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

import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.exception.OutOfFrameException;



/**
 * 
 * ECHONET Liteの電文(フレーム)を作るクラス
 *
 */
public final class EchoFrame {
	
	private static final byte EHD1 = 0x10;
	private static final byte EHD2 = (byte)0x81; 


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
	
	private short mTID;
	private EchoObject mSeoj;
	private EchoObject mDeoj;
	private byte mEsv;
	
	protected List<EchoProperty> mPropertyList;
	
	


	public EchoFrame(short tid, EchoObject seoj, EchoObject deoj, byte esv) {
		mTID = tid;
		mSeoj = seoj;
		mDeoj = deoj;
		mEsv = esv;
		
		mPropertyList = new ArrayList<EchoProperty>();
		
	}
	
	public EchoFrame(InetAddress address, byte[] data) {
		if(data.length < 11) {return;}
		if(data[0] != EHD1) return;
		if(data[1] != EHD2) return;
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.put(data[2]);
		buffer.put(data[3]);
		mTID = buffer.getShort(0);
		//Echo.putProxy(address, data[4], data[5], data[6]);
		Echo.updateNodeInstance(address, data[4], data[5], data[6]);
		mSeoj = Echo.getInstance(address, data[4], data[5], data[6]);
		mDeoj = Echo.getInstance(Echo.getNode().getAddress(), 
				data[7], data[8], data[9]);
		mEsv = data[10];
		int size = data[11] & 0xFF;
		mPropertyList = new ArrayList<EchoProperty>();
		for(int i = 0, j = 12; i < size; i++) {
			if(data.length == j) return;
			byte epc, pdc;
			byte[] edt;
			epc = data[j];
			j++;
			if(data.length == j) return;
			pdc = data[j];
			j++;
			if(pdc == 0) {
				edt = null;
			} else {
				if(data.length < j+(pdc & 0xFF)) return;
				edt = new byte[(int)(pdc & 0xFF)];
				System.arraycopy(data, j, edt, 0, (int)(pdc & 0xFF));
				j += (pdc & 0xFF);
			}
			mPropertyList.add(new EchoProperty(epc, pdc, edt));
		}
		
	}
	
	public short getTid() {
		return mTID;
	}
	
	public EchoObject getSeoj() {
		return mSeoj;
	}
	
	public EchoObject getDeoj() {
		return mDeoj;
	}
	
	public void setEsv(byte esv) {
		mEsv = esv;
	}

	public byte getEsv() {
		return mEsv;
	}
	
	public EchoProperty[] getProperties() {
		return (EchoProperty[]) mPropertyList.toArray(new EchoProperty[]{});
	}
	
	public void addProperty(EchoProperty property) {
		mPropertyList.add(property);
	}
	
	public void addProperty(byte epc, byte pdc, byte[] edt) {
		EchoProperty prop = new EchoProperty(epc, pdc, edt);
		mPropertyList.add(prop);
	}

	public void addProperty(byte epc, byte[] edt) {
		EchoProperty prop = new EchoProperty(epc, edt);
		mPropertyList.add(prop);
	}
	
	public void addProperty(byte epc) {
		addProperty(epc, (byte)0, null);
	}
	
	
	public void addProperty(byte epc, byte[] edt, boolean success) {
		if(success) {
			switch(mEsv) {
			case ESV_SETI: case ESV_SETC:
				addProperty(epc, edt);
				break;
			case ESV_SET_NO_RES: case ESV_SETI_SNA:
			case ESV_SET_RES: case ESV_SETC_SNA:
				addProperty(epc);
				break;
			case ESV_GET_RES: case ESV_GET_SNA:
				addProperty(epc, edt);
				break;
			case ESV_INF: case ESV_INF_SNA:
				addProperty(epc, edt);
			case ESV_INFC:
				addProperty(epc, edt);
				break;
			}
		} else {
			switch(mEsv) {
			case ESV_SET_NO_RES: case ESV_SETI_SNA:
				addProperty(epc, edt);
				setEsv(ESV_SETI_SNA);
				break;
			case ESV_SET_RES: case ESV_SETC_SNA:
				addProperty(epc, edt);
				setEsv(ESV_SETC_SNA);
				break;
			case ESV_GET_RES: case ESV_GET_SNA:
				addProperty(epc);
				setEsv(ESV_GET_SNA);
				break;
			case ESV_INF: case ESV_INF_SNA:
				addProperty(epc);
				setEsv(ESV_INF_SNA);
				break;
			}
		}
	}

	public void addProperty(EchoProperty property, boolean success) {
		if(success) {
			switch(mEsv) {
			case ESV_SETI: case ESV_SETC:
				addProperty(property);
				break;
			case ESV_SET_NO_RES: case ESV_SETI_SNA:
			case ESV_SET_RES: case ESV_SETC_SNA:
				addProperty(property.epc);
				break;
			case ESV_GET_RES: case ESV_GET_SNA:
				addProperty(property);
				break;
			case ESV_INF: case ESV_INF_SNA:
				addProperty(property);
			case ESV_INFC:
				addProperty(property);
				break;
			}
		} else {
			switch(mEsv) {
			case ESV_SET_NO_RES: case ESV_SETI_SNA:
				addProperty(property);
				setEsv(ESV_SETI_SNA);
				break;
			case ESV_SET_RES: case ESV_SETC_SNA:
				addProperty(property);
				setEsv(ESV_SETC_SNA);
				break;
			case ESV_GET_RES: case ESV_GET_SNA:
				addProperty(property.epc);
				setEsv(ESV_GET_SNA);
				break;
			case ESV_INF: case ESV_INF_SNA:
				addProperty(property.epc);
				setEsv(ESV_INF_SNA);
				break;
			}
		}
	}
	
	public byte[] getFrameByteArray() {
		int propertyListSize = mPropertyList.size();
		if(propertyListSize > 255) {
			propertyListSize = 255;
		}
		int size = 12;
		for(int i = 0; i < propertyListSize; i++) {
			size += mPropertyList.get(i).size();
		}
		if(size > EchoSocket.UDP_MAX_PACKET_SIZE) return null;
		ByteBuffer buffer = ByteBuffer.allocate(size);
		buffer.order(ByteOrder.BIG_ENDIAN);
		
		buffer.put(EHD1);
		buffer.put(EHD2);
		buffer.putShort(mTID);
		buffer.put(EchoUtils.instanceToByteArray(mSeoj));
		buffer.put(EchoUtils.instanceToByteArray(mDeoj));
		buffer.put(mEsv);
		buffer.put((byte)propertyListSize);
		for(EchoProperty p : mPropertyList) {
			buffer.put(p.epc);
			buffer.put(p.pdc);
			if(p.edt != null)
				buffer.put(p.edt);
		}
		return buffer.array();
		
	}
	
}
