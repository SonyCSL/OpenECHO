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
package com.sonycsl.echo.eoj;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.EchoUtils;
import com.sonycsl.echo.node.EchoNode;


public abstract class EchoObject {

	@SuppressWarnings("unused")
	private static final String TAG = EchoObject.class.getSimpleName();
	private final EchoObject self = this;
	
	public static final byte ESV_SETI = 0x60;
	public static final byte ESV_SETC = 0x61;
	public static final byte ESV_GET  = 0x62;
	public static final byte ESV_INF_REQ = 0x63;
	public static final byte ESV_SET_RES = 0x71;
	public static final byte ESV_GET_RES = 0x72;
	public static final byte ESV_INF = 0x73;
	public static final byte ESV_INFC = 0x74;
	public static final byte ESV_INFC_RES = 0x7A;
	public static final byte ESV_SETI_SNA = 0x50;
	public static final byte ESV_SETC_SNA = 0x51;
	public static final byte ESV_GET_SNA = 0x52;
	public static final byte ESV_INF_SNA = 0x53;
	
	public static final byte ESV_SET_NO_RES = 0x70;
	
	public static final byte ESV_SET_GET = 0x6E;
	public static final byte ESV_SET_GET_RES = 0x7E;
	public static final byte ESV_SET_GET_SNA = 0x5E;
	
	private short mTid = 0;
	
	private EchoNode mNode = null;
	
	private EchoObject mSeoj = null;
	private EchoObject mDeoj = null;
	
	private Receiver mReceiver = null;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("groupCode:");
		sb.append(String.format("%02x", getClassGroupCode()));
		sb.append(",classCode:");
		sb.append(String.format("%02x", getClassCode()));
		sb.append(",instanceCode:");
		sb.append(String.format("%02x", getInstanceCode()));
		sb.append(",address:");
		if(getNode() != null) {
			sb.append(getNode().getAddress().getHostAddress());
		}
		return new String(sb);
	}
	
	public abstract byte getClassGroupCode();
	
	public abstract byte getClassCode();
	
	public abstract byte getInstanceCode();
	
	public final short getObjectClassCode() {
		return EchoUtils.getObjectClassCode(getClassGroupCode(), getClassCode());
	}
	
	public boolean isProxy() {
		return false;
	}
	
	public final void setTid(short tid) {
		mTid = tid;
	}
	
	public final short getTid() {
		return mTid;
	}
	
	public final void setNode(EchoNode node) {
		mNode = node;
	}
	
	public EchoNode getNode() {
		return mNode;
	}
	
	public final void setSeoj(EchoObject seoj) {
		mSeoj = seoj;
	}
	
	public final EchoObject getSeoj() {
		if(mSeoj == null) {
			mSeoj = Echo.getNode().getProfile();
		}
		return mSeoj;
	}
	
	protected void setDeoj(EchoObject deoj) {
		mDeoj = deoj;
	}
	
	protected EchoObject getDeoj() {
		if(mDeoj == null) {
			mDeoj = Echo.getNode().getProfile();
		}
		return mDeoj;
	}

	public final void setReceiver(Receiver receiver) {
		mReceiver = receiver;
	}

	public void onInvokedSetMethod(byte epc, byte[] edt, boolean success) {
		if(Echo.getMethodInvokedListener() == null) return;
		byte pdc = (edt == null) ? 0 : (byte)edt.length;
		Echo.getMethodInvokedListener().onInvokedSetMethod(this, epc, pdc, edt, success);
	}
	public void onInvokedGetMethod(byte epc, byte[] edt) {
		if(Echo.getMethodInvokedListener() == null) return;
		byte pdc = (edt == null) ? 0 : (byte)edt.length;
		Echo.getMethodInvokedListener().onInvokedGetMethod(this, epc, pdc, edt);
	}
	
	public void onInvokedReqSetMethod(byte epc, byte[] edt) {
		if(Echo.getMethodInvokedListener() == null) return;
		byte pdc = (edt == null) ? 0 : (byte)edt.length;
		Echo.getMethodInvokedListener().onInvokedReqSetMethod(this, epc, pdc, edt);
	}
	public void onInvokedReqGetMethod(byte epc) {
		if(Echo.getMethodInvokedListener() == null) return;
		Echo.getMethodInvokedListener().onInvokedReqGetMethod(this, epc);
	}
	public void onInvokedReqInformMethod(byte epc) {
		if(Echo.getMethodInvokedListener() == null) return;
		Echo.getMethodInvokedListener().onInvokedReqInformMethod(this, epc);
	}
	public void onInvokedReqInformMethod(byte epc, byte[] edt) {
		if(Echo.getMethodInvokedListener() == null) return;
		byte pdc = (edt == null) ? 0 : (byte)edt.length;
		Echo.getMethodInvokedListener().onInvokedReqInformMethod(this, epc, pdc, edt);
	}
	public void onInvokedInformMethod(byte epc, byte[] edt) {
		if(Echo.getMethodInvokedListener() == null) return;
		byte pdc = (edt == null) ? 0 : (byte)edt.length;
		Echo.getMethodInvokedListener().onInvokedInformMethod(this, epc, pdc, edt);
	}
	
	public final void onReceive(EchoFrame frame) {
		EchoFrame.Property[] properties = frame.getProperties();
		if(mReceiver != null) {
			for(EchoFrame.Property p : properties) {
				mReceiver.onReceive(this, frame.getTid(), frame.getEsv(), p.epc, p.pdc, p.edt);
			}
		}

		EchoFrame res;
		switch(frame.getEsv()) {
		case ESV_SETI:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), ESV_SET_NO_RES);
			for(EchoFrame.Property p : properties) {
				onReceiveSet(res, p.epc, p.pdc, p.edt);
			}
			if(res.getEsv() == ESV_SETI_SNA) {
				try {
					EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		case ESV_SETC:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), ESV_SET_RES);
			for(EchoFrame.Property p : properties) {
				onReceiveSet(res, p.epc, p.pdc, p.edt);
			}
			try {
				EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case ESV_GET:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), ESV_GET_RES);
			for(EchoFrame.Property p : properties) {
				onReceiveGet(res, p.epc);
			}
			try {
				EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case ESV_INF_REQ:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), ESV_INF);
			for(EchoFrame.Property p : properties) {
				onReceiveInfReq(res, p.epc);
			}
			/*
			try {
				EchoSocket.sendGroup(res.getFrameByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
			if(res.getEsv() == ESV_INF) {
				try {
					EchoSocket.sendGroup(res.getFrameByteArray());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		case ESV_INFC:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), ESV_INFC_RES);
			for(EchoFrame.Property p : properties) {
				res.addProperty(p.epc);
			}
			try {
				EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case ESV_SET_GET:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), ESV_SET_GET_SNA);
			byte[] b = res.getFrameByteArray();
			ByteBuffer buffer = ByteBuffer.allocate(b.length+1);
			buffer.order(ByteOrder.BIG_ENDIAN);
			buffer.put(b);
			buffer.put((byte)0);
			try {
				EchoSocket.send(res.getDeoj().getNode().getAddress(), buffer.array());
			} catch (IOException e) {
				e.printStackTrace();
			}
		default :
			return;
		}
		
	}

	
	/**
	 * ESV=0x60,0x61
	 * @param res
	 * @param epc
	 * @param pdc
	 * @param edt
	 */
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		
	}
	
	/**
	 * ESV=0x62
	 * @param res
	 * @param epc
	 * @param pdc
	 * @param edt
	 */
	protected void onReceiveGet(EchoFrame res, byte epc) {
		
	}
	
	/**
	 * ESV=0x63
	 * @param res
	 * @param epc
	 * @param pdc
	 * @param edt
	 */
	protected void onReceiveInfReq(EchoFrame res, byte epc) {
		onReceiveGet(res, epc);
	}

	public Setter set() {
		return new Setter(ESV_SETI);
	}
	
	public Setter setC() {
		return new Setter(ESV_SETC);
	}
	
	public Getter get() {
		return new Getter();
	}
	
	public Informer inform() {
		return new InformerImpl();
	}
	
	protected InformerC informC() {
		return new InformerC();
	}
	
	public static class Receiver {
		public final void onReceive(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			switch(esv) {
			case ESV_SET_RES: case ESV_SETI_SNA: case ESV_SETC_SNA:
				onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
				break;
			case ESV_GET_RES: case ESV_GET_SNA:
				onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
				break;
			case ESV_INF: case ESV_INF_SNA:
				onReceiveInf(eoj, tid, esv, epc, pdc, edt);
				break;
			case ESV_INFC:
				onReceiveInfC(eoj, tid, esv, epc, pdc, edt);
				break;
			case ESV_INFC_RES:
				onReceiveInfCRes(eoj, tid, esv, epc, pdc, edt);
				break;
			}
		}
		/**
		 * ESV=0x71,0x50,0x51
		 * @param eoj
		 * @param tid
		 * @param esv
		 * @param epc
		 * @param pdc
		 * @param edt
		 */
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			
		}
		
		/**
		 * ESV=0x72,0x52
		 * @param eoj
		 * @param tid
		 * @param epc
		 * @param pdc
		 * @param edt
		 */
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			
		}

		/**
		 * ESV=0x73,0x53
		 * @param eoj
		 * @param tid
		 * @param esv
		 * @param epc
		 * @param pdc
		 * @param edt
		 */
		protected final void onReceiveInf(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			onReceiveInfC(eoj, tid, esv, epc, pdc, edt);
		}
		
		/**
		 * ESV=0x74
		 * @param eoj
		 * @param tid
		 * @param epc
		 * @param pdc
		 * @param edt
		 */
		protected void onReceiveInfC(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
		}
		
		/**
		 * ESV=0x7A
		 * @param eoj
		 * @param tid
		 * @param epc
		 * @param pdc
		 * @param edt
		 */
		protected void onReceiveInfCRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
		}
		

		public void onInvokedOnSetMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			if(Echo.getMethodInvokedListener() == null) return;
			Echo.getMethodInvokedListener().onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		public void onInvokedOnGetMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			if(Echo.getMethodInvokedListener() == null) return;
			Echo.getMethodInvokedListener().onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
			
		}
		public void onInvokedOnInformMethod(EchoObject eoj, short tid, byte esv, byte epc) {
			Echo.getMethodInvokedListener().onInvokedOnInformMethod(eoj, tid, esv, epc);
		}
		
	}
	
	protected class Sender {
		protected EchoFrame mFrame;
		
		public Sender(EchoObject seoj, EchoObject deoj, byte esv) {
			mFrame = new EchoFrame(mTid, seoj, deoj, esv);
		}
		
		protected void send() throws IOException {
			byte[] data = mFrame.getFrameByteArray();
			EchoSocket.send(mNode.getAddress(), data);
			if(Echo.getMethodInvokedListener() == null) return;
			Echo.getMethodInvokedListener().onInvokedSendMethod(getFrame());
		}
		
		protected void sendGroup() throws IOException {
			byte[] data = mFrame.getFrameByteArray();
			EchoSocket.sendGroup(data);
			if(Echo.getMethodInvokedListener() == null) return;
			Echo.getMethodInvokedListener().onInvokedSendGroupMethod(getFrame());
		}

		
		protected EchoFrame getFrame() {
			return mFrame;
		}

		protected void setEsv(byte esv) {
			mFrame.setEsv(esv);
		}
		
		protected byte getEsv() {
			return mFrame.getEsv();
		}
		
		protected void addProperty(byte epc) {
			mFrame.addProperty(epc);
		}
		
		protected void addProperty(byte epc, byte[] edt) {
			mFrame.addProperty(epc, edt);
		}

		protected void addProperty(byte epc, byte[] edt, boolean success) {
			mFrame.addProperty(epc, edt, success);
		}

		
	}
	
	public class Setter extends Sender {

		public Setter(byte esv) {
			super(getSeoj(), self, esv);
		}
		
		@Override
		public void send() throws IOException {
			super.send();
		}

		@Override
		public void sendGroup() throws IOException {
			super.sendGroup();
		}

		public Setter reqSet(byte epc, byte[] edt) {
			addProperty(epc, edt);
			onInvokedReqSetMethod(epc, edt);
			return this;
		}

		@Override
		protected void addProperty(byte epc, byte[] edt, boolean success) {
			super.addProperty(epc, edt, success);
			if(success)
				onInvokedReqSetMethod(epc, edt);
		}

	}
	
	public class Getter extends Sender {
		public Getter() {
			super(getSeoj(), self, ESV_GET);
		}
		
		@Override
		public void send() throws IOException {
			super.send();
		}

		@Override
		public void sendGroup() throws IOException {
			super.sendGroup();
		}

		public Getter reqGet(byte epc) {
			addProperty(epc);
			onInvokedReqGetMethod(epc);
			return this;
		}

		@Override
		protected void addProperty(byte epc) {
			super.addProperty(epc);
			onInvokedReqGetMethod(epc);
		}
	}
	
	
	
	public interface Informer {
		public void send() throws IOException;
		public void sendGroup() throws IOException;

		public Informer reqInform(byte epc);
	}
	
	public class InformerImpl extends Sender implements Informer {

		public InformerImpl() {
			super(self, getDeoj(), ESV_INF);
		}

		@Override
		public void send() throws IOException {
			super.send();
		}

		@Override
		public void sendGroup() throws IOException {
			super.sendGroup();
		}

		protected void addProperty(byte epc, byte[] edt, boolean success) {
			if(success) {
				mFrame.addProperty(epc, edt);
				onInvokedReqInformMethod(epc, edt);
			}
		}

		@Override
		public Informer reqInform(byte epc) {
			getFrame().setEsv(ESV_INFC);
			onReceiveInfReq(getFrame(), epc);
			getFrame().setEsv(ESV_INF);
			EchoFrame.Property[] props = getFrame().getProperties();
			if(props.length == 0) return this;
			EchoFrame.Property prop = props[props.length - 1];
			if(prop.epc == epc)
				onInvokedReqInformMethod(epc, prop.edt);
			return this;
		}
	}
	
	public class InformerProxy extends Sender implements Informer {

		public InformerProxy() {
			super(getSeoj(), self, ESV_INF_REQ);
		}

		@Override
		public void send() throws IOException {
			super.send();
		}

		@Override
		public void sendGroup() throws IOException {
			super.sendGroup();
		}

		@Override
		public Informer reqInform(byte epc) {
			addProperty(epc);
			return this;
		}

		@Override
		protected void addProperty(byte epc) {
			super.addProperty(epc);
			onInvokedReqInformMethod(epc);
		}
	}

	public class InformerC extends Sender {
		public InformerC() {
			super(self, getDeoj(), ESV_INFC);
		}

		@Override
		public void send() throws IOException {
			super.send();
		}

		@Override
		protected void addProperty(byte epc, byte[] edt) {
			super.addProperty(epc, edt);
			onInvokedInformMethod(epc, edt);
		}

	}

}
