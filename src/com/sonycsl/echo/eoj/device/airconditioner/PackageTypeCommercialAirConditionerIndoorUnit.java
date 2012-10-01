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
	@SuppressWarnings("unused")
	private static final String TAG = PackageTypeCommercialAirConditionerIndoorUnit.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x45;

	protected static final byte EPC_OPERATION_MODE_SETTING = (byte)0xB0;
	protected static final byte EPC_TEMPERATURE_SETTING1 = (byte)0xB3;
	protected static final byte EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1 = (byte)0xB4;
	protected static final byte EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1 = (byte)0xB5;
	protected static final byte EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1 = (byte)0xB6;
	protected static final byte EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1 = (byte)0xB7;
	protected static final byte EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT = (byte)0xB8;
	protected static final byte EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT = (byte)0xB9;
	protected static final byte EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1 = (byte)0xBA;
	protected static final byte EPC_MEASURED_INDOOR_TEMPERATURE1 = (byte)0xBB;
	protected static final byte EPC_RELATIVE_TEMPERATURE_SETTING = (byte)0xBF;
	protected static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	protected static final byte EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING = (byte)0xA4;
	protected static final byte EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING = (byte)0xA5;
	protected static final byte EPC_GSPECIAL_H_STATE = (byte)0xAA;
	protected static final byte EPC_THERMOSTAT_STATE = (byte)0xAC;
	protected static final byte EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE = (byte)0xAE;
	protected static final byte EPC_VENTILATION_MODE_SETTING = (byte)0xC0;
	protected static final byte EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER = (byte)0xC1;
	protected static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	protected static final byte EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING = (byte)0xCD;
	protected static final byte EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION = (byte)0xCE;
	protected static final byte EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING = (byte)0xCF;
	protected static final byte EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT = (byte)0xDB;
	protected static final byte EPC_APERTURE_OF_EXPANSION_VALVE = (byte)0xDC;
	protected static final byte EPC_TEMPERATURE_SETTING2 = (byte)0xE3;
	protected static final byte EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2 = (byte)0xE4;
	protected static final byte EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2 = (byte)0xE5;
	protected static final byte EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2 = (byte)0xE6;
	protected static final byte EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2 = (byte)0xE7;
	protected static final byte EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2 = (byte)0xEA;
	protected static final byte EPC_MEASURED_INDOOR_TEMPERATURE2 = (byte)0xEB;
	protected static final byte EPC_GON_TIMER_BASED_RESERVATION_H_SETTING = (byte)0x90;
	protected static final byte EPC_ON_TIMER_SETTING_TIME = (byte)0x91;
	protected static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME = (byte)0x92;
	protected static final byte EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING = (byte)0x94;
	protected static final byte EPC_OFF_TIMER_SETTING_TIME = (byte)0x95;
	protected static final byte EPC_OFF_TIMER_SETTING_RELATIVE_TIME = (byte)0x96;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract boolean setOperationModeSetting(byte[] edt);
	/**
	 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract byte[] getOperationModeSetting();
	/**
	 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract boolean setTemperatureSetting1(byte[] edt);
	/**
	 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract byte[] getTemperatureSetting1();
	/**
	 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
	 */
	protected boolean setGrelativeHumiditySettingForEdehumidificaTionFModeH1(byte[] edt) {return false;}
	/**
	 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getGrelativeHumiditySettingForEdehumidificaTionFModeH1() {return null;}
	/**
	 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGtemperatureSettingForEcoolingFModeH1(byte[] edt) {return false;}
	/**
	 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGtemperatureSettingForEcoolingFModeH1() {return null;}
	/**
	 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGtemperatureSettingForEheatingFModeH1(byte[] edt) {return false;}
	/**
	 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGtemperatureSettingForEheatingFModeH1() {return null;}
	/**
	 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGtemperatureSettingForEdehumidificaTionFModeH1(byte[] edt) {return false;}
	/**
	 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGtemperatureSettingForEdehumidificaTionFModeH1() {return null;}
	/**
	 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification: air circulator<br><br>Data type : unsigned short x 4<br>Data size : 8 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedPowerConsumptionOfIndoorUnit() {return null;}
	/**
	 * This property indicates the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredElectricCurrentConsumptionOfIndoorUnit() {return null;}
	/**
	 * Used to acquire the measured indoor relative humidity.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredIndoorRelativeHumidity1() {return null;}
	/**
	 * Used to acquire the measured indoor temperature.<br>0x81 to 0x7D (-127 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredIndoorTemperature1() {return null;}
	/**
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeTemperatureSetting() {return null;}
	/**
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAirFlowRateSetting() {return null;}
	/**
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGairFlowDirectionVerticalHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGairFlowDirectionVerticalHSetting() {return null;}
	/**
	 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGairFlowDirectionHorizontalHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGairFlowDirectionHorizontalHSetting() {return null;}
	/**
	 * This property indicates when the air conditioner is in a �gspecial�h state.<br>�gNormal operation�h state = 0x40, �gpreheating�h state = 0x42, �gheat removal�h state = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getGspecialHState() {return null;}
	/**
	 * This property indicates the state (ON or OFF) of the thermostat.<br>Thermostat ON = 0x41 Thermostat OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getThermostatState() {return null;}
	/**
	 * This property indicates, when the air conditioner is operating in the �gautomatic�h operation mode, the function (�gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h) that is currently being used.<br>The following values shall be used: Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getCurrentFunctionGautomaticHOperationMode() {return null;}
	/**
	 * Used to specify the ventilation mode and to acquire the current setting.<br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setVentilationModeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the ventilation mode and to acquire the current setting.<br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVentilationModeSetting() {return null;}
	/**
	 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {return null;}
	/**
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	/**
	 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>Disabled = 0x41, not disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGdisablingOfAirConditionerHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>Disabled = 0x41, not disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGdisablingOfAirConditionerHSetting() {return null;}
	/**
	 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setThermostatSettingOverrideFunction(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getThermostatSettingOverrideFunction() {return null;}
	/**
	 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>Enabled = 0x41, disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
	 */
	protected boolean setFilterCleaningReminderLampSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>Enabled = 0x41, disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getFilterCleaningReminderLampSetting() {return null;}
	/**
	 * This property indicates the measured power consumption of the indoor unit.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : unsigned<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredPowerConsumptionOfIndoorUnit() {return null;}
	/**
	 * This property indicates the aperture of the expansion valve in %.<br>0 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getApertureOfExpansionValve() {return null;}
	/**
	 * Used to set the temperature and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract boolean setTemperatureSetting2(byte[] edt);
	/**
	 * Used to set the temperature and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract byte[] getTemperatureSetting2();
	/**
	 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
	 */
	protected boolean setGrelativeHumiditySettingForEdehumidificatioNFModeH2(byte[] edt) {return false;}
	/**
	 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getGrelativeHumiditySettingForEdehumidificatioNFModeH2() {return null;}
	/**
	 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGtemperatureSettingForEcoolingFModeH2(byte[] edt) {return false;}
	/**
	 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGtemperatureSettingForEcoolingFModeH2() {return null;}
	/**
	 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGtemperatureSettingForEheatingFModeH2(byte[] edt) {return false;}
	/**
	 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGtemperatureSettingForEheatingFModeH2() {return null;}
	/**
	 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGtemperatureSettingForEdehumidificatioNFModeH2(byte[] edt) {return false;}
	/**
	 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGtemperatureSettingForEdehumidificatioNFModeH2() {return null;}
	/**
	 * Used to acquire the measured indoor relative humidity.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredIndoorRelativeHumidity2() {return null;}
	/**
	 * Used to acquire the measured indoor temperature.<br>0xF554 to 0x7FFD (-273,2 to 3276,5��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredIndoorTemperature2() {return null;}
	/**
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGonTimerBasedReservationHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGonTimerBasedReservationHSetting() {return null;}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	/**
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGoffTimerBasedReservationHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGoffTimerBasedReservationHSetting() {return null;}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerSettingRelativeTime() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, setOperationModeSetting(edt));
			break;
		case EPC_TEMPERATURE_SETTING1:
			res.addProperty(epc, edt, setTemperatureSetting1(edt));
			break;
		case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
			res.addProperty(epc, edt, setGrelativeHumiditySettingForEdehumidificaTionFModeH1(edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1:
			res.addProperty(epc, edt, setGtemperatureSettingForEcoolingFModeH1(edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1:
			res.addProperty(epc, edt, setGtemperatureSettingForEheatingFModeH1(edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
			res.addProperty(epc, edt, setGtemperatureSettingForEdehumidificaTionFModeH1(edt));
			break;
		case EPC_RELATIVE_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setRelativeTemperatureSetting(edt));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, setAirFlowRateSetting(edt));
			break;
		case EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING:
			res.addProperty(epc, edt, setGairFlowDirectionVerticalHSetting(edt));
			break;
		case EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING:
			res.addProperty(epc, edt, setGairFlowDirectionHorizontalHSetting(edt));
			break;
		case EPC_VENTILATION_MODE_SETTING:
			res.addProperty(epc, edt, setVentilationModeSetting(edt));
			break;
		case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER:
			res.addProperty(epc, edt, setCombinedOperationOfIndoorUnitAndTotalHeatExchanger(edt));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, setVentilationAirFlowRateSetting(edt));
			break;
		case EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING:
			res.addProperty(epc, edt, setGdisablingOfAirConditionerHSetting(edt));
			break;
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
			res.addProperty(epc, edt, setThermostatSettingOverrideFunction(edt));
			break;
		case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING:
			res.addProperty(epc, edt, setFilterCleaningReminderLampSetting(edt));
			break;
		case EPC_TEMPERATURE_SETTING2:
			res.addProperty(epc, edt, setTemperatureSetting2(edt));
			break;
		case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
			res.addProperty(epc, edt, setGrelativeHumiditySettingForEdehumidificatioNFModeH2(edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2:
			res.addProperty(epc, edt, setGtemperatureSettingForEcoolingFModeH2(edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2:
			res.addProperty(epc, edt, setGtemperatureSettingForEheatingFModeH2(edt));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
			res.addProperty(epc, edt, setGtemperatureSettingForEdehumidificatioNFModeH2(edt));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING:
			res.addProperty(epc, edt, setGonTimerBasedReservationHSetting(edt));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, setOnTimerSettingTime(edt));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, setOnTimerSettingRelativeTime(edt));
			break;
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
			res.addProperty(epc, edt, setGoffTimerBasedReservationHSetting(edt));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, setOffTimerSettingTime(edt));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, setOffTimerSettingRelativeTime(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			edt = getOperationModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPERATURE_SETTING1:
			edt = getTemperatureSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
			edt = getGrelativeHumiditySettingForEdehumidificaTionFModeH1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1:
			edt = getGtemperatureSettingForEcoolingFModeH1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1:
			edt = getGtemperatureSettingForEheatingFModeH1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
			edt = getGtemperatureSettingForEdehumidificaTionFModeH1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT:
			edt = getRatedPowerConsumptionOfIndoorUnit();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT:
			edt = getMeasuredElectricCurrentConsumptionOfIndoorUnit();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1:
			edt = getMeasuredIndoorRelativeHumidity1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_INDOOR_TEMPERATURE1:
			edt = getMeasuredIndoorTemperature1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RELATIVE_TEMPERATURE_SETTING:
			edt = getRelativeTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			edt = getAirFlowRateSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING:
			edt = getGairFlowDirectionVerticalHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING:
			edt = getGairFlowDirectionHorizontalHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GSPECIAL_H_STATE:
			edt = getGspecialHState();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_THERMOSTAT_STATE:
			edt = getThermostatState();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE:
			edt = getCurrentFunctionGautomaticHOperationMode();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_MODE_SETTING:
			edt = getVentilationModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER:
			edt = getCombinedOperationOfIndoorUnitAndTotalHeatExchanger();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			edt = getVentilationAirFlowRateSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING:
			edt = getGdisablingOfAirConditionerHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
			edt = getThermostatSettingOverrideFunction();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING:
			edt = getFilterCleaningReminderLampSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT:
			edt = getMeasuredPowerConsumptionOfIndoorUnit();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_APERTURE_OF_EXPANSION_VALVE:
			edt = getApertureOfExpansionValve();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPERATURE_SETTING2:
			edt = getTemperatureSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
			edt = getGrelativeHumiditySettingForEdehumidificatioNFModeH2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2:
			edt = getGtemperatureSettingForEcoolingFModeH2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2:
			edt = getGtemperatureSettingForEheatingFModeH2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
			edt = getGtemperatureSettingForEdehumidificatioNFModeH2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2:
			edt = getMeasuredIndoorRelativeHumidity2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INDOOR_TEMPERATURE2:
			edt = getMeasuredIndoorTemperature2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING:
			edt = getGonTimerBasedReservationHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			edt = getOnTimerSettingTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			edt = getOnTimerSettingRelativeTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
			edt = getGoffTimerBasedReservationHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			edt = getOffTimerSettingTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			edt = getOffTimerSettingRelativeTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;

		}
	}
	
	@Override
	public Setter set() {
		return new SetterImpl(ESV_SET_NO_RES);
	}

	@Override
	public Setter setC() {
		return new SetterImpl(ESV_SET_RES);
	}

	@Override
	public Getter get() {
		return new GetterImpl();
	}

	@Override
	public Informer inform() {
		return new InformerImpl();
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_MODE_SETTING:
				onSetOperationModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPERATURE_SETTING1:
				onSetTemperatureSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
				onSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(eoj, tid, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1:
				onSetGtemperatureSettingForEcoolingFModeH1(eoj, tid, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1:
				onSetGtemperatureSettingForEheatingFModeH1(eoj, tid, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
				onSetGtemperatureSettingForEdehumidificaTionFModeH1(eoj, tid, (pdc != 0));
				break;
			case EPC_RELATIVE_TEMPERATURE_SETTING:
				onSetRelativeTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				onSetAirFlowRateSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING:
				onSetGairFlowDirectionVerticalHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING:
				onSetGairFlowDirectionHorizontalHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_VENTILATION_MODE_SETTING:
				onSetVentilationModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER:
				onSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(eoj, tid, (pdc != 0));
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				onSetVentilationAirFlowRateSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING:
				onSetGdisablingOfAirConditionerHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
				onSetThermostatSettingOverrideFunction(eoj, tid, (pdc != 0));
				break;
			case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING:
				onSetFilterCleaningReminderLampSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPERATURE_SETTING2:
				onSetTemperatureSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
				onSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(eoj, tid, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2:
				onSetGtemperatureSettingForEcoolingFModeH2(eoj, tid, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2:
				onSetGtemperatureSettingForEheatingFModeH2(eoj, tid, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
				onSetGtemperatureSettingForEdehumidificatioNFModeH2(eoj, tid, (pdc != 0));
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING:
				onSetGonTimerBasedReservationHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				onSetOnTimerSettingTime(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				onSetOnTimerSettingRelativeTime(eoj, tid, (pdc != 0));
				break;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
				onSetGoffTimerBasedReservationHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				onSetOffTimerSettingTime(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				onSetOffTimerSettingRelativeTime(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_MODE_SETTING:
				onGetOperationModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPERATURE_SETTING1:
				onGetTemperatureSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
				onGetGrelativeHumiditySettingForEdehumidificaTionFModeH1(eoj, tid, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1:
				onGetGtemperatureSettingForEcoolingFModeH1(eoj, tid, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1:
				onGetGtemperatureSettingForEheatingFModeH1(eoj, tid, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1:
				onGetGtemperatureSettingForEdehumidificaTionFModeH1(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT:
				onGetRatedPowerConsumptionOfIndoorUnit(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT:
				onGetMeasuredElectricCurrentConsumptionOfIndoorUnit(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1:
				onGetMeasuredIndoorRelativeHumidity1(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INDOOR_TEMPERATURE1:
				onGetMeasuredIndoorTemperature1(eoj, tid, pdc, edt);
				break;
			case EPC_RELATIVE_TEMPERATURE_SETTING:
				onGetRelativeTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				onGetAirFlowRateSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING:
				onGetGairFlowDirectionVerticalHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING:
				onGetGairFlowDirectionHorizontalHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GSPECIAL_H_STATE:
				onGetGspecialHState(eoj, tid, pdc, edt);
				break;
			case EPC_THERMOSTAT_STATE:
				onGetThermostatState(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE:
				onGetCurrentFunctionGautomaticHOperationMode(eoj, tid, pdc, edt);
				break;
			case EPC_VENTILATION_MODE_SETTING:
				onGetVentilationModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER:
				onGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(eoj, tid, pdc, edt);
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				onGetVentilationAirFlowRateSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING:
				onGetGdisablingOfAirConditionerHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION:
				onGetThermostatSettingOverrideFunction(eoj, tid, pdc, edt);
				break;
			case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING:
				onGetFilterCleaningReminderLampSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT:
				onGetMeasuredPowerConsumptionOfIndoorUnit(eoj, tid, pdc, edt);
				break;
			case EPC_APERTURE_OF_EXPANSION_VALVE:
				onGetApertureOfExpansionValve(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPERATURE_SETTING2:
				onGetTemperatureSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
				onGetGrelativeHumiditySettingForEdehumidificatioNFModeH2(eoj, tid, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2:
				onGetGtemperatureSettingForEcoolingFModeH2(eoj, tid, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2:
				onGetGtemperatureSettingForEheatingFModeH2(eoj, tid, pdc, edt);
				break;
			case EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2:
				onGetGtemperatureSettingForEdehumidificatioNFModeH2(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2:
				onGetMeasuredIndoorRelativeHumidity2(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INDOOR_TEMPERATURE2:
				onGetMeasuredIndoorTemperature2(eoj, tid, pdc, edt);
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING:
				onGetGonTimerBasedReservationHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				onGetOnTimerSettingTime(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				onGetOnTimerSettingRelativeTime(eoj, tid, pdc, edt);
				break;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
				onGetGoffTimerBasedReservationHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				onGetOffTimerSettingTime(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				onGetOffTimerSettingRelativeTime(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onSetTemperatureSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onGetTemperatureSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		protected void onSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetGrelativeHumiditySettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGtemperatureSettingForEcoolingFModeH1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGtemperatureSettingForEcoolingFModeH1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGtemperatureSettingForEheatingFModeH1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGtemperatureSettingForEheatingFModeH1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGtemperatureSettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGtemperatureSettingForEdehumidificaTionFModeH1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification: air circulator<br><br>Data type : unsigned short x 4<br>Data size : 8 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedPowerConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredElectricCurrentConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured indoor relative humidity.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredIndoorRelativeHumidity1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured indoor temperature.<br>0x81 to 0x7D (-127 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredIndoorTemperature1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRelativeTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGairFlowDirectionVerticalHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGairFlowDirectionVerticalHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGairFlowDirectionHorizontalHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGairFlowDirectionHorizontalHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates when the air conditioner is in a �gspecial�h state.<br>�gNormal operation�h state = 0x40, �gpreheating�h state = 0x42, �gheat removal�h state = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetGspecialHState(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the state (ON or OFF) of the thermostat.<br>Thermostat ON = 0x41 Thermostat OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetThermostatState(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates, when the air conditioner is operating in the �gautomatic�h operation mode, the function (�gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h) that is currently being used.<br>The following values shall be used: Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetCurrentFunctionGautomaticHOperationMode(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetVentilationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetVentilationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>Disabled = 0x41, not disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGdisablingOfAirConditionerHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>Disabled = 0x41, not disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGdisablingOfAirConditionerHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetThermostatSettingOverrideFunction(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>Enabled = 0x41, disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		protected void onSetFilterCleaningReminderLampSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>Enabled = 0x41, disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetFilterCleaningReminderLampSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured power consumption of the indoor unit.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : unsigned<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredPowerConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the aperture of the expansion valve in %.<br>0 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetApertureOfExpansionValve(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onSetTemperatureSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onGetTemperatureSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		protected void onSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetGrelativeHumiditySettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGtemperatureSettingForEcoolingFModeH2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGtemperatureSettingForEcoolingFModeH2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGtemperatureSettingForEheatingFModeH2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGtemperatureSettingForEheatingFModeH2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGtemperatureSettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGtemperatureSettingForEdehumidificatioNFModeH2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured indoor relative humidity.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredIndoorRelativeHumidity2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured indoor temperature.<br>0xF554 to 0x7FFD (-273,2 to 3276,5��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredIndoorTemperature2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGonTimerBasedReservationHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGonTimerBasedReservationHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

	}
	
	public interface Setter extends DeviceObject.Setter {
		public Setter reqSetOperationStatus(byte[] edt);
		public Setter reqSetInstallationLocation(byte[] edt);
		public Setter reqSetCurrentLimitSetting(byte[] edt);
		public Setter reqSetPowerSavingOperationSetting(byte[] edt);
		public Setter reqSetPositionInformation(byte[] edt);
		public Setter reqSetCurrentTimeSetting(byte[] edt);
		public Setter reqSetCurrentDateSetting(byte[] edt);
		public Setter reqSetPowerLimitSetting(byte[] edt);
		
		/**
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Setter reqSetOperationModeSetting(byte[] edt);
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Setter reqSetTemperatureSetting1(byte[] edt);
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Setter reqSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(byte[] edt);
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGtemperatureSettingForEcoolingFModeH1(byte[] edt);
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGtemperatureSettingForEheatingFModeH1(byte[] edt);
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGtemperatureSettingForEdehumidificaTionFModeH1(byte[] edt);
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRelativeTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetAirFlowRateSetting(byte[] edt);
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGairFlowDirectionVerticalHSetting(byte[] edt);
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGairFlowDirectionHorizontalHSetting(byte[] edt);
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetVentilationModeSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte[] edt);
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt);
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>Disabled = 0x41, not disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGdisablingOfAirConditionerHSetting(byte[] edt);
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt);
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>Enabled = 0x41, disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Setter reqSetFilterCleaningReminderLampSetting(byte[] edt);
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Setter reqSetTemperatureSetting2(byte[] edt);
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Setter reqSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(byte[] edt);
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGtemperatureSettingForEcoolingFModeH2(byte[] edt);
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGtemperatureSettingForEheatingFModeH2(byte[] edt);
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGtemperatureSettingForEdehumidificatioNFModeH2(byte[] edt);
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGonTimerBasedReservationHSetting(byte[] edt);
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt);
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt);
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt);
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt);
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt);
	}

	public class SetterImpl extends DeviceObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
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

		@Override
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, setOperationModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting1(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING1, edt, setTemperatureSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(byte[] edt) {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, setGrelativeHumiditySettingForEdehumidificaTionFModeH1(edt));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEcoolingFModeH1(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1, edt, setGtemperatureSettingForEcoolingFModeH1(edt));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEheatingFModeH1(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1, edt, setGtemperatureSettingForEheatingFModeH1(edt));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEdehumidificaTionFModeH1(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, setGtemperatureSettingForEdehumidificaTionFModeH1(edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeTemperatureSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, setRelativeTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, setAirFlowRateSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGairFlowDirectionVerticalHSetting(byte[] edt) {
			addProperty(EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING, edt, setGairFlowDirectionVerticalHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGairFlowDirectionHorizontalHSetting(byte[] edt) {
			addProperty(EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING, edt, setGairFlowDirectionHorizontalHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetVentilationModeSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_MODE_SETTING, edt, setVentilationModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte[] edt) {
			addProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER, edt, setCombinedOperationOfIndoorUnitAndTotalHeatExchanger(edt));
			return this;
		}
		@Override
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, setVentilationAirFlowRateSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGdisablingOfAirConditionerHSetting(byte[] edt) {
			addProperty(EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING, edt, setGdisablingOfAirConditionerHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt) {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt, setThermostatSettingOverrideFunction(edt));
			return this;
		}
		@Override
		public Setter reqSetFilterCleaningReminderLampSetting(byte[] edt) {
			addProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING, edt, setFilterCleaningReminderLampSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting2(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING2, edt, setTemperatureSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(byte[] edt) {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, setGrelativeHumiditySettingForEdehumidificatioNFModeH2(edt));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEcoolingFModeH2(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2, edt, setGtemperatureSettingForEcoolingFModeH2(edt));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEheatingFModeH2(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2, edt, setGtemperatureSettingForEheatingFModeH2(edt));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEdehumidificatioNFModeH2(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, setGtemperatureSettingForEdehumidificatioNFModeH2(edt));
			return this;
		}
		@Override
		public Setter reqSetGonTimerBasedReservationHSetting(byte[] edt) {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING, edt, setGonTimerBasedReservationHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, setOnTimerSettingTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, setOnTimerSettingRelativeTime(edt));
			return this;
		}
		@Override
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt) {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt, setGoffTimerBasedReservationHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, setOffTimerSettingTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, setOffTimerSettingRelativeTime(edt));
			return this;
		}
	}
	
	public class SetterProxy extends DeviceObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
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

		@Override
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting1(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGrelativeHumiditySettingForEdehumidificaTionFModeH1(byte[] edt) {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEcoolingFModeH1(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEheatingFModeH1(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEdehumidificaTionFModeH1(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRelativeTemperatureSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGairFlowDirectionVerticalHSetting(byte[] edt) {
			addProperty(EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGairFlowDirectionHorizontalHSetting(byte[] edt) {
			addProperty(EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVentilationModeSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte[] edt) {
			addProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGdisablingOfAirConditionerHSetting(byte[] edt) {
			addProperty(EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt) {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetFilterCleaningReminderLampSetting(byte[] edt) {
			addProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting2(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetGrelativeHumiditySettingForEdehumidificatioNFModeH2(byte[] edt) {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEcoolingFModeH2(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEheatingFModeH2(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureSettingForEdehumidificatioNFModeH2(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetGonTimerBasedReservationHSetting(byte[] edt) {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt) {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
	}

	public interface Getter extends DeviceObject.Getter {
		public Getter reqGetOperationStatus();
		public Getter reqGetInstallationLocation();
		public Getter reqGetStandardVersionInformation();
		public Getter reqGetIdentificationNumber();
		public Getter reqGetMeasuredInstantaneousPowerConsumption();
		public Getter reqGetMeasuredCumulativePowerConsumption();
		public Getter reqGetManufacturersFaultCode();
		public Getter reqGetCurrentLimitSetting();
		public Getter reqGetFaultStatus();
		public Getter reqGetFaultDescription();
		public Getter reqGetManufacturerCode();
		public Getter reqGetBusinessFacilityCode();
		public Getter reqGetProductCode();
		public Getter reqGetProductionNumber();
		public Getter reqGetProductionDate();
		public Getter reqGetPowerSavingOperationSetting();
		public Getter reqGetPositionInformation();
		public Getter reqGetCurrentTimeSetting();
		public Getter reqGetCurrentDateSetting();
		public Getter reqGetPowerLimitSetting();
		public Getter reqGetCumulativeOperatingTime();
		public Getter reqGetStatusChangeAnnouncementPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		/**
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Getter reqGetOperationModeSetting();
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Getter reqGetTemperatureSetting1();
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetGrelativeHumiditySettingForEdehumidificaTionFModeH1();
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGtemperatureSettingForEcoolingFModeH1();
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGtemperatureSettingForEheatingFModeH1();
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGtemperatureSettingForEdehumidificaTionFModeH1();
		/**
		 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification: air circulator<br><br>Data type : unsigned short x 4<br>Data size : 8 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRatedPowerConsumptionOfIndoorUnit();
		/**
		 * This property indicates the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredElectricCurrentConsumptionOfIndoorUnit();
		/**
		 * Used to acquire the measured indoor relative humidity.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredIndoorRelativeHumidity1();
		/**
		 * Used to acquire the measured indoor temperature.<br>0x81 to 0x7D (-127 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredIndoorTemperature1();
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRelativeTemperatureSetting();
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetAirFlowRateSetting();
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGairFlowDirectionVerticalHSetting();
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGairFlowDirectionHorizontalHSetting();
		/**
		 * This property indicates when the air conditioner is in a �gspecial�h state.<br>�gNormal operation�h state = 0x40, �gpreheating�h state = 0x42, �gheat removal�h state = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetGspecialHState();
		/**
		 * This property indicates the state (ON or OFF) of the thermostat.<br>Thermostat ON = 0x41 Thermostat OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetThermostatState();
		/**
		 * This property indicates, when the air conditioner is operating in the �gautomatic�h operation mode, the function (�gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h) that is currently being used.<br>The following values shall be used: Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetCurrentFunctionGautomaticHOperationMode();
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetVentilationModeSetting();
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger();
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetVentilationAirFlowRateSetting();
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>Disabled = 0x41, not disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGdisablingOfAirConditionerHSetting();
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetThermostatSettingOverrideFunction();
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>Enabled = 0x41, disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetFilterCleaningReminderLampSetting();
		/**
		 * This property indicates the measured power consumption of the indoor unit.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : unsigned<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredPowerConsumptionOfIndoorUnit();
		/**
		 * This property indicates the aperture of the expansion valve in %.<br>0 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetApertureOfExpansionValve();
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Getter reqGetTemperatureSetting2();
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetGrelativeHumiditySettingForEdehumidificatioNFModeH2();
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGtemperatureSettingForEcoolingFModeH2();
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGtemperatureSettingForEheatingFModeH2();
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGtemperatureSettingForEdehumidificatioNFModeH2();
		/**
		 * Used to acquire the measured indoor relative humidity.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredIndoorRelativeHumidity2();
		/**
		 * Used to acquire the measured indoor temperature.<br>0xF554 to 0x7FFD (-273,2 to 3276,5��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredIndoorTemperature2();
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGonTimerBasedReservationHSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGoffTimerBasedReservationHSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerSettingRelativeTime();
	}
	
	public class GetterImpl extends DeviceObject.GetterImpl implements Getter {

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

		@Override
		public Getter reqGetOperationModeSetting() {
			byte[] edt = getOperationModeSetting();
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting1() {
			byte[] edt = getTemperatureSetting1();
			addProperty(EPC_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGrelativeHumiditySettingForEdehumidificaTionFModeH1() {
			byte[] edt = getGrelativeHumiditySettingForEdehumidificaTionFModeH1();
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEcoolingFModeH1() {
			byte[] edt = getGtemperatureSettingForEcoolingFModeH1();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEheatingFModeH1() {
			byte[] edt = getGtemperatureSettingForEheatingFModeH1();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEdehumidificaTionFModeH1() {
			byte[] edt = getGtemperatureSettingForEdehumidificaTionFModeH1();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfIndoorUnit() {
			byte[] edt = getRatedPowerConsumptionOfIndoorUnit();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredElectricCurrentConsumptionOfIndoorUnit() {
			byte[] edt = getMeasuredElectricCurrentConsumptionOfIndoorUnit();
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredIndoorRelativeHumidity1() {
			byte[] edt = getMeasuredIndoorRelativeHumidity1();
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredIndoorTemperature1() {
			byte[] edt = getMeasuredIndoorTemperature1();
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRelativeTemperatureSetting() {
			byte[] edt = getRelativeTemperatureSetting();
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAirFlowRateSetting() {
			byte[] edt = getAirFlowRateSetting();
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGairFlowDirectionVerticalHSetting() {
			byte[] edt = getGairFlowDirectionVerticalHSetting();
			addProperty(EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGairFlowDirectionHorizontalHSetting() {
			byte[] edt = getGairFlowDirectionHorizontalHSetting();
			addProperty(EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGspecialHState() {
			byte[] edt = getGspecialHState();
			addProperty(EPC_GSPECIAL_H_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetThermostatState() {
			byte[] edt = getThermostatState();
			addProperty(EPC_THERMOSTAT_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCurrentFunctionGautomaticHOperationMode() {
			byte[] edt = getCurrentFunctionGautomaticHOperationMode();
			addProperty(EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVentilationModeSetting() {
			byte[] edt = getVentilationModeSetting();
			addProperty(EPC_VENTILATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {
			byte[] edt = getCombinedOperationOfIndoorUnitAndTotalHeatExchanger();
			addProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVentilationAirFlowRateSetting() {
			byte[] edt = getVentilationAirFlowRateSetting();
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGdisablingOfAirConditionerHSetting() {
			byte[] edt = getGdisablingOfAirConditionerHSetting();
			addProperty(EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetThermostatSettingOverrideFunction() {
			byte[] edt = getThermostatSettingOverrideFunction();
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetFilterCleaningReminderLampSetting() {
			byte[] edt = getFilterCleaningReminderLampSetting();
			addProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredPowerConsumptionOfIndoorUnit() {
			byte[] edt = getMeasuredPowerConsumptionOfIndoorUnit();
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetApertureOfExpansionValve() {
			byte[] edt = getApertureOfExpansionValve();
			addProperty(EPC_APERTURE_OF_EXPANSION_VALVE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting2() {
			byte[] edt = getTemperatureSetting2();
			addProperty(EPC_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGrelativeHumiditySettingForEdehumidificatioNFModeH2() {
			byte[] edt = getGrelativeHumiditySettingForEdehumidificatioNFModeH2();
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEcoolingFModeH2() {
			byte[] edt = getGtemperatureSettingForEcoolingFModeH2();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEheatingFModeH2() {
			byte[] edt = getGtemperatureSettingForEheatingFModeH2();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEdehumidificatioNFModeH2() {
			byte[] edt = getGtemperatureSettingForEdehumidificatioNFModeH2();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredIndoorRelativeHumidity2() {
			byte[] edt = getMeasuredIndoorRelativeHumidity2();
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredIndoorTemperature2() {
			byte[] edt = getMeasuredIndoorTemperature2();
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGonTimerBasedReservationHSetting() {
			byte[] edt = getGonTimerBasedReservationHSetting();
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingTime() {
			byte[] edt = getOnTimerSettingTime();
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingRelativeTime() {
			byte[] edt = getOnTimerSettingRelativeTime();
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGoffTimerBasedReservationHSetting() {
			byte[] edt = getGoffTimerBasedReservationHSetting();
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingTime() {
			byte[] edt = getOffTimerSettingTime();
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingRelativeTime() {
			byte[] edt = getOffTimerSettingRelativeTime();
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
	}

	public class GetterProxy extends DeviceObject.GetterProxy implements Getter {

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

		@Override
		public Getter reqGetOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting1() {
			addProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetGrelativeHumiditySettingForEdehumidificaTionFModeH1() {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1);
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEcoolingFModeH1() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1);
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEheatingFModeH1() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1);
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEdehumidificaTionFModeH1() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1);
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfIndoorUnit() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		@Override
		public Getter reqGetMeasuredElectricCurrentConsumptionOfIndoorUnit() {
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		@Override
		public Getter reqGetMeasuredIndoorRelativeHumidity1() {
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1);
			return this;
		}
		@Override
		public Getter reqGetMeasuredIndoorTemperature1() {
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE1);
			return this;
		}
		@Override
		public Getter reqGetRelativeTemperatureSetting() {
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGairFlowDirectionVerticalHSetting() {
			addProperty(EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGairFlowDirectionHorizontalHSetting() {
			addProperty(EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGspecialHState() {
			addProperty(EPC_GSPECIAL_H_STATE);
			return this;
		}
		@Override
		public Getter reqGetThermostatState() {
			addProperty(EPC_THERMOSTAT_STATE);
			return this;
		}
		@Override
		public Getter reqGetCurrentFunctionGautomaticHOperationMode() {
			addProperty(EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE);
			return this;
		}
		@Override
		public Getter reqGetVentilationModeSetting() {
			addProperty(EPC_VENTILATION_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {
			addProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER);
			return this;
		}
		@Override
		public Getter reqGetVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGdisablingOfAirConditionerHSetting() {
			addProperty(EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetThermostatSettingOverrideFunction() {
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION);
			return this;
		}
		@Override
		public Getter reqGetFilterCleaningReminderLampSetting() {
			addProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredPowerConsumptionOfIndoorUnit() {
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		@Override
		public Getter reqGetApertureOfExpansionValve() {
			addProperty(EPC_APERTURE_OF_EXPANSION_VALVE);
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting2() {
			addProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetGrelativeHumiditySettingForEdehumidificatioNFModeH2() {
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2);
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEcoolingFModeH2() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2);
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEheatingFModeH2() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2);
			return this;
		}
		@Override
		public Getter reqGetGtemperatureSettingForEdehumidificatioNFModeH2() {
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2);
			return this;
		}
		@Override
		public Getter reqGetMeasuredIndoorRelativeHumidity2() {
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2);
			return this;
		}
		@Override
		public Getter reqGetMeasuredIndoorTemperature2() {
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE2);
			return this;
		}
		@Override
		public Getter reqGetGonTimerBasedReservationHSetting() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		@Override
		public Getter reqGetGoffTimerBasedReservationHSetting() {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
	}
	
	public interface Informer extends DeviceObject.Informer {
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
		 * Used to specify the operation mode (�gautomatic,�h .�gcooling,�h .�gheating,�h . �gdehumidification�h .or .�gair . circulator�h) .and .to .acquire .the .current . setting.<br>The following values shall be used: Automatic: 0x41 Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Informer reqInformOperationModeSetting();
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Informer reqInformTemperatureSetting1();
		/**
		 * Used to set the relative humidity for the .�gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformGrelativeHumiditySettingForEdehumidificaTionFModeH1();
		/**
		 * Used to set the temperature for the �gcooling�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGtemperatureSettingForEcoolingFModeH1();
		/**
		 * Used to set the temperature for the �gheating�h .mode .and .to .acquire .the . current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGtemperatureSettingForEheatingFModeH1();
		/**
		 * Used to set the temperature for the �gdehumidification�h .mode .and .to . acquire the current setting.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGtemperatureSettingForEdehumidificaTionFModeH1();
		/**
		 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br>0x0000 to 0xFFFD (0 to 65533W) Cooling: heating: dehumidification: air circulator<br><br>Data type : unsigned short x 4<br>Data size : 8 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRatedPowerConsumptionOfIndoorUnit();
		/**
		 * This property indicates the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredElectricCurrentConsumptionOfIndoorUnit();
		/**
		 * Used to acquire the measured indoor relative humidity.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredIndoorRelativeHumidity1();
		/**
		 * Used to acquire the measured indoor temperature.<br>0x81 to 0x7D (-127 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredIndoorTemperature1();
		/**
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>0x81 to 0x7D (-12.7��C to 12.5��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRelativeTemperatureSetting();
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>Automatic air flow rate control function used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformAirFlowRateSetting();
		/**
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: 0x41 to 0x49 (0x41 and 0x49 shall be used for the uppermost and lowermost directions, respectively.)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGairFlowDirectionVerticalHSetting();
		/**
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>Automatic = 0x31, swing = 0x32 Air flow direction: Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGairFlowDirectionHorizontalHSetting();
		/**
		 * This property indicates when the air conditioner is in a �gspecial�h state.<br>�gNormal operation�h state = 0x40, �gpreheating�h state = 0x42, �gheat removal�h state = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformGspecialHState();
		/**
		 * This property indicates the state (ON or OFF) of the thermostat.<br>Thermostat ON = 0x41 Thermostat OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformThermostatState();
		/**
		 * This property indicates, when the air conditioner is operating in the �gautomatic�h operation mode, the function (�gcooling,�h �gheating,�h �gdehumidification,�h �gair circulator�h or �gother�h) that is currently being used.<br>The following values shall be used: Cooling: 0x42 Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformCurrentFunctionGautomaticHOperationMode();
		/**
		 * Used to specify the ventilation mode and to acquire the current setting.<br>Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange = 0x42, automatic control of ventilation (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformVentilationModeSetting();
		/**
		 * Used to specify whether or not to use the �gcombined operation of indoor unit and total heat exchanger�h function, and to acquire the current setting.<br>�gCombined operation of indoor unit and total heat exchanger�h function used = 0x41 �gCombined operation of indoor unit and total heat exchanger�h function not used= 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformCombinedOperationOfIndoorUnitAndTotalHeatExchanger();
		/**
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>Automatic control of ventilation air flow rate = 0x41 Ventilation air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformVentilationAirFlowRateSetting();
		/**
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>Disabled = 0x41, not disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGdisablingOfAirConditionerHSetting();
		/**
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformThermostatSettingOverrideFunction();
		/**
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>Enabled = 0x41, disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformFilterCleaningReminderLampSetting();
		/**
		 * This property indicates the measured power consumption of the indoor unit.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : unsigned<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredPowerConsumptionOfIndoorUnit();
		/**
		 * This property indicates the aperture of the expansion valve in %.<br>0 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformApertureOfExpansionValve();
		/**
		 * Used to set the temperature and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Informer reqInformTemperatureSetting2();
		/**
		 * Used to set the relative humidity for the �gdehumidification�h mode and to acquire the current setting.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformGrelativeHumiditySettingForEdehumidificatioNFModeH2();
		/**
		 * Used to set the temperature for the �gcooling�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGtemperatureSettingForEcoolingFModeH2();
		/**
		 * Used to set the temperature for the �gheating�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGtemperatureSettingForEheatingFModeH2();
		/**
		 * Used to set the temperature for the �gdehumidification�h mode and to acquire the current setting.<br>0xFE0C to 0x3E8 (-50.0 to 100.0��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGtemperatureSettingForEdehumidificatioNFModeH2();
		/**
		 * Used to acquire the measured indoor relative humidity.<br>0x0000 to 0x3E8 (0.0 to 100.0%)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredIndoorRelativeHumidity2();
		/**
		 * Used to acquire the measured indoor temperature.<br>0xF554 to 0x7FFD (-273,2 to 3276,5��C)<br><br>Data type : unsigned short<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredIndoorTemperature2();
		/**
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGonTimerBasedReservationHSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGoffTimerBasedReservationHSetting();
		/**
		 * Used to specify the time for the time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerSettingTime();
		/**
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char�~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerSettingRelativeTime();
	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {

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
			byte[] edt = getOperationModeSetting();
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting1() {
			byte[] edt = getTemperatureSetting1();
			addProperty(EPC_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGrelativeHumiditySettingForEdehumidificaTionFModeH1() {
			byte[] edt = getGrelativeHumiditySettingForEdehumidificaTionFModeH1();
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEcoolingFModeH1() {
			byte[] edt = getGtemperatureSettingForEcoolingFModeH1();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEheatingFModeH1() {
			byte[] edt = getGtemperatureSettingForEheatingFModeH1();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEdehumidificaTionFModeH1() {
			byte[] edt = getGtemperatureSettingForEdehumidificaTionFModeH1();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICA_TION_F_MODE_H1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfIndoorUnit() {
			byte[] edt = getRatedPowerConsumptionOfIndoorUnit();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredElectricCurrentConsumptionOfIndoorUnit() {
			byte[] edt = getMeasuredElectricCurrentConsumptionOfIndoorUnit();
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorRelativeHumidity1() {
			byte[] edt = getMeasuredIndoorRelativeHumidity1();
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorTemperature1() {
			byte[] edt = getMeasuredIndoorTemperature1();
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRelativeTemperatureSetting() {
			byte[] edt = getRelativeTemperatureSetting();
			addProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			byte[] edt = getAirFlowRateSetting();
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGairFlowDirectionVerticalHSetting() {
			byte[] edt = getGairFlowDirectionVerticalHSetting();
			addProperty(EPC_GAIR_FLOW_DIRECTION_VERTICAL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGairFlowDirectionHorizontalHSetting() {
			byte[] edt = getGairFlowDirectionHorizontalHSetting();
			addProperty(EPC_GAIR_FLOW_DIRECTION_HORIZONTAL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGspecialHState() {
			byte[] edt = getGspecialHState();
			addProperty(EPC_GSPECIAL_H_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformThermostatState() {
			byte[] edt = getThermostatState();
			addProperty(EPC_THERMOSTAT_STATE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCurrentFunctionGautomaticHOperationMode() {
			byte[] edt = getCurrentFunctionGautomaticHOperationMode();
			addProperty(EPC_CURRENT_FUNCTION_GAUTOMATIC_H_OPERATION_MODE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationModeSetting() {
			byte[] edt = getVentilationModeSetting();
			addProperty(EPC_VENTILATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {
			byte[] edt = getCombinedOperationOfIndoorUnitAndTotalHeatExchanger();
			addProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationAirFlowRateSetting() {
			byte[] edt = getVentilationAirFlowRateSetting();
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGdisablingOfAirConditionerHSetting() {
			byte[] edt = getGdisablingOfAirConditionerHSetting();
			addProperty(EPC_GDISABLING_OF_AIR_CONDITIONER_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformThermostatSettingOverrideFunction() {
			byte[] edt = getThermostatSettingOverrideFunction();
			addProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFilterCleaningReminderLampSetting() {
			byte[] edt = getFilterCleaningReminderLampSetting();
			addProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredPowerConsumptionOfIndoorUnit() {
			byte[] edt = getMeasuredPowerConsumptionOfIndoorUnit();
			addProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformApertureOfExpansionValve() {
			byte[] edt = getApertureOfExpansionValve();
			addProperty(EPC_APERTURE_OF_EXPANSION_VALVE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting2() {
			byte[] edt = getTemperatureSetting2();
			addProperty(EPC_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGrelativeHumiditySettingForEdehumidificatioNFModeH2() {
			byte[] edt = getGrelativeHumiditySettingForEdehumidificatioNFModeH2();
			addProperty(EPC_GRELATIVE_HUMIDITY_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEcoolingFModeH2() {
			byte[] edt = getGtemperatureSettingForEcoolingFModeH2();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_ECOOLING_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEheatingFModeH2() {
			byte[] edt = getGtemperatureSettingForEheatingFModeH2();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EHEATING_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureSettingForEdehumidificatioNFModeH2() {
			byte[] edt = getGtemperatureSettingForEdehumidificatioNFModeH2();
			addProperty(EPC_GTEMPERATURE_SETTING_FOR_EDEHUMIDIFICATIO_N_F_MODE_H2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorRelativeHumidity2() {
			byte[] edt = getMeasuredIndoorRelativeHumidity2();
			addProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredIndoorTemperature2() {
			byte[] edt = getMeasuredIndoorTemperature2();
			addProperty(EPC_MEASURED_INDOOR_TEMPERATURE2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGonTimerBasedReservationHSetting() {
			byte[] edt = getGonTimerBasedReservationHSetting();
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingTime() {
			byte[] edt = getOnTimerSettingTime();
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingRelativeTime() {
			byte[] edt = getOnTimerSettingRelativeTime();
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGoffTimerBasedReservationHSetting() {
			byte[] edt = getGoffTimerBasedReservationHSetting();
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			byte[] edt = getOffTimerSettingTime();
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingRelativeTime() {
			byte[] edt = getOffTimerSettingRelativeTime();
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {

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
