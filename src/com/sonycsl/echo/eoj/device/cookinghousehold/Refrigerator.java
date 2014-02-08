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
package com.sonycsl.echo.eoj.device.cookinghousehold;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class Refrigerator extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x03B7;

	public static final byte EPC_DOOR_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_DOOR_OPEN_WARNING = (byte)0xB1;
	public static final byte EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS = (byte)0xB2;
	public static final byte EPC_FREEZER_COMPARTMENT_DOOR_STATUS = (byte)0xB3;
	public static final byte EPC_ICE_COMPARTMENT_DOOR_STATUS = (byte)0xB4;
	public static final byte EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS = (byte)0xB5;
	public static final byte EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR = (byte)0xB6;
	public static final byte EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL = (byte)0xE0;
	public static final byte EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING = (byte)0xE2;
	public static final byte EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING = (byte)0xE3;
	public static final byte EPC_ICE_TEMPERATURE_SETTING = (byte)0xE4;
	public static final byte EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING = (byte)0xE5;
	public static final byte EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING = (byte)0xE6;
	public static final byte EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xE9;
	public static final byte EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xEA;
	public static final byte EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xEB;
	public static final byte EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xEC;
	public static final byte EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xED;
	public static final byte EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE = (byte)0xD1;
	public static final byte EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE = (byte)0xD2;
	public static final byte EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE = (byte)0xD3;
	public static final byte EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE = (byte)0xD4;
	public static final byte EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE = (byte)0xD5;
	public static final byte EPC_COMPRESSOR_ROTATION_SPEED = (byte)0xD8;
	public static final byte EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION = (byte)0xDA;
	public static final byte EPC_RATED_POWER_CONSUMPTION = (byte)0xDC;
	public static final byte EPC_QUICK_FREEZE_FUNCTION_SETTING = (byte)0xA0;
	public static final byte EPC_QUICK_REFRIGERATION_FUNCTION_SETTING = (byte)0xA1;
	public static final byte EPC_ICEMAKER_SETTING = (byte)0xA4;
	public static final byte EPC_ICEMAKER_OPERATION_STATUS = (byte)0xA5;
	public static final byte EPC_ICEMAKER_TANK_STATUS = (byte)0xA6;
	public static final byte EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING = (byte)0xA8;
	public static final byte EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING = (byte)0xA9;
	public static final byte EPC_DEODORIZATION_FUNCTION_SETTING = (byte)0xAD;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
		addStatusChangeAnnouncementProperty(EPC_DOOR_OPEN_WARNING);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewRefrigerator(this);
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
	 * Property name : Door open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Door open/close status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door open = 0x41, Door close = 0x42<br>
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
	protected abstract byte[] getDoorOpenCloseStatus();
	/**
	 * Property name : Door open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Door open/close status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door open = 0x41, Door close = 0x42<br>
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
	protected boolean isValidDoorOpenCloseStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Door open warning<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Door open warning status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door open warning found = 0x41 Door open warning not found = 0x42<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getDoorOpenWarning() {return null;}
	/**
	 * Property name : Door open warning<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Door open warning status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door open warning found = 0x41 Door open warning not found = 0x42<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDoorOpenWarning(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Refrigerator compartment door status<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected byte[] getRefrigeratorCompartmentDoorStatus() {return null;}
	/**
	 * Property name : Refrigerator compartment door status<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected boolean isValidRefrigeratorCompartmentDoorStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Freezer compartment door status<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected byte[] getFreezerCompartmentDoorStatus() {return null;}
	/**
	 * Property name : Freezer compartment door status<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected boolean isValidFreezerCompartmentDoorStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Ice compartment door status<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected byte[] getIceCompartmentDoorStatus() {return null;}
	/**
	 * Property name : Ice compartment door status<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected boolean isValidIceCompartmentDoorStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Vegetable compartment door status<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected byte[] getVegetableCompartmentDoorStatus() {return null;}
	/**
	 * Property name : Vegetable compartment door status<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected boolean isValidVegetableCompartmentDoorStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Multi-refrigera- ting mode compartment door<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected byte[] getMultiRefrigeraTingModeCompartmentDoor() {return null;}
	/**
	 * Property name : Multi-refrigera- ting mode compartment door<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Open = 0x41, closed = 0x42<br>
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
	protected boolean isValidMultiRefrigeraTingModeCompartmentDoor(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Maximum allowable temperature setting level<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Refrigerator compartment Second byte: Freezer compartment Third byte: subzero-fresh<br>
	 * compartment<br>
	 * Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode<br>
	 * compartment<br>
	 * Sixth to eighth bytes: Reserved for future use.<br>
	 * 0x01.0xFF (Level 1.255)<br>
	 * 0x00 = no compartment<br>
	 * <br>
	 * Data type : unsigned char × 8<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMaximumAllowableTemperatureSettingLevel() {return null;}
	/**
	 * Property name : Maximum allowable temperature setting level<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Refrigerator compartment Second byte: Freezer compartment Third byte: subzero-fresh<br>
	 * compartment<br>
	 * Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode<br>
	 * compartment<br>
	 * Sixth to eighth bytes: Reserved for future use.<br>
	 * 0x01.0xFF (Level 1.255)<br>
	 * 0x00 = no compartment<br>
	 * <br>
	 * Data type : unsigned char × 8<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMaximumAllowableTemperatureSettingLevel(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Refrigerator compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the refrigerator compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean setRefrigeratorCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Refrigerator compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the refrigerator compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getRefrigeratorCompartmentTemperatureSetting() {return null;}
	/**
	 * Property name : Refrigerator compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the refrigerator compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidRefrigeratorCompartmentTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Freezer compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the freezer compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean setFreezerCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Freezer compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the freezer compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getFreezerCompartmentTemperatureSetting() {return null;}
	/**
	 * Property name : Freezer compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the freezer compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidFreezerCompartmentTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Ice temperature setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ice compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean setIceTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ice temperature setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ice compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getIceTemperatureSetting() {return null;}
	/**
	 * Property name : Ice temperature setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the ice compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidIceTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Vegetable compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the vegetable compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean setVegetableCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Vegetable compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the vegetable compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getVegetableCompartmentTemperatureSetting() {return null;}
	/**
	 * Property name : Vegetable compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the vegetable compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidVegetableCompartmentTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Multi-refrigera- ting mode compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the multi-refrigerating mode compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean setMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Multi-refrigera- ting mode compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the multi-refrigerating mode compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getMultiRefrigeraTingModeCompartmentTemperatureSetting() {return null;}
	/**
	 * Property name : Multi-refrigera- ting mode compartment temperature setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the multi-refrigerating mode compartment temperature in °C, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Refrigerator compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean setRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Property name : Refrigerator compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected byte[] getRefrigeratorCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Property name : Refrigerator compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean isValidRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Freezer compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean setFreezerCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Property name : Freezer compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected byte[] getFreezerCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Property name : Freezer compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean isValidFreezerCompartmentTemperatureLevelSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ice compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean setIceCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Property name : ice compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected byte[] getIceCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Property name : ice compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean isValidIceCompartmentTemperatureLevelSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Vegetable compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean setVegetableCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Property name : Vegetable compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected byte[] getVegetableCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Property name : Vegetable compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean isValidVegetableCompartmentTemperatureLevelSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Multi-refrigera- ting mode compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Property name : Multi-refrigera- ting mode compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected byte[] getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Property name : Multi-refrigera- ting mode compartment temperature level setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
	protected boolean isValidMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured refrigerator compartment temperature<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured refrigerator compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getMeasuredRefrigeratorCompartmentTemperature() {return null;}
	/**
	 * Property name : Measured refrigerator compartment temperature<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured refrigerator compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidMeasuredRefrigeratorCompartmentTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured freezer compartment temperature<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured freezer compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getMeasuredFreezerCompartmentTemperature() {return null;}
	/**
	 * Property name : Measured freezer compartment temperature<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured freezer compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidMeasuredFreezerCompartmentTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured subzero-fresh compartment temperature<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured meat and fish compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getMeasuredSubzeroFreshCompartmentTemperature() {return null;}
	/**
	 * Property name : Measured subzero-fresh compartment temperature<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured meat and fish compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidMeasuredSubzeroFreshCompartmentTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured vegetable compartment temperature<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured vegetable compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getMeasuredVegetableCompartmentTemperature() {return null;}
	/**
	 * Property name : Measured vegetable compartment temperature<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured vegetable compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidMeasuredVegetableCompartmentTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured
multi-refrigeratin g mode compartment temperature<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured<br>
	 * multi-refrigerating mode compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected byte[] getMeasuredMultiRefrigeratinGModeCompartmentTemperature() {return null;}
	/**
	 * Property name : Measured
multi-refrigeratin g mode compartment temperature<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured<br>
	 * multi-refrigerating mode compartment temperature (°C).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7E (-127.126°C)<br>
	 * <br>
	 * Data type : signed char<br>
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
	protected boolean isValidMeasuredMultiRefrigeratinGModeCompartmentTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Compressor rotation speed<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Maximum rotation speed L (0x01.0xFF (1.255))<br>
	 * Second byte: Rotation speed of the actual compressor:<br>
	 * 0x00 to L (zero speed to highest speed)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getCompressorRotationSpeed() {return null;}
	/**
	 * Property name : Compressor rotation speed<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Maximum rotation speed L (0x01.0xFF (1.255))<br>
	 * Second byte: Rotation speed of the actual compressor:<br>
	 * 0x00 to L (zero speed to highest speed)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidCompressorRotationSpeed(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured electric current consumption<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured electric current consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6553.3A)<br>
	 * <br>
	 * Data type : unsigned char<br>
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
	protected byte[] getMeasuredElectricCurrentConsumption() {return null;}
	/**
	 * Property name : Measured electric current consumption<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the measured electric current consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6553.3A)<br>
	 * <br>
	 * Data type : unsigned char<br>
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
	protected boolean isValidMeasuredElectricCurrentConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Rated power consumption<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the rated power consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned char<br>
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
	protected byte[] getRatedPowerConsumption() {return null;}
	/**
	 * Property name : Rated power consumption<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the rated power consumption.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned char<br>
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
	protected boolean isValidRatedPowerConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Quick freeze function setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “Quick freeze” function of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” mode: 0x41 “Quick freeze” mode: 0x42 “Standby for fast freezing” mode:<br>
	 * 0x43<br>
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
	protected boolean setQuickFreezeFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Quick freeze function setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “Quick freeze” function of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” mode: 0x41 “Quick freeze” mode: 0x42 “Standby for fast freezing” mode:<br>
	 * 0x43<br>
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
	protected byte[] getQuickFreezeFunctionSetting() {return null;}
	/**
	 * Property name : Quick freeze function setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “Quick freeze” function of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” mode: 0x41 “Quick freeze” mode: 0x42 “Standby for fast freezing” mode:<br>
	 * 0x43<br>
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
	protected boolean isValidQuickFreezeFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Quick refrigeration function setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “quick refrigeration” function of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” mode: 0x41 “Quick refrigeration” mode: 0x42 “Standby for quick refrigeration”<br>
	 * mode: 0x43<br>
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
	protected boolean setQuickRefrigerationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Quick refrigeration function setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “quick refrigeration” function of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” mode: 0x41 “Quick refrigeration” mode: 0x42 “Standby for quick refrigeration”<br>
	 * mode: 0x43<br>
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
	protected byte[] getQuickRefrigerationFunctionSetting() {return null;}
	/**
	 * Property name : Quick refrigeration function setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the “quick refrigeration” function of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” mode: 0x41 “Quick refrigeration” mode: 0x42 “Standby for quick refrigeration”<br>
	 * mode: 0x43<br>
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
	protected boolean isValidQuickRefrigerationFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Icemaker setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Enable icemaker” option: 0x41 “Disable icemaker” option: 0x42 “Temporarily disable icemaker”<br>
	 * option: 0x43<br>
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
	protected boolean setIcemakerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Icemaker setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Enable icemaker” option: 0x41 “Disable icemaker” option: 0x42 “Temporarily disable icemaker”<br>
	 * option: 0x43<br>
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
	protected byte[] getIcemakerSetting() {return null;}
	/**
	 * Property name : Icemaker setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Enable icemaker” option: 0x41 “Disable icemaker” option: 0x42 “Temporarily disable icemaker”<br>
	 * option: 0x43<br>
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
	protected boolean isValidIcemakerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Icemaker operation status<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Ice-making in progress” state: 0x41<br>
	 * “Ice-making stopped” state: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getIcemakerOperationStatus() {return null;}
	/**
	 * Property name : Icemaker operation status<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Ice-making in progress” state: 0x41<br>
	 * “Ice-making stopped” state: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIcemakerOperationStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Icemaker tank status<br>
	 * <br>
	 * EPC : 0xA6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Icemaker tank contains water: 0x41 There is no water left in the icemaker<br>
	 * tank or the icemaker tank has not been<br>
	 * positioned correctly in the refrigerator: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getIcemakerTankStatus() {return null;}
	/**
	 * Property name : Icemaker tank status<br>
	 * <br>
	 * EPC : 0xA6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Icemaker tank contains water: 0x41 There is no water left in the icemaker<br>
	 * tank or the icemaker tank has not been<br>
	 * positioned correctly in the refrigerator: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIcemakerTankStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Refrigerator compartment humidification function setting<br>
	 * <br>
	 * EPC : 0xA8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x41 OFF = 0x42<br>
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
	protected boolean setRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Refrigerator compartment humidification function setting<br>
	 * <br>
	 * EPC : 0xA8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x41 OFF = 0x42<br>
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
	protected byte[] getRefrigeratorCompartmentHumidificationFunctionSetting() {return null;}
	/**
	 * Property name : Refrigerator compartment humidification function setting<br>
	 * <br>
	 * EPC : 0xA8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x41 OFF = 0x42<br>
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
	protected boolean isValidRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Vegetable compartment humidification function setting<br>
	 * <br>
	 * EPC : 0xA9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x41 OFF = 0x42<br>
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
	protected boolean setVegetableCompartmentHumidificationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Vegetable compartment humidification function setting<br>
	 * <br>
	 * EPC : 0xA9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x41 OFF = 0x42<br>
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
	protected byte[] getVegetableCompartmentHumidificationFunctionSetting() {return null;}
	/**
	 * Property name : Vegetable compartment humidification function setting<br>
	 * <br>
	 * EPC : 0xA9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x41 OFF = 0x42<br>
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
	protected boolean isValidVegetableCompartmentHumidificationFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Deodorization function setting<br>
	 * <br>
	 * EPC : 0xAD<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x41 OFF = 0x42<br>
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
	protected boolean setDeodorizationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Deodorization function setting<br>
	 * <br>
	 * EPC : 0xAD<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x41 OFF = 0x42<br>
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
	protected byte[] getDeodorizationFunctionSetting() {return null;}
	/**
	 * Property name : Deodorization function setting<br>
	 * <br>
	 * EPC : 0xAD<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x41 OFF = 0x42<br>
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
	protected boolean isValidDeodorizationFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING : return setRefrigeratorCompartmentTemperatureSetting(property.edt);
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING : return setFreezerCompartmentTemperatureSetting(property.edt);
		case EPC_ICE_TEMPERATURE_SETTING : return setIceTemperatureSetting(property.edt);
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING : return setVegetableCompartmentTemperatureSetting(property.edt);
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING : return setMultiRefrigeraTingModeCompartmentTemperatureSetting(property.edt);
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return setRefrigeratorCompartmentTemperatureLevelSetting(property.edt);
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return setFreezerCompartmentTemperatureLevelSetting(property.edt);
		case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return setIceCompartmentTemperatureLevelSetting(property.edt);
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return setVegetableCompartmentTemperatureLevelSetting(property.edt);
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(property.edt);
		case EPC_QUICK_FREEZE_FUNCTION_SETTING : return setQuickFreezeFunctionSetting(property.edt);
		case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING : return setQuickRefrigerationFunctionSetting(property.edt);
		case EPC_ICEMAKER_SETTING : return setIcemakerSetting(property.edt);
		case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : return setRefrigeratorCompartmentHumidificationFunctionSetting(property.edt);
		case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : return setVegetableCompartmentHumidificationFunctionSetting(property.edt);
		case EPC_DEODORIZATION_FUNCTION_SETTING : return setDeodorizationFunctionSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_DOOR_OPEN_CLOSE_STATUS : return getDoorOpenCloseStatus();
		case EPC_DOOR_OPEN_WARNING : return getDoorOpenWarning();
		case EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS : return getRefrigeratorCompartmentDoorStatus();
		case EPC_FREEZER_COMPARTMENT_DOOR_STATUS : return getFreezerCompartmentDoorStatus();
		case EPC_ICE_COMPARTMENT_DOOR_STATUS : return getIceCompartmentDoorStatus();
		case EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS : return getVegetableCompartmentDoorStatus();
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR : return getMultiRefrigeraTingModeCompartmentDoor();
		case EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL : return getMaximumAllowableTemperatureSettingLevel();
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING : return getRefrigeratorCompartmentTemperatureSetting();
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING : return getFreezerCompartmentTemperatureSetting();
		case EPC_ICE_TEMPERATURE_SETTING : return getIceTemperatureSetting();
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING : return getVegetableCompartmentTemperatureSetting();
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING : return getMultiRefrigeraTingModeCompartmentTemperatureSetting();
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return getRefrigeratorCompartmentTemperatureLevelSetting();
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return getFreezerCompartmentTemperatureLevelSetting();
		case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return getIceCompartmentTemperatureLevelSetting();
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return getVegetableCompartmentTemperatureLevelSetting();
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
		case EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE : return getMeasuredRefrigeratorCompartmentTemperature();
		case EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE : return getMeasuredFreezerCompartmentTemperature();
		case EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE : return getMeasuredSubzeroFreshCompartmentTemperature();
		case EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE : return getMeasuredVegetableCompartmentTemperature();
		case EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE : return getMeasuredMultiRefrigeratinGModeCompartmentTemperature();
		case EPC_COMPRESSOR_ROTATION_SPEED : return getCompressorRotationSpeed();
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION : return getMeasuredElectricCurrentConsumption();
		case EPC_RATED_POWER_CONSUMPTION : return getRatedPowerConsumption();
		case EPC_QUICK_FREEZE_FUNCTION_SETTING : return getQuickFreezeFunctionSetting();
		case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING : return getQuickRefrigerationFunctionSetting();
		case EPC_ICEMAKER_SETTING : return getIcemakerSetting();
		case EPC_ICEMAKER_OPERATION_STATUS : return getIcemakerOperationStatus();
		case EPC_ICEMAKER_TANK_STATUS : return getIcemakerTankStatus();
		case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : return getRefrigeratorCompartmentHumidificationFunctionSetting();
		case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : return getVegetableCompartmentHumidificationFunctionSetting();
		case EPC_DEODORIZATION_FUNCTION_SETTING : return getDeodorizationFunctionSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_DOOR_OPEN_CLOSE_STATUS : return isValidDoorOpenCloseStatus(property.edt);
		case EPC_DOOR_OPEN_WARNING : return isValidDoorOpenWarning(property.edt);
		case EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS : return isValidRefrigeratorCompartmentDoorStatus(property.edt);
		case EPC_FREEZER_COMPARTMENT_DOOR_STATUS : return isValidFreezerCompartmentDoorStatus(property.edt);
		case EPC_ICE_COMPARTMENT_DOOR_STATUS : return isValidIceCompartmentDoorStatus(property.edt);
		case EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS : return isValidVegetableCompartmentDoorStatus(property.edt);
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR : return isValidMultiRefrigeraTingModeCompartmentDoor(property.edt);
		case EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL : return isValidMaximumAllowableTemperatureSettingLevel(property.edt);
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING : return isValidRefrigeratorCompartmentTemperatureSetting(property.edt);
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING : return isValidFreezerCompartmentTemperatureSetting(property.edt);
		case EPC_ICE_TEMPERATURE_SETTING : return isValidIceTemperatureSetting(property.edt);
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING : return isValidVegetableCompartmentTemperatureSetting(property.edt);
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING : return isValidMultiRefrigeraTingModeCompartmentTemperatureSetting(property.edt);
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return isValidRefrigeratorCompartmentTemperatureLevelSetting(property.edt);
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return isValidFreezerCompartmentTemperatureLevelSetting(property.edt);
		case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return isValidIceCompartmentTemperatureLevelSetting(property.edt);
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return isValidVegetableCompartmentTemperatureLevelSetting(property.edt);
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : return isValidMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(property.edt);
		case EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE : return isValidMeasuredRefrigeratorCompartmentTemperature(property.edt);
		case EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE : return isValidMeasuredFreezerCompartmentTemperature(property.edt);
		case EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE : return isValidMeasuredSubzeroFreshCompartmentTemperature(property.edt);
		case EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE : return isValidMeasuredVegetableCompartmentTemperature(property.edt);
		case EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE : return isValidMeasuredMultiRefrigeratinGModeCompartmentTemperature(property.edt);
		case EPC_COMPRESSOR_ROTATION_SPEED : return isValidCompressorRotationSpeed(property.edt);
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION : return isValidMeasuredElectricCurrentConsumption(property.edt);
		case EPC_RATED_POWER_CONSUMPTION : return isValidRatedPowerConsumption(property.edt);
		case EPC_QUICK_FREEZE_FUNCTION_SETTING : return isValidQuickFreezeFunctionSetting(property.edt);
		case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING : return isValidQuickRefrigerationFunctionSetting(property.edt);
		case EPC_ICEMAKER_SETTING : return isValidIcemakerSetting(property.edt);
		case EPC_ICEMAKER_OPERATION_STATUS : return isValidIcemakerOperationStatus(property.edt);
		case EPC_ICEMAKER_TANK_STATUS : return isValidIcemakerTankStatus(property.edt);
		case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : return isValidRefrigeratorCompartmentHumidificationFunctionSetting(property.edt);
		case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : return isValidVegetableCompartmentHumidificationFunctionSetting(property.edt);
		case EPC_DEODORIZATION_FUNCTION_SETTING : return isValidDeodorizationFunctionSetting(property.edt);
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
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING : 
				onSetRefrigeratorCompartmentTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING : 
				onSetFreezerCompartmentTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ICE_TEMPERATURE_SETTING : 
				onSetIceTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING : 
				onSetVegetableCompartmentTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING : 
				onSetMultiRefrigeraTingModeCompartmentTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onSetRefrigeratorCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onSetFreezerCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onSetIceCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onSetVegetableCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_QUICK_FREEZE_FUNCTION_SETTING : 
				onSetQuickFreezeFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING : 
				onSetQuickRefrigerationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ICEMAKER_SETTING : 
				onSetIcemakerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : 
				onSetRefrigeratorCompartmentHumidificationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : 
				onSetVegetableCompartmentHumidificationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DEODORIZATION_FUNCTION_SETTING : 
				onSetDeodorizationFunctionSetting(eoj, tid, esv, property, success);
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
			case EPC_DOOR_OPEN_CLOSE_STATUS : 
				onGetDoorOpenCloseStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_DOOR_OPEN_WARNING : 
				onGetDoorOpenWarning(eoj, tid, esv, property, success);
				return true;
			case EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS : 
				onGetRefrigeratorCompartmentDoorStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_FREEZER_COMPARTMENT_DOOR_STATUS : 
				onGetFreezerCompartmentDoorStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_ICE_COMPARTMENT_DOOR_STATUS : 
				onGetIceCompartmentDoorStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS : 
				onGetVegetableCompartmentDoorStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR : 
				onGetMultiRefrigeraTingModeCompartmentDoor(eoj, tid, esv, property, success);
				return true;
			case EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL : 
				onGetMaximumAllowableTemperatureSettingLevel(eoj, tid, esv, property, success);
				return true;
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING : 
				onGetRefrigeratorCompartmentTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING : 
				onGetFreezerCompartmentTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ICE_TEMPERATURE_SETTING : 
				onGetIceTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING : 
				onGetVegetableCompartmentTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING : 
				onGetMultiRefrigeraTingModeCompartmentTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onGetRefrigeratorCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onGetFreezerCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onGetIceCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onGetVegetableCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING : 
				onGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE : 
				onGetMeasuredRefrigeratorCompartmentTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE : 
				onGetMeasuredFreezerCompartmentTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE : 
				onGetMeasuredSubzeroFreshCompartmentTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE : 
				onGetMeasuredVegetableCompartmentTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE : 
				onGetMeasuredMultiRefrigeratinGModeCompartmentTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_COMPRESSOR_ROTATION_SPEED : 
				onGetCompressorRotationSpeed(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION : 
				onGetMeasuredElectricCurrentConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_CONSUMPTION : 
				onGetRatedPowerConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_QUICK_FREEZE_FUNCTION_SETTING : 
				onGetQuickFreezeFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING : 
				onGetQuickRefrigerationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ICEMAKER_SETTING : 
				onGetIcemakerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ICEMAKER_OPERATION_STATUS : 
				onGetIcemakerOperationStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_ICEMAKER_TANK_STATUS : 
				onGetIcemakerTankStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : 
				onGetRefrigeratorCompartmentHumidificationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING : 
				onGetVegetableCompartmentHumidificationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DEODORIZATION_FUNCTION_SETTING : 
				onGetDeodorizationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Door open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Door open/close status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door open = 0x41, Door close = 0x42<br>
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
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Door open warning<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Door open warning status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door open warning found = 0x41 Door open warning not found = 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetDoorOpenWarning(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Refrigerator compartment door status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		protected void onGetRefrigeratorCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Freezer compartment door status<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		protected void onGetFreezerCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ice compartment door status<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		protected void onGetIceCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Vegetable compartment door status<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		protected void onGetVegetableCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Multi-refrigera- ting mode compartment door<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		protected void onGetMultiRefrigeraTingModeCompartmentDoor(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Maximum allowable temperature setting level<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Refrigerator compartment Second byte: Freezer compartment Third byte: subzero-fresh<br>
		 * compartment<br>
		 * Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode<br>
		 * compartment<br>
		 * Sixth to eighth bytes: Reserved for future use.<br>
		 * 0x01.0xFF (Level 1.255)<br>
		 * 0x00 = no compartment<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMaximumAllowableTemperatureSettingLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Refrigerator compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onSetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Refrigerator compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Freezer compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onSetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Freezer compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ice temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ice compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onSetIceTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ice temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ice compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetIceTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Vegetable compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onSetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Vegetable compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onSetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Refrigerator compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onSetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Refrigerator compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onGetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Freezer compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onSetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Freezer compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onGetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ice compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onSetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ice compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onGetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Vegetable compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onSetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Vegetable compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onGetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		protected void onGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured refrigerator compartment temperature<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured refrigerator compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetMeasuredRefrigeratorCompartmentTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured freezer compartment temperature<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured freezer compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetMeasuredFreezerCompartmentTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured subzero-fresh compartment temperature<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured meat and fish compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetMeasuredSubzeroFreshCompartmentTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured vegetable compartment temperature<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured vegetable compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetMeasuredVegetableCompartmentTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured
multi-refrigeratin g mode compartment temperature<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured<br>
		 * multi-refrigerating mode compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		protected void onGetMeasuredMultiRefrigeratinGModeCompartmentTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Compressor rotation speed<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Maximum rotation speed L (0x01.0xFF (1.255))<br>
		 * Second byte: Rotation speed of the actual compressor:<br>
		 * 0x00 to L (zero speed to highest speed)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetCompressorRotationSpeed(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured electric current consumption<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured electric current consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned char<br>
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
		protected void onGetMeasuredElectricCurrentConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power consumption<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rated power consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned char<br>
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
		protected void onGetRatedPowerConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Quick freeze function setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “Quick freeze” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick freeze” mode: 0x42 “Standby for fast freezing” mode:<br>
		 * 0x43<br>
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
		protected void onSetQuickFreezeFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Quick freeze function setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “Quick freeze” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick freeze” mode: 0x42 “Standby for fast freezing” mode:<br>
		 * 0x43<br>
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
		protected void onGetQuickFreezeFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Quick refrigeration function setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “quick refrigeration” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick refrigeration” mode: 0x42 “Standby for quick refrigeration”<br>
		 * mode: 0x43<br>
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
		protected void onSetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Quick refrigeration function setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “quick refrigeration” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick refrigeration” mode: 0x42 “Standby for quick refrigeration”<br>
		 * mode: 0x43<br>
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
		protected void onGetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Icemaker setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Enable icemaker” option: 0x41 “Disable icemaker” option: 0x42 “Temporarily disable icemaker”<br>
		 * option: 0x43<br>
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
		protected void onSetIcemakerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Icemaker setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Enable icemaker” option: 0x41 “Disable icemaker” option: 0x42 “Temporarily disable icemaker”<br>
		 * option: 0x43<br>
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
		protected void onGetIcemakerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Icemaker operation status<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Ice-making in progress” state: 0x41<br>
		 * “Ice-making stopped” state: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetIcemakerOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Icemaker tank status<br>
		 * <br>
		 * EPC : 0xA6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Icemaker tank contains water: 0x41 There is no water left in the icemaker<br>
		 * tank or the icemaker tank has not been<br>
		 * positioned correctly in the refrigerator: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetIcemakerTankStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Refrigerator compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		protected void onSetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Refrigerator compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		protected void onGetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Vegetable compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		protected void onSetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Vegetable compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		protected void onGetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Deodorization function setting<br>
		 * <br>
		 * EPC : 0xAD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		protected void onSetDeodorizationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Deodorization function setting<br>
		 * <br>
		 * EPC : 0xAD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		protected void onGetDeodorizationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Refrigerator compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Setter reqSetRefrigeratorCompartmentTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Freezer compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Setter reqSetFreezerCompartmentTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Ice temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ice compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Setter reqSetIceTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_ICE_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Vegetable compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Setter reqSetVegetableCompartmentTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Setter reqSetRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt) {
			reqSetProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Freezer compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Setter reqSetFreezerCompartmentTemperatureLevelSetting(byte[] edt) {
			reqSetProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ice compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Setter reqSetIceCompartmentTemperatureLevelSetting(byte[] edt) {
			reqSetProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Vegetable compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Setter reqSetVegetableCompartmentTemperatureLevelSetting(byte[] edt) {
			reqSetProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt) {
			reqSetProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Quick freeze function setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “Quick freeze” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick freeze” mode: 0x42 “Standby for fast freezing” mode:<br>
		 * 0x43<br>
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
		public Setter reqSetQuickFreezeFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Quick refrigeration function setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “quick refrigeration” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick refrigeration” mode: 0x42 “Standby for quick refrigeration”<br>
		 * mode: 0x43<br>
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
		public Setter reqSetQuickRefrigerationFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Icemaker setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Enable icemaker” option: 0x41 “Disable icemaker” option: 0x42 “Temporarily disable icemaker”<br>
		 * option: 0x43<br>
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
		public Setter reqSetIcemakerSetting(byte[] edt) {
			reqSetProperty(EPC_ICEMAKER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		public Setter reqSetRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Vegetable compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		public Setter reqSetVegetableCompartmentHumidificationFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Deodorization function setting<br>
		 * <br>
		 * EPC : 0xAD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		public Setter reqSetDeodorizationFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_DEODORIZATION_FUNCTION_SETTING, edt);
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
		 * Property name : Door open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Door open/close status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door open = 0x41, Door close = 0x42<br>
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
		public Getter reqGetDoorOpenCloseStatus() {
			reqGetProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Door open warning<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Door open warning status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door open warning found = 0x41 Door open warning not found = 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetDoorOpenWarning() {
			reqGetProperty(EPC_DOOR_OPEN_WARNING);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment door status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Getter reqGetRefrigeratorCompartmentDoorStatus() {
			reqGetProperty(EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Property name : Freezer compartment door status<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Getter reqGetFreezerCompartmentDoorStatus() {
			reqGetProperty(EPC_FREEZER_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Property name : Ice compartment door status<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Getter reqGetIceCompartmentDoorStatus() {
			reqGetProperty(EPC_ICE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Property name : Vegetable compartment door status<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Getter reqGetVegetableCompartmentDoorStatus() {
			reqGetProperty(EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Property name : Multi-refrigera- ting mode compartment door<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Getter reqGetMultiRefrigeraTingModeCompartmentDoor() {
			reqGetProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR);
			return this;
		}
		/**
		 * Property name : Maximum allowable temperature setting level<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Refrigerator compartment Second byte: Freezer compartment Third byte: subzero-fresh<br>
		 * compartment<br>
		 * Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode<br>
		 * compartment<br>
		 * Sixth to eighth bytes: Reserved for future use.<br>
		 * 0x01.0xFF (Level 1.255)<br>
		 * 0x00 = no compartment<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMaximumAllowableTemperatureSettingLevel() {
			reqGetProperty(EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetRefrigeratorCompartmentTemperatureSetting() {
			reqGetProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Freezer compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetFreezerCompartmentTemperatureSetting() {
			reqGetProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Ice temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ice compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetIceTemperatureSetting() {
			reqGetProperty(EPC_ICE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Vegetable compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetVegetableCompartmentTemperatureSetting() {
			reqGetProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureSetting() {
			reqGetProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Getter reqGetRefrigeratorCompartmentTemperatureLevelSetting() {
			reqGetProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Freezer compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Getter reqGetFreezerCompartmentTemperatureLevelSetting() {
			reqGetProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : ice compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Getter reqGetIceCompartmentTemperatureLevelSetting() {
			reqGetProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Vegetable compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Getter reqGetVegetableCompartmentTemperatureLevelSetting() {
			reqGetProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {
			reqGetProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Measured refrigerator compartment temperature<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured refrigerator compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetMeasuredRefrigeratorCompartmentTemperature() {
			reqGetProperty(EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured freezer compartment temperature<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured freezer compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetMeasuredFreezerCompartmentTemperature() {
			reqGetProperty(EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured subzero-fresh compartment temperature<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured meat and fish compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetMeasuredSubzeroFreshCompartmentTemperature() {
			reqGetProperty(EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured vegetable compartment temperature<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured vegetable compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetMeasuredVegetableCompartmentTemperature() {
			reqGetProperty(EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured
multi-refrigeratin g mode compartment temperature<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured<br>
		 * multi-refrigerating mode compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Getter reqGetMeasuredMultiRefrigeratinGModeCompartmentTemperature() {
			reqGetProperty(EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Compressor rotation speed<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Maximum rotation speed L (0x01.0xFF (1.255))<br>
		 * Second byte: Rotation speed of the actual compressor:<br>
		 * 0x00 to L (zero speed to highest speed)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetCompressorRotationSpeed() {
			reqGetProperty(EPC_COMPRESSOR_ROTATION_SPEED);
			return this;
		}
		/**
		 * Property name : Measured electric current consumption<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured electric current consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned char<br>
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
		public Getter reqGetMeasuredElectricCurrentConsumption() {
			reqGetProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Rated power consumption<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rated power consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned char<br>
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
		public Getter reqGetRatedPowerConsumption() {
			reqGetProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Quick freeze function setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “Quick freeze” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick freeze” mode: 0x42 “Standby for fast freezing” mode:<br>
		 * 0x43<br>
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
		public Getter reqGetQuickFreezeFunctionSetting() {
			reqGetProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Quick refrigeration function setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “quick refrigeration” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick refrigeration” mode: 0x42 “Standby for quick refrigeration”<br>
		 * mode: 0x43<br>
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
		public Getter reqGetQuickRefrigerationFunctionSetting() {
			reqGetProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Icemaker setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Enable icemaker” option: 0x41 “Disable icemaker” option: 0x42 “Temporarily disable icemaker”<br>
		 * option: 0x43<br>
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
		public Getter reqGetIcemakerSetting() {
			reqGetProperty(EPC_ICEMAKER_SETTING);
			return this;
		}
		/**
		 * Property name : Icemaker operation status<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Ice-making in progress” state: 0x41<br>
		 * “Ice-making stopped” state: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIcemakerOperationStatus() {
			reqGetProperty(EPC_ICEMAKER_OPERATION_STATUS);
			return this;
		}
		/**
		 * Property name : Icemaker tank status<br>
		 * <br>
		 * EPC : 0xA6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Icemaker tank contains water: 0x41 There is no water left in the icemaker<br>
		 * tank or the icemaker tank has not been<br>
		 * positioned correctly in the refrigerator: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIcemakerTankStatus() {
			reqGetProperty(EPC_ICEMAKER_TANK_STATUS);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		public Getter reqGetRefrigeratorCompartmentHumidificationFunctionSetting() {
			reqGetProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Vegetable compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		public Getter reqGetVegetableCompartmentHumidificationFunctionSetting() {
			reqGetProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Deodorization function setting<br>
		 * <br>
		 * EPC : 0xAD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		public Getter reqGetDeodorizationFunctionSetting() {
			reqGetProperty(EPC_DEODORIZATION_FUNCTION_SETTING);
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
		 * Property name : Door open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Door open/close status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door open = 0x41, Door close = 0x42<br>
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
		public Informer reqInformDoorOpenCloseStatus() {
			reqInformProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Door open warning<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Door open warning status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door open warning found = 0x41 Door open warning not found = 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformDoorOpenWarning() {
			reqInformProperty(EPC_DOOR_OPEN_WARNING);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment door status<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Informer reqInformRefrigeratorCompartmentDoorStatus() {
			reqInformProperty(EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Property name : Freezer compartment door status<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Informer reqInformFreezerCompartmentDoorStatus() {
			reqInformProperty(EPC_FREEZER_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Property name : Ice compartment door status<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Informer reqInformIceCompartmentDoorStatus() {
			reqInformProperty(EPC_ICE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Property name : Vegetable compartment door status<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Informer reqInformVegetableCompartmentDoorStatus() {
			reqInformProperty(EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Property name : Multi-refrigera- ting mode compartment door<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Open = 0x41, closed = 0x42<br>
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
		public Informer reqInformMultiRefrigeraTingModeCompartmentDoor() {
			reqInformProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR);
			return this;
		}
		/**
		 * Property name : Maximum allowable temperature setting level<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Refrigerator compartment Second byte: Freezer compartment Third byte: subzero-fresh<br>
		 * compartment<br>
		 * Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode<br>
		 * compartment<br>
		 * Sixth to eighth bytes: Reserved for future use.<br>
		 * 0x01.0xFF (Level 1.255)<br>
		 * 0x00 = no compartment<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMaximumAllowableTemperatureSettingLevel() {
			reqInformProperty(EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformRefrigeratorCompartmentTemperatureSetting() {
			reqInformProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Freezer compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformFreezerCompartmentTemperatureSetting() {
			reqInformProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Ice temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the ice compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformIceTemperatureSetting() {
			reqInformProperty(EPC_ICE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Vegetable compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformVegetableCompartmentTemperatureSetting() {
			reqInformProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature in °C, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureSetting() {
			reqInformProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Informer reqInformRefrigeratorCompartmentTemperatureLevelSetting() {
			reqInformProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Freezer compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Informer reqInformFreezerCompartmentTemperatureLevelSetting() {
			reqInformProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : ice compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Informer reqInformIceCompartmentTemperatureLevelSetting() {
			reqInformProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Vegetable compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Informer reqInformVegetableCompartmentTemperatureLevelSetting() {
			reqInformProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Multi-refrigera- ting mode compartment temperature level setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br>
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
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {
			reqInformProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Measured refrigerator compartment temperature<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured refrigerator compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformMeasuredRefrigeratorCompartmentTemperature() {
			reqInformProperty(EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured freezer compartment temperature<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured freezer compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformMeasuredFreezerCompartmentTemperature() {
			reqInformProperty(EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured subzero-fresh compartment temperature<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured meat and fish compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformMeasuredSubzeroFreshCompartmentTemperature() {
			reqInformProperty(EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured vegetable compartment temperature<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured vegetable compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformMeasuredVegetableCompartmentTemperature() {
			reqInformProperty(EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured
multi-refrigeratin g mode compartment temperature<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured<br>
		 * multi-refrigerating mode compartment temperature (°C).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7E (-127.126°C)<br>
		 * <br>
		 * Data type : signed char<br>
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
		public Informer reqInformMeasuredMultiRefrigeratinGModeCompartmentTemperature() {
			reqInformProperty(EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Compressor rotation speed<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Maximum rotation speed L (0x01.0xFF (1.255))<br>
		 * Second byte: Rotation speed of the actual compressor:<br>
		 * 0x00 to L (zero speed to highest speed)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformCompressorRotationSpeed() {
			reqInformProperty(EPC_COMPRESSOR_ROTATION_SPEED);
			return this;
		}
		/**
		 * Property name : Measured electric current consumption<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the measured electric current consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned char<br>
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
		public Informer reqInformMeasuredElectricCurrentConsumption() {
			reqInformProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Rated power consumption<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the rated power consumption.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned char<br>
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
		public Informer reqInformRatedPowerConsumption() {
			reqInformProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Quick freeze function setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “Quick freeze” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick freeze” mode: 0x42 “Standby for fast freezing” mode:<br>
		 * 0x43<br>
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
		public Informer reqInformQuickFreezeFunctionSetting() {
			reqInformProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Quick refrigeration function setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the “quick refrigeration” function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” mode: 0x41 “Quick refrigeration” mode: 0x42 “Standby for quick refrigeration”<br>
		 * mode: 0x43<br>
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
		public Informer reqInformQuickRefrigerationFunctionSetting() {
			reqInformProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Icemaker setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Enable icemaker” option: 0x41 “Disable icemaker” option: 0x42 “Temporarily disable icemaker”<br>
		 * option: 0x43<br>
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
		public Informer reqInformIcemakerSetting() {
			reqInformProperty(EPC_ICEMAKER_SETTING);
			return this;
		}
		/**
		 * Property name : Icemaker operation status<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Ice-making in progress” state: 0x41<br>
		 * “Ice-making stopped” state: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIcemakerOperationStatus() {
			reqInformProperty(EPC_ICEMAKER_OPERATION_STATUS);
			return this;
		}
		/**
		 * Property name : Icemaker tank status<br>
		 * <br>
		 * EPC : 0xA6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Icemaker tank contains water: 0x41 There is no water left in the icemaker<br>
		 * tank or the icemaker tank has not been<br>
		 * positioned correctly in the refrigerator: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIcemakerTankStatus() {
			reqInformProperty(EPC_ICEMAKER_TANK_STATUS);
			return this;
		}
		/**
		 * Property name : Refrigerator compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		public Informer reqInformRefrigeratorCompartmentHumidificationFunctionSetting() {
			reqInformProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Vegetable compartment humidification function setting<br>
		 * <br>
		 * EPC : 0xA9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		public Informer reqInformVegetableCompartmentHumidificationFunctionSetting() {
			reqInformProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Deodorization function setting<br>
		 * <br>
		 * EPC : 0xAD<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x41 OFF = 0x42<br>
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
		public Informer reqInformDeodorizationFunctionSetting() {
			reqInformProperty(EPC_DEODORIZATION_FUNCTION_SETTING);
			return this;
		}
	}

	public static class Proxy extends Refrigerator {
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
		protected byte[] getDoorOpenCloseStatus() {return null;}
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
