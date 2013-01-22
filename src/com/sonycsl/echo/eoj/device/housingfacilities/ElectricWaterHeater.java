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
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class ElectricWaterHeater extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x026B;

	public static final byte EPC_GAUTOMATIC_WATER_HEATING_H_SETTING = (byte)0xB0;
	public static final byte EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING = (byte)0xB1;
	public static final byte EPC_WATER_HEATER_STATUS = (byte)0xB2;
	public static final byte EPC_WATER_HEATING_TEMPERATURE_SETTING = (byte)0xB3;
	public static final byte EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING = (byte)0xC0;
	public static final byte EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER = (byte)0xC1;
	public static final byte EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING = (byte)0xD1;
	public static final byte EPC_BATH_WATER_TEMPERATURE_SETTING = (byte)0xD3;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING = (byte)0xE0;
	public static final byte EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK = (byte)0xE1;
	public static final byte EPC_TANK_CAPACITY = (byte)0xE2;
	public static final byte EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING = (byte)0xE3;
	public static final byte EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING = (byte)0xE5;
	public static final byte EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING = (byte)0xE6;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING1 = (byte)0xE7;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING2 = (byte)0xE8;
	public static final byte EPC_BATH_WATER_VOLUME_SETTING3 = (byte)0xEE;
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
		addSetProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
		addGetProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewElectricWaterHeater(this);
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
	 * This property indicates the ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : �\<br>
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
	 * This property indicates the ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : �\<br>
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
	 * Property name : �gAutomatic water heating�h setting<br>
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
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGautomaticWaterHeatingHSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gAutomatic water heating�h setting<br>
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
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGautomaticWaterHeatingHSetting() {return null;}
	/**
	 * Property name : �gAutomatic water heating�h setting<br>
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
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGautomaticWaterHeatingHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : �gAutomatic water temperature control�h setting<br>
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
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setGautomaticWaterTemperatureControlHSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gAutomatic water temperature control�h setting<br>
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
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getGautomaticWaterTemperatureControlHSetting() {return null;}
	/**
	 * Property name : �gAutomatic water temperature control�h setting<br>
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
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidGautomaticWaterTemperatureControlHSetting(byte[] edt) {
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
	 * Heating = 0x41<br>
	 * Not heating = 0x42<br>
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
	 * Heating = 0x41<br>
	 * Not heating = 0x42<br>
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
	 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	protected abstract boolean setWaterHeatingTemperatureSetting(byte[] edt);
	/**
	 * Property name : Water heating temperature setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	protected abstract byte[] getWaterHeatingTemperatureSetting();
	/**
	 * Property name : Water heating temperature setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	protected boolean isValidWaterHeatingTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : �gDaytime reheating permission�h setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Daytime reheating permitted: 0x41<br>
	 * Daytime reheating not permitted: 0x42<br>
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
	protected boolean setGdaytimeReheatingPermissionHSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gDaytime reheating permission�h setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Daytime reheating permitted: 0x41<br>
	 * Daytime reheating not permitted: 0x42<br>
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
	protected byte[] getGdaytimeReheatingPermissionHSetting() {return null;}
	/**
	 * Property name : �gDaytime reheating permission�h setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Daytime reheating permitted: 0x41<br>
	 * Daytime reheating not permitted: 0x42<br>
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
	protected boolean isValidGdaytimeReheatingPermissionHSetting(byte[] edt) {
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
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	protected boolean isValidMeasuredTemperatureOfWaterInWaterHeater(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : �gTemperature of supplied water�h setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	protected boolean setGtemperatureOfSuppliedWaterHSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gTemperature of supplied water�h setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	protected byte[] getGtemperatureOfSuppliedWaterHSetting() {return null;}
	/**
	 * Property name : �gTemperature of supplied water�h setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	protected boolean isValidGtemperatureOfSuppliedWaterHSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bath water temperature setting<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	protected boolean setBathWaterTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bath water temperature setting<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	protected byte[] getBathWaterTemperatureSetting() {return null;}
	/**
	 * Property name : Bath water temperature setting<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x64 (0 to 100��C)<br>
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
	 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liters<br>
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
	 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liters<br>
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
	 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liters<br>
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
	 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liters<br>
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
	 * Property name : �gAutomatic bath water heating�h mode setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * �gAutomatic bath water heating�h mode<br>
	 * ON = 0x41<br>
	 * �gAutomatic bath water heating�h mode<br>
	 * OFF = 0x42<br>
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
	protected boolean setGautomaticBathWaterHeatingHModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gAutomatic bath water heating�h mode setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * �gAutomatic bath water heating�h mode<br>
	 * ON = 0x41<br>
	 * �gAutomatic bath water heating�h mode<br>
	 * OFF = 0x42<br>
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
	protected byte[] getGautomaticBathWaterHeatingHModeSetting() {return null;}
	/**
	 * Property name : �gAutomatic bath water heating�h mode setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * �gAutomatic bath water heating�h mode<br>
	 * ON = 0x41<br>
	 * �gAutomatic bath water heating�h mode<br>
	 * OFF = 0x42<br>
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
	protected boolean isValidGautomaticBathWaterHeatingHModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : �gAddition of hot water�h function setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * �gAddition of hot water�h function ON =<br>
	 * 0x41<br>
	 * �gAddition of hot water�h function OFF<br>
	 * = 0x42<br>
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
	protected boolean setGadditionOfHotWaterHFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gAddition of hot water�h function setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * �gAddition of hot water�h function ON =<br>
	 * 0x41<br>
	 * �gAddition of hot water�h function OFF<br>
	 * = 0x42<br>
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
	protected byte[] getGadditionOfHotWaterHFunctionSetting() {return null;}
	/**
	 * Property name : �gAddition of hot water�h function setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * �gAddition of hot water�h function ON =<br>
	 * 0x41<br>
	 * �gAddition of hot water�h function OFF<br>
	 * = 0x42<br>
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
	protected boolean isValidGadditionOfHotWaterHFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : �gSlight bath water temperature lowering�h function setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * �gSlight bath water temperature lowering�h function ON = 0x41<br>
	 * �gSlight bath water temperature lowering�h function OFF = 0x42<br>
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
	protected boolean setGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gSlight bath water temperature lowering�h function setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * �gSlight bath water temperature lowering�h function ON = 0x41<br>
	 * �gSlight bath water temperature lowering�h function OFF = 0x42<br>
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
	protected byte[] getGslightBathWaterTemperatureLoweringHFunctionSetting() {return null;}
	/**
	 * Property name : �gSlight bath water temperature lowering�h function setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * �gSlight bath water temperature lowering�h function ON = 0x41<br>
	 * �gSlight bath water temperature lowering�h function OFF = 0x42<br>
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
	protected boolean isValidGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
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
	 * 0x00 to 0xFD (0 to 253 liters)<br>
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
	 * 0x00 to 0xFD (0 to 253 liters)<br>
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
	 * 0x00 to 0xFD (0 to 253 liters)<br>
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
	 * 0x31 to 0x38<br>
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
	 * 0x31 to 0x38<br>
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
	 * 0x31 to 0x38<br>
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
	 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liters<br>
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
	 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liters<br>
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
	 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : liters<br>
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
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * 0x31 to 0x38<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41<br>
	 * Reservation OFF = 0x42<br>
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
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * 0x31 to 0x38<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41<br>
	 * Reservation OFF = 0x42<br>
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
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * 0x31 to 0x38<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41<br>
	 * Reservation OFF = 0x42<br>
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
	 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0xFFFD(0-65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0xFFFD(0-65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD(0-65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD(0-65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD(0-65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
	 * 0x0000-0xFFFD(0-65,533)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
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
		case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING : return setGautomaticWaterHeatingHSetting(property.edt);
		case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING : return setGautomaticWaterTemperatureControlHSetting(property.edt);
		case EPC_WATER_HEATING_TEMPERATURE_SETTING : return setWaterHeatingTemperatureSetting(property.edt);
		case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING : return setGdaytimeReheatingPermissionHSetting(property.edt);
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : return setGtemperatureOfSuppliedWaterHSetting(property.edt);
		case EPC_BATH_WATER_TEMPERATURE_SETTING : return setBathWaterTemperatureSetting(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING : return setBathWaterVolumeSetting(property.edt);
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING : return setGautomaticBathWaterHeatingHModeSetting(property.edt);
		case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING : return setGadditionOfHotWaterHFunctionSetting(property.edt);
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : return setGslightBathWaterTemperatureLoweringHFunctionSetting(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING1 : return setBathWaterVolumeSetting1(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING2 : return setBathWaterVolumeSetting2(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING3 : return setBathWaterVolumeSetting3(property.edt);
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
		case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING : return getGautomaticWaterHeatingHSetting();
		case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING : return getGautomaticWaterTemperatureControlHSetting();
		case EPC_WATER_HEATER_STATUS : return getWaterHeaterStatus();
		case EPC_WATER_HEATING_TEMPERATURE_SETTING : return getWaterHeatingTemperatureSetting();
		case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING : return getGdaytimeReheatingPermissionHSetting();
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : return getMeasuredTemperatureOfWaterInWaterHeater();
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : return getGtemperatureOfSuppliedWaterHSetting();
		case EPC_BATH_WATER_TEMPERATURE_SETTING : return getBathWaterTemperatureSetting();
		case EPC_BATH_WATER_VOLUME_SETTING : return getBathWaterVolumeSetting();
		case EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK : return getMeasuredAmountOfWaterRemainingInTank();
		case EPC_TANK_CAPACITY : return getTankCapacity();
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING : return getGautomaticBathWaterHeatingHModeSetting();
		case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING : return getGadditionOfHotWaterHFunctionSetting();
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : return getGslightBathWaterTemperatureLoweringHFunctionSetting();
		case EPC_BATH_WATER_VOLUME_SETTING1 : return getBathWaterVolumeSetting1();
		case EPC_BATH_WATER_VOLUME_SETTING2 : return getBathWaterVolumeSetting2();
		case EPC_BATH_WATER_VOLUME_SETTING3 : return getBathWaterVolumeSetting3();
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
		case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING : return isValidGautomaticWaterHeatingHSetting(property.edt);
		case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING : return isValidGautomaticWaterTemperatureControlHSetting(property.edt);
		case EPC_WATER_HEATER_STATUS : return isValidWaterHeaterStatus(property.edt);
		case EPC_WATER_HEATING_TEMPERATURE_SETTING : return isValidWaterHeatingTemperatureSetting(property.edt);
		case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING : return isValidGdaytimeReheatingPermissionHSetting(property.edt);
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : return isValidMeasuredTemperatureOfWaterInWaterHeater(property.edt);
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : return isValidGtemperatureOfSuppliedWaterHSetting(property.edt);
		case EPC_BATH_WATER_TEMPERATURE_SETTING : return isValidBathWaterTemperatureSetting(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING : return isValidBathWaterVolumeSetting(property.edt);
		case EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK : return isValidMeasuredAmountOfWaterRemainingInTank(property.edt);
		case EPC_TANK_CAPACITY : return isValidTankCapacity(property.edt);
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING : return isValidGautomaticBathWaterHeatingHModeSetting(property.edt);
		case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING : return isValidGadditionOfHotWaterHFunctionSetting(property.edt);
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : return isValidGslightBathWaterTemperatureLoweringHFunctionSetting(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING1 : return isValidBathWaterVolumeSetting1(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING2 : return isValidBathWaterVolumeSetting2(property.edt);
		case EPC_BATH_WATER_VOLUME_SETTING3 : return isValidBathWaterVolumeSetting3(property.edt);
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
			case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING : 
				onSetGautomaticWaterHeatingHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING : 
				onSetGautomaticWaterTemperatureControlHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_HEATING_TEMPERATURE_SETTING : 
				onSetWaterHeatingTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING : 
				onSetGdaytimeReheatingPermissionHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : 
				onSetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_TEMPERATURE_SETTING : 
				onSetBathWaterTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATH_WATER_VOLUME_SETTING : 
				onSetBathWaterVolumeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING : 
				onSetGautomaticBathWaterHeatingHModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING : 
				onSetGadditionOfHotWaterHFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : 
				onSetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, property, success);
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
			case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING : 
				onGetGautomaticWaterHeatingHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING : 
				onGetGautomaticWaterTemperatureControlHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_HEATER_STATUS : 
				onGetWaterHeaterStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_HEATING_TEMPERATURE_SETTING : 
				onGetWaterHeatingTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING : 
				onGetGdaytimeReheatingPermissionHSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER : 
				onGetMeasuredTemperatureOfWaterInWaterHeater(eoj, tid, esv, property, success);
				return true;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING : 
				onGetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, property, success);
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
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING : 
				onGetGautomaticBathWaterHeatingHModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING : 
				onGetGadditionOfHotWaterHFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING : 
				onGetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, property, success);
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
		 * Property name : �gAutomatic water heating�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGautomaticWaterHeatingHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gAutomatic water heating�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGautomaticWaterHeatingHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gAutomatic water temperature control�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetGautomaticWaterTemperatureControlHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gAutomatic water temperature control�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetGautomaticWaterTemperatureControlHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water heater status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating = 0x41<br>
		 * Not heating = 0x42<br>
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
		protected void onGetWaterHeaterStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		protected void onSetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		protected void onGetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gDaytime reheating permission�h setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41<br>
		 * Daytime reheating not permitted: 0x42<br>
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
		protected void onSetGdaytimeReheatingPermissionHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gDaytime reheating permission�h setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41<br>
		 * Daytime reheating not permitted: 0x42<br>
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
		protected void onGetGdaytimeReheatingPermissionHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured temperature of water in water heater<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the current temperature of the water in the water heater.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		protected void onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gTemperature of supplied water�h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		protected void onSetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gTemperature of supplied water�h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		protected void onGetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		protected void onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetTankCapacity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gAutomatic bath water heating�h mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * ON = 0x41<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * OFF = 0x42<br>
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
		protected void onSetGautomaticBathWaterHeatingHModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gAutomatic bath water heating�h mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * ON = 0x41<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * OFF = 0x42<br>
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
		protected void onGetGautomaticBathWaterHeatingHModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gAddition of hot water�h function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAddition of hot water�h function ON =<br>
		 * 0x41<br>
		 * �gAddition of hot water�h function OFF<br>
		 * = 0x42<br>
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
		protected void onSetGadditionOfHotWaterHFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gAddition of hot water�h function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAddition of hot water�h function ON =<br>
		 * 0x41<br>
		 * �gAddition of hot water�h function OFF<br>
		 * = 0x42<br>
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
		protected void onGetGadditionOfHotWaterHFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gSlight bath water temperature lowering�h function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gSlight bath water temperature lowering�h function ON = 0x41<br>
		 * �gSlight bath water temperature lowering�h function OFF = 0x42<br>
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
		protected void onSetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gSlight bath water temperature lowering�h function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gSlight bath water temperature lowering�h function ON = 0x41<br>
		 * �gSlight bath water temperature lowering�h function OFF = 0x42<br>
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
		protected void onGetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bath water volume setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0xFD (0 to 253 liters)<br>
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
		 * 0x00 to 0xFD (0 to 253 liters)<br>
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
		 * 0x31 to 0x38<br>
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
		 * 0x31 to 0x38<br>
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * 0x31 to 0x38<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41<br>
		 * Reservation OFF = 0x42<br>
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
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * 0x31 to 0x38<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41<br>
		 * Reservation OFF = 0x42<br>
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
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power consumption of H/P unit in wintertime<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD(0-65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
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
		 * 0x0000-0xFFFD(0-65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
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
		 * 0x0000-0xFFFD(0-65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
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
		 * Property name : �gAutomatic water heating�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGautomaticWaterHeatingHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : �gAutomatic water temperature control�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetGautomaticWaterTemperatureControlHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Setter reqSetWaterHeatingTemperatureSetting(byte[] edt) {
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : �gDaytime reheating permission�h setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41<br>
		 * Daytime reheating not permitted: 0x42<br>
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
		public Setter reqSetGdaytimeReheatingPermissionHSetting(byte[] edt) {
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : �gTemperature of supplied water�h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Setter reqSetGtemperatureOfSuppliedWaterHSetting(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING, edt);
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
		public Setter reqSetBathWaterVolumeSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : �gAutomatic bath water heating�h mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * ON = 0x41<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * OFF = 0x42<br>
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
		public Setter reqSetGautomaticBathWaterHeatingHModeSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : �gAddition of hot water�h function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAddition of hot water�h function ON =<br>
		 * 0x41<br>
		 * �gAddition of hot water�h function OFF<br>
		 * = 0x42<br>
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
		public Setter reqSetGadditionOfHotWaterHFunctionSetting(byte[] edt) {
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : �gSlight bath water temperature lowering�h function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gSlight bath water temperature lowering�h function ON = 0x41<br>
		 * �gSlight bath water temperature lowering�h function OFF = 0x42<br>
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
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt);
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
		 * 0x00 to 0xFD (0 to 253 liters)<br>
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
		public Setter reqSetBathWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1, edt);
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
		 * 0x31 to 0x38<br>
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
		public Setter reqSetBathWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2, edt);
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathWaterVolumeSetting3(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * 0x31 to 0x38<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41<br>
		 * Reservation OFF = 0x42<br>
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
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt);
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
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt);
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
		 * Property name : �gAutomatic water heating�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGautomaticWaterHeatingHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING);
			return this;
		}
		/**
		 * Property name : �gAutomatic water temperature control�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetGautomaticWaterTemperatureControlHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING);
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
		 * Heating = 0x41<br>
		 * Not heating = 0x42<br>
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
		public Getter reqGetWaterHeaterStatus() {
			addProperty(EPC_WATER_HEATER_STATUS);
			return this;
		}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Getter reqGetWaterHeatingTemperatureSetting() {
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : �gDaytime reheating permission�h setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41<br>
		 * Daytime reheating not permitted: 0x42<br>
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
		public Getter reqGetGdaytimeReheatingPermissionHSetting() {
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING);
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
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		/**
		 * Property name : �gTemperature of supplied water�h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Getter reqGetGtemperatureOfSuppliedWaterHSetting() {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Getter reqGetBathWaterTemperatureSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING);
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
		public Getter reqGetBathWaterVolumeSetting() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING);
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredAmountOfWaterRemainingInTank() {
			addProperty(EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK);
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTankCapacity() {
			addProperty(EPC_TANK_CAPACITY);
			return this;
		}
		/**
		 * Property name : �gAutomatic bath water heating�h mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * ON = 0x41<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * OFF = 0x42<br>
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
		public Getter reqGetGautomaticBathWaterHeatingHModeSetting() {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : �gAddition of hot water�h function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAddition of hot water�h function ON =<br>
		 * 0x41<br>
		 * �gAddition of hot water�h function OFF<br>
		 * = 0x42<br>
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
		public Getter reqGetGadditionOfHotWaterHFunctionSetting() {
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : �gSlight bath water temperature lowering�h function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gSlight bath water temperature lowering�h function ON = 0x41<br>
		 * �gSlight bath water temperature lowering�h function OFF = 0x42<br>
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
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting() {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING);
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
		 * 0x00 to 0xFD (0 to 253 liters)<br>
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
		public Getter reqGetBathWaterVolumeSetting1() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1);
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
		 * 0x31 to 0x38<br>
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
		public Getter reqGetBathWaterVolumeSetting2() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2);
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathWaterVolumeSetting3() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * 0x31 to 0x38<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41<br>
		 * Reservation OFF = 0x42<br>
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
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
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
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Rated power consumption of H/P unit in wintertime<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD(0-65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInWintertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME);
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
		 * 0x0000-0xFFFD(0-65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS);
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
		 * 0x0000-0xFFFD(0-65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInSummertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME);
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
		 * Property name : �gAutomatic water heating�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGautomaticWaterHeatingHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING);
			return this;
		}
		/**
		 * Property name : �gAutomatic water temperature control�h setting<br>
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
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformGautomaticWaterTemperatureControlHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING);
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
		 * Heating = 0x41<br>
		 * Not heating = 0x42<br>
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
		public Informer reqInformWaterHeaterStatus() {
			addProperty(EPC_WATER_HEATER_STATUS);
			return this;
		}
		/**
		 * Property name : Water heating temperature setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Informer reqInformWaterHeatingTemperatureSetting() {
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : �gDaytime reheating permission�h setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Daytime reheating permitted: 0x41<br>
		 * Daytime reheating not permitted: 0x42<br>
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
		public Informer reqInformGdaytimeReheatingPermissionHSetting() {
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING);
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
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		/**
		 * Property name : �gTemperature of supplied water�h setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Informer reqInformGtemperatureOfSuppliedWaterHSetting() {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING);
			return this;
		}
		/**
		 * Property name : Bath water temperature setting<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x64 (0 to 100��C)<br>
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
		public Informer reqInformBathWaterTemperatureSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING);
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
		public Informer reqInformBathWaterVolumeSetting() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING);
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredAmountOfWaterRemainingInTank() {
			addProperty(EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK);
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTankCapacity() {
			addProperty(EPC_TANK_CAPACITY);
			return this;
		}
		/**
		 * Property name : �gAutomatic bath water heating�h mode setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * ON = 0x41<br>
		 * �gAutomatic bath water heating�h mode<br>
		 * OFF = 0x42<br>
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
		public Informer reqInformGautomaticBathWaterHeatingHModeSetting() {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : �gAddition of hot water�h function setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gAddition of hot water�h function ON =<br>
		 * 0x41<br>
		 * �gAddition of hot water�h function OFF<br>
		 * = 0x42<br>
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
		public Informer reqInformGadditionOfHotWaterHFunctionSetting() {
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : �gSlight bath water temperature lowering�h function setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * �gSlight bath water temperature lowering�h function ON = 0x41<br>
		 * �gSlight bath water temperature lowering�h function OFF = 0x42<br>
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
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting() {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING);
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
		 * 0x00 to 0xFD (0 to 253 liters)<br>
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
		public Informer reqInformBathWaterVolumeSetting1() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1);
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
		 * 0x31 to 0x38<br>
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
		public Informer reqInformBathWaterVolumeSetting2() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2);
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
		 * 0x0000 to 0xFFFD (0 to 65533 liters)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : liters<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathWaterVolumeSetting3() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * 0x31 to 0x38<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41<br>
		 * Reservation OFF = 0x42<br>
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
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
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
		public Informer reqInformOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Rated power consumption of H/P unit in wintertime<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0xFFFD(0-65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInWintertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME);
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
		 * 0x0000-0xFFFD(0-65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS);
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
		 * 0x0000-0xFFFD(0-65,533)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInSummertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME);
			return this;
		}
	}

	public static class Proxy extends ElectricWaterHeater {
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
		protected boolean setWaterHeatingTemperatureSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getWaterHeatingTemperatureSetting() {return null;}
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
