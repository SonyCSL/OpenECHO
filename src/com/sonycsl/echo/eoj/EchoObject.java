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
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.EchoUtils;
import com.sonycsl.echo.eoj.profile.NodeProfile;
import com.sonycsl.echo.exception.InvalidPropertyException;
import com.sonycsl.echo.node.EchoNode;


public abstract class EchoObject {

	private EchoNode mNode = null;
	
	
	private Receiver mReceiver = null;
	
	

	private HashSet<Byte> mStatusChangeAnnouncementProperties;
	private HashSet<Byte> mSetProperties;
	private HashSet<Byte> mGetProperties;
	
	public EchoObject() {
		super();

		mStatusChangeAnnouncementProperties = new HashSet<Byte>();
		mSetProperties = new HashSet<Byte>();
		mGetProperties = new HashSet<Byte>();
		
		setupPropertyMaps();
	}
	
	public void onNew() {
		Echo.getEventListener().onNewEchoObject(this);
	}
	
	public void onFound() {
		Echo.getEventListener().onFoundEchoObject(this);
	}
	
	protected void setupPropertyMaps() {}

	protected final void addStatusChangeAnnouncementProperty(byte epc) {
		mStatusChangeAnnouncementProperties.add(epc);
	}

	protected final void removeStatusChangeAnnouncementProperty(byte epc) {
		if(mStatusChangeAnnouncementProperties.contains(epc))
			mStatusChangeAnnouncementProperties.remove(epc);
	}
	
	protected final void clearStatusChangeAnnouncementProperties() {
		mStatusChangeAnnouncementProperties.clear();
	}
	
	public final byte[] getStatusChangeAnnouncementProperties() {
		byte[] ret = new byte[mStatusChangeAnnouncementProperties.size()];
		Iterator<Byte> it = mStatusChangeAnnouncementProperties.iterator();
		for(int i = 0; i < ret.length; i++) {
			ret[i] = it.next();
		}
		return ret;
	}
	
	protected final void addSetProperty(byte epc) {
		mSetProperties.add(epc);
	}

	
	protected final void removeSetProperty(byte epc) {
		if(mSetProperties.contains(epc))
			mSetProperties.remove(epc);
	}
	
	protected final void clearSetProperties() {
		mSetProperties.clear();
	}
	
	public final byte[] getSetProperties() {
		byte[] ret = new byte[mSetProperties.size()];
		Iterator<Byte> it = mSetProperties.iterator();
		for(int i = 0; i < ret.length; i++) {
			ret[i] = it.next();
		}
		return ret;
	}
	
	protected final void addGetProperty(byte epc) {
		mGetProperties.add(epc);
	}
	
	protected final void removeGetProperty(byte epc) {
		if(mGetProperties.contains(epc))
			mGetProperties.remove(epc);
	}
	
	protected final void clearGetProperties() {
		mGetProperties.clear();
	}
	
	public final byte[] getGetProperties() {
		byte[] ret = new byte[mGetProperties.size()];
		Iterator<Byte> it = mGetProperties.iterator();
		for(int i = 0; i < ret.length; i++) {
			ret[i] = it.next();
		}
		return ret;
	}

	
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
			sb.append(getNode().getAddressStr());
		}
		return new String(sb);
	}
	
	public final byte getClassGroupCode() {
		short code = getEchoClassCode();
		return (byte)((code >> 8) & 0xFF);
	}
	
	public final byte getClassCode() {
		short code = getEchoClassCode();
		return (byte)(code & 0xFF);
	}
	
	public abstract byte getInstanceCode();
	
	public abstract short getEchoClassCode();
	
	public final int getEchoObjectCode() {
		return EchoUtils.getEchoObjectCode(getEchoClassCode(), getInstanceCode());
	}
	
	public final void setNode(EchoNode node) {
		mNode = node;
	}
	
	public final EchoNode getNode() {
		return mNode;
	}
	
	public final void removeNode() {
		mNode = null;
	}

	public final boolean isSelfObject() {
		EchoNode node = getNode();
		if(node==null) return false;
		else return node.isSelfNode();
		
	}
	
	public final boolean isProxy() {
		EchoNode node = getNode();
		if(node==null) return true;
		else return node.isProxy();
	}
	
	
	protected synchronized boolean setProperty(EchoProperty property) {
		return false;
	}
	
	protected synchronized byte[] getProperty(byte epc) {
		return null;
	}
	
	protected synchronized boolean isValidProperty(EchoProperty property) {
		return false;
	}
	
	public final void setReceiver(Receiver receiver) {
		mReceiver = receiver;
	}
	
	public final Receiver getReceiver() {
		return mReceiver;
	}
		
	public final EchoFrame onReceiveRequest(EchoFrame frame) {
		/*
		EchoProperty[] properties = frame.getProperties();

		Echo.EventListener listener = Echo.getEventListener();
		
		// receive response
		for(EchoProperty p : properties) {
			try {
				switch(frame.getESV()) {
				case EchoFrame.ESV_SET_RES: case EchoFrame.ESV_SETI_SNA: case EchoFrame.ESV_SETC_SNA:
					if(mReceiver != null) mReceiver.onSetProperty(this, frame.getTid(), frame.getESV(), p, (p.pdc == 0));
					if(listener != null) listener.onSetProperty(this, frame.getTid(), frame.getESV(), p, (p.pdc == 0));
					break;
				case EchoFrame.ESV_GET_RES: case EchoFrame.ESV_GET_SNA:
				case EchoFrame.ESV_INF: case EchoFrame.ESV_INF_SNA:
				case EchoFrame.ESV_INFC:
					onReceiveProperty(p);
					if(mReceiver != null) mReceiver.onGetProperty(this, frame.getTid(), frame.getESV(), p, (p.pdc != 0));
					if(listener != null) listener.onGetProperty(this, frame.getTid(), frame.getESV(), p, (p.pdc != 0));
					break;
				case EchoFrame.ESV_INFC_RES:
					if(mReceiver != null) mReceiver.onInformProperty(this, frame.getTid(), frame.getESV(), p);
					if(listener != null) listener.onInformProperty(this, frame.getTid(), frame.getESV(), p);
					break;
				}
			} catch(Exception e) {
				try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
			}
		}*/

		// receive request
		byte esv = 0;
		switch(frame.getESV()) {
		case EchoFrame.ESV_SETI:
			esv = EchoFrame.ESV_SET_NO_RES;
			break;
		case EchoFrame.ESV_SETC:
			esv = EchoFrame.ESV_SET_RES;
			break;
		case EchoFrame.ESV_GET:
			esv = EchoFrame.ESV_GET_RES;
			break;
		case EchoFrame.ESV_INF_REQ:
			esv = EchoFrame.ESV_INF;
			break;
		case EchoFrame.ESV_INFC:
			esv =  EchoFrame.ESV_INFC_RES;
			break;
		case EchoFrame.ESV_SET_GET:
			esv = EchoFrame.ESV_SET_GET_SNA;
			break;
		}
		EchoFrame response = new EchoFrame(frame.getDstEchoClassCode(), frame.getDstEchoInstanceCode()
				, frame.getSrcEchoClassCode(), frame.getSrcEchoInstanceCode()
				, frame.getSrcEchoAddress(), esv);
		response.setTID(frame.getTID());
		switch(frame.getESV()) {
		case EchoFrame.ESV_SETI:
		case EchoFrame.ESV_SETC:
			for(EchoProperty p : frame.getPropertyList()) {
				onReceiveSetRequest(p, response);
			}
			break;
		case EchoFrame.ESV_GET:
		case EchoFrame.ESV_INF_REQ:
			for(EchoProperty p : frame.getPropertyList()) {
				onReceiveGetRequest(p.epc, response);
			}
			break;
		case EchoFrame.ESV_INFC:
			for(EchoProperty p : frame.getPropertyList()) {
				response.addPropertyForResponse(p.epc);
			}
			break;
		}
		return response;

		
	}

	protected final void onReceiveSetRequest(EchoProperty property, EchoFrame response) {
		boolean success = false;
		Echo.EventListener listener = Echo.getEventListener();
		try {
			if(mSetProperties.contains(property.epc)) {
				boolean valid = isValidProperty(property);
				if(listener != null) listener.isValidProperty(this, property, valid);
				if(valid) {
					// valid property
					success = setProperty(property);
					if(listener != null) listener.setProperty(this, property, success);
				} else {
					// invalid property
					success = false;
				}
			} else {
				success = false;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			success = false;
			try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
		}

		if(success) {
			response.addPropertyForResponse(property.epc);
		} else {
			response.addPropertyForResponse(property.epc, property.edt);
		}
	}
	
	protected final void onReceiveGetRequest(byte epc, EchoFrame response) {
		byte[] edt = null;
		Echo.EventListener listener = Echo.getEventListener();
		try {
			if(response.getESV() == EchoFrame.ESV_GET_RES || response.getESV() == EchoFrame.ESV_GET_SNA) {
				edt = mGetProperties.contains(epc) ? getProperty(epc) : null;
			} else {
				edt = getProperty(epc);
			}
			EchoProperty property = new EchoProperty(epc, edt);
			listener.getProperty(this, property);
			boolean valid = isValidProperty(property);
			if(listener != null) listener.isValidProperty(this, property, valid);
			if(valid) {
				// valid property
			} else {
				// invalid property
				edt = null;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			edt = null;
			try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
		}
		response.addPropertyForResponse(epc, edt);
	}

	public Setter set() {
		return set(true);
	}
	
	public Setter set(boolean responseRequired) {
		return new Setter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr(), responseRequired);
	}
	
	public Getter get() {
		return new Getter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr());
	}
	
	public Informer inform() {
		return inform(isSelfObject());
	}
	
	protected Informer inform(boolean multicast) {

		String address;
		if(multicast) {
			address = EchoSocket.MULTICAST_ADDRESS;
		} else {
			address = getNode().getAddressStr();
		}
		return new Informer(getEchoClassCode(), getInstanceCode()
				, address, isSelfObject());
	}
	
	protected InformerC informC(String address) {
		return new InformerC(getEchoClassCode(), getInstanceCode()
				, address);
	}
	
	
	public static class Receiver {
		
		public void onReceive(EchoObject eoj, EchoFrame frame){
			onReceiveFrame(eoj, frame);

			switch(frame.getESV()) {
			case EchoFrame.ESV_SET_RES: case EchoFrame.ESV_SETI_SNA: case EchoFrame.ESV_SETC_SNA:
				for(EchoProperty p : frame.getPropertyList()) {
					onSetProperty(eoj, frame.getTID(), frame.getESV(), p, (p.pdc == 0));
				}
				break;
			case EchoFrame.ESV_GET_RES: case EchoFrame.ESV_GET_SNA:
			case EchoFrame.ESV_INF: case EchoFrame.ESV_INF_SNA:
			case EchoFrame.ESV_INFC:
				for(EchoProperty p : frame.getPropertyList()) {
					onGetProperty(eoj, frame.getTID(), frame.getESV(), p, (p.pdc != 0));
				}
				break;
			case EchoFrame.ESV_INFC_RES:
				for(EchoProperty p : frame.getPropertyList()) {
					onInformProperty(eoj, frame.getTID(), frame.getESV(), p);
				}
				break;
			}
		}
		
		public void onReceiveFrame(EchoObject eoj, EchoFrame frame) {
			
		}
		
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
			return false;
		}
		
		protected boolean onGetProperty(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
			return false;
		}
		
		protected boolean onInformProperty(EchoObject eoj, short tid, byte esv, EchoProperty property) {
			return false;
		}
		
	}
	
	protected static abstract class Sender {
		protected short mSrcEchoClassCode;
		protected byte mSrcEchoInstanceCode;
		protected short mDstEchoClassCode;
		protected byte mDstEchoInstanceCode;
		protected String mDstEchoAddress;
		protected byte mESV;
		
		
		public Sender(short srcEchoClassCode, byte srcEchoInstanceCode
				, short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, byte esv) {
			mSrcEchoClassCode = srcEchoClassCode;
			mSrcEchoInstanceCode = srcEchoInstanceCode;
			mDstEchoClassCode = dstEchoClassCode;
			mDstEchoInstanceCode = dstEchoInstanceCode;
			mDstEchoAddress = dstEchoAddress;
			mESV = esv;
		}
		/*
		protected EchoFrame send() throws IOException {
			short tid = EchoSocket.getNextTID();
			EchoFrame frame = new EchoFrame(tid, mSeoj, mDeoj, mEsv);
			switch(mEsv) {
			case EchoFrame.ESV_SETI : case EchoFrame.ESV_SETC :
				for(EchoProperty p : mPropertyList) {
					if(isValidProperty(p)) {
						frame.addProperty(p);
					}
				}
				break;
			case EchoFrame.ESV_GET : case EchoFrame.ESV_INF_REQ :
				for(EchoProperty p : mPropertyList) {
					frame.addProperty(p);
				}
				break;
			case EchoFrame.ESV_INF : case EchoFrame.ESV_INFC :
				
				for(EchoProperty p : mPropertyList) {
					EchoProperty pp = new EchoProperty(p.epc, mEoj.getProperty(p.epc));
					if(isValidProperty(pp)) {
						frame.addProperty(pp);
					}
				}
				break;
			}
			byte[] data = frame.getFrameByteArray();
			
			if (mMulticast) {
				EchoSocket.sendGroup(data);
			} else {
				//EchoSocket.send(mEoj.getNode().getAddress(), data);
				if(getDeoj().getNode() == null) {
					throw new IOException("Not found target node.");
				}
				EchoSocket.send(getDeoj().getNode().getAddress(), data);
			}
			//if(Echo.getMethodInvokedListener() == null) return;
			//Echo.getMethodInvokedListener().onInvokedSendMethod(frame);
			
			
			Echo.EventListener listener = Echo.getEventListener();
			try {
				if(listener != null) listener.sendEvent(frame);
			} catch(Exception e) {
				try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
			}
			return tid;
		}*/

		abstract EchoFrame send() throws IOException ;
		public void send(EchoFrame frame) throws IOException {
			short tid = EchoSocket.nextTID();
			frame.setTID(tid);
			EchoSocket.sendUDPFrame(frame);
		}
		abstract EchoFrame sendTCP() throws IOException ;
		public void sendTCP(EchoFrame frame) throws IOException {
			short tid = EchoSocket.nextTID();
			frame.setTID(tid);
			EchoSocket.sendTCPFrame(frame);
		}
		
		public void setSeoj(short srcEchoClassCode, byte srcEchoInstanceCode) {
			mSrcEchoClassCode = srcEchoClassCode;
			mSrcEchoInstanceCode = srcEchoInstanceCode;
		}
		
		
		public void setDeoj(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			mDstEchoClassCode = dstEchoClassCode;
			mDstEchoInstanceCode = dstEchoInstanceCode;
			mDstEchoAddress = dstEchoAddress;
		}

	}
	
	public static class Setter extends Sender {

		
		protected ArrayList<EchoProperty> mPropertyList;
		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(NodeProfile.ECHO_CLASS_CODE
				, Echo.getSelfNode().getNodeProfile().getInstanceCode()
				, dstEchoClassCode, dstEchoInstanceCode, dstEchoAddress
					, responseRequired ? EchoFrame.ESV_SETC : EchoFrame.ESV_SETI);
			mPropertyList = new ArrayList<EchoProperty>();
		}

		@Override
		public EchoFrame send() throws IOException {

			EchoFrame frame = new EchoFrame(mSrcEchoClassCode, mSrcEchoInstanceCode
					, mDstEchoClassCode, mDstEchoInstanceCode
					, mDstEchoAddress, mESV);

			for(EchoProperty p : mPropertyList) {
				frame.addProperty(p);
			}
			send(frame);
			return frame;
		}

		@Override
		public EchoFrame sendTCP() throws IOException {

			EchoFrame frame = new EchoFrame(mSrcEchoClassCode, mSrcEchoInstanceCode
					, mDstEchoClassCode, mDstEchoInstanceCode
					, mDstEchoAddress, mESV);

			for(EchoProperty p : mPropertyList) {
				frame.addProperty(p);
			}
			sendTCP(frame);
			return frame;
		}
		
		public Setter reqSetProperty(byte epc, byte[] edt) {
			mPropertyList.add(new EchoProperty(epc, edt));
			return this;
		}


	}
	
	public static class Getter extends Sender {
		protected ArrayList<Byte> mEPCList;

		
		
		public Getter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			super(NodeProfile.ECHO_CLASS_CODE
					, Echo.getSelfNode().getNodeProfile().getInstanceCode()
					, dstEchoClassCode, dstEchoInstanceCode, dstEchoAddress
					, EchoFrame.ESV_GET);
			mEPCList = new ArrayList<Byte>();
		}
		
		@Override
		public EchoFrame send() throws IOException {

			EchoFrame frame = new EchoFrame(mSrcEchoClassCode, mSrcEchoInstanceCode
					, mDstEchoClassCode, mDstEchoInstanceCode
					, mDstEchoAddress, mESV);


			for(Byte epc : mEPCList) {
				frame.addProperty(new EchoProperty(epc));
			}
			send(frame);
			return frame;
		}

		@Override
		public EchoFrame sendTCP() throws IOException {

			EchoFrame frame = new EchoFrame(mSrcEchoClassCode, mSrcEchoInstanceCode
					, mDstEchoClassCode, mDstEchoInstanceCode
					, mDstEchoAddress, mESV);


			for(Byte epc : mEPCList) {
				frame.addProperty(new EchoProperty(epc));
			}
			sendTCP(frame);
			return frame;
		}

		public Getter reqGetProperty(byte epc) {
			mEPCList.add(epc);
			return this;
		}

	}
	
	
	public static class Informer extends Sender {
		protected ArrayList<Byte> mEPCList;

		public Informer(short echoClassCode, byte echoInstanceCode
				, String dstEchoAddress, boolean isSelfObject) {
			super(
					isSelfObject ? echoClassCode : NodeProfile.ECHO_CLASS_CODE
							, isSelfObject ? echoInstanceCode : Echo.getSelfNode().getNodeProfile().getInstanceCode()
							, isSelfObject ? NodeProfile.ECHO_CLASS_CODE : echoClassCode
							, isSelfObject ? NodeProfile.INSTANCE_CODE : echoInstanceCode
							, dstEchoAddress
							, isSelfObject ? EchoFrame.ESV_INF : EchoFrame.ESV_INF_REQ);
			mEPCList = new ArrayList<Byte>();
		}

		@Override
		public EchoFrame send() throws IOException {

			EchoFrame frame = new EchoFrame(mSrcEchoClassCode, mSrcEchoInstanceCode
					, mDstEchoClassCode, mDstEchoInstanceCode
					, mDstEchoAddress, mESV);

			if(mESV == EchoFrame.ESV_INF_REQ) {
				for(Byte epc : mEPCList) {
					frame.addProperty(new EchoProperty(epc));
				}
			} else {
				EchoNode node = Echo.getSelfNode();
				EchoObject seoj = node.getInstance(mSrcEchoClassCode, mSrcEchoInstanceCode);
				if(seoj.get() == null) {
					return frame;
				}
				for(Byte epc : mEPCList) {
					byte[] edt = seoj.getProperty(epc);

					if(edt != null) {
						EchoProperty property = new EchoProperty(epc, edt);

						if(seoj.isValidProperty(property)) {
							frame.addProperty(property);
						}
					}
				}
			}

			send(frame);
			return frame;
		}
		
		public Informer reqInformProperty(byte epc) {
			mEPCList.add(epc);
			return this;
		}

		@Override
		public EchoFrame sendTCP() throws IOException {

			EchoFrame frame = new EchoFrame(mSrcEchoClassCode, mSrcEchoInstanceCode
					, mDstEchoClassCode, mDstEchoInstanceCode
					, mDstEchoAddress, mESV);

			if(mESV == EchoFrame.ESV_INF_REQ) {
				for(Byte epc : mEPCList) {
					frame.addProperty(new EchoProperty(epc));
				}
			} else {
				EchoNode node = Echo.getSelfNode();
				if(node == null) {
					return frame;
				}
				EchoObject seoj = node.getInstance(mSrcEchoClassCode, mSrcEchoInstanceCode);
				if(seoj.get() == null) {
					return frame;
				}
				for(Byte epc : mEPCList) {
					byte[] edt = seoj.getProperty(epc);

					if(edt != null) {
						EchoProperty property = new EchoProperty(epc, edt);

						if(seoj.isValidProperty(property)) {
							frame.addProperty(property);
						}
					}
				}
			}

			sendTCP(frame);
			return frame;
		}
	}

	public static class InformerC extends Sender {
		protected ArrayList<Byte> mEPCList;
		
		public InformerC(short srcEchoClassCode, byte srcEchoInstanceCode
				, String dstEchoAddress) {
			super(NodeProfile.ECHO_CLASS_CODE
					, Echo.getSelfNode().getNodeProfile().getInstanceCode()
					, NodeProfile.ECHO_CLASS_CODE, NodeProfile.INSTANCE_CODE, dstEchoAddress
					, EchoFrame.ESV_INFC);
			mEPCList = new ArrayList<Byte>();
		}

		@Override
		public EchoFrame send() throws IOException {

			EchoFrame frame = new EchoFrame(mSrcEchoClassCode, mSrcEchoInstanceCode
					, mDstEchoClassCode, mDstEchoInstanceCode
					, mDstEchoAddress, mESV);

			EchoNode node = Echo.getSelfNode();
			if(node == null) {
				return frame;
			}
			EchoObject seoj = node.getInstance(mSrcEchoClassCode, mSrcEchoInstanceCode);
			if(seoj.get() == null) {
				return frame;
			}
			for(Byte epc : mEPCList) {
				byte[] edt = seoj.getProperty(epc);

				if(edt != null) {
					EchoProperty property = new EchoProperty(epc, edt);

					if(seoj.isValidProperty(property)) {
						frame.addProperty(property);
					}
				}
			}

			send(frame);
			return frame;
		}
		
		public InformerC reqInformProperty(byte epc) {
			mEPCList.add(epc);
			return this;
		}

		@Override
		public EchoFrame sendTCP() throws IOException {
			EchoFrame frame = new EchoFrame(mSrcEchoClassCode, mSrcEchoInstanceCode
					, mDstEchoClassCode, mDstEchoInstanceCode
					, mDstEchoAddress, mESV);

			EchoNode node = Echo.getSelfNode();
			if(node == null) {
				return frame;
			}
			EchoObject seoj = node.getInstance(mSrcEchoClassCode, mSrcEchoInstanceCode);
			if(seoj.get() == null) {
				return frame;
			}
			for(Byte epc : mEPCList) {
				byte[] edt = seoj.getProperty(epc);

				if(edt != null) {
					EchoProperty property = new EchoProperty(epc, edt);

					if(seoj.isValidProperty(property)) {
						frame.addProperty(property);
					}
				}
			}

			sendTCP(frame);
			return frame;
		}
	}

}
