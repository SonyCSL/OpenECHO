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

public abstract class InstantaneousWaterHeater extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0272;

	public static final byte EPC_HOT_WATER_HEATING_STATUS = (byte)0xD0;
	public static final byte EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE = (byte)0xD1;
	public static final byte EPC_HOT_WATER_WARMER_SETTING = (byte)0xD2;
	public static final byte EPC_DURATION_OF_AUTOMATIC_OPERATION_SETTING = (byte)0xDA;
	public static final byte EPC_REMAINING_AUTOMATIC_OPERATION_TIME = (byte)0xDB;
	public static final byte EPC_SET_VALUE_OF_BATH_TEMPERATURE = (byte)0xE1;
	public static final byte EPC_BATH_WATER_HEATER_STATUS = (byte)0xE2;
	public static final byte EPC_BATH_AUTO_MODE_SETTING = (byte)0xE3;
	public static final byte EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING = (byte)0xE4;
	public static final byte EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING = (byte)0xE5;
	public static final byte EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING = (byte)0xE6;
	public static final byte EPC_BATH_HOT_WATER_VOLUME_SETTING1 = (byte)0xE7;
	public static final byte EPC_BATH_HOT_WATER_VOLUME_SETTING2 = (byte)0xE8;
	public static final byte EPC_BATH_HOT_WATER_VOLUME_SETTING3 = (byte)0xEE;
	public static final byte EPC_BATHROOM_PRIORITY_SETTING = (byte)0xE9;
	public static final byte EPC_SHOWER_HOT_WATER_SUPPLY_STATUS = (byte)0xEA;
	public static final byte EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS = (byte)0xEB;
	public static final byte EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING = (byte)0xEC;
	public static final byte EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME = (byte)0xED;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_SET_VALUE_OF_ON_TIMER_TIME = (byte)0x91;
	public static final byte EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME = (byte)0x92;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_HOT_WATER_HEATING_STATUS);
		addGetProperty(EPC_BATH_WATER_HEATER_STATUS);
		addSetProperty(EPC_BATH_AUTO_MODE_SETTING);
		addGetProperty(EPC_BATH_AUTO_MODE_SETTING);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewInstantaneousWaterHeater(this);
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
	 * This  property  indicates  the  ON/OFF status.<br>
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
	 * This  property  indicates  the  ON/OFF status.<br>
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
	 * Property name : Hot water heating status<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates hot water heating status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water heating status found<br>
	 * = 0x41<br>
	 * Hot water heating status not found = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getHotWaterHeatingStatus();
	/**
	 * Property name : Hot water heating status<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates hot water heating status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water heating status found<br>
	 * = 0x41<br>
	 * Hot water heating status not found = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidHotWaterHeatingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set value of hot water temperature<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set value of hot water temperature in .C.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfHotWaterTemperature(byte[] edt) {return false;}
	/**
	 * Property name : Set value of hot water temperature<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set value of hot water temperature in .C.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfHotWaterTemperature() {return null;}
	/**
	 * Property name : Set value of hot water temperature<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set value of hot water temperature in .C.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfHotWaterTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Hot water Warmer setting<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Hot water warmer setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water warmer operation = 0x41 Hot water warmer operation resetting<br>
	 * = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setHotWaterWarmerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Hot water Warmer setting<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Hot water warmer setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water warmer operation = 0x41 Hot water warmer operation resetting<br>
	 * = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getHotWaterWarmerSetting() {return null;}
	/**
	 * Property name : Hot water Warmer setting<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Hot water warmer setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water warmer operation = 0x41 Hot water warmer operation resetting<br>
	 * = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHotWaterWarmerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Duration of automatic operation” setting<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * Limitless: 0xFFFF<br>
	 * <br>
	 * Data type : unsigned char× 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDurationOfAutomaticOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Duration of automatic operation” setting<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * Limitless: 0xFFFF<br>
	 * <br>
	 * Data type : unsigned char× 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDurationOfAutomaticOperationSetting() {return null;}
	/**
	 * Property name : “Duration of automatic operation” setting<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * Limitless: 0xFFFF<br>
	 * <br>
	 * Data type : unsigned char× 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDurationOfAutomaticOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Remaining automatic operation time<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * Infinite: 0xFFFF<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRemainingAutomaticOperationTime() {return null;}
	/**
	 * Property name : Remaining automatic operation time<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * Infinite: 0xFFFF<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRemainingAutomaticOperationTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Set value of bath temperature<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set value of bath temperature in .C.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfBathTemperature(byte[] edt) {return false;}
	/**
	 * Property name : Set value of bath temperature<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set value of bath temperature in .C.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfBathTemperature() {return null;}
	/**
	 * Property name : Set value of bath temperature<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set value of bath temperature in .C.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfBathTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water heater status<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether or not the bath water heater is heating bath water.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Heating = 0x41 Not heating = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getBathWaterHeaterStatus();
	/**
	 * Property name : Bath water heater status<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates whether or not the bath water heater is heating bath water.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Heating = 0x41 Not heating = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidBathWaterHeaterStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath auto mode setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Bath auto mode ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Auto ON = 0x41 Auto OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setBathAutoModeSetting(byte[] edt);
	/**
	 * Property name : Bath auto mode setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Bath auto mode ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Auto ON = 0x41 Auto OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getBathAutoModeSetting();
	/**
	 * Property name : Bath auto mode setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Bath auto mode ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Auto ON = 0x41 Auto OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidBathAutoModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath additional boil-up operation setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Additional boil-up ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathAdditionalBoilUpOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bath additional boil-up operation setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Additional boil-up ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathAdditionalBoilUpOperationSetting() {return null;}
	/**
	 * Property name : Bath additional boil-up operation setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Additional boil-up ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathAdditionalBoilUpOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath hot water adding operation setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Hot water addition ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathHotWaterAddingOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bath hot water adding operation setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Hot water addition ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathHotWaterAddingOperationSetting() {return null;}
	/**
	 * Property name : Bath hot water adding operation setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Hot water addition ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathHotWaterAddingOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water temperature lowering operation setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Hot water temperature lowering ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water temperature lowering ON = 0x41<br>
	 * Hot water temperature lowering OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathWaterTemperatureLoweringOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bath water temperature lowering operation setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Hot water temperature lowering ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water temperature lowering ON = 0x41<br>
	 * Hot water temperature lowering OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathWaterTemperatureLoweringOperationSetting() {return null;}
	/**
	 * Property name : Bath water temperature lowering operation setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Hot water temperature lowering ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Hot water temperature lowering ON = 0x41<br>
	 * Hot water temperature lowering OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathWaterTemperatureLoweringOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath hot water volume setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates bath hot water volume in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xFD (0.253 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liters<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathHotWaterVolumeSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Bath hot water volume setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates bath hot water volume in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xFD (0.253 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liters<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathHotWaterVolumeSetting1() {return null;}
	/**
	 * Property name : Bath hot water volume setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates bath hot water volume in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xFD (0.253 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liters<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathHotWaterVolumeSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath hot water volume setting 2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies bath hot water volume (8-step).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathHotWaterVolumeSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Bath hot water volume setting 2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies bath hot water volume (8-step).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathHotWaterVolumeSetting2() {return null;}
	/**
	 * Property name : Bath hot water volume setting 2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies bath hot water volume (8-step).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathHotWaterVolumeSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath hot water volume setting 3<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates bath hot water volume in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathHotWaterVolumeSetting3(byte[] edt) {return false;}
	/**
	 * Property name : Bath hot water volume setting 3<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates bath hot water volume in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathHotWaterVolumeSetting3() {return null;}
	/**
	 * Property name : Bath hot water volume setting 3<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates bath hot water volume in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathHotWaterVolumeSetting3(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Bathroom priority setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Bathroom priority ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathroomPrioritySetting(byte[] edt) {return false;}
	/**
	 * Property name : Bathroom priority setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Bathroom priority ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathroomPrioritySetting() {return null;}
	/**
	 * Property name : Bathroom priority setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Bathroom priority ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathroomPrioritySetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Shower hot water supply status<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Shower hot water supply ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getShowerHotWaterSupplyStatus() {return null;}
	/**
	 * Property name : Shower hot water supply status<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Shower hot water supply ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidShowerHotWaterSupplyStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Kitchen hot water supply status<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Kitchen hot water supply ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getKitchenHotWaterSupplyStatus() {return null;}
	/**
	 * Property name : Kitchen hot water supply status<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Kitchen hot water supply ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidKitchenHotWaterSupplyStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Hot water warmer ON timer reservation setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setHotWaterWarmerOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Hot water warmer ON timer reservation setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getHotWaterWarmerOnTimerReservationSetting() {return null;}
	/**
	 * Property name : Hot water warmer ON timer reservation setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHotWaterWarmerOnTimerReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set value of hot water warmer ON timer time<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfHotWaterWarmerOnTimerTime(byte[] edt) {return false;}
	/**
	 * Property name : Set value of hot water warmer ON timer time<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfHotWaterWarmerOnTimerTime() {return null;}
	/**
	 * Property name : Set value of hot water warmer ON timer time<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfHotWaterWarmerOnTimerTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/Reservation OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/Reservation OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/Reservation OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set value of ON timer time<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfOnTimerTime(byte[] edt) {return false;}
	/**
	 * Property name : Set value of ON timer time<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfOnTimerTime() {return null;}
	/**
	 * Property name : Set value of ON timer time<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfOnTimerTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Set value of ON timer relative time<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfOnTimerRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : Set value of ON timer relative time<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfOnTimerRelativeTime() {return null;}
	/**
	 * Property name : Set value of ON timer relative time<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfOnTimerRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE : return setSetValueOfHotWaterTemperature(property.edt);
		case EPC_HOT_WATER_WARMER_SETTING : return setHotWaterWarmerSetting(property.edt);
		case EPC_DURATION_OF_AUTOMATIC_OPERATION_SETTING : return setDurationOfAutomaticOperationSetting(property.edt);
		case EPC_SET_VALUE_OF_BATH_TEMPERATURE : return setSetValueOfBathTemperature(property.edt);
		case EPC_BATH_AUTO_MODE_SETTING : return setBathAutoModeSetting(property.edt);
		case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING : return setBathAdditionalBoilUpOperationSetting(property.edt);
		case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING : return setBathHotWaterAddingOperationSetting(property.edt);
		case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING : return setBathWaterTemperatureLoweringOperationSetting(property.edt);
		case EPC_BATH_HOT_WATER_VOLUME_SETTING1 : return setBathHotWaterVolumeSetting1(property.edt);
		case EPC_BATH_HOT_WATER_VOLUME_SETTING2 : return setBathHotWaterVolumeSetting2(property.edt);
		case EPC_BATH_HOT_WATER_VOLUME_SETTING3 : return setBathHotWaterVolumeSetting3(property.edt);
		case EPC_BATHROOM_PRIORITY_SETTING : return setBathroomPrioritySetting(property.edt);
		case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING : return setHotWaterWarmerOnTimerReservationSetting(property.edt);
		case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME : return setSetValueOfHotWaterWarmerOnTimerTime(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_SET_VALUE_OF_ON_TIMER_TIME : return setSetValueOfOnTimerTime(property.edt);
		case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME : return setSetValueOfOnTimerRelativeTime(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_HOT_WATER_HEATING_STATUS : return getHotWaterHeatingStatus();
		case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE : return getSetValueOfHotWaterTemperature();
		case EPC_HOT_WATER_WARMER_SETTING : return getHotWaterWarmerSetting();
		case EPC_DURATION_OF_AUTOMATIC_OPERATION_SETTING : return getDurationOfAutomaticOperationSetting();
		case EPC_REMAINING_AUTOMATIC_OPERATION_TIME : return getRemainingAutomaticOperationTime();
		case EPC_SET_VALUE_OF_BATH_TEMPERATURE : return getSetValueOfBathTemperature();
		case EPC_BATH_WATER_HEATER_STATUS : return getBathWaterHeaterStatus();
		case EPC_BATH_AUTO_MODE_SETTING : return getBathAutoModeSetting();
		case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING : return getBathAdditionalBoilUpOperationSetting();
		case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING : return getBathHotWaterAddingOperationSetting();
		case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING : return getBathWaterTemperatureLoweringOperationSetting();
		case EPC_BATH_HOT_WATER_VOLUME_SETTING1 : return getBathHotWaterVolumeSetting1();
		case EPC_BATH_HOT_WATER_VOLUME_SETTING2 : return getBathHotWaterVolumeSetting2();
		case EPC_BATH_HOT_WATER_VOLUME_SETTING3 : return getBathHotWaterVolumeSetting3();
		case EPC_BATHROOM_PRIORITY_SETTING : return getBathroomPrioritySetting();
		case EPC_SHOWER_HOT_WATER_SUPPLY_STATUS : return getShowerHotWaterSupplyStatus();
		case EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS : return getKitchenHotWaterSupplyStatus();
		case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING : return getHotWaterWarmerOnTimerReservationSetting();
		case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME : return getSetValueOfHotWaterWarmerOnTimerTime();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_SET_VALUE_OF_ON_TIMER_TIME : return getSetValueOfOnTimerTime();
		case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME : return getSetValueOfOnTimerRelativeTime();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_HOT_WATER_HEATING_STATUS : return isValidHotWaterHeatingStatus(property.edt);
		case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE : return isValidSetValueOfHotWaterTemperature(property.edt);
		case EPC_HOT_WATER_WARMER_SETTING : return isValidHotWaterWarmerSetting(property.edt);
		case EPC_DURATION_OF_AUTOMATIC_OPERATION_SETTING : return isValidDurationOfAutomaticOperationSetting(property.edt);
		case EPC_REMAINING_AUTOMATIC_OPERATION_TIME : return isValidRemainingAutomaticOperationTime(property.edt);
		case EPC_SET_VALUE_OF_BATH_TEMPERATURE : return isValidSetValueOfBathTemperature(property.edt);
		case EPC_BATH_WATER_HEATER_STATUS : return isValidBathWaterHeaterStatus(property.edt);
		case EPC_BATH_AUTO_MODE_SETTING : return isValidBathAutoModeSetting(property.edt);
		case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING : return isValidBathAdditionalBoilUpOperationSetting(property.edt);
		case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING : return isValidBathHotWaterAddingOperationSetting(property.edt);
		case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING : return isValidBathWaterTemperatureLoweringOperationSetting(property.edt);
		case EPC_BATH_HOT_WATER_VOLUME_SETTING1 : return isValidBathHotWaterVolumeSetting1(property.edt);
		case EPC_BATH_HOT_WATER_VOLUME_SETTING2 : return isValidBathHotWaterVolumeSetting2(property.edt);
		case EPC_BATH_HOT_WATER_VOLUME_SETTING3 : return isValidBathHotWaterVolumeSetting3(property.edt);
		case EPC_BATHROOM_PRIORITY_SETTING : return isValidBathroomPrioritySetting(property.edt);
		case EPC_SHOWER_HOT_WATER_SUPPLY_STATUS : return isValidShowerHotWaterSupplyStatus(property.edt);
		case EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS : return isValidKitchenHotWaterSupplyStatus(property.edt);
		case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING : return isValidHotWaterWarmerOnTimerReservationSetting(property.edt);
		case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME : return isValidSetValueOfHotWaterWarmerOnTimerTime(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_SET_VALUE_OF_ON_TIMER_TIME : return isValidSetValueOfOnTimerTime(property.edt);
		case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME : return isValidSetValueOfOnTimerRelativeTime(property.edt);
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
			case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE : 
				onSetSetValueOfHotWaterTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_HOT_WATER_WARMER_SETTING : 
				onSetHotWaterWarmerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DURATION_OF_AUTOMATIC_OPERATION_SETTING : 
				onSetDurationOfAutomaticOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_BATH_TEMPERATURE : 
				onSetSetValueOfBathTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_AUTO_MODE_SETTING : 
				onSetBathAutoModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING : 
				onSetBathAdditionalBoilUpOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING : 
				onSetBathHotWaterAddingOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING : 
				onSetBathWaterTemperatureLoweringOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING1 : 
				onSetBathHotWaterVolumeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING2 : 
				onSetBathHotWaterVolumeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING3 : 
				onSetBathHotWaterVolumeSetting3(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_PRIORITY_SETTING : 
				onSetBathroomPrioritySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING : 
				onSetHotWaterWarmerOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME : 
				onSetSetValueOfHotWaterWarmerOnTimerTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_ON_TIMER_TIME : 
				onSetSetValueOfOnTimerTime(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME : 
				onSetSetValueOfOnTimerRelativeTime(eoj, tid, esv, property, success);
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
			case EPC_HOT_WATER_HEATING_STATUS : 
				onGetHotWaterHeatingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE : 
				onGetSetValueOfHotWaterTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_HOT_WATER_WARMER_SETTING : 
				onGetHotWaterWarmerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DURATION_OF_AUTOMATIC_OPERATION_SETTING : 
				onGetDurationOfAutomaticOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_AUTOMATIC_OPERATION_TIME : 
				onGetRemainingAutomaticOperationTime(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_BATH_TEMPERATURE : 
				onGetSetValueOfBathTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_HEATER_STATUS : 
				onGetBathWaterHeaterStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_AUTO_MODE_SETTING : 
				onGetBathAutoModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING : 
				onGetBathAdditionalBoilUpOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING : 
				onGetBathHotWaterAddingOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING : 
				onGetBathWaterTemperatureLoweringOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING1 : 
				onGetBathHotWaterVolumeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING2 : 
				onGetBathHotWaterVolumeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING3 : 
				onGetBathHotWaterVolumeSetting3(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_PRIORITY_SETTING : 
				onGetBathroomPrioritySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SHOWER_HOT_WATER_SUPPLY_STATUS : 
				onGetShowerHotWaterSupplyStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS : 
				onGetKitchenHotWaterSupplyStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING : 
				onGetHotWaterWarmerOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME : 
				onGetSetValueOfHotWaterWarmerOnTimerTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_ON_TIMER_TIME : 
				onGetSetValueOfOnTimerTime(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME : 
				onGetSetValueOfOnTimerRelativeTime(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Hot water heating status<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates hot water heating status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water heating status found<br>
		 * = 0x41<br>
		 * Hot water heating status not found = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetHotWaterHeatingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of hot water temperature<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of hot water temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfHotWaterTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of hot water temperature<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of hot water temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfHotWaterTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Hot water Warmer setting<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water warmer setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water warmer operation = 0x41 Hot water warmer operation resetting<br>
		 * = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetHotWaterWarmerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Hot water Warmer setting<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water warmer setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water warmer operation = 0x41 Hot water warmer operation resetting<br>
		 * = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetHotWaterWarmerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Duration of automatic operation” setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * Limitless: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char× 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDurationOfAutomaticOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Duration of automatic operation” setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * Limitless: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char× 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDurationOfAutomaticOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining automatic operation time<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * Infinite: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRemainingAutomaticOperationTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of bath temperature<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of bath temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfBathTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of bath temperature<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of bath temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfBathTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water heater status<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not the bath water heater is heating bath water.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating = 0x41 Not heating = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetBathWaterHeaterStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath auto mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Bath auto mode ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto ON = 0x41 Auto OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetBathAutoModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath auto mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Bath auto mode ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto ON = 0x41 Auto OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetBathAutoModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath additional boil-up operation setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Additional boil-up ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathAdditionalBoilUpOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath additional boil-up operation setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Additional boil-up ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathAdditionalBoilUpOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath hot water adding operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water addition ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathHotWaterAddingOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath hot water adding operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water addition ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathHotWaterAddingOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water temperature lowering operation setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water temperature lowering ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water temperature lowering ON = 0x41<br>
		 * Hot water temperature lowering OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathWaterTemperatureLoweringOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water temperature lowering operation setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water temperature lowering ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water temperature lowering ON = 0x41<br>
		 * Hot water temperature lowering OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathWaterTemperatureLoweringOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath hot water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathHotWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath hot water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathHotWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath hot water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies bath hot water volume (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathHotWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath hot water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies bath hot water volume (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathHotWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath hot water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathHotWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath hot water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathHotWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom priority setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Bathroom priority ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathroomPrioritySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom priority setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Bathroom priority ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathroomPrioritySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Shower hot water supply status<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Shower hot water supply ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetShowerHotWaterSupplyStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Kitchen hot water supply status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Kitchen hot water supply ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetKitchenHotWaterSupplyStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Hot water warmer ON timer reservation setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetHotWaterWarmerOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Hot water warmer ON timer reservation setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetHotWaterWarmerOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of hot water warmer ON timer time<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfHotWaterWarmerOnTimerTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of hot water warmer ON timer time<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfHotWaterWarmerOnTimerTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/Reservation OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/Reservation OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of ON timer time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfOnTimerTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of ON timer time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfOnTimerTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of ON timer relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfOnTimerRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of ON timer relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfOnTimerRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Set value of hot water temperature<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of hot water temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfHotWaterTemperature(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE, edt);
			return this;
		}
		/**
		 * Property name : Hot water Warmer setting<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water warmer setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water warmer operation = 0x41 Hot water warmer operation resetting<br>
		 * = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetHotWaterWarmerSetting(byte[] edt) {
			reqSetProperty(EPC_HOT_WATER_WARMER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Duration of automatic operation” setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * Limitless: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char× 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDurationOfAutomaticOperationSetting(byte[] edt) {
			reqSetProperty(EPC_DURATION_OF_AUTOMATIC_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Set value of bath temperature<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of bath temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfBathTemperature(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE, edt);
			return this;
		}
		/**
		 * Property name : Bath auto mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Bath auto mode ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto ON = 0x41 Auto OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetBathAutoModeSetting(byte[] edt) {
			reqSetProperty(EPC_BATH_AUTO_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath additional boil-up operation setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Additional boil-up ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathAdditionalBoilUpOperationSetting(byte[] edt) {
			reqSetProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath hot water adding operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water addition ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathHotWaterAddingOperationSetting(byte[] edt) {
			reqSetProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath water temperature lowering operation setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water temperature lowering ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water temperature lowering ON = 0x41<br>
		 * Hot water temperature lowering OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathWaterTemperatureLoweringOperationSetting(byte[] edt) {
			reqSetProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath hot water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathHotWaterVolumeSetting1(byte[] edt) {
			reqSetProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Bath hot water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies bath hot water volume (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathHotWaterVolumeSetting2(byte[] edt) {
			reqSetProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Bath hot water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathHotWaterVolumeSetting3(byte[] edt) {
			reqSetProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3, edt);
			return this;
		}
		/**
		 * Property name : Bathroom priority setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Bathroom priority ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathroomPrioritySetting(byte[] edt) {
			reqSetProperty(EPC_BATHROOM_PRIORITY_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Hot water warmer ON timer reservation setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetHotWaterWarmerOnTimerReservationSetting(byte[] edt) {
			reqSetProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Set value of hot water warmer ON timer time<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfHotWaterWarmerOnTimerTime(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/Reservation OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Set value of ON timer time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfOnTimerTime(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME, edt);
			return this;
		}
		/**
		 * Property name : Set value of ON timer relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfOnTimerRelativeTime(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME, edt);
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
		 * Property name : Hot water heating status<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates hot water heating status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water heating status found<br>
		 * = 0x41<br>
		 * Hot water heating status not found = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetHotWaterHeatingStatus() {
			reqGetProperty(EPC_HOT_WATER_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Set value of hot water temperature<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of hot water temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfHotWaterTemperature() {
			reqGetProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Hot water Warmer setting<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water warmer setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water warmer operation = 0x41 Hot water warmer operation resetting<br>
		 * = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHotWaterWarmerSetting() {
			reqGetProperty(EPC_HOT_WATER_WARMER_SETTING);
			return this;
		}
		/**
		 * Property name : “Duration of automatic operation” setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * Limitless: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char× 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDurationOfAutomaticOperationSetting() {
			reqGetProperty(EPC_DURATION_OF_AUTOMATIC_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Remaining automatic operation time<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * Infinite: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRemainingAutomaticOperationTime() {
			reqGetProperty(EPC_REMAINING_AUTOMATIC_OPERATION_TIME);
			return this;
		}
		/**
		 * Property name : Set value of bath temperature<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of bath temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfBathTemperature() {
			reqGetProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Bath water heater status<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not the bath water heater is heating bath water.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating = 0x41 Not heating = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetBathWaterHeaterStatus() {
			reqGetProperty(EPC_BATH_WATER_HEATER_STATUS);
			return this;
		}
		/**
		 * Property name : Bath auto mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Bath auto mode ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto ON = 0x41 Auto OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetBathAutoModeSetting() {
			reqGetProperty(EPC_BATH_AUTO_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Bath additional boil-up operation setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Additional boil-up ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathAdditionalBoilUpOperationSetting() {
			reqGetProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath hot water adding operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water addition ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathHotWaterAddingOperationSetting() {
			reqGetProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water temperature lowering operation setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water temperature lowering ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water temperature lowering ON = 0x41<br>
		 * Hot water temperature lowering OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathWaterTemperatureLoweringOperationSetting() {
			reqGetProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath hot water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathHotWaterVolumeSetting1() {
			reqGetProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Property name : Bath hot water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies bath hot water volume (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathHotWaterVolumeSetting2() {
			reqGetProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Property name : Bath hot water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathHotWaterVolumeSetting3() {
			reqGetProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3);
			return this;
		}
		/**
		 * Property name : Bathroom priority setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Bathroom priority ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathroomPrioritySetting() {
			reqGetProperty(EPC_BATHROOM_PRIORITY_SETTING);
			return this;
		}
		/**
		 * Property name : Shower hot water supply status<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Shower hot water supply ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetShowerHotWaterSupplyStatus() {
			reqGetProperty(EPC_SHOWER_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		/**
		 * Property name : Kitchen hot water supply status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Kitchen hot water supply ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetKitchenHotWaterSupplyStatus() {
			reqGetProperty(EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		/**
		 * Property name : Hot water warmer ON timer reservation setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHotWaterWarmerOnTimerReservationSetting() {
			reqGetProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set value of hot water warmer ON timer time<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfHotWaterWarmerOnTimerTime() {
			reqGetProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/Reservation OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			reqGetProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set value of ON timer time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfOnTimerTime() {
			reqGetProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME);
			return this;
		}
		/**
		 * Property name : Set value of ON timer relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfOnTimerRelativeTime() {
			reqGetProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME);
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
		 * Property name : Hot water heating status<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates hot water heating status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water heating status found<br>
		 * = 0x41<br>
		 * Hot water heating status not found = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformHotWaterHeatingStatus() {
			reqInformProperty(EPC_HOT_WATER_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Set value of hot water temperature<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of hot water temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfHotWaterTemperature() {
			reqInformProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Hot water Warmer setting<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water warmer setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water warmer operation = 0x41 Hot water warmer operation resetting<br>
		 * = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHotWaterWarmerSetting() {
			reqInformProperty(EPC_HOT_WATER_WARMER_SETTING);
			return this;
		}
		/**
		 * Property name : “Duration of automatic operation” setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * Limitless: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char× 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDurationOfAutomaticOperationSetting() {
			reqInformProperty(EPC_DURATION_OF_AUTOMATIC_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Remaining automatic operation time<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * Infinite: 0xFFFF<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRemainingAutomaticOperationTime() {
			reqInformProperty(EPC_REMAINING_AUTOMATIC_OPERATION_TIME);
			return this;
		}
		/**
		 * Property name : Set value of bath temperature<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set value of bath temperature in .C.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfBathTemperature() {
			reqInformProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Bath water heater status<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates whether or not the bath water heater is heating bath water.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating = 0x41 Not heating = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformBathWaterHeaterStatus() {
			reqInformProperty(EPC_BATH_WATER_HEATER_STATUS);
			return this;
		}
		/**
		 * Property name : Bath auto mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Bath auto mode ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Auto ON = 0x41 Auto OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformBathAutoModeSetting() {
			reqInformProperty(EPC_BATH_AUTO_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Bath additional boil-up operation setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Additional boil-up ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathAdditionalBoilUpOperationSetting() {
			reqInformProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath hot water adding operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water addition ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathHotWaterAddingOperationSetting() {
			reqInformProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water temperature lowering operation setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Hot water temperature lowering ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Hot water temperature lowering ON = 0x41<br>
		 * Hot water temperature lowering OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathWaterTemperatureLoweringOperationSetting() {
			reqInformProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath hot water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathHotWaterVolumeSetting1() {
			reqInformProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Property name : Bath hot water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies bath hot water volume (8-step).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathHotWaterVolumeSetting2() {
			reqInformProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Property name : Bath hot water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates bath hot water volume in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathHotWaterVolumeSetting3() {
			reqInformProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3);
			return this;
		}
		/**
		 * Property name : Bathroom priority setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Bathroom priority ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathroomPrioritySetting() {
			reqInformProperty(EPC_BATHROOM_PRIORITY_SETTING);
			return this;
		}
		/**
		 * Property name : Shower hot water supply status<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Shower hot water supply ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformShowerHotWaterSupplyStatus() {
			reqInformProperty(EPC_SHOWER_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		/**
		 * Property name : Kitchen hot water supply status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Kitchen hot water supply ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformKitchenHotWaterSupplyStatus() {
			reqInformProperty(EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		/**
		 * Property name : Hot water warmer ON timer reservation setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHotWaterWarmerOnTimerReservationSetting() {
			reqInformProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set value of hot water warmer ON timer time<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfHotWaterWarmerOnTimerTime() {
			reqInformProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/Reservation OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting() {
			reqInformProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set value of ON timer time<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfOnTimerTime() {
			reqInformProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME);
			return this;
		}
		/**
		 * Property name : Set value of ON timer relative time<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfOnTimerRelativeTime() {
			reqInformProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME);
			return this;
		}
	}

	public static class Proxy extends InstantaneousWaterHeater {
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
		protected byte[] getHotWaterHeatingStatus() {return null;}
		@Override
		protected byte[] getBathWaterHeaterStatus() {return null;}
		@Override
		protected boolean setBathAutoModeSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getBathAutoModeSetting() {return null;}
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
