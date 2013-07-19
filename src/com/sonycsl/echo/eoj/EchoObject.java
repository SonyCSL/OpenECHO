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
	
	private long mUpdatedTime = 0;
	
	private Receiver mReceiver = null;
	
	private boolean mActive = true;
	

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
			sb.append(getNode().getAddress().getHostAddress());
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
	
	public void initialize(EchoNode node) {
		mNode = node;
		
		update();
		
		Echo.EventListener listener = Echo.getEventListener();
		try {
			if(listener != null) listener.onNewEchoObject(this);
		} catch(Exception e) {
			try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
		}
	}
	
	public void clear() {
		mNode = null;
	}
	
	public final void update() {
		setActive(true);
		mUpdatedTime = System.currentTimeMillis();
		EchoNode node = getNode();
		if(node != null) {
			node.update();
		}
	}
	
	public final long getUpdatedTime() {
		return mUpdatedTime;
	}
	
	public final boolean isProxy() {
		EchoNode node = getNode();
		if(node==null) return true;
		else return node.isProxy();
	}
	
	public final EchoNode getNode() {
		return mNode;
	}
	
	public final void setActive(boolean active) {
		mActive = active;
	}
	
	public final boolean isActive() {
		return mActive;
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
	
	protected boolean onReceiveProperty(EchoProperty property) {
		return false;
	}
	
	public final void receive(EchoFrame frame) {
		update();
		
		EchoProperty[] properties = frame.getProperties();

		Echo.EventListener listener = Echo.getEventListener();
		
		// receive response
		for(EchoProperty p : properties) {
			try {
				switch(frame.getEsv()) {
				case EchoFrame.ESV_SET_RES: case EchoFrame.ESV_SETI_SNA: case EchoFrame.ESV_SETC_SNA:
					if(mReceiver != null) mReceiver.onSetProperty(this, frame.getTid(), frame.getEsv(), p, (p.pdc == 0));
					if(listener != null) listener.onSetProperty(this, frame.getTid(), frame.getEsv(), p, (p.pdc == 0));
					break;
				case EchoFrame.ESV_GET_RES: case EchoFrame.ESV_GET_SNA:
				case EchoFrame.ESV_INF: case EchoFrame.ESV_INF_SNA:
				case EchoFrame.ESV_INFC:
					onReceiveProperty(p);
					if(mReceiver != null) mReceiver.onGetProperty(this, frame.getTid(), frame.getEsv(), p, (p.pdc != 0));
					if(listener != null) listener.onGetProperty(this, frame.getTid(), frame.getEsv(), p, (p.pdc != 0));
					break;
				case EchoFrame.ESV_INFC_RES:
					if(mReceiver != null) mReceiver.onInformProperty(this, frame.getTid(), frame.getEsv(), p);
					if(listener != null) listener.onInformProperty(this, frame.getTid(), frame.getEsv(), p);
					break;
				}
			} catch(Exception e) {
				try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
			}
		}

		// receive request
		EchoFrame res;
		switch(frame.getEsv()) {
		case EchoFrame.ESV_SETI:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), EchoFrame.ESV_SET_NO_RES);
			for(EchoProperty p : properties) {
				onReceiveSet(res, p);
			}
			if(res.getEsv() == EchoFrame.ESV_SETI_SNA) {
				try {
					EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
					if(listener != null) listener.sendEvent(res);
				} catch (Exception e) {
					try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
				}
			}
			break;
		case EchoFrame.ESV_SETC:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), EchoFrame.ESV_SET_RES);
			for(EchoProperty p : properties) {
				onReceiveSet(res, p);
			}
			try {
				EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
				if(listener != null) listener.sendEvent(res);
			} catch (Exception e) {
				try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
			}
			break;
		case EchoFrame.ESV_GET:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), EchoFrame.ESV_GET_RES);
			for(EchoProperty p : properties) {
				//if(!onReceiveGet(res, p.epc)) {
				//	res.addProperty(p.epc, p.edt, false);
				//}
				onReceiveGet(res, p.epc);
			}
			try {
				EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
				if(listener != null) listener.sendEvent(res);
			} catch (Exception e) {
				try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
			}
			break;
		case EchoFrame.ESV_INF_REQ:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), EchoFrame.ESV_INF);
			for(EchoProperty p : properties) {
				//if(!onReceiveInfReq(res, p.epc)) {
				//	res.addProperty(p.epc, p.edt, false);
				//}
				onReceiveGet(res, p.epc);
			}
			/*
			try {
				EchoSocket.sendGroup(res.getFrameByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
			if(res.getEsv() == EchoFrame.ESV_INF) {
				try {
					EchoSocket.sendGroup(res.getFrameByteArray());
					if(listener != null) listener.sendEvent(res);
				} catch (Exception e) {
					try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
				}
			} else {
				// ESV_INF_SNA
				try {
					EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
					if(listener != null) listener.sendEvent(res);
				} catch (Exception e) {
					try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
				}
			}
			break;
		case EchoFrame.ESV_INFC:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), EchoFrame.ESV_INFC_RES);
			for(EchoProperty p : properties) {
				res.addProperty(p.epc);
			}
			try {
				EchoSocket.send(res.getDeoj().getNode().getAddress(), res.getFrameByteArray());
				if(listener != null) listener.sendEvent(res);
			} catch (Exception e) {
				try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
			}
			break;
		case EchoFrame.ESV_SET_GET:
			res = new EchoFrame(frame.getTid(), frame.getDeoj(), frame.getSeoj(), EchoFrame.ESV_SET_GET_SNA);
			byte[] b = res.getFrameByteArray();
			ByteBuffer buffer = ByteBuffer.allocate(b.length+1);
			buffer.order(ByteOrder.BIG_ENDIAN);
			buffer.put(b);
			buffer.put((byte)0);
			try {
				EchoSocket.send(res.getDeoj().getNode().getAddress(), buffer.array());
				if(listener != null) listener.sendEvent(res);
			} catch (Exception e) {
				try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
			}
		default :
			return;
		}
		
	}

	protected final void onReceiveSet(EchoFrame res, EchoProperty property) {
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
				
			}
		} catch (Exception e) {
			//e.printStackTrace();
			success = false;
			try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
		}
		res.addProperty(property, success);
	}
	
	protected final void onReceiveGet(EchoFrame res, byte epc) {
		byte[] edt = null;
		Echo.EventListener listener = Echo.getEventListener();
		try {
			if(res.getEsv() == EchoFrame.ESV_GET_RES || res.getEsv() == EchoFrame.ESV_GET_SNA) {
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
		res.addProperty(epc, edt, (edt != null));
	}

	public Setter set() {
		return new Setter(this, true, false);
	}
	
	public Setter set(boolean responseRequired) {
		return new Setter(this, responseRequired, false);
	}
	
	public Getter get() {
		return new Getter(this, false);
	}
	
	public Informer inform() {
		return new Informer(this, !isProxy());
	}
	
	protected Informer inform(boolean multicast) {
		return new Informer(this, multicast);
	}
	
	protected InformerC informC() {
		return new InformerC(this);
	}
	
	
	public static class Receiver {
		
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
	
	protected static class Sender {
		private EchoObject mEoj;
		
		private EchoObject mSeoj;
		private EchoObject mDeoj;
		
		private byte mEsv;
		
		private boolean mMulticast;
		
		private ArrayList<EchoProperty> mPropertyList;
		
		public Sender(EchoObject eoj, EchoObject seoj, EchoObject deoj, byte esv, boolean multicast) {
			//mFrame = new EchoFrame(mTid, seoj, deoj, esv);
			mEoj = eoj;
			
			mSeoj = seoj;
			mDeoj = deoj;
			
			mEsv = esv;
			
			mPropertyList = new ArrayList<EchoProperty>();
			
			mMulticast = multicast;
		}
		
		protected short send() throws IOException {
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
		}
		
		protected void addProperty(byte epc) {
			mPropertyList.add(new EchoProperty(epc));
		}
		
		protected void addProperty(byte epc, byte[] edt) {
			mPropertyList.add(new EchoProperty(epc, edt));
		}
		
		
		private boolean isValidProperty(EchoProperty property) {

			Echo.EventListener listener = Echo.getEventListener();
			
			boolean valid = false;
			try {
				valid = mEoj.isValidProperty(property);
				if(listener != null) listener.isValidProperty(mEoj, property, valid);
			} catch(Exception e) {
				valid = false;
				try{if(listener != null) listener.onCatchException(e);}catch(Exception ex){}
			}
			return valid;
		}

		public void setSeoj(EchoObject seoj) {
			mSeoj = seoj;
		}
		
		public EchoObject getSeoj() {
			return mSeoj;
		}
		
		
		public void setDeoj(EchoObject deoj) {
			mDeoj = deoj;
		}
		
		public EchoObject getDeoj() {
			return mDeoj;
		}

		public boolean isMulticast() {
			return mMulticast;
		}
	}
	
	public static class Setter extends Sender {

		public Setter(EchoObject eoj, boolean responseRequired, boolean multicast) {
			super(eoj, Echo.getNode().getNodeProfile(), eoj
				, responseRequired ? EchoFrame.ESV_SETC : EchoFrame.ESV_SETI
				, multicast);
		}

		@Override
		public short send() throws IOException {
			return super.send();
		}

		public Setter reqSetProperty(byte epc, byte[] edt) {
			addProperty(epc, edt);
			return this;
		}

	}
	
	public static class Getter extends Sender {
		public Getter(EchoObject eoj, boolean multicast) {
			super(eoj, Echo.getNode().getNodeProfile(), eoj, EchoFrame.ESV_GET, multicast);
		}
		
		@Override
		public short send() throws IOException {
			return super.send();
		}

		public Getter reqGetProperty(byte epc) {
			addProperty(epc);
			return this;
		}

	}
	
	
	public static class Informer extends Sender {

		public Informer(EchoObject eoj, boolean multicast) {
			super(
				eoj
				, eoj.isProxy() ? Echo.getNode().getNodeProfile() : eoj
				, eoj.isProxy() ? eoj : Echo.getNode().getNodeProfile()
				, eoj.isProxy() ? EchoFrame.ESV_INF_REQ : EchoFrame.ESV_INF
				, multicast);
		}

		@Override
		public short send() throws IOException {
			return super.send();
		}
		
		public Informer reqInformProperty(byte epc) {
			addProperty(epc);
			return this;
		}
	}

	public static class InformerC extends Sender {
		public InformerC(EchoObject eoj) {
			super(eoj, eoj, Echo.getNode().getNodeProfile(), EchoFrame.ESV_INFC, false);
		}

		@Override
		public short send() throws IOException {
			return super.send();
		}
		
		public InformerC reqInformProperty(byte epc) {
			addProperty(epc);
			return this;
		}
	}

}
