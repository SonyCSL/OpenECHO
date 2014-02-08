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
package com.sonycsl.echo.eoj.device.housingfacilities;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class ElectricShutter extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0261;

	public static final byte EPC_OPEN_CLOSE_SETTING1 = (byte)0xE0;
	public static final byte EPC_EXTENT_OF_OPENING1 = (byte)0xE1;
	public static final byte EPC_BLIND_ANGLE_SETTING = (byte)0xE2;
	public static final byte EPC_SHUTTER_SPEED = (byte)0xE3;
	public static final byte EPC_EXTENT_OF_OPENING2 = (byte)0xE4;
	public static final byte EPC_ELECTRIC_LOCK_SETTING = (byte)0xE5;
	public static final byte EPC_OPEN_CLOSE_SETTING2 = (byte)0xE7;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addStatusChangeAnnouncementProperty(EPC_OPEN_CLOSE_SETTING1);
		addSetProperty(EPC_OPEN_CLOSE_SETTING1);
		addGetProperty(EPC_OPEN_CLOSE_SETTING1);
		addStatusChangeAnnouncementProperty(EPC_OPEN_CLOSE_SETTING2);
		addSetProperty(EPC_OPEN_CLOSE_SETTING2);
		addGetProperty(EPC_OPEN_CLOSE_SETTING2);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewElectricShutter(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Open/close setting 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Open(ed)/close(d)/stop(ped)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOpenCloseSetting1(byte[] edt);
	/**
	 * Property name : Open/close setting 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Open(ed)/close(d)/stop(ped)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOpenCloseSetting1();
	/**
	 * Property name : Open/close setting 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Open(ed)/close(d)/stop(ped)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOpenCloseSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Extent of opening 1<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setExtentOfOpening1(byte[] edt) {return false;}
	/**
	 * Property name : Extent of opening 1<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getExtentOfOpening1() {return null;}
	/**
	 * Property name : Extent of opening 1<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidExtentOfOpening1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Blind angle setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Blind angle<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xB4 (0.180°)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : deg<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBlindAngleSetting(byte[] edt) {return false;}
	/**
	 * Property name : Blind angle setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Blind angle<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xB4 (0.180°)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : deg<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBlindAngleSetting() {return null;}
	/**
	 * Property name : Blind angle setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Blind angle<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xB4 (0.180°)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : deg<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBlindAngleSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Shutter speed<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Low/medium/high<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Low = 0x41, medium = 0x42, high = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setShutterSpeed(byte[] edt) {return false;}
	/**
	 * Property name : Shutter speed<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Low/medium/high<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Low = 0x41, medium = 0x42, high = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getShutterSpeed() {return null;}
	/**
	 * Property name : Shutter speed<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Low/medium/high<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Low = 0x41, medium = 0x42, high = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidShutterSpeed(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Extent of opening 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xFF (0.255)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setExtentOfOpening2(byte[] edt) {return false;}
	/**
	 * Property name : Extent of opening 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xFF (0.255)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getExtentOfOpening2() {return null;}
	/**
	 * Property name : Extent of opening 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xFF (0.255)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidExtentOfOpening2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Electric lock setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Activated = 0x41, deactivated = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setElectricLockSetting(byte[] edt) {return false;}
	/**
	 * Property name : Electric lock setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Activated = 0x41, deactivated = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getElectricLockSetting() {return null;}
	/**
	 * Property name : Electric lock setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Activated = 0x41, deactivated = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidElectricLockSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Open/close setting 2<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Open/close<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, close = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOpenCloseSetting2(byte[] edt);
	/**
	 * Property name : Open/close setting 2<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Open/close<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, close = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOpenCloseSetting2();
	/**
	 * Property name : Open/close setting 2<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Open/close<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, close = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOpenCloseSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_OPEN_CLOSE_SETTING1 : return setOpenCloseSetting1(property.edt);
		case EPC_EXTENT_OF_OPENING1 : return setExtentOfOpening1(property.edt);
		case EPC_BLIND_ANGLE_SETTING : return setBlindAngleSetting(property.edt);
		case EPC_SHUTTER_SPEED : return setShutterSpeed(property.edt);
		case EPC_EXTENT_OF_OPENING2 : return setExtentOfOpening2(property.edt);
		case EPC_ELECTRIC_LOCK_SETTING : return setElectricLockSetting(property.edt);
		case EPC_OPEN_CLOSE_SETTING2 : return setOpenCloseSetting2(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_OPEN_CLOSE_SETTING1 : return getOpenCloseSetting1();
		case EPC_EXTENT_OF_OPENING1 : return getExtentOfOpening1();
		case EPC_BLIND_ANGLE_SETTING : return getBlindAngleSetting();
		case EPC_SHUTTER_SPEED : return getShutterSpeed();
		case EPC_EXTENT_OF_OPENING2 : return getExtentOfOpening2();
		case EPC_ELECTRIC_LOCK_SETTING : return getElectricLockSetting();
		case EPC_OPEN_CLOSE_SETTING2 : return getOpenCloseSetting2();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_OPEN_CLOSE_SETTING1 : return isValidOpenCloseSetting1(property.edt);
		case EPC_EXTENT_OF_OPENING1 : return isValidExtentOfOpening1(property.edt);
		case EPC_BLIND_ANGLE_SETTING : return isValidBlindAngleSetting(property.edt);
		case EPC_SHUTTER_SPEED : return isValidShutterSpeed(property.edt);
		case EPC_EXTENT_OF_OPENING2 : return isValidExtentOfOpening2(property.edt);
		case EPC_ELECTRIC_LOCK_SETTING : return isValidElectricLockSetting(property.edt);
		case EPC_OPEN_CLOSE_SETTING2 : return isValidOpenCloseSetting2(property.edt);
		default : return false;
		}
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
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_OPEN_CLOSE_SETTING1 : 
				onSetOpenCloseSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_EXTENT_OF_OPENING1 : 
				onSetExtentOfOpening1(eoj, tid, esv, property, success);
				return true;
			case EPC_BLIND_ANGLE_SETTING : 
				onSetBlindAngleSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SHUTTER_SPEED : 
				onSetShutterSpeed(eoj, tid, esv, property, success);
				return true;
			case EPC_EXTENT_OF_OPENING2 : 
				onSetExtentOfOpening2(eoj, tid, esv, property, success);
				return true;
			case EPC_ELECTRIC_LOCK_SETTING : 
				onSetElectricLockSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OPEN_CLOSE_SETTING2 : 
				onSetOpenCloseSetting2(eoj, tid, esv, property, success);
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
			case EPC_OPEN_CLOSE_SETTING1 : 
				onGetOpenCloseSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_EXTENT_OF_OPENING1 : 
				onGetExtentOfOpening1(eoj, tid, esv, property, success);
				return true;
			case EPC_BLIND_ANGLE_SETTING : 
				onGetBlindAngleSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SHUTTER_SPEED : 
				onGetShutterSpeed(eoj, tid, esv, property, success);
				return true;
			case EPC_EXTENT_OF_OPENING2 : 
				onGetExtentOfOpening2(eoj, tid, esv, property, success);
				return true;
			case EPC_ELECTRIC_LOCK_SETTING : 
				onGetElectricLockSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OPEN_CLOSE_SETTING2 : 
				onGetOpenCloseSetting2(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Open/close setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open(ed)/close(d)/stop(ped)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOpenCloseSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Open/close setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open(ed)/close(d)/stop(ped)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOpenCloseSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Extent of opening 1<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetExtentOfOpening1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Extent of opening 1<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetExtentOfOpening1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Blind angle setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Blind angle<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xB4 (0.180°)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : deg<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBlindAngleSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Blind angle setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Blind angle<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xB4 (0.180°)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : deg<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBlindAngleSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Shutter speed<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Low/medium/high<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Low = 0x41, medium = 0x42, high = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetShutterSpeed(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Shutter speed<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Low/medium/high<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Low = 0x41, medium = 0x42, high = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetShutterSpeed(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Extent of opening 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFF (0.255)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetExtentOfOpening2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Extent of opening 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFF (0.255)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetExtentOfOpening2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Electric lock setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Activated = 0x41, deactivated = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetElectricLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Electric lock setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Activated = 0x41, deactivated = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetElectricLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Open/close setting 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, close = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOpenCloseSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Open/close setting 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, close = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOpenCloseSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress, responseRequired);
		}
		
		@Override
		public Setter reqSetProperty(byte epc, byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
		}
		
		@Override
		public Setter reqSetOperationStatus(byte[] edt) {
			return (Setter)super.reqSetOperationStatus(edt);
		}
		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}
		@Override
		public Setter reqSetCurrentLimitSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimitSetting(edt);
		}
		@Override
		public Setter reqSetPowerSavingOperationSetting(byte[] edt) {
			return (Setter)super.reqSetPowerSavingOperationSetting(edt);
		}
		@Override
		public Setter reqSetRemoteControlSetting(byte[] edt) {
			return (Setter)super.reqSetRemoteControlSetting(edt);
		}
		@Override
		public Setter reqSetCurrentTimeSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentTimeSetting(edt);
		}
		@Override
		public Setter reqSetCurrentDateSetting(byte[] edt) {
			return (Setter)super.reqSetCurrentDateSetting(edt);
		}
		@Override
		public Setter reqSetPowerLimitSetting(byte[] edt) {
			return (Setter)super.reqSetPowerLimitSetting(edt);
		}
		
		/**
		 * Property name : Open/close setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open(ed)/close(d)/stop(ped)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOpenCloseSetting1(byte[] edt) {
			reqSetProperty(EPC_OPEN_CLOSE_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Extent of opening 1<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetExtentOfOpening1(byte[] edt) {
			reqSetProperty(EPC_EXTENT_OF_OPENING1, edt);
			return this;
		}
		/**
		 * Property name : Blind angle setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Blind angle<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xB4 (0.180°)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : deg<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBlindAngleSetting(byte[] edt) {
			reqSetProperty(EPC_BLIND_ANGLE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Shutter speed<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Low/medium/high<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Low = 0x41, medium = 0x42, high = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetShutterSpeed(byte[] edt) {
			reqSetProperty(EPC_SHUTTER_SPEED, edt);
			return this;
		}
		/**
		 * Property name : Extent of opening 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFF (0.255)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetExtentOfOpening2(byte[] edt) {
			reqSetProperty(EPC_EXTENT_OF_OPENING2, edt);
			return this;
		}
		/**
		 * Property name : Electric lock setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Activated = 0x41, deactivated = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetElectricLockSetting(byte[] edt) {
			reqSetProperty(EPC_ELECTRIC_LOCK_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Open/close setting 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, close = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOpenCloseSetting2(byte[] edt) {
			reqSetProperty(EPC_OPEN_CLOSE_SETTING2, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
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
		public Getter reqGetOperationStatus() {
			return (Getter)super.reqGetOperationStatus();
		}
		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}
		@Override
		public Getter reqGetStandardVersionInformation() {
			return (Getter)super.reqGetStandardVersionInformation();
		}
		@Override
		public Getter reqGetIdentificationNumber() {
			return (Getter)super.reqGetIdentificationNumber();
		}
		@Override
		public Getter reqGetMeasuredInstantaneousPowerConsumption() {
			return (Getter)super.reqGetMeasuredInstantaneousPowerConsumption();
		}
		@Override
		public Getter reqGetMeasuredCumulativePowerConsumption() {
			return (Getter)super.reqGetMeasuredCumulativePowerConsumption();
		}
		@Override
		public Getter reqGetManufacturersFaultCode() {
			return (Getter)super.reqGetManufacturersFaultCode();
		}
		@Override
		public Getter reqGetCurrentLimitSetting() {
			return (Getter)super.reqGetCurrentLimitSetting();
		}
		@Override
		public Getter reqGetFaultStatus() {
			return (Getter)super.reqGetFaultStatus();
		}
		@Override
		public Getter reqGetFaultDescription() {
			return (Getter)super.reqGetFaultDescription();
		}
		@Override
		public Getter reqGetManufacturerCode() {
			return (Getter)super.reqGetManufacturerCode();
		}
		@Override
		public Getter reqGetBusinessFacilityCode() {
			return (Getter)super.reqGetBusinessFacilityCode();
		}
		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}
		@Override
		public Getter reqGetProductionNumber() {
			return (Getter)super.reqGetProductionNumber();
		}
		@Override
		public Getter reqGetProductionDate() {
			return (Getter)super.reqGetProductionDate();
		}
		@Override
		public Getter reqGetPowerSavingOperationSetting() {
			return (Getter)super.reqGetPowerSavingOperationSetting();
		}
		@Override
		public Getter reqGetRemoteControlSetting() {
			return (Getter)super.reqGetRemoteControlSetting();
		}
		@Override
		public Getter reqGetCurrentTimeSetting() {
			return (Getter)super.reqGetCurrentTimeSetting();
		}
		@Override
		public Getter reqGetCurrentDateSetting() {
			return (Getter)super.reqGetCurrentDateSetting();
		}
		@Override
		public Getter reqGetPowerLimitSetting() {
			return (Getter)super.reqGetPowerLimitSetting();
		}
		@Override
		public Getter reqGetCumulativeOperatingTime() {
			return (Getter)super.reqGetCumulativeOperatingTime();
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
		 * Property name : Open/close setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open(ed)/close(d)/stop(ped)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOpenCloseSetting1() {
			reqGetProperty(EPC_OPEN_CLOSE_SETTING1);
			return this;
		}
		/**
		 * Property name : Extent of opening 1<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetExtentOfOpening1() {
			reqGetProperty(EPC_EXTENT_OF_OPENING1);
			return this;
		}
		/**
		 * Property name : Blind angle setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Blind angle<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xB4 (0.180°)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : deg<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBlindAngleSetting() {
			reqGetProperty(EPC_BLIND_ANGLE_SETTING);
			return this;
		}
		/**
		 * Property name : Shutter speed<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Low/medium/high<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Low = 0x41, medium = 0x42, high = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetShutterSpeed() {
			reqGetProperty(EPC_SHUTTER_SPEED);
			return this;
		}
		/**
		 * Property name : Extent of opening 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFF (0.255)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetExtentOfOpening2() {
			reqGetProperty(EPC_EXTENT_OF_OPENING2);
			return this;
		}
		/**
		 * Property name : Electric lock setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Activated = 0x41, deactivated = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetElectricLockSetting() {
			reqGetProperty(EPC_ELECTRIC_LOCK_SETTING);
			return this;
		}
		/**
		 * Property name : Open/close setting 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, close = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOpenCloseSetting2() {
			reqGetProperty(EPC_OPEN_CLOSE_SETTING2);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
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
		public Informer reqInformOperationStatus() {
			return (Informer)super.reqInformOperationStatus();
		}
		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}
		@Override
		public Informer reqInformStandardVersionInformation() {
			return (Informer)super.reqInformStandardVersionInformation();
		}
		@Override
		public Informer reqInformIdentificationNumber() {
			return (Informer)super.reqInformIdentificationNumber();
		}
		@Override
		public Informer reqInformMeasuredInstantaneousPowerConsumption() {
			return (Informer)super.reqInformMeasuredInstantaneousPowerConsumption();
		}
		@Override
		public Informer reqInformMeasuredCumulativePowerConsumption() {
			return (Informer)super.reqInformMeasuredCumulativePowerConsumption();
		}
		@Override
		public Informer reqInformManufacturersFaultCode() {
			return (Informer)super.reqInformManufacturersFaultCode();
		}
		@Override
		public Informer reqInformCurrentLimitSetting() {
			return (Informer)super.reqInformCurrentLimitSetting();
		}
		@Override
		public Informer reqInformFaultStatus() {
			return (Informer)super.reqInformFaultStatus();
		}
		@Override
		public Informer reqInformFaultDescription() {
			return (Informer)super.reqInformFaultDescription();
		}
		@Override
		public Informer reqInformManufacturerCode() {
			return (Informer)super.reqInformManufacturerCode();
		}
		@Override
		public Informer reqInformBusinessFacilityCode() {
			return (Informer)super.reqInformBusinessFacilityCode();
		}
		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}
		@Override
		public Informer reqInformProductionNumber() {
			return (Informer)super.reqInformProductionNumber();
		}
		@Override
		public Informer reqInformProductionDate() {
			return (Informer)super.reqInformProductionDate();
		}
		@Override
		public Informer reqInformPowerSavingOperationSetting() {
			return (Informer)super.reqInformPowerSavingOperationSetting();
		}
		@Override
		public Informer reqInformRemoteControlSetting() {
			return (Informer)super.reqInformRemoteControlSetting();
		}
		@Override
		public Informer reqInformCurrentTimeSetting() {
			return (Informer)super.reqInformCurrentTimeSetting();
		}
		@Override
		public Informer reqInformCurrentDateSetting() {
			return (Informer)super.reqInformCurrentDateSetting();
		}
		@Override
		public Informer reqInformPowerLimitSetting() {
			return (Informer)super.reqInformPowerLimitSetting();
		}
		@Override
		public Informer reqInformCumulativeOperatingTime() {
			return (Informer)super.reqInformCumulativeOperatingTime();
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
		 * Property name : Open/close setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open(ed)/close(d)/stop(ped)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOpenCloseSetting1() {
			reqInformProperty(EPC_OPEN_CLOSE_SETTING1);
			return this;
		}
		/**
		 * Property name : Extent of opening 1<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformExtentOfOpening1() {
			reqInformProperty(EPC_EXTENT_OF_OPENING1);
			return this;
		}
		/**
		 * Property name : Blind angle setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Blind angle<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xB4 (0.180°)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : deg<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBlindAngleSetting() {
			reqInformProperty(EPC_BLIND_ANGLE_SETTING);
			return this;
		}
		/**
		 * Property name : Shutter speed<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Low/medium/high<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Low = 0x41, medium = 0x42, high = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformShutterSpeed() {
			reqInformProperty(EPC_SHUTTER_SPEED);
			return this;
		}
		/**
		 * Property name : Extent of opening 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFF (0.255)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformExtentOfOpening2() {
			reqInformProperty(EPC_EXTENT_OF_OPENING2);
			return this;
		}
		/**
		 * Property name : Electric lock setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Activated = 0x41, deactivated = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformElectricLockSetting() {
			reqInformProperty(EPC_ELECTRIC_LOCK_SETTING);
			return this;
		}
		/**
		 * Property name : Open/close setting 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, close = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOpenCloseSetting2() {
			reqInformProperty(EPC_OPEN_CLOSE_SETTING2);
			return this;
		}
	}

	public static class Proxy extends ElectricShutter {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getOperationStatus() {return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt) {return false;}
		@Override
		protected byte[] getInstallationLocation() {return null;}
		@Override
		protected byte[] getStandardVersionInformation() {return null;}
		@Override
		protected byte[] getFaultStatus() {return null;}
		@Override
		protected byte[] getManufacturerCode() {return null;}
		@Override
		protected boolean setOpenCloseSetting1(byte[] edt) {return false;}
		@Override
		protected byte[] getOpenCloseSetting1() {return null;}
		@Override
		protected boolean setOpenCloseSetting2(byte[] edt) {return false;}
		@Override
		protected byte[] getOpenCloseSetting2() {return null;}
	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return setG(instanceCode, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, responseRequired);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, false);
	}

}
