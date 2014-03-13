package com.sonycsl.echo.protocol;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.EchoUtils;

public class EchoUDPProtocol extends EchoProtocol {
	public static int UDP_MAX_PACKET_SIZE = 65507;

	private static final int PORT = 3610;

	private MulticastSocket mMulticastSocket;
	private InetAddress mMulticastAddress;
	
	public EchoUDPProtocol() {
		
	}
	

	
	public void openUDP() throws IOException {

		mMulticastAddress = InetAddress.getByName(EchoSocket.MULTICAST_ADDRESS);
		mMulticastSocket = new MulticastSocket(PORT);
		mMulticastSocket.setNetworkInterface(EchoUtils.getNetworkInterface());
		mMulticastSocket.joinGroup(mMulticastAddress);
		mMulticastSocket.setLoopbackMode(true);
		mMulticastSocket.setSoTimeout(10);
	}

	public void closeUDP() {

		if(mMulticastSocket != null){
			MulticastSocket s = mMulticastSocket;
			mMulticastSocket = null;
			try {
				s.leaveGroup(mMulticastAddress);
			} catch (IOException e) {
				e.printStackTrace();
			}
			s.close();
		}
		
	}
	

	public void sendUDP(EchoFrame frame) throws IOException {

		Echo.getEventListener().sendEvent(frame);

		if(frame.getDstEchoAddress().equals(EchoSocket.SELF_ADDRESS)) {
			sendToSelf(frame.copy());
			return;
		}
		byte[] data = frame.getFrameByteArray();

		InetAddress address = InetAddress.getByName(frame.getDstEchoAddress());
		DatagramPacket packet = new DatagramPacket(data, data.length,
				address, PORT);
		mMulticastSocket.send(packet);
		if(frame.getDstEchoAddress().equals(EchoSocket.MULTICAST_ADDRESS)) {
			EchoFrame f = frame.copy();
			f.setDstEchoAddress(EchoSocket.SELF_ADDRESS);
			sendToSelf(f);
		}
	}
	
	public void sendToSelf(EchoFrame frame) {
		UDPProtocolTask task = new UDPProtocolTask(frame, this);
		EchoSocket.enqueueTask(task);
	}

	public void receive()  {
		DatagramPacket packet =
				new DatagramPacket(
						new byte[UDP_MAX_PACKET_SIZE],
						UDP_MAX_PACKET_SIZE);
		// closed?
		if(mMulticastSocket == null){
			//System.err.println("sMulticastSocket has been closed.");
			//try {
			//	openUDP();
			//} catch (IOException e) {
			//	e.printStackTrace();
			//}
			return;
		}
		try {
			mMulticastSocket.receive(packet);
		} catch (IOException e) {
			//e.printStackTrace();
			//try {
			//	openUDP();
			//} catch (IOException e1) {
			//	e1.printStackTrace();
			//}
			return;
		}
		Enumeration<InetAddress> enumIpAddr;
		try {
			enumIpAddr = mMulticastSocket.getNetworkInterface().getInetAddresses();
		} catch (SocketException e) {
			//e.printStackTrace();
			//try {
			//	openUDP();
			//} catch (IOException e1) {
			//	e1.printStackTrace();
			//}
			return;
		}
		while(enumIpAddr.hasMoreElements()) {
			InetAddress inetAddress = enumIpAddr.nextElement();
			if (inetAddress.equals(packet.getAddress())) {
				// from self node
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
		
		UDPProtocolTask task = new UDPProtocolTask(frame, this);
		EchoSocket.enqueueTask(task);
	}
	
	public static class UDPProtocolTask extends EchoProtocol.Task {

		EchoUDPProtocol mProtocol;
		public UDPProtocolTask(EchoFrame frame, EchoUDPProtocol protocol) {
			super(frame);
			mProtocol = protocol;
		}

		@Override
		protected void respond(EchoFrame response) {
			try {
				mProtocol.sendUDP(response);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		protected void informAll(EchoFrame response) {
			try {
				mProtocol.sendUDP(response);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
