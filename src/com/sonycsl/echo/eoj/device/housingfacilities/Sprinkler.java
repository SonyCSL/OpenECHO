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

public abstract class Sprinkler extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0267;

	public static final byte EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING = (byte)0xE0;
	public static final byte EPC_SPRINKLE_INTERVAL_SETTING = (byte)0xE1;
	public static final byte EPC_NUMBER_OF_SPRINKLES_SETTING = (byte)0xE2;
	public static final byte EPC_SPRINKLE_TIME_SETTING1 = (byte)0xE3;
	public static final byte EPC_SPRINKLE_TIME_SETTING2 = (byte)0xE4;
	public static final byte EPC_SPRINKLE_DURATION_SETTING = (byte)0xE5;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING);
		addGetProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewSprinkler(this);
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
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
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
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
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
	 * Property name : Sprinkle valve open/close setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Open/close of sprinkle valve<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic ON=0x40    manual ON=0x41, manual OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setSprinkleValveOpenCloseSetting(byte[] edt);
	/**
	 * Property name : Sprinkle valve open/close setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Open/close of sprinkle valve<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic ON=0x40    manual ON=0x41, manual OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getSprinkleValveOpenCloseSetting();
	/**
	 * Property name : Sprinkle valve open/close setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Open/close of sprinkle valve<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic ON=0x40    manual ON=0x41, manual OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidSprinkleValveOpenCloseSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Sprinkle interval setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * OFF / daily / every other day / every 3 days / once a week<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x40／0x41／0x42／0x43／0x44<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSprinkleIntervalSetting(byte[] edt) {return false;}
	/**
	 * Property name : Sprinkle interval setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * OFF / daily / every other day / every 3 days / once a week<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x40／0x41／0x42／0x43／0x44<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSprinkleIntervalSetting() {return null;}
	/**
	 * Property name : Sprinkle interval setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * OFF / daily / every other day / every 3 days / once a week<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x40／0x41／0x42／0x43／0x44<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSprinkleIntervalSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Number of sprinkles setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Number of sprinkles in a day(up to 2 times)<br>
	 * First ON／second ON／both ON<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x41／0x42／0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setNumberOfSprinklesSetting(byte[] edt) {return false;}
	/**
	 * Property name : Number of sprinkles setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Number of sprinkles in a day(up to 2 times)<br>
	 * First ON／second ON／both ON<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x41／0x42／0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getNumberOfSprinklesSetting() {return null;}
	/**
	 * Property name : Number of sprinkles setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Number of sprinkles in a day(up to 2 times)<br>
	 * First ON／second ON／both ON<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x41／0x42／0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidNumberOfSprinklesSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Sprinkle time setting 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Set timer value HH:MM and get updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSprinkleTimeSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Sprinkle time setting 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Set timer value HH:MM and get updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSprinkleTimeSetting1() {return null;}
	/**
	 * Property name : Sprinkle time setting 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Set timer value HH:MM and get updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSprinkleTimeSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Sprinkle time setting 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Set timer value HH:MM and get updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSprinkleTimeSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Sprinkle time setting 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Set timer value HH:MM and get updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSprinkleTimeSetting2() {return null;}
	/**
	 * Property name : Sprinkle time setting 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Set timer value HH:MM and get updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSprinkleTimeSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Sprinkle duration setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Set timer value MM 0 to 59 minutes<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x3B (=0.59)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSprinkleDurationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Sprinkle duration setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Set timer value MM 0 to 59 minutes<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x3B (=0.59)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSprinkleDurationSetting() {return null;}
	/**
	 * Property name : Sprinkle duration setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Set timer value MM 0 to 59 minutes<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x3B (=0.59)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSprinkleDurationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING : return setSprinkleValveOpenCloseSetting(property.edt);
		case EPC_SPRINKLE_INTERVAL_SETTING : return setSprinkleIntervalSetting(property.edt);
		case EPC_NUMBER_OF_SPRINKLES_SETTING : return setNumberOfSprinklesSetting(property.edt);
		case EPC_SPRINKLE_TIME_SETTING1 : return setSprinkleTimeSetting1(property.edt);
		case EPC_SPRINKLE_TIME_SETTING2 : return setSprinkleTimeSetting2(property.edt);
		case EPC_SPRINKLE_DURATION_SETTING : return setSprinkleDurationSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING : return getSprinkleValveOpenCloseSetting();
		case EPC_SPRINKLE_INTERVAL_SETTING : return getSprinkleIntervalSetting();
		case EPC_NUMBER_OF_SPRINKLES_SETTING : return getNumberOfSprinklesSetting();
		case EPC_SPRINKLE_TIME_SETTING1 : return getSprinkleTimeSetting1();
		case EPC_SPRINKLE_TIME_SETTING2 : return getSprinkleTimeSetting2();
		case EPC_SPRINKLE_DURATION_SETTING : return getSprinkleDurationSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING : return isValidSprinkleValveOpenCloseSetting(property.edt);
		case EPC_SPRINKLE_INTERVAL_SETTING : return isValidSprinkleIntervalSetting(property.edt);
		case EPC_NUMBER_OF_SPRINKLES_SETTING : return isValidNumberOfSprinklesSetting(property.edt);
		case EPC_SPRINKLE_TIME_SETTING1 : return isValidSprinkleTimeSetting1(property.edt);
		case EPC_SPRINKLE_TIME_SETTING2 : return isValidSprinkleTimeSetting2(property.edt);
		case EPC_SPRINKLE_DURATION_SETTING : return isValidSprinkleDurationSetting(property.edt);
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
			case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING : 
				onSetSprinkleValveOpenCloseSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPRINKLE_INTERVAL_SETTING : 
				onSetSprinkleIntervalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_NUMBER_OF_SPRINKLES_SETTING : 
				onSetNumberOfSprinklesSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPRINKLE_TIME_SETTING1 : 
				onSetSprinkleTimeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_SPRINKLE_TIME_SETTING2 : 
				onSetSprinkleTimeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_SPRINKLE_DURATION_SETTING : 
				onSetSprinkleDurationSetting(eoj, tid, esv, property, success);
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
			case EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING : 
				onGetSprinkleValveOpenCloseSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPRINKLE_INTERVAL_SETTING : 
				onGetSprinkleIntervalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_NUMBER_OF_SPRINKLES_SETTING : 
				onGetNumberOfSprinklesSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPRINKLE_TIME_SETTING1 : 
				onGetSprinkleTimeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_SPRINKLE_TIME_SETTING2 : 
				onGetSprinkleTimeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_SPRINKLE_DURATION_SETTING : 
				onGetSprinkleDurationSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Sprinkle valve open/close setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close of sprinkle valve<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic ON=0x40    manual ON=0x41, manual OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetSprinkleValveOpenCloseSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sprinkle valve open/close setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close of sprinkle valve<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic ON=0x40    manual ON=0x41, manual OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetSprinkleValveOpenCloseSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sprinkle interval setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * OFF / daily / every other day / every 3 days / once a week<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40／0x41／0x42／0x43／0x44<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSprinkleIntervalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sprinkle interval setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * OFF / daily / every other day / every 3 days / once a week<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40／0x41／0x42／0x43／0x44<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSprinkleIntervalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Number of sprinkles setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Number of sprinkles in a day(up to 2 times)<br>
		 * First ON／second ON／both ON<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41／0x42／0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetNumberOfSprinklesSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Number of sprinkles setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Number of sprinkles in a day(up to 2 times)<br>
		 * First ON／second ON／both ON<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41／0x42／0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetNumberOfSprinklesSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sprinkle time setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSprinkleTimeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sprinkle time setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSprinkleTimeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sprinkle time setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSprinkleTimeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sprinkle time setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSprinkleTimeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sprinkle duration setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value MM 0 to 59 minutes<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x3B (=0.59)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSprinkleDurationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Sprinkle duration setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value MM 0 to 59 minutes<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x3B (=0.59)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSprinkleDurationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Sprinkle valve open/close setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close of sprinkle valve<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic ON=0x40    manual ON=0x41, manual OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetSprinkleValveOpenCloseSetting(byte[] edt) {
			reqSetProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Sprinkle interval setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * OFF / daily / every other day / every 3 days / once a week<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40／0x41／0x42／0x43／0x44<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSprinkleIntervalSetting(byte[] edt) {
			reqSetProperty(EPC_SPRINKLE_INTERVAL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Number of sprinkles setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Number of sprinkles in a day(up to 2 times)<br>
		 * First ON／second ON／both ON<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41／0x42／0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetNumberOfSprinklesSetting(byte[] edt) {
			reqSetProperty(EPC_NUMBER_OF_SPRINKLES_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Sprinkle time setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSprinkleTimeSetting1(byte[] edt) {
			reqSetProperty(EPC_SPRINKLE_TIME_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Sprinkle time setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSprinkleTimeSetting2(byte[] edt) {
			reqSetProperty(EPC_SPRINKLE_TIME_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Sprinkle duration setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value MM 0 to 59 minutes<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x3B (=0.59)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSprinkleDurationSetting(byte[] edt) {
			reqSetProperty(EPC_SPRINKLE_DURATION_SETTING, edt);
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
		 * Property name : Sprinkle valve open/close setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close of sprinkle valve<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic ON=0x40    manual ON=0x41, manual OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetSprinkleValveOpenCloseSetting() {
			reqGetProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING);
			return this;
		}
		/**
		 * Property name : Sprinkle interval setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * OFF / daily / every other day / every 3 days / once a week<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40／0x41／0x42／0x43／0x44<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSprinkleIntervalSetting() {
			reqGetProperty(EPC_SPRINKLE_INTERVAL_SETTING);
			return this;
		}
		/**
		 * Property name : Number of sprinkles setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Number of sprinkles in a day(up to 2 times)<br>
		 * First ON／second ON／both ON<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41／0x42／0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetNumberOfSprinklesSetting() {
			reqGetProperty(EPC_NUMBER_OF_SPRINKLES_SETTING);
			return this;
		}
		/**
		 * Property name : Sprinkle time setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSprinkleTimeSetting1() {
			reqGetProperty(EPC_SPRINKLE_TIME_SETTING1);
			return this;
		}
		/**
		 * Property name : Sprinkle time setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSprinkleTimeSetting2() {
			reqGetProperty(EPC_SPRINKLE_TIME_SETTING2);
			return this;
		}
		/**
		 * Property name : Sprinkle duration setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value MM 0 to 59 minutes<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x3B (=0.59)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSprinkleDurationSetting() {
			reqGetProperty(EPC_SPRINKLE_DURATION_SETTING);
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
		 * Property name : Sprinkle valve open/close setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Open/close of sprinkle valve<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic ON=0x40    manual ON=0x41, manual OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformSprinkleValveOpenCloseSetting() {
			reqInformProperty(EPC_SPRINKLE_VALVE_OPEN_CLOSE_SETTING);
			return this;
		}
		/**
		 * Property name : Sprinkle interval setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * OFF / daily / every other day / every 3 days / once a week<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40／0x41／0x42／0x43／0x44<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSprinkleIntervalSetting() {
			reqInformProperty(EPC_SPRINKLE_INTERVAL_SETTING);
			return this;
		}
		/**
		 * Property name : Number of sprinkles setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Number of sprinkles in a day(up to 2 times)<br>
		 * First ON／second ON／both ON<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41／0x42／0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformNumberOfSprinklesSetting() {
			reqInformProperty(EPC_NUMBER_OF_SPRINKLES_SETTING);
			return this;
		}
		/**
		 * Property name : Sprinkle time setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSprinkleTimeSetting1() {
			reqInformProperty(EPC_SPRINKLE_TIME_SETTING1);
			return this;
		}
		/**
		 * Property name : Sprinkle time setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value HH:MM and get updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17 : 0.0x3B (=0.23) : (=0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSprinkleTimeSetting2() {
			reqInformProperty(EPC_SPRINKLE_TIME_SETTING2);
			return this;
		}
		/**
		 * Property name : Sprinkle duration setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Set timer value MM 0 to 59 minutes<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x3B (=0.59)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSprinkleDurationSetting() {
			reqInformProperty(EPC_SPRINKLE_DURATION_SETTING);
			return this;
		}
	}

	public static class Proxy extends Sprinkler {
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
		protected boolean setSprinkleValveOpenCloseSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getSprinkleValveOpenCloseSetting() {return null;}
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
