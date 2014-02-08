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

public abstract class ElectricWaterHeater extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x026B;

	public static final byte EPC_AUTOMATIC_WATER_HEATING_SETTING = (byte)0xB0;
	public static final byte EPC_AUTOMATIC_WATER_TEMPERATURE_CONTROL_SETTING = (byte)0xB1;
	public static final byte EPC_WATER_HEATER_STATUS = (byte)0xB2;
	public static final byte EPC_WATER_HEATING_TEMPERATURE_SETTING = (byte)0xB3;
	public static final byte EPC_DAYTIME_REHEATING_PERMISSION_SETTING = (byte)0xC0;
	public static final byte EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER = (byte)0xC1;
	public static final byte EPC_ALARM_STATUS = (byte)0xC2;
	public static final byte EPC_TEMPERATURE_OF_SUPPLIED_WATER_SETTING = (byte)0xD1;
	public static final byte EPC_BATH_WATER_TEMPERATURE_SETTING = (byte)0xD3;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING = (byte)0xE0;
	public static final byte EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK = (byte)0xE1;
	public static final byte EPC_TANK_CAPACITY = (byte)0xE2;
	public static final byte EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING = (byte)0xE3;
	public static final byte EPC_ADDITION_OF_HOT_WATER_FUNCTION_SETTING = (byte)0xE5;
	public static final byte EPC_SLIGHT_BATH_WATER_TEMPERATURE_LOWERING_FUNCTION_SETTING = (byte)0xE6;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING1 = (byte)0xE7;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING2 = (byte)0xE8;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING3 = (byte)0xEE;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING4 = (byte)0xD4;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING4_MAXIMUM_SETTABLE_LEVEL = (byte)0xD5;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	public static final byte EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME = (byte)0xDB;
	public static final byte EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS = (byte)0xDC;
	public static final byte EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME = (byte)0xDD;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_AUTOMATIC_WATER_HEATING_SETTING);
		addGetProperty(EPC_AUTOMATIC_WATER_HEATING_SETTING);
		addSetProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
		addGetProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
		addStatusChangeAnnouncementProperty(EPC_ALARM_STATUS);
		addSetProperty(EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING);
		addGetProperty(EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewElectricWaterHeater(this);
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
	 * Property name : “Automatic water heating” setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic water heating function used: 0x41<br>
	 * Non-automatic water heating function stopped: 0x43<br>
	 * Non-automatic water heating function used: 0x42<br>
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
	protected abstract boolean setAutomaticWaterHeatingSetting(byte[] edt);
	/**
	 * Property name : “Automatic water heating” setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic water heating function used: 0x41<br>
	 * Non-automatic water heating function stopped: 0x43<br>
	 * Non-automatic water heating function used: 0x42<br>
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
	protected abstract byte[] getAutomaticWaterHeatingSetting();
	/**
	 * Property name : “Automatic water heating” setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic water heating function used: 0x41<br>
	 * Non-automatic water heating function stopped: 0x43<br>
	 * Non-automatic water heating function used: 0x42<br>
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
	protected boolean isValidAutomaticWaterHeatingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Automatic water temperature control” setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic water temperature control function used: 0x41<br>
	 * Automatic water temperature control function not used: 0x42<br>
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
	protected boolean setAutomaticWaterTemperatureControlSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Automatic water temperature control” setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic water temperature control function used: 0x41<br>
	 * Automatic water temperature control function not used: 0x42<br>
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
	protected byte[] getAutomaticWaterTemperatureControlSetting() {return null;}
	/**
	 * Property name : “Automatic water temperature control” setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic water temperature control function used: 0x41<br>
	 * Automatic water temperature control function not used: 0x42<br>
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
	protected boolean isValidAutomaticWaterTemperatureControlSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Water heater status<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>
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
	 * Get - optional<br>
	 */
	protected byte[] getWaterHeaterStatus() {return null;}
	/**
	 * Property name : Water heater status<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>
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
	 * Get - optional<br>
	 */
	protected boolean isValidWaterHeaterStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Water heating temperature setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in °C) the temperature of heated water to achieve, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setWaterHeatingTemperatureSetting(byte[] edt);
	/**
	 * Property name : Water heating temperature setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in °C) the temperature of heated water to achieve, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getWaterHeatingTemperatureSetting();
	/**
	 * Property name : Water heating temperature setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in °C) the temperature of heated water to achieve, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidWaterHeatingTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Daytime reheating permission” setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br>
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
	protected boolean setDaytimeReheatingPermissionSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Daytime reheating permission” setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br>
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
	protected byte[] getDaytimeReheatingPermissionSetting() {return null;}
	/**
	 * Property name : “Daytime reheating permission” setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br>
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
	protected boolean isValidDaytimeReheatingPermissionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured temperature of water in water heater<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the current temperature of the water in the water heater.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredTemperatureOfWaterInWaterHeater() {return null;}
	/**
	 * Property name : Measured temperature of water in water heater<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the current temperature of the water in the water heater.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredTemperatureOfWaterInWaterHeater(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Alarm status<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the status of an alarm.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte:<br>
	 * Bit 0: Out of hot water<br>
	 * 0 Normal<br>
	 * 1 Alarm Bit 1: Water leaking<br>
	 * 0 Normal<br>
	 * 1 Alarm Bit 2: Water frozen<br>
	 * 0 Normal<br>
	 * 1 Alarm<br>
	 * Bits 3-7: reserved for future use<br>
	 * 2-4 bytes:<br>
	 * reserved for future use<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getAlarmStatus() {return null;}
	/**
	 * Property name : Alarm status<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the status of an alarm.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte:<br>
	 * Bit 0: Out of hot water<br>
	 * 0 Normal<br>
	 * 1 Alarm Bit 1: Water leaking<br>
	 * 0 Normal<br>
	 * 1 Alarm Bit 2: Water frozen<br>
	 * 0 Normal<br>
	 * 1 Alarm<br>
	 * Bits 3-7: reserved for future use<br>
	 * 2-4 bytes:<br>
	 * reserved for future use<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidAlarmStatus(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : “Temperature of supplied water” setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of water supplied from the water heater in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
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
	protected boolean setTemperatureOfSuppliedWaterSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Temperature of supplied water” setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of water supplied from the water heater in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
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
	protected byte[] getTemperatureOfSuppliedWaterSetting() {return null;}
	/**
	 * Property name : “Temperature of supplied water” setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of water supplied from the water heater in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
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
	protected boolean isValidTemperatureOfSuppliedWaterSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water temperature setting<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in °C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
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
	protected boolean setBathWaterTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bath water temperature setting<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in °C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
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
	protected byte[] getBathWaterTemperatureSetting() {return null;}
	/**
	 * Property name : Bath water temperature setting<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in °C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
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
	protected boolean isValidBathWaterTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water volume setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
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
	protected boolean setBathWaterVolumeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bath water volume setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
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
	protected byte[] getBathWaterVolumeSetting() {return null;}
	/**
	 * Property name : Bath water volume setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
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
	protected boolean isValidBathWaterVolumeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured amount of water remaining in tank<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured amount of water left in the tank in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredAmountOfWaterRemainingInTank() {return null;}
	/**
	 * Property name : Measured amount of water remaining in tank<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured amount of water left in the tank in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredAmountOfWaterRemainingInTank(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Tank capacity<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the tank capacity in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getTankCapacity() {return null;}
	/**
	 * Property name : Tank capacity<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the tank capacity in liters.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTankCapacity(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : “Automatic bath water heating” mode setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “automatic bath water heating” mode, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Automatic bath water heating” mode ON = 0x41<br>
	 * “Automatic bath water heating” mode OFF = 0x42<br>
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
	protected abstract boolean setAutomaticBathWaterHeatingModeSetting(byte[] edt);
	/**
	 * Property name : “Automatic bath water heating” mode setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “automatic bath water heating” mode, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Automatic bath water heating” mode ON = 0x41<br>
	 * “Automatic bath water heating” mode OFF = 0x42<br>
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
	protected abstract byte[] getAutomaticBathWaterHeatingModeSetting();
	/**
	 * Property name : “Automatic bath water heating” mode setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “automatic bath water heating” mode, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Automatic bath water heating” mode ON = 0x41<br>
	 * “Automatic bath water heating” mode OFF = 0x42<br>
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
	protected boolean isValidAutomaticBathWaterHeatingModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Addition of hot water” function setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Addition of hot water” function ON = 0x41<br>
	 * “Addition of hot water” function OFF<br>
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
	protected boolean setAdditionOfHotWaterFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Addition of hot water” function setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Addition of hot water” function ON = 0x41<br>
	 * “Addition of hot water” function OFF<br>
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
	protected byte[] getAdditionOfHotWaterFunctionSetting() {return null;}
	/**
	 * Property name : “Addition of hot water” function setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Addition of hot water” function ON = 0x41<br>
	 * “Addition of hot water” function OFF<br>
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
	protected boolean isValidAdditionOfHotWaterFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Slight bath water temperature lowering” function setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “slight bath water temperature lowering” function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Slight bath water temperature lowering” function ON = 0x41<br>
	 * “Slight bath water temperature lowering” function OFF = 0x42<br>
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
	protected boolean setSlightBathWaterTemperatureLoweringFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Slight bath water temperature lowering” function setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “slight bath water temperature lowering” function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Slight bath water temperature lowering” function ON = 0x41<br>
	 * “Slight bath water temperature lowering” function OFF = 0x42<br>
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
	protected byte[] getSlightBathWaterTemperatureLoweringFunctionSetting() {return null;}
	/**
	 * Property name : “Slight bath water temperature lowering” function setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “slight bath water temperature lowering” function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Slight bath water temperature lowering” function ON = 0x41<br>
	 * “Slight bath water temperature lowering” function OFF = 0x42<br>
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
	protected boolean isValidSlightBathWaterTemperatureLoweringFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water volume setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xFD (0.253 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathWaterVolumeSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Bath water volume setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xFD (0.253 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathWaterVolumeSetting1() {return null;}
	/**
	 * Property name : Bath water volume setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0xFD (0.253 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathWaterVolumeSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water volume setting 2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
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
	protected boolean setBathWaterVolumeSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Bath water volume setting 2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
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
	protected byte[] getBathWaterVolumeSetting2() {return null;}
	/**
	 * Property name : Bath water volume setting 2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
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
	protected boolean isValidBathWaterVolumeSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water volume setting 3<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533 liters)<br>
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
	protected boolean setBathWaterVolumeSetting3(byte[] edt) {return false;}
	/**
	 * Property name : Bath water volume setting 3<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533 liters)<br>
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
	protected byte[] getBathWaterVolumeSetting3() {return null;}
	/**
	 * Property name : Bath water volume setting 3<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533 liters)<br>
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
	protected boolean isValidBathWaterVolumeSetting3(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Bath water volume setting 4<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * ￼<br>
	 * The bath hot water volume is specified by the number of steps.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01-0xFF<br>
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
	protected boolean setBathWaterVolumeSetting4(byte[] edt) {return false;}
	/**
	 * Property name : Bath water volume setting 4<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * ￼<br>
	 * The bath hot water volume is specified by the number of steps.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01-0xFF<br>
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
	protected byte[] getBathWaterVolumeSetting4() {return null;}
	/**
	 * Property name : Bath water volume setting 4<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * ￼<br>
	 * The bath hot water volume is specified by the number of steps.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01-0xFF<br>
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
	protected boolean isValidBathWaterVolumeSetting4(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water volume setting 4- Maximum settable level<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * ￼<br>
	 * The maximum settable level is the top step of Bath water volume setting 4.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01-0xFF<br>
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
	protected byte[] getBathWaterVolumeSetting4MaximumSettableLevel() {return null;}
	/**
	 * Property name : Bath water volume setting 4- Maximum settable level<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * ￼<br>
	 * The maximum settable level is the top step of Bath water volume setting 4.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01-0xFF<br>
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
	protected boolean isValidBathWaterVolumeSetting4MaximumSettableLevel(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
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
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
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
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
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
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * ON timer setting (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
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
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * ON timer setting (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
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
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * ON timer setting (HH:MM)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
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
	protected boolean isValidOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Rated power consumption of H/P unit in wintertime<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power consumption of the heat pump in wintertime (December to March)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD(0.65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedPowerConsumptionOfHPUnitInWintertime() {return null;}
	/**
	 * Property name : Rated power consumption of H/P unit in wintertime<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power consumption of the heat pump in wintertime (December to March)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD(0.65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedPowerConsumptionOfHPUnitInWintertime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Rated power consumption of H/P unit in
in-between seasons<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power consumption of the heat pump in<br>
	 * in-between seasons (April, May, October, November)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD(0.65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {return null;}
	/**
	 * Property name : Rated power consumption of H/P unit in
in-between seasons<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power consumption of the heat pump in<br>
	 * in-between seasons (April, May, October, November)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD(0.65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedPowerConsumptionOfHPUnitInInBetweenSeasons(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Rated power consumption of H/P unit in summertime<br>
	 * <br>
	 * EPC : 0xDD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD(0.65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedPowerConsumptionOfHPUnitInSummertime() {return null;}
	/**
	 * Property name : Rated power consumption of H/P unit in summertime<br>
	 * <br>
	 * EPC : 0xDD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD(0.65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedPowerConsumptionOfHPUnitInSummertime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_AUTOMATIC_WATER_HEATING_SETTING : return setAutomaticWaterHeatingSetting(property.edt);
		case EPC_AUTOMATIC_WATER_TEMPERATURE_CONTROL_SETTING : return setAutomaticWaterTemperatureControlSetting(property.edt);
		case EPC_WATER_HEATING_TEMPERATURE_SETTING : return setWaterHeatingTemperatureSetting(property.edt);
		case EPC_DAYTIME_REHEATING_PERMISSION_SETTING : return setDaytimeReheatingPermissionSetting(property.edt);
		case EPC_TEMPERATURE_OF_SUPPLIED_WATER_SETTING : return setTemperatureOfSuppliedWaterSetting(property.edt);
		case EPC_BATH_WATER_TEMPERATURE_SETTING : return setBathWaterTemperatureSetting(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING : return setBathWaterVolumeSetting(property.edt);
		case EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING : return setAutomaticBathWaterHeatingModeSetting(property.edt);
		case EPC_ADDITION_OF_HOT_WATER_FUNCTION_SETTING : return setAdditionOfHotWaterFunctionSetting(property.edt);
		case EPC_SLIGHT_BATH_WATER_TEMPERATURE_LOWERING_FUNCTION_SETTING : return setSlightBathWaterTemperatureLoweringFunctionSetting(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING1 : return setBathWaterVolumeSetting1(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING2 : return setBathWaterVolumeSetting2(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING3 : return setBathWaterVolumeSetting3(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING4 : return setBathWaterVolumeSetting4(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return setOnTimerSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_AUTOMATIC_WATER_HEATING_SETTING : return getAutomaticWaterHeatingSetting();
		case EPC_AUTOMATIC_WATER_TEMPERATURE_CONTROL_SETTING : return getAutomaticWaterTemperatureControlSetting();
		case EPC_WATER_HEATER_STATUS : return getWaterHeaterStatus();
		case EPC_WATER_HEATING_TEMPERATURE_SETTING : return getWaterHeatingTemperatureSetting();
		case EPC_DAYTIME_REHEATING_PERMISSION_SETTING : return getDaytimeReheatingPermissionSetting();
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : return getMeasuredTemperatureOfWaterInWaterHeater();
		case EPC_ALARM_STATUS : return getAlarmStatus();
		case EPC_TEMPERATURE_OF_SUPPLIED_WATER_SETTING : return getTemperatureOfSuppliedWaterSetting();
		case EPC_BATH_WATER_TEMPERATURE_SETTING : return getBathWaterTemperatureSetting();
		case EPC_BATH_WATER_VOLUME_SETTING : return getBathWaterVolumeSetting();
		case EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK : return getMeasuredAmountOfWaterRemainingInTank();
		case EPC_TANK_CAPACITY : return getTankCapacity();
		case EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING : return getAutomaticBathWaterHeatingModeSetting();
		case EPC_ADDITION_OF_HOT_WATER_FUNCTION_SETTING : return getAdditionOfHotWaterFunctionSetting();
		case EPC_SLIGHT_BATH_WATER_TEMPERATURE_LOWERING_FUNCTION_SETTING : return getSlightBathWaterTemperatureLoweringFunctionSetting();
		case EPC_BATH_WATER_VOLUME_SETTING1 : return getBathWaterVolumeSetting1();
		case EPC_BATH_WATER_VOLUME_SETTING2 : return getBathWaterVolumeSetting2();
		case EPC_BATH_WATER_VOLUME_SETTING3 : return getBathWaterVolumeSetting3();
		case EPC_BATH_WATER_VOLUME_SETTING4 : return getBathWaterVolumeSetting4();
		case EPC_BATH_WATER_VOLUME_SETTING4_MAXIMUM_SETTABLE_LEVEL : return getBathWaterVolumeSetting4MaximumSettableLevel();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_ON_TIMER_SETTING : return getOnTimerSetting();
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME : return getRatedPowerConsumptionOfHPUnitInWintertime();
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS : return getRatedPowerConsumptionOfHPUnitInInBetweenSeasons();
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME : return getRatedPowerConsumptionOfHPUnitInSummertime();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_AUTOMATIC_WATER_HEATING_SETTING : return isValidAutomaticWaterHeatingSetting(property.edt);
		case EPC_AUTOMATIC_WATER_TEMPERATURE_CONTROL_SETTING : return isValidAutomaticWaterTemperatureControlSetting(property.edt);
		case EPC_WATER_HEATER_STATUS : return isValidWaterHeaterStatus(property.edt);
		case EPC_WATER_HEATING_TEMPERATURE_SETTING : return isValidWaterHeatingTemperatureSetting(property.edt);
		case EPC_DAYTIME_REHEATING_PERMISSION_SETTING : return isValidDaytimeReheatingPermissionSetting(property.edt);
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : return isValidMeasuredTemperatureOfWaterInWaterHeater(property.edt);
		case EPC_ALARM_STATUS : return isValidAlarmStatus(property.edt);
		case EPC_TEMPERATURE_OF_SUPPLIED_WATER_SETTING : return isValidTemperatureOfSuppliedWaterSetting(property.edt);
		case EPC_BATH_WATER_TEMPERATURE_SETTING : return isValidBathWaterTemperatureSetting(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING : return isValidBathWaterVolumeSetting(property.edt);
		case EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK : return isValidMeasuredAmountOfWaterRemainingInTank(property.edt);
		case EPC_TANK_CAPACITY : return isValidTankCapacity(property.edt);
		case EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING : return isValidAutomaticBathWaterHeatingModeSetting(property.edt);
		case EPC_ADDITION_OF_HOT_WATER_FUNCTION_SETTING : return isValidAdditionOfHotWaterFunctionSetting(property.edt);
		case EPC_SLIGHT_BATH_WATER_TEMPERATURE_LOWERING_FUNCTION_SETTING : return isValidSlightBathWaterTemperatureLoweringFunctionSetting(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING1 : return isValidBathWaterVolumeSetting1(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING2 : return isValidBathWaterVolumeSetting2(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING3 : return isValidBathWaterVolumeSetting3(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING4 : return isValidBathWaterVolumeSetting4(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING4_MAXIMUM_SETTABLE_LEVEL : return isValidBathWaterVolumeSetting4MaximumSettableLevel(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return isValidOnTimerSetting(property.edt);
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME : return isValidRatedPowerConsumptionOfHPUnitInWintertime(property.edt);
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS : return isValidRatedPowerConsumptionOfHPUnitInInBetweenSeasons(property.edt);
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME : return isValidRatedPowerConsumptionOfHPUnitInSummertime(property.edt);
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
			case EPC_AUTOMATIC_WATER_HEATING_SETTING : 
				onSetAutomaticWaterHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_WATER_TEMPERATURE_CONTROL_SETTING : 
				onSetAutomaticWaterTemperatureControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_HEATING_TEMPERATURE_SETTING : 
				onSetWaterHeatingTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DAYTIME_REHEATING_PERMISSION_SETTING : 
				onSetDaytimeReheatingPermissionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_OF_SUPPLIED_WATER_SETTING : 
				onSetTemperatureOfSuppliedWaterSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_TEMPERATURE_SETTING : 
				onSetBathWaterTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING : 
				onSetBathWaterVolumeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING : 
				onSetAutomaticBathWaterHeatingModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ADDITION_OF_HOT_WATER_FUNCTION_SETTING : 
				onSetAdditionOfHotWaterFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SLIGHT_BATH_WATER_TEMPERATURE_LOWERING_FUNCTION_SETTING : 
				onSetSlightBathWaterTemperatureLoweringFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING1 : 
				onSetBathWaterVolumeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING2 : 
				onSetBathWaterVolumeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING3 : 
				onSetBathWaterVolumeSetting3(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING4 : 
				onSetBathWaterVolumeSetting4(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onSetOnTimerSetting(eoj, tid, esv, property, success);
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
			case EPC_AUTOMATIC_WATER_HEATING_SETTING : 
				onGetAutomaticWaterHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_WATER_TEMPERATURE_CONTROL_SETTING : 
				onGetAutomaticWaterTemperatureControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_HEATER_STATUS : 
				onGetWaterHeaterStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_HEATING_TEMPERATURE_SETTING : 
				onGetWaterHeatingTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DAYTIME_REHEATING_PERMISSION_SETTING : 
				onGetDaytimeReheatingPermissionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : 
				onGetMeasuredTemperatureOfWaterInWaterHeater(eoj, tid, esv, property, success);
				return true;
			case EPC_ALARM_STATUS : 
				onGetAlarmStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_OF_SUPPLIED_WATER_SETTING : 
				onGetTemperatureOfSuppliedWaterSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_TEMPERATURE_SETTING : 
				onGetBathWaterTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING : 
				onGetBathWaterVolumeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK : 
				onGetMeasuredAmountOfWaterRemainingInTank(eoj, tid, esv, property, success);
				return true;
			case EPC_TANK_CAPACITY : 
				onGetTankCapacity(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING : 
				onGetAutomaticBathWaterHeatingModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ADDITION_OF_HOT_WATER_FUNCTION_SETTING : 
				onGetAdditionOfHotWaterFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SLIGHT_BATH_WATER_TEMPERATURE_LOWERING_FUNCTION_SETTING : 
				onGetSlightBathWaterTemperatureLoweringFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING1 : 
				onGetBathWaterVolumeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING2 : 
				onGetBathWaterVolumeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING3 : 
				onGetBathWaterVolumeSetting3(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING4 : 
				onGetBathWaterVolumeSetting4(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING4_MAXIMUM_SETTABLE_LEVEL : 
				onGetBathWaterVolumeSetting4MaximumSettableLevel(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onGetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME : 
				onGetRatedPowerConsumptionOfHPUnitInWintertime(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS : 
				onGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME : 
				onGetRatedPowerConsumptionOfHPUnitInSummertime(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : “Automatic water heating” setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water heating function used: 0x41<br>
		 * Non-automatic water heating function stopped: 0x43<br>
		 * Non-automatic water heating function used: 0x42<br>
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
		protected void onSetAutomaticWaterHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Automatic water heating” setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water heating function used: 0x41<br>
		 * Non-automatic water heating function stopped: 0x43<br>
		 * Non-automatic water heating function used: 0x42<br>
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
		protected void onGetAutomaticWaterHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Automatic water temperature control” setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water temperature control function used: 0x41<br>
		 * Automatic water temperature control function not used: 0x42<br>
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
		protected void onSetAutomaticWaterTemperatureControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Automatic water temperature control” setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water temperature control function used: 0x41<br>
		 * Automatic water temperature control function not used: 0x42<br>
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
		protected void onGetAutomaticWaterTemperatureControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water heater status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>
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
		 * Get - optional<br>
		 */
		protected void onGetWaterHeaterStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Daytime reheating permission” setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br>
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
		protected void onSetDaytimeReheatingPermissionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Daytime reheating permission” setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br>
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
		protected void onGetDaytimeReheatingPermissionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Alarm status<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the status of an alarm.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte:<br>
		 * Bit 0: Out of hot water<br>
		 * 0 Normal<br>
		 * 1 Alarm Bit 1: Water leaking<br>
		 * 0 Normal<br>
		 * 1 Alarm Bit 2: Water frozen<br>
		 * 0 Normal<br>
		 * 1 Alarm<br>
		 * Bits 3-7: reserved for future use<br>
		 * 2-4 bytes:<br>
		 * reserved for future use<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetAlarmStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature of supplied water” setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		protected void onSetTemperatureOfSuppliedWaterSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Temperature of supplied water” setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		protected void onGetTemperatureOfSuppliedWaterSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		protected void onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		protected void onGetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
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
		protected void onSetBathWaterVolumeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
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
		protected void onGetBathWaterVolumeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured amount of water remaining in tank<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured amount of water left in the tank in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredAmountOfWaterRemainingInTank(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Tank capacity<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the tank capacity in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetTankCapacity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Automatic bath water heating” mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “automatic bath water heating” mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Automatic bath water heating” mode ON = 0x41<br>
		 * “Automatic bath water heating” mode OFF = 0x42<br>
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
		protected void onSetAutomaticBathWaterHeatingModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Automatic bath water heating” mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “automatic bath water heating” mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Automatic bath water heating” mode ON = 0x41<br>
		 * “Automatic bath water heating” mode OFF = 0x42<br>
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
		protected void onGetAutomaticBathWaterHeatingModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Addition of hot water” function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Addition of hot water” function ON = 0x41<br>
		 * “Addition of hot water” function OFF<br>
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
		protected void onSetAdditionOfHotWaterFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Addition of hot water” function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Addition of hot water” function ON = 0x41<br>
		 * “Addition of hot water” function OFF<br>
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
		protected void onGetAdditionOfHotWaterFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Slight bath water temperature lowering” function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “slight bath water temperature lowering” function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Slight bath water temperature lowering” function ON = 0x41<br>
		 * “Slight bath water temperature lowering” function OFF = 0x42<br>
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
		protected void onSetSlightBathWaterTemperatureLoweringFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Slight bath water temperature lowering” function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “slight bath water temperature lowering” function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Slight bath water temperature lowering” function ON = 0x41<br>
		 * “Slight bath water temperature lowering” function OFF = 0x42<br>
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
		protected void onGetSlightBathWaterTemperatureLoweringFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
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
		protected void onSetBathWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
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
		protected void onGetBathWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
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
		protected void onSetBathWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
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
		protected void onGetBathWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 4<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * ￼<br>
		 * The bath hot water volume is specified by the number of steps.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01-0xFF<br>
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
		protected void onSetBathWaterVolumeSetting4(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 4<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * ￼<br>
		 * The bath hot water volume is specified by the number of steps.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01-0xFF<br>
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
		protected void onGetBathWaterVolumeSetting4(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 4- Maximum settable level<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * ￼<br>
		 * The maximum settable level is the top step of Bath water volume setting 4.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01-0xFF<br>
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
		protected void onGetBathWaterVolumeSetting4MaximumSettableLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
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
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * ON timer setting (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
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
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * ON timer setting (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
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
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power consumption of H/P unit in wintertime<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to March)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedPowerConsumptionOfHPUnitInWintertime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power consumption of H/P unit in
in-between seasons<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in<br>
		 * in-between seasons (April, May, October, November)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power consumption of H/P unit in summertime<br>
		 * <br>
		 * EPC : 0xDD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedPowerConsumptionOfHPUnitInSummertime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : “Automatic water heating” setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water heating function used: 0x41<br>
		 * Non-automatic water heating function stopped: 0x43<br>
		 * Non-automatic water heating function used: 0x42<br>
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
		public Setter reqSetAutomaticWaterHeatingSetting(byte[] edt) {
			reqSetProperty(EPC_AUTOMATIC_WATER_HEATING_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Automatic water temperature control” setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water temperature control function used: 0x41<br>
		 * Automatic water temperature control function not used: 0x42<br>
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
		public Setter reqSetAutomaticWaterTemperatureControlSetting(byte[] edt) {
			reqSetProperty(EPC_AUTOMATIC_WATER_TEMPERATURE_CONTROL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetWaterHeatingTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Daytime reheating permission” setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br>
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
		public Setter reqSetDaytimeReheatingPermissionSetting(byte[] edt) {
			reqSetProperty(EPC_DAYTIME_REHEATING_PERMISSION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Temperature of supplied water” setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		public Setter reqSetTemperatureOfSuppliedWaterSetting(byte[] edt) {
			reqSetProperty(EPC_TEMPERATURE_OF_SUPPLIED_WATER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_BATH_WATER_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath water volume setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
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
		public Setter reqSetBathWaterVolumeSetting(byte[] edt) {
			reqSetProperty(EPC_BATH_WATER_VOLUME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Automatic bath water heating” mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “automatic bath water heating” mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Automatic bath water heating” mode ON = 0x41<br>
		 * “Automatic bath water heating” mode OFF = 0x42<br>
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
		public Setter reqSetAutomaticBathWaterHeatingModeSetting(byte[] edt) {
			reqSetProperty(EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Addition of hot water” function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Addition of hot water” function ON = 0x41<br>
		 * “Addition of hot water” function OFF<br>
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
		public Setter reqSetAdditionOfHotWaterFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_ADDITION_OF_HOT_WATER_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Slight bath water temperature lowering” function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “slight bath water temperature lowering” function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Slight bath water temperature lowering” function ON = 0x41<br>
		 * “Slight bath water temperature lowering” function OFF = 0x42<br>
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
		public Setter reqSetSlightBathWaterTemperatureLoweringFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_SLIGHT_BATH_WATER_TEMPERATURE_LOWERING_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathWaterVolumeSetting1(byte[] edt) {
			reqSetProperty(EPC_BATH_WATER_VOLUME_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
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
		public Setter reqSetBathWaterVolumeSetting2(byte[] edt) {
			reqSetProperty(EPC_BATH_WATER_VOLUME_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
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
		public Setter reqSetBathWaterVolumeSetting3(byte[] edt) {
			reqSetProperty(EPC_BATH_WATER_VOLUME_SETTING3, edt);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 4<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * ￼<br>
		 * The bath hot water volume is specified by the number of steps.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01-0xFF<br>
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
		public Setter reqSetBathWaterVolumeSetting4(byte[] edt) {
			reqSetProperty(EPC_BATH_WATER_VOLUME_SETTING4, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
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
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * ON timer setting (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
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
		public Setter reqSetOnTimerSetting(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_SETTING, edt);
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
		 * Property name : “Automatic water heating” setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water heating function used: 0x41<br>
		 * Non-automatic water heating function stopped: 0x43<br>
		 * Non-automatic water heating function used: 0x42<br>
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
		public Getter reqGetAutomaticWaterHeatingSetting() {
			reqGetProperty(EPC_AUTOMATIC_WATER_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : “Automatic water temperature control” setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water temperature control function used: 0x41<br>
		 * Automatic water temperature control function not used: 0x42<br>
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
		public Getter reqGetAutomaticWaterTemperatureControlSetting() {
			reqGetProperty(EPC_AUTOMATIC_WATER_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Water heater status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>
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
		 * Get - optional<br>
		 */
		public Getter reqGetWaterHeaterStatus() {
			reqGetProperty(EPC_WATER_HEATER_STATUS);
			return this;
		}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetWaterHeatingTemperatureSetting() {
			reqGetProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : “Daytime reheating permission” setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br>
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
		public Getter reqGetDaytimeReheatingPermissionSetting() {
			reqGetProperty(EPC_DAYTIME_REHEATING_PERMISSION_SETTING);
			return this;
		}
		/**
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			reqGetProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		/**
		 * Property name : Alarm status<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the status of an alarm.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte:<br>
		 * Bit 0: Out of hot water<br>
		 * 0 Normal<br>
		 * 1 Alarm Bit 1: Water leaking<br>
		 * 0 Normal<br>
		 * 1 Alarm Bit 2: Water frozen<br>
		 * 0 Normal<br>
		 * 1 Alarm<br>
		 * Bits 3-7: reserved for future use<br>
		 * 2-4 bytes:<br>
		 * reserved for future use<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetAlarmStatus() {
			reqGetProperty(EPC_ALARM_STATUS);
			return this;
		}
		/**
		 * Property name : “Temperature of supplied water” setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		public Getter reqGetTemperatureOfSuppliedWaterSetting() {
			reqGetProperty(EPC_TEMPERATURE_OF_SUPPLIED_WATER_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		public Getter reqGetBathWaterTemperatureSetting() {
			reqGetProperty(EPC_BATH_WATER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water volume setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
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
		public Getter reqGetBathWaterVolumeSetting() {
			reqGetProperty(EPC_BATH_WATER_VOLUME_SETTING);
			return this;
		}
		/**
		 * Property name : Measured amount of water remaining in tank<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured amount of water left in the tank in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredAmountOfWaterRemainingInTank() {
			reqGetProperty(EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK);
			return this;
		}
		/**
		 * Property name : Tank capacity<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the tank capacity in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTankCapacity() {
			reqGetProperty(EPC_TANK_CAPACITY);
			return this;
		}
		/**
		 * Property name : “Automatic bath water heating” mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “automatic bath water heating” mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Automatic bath water heating” mode ON = 0x41<br>
		 * “Automatic bath water heating” mode OFF = 0x42<br>
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
		public Getter reqGetAutomaticBathWaterHeatingModeSetting() {
			reqGetProperty(EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : “Addition of hot water” function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Addition of hot water” function ON = 0x41<br>
		 * “Addition of hot water” function OFF<br>
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
		public Getter reqGetAdditionOfHotWaterFunctionSetting() {
			reqGetProperty(EPC_ADDITION_OF_HOT_WATER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : “Slight bath water temperature lowering” function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “slight bath water temperature lowering” function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Slight bath water temperature lowering” function ON = 0x41<br>
		 * “Slight bath water temperature lowering” function OFF = 0x42<br>
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
		public Getter reqGetSlightBathWaterTemperatureLoweringFunctionSetting() {
			reqGetProperty(EPC_SLIGHT_BATH_WATER_TEMPERATURE_LOWERING_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathWaterVolumeSetting1() {
			reqGetProperty(EPC_BATH_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
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
		public Getter reqGetBathWaterVolumeSetting2() {
			reqGetProperty(EPC_BATH_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
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
		public Getter reqGetBathWaterVolumeSetting3() {
			reqGetProperty(EPC_BATH_WATER_VOLUME_SETTING3);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 4<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * ￼<br>
		 * The bath hot water volume is specified by the number of steps.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01-0xFF<br>
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
		public Getter reqGetBathWaterVolumeSetting4() {
			reqGetProperty(EPC_BATH_WATER_VOLUME_SETTING4);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 4- Maximum settable level<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * ￼<br>
		 * The maximum settable level is the top step of Bath water volume setting 4.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01-0xFF<br>
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
		public Getter reqGetBathWaterVolumeSetting4MaximumSettableLevel() {
			reqGetProperty(EPC_BATH_WATER_VOLUME_SETTING4_MAXIMUM_SETTABLE_LEVEL);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
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
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * ON timer setting (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
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
		public Getter reqGetOnTimerSetting() {
			reqGetProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Rated power consumption of H/P unit in wintertime<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to March)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInWintertime() {
			reqGetProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME);
			return this;
		}
		/**
		 * Property name : Rated power consumption of H/P unit in
in-between seasons<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in<br>
		 * in-between seasons (April, May, October, November)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			reqGetProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS);
			return this;
		}
		/**
		 * Property name : Rated power consumption of H/P unit in summertime<br>
		 * <br>
		 * EPC : 0xDD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInSummertime() {
			reqGetProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME);
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
		 * Property name : “Automatic water heating” setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water heating function used: 0x41<br>
		 * Non-automatic water heating function stopped: 0x43<br>
		 * Non-automatic water heating function used: 0x42<br>
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
		public Informer reqInformAutomaticWaterHeatingSetting() {
			reqInformProperty(EPC_AUTOMATIC_WATER_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : “Automatic water temperature control” setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic water temperature control function used: 0x41<br>
		 * Automatic water temperature control function not used: 0x42<br>
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
		public Informer reqInformAutomaticWaterTemperatureControlSetting() {
			reqInformProperty(EPC_AUTOMATIC_WATER_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Water heater status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>
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
		 * Get - optional<br>
		 */
		public Informer reqInformWaterHeaterStatus() {
			reqInformProperty(EPC_WATER_HEATER_STATUS);
			return this;
		}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformWaterHeatingTemperatureSetting() {
			reqInformProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : “Daytime reheating permission” setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br>
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
		public Informer reqInformDaytimeReheatingPermissionSetting() {
			reqInformProperty(EPC_DAYTIME_REHEATING_PERMISSION_SETTING);
			return this;
		}
		/**
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater() {
			reqInformProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		/**
		 * Property name : Alarm status<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the status of an alarm.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte:<br>
		 * Bit 0: Out of hot water<br>
		 * 0 Normal<br>
		 * 1 Alarm Bit 1: Water leaking<br>
		 * 0 Normal<br>
		 * 1 Alarm Bit 2: Water frozen<br>
		 * 0 Normal<br>
		 * 1 Alarm<br>
		 * Bits 3-7: reserved for future use<br>
		 * 2-4 bytes:<br>
		 * reserved for future use<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformAlarmStatus() {
			reqInformProperty(EPC_ALARM_STATUS);
			return this;
		}
		/**
		 * Property name : “Temperature of supplied water” setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		public Informer reqInformTemperatureOfSuppliedWaterSetting() {
			reqInformProperty(EPC_TEMPERATURE_OF_SUPPLIED_WATER_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in °C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
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
		public Informer reqInformBathWaterTemperatureSetting() {
			reqInformProperty(EPC_BATH_WATER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water volume setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
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
		public Informer reqInformBathWaterVolumeSetting() {
			reqInformProperty(EPC_BATH_WATER_VOLUME_SETTING);
			return this;
		}
		/**
		 * Property name : Measured amount of water remaining in tank<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured amount of water left in the tank in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredAmountOfWaterRemainingInTank() {
			reqInformProperty(EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK);
			return this;
		}
		/**
		 * Property name : Tank capacity<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the tank capacity in liters.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTankCapacity() {
			reqInformProperty(EPC_TANK_CAPACITY);
			return this;
		}
		/**
		 * Property name : “Automatic bath water heating” mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “automatic bath water heating” mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Automatic bath water heating” mode ON = 0x41<br>
		 * “Automatic bath water heating” mode OFF = 0x42<br>
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
		public Informer reqInformAutomaticBathWaterHeatingModeSetting() {
			reqInformProperty(EPC_AUTOMATIC_BATH_WATER_HEATING_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : “Addition of hot water” function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Addition of hot water” function ON = 0x41<br>
		 * “Addition of hot water” function OFF<br>
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
		public Informer reqInformAdditionOfHotWaterFunctionSetting() {
			reqInformProperty(EPC_ADDITION_OF_HOT_WATER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : “Slight bath water temperature lowering” function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “slight bath water temperature lowering” function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Slight bath water temperature lowering” function ON = 0x41<br>
		 * “Slight bath water temperature lowering” function OFF = 0x42<br>
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
		public Informer reqInformSlightBathWaterTemperatureLoweringFunctionSetting() {
			reqInformProperty(EPC_SLIGHT_BATH_WATER_TEMPERATURE_LOWERING_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0xFD (0.253 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathWaterVolumeSetting1() {
			reqInformProperty(EPC_BATH_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>
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
		public Informer reqInformBathWaterVolumeSetting2() {
			reqInformProperty(EPC_BATH_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 3<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533 liters)<br>
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
		public Informer reqInformBathWaterVolumeSetting3() {
			reqInformProperty(EPC_BATH_WATER_VOLUME_SETTING3);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 4<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * ￼<br>
		 * The bath hot water volume is specified by the number of steps.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01-0xFF<br>
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
		public Informer reqInformBathWaterVolumeSetting4() {
			reqInformProperty(EPC_BATH_WATER_VOLUME_SETTING4);
			return this;
		}
		/**
		 * Property name : Bath water volume setting 4- Maximum settable level<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * ￼<br>
		 * The maximum settable level is the top step of Bath water volume setting 4.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01-0xFF<br>
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
		public Informer reqInformBathWaterVolumeSetting4MaximumSettableLevel() {
			reqInformProperty(EPC_BATH_WATER_VOLUME_SETTING4_MAXIMUM_SETTABLE_LEVEL);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41 Reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
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
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * ON timer setting (HH:MM)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
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
		public Informer reqInformOnTimerSetting() {
			reqInformProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Rated power consumption of H/P unit in wintertime<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to March)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInWintertime() {
			reqInformProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME);
			return this;
		}
		/**
		 * Property name : Rated power consumption of H/P unit in
in-between seasons<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in<br>
		 * in-between seasons (April, May, October, November)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			reqInformProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS);
			return this;
		}
		/**
		 * Property name : Rated power consumption of H/P unit in summertime<br>
		 * <br>
		 * EPC : 0xDD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInSummertime() {
			reqInformProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME);
			return this;
		}
	}

	public static class Proxy extends ElectricWaterHeater {
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
		protected boolean setAutomaticWaterHeatingSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getAutomaticWaterHeatingSetting() {return null;}
		@Override
		protected boolean setWaterHeatingTemperatureSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getWaterHeatingTemperatureSetting() {return null;}
		@Override
		protected boolean setAutomaticBathWaterHeatingModeSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getAutomaticBathWaterHeatingModeSetting() {return null;}
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
