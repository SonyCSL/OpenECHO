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
package com.sonycsl.echo.eoj.device.airconditioner;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class HomeAirConditioner extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0130;

	public static final byte EPC_OPERATION_MODE_SETTING = (byte)0xB0;
	public static final byte EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING = (byte)0xB1;
	public static final byte EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING = (byte)0xB2;
	public static final byte EPC_SET_TEMPERATURE_VALUE = (byte)0xB3;
	public static final byte EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE = (byte)0xB4;
	public static final byte EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE = (byte)0xB5;
	public static final byte EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE = (byte)0xB6;
	public static final byte EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE = (byte)0xB7;
	public static final byte EPC_RATED_POWER_CONSUMPTION = (byte)0xB8;
	public static final byte EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION = (byte)0xB9;
	public static final byte EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY = (byte)0xBA;
	public static final byte EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE = (byte)0xBB;
	public static final byte EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL = (byte)0xBC;
	public static final byte EPC_MEASURED_COOLED_AIR_TEMPERATURE = (byte)0xBD;
	public static final byte EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE = (byte)0xBE;
	public static final byte EPC_RELATIVE_TEMPERATURE_SETTING = (byte)0xBF;
	public static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	public static final byte EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING = (byte)0xA1;
	public static final byte EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING = (byte)0xA3;
	public static final byte EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING = (byte)0xA4;
	public static final byte EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING = (byte)0xA5;
	public static final byte EPC_SPECIAL_STATE = (byte)0xAA;
	public static final byte EPC_NON_PRIORITY_STATE = (byte)0xAB;
	public static final byte EPC_VENTILATION_FUNCTION_SETTING = (byte)0xC0;
	public static final byte EPC_HUMIDIFIER_FUNCTION_SETTING = (byte)0xC1;
	public static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	public static final byte EPC_DEGREE_OF_HUMIDIFICATION_SETTING = (byte)0xC4;
	public static final byte EPC_MOUNTED_AIR_CLEANING_METHOD = (byte)0xC6;
	public static final byte EPC_AIR_PURIFIER_FUNCTION_SETTING = (byte)0xC7;
	public static final byte EPC_MOUNTED_AIR_REFRESH_METHOD = (byte)0xC8;
	public static final byte EPC_AIR_REFRESHER_FUNCTION_SETTING = (byte)0xC9;
	public static final byte EPC_MOUNTED_SELF_CLEANING_METHOD = (byte)0xCA;
	public static final byte EPC_SELF_CLEANING_FUNCTION_SETTING = (byte)0xCB;
	public static final byte EPC_SPECIAL_FUNCTION_SETTING = (byte)0xCC;
	public static final byte EPC_OPERATION_STATUS_OF_COMPONENTS = (byte)0xCD;
	public static final byte EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION = (byte)0xCE;
	public static final byte EPC_AIR_PURIFICATION_MODE_SETTING = (byte)0xCF;
	public static final byte EPC_ON_TIMER_BASED_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING_TIME = (byte)0x91;
	public static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME = (byte)0x92;
	public static final byte EPC_OFF_TIMER_BASED_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_OFF_TIMER_SETTING_TIME = (byte)0x95;
	public static final byte EPC_OFF_TIMER_SETTING_RELATIVE_TIME = (byte)0x96;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_MODE_SETTING);
		addSetProperty(EPC_OPERATION_MODE_SETTING);
		addGetProperty(EPC_OPERATION_MODE_SETTING);
		addSetProperty(EPC_SET_TEMPERATURE_VALUE);
		addGetProperty(EPC_SET_TEMPERATURE_VALUE);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewHomeAirConditioner(this);
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
	 * This  property  indicates  the  ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit :  �<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationStatus(byte[] edt);
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This  property  indicates  the  ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit :  �<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41<br>
	 * Cooling: 0x42<br>
	 * Heating: 0x43<br>
	 * Dehumidification: 0x44<br>
	 * Air circulator: 0x45<br>
	 * Other: 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationModeSetting(byte[] edt);
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41<br>
	 * Cooling: 0x42<br>
	 * Heating: 0x43<br>
	 * Dehumidification: 0x44<br>
	 * Air circulator: 0x45<br>
	 * Other: 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationModeSetting();
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41<br>
	 * Cooling: 0x42<br>
	 * Heating: 0x43<br>
	 * Dehumidification: 0x44<br>
	 * Air circulator: 0x45<br>
	 * Other: 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Automatic temperature control setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41<br>
	 * Non-automatic = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic temperature control setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41<br>
	 * Non-automatic = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	/**
	 * Property name : Automatic temperature control setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41<br>
	 * Non-automatic = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAutomaticTemperatureControlSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Normal/high- speed/silent operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the type of operation<br>
	 * ( gnormal, h  ghigh-speed h or  gsilent h),<br>
	 * and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal operation: 0x41<br>
	 * High-speed operation: 0x42<br>
	 * Silent operation: 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setNormalHighSpeedSilentOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Normal/high- speed/silent operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the type of operation<br>
	 * ( gnormal, h  ghigh-speed h or  gsilent h),<br>
	 * and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal operation: 0x41<br>
	 * High-speed operation: 0x42<br>
	 * Silent operation: 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getNormalHighSpeedSilentOperationSetting() {return null;}
	/**
	 * Property name : Normal/high- speed/silent operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the type of operation<br>
	 * ( gnormal, h  ghigh-speed h or  gsilent h),<br>
	 * and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal operation: 0x41<br>
	 * High-speed operation: 0x42<br>
	 * Silent operation: 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidNormalHighSpeedSilentOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set temperature value<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature and to<br>
	 * acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setSetTemperatureValue(byte[] edt);
	/**
	 * Property name : Set temperature value<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature and to<br>
	 * acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getSetTemperatureValue();
	/**
	 * Property name : Set temperature value<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature and to<br>
	 * acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidSetTemperatureValue(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set value of relative humidity in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {return false;}
	/**
	 * Property name : Set value of relative humidity in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfRelativeHumidityInDehumidifyingMode() {return null;}
	/**
	 * Property name : Set value of relative humidity in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set temperature value in cooling mode<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetTemperatureValueInCoolingMode(byte[] edt) {return false;}
	/**
	 * Property name : Set temperature value in cooling mode<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetTemperatureValueInCoolingMode() {return null;}
	/**
	 * Property name : Set temperature value in cooling mode<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetTemperatureValueInCoolingMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set temperature value in heating mode<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetTemperatureValueInHeatingMode(byte[] edt) {return false;}
	/**
	 * Property name : Set temperature value in heating mode<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetTemperatureValueInHeatingMode() {return null;}
	/**
	 * Property name : Set temperature value in heating mode<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetTemperatureValueInHeatingMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set temperature value in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetTemperatureValueInDehumidifyingMode(byte[] edt) {return false;}
	/**
	 * Property name : Set temperature value in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetTemperatureValueInDehumidifyingMode() {return null;}
	/**
	 * Property name : Set temperature value in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50  )<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetTemperatureValueInDehumidifyingMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Rated power consumption<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents of property :<br>
	 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast<br>
	 * <br>
	 * Data type : unsigned short x 4<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedPowerConsumption() {return null;}
	/**
	 * Property name : Rated power consumption<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents of property :<br>
	 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast<br>
	 * <br>
	 * Data type : unsigned short x 4<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedPowerConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measured value of current consumption<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured value of current consumption<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredValueOfCurrentConsumption() {return null;}
	/**
	 * Property name : Measured value of current consumption<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured value of current consumption<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredValueOfCurrentConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured value of room relative humidity<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured value of room relative humidity<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100. C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredValueOfRoomRelativeHumidity() {return null;}
	/**
	 * Property name : Measured value of room relative humidity<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured value of room relative humidity<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100. C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredValueOfRoomRelativeHumidity(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured value of room temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured value of room temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80.0x7D (-127.125.C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredValueOfRoomTemperature() {return null;}
	/**
	 * Property name : Measured value of room temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured value of room temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80.0x7D (-127.125.C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredValueOfRoomTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set temperature value of user remote control<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents of property :<br>
	 * Set temperature value of user remote control<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50.C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetTemperatureValueOfUserRemoteControl() {return null;}
	/**
	 * Property name : Set temperature value of user remote control<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents of property :<br>
	 * Set temperature value of user remote control<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50.C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetTemperatureValueOfUserRemoteControl(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured cooled air temperature<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cooled air temperature at the outlet.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (-127 to 125  C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredCooledAirTemperature() {return null;}
	/**
	 * Property name : Measured cooled air temperature<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cooled air temperature at the outlet.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (-127 to 125  C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredCooledAirTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured outdoor air temperature<br>
	 * <br>
	 * EPC : 0xBE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured outdoor air temperature.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (-127 to 125  C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredOutdoorAirTemperature() {return null;}
	/**
	 * Property name : Measured outdoor air temperature<br>
	 * <br>
	 * EPC : 0xBE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured outdoor air temperature.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (-127 to 125  C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredOutdoorAirTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Relative temperature setting<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (-12.7  C to 12.5  C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 0.1
. C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRelativeTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Relative temperature setting<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (-12.7  C to 12.5  C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 0.1
. C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRelativeTemperatureSetting() {return null;}
	/**
	 * Property name : Relative temperature setting<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (-12.7  C to 12.5  C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 0.1
. C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRelativeTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Air flow rate setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow rate control function used = 0x41<br>
	 * Air flow rate = 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air flow rate setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow rate control function used = 0x41<br>
	 * Air flow rate = 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAirFlowRateSetting() {return null;}
	/**
	 * Property name : Air flow rate setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow rate control function used = 0x41<br>
	 * Air flow rate = 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAirFlowRateSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Automatic control of air flow direction setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which<br>
	 * the automatic air flow direction control function is to be used, and to acquire<br>
	 * the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41, non-automatic =<br>
	 * 0x42, automatic (vertical) = 0x43,<br>
	 * automatic (horizontal) = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic control of air flow direction setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which<br>
	 * the automatic air flow direction control function is to be used, and to acquire<br>
	 * the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41, non-automatic =<br>
	 * 0x42, automatic (vertical) = 0x43,<br>
	 * automatic (horizontal) = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAutomaticControlOfAirFlowDirectionSetting() {return null;}
	/**
	 * Property name : Automatic control of air flow direction setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which<br>
	 * the automatic air flow direction control function is to be used, and to acquire<br>
	 * the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41, non-automatic =<br>
	 * 0x42, automatic (vertical) = 0x43,<br>
	 * automatic (horizontal) = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Automatic swing of air flow
setting<br>
	 * <br>
	 * EPC : 0xA3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used<br>
	 * (vertical and horizontal) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAutomaticSwingOfAirFlowSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic swing of air flow
setting<br>
	 * <br>
	 * EPC : 0xA3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used<br>
	 * (vertical and horizontal) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAutomaticSwingOfAirFlowSetting() {return null;}
	/**
	 * Property name : Automatic swing of air flow
setting<br>
	 * <br>
	 * EPC : 0xA3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used<br>
	 * (vertical and horizontal) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAutomaticSwingOfAirFlowSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Air flow direction (vertical) setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAirFlowDirectionVerticalSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air flow direction (vertical) setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAirFlowDirectionVerticalSetting() {return null;}
	/**
	 * Property name : Air flow direction (vertical) setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAirFlowDirectionVerticalSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Air flow direction (horizontal) setting<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
	 * = 0x44 (for a full list of the predefined<br>
	 * patterns, see the table in the subsection defining the detailed requirements for this property.<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAirFlowDirectionHorizontalSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air flow direction (horizontal) setting<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
	 * = 0x44 (for a full list of the predefined<br>
	 * patterns, see the table in the subsection defining the detailed requirements for this property.<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAirFlowDirectionHorizontalSetting() {return null;}
	/**
	 * Property name : Air flow direction (horizontal) setting<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
	 * = 0x44 (for a full list of the predefined<br>
	 * patterns, see the table in the subsection defining the detailed requirements for this property.<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAirFlowDirectionHorizontalSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Special state<br>
	 * <br>
	 * EPC : 0xAA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates if the air conditioner is in a  gspecial h state (i.e. the  gdefrosting, h  gpreheating, h or  gheat removal h state).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  gNormal operation h state = 0x40,  gDefrosting h state = 0x41,  gPreheating h state = 0x42,<br>
	 *  gHeat removal h state = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSpecialState() {return null;}
	/**
	 * Property name : Special state<br>
	 * <br>
	 * EPC : 0xAA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates if the air conditioner is in a  gspecial h state (i.e. the  gdefrosting, h  gpreheating, h or  gheat removal h state).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  gNormal operation h state = 0x40,  gDefrosting h state = 0x41,  gPreheating h state = 0x42,<br>
	 *  gHeat removal h state = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSpecialState(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Non-priority state<br>
	 * <br>
	 * EPC : 0xAB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to indicate when the air conditioner is in a  gnon-priority h state.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  gNormal operation h state = 0x40,<br>
	 *  gNon-priority h state = 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getNonPriorityState() {return null;}
	/**
	 * Property name : Non-priority state<br>
	 * <br>
	 * EPC : 0xAB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to indicate when the air conditioner is in a  gnon-priority h state.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 *  gNormal operation h state = 0x40,<br>
	 *  gNon-priority h state = 0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidNonPriorityState(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Ventilation function setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setVentilationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ventilation function setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getVentilationFunctionSetting() {return null;}
	/**
	 * Property name : Ventilation function setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidVentilationFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Humidifier function setting<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setHumidifierFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Humidifier function setting<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getHumidifierFunctionSetting() {return null;}
	/**
	 * Property name : Humidifier function setting<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidHumidifierFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to<br>
	 * acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to<br>
	 * acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to<br>
	 * acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidVentilationAirFlowRateSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Degree of humidification setting<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of the degree of humidification = 0x41<br>
	 * Degree of humidification = 0x31 to<br>
	 * 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDegreeOfHumidificationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Degree of humidification setting<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of the degree of humidification = 0x41<br>
	 * Degree of humidification = 0x31 to<br>
	 * 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDegreeOfHumidificationSetting() {return null;}
	/**
	 * Property name : Degree of humidification setting<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of the degree of humidification = 0x41<br>
	 * Degree of humidification = 0x31 to<br>
	 * 0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDegreeOfHumidificationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Mounted air cleaning method<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents of property :<br>
	 * A bitmap indicates mounted method of exercising air cleaning function.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about electrical dust collection method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 - Mounted<br>
	 * Bit 1: Information about cluster ion method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 . Mounted<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMountedAirCleaningMethod() {return null;}
	/**
	 * Property name : Mounted air cleaning method<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents of property :<br>
	 * A bitmap indicates mounted method of exercising air cleaning function.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about electrical dust collection method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 - Mounted<br>
	 * Bit 1: Information about cluster ion method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 . Mounted<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMountedAirCleaningMethod(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Air purifier function setting<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents of property :<br>
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function.<br>
	 * Element 1: Indicates whether or not to use the cluster ion-based air purifier function.<br>
	 * Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char x 8<br>
	 * <br>
	 * Data size : 8 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAirPurifierFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air purifier function setting<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents of property :<br>
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function.<br>
	 * Element 1: Indicates whether or not to use the cluster ion-based air purifier function.<br>
	 * Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char x 8<br>
	 * <br>
	 * Data size : 8 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAirPurifierFunctionSetting() {return null;}
	/**
	 * Property name : Air purifier function setting<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents of property :<br>
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function.<br>
	 * Element 1: Indicates whether or not to use the cluster ion-based air purifier function.<br>
	 * Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char x 8<br>
	 * <br>
	 * Data size : 8 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAirPurifierFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Mounted air refresh method<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents of property :<br>
	 * A bitmap indicates mounted method for exercising refresh function.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about minus ion method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 - Mounted<br>
	 * Bit 1: Information about cluster ion method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 . Mounted<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMountedAirRefreshMethod() {return null;}
	/**
	 * Property name : Mounted air refresh method<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents of property :<br>
	 * A bitmap indicates mounted method for exercising refresh function.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about minus ion method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 - Mounted<br>
	 * Bit 1: Information about cluster ion method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 . Mounted<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMountedAirRefreshMethod(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Air refresher function setting<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents of property :<br>
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the minus ion-based air refresher function.<br>
	 * Element 1: Indicates whether or not to use the cluster ion-based air refresher function.<br>
	 * Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char x 8<br>
	 * <br>
	 * Data size : 8 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAirRefresherFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air refresher function setting<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents of property :<br>
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the minus ion-based air refresher function.<br>
	 * Element 1: Indicates whether or not to use the cluster ion-based air refresher function.<br>
	 * Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char x 8<br>
	 * <br>
	 * Data size : 8 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAirRefresherFunctionSetting() {return null;}
	/**
	 * Property name : Air refresher function setting<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents of property :<br>
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the minus ion-based air refresher function.<br>
	 * Element 1: Indicates whether or not to use the cluster ion-based air refresher function.<br>
	 * Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char x 8<br>
	 * <br>
	 * Data size : 8 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAirRefresherFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Mounted
self-cleaning
method<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents of property :<br>
	 * A bitmap indicates mounted method for exercising self-cleaning function.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about ozone cleaning method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 - Mounted<br>
	 * Bit 1: Information about drying method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 . Mounted<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMountedSelfCleaningMethod() {return null;}
	/**
	 * Property name : Mounted
self-cleaning
method<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents of property :<br>
	 * A bitmap indicates mounted method for exercising self-cleaning function.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about ozone cleaning method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 - Mounted<br>
	 * Bit 1: Information about drying method mounting<br>
	 * 0 - Not mounted<br>
	 * 1 . Mounted<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMountedSelfCleaningMethod(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Self-cleaning function setting<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents of property :<br>
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of<br>
	 * self-cleaning to achieve with the<br>
	 * self-cleaning function, and to acquire<br>
	 * the current settings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function.<br>
	 * Element 1: Indicates whether or not to use the drying-based self-cleaning function.<br>
	 * Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char x 8<br>
	 * <br>
	 * Data size : 8 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSelfCleaningFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Self-cleaning function setting<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents of property :<br>
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of<br>
	 * self-cleaning to achieve with the<br>
	 * self-cleaning function, and to acquire<br>
	 * the current settings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function.<br>
	 * Element 1: Indicates whether or not to use the drying-based self-cleaning function.<br>
	 * Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char x 8<br>
	 * <br>
	 * Data size : 8 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSelfCleaningFunctionSetting() {return null;}
	/**
	 * Property name : Self-cleaning function setting<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents of property :<br>
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of<br>
	 * self-cleaning to achieve with the<br>
	 * self-cleaning function, and to acquire<br>
	 * the current settings.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function.<br>
	 * Element 1: Indicates whether or not to use the drying-based self-cleaning function.<br>
	 * Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char x 8<br>
	 * <br>
	 * Data size : 8 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSelfCleaningFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Special function setting<br>
	 * <br>
	 * EPC : 0xCC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44<br>
	 * 0x45 . : Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSpecialFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Special function setting<br>
	 * <br>
	 * EPC : 0xCC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44<br>
	 * 0x45 . : Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSpecialFunctionSetting() {return null;}
	/**
	 * Property name : Special function setting<br>
	 * <br>
	 * EPC : 0xCC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44<br>
	 * 0x45 . : Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSpecialFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Operation status of components<br>
	 * <br>
	 * EPC : 0xCD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Operation status of the compressor:<br>
	 * 0: Not operating<br>
	 * 1: In operation<br>
	 * Bit 1: Operation status of the thermostat:<br>
	 * 0: Thermostat OFF<br>
	 * 1: Thermostat ON<br>
	 * Bits 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getOperationStatusOfComponents() {return null;}
	/**
	 * Property name : Operation status of components<br>
	 * <br>
	 * EPC : 0xCD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Operation status of the compressor:<br>
	 * 0: Not operating<br>
	 * 1: In operation<br>
	 * Bit 1: Operation status of the thermostat:<br>
	 * 0: Thermostat OFF<br>
	 * 1: Thermostat ON<br>
	 * Bits 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOperationStatusOfComponents(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Thermostat setting override function<br>
	 * <br>
	 * EPC : 0xCE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setThermostatSettingOverrideFunction(byte[] edt) {return false;}
	/**
	 * Property name : Thermostat setting override function<br>
	 * <br>
	 * EPC : 0xCE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidThermostatSettingOverrideFunction(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Air purification mode setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Air purification ON  0x41,OFF  <br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAirPurificationModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air purification mode setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Air purification ON  0x41,OFF  <br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAirPurificationModeSetting() {return null;}
	/**
	 * Property name : Air purification mode setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Air purification ON  0x41,OFF  <br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAirPurificationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
	 * 0x42, time-based reservation function<br>
	 * is ON = 0x43, relative time-based<br>
	 * reservation function is ON = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerBasedReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
	 * 0x42, time-based reservation function<br>
	 * is ON = 0x43, relative time-based<br>
	 * reservation function is ON = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerBasedReservationSetting() {return null;}
	/**
	 * Property name : ON timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
	 * 0x42, time-based reservation function<br>
	 * is ON = 0x43, relative time-based<br>
	 * reservation function is ON = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerBasedReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer setting
(time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the<br>
	 * time-based reservation function in the<br>
	 * HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting
(time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the<br>
	 * time-based reservation function in the<br>
	 * HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	/**
	 * Property name : ON timer setting
(time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the<br>
	 * time-based reservation function in the<br>
	 * HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSettingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : ON timer setting
(relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting
(relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	/**
	 * Property name : ON timer setting
(relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSettingRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
	 * 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerBasedReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
	 * 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerBasedReservationSetting() {return null;}
	/**
	 * Property name : OFF timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
	 * 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerBasedReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the<br>
	 * time-based reservation function in the<br>
	 * HH:MM format and to acquire the<br>
	 * current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the<br>
	 * time-based reservation function in the<br>
	 * HH:MM format and to acquire the<br>
	 * current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	/**
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the<br>
	 * time-based reservation function in the<br>
	 * HH:MM format and to acquire the<br>
	 * current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerSettingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerSettingRelativeTime() {return null;}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFF: 0 to 0x3B<br>
	 * (= 0 to 255): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerSettingRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_OPERATION_MODE_SETTING : return setOperationModeSetting(property.edt);
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : return setAutomaticTemperatureControlSetting(property.edt);
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : return setNormalHighSpeedSilentOperationSetting(property.edt);
		case EPC_SET_TEMPERATURE_VALUE : return setSetTemperatureValue(property.edt);
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : return setSetValueOfRelativeHumidityInDehumidifyingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : return setSetTemperatureValueInCoolingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : return setSetTemperatureValueInHeatingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : return setSetTemperatureValueInDehumidifyingMode(property.edt);
		case EPC_RELATIVE_TEMPERATURE_SETTING : return setRelativeTemperatureSetting(property.edt);
		case EPC_AIR_FLOW_RATE_SETTING : return setAirFlowRateSetting(property.edt);
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : return setAutomaticControlOfAirFlowDirectionSetting(property.edt);
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : return setAutomaticSwingOfAirFlowSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : return setAirFlowDirectionVerticalSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : return setAirFlowDirectionHorizontalSetting(property.edt);
		case EPC_VENTILATION_FUNCTION_SETTING : return setVentilationFunctionSetting(property.edt);
		case EPC_HUMIDIFIER_FUNCTION_SETTING : return setHumidifierFunctionSetting(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return setVentilationAirFlowRateSetting(property.edt);
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : return setDegreeOfHumidificationSetting(property.edt);
		case EPC_AIR_PURIFIER_FUNCTION_SETTING : return setAirPurifierFunctionSetting(property.edt);
		case EPC_AIR_REFRESHER_FUNCTION_SETTING : return setAirRefresherFunctionSetting(property.edt);
		case EPC_SELF_CLEANING_FUNCTION_SETTING : return setSelfCleaningFunctionSetting(property.edt);
		case EPC_SPECIAL_FUNCTION_SETTING : return setSpecialFunctionSetting(property.edt);
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : return setThermostatSettingOverrideFunction(property.edt);
		case EPC_AIR_PURIFICATION_MODE_SETTING : return setAirPurificationModeSetting(property.edt);
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING : return setOnTimerBasedReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING_TIME : return setOnTimerSettingTime(property.edt);
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME : return setOnTimerSettingRelativeTime(property.edt);
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : return setOffTimerBasedReservationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_TIME : return setOffTimerSettingTime(property.edt);
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : return setOffTimerSettingRelativeTime(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING : return getOperationModeSetting();
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : return getAutomaticTemperatureControlSetting();
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : return getNormalHighSpeedSilentOperationSetting();
		case EPC_SET_TEMPERATURE_VALUE : return getSetTemperatureValue();
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : return getSetValueOfRelativeHumidityInDehumidifyingMode();
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : return getSetTemperatureValueInCoolingMode();
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : return getSetTemperatureValueInHeatingMode();
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : return getSetTemperatureValueInDehumidifyingMode();
		case EPC_RATED_POWER_CONSUMPTION : return getRatedPowerConsumption();
		case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION : return getMeasuredValueOfCurrentConsumption();
		case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY : return getMeasuredValueOfRoomRelativeHumidity();
		case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE : return getMeasuredValueOfRoomTemperature();
		case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL : return getSetTemperatureValueOfUserRemoteControl();
		case EPC_MEASURED_COOLED_AIR_TEMPERATURE : return getMeasuredCooledAirTemperature();
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE : return getMeasuredOutdoorAirTemperature();
		case EPC_RELATIVE_TEMPERATURE_SETTING : return getRelativeTemperatureSetting();
		case EPC_AIR_FLOW_RATE_SETTING : return getAirFlowRateSetting();
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : return getAutomaticControlOfAirFlowDirectionSetting();
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : return getAutomaticSwingOfAirFlowSetting();
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : return getAirFlowDirectionVerticalSetting();
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : return getAirFlowDirectionHorizontalSetting();
		case EPC_SPECIAL_STATE : return getSpecialState();
		case EPC_NON_PRIORITY_STATE : return getNonPriorityState();
		case EPC_VENTILATION_FUNCTION_SETTING : return getVentilationFunctionSetting();
		case EPC_HUMIDIFIER_FUNCTION_SETTING : return getHumidifierFunctionSetting();
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return getVentilationAirFlowRateSetting();
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : return getDegreeOfHumidificationSetting();
		case EPC_MOUNTED_AIR_CLEANING_METHOD : return getMountedAirCleaningMethod();
		case EPC_AIR_PURIFIER_FUNCTION_SETTING : return getAirPurifierFunctionSetting();
		case EPC_MOUNTED_AIR_REFRESH_METHOD : return getMountedAirRefreshMethod();
		case EPC_AIR_REFRESHER_FUNCTION_SETTING : return getAirRefresherFunctionSetting();
		case EPC_MOUNTED_SELF_CLEANING_METHOD : return getMountedSelfCleaningMethod();
		case EPC_SELF_CLEANING_FUNCTION_SETTING : return getSelfCleaningFunctionSetting();
		case EPC_SPECIAL_FUNCTION_SETTING : return getSpecialFunctionSetting();
		case EPC_OPERATION_STATUS_OF_COMPONENTS : return getOperationStatusOfComponents();
		case EPC_AIR_PURIFICATION_MODE_SETTING : return getAirPurificationModeSetting();
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING : return getOnTimerBasedReservationSetting();
		case EPC_ON_TIMER_SETTING_TIME : return getOnTimerSettingTime();
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME : return getOnTimerSettingRelativeTime();
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : return getOffTimerBasedReservationSetting();
		case EPC_OFF_TIMER_SETTING_TIME : return getOffTimerSettingTime();
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : return getOffTimerSettingRelativeTime();
		default : return null;
		}
	}

	@Override
	protected boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_OPERATION_MODE_SETTING : return isValidOperationModeSetting(property.edt);
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : return isValidAutomaticTemperatureControlSetting(property.edt);
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : return isValidNormalHighSpeedSilentOperationSetting(property.edt);
		case EPC_SET_TEMPERATURE_VALUE : return isValidSetTemperatureValue(property.edt);
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : return isValidSetValueOfRelativeHumidityInDehumidifyingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : return isValidSetTemperatureValueInCoolingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : return isValidSetTemperatureValueInHeatingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : return isValidSetTemperatureValueInDehumidifyingMode(property.edt);
		case EPC_RATED_POWER_CONSUMPTION : return isValidRatedPowerConsumption(property.edt);
		case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION : return isValidMeasuredValueOfCurrentConsumption(property.edt);
		case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY : return isValidMeasuredValueOfRoomRelativeHumidity(property.edt);
		case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE : return isValidMeasuredValueOfRoomTemperature(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL : return isValidSetTemperatureValueOfUserRemoteControl(property.edt);
		case EPC_MEASURED_COOLED_AIR_TEMPERATURE : return isValidMeasuredCooledAirTemperature(property.edt);
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE : return isValidMeasuredOutdoorAirTemperature(property.edt);
		case EPC_RELATIVE_TEMPERATURE_SETTING : return isValidRelativeTemperatureSetting(property.edt);
		case EPC_AIR_FLOW_RATE_SETTING : return isValidAirFlowRateSetting(property.edt);
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : return isValidAutomaticControlOfAirFlowDirectionSetting(property.edt);
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : return isValidAutomaticSwingOfAirFlowSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : return isValidAirFlowDirectionVerticalSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : return isValidAirFlowDirectionHorizontalSetting(property.edt);
		case EPC_SPECIAL_STATE : return isValidSpecialState(property.edt);
		case EPC_NON_PRIORITY_STATE : return isValidNonPriorityState(property.edt);
		case EPC_VENTILATION_FUNCTION_SETTING : return isValidVentilationFunctionSetting(property.edt);
		case EPC_HUMIDIFIER_FUNCTION_SETTING : return isValidHumidifierFunctionSetting(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return isValidVentilationAirFlowRateSetting(property.edt);
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : return isValidDegreeOfHumidificationSetting(property.edt);
		case EPC_MOUNTED_AIR_CLEANING_METHOD : return isValidMountedAirCleaningMethod(property.edt);
		case EPC_AIR_PURIFIER_FUNCTION_SETTING : return isValidAirPurifierFunctionSetting(property.edt);
		case EPC_MOUNTED_AIR_REFRESH_METHOD : return isValidMountedAirRefreshMethod(property.edt);
		case EPC_AIR_REFRESHER_FUNCTION_SETTING : return isValidAirRefresherFunctionSetting(property.edt);
		case EPC_MOUNTED_SELF_CLEANING_METHOD : return isValidMountedSelfCleaningMethod(property.edt);
		case EPC_SELF_CLEANING_FUNCTION_SETTING : return isValidSelfCleaningFunctionSetting(property.edt);
		case EPC_SPECIAL_FUNCTION_SETTING : return isValidSpecialFunctionSetting(property.edt);
		case EPC_OPERATION_STATUS_OF_COMPONENTS : return isValidOperationStatusOfComponents(property.edt);
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : return isValidThermostatSettingOverrideFunction(property.edt);
		case EPC_AIR_PURIFICATION_MODE_SETTING : return isValidAirPurificationModeSetting(property.edt);
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING : return isValidOnTimerBasedReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING_TIME : return isValidOnTimerSettingTime(property.edt);
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME : return isValidOnTimerSettingRelativeTime(property.edt);
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : return isValidOffTimerBasedReservationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_TIME : return isValidOffTimerSettingTime(property.edt);
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : return isValidOffTimerSettingRelativeTime(property.edt);
		default : return false;
		}
	}

	@Override
	public Setter set() {
		return new Setter(this, true, false);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(this, responseRequired, false);
	}

	@Override
	public Getter get() {
		return new Getter(this, false);
	}

	@Override
	public Informer inform() {
		return new Informer(this, !isProxy());
	}
	
	@Override
	protected Informer inform(boolean multicast) {
		return new Informer(this, multicast);
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_OPERATION_MODE_SETTING : 
				onSetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : 
				onSetAutomaticTemperatureControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : 
				onSetNormalHighSpeedSilentOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE : 
				onSetSetTemperatureValue(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : 
				onSetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : 
				onSetSetTemperatureValueInCoolingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : 
				onSetSetTemperatureValueInHeatingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : 
				onSetSetTemperatureValueInDehumidifyingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TEMPERATURE_SETTING : 
				onSetRelativeTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_RATE_SETTING : 
				onSetAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : 
				onSetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : 
				onSetAutomaticSwingOfAirFlowSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : 
				onSetAirFlowDirectionVerticalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : 
				onSetAirFlowDirectionHorizontalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_FUNCTION_SETTING : 
				onSetVentilationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMIDIFIER_FUNCTION_SETTING : 
				onSetHumidifierFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onSetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : 
				onSetDegreeOfHumidificationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_PURIFIER_FUNCTION_SETTING : 
				onSetAirPurifierFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_REFRESHER_FUNCTION_SETTING : 
				onSetAirRefresherFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SELF_CLEANING_FUNCTION_SETTING : 
				onSetSelfCleaningFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_FUNCTION_SETTING : 
				onSetSpecialFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : 
				onSetThermostatSettingOverrideFunction(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_PURIFICATION_MODE_SETTING : 
				onSetAirPurificationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING : 
				onSetOnTimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_TIME : 
				onSetOnTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME : 
				onSetOnTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : 
				onSetOffTimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_TIME : 
				onSetOffTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : 
				onSetOffTimerSettingRelativeTime(eoj, tid, esv, property, success);
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
			case EPC_OPERATION_MODE_SETTING : 
				onGetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : 
				onGetAutomaticTemperatureControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : 
				onGetNormalHighSpeedSilentOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE : 
				onGetSetTemperatureValue(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : 
				onGetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : 
				onGetSetTemperatureValueInCoolingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : 
				onGetSetTemperatureValueInHeatingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : 
				onGetSetTemperatureValueInDehumidifyingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_CONSUMPTION : 
				onGetRatedPowerConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION : 
				onGetMeasuredValueOfCurrentConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY : 
				onGetMeasuredValueOfRoomRelativeHumidity(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE : 
				onGetMeasuredValueOfRoomTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL : 
				onGetSetTemperatureValueOfUserRemoteControl(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_COOLED_AIR_TEMPERATURE : 
				onGetMeasuredCooledAirTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE : 
				onGetMeasuredOutdoorAirTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TEMPERATURE_SETTING : 
				onGetRelativeTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_RATE_SETTING : 
				onGetAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : 
				onGetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : 
				onGetAutomaticSwingOfAirFlowSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : 
				onGetAirFlowDirectionVerticalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : 
				onGetAirFlowDirectionHorizontalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_STATE : 
				onGetSpecialState(eoj, tid, esv, property, success);
				return true;
			case EPC_NON_PRIORITY_STATE : 
				onGetNonPriorityState(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_FUNCTION_SETTING : 
				onGetVentilationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMIDIFIER_FUNCTION_SETTING : 
				onGetHumidifierFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onGetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : 
				onGetDegreeOfHumidificationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MOUNTED_AIR_CLEANING_METHOD : 
				onGetMountedAirCleaningMethod(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_PURIFIER_FUNCTION_SETTING : 
				onGetAirPurifierFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MOUNTED_AIR_REFRESH_METHOD : 
				onGetMountedAirRefreshMethod(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_REFRESHER_FUNCTION_SETTING : 
				onGetAirRefresherFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MOUNTED_SELF_CLEANING_METHOD : 
				onGetMountedSelfCleaningMethod(eoj, tid, esv, property, success);
				return true;
			case EPC_SELF_CLEANING_FUNCTION_SETTING : 
				onGetSelfCleaningFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_FUNCTION_SETTING : 
				onGetSpecialFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_STATUS_OF_COMPONENTS : 
				onGetOperationStatusOfComponents(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_PURIFICATION_MODE_SETTING : 
				onGetAirPurificationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING : 
				onGetOnTimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_TIME : 
				onGetOnTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME : 
				onGetOnTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : 
				onGetOffTimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_TIME : 
				onGetOffTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME : 
				onGetOffTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
		 * Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
		 * Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41<br>
		 * Non-automatic = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41<br>
		 * Non-automatic = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the type of operation<br>
		 * ( gnormal, h  ghigh-speed h or  gsilent h),<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41<br>
		 * High-speed operation: 0x42<br>
		 * Silent operation: 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the type of operation<br>
		 * ( gnormal, h  ghigh-speed h or  gsilent h),<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41<br>
		 * High-speed operation: 0x42<br>
		 * Silent operation: 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetSetTemperatureValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetSetTemperatureValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power consumption<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast<br>
		 * <br>
		 * Data type : unsigned short x 4<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedPowerConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured value of current consumption<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured value of current consumption<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredValueOfCurrentConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured value of room relative humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured value of room relative humidity<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100. C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured value of room temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured value of room temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80.0x7D (-127.125.C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredValueOfRoomTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value of user remote control<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * Set temperature value of user remote control<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50.C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSetTemperatureValueOfUserRemoteControl(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cooled air temperature<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cooled air temperature at the outlet.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-127 to 125  C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredCooledAirTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured outdoor air temperature<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured outdoor air temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-127 to 125  C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredOutdoorAirTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-12.7  C to 12.5  C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1
. C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-12.7  C to 12.5  C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1
. C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which<br>
		 * the automatic air flow direction control function is to be used, and to acquire<br>
		 * the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42, automatic (vertical) = 0x43,<br>
		 * automatic (horizontal) = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which<br>
		 * the automatic air flow direction control function is to be used, and to acquire<br>
		 * the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42, automatic (vertical) = 0x43,<br>
		 * automatic (horizontal) = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic swing of air flow
setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used<br>
		 * (vertical and horizontal) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic swing of air flow
setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used<br>
		 * (vertical and horizontal) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44 (for a full list of the predefined<br>
		 * patterns, see the table in the subsection defining the detailed requirements for this property.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44 (for a full list of the predefined<br>
		 * patterns, see the table in the subsection defining the detailed requirements for this property.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates if the air conditioner is in a  gspecial h state (i.e. the  gdefrosting, h  gpreheating, h or  gheat removal h state).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gNormal operation h state = 0x40,  gDefrosting h state = 0x41,  gPreheating h state = 0x42,<br>
		 *  gHeat removal h state = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSpecialState(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Non-priority state<br>
		 * <br>
		 * EPC : 0xAB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to indicate when the air conditioner is in a  gnon-priority h state.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gNormal operation h state = 0x40,<br>
		 *  gNon-priority h state = 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetNonPriorityState(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetVentilationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetVentilationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetHumidifierFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetHumidifierFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41<br>
		 * Degree of humidification = 0x31 to<br>
		 * 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDegreeOfHumidificationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41<br>
		 * Degree of humidification = 0x31 to<br>
		 * 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDegreeOfHumidificationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Mounted air cleaning method<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * A bitmap indicates mounted method of exercising air cleaning function.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about electrical dust collection method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 - Mounted<br>
		 * Bit 1: Information about cluster ion method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 . Mounted<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMountedAirCleaningMethod(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air purifier function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAirPurifierFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air purifier function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAirPurifierFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Mounted air refresh method<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * A bitmap indicates mounted method for exercising refresh function.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about minus ion method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 - Mounted<br>
		 * Bit 1: Information about cluster ion method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 . Mounted<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMountedAirRefreshMethod(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air refresher function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAirRefresherFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air refresher function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAirRefresherFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Mounted
self-cleaning
method<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * A bitmap indicates mounted method for exercising self-cleaning function.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about ozone cleaning method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 - Mounted<br>
		 * Bit 1: Information about drying method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 . Mounted<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMountedSelfCleaningMethod(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of<br>
		 * self-cleaning to achieve with the<br>
		 * self-cleaning function, and to acquire<br>
		 * the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function.<br>
		 * Element 1: Indicates whether or not to use the drying-based self-cleaning function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSelfCleaningFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of<br>
		 * self-cleaning to achieve with the<br>
		 * self-cleaning function, and to acquire<br>
		 * the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function.<br>
		 * Element 1: Indicates whether or not to use the drying-based self-cleaning function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSelfCleaningFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44<br>
		 * 0x45 . : Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSpecialFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44<br>
		 * 0x45 . : Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSpecialFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status of components<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Operation status of the compressor:<br>
		 * 0: Not operating<br>
		 * 1: In operation<br>
		 * Bit 1: Operation status of the thermostat:<br>
		 * 0: Thermostat OFF<br>
		 * 1: Thermostat ON<br>
		 * Bits 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetOperationStatusOfComponents(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Thermostat setting override function<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		protected void onSetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON  0x41,OFF  <br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAirPurificationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON  0x41,OFF  <br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAirPurificationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function<br>
		 * is ON = 0x43, relative time-based<br>
		 * reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function<br>
		 * is ON = 0x43, relative time-based<br>
		 * reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(EchoObject eoj, boolean responseRequired, boolean multicast) {
			super(eoj, responseRequired, multicast);
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
		public Setter reqSetPositionInformation(byte[] edt) {
			return (Setter)super.reqSetPositionInformation(edt);
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
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
		 * Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41<br>
		 * Non-automatic = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the type of operation<br>
		 * ( gnormal, h  ghigh-speed h or  gsilent h),<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41<br>
		 * High-speed operation: 0x42<br>
		 * Silent operation: 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetNormalHighSpeedSilentOperationSetting(byte[] edt) {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetSetTemperatureValue(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE, edt);
			return this;
		}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE, edt);
			return this;
		}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetTemperatureValueInCoolingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE, edt);
			return this;
		}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetTemperatureValueInHeatingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE, edt);
			return this;
		}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetTemperatureValueInDehumidifyingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE, edt);
			return this;
		}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-12.7  C to 12.5  C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1
. C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRelativeTemperatureSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which<br>
		 * the automatic air flow direction control function is to be used, and to acquire<br>
		 * the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42, automatic (vertical) = 0x43,<br>
		 * automatic (horizontal) = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Automatic swing of air flow
setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used<br>
		 * (vertical and horizontal) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAutomaticSwingOfAirFlowSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAirFlowDirectionVerticalSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44 (for a full list of the predefined<br>
		 * patterns, see the table in the subsection defining the detailed requirements for this property.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAirFlowDirectionHorizontalSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetVentilationFunctionSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetHumidifierFunctionSetting(byte[] edt) {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41<br>
		 * Degree of humidification = 0x31 to<br>
		 * 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDegreeOfHumidificationSetting(byte[] edt) {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air purifier function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAirPurifierFunctionSetting(byte[] edt) {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air refresher function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAirRefresherFunctionSetting(byte[] edt) {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of<br>
		 * self-cleaning to achieve with the<br>
		 * self-cleaning function, and to acquire<br>
		 * the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function.<br>
		 * Element 1: Indicates whether or not to use the drying-based self-cleaning function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSelfCleaningFunctionSetting(byte[] edt) {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44<br>
		 * 0x45 . : Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSpecialFunctionSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Thermostat setting override function<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt) {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt);
			return this;
		}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON  0x41,OFF  <br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAirPurificationModeSetting(byte[] edt) {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function<br>
		 * is ON = 0x43, relative time-based<br>
		 * reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt);
			return this;
		}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
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
		public Getter reqGetPositionInformation() {
			return (Getter)super.reqGetPositionInformation();
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
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
		 * Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41<br>
		 * Non-automatic = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the type of operation<br>
		 * ( gnormal, h  ghigh-speed h or  gsilent h),<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41<br>
		 * High-speed operation: 0x42<br>
		 * Silent operation: 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetNormalHighSpeedSilentOperationSetting() {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetSetTemperatureValue() {
			addProperty(EPC_SET_TEMPERATURE_VALUE);
			return this;
		}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfRelativeHumidityInDehumidifyingMode() {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetTemperatureValueInCoolingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetTemperatureValueInHeatingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetTemperatureValueInDehumidifyingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Property name : Rated power consumption<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast<br>
		 * <br>
		 * Data type : unsigned short x 4<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerConsumption() {
			addProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured value of current consumption<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured value of current consumption<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredValueOfCurrentConsumption() {
			addProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured value of room relative humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured value of room relative humidity<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100. C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Measured value of room temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured value of room temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80.0x7D (-127.125.C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredValueOfRoomTemperature() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Set temperature value of user remote control<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * Set temperature value of user remote control<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50.C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetTemperatureValueOfUserRemoteControl() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL);
			return this;
		}
		/**
		 * Property name : Measured cooled air temperature<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cooled air temperature at the outlet.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-127 to 125  C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredCooledAirTemperature() {
			addProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured outdoor air temperature<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured outdoor air temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-127 to 125  C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-12.7  C to 12.5  C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1
. C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRelativeTemperatureSetting() {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which<br>
		 * the automatic air flow direction control function is to be used, and to acquire<br>
		 * the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42, automatic (vertical) = 0x43,<br>
		 * automatic (horizontal) = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAutomaticControlOfAirFlowDirectionSetting() {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic swing of air flow
setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used<br>
		 * (vertical and horizontal) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAutomaticSwingOfAirFlowSetting() {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAirFlowDirectionVerticalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44 (for a full list of the predefined<br>
		 * patterns, see the table in the subsection defining the detailed requirements for this property.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAirFlowDirectionHorizontalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		/**
		 * Property name : Special state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates if the air conditioner is in a  gspecial h state (i.e. the  gdefrosting, h  gpreheating, h or  gheat removal h state).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gNormal operation h state = 0x40,  gDefrosting h state = 0x41,  gPreheating h state = 0x42,<br>
		 *  gHeat removal h state = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSpecialState() {
			addProperty(EPC_SPECIAL_STATE);
			return this;
		}
		/**
		 * Property name : Non-priority state<br>
		 * <br>
		 * EPC : 0xAB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to indicate when the air conditioner is in a  gnon-priority h state.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gNormal operation h state = 0x40,<br>
		 *  gNon-priority h state = 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetNonPriorityState() {
			addProperty(EPC_NON_PRIORITY_STATE);
			return this;
		}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetVentilationFunctionSetting() {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetHumidifierFunctionSetting() {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41<br>
		 * Degree of humidification = 0x31 to<br>
		 * 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDegreeOfHumidificationSetting() {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted air cleaning method<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * A bitmap indicates mounted method of exercising air cleaning function.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about electrical dust collection method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 - Mounted<br>
		 * Bit 1: Information about cluster ion method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 . Mounted<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMountedAirCleaningMethod() {
			addProperty(EPC_MOUNTED_AIR_CLEANING_METHOD);
			return this;
		}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air purifier function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAirPurifierFunctionSetting() {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted air refresh method<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * A bitmap indicates mounted method for exercising refresh function.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about minus ion method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 - Mounted<br>
		 * Bit 1: Information about cluster ion method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 . Mounted<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMountedAirRefreshMethod() {
			addProperty(EPC_MOUNTED_AIR_REFRESH_METHOD);
			return this;
		}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air refresher function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAirRefresherFunctionSetting() {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted
self-cleaning
method<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * A bitmap indicates mounted method for exercising self-cleaning function.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about ozone cleaning method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 - Mounted<br>
		 * Bit 1: Information about drying method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 . Mounted<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMountedSelfCleaningMethod() {
			addProperty(EPC_MOUNTED_SELF_CLEANING_METHOD);
			return this;
		}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of<br>
		 * self-cleaning to achieve with the<br>
		 * self-cleaning function, and to acquire<br>
		 * the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function.<br>
		 * Element 1: Indicates whether or not to use the drying-based self-cleaning function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSelfCleaningFunctionSetting() {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44<br>
		 * 0x45 . : Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSpecialFunctionSetting() {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Operation status of components<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Operation status of the compressor:<br>
		 * 0: Not operating<br>
		 * 1: In operation<br>
		 * Bit 1: Operation status of the thermostat:<br>
		 * 0: Thermostat OFF<br>
		 * 1: Thermostat ON<br>
		 * Bits 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOperationStatusOfComponents() {
			addProperty(EPC_OPERATION_STATUS_OF_COMPONENTS);
			return this;
		}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON  0x41,OFF  <br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAirPurificationModeSetting() {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function<br>
		 * is ON = 0x43, relative time-based<br>
		 * reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerBasedReservationSetting() {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerBasedReservationSetting() {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
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
		public Informer reqInformPositionInformation() {
			return (Informer)super.reqInformPositionInformation();
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
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43<br>
		 * Dehumidification: 0x44<br>
		 * Air circulator: 0x45<br>
		 * Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41<br>
		 * Non-automatic = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the type of operation<br>
		 * ( gnormal, h  ghigh-speed h or  gsilent h),<br>
		 * and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41<br>
		 * High-speed operation: 0x42<br>
		 * Silent operation: 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformNormalHighSpeedSilentOperationSetting() {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformSetTemperatureValue() {
			addProperty(EPC_SET_TEMPERATURE_VALUE);
			return this;
		}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfRelativeHumidityInDehumidifyingMode() {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetTemperatureValueInCoolingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetTemperatureValueInHeatingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50  )<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetTemperatureValueInDehumidifyingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Property name : Rated power consumption<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast<br>
		 * <br>
		 * Data type : unsigned short x 4<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerConsumption() {
			addProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured value of current consumption<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured value of current consumption<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredValueOfCurrentConsumption() {
			addProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured value of room relative humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured value of room relative humidity<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100. C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Measured value of room temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured value of room temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80.0x7D (-127.125.C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredValueOfRoomTemperature() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Set temperature value of user remote control<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents of property :<br>
		 * Set temperature value of user remote control<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50.C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetTemperatureValueOfUserRemoteControl() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL);
			return this;
		}
		/**
		 * Property name : Measured cooled air temperature<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cooled air temperature at the outlet.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-127 to 125  C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredCooledAirTemperature() {
			addProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured outdoor air temperature<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured outdoor air temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-127 to 125  C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-12.7  C to 12.5  C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1
. C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRelativeTemperatureSetting() {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which<br>
		 * the automatic air flow direction control function is to be used, and to acquire<br>
		 * the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42, automatic (vertical) = 0x43,<br>
		 * automatic (horizontal) = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAutomaticControlOfAirFlowDirectionSetting() {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic swing of air flow
setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used<br>
		 * (vertical and horizontal) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAutomaticSwingOfAirFlowSetting() {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAirFlowDirectionVerticalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44 (for a full list of the predefined<br>
		 * patterns, see the table in the subsection defining the detailed requirements for this property.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAirFlowDirectionHorizontalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		/**
		 * Property name : Special state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates if the air conditioner is in a  gspecial h state (i.e. the  gdefrosting, h  gpreheating, h or  gheat removal h state).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gNormal operation h state = 0x40,  gDefrosting h state = 0x41,  gPreheating h state = 0x42,<br>
		 *  gHeat removal h state = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSpecialState() {
			addProperty(EPC_SPECIAL_STATE);
			return this;
		}
		/**
		 * Property name : Non-priority state<br>
		 * <br>
		 * EPC : 0xAB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to indicate when the air conditioner is in a  gnon-priority h state.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 *  gNormal operation h state = 0x40,<br>
		 *  gNon-priority h state = 0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformNonPriorityState() {
			addProperty(EPC_NON_PRIORITY_STATE);
			return this;
		}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformVentilationFunctionSetting() {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformHumidifierFunctionSetting() {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to<br>
		 * acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41<br>
		 * Degree of humidification = 0x31 to<br>
		 * 0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDegreeOfHumidificationSetting() {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted air cleaning method<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents of property :<br>
		 * A bitmap indicates mounted method of exercising air cleaning function.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about electrical dust collection method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 - Mounted<br>
		 * Bit 1: Information about cluster ion method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 . Mounted<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMountedAirCleaningMethod() {
			addProperty(EPC_MOUNTED_AIR_CLEANING_METHOD);
			return this;
		}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air purifier function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAirPurifierFunctionSetting() {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted air refresh method<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * A bitmap indicates mounted method for exercising refresh function.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about minus ion method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 - Mounted<br>
		 * Bit 1: Information about cluster ion method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 . Mounted<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMountedAirRefreshMethod() {
			addProperty(EPC_MOUNTED_AIR_REFRESH_METHOD);
			return this;
		}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function.<br>
		 * Element 1: Indicates whether or not to use the cluster ion-based air refresher function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAirRefresherFunctionSetting() {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted
self-cleaning
method<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * A bitmap indicates mounted method for exercising self-cleaning function.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about ozone cleaning method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 - Mounted<br>
		 * Bit 1: Information about drying method mounting<br>
		 * 0 - Not mounted<br>
		 * 1 . Mounted<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMountedSelfCleaningMethod() {
			addProperty(EPC_MOUNTED_SELF_CLEANING_METHOD);
			return this;
		}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of<br>
		 * self-cleaning to achieve with the<br>
		 * self-cleaning function, and to acquire<br>
		 * the current settings.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function.<br>
		 * Element 1: Indicates whether or not to use the drying-based self-cleaning function.<br>
		 * Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char x 8<br>
		 * <br>
		 * Data size : 8 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSelfCleaningFunctionSetting() {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44<br>
		 * 0x45 . : Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSpecialFunctionSetting() {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Operation status of components<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Operation status of the compressor:<br>
		 * 0: Not operating<br>
		 * 1: In operation<br>
		 * Bit 1: Operation status of the thermostat:<br>
		 * 0: Thermostat OFF<br>
		 * 1: Thermostat ON<br>
		 * Bits 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOperationStatusOfComponents() {
			addProperty(EPC_OPERATION_STATUS_OF_COMPONENTS);
			return this;
		}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON  0x41,OFF  <br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAirPurificationModeSetting() {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function<br>
		 * is ON = 0x43, relative time-based<br>
		 * reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerBasedReservationSetting() {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting
(time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : ON timer setting
(relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF =<br>
		 * 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerBasedReservationSetting() {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the<br>
		 * HH:MM format and to acquire the<br>
		 * current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFF: 0 to 0x3B<br>
		 * (= 0 to 255): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
	}

	public static class Proxy extends HomeAirConditioner {
		private byte mInstanceCode;
		public Proxy(byte instanceCode) {
			super();
			mInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mInstanceCode;
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
		protected boolean setOperationStatus(byte[] edt) {return false;}
		@Override
		protected boolean setOperationModeSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getOperationModeSetting() {return null;}
		@Override
		protected boolean setSetTemperatureValue(byte[] edt) {return false;}
		@Override
		protected byte[] getSetTemperatureValue() {return null;}
	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return new Setter(new Proxy(instanceCode), true, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(new Proxy(instanceCode), responseRequired, true);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(new Proxy(instanceCode), true);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(new Proxy(instanceCode), true);
	}

}
