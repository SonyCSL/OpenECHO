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
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.node.EchoNode;
import com.sonycsl.echo.protocol.EchoProtocol;
import com.sonycsl.echo.protocol.EchoTCPProtocol;
import com.sonycsl.echo.protocol.EchoUDPProtocol;
import com.sonycsl.echo.protocol.EchoProtocol.Task;



public final class EchoSocket {
	@SuppressWarnings("unused")
	private static final String TAG = EchoSocket.class.getSimpleName();

	public static final String SELF_ADDRESS = "127.0.0.1";
	public static final String MULTICAST_ADDRESS = "224.0.23.0";

	
	protected static Queue<EchoProtocol.Task> sTaskQueue = new ConcurrentLinkedQueue<EchoProtocol.Task>();

	public static synchronized void enqueueTask(Task task) {
		sTaskQueue.offer(task);
	}
	
	public static synchronized Task dequeueTask() {
		return sTaskQueue.poll();
	}

	private static EchoUDPProtocol sUDPProtocol = new EchoUDPProtocol();
	private static EchoTCPProtocol sTCPProtocol = new EchoTCPProtocol();

	private static Thread sRecvThread;
	private static Thread sTaskPerformerThread;
	private static short sNextTID = 0;

	private EchoSocket() {
	}
	private static class Receiver implements Runnable {
		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()) {
				receive();
				//try {
				//	Thread.sleep(10);
				//} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//	break;
				//}
			}
		}
	}
	
	private static class TaskPerformer implements Runnable {

		@Override
		public void run() {
			while(!Thread.currentThread().isInterrupted()) {
				performTasks();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			}
			
		}
		
	}

	public static void openSocket() throws IOException {

		sUDPProtocol.openUDP();
		sTCPProtocol.openTCP();

	}

	public static void closeSocket() throws IOException {
		sTCPProtocol.closeTCP();
		sUDPProtocol.closeUDP();
	}

	public static void startReceiverThread() {
		//stopReceiverThread();
		//sExecutors.execute(new Receiver());
		if(sRecvThread == null){
			sRecvThread = new Thread(new Receiver());
			sRecvThread.start();
		}else{
			//System.err.println("There is already receiver thread.");
		}
		if(sTaskPerformerThread == null) {
			sTaskPerformerThread = new Thread(new TaskPerformer());
			sTaskPerformerThread.start();
		}
	}

	public static void stopReceiverThread() {
		//sExecutors.shutdown();
		//sExecutors.shutdownNow();
		if(sRecvThread != null){
			sRecvThread.interrupt();
			sRecvThread = null;
		}
		if(sTaskPerformerThread != null){
			sTaskPerformerThread.interrupt();
			sTaskPerformerThread = null;
		}
		
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
	
	public static void sendUDPFrame(EchoFrame frame) throws IOException {
		sUDPProtocol.sendUDP(frame);
	}
	
	public static void sendTCPFrame(EchoFrame frame) throws IOException {
		sTCPProtocol.sendTCP(frame);
	}
	
	public static void receive() {
		Thread udp = new Thread(new Runnable(){
			@Override
			public void run() {
				sUDPProtocol.receive();
			}
		});
		udp.start();

		Thread tcp = new Thread(new Runnable(){
			@Override
			public void run() {
				sTCPProtocol.receive();
			}
		});
		tcp.start();
		
		try {
			udp.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			tcp.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void performTasks() {
		EchoProtocol.Task task = null;
		while((task = dequeueTask()) != null) {
			task.perform();
		}
	}

}
