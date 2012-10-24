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
import java.util.List;

import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;



public final class EchoSocket {
	@SuppressWarnings("unused")
	private static final String TAG = EchoSocket.class.getSimpleName();

	public static int UDP_MAX_PACKET_SIZE = 65507;

	private static final String ADDRESS = "224.0.23.0";
	private static final int PORT = 3610;
	private static MulticastSocket mSocket;
	private static InetAddress mMulticastAddress;
	private static Receiver mReceiver;
	
	private EchoSocket() {
	}
	
	public static InetAddress getLocalAddress() {
		return mSocket.getLocalAddress();
	}
	
	public static void start() throws IOException {
		mMulticastAddress = InetAddress.getByName(ADDRESS);
		if(mSocket != null) {
			stop();
		}
		mSocket = new MulticastSocket(PORT);

		mReceiver = new Receiver(mSocket);
		mReceiver.start();
		
		mSocket.joinGroup(mMulticastAddress);
	}
	
	public static void stop() throws IOException {
		mReceiver.close();
		mSocket.leaveGroup(mMulticastAddress);
		mSocket.close();
		mSocket = null;
	}
	
	public static void send(InetAddress address, byte[] data) throws IOException {
		if(mSocket == null) {
			return;
		}
		
		DatagramPacket packet = new DatagramPacket(data, data.length,
				address, PORT);
		mSocket.send(packet);
	}
	
	public static void sendGroup(byte[] data) throws IOException {
		if(mSocket == null) {
			return;
		}
		
		DatagramPacket packet = new DatagramPacket(data, data.length, 
				mMulticastAddress, PORT);
		mSocket.send(packet);
		
	}
	

	
	private static class Receiver extends Thread {
		
		MulticastSocket mReceiverSocket;
		boolean mRunning = true;
		
		public Receiver(MulticastSocket socket) {
			mReceiverSocket = socket;
		}

		@Override
		public void run() {
			while(mRunning) {
				DatagramPacket packet = 
						new DatagramPacket(
								new byte[EchoSocket.UDP_MAX_PACKET_SIZE], 
								EchoSocket.UDP_MAX_PACKET_SIZE);
				try {
					mReceiverSocket.receive(packet);
				} catch (IOException e) {
					//e.printStackTrace();
					mRunning = false;
					break;
				}
				byte[] data = new byte[packet.getLength()];
				System.arraycopy(packet.getData(), 0, data, 0, packet.getLength());
				
				if(data.length < 12) continue;
				List<EchoFrame> frameList = new ArrayList<EchoFrame>();
				if(data[9] == 0) {
					DeviceObject[] devices = Echo.getNode().getDevices(data[7], data[8]);
					for(DeviceObject dev : devices) {
						byte[] d = data.clone();
						d[9] = dev.getInstanceCode();
						frameList.add(new EchoFrame(packet.getAddress(), d));
					}
				} else {
					frameList.add(new EchoFrame(packet.getAddress(), data));
				}
				
				for(EchoFrame frame : frameList) {

					if(Echo.getMethodInvokedListener() != null) {
						Echo.getMethodInvokedListener().onInvokedReceiveMethod(frame);
					}
					
					if(frame.getDeoj() != null) {
						switch(frame.getEsv()) {
						case EchoObject.ESV_SETI_SNA:
						case EchoObject.ESV_SET_RES: case EchoObject.ESV_SETC_SNA:
						case EchoObject.ESV_GET_RES: case EchoObject.ESV_GET_SNA: 
						case EchoObject.ESV_INF: case EchoObject.ESV_INF_SNA: 
						case EchoObject.ESV_INFC:
							frame.getSeoj().onReceive(frame);
							break;
						case EchoObject.ESV_SETI: case EchoObject.ESV_SETC:
						case EchoObject.ESV_GET:
						case EchoObject.ESV_INF_REQ:
						case EchoObject.ESV_INFC_RES:
							frame.getDeoj().onReceive(frame);
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
}
