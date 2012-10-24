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

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class HomeAirConditioner extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x30;

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
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract boolean setOperationModeSetting(byte[] edt);
	private final boolean _setOperationModeSetting(byte epc, byte[] edt) {
		boolean success = setOperationModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract byte[] getOperationModeSetting();
	private final byte[] _getOperationModeSetting(byte epc) {
		byte[] edt = getOperationModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br><br>Automatic = 0x41 Non-automatic = 0x42<br><br>Name : Automatic temperature control setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	private final boolean _setAutomaticTemperatureControlSetting(byte epc, byte[] edt) {
		boolean success = setAutomaticTemperatureControlSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br><br>Automatic = 0x41 Non-automatic = 0x42<br><br>Name : Automatic temperature control setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	private final byte[] _getAutomaticTemperatureControlSetting(byte epc) {
		byte[] edt = getAutomaticTemperatureControlSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the type of operation ( gnormal, h  ghigh-speed h or  gsilent h), and to acquire the current setting.<br><br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43<br><br>Name : Normal/high- speed/silent operation setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setNormalHighSpeedSilentOperationSetting(byte[] edt) {return false;}
	private final boolean _setNormalHighSpeedSilentOperationSetting(byte epc, byte[] edt) {
		boolean success = setNormalHighSpeedSilentOperationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the type of operation ( gnormal, h  ghigh-speed h or  gsilent h), and to acquire the current setting.<br><br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43<br><br>Name : Normal/high- speed/silent operation setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getNormalHighSpeedSilentOperationSetting() {return null;}
	private final byte[] _getNormalHighSpeedSilentOperationSetting(byte epc) {
		byte[] edt = getNormalHighSpeedSilentOperationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract boolean setSetTemperatureValue(byte[] edt);
	private final boolean _setSetTemperatureValue(byte epc, byte[] edt) {
		boolean success = setSetTemperatureValue(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract byte[] getSetTemperatureValue();
	private final byte[] _getSetTemperatureValue(byte epc) {
		byte[] edt = getSetTemperatureValue();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Set value of relative humidity in dehumidifying mode<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {return false;}
	private final boolean _setSetValueOfRelativeHumidityInDehumidifyingMode(byte epc, byte[] edt) {
		boolean success = setSetValueOfRelativeHumidityInDehumidifyingMode(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Set value of relative humidity in dehumidifying mode<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfRelativeHumidityInDehumidifyingMode() {return null;}
	private final byte[] _getSetValueOfRelativeHumidityInDehumidifyingMode(byte epc) {
		byte[] edt = getSetValueOfRelativeHumidityInDehumidifyingMode();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in cooling mode<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetTemperatureValueInCoolingMode(byte[] edt) {return false;}
	private final boolean _setSetTemperatureValueInCoolingMode(byte epc, byte[] edt) {
		boolean success = setSetTemperatureValueInCoolingMode(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in cooling mode<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetTemperatureValueInCoolingMode() {return null;}
	private final byte[] _getSetTemperatureValueInCoolingMode(byte epc) {
		byte[] edt = getSetTemperatureValueInCoolingMode();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in heating mode<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetTemperatureValueInHeatingMode(byte[] edt) {return false;}
	private final boolean _setSetTemperatureValueInHeatingMode(byte epc, byte[] edt) {
		boolean success = setSetTemperatureValueInHeatingMode(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in heating mode<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetTemperatureValueInHeatingMode() {return null;}
	private final byte[] _getSetTemperatureValueInHeatingMode(byte epc) {
		byte[] edt = getSetTemperatureValueInHeatingMode();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in dehumidifying mode<br>EPC : 0xB7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetTemperatureValueInDehumidifyingMode(byte[] edt) {return false;}
	private final boolean _setSetTemperatureValueInDehumidifyingMode(byte epc, byte[] edt) {
		boolean success = setSetTemperatureValueInDehumidifyingMode(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in dehumidifying mode<br>EPC : 0xB7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetTemperatureValueInDehumidifyingMode() {return null;}
	private final byte[] _getSetTemperatureValueInDehumidifyingMode(byte epc) {
		byte[] edt = getSetTemperatureValueInDehumidifyingMode();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br><br>0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast<br><br>Name : Rated power consumption<br>EPC : 0xB8<br>Data Type : unsigned short x 4<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRatedPowerConsumption() {return null;}
	private final byte[] _getRatedPowerConsumption(byte epc) {
		byte[] edt = getRatedPowerConsumption();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Measured value of current consumption<br><br>0x0000.0xFFFD (0.6553.3A)<br><br>Name : Measured value of current consumption<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredValueOfCurrentConsumption() {return null;}
	private final byte[] _getMeasuredValueOfCurrentConsumption(byte epc) {
		byte[] edt = getMeasuredValueOfCurrentConsumption();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Measured value of room relative humidity<br><br>0x00.0x64 (0.100. C)<br><br>Name : Measured value of room relative humidity<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredValueOfRoomRelativeHumidity() {return null;}
	private final byte[] _getMeasuredValueOfRoomRelativeHumidity(byte epc) {
		byte[] edt = getMeasuredValueOfRoomRelativeHumidity();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Measured value of room temperature<br><br>0x80.0x7D (-127.125.C)<br><br>Name : Measured value of room temperature<br>EPC : 0xBB<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredValueOfRoomTemperature() {return null;}
	private final byte[] _getMeasuredValueOfRoomTemperature(byte epc) {
		byte[] edt = getMeasuredValueOfRoomTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Set temperature value of user remote control<br><br>0x00.0x32 (0.50.C)<br><br>Name : Set temperature value of user remote control<br>EPC : 0xBC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSetTemperatureValueOfUserRemoteControl() {return null;}
	private final byte[] _getSetTemperatureValueOfUserRemoteControl(byte epc) {
		byte[] edt = getSetTemperatureValueOfUserRemoteControl();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured cooled air temperature at the outlet.<br><br>0x81 to 0x7D (-127 to 125  C)<br><br>Name : Measured cooled air temperature<br>EPC : 0xBD<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredCooledAirTemperature() {return null;}
	private final byte[] _getMeasuredCooledAirTemperature(byte epc) {
		byte[] edt = getMeasuredCooledAirTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured outdoor air temperature.<br><br>0x81 to 0x7D (-127 to 125  C)<br><br>Name : Measured outdoor air temperature<br>EPC : 0xBE<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredOutdoorAirTemperature() {return null;}
	private final byte[] _getMeasuredOutdoorAirTemperature(byte epc) {
		byte[] edt = getMeasuredOutdoorAirTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7  C to 12.5  C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRelativeTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setRelativeTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setRelativeTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7  C to 12.5  C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRelativeTemperatureSetting() {return null;}
	private final byte[] _getRelativeTemperatureSetting(byte epc) {
		byte[] edt = getRelativeTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	private final boolean _setAirFlowRateSetting(byte epc, byte[] edt) {
		boolean success = setAirFlowRateSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAirFlowRateSetting() {return null;}
	private final byte[] _getAirFlowRateSetting(byte epc) {
		byte[] edt = getAirFlowRateSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br><br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br><br>Name : Automatic control of air flow direction setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {return false;}
	private final boolean _setAutomaticControlOfAirFlowDirectionSetting(byte epc, byte[] edt) {
		boolean success = setAutomaticControlOfAirFlowDirectionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br><br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br><br>Name : Automatic control of air flow direction setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAutomaticControlOfAirFlowDirectionSetting() {return null;}
	private final byte[] _getAutomaticControlOfAirFlowDirectionSetting(byte epc) {
		byte[] edt = getAutomaticControlOfAirFlowDirectionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br><br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br><br>Name : Automatic swing of air flow setting<br>EPC : 0xA3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAutomaticSwingOfAirFlowSetting(byte[] edt) {return false;}
	private final boolean _setAutomaticSwingOfAirFlowSetting(byte epc, byte[] edt) {
		boolean success = setAutomaticSwingOfAirFlowSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br><br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br><br>Name : Automatic swing of air flow setting<br>EPC : 0xA3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAutomaticSwingOfAirFlowSetting() {return null;}
	private final byte[] _getAutomaticSwingOfAirFlowSetting(byte epc) {
		byte[] edt = getAutomaticSwingOfAirFlowSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br><br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br><br>Name : Air flow direction (vertical) setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAirFlowDirectionVerticalSetting(byte[] edt) {return false;}
	private final boolean _setAirFlowDirectionVerticalSetting(byte epc, byte[] edt) {
		boolean success = setAirFlowDirectionVerticalSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br><br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br><br>Name : Air flow direction (vertical) setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAirFlowDirectionVerticalSetting() {return null;}
	private final byte[] _getAirFlowDirectionVerticalSetting(byte epc) {
		byte[] edt = getAirFlowDirectionVerticalSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br><br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.<br><br>Name : Air flow direction (horizontal) setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAirFlowDirectionHorizontalSetting(byte[] edt) {return false;}
	private final boolean _setAirFlowDirectionHorizontalSetting(byte epc, byte[] edt) {
		boolean success = setAirFlowDirectionHorizontalSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br><br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.<br><br>Name : Air flow direction (horizontal) setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAirFlowDirectionHorizontalSetting() {return null;}
	private final byte[] _getAirFlowDirectionHorizontalSetting(byte epc) {
		byte[] edt = getAirFlowDirectionHorizontalSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates if the air conditioner is in a  gspecial h state (i.e. the  gdefrosting, h  gpreheating, h or  gheat removal h state).<br><br> gNormal operation h state = 0x40,  gDefrosting h state = 0x41,  gPreheating h state = 0x42,  gHeat removal h state = 0x43<br><br>Name : Special state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSpecialState() {return null;}
	private final byte[] _getSpecialState(byte epc) {
		byte[] edt = getSpecialState();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to indicate when the air conditioner is in a  gnon-priority h state.<br><br> gNormal operation h state = 0x40,  gNon-priority h state = 0x41<br><br>Name : Non-priority state<br>EPC : 0xAB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getNonPriorityState() {return null;}
	private final byte[] _getNonPriorityState(byte epc) {
		byte[] edt = getNonPriorityState();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br><br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br><br>Name : Ventilation function setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVentilationFunctionSetting(byte[] edt) {return false;}
	private final boolean _setVentilationFunctionSetting(byte epc, byte[] edt) {
		boolean success = setVentilationFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br><br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br><br>Name : Ventilation function setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getVentilationFunctionSetting() {return null;}
	private final byte[] _getVentilationFunctionSetting(byte epc) {
		byte[] edt = getVentilationFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br><br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br><br>Name : Humidifier function setting<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHumidifierFunctionSetting(byte[] edt) {return false;}
	private final boolean _setHumidifierFunctionSetting(byte epc, byte[] edt) {
		boolean success = setHumidifierFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br><br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br><br>Name : Humidifier function setting<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHumidifierFunctionSetting() {return null;}
	private final byte[] _getHumidifierFunctionSetting(byte epc) {
		byte[] edt = getHumidifierFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	private final boolean _setVentilationAirFlowRateSetting(byte epc, byte[] edt) {
		boolean success = setVentilationAirFlowRateSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	private final byte[] _getVentilationAirFlowRateSetting(byte epc) {
		byte[] edt = getVentilationAirFlowRateSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38<br><br>Name : Degree of humidification setting<br>EPC : 0xC4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDegreeOfHumidificationSetting(byte[] edt) {return false;}
	private final boolean _setDegreeOfHumidificationSetting(byte epc, byte[] edt) {
		boolean success = setDegreeOfHumidificationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38<br><br>Name : Degree of humidification setting<br>EPC : 0xC4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDegreeOfHumidificationSetting() {return null;}
	private final byte[] _getDegreeOfHumidificationSetting(byte epc) {
		byte[] edt = getDegreeOfHumidificationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * A bitmap indicates mounted method of exercising air cleaning function.<br><br>Bit 0: Information about electrical dust collection method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted air cleaning method<br>EPC : 0xC6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMountedAirCleaningMethod() {return null;}
	private final byte[] _getMountedAirCleaningMethod(byte epc) {
		byte[] edt = getMountedAirCleaningMethod();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air purifier function setting<br>EPC : 0xC7<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAirPurifierFunctionSetting(byte[] edt) {return false;}
	private final boolean _setAirPurifierFunctionSetting(byte epc, byte[] edt) {
		boolean success = setAirPurifierFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air purifier function setting<br>EPC : 0xC7<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAirPurifierFunctionSetting() {return null;}
	private final byte[] _getAirPurifierFunctionSetting(byte epc) {
		byte[] edt = getAirPurifierFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * A bitmap indicates mounted method for exercising refresh function.<br><br>Bit 0: Information about minus ion method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted air refresh method<br>EPC : 0xC8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMountedAirRefreshMethod() {return null;}
	private final byte[] _getMountedAirRefreshMethod(byte epc) {
		byte[] edt = getMountedAirRefreshMethod();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air refresher function setting<br>EPC : 0xC9<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAirRefresherFunctionSetting(byte[] edt) {return false;}
	private final boolean _setAirRefresherFunctionSetting(byte epc, byte[] edt) {
		boolean success = setAirRefresherFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air refresher function setting<br>EPC : 0xC9<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAirRefresherFunctionSetting() {return null;}
	private final byte[] _getAirRefresherFunctionSetting(byte epc) {
		byte[] edt = getAirRefresherFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * A bitmap indicates mounted method for exercising self-cleaning function.<br><br>Bit 0: Information about ozone cleaning method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about drying method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted self-cleaning method<br>EPC : 0xCA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMountedSelfCleaningMethod() {return null;}
	private final byte[] _getMountedSelfCleaningMethod(byte epc) {
		byte[] edt = getMountedSelfCleaningMethod();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.<br><br>Name : Self-cleaning function setting<br>EPC : 0xCB<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSelfCleaningFunctionSetting(byte[] edt) {return false;}
	private final boolean _setSelfCleaningFunctionSetting(byte epc, byte[] edt) {
		boolean success = setSelfCleaningFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.<br><br>Name : Self-cleaning function setting<br>EPC : 0xCB<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSelfCleaningFunctionSetting() {return null;}
	private final byte[] _getSelfCleaningFunctionSetting(byte epc) {
		byte[] edt = getSelfCleaningFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br><br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.<br><br>Name : Special function setting<br>EPC : 0xCC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSpecialFunctionSetting(byte[] edt) {return false;}
	private final boolean _setSpecialFunctionSetting(byte epc, byte[] edt) {
		boolean success = setSpecialFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br><br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.<br><br>Name : Special function setting<br>EPC : 0xCC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSpecialFunctionSetting() {return null;}
	private final byte[] _getSpecialFunctionSetting(byte epc) {
		byte[] edt = getSpecialFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br><br>Bit 0: Operation status of the compressor: 0: Not operating 1: In operation Bit 1: Operation status of the thermostat: 0: Thermostat OFF 1: Thermostat ON Bits 2 to 7: Reserved for future use.<br><br>Name : Operation status of components<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getOperationStatusOfComponents() {return null;}
	private final byte[] _getOperationStatusOfComponents(byte epc) {
		byte[] edt = getOperationStatusOfComponents();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
	 */
	protected boolean setThermostatSettingOverrideFunction(byte[] edt) {return false;}
	private final boolean _setThermostatSettingOverrideFunction(byte epc, byte[] edt) {
		boolean success = setThermostatSettingOverrideFunction(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br><br>Air purification ON  0x41,OFF   0x42<br><br>Name : Air purification mode setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAirPurificationModeSetting(byte[] edt) {return false;}
	private final boolean _setAirPurificationModeSetting(byte epc, byte[] edt) {
		boolean success = setAirPurificationModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br><br>Air purification ON  0x41,OFF   0x42<br><br>Name : Air purification mode setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAirPurificationModeSetting() {return null;}
	private final byte[] _getAirPurificationModeSetting(byte epc) {
		byte[] edt = getAirPurificationModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : ON timer-based reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerBasedReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerBasedReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerBasedReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : ON timer-based reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerBasedReservationSetting() {return null;}
	private final byte[] _getOnTimerBasedReservationSetting(byte epc) {
		byte[] edt = getOnTimerBasedReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	private final byte[] _getOnTimerSettingTime(byte epc) {
		byte[] edt = getOnTimerSettingTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingRelativeTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingRelativeTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	private final byte[] _getOnTimerSettingRelativeTime(byte epc) {
		byte[] edt = getOnTimerSettingRelativeTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : OFF timer-based reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOffTimerBasedReservationSetting(byte[] edt) {return false;}
	private final boolean _setOffTimerBasedReservationSetting(byte epc, byte[] edt) {
		boolean success = setOffTimerBasedReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : OFF timer-based reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOffTimerBasedReservationSetting() {return null;}
	private final byte[] _getOffTimerBasedReservationSetting(byte epc) {
		byte[] edt = getOffTimerBasedReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	private final boolean _setOffTimerSettingTime(byte epc, byte[] edt) {
		boolean success = setOffTimerSettingTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	private final byte[] _getOffTimerSettingTime(byte epc) {
		byte[] edt = getOffTimerSettingTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	private final boolean _setOffTimerSettingRelativeTime(byte epc, byte[] edt) {
		boolean success = setOffTimerSettingRelativeTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOffTimerSettingRelativeTime() {return null;}
	private final byte[] _getOffTimerSettingRelativeTime(byte epc) {
		byte[] edt = getOffTimerSettingRelativeTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, _setOperationModeSetting(epc, edt));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			res.addProperty(epc, edt, _setAutomaticTemperatureControlSetting(epc, edt));
			break;
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING:
			res.addProperty(epc, edt, _setNormalHighSpeedSilentOperationSetting(epc, edt));
			break;
		case EPC_SET_TEMPERATURE_VALUE:
			res.addProperty(epc, edt, _setSetTemperatureValue(epc, edt));
			break;
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE:
			res.addProperty(epc, edt, _setSetValueOfRelativeHumidityInDehumidifyingMode(epc, edt));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE:
			res.addProperty(epc, edt, _setSetTemperatureValueInCoolingMode(epc, edt));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE:
			res.addProperty(epc, edt, _setSetTemperatureValueInHeatingMode(epc, edt));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE:
			res.addProperty(epc, edt, _setSetTemperatureValueInDehumidifyingMode(epc, edt));
			break;
		case EPC_RELATIVE_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setRelativeTemperatureSetting(epc, edt));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, _setAirFlowRateSetting(epc, edt));
			break;
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING:
			res.addProperty(epc, edt, _setAutomaticControlOfAirFlowDirectionSetting(epc, edt));
			break;
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING:
			res.addProperty(epc, edt, _setAutomaticSwingOfAirFlowSetting(epc, edt));
			break;
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING:
			res.addProperty(epc, edt, _setAirFlowDirectionVerticalSetting(epc, edt));
			break;
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING:
			res.addProperty(epc, edt, _setAirFlowDirectionHorizontalSetting(epc, edt));
			break;
		case EPC_VENTILATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setVentilationFunctionSetting(epc, edt));
			break;
		case EPC_HUMIDIFIER_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setHumidifierFunctionSetting(epc, edt));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, _setVentilationAirFlowRateSetting(epc, edt));
			break;
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING:
			res.addProperty(epc, edt, _setDegreeOfHumidificationSetting(epc, edt));
			break;
		case EPC_AIR_PURIFIER_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setAirPurifierFunctionSetting(epc, edt));
			break;
		case EPC_AIR_REFRESHER_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setAirRefresherFunctionSetting(epc, edt));
			break;
		case EPC_SELF_CLEANING_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setSelfCleaningFunctionSetting(epc, edt));
			break;
		case EPC_SPECIAL_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setSpecialFunctionSetting(epc, edt));
			break;
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
			res.addProperty(epc, edt, _setThermostatSettingOverrideFunction(epc, edt));
			break;
		case EPC_AIR_PURIFICATION_MODE_SETTING:
			res.addProperty(epc, edt, _setAirPurificationModeSetting(epc, edt));
			break;
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOnTimerBasedReservationSetting(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingTime(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingRelativeTime(epc, edt));
			break;
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOffTimerBasedReservationSetting(epc, edt));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, _setOffTimerSettingTime(epc, edt));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, _setOffTimerSettingRelativeTime(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			edt = _getOperationModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			edt = _getAutomaticTemperatureControlSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING:
			edt = _getNormalHighSpeedSilentOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE:
			edt = _getSetTemperatureValue(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE:
			edt = _getSetValueOfRelativeHumidityInDehumidifyingMode(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE:
			edt = _getSetTemperatureValueInCoolingMode(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE:
			edt = _getSetTemperatureValueInHeatingMode(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE:
			edt = _getSetTemperatureValueInDehumidifyingMode(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RATED_POWER_CONSUMPTION:
			edt = _getRatedPowerConsumption(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION:
			edt = _getMeasuredValueOfCurrentConsumption(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
			edt = _getMeasuredValueOfRoomRelativeHumidity(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE:
			edt = _getMeasuredValueOfRoomTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL:
			edt = _getSetTemperatureValueOfUserRemoteControl(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_COOLED_AIR_TEMPERATURE:
			edt = _getMeasuredCooledAirTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE:
			edt = _getMeasuredOutdoorAirTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RELATIVE_TEMPERATURE_SETTING:
			edt = _getRelativeTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			edt = _getAirFlowRateSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING:
			edt = _getAutomaticControlOfAirFlowDirectionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING:
			edt = _getAutomaticSwingOfAirFlowSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING:
			edt = _getAirFlowDirectionVerticalSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING:
			edt = _getAirFlowDirectionHorizontalSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SPECIAL_STATE:
			edt = _getSpecialState(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_NON_PRIORITY_STATE:
			edt = _getNonPriorityState(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_FUNCTION_SETTING:
			edt = _getVentilationFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HUMIDIFIER_FUNCTION_SETTING:
			edt = _getHumidifierFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			edt = _getVentilationAirFlowRateSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING:
			edt = _getDegreeOfHumidificationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MOUNTED_AIR_CLEANING_METHOD:
			edt = _getMountedAirCleaningMethod(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_PURIFIER_FUNCTION_SETTING:
			edt = _getAirPurifierFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MOUNTED_AIR_REFRESH_METHOD:
			edt = _getMountedAirRefreshMethod(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_REFRESHER_FUNCTION_SETTING:
			edt = _getAirRefresherFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MOUNTED_SELF_CLEANING_METHOD:
			edt = _getMountedSelfCleaningMethod(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SELF_CLEANING_FUNCTION_SETTING:
			edt = _getSelfCleaningFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_SPECIAL_FUNCTION_SETTING:
			edt = _getSpecialFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OPERATION_STATUS_OF_COMPONENTS:
			edt = _getOperationStatusOfComponents(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_PURIFICATION_MODE_SETTING:
			edt = _getAirPurificationModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
			edt = _getOnTimerBasedReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			edt = _getOnTimerSettingTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			edt = _getOnTimerSettingRelativeTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
			edt = _getOffTimerBasedReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			edt = _getOffTimerSettingTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			edt = _getOffTimerSettingRelativeTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;

		}
	}
	
	@Override
	public Setter set() {
		return new Setter(ESV_SETI);
	}

	@Override
	public Setter setC() {
		return new Setter(ESV_SETC);
	}

	@Override
	public Getter get() {
		return new Getter();
	}

	@Override
	public Informer inform() {
		return new InformerImpl();
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_MODE_SETTING:
				_onSetOperationModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				_onSetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING:
				_onSetNormalHighSpeedSilentOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_TEMPERATURE_VALUE:
				_onSetSetTemperatureValue(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE:
				_onSetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE:
				_onSetSetTemperatureValueInCoolingMode(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE:
				_onSetSetTemperatureValueInHeatingMode(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE:
				_onSetSetTemperatureValueInDehumidifyingMode(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_RELATIVE_TEMPERATURE_SETTING:
				_onSetRelativeTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				_onSetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING:
				_onSetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING:
				_onSetAutomaticSwingOfAirFlowSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING:
				_onSetAirFlowDirectionVerticalSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING:
				_onSetAirFlowDirectionHorizontalSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_VENTILATION_FUNCTION_SETTING:
				_onSetVentilationFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_HUMIDIFIER_FUNCTION_SETTING:
				_onSetHumidifierFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				_onSetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DEGREE_OF_HUMIDIFICATION_SETTING:
				_onSetDegreeOfHumidificationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AIR_PURIFIER_FUNCTION_SETTING:
				_onSetAirPurifierFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AIR_REFRESHER_FUNCTION_SETTING:
				_onSetAirRefresherFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SELF_CLEANING_FUNCTION_SETTING:
				_onSetSelfCleaningFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SPECIAL_FUNCTION_SETTING:
				_onSetSpecialFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
				_onSetThermostatSettingOverrideFunction(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AIR_PURIFICATION_MODE_SETTING:
				_onSetAirPurificationModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
				_onSetOnTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				_onSetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				_onSetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
				_onSetOffTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				_onSetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				_onSetOffTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_MODE_SETTING:
				_onGetOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				_onGetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING:
				_onGetNormalHighSpeedSilentOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE:
				_onGetSetTemperatureValue(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE:
				_onGetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE:
				_onGetSetTemperatureValueInCoolingMode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE:
				_onGetSetTemperatureValueInHeatingMode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE:
				_onGetSetTemperatureValueInDehumidifyingMode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION:
				_onGetRatedPowerConsumption(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION:
				_onGetMeasuredValueOfCurrentConsumption(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY:
				_onGetMeasuredValueOfRoomRelativeHumidity(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE:
				_onGetMeasuredValueOfRoomTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL:
				_onGetSetTemperatureValueOfUserRemoteControl(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_COOLED_AIR_TEMPERATURE:
				_onGetMeasuredCooledAirTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE:
				_onGetMeasuredOutdoorAirTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RELATIVE_TEMPERATURE_SETTING:
				_onGetRelativeTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				_onGetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING:
				_onGetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING:
				_onGetAutomaticSwingOfAirFlowSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING:
				_onGetAirFlowDirectionVerticalSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING:
				_onGetAirFlowDirectionHorizontalSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPECIAL_STATE:
				_onGetSpecialState(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_NON_PRIORITY_STATE:
				_onGetNonPriorityState(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VENTILATION_FUNCTION_SETTING:
				_onGetVentilationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HUMIDIFIER_FUNCTION_SETTING:
				_onGetHumidifierFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				_onGetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DEGREE_OF_HUMIDIFICATION_SETTING:
				_onGetDegreeOfHumidificationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MOUNTED_AIR_CLEANING_METHOD:
				_onGetMountedAirCleaningMethod(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_PURIFIER_FUNCTION_SETTING:
				_onGetAirPurifierFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MOUNTED_AIR_REFRESH_METHOD:
				_onGetMountedAirRefreshMethod(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_REFRESHER_FUNCTION_SETTING:
				_onGetAirRefresherFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MOUNTED_SELF_CLEANING_METHOD:
				_onGetMountedSelfCleaningMethod(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SELF_CLEANING_FUNCTION_SETTING:
				_onGetSelfCleaningFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPECIAL_FUNCTION_SETTING:
				_onGetSpecialFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OPERATION_STATUS_OF_COMPONENTS:
				_onGetOperationStatusOfComponents(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_PURIFICATION_MODE_SETTING:
				_onGetAirPurificationModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
				_onGetOnTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				_onGetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				_onGetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
				_onGetOffTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				_onGetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				_onGetOffTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOperationModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br><br>Automatic = 0x41 Non-automatic = 0x42<br><br>Name : Automatic temperature control setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br><br>Automatic = 0x41 Non-automatic = 0x42<br><br>Name : Automatic temperature control setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the type of operation ( gnormal, h  ghigh-speed h or  gsilent h), and to acquire the current setting.<br><br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43<br><br>Name : Normal/high- speed/silent operation setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetNormalHighSpeedSilentOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the type of operation ( gnormal, h  ghigh-speed h or  gsilent h), and to acquire the current setting.<br><br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43<br><br>Name : Normal/high- speed/silent operation setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetNormalHighSpeedSilentOperationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onSetSetTemperatureValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetTemperatureValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetTemperatureValue(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onGetSetTemperatureValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetTemperatureValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetTemperatureValue(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Set value of relative humidity in dehumidifying mode<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Set value of relative humidity in dehumidifying mode<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in cooling mode<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetTemperatureValueInCoolingMode(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in cooling mode<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetTemperatureValueInCoolingMode(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in heating mode<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetTemperatureValueInHeatingMode(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in heating mode<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetTemperatureValueInHeatingMode(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in dehumidifying mode<br>EPC : 0xB7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetTemperatureValueInDehumidifyingMode(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in dehumidifying mode<br>EPC : 0xB7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetTemperatureValueInDehumidifyingMode(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br><br>0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast<br><br>Name : Rated power consumption<br>EPC : 0xB8<br>Data Type : unsigned short x 4<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRatedPowerConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedPowerConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedPowerConsumption(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured value of current consumption<br><br>0x0000.0xFFFD (0.6553.3A)<br><br>Name : Measured value of current consumption<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredValueOfCurrentConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredValueOfCurrentConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredValueOfCurrentConsumption(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured value of room relative humidity<br><br>0x00.0x64 (0.100. C)<br><br>Name : Measured value of room relative humidity<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredValueOfRoomRelativeHumidity(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured value of room temperature<br><br>0x80.0x7D (-127.125.C)<br><br>Name : Measured value of room temperature<br>EPC : 0xBB<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredValueOfRoomTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredValueOfRoomTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredValueOfRoomTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Set temperature value of user remote control<br><br>0x00.0x32 (0.50.C)<br><br>Name : Set temperature value of user remote control<br>EPC : 0xBC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSetTemperatureValueOfUserRemoteControl(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetTemperatureValueOfUserRemoteControl(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetTemperatureValueOfUserRemoteControl(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured cooled air temperature at the outlet.<br><br>0x81 to 0x7D (-127 to 125  C)<br><br>Name : Measured cooled air temperature<br>EPC : 0xBD<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredCooledAirTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCooledAirTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCooledAirTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured outdoor air temperature.<br><br>0x81 to 0x7D (-127 to 125  C)<br><br>Name : Measured outdoor air temperature<br>EPC : 0xBE<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredOutdoorAirTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredOutdoorAirTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredOutdoorAirTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7  C to 12.5  C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7  C to 12.5  C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br><br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br><br>Name : Automatic control of air flow direction setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br><br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br><br>Name : Automatic control of air flow direction setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br><br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br><br>Name : Automatic swing of air flow setting<br>EPC : 0xA3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutomaticSwingOfAirFlowSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br><br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br><br>Name : Automatic swing of air flow setting<br>EPC : 0xA3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutomaticSwingOfAirFlowSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br><br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br><br>Name : Air flow direction (vertical) setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAirFlowDirectionVerticalSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br><br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br><br>Name : Air flow direction (vertical) setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirFlowDirectionVerticalSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br><br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.<br><br>Name : Air flow direction (horizontal) setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAirFlowDirectionHorizontalSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br><br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.<br><br>Name : Air flow direction (horizontal) setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirFlowDirectionHorizontalSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates if the air conditioner is in a  gspecial h state (i.e. the  gdefrosting, h  gpreheating, h or  gheat removal h state).<br><br> gNormal operation h state = 0x40,  gDefrosting h state = 0x41,  gPreheating h state = 0x42,  gHeat removal h state = 0x43<br><br>Name : Special state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSpecialState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSpecialState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSpecialState(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to indicate when the air conditioner is in a  gnon-priority h state.<br><br> gNormal operation h state = 0x40,  gNon-priority h state = 0x41<br><br>Name : Non-priority state<br>EPC : 0xAB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetNonPriorityState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetNonPriorityState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetNonPriorityState(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br><br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br><br>Name : Ventilation function setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVentilationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVentilationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVentilationFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br><br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br><br>Name : Ventilation function setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetVentilationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVentilationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVentilationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br><br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br><br>Name : Humidifier function setting<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHumidifierFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHumidifierFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHumidifierFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br><br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br><br>Name : Humidifier function setting<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHumidifierFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHumidifierFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHumidifierFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38<br><br>Name : Degree of humidification setting<br>EPC : 0xC4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDegreeOfHumidificationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDegreeOfHumidificationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDegreeOfHumidificationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38<br><br>Name : Degree of humidification setting<br>EPC : 0xC4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDegreeOfHumidificationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDegreeOfHumidificationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDegreeOfHumidificationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * A bitmap indicates mounted method of exercising air cleaning function.<br><br>Bit 0: Information about electrical dust collection method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted air cleaning method<br>EPC : 0xC6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMountedAirCleaningMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMountedAirCleaningMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMountedAirCleaningMethod(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air purifier function setting<br>EPC : 0xC7<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAirPurifierFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAirPurifierFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAirPurifierFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air purifier function setting<br>EPC : 0xC7<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAirPurifierFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirPurifierFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirPurifierFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * A bitmap indicates mounted method for exercising refresh function.<br><br>Bit 0: Information about minus ion method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted air refresh method<br>EPC : 0xC8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMountedAirRefreshMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMountedAirRefreshMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMountedAirRefreshMethod(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air refresher function setting<br>EPC : 0xC9<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAirRefresherFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAirRefresherFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAirRefresherFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air refresher function setting<br>EPC : 0xC9<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAirRefresherFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirRefresherFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirRefresherFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * A bitmap indicates mounted method for exercising self-cleaning function.<br><br>Bit 0: Information about ozone cleaning method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about drying method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted self-cleaning method<br>EPC : 0xCA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMountedSelfCleaningMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMountedSelfCleaningMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMountedSelfCleaningMethod(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.<br><br>Name : Self-cleaning function setting<br>EPC : 0xCB<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSelfCleaningFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSelfCleaningFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSelfCleaningFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.<br><br>Name : Self-cleaning function setting<br>EPC : 0xCB<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSelfCleaningFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSelfCleaningFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSelfCleaningFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br><br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.<br><br>Name : Special function setting<br>EPC : 0xCC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSpecialFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSpecialFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSpecialFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br><br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.<br><br>Name : Special function setting<br>EPC : 0xCC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSpecialFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSpecialFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSpecialFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br><br>Bit 0: Operation status of the compressor: 0: Not operating 1: In operation Bit 1: Operation status of the thermostat: 0: Thermostat OFF 1: Thermostat ON Bits 2 to 7: Reserved for future use.<br><br>Name : Operation status of components<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetOperationStatusOfComponents(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationStatusOfComponents(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationStatusOfComponents(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
		 */
		protected void onSetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetThermostatSettingOverrideFunction(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br><br>Air purification ON  0x41,OFF   0x42<br><br>Name : Air purification mode setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAirPurificationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAirPurificationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAirPurificationModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br><br>Air purification ON  0x41,OFF   0x42<br><br>Name : Air purification mode setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAirPurificationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirPurificationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirPurificationModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : ON timer-based reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : ON timer-based reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : OFF timer-based reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : OFF timer-based reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}

	}
	
	public class Setter extends DeviceObject.Setter {
		public Setter(byte esv) {
			super(esv);
		}

		@Override
		public Setter reqSet(byte epc, byte[] edt) {
			return (Setter)super.reqSet(epc, edt);
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
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br><br>Automatic = 0x41 Non-automatic = 0x42<br><br>Name : Automatic temperature control setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the type of operation ( gnormal, h  ghigh-speed h or  gsilent h), and to acquire the current setting.<br><br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43<br><br>Name : Normal/high- speed/silent operation setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetNormalHighSpeedSilentOperationSetting(byte[] edt) {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Setter reqSetSetTemperatureValue(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Set value of relative humidity in dehumidifying mode<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in cooling mode<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetTemperatureValueInCoolingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in heating mode<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetTemperatureValueInHeatingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in dehumidifying mode<br>EPC : 0xB7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetTemperatureValueInDehumidifyingMode(byte[] edt) {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7  C to 12.5  C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRelativeTemperatureSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br><br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br><br>Name : Automatic control of air flow direction setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br><br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br><br>Name : Automatic swing of air flow setting<br>EPC : 0xA3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAutomaticSwingOfAirFlowSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br><br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br><br>Name : Air flow direction (vertical) setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAirFlowDirectionVerticalSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br><br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.<br><br>Name : Air flow direction (horizontal) setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAirFlowDirectionHorizontalSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br><br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br><br>Name : Ventilation function setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetVentilationFunctionSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br><br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br><br>Name : Humidifier function setting<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHumidifierFunctionSetting(byte[] edt) {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38<br><br>Name : Degree of humidification setting<br>EPC : 0xC4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDegreeOfHumidificationSetting(byte[] edt) {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air purifier function setting<br>EPC : 0xC7<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAirPurifierFunctionSetting(byte[] edt) {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air refresher function setting<br>EPC : 0xC9<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAirRefresherFunctionSetting(byte[] edt) {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.<br><br>Name : Self-cleaning function setting<br>EPC : 0xCB<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSelfCleaningFunctionSetting(byte[] edt) {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		/**
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br><br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.<br><br>Name : Special function setting<br>EPC : 0xCC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSpecialFunctionSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
		 */
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt) {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br><br>Air purification ON  0x41,OFF   0x42<br><br>Name : Air purification mode setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAirPurificationModeSetting(byte[] edt) {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : ON timer-based reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : OFF timer-based reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
	}

	public class Getter extends DeviceObject.Getter {

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
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Getter reqGetOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br><br>Automatic = 0x41 Non-automatic = 0x42<br><br>Name : Automatic temperature control setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Used to specify the type of operation ( gnormal, h  ghigh-speed h or  gsilent h), and to acquire the current setting.<br><br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43<br><br>Name : Normal/high- speed/silent operation setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetNormalHighSpeedSilentOperationSetting() {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING);
			return this;
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Getter reqGetSetTemperatureValue() {
			addProperty(EPC_SET_TEMPERATURE_VALUE);
			return this;
		}
		/**
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Set value of relative humidity in dehumidifying mode<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfRelativeHumidityInDehumidifyingMode() {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in cooling mode<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetTemperatureValueInCoolingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE);
			return this;
		}
		/**
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in heating mode<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetTemperatureValueInHeatingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE);
			return this;
		}
		/**
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in dehumidifying mode<br>EPC : 0xB7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetTemperatureValueInDehumidifyingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br><br>0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast<br><br>Name : Rated power consumption<br>EPC : 0xB8<br>Data Type : unsigned short x 4<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRatedPowerConsumption() {
			addProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Measured value of current consumption<br><br>0x0000.0xFFFD (0.6553.3A)<br><br>Name : Measured value of current consumption<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredValueOfCurrentConsumption() {
			addProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION);
			return this;
		}
		/**
		 * Measured value of room relative humidity<br><br>0x00.0x64 (0.100. C)<br><br>Name : Measured value of room relative humidity<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Measured value of room temperature<br><br>0x80.0x7D (-127.125.C)<br><br>Name : Measured value of room temperature<br>EPC : 0xBB<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredValueOfRoomTemperature() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE);
			return this;
		}
		/**
		 * Set temperature value of user remote control<br><br>0x00.0x32 (0.50.C)<br><br>Name : Set temperature value of user remote control<br>EPC : 0xBC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSetTemperatureValueOfUserRemoteControl() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL);
			return this;
		}
		/**
		 * This property indicates the measured cooled air temperature at the outlet.<br><br>0x81 to 0x7D (-127 to 125  C)<br><br>Name : Measured cooled air temperature<br>EPC : 0xBD<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredCooledAirTemperature() {
			addProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * This property indicates the measured outdoor air temperature.<br><br>0x81 to 0x7D (-127 to 125  C)<br><br>Name : Measured outdoor air temperature<br>EPC : 0xBE<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7  C to 12.5  C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRelativeTemperatureSetting() {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br><br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br><br>Name : Automatic control of air flow direction setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAutomaticControlOfAirFlowDirectionSetting() {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br><br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br><br>Name : Automatic swing of air flow setting<br>EPC : 0xA3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAutomaticSwingOfAirFlowSetting() {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING);
			return this;
		}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br><br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br><br>Name : Air flow direction (vertical) setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAirFlowDirectionVerticalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br><br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.<br><br>Name : Air flow direction (horizontal) setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAirFlowDirectionHorizontalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		/**
		 * This property indicates if the air conditioner is in a  gspecial h state (i.e. the  gdefrosting, h  gpreheating, h or  gheat removal h state).<br><br> gNormal operation h state = 0x40,  gDefrosting h state = 0x41,  gPreheating h state = 0x42,  gHeat removal h state = 0x43<br><br>Name : Special state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSpecialState() {
			addProperty(EPC_SPECIAL_STATE);
			return this;
		}
		/**
		 * Used to indicate when the air conditioner is in a  gnon-priority h state.<br><br> gNormal operation h state = 0x40,  gNon-priority h state = 0x41<br><br>Name : Non-priority state<br>EPC : 0xAB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetNonPriorityState() {
			addProperty(EPC_NON_PRIORITY_STATE);
			return this;
		}
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br><br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br><br>Name : Ventilation function setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetVentilationFunctionSetting() {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br><br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br><br>Name : Humidifier function setting<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHumidifierFunctionSetting() {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38<br><br>Name : Degree of humidification setting<br>EPC : 0xC4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDegreeOfHumidificationSetting() {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING);
			return this;
		}
		/**
		 * A bitmap indicates mounted method of exercising air cleaning function.<br><br>Bit 0: Information about electrical dust collection method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted air cleaning method<br>EPC : 0xC6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMountedAirCleaningMethod() {
			addProperty(EPC_MOUNTED_AIR_CLEANING_METHOD);
			return this;
		}
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air purifier function setting<br>EPC : 0xC7<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAirPurifierFunctionSetting() {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * A bitmap indicates mounted method for exercising refresh function.<br><br>Bit 0: Information about minus ion method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted air refresh method<br>EPC : 0xC8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMountedAirRefreshMethod() {
			addProperty(EPC_MOUNTED_AIR_REFRESH_METHOD);
			return this;
		}
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air refresher function setting<br>EPC : 0xC9<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAirRefresherFunctionSetting() {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * A bitmap indicates mounted method for exercising self-cleaning function.<br><br>Bit 0: Information about ozone cleaning method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about drying method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted self-cleaning method<br>EPC : 0xCA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMountedSelfCleaningMethod() {
			addProperty(EPC_MOUNTED_SELF_CLEANING_METHOD);
			return this;
		}
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.<br><br>Name : Self-cleaning function setting<br>EPC : 0xCB<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSelfCleaningFunctionSetting() {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br><br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.<br><br>Name : Special function setting<br>EPC : 0xCC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSpecialFunctionSetting() {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING);
			return this;
		}
		/**
		 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br><br>Bit 0: Operation status of the compressor: 0: Not operating 1: In operation Bit 1: Operation status of the thermostat: 0: Thermostat OFF 1: Thermostat ON Bits 2 to 7: Reserved for future use.<br><br>Name : Operation status of components<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetOperationStatusOfComponents() {
			addProperty(EPC_OPERATION_STATUS_OF_COMPONENTS);
			return this;
		}
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br><br>Air purification ON  0x41,OFF   0x42<br><br>Name : Air purification mode setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAirPurificationModeSetting() {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : ON timer-based reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerBasedReservationSetting() {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : OFF timer-based reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOffTimerBasedReservationSetting() {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
	}
	
	public interface Informer extends DeviceObject.Informer {
		public Informer reqInform(byte epc);
		
		public Informer reqInformOperationStatus();
		public Informer reqInformInstallationLocation();
		public Informer reqInformStandardVersionInformation();
		public Informer reqInformIdentificationNumber();
		public Informer reqInformMeasuredInstantaneousPowerConsumption();
		public Informer reqInformMeasuredCumulativePowerConsumption();
		public Informer reqInformManufacturersFaultCode();
		public Informer reqInformCurrentLimitSetting();
		public Informer reqInformFaultStatus();
		public Informer reqInformFaultDescription();
		public Informer reqInformManufacturerCode();
		public Informer reqInformBusinessFacilityCode();
		public Informer reqInformProductCode();
		public Informer reqInformProductionNumber();
		public Informer reqInformProductionDate();
		public Informer reqInformPowerSavingOperationSetting();
		public Informer reqInformPositionInformation();
		public Informer reqInformCurrentTimeSetting();
		public Informer reqInformCurrentDateSetting();
		public Informer reqInformPowerLimitSetting();
		public Informer reqInformCumulativeOperatingTime();
		public Informer reqInformStatusChangeAnnouncementPropertyMap();
		public Informer reqInformSetPropertyMap();
		public Informer reqInformGetPropertyMap();
		
		/**
		 * Used to specify the operation mode ( gautomatic, h  gcooling, h  gheating, h  gdehumidification, h  gair circulator h or  gother h), and to acquire the current setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Informer reqInformOperationModeSetting();
		/**
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting.<br><br>Automatic = 0x41 Non-automatic = 0x42<br><br>Name : Automatic temperature control setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAutomaticTemperatureControlSetting();
		/**
		 * Used to specify the type of operation ( gnormal, h  ghigh-speed h or  gsilent h), and to acquire the current setting.<br><br>Normal operation: 0x41 High-speed operation: 0x42 Silent operation: 0x43<br><br>Name : Normal/high- speed/silent operation setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformNormalHighSpeedSilentOperationSetting();
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Informer reqInformSetTemperatureValue();
		/**
		 * Used to set the relative humidity for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Set value of relative humidity in dehumidifying mode<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfRelativeHumidityInDehumidifyingMode();
		/**
		 * Used to set the temperature for the  gcooling h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in cooling mode<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetTemperatureValueInCoolingMode();
		/**
		 * Used to set the temperature for the  gheating h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in heating mode<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetTemperatureValueInHeatingMode();
		/**
		 * Used to set the temperature for the  gdehumidification h mode and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50  )<br><br>Name : Set temperature value in dehumidifying mode<br>EPC : 0xB7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetTemperatureValueInDehumidifyingMode();
		/**
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast<br><br>0x0000.0xFFFD (0.65533W) Cooling: heating: dehumidifying: blast<br><br>Name : Rated power consumption<br>EPC : 0xB8<br>Data Type : unsigned short x 4<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRatedPowerConsumption();
		/**
		 * Measured value of current consumption<br><br>0x0000.0xFFFD (0.6553.3A)<br><br>Name : Measured value of current consumption<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredValueOfCurrentConsumption();
		/**
		 * Measured value of room relative humidity<br><br>0x00.0x64 (0.100. C)<br><br>Name : Measured value of room relative humidity<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity();
		/**
		 * Measured value of room temperature<br><br>0x80.0x7D (-127.125.C)<br><br>Name : Measured value of room temperature<br>EPC : 0xBB<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredValueOfRoomTemperature();
		/**
		 * Set temperature value of user remote control<br><br>0x00.0x32 (0.50.C)<br><br>Name : Set temperature value of user remote control<br>EPC : 0xBC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSetTemperatureValueOfUserRemoteControl();
		/**
		 * This property indicates the measured cooled air temperature at the outlet.<br><br>0x81 to 0x7D (-127 to 125  C)<br><br>Name : Measured cooled air temperature<br>EPC : 0xBD<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredCooledAirTemperature();
		/**
		 * This property indicates the measured outdoor air temperature.<br><br>0x81 to 0x7D (-127 to 125  C)<br><br>Name : Measured outdoor air temperature<br>EPC : 0xBE<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature();
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7  C to 12.5  C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRelativeTemperatureSetting();
		/**
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAirFlowRateSetting();
		/**
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting.<br><br>Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br><br>Name : Automatic control of air flow direction setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAutomaticControlOfAirFlowDirectionSetting();
		/**
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting.<br><br>Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br><br>Name : Automatic swing of air flow setting<br>EPC : 0xA3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAutomaticSwingOfAirFlowSetting();
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting.<br><br>Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br><br>Name : Air flow direction (vertical) setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAirFlowDirectionVerticalSetting();
		/**
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting.<br><br>Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44 (for a full list of the predefined patterns, see the table in the subsection defining the detailed requirements for this property.<br><br>Name : Air flow direction (horizontal) setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAirFlowDirectionHorizontalSetting();
		/**
		 * This property indicates if the air conditioner is in a  gspecial h state (i.e. the  gdefrosting, h  gpreheating, h or  gheat removal h state).<br><br> gNormal operation h state = 0x40,  gDefrosting h state = 0x41,  gPreheating h state = 0x42,  gHeat removal h state = 0x43<br><br>Name : Special state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSpecialState();
		/**
		 * Used to indicate when the air conditioner is in a  gnon-priority h state.<br><br> gNormal operation h state = 0x40,  gNon-priority h state = 0x41<br><br>Name : Non-priority state<br>EPC : 0xAB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformNonPriorityState();
		/**
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting.<br><br>Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br><br>Name : Ventilation function setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformVentilationFunctionSetting();
		/**
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting.<br><br>Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br><br>Name : Humidifier function setting<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHumidifierFunctionSetting();
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformVentilationAirFlowRateSetting();
		/**
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>Automatic control of the degree of humidification = 0x41 Degree of humidification = 0x31 to 0x38<br><br>Name : Degree of humidification setting<br>EPC : 0xC4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDegreeOfHumidificationSetting();
		/**
		 * A bitmap indicates mounted method of exercising air cleaning function.<br><br>Bit 0: Information about electrical dust collection method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted air cleaning method<br>EPC : 0xC6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMountedAirCleaningMethod();
		/**
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function. Element 1: Indicates whether or not to use the cluster ion-based air purifier function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air purifier function setting<br>EPC : 0xC7<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAirPurifierFunctionSetting();
		/**
		 * A bitmap indicates mounted method for exercising refresh function.<br><br>Bit 0: Information about minus ion method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about cluster ion method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted air refresh method<br>EPC : 0xC8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMountedAirRefreshMethod();
		/**
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the minus ion-based air refresher function. Element 1: Indicates whether or not to use the cluster ion-based air refresher function. Elements 2 to 7: Reserved for future use.<br><br>Name : Air refresher function setting<br>EPC : 0xC9<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAirRefresherFunctionSetting();
		/**
		 * A bitmap indicates mounted method for exercising self-cleaning function.<br><br>Bit 0: Information about ozone cleaning method mounting 0 - Not mounted 1 - Mounted Bit 1: Information about drying method mounting 0 - Not mounted 1 . Mounted<br><br>Name : Mounted self-cleaning method<br>EPC : 0xCA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMountedSelfCleaningMethod();
		/**
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of self-cleaning to achieve with the self-cleaning function, and to acquire the current settings.<br><br>Element 0: Indicates whether or not to use the ozone-based self-cleaning function. Element 1: Indicates whether or not to use the drying-based self-cleaning function. Elements 2 to 7: Reserved for future use.<br><br>Name : Self-cleaning function setting<br>EPC : 0xCB<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSelfCleaningFunctionSetting();
		/**
		 * Used to specify the  gspecial function h to use, and to acquire the current setting.<br><br>No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44 0x45 . : Reserved for future use.<br><br>Name : Special function setting<br>EPC : 0xCC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSpecialFunctionSetting();
		/**
		 * This property indicates the operation status of components of the air conditioner in a bitmap format.<br><br>Bit 0: Operation status of the compressor: 0: Not operating 1: In operation Bit 1: Operation status of the thermostat: 0: Thermostat OFF 1: Thermostat ON Bits 2 to 7: Reserved for future use.<br><br>Name : Operation status of components<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformOperationStatusOfComponents();
		/**
		 * Used to set the air purification mode seting ON/OFF and to acquire the current setting. B<br><br>Air purification ON  0x41,OFF   0x42<br><br>Name : Air purification mode setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAirPurificationModeSetting();
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : ON timer-based reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : OFF timer-based reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOffTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOffTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOffTimerSettingRelativeTime();
	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {
		@Override
		public Informer reqInform(byte epc) {
			return (Informer)super.reqInform(epc);
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

		@Override
		public Informer reqInformOperationModeSetting() {
			byte epc = EPC_OPERATION_MODE_SETTING;
			byte[] edt = _getOperationModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticTemperatureControlSetting() {
			byte epc = EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING;
			byte[] edt = _getAutomaticTemperatureControlSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformNormalHighSpeedSilentOperationSetting() {
			byte epc = EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING;
			byte[] edt = _getNormalHighSpeedSilentOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValue() {
			byte epc = EPC_SET_TEMPERATURE_VALUE;
			byte[] edt = _getSetTemperatureValue(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfRelativeHumidityInDehumidifyingMode() {
			byte epc = EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE;
			byte[] edt = _getSetValueOfRelativeHumidityInDehumidifyingMode(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInCoolingMode() {
			byte epc = EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE;
			byte[] edt = _getSetTemperatureValueInCoolingMode(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInHeatingMode() {
			byte epc = EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE;
			byte[] edt = _getSetTemperatureValueInHeatingMode(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInDehumidifyingMode() {
			byte epc = EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE;
			byte[] edt = _getSetTemperatureValueInDehumidifyingMode(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumption() {
			byte epc = EPC_RATED_POWER_CONSUMPTION;
			byte[] edt = _getRatedPowerConsumption(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfCurrentConsumption() {
			byte epc = EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION;
			byte[] edt = _getMeasuredValueOfCurrentConsumption(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity() {
			byte epc = EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY;
			byte[] edt = _getMeasuredValueOfRoomRelativeHumidity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomTemperature() {
			byte epc = EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE;
			byte[] edt = _getMeasuredValueOfRoomTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueOfUserRemoteControl() {
			byte epc = EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL;
			byte[] edt = _getSetTemperatureValueOfUserRemoteControl(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCooledAirTemperature() {
			byte epc = EPC_MEASURED_COOLED_AIR_TEMPERATURE;
			byte[] edt = _getMeasuredCooledAirTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature() {
			byte epc = EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE;
			byte[] edt = _getMeasuredOutdoorAirTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRelativeTemperatureSetting() {
			byte epc = EPC_RELATIVE_TEMPERATURE_SETTING;
			byte[] edt = _getRelativeTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			byte epc = EPC_AIR_FLOW_RATE_SETTING;
			byte[] edt = _getAirFlowRateSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticControlOfAirFlowDirectionSetting() {
			byte epc = EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING;
			byte[] edt = _getAutomaticControlOfAirFlowDirectionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticSwingOfAirFlowSetting() {
			byte epc = EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING;
			byte[] edt = _getAutomaticSwingOfAirFlowSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowDirectionVerticalSetting() {
			byte epc = EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING;
			byte[] edt = _getAirFlowDirectionVerticalSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowDirectionHorizontalSetting() {
			byte epc = EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING;
			byte[] edt = _getAirFlowDirectionHorizontalSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSpecialState() {
			byte epc = EPC_SPECIAL_STATE;
			byte[] edt = _getSpecialState(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformNonPriorityState() {
			byte epc = EPC_NON_PRIORITY_STATE;
			byte[] edt = _getNonPriorityState(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationFunctionSetting() {
			byte epc = EPC_VENTILATION_FUNCTION_SETTING;
			byte[] edt = _getVentilationFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHumidifierFunctionSetting() {
			byte epc = EPC_HUMIDIFIER_FUNCTION_SETTING;
			byte[] edt = _getHumidifierFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationAirFlowRateSetting() {
			byte epc = EPC_VENTILATION_AIR_FLOW_RATE_SETTING;
			byte[] edt = _getVentilationAirFlowRateSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDegreeOfHumidificationSetting() {
			byte epc = EPC_DEGREE_OF_HUMIDIFICATION_SETTING;
			byte[] edt = _getDegreeOfHumidificationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMountedAirCleaningMethod() {
			byte epc = EPC_MOUNTED_AIR_CLEANING_METHOD;
			byte[] edt = _getMountedAirCleaningMethod(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirPurifierFunctionSetting() {
			byte epc = EPC_AIR_PURIFIER_FUNCTION_SETTING;
			byte[] edt = _getAirPurifierFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMountedAirRefreshMethod() {
			byte epc = EPC_MOUNTED_AIR_REFRESH_METHOD;
			byte[] edt = _getMountedAirRefreshMethod(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirRefresherFunctionSetting() {
			byte epc = EPC_AIR_REFRESHER_FUNCTION_SETTING;
			byte[] edt = _getAirRefresherFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMountedSelfCleaningMethod() {
			byte epc = EPC_MOUNTED_SELF_CLEANING_METHOD;
			byte[] edt = _getMountedSelfCleaningMethod(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSelfCleaningFunctionSetting() {
			byte epc = EPC_SELF_CLEANING_FUNCTION_SETTING;
			byte[] edt = _getSelfCleaningFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformSpecialFunctionSetting() {
			byte epc = EPC_SPECIAL_FUNCTION_SETTING;
			byte[] edt = _getSpecialFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOperationStatusOfComponents() {
			byte epc = EPC_OPERATION_STATUS_OF_COMPONENTS;
			byte[] edt = _getOperationStatusOfComponents(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirPurificationModeSetting() {
			byte epc = EPC_AIR_PURIFICATION_MODE_SETTING;
			byte[] edt = _getAirPurificationModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerBasedReservationSetting() {
			byte epc = EPC_ON_TIMER_BASED_RESERVATION_SETTING;
			byte[] edt = _getOnTimerBasedReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingTime() {
			byte epc = EPC_ON_TIMER_SETTING_TIME;
			byte[] edt = _getOnTimerSettingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingRelativeTime() {
			byte epc = EPC_ON_TIMER_SETTING_RELATIVE_TIME;
			byte[] edt = _getOnTimerSettingRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerBasedReservationSetting() {
			byte epc = EPC_OFF_TIMER_BASED_RESERVATION_SETTING;
			byte[] edt = _getOffTimerBasedReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			byte epc = EPC_OFF_TIMER_SETTING_TIME;
			byte[] edt = _getOffTimerSettingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingRelativeTime() {
			byte epc = EPC_OFF_TIMER_SETTING_RELATIVE_TIME;
			byte[] edt = _getOffTimerSettingRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {
		@Override
		public Informer reqInform(byte epc) {
			return (Informer)super.reqInform(epc);
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

		@Override
		public Informer reqInformOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformNormalHighSpeedSilentOperationSetting() {
			addProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValue() {
			addProperty(EPC_SET_TEMPERATURE_VALUE);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfRelativeHumidityInDehumidifyingMode() {
			addProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInCoolingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInHeatingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueInDehumidifyingMode() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumption() {
			addProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfCurrentConsumption() {
			addProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION);
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRoomTemperature() {
			addProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformSetTemperatureValueOfUserRemoteControl() {
			addProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCooledAirTemperature() {
			addProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredOutdoorAirTemperature() {
			addProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformRelativeTemperatureSetting() {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAutomaticControlOfAirFlowDirectionSetting() {
			addProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAutomaticSwingOfAirFlowSetting() {
			addProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAirFlowDirectionVerticalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAirFlowDirectionHorizontalSetting() {
			addProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSpecialState() {
			addProperty(EPC_SPECIAL_STATE);
			return this;
		}
		@Override
		public Informer reqInformNonPriorityState() {
			addProperty(EPC_NON_PRIORITY_STATE);
			return this;
		}
		@Override
		public Informer reqInformVentilationFunctionSetting() {
			addProperty(EPC_VENTILATION_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformHumidifierFunctionSetting() {
			addProperty(EPC_HUMIDIFIER_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformDegreeOfHumidificationSetting() {
			addProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMountedAirCleaningMethod() {
			addProperty(EPC_MOUNTED_AIR_CLEANING_METHOD);
			return this;
		}
		@Override
		public Informer reqInformAirPurifierFunctionSetting() {
			addProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMountedAirRefreshMethod() {
			addProperty(EPC_MOUNTED_AIR_REFRESH_METHOD);
			return this;
		}
		@Override
		public Informer reqInformAirRefresherFunctionSetting() {
			addProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMountedSelfCleaningMethod() {
			addProperty(EPC_MOUNTED_SELF_CLEANING_METHOD);
			return this;
		}
		@Override
		public Informer reqInformSelfCleaningFunctionSetting() {
			addProperty(EPC_SELF_CLEANING_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSpecialFunctionSetting() {
			addProperty(EPC_SPECIAL_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOperationStatusOfComponents() {
			addProperty(EPC_OPERATION_STATUS_OF_COMPONENTS);
			return this;
		}
		@Override
		public Informer reqInformAirPurificationModeSetting() {
			addProperty(EPC_AIR_PURIFICATION_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerBasedReservationSetting() {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		@Override
		public Informer reqInformOffTimerBasedReservationSetting() {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
	}
}
