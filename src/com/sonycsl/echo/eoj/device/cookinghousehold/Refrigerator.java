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

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class Refrigerator extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xB7;
	
	public Refrigerator() {
		setReceiver(new Receiver());
	}

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
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Door open/close status<br><br>Door open = 0x41, Door close = 0x42<br><br>Name : Door open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getDoorOpenCloseStatus();
	private final byte[] _getDoorOpenCloseStatus(byte epc) {
		byte[] edt = getDoorOpenCloseStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Door open warning status<br><br>Door open warning found = 0x41 Door open warning not found = 0x42<br><br>Name : Door open warning<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getDoorOpenWarning() {return null;}
	private final byte[] _getDoorOpenWarning(byte epc) {
		byte[] edt = getDoorOpenWarning();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Refrigerator compartment door status<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRefrigeratorCompartmentDoorStatus() {return null;}
	private final byte[] _getRefrigeratorCompartmentDoorStatus(byte epc) {
		byte[] edt = getRefrigeratorCompartmentDoorStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Freezer compartment door status<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getFreezerCompartmentDoorStatus() {return null;}
	private final byte[] _getFreezerCompartmentDoorStatus(byte epc) {
		byte[] edt = getFreezerCompartmentDoorStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Ice compartment door status<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getIceCompartmentDoorStatus() {return null;}
	private final byte[] _getIceCompartmentDoorStatus(byte epc) {
		byte[] edt = getIceCompartmentDoorStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Vegetable compartment door status<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getVegetableCompartmentDoorStatus() {return null;}
	private final byte[] _getVegetableCompartmentDoorStatus(byte epc) {
		byte[] edt = getVegetableCompartmentDoorStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Multi-refrigera- ting mode compartment door<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMultiRefrigeraTingModeCompartmentDoor() {return null;}
	private final byte[] _getMultiRefrigeraTingModeCompartmentDoor(byte epc) {
		byte[] edt = getMultiRefrigeraTingModeCompartmentDoor();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br><br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment<br><br>Name : Maximum allowable temperature setting level<br>EPC : 0xE0<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMaximumAllowableTemperatureSettingLevel() {return null;}
	private final byte[] _getMaximumAllowableTemperatureSettingLevel(byte epc) {
		byte[] edt = getMaximumAllowableTemperatureSettingLevel();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Refrigerator compartment temperature setting<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRefrigeratorCompartmentTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setRefrigeratorCompartmentTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setRefrigeratorCompartmentTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Refrigerator compartment temperature setting<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRefrigeratorCompartmentTemperatureSetting() {return null;}
	private final byte[] _getRefrigeratorCompartmentTemperatureSetting(byte epc) {
		byte[] edt = getRefrigeratorCompartmentTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Freezer compartment temperature setting<br>EPC : 0xE3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setFreezerCompartmentTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setFreezerCompartmentTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setFreezerCompartmentTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Freezer compartment temperature setting<br>EPC : 0xE3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getFreezerCompartmentTemperatureSetting() {return null;}
	private final byte[] _getFreezerCompartmentTemperatureSetting(byte epc) {
		byte[] edt = getFreezerCompartmentTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Ice temperature setting<br>EPC : 0xE4<br>Data Type : signed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setIceTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setIceTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setIceTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Ice temperature setting<br>EPC : 0xE4<br>Data Type : signed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getIceTemperatureSetting() {return null;}
	private final byte[] _getIceTemperatureSetting(byte epc) {
		byte[] edt = getIceTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Vegetable compartment temperature setting<br>EPC : 0xE5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVegetableCompartmentTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setVegetableCompartmentTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setVegetableCompartmentTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Vegetable compartment temperature setting<br>EPC : 0xE5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getVegetableCompartmentTemperatureSetting() {return null;}
	private final byte[] _getVegetableCompartmentTemperatureSetting(byte epc) {
		byte[] edt = getVegetableCompartmentTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Multi-refrigera- ting mode compartment temperature setting<br>EPC : 0xE6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setMultiRefrigeraTingModeCompartmentTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setMultiRefrigeraTingModeCompartmentTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Multi-refrigera- ting mode compartment temperature setting<br>EPC : 0xE6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getMultiRefrigeraTingModeCompartmentTemperatureSetting() {return null;}
	private final byte[] _getMultiRefrigeraTingModeCompartmentTemperatureSetting(byte epc) {
		byte[] edt = getMultiRefrigeraTingModeCompartmentTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Refrigerator compartment temperature level setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	private final boolean _setRefrigeratorCompartmentTemperatureLevelSetting(byte epc, byte[] edt) {
		boolean success = setRefrigeratorCompartmentTemperatureLevelSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Refrigerator compartment temperature level setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRefrigeratorCompartmentTemperatureLevelSetting() {return null;}
	private final byte[] _getRefrigeratorCompartmentTemperatureLevelSetting(byte epc) {
		byte[] edt = getRefrigeratorCompartmentTemperatureLevelSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Freezer compartment temperature level setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setFreezerCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	private final boolean _setFreezerCompartmentTemperatureLevelSetting(byte epc, byte[] edt) {
		boolean success = setFreezerCompartmentTemperatureLevelSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Freezer compartment temperature level setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getFreezerCompartmentTemperatureLevelSetting() {return null;}
	private final byte[] _getFreezerCompartmentTemperatureLevelSetting(byte epc) {
		byte[] edt = getFreezerCompartmentTemperatureLevelSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : ice compartment temperature level setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setIceCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	private final boolean _setIceCompartmentTemperatureLevelSetting(byte epc, byte[] edt) {
		boolean success = setIceCompartmentTemperatureLevelSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : ice compartment temperature level setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getIceCompartmentTemperatureLevelSetting() {return null;}
	private final byte[] _getIceCompartmentTemperatureLevelSetting(byte epc) {
		byte[] edt = getIceCompartmentTemperatureLevelSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Vegetable compartment temperature level setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVegetableCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	private final boolean _setVegetableCompartmentTemperatureLevelSetting(byte epc, byte[] edt) {
		boolean success = setVegetableCompartmentTemperatureLevelSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Vegetable compartment temperature level setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getVegetableCompartmentTemperatureLevelSetting() {return null;}
	private final byte[] _getVegetableCompartmentTemperatureLevelSetting(byte epc) {
		byte[] edt = getVegetableCompartmentTemperatureLevelSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Multi-refrigera- ting mode compartment temperature level setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	private final boolean _setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte epc, byte[] edt) {
		boolean success = setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Multi-refrigera- ting mode compartment temperature level setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {return null;}
	private final byte[] _getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte epc) {
		byte[] edt = getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured refrigerator compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured refrigerator compartment temperature<br>EPC : 0xD1<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredRefrigeratorCompartmentTemperature() {return null;}
	private final byte[] _getMeasuredRefrigeratorCompartmentTemperature(byte epc) {
		byte[] edt = getMeasuredRefrigeratorCompartmentTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured freezer compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured freezer compartment temperature<br>EPC : 0xD2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredFreezerCompartmentTemperature() {return null;}
	private final byte[] _getMeasuredFreezerCompartmentTemperature(byte epc) {
		byte[] edt = getMeasuredFreezerCompartmentTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured meat and fish compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured subzero-fresh compartment temperature<br>EPC : 0xD3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredSubzeroFreshCompartmentTemperature() {return null;}
	private final byte[] _getMeasuredSubzeroFreshCompartmentTemperature(byte epc) {
		byte[] edt = getMeasuredSubzeroFreshCompartmentTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured vegetable compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured vegetable compartment temperature<br>EPC : 0xD4<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredVegetableCompartmentTemperature() {return null;}
	private final byte[] _getMeasuredVegetableCompartmentTemperature(byte epc) {
		byte[] edt = getMeasuredVegetableCompartmentTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured multi-refrigeratin g mode compartment temperature<br>EPC : 0xD5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredMultiRefrigeratinGModeCompartmentTemperature() {return null;}
	private final byte[] _getMeasuredMultiRefrigeratinGModeCompartmentTemperature(byte epc) {
		byte[] edt = getMeasuredMultiRefrigeratinGModeCompartmentTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br><br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)<br><br>Name : Compressor rotation speed<br>EPC : 0xD8<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getCompressorRotationSpeed() {return null;}
	private final byte[] _getCompressorRotationSpeed(byte epc) {
		byte[] edt = getCompressorRotationSpeed();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption<br>EPC : 0xDA<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredElectricCurrentConsumption() {return null;}
	private final byte[] _getMeasuredElectricCurrentConsumption(byte epc) {
		byte[] edt = getMeasuredElectricCurrentConsumption();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the rated power consumption.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Rated power consumption<br>EPC : 0xDC<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRatedPowerConsumption() {return null;}
	private final byte[] _getRatedPowerConsumption(byte epc) {
		byte[] edt = getRatedPowerConsumption();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Name : Quick freeze function setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setQuickFreezeFunctionSetting(byte[] edt) {return false;}
	private final boolean _setQuickFreezeFunctionSetting(byte epc, byte[] edt) {
		boolean success = setQuickFreezeFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Name : Quick freeze function setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getQuickFreezeFunctionSetting() {return null;}
	private final byte[] _getQuickFreezeFunctionSetting(byte epc) {
		byte[] edt = getQuickFreezeFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Name : Quick refrigeration function setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setQuickRefrigerationFunctionSetting(byte[] edt) {return false;}
	private final boolean _setQuickRefrigerationFunctionSetting(byte epc, byte[] edt) {
		boolean success = setQuickRefrigerationFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Name : Quick refrigeration function setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getQuickRefrigerationFunctionSetting() {return null;}
	private final byte[] _getQuickRefrigerationFunctionSetting(byte epc) {
		byte[] edt = getQuickRefrigerationFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br><br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Name : Icemaker setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setIcemakerSetting(byte[] edt) {return false;}
	private final boolean _setIcemakerSetting(byte epc, byte[] edt) {
		boolean success = setIcemakerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br><br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Name : Icemaker setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getIcemakerSetting() {return null;}
	private final byte[] _getIcemakerSetting(byte epc) {
		byte[] edt = getIcemakerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the status of the automatic icemaker of the refrigerator.<br><br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42<br><br>Name : Icemaker operation status<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getIcemakerOperationStatus() {return null;}
	private final byte[] _getIcemakerOperationStatus(byte epc) {
		byte[] edt = getIcemakerOperationStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br><br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42<br><br>Name : Icemaker tank status<br>EPC : 0xA6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getIcemakerTankStatus() {return null;}
	private final byte[] _getIcemakerTankStatus(byte epc) {
		byte[] edt = getIcemakerTankStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Refrigerator compartment humidification function setting<br>EPC : 0xA8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt) {return false;}
	private final boolean _setRefrigeratorCompartmentHumidificationFunctionSetting(byte epc, byte[] edt) {
		boolean success = setRefrigeratorCompartmentHumidificationFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Refrigerator compartment humidification function setting<br>EPC : 0xA8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRefrigeratorCompartmentHumidificationFunctionSetting() {return null;}
	private final byte[] _getRefrigeratorCompartmentHumidificationFunctionSetting(byte epc) {
		byte[] edt = getRefrigeratorCompartmentHumidificationFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Vegetable compartment humidification function setting<br>EPC : 0xA9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setVegetableCompartmentHumidificationFunctionSetting(byte[] edt) {return false;}
	private final boolean _setVegetableCompartmentHumidificationFunctionSetting(byte epc, byte[] edt) {
		boolean success = setVegetableCompartmentHumidificationFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Vegetable compartment humidification function setting<br>EPC : 0xA9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getVegetableCompartmentHumidificationFunctionSetting() {return null;}
	private final byte[] _getVegetableCompartmentHumidificationFunctionSetting(byte epc) {
		byte[] edt = getVegetableCompartmentHumidificationFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Deodorization function setting<br>EPC : 0xAD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDeodorizationFunctionSetting(byte[] edt) {return false;}
	private final boolean _setDeodorizationFunctionSetting(byte epc, byte[] edt) {
		boolean success = setDeodorizationFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Deodorization function setting<br>EPC : 0xAD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDeodorizationFunctionSetting() {return null;}
	private final byte[] _getDeodorizationFunctionSetting(byte epc) {
		byte[] edt = getDeodorizationFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setRefrigeratorCompartmentTemperatureSetting(epc, edt));
			break;
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setFreezerCompartmentTemperatureSetting(epc, edt));
			break;
		case EPC_ICE_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setIceTemperatureSetting(epc, edt));
			break;
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setVegetableCompartmentTemperatureSetting(epc, edt));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setMultiRefrigeraTingModeCompartmentTemperatureSetting(epc, edt));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, _setRefrigeratorCompartmentTemperatureLevelSetting(epc, edt));
			break;
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, _setFreezerCompartmentTemperatureLevelSetting(epc, edt));
			break;
		case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, _setIceCompartmentTemperatureLevelSetting(epc, edt));
			break;
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, _setVegetableCompartmentTemperatureLevelSetting(epc, edt));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, _setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(epc, edt));
			break;
		case EPC_QUICK_FREEZE_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setQuickFreezeFunctionSetting(epc, edt));
			break;
		case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setQuickRefrigerationFunctionSetting(epc, edt));
			break;
		case EPC_ICEMAKER_SETTING:
			res.addProperty(epc, edt, _setIcemakerSetting(epc, edt));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setRefrigeratorCompartmentHumidificationFunctionSetting(epc, edt));
			break;
		case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setVegetableCompartmentHumidificationFunctionSetting(epc, edt));
			break;
		case EPC_DEODORIZATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setDeodorizationFunctionSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_DOOR_OPEN_CLOSE_STATUS:
			edt = _getDoorOpenCloseStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DOOR_OPEN_WARNING:
			edt = _getDoorOpenWarning(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS:
			edt = _getRefrigeratorCompartmentDoorStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FREEZER_COMPARTMENT_DOOR_STATUS:
			edt = _getFreezerCompartmentDoorStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICE_COMPARTMENT_DOOR_STATUS:
			edt = _getIceCompartmentDoorStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS:
			edt = _getVegetableCompartmentDoorStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR:
			edt = _getMultiRefrigeraTingModeCompartmentDoor(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL:
			edt = _getMaximumAllowableTemperatureSettingLevel(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING:
			edt = _getRefrigeratorCompartmentTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING:
			edt = _getFreezerCompartmentTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICE_TEMPERATURE_SETTING:
			edt = _getIceTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING:
			edt = _getVegetableCompartmentTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING:
			edt = _getMultiRefrigeraTingModeCompartmentTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = _getRefrigeratorCompartmentTemperatureLevelSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = _getFreezerCompartmentTemperatureLevelSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = _getIceCompartmentTemperatureLevelSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = _getVegetableCompartmentTemperatureLevelSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = _getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE:
			edt = _getMeasuredRefrigeratorCompartmentTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE:
			edt = _getMeasuredFreezerCompartmentTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE:
			edt = _getMeasuredSubzeroFreshCompartmentTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE:
			edt = _getMeasuredVegetableCompartmentTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE:
			edt = _getMeasuredMultiRefrigeratinGModeCompartmentTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_COMPRESSOR_ROTATION_SPEED:
			edt = _getCompressorRotationSpeed(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION:
			edt = _getMeasuredElectricCurrentConsumption(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_CONSUMPTION:
			edt = _getRatedPowerConsumption(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_QUICK_FREEZE_FUNCTION_SETTING:
			edt = _getQuickFreezeFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING:
			edt = _getQuickRefrigerationFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICEMAKER_SETTING:
			edt = _getIcemakerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICEMAKER_OPERATION_STATUS:
			edt = _getIcemakerOperationStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICEMAKER_TANK_STATUS:
			edt = _getIcemakerTankStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
			edt = _getRefrigeratorCompartmentHumidificationFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
			edt = _getVegetableCompartmentHumidificationFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DEODORIZATION_FUNCTION_SETTING:
			edt = _getDeodorizationFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING:
				_onSetRefrigeratorCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING:
				_onSetFreezerCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ICE_TEMPERATURE_SETTING:
				_onSetIceTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING:
				_onSetVegetableCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING:
				_onSetMultiRefrigeraTingModeCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onSetRefrigeratorCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onSetFreezerCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onSetIceCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onSetVegetableCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_QUICK_FREEZE_FUNCTION_SETTING:
				_onSetQuickFreezeFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING:
				_onSetQuickRefrigerationFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ICEMAKER_SETTING:
				_onSetIcemakerSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
				_onSetRefrigeratorCompartmentHumidificationFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
				_onSetVegetableCompartmentHumidificationFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_DEODORIZATION_FUNCTION_SETTING:
				_onSetDeodorizationFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_DOOR_OPEN_CLOSE_STATUS:
				_onGetDoorOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DOOR_OPEN_WARNING:
				_onGetDoorOpenWarning(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS:
				_onGetRefrigeratorCompartmentDoorStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FREEZER_COMPARTMENT_DOOR_STATUS:
				_onGetFreezerCompartmentDoorStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ICE_COMPARTMENT_DOOR_STATUS:
				_onGetIceCompartmentDoorStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS:
				_onGetVegetableCompartmentDoorStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR:
				_onGetMultiRefrigeraTingModeCompartmentDoor(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL:
				_onGetMaximumAllowableTemperatureSettingLevel(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING:
				_onGetRefrigeratorCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING:
				_onGetFreezerCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ICE_TEMPERATURE_SETTING:
				_onGetIceTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING:
				_onGetVegetableCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING:
				_onGetMultiRefrigeraTingModeCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onGetRefrigeratorCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onGetFreezerCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onGetIceCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onGetVegetableCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				_onGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE:
				_onGetMeasuredRefrigeratorCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE:
				_onGetMeasuredFreezerCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE:
				_onGetMeasuredSubzeroFreshCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE:
				_onGetMeasuredVegetableCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE:
				_onGetMeasuredMultiRefrigeratinGModeCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_COMPRESSOR_ROTATION_SPEED:
				_onGetCompressorRotationSpeed(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION:
				_onGetMeasuredElectricCurrentConsumption(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION:
				_onGetRatedPowerConsumption(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_QUICK_FREEZE_FUNCTION_SETTING:
				_onGetQuickFreezeFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING:
				_onGetQuickRefrigerationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ICEMAKER_SETTING:
				_onGetIcemakerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ICEMAKER_OPERATION_STATUS:
				_onGetIcemakerOperationStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ICEMAKER_TANK_STATUS:
				_onGetIcemakerTankStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
				_onGetRefrigeratorCompartmentHumidificationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
				_onGetVegetableCompartmentHumidificationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DEODORIZATION_FUNCTION_SETTING:
				_onGetDeodorizationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Door open/close status<br><br>Door open = 0x41, Door close = 0x42<br><br>Name : Door open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDoorOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Door open warning status<br><br>Door open warning found = 0x41 Door open warning not found = 0x42<br><br>Name : Door open warning<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetDoorOpenWarning(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDoorOpenWarning(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDoorOpenWarning(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Refrigerator compartment door status<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRefrigeratorCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRefrigeratorCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRefrigeratorCompartmentDoorStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Freezer compartment door status<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetFreezerCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFreezerCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFreezerCompartmentDoorStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Ice compartment door status<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetIceCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIceCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIceCompartmentDoorStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Vegetable compartment door status<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetVegetableCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVegetableCompartmentDoorStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVegetableCompartmentDoorStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Multi-refrigera- ting mode compartment door<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMultiRefrigeraTingModeCompartmentDoor(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMultiRefrigeraTingModeCompartmentDoor(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMultiRefrigeraTingModeCompartmentDoor(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br><br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment<br><br>Name : Maximum allowable temperature setting level<br>EPC : 0xE0<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMaximumAllowableTemperatureSettingLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMaximumAllowableTemperatureSettingLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMaximumAllowableTemperatureSettingLevel(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Refrigerator compartment temperature setting<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRefrigeratorCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Refrigerator compartment temperature setting<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRefrigeratorCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Freezer compartment temperature setting<br>EPC : 0xE3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetFreezerCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Freezer compartment temperature setting<br>EPC : 0xE3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFreezerCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Ice temperature setting<br>EPC : 0xE4<br>Data Type : signed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetIceTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetIceTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetIceTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Ice temperature setting<br>EPC : 0xE4<br>Data Type : signed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetIceTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIceTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIceTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Vegetable compartment temperature setting<br>EPC : 0xE5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVegetableCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Vegetable compartment temperature setting<br>EPC : 0xE5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVegetableCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Multi-refrigera- ting mode compartment temperature setting<br>EPC : 0xE6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetMultiRefrigeraTingModeCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Multi-refrigera- ting mode compartment temperature setting<br>EPC : 0xE6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMultiRefrigeraTingModeCompartmentTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Refrigerator compartment temperature level setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRefrigeratorCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Refrigerator compartment temperature level setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRefrigeratorCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Freezer compartment temperature level setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetFreezerCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Freezer compartment temperature level setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFreezerCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : ice compartment temperature level setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetIceCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : ice compartment temperature level setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIceCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Vegetable compartment temperature level setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVegetableCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Vegetable compartment temperature level setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVegetableCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Multi-refrigera- ting mode compartment temperature level setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Multi-refrigera- ting mode compartment temperature level setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured refrigerator compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured refrigerator compartment temperature<br>EPC : 0xD1<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredRefrigeratorCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredRefrigeratorCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredRefrigeratorCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured freezer compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured freezer compartment temperature<br>EPC : 0xD2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredFreezerCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredFreezerCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredFreezerCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured meat and fish compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured subzero-fresh compartment temperature<br>EPC : 0xD3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredSubzeroFreshCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredSubzeroFreshCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredSubzeroFreshCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured vegetable compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured vegetable compartment temperature<br>EPC : 0xD4<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredVegetableCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredVegetableCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredVegetableCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured multi-refrigeratin g mode compartment temperature<br>EPC : 0xD5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredMultiRefrigeratinGModeCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredMultiRefrigeratinGModeCompartmentTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredMultiRefrigeratinGModeCompartmentTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br><br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)<br><br>Name : Compressor rotation speed<br>EPC : 0xD8<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetCompressorRotationSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCompressorRotationSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCompressorRotationSpeed(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption<br>EPC : 0xDA<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredElectricCurrentConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredElectricCurrentConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredElectricCurrentConsumption(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the rated power consumption.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Rated power consumption<br>EPC : 0xDC<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRatedPowerConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedPowerConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedPowerConsumption(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Name : Quick freeze function setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetQuickFreezeFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetQuickFreezeFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetQuickFreezeFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Name : Quick freeze function setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetQuickFreezeFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetQuickFreezeFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetQuickFreezeFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Name : Quick refrigeration function setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetQuickRefrigerationFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Name : Quick refrigeration function setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetQuickRefrigerationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br><br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Name : Icemaker setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetIcemakerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetIcemakerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetIcemakerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br><br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Name : Icemaker setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetIcemakerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIcemakerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIcemakerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br><br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42<br><br>Name : Icemaker operation status<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetIcemakerOperationStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIcemakerOperationStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIcemakerOperationStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br><br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42<br><br>Name : Icemaker tank status<br>EPC : 0xA6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetIcemakerTankStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIcemakerTankStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIcemakerTankStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Refrigerator compartment humidification function setting<br>EPC : 0xA8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRefrigeratorCompartmentHumidificationFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Refrigerator compartment humidification function setting<br>EPC : 0xA8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRefrigeratorCompartmentHumidificationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Vegetable compartment humidification function setting<br>EPC : 0xA9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVegetableCompartmentHumidificationFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Vegetable compartment humidification function setting<br>EPC : 0xA9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVegetableCompartmentHumidificationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Deodorization function setting<br>EPC : 0xAD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDeodorizationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDeodorizationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDeodorizationFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Deodorization function setting<br>EPC : 0xAD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDeodorizationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDeodorizationFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDeodorizationFunctionSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Refrigerator compartment temperature setting<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRefrigeratorCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Freezer compartment temperature setting<br>EPC : 0xE3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetFreezerCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Ice temperature setting<br>EPC : 0xE4<br>Data Type : signed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetIceTemperatureSetting(byte[] edt) {
			addProperty(EPC_ICE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Vegetable compartment temperature setting<br>EPC : 0xE5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetVegetableCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Multi-refrigera- ting mode compartment temperature setting<br>EPC : 0xE6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Refrigerator compartment temperature level setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Freezer compartment temperature level setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetFreezerCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : ice compartment temperature level setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetIceCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Vegetable compartment temperature level setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetVegetableCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Multi-refrigera- ting mode compartment temperature level setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Name : Quick freeze function setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetQuickFreezeFunctionSetting(byte[] edt) {
			addProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Name : Quick refrigeration function setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetQuickRefrigerationFunctionSetting(byte[] edt) {
			addProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br><br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Name : Icemaker setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetIcemakerSetting(byte[] edt) {
			addProperty(EPC_ICEMAKER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Refrigerator compartment humidification function setting<br>EPC : 0xA8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt) {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Vegetable compartment humidification function setting<br>EPC : 0xA9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetVegetableCompartmentHumidificationFunctionSetting(byte[] edt) {
			addProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Deodorization function setting<br>EPC : 0xAD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDeodorizationFunctionSetting(byte[] edt) {
			addProperty(EPC_DEODORIZATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Door open/close status<br><br>Door open = 0x41, Door close = 0x42<br><br>Name : Door open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetDoorOpenCloseStatus() {
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Door open warning status<br><br>Door open warning found = 0x41 Door open warning not found = 0x42<br><br>Name : Door open warning<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetDoorOpenWarning() {
			addProperty(EPC_DOOR_OPEN_WARNING);
			return this;
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Refrigerator compartment door status<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRefrigeratorCompartmentDoorStatus() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Freezer compartment door status<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetFreezerCompartmentDoorStatus() {
			addProperty(EPC_FREEZER_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Ice compartment door status<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetIceCompartmentDoorStatus() {
			addProperty(EPC_ICE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Vegetable compartment door status<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetVegetableCompartmentDoorStatus() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		/**
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Multi-refrigera- ting mode compartment door<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMultiRefrigeraTingModeCompartmentDoor() {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR);
			return this;
		}
		/**
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br><br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment<br><br>Name : Maximum allowable temperature setting level<br>EPC : 0xE0<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMaximumAllowableTemperatureSettingLevel() {
			addProperty(EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL);
			return this;
		}
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Refrigerator compartment temperature setting<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRefrigeratorCompartmentTemperatureSetting() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Freezer compartment temperature setting<br>EPC : 0xE3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetFreezerCompartmentTemperatureSetting() {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Ice temperature setting<br>EPC : 0xE4<br>Data Type : signed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetIceTemperatureSetting() {
			addProperty(EPC_ICE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Vegetable compartment temperature setting<br>EPC : 0xE5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetVegetableCompartmentTemperatureSetting() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Multi-refrigera- ting mode compartment temperature setting<br>EPC : 0xE6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureSetting() {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Refrigerator compartment temperature level setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRefrigeratorCompartmentTemperatureLevelSetting() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Freezer compartment temperature level setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetFreezerCompartmentTemperatureLevelSetting() {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : ice compartment temperature level setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetIceCompartmentTemperatureLevelSetting() {
			addProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Vegetable compartment temperature level setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetVegetableCompartmentTemperatureLevelSetting() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Multi-refrigera- ting mode compartment temperature level setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		/**
		 * Used to acquire the measured refrigerator compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured refrigerator compartment temperature<br>EPC : 0xD1<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredRefrigeratorCompartmentTemperature() {
			addProperty(EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Used to acquire the measured freezer compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured freezer compartment temperature<br>EPC : 0xD2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredFreezerCompartmentTemperature() {
			addProperty(EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Used to acquire the measured meat and fish compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured subzero-fresh compartment temperature<br>EPC : 0xD3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredSubzeroFreshCompartmentTemperature() {
			addProperty(EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Used to acquire the measured vegetable compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured vegetable compartment temperature<br>EPC : 0xD4<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredVegetableCompartmentTemperature() {
			addProperty(EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured multi-refrigeratin g mode compartment temperature<br>EPC : 0xD5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredMultiRefrigeratinGModeCompartmentTemperature() {
			addProperty(EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		/**
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br><br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)<br><br>Name : Compressor rotation speed<br>EPC : 0xD8<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetCompressorRotationSpeed() {
			addProperty(EPC_COMPRESSOR_ROTATION_SPEED);
			return this;
		}
		/**
		 * Used to acquire the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption<br>EPC : 0xDA<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredElectricCurrentConsumption() {
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION);
			return this;
		}
		/**
		 * Used to acquire the rated power consumption.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Rated power consumption<br>EPC : 0xDC<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRatedPowerConsumption() {
			addProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Name : Quick freeze function setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetQuickFreezeFunctionSetting() {
			addProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Name : Quick refrigeration function setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetQuickRefrigerationFunctionSetting() {
			addProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br><br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Name : Icemaker setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetIcemakerSetting() {
			addProperty(EPC_ICEMAKER_SETTING);
			return this;
		}
		/**
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br><br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42<br><br>Name : Icemaker operation status<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetIcemakerOperationStatus() {
			addProperty(EPC_ICEMAKER_OPERATION_STATUS);
			return this;
		}
		/**
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br><br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42<br><br>Name : Icemaker tank status<br>EPC : 0xA6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetIcemakerTankStatus() {
			addProperty(EPC_ICEMAKER_TANK_STATUS);
			return this;
		}
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Refrigerator compartment humidification function setting<br>EPC : 0xA8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRefrigeratorCompartmentHumidificationFunctionSetting() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Vegetable compartment humidification function setting<br>EPC : 0xA9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetVegetableCompartmentHumidificationFunctionSetting() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Deodorization function setting<br>EPC : 0xAD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDeodorizationFunctionSetting() {
			addProperty(EPC_DEODORIZATION_FUNCTION_SETTING);
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
		 * Door open/close status<br><br>Door open = 0x41, Door close = 0x42<br><br>Name : Door open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformDoorOpenCloseStatus();
		/**
		 * Door open warning status<br><br>Door open warning found = 0x41 Door open warning not found = 0x42<br><br>Name : Door open warning<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformDoorOpenWarning();
		/**
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Refrigerator compartment door status<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRefrigeratorCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Freezer compartment door status<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformFreezerCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Ice compartment door status<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformIceCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Vegetable compartment door status<br>EPC : 0xB5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformVegetableCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br><br>Open = 0x41, closed = 0x42<br><br>Name : Multi-refrigera- ting mode compartment door<br>EPC : 0xB6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMultiRefrigeraTingModeCompartmentDoor();
		/**
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br><br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment<br><br>Name : Maximum allowable temperature setting level<br>EPC : 0xE0<br>Data Type : unsigned char x 8<br>Data Size(Byte) : 8 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMaximumAllowableTemperatureSettingLevel();
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Refrigerator compartment temperature setting<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRefrigeratorCompartmentTemperatureSetting();
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Freezer compartment temperature setting<br>EPC : 0xE3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformFreezerCompartmentTemperatureSetting();
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Ice temperature setting<br>EPC : 0xE4<br>Data Type : signed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformIceTemperatureSetting();
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Vegetable compartment temperature setting<br>EPC : 0xE5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformVegetableCompartmentTemperatureSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Multi-refrigera- ting mode compartment temperature setting<br>EPC : 0xE6<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureSetting();
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Refrigerator compartment temperature level setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRefrigeratorCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Freezer compartment temperature level setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformFreezerCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : ice compartment temperature level setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformIceCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Vegetable compartment temperature level setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformVegetableCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br><br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Name : Multi-refrigera- ting mode compartment temperature level setting<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
		/**
		 * Used to acquire the measured refrigerator compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured refrigerator compartment temperature<br>EPC : 0xD1<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredRefrigeratorCompartmentTemperature();
		/**
		 * Used to acquire the measured freezer compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured freezer compartment temperature<br>EPC : 0xD2<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredFreezerCompartmentTemperature();
		/**
		 * Used to acquire the measured meat and fish compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured subzero-fresh compartment temperature<br>EPC : 0xD3<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredSubzeroFreshCompartmentTemperature();
		/**
		 * Used to acquire the measured vegetable compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured vegetable compartment temperature<br>EPC : 0xD4<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredVegetableCompartmentTemperature();
		/**
		 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br><br>0x81 to 0x7E (-127 to 126��C)<br><br>Name : Measured multi-refrigeratin g mode compartment temperature<br>EPC : 0xD5<br>Data Type : signed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredMultiRefrigeratinGModeCompartmentTemperature();
		/**
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br><br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)<br><br>Name : Compressor rotation speed<br>EPC : 0xD8<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformCompressorRotationSpeed();
		/**
		 * Used to acquire the measured electric current consumption.<br><br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Name : Measured electric current consumption<br>EPC : 0xDA<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredElectricCurrentConsumption();
		/**
		 * Used to acquire the rated power consumption.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Rated power consumption<br>EPC : 0xDC<br>Data Type : unsigned char<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRatedPowerConsumption();
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Name : Quick freeze function setting<br>EPC : 0xA0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformQuickFreezeFunctionSetting();
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br><br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Name : Quick refrigeration function setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformQuickRefrigerationFunctionSetting();
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br><br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Name : Icemaker setting<br>EPC : 0xA4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformIcemakerSetting();
		/**
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br><br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42<br><br>Name : Icemaker operation status<br>EPC : 0xA5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformIcemakerOperationStatus();
		/**
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br><br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42<br><br>Name : Icemaker tank status<br>EPC : 0xA6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformIcemakerTankStatus();
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Refrigerator compartment humidification function setting<br>EPC : 0xA8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRefrigeratorCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Vegetable compartment humidification function setting<br>EPC : 0xA9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformVegetableCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br><br>ON = 0x41 OFF = 0x42<br><br>Name : Deodorization function setting<br>EPC : 0xAD<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDeodorizationFunctionSetting();
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
		public Informer reqInformDoorOpenCloseStatus() {
			byte epc = EPC_DOOR_OPEN_CLOSE_STATUS;
			byte[] edt = _getDoorOpenCloseStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDoorOpenWarning() {
			byte epc = EPC_DOOR_OPEN_WARNING;
			byte[] edt = _getDoorOpenWarning(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentDoorStatus() {
			byte epc = EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS;
			byte[] edt = _getRefrigeratorCompartmentDoorStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFreezerCompartmentDoorStatus() {
			byte epc = EPC_FREEZER_COMPARTMENT_DOOR_STATUS;
			byte[] edt = _getFreezerCompartmentDoorStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIceCompartmentDoorStatus() {
			byte epc = EPC_ICE_COMPARTMENT_DOOR_STATUS;
			byte[] edt = _getIceCompartmentDoorStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentDoorStatus() {
			byte epc = EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS;
			byte[] edt = _getVegetableCompartmentDoorStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMultiRefrigeraTingModeCompartmentDoor() {
			byte epc = EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR;
			byte[] edt = _getMultiRefrigeraTingModeCompartmentDoor(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMaximumAllowableTemperatureSettingLevel() {
			byte epc = EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL;
			byte[] edt = _getMaximumAllowableTemperatureSettingLevel(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentTemperatureSetting() {
			byte epc = EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING;
			byte[] edt = _getRefrigeratorCompartmentTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFreezerCompartmentTemperatureSetting() {
			byte epc = EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING;
			byte[] edt = _getFreezerCompartmentTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIceTemperatureSetting() {
			byte epc = EPC_ICE_TEMPERATURE_SETTING;
			byte[] edt = _getIceTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentTemperatureSetting() {
			byte epc = EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING;
			byte[] edt = _getVegetableCompartmentTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureSetting() {
			byte epc = EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING;
			byte[] edt = _getMultiRefrigeraTingModeCompartmentTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentTemperatureLevelSetting() {
			byte epc = EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING;
			byte[] edt = _getRefrigeratorCompartmentTemperatureLevelSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFreezerCompartmentTemperatureLevelSetting() {
			byte epc = EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING;
			byte[] edt = _getFreezerCompartmentTemperatureLevelSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIceCompartmentTemperatureLevelSetting() {
			byte epc = EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING;
			byte[] edt = _getIceCompartmentTemperatureLevelSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentTemperatureLevelSetting() {
			byte epc = EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING;
			byte[] edt = _getVegetableCompartmentTemperatureLevelSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {
			byte epc = EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING;
			byte[] edt = _getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRefrigeratorCompartmentTemperature() {
			byte epc = EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE;
			byte[] edt = _getMeasuredRefrigeratorCompartmentTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredFreezerCompartmentTemperature() {
			byte epc = EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE;
			byte[] edt = _getMeasuredFreezerCompartmentTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredSubzeroFreshCompartmentTemperature() {
			byte epc = EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE;
			byte[] edt = _getMeasuredSubzeroFreshCompartmentTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredVegetableCompartmentTemperature() {
			byte epc = EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE;
			byte[] edt = _getMeasuredVegetableCompartmentTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredMultiRefrigeratinGModeCompartmentTemperature() {
			byte epc = EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE;
			byte[] edt = _getMeasuredMultiRefrigeratinGModeCompartmentTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCompressorRotationSpeed() {
			byte epc = EPC_COMPRESSOR_ROTATION_SPEED;
			byte[] edt = _getCompressorRotationSpeed(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredElectricCurrentConsumption() {
			byte epc = EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION;
			byte[] edt = _getMeasuredElectricCurrentConsumption(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumption() {
			byte epc = EPC_RATED_POWER_CONSUMPTION;
			byte[] edt = _getRatedPowerConsumption(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformQuickFreezeFunctionSetting() {
			byte epc = EPC_QUICK_FREEZE_FUNCTION_SETTING;
			byte[] edt = _getQuickFreezeFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformQuickRefrigerationFunctionSetting() {
			byte epc = EPC_QUICK_REFRIGERATION_FUNCTION_SETTING;
			byte[] edt = _getQuickRefrigerationFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIcemakerSetting() {
			byte epc = EPC_ICEMAKER_SETTING;
			byte[] edt = _getIcemakerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIcemakerOperationStatus() {
			byte epc = EPC_ICEMAKER_OPERATION_STATUS;
			byte[] edt = _getIcemakerOperationStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIcemakerTankStatus() {
			byte epc = EPC_ICEMAKER_TANK_STATUS;
			byte[] edt = _getIcemakerTankStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentHumidificationFunctionSetting() {
			byte epc = EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING;
			byte[] edt = _getRefrigeratorCompartmentHumidificationFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentHumidificationFunctionSetting() {
			byte epc = EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING;
			byte[] edt = _getVegetableCompartmentHumidificationFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDeodorizationFunctionSetting() {
			byte epc = EPC_DEODORIZATION_FUNCTION_SETTING;
			byte[] edt = _getDeodorizationFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformDoorOpenCloseStatus() {
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Informer reqInformDoorOpenWarning() {
			addProperty(EPC_DOOR_OPEN_WARNING);
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentDoorStatus() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		@Override
		public Informer reqInformFreezerCompartmentDoorStatus() {
			addProperty(EPC_FREEZER_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		@Override
		public Informer reqInformIceCompartmentDoorStatus() {
			addProperty(EPC_ICE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentDoorStatus() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		@Override
		public Informer reqInformMultiRefrigeraTingModeCompartmentDoor() {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR);
			return this;
		}
		@Override
		public Informer reqInformMaximumAllowableTemperatureSettingLevel() {
			addProperty(EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL);
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentTemperatureSetting() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformFreezerCompartmentTemperatureSetting() {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformIceTemperatureSetting() {
			addProperty(EPC_ICE_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentTemperatureSetting() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureSetting() {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentTemperatureLevelSetting() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformFreezerCompartmentTemperatureLevelSetting() {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformIceCompartmentTemperatureLevelSetting() {
			addProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentTemperatureLevelSetting() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredRefrigeratorCompartmentTemperature() {
			addProperty(EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredFreezerCompartmentTemperature() {
			addProperty(EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredSubzeroFreshCompartmentTemperature() {
			addProperty(EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredVegetableCompartmentTemperature() {
			addProperty(EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredMultiRefrigeratinGModeCompartmentTemperature() {
			addProperty(EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformCompressorRotationSpeed() {
			addProperty(EPC_COMPRESSOR_ROTATION_SPEED);
			return this;
		}
		@Override
		public Informer reqInformMeasuredElectricCurrentConsumption() {
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumption() {
			addProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		@Override
		public Informer reqInformQuickFreezeFunctionSetting() {
			addProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformQuickRefrigerationFunctionSetting() {
			addProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformIcemakerSetting() {
			addProperty(EPC_ICEMAKER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformIcemakerOperationStatus() {
			addProperty(EPC_ICEMAKER_OPERATION_STATUS);
			return this;
		}
		@Override
		public Informer reqInformIcemakerTankStatus() {
			addProperty(EPC_ICEMAKER_TANK_STATUS);
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentHumidificationFunctionSetting() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentHumidificationFunctionSetting() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformDeodorizationFunctionSetting() {
			addProperty(EPC_DEODORIZATION_FUNCTION_SETTING);
			return this;
		}
	}
}
