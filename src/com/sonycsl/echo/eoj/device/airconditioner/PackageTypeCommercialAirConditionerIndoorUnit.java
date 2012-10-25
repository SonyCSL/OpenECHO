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

public abstract class PackageTypeCommercialAirConditionerIndoorUnit extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x45;
	
	public PackageTypeCommercialAirConditionerIndoorUnit() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_OPERATION_MODE_SETTING = (byte)0xB0;
	public static final byte EPC_TEMPERATURE_SETTING1 = (byte)0xB3;
	public static final byte EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1 = (byte)0xB4;
	public static final byte EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1 = (byte)0xB5;
	public static final byte EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1 = (byte)0xB6;
	public static final byte EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1 = (byte)0xB7;
	public static final byte EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT = (byte)0xB8;
	public static final byte EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT = (byte)0xB9;
	public static final byte EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1 = (byte)0xBA;
	public static final byte EPC_MEASURED_INDOOR_TEMPERATURE1 = (byte)0xBB;
	public static final byte EPC_RELATIVE_TEMPERATURE_SETTING = (byte)0xBF;
	public static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	public static final byte EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING = (byte)0xA4;
	public static final byte EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING = (byte)0xA5;
	public static final byte EPC_GSPECIAL_H_STATE = (byte)0xAA;
	public static final byte EPC_THERMOSTAT_STATE = (byte)0xAC;
	public static final byte EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE = (byte)0xAE;
	public static final byte EPC_VENTILATION_MODE_SETTING = (byte)0xC0;
	public static final byte EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER = (byte)0xC1;
	public static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	public static final byte EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING = (byte)0xCD;
	public static final byte EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION = (byte)0xCE;
	public static final byte EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING = (byte)0xCF;
	public static final byte EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT = (byte)0xDB;
	public static final byte EPC_APERTURE_OF_EXPANSION_VALVE = (byte)0xDC;
	public static final byte EPC_TEMPERATURE_SETTING2 = (byte)0xE3;
	public static final byte EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2 = (byte)0xE4;
	public static final byte EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2 = (byte)0xE5;
	public static final byte EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2 = (byte)0xE6;
	public static final byte EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2 = (byte)0xE7;
	public static final byte EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2 = (byte)0xEA;
	public static final byte EPC_MEASURED_INDOOR_TEMPERATURE2 = (byte)0xEB;
	public static final byte EPC_GON_TIMER_BASED_RESERVATION_H_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING_TIME = (byte)0x91;
	public static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME = (byte)0x92;
	public static final byte EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING = (byte)0x94;
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
	 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract boolean setOperationModeSetting(byte[] edt);
	private final boolean _setOperationModeSetting(byte epc, byte[] edt) {
		boolean success = setOperationModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract byte[] getOperationModeSetting();
	private final byte[] _getOperationModeSetting(byte epc) {
		byte[] edt = getOperationModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : Temperature setting 1<br>EPC : 0xB3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract boolean setTemperatureSetting1(byte[] edt);
	private final boolean _setTemperatureSetting1(byte epc, byte[] edt) {
		boolean success = setTemperatureSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : Temperature setting 1<br>EPC : 0xB3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract byte[] getTemperatureSetting1();
	private final byte[] _getTemperatureSetting1(byte epc) {
		byte[] edt = getTemperatureSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : �gRelative . humidity setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected boolean setGrelativeHumiditySettingForEdehumidificaTionFModeH1(byte[] edt) {return false;}
	private final boolean _setGrelativeHumiditySettingForEdehumidificaTionFModeH1(byte epc, byte[] edt) {
		boolean success = setGrelativeHumiditySettingForEdehumidificaTionFModeH1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : �gRelative . humidity setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getGrelativeHumiditySettingForEdehumidificaTionFModeH1() {return null;}
	private final byte[] _getGrelativeHumiditySettingForEdehumidificaTionFModeH1(byte epc) {
		byte[] edt = getGrelativeHumiditySettingForEdehumidificaTionFModeH1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �ecooling�f .mode�h . 1<br>EPC : 0xB5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGtemperatureSettingForEcoolingFModeH1(byte[] edt) {return false;}
	private final boolean _setGtemperatureSettingForEcoolingFModeH1(byte epc, byte[] edt) {
		boolean success = setGtemperatureSettingForEcoolingFModeH1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �ecooling�f .mode�h . 1<br>EPC : 0xB5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGtemperatureSettingForEcoolingFModeH1() {return null;}
	private final byte[] _getGtemperatureSettingForEcoolingFModeH1(byte epc) {
		byte[] edt = getGtemperatureSettingForEcoolingFModeH1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �eheating�f .mode�h . 1<br>EPC : 0xB6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGtemperatureSettingForEheatingFModeH1(byte[] edt) {return false;}
	private final boolean _setGtemperatureSettingForEheatingFModeH1(byte epc, byte[] edt) {
		boolean success = setGtemperatureSettingForEheatingFModeH1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �eheating�f .mode�h . 1<br>EPC : 0xB6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGtemperatureSettingForEheatingFModeH1() {return null;}
	private final byte[] _getGtemperatureSettingForEheatingFModeH1(byte epc) {
		byte[] edt = getGtemperatureSettingForEheatingFModeH1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB7<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGtemperatureSettingForEdehumidificaTionFModeH1(byte[] edt) {return false;}
	private final boolean _setGtemperatureSettingForEdehumidificaTionFModeH1(byte epc, byte[] edt) {
		boolean success = setGtemperatureSettingForEdehumidificaTionFModeH1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB7<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGtemperatureSettingForEdehumidificaTionFModeH1() {return null;}
	private final byte[] _getGtemperatureSettingForEdehumidificaTionFModeH1(byte epc) {
		byte[] edt = getGtemperatureSettingForEdehumidificaTionFModeH1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br><br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification: air circulator<br><br>Name : Rated power consumption of indoor unit<br>EPC : 0xB8<br>Data Type : unsigned short x 4<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRatedPowerConsumptionOfIndoorUnit() {return null;}
	private final byte[] _getRatedPowerConsumptionOfIndoorUnit(byte epc) {
		byte[] edt = getRatedPowerConsumptionOfIndoorUnit();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption of indoor unit<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredElectricCurrentConsumptionOfIndoorUnit() {return null;}
	private final byte[] _getMeasuredElectricCurrentConsumptionOfIndoorUnit(byte epc) {
		byte[] edt = getMeasuredElectricCurrentConsumptionOfIndoorUnit();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured indoor relative humidity.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Measured indoor relative humidity 1<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredIndoorRelativeHumidity1() {return null;}
	private final byte[] _getMeasuredIndoorRelativeHumidity1(byte epc) {
		byte[] edt = getMeasuredIndoorRelativeHumidity1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured indoor temperature.<br><br>0x81 to 0x7D (-127 to 125��C)<br><br>Name : Measured indoor temperature 1<br>EPC : 0xBB<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredIndoorTemperature1() {return null;}
	private final byte[] _getMeasuredIndoorTemperature1(byte epc) {
		byte[] edt = getMeasuredIndoorTemperature1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRelativeTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setRelativeTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setRelativeTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRelativeTemperatureSetting() {return null;}
	private final byte[] _getRelativeTemperatureSetting(byte epc) {
		byte[] edt = getRelativeTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	private final boolean _setAirFlowRateSetting(byte epc, byte[] edt) {
		boolean success = setAirFlowRateSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAirFlowRateSetting() {return null;}
	private final byte[] _getAirFlowRateSetting(byte epc) {
		byte[] edt = getAirFlowRateSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Name : �gAir flow direction (vertical)�h setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGairFlowDirectionVerticalHSetting(byte[] edt) {return false;}
	private final boolean _setGairFlowDirectionVerticalHSetting(byte epc, byte[] edt) {
		boolean success = setGairFlowDirectionVerticalHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Name : �gAir flow direction (vertical)�h setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGairFlowDirectionVerticalHSetting() {return null;}
	private final byte[] _getGairFlowDirectionVerticalHSetting(byte epc) {
		byte[] edt = getGairFlowDirectionVerticalHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Name : �gAir flow direction (horizontal)�h setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGairFlowDirectionHorizontalHSetting(byte[] edt) {return false;}
	private final boolean _setGairFlowDirectionHorizontalHSetting(byte epc, byte[] edt) {
		boolean success = setGairFlowDirectionHorizontalHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Name : �gAir flow direction (horizontal)�h setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGairFlowDirectionHorizontalHSetting() {return null;}
	private final byte[] _getGairFlowDirectionHorizontalHSetting(byte epc) {
		byte[] edt = getGairFlowDirectionHorizontalHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates when the air conditioner is in a �gspecial�h state.<br><br>�gNormal operation�h state = 0x40, �gpreheating�h state = 0x42, �gheat removal�h state = 0x43<br><br>Name : �gSpecial�h state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getGspecialHState() {return null;}
	private final byte[] _getGspecialHState(byte epc) {
		byte[] edt = getGspecialHState();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the state (ON or OFF) of the thermostat.<br><br>Thermostat ON = 0x41 Thermostat OFF = 0x42<br><br>Name : Thermostat state<br>EPC : 0xAC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getThermostatState() {return null;}
	private final byte[] _getThermostatState(byte epc) {
		byte[] edt = getThermostatState();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates, when the air conditioner is operating in the �gautomatic�h operation mode, the function (�gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h) that is currently being used.<br><br>The following values shall be used: Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Current function (�gautomatic�h operation mode)<br>EPC : 0xAE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getCurrentFunctionGautomaticHOperationMode() {return null;}
	private final byte[] _getCurrentFunctionGautomaticHOperationMode(byte epc) {
		byte[] edt = getCurrentFunctionGautomaticHOperationMode();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the ventilation mode and to acquire the current setting.<br><br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Name : Ventilation mode setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVentilationModeSetting(byte[] edt) {return false;}
	private final boolean _setVentilationModeSetting(byte epc, byte[] edt) {
		boolean success = setVentilationModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the ventilation mode and to acquire the current setting.<br><br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Name : Ventilation mode setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getVentilationModeSetting() {return null;}
	private final byte[] _getVentilationModeSetting(byte epc) {
		byte[] edt = getVentilationModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br><br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Name : Combined operation of indoor unit and total heat exchanger<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte[] edt) {return false;}
	private final boolean _setCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte epc, byte[] edt) {
		boolean success = setCombinedOperationOfIndoorUnitAndTotalHeatExchanger(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br><br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Name : Combined operation of indoor unit and total heat exchanger<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {return null;}
	private final byte[] _getCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte epc) {
		byte[] edt = getCombinedOperationOfIndoorUnitAndTotalHeatExchanger();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	private final boolean _setVentilationAirFlowRateSetting(byte epc, byte[] edt) {
		boolean success = setVentilationAirFlowRateSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	private final byte[] _getVentilationAirFlowRateSetting(byte epc) {
		byte[] edt = getVentilationAirFlowRateSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br><br>Disabled = 0x41, not disabled = 0x42<br><br>Name : �gDisabling of air conditioner�h setting<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGdisablingOfAirConditionerHSetting(byte[] edt) {return false;}
	private final boolean _setGdisablingOfAirConditionerHSetting(byte epc, byte[] edt) {
		boolean success = setGdisablingOfAirConditionerHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br><br>Disabled = 0x41, not disabled = 0x42<br><br>Name : �gDisabling of air conditioner�h setting<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGdisablingOfAirConditionerHSetting() {return null;}
	private final byte[] _getGdisablingOfAirConditionerHSetting(byte epc) {
		byte[] edt = getGdisablingOfAirConditionerHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setThermostatSettingOverrideFunction(byte[] edt) {return false;}
	private final boolean _setThermostatSettingOverrideFunction(byte epc, byte[] edt) {
		boolean success = setThermostatSettingOverrideFunction(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getThermostatSettingOverrideFunction() {return null;}
	private final byte[] _getThermostatSettingOverrideFunction(byte epc) {
		byte[] edt = getThermostatSettingOverrideFunction();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br><br>Enabled = 0x41, disabled = 0x42<br><br>Name : Filter cleaning reminder lamp setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected boolean setFilterCleaningReminderLampSetting(byte[] edt) {return false;}
	private final boolean _setFilterCleaningReminderLampSetting(byte epc, byte[] edt) {
		boolean success = setFilterCleaningReminderLampSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br><br>Enabled = 0x41, disabled = 0x42<br><br>Name : Filter cleaning reminder lamp setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getFilterCleaningReminderLampSetting() {return null;}
	private final byte[] _getFilterCleaningReminderLampSetting(byte epc) {
		byte[] edt = getFilterCleaningReminderLampSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured power consumption of the indoor unit.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Measured power consumption of indoor unit<br>EPC : 0xDB<br>Data Type : unsigned<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredPowerConsumptionOfIndoorUnit() {return null;}
	private final byte[] _getMeasuredPowerConsumptionOfIndoorUnit(byte epc) {
		byte[] edt = getMeasuredPowerConsumptionOfIndoorUnit();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the aperture of the expansion valve in %.<br><br>0 to 0x64 (0 to 100%)<br><br>Name : Aperture of expansion valve<br>EPC : 0xDC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getApertureOfExpansionValve() {return null;}
	private final byte[] _getApertureOfExpansionValve(byte epc) {
		byte[] edt = getApertureOfExpansionValve();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : Temperature setting 2<br>EPC : 0xE3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract boolean setTemperatureSetting2(byte[] edt);
	private final boolean _setTemperatureSetting2(byte epc, byte[] edt) {
		boolean success = setTemperatureSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : Temperature setting 2<br>EPC : 0xE3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract byte[] getTemperatureSetting2();
	private final byte[] _getTemperatureSetting2(byte epc) {
		byte[] edt = getTemperatureSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : �gRelative humidity setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected boolean setGrelativeHumiditySettingForEdehumidificatioNFModeH2(byte[] edt) {return false;}
	private final boolean _setGrelativeHumiditySettingForEdehumidificatioNFModeH2(byte epc, byte[] edt) {
		boolean success = setGrelativeHumiditySettingForEdehumidificatioNFModeH2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : �gRelative humidity setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getGrelativeHumiditySettingForEdehumidificatioNFModeH2() {return null;}
	private final byte[] _getGrelativeHumiditySettingForEdehumidificatioNFModeH2(byte epc) {
		byte[] edt = getGrelativeHumiditySettingForEdehumidificatioNFModeH2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �ecooling�f mode�h 2<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGtemperatureSettingForEcoolingFModeH2(byte[] edt) {return false;}
	private final boolean _setGtemperatureSettingForEcoolingFModeH2(byte epc, byte[] edt) {
		boolean success = setGtemperatureSettingForEcoolingFModeH2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �ecooling�f mode�h 2<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGtemperatureSettingForEcoolingFModeH2() {return null;}
	private final byte[] _getGtemperatureSettingForEcoolingFModeH2(byte epc) {
		byte[] edt = getGtemperatureSettingForEcoolingFModeH2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �eheating�f mode�h 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGtemperatureSettingForEheatingFModeH2(byte[] edt) {return false;}
	private final boolean _setGtemperatureSettingForEheatingFModeH2(byte epc, byte[] edt) {
		boolean success = setGtemperatureSettingForEheatingFModeH2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �eheating�f mode�h 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGtemperatureSettingForEheatingFModeH2() {return null;}
	private final byte[] _getGtemperatureSettingForEheatingFModeH2(byte epc) {
		byte[] edt = getGtemperatureSettingForEheatingFModeH2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGtemperatureSettingForEdehumidificatioNFModeH2(byte[] edt) {return false;}
	private final boolean _setGtemperatureSettingForEdehumidificatioNFModeH2(byte epc, byte[] edt) {
		boolean success = setGtemperatureSettingForEdehumidificatioNFModeH2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGtemperatureSettingForEdehumidificatioNFModeH2() {return null;}
	private final byte[] _getGtemperatureSettingForEdehumidificatioNFModeH2(byte epc) {
		byte[] edt = getGtemperatureSettingForEdehumidificatioNFModeH2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured indoor relative humidity.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : Measured indoor relative humidity 2<br>EPC : 0xEA<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredIndoorRelativeHumidity2() {return null;}
	private final byte[] _getMeasuredIndoorRelativeHumidity2(byte epc) {
		byte[] edt = getMeasuredIndoorRelativeHumidity2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured indoor temperature.<br><br>0xF554 to 0x7FFD (-273,2 to 3276,5��C)<br><br>Name : Measured indoor temperature 2<br>EPC : 0xEB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredIndoorTemperature2() {return null;}
	private final byte[] _getMeasuredIndoorTemperature2(byte epc) {
		byte[] edt = getMeasuredIndoorTemperature2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gON timer-based reservation�h setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGonTimerBasedReservationHSetting(byte[] edt) {return false;}
	private final boolean _setGonTimerBasedReservationHSetting(byte epc, byte[] edt) {
		boolean success = setGonTimerBasedReservationHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gON timer-based reservation�h setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGonTimerBasedReservationHSetting() {return null;}
	private final byte[] _getGonTimerBasedReservationHSetting(byte epc) {
		byte[] edt = getGonTimerBasedReservationHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	private final byte[] _getOnTimerSettingTime(byte epc) {
		byte[] edt = getOnTimerSettingTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingRelativeTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingRelativeTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	private final byte[] _getOnTimerSettingRelativeTime(byte epc) {
		byte[] edt = getOnTimerSettingRelativeTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gOFF timer-based reservation�h setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGoffTimerBasedReservationHSetting(byte[] edt) {return false;}
	private final boolean _setGoffTimerBasedReservationHSetting(byte epc, byte[] edt) {
		boolean success = setGoffTimerBasedReservationHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gOFF timer-based reservation�h setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGoffTimerBasedReservationHSetting() {return null;}
	private final byte[] _getGoffTimerBasedReservationHSetting(byte epc) {
		byte[] edt = getGoffTimerBasedReservationHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	private final boolean _setOffTimerSettingTime(byte epc, byte[] edt) {
		boolean success = setOffTimerSettingTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	private final byte[] _getOffTimerSettingTime(byte epc) {
		byte[] edt = getOffTimerSettingTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	private final boolean _setOffTimerSettingRelativeTime(byte epc, byte[] edt) {
		boolean success = setOffTimerSettingRelativeTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		case EPC_TEMPERATURE_SETTING1:
			res.addProperty(epc, edt, _setTemperatureSetting1(epc, edt));
			break;
		case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
			res.addProperty(epc, edt, _setGrelativeHumiditySettingForEdehumidificaTionFModeH1(epc, edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1:
			res.addProperty(epc, edt, _setGtemperatureSettingForEcoolingFModeH1(epc, edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1:
			res.addProperty(epc, edt, _setGtemperatureSettingForEheatingFModeH1(epc, edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
			res.addProperty(epc, edt, _setGtemperatureSettingForEdehumidificaTionFModeH1(epc, edt));
			break;
		case EPC_RELATIVE_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setRelativeTemperatureSetting(epc, edt));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, _setAirFlowRateSetting(epc, edt));
			break;
		case EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING:
			res.addProperty(epc, edt, _setGairFlowDirectionVerticalHSetting(epc, edt));
			break;
		case EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING:
			res.addProperty(epc, edt, _setGairFlowDirectionHorizontalHSetting(epc, edt));
			break;
		case EPC_VENTILATION_MODE_SETTING:
			res.addProperty(epc, edt, _setVentilationModeSetting(epc, edt));
			break;
		case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER:
			res.addProperty(epc, edt, _setCombinedOperationOfIndoorUnitAndTotalHeatExchanger(epc, edt));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, _setVentilationAirFlowRateSetting(epc, edt));
			break;
		case EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING:
			res.addProperty(epc, edt, _setGdisablingOfAirConditionerHSetting(epc, edt));
			break;
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
			res.addProperty(epc, edt, _setThermostatSettingOverrideFunction(epc, edt));
			break;
		case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING:
			res.addProperty(epc, edt, _setFilterCleaningReminderLampSetting(epc, edt));
			break;
		case EPC_TEMPERATURE_SETTING2:
			res.addProperty(epc, edt, _setTemperatureSetting2(epc, edt));
			break;
		case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
			res.addProperty(epc, edt, _setGrelativeHumiditySettingForEdehumidificatioNFModeH2(epc, edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2:
			res.addProperty(epc, edt, _setGtemperatureSettingForEcoolingFModeH2(epc, edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2:
			res.addProperty(epc, edt, _setGtemperatureSettingForEheatingFModeH2(epc, edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
			res.addProperty(epc, edt, _setGtemperatureSettingForEdehumidificatioNFModeH2(epc, edt));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING:
			res.addProperty(epc, edt, _setGonTimerBasedReservationHSetting(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingTime(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingRelativeTime(epc, edt));
			break;
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
			res.addProperty(epc, edt, _setGoffTimerBasedReservationHSetting(epc, edt));
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
		case EPC_TEMPERATURE_SETTING1:
			edt = _getTemperatureSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
			edt = _getGrelativeHumiditySettingForEdehumidificaTionFModeH1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1:
			edt = _getGtemperatureSettingForEcoolingFModeH1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1:
			edt = _getGtemperatureSettingForEheatingFModeH1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
			edt = _getGtemperatureSettingForEdehumidificaTionFModeH1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT:
			edt = _getRatedPowerConsumptionOfIndoorUnit(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT:
			edt = _getMeasuredElectricCurrentConsumptionOfIndoorUnit(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1:
			edt = _getMeasuredIndoorRelativeHumidity1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_INDOOR_TEMPERATURE1:
			edt = _getMeasuredIndoorTemperature1(epc);
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
		case EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING:
			edt = _getGairFlowDirectionVerticalHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING:
			edt = _getGairFlowDirectionHorizontalHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GSPECIAL_H_STATE:
			edt = _getGspecialHState(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_THERMOSTAT_STATE:
			edt = _getThermostatState(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE:
			edt = _getCurrentFunctionGautomaticHOperationMode(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_MODE_SETTING:
			edt = _getVentilationModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER:
			edt = _getCombinedOperationOfIndoorUnitAndTotalHeatExchanger(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			edt = _getVentilationAirFlowRateSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING:
			edt = _getGdisablingOfAirConditionerHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
			edt = _getThermostatSettingOverrideFunction(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING:
			edt = _getFilterCleaningReminderLampSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT:
			edt = _getMeasuredPowerConsumptionOfIndoorUnit(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_APERTURE_OF_EXPANSION_VALVE:
			edt = _getApertureOfExpansionValve(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPERATURE_SETTING2:
			edt = _getTemperatureSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
			edt = _getGrelativeHumiditySettingForEdehumidificatioNFModeH2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2:
			edt = _getGtemperatureSettingForEcoolingFModeH2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2:
			edt = _getGtemperatureSettingForEheatingFModeH2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
			edt = _getGtemperatureSettingForEdehumidificatioNFModeH2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2:
			edt = _getMeasuredIndoorRelativeHumidity2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INDOOR_TEMPERATURE2:
			edt = _getMeasuredIndoorTemperature2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING:
			edt = _getGonTimerBasedReservationHSetting(epc);
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
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
			edt = _getGoffTimerBasedReservationHSetting(epc);
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
			case EPC_TEMPERATURE_SETTING1:
				_onSetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
				_onSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1:
				_onSetGtemperatureSettingForEcoolingFModeH1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1:
				_onSetGtemperatureSettingForEheatingFModeH1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
				_onSetGtemperatureSettingForEdehumidificaTionFModeH1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_RELATIVE_TEMPERATURE_SETTING:
				_onSetRelativeTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				_onSetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING:
				_onSetGairFlowDirectionVerticalHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING:
				_onSetGairFlowDirectionHorizontalHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_VENTILATION_MODE_SETTING:
				_onSetVentilationModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER:
				_onSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				_onSetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING:
				_onSetGdisablingOfAirConditionerHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
				_onSetThermostatSettingOverrideFunction(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING:
				_onSetFilterCleaningReminderLampSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_TEMPERATURE_SETTING2:
				_onSetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
				_onSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2:
				_onSetGtemperatureSettingForEcoolingFModeH2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2:
				_onSetGtemperatureSettingForEheatingFModeH2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
				_onSetGtemperatureSettingForEdehumidificatioNFModeH2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING:
				_onSetGonTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				_onSetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				_onSetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
				_onSetGoffTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
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
			case EPC_TEMPERATURE_SETTING1:
				_onGetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
				_onGetGrelativeHumiditySettingForEdehumidificaTionFModeH1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1:
				_onGetGtemperatureSettingForEcoolingFModeH1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1:
				_onGetGtemperatureSettingForEheatingFModeH1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
				_onGetGtemperatureSettingForEdehumidificaTionFModeH1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT:
				_onGetRatedPowerConsumptionOfIndoorUnit(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT:
				_onGetMeasuredElectricCurrentConsumptionOfIndoorUnit(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1:
				_onGetMeasuredIndoorRelativeHumidity1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INDOOR_TEMPERATURE1:
				_onGetMeasuredIndoorTemperature1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RELATIVE_TEMPERATURE_SETTING:
				_onGetRelativeTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				_onGetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING:
				_onGetGairFlowDirectionVerticalHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING:
				_onGetGairFlowDirectionHorizontalHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GSPECIAL_H_STATE:
				_onGetGspecialHState(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_THERMOSTAT_STATE:
				_onGetThermostatState(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE:
				_onGetCurrentFunctionGautomaticHOperationMode(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VENTILATION_MODE_SETTING:
				_onGetVentilationModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER:
				_onGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				_onGetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING:
				_onGetGdisablingOfAirConditionerHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
				_onGetThermostatSettingOverrideFunction(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING:
				_onGetFilterCleaningReminderLampSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT:
				_onGetMeasuredPowerConsumptionOfIndoorUnit(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_APERTURE_OF_EXPANSION_VALVE:
				_onGetApertureOfExpansionValve(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TEMPERATURE_SETTING2:
				_onGetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
				_onGetGrelativeHumiditySettingForEdehumidificatioNFModeH2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2:
				_onGetGtemperatureSettingForEcoolingFModeH2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2:
				_onGetGtemperatureSettingForEheatingFModeH2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
				_onGetGtemperatureSettingForEdehumidificatioNFModeH2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2:
				_onGetMeasuredIndoorRelativeHumidity2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INDOOR_TEMPERATURE2:
				_onGetMeasuredIndoorTemperature2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING:
				_onGetGonTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				_onGetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				_onGetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
				_onGetGoffTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOperationModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : Temperature setting 1<br>EPC : 0xB3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onSetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : Temperature setting 1<br>EPC : 0xB3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onGetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : �gRelative . humidity setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : �gRelative . humidity setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetGrelativeHumiditySettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGrelativeHumiditySettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGrelativeHumiditySettingForEdehumidificaTionFModeH1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �ecooling�f .mode�h . 1<br>EPC : 0xB5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGtemperatureSettingForEcoolingFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGtemperatureSettingForEcoolingFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGtemperatureSettingForEcoolingFModeH1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �ecooling�f .mode�h . 1<br>EPC : 0xB5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGtemperatureSettingForEcoolingFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGtemperatureSettingForEcoolingFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGtemperatureSettingForEcoolingFModeH1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �eheating�f .mode�h . 1<br>EPC : 0xB6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGtemperatureSettingForEheatingFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGtemperatureSettingForEheatingFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGtemperatureSettingForEheatingFModeH1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �eheating�f .mode�h . 1<br>EPC : 0xB6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGtemperatureSettingForEheatingFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGtemperatureSettingForEheatingFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGtemperatureSettingForEheatingFModeH1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB7<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGtemperatureSettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGtemperatureSettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGtemperatureSettingForEdehumidificaTionFModeH1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB7<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGtemperatureSettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGtemperatureSettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGtemperatureSettingForEdehumidificaTionFModeH1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br><br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification: air circulator<br><br>Name : Rated power consumption of indoor unit<br>EPC : 0xB8<br>Data Type : unsigned short x 4<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRatedPowerConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedPowerConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedPowerConsumptionOfIndoorUnit(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption of indoor unit<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredElectricCurrentConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredElectricCurrentConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredElectricCurrentConsumptionOfIndoorUnit(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured indoor relative humidity.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Measured indoor relative humidity 1<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredIndoorRelativeHumidity1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredIndoorRelativeHumidity1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredIndoorRelativeHumidity1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured indoor temperature.<br><br>0x81 to 0x7D (-127 to 125��C)<br><br>Name : Measured indoor temperature 1<br>EPC : 0xBB<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredIndoorTemperature1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredIndoorTemperature1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredIndoorTemperature1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Name : �gAir flow direction (vertical)�h setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGairFlowDirectionVerticalHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGairFlowDirectionVerticalHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGairFlowDirectionVerticalHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Name : �gAir flow direction (vertical)�h setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGairFlowDirectionVerticalHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGairFlowDirectionVerticalHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGairFlowDirectionVerticalHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Name : �gAir flow direction (horizontal)�h setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGairFlowDirectionHorizontalHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGairFlowDirectionHorizontalHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGairFlowDirectionHorizontalHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Name : �gAir flow direction (horizontal)�h setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGairFlowDirectionHorizontalHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGairFlowDirectionHorizontalHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGairFlowDirectionHorizontalHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates when the air conditioner is in a �gspecial�h state.<br><br>�gNormal operation�h state = 0x40, �gpreheating�h state = 0x42, �gheat removal�h state = 0x43<br><br>Name : �gSpecial�h state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetGspecialHState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGspecialHState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGspecialHState(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the state (ON or OFF) of the thermostat.<br><br>Thermostat ON = 0x41 Thermostat OFF = 0x42<br><br>Name : Thermostat state<br>EPC : 0xAC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetThermostatState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetThermostatState(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetThermostatState(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates, when the air conditioner is operating in the �gautomatic�h operation mode, the function (�gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h) that is currently being used.<br><br>The following values shall be used: Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Current function (�gautomatic�h operation mode)<br>EPC : 0xAE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetCurrentFunctionGautomaticHOperationMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCurrentFunctionGautomaticHOperationMode(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCurrentFunctionGautomaticHOperationMode(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br><br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Name : Ventilation mode setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVentilationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVentilationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVentilationModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br><br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Name : Ventilation mode setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetVentilationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVentilationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVentilationModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br><br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Name : Combined operation of indoor unit and total heat exchanger<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br><br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Name : Combined operation of indoor unit and total heat exchanger<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br><br>Disabled = 0x41, not disabled = 0x42<br><br>Name : �gDisabling of air conditioner�h setting<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGdisablingOfAirConditionerHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGdisablingOfAirConditionerHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGdisablingOfAirConditionerHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br><br>Disabled = 0x41, not disabled = 0x42<br><br>Name : �gDisabling of air conditioner�h setting<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGdisablingOfAirConditionerHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGdisablingOfAirConditionerHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGdisablingOfAirConditionerHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetThermostatSettingOverrideFunction(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetThermostatSettingOverrideFunction(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br><br>Enabled = 0x41, disabled = 0x42<br><br>Name : Filter cleaning reminder lamp setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onSetFilterCleaningReminderLampSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetFilterCleaningReminderLampSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetFilterCleaningReminderLampSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br><br>Enabled = 0x41, disabled = 0x42<br><br>Name : Filter cleaning reminder lamp setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetFilterCleaningReminderLampSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFilterCleaningReminderLampSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFilterCleaningReminderLampSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured power consumption of the indoor unit.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Measured power consumption of indoor unit<br>EPC : 0xDB<br>Data Type : unsigned<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredPowerConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredPowerConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredPowerConsumptionOfIndoorUnit(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the aperture of the expansion valve in %.<br><br>0 to 0x64 (0 to 100%)<br><br>Name : Aperture of expansion valve<br>EPC : 0xDC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetApertureOfExpansionValve(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetApertureOfExpansionValve(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetApertureOfExpansionValve(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : Temperature setting 2<br>EPC : 0xE3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onSetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : Temperature setting 2<br>EPC : 0xE3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onGetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : �gRelative humidity setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : �gRelative humidity setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetGrelativeHumiditySettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGrelativeHumiditySettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGrelativeHumiditySettingForEdehumidificatioNFModeH2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �ecooling�f mode�h 2<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGtemperatureSettingForEcoolingFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGtemperatureSettingForEcoolingFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGtemperatureSettingForEcoolingFModeH2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �ecooling�f mode�h 2<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGtemperatureSettingForEcoolingFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGtemperatureSettingForEcoolingFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGtemperatureSettingForEcoolingFModeH2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �eheating�f mode�h 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGtemperatureSettingForEheatingFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGtemperatureSettingForEheatingFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGtemperatureSettingForEheatingFModeH2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �eheating�f mode�h 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGtemperatureSettingForEheatingFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGtemperatureSettingForEheatingFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGtemperatureSettingForEheatingFModeH2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGtemperatureSettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGtemperatureSettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGtemperatureSettingForEdehumidificatioNFModeH2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGtemperatureSettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGtemperatureSettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGtemperatureSettingForEdehumidificatioNFModeH2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured indoor relative humidity.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : Measured indoor relative humidity 2<br>EPC : 0xEA<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredIndoorRelativeHumidity2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredIndoorRelativeHumidity2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredIndoorRelativeHumidity2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured indoor temperature.<br><br>0xF554 to 0x7FFD (-273,2 to 3276,5��C)<br><br>Name : Measured indoor temperature 2<br>EPC : 0xEB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredIndoorTemperature2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredIndoorTemperature2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredIndoorTemperature2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gON timer-based reservation�h setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGonTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGonTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGonTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gON timer-based reservation�h setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGonTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGonTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGonTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gOFF timer-based reservation�h setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGoffTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gOFF timer-based reservation�h setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGoffTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : Temperature setting 1<br>EPC : 0xB3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Setter reqSetTemperatureSetting1(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : �gRelative . humidity setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Setter reqSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(byte[] edt) {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �ecooling�f .mode�h . 1<br>EPC : 0xB5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGtemperatureSettingForEcoolingFModeH1(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �eheating�f .mode�h . 1<br>EPC : 0xB6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGtemperatureSettingForEheatingFModeH1(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB7<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGtemperatureSettingForEdehumidificaTionFModeH1(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRelativeTemperatureSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Name : �gAir flow direction (vertical)�h setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGairFlowDirectionVerticalHSetting(byte[] edt) {
			addProperty(EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Name : �gAir flow direction (horizontal)�h setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGairFlowDirectionHorizontalHSetting(byte[] edt) {
			addProperty(EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br><br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Name : Ventilation mode setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetVentilationModeSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br><br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Name : Combined operation of indoor unit and total heat exchanger<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte[] edt) {
			addProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br><br>Disabled = 0x41, not disabled = 0x42<br><br>Name : �gDisabling of air conditioner�h setting<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGdisablingOfAirConditionerHSetting(byte[] edt) {
			addProperty(EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt) {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br><br>Enabled = 0x41, disabled = 0x42<br><br>Name : Filter cleaning reminder lamp setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Setter reqSetFilterCleaningReminderLampSetting(byte[] edt) {
			addProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : Temperature setting 2<br>EPC : 0xE3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Setter reqSetTemperatureSetting2(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : �gRelative humidity setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Setter reqSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(byte[] edt) {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �ecooling�f mode�h 2<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGtemperatureSettingForEcoolingFModeH2(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �eheating�f mode�h 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGtemperatureSettingForEheatingFModeH2(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGtemperatureSettingForEdehumidificatioNFModeH2(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gON timer-based reservation�h setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGonTimerBasedReservationHSetting(byte[] edt) {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gOFF timer-based reservation�h setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt) {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Getter reqGetOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : Temperature setting 1<br>EPC : 0xB3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Getter reqGetTemperatureSetting1() {
			addProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : �gRelative . humidity setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetGrelativeHumiditySettingForEdehumidificaTionFModeH1() {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1);
			return this;
		}
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �ecooling�f .mode�h . 1<br>EPC : 0xB5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGtemperatureSettingForEcoolingFModeH1() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1);
			return this;
		}
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �eheating�f .mode�h . 1<br>EPC : 0xB6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGtemperatureSettingForEheatingFModeH1() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1);
			return this;
		}
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB7<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGtemperatureSettingForEdehumidificaTionFModeH1() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1);
			return this;
		}
		/**
		 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br><br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification: air circulator<br><br>Name : Rated power consumption of indoor unit<br>EPC : 0xB8<br>Data Type : unsigned short x 4<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfIndoorUnit() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		/**
		 * This property indicates the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption of indoor unit<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredElectricCurrentConsumptionOfIndoorUnit() {
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		/**
		 * Used to acquire the measured indoor relative humidity.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Measured indoor relative humidity 1<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredIndoorRelativeHumidity1() {
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1);
			return this;
		}
		/**
		 * Used to acquire the measured indoor temperature.<br><br>0x81 to 0x7D (-127 to 125��C)<br><br>Name : Measured indoor temperature 1<br>EPC : 0xBB<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredIndoorTemperature1() {
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE1);
			return this;
		}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRelativeTemperatureSetting() {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Name : �gAir flow direction (vertical)�h setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGairFlowDirectionVerticalHSetting() {
			addProperty(EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING);
			return this;
		}
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Name : �gAir flow direction (horizontal)�h setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGairFlowDirectionHorizontalHSetting() {
			addProperty(EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING);
			return this;
		}
		/**
		 * This property indicates when the air conditioner is in a �gspecial�h state.<br><br>�gNormal operation�h state = 0x40, �gpreheating�h state = 0x42, �gheat removal�h state = 0x43<br><br>Name : �gSpecial�h state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetGspecialHState() {
			addProperty(EPC_GSPECIAL_H_STATE);
			return this;
		}
		/**
		 * This property indicates the state (ON or OFF) of the thermostat.<br><br>Thermostat ON = 0x41 Thermostat OFF = 0x42<br><br>Name : Thermostat state<br>EPC : 0xAC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetThermostatState() {
			addProperty(EPC_THERMOSTAT_STATE);
			return this;
		}
		/**
		 * This property indicates, when the air conditioner is operating in the �gautomatic�h operation mode, the function (�gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h) that is currently being used.<br><br>The following values shall be used: Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Current function (�gautomatic�h operation mode)<br>EPC : 0xAE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetCurrentFunctionGautomaticHOperationMode() {
			addProperty(EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE);
			return this;
		}
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br><br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Name : Ventilation mode setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetVentilationModeSetting() {
			addProperty(EPC_VENTILATION_MODE_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br><br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Name : Combined operation of indoor unit and total heat exchanger<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {
			addProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER);
			return this;
		}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br><br>Disabled = 0x41, not disabled = 0x42<br><br>Name : �gDisabling of air conditioner�h setting<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGdisablingOfAirConditionerHSetting() {
			addProperty(EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetThermostatSettingOverrideFunction() {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION);
			return this;
		}
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br><br>Enabled = 0x41, disabled = 0x42<br><br>Name : Filter cleaning reminder lamp setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetFilterCleaningReminderLampSetting() {
			addProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING);
			return this;
		}
		/**
		 * This property indicates the measured power consumption of the indoor unit.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Measured power consumption of indoor unit<br>EPC : 0xDB<br>Data Type : unsigned<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredPowerConsumptionOfIndoorUnit() {
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		/**
		 * This property indicates the aperture of the expansion valve in %.<br><br>0 to 0x64 (0 to 100%)<br><br>Name : Aperture of expansion valve<br>EPC : 0xDC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetApertureOfExpansionValve() {
			addProperty(EPC_APERTURE_OF_EXPANSION_VALVE);
			return this;
		}
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : Temperature setting 2<br>EPC : 0xE3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Getter reqGetTemperatureSetting2() {
			addProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : �gRelative humidity setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetGrelativeHumiditySettingForEdehumidificatioNFModeH2() {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2);
			return this;
		}
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �ecooling�f mode�h 2<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGtemperatureSettingForEcoolingFModeH2() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2);
			return this;
		}
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �eheating�f mode�h 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGtemperatureSettingForEheatingFModeH2() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2);
			return this;
		}
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGtemperatureSettingForEdehumidificatioNFModeH2() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2);
			return this;
		}
		/**
		 * Used to acquire the measured indoor relative humidity.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : Measured indoor relative humidity 2<br>EPC : 0xEA<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredIndoorRelativeHumidity2() {
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2);
			return this;
		}
		/**
		 * Used to acquire the measured indoor temperature.<br><br>0xF554 to 0x7FFD (-273,2 to 3276,5��C)<br><br>Name : Measured indoor temperature 2<br>EPC : 0xEB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredIndoorTemperature2() {
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE2);
			return this;
		}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gON timer-based reservation�h setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGonTimerBasedReservationHSetting() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING);
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gOFF timer-based reservation�h setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGoffTimerBasedReservationHSetting() {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING);
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br><br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Name : Operation mode setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Informer reqInformOperationModeSetting();
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : Temperature setting 1<br>EPC : 0xB3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Informer reqInformTemperatureSetting1();
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : �gRelative . humidity setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformGrelativeHumiditySettingForEdehumidificaTionFModeH1();
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �ecooling�f .mode�h . 1<br>EPC : 0xB5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGtemperatureSettingForEcoolingFModeH1();
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �eheating�f .mode�h . 1<br>EPC : 0xB6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGtemperatureSettingForEheatingFModeH1();
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br><br>0x00 to 0x32 (0 to 50��C)<br><br>Name : �gTemperature . setting for �edehumidifica- tion�f .mode�h .1<br>EPC : 0xB7<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGtemperatureSettingForEdehumidificaTionFModeH1();
		/**
		 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br><br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification: air circulator<br><br>Name : Rated power consumption of indoor unit<br>EPC : 0xB8<br>Data Type : unsigned short x 4<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfIndoorUnit();
		/**
		 * This property indicates the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption of indoor unit<br>EPC : 0xB9<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredElectricCurrentConsumptionOfIndoorUnit();
		/**
		 * Used to acquire the measured indoor relative humidity.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Measured indoor relative humidity 1<br>EPC : 0xBA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredIndoorRelativeHumidity1();
		/**
		 * Used to acquire the measured indoor temperature.<br><br>0x81 to 0x7D (-127 to 125��C)<br><br>Name : Measured indoor temperature 1<br>EPC : 0xBB<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredIndoorTemperature1();
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br><br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Name : Relative temperature setting<br>EPC : 0xBF<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRelativeTemperatureSetting();
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br><br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Name : Air flow rate setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAirFlowRateSetting();
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Name : �gAir flow direction (vertical)�h setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGairFlowDirectionVerticalHSetting();
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br><br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Name : �gAir flow direction (horizontal)�h setting<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGairFlowDirectionHorizontalHSetting();
		/**
		 * This property indicates when the air conditioner is in a �gspecial�h state.<br><br>�gNormal operation�h state = 0x40, �gpreheating�h state = 0x42, �gheat removal�h state = 0x43<br><br>Name : �gSpecial�h state<br>EPC : 0xAA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformGspecialHState();
		/**
		 * This property indicates the state (ON or OFF) of the thermostat.<br><br>Thermostat ON = 0x41 Thermostat OFF = 0x42<br><br>Name : Thermostat state<br>EPC : 0xAC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformThermostatState();
		/**
		 * This property indicates, when the air conditioner is operating in the �gautomatic�h operation mode, the function (�gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h) that is currently being used.<br><br>The following values shall be used: Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Name : Current function (�gautomatic�h operation mode)<br>EPC : 0xAE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformCurrentFunctionGautomaticHOperationMode();
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br><br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Name : Ventilation mode setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformVentilationModeSetting();
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br><br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Name : Combined operation of indoor unit and total heat exchanger<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformCombinedOperationOfIndoorUnitAndTotalHeatExchanger();
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Name : Ventilation air flow rate setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformVentilationAirFlowRateSetting();
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br><br>Disabled = 0x41, not disabled = 0x42<br><br>Name : �gDisabling of air conditioner�h setting<br>EPC : 0xCD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGdisablingOfAirConditionerHSetting();
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br><br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Name : Thermostat setting override function<br>EPC : 0xCE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformThermostatSettingOverrideFunction();
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br><br>Enabled = 0x41, disabled = 0x42<br><br>Name : Filter cleaning reminder lamp setting<br>EPC : 0xCF<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformFilterCleaningReminderLampSetting();
		/**
		 * This property indicates the measured power consumption of the indoor unit.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Measured power consumption of indoor unit<br>EPC : 0xDB<br>Data Type : unsigned<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredPowerConsumptionOfIndoorUnit();
		/**
		 * This property indicates the aperture of the expansion valve in %.<br><br>0 to 0x64 (0 to 100%)<br><br>Name : Aperture of expansion valve<br>EPC : 0xDC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformApertureOfExpansionValve();
		/**
		 * Used to set the temperature and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : Temperature setting 2<br>EPC : 0xE3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Informer reqInformTemperatureSetting2();
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : �gRelative humidity setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformGrelativeHumiditySettingForEdehumidificatioNFModeH2();
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �ecooling�f mode�h 2<br>EPC : 0xE5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGtemperatureSettingForEcoolingFModeH2();
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �eheating�f mode�h 2<br>EPC : 0xE6<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGtemperatureSettingForEheatingFModeH2();
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br><br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Name : �gTemperature setting for �edehumidificatio n�f mode�h 2<br>EPC : 0xE7<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGtemperatureSettingForEdehumidificatioNFModeH2();
		/**
		 * Used to acquire the measured indoor relative humidity.<br><br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Name : Measured indoor relative humidity 2<br>EPC : 0xEA<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredIndoorRelativeHumidity2();
		/**
		 * Used to acquire the measured indoor temperature.<br><br>0xF554 to 0x7FFD (-273,2 to 3276,5��C)<br><br>Name : Measured indoor temperature 2<br>EPC : 0xEB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredIndoorTemperature2();
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gON timer-based reservation�h setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGonTimerBasedReservationHSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting (time)<br>EPC : 0x91<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : ON timer setting (relative time)<br>EPC : 0x92<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br><br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Name : �gOFF timer-based reservation�h setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGoffTimerBasedReservationHSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : OFF timer setting (time)<br>EPC : 0x95<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOffTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : OFF timer setting (relative time)<br>EPC : 0x96<br>Data Type : unsigned char�~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		public Informer reqInformTemperatureSetting1() {
			byte epc = EPC_TEMPERATURE_SETTING1;
			byte[] edt = _getTemperatureSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGrelativeHumiditySettingForEdehumidificaTionFModeH1() {
			byte epc = EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1;
			byte[] edt = _getGrelativeHumiditySettingForEdehumidificaTionFModeH1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEcoolingFModeH1() {
			byte epc = EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1;
			byte[] edt = _getGtemperatureSettingForEcoolingFModeH1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEheatingFModeH1() {
			byte epc = EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1;
			byte[] edt = _getGtemperatureSettingForEheatingFModeH1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEdehumidificaTionFModeH1() {
			byte epc = EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1;
			byte[] edt = _getGtemperatureSettingForEdehumidificaTionFModeH1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfIndoorUnit() {
			byte epc = EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT;
			byte[] edt = _getRatedPowerConsumptionOfIndoorUnit(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredElectricCurrentConsumptionOfIndoorUnit() {
			byte epc = EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT;
			byte[] edt = _getMeasuredElectricCurrentConsumptionOfIndoorUnit(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorRelativeHumidity1() {
			byte epc = EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1;
			byte[] edt = _getMeasuredIndoorRelativeHumidity1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorTemperature1() {
			byte epc = EPC_MEASURED_INDOOR_TEMPERATURE1;
			byte[] edt = _getMeasuredIndoorTemperature1(epc);
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
		public Informer reqInformGairFlowDirectionVerticalHSetting() {
			byte epc = EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING;
			byte[] edt = _getGairFlowDirectionVerticalHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGairFlowDirectionHorizontalHSetting() {
			byte epc = EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING;
			byte[] edt = _getGairFlowDirectionHorizontalHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGspecialHState() {
			byte epc = EPC_GSPECIAL_H_STATE;
			byte[] edt = _getGspecialHState(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformThermostatState() {
			byte epc = EPC_THERMOSTAT_STATE;
			byte[] edt = _getThermostatState(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCurrentFunctionGautomaticHOperationMode() {
			byte epc = EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE;
			byte[] edt = _getCurrentFunctionGautomaticHOperationMode(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationModeSetting() {
			byte epc = EPC_VENTILATION_MODE_SETTING;
			byte[] edt = _getVentilationModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {
			byte epc = EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER;
			byte[] edt = _getCombinedOperationOfIndoorUnitAndTotalHeatExchanger(epc);
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
		public Informer reqInformGdisablingOfAirConditionerHSetting() {
			byte epc = EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING;
			byte[] edt = _getGdisablingOfAirConditionerHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformThermostatSettingOverrideFunction() {
			byte epc = EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION;
			byte[] edt = _getThermostatSettingOverrideFunction(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFilterCleaningReminderLampSetting() {
			byte epc = EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING;
			byte[] edt = _getFilterCleaningReminderLampSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredPowerConsumptionOfIndoorUnit() {
			byte epc = EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT;
			byte[] edt = _getMeasuredPowerConsumptionOfIndoorUnit(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformApertureOfExpansionValve() {
			byte epc = EPC_APERTURE_OF_EXPANSION_VALVE;
			byte[] edt = _getApertureOfExpansionValve(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting2() {
			byte epc = EPC_TEMPERATURE_SETTING2;
			byte[] edt = _getTemperatureSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGrelativeHumiditySettingForEdehumidificatioNFModeH2() {
			byte epc = EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2;
			byte[] edt = _getGrelativeHumiditySettingForEdehumidificatioNFModeH2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEcoolingFModeH2() {
			byte epc = EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2;
			byte[] edt = _getGtemperatureSettingForEcoolingFModeH2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEheatingFModeH2() {
			byte epc = EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2;
			byte[] edt = _getGtemperatureSettingForEheatingFModeH2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEdehumidificatioNFModeH2() {
			byte epc = EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2;
			byte[] edt = _getGtemperatureSettingForEdehumidificatioNFModeH2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorRelativeHumidity2() {
			byte epc = EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2;
			byte[] edt = _getMeasuredIndoorRelativeHumidity2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorTemperature2() {
			byte epc = EPC_MEASURED_INDOOR_TEMPERATURE2;
			byte[] edt = _getMeasuredIndoorTemperature2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGonTimerBasedReservationHSetting() {
			byte epc = EPC_GON_TIMER_BASED_RESERVATION_H_SETTING;
			byte[] edt = _getGonTimerBasedReservationHSetting(epc);
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
		public Informer reqInformGoffTimerBasedReservationHSetting() {
			byte epc = EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING;
			byte[] edt = _getGoffTimerBasedReservationHSetting(epc);
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
		public Informer reqInformTemperatureSetting1() {
			addProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformGrelativeHumiditySettingForEdehumidificaTionFModeH1() {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1);
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEcoolingFModeH1() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1);
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEheatingFModeH1() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1);
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEdehumidificaTionFModeH1() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfIndoorUnit() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		@Override
		public Informer reqInformMeasuredElectricCurrentConsumptionOfIndoorUnit() {
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorRelativeHumidity1() {
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1);
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorTemperature1() {
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE1);
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
		public Informer reqInformGairFlowDirectionVerticalHSetting() {
			addProperty(EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGairFlowDirectionHorizontalHSetting() {
			addProperty(EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGspecialHState() {
			addProperty(EPC_GSPECIAL_H_STATE);
			return this;
		}
		@Override
		public Informer reqInformThermostatState() {
			addProperty(EPC_THERMOSTAT_STATE);
			return this;
		}
		@Override
		public Informer reqInformCurrentFunctionGautomaticHOperationMode() {
			addProperty(EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE);
			return this;
		}
		@Override
		public Informer reqInformVentilationModeSetting() {
			addProperty(EPC_VENTILATION_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {
			addProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER);
			return this;
		}
		@Override
		public Informer reqInformVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGdisablingOfAirConditionerHSetting() {
			addProperty(EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformThermostatSettingOverrideFunction() {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION);
			return this;
		}
		@Override
		public Informer reqInformFilterCleaningReminderLampSetting() {
			addProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredPowerConsumptionOfIndoorUnit() {
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		@Override
		public Informer reqInformApertureOfExpansionValve() {
			addProperty(EPC_APERTURE_OF_EXPANSION_VALVE);
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting2() {
			addProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformGrelativeHumiditySettingForEdehumidificatioNFModeH2() {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2);
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEcoolingFModeH2() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2);
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEheatingFModeH2() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2);
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEdehumidificatioNFModeH2() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2);
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorRelativeHumidity2() {
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2);
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorTemperature2() {
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE2);
			return this;
		}
		@Override
		public Informer reqInformGonTimerBasedReservationHSetting() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING);
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
		public Informer reqInformGoffTimerBasedReservationHSetting() {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING);
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
