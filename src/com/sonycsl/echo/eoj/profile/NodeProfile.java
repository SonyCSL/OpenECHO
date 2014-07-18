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
package com.sonycsl.echo.eoj.profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.EchoUtils;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.eoj.profile.ProfileObject.Getter;
import com.sonycsl.echo.eoj.profile.ProfileObject.Informer;
import com.sonycsl.echo.eoj.profile.ProfileObject.Setter;
import com.sonycsl.echo.node.EchoNode;

public abstract class NodeProfile extends ProfileObject {
	@SuppressWarnings("unused")
	private static final String TAG = NodeProfile.class.getSimpleName();
	
	
	public static final short ECHO_CLASS_CODE = 0x0EF0;
	//public static final byte CLASS_GROUP_CODE = (byte)0x0E;
	//public static final byte CLASS_CODE = (byte)0xF0;
	public static final byte INSTANCE_CODE = (byte)0x01;
	public static final byte INSTANCE_CODE_TRANSMISSION_ONLY= 0x02;

	
	public static final byte EPC_OPERATING_STATUS = (byte)0x80;
	public static final byte EPC_VERSION_INFORMATION = (byte)0x82;
	public static final byte EPC_IDENTIFICATION_NUMBER = (byte)0x83;
	public static final byte EPC_FAULT_CONTENT = (byte)0x89;
	public static final byte EPC_UNIQUE_IDENTIFIER_DATA = (byte)0xBF;
	public static final byte EPC_NUMBER_OF_SELF_NODE_INSTANCES = (byte)0xD3;
	public static final byte EPC_NUMBER_OF_SELF_NODE_CLASSES = (byte)0xD4;
	public static final byte EPC_INSTANCE_LIST_NOTIFICATION = (byte)0xD5;
	public static final byte EPC_SELF_NODE_INSTANCE_LIST_S = (byte)0xD6;
	public static final byte EPC_SELF_NODE_CLASS_LIST = (byte)0xD7; 
	
	public static final byte[] EDT_VERSION_INFORMATION = {(byte)0x01, (byte)0x0A, (byte)0x01, (byte) 0x00};
	
	@Override
	public byte getInstanceCode() {
		return INSTANCE_CODE;
	}

	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}
	

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewNodeProfile(this);
	}
	
	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();

		addStatusChangeAnnouncementProperty(EPC_OPERATING_STATUS);
		addStatusChangeAnnouncementProperty(EPC_INSTANCE_LIST_NOTIFICATION);
		
		addSetProperty(EPC_UNIQUE_IDENTIFIER_DATA);

		addGetProperty(EPC_OPERATING_STATUS);
		addGetProperty(EPC_VERSION_INFORMATION);
		addGetProperty(EPC_IDENTIFICATION_NUMBER);
		addGetProperty(EPC_UNIQUE_IDENTIFIER_DATA);
		addGetProperty(EPC_NUMBER_OF_SELF_NODE_INSTANCES);
		addGetProperty(EPC_NUMBER_OF_SELF_NODE_CLASSES);
		//addGetProperty(EPC_INSTANCE_LIST_NOTIFICATION);
		addGetProperty(EPC_SELF_NODE_INSTANCE_LIST_S);
		addGetProperty(EPC_SELF_NODE_CLASS_LIST);
	}
	
	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_OPERATING_STATUS : return setOperatingStatus(property.edt);
		case EPC_UNIQUE_IDENTIFIER_DATA: return setUniqueIdentifierData(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_OPERATING_STATUS : return getOperatingStatus();
		case EPC_VERSION_INFORMATION : return getVersionInformation();
		case EPC_IDENTIFICATION_NUMBER : return getIdentificationNumber();
		case EPC_FAULT_CONTENT : return getFaultContent();
		case EPC_UNIQUE_IDENTIFIER_DATA : return getUniqueIdentifierData();
		case EPC_NUMBER_OF_SELF_NODE_INSTANCES : return getNumberOfSelfNodeInstances();
		case EPC_NUMBER_OF_SELF_NODE_CLASSES : return getNumberOfSelfNodeClasses();
		case EPC_INSTANCE_LIST_NOTIFICATION : return getInstanceListNotification();
		case EPC_SELF_NODE_INSTANCE_LIST_S : return getSelfNodeInstanceListS();
		case EPC_SELF_NODE_CLASS_LIST : return getSelfNodeClassList();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_OPERATING_STATUS : return isValidOperatingStatus(property.edt);
		case EPC_VERSION_INFORMATION : return isValidVersionInformation(property.edt);
		case EPC_IDENTIFICATION_NUMBER : return isValidIdentificationNumber(property.edt);
		case EPC_FAULT_CONTENT : return isValidFaultContent(property.edt);
		case EPC_UNIQUE_IDENTIFIER_DATA : return isValidUniqueIdentifierData(property.edt);
		case EPC_NUMBER_OF_SELF_NODE_INSTANCES : return isValidNumberOfSelfNodeInstances(property.edt);
		case EPC_NUMBER_OF_SELF_NODE_CLASSES : return isValidNumberOfSelfNodeClasses(property.edt);
		case EPC_INSTANCE_LIST_NOTIFICATION : return isValidInstanceListNotification(property.edt);
		case EPC_SELF_NODE_INSTANCE_LIST_S : return isValidSelfNodeInstanceListS(property.edt);
		case EPC_SELF_NODE_CLASS_LIST : return isValidSelfNodeClassList(property.edt);
		default : return false;
		}
	}
	
	/**
	 * Indicates node operating status.<br>
	 * <br>
	 * Booting = 0x30, not booting = 0x31<br>
	 * <br>
	 * Name : Operating status<br>
	 * EPC : 0x80<br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : mandatory<br>
	 * <br>
	 * Announcement at status change<br>
	 */
	protected boolean setOperatingStatus(byte[] edt) {
		return false;
	}
	/**
	 * Indicates node operating status.<br>
	 * <br>
	 * Booting = 0x30, not booting = 0x31<br>
	 * <br>
	 * Name : Operating status<br>
	 * EPC : 0x80<br>
	 * Data Type : unsigned char<br>
	 * Data Size(Byte) : 1<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : optional<br>
	 * Get : mandatory<br>
	 * <br>
	 * Announcement at status change<br>
	 */
	protected abstract byte[] getOperatingStatus();
	
	protected boolean isValidOperatingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	
	/**
	 * Indicates ECHONET Lite version<br>
	 * used by communication middleware and message types supported by communication middleware.<br>
	 * <br>
	 * 1st byte: Indicates major version number (digits to left of decimal point) in binary notation.<br>
	 * 2nd byte: Indicates minor version number (digits to right of decimal point) in binary notation.<br>
	 * 3rd and 4th bytes: Indicate message types with a bitmap.<br>
	 * <br>
	 * Name : Version information<br>
	 * EPC : 0x82<br>
	 * Data Type : unsigned char×4<br>
	 * Data Size(Byte) : 4<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected byte[] getVersionInformation(){return EDT_VERSION_INFORMATION;}
	
	protected boolean isValidVersionInformation(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	
	/**
	 * Number to identify the node implementing the device object in the domain.<br>
	 * <br>
	 * 1st byte: lower communication ID field<br>
	 * 0x01 to 0xFD：<br>
	 * Set arbitrarily for the protocol when the communication protocol used in the lower communication layer has a unique number. (not used in the ECHONET Lite Specification)<br>
	 * 0xFE:<br>
	 * Set 2 to 17 bytes in the manufacturer-specified format.<br>
	 * 0xFF:<br>
	 * Set 2 to 9 bytes when the protocol generated by random numbers is used in the lower communication layer.<br>
	 * 0x00:<br>
	 * Identification number is not set.<br>
	 * Over 2nd byte: unique number field<br>
	 * <br>
	 * Name : Identification number<br>
	 * EPC : 0x83<br>
	 * Data Type : unsigned char×9 or unsigned char × 17<br>
	 * Data Size(Byte) : 9 or 17<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected abstract byte[] getIdentificationNumber();

	protected boolean isValidIdentificationNumber(byte[] edt) {
		if(edt == null || !(edt.length == 9 || edt.length == 17)) return false;
		return true;
	}
	
	/**
	 * Fault content<br>
	 * <br>
	 * 0x0000-0x03E8 (0-1000)<br>
	 * <br>
	 * Name : Fault content<br>
	 * EPC : 0x89<br>
	 * Data Type : unsigned short<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : optional<br>
	 */
	protected byte[] getFaultContent() {
		return null;
	}

	protected boolean isValidFaultContent(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	
	/**
	 * Stipulated in 2 bytes<br>
	 * <br>
	 * See (3) below.<br>
	 * <br>
	 * Name : Unique identifier data<br>
	 * EPC : 0xBF<br>
	 * Data Type : unsigned short<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : mandatory<br>
	 * Get : mandatory<br>
	 */
	protected abstract boolean setUniqueIdentifierData(byte[] edt);
	
	
	/**
	 * Stipulated in 2 bytes<br>
	 * <br>
	 * See (3) below.<br>
	 * <br>
	 * Name : Unique identifier data<br>
	 * EPC : 0xBF<br>
	 * Data Type : unsigned short<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : mandatory<br>
	 * Get : mandatory<br>
	 */
	protected abstract byte[] getUniqueIdentifierData();

	protected boolean isValidUniqueIdentifierData(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	
	/**
	 * Total number of instances held by self-node<br>
	 * <br>
	 * 1st to 3rd bytes: Total number of instances<br>
	 * <br>
	 * Name : Number of self-node instances<br>
	 * EPC : 0xD3<br>
	 * Data Type : unsigned char×3<br>
	 * Data Size(Byte) : 3<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected byte[] getNumberOfSelfNodeInstances() {
		byte[] ret = new byte[3];
		int num = getNode().getDevices().length;
		
		ret[2] = (byte)(num & 0xFF);
		ret[1] = (byte)((num >> 8) & 0xFF);
		ret[0] = (byte)((num >> 16) & 0xFF);
		return ret;
	}

	protected boolean isValidNumberOfSelfNodeInstances(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	
	/**
	 * Total number of classes held by self-node<br>
	 * <br>
	 * 1st and 2nd bytes: Total number of classes<br>
	 * <br>
	 * Name : Number of self-node classes<br>
	 * EPC : 0xD4<br>
	 * Data Type : unsigned char×2<br>
	 * Data Size(Byte) : 2<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected byte[] getNumberOfSelfNodeClasses() {
		HashSet<Short> hashSet = new HashSet<Short>();
		DeviceObject[] devices = getNode().getDevices();
		for(DeviceObject d : devices) {
			hashSet.add(d.getEchoClassCode());
		}
		int size = hashSet.size() + 1;
		byte[] edt = new byte[2];
		edt[0] = (byte)((size >> 8) & 0xFF);
		edt[1] = (byte)(size & 0xFF);
		return edt;
	}

	protected boolean isValidNumberOfSelfNodeClasses(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	
	/**
	 * Instance list when self-node instance configuration is changed<br>
	 * <br>
	 * 1st byte: Number of notification instances<br>
	 * 2nd to 253rd bytes: ECHONET object codes (EOJ3 bytes) enumerated<br>
	 * <br>
	 * Name : Instance list notification<br>
	 * EPC : 0xD5<br>
	 * Data Type : unsigned char×(MAX) 253<br>
	 * Data Size(Byte) : Max.253<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : mandatory<br>
	 * Set : undefined<br>
	 * Get : undefined<br>
	 * <br>
	 * Announcement at status change<br>
	 */
	protected byte[] getInstanceListNotification() {
		// deviceの数がが85以上の場合電文を分ける．
		return EchoUtils.devicesToByteArray(getNode().getDevices(), 0);
	}

	protected boolean isValidInstanceListNotification(byte[] edt) {
		if(edt == null || !(edt.length <= 253)) return false;
		return true;
	}
	
	//public void InstanceListNotification() {
		
	//}
	
	/**
	 * Self-node instance list<br>
	 * <br>
	 * 1st byte: Total number of instances<br>
	 * 2nd to 253rd bytes: ECHONET object codes (EOJ3 bytes) enumerated<br>
	 * <br>
	 * Name : Self-node instance list S<br>
	 * EPC : 0xD6<br>
	 * Data Type : unsigned char×(MAX) 253<br>
	 * Data Size(Byte) : Max.253<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected byte[] getSelfNodeInstanceListS() {
		// deviceの数は85以上の場合，85番目以降は電文に載せない．
		//EchoUtils.devicesToByteArray(getNode().getDevices());
		return EchoUtils.devicesToByteArray(getNode().getDevices(), 0);
	}

	protected boolean isValidSelfNodeInstanceListS(byte[] edt) {
		if(edt == null || !(edt.length <= 253)) return false;
		return true;
	}

	/**
	 * Self-node class list<br>
	 * <br>
	 * 1st byte: Total number of classes<br>
	 * 2nd to 17th bytes: Class codes (EOJ high-order 2 bytes) enumerated<br>
	 * <br>
	 * Name : Self-node class list<br>
	 * EPC : 0xD7<br>
	 * Data Type : unsigned char×(MAX) 17<br>
	 * Data Size(Byte) : Max.17<br>
	 * <br>
	 * AccessRule<br>
	 * Announce : undefined<br>
	 * Set : undefined<br>
	 * Get : mandatory<br>
	 */
	protected byte[] getSelfNodeClassList() {

		HashSet<Short> hashSet = new HashSet<Short>();
		DeviceObject[] devices = getNode().getDevices();
		for(DeviceObject d : devices) {
			hashSet.add(d.getEchoClassCode());
		}
		int size = hashSet.size();
		int s = (size >= 9) ? 8 : size;
		byte[] edt = new byte[1+(s*2)];
		edt[0] = (byte)size;
		Iterator<Short> itr = hashSet.iterator();
		for(int i = 0; i < s; i++) {
			short echoClassCode = itr.next();
			edt[1+(i*2)] = (byte)((echoClassCode >> 8) & 0xFF);
			edt[2+(i*2)] = (byte)(echoClassCode & 0xFF);
		}
		return edt;
	}

	protected boolean isValidSelfNodeClassList(byte[] edt) {
		if(edt == null || !(edt.length <= 253)) return false;
		return true;
	}
	@Override
	public Setter set() {
		return set(true);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr(), responseRequired);
	}

	@Override
	public Getter get() {
		return new Getter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr());
	}

	@Override
	public Informer inform() {
		return inform(isSelfObject());
	}

	@Override
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


	@Override
	protected InformerC informC(String address) {
		return new InformerC(getEchoClassCode(), getInstanceCode()
				, address);
	}


	public static class Receiver extends ProfileObject.Receiver {
		

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_OPERATING_STATUS:
				onSetOperatingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_UNIQUE_IDENTIFIER_DATA:
				onSetUniqueIdentifierData(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}

		@Override
		protected boolean onGetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onGetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_OPERATING_STATUS:
				onGetOperatingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_VERSION_INFORMATION:
				onGetVersionInformation(eoj, tid, esv, property, success);
				return true;
			case EPC_IDENTIFICATION_NUMBER:
				onGetIdentificationNumber(eoj, tid, esv, property, success);
				return true;
			case EPC_FAULT_CONTENT:
				onGetFaultContent(eoj, tid, esv, property, success);
				return true;
			case EPC_UNIQUE_IDENTIFIER_DATA:
				onGetUniqueIdentifierData(eoj, tid, esv, property, success);
				return true;
			case EPC_NUMBER_OF_SELF_NODE_INSTANCES:
				onGetNumberOfSelfNodeInstances(eoj, tid, esv, property, success);
				return true;
			case EPC_NUMBER_OF_SELF_NODE_CLASSES:
				onGetNumberOfSelfNodeClasses(eoj, tid, esv, property, success);
				return true;
			case EPC_INSTANCE_LIST_NOTIFICATION:
				onGetInstanceListNotification(eoj, tid, esv, property, success);
				return true;
			case EPC_SELF_NODE_INSTANCE_LIST_S:
				onGetSelfNodeInstanceListS(eoj, tid, esv, property, success);
				return true;
			case EPC_SELF_NODE_CLASS_LIST:
				onGetSelfNodeClassList(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		@Override
		protected boolean onInformProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property) {
			boolean ret = super.onInformProperty(eoj, tid, esv, property);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_INSTANCE_LIST_NOTIFICATION:
				onInformInstanceListNotification(eoj, tid, esv, property);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Indicates node operating status.<br>
		 * <br>
		 * Booting = 0x30, not booting = 0x31<br>
		 * <br>
		 * Name : Operating status<br>
		 * EPC : 0x80<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * <br>
		 * Announcement at status change<br>
		 */
		protected void onSetOperatingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * Indicates node operating status.<br>
		 * <br>
		 * Booting = 0x30, not booting = 0x31<br>
		 * <br>
		 * Name : Operating status<br>
		 * EPC : 0x80<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * <br>
		 * Announcement at status change<br>
		 */
		protected void onGetOperatingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * Indicates ECHONET Lite version<br>
		 * used by communication middleware and message types supported by communication middleware.<br>
		 * <br>
		 * 1st byte: Indicates major version number (digits to left of decimal point) in binary notation.<br>
		 * 2nd byte: Indicates minor version number (digits to right of decimal point) in binary notation.<br>
		 * 3rd and 4th bytes: Indicate message types with a bitmap.<br>
		 * <br>
		 * Name : Version information<br>
		 * EPC : 0x82<br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		protected void onGetVersionInformation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * Number to identify the node implementing the device object in the domain.<br>
		 * <br>
		 * 1st byte: lower communication ID field<br>
		 * 0x01 to 0xFD：<br>
		 * Set arbitrarily for the protocol when the communication protocol used in the lower communication layer has a unique number. (not used in the ECHONET Lite Specification)<br>
		 * 0xFE:<br>
		 * Set 2 to 17 bytes in the manufacturer-specified format.<br>
		 * 0xFF:<br>
		 * Set 2 to 9 bytes when the protocol generated by random numbers is used in the lower communication layer.<br>
		 * 0x00:<br>
		 * Identification number is not set.<br>
		 * Over 2nd byte: unique number field<br>
		 * <br>
		 * Name : Identification number<br>
		 * EPC : 0x83<br>
		 * Data Type : unsigned char×9 or unsigned char × 17<br>
		 * Data Size(Byte) : 9 or 17<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		protected void onGetIdentificationNumber(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * Fault content<br>
		 * <br>
		 * 0x0000-0x03E8 (0-1000)<br>
		 * <br>
		 * Name : Fault content<br>
		 * EPC : 0x89<br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		protected void onGetFaultContent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * Stipulated in 2 bytes<br>
		 * <br>
		 * See (3) below.<br>
		 * <br>
		 * Name : Unique identifier data<br>
		 * EPC : 0xBF<br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 */
		protected void onSetUniqueIdentifierData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * Stipulated in 2 bytes<br>
		 * <br>
		 * See (3) below.<br>
		 * <br>
		 * Name : Unique identifier data<br>
		 * EPC : 0xBF<br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 */
		protected void onGetUniqueIdentifierData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * Total number of instances held by self-node<br>
		 * <br>
		 * 1st to 3rd bytes: Total number of instances<br>
		 * <br>
		 * Name : Number of self-node instances<br>
		 * EPC : 0xD3<br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		protected void onGetNumberOfSelfNodeInstances(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		
		/**
		 * Total number of classes held by self-node<br>
		 * <br>
		 * 1st and 2nd bytes: Total number of classes<br>
		 * <br>
		 * Name : Number of self-node classes<br>
		 * EPC : 0xD4<br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		protected void onGetNumberOfSelfNodeClasses(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

		/**
		 * Instance list when self-node instance configuration is changed<br>
		 * <br>
		 * 1st byte: Number of notification instances<br>
		 * 2nd to 253rd bytes: ECHONET object codes (EOJ3 bytes) enumerated<br>
		 * <br>
		 * Name : Instance list notification<br>
		 * EPC : 0xD5<br>
		 * Data Type : unsigned char×(MAX) 253<br>
		 * Data Size(Byte) : Max.253<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : mandatory<br>
		 * Set : undefined<br>
		 * Get : undefined<br>
		 * <br>
		 * Announcement at status change<br>
		 */
		protected void onGetInstanceListNotification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
		}
		
		/**
		 * Instance list when self-node instance configuration is changed<br>
		 * <br>
		 * 1st byte: Number of notification instances<br>
		 * 2nd to 253rd bytes: ECHONET object codes (EOJ3 bytes) enumerated<br>
		 * <br>
		 * Name : Instance list notification<br>
		 * EPC : 0xD5<br>
		 * Data Type : unsigned char×(MAX) 253<br>
		 * Data Size(Byte) : Max.253<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : mandatory<br>
		 * Set : undefined<br>
		 * Get : undefined<br>
		 * <br>
		 * Announcement at status change<br>
		 */
		protected void onInformInstanceListNotification(EchoObject eoj, short tid, byte esv, EchoProperty property) {}
		
		/**
		 * Self-node instance list<br>
		 * <br>
		 * 1st byte: Total number of instances<br>
		 * 2nd to 253rd bytes: ECHONET object codes (EOJ3 bytes) enumerated<br>
		 * <br>
		 * Name : Self-node instance list S<br>
		 * EPC : 0xD6<br>
		 * Data Type : unsigned char×(MAX) 253<br>
		 * Data Size(Byte) : Max.253<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		protected void onGetSelfNodeInstanceListS(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {
		}
		
		/**
		 * Self-node class list<br>
		 * <br>
		 * 1st byte: Total number of classes<br>
		 * 2nd to 17th bytes: Class codes (EOJ high-order 2 bytes) enumerated<br>
		 * <br>
		 * Name : Self-node class list<br>
		 * EPC : 0xD7<br>
		 * Data Type : unsigned char×(MAX) 17<br>
		 * Data Size(Byte) : Max.17<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		protected void onGetSelfNodeClassList(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}
	
	public static class Setter extends ProfileObject.Setter {

		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress, responseRequired);
		}
		
		@Override
		public Setter reqSetProperty(byte epc, byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
		}
		/**
		 * Indicates node operating status.<br>
		 * <br>
		 * Booting = 0x30, not booting = 0x31<br>
		 * <br>
		 * Name : Operating status<br>
		 * EPC : 0x80<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * <br>
		 * Announcement at status change<br>
		 */
		public Setter reqSetOperatingStatus(byte[] edt) {
			reqSetProperty(EPC_OPERATING_STATUS, edt);
			return this;
		}
		/**
		 * Stipulated in 2 bytes<br>
		 * <br>
		 * See (3) below.<br>
		 * <br>
		 * Name : Unique identifier data<br>
		 * EPC : 0xBF<br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 */
		public Setter reqSetUniqueIdentifierData(byte[] edt) {
			reqSetProperty(EPC_UNIQUE_IDENTIFIER_DATA, edt);
			return this;
		}
	}
	
	public static class Getter extends ProfileObject.Getter {
		public Getter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress);
		}
		@Override
		public Getter reqGetProperty(byte epc) {
			return (Getter)super.reqGetProperty(epc);
		}
		@Override
		public Getter reqGetFaultStatus() {
			return (Getter)super.reqGetFaultStatus();
		}
		@Override
		public Getter reqGetManufacturerCode() {
			return (Getter)super.reqGetManufacturerCode();
		}
		@Override
		public Getter reqGetPlaceOfBusinessCode() {
			return (Getter)super.reqGetPlaceOfBusinessCode();
		}
		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}
		@Override
		public Getter reqGetSerialNumber() {
			return (Getter)super.reqGetSerialNumber();
		}
		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
		}
		@Override
		public Getter reqGetStatusChangeAnnouncementPropertyMap() {
			return (Getter)super.reqGetStatusChangeAnnouncementPropertyMap();
		}
		@Override
		public Getter reqGetSetPropertyMap() {
			return (Getter)super.reqGetSetPropertyMap();
		}
		@Override
		public Getter reqGetGetPropertyMap() {
			return (Getter)super.reqGetGetPropertyMap();
		}
		
		/**
		 * Indicates node operating status.<br>
		 * <br>
		 * Booting = 0x30, not booting = 0x31<br>
		 * <br>
		 * Name : Operating status<br>
		 * EPC : 0x80<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * <br>
		 * Announcement at status change<br>
		 */
		public Getter reqGetOperatingStatus() {
			reqGetProperty(EPC_OPERATING_STATUS);
			return this;
		}
		/**
		 * Indicates ECHONET Lite version<br>
		 * used by communication middleware and message types supported by communication middleware.<br>
		 * <br>
		 * 1st byte: Indicates major version number (digits to left of decimal point) in binary notation.<br>
		 * 2nd byte: Indicates minor version number (digits to right of decimal point) in binary notation.<br>
		 * 3rd and 4th bytes: Indicate message types with a bitmap.<br>
		 * <br>
		 * Name : Version information<br>
		 * EPC : 0x82<br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Getter reqGetVersionInformation() {
			reqGetProperty(EPC_VERSION_INFORMATION);
			return this;
		}
		/**
		 * Number to identify the node implementing the device object in the domain.<br>
		 * <br>
		 * 1st byte: lower communication ID field<br>
		 * 0x01 to 0xFD：<br>
		 * Set arbitrarily for the protocol when the communication protocol used in the lower communication layer has a unique number. (not used in the ECHONET Lite Specification)<br>
		 * 0xFE:<br>
		 * Set 2 to 17 bytes in the manufacturer-specified format.<br>
		 * 0xFF:<br>
		 * Set 2 to 9 bytes when the protocol generated by random numbers is used in the lower communication layer.<br>
		 * 0x00:<br>
		 * Identification number is not set.<br>
		 * Over 2nd byte: unique number field<br>
		 * <br>
		 * Name : Identification number<br>
		 * EPC : 0x83<br>
		 * Data Type : unsigned char×9 or unsigned char × 17<br>
		 * Data Size(Byte) : 9 or 17<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Getter reqGetIdentificationNumber() {
			reqGetProperty(EPC_IDENTIFICATION_NUMBER);
			return this;
		}
		/**
		 * Fault content<br>
		 * <br>
		 * 0x0000-0x03E8 (0-1000)<br>
		 * <br>
		 * Name : Fault content<br>
		 * EPC : 0x89<br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Getter reqGetFaultContent() {
			reqGetProperty(EPC_FAULT_CONTENT);
			return this;
		}
		/**
		 * Stipulated in 2 bytes<br>
		 * <br>
		 * See (3) below.<br>
		 * <br>
		 * Name : Unique identifier data<br>
		 * EPC : 0xBF<br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 */
		public Getter reqGetUniqueIdentifierData() {
			reqGetProperty(EPC_UNIQUE_IDENTIFIER_DATA);
			return this;
		}
		/**
		 * Total number of instances held by self-node<br>
		 * <br>
		 * 1st to 3rd bytes: Total number of instances<br>
		 * <br>
		 * Name : Number of self-node instances<br>
		 * EPC : 0xD3<br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Getter reqGetNumberOfSelfNodeInstances() {
			reqGetProperty(EPC_NUMBER_OF_SELF_NODE_INSTANCES);
			return this;
		}
		/**
		 * Total number of classes held by self-node<br>
		 * <br>
		 * 1st and 2nd bytes: Total number of classes<br>
		 * <br>
		 * Name : Number of self-node classes<br>
		 * EPC : 0xD4<br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Getter reqGetNumberOfSelfNodeClasses() {
			reqGetProperty(EPC_NUMBER_OF_SELF_NODE_CLASSES);
			return this;
		}
		/**
		 * Self-node instance list<br>
		 * <br>
		 * 1st byte: Total number of instances<br>
		 * 2nd to 253rd bytes: ECHONET object codes (EOJ3 bytes) enumerated<br>
		 * <br>
		 * Name : Self-node instance list S<br>
		 * EPC : 0xD6<br>
		 * Data Type : unsigned char×(MAX) 253<br>
		 * Data Size(Byte) : Max.253<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Getter reqGetSelfNodeInstanceListS() {
			reqGetProperty(EPC_SELF_NODE_INSTANCE_LIST_S);
			return this;
		}
		/**
		 * Self-node class list<br>
		 * <br>
		 * 1st byte: Total number of classes<br>
		 * 2nd to 17th bytes: Class codes (EOJ high-order 2 bytes) enumerated<br>
		 * <br>
		 * Name : Self-node class list<br>
		 * EPC : 0xD7<br>
		 * Data Type : unsigned char×(MAX) 17<br>
		 * Data Size(Byte) : Max.17<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Getter reqGetSelfNodeClassList() {
			reqGetProperty(EPC_SELF_NODE_CLASS_LIST);
			return this;
		}
	}
	
	public static class Informer extends ProfileObject.Informer {

		//List<EchoFrame> mNotificationFrameList = null;
		//EchoObject mEoj;

		public Informer(short echoClassCode, byte echoInstanceCode
				, String dstEchoAddress, boolean isSelfObject) {
			super(echoClassCode, echoInstanceCode
					, dstEchoAddress, isSelfObject);
		}

		@Override
		public Informer reqInformProperty(byte epc) {
			return (Informer)super.reqInformProperty(epc);
		}
		
		@Override
		public Informer reqInformFaultStatus() {
			return (Informer)super.reqInformFaultStatus();
		}
		@Override
		public Informer reqInformManufacturerCode() {
			return (Informer)super.reqInformManufacturerCode();
		}
		@Override
		public Informer reqInformPlaceOfBusinessCode() {
			return (Informer)super.reqInformPlaceOfBusinessCode();
		}
		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}
		@Override
		public Informer reqInformSerialNumber() {
			return (Informer)super.reqInformSerialNumber();
		}
		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}
		@Override
		public Informer reqInformStatusChangeAnnouncementPropertyMap() {
			return (Informer)super.reqInformStatusChangeAnnouncementPropertyMap();
		}
		@Override
		public Informer reqInformSetPropertyMap() {
			return (Informer)super.reqInformSetPropertyMap();
		}
		@Override
		public Informer reqInformGetPropertyMap() {
			return (Informer)super.reqInformGetPropertyMap();
		}
		
		/**
		 * Indicates node operating status.<br>
		 * <br>
		 * Booting = 0x30, not booting = 0x31<br>
		 * <br>
		 * Name : Operating status<br>
		 * EPC : 0x80<br>
		 * Data Type : unsigned char<br>
		 * Data Size(Byte) : 1<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : optional<br>
		 * Get : mandatory<br>
		 * <br>
		 * Announcement at status change<br>
		 */
		public Informer reqInformOperatingStatus() {
			reqInformProperty(EPC_OPERATING_STATUS);
			return this;
		}
		/**
		 * Indicates ECHONET Lite version<br>
		 * used by communication middleware and message types supported by communication middleware.<br>
		 * <br>
		 * 1st byte: Indicates major version number (digits to left of decimal point) in binary notation.<br>
		 * 2nd byte: Indicates minor version number (digits to right of decimal point) in binary notation.<br>
		 * 3rd and 4th bytes: Indicate message types with a bitmap.<br>
		 * <br>
		 * Name : Version information<br>
		 * EPC : 0x82<br>
		 * Data Type : unsigned char×4<br>
		 * Data Size(Byte) : 4<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Informer reqInformVersionInformation() {
			reqInformProperty(EPC_VERSION_INFORMATION);
			return this;
		}
		/**
		 * Number to identify the node implementing the device object in the domain.<br>
		 * <br>
		 * 1st byte: lower communication ID field<br>
		 * 0x01 to 0xFD：<br>
		 * Set arbitrarily for the protocol when the communication protocol used in the lower communication layer has a unique number. (not used in the ECHONET Lite Specification)<br>
		 * 0xFE:<br>
		 * Set 2 to 17 bytes in the manufacturer-specified format.<br>
		 * 0xFF:<br>
		 * Set 2 to 9 bytes when the protocol generated by random numbers is used in the lower communication layer.<br>
		 * 0x00:<br>
		 * Identification number is not set.<br>
		 * Over 2nd byte: unique number field<br>
		 * <br>
		 * Name : Identification number<br>
		 * EPC : 0x83<br>
		 * Data Type : unsigned char×9 or unsigned char × 17<br>
		 * Data Size(Byte) : 9 or 17<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Informer reqInformIdentificationNumber() {
			reqInformProperty(EPC_IDENTIFICATION_NUMBER);
			return this;
		}
		/**
		 * Fault content<br>
		 * <br>
		 * 0x0000-0x03E8 (0-1000)<br>
		 * <br>
		 * Name : Fault content<br>
		 * EPC : 0x89<br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : optional<br>
		 */
		public Informer reqInformFaultContent() {
			reqInformProperty(EPC_FAULT_CONTENT);
			return this;
		}
		/**
		 * Stipulated in 2 bytes<br>
		 * <br>
		 * See (3) below.<br>
		 * <br>
		 * Name : Unique identifier data<br>
		 * EPC : 0xBF<br>
		 * Data Type : unsigned short<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : mandatory<br>
		 * Get : mandatory<br>
		 */
		public Informer reqInformUniqueIdentifierData() {
			reqInformProperty(EPC_UNIQUE_IDENTIFIER_DATA);
			return this;
		}
		/**
		 * Total number of instances held by self-node<br>
		 * <br>
		 * 1st to 3rd bytes: Total number of instances<br>
		 * <br>
		 * Name : Number of self-node instances<br>
		 * EPC : 0xD3<br>
		 * Data Type : unsigned char×3<br>
		 * Data Size(Byte) : 3<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Informer reqInformNumberOfSelfNodeInstances() {
			reqInformProperty(EPC_NUMBER_OF_SELF_NODE_INSTANCES);
			return this;
		}
		/**
		 * Total number of classes held by self-node<br>
		 * <br>
		 * 1st and 2nd bytes: Total number of classes<br>
		 * <br>
		 * Name : Number of self-node classes<br>
		 * EPC : 0xD4<br>
		 * Data Type : unsigned char×2<br>
		 * Data Size(Byte) : 2<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Informer reqInformNumberOfSelfNodeClasses() {
			reqInformProperty(EPC_NUMBER_OF_SELF_NODE_CLASSES);
			return this;
		}
		/**
		 * Instance list when self-node instance configuration is changed<br>
		 * <br>
		 * 1st byte: Number of notification instances<br>
		 * 2nd to 253rd bytes: ECHONET object codes (EOJ3 bytes) enumerated<br>
		 * <br>
		 * Name : Instance list notification<br>
		 * EPC : 0xD5<br>
		 * Data Type : unsigned char×(MAX) 253<br>
		 * Data Size(Byte) : Max.253<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : mandatory<br>
		 * Set : undefined<br>
		 * Get : undefined<br>
		 * <br>
		 * Announcement at status change<br>
		 */
		public Informer reqInformInstanceListNotification() {
			reqInformProperty(EPC_INSTANCE_LIST_NOTIFICATION);
			return this;
		}
		/**
		 * Self-node instance list<br>
		 * <br>
		 * 1st byte: Total number of instances<br>
		 * 2nd to 253rd bytes: ECHONET object codes (EOJ3 bytes) enumerated<br>
		 * <br>
		 * Name : Self-node instance list S<br>
		 * EPC : 0xD6<br>
		 * Data Type : unsigned char×(MAX) 253<br>
		 * Data Size(Byte) : Max.253<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Informer reqInformSelfNodeInstanceListS() {
			reqInformProperty(EPC_SELF_NODE_INSTANCE_LIST_S);
			return this;
		}
		/**
		 * Self-node class list<br>
		 * <br>
		 * 1st byte: Total number of classes<br>
		 * 2nd to 17th bytes: Class codes (EOJ high-order 2 bytes) enumerated<br>
		 * <br>
		 * Name : Self-node class list<br>
		 * EPC : 0xD7<br>
		 * Data Type : unsigned char×(MAX) 17<br>
		 * Data Size(Byte) : Max.17<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : undefined<br>
		 * Set : undefined<br>
		 * Get : mandatory<br>
		 */
		public Informer reqInformSelfNodeClassList() {
			reqInformProperty(EPC_SELF_NODE_CLASS_LIST);
			return this;
		}
	}
	
	public static class InformerC extends EchoObject.InformerC {
		public InformerC(short srcEchoClassCode, byte srcEchoInstanceCode
				, String dstEchoAddress) {
			super(srcEchoClassCode, srcEchoInstanceCode
					, dstEchoAddress);
		}

		/**
		 * Instance list when self-node instance configuration is changed<br>
		 * <br>
		 * 1st byte: Number of notification instances<br>
		 * 2nd to 253rd bytes: ECHONET object codes (EOJ3 bytes) enumerated<br>
		 * <br>
		 * Name : Instance list notification<br>
		 * EPC : 0xD5<br>
		 * Data Type : unsigned char×(MAX) 253<br>
		 * Data Size(Byte) : Max.253<br>
		 * <br>
		 * AccessRule<br>
		 * Announce : mandatory<br>
		 * Set : undefined<br>
		 * Get : undefined<br>
		 * <br>
		 * Announcement at status change<br>
		 */
		public InformerC informInstanceListNotification() {
			reqInformProperty(EPC_INSTANCE_LIST_NOTIFICATION);
			return this;
		}
		
	}
	
	public static class Proxy extends NodeProfile {
		
		private byte mEchoInstanceCode = INSTANCE_CODE;
		
		public void setInstanceCode(byte echoInstanceCode) {
			mEchoInstanceCode = echoInstanceCode;
		}
		
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}

		@Override
		protected byte[] getOperatingStatus() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected byte[] getVersionInformation() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected byte[] getIdentificationNumber() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected boolean setUniqueIdentifierData(byte[] edt) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		protected byte[] getUniqueIdentifierData() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected byte[] getManufacturerCode() {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	public static Setter setG() {
		return setG(true);
	}

	public static Setter setG(boolean responseRequired) {
		return new Setter(ECHO_CLASS_CODE, INSTANCE_CODE
				, EchoSocket.MULTICAST_ADDRESS, responseRequired);
	}

	public static Getter getG() {
		return new Getter(ECHO_CLASS_CODE, INSTANCE_CODE
				, EchoSocket.MULTICAST_ADDRESS);
	}

	public static Informer informG() {
		return new Informer(ECHO_CLASS_CODE, INSTANCE_CODE
				, EchoSocket.MULTICAST_ADDRESS, false);
	}
}
