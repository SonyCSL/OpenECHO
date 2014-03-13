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
import java.io.IOException;
import java.io.InputStream;
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
	
	public static final int MIN_FRAME_SIZE = 12;
	
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
	private byte mESV;
	
	private short mSrcEchoClassCode;
	private byte mSrcEchoInstanceCode;
	private String mSrcEchoAddress;
	private short mDstEchoClassCode;
	private byte mDstEchoInstanceCode;
	private String mDstEchoAddress;
	
	protected List<EchoProperty> mPropertyList;
	


	public EchoFrame(short srcEchoClassCode, byte srcEchoInstanceCode
			, short dstEchoClassCode, byte dstEchoInstanceCode
			, String dstEchoAddress, byte esv) {
		// send frame
		mSrcEchoClassCode = srcEchoClassCode;
		mSrcEchoInstanceCode = srcEchoInstanceCode;
		
		mSrcEchoAddress = EchoSocket.SELF_ADDRESS;
		mDstEchoClassCode = dstEchoClassCode;
		mDstEchoInstanceCode = dstEchoInstanceCode;
		mDstEchoAddress = dstEchoAddress;
		
		mESV = esv;
		
		mTID = 0;
		
		mPropertyList = new ArrayList<EchoProperty>();
	}
	
	// This constructor may create invalid EchoFrame.
	public EchoFrame(String srcEchoAddress, byte[] data) {
		// receive frame
		mSrcEchoAddress = srcEchoAddress;
		mDstEchoAddress = EchoSocket.SELF_ADDRESS;
		if(data.length < MIN_FRAME_SIZE) {return;}
		if(data[0] != EHD1) return;
		if(data[1] != EHD2) return;
		ByteBuffer buffer = ByteBuffer.allocate(2);
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.put(data[2]);
		buffer.put(data[3]);
		mTID = buffer.getShort(0);
		//Echo.putProxy(address, data[4], data[5], data[6]);
		//Echo.updateNodeInstance(address, data[4], data[5], data[6]);
		//mSeoj = Echo.getInstance(address, data[4], data[5], data[6]);
		//mDeoj = Echo.getInstance(Echo.getNode().getAddress(), 
		//		data[7], data[8], data[9]);
		buffer = ByteBuffer.allocate(2);
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.put(data[4]);
		buffer.put(data[5]);
		mSrcEchoClassCode = buffer.getShort(0);
		mSrcEchoInstanceCode = data[6];
		buffer = ByteBuffer.allocate(2);
		buffer.order(ByteOrder.BIG_ENDIAN);
		buffer.put(data[7]);
		buffer.put(data[8]);
		mDstEchoClassCode = buffer.getShort(0);
		mDstEchoInstanceCode = data[9];
		mESV = data[10];
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
	
	public static EchoFrame getEchoFrameFromStream(String srcEchoAddress, DataInputStream in) throws IOException {
		

		byte ehd1 =  in.readByte();
		byte ehd2 = in.readByte();
		if(ehd1 == EHD1 && ehd2 == EHD2) {
		} else {
			return null;
		}
		ArrayList<Byte> data = new ArrayList<Byte>();
		data.add(EHD1); data.add(EHD2);
		for(int i = 0; i < 10; i++) {
			data.add(in.readByte());
		}
		int propertyListSize = data.get(11) & 0xFF;
		for(int i = 0; i < propertyListSize; i++) {
			data.add(in.readByte()); // epc
			int pdc = in.readUnsignedByte();
			data.add((byte)pdc);
			for(int j = 0; j < pdc; j++) {
				data.add(in.readByte());
			}
		}
		byte[] b = new byte[data.size()];
		for(int i = 0; i < data.size(); i++) {
			b[i] = data.get(i);
		}
		EchoFrame frame = new EchoFrame(srcEchoAddress, b);
		return frame;
		
	}
	
	protected EchoFrame(short srcEchoClassCode, byte srcEchoInstanceCode,
			String srcEchoAddress
			, short dstEchoClassCode, byte dstEchoInstanceCode
			, String dstEchoAddress, byte esv, short tid, List<EchoProperty> propertyList) {
		
		// copy

		mSrcEchoClassCode = srcEchoClassCode;
		mSrcEchoInstanceCode = srcEchoInstanceCode;
		mSrcEchoAddress = srcEchoAddress;
		mDstEchoClassCode = dstEchoClassCode;
		mDstEchoInstanceCode = dstEchoInstanceCode;
		mDstEchoAddress = dstEchoAddress;
		
		mESV = esv;
		
		mTID = tid;
		
		mPropertyList = new ArrayList<EchoProperty>();
		for(EchoProperty property : propertyList) {
			mPropertyList.add(property.copy());
		}
	}
	
	public void setTID(short tid) {
		mTID = tid;
	}
	
	public short getTID() {
		return mTID;
	}

	public byte getESV() {
		return mESV;
	}
	
	public short getSrcEchoClassCode() {
		return mSrcEchoClassCode;
	}
	
	public byte getSrcEchoInstanceCode() {
		return mSrcEchoInstanceCode;
	}
	
	public String getSrcEchoAddress() {
		return mSrcEchoAddress;
	}

	public short getDstEchoClassCode() {
		return mDstEchoClassCode;
	}
	
	public void setDstEchoInstanceCode(byte dstEchoInstanceCode) {
		mDstEchoInstanceCode = dstEchoInstanceCode;
	}
	
	public byte getDstEchoInstanceCode() {
		return mDstEchoInstanceCode;
	}
	
	public void setDstEchoAddress(String dstEchoAddress) {
		mDstEchoAddress = dstEchoAddress;
	}
	
	public String getDstEchoAddress() {
		return mDstEchoAddress;
	}
	
	public List<EchoProperty> getPropertyList() {
		return mPropertyList;
	}
	
	public EchoProperty[] getProperties() {
		return mPropertyList.toArray(new EchoProperty[]{});
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
		//if(size > Echo.UDP_MAX_PACKET_SIZE) return null;
		ByteBuffer buffer = ByteBuffer.allocate(size);
		buffer.order(ByteOrder.BIG_ENDIAN);
		
		buffer.put(EHD1);
		buffer.put(EHD2);
		buffer.putShort(mTID);
		buffer.putShort(mSrcEchoClassCode);
		buffer.put(mSrcEchoInstanceCode);
		buffer.putShort(mDstEchoClassCode);
		buffer.put(mDstEchoInstanceCode);
		buffer.put(mESV);
		buffer.put((byte)propertyListSize);
		for(EchoProperty p : mPropertyList) {
			buffer.put(p.epc);
			buffer.put(p.pdc);
			if(p.edt != null)
				buffer.put(p.edt);
		}
		return buffer.array();
		
	}
	
	
	public void addPropertyForResponse(byte epc) {
		addPropertyForResponse(epc, null);
	}
	
	public void addPropertyForResponse(byte epc, byte[] edt) {
		EchoProperty property = new EchoProperty(epc, edt);
		addPropertyForResponse(property);
	}
	
	public void addPropertyForResponse(EchoProperty property) {
		mPropertyList.add(property);
		switch(mESV) {
		case ESV_SET_NO_RES: case ESV_SETI_SNA:
			if(property.pdc != 0) {
				mESV = ESV_SETI_SNA;
			}
			break;
		case ESV_SET_RES: case ESV_SETC_SNA:
			if(property.pdc != 0) {
				mESV = ESV_SETC_SNA;
			}
			break;
		case ESV_GET_RES: case ESV_GET_SNA:
			if(property.pdc == 0) {
				mESV = ESV_GET_SNA;
			}
			break;
		case ESV_INF: case ESV_INF_SNA:
			if(property.pdc == 0) {
				mESV = ESV_INF_SNA;
			}
			break;
		}
	}
	
	// TODO:checking valid or not improvement.
	public boolean isValid(){
		return mPropertyList != null;
	}
	
	public void addProperty(EchoProperty property) {
		mPropertyList.add(property);
	}
	
	public EchoFrame copy() { 
		EchoFrame ret = new EchoFrame(mSrcEchoClassCode, mSrcEchoInstanceCode
				,mSrcEchoAddress
				, mDstEchoClassCode, mDstEchoInstanceCode
				, mDstEchoAddress, mESV, mTID, mPropertyList);
		return ret;
	}
	
	@Override
	public String toString(){
		return "class:"+getSrcEchoClassCode()+"(i:"+getSrcEchoInstanceCode()+
				"["+getSrcEchoAddress()+"]" + "->" +
				"class:"+getDstEchoClassCode()+"(i:"+getDstEchoInstanceCode()
				+"["+getDstEchoAddress()+"] epv:"+ getESV() + " tid:" + getTID();
		
	}
	
}
