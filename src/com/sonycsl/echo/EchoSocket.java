/*
 * Copyright 2012 Sony Computer Science Laboratories, Inc. <info@kadecot.net>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sonycsl.echo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.node.EchoNode;



public final class EchoSocket {
	@SuppressWarnings("unused")
	private static final String TAG = EchoSocket.class.getSimpleName();

	public static int UDP_MAX_PACKET_SIZE = 65507;
	public static int TCP_MAX_PACKET_SIZE = 65507;

	public static final String SELF_ADDRESS = "127.0.0.1";
	public static final String MULTICAST_ADDRESS = "224.0.23.0";
	private static final int PORT = 3610;

	private static final Queue<EchoFrame> mSelfFrameQueue = new LinkedList<EchoFrame>();
	private static MulticastSocket sMulticastSocket;
	private static InetAddress sMulticastAddress;
	private static ExecutorService sExecutors;

	// for TCP.
	private static ServerSocket sServerSocket;
	private static ExecutorService sConnectedTCPSocketThreads;
	//  may be connected from same source many times.
	private static HashMap<String, ArrayList<Socket>> sTCPSockets;


	private static short sNextTID = 0;

	private EchoSocket() {
	}
	private static class Receiver implements Runnable {
		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()) {
				try {
					receiveUDP();
					receiveTCP();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				receiveFrameFromSelfNode();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void openSocket() throws IOException {

		sMulticastAddress = InetAddress.getByName(MULTICAST_ADDRESS);
		sMulticastSocket = new MulticastSocket(PORT);

		sExecutors = Executors.newSingleThreadExecutor();
		//int ttl = 1;
		//sMulticastSocket.setLoopbackMode(true);
		//sMulticastSocket.setTimeToLive(ttl);
		sMulticastSocket.setNetworkInterface(EchoUtils.getNetworkInterface());
		//sMulticastSocket.setInterface(EchoUtils.getLocalIpAddress());
		sMulticastSocket.joinGroup(sMulticastAddress);
		sMulticastSocket.setLoopbackMode(true);
		sMulticastSocket.setSoTimeout(10);


		sTCPSockets = new HashMap<String, ArrayList<Socket>>();

		sServerSocket = new ServerSocket();
		sServerSocket.setSoTimeout(10);
		sServerSocket.setReuseAddress(true);
		sServerSocket.bind(new InetSocketAddress(PORT));
		sConnectedTCPSocketThreads = Executors.newCachedThreadPool();

	}

	public static void closeSocket() throws IOException {
		if(sMulticastSocket != null){
			MulticastSocket s = sMulticastSocket;
			sMulticastSocket = null;
			s.leaveGroup(sMulticastAddress);
			s.close();
		}
		if(sServerSocket != null){
			ServerSocket s = sServerSocket;
			sServerSocket = null;
			s.close();
		}
		if(sConnectedTCPSocketThreads != null){
			sConnectedTCPSocketThreads.shutdownNow();
			sConnectedTCPSocketThreads = null;
		}
	}

	private static void sendFrameToSelfNode(EchoFrame frame) {
		mSelfFrameQueue.offer(frame);
	}
	private static void receiveFrameFromSelfNode() {
		EchoFrame frame = mSelfFrameQueue.poll();
		if(frame != null) {
			onReceiveUDPFrame(frame);
		}
	}

	private static void onReceiveUDPFrame(EchoFrame frame) {
		checkNewObjectInResponse(frame.copy());
		Echo.getEventListener().receiveEvent(frame);

		switch(frame.getESV()) {
		case EchoFrame.ESV_SETI_SNA:
		case EchoFrame.ESV_SET_RES: case EchoFrame.ESV_SETC_SNA:
		case EchoFrame.ESV_GET_RES: case EchoFrame.ESV_GET_SNA:
		case EchoFrame.ESV_INF: case EchoFrame.ESV_INF_SNA:
		case EchoFrame.ESV_INFC_RES:
			// not request
			onReceiveNotRequest(frame);
			break;
		case EchoFrame.ESV_INFC:
			onReceiveNotRequest(frame);
		case EchoFrame.ESV_SETI: case EchoFrame.ESV_SETC:
		case EchoFrame.ESV_GET:
		case EchoFrame.ESV_INF_REQ:
		case EchoFrame.ESV_SET_GET:
			// request
			EchoNode selfNode = Echo.getSelfNode();
			if(selfNode == null) {
				return;
			}
			if(frame.getDstEchoInstanceCode() == 0) {
				if(frame.getDstEchoClassCode() == NodeProfile.ECHO_CLASS_CODE) {
					EchoObject deoj = selfNode.getNodeProfile();
					onReceiveUDPRequestFrame(deoj, frame);
				} else {
					DeviceObject[] deojList = selfNode.getDevices(frame.getDstEchoClassCode());
					for(DeviceObject deoj : deojList) {
						onReceiveUDPRequestFrame(deoj, frame);
					}
				}
			} else {
				EchoObject deoj = selfNode.getInstance(frame.getDstEchoClassCode(), frame.getDstEchoInstanceCode());
				if(deoj == null) {return;}
				onReceiveUDPRequestFrame(deoj, frame);
			}
			break;
		}
	}

	private static void onReceiveUDPRequestFrame(EchoObject deoj, EchoFrame frame){
		EchoFrame request = frame.copy();
		request.setDstEchoInstanceCode(deoj.getInstanceCode());
		EchoFrame response = deoj.onReceiveRequest(request);

		if(response.getESV() == EchoFrame.ESV_INF) {
			response.setDstEchoAddress(MULTICAST_ADDRESS);
		}
		if(response.getESV() == EchoFrame.ESV_SET_NO_RES) {
			return;
		}
		System.err.println(response);
		try {
			sendUDPFrame(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void onReceiveNotRequest(EchoFrame frame) {
		// check new node or instance
		//checkNewObjectInResponse(frame.copy());
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


	private static void onReceiveTCPFrame(EchoFrame frame, Socket socket) {
		Echo.getEventListener().receiveEvent(frame);
		switch(frame.getESV()) {
		case EchoFrame.ESV_SETI_SNA:
		case EchoFrame.ESV_SET_RES: case EchoFrame.ESV_SETC_SNA:
		case EchoFrame.ESV_GET_RES: case EchoFrame.ESV_GET_SNA:
		case EchoFrame.ESV_INF: case EchoFrame.ESV_INF_SNA:
		case EchoFrame.ESV_INFC_RES:
			// not request
			onReceiveNotRequest(frame);
			break;
		case EchoFrame.ESV_INFC:
			onReceiveNotRequest(frame);
		case EchoFrame.ESV_SETI: case EchoFrame.ESV_SETC:
		case EchoFrame.ESV_GET:
		case EchoFrame.ESV_INF_REQ:
		case EchoFrame.ESV_SET_GET:
			// request
			EchoNode selfNode = Echo.getSelfNode();
			if(selfNode == null) {
				return;
			}
			if(frame.getDstEchoInstanceCode() == 0) {
				if(frame.getDstEchoClassCode() == NodeProfile.ECHO_CLASS_CODE) {
					EchoObject deoj = selfNode.getNodeProfile();
					onReceiveTCPRequestFrame(deoj, frame, socket);
				} else {
					DeviceObject[] deojList = selfNode.getDevices(frame.getDstEchoClassCode());
					for(DeviceObject deoj : deojList) {
						onReceiveTCPRequestFrame(deoj, frame, socket);
					}
				}
			} else {
				EchoObject deoj = selfNode.getInstance(frame.getDstEchoClassCode(), frame.getDstEchoInstanceCode());
				if(deoj == null) {return;}
				onReceiveTCPRequestFrame(deoj, frame, socket);
			}
			break;
		}
	}

	private static void onReceiveTCPRequestFrame(EchoObject deoj, EchoFrame frame, Socket socket){
		checkNewObjectInResponse(frame.copy());
		EchoFrame request = frame.copy();
		request.setDstEchoInstanceCode(deoj.getInstanceCode());
		EchoFrame response = deoj.onReceiveRequest(request);

		if(response.getESV() == EchoFrame.ESV_INF) {
			response.setDstEchoAddress(MULTICAST_ADDRESS);
		}
		if(response.getESV() == EchoFrame.ESV_SET_NO_RES) {
			return;
		}
		System.err.println(response);
		try {
			sendTCPFrame(response, socket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void checkNewObjectInResponse(EchoFrame frame) {
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
				Echo.getEventListener().onNewNode(node);
			}
			Echo.getEventListener().onFoundNode(node);
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
				Echo.getEventListener().onNewNode(node);
			}
			Echo.getEventListener().onFoundNode(node);
			if(flagNewDevice) {
				Echo.getEventListener().onNewEchoObject(seoj);
			}
			Echo.getEventListener().onFoundEchoObject(seoj);
			int foundDeviceListSize = foundDevices.size();
			for(int i = 0; i < foundDeviceListSize; i++) {
				if(flagNewDevices.get(i)) {
					Echo.getEventListener().onNewEchoObject(foundDevices.get(i));
				}
				Echo.getEventListener().onFoundEchoObject(foundDevices.get(i));
			}
		} else {
			// seoj is DeviceObject
			if(flagNewNode) {
				Echo.getEventListener().onNewNode(node);
			}
			Echo.getEventListener().onFoundNode(node);
			if(flagNewDevice) {
				Echo.getEventListener().onNewEchoObject(seoj);
			}
			Echo.getEventListener().onFoundEchoObject(seoj);
			return;
		}
	}

	public static void sendUDPFrame(EchoFrame frame) throws IOException {
		Echo.getEventListener().sendEvent(frame);

		if(frame.getDstEchoAddress().equals(SELF_ADDRESS)) {
			sendFrameToSelfNode(frame.copy());
			return;
		}
		byte[] data = frame.getFrameByteArray();

		InetAddress address = InetAddress.getByName(frame.getDstEchoAddress());
		DatagramPacket packet = new DatagramPacket(data, data.length,
				address, PORT);
		sMulticastSocket.send(packet);
		if(frame.getDstEchoAddress().equals(MULTICAST_ADDRESS)) {
			EchoFrame f = frame.copy();
			f.setDstEchoAddress(SELF_ADDRESS);
			sendFrameToSelfNode(f);
		}
	}

	public static void sendTCPFrame(EchoFrame frame) throws IOException {
		Echo.getEventListener().sendEvent(frame);
		// will not occur?
		if(frame.getDstEchoAddress().equals(SELF_ADDRESS)){
			sendFrameToSelfNode(frame.copy());
			return;
		}
		InetAddress address = InetAddress.getByName(frame.getDstEchoAddress());

		if(sTCPSockets.containsKey(frame.getDstEchoAddress())) {
			ArrayList<Socket> list = sTCPSockets.get(frame.getDstEchoAddress());
			// 既存のsocketを新しいものから試す．
			for(int i = list.size() - 1; i >= 0; --i) {
				Socket sock = list.get(i);
				try {
					System.err.println("Reuse " + sock.getInetAddress() + " [" + i + "]");
					sendTCPFrame(frame, sock);
					return;
				} catch(IOException e) {
					closeTCPSocket(sock);
					continue;
				}
			}
		}

		// 既存のsocketが使えない場合
		Socket sock = new Socket(address,PORT);
		System.err.println("Socket add" + sock.getInetAddress());

		sendTCPFrame(frame, sock);
		if(sTCPSockets.containsKey(address.getHostAddress())) {
			sTCPSockets.get(address.getHostAddress()).add(sock);
		} else {
			ArrayList<Socket> list = new ArrayList<Socket>();
			list.add(sock);
			sTCPSockets.put(address.getHostAddress(), list);
		}
		// at first,read. 要求電文に対する応答電文は同一のコネクションで送信するものとする。
		sConnectedTCPSocketThreads.execute(new TCPSocketThread(sock));
	}

	public static void sendTCPFrame(EchoFrame frame, Socket socket) throws IOException {
		byte[] data = frame.getFrameByteArray();
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.write(data);
	}

	public static void receiveUDP() throws IOException {
		DatagramPacket packet =
				new DatagramPacket(
						new byte[EchoSocket.UDP_MAX_PACKET_SIZE],
						EchoSocket.UDP_MAX_PACKET_SIZE);
		// closed?
		if(sMulticastSocket == null){
			//System.err.println("sMulticastSocket has been closed.");
			return;
		}
		sMulticastSocket.receive(packet);
		Enumeration<InetAddress> enumIpAddr = sMulticastSocket.getNetworkInterface().getInetAddresses();
		while(enumIpAddr.hasMoreElements()) {
			InetAddress inetAddress = enumIpAddr.nextElement();
			if (inetAddress.equals(packet.getAddress())) {
				return;
			}
		}
		byte[] data = new byte[packet.getLength()];
		System.arraycopy(packet.getData(), 0, data, 0, packet.getLength());

		if(data.length < EchoFrame.MIN_FRAME_SIZE) {
			return;
		}
		InetAddress address = packet.getAddress();
		String srcEchoAddress = address.getHostAddress();
		EchoFrame frame = new EchoFrame(srcEchoAddress, data);
		onReceiveUDPFrame(frame);
	}

	public static void receiveTCP() throws IOException {
		// has been closed?
		if(sServerSocket == null){
			//System.err.println("TCP server socket has been closed.");
			return;
		}
		Socket sock = sServerSocket.accept();
		String address = sock.getInetAddress().getHostAddress();
		if(sTCPSockets.containsKey(address)) {
			sTCPSockets.get(address).add(sock);
		} else {
			ArrayList<Socket> list = new ArrayList<Socket>();
			list.add(sock);
			sTCPSockets.put(address, list);
		}
		System.err.println("Socket add" + sock.getInetAddress() + "(income)");

		sConnectedTCPSocketThreads.execute(new TCPSocketThread(sock));
	}

	public static void startReceiverThread() {
		sExecutors.execute(new Receiver());
	}

	public static void stopReceiverThread() {
		sExecutors.shutdown();
		sExecutors.shutdownNow();
	}

	public static void resumeReceiverThread() {

	}

	public static void pauseReceiverThread() {

	}
	public static synchronized short nextTID() {
		short ret = sNextTID;
		sNextTID += 1;
		//Echo::getStorage().get()->setNextTID(sNextTID);
		return ret;
	}

	public static short getNextTIDNoIncrement() {
		return sNextTID;
	}

	public static void closeTCPSocket(Socket socket) {
		System.err.println("Socket close" + socket.getInetAddress());
		ArrayList<Socket> list = sTCPSockets.get(socket.getInetAddress().getHostAddress());
		list.remove(socket);
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static class TCPSocketThread implements Runnable {
		private Socket sock;
		public TCPSocketThread(Socket s) {
			sock = s;
		}
		// first state is recv.
		@Override
		public void run() {
			// Thread.interrupt is called by executor.
			try {
				//DataOutputStream out = new DataOutputStream(sock.getOutputStream());
				DataInputStream in = new DataInputStream(sock.getInputStream());
				while (!Thread.interrupted() && sock.isConnected()) {
					String address = sock.getInetAddress().getHostAddress();
					try {
						EchoFrame frame = EchoFrame.getEchoFrameFromStream(address, in);
						if(frame != null) {
							System.out.println("TCP: " + frame);
							onReceiveTCPFrame(frame, sock);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				closeTCPSocket(sock);
			}
		}
	}
}
