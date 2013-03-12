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

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;



public final class EchoSocket {
	@SuppressWarnings("unused")
	private static final String TAG = EchoSocket.class.getSimpleName();

	public static int UDP_MAX_PACKET_SIZE = 65507;

	private static final String ADDRESS = "224.0.23.0";
	private static final int PORT = 3610;
	private static MulticastSocket sSocket;
	private static InetAddress sMulticastAddress;
	private static ReceiverThread sReceiver;
	
	//private static HashMap<Short, ResponseListener> sListeners;
	

	private static short sTID = 0;
	
	private EchoSocket() {
	}
	
	//public static InetAddress getLocalAddress() {
	//	return mSocket.getLocalAddress();
	//}
	
	protected static void start() throws IOException {

		if(sSocket != null) {
			close();
		}
		//sListeners = new HashMap<Short, ResponseListener>();
		
		sMulticastAddress = InetAddress.getByName(ADDRESS);
		sSocket = new MulticastSocket(PORT);

		sReceiver = new ReceiverThread(sSocket);
		sReceiver.start();
		
		sSocket.joinGroup(sMulticastAddress);
	}
	
	protected static void close() throws IOException {
		sReceiver.close();
		sSocket.leaveGroup(sMulticastAddress);
		sSocket.close();
		sSocket = null;
		//if(sListeners != null) {
		//	sListeners.clear();
		//	sListeners = null;
		//}
	}
	
	protected static boolean isClosed() {
		if(sSocket == null) return false;
		return sSocket.isClosed();
	}
	
	public static void send(InetAddress address, byte[] data) throws IOException {
		if(sSocket == null) {
			return;
		}
		if(data == null) {
			return;
		}
		DatagramPacket packet = new DatagramPacket(data, data.length,
				address, PORT);
		sSocket.send(packet);
	}
	
	public static void sendGroup(byte[] data) throws IOException {
		if(sSocket == null) {
			return;
		}
		if(data == null) {
			return;
		}
		DatagramPacket packet = new DatagramPacket(data, data.length, 
				sMulticastAddress, PORT);
		sSocket.send(packet);
		
	}
	
	public static short getLastTID() {
		return sTID;
	}
	
	public static short getNextTID() {
		short tid = sTID;
		sTID++;
		return tid;
	}
	
	
	private static class ReceiverThread extends Thread {
		
		MulticastSocket mSocket;
		boolean mRunning = true;
		
		public ReceiverThread(MulticastSocket socket) {
			mSocket = socket;
		}

		@Override
		public void run() {
			while(mRunning) {
				DatagramPacket packet = 
						new DatagramPacket(
								new byte[EchoSocket.UDP_MAX_PACKET_SIZE], 
								EchoSocket.UDP_MAX_PACKET_SIZE);
				try {
					mSocket.receive(packet);
				} catch (IOException e) {
					//e.printStackTrace();
					mRunning = false;
					break;
				}
				byte[] data = new byte[packet.getLength()];
				System.arraycopy(packet.getData(), 0, data, 0, packet.getLength());
				
				if(data.length < 12) continue;
				List<EchoFrame> frameList = new ArrayList<EchoFrame>();
				
				Echo.EventListener listener = Echo.getEventListener();
				try {
					if(listener != null) Echo.getEventListener().receiveEvent(new EchoFrame(packet.getAddress(), data));
				} catch(Exception e) {
					try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
				}
				
				if(data[9] == 0) {
					DeviceObject[] devices = Echo.getNode().getDevices(data[7], data[8]);
					if(devices != null) {
						for(DeviceObject dev : devices) {
							byte[] d = data.clone();
							d[9] = dev.getInstanceCode();
							frameList.add(new EchoFrame(packet.getAddress(), d));
						}
					}
				} else {
					frameList.add(new EchoFrame(packet.getAddress(), data));
				}
				
				for(EchoFrame frame : frameList) {
					
					if(frame.getDeoj() != null) {
						switch(frame.getEsv()) {
						case EchoFrame.ESV_SETI_SNA:
						case EchoFrame.ESV_SET_RES: case EchoFrame.ESV_SETC_SNA:
						case EchoFrame.ESV_GET_RES: case EchoFrame.ESV_GET_SNA: 
						case EchoFrame.ESV_INF: case EchoFrame.ESV_INF_SNA: 
						case EchoFrame.ESV_INFC:
							frame.getSeoj().receive(frame);
							break;
						case EchoFrame.ESV_SETI: case EchoFrame.ESV_SETC:
						case EchoFrame.ESV_GET:
						case EchoFrame.ESV_INF_REQ:
						case EchoFrame.ESV_INFC_RES:
							frame.getDeoj().receive(frame);
							break;
						}
					}
				}
			}
		}
		
		public void close() {
			mRunning = false;
		}
		
	}
	
	/*
	public interface ResponseListener {
		public static final int REASON_LIMIT = 0;
		public static final int REASON_TIMEOUT = 1;
		
		
		public void preReceive(EchoObject eoj, EchoFrame frame);
		public void postReceive(EchoObject eoj, EchoFrame frame);
		
		public void complete(EchoObject[] eojs, int reason);
	}
	
	public class ReceiverListenerInfo {
		long timeout;
		int limit;
		ResponseListener listener;
	}
	
	private static class ListenerThread extends Thread {

		boolean mRunning = true;
		
		@Override
		public void run() {
			while(mRunning) {
				if(sListeners == null) {
					mRunning = false;
					break;
				}
			}
		}
		
		public void close() {
			mRunning = false;
		}
		
	}
	*/
}
