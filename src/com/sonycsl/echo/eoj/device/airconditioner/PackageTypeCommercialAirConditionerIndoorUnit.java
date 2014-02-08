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
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class PackageTypeCommercialAirConditionerIndoorUnit extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0145;

	public static final byte EPC_OPERATION_MODE_SETTING = (byte)0xB0;
	public static final byte EPC_TEMPERATURE_SETTING1 = (byte)0xB3;
	public static final byte EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 = (byte)0xB4;
	public static final byte EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE1 = (byte)0xB5;
	public static final byte EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE1 = (byte)0xB6;
	public static final byte EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 = (byte)0xB7;
	public static final byte EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT = (byte)0xB8;
	public static final byte EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT = (byte)0xB9;
	public static final byte EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1 = (byte)0xBA;
	public static final byte EPC_MEASURED_INDOOR_TEMPERATURE1 = (byte)0xBB;
	public static final byte EPC_RELATIVE_TEMPERATURE_SETTING = (byte)0xBF;
	public static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	public static final byte EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING = (byte)0xA4;
	public static final byte EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING = (byte)0xA5;
	public static final byte EPC_SPECIAL_STATE = (byte)0xAA;
	public static final byte EPC_THERMOSTAT_STATE = (byte)0xAC;
	public static final byte EPC_CURRENT_FUNCTION_AUTOMATIC_OPERATION_MODE = (byte)0xAE;
	public static final byte EPC_VENTILATION_MODE_SETTING = (byte)0xC0;
	public static final byte EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER = (byte)0xC1;
	public static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	public static final byte EPC_DISABLING_OF_AIR_CONDITIONER_SETTING = (byte)0xCD;
	public static final byte EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION = (byte)0xCE;
	public static final byte EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING = (byte)0xCF;
	public static final byte EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT = (byte)0xDB;
	public static final byte EPC_APERTURE_OF_EXPANSION_VALVE = (byte)0xDC;
	public static final byte EPC_TEMPERATURE_SETTING2 = (byte)0xE3;
	public static final byte EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 = (byte)0xE4;
	public static final byte EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE2 = (byte)0xE5;
	public static final byte EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE2 = (byte)0xE6;
	public static final byte EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 = (byte)0xE7;
	public static final byte EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2 = (byte)0xEA;
	public static final byte EPC_MEASURED_INDOOR_TEMPERATURE2 = (byte)0xEB;
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
		addStatusChangeAnnouncementProperty(EPC_TEMPERATURE_SETTING1);
		addSetProperty(EPC_TEMPERATURE_SETTING1);
		addGetProperty(EPC_TEMPERATURE_SETTING1);
		addStatusChangeAnnouncementProperty(EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1);
		addStatusChangeAnnouncementProperty(EPC_CURRENT_FUNCTION_AUTOMATIC_OPERATION_MODE);
		addStatusChangeAnnouncementProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING);
		addStatusChangeAnnouncementProperty(EPC_TEMPERATURE_SETTING2);
		addSetProperty(EPC_TEMPERATURE_SETTING2);
		addGetProperty(EPC_TEMPERATURE_SETTING2);
		addStatusChangeAnnouncementProperty(EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewPackageTypeCommercialAirConditionerIndoorUnit(this);
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
	 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41<br>
	 * Cooling: 0x42<br>
	 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41<br>
	 * Cooling: 0x42<br>
	 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”) and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41<br>
	 * Cooling: 0x42<br>
	 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Property name : Temperature setting 1<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setTemperatureSetting1(byte[] edt);
	/**
	 * Property name : Temperature setting 1<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getTemperatureSetting1();
	/**
	 * Property name : Temperature setting 1<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidTemperatureSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Relative
humidity setting for ‘dehumidifica- tion’ mode” 1<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setRelativeHumiditySettingForDehumidificaTionMode1(byte[] edt) {return false;}
	/**
	 * Property name : “Relative
humidity setting for ‘dehumidifica- tion’ mode” 1<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getRelativeHumiditySettingForDehumidificaTionMode1() {return null;}
	/**
	 * Property name : “Relative
humidity setting for ‘dehumidifica- tion’ mode” 1<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRelativeHumiditySettingForDehumidificaTionMode1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Temperature setting for ‘cooling’ mode” 1<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTemperatureSettingForCoolingMode1(byte[] edt) {return false;}
	/**
	 * Property name : “Temperature setting for ‘cooling’ mode” 1<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTemperatureSettingForCoolingMode1() {return null;}
	/**
	 * Property name : “Temperature setting for ‘cooling’ mode” 1<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTemperatureSettingForCoolingMode1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Temperature setting for ‘heating’ mode” 1<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTemperatureSettingForHeatingMode1(byte[] edt) {return false;}
	/**
	 * Property name : “Temperature setting for ‘heating’ mode” 1<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTemperatureSettingForHeatingMode1() {return null;}
	/**
	 * Property name : “Temperature setting for ‘heating’ mode” 1<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTemperatureSettingForHeatingMode1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Temperature
setting for ‘dehumidifica- tion’ mode” 1<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTemperatureSettingForDehumidificaTionMode1(byte[] edt) {return false;}
	/**
	 * Property name : “Temperature
setting for ‘dehumidifica- tion’ mode” 1<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTemperatureSettingForDehumidificaTionMode1() {return null;}
	/**
	 * Property name : “Temperature
setting for ‘dehumidifica- tion’ mode” 1<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTemperatureSettingForDehumidificaTionMode1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Rated power consumption of indoor unit<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * Cooling: heating: dehumidification: air circulator<br>
	 * <br>
	 * Data type : unsigned short × 4<br>
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
	protected byte[] getRatedPowerConsumptionOfIndoorUnit() {return null;}
	/**
	 * Property name : Rated power consumption of indoor unit<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * Cooling: heating: dehumidification: air circulator<br>
	 * <br>
	 * Data type : unsigned short × 4<br>
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
	protected boolean isValidRatedPowerConsumptionOfIndoorUnit(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Measured electric current consumption of indoor unit<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured electric current consumption.<br>
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
	protected byte[] getMeasuredElectricCurrentConsumptionOfIndoorUnit() {return null;}
	/**
	 * Property name : Measured electric current consumption of indoor unit<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured electric current consumption.<br>
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
	protected boolean isValidMeasuredElectricCurrentConsumptionOfIndoorUnit(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured indoor relative humidity 1<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured indoor relative humidity.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredIndoorRelativeHumidity1() {return null;}
	/**
	 * Property name : Measured indoor relative humidity 1<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured indoor relative humidity.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredIndoorRelativeHumidity1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured indoor temperature 1<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured indoor temperature.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredIndoorTemperature1() {return null;}
	/**
	 * Property name : Measured indoor temperature 1<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured indoor temperature.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredIndoorTemperature1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Relative temperature setting<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-12.7°C.12.5°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 0.1°C<br>
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
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-12.7°C.12.5°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 0.1°C<br>
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
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-12.7°C.12.5°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : 0.1°C<br>
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
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow rate control function used = 0x41<br>
	 * Air flow rate = 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow rate control function used = 0x41<br>
	 * Air flow rate = 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow rate control function used = 0x41<br>
	 * Air flow rate = 0x31.0x38<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Property name : “Air flow direction (vertical)” setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x31, swing = 0x32 Air flow direction: 0x41.0x49 (0x41 and 0x49 shall be used for the<br>
	 * uppermost and lowermost directions,<br>
	 * respectively.)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAirFlowDirectionVerticalSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Air flow direction (vertical)” setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x31, swing = 0x32 Air flow direction: 0x41.0x49 (0x41 and 0x49 shall be used for the<br>
	 * uppermost and lowermost directions,<br>
	 * respectively.)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAirFlowDirectionVerticalSetting() {return null;}
	/**
	 * Property name : “Air flow direction (vertical)” setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x31, swing = 0x32 Air flow direction: 0x41.0x49 (0x41 and 0x49 shall be used for the<br>
	 * uppermost and lowermost directions,<br>
	 * respectively.)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Property name : “Air flow direction (horizontal)” setting<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x31, swing = 0x32 Air flow direction:<br>
	 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
	 * = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAirFlowDirectionHorizontalSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Air flow direction (horizontal)” setting<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x31, swing = 0x32 Air flow direction:<br>
	 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
	 * = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAirFlowDirectionHorizontalSetting() {return null;}
	/**
	 * Property name : “Air flow direction (horizontal)” setting<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x31, swing = 0x32 Air flow direction:<br>
	 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
	 * = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
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
	 * Property name : “Special” state<br>
	 * <br>
	 * EPC : 0xAA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates when the air conditioner is in a “special” state.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” state = 0x40, “preheating” state = 0x42, “heat removal” state = 0x43<br>
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
	 * Property name : “Special” state<br>
	 * <br>
	 * EPC : 0xAA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates when the air conditioner is in a “special” state.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” state = 0x40, “preheating” state = 0x42, “heat removal” state = 0x43<br>
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
	 * Property name : Thermostat state<br>
	 * <br>
	 * EPC : 0xAC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the state (ON or OFF) of the thermostat.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Thermostat ON = 0x41 Thermostat OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getThermostatState() {return null;}
	/**
	 * Property name : Thermostat state<br>
	 * <br>
	 * EPC : 0xAC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the state (ON or OFF) of the thermostat.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Thermostat ON = 0x41 Thermostat OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidThermostatState(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Current function (“automatic” operation mode)<br>
	 * <br>
	 * EPC : 0xAE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates, when the air conditioner is operating in the “automatic” operation mode, the function (“cooling,” “heating,” “dehumidification,” “air circulator” or “other”) that is currently being used.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Cooling: 0x42<br>
	 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getCurrentFunctionAutomaticOperationMode() {return null;}
	/**
	 * Property name : Current function (“automatic” operation mode)<br>
	 * <br>
	 * EPC : 0xAE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates, when the air conditioner is operating in the “automatic” operation mode, the function (“cooling,” “heating,” “dehumidification,” “air circulator” or “other”) that is currently being used.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Cooling: 0x42<br>
	 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidCurrentFunctionAutomaticOperationMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Ventilation mode setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ventilation mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange =<br>
	 * 0x42, automatic control of ventilation<br>
	 * (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br>
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
	protected boolean setVentilationModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ventilation mode setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ventilation mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange =<br>
	 * 0x42, automatic control of ventilation<br>
	 * (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br>
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
	protected byte[] getVentilationModeSetting() {return null;}
	/**
	 * Property name : Ventilation mode setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ventilation mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange =<br>
	 * 0x42, automatic control of ventilation<br>
	 * (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br>
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
	protected boolean isValidVentilationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Combined operation of indoor unit and total heat exchanger<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “combined operation of indoor unit and total heat exchanger” function,  and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Combined operation of indoor unit and total heat exchanger” function used = 0x41<br>
	 * “Combined operation of indoor unit and total heat exchanger” function not used= 0x42<br>
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
	protected boolean setCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte[] edt) {return false;}
	/**
	 * Property name : Combined operation of indoor unit and total heat exchanger<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “combined operation of indoor unit and total heat exchanger” function,  and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Combined operation of indoor unit and total heat exchanger” function used = 0x41<br>
	 * “Combined operation of indoor unit and total heat exchanger” function not used= 0x42<br>
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
	protected byte[] getCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {return null;}
	/**
	 * Property name : Combined operation of indoor unit and total heat exchanger<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “combined operation of indoor unit and total heat exchanger” function,  and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Combined operation of indoor unit and total heat exchanger” function used = 0x41<br>
	 * “Combined operation of indoor unit and total heat exchanger” function not used= 0x42<br>
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
	protected boolean isValidCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire  the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of ventilation air flow rate = 0x41<br>
	 * Ventilation air flow rate = 0x31 to 0x38<br>
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
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire  the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of ventilation air flow rate = 0x41<br>
	 * Ventilation air flow rate = 0x31 to 0x38<br>
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
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire  the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of ventilation air flow rate = 0x41<br>
	 * Ventilation air flow rate = 0x31 to 0x38<br>
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
	 * Property name : “Disabling of air conditioner” setting<br>
	 * <br>
	 * EPC : 0xCD<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Disabled = 0x41, not disabled = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDisablingOfAirConditionerSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Disabling of air conditioner” setting<br>
	 * <br>
	 * EPC : 0xCD<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Disabled = 0x41, not disabled = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDisablingOfAirConditionerSetting() {return null;}
	/**
	 * Property name : “Disabling of air conditioner” setting<br>
	 * <br>
	 * EPC : 0xCD<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Disabled = 0x41, not disabled = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDisablingOfAirConditionerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Thermostat setting override function<br>
	 * <br>
	 * EPC : 0xCE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setThermostatSettingOverrideFunction(byte[] edt) {return false;}
	/**
	 * Property name : Thermostat setting override function<br>
	 * <br>
	 * EPC : 0xCE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getThermostatSettingOverrideFunction() {return null;}
	/**
	 * Property name : Thermostat setting override function<br>
	 * <br>
	 * EPC : 0xCE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidThermostatSettingOverrideFunction(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Filter cleaning reminder lamp setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Enabled = 0x41, disabled = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setFilterCleaningReminderLampSetting(byte[] edt) {return false;}
	/**
	 * Property name : Filter cleaning reminder lamp setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Enabled = 0x41, disabled = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getFilterCleaningReminderLampSetting() {return null;}
	/**
	 * Property name : Filter cleaning reminder lamp setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Enabled = 0x41, disabled = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidFilterCleaningReminderLampSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured power consumption of indoor unit<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured power consumption of the indoor unit.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredPowerConsumptionOfIndoorUnit() {return null;}
	/**
	 * Property name : Measured power consumption of indoor unit<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured power consumption of the indoor unit.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredPowerConsumptionOfIndoorUnit(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Aperture of expansion valve<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the aperture of the expansion valve in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x64 (0.100%)<br>
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
	protected byte[] getApertureOfExpansionValve() {return null;}
	/**
	 * Property name : Aperture of expansion valve<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the aperture of the expansion valve in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x64 (0.100%)<br>
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
	protected boolean isValidApertureOfExpansionValve(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Temperature setting 2<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setTemperatureSetting2(byte[] edt);
	/**
	 * Property name : Temperature setting 2<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getTemperatureSetting2();
	/**
	 * Property name : Temperature setting 2<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidTemperatureSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : “Relative humidity setting for ‘dehumidificatio n’ mode” 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x3E8 (0.0.100.0%)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setRelativeHumiditySettingForDehumidificatioNMode2(byte[] edt) {return false;}
	/**
	 * Property name : “Relative humidity setting for ‘dehumidificatio n’ mode” 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x3E8 (0.0.100.0%)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getRelativeHumiditySettingForDehumidificatioNMode2() {return null;}
	/**
	 * Property name : “Relative humidity setting for ‘dehumidificatio n’ mode” 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x3E8 (0.0.100.0%)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRelativeHumiditySettingForDehumidificatioNMode2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : “Temperature setting for ‘cooling’ mode” 2<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTemperatureSettingForCoolingMode2(byte[] edt) {return false;}
	/**
	 * Property name : “Temperature setting for ‘cooling’ mode” 2<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTemperatureSettingForCoolingMode2() {return null;}
	/**
	 * Property name : “Temperature setting for ‘cooling’ mode” 2<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTemperatureSettingForCoolingMode2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : “Temperature setting for ‘heating’ mode” 2<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTemperatureSettingForHeatingMode2(byte[] edt) {return false;}
	/**
	 * Property name : “Temperature setting for ‘heating’ mode” 2<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTemperatureSettingForHeatingMode2() {return null;}
	/**
	 * Property name : “Temperature setting for ‘heating’ mode” 2<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTemperatureSettingForHeatingMode2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : “Temperature setting for ‘dehumidificatio n’ mode” 2<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTemperatureSettingForDehumidificatioNMode2(byte[] edt) {return false;}
	/**
	 * Property name : “Temperature setting for ‘dehumidificatio n’ mode” 2<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTemperatureSettingForDehumidificatioNMode2() {return null;}
	/**
	 * Property name : “Temperature setting for ‘dehumidificatio n’ mode” 2<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTemperatureSettingForDehumidificatioNMode2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured indoor relative humidity 2<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured indoor relative humidity.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x3E8 (0.0.100.0%)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredIndoorRelativeHumidity2() {return null;}
	/**
	 * Property name : Measured indoor relative humidity 2<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured indoor relative humidity.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x3E8 (0.0.100.0%)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1%<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredIndoorRelativeHumidity2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured indoor temperature 2<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured indoor temperature.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFD (-273,2.3276,5°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredIndoorTemperature2() {return null;}
	/**
	 * Property name : Measured indoor temperature 2<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured indoor temperature.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFD (-273,2.3276,5°C)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredIndoorTemperature2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : “ON
timer-based reservation” setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
	 * Property name : “ON
timer-based reservation” setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
	 * Property name : “ON
timer-based reservation” setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
	 * Property name : ON timer setting (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the<br>
	 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * Property name : ON timer setting (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the<br>
	 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * Property name : ON timer setting (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the<br>
	 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * Property name : ON timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * Property name : ON timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * Property name : ON timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * Property name : “OFF
timer-based reservation” setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
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
	 * Property name : “OFF
timer-based reservation” setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
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
	 * Property name : “OFF
timer-based reservation” setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
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
	 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char×2<br>
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
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_OPERATION_MODE_SETTING : return setOperationModeSetting(property.edt);
		case EPC_TEMPERATURE_SETTING1 : return setTemperatureSetting1(property.edt);
		case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : return setRelativeHumiditySettingForDehumidificaTionMode1(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE1 : return setTemperatureSettingForCoolingMode1(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE1 : return setTemperatureSettingForHeatingMode1(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : return setTemperatureSettingForDehumidificaTionMode1(property.edt);
		case EPC_RELATIVE_TEMPERATURE_SETTING : return setRelativeTemperatureSetting(property.edt);
		case EPC_AIR_FLOW_RATE_SETTING : return setAirFlowRateSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : return setAirFlowDirectionVerticalSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : return setAirFlowDirectionHorizontalSetting(property.edt);
		case EPC_VENTILATION_MODE_SETTING : return setVentilationModeSetting(property.edt);
		case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER : return setCombinedOperationOfIndoorUnitAndTotalHeatExchanger(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return setVentilationAirFlowRateSetting(property.edt);
		case EPC_DISABLING_OF_AIR_CONDITIONER_SETTING : return setDisablingOfAirConditionerSetting(property.edt);
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : return setThermostatSettingOverrideFunction(property.edt);
		case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING : return setFilterCleaningReminderLampSetting(property.edt);
		case EPC_TEMPERATURE_SETTING2 : return setTemperatureSetting2(property.edt);
		case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : return setRelativeHumiditySettingForDehumidificatioNMode2(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE2 : return setTemperatureSettingForCoolingMode2(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE2 : return setTemperatureSettingForHeatingMode2(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : return setTemperatureSettingForDehumidificatioNMode2(property.edt);
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
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING : return getOperationModeSetting();
		case EPC_TEMPERATURE_SETTING1 : return getTemperatureSetting1();
		case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : return getRelativeHumiditySettingForDehumidificaTionMode1();
		case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE1 : return getTemperatureSettingForCoolingMode1();
		case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE1 : return getTemperatureSettingForHeatingMode1();
		case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : return getTemperatureSettingForDehumidificaTionMode1();
		case EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT : return getRatedPowerConsumptionOfIndoorUnit();
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT : return getMeasuredElectricCurrentConsumptionOfIndoorUnit();
		case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1 : return getMeasuredIndoorRelativeHumidity1();
		case EPC_MEASURED_INDOOR_TEMPERATURE1 : return getMeasuredIndoorTemperature1();
		case EPC_RELATIVE_TEMPERATURE_SETTING : return getRelativeTemperatureSetting();
		case EPC_AIR_FLOW_RATE_SETTING : return getAirFlowRateSetting();
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : return getAirFlowDirectionVerticalSetting();
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : return getAirFlowDirectionHorizontalSetting();
		case EPC_SPECIAL_STATE : return getSpecialState();
		case EPC_THERMOSTAT_STATE : return getThermostatState();
		case EPC_CURRENT_FUNCTION_AUTOMATIC_OPERATION_MODE : return getCurrentFunctionAutomaticOperationMode();
		case EPC_VENTILATION_MODE_SETTING : return getVentilationModeSetting();
		case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER : return getCombinedOperationOfIndoorUnitAndTotalHeatExchanger();
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return getVentilationAirFlowRateSetting();
		case EPC_DISABLING_OF_AIR_CONDITIONER_SETTING : return getDisablingOfAirConditionerSetting();
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : return getThermostatSettingOverrideFunction();
		case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING : return getFilterCleaningReminderLampSetting();
		case EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT : return getMeasuredPowerConsumptionOfIndoorUnit();
		case EPC_APERTURE_OF_EXPANSION_VALVE : return getApertureOfExpansionValve();
		case EPC_TEMPERATURE_SETTING2 : return getTemperatureSetting2();
		case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : return getRelativeHumiditySettingForDehumidificatioNMode2();
		case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE2 : return getTemperatureSettingForCoolingMode2();
		case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE2 : return getTemperatureSettingForHeatingMode2();
		case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : return getTemperatureSettingForDehumidificatioNMode2();
		case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2 : return getMeasuredIndoorRelativeHumidity2();
		case EPC_MEASURED_INDOOR_TEMPERATURE2 : return getMeasuredIndoorTemperature2();
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
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_OPERATION_MODE_SETTING : return isValidOperationModeSetting(property.edt);
		case EPC_TEMPERATURE_SETTING1 : return isValidTemperatureSetting1(property.edt);
		case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : return isValidRelativeHumiditySettingForDehumidificaTionMode1(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE1 : return isValidTemperatureSettingForCoolingMode1(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE1 : return isValidTemperatureSettingForHeatingMode1(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : return isValidTemperatureSettingForDehumidificaTionMode1(property.edt);
		case EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT : return isValidRatedPowerConsumptionOfIndoorUnit(property.edt);
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT : return isValidMeasuredElectricCurrentConsumptionOfIndoorUnit(property.edt);
		case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1 : return isValidMeasuredIndoorRelativeHumidity1(property.edt);
		case EPC_MEASURED_INDOOR_TEMPERATURE1 : return isValidMeasuredIndoorTemperature1(property.edt);
		case EPC_RELATIVE_TEMPERATURE_SETTING : return isValidRelativeTemperatureSetting(property.edt);
		case EPC_AIR_FLOW_RATE_SETTING : return isValidAirFlowRateSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : return isValidAirFlowDirectionVerticalSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : return isValidAirFlowDirectionHorizontalSetting(property.edt);
		case EPC_SPECIAL_STATE : return isValidSpecialState(property.edt);
		case EPC_THERMOSTAT_STATE : return isValidThermostatState(property.edt);
		case EPC_CURRENT_FUNCTION_AUTOMATIC_OPERATION_MODE : return isValidCurrentFunctionAutomaticOperationMode(property.edt);
		case EPC_VENTILATION_MODE_SETTING : return isValidVentilationModeSetting(property.edt);
		case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER : return isValidCombinedOperationOfIndoorUnitAndTotalHeatExchanger(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return isValidVentilationAirFlowRateSetting(property.edt);
		case EPC_DISABLING_OF_AIR_CONDITIONER_SETTING : return isValidDisablingOfAirConditionerSetting(property.edt);
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : return isValidThermostatSettingOverrideFunction(property.edt);
		case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING : return isValidFilterCleaningReminderLampSetting(property.edt);
		case EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT : return isValidMeasuredPowerConsumptionOfIndoorUnit(property.edt);
		case EPC_APERTURE_OF_EXPANSION_VALVE : return isValidApertureOfExpansionValve(property.edt);
		case EPC_TEMPERATURE_SETTING2 : return isValidTemperatureSetting2(property.edt);
		case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : return isValidRelativeHumiditySettingForDehumidificatioNMode2(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE2 : return isValidTemperatureSettingForCoolingMode2(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE2 : return isValidTemperatureSettingForHeatingMode2(property.edt);
		case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : return isValidTemperatureSettingForDehumidificatioNMode2(property.edt);
		case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2 : return isValidMeasuredIndoorRelativeHumidity2(property.edt);
		case EPC_MEASURED_INDOOR_TEMPERATURE2 : return isValidMeasuredIndoorTemperature2(property.edt);
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
			case EPC_OPERATION_MODE_SETTING : 
				onSetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING1 : 
				onSetTemperatureSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : 
				onSetRelativeHumiditySettingForDehumidificaTionMode1(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE1 : 
				onSetTemperatureSettingForCoolingMode1(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE1 : 
				onSetTemperatureSettingForHeatingMode1(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : 
				onSetTemperatureSettingForDehumidificaTionMode1(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TEMPERATURE_SETTING : 
				onSetRelativeTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_RATE_SETTING : 
				onSetAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : 
				onSetAirFlowDirectionVerticalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : 
				onSetAirFlowDirectionHorizontalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_MODE_SETTING : 
				onSetVentilationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER : 
				onSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onSetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISABLING_OF_AIR_CONDITIONER_SETTING : 
				onSetDisablingOfAirConditionerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : 
				onSetThermostatSettingOverrideFunction(eoj, tid, esv, property, success);
				return true;
			case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING : 
				onSetFilterCleaningReminderLampSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING2 : 
				onSetTemperatureSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : 
				onSetRelativeHumiditySettingForDehumidificatioNMode2(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE2 : 
				onSetTemperatureSettingForCoolingMode2(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE2 : 
				onSetTemperatureSettingForHeatingMode2(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : 
				onSetTemperatureSettingForDehumidificatioNMode2(eoj, tid, esv, property, success);
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
			case EPC_TEMPERATURE_SETTING1 : 
				onGetTemperatureSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : 
				onGetRelativeHumiditySettingForDehumidificaTionMode1(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE1 : 
				onGetTemperatureSettingForCoolingMode1(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE1 : 
				onGetTemperatureSettingForHeatingMode1(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICA_TION_MODE1 : 
				onGetTemperatureSettingForDehumidificaTionMode1(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT : 
				onGetRatedPowerConsumptionOfIndoorUnit(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT : 
				onGetMeasuredElectricCurrentConsumptionOfIndoorUnit(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1 : 
				onGetMeasuredIndoorRelativeHumidity1(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INDOOR_TEMPERATURE1 : 
				onGetMeasuredIndoorTemperature1(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TEMPERATURE_SETTING : 
				onGetRelativeTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_RATE_SETTING : 
				onGetAirFlowRateSetting(eoj, tid, esv, property, success);
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
			case EPC_THERMOSTAT_STATE : 
				onGetThermostatState(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_FUNCTION_AUTOMATIC_OPERATION_MODE : 
				onGetCurrentFunctionAutomaticOperationMode(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_MODE_SETTING : 
				onGetVentilationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER : 
				onGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onGetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISABLING_OF_AIR_CONDITIONER_SETTING : 
				onGetDisablingOfAirConditionerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : 
				onGetThermostatSettingOverrideFunction(eoj, tid, esv, property, success);
				return true;
			case EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING : 
				onGetFilterCleaningReminderLampSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT : 
				onGetMeasuredPowerConsumptionOfIndoorUnit(eoj, tid, esv, property, success);
				return true;
			case EPC_APERTURE_OF_EXPANSION_VALVE : 
				onGetApertureOfExpansionValve(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING2 : 
				onGetTemperatureSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : 
				onGetRelativeHumiditySettingForDehumidificatioNMode2(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE2 : 
				onGetTemperatureSettingForCoolingMode2(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE2 : 
				onGetTemperatureSettingForHeatingMode2(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2 : 
				onGetTemperatureSettingForDehumidificatioNMode2(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2 : 
				onGetMeasuredIndoorRelativeHumidity2(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INDOOR_TEMPERATURE2 : 
				onGetMeasuredIndoorTemperature2(eoj, tid, esv, property, success);
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
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
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
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
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
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetTemperatureSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetTemperatureSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Relative
humidity setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetRelativeHumiditySettingForDehumidificaTionMode1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Relative
humidity setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRelativeHumiditySettingForDehumidificaTionMode1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 1<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTemperatureSettingForCoolingMode1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 1<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTemperatureSettingForCoolingMode1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 1<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTemperatureSettingForHeatingMode1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 1<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTemperatureSettingForHeatingMode1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature
setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTemperatureSettingForDehumidificaTionMode1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature
setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTemperatureSettingForDehumidificaTionMode1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power consumption of indoor unit<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * Cooling: heating: dehumidification: air circulator<br>
		 * <br>
		 * Data type : unsigned short × 4<br>
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
		protected void onGetRatedPowerConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured electric current consumption of indoor unit<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured electric current consumption.<br>
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
		protected void onGetMeasuredElectricCurrentConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured indoor relative humidity 1<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor relative humidity.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredIndoorRelativeHumidity1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured indoor temperature 1<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredIndoorTemperature1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1°C<br>
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
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1°C<br>
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
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
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
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Air flow direction (vertical)” setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction: 0x41.0x49 (0x41 and 0x49 shall be used for the<br>
		 * uppermost and lowermost directions,<br>
		 * respectively.)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Air flow direction (vertical)” setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction: 0x41.0x49 (0x41 and 0x49 shall be used for the<br>
		 * uppermost and lowermost directions,<br>
		 * respectively.)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Air flow direction (horizontal)” setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction:<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Air flow direction (horizontal)” setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction:<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Special” state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates when the air conditioner is in a “special” state.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40, “preheating” state = 0x42, “heat removal” state = 0x43<br>
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
		 * Property name : Thermostat state<br>
		 * <br>
		 * EPC : 0xAC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the state (ON or OFF) of the thermostat.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Thermostat ON = 0x41 Thermostat OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetThermostatState(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Current function (“automatic” operation mode)<br>
		 * <br>
		 * EPC : 0xAE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, when the air conditioner is operating in the “automatic” operation mode, the function (“cooling,” “heating,” “dehumidification,” “air circulator” or “other”) that is currently being used.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Cooling: 0x42<br>
		 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetCurrentFunctionAutomaticOperationMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation mode setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange =<br>
		 * 0x42, automatic control of ventilation<br>
		 * (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br>
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
		protected void onSetVentilationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation mode setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange =<br>
		 * 0x42, automatic control of ventilation<br>
		 * (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br>
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
		protected void onGetVentilationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Combined operation of indoor unit and total heat exchanger<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “combined operation of indoor unit and total heat exchanger” function,  and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Combined operation of indoor unit and total heat exchanger” function used = 0x41<br>
		 * “Combined operation of indoor unit and total heat exchanger” function not used= 0x42<br>
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
		protected void onSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Combined operation of indoor unit and total heat exchanger<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “combined operation of indoor unit and total heat exchanger” function,  and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Combined operation of indoor unit and total heat exchanger” function used = 0x41<br>
		 * “Combined operation of indoor unit and total heat exchanger” function not used= 0x42<br>
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
		protected void onGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire  the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41<br>
		 * Ventilation air flow rate = 0x31 to 0x38<br>
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
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire  the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41<br>
		 * Ventilation air flow rate = 0x31 to 0x38<br>
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
		 * Property name : “Disabling of air conditioner” setting<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Disabled = 0x41, not disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDisablingOfAirConditionerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Disabling of air conditioner” setting<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Disabled = 0x41, not disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDisablingOfAirConditionerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Thermostat setting override function<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Thermostat setting override function<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Filter cleaning reminder lamp setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Enabled = 0x41, disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetFilterCleaningReminderLampSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Filter cleaning reminder lamp setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Enabled = 0x41, disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetFilterCleaningReminderLampSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured power consumption of indoor unit<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured power consumption of the indoor unit.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredPowerConsumptionOfIndoorUnit(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Aperture of expansion valve<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the aperture of the expansion valve in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x64 (0.100%)<br>
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
		protected void onGetApertureOfExpansionValve(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetTemperatureSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetTemperatureSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Relative humidity setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x3E8 (0.0.100.0%)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetRelativeHumiditySettingForDehumidificatioNMode2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Relative humidity setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x3E8 (0.0.100.0%)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRelativeHumiditySettingForDehumidificatioNMode2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 2<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTemperatureSettingForCoolingMode2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 2<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTemperatureSettingForCoolingMode2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTemperatureSettingForHeatingMode2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTemperatureSettingForHeatingMode2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTemperatureSettingForDehumidificatioNMode2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTemperatureSettingForDehumidificatioNMode2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured indoor relative humidity 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor relative humidity.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x3E8 (0.0.100.0%)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredIndoorRelativeHumidity2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured indoor temperature 2<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFD (-273,2.3276,5°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredIndoorTemperature2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “ON
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		 * Property name : “ON
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
		 * Property name : “OFF
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
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
		 * Property name : “OFF
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
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
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOperationModeSetting(byte[] edt) {
			reqSetProperty(EPC_OPERATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetTemperatureSetting1(byte[] edt) {
			reqSetProperty(EPC_TEMPERATURE_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : “Relative
humidity setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetRelativeHumiditySettingForDehumidificaTionMode1(byte[] edt) {
			reqSetProperty(EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1, edt);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 1<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTemperatureSettingForCoolingMode1(byte[] edt) {
			reqSetProperty(EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE1, edt);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 1<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTemperatureSettingForHeatingMode1(byte[] edt) {
			reqSetProperty(EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE1, edt);
			return this;
		}
		/**
		 * Property name : “Temperature
setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTemperatureSettingForDehumidificaTionMode1(byte[] edt) {
			reqSetProperty(EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICA_TION_MODE1, edt);
			return this;
		}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRelativeTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Air flow direction (vertical)” setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction: 0x41.0x49 (0x41 and 0x49 shall be used for the<br>
		 * uppermost and lowermost directions,<br>
		 * respectively.)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAirFlowDirectionVerticalSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Air flow direction (horizontal)” setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction:<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAirFlowDirectionHorizontalSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Ventilation mode setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange =<br>
		 * 0x42, automatic control of ventilation<br>
		 * (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br>
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
		public Setter reqSetVentilationModeSetting(byte[] edt) {
			reqSetProperty(EPC_VENTILATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Combined operation of indoor unit and total heat exchanger<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “combined operation of indoor unit and total heat exchanger” function,  and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Combined operation of indoor unit and total heat exchanger” function used = 0x41<br>
		 * “Combined operation of indoor unit and total heat exchanger” function not used= 0x42<br>
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
		public Setter reqSetCombinedOperationOfIndoorUnitAndTotalHeatExchanger(byte[] edt) {
			reqSetProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER, edt);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire  the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41<br>
		 * Ventilation air flow rate = 0x31 to 0x38<br>
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
			reqSetProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Disabling of air conditioner” setting<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Disabled = 0x41, not disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDisablingOfAirConditionerSetting(byte[] edt) {
			reqSetProperty(EPC_DISABLING_OF_AIR_CONDITIONER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Thermostat setting override function<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt) {
			reqSetProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt);
			return this;
		}
		/**
		 * Property name : Filter cleaning reminder lamp setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Enabled = 0x41, disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetFilterCleaningReminderLampSetting(byte[] edt) {
			reqSetProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetTemperatureSetting2(byte[] edt) {
			reqSetProperty(EPC_TEMPERATURE_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : “Relative humidity setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x3E8 (0.0.100.0%)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetRelativeHumiditySettingForDehumidificatioNMode2(byte[] edt) {
			reqSetProperty(EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2, edt);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 2<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTemperatureSettingForCoolingMode2(byte[] edt) {
			reqSetProperty(EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE2, edt);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTemperatureSettingForHeatingMode2(byte[] edt) {
			reqSetProperty(EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE2, edt);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTemperatureSettingForDehumidificatioNMode2(byte[] edt) {
			reqSetProperty(EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2, edt);
			return this;
		}
		/**
		 * Property name : “ON
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
			reqSetProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqSetProperty(EPC_ON_TIMER_SETTING_TIME, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqSetProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt);
			return this;
		}
		/**
		 * Property name : “OFF
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt) {
			reqSetProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqSetProperty(EPC_OFF_TIMER_SETTING_TIME, edt);
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
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqSetProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt);
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
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOperationModeSetting() {
			reqGetProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetTemperatureSetting1() {
			reqGetProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		/**
		 * Property name : “Relative
humidity setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRelativeHumiditySettingForDehumidificaTionMode1() {
			reqGetProperty(EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 1<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTemperatureSettingForCoolingMode1() {
			reqGetProperty(EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE1);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 1<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTemperatureSettingForHeatingMode1() {
			reqGetProperty(EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE1);
			return this;
		}
		/**
		 * Property name : “Temperature
setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTemperatureSettingForDehumidificaTionMode1() {
			reqGetProperty(EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICA_TION_MODE1);
			return this;
		}
		/**
		 * Property name : Rated power consumption of indoor unit<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * Cooling: heating: dehumidification: air circulator<br>
		 * <br>
		 * Data type : unsigned short × 4<br>
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
		public Getter reqGetRatedPowerConsumptionOfIndoorUnit() {
			reqGetProperty(EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured electric current consumption of indoor unit<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured electric current consumption.<br>
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
		public Getter reqGetMeasuredElectricCurrentConsumptionOfIndoorUnit() {
			reqGetProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured indoor relative humidity 1<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor relative humidity.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredIndoorRelativeHumidity1() {
			reqGetProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1);
			return this;
		}
		/**
		 * Property name : Measured indoor temperature 1<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredIndoorTemperature1() {
			reqGetProperty(EPC_MEASURED_INDOOR_TEMPERATURE1);
			return this;
		}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRelativeTemperatureSetting() {
			reqGetProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAirFlowRateSetting() {
			reqGetProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : “Air flow direction (vertical)” setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction: 0x41.0x49 (0x41 and 0x49 shall be used for the<br>
		 * uppermost and lowermost directions,<br>
		 * respectively.)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAirFlowDirectionVerticalSetting() {
			reqGetProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		/**
		 * Property name : “Air flow direction (horizontal)” setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction:<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAirFlowDirectionHorizontalSetting() {
			reqGetProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		/**
		 * Property name : “Special” state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates when the air conditioner is in a “special” state.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40, “preheating” state = 0x42, “heat removal” state = 0x43<br>
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
			reqGetProperty(EPC_SPECIAL_STATE);
			return this;
		}
		/**
		 * Property name : Thermostat state<br>
		 * <br>
		 * EPC : 0xAC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the state (ON or OFF) of the thermostat.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Thermostat ON = 0x41 Thermostat OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetThermostatState() {
			reqGetProperty(EPC_THERMOSTAT_STATE);
			return this;
		}
		/**
		 * Property name : Current function (“automatic” operation mode)<br>
		 * <br>
		 * EPC : 0xAE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, when the air conditioner is operating in the “automatic” operation mode, the function (“cooling,” “heating,” “dehumidification,” “air circulator” or “other”) that is currently being used.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Cooling: 0x42<br>
		 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetCurrentFunctionAutomaticOperationMode() {
			reqGetProperty(EPC_CURRENT_FUNCTION_AUTOMATIC_OPERATION_MODE);
			return this;
		}
		/**
		 * Property name : Ventilation mode setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange =<br>
		 * 0x42, automatic control of ventilation<br>
		 * (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br>
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
		public Getter reqGetVentilationModeSetting() {
			reqGetProperty(EPC_VENTILATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Combined operation of indoor unit and total heat exchanger<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “combined operation of indoor unit and total heat exchanger” function,  and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Combined operation of indoor unit and total heat exchanger” function used = 0x41<br>
		 * “Combined operation of indoor unit and total heat exchanger” function not used= 0x42<br>
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
		public Getter reqGetCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {
			reqGetProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire  the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41<br>
		 * Ventilation air flow rate = 0x31 to 0x38<br>
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
			reqGetProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : “Disabling of air conditioner” setting<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Disabled = 0x41, not disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDisablingOfAirConditionerSetting() {
			reqGetProperty(EPC_DISABLING_OF_AIR_CONDITIONER_SETTING);
			return this;
		}
		/**
		 * Property name : Thermostat setting override function<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetThermostatSettingOverrideFunction() {
			reqGetProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION);
			return this;
		}
		/**
		 * Property name : Filter cleaning reminder lamp setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Enabled = 0x41, disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetFilterCleaningReminderLampSetting() {
			reqGetProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING);
			return this;
		}
		/**
		 * Property name : Measured power consumption of indoor unit<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured power consumption of the indoor unit.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredPowerConsumptionOfIndoorUnit() {
			reqGetProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Aperture of expansion valve<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the aperture of the expansion valve in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x64 (0.100%)<br>
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
		public Getter reqGetApertureOfExpansionValve() {
			reqGetProperty(EPC_APERTURE_OF_EXPANSION_VALVE);
			return this;
		}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetTemperatureSetting2() {
			reqGetProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		/**
		 * Property name : “Relative humidity setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x3E8 (0.0.100.0%)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRelativeHumiditySettingForDehumidificatioNMode2() {
			reqGetProperty(EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 2<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTemperatureSettingForCoolingMode2() {
			reqGetProperty(EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE2);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTemperatureSettingForHeatingMode2() {
			reqGetProperty(EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE2);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTemperatureSettingForDehumidificatioNMode2() {
			reqGetProperty(EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2);
			return this;
		}
		/**
		 * Property name : Measured indoor relative humidity 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor relative humidity.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x3E8 (0.0.100.0%)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredIndoorRelativeHumidity2() {
			reqGetProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2);
			return this;
		}
		/**
		 * Property name : Measured indoor temperature 2<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFD (-273,2.3276,5°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredIndoorTemperature2() {
			reqGetProperty(EPC_MEASURED_INDOOR_TEMPERATURE2);
			return this;
		}
		/**
		 * Property name : “ON
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
			reqGetProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqGetProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqGetProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : “OFF
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerBasedReservationSetting() {
			reqGetProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqGetProperty(EPC_OFF_TIMER_SETTING_TIME);
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
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqGetProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
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
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification” or “air circulator”) and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41<br>
		 * Cooling: 0x42<br>
		 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOperationModeSetting() {
			reqInformProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformTemperatureSetting1() {
			reqInformProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		/**
		 * Property name : “Relative
humidity setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRelativeHumiditySettingForDehumidificaTionMode1() {
			reqInformProperty(EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICA_TION_MODE1);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 1<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTemperatureSettingForCoolingMode1() {
			reqInformProperty(EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE1);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 1<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTemperatureSettingForHeatingMode1() {
			reqInformProperty(EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE1);
			return this;
		}
		/**
		 * Property name : “Temperature
setting for ‘dehumidifica- tion’ mode” 1<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTemperatureSettingForDehumidificaTionMode1() {
			reqInformProperty(EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICA_TION_MODE1);
			return this;
		}
		/**
		 * Property name : Rated power consumption of indoor unit<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption for the cooling, heating, dehumidification and air circulator modes.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * Cooling: heating: dehumidification: air circulator<br>
		 * <br>
		 * Data type : unsigned short × 4<br>
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
		public Informer reqInformRatedPowerConsumptionOfIndoorUnit() {
			reqInformProperty(EPC_RATED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured electric current consumption of indoor unit<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured electric current consumption.<br>
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
		public Informer reqInformMeasuredElectricCurrentConsumptionOfIndoorUnit() {
			reqInformProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Measured indoor relative humidity 1<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor relative humidity.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredIndoorRelativeHumidity1() {
			reqInformProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY1);
			return this;
		}
		/**
		 * Property name : Measured indoor temperature 1<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredIndoorTemperature1() {
			reqInformProperty(EPC_MEASURED_INDOOR_TEMPERATURE1);
			return this;
		}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRelativeTemperatureSetting() {
			reqInformProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41<br>
		 * Air flow rate = 0x31.0x38<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAirFlowRateSetting() {
			reqInformProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : “Air flow direction (vertical)” setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 9 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction: 0x41.0x49 (0x41 and 0x49 shall be used for the<br>
		 * uppermost and lowermost directions,<br>
		 * respectively.)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAirFlowDirectionVerticalSetting() {
			reqInformProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		/**
		 * Property name : “Air flow direction (horizontal)” setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the air flow direction in the horizontal plane by selecting a pattern from among the 6 predefined patterns or to specify using the automatic air flow direction control function or automatic air flow swing function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x31, swing = 0x32 Air flow direction:<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward<br>
		 * = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAirFlowDirectionHorizontalSetting() {
			reqInformProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		/**
		 * Property name : “Special” state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates when the air conditioner is in a “special” state.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40, “preheating” state = 0x42, “heat removal” state = 0x43<br>
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
			reqInformProperty(EPC_SPECIAL_STATE);
			return this;
		}
		/**
		 * Property name : Thermostat state<br>
		 * <br>
		 * EPC : 0xAC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the state (ON or OFF) of the thermostat.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Thermostat ON = 0x41 Thermostat OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformThermostatState() {
			reqInformProperty(EPC_THERMOSTAT_STATE);
			return this;
		}
		/**
		 * Property name : Current function (“automatic” operation mode)<br>
		 * <br>
		 * EPC : 0xAE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates, when the air conditioner is operating in the “automatic” operation mode, the function (“cooling,” “heating,” “dehumidification,” “air circulator” or “other”) that is currently being used.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Cooling: 0x42<br>
		 * Heating: 0x43 Dehumidification: 0x44 Air circulator: 0x45 Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformCurrentFunctionAutomaticOperationMode() {
			reqInformProperty(EPC_CURRENT_FUNCTION_AUTOMATIC_OPERATION_MODE);
			return this;
		}
		/**
		 * Property name : Ventilation mode setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ordinary ventilation = 0x41, ventilation plus total heat exchanger-based heat exchange =<br>
		 * 0x42, automatic control of ventilation<br>
		 * (i.e. automatic switching between ordinary ventilation and ventilation plus total heat exchanger-based heat exchange) = 0x43<br>
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
		public Informer reqInformVentilationModeSetting() {
			reqInformProperty(EPC_VENTILATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Combined operation of indoor unit and total heat exchanger<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “combined operation of indoor unit and total heat exchanger” function,  and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Combined operation of indoor unit and total heat exchanger” function used = 0x41<br>
		 * “Combined operation of indoor unit and total heat exchanger” function not used= 0x42<br>
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
		public Informer reqInformCombinedOperationOfIndoorUnitAndTotalHeatExchanger() {
			reqInformProperty(EPC_COMBINED_OPERATION_OF_INDOOR_UNIT_AND_TOTAL_HEAT_EXCHANGER);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels and to acquire  the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41<br>
		 * Ventilation air flow rate = 0x31 to 0x38<br>
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
			reqInformProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : “Disabling of air conditioner” setting<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to disable the air conditioner, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Disabled = 0x41, not disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDisablingOfAirConditionerSetting() {
			reqInformProperty(EPC_DISABLING_OF_AIR_CONDITIONER_SETTING);
			return this;
		}
		/**
		 * Property name : Thermostat setting override function<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not the air conditioner shall operate ignoring its thermostat setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformThermostatSettingOverrideFunction() {
			reqInformProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION);
			return this;
		}
		/**
		 * Property name : Filter cleaning reminder lamp setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the filter cleaning reminder lamp, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Enabled = 0x41, disabled = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformFilterCleaningReminderLampSetting() {
			reqInformProperty(EPC_FILTER_CLEANING_REMINDER_LAMP_SETTING);
			return this;
		}
		/**
		 * Property name : Measured power consumption of indoor unit<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured power consumption of the indoor unit.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredPowerConsumptionOfIndoorUnit() {
			reqInformProperty(EPC_MEASURED_POWER_CONSUMPTION_OF_INDOOR_UNIT);
			return this;
		}
		/**
		 * Property name : Aperture of expansion valve<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the aperture of the expansion valve in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x64 (0.100%)<br>
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
		public Informer reqInformApertureOfExpansionValve() {
			reqInformProperty(EPC_APERTURE_OF_EXPANSION_VALVE);
			return this;
		}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformTemperatureSetting2() {
			reqInformProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		/**
		 * Property name : “Relative humidity setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x3E8 (0.0.100.0%)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRelativeHumiditySettingForDehumidificatioNMode2() {
			reqInformProperty(EPC_RELATIVE_HUMIDITY_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘cooling’ mode” 2<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTemperatureSettingForCoolingMode2() {
			reqInformProperty(EPC_TEMPERATURE_SETTING_FOR_COOLING_MODE2);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘heating’ mode” 2<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTemperatureSettingForHeatingMode2() {
			reqInformProperty(EPC_TEMPERATURE_SETTING_FOR_HEATING_MODE2);
			return this;
		}
		/**
		 * Property name : “Temperature setting for ‘dehumidificatio n’ mode” 2<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFE0C.0x3E8 (-50.0.100.0°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTemperatureSettingForDehumidificatioNMode2() {
			reqInformProperty(EPC_TEMPERATURE_SETTING_FOR_DEHUMIDIFICATIO_N_MODE2);
			return this;
		}
		/**
		 * Property name : Measured indoor relative humidity 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor relative humidity.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x3E8 (0.0.100.0%)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1%<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredIndoorRelativeHumidity2() {
			reqInformProperty(EPC_MEASURED_INDOOR_RELATIVE_HUMIDITY2);
			return this;
		}
		/**
		 * Property name : Measured indoor temperature 2<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured indoor temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFD (-273,2.3276,5°C)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredIndoorTemperature2() {
			reqInformProperty(EPC_MEASURED_INDOOR_TEMPERATURE2);
			return this;
		}
		/**
		 * Property name : “ON
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
			reqInformProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqInformProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqInformProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : “OFF
timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerBasedReservationSetting() {
			reqInformProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the<br>
		 * time-based reservation function in the HH:MM format and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqInformProperty(EPC_OFF_TIMER_SETTING_TIME);
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
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char×2<br>
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
			reqInformProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
	}

	public static class Proxy extends PackageTypeCommercialAirConditionerIndoorUnit {
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
		protected boolean setOperationStatus(byte[] edt) {return false;}
		@Override
		protected boolean setOperationModeSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getOperationModeSetting() {return null;}
		@Override
		protected boolean setTemperatureSetting1(byte[] edt) {return false;}
		@Override
		protected byte[] getTemperatureSetting1() {return null;}
		@Override
		protected boolean setTemperatureSetting2(byte[] edt) {return false;}
		@Override
		protected byte[] getTemperatureSetting2() {return null;}
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
