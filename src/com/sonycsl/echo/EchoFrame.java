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



/**
 * 
 * ECHONET Liteの電文(フレーム)を作るクラス
 *
 */
public final class EchoFrame {
	
	protected static final byte EHD1 = 0x10;
	protected static final byte EHD2 = (byte)0x81; 

	protected short mTID;
	protected EchoObject mSeoj;
	protected EchoObject mDeoj;
	protected byte mEsv;
	
	protected List<Property> mPropertyList;
	
	


	public EchoFrame(short tid, EchoObject seoj, EchoObject deoj, byte esv) {
		mTID = tid;
		mSeoj = seoj;
		mDeoj = deoj;
		mEsv = esv;
		
		mPropertyList = new ArrayList<Property>();
		
	}
	
	public EchoFrame(InetAddress address, byte[] data) {
		Echo echo = Echo.getEcho();
		if(data.length < 11) return;
		if(data[0] != EHD1) return;
		if(data[1] != EHD2) return;
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.put(data[2]);
		buffer.put(data[3]);
		mTID = buffer.getShort(0);
		echo.putProxy(address, data[4], data[5], data[6]);
		mSeoj = echo.getInstance(address, data[4], data[5], data[6]);
		mDeoj = echo.getInstance(Echo.getEcho().getNode().getAddress(), 
				data[7], data[8], data[9]);
		mEsv = data[10];
		int size = data[11] & 0xFF;
		mPropertyList = new ArrayList<Property>();
		for(int i = 0, j = 12; i < size; i++) {
			if(data.length == j) return;
			Property p = new Property();
			p.epc = data[j];
			j++;
			if(data.length == j) return;
			p.pdc = data[j];
			j++;
			if(p.pdc == 0) {
				p.edt = null;
			} else {
				if(data.length < j+(p.pdc & 0xFF)) return;
				p.edt = new byte[p.pdc];
				System.arraycopy(data, j, p.edt, 0, p.pdc);
				j += (p.pdc & 0xFF);
			}
			mPropertyList.add(p);
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
	
	public Property[] getProperties() {
		return (Property[]) mPropertyList.toArray(new Property[]{});
	}
	
	public void addProperty(byte epc, byte pdc, byte[] edt) {
		Property prop = new Property();
		prop.epc = epc;
		prop.pdc = pdc;
		prop.edt = edt;
		mPropertyList.add(prop);
	}

	public void addProperty(byte epc, byte[] edt) {
		Property prop = new Property();
		prop.epc = epc;
		if(edt == null) {
			prop.pdc = (byte)0;
		} else {
			prop.pdc = (byte)edt.length;
		}
		prop.edt = edt;
		mPropertyList.add(prop);
	}
	
	public void addProperty(byte epc) {
		addProperty(epc, (byte)0, null);
	}
	
	
	public void addProperty(byte epc, byte[] edt, boolean success) {
		if(success) {
			switch(mEsv) {
			case EchoObject.ESV_SETI: case EchoObject.ESV_SETC:
				addProperty(epc, edt);
				break;
			case EchoObject.ESV_SET_NO_RES: case EchoObject.ESV_SETI_SNA:
			case EchoObject.ESV_SET_RES: case EchoObject.ESV_SETC_SNA:
				addProperty(epc);
				break;
			case EchoObject.ESV_GET_RES: case EchoObject.ESV_GET_SNA:
				addProperty(epc, edt);
				break;
			case EchoObject.ESV_INF: case EchoObject.ESV_INF_SNA:
				addProperty(epc, edt);
			case EchoObject.ESV_INFC:
				addProperty(epc, edt);
				break;
			}
		} else {
			switch(mEsv) {
			case EchoObject.ESV_SET_NO_RES: case EchoObject.ESV_SETI_SNA:
				addProperty(epc, edt);
				setEsv(EchoObject.ESV_SETI_SNA);
				break;
			case EchoObject.ESV_SET_RES: case EchoObject.ESV_SETC_SNA:
				addProperty(epc, edt);
				setEsv(EchoObject.ESV_SETC_SNA);
				break;
			case EchoObject.ESV_GET_RES: case EchoObject.ESV_GET_SNA:
				addProperty(epc);
				setEsv(EchoObject.ESV_GET_SNA);
				break;
			case EchoObject.ESV_INF: case EchoObject.ESV_INF_SNA:
				addProperty(epc);
				setEsv(EchoObject.ESV_INF_SNA);
				break;
			}
		}
	}
	
	public byte[] getFrameByteArray() {
		if(mPropertyList.size() > 255)return null;
		int size = 12;
		for(Property p : mPropertyList) {
			size += p.size();
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
		buffer.put((byte)mPropertyList.size());
		for(Property p : mPropertyList) {
			buffer.put(p.epc);
			buffer.put(p.pdc);
			if(p.edt != null)
				buffer.put(p.edt);
		}
		return buffer.array();
		
	}
	
	public static class Property {
		public byte epc;
		public byte pdc;
		public byte[] edt;

		public int size() {
			if(edt != null) return edt.length + 2;
			return 2;
		}
	}
	
}
