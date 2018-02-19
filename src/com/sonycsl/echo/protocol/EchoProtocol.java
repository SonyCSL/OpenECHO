package com.sonycsl.echo.protocol;

import java.util.ArrayList;
import java.util.List;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.node.EchoNode;

/**
 * 受信したFrameは一度キューに保存し，EchoSocketのreceive関数で処理を行う．
 * 
 *
 */
public abstract class EchoProtocol {
	//protected Queue<EchoFrame> mSelfFrameQueue = new LinkedList<EchoFrame>();

	
	
/*
	protected void sendFrameToSelfNode(EchoFrame frame) {
		mSelfFrameQueue.offer(frame);
	}
	public void receiveFrameFromSelfNode() {
		EchoFrame frame = mSelfFrameQueue.poll();
		if(frame != null) {
			onReceiveFrameFromSelfNode(frame);
		}
	}
	protected void onReceiveFrameFromSelfNode(EchoFrame frame) {

		if(frame.isValid()){
			checkObjectInFrame(frame.copy());

			//onReceiveUDPFrame(frame);
			if(isReportFrame(frame)) {
				onReceiveReport(frame);
			}
			if(isRequestFrame(frame)) {
				List<EchoFrame> responses = onReceiveRequest(frame);
				
				for(EchoFrame res : responses) {

					if(res.getESV() == EchoFrame.ESV_INF) {
						res.setDstEchoAddress(EchoSocket.MULTICAST_ADDRESS);
					}
					if(res.getESV() == EchoFrame.ESV_SET_NO_RES) {
						return;
					}
					send(res);
				}
			}
			
		}
	}*/
	
	//public abstract void sendToSelf(EchoFrame frame);
	//public abstract void sendToOther(EchoFrame frame);
	//public abstract void sendToGroup(EchoFrame frame);
	public abstract void receive();

	public static abstract class Task {
		protected EchoFrame mFrame;
		public Task(EchoFrame frame) {
			mFrame = frame;
		}
		public void perform() {
			if(mFrame.isValid()){
				checkObjectInFrame(mFrame.copy());
				Echo.getEventListener().receiveEvent(mFrame);

				if(isReportFrame(mFrame)) {
					onReceiveReport(mFrame);
				}
				if(isRequestFrame(mFrame)) {
					List<EchoFrame> responses = onReceiveRequest(mFrame);
					
					for(EchoFrame res : responses) {

						if(res.getESV() == EchoFrame.ESV_SET_NO_RES) {
							return;
						}
						if(res.getESV() == EchoFrame.ESV_INF) {
							res.setDstEchoAddress(EchoSocket.MULTICAST_ADDRESS);
							informAll(res);
						} else {
							respond(res);
						}
					}
				}
				
			}
		}
		protected abstract void respond(EchoFrame response);
		protected abstract void informAll(EchoFrame response);

		protected static boolean isRequestFrame(EchoFrame frame) {

			switch(frame.getESV()) {
			case EchoFrame.ESV_SETI: case EchoFrame.ESV_SETC:
			case EchoFrame.ESV_GET:
			case EchoFrame.ESV_INF_REQ:
			case EchoFrame.ESV_SET_GET:
			case EchoFrame.ESV_INFC:
				return true;
			default:
				return false;
			}
		}
		
		protected static boolean isReportFrame(EchoFrame frame) {
			switch(frame.getESV()) {
			case EchoFrame.ESV_SETI_SNA:
			case EchoFrame.ESV_SET_RES: case EchoFrame.ESV_SETC_SNA:
			case EchoFrame.ESV_GET_RES: case EchoFrame.ESV_GET_SNA:
			case EchoFrame.ESV_INF: case EchoFrame.ESV_INF_SNA:
			case EchoFrame.ESV_INFC_RES:
			case EchoFrame.ESV_INFC:
				return true;
			default:
				return false;
			}
		}
		
		
		protected static List<EchoFrame> onReceiveRequest(EchoFrame frame) {

			ArrayList<EchoFrame> responses = new ArrayList<EchoFrame>();
			EchoNode selfNode = Echo.getSelfNode();
			if(selfNode == null) {
				return responses;
			}
			if(frame.getDstEchoInstanceCode() == 0) {
				if(frame.getDstEchoClassCode() == NodeProfile.ECHO_CLASS_CODE) {
					EchoObject deoj = selfNode.getNodeProfile();
					EchoFrame res = onReceiveRequest(deoj, frame);
					if(res != null) {responses.add(res);}
				} else {
					DeviceObject[] deojList = selfNode.getDevices(frame.getDstEchoClassCode());
					for(DeviceObject deoj : deojList) {
						EchoFrame res = onReceiveRequest(deoj, frame);
						if(res != null) {responses.add(res);}
					}
				}
			} else {
				EchoObject deoj = selfNode.getInstance(frame.getDstEchoClassCode(), frame.getDstEchoInstanceCode());
				if(deoj == null) {return responses;}
				EchoFrame res = onReceiveRequest(deoj, frame);
				if(res != null) {responses.add(res);}
			}
			return responses;
		}
		
		protected static EchoFrame onReceiveRequest(EchoObject deoj, EchoFrame frame) {

			EchoFrame request = frame.copy();
			request.setDstEchoInstanceCode(deoj.getInstanceCode());
			EchoFrame response = deoj.onReceiveRequest(request);
			
			return response;
		}

		protected static void onReceiveReport(EchoFrame frame) {
			EchoNode node = Echo.getNode(frame.getSrcEchoAddress());
			EchoObject seoj = node.getInstance(frame.getSrcEchoClassCode(),
												frame.getSrcEchoInstanceCode());

			if(seoj == null) {return;}
			seoj.setNode(node);

			// receiver
			EchoObject.Receiver receiver = seoj.getReceiver();
			if(receiver != null) {
				receiver.onReceive(seoj, frame);
			}
		}

		
		protected static void checkObjectInFrame(EchoFrame frame) {
			if(EchoSocket.SELF_ADDRESS.equals(frame.getSrcEchoAddress())) {
				// self node
				return;
			}
			
			// other node
			EchoNode node = Echo.getNode(frame.getSrcEchoAddress());
			boolean flagNewNode = false;
			if(node == null) {
				node = Echo.addOtherNode(frame.getSrcEchoAddress());
				flagNewNode = true;
				if(node == null) {return;}

				node.getNodeProfile().setNode(node);
			}

			if(frame.getSrcEchoClassCode() == NodeProfile.ECHO_CLASS_CODE
					&& frame.getSrcEchoInstanceCode() == NodeProfile.INSTANCE_CODE_TRANSMISSION_ONLY) {
				//node.get()->getNodeProfile().get()->setInstanceCode(NodeProfile::INSTANCE_CODE_TRANSMISSION_ONLY);
				NodeProfile profile = node.getNodeProfile();
				NodeProfile.Proxy proxy = (NodeProfile.Proxy)profile;
				proxy.setInstanceCode(NodeProfile.INSTANCE_CODE_TRANSMISSION_ONLY);
			}

			boolean flagNewDevice = false;
			EchoObject seoj = node.getInstance(frame.getSrcEchoClassCode(), frame.getSrcEchoInstanceCode());
			if(seoj == null) {
				// generate
				// device

				seoj = node.addOtherDevice(frame.getSrcEchoClassCode(), frame.getSrcEchoInstanceCode());
				flagNewDevice = true;

				if(seoj != null) {seoj.setNode(node);}

				//seoj = node.get()->getInstnace(frame.getSrcEchoClassCode(), frame.getSrcEchoInstanceCode());
			}
			if(seoj == null) {
				if(flagNewNode) {
					//Echo.getEventListener().onNewNode(node);
					node.onNew();
				}
				//Echo.getEventListener().onFoundNode(node);
				node.onFound();
				return;
			}
			if(seoj.getEchoClassCode() == NodeProfile.ECHO_CLASS_CODE
					&& (seoj.getInstanceCode() == NodeProfile.INSTANCE_CODE
						|| seoj.getInstanceCode() == NodeProfile.INSTANCE_CODE_TRANSMISSION_ONLY)
					&& (frame.getESV() == EchoFrame.ESV_GET_RES
						|| frame.getESV() == EchoFrame.ESV_GET_SNA
						|| frame.getESV() == EchoFrame.ESV_INF
						|| frame.getESV() == EchoFrame.ESV_INF_SNA
						|| frame.getESV() == EchoFrame.ESV_INFC)) {
				// seoj is NodeProfile
				List<EchoObject> foundDevices = new ArrayList<EchoObject>();
				List<Boolean> flagNewDevices = new ArrayList<Boolean>();

				for(EchoProperty p : frame.getPropertyList()) {
					if(p.epc != NodeProfile.EPC_INSTANCE_LIST_NOTIFICATION
						&& p.epc != NodeProfile.EPC_SELF_NODE_INSTANCE_LIST_S) {continue;}
					if(p.pdc == 0) {continue;}
					int deviceListSize = (int)p.edt[0];
					if(deviceListSize > 84) {
						deviceListSize = 84;
					}
					for(int d = 0, i = 1; d < deviceListSize; d++) {
						if(i == p.pdc) break;
						short echoClassCode = (short)(((p.edt[i]) & 0xFF) << 8);
						i += 1;
						if(i == p.pdc) break;
						echoClassCode += p.edt[i] & 0xFF;
						i += 1;
						if(i == p.pdc) break;
						byte echoInstanceCode = p.edt[i];
						i += 1;
						if(node.containsDevice(echoClassCode, echoInstanceCode)) {
							flagNewDevices.add(false);
							foundDevices.add(node.getInstance(echoClassCode, echoInstanceCode));
						} else {
							// new
							flagNewDevices.add(true);
							EchoObject eoj = node.addOtherDevice(echoClassCode, echoInstanceCode);
							foundDevices.add(eoj);
							if(eoj != null) {eoj.setNode(node);}
						}
					}
				}

				if(flagNewNode) {
					//Echo.getEventListener().onNewNode(node);
					node.onNew();
				}
				//Echo.getEventListener().onFoundNode(node);
				node.onFound();
				if(flagNewDevice) {
					//Echo.getEventListener().onNewEchoObject(seoj);
					seoj.onNew();
				}
				//Echo.getEventListener().onFoundEchoObject(seoj);
				seoj.onFound();
				int foundDeviceListSize = foundDevices.size();
				for(int i = 0; i < foundDeviceListSize; i++) {
					if(flagNewDevices.get(i)) {
						//Echo.getEventListener().onNewEchoObject(foundDevices.get(i));
						foundDevices.get(i).onNew();
					}
					//Echo.getEventListener().onFoundEchoObject(foundDevices.get(i));
					foundDevices.get(i).onFound();
				}
			} else {
				// seoj is DeviceObject
				if(flagNewNode) {
					//Echo.getEventListener().onNewNode(node);
					node.onNew();
				}
				//Echo.getEventListener().onFoundNode(node);
				node.onFound();
				if(flagNewDevice) {
					//Echo.getEventListener().onNewEchoObject(seoj);
					seoj.onNew();
				}
				//Echo.getEventListener().onFoundEchoObject(seoj);
				seoj.onFound();
				return;
			}
		}
	}

}
