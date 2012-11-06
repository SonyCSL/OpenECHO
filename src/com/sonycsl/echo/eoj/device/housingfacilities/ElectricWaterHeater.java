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

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class ElectricWaterHeater extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x6B;
	
	public ElectricWaterHeater() {
		setReceiver(new Receiver());
	}

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
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br><br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Name : �gAutomatic water heating�h setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGautomaticWaterHeatingHSetting(byte[] edt) {return false;}
	private final boolean _setGautomaticWaterHeatingHSetting(byte epc, byte[] edt) {
		boolean success = setGautomaticWaterHeatingHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br><br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Name : �gAutomatic water heating�h setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGautomaticWaterHeatingHSetting() {return null;}
	private final byte[] _getGautomaticWaterHeatingHSetting(byte epc) {
		byte[] edt = getGautomaticWaterHeatingHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br><br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Name : �gAutomatic water temperature control�h setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGautomaticWaterTemperatureControlHSetting(byte[] edt) {return false;}
	private final boolean _setGautomaticWaterTemperatureControlHSetting(byte epc, byte[] edt) {
		boolean success = setGautomaticWaterTemperatureControlHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br><br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Name : �gAutomatic water temperature control�h setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGautomaticWaterTemperatureControlHSetting() {return null;}
	private final byte[] _getGautomaticWaterTemperatureControlHSetting(byte epc) {
		byte[] edt = getGautomaticWaterTemperatureControlHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br><br>Heating = 0x41 Not heating = 0x42<br><br>Name : Water heater status<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getWaterHeaterStatus() {return null;}
	private final byte[] _getWaterHeaterStatus(byte epc) {
		byte[] edt = getWaterHeaterStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Water heating temperature setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract boolean setWaterHeatingTemperatureSetting(byte[] edt);
	private final boolean _setWaterHeatingTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setWaterHeatingTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Water heating temperature setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract byte[] getWaterHeatingTemperatureSetting();
	private final byte[] _getWaterHeatingTemperatureSetting(byte epc) {
		byte[] edt = getWaterHeatingTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br><br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Name : �gDaytime reheating permission�h setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGdaytimeReheatingPermissionHSetting(byte[] edt) {return false;}
	private final boolean _setGdaytimeReheatingPermissionHSetting(byte epc, byte[] edt) {
		boolean success = setGdaytimeReheatingPermissionHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br><br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Name : �gDaytime reheating permission�h setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGdaytimeReheatingPermissionHSetting() {return null;}
	private final byte[] _getGdaytimeReheatingPermissionHSetting(byte epc) {
		byte[] edt = getGdaytimeReheatingPermissionHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the current temperature of the water in the water heater.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Measured temperature of water in water heater<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredTemperatureOfWaterInWaterHeater() {return null;}
	private final byte[] _getMeasuredTemperatureOfWaterInWaterHeater(byte epc) {
		byte[] edt = getMeasuredTemperatureOfWaterInWaterHeater();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : �gTemperature of supplied water�h setting<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGtemperatureOfSuppliedWaterHSetting(byte[] edt) {return false;}
	private final boolean _setGtemperatureOfSuppliedWaterHSetting(byte epc, byte[] edt) {
		boolean success = setGtemperatureOfSuppliedWaterHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : �gTemperature of supplied water�h setting<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGtemperatureOfSuppliedWaterHSetting() {return null;}
	private final byte[] _getGtemperatureOfSuppliedWaterHSetting(byte epc) {
		byte[] edt = getGtemperatureOfSuppliedWaterHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Bath water temperature setting<br>EPC : 0xD3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathWaterTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setBathWaterTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setBathWaterTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Bath water temperature setting<br>EPC : 0xD3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathWaterTemperatureSetting() {return null;}
	private final byte[] _getBathWaterTemperatureSetting(byte epc) {
		byte[] edt = getBathWaterTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Bath water volume setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathWaterVolumeSetting(byte[] edt) {return false;}
	private final boolean _setBathWaterVolumeSetting(byte epc, byte[] edt) {
		boolean success = setBathWaterVolumeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Bath water volume setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathWaterVolumeSetting() {return null;}
	private final byte[] _getBathWaterVolumeSetting(byte epc) {
		byte[] edt = getBathWaterVolumeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured amount of water left in the tank in liters.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Measured amount of water remaining in tank<br>EPC : 0xE1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredAmountOfWaterRemainingInTank() {return null;}
	private final byte[] _getMeasuredAmountOfWaterRemainingInTank(byte epc) {
		byte[] edt = getMeasuredAmountOfWaterRemainingInTank();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the tank capacity in liters.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Tank capacity<br>EPC : 0xE2<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getTankCapacity() {return null;}
	private final byte[] _getTankCapacity(byte epc) {
		byte[] edt = getTankCapacity();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br><br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Name : �gAutomatic bath water heating�h mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGautomaticBathWaterHeatingHModeSetting(byte[] edt) {return false;}
	private final boolean _setGautomaticBathWaterHeatingHModeSetting(byte epc, byte[] edt) {
		boolean success = setGautomaticBathWaterHeatingHModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br><br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Name : �gAutomatic bath water heating�h mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGautomaticBathWaterHeatingHModeSetting() {return null;}
	private final byte[] _getGautomaticBathWaterHeatingHModeSetting(byte epc) {
		byte[] edt = getGautomaticBathWaterHeatingHModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br><br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Name : �gAddition of hot water�h function setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGadditionOfHotWaterHFunctionSetting(byte[] edt) {return false;}
	private final boolean _setGadditionOfHotWaterHFunctionSetting(byte epc, byte[] edt) {
		boolean success = setGadditionOfHotWaterHFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br><br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Name : �gAddition of hot water�h function setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGadditionOfHotWaterHFunctionSetting() {return null;}
	private final byte[] _getGadditionOfHotWaterHFunctionSetting(byte epc) {
		byte[] edt = getGadditionOfHotWaterHFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br><br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Name : �gSlight bath water temperature lowering�h function setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {return false;}
	private final boolean _setGslightBathWaterTemperatureLoweringHFunctionSetting(byte epc, byte[] edt) {
		boolean success = setGslightBathWaterTemperatureLoweringHFunctionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br><br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Name : �gSlight bath water temperature lowering�h function setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGslightBathWaterTemperatureLoweringHFunctionSetting() {return null;}
	private final byte[] _getGslightBathWaterTemperatureLoweringHFunctionSetting(byte epc) {
		byte[] edt = getGslightBathWaterTemperatureLoweringHFunctionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x00 to 0xFD (0 to 253 liters)<br><br>Name : Bath water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathWaterVolumeSetting1(byte[] edt) {return false;}
	private final boolean _setBathWaterVolumeSetting1(byte epc, byte[] edt) {
		boolean success = setBathWaterVolumeSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x00 to 0xFD (0 to 253 liters)<br><br>Name : Bath water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathWaterVolumeSetting1() {return null;}
	private final byte[] _getBathWaterVolumeSetting1(byte epc) {
		byte[] edt = getBathWaterVolumeSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Bath water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathWaterVolumeSetting2(byte[] edt) {return false;}
	private final boolean _setBathWaterVolumeSetting2(byte epc, byte[] edt) {
		boolean success = setBathWaterVolumeSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Bath water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathWaterVolumeSetting2() {return null;}
	private final byte[] _getBathWaterVolumeSetting2(byte epc) {
		byte[] edt = getBathWaterVolumeSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Bath water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathWaterVolumeSetting3(byte[] edt) {return false;}
	private final boolean _setBathWaterVolumeSetting3(byte epc, byte[] edt) {
		boolean success = setBathWaterVolumeSetting3(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Bath water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathWaterVolumeSetting3() {return null;}
	private final byte[] _getBathWaterVolumeSetting3(byte epc) {
		byte[] edt = getBathWaterVolumeSetting3();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * 0x31 to 0x38<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * 0x31 to 0x38<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * ON timer setting (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * ON timer setting (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerSetting() {return null;}
	private final byte[] _getOnTimerSetting(byte epc) {
		byte[] edt = getOnTimerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in wintertime<br>EPC : 0xDB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRatedPowerConsumptionOfHPUnitInWintertime() {return null;}
	private final byte[] _getRatedPowerConsumptionOfHPUnitInWintertime(byte epc) {
		byte[] edt = getRatedPowerConsumptionOfHPUnitInWintertime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the rated power consumption of the heat pump in in-between seasons (April, May, October, November)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in in-between seasons<br>EPC : 0xDC<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {return null;}
	private final byte[] _getRatedPowerConsumptionOfHPUnitInInBetweenSeasons(byte epc) {
		byte[] edt = getRatedPowerConsumptionOfHPUnitInInBetweenSeasons();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in summertime<br>EPC : 0xDD<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRatedPowerConsumptionOfHPUnitInSummertime() {return null;}
	private final byte[] _getRatedPowerConsumptionOfHPUnitInSummertime(byte epc) {
		byte[] edt = getRatedPowerConsumptionOfHPUnitInSummertime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING:
			res.addProperty(epc, edt, _setGautomaticWaterHeatingHSetting(epc, edt));
			break;
		case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING:
			res.addProperty(epc, edt, _setGautomaticWaterTemperatureControlHSetting(epc, edt));
			break;
		case EPC_WATER_HEATING_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setWaterHeatingTemperatureSetting(epc, edt));
			break;
		case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING:
			res.addProperty(epc, edt, _setGdaytimeReheatingPermissionHSetting(epc, edt));
			break;
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
			res.addProperty(epc, edt, _setGtemperatureOfSuppliedWaterHSetting(epc, edt));
			break;
		case EPC_BATH_WATER_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setBathWaterTemperatureSetting(epc, edt));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING:
			res.addProperty(epc, edt, _setBathWaterVolumeSetting(epc, edt));
			break;
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING:
			res.addProperty(epc, edt, _setGautomaticBathWaterHeatingHModeSetting(epc, edt));
			break;
		case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setGadditionOfHotWaterHFunctionSetting(epc, edt));
			break;
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setGslightBathWaterTemperatureLoweringHFunctionSetting(epc, edt));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING1:
			res.addProperty(epc, edt, _setBathWaterVolumeSetting1(epc, edt));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING2:
			res.addProperty(epc, edt, _setBathWaterVolumeSetting2(epc, edt));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING3:
			res.addProperty(epc, edt, _setBathWaterVolumeSetting3(epc, edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING:
			res.addProperty(epc, edt, _setOnTimerSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING:
			edt = _getGautomaticWaterHeatingHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING:
			edt = _getGautomaticWaterTemperatureControlHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_HEATER_STATUS:
			edt = _getWaterHeaterStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_HEATING_TEMPERATURE_SETTING:
			edt = _getWaterHeatingTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING:
			edt = _getGdaytimeReheatingPermissionHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER:
			edt = _getMeasuredTemperatureOfWaterInWaterHeater(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
			edt = _getGtemperatureOfSuppliedWaterHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_TEMPERATURE_SETTING:
			edt = _getBathWaterTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING:
			edt = _getBathWaterVolumeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK:
			edt = _getMeasuredAmountOfWaterRemainingInTank(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TANK_CAPACITY:
			edt = _getTankCapacity(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING:
			edt = _getGautomaticBathWaterHeatingHModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING:
			edt = _getGadditionOfHotWaterHFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
			edt = _getGslightBathWaterTemperatureLoweringHFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING1:
			edt = _getBathWaterVolumeSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING2:
			edt = _getBathWaterVolumeSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING3:
			edt = _getBathWaterVolumeSetting3(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = _getOnTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING:
			edt = _getOnTimerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME:
			edt = _getRatedPowerConsumptionOfHPUnitInWintertime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS:
			edt = _getRatedPowerConsumptionOfHPUnitInInBetweenSeasons(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME:
			edt = _getRatedPowerConsumptionOfHPUnitInSummertime(epc);
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
			case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING:
				_onSetGautomaticWaterHeatingHSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING:
				_onSetGautomaticWaterTemperatureControlHSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_WATER_HEATING_TEMPERATURE_SETTING:
				_onSetWaterHeatingTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING:
				_onSetGdaytimeReheatingPermissionHSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
				_onSetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_BATH_WATER_TEMPERATURE_SETTING:
				_onSetBathWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_BATH_WATER_VOLUME_SETTING:
				_onSetBathWaterVolumeSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING:
				_onSetGautomaticBathWaterHeatingHModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING:
				_onSetGadditionOfHotWaterHFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
				_onSetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_BATH_WATER_VOLUME_SETTING1:
				_onSetBathWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_BATH_WATER_VOLUME_SETTING2:
				_onSetBathWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_BATH_WATER_VOLUME_SETTING3:
				_onSetBathWaterVolumeSetting3(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ON_TIMER_SETTING:
				_onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING:
				_onGetGautomaticWaterHeatingHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING:
				_onGetGautomaticWaterTemperatureControlHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WATER_HEATER_STATUS:
				_onGetWaterHeaterStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WATER_HEATING_TEMPERATURE_SETTING:
				_onGetWaterHeatingTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING:
				_onGetGdaytimeReheatingPermissionHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER:
				_onGetMeasuredTemperatureOfWaterInWaterHeater(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
				_onGetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_TEMPERATURE_SETTING:
				_onGetBathWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_VOLUME_SETTING:
				_onGetBathWaterVolumeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK:
				_onGetMeasuredAmountOfWaterRemainingInTank(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TANK_CAPACITY:
				_onGetTankCapacity(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING:
				_onGetGautomaticBathWaterHeatingHModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING:
				_onGetGadditionOfHotWaterHFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
				_onGetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_VOLUME_SETTING1:
				_onGetBathWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_VOLUME_SETTING2:
				_onGetBathWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_VOLUME_SETTING3:
				_onGetBathWaterVolumeSetting3(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING:
				_onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME:
				_onGetRatedPowerConsumptionOfHPUnitInWintertime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS:
				_onGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME:
				_onGetRatedPowerConsumptionOfHPUnitInSummertime(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br><br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Name : �gAutomatic water heating�h setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGautomaticWaterHeatingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGautomaticWaterHeatingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGautomaticWaterHeatingHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br><br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Name : �gAutomatic water heating�h setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGautomaticWaterHeatingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGautomaticWaterHeatingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGautomaticWaterHeatingHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br><br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Name : �gAutomatic water temperature control�h setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGautomaticWaterTemperatureControlHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGautomaticWaterTemperatureControlHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGautomaticWaterTemperatureControlHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br><br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Name : �gAutomatic water temperature control�h setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGautomaticWaterTemperatureControlHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGautomaticWaterTemperatureControlHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGautomaticWaterTemperatureControlHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br><br>Heating = 0x41 Not heating = 0x42<br><br>Name : Water heater status<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetWaterHeaterStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWaterHeaterStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWaterHeaterStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Water heating temperature setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onSetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWaterHeatingTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Water heating temperature setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onGetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWaterHeatingTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br><br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Name : �gDaytime reheating permission�h setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGdaytimeReheatingPermissionHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGdaytimeReheatingPermissionHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGdaytimeReheatingPermissionHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br><br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Name : �gDaytime reheating permission�h setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGdaytimeReheatingPermissionHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGdaytimeReheatingPermissionHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGdaytimeReheatingPermissionHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the current temperature of the water in the water heater.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Measured temperature of water in water heater<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredTemperatureOfWaterInWaterHeater(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : �gTemperature of supplied water�h setting<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : �gTemperature of supplied water�h setting<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Bath water temperature setting<br>EPC : 0xD3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Bath water temperature setting<br>EPC : 0xD3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Bath water volume setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathWaterVolumeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterVolumeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterVolumeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Bath water volume setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathWaterVolumeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterVolumeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterVolumeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured amount of water left in the tank in liters.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Measured amount of water remaining in tank<br>EPC : 0xE1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredAmountOfWaterRemainingInTank(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredAmountOfWaterRemainingInTank(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredAmountOfWaterRemainingInTank(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the tank capacity in liters.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Tank capacity<br>EPC : 0xE2<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetTankCapacity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTankCapacity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTankCapacity(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br><br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Name : �gAutomatic bath water heating�h mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGautomaticBathWaterHeatingHModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGautomaticBathWaterHeatingHModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGautomaticBathWaterHeatingHModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br><br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Name : �gAutomatic bath water heating�h mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGautomaticBathWaterHeatingHModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGautomaticBathWaterHeatingHModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGautomaticBathWaterHeatingHModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br><br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Name : �gAddition of hot water�h function setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGadditionOfHotWaterHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGadditionOfHotWaterHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGadditionOfHotWaterHFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br><br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Name : �gAddition of hot water�h function setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGadditionOfHotWaterHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGadditionOfHotWaterHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGadditionOfHotWaterHFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br><br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Name : �gSlight bath water temperature lowering�h function setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br><br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Name : �gSlight bath water temperature lowering�h function setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x00 to 0xFD (0 to 253 liters)<br><br>Name : Bath water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x00 to 0xFD (0 to 253 liters)<br><br>Name : Bath water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Bath water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Bath water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Bath water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterVolumeSetting3(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Bath water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterVolumeSetting3(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * 0x31 to 0x38<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * 0x31 to 0x38<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * ON timer setting (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * ON timer setting (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in wintertime<br>EPC : 0xDB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRatedPowerConsumptionOfHPUnitInWintertime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedPowerConsumptionOfHPUnitInWintertime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedPowerConsumptionOfHPUnitInWintertime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the rated power consumption of the heat pump in in-between seasons (April, May, October, November)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in in-between seasons<br>EPC : 0xDC<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in summertime<br>EPC : 0xDD<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRatedPowerConsumptionOfHPUnitInSummertime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedPowerConsumptionOfHPUnitInSummertime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedPowerConsumptionOfHPUnitInSummertime(eoj, tid, esv, epc, pdc, edt);
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
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br><br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Name : �gAutomatic water heating�h setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGautomaticWaterHeatingHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br><br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Name : �gAutomatic water temperature control�h setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGautomaticWaterTemperatureControlHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Water heating temperature setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Setter reqSetWaterHeatingTemperatureSetting(byte[] edt) {
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br><br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Name : �gDaytime reheating permission�h setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGdaytimeReheatingPermissionHSetting(byte[] edt) {
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : �gTemperature of supplied water�h setting<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGtemperatureOfSuppliedWaterHSetting(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Bath water temperature setting<br>EPC : 0xD3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Bath water volume setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathWaterVolumeSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br><br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Name : �gAutomatic bath water heating�h mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGautomaticBathWaterHeatingHModeSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br><br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Name : �gAddition of hot water�h function setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGadditionOfHotWaterHFunctionSetting(byte[] edt) {
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br><br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Name : �gSlight bath water temperature lowering�h function setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x00 to 0xFD (0 to 253 liters)<br><br>Name : Bath water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Bath water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Bath water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathWaterVolumeSetting3(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * 0x31 to 0x38<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * ON timer setting (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br><br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Name : �gAutomatic water heating�h setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGautomaticWaterHeatingHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br><br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Name : �gAutomatic water temperature control�h setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGautomaticWaterTemperatureControlHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING);
			return this;
		}
		/**
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br><br>Heating = 0x41 Not heating = 0x42<br><br>Name : Water heater status<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetWaterHeaterStatus() {
			addProperty(EPC_WATER_HEATER_STATUS);
			return this;
		}
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Water heating temperature setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Getter reqGetWaterHeatingTemperatureSetting() {
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br><br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Name : �gDaytime reheating permission�h setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGdaytimeReheatingPermissionHSetting() {
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING);
			return this;
		}
		/**
		 * This property indicates the current temperature of the water in the water heater.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Measured temperature of water in water heater<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : �gTemperature of supplied water�h setting<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGtemperatureOfSuppliedWaterHSetting() {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING);
			return this;
		}
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Bath water temperature setting<br>EPC : 0xD3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathWaterTemperatureSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Bath water volume setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathWaterVolumeSetting() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING);
			return this;
		}
		/**
		 * This property indicates the measured amount of water left in the tank in liters.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Measured amount of water remaining in tank<br>EPC : 0xE1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredAmountOfWaterRemainingInTank() {
			addProperty(EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK);
			return this;
		}
		/**
		 * This property indicates the tank capacity in liters.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Tank capacity<br>EPC : 0xE2<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetTankCapacity() {
			addProperty(EPC_TANK_CAPACITY);
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br><br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Name : �gAutomatic bath water heating�h mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGautomaticBathWaterHeatingHModeSetting() {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br><br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Name : �gAddition of hot water�h function setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGadditionOfHotWaterHFunctionSetting() {
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br><br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Name : �gSlight bath water temperature lowering�h function setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting() {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x00 to 0xFD (0 to 253 liters)<br><br>Name : Bath water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathWaterVolumeSetting1() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Bath water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathWaterVolumeSetting2() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Bath water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathWaterVolumeSetting3() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3);
			return this;
		}
		/**
		 * 0x31 to 0x38<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * ON timer setting (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in wintertime<br>EPC : 0xDB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInWintertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME);
			return this;
		}
		/**
		 * This property indicates the rated power consumption of the heat pump in in-between seasons (April, May, October, November)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in in-between seasons<br>EPC : 0xDC<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS);
			return this;
		}
		/**
		 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in summertime<br>EPC : 0xDD<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInSummertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME);
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
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br><br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Name : �gAutomatic water heating�h setting<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGautomaticWaterHeatingHSetting();
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br><br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Name : �gAutomatic water temperature control�h setting<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGautomaticWaterTemperatureControlHSetting();
		/**
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br><br>Heating = 0x41 Not heating = 0x42<br><br>Name : Water heater status<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformWaterHeaterStatus();
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Water heating temperature setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Informer reqInformWaterHeatingTemperatureSetting();
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br><br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Name : �gDaytime reheating permission�h setting<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGdaytimeReheatingPermissionHSetting();
		/**
		 * This property indicates the current temperature of the water in the water heater.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Measured temperature of water in water heater<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater();
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : �gTemperature of supplied water�h setting<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGtemperatureOfSuppliedWaterHSetting();
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100��C)<br><br>Name : Bath water temperature setting<br>EPC : 0xD3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathWaterTemperatureSetting();
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br><br>0x00 to 0x64 (0 to 100%)<br><br>Name : Bath water volume setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathWaterVolumeSetting();
		/**
		 * This property indicates the measured amount of water left in the tank in liters.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Measured amount of water remaining in tank<br>EPC : 0xE1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredAmountOfWaterRemainingInTank();
		/**
		 * This property indicates the tank capacity in liters.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Tank capacity<br>EPC : 0xE2<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformTankCapacity();
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br><br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Name : �gAutomatic bath water heating�h mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGautomaticBathWaterHeatingHModeSetting();
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br><br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Name : �gAddition of hot water�h function setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGadditionOfHotWaterHFunctionSetting();
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br><br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Name : �gSlight bath water temperature lowering�h function setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting();
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x00 to 0xFD (0 to 253 liters)<br><br>Name : Bath water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathWaterVolumeSetting1();
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Bath water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathWaterVolumeSetting2();
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Name : Bath water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathWaterVolumeSetting3();
		/**
		 * 0x31 to 0x38<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * ON timer setting (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in wintertime<br>EPC : 0xDB<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInWintertime();
		/**
		 * This property indicates the rated power consumption of the heat pump in in-between seasons (April, May, October, November)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in in-between seasons<br>EPC : 0xDC<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInInBetweenSeasons();
		/**
		 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br><br>0x0000-0xFFFD(0-65,533)<br><br>Name : Rated power consumption of H/P unit in summertime<br>EPC : 0xDD<br>Data Type : unsigned short<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInSummertime();
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
		public Informer reqInformGautomaticWaterHeatingHSetting() {
			byte epc = EPC_GAUTOMATIC_WATER_HEATING_H_SETTING;
			byte[] edt = _getGautomaticWaterHeatingHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGautomaticWaterTemperatureControlHSetting() {
			byte epc = EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING;
			byte[] edt = _getGautomaticWaterTemperatureControlHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterHeaterStatus() {
			byte epc = EPC_WATER_HEATER_STATUS;
			byte[] edt = _getWaterHeaterStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterHeatingTemperatureSetting() {
			byte epc = EPC_WATER_HEATING_TEMPERATURE_SETTING;
			byte[] edt = _getWaterHeatingTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGdaytimeReheatingPermissionHSetting() {
			byte epc = EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING;
			byte[] edt = _getGdaytimeReheatingPermissionHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater() {
			byte epc = EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER;
			byte[] edt = _getMeasuredTemperatureOfWaterInWaterHeater(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureOfSuppliedWaterHSetting() {
			byte epc = EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING;
			byte[] edt = _getGtemperatureOfSuppliedWaterHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterTemperatureSetting() {
			byte epc = EPC_BATH_WATER_TEMPERATURE_SETTING;
			byte[] edt = _getBathWaterTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting() {
			byte epc = EPC_BATH_WATER_VOLUME_SETTING;
			byte[] edt = _getBathWaterVolumeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredAmountOfWaterRemainingInTank() {
			byte epc = EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK;
			byte[] edt = _getMeasuredAmountOfWaterRemainingInTank(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformTankCapacity() {
			byte epc = EPC_TANK_CAPACITY;
			byte[] edt = _getTankCapacity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGautomaticBathWaterHeatingHModeSetting() {
			byte epc = EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING;
			byte[] edt = _getGautomaticBathWaterHeatingHModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGadditionOfHotWaterHFunctionSetting() {
			byte epc = EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING;
			byte[] edt = _getGadditionOfHotWaterHFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting() {
			byte epc = EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING;
			byte[] edt = _getGslightBathWaterTemperatureLoweringHFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting1() {
			byte epc = EPC_BATH_WATER_VOLUME_SETTING1;
			byte[] edt = _getBathWaterVolumeSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting2() {
			byte epc = EPC_BATH_WATER_VOLUME_SETTING2;
			byte[] edt = _getBathWaterVolumeSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting3() {
			byte epc = EPC_BATH_WATER_VOLUME_SETTING3;
			byte[] edt = _getBathWaterVolumeSetting3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOnTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSetting() {
			byte epc = EPC_ON_TIMER_SETTING;
			byte[] edt = _getOnTimerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfHPUnitInWintertime() {
			byte epc = EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME;
			byte[] edt = _getRatedPowerConsumptionOfHPUnitInWintertime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			byte epc = EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS;
			byte[] edt = _getRatedPowerConsumptionOfHPUnitInInBetweenSeasons(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfHPUnitInSummertime() {
			byte epc = EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME;
			byte[] edt = _getRatedPowerConsumptionOfHPUnitInSummertime(epc);
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
		public Informer reqInformGautomaticWaterHeatingHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGautomaticWaterTemperatureControlHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformWaterHeaterStatus() {
			addProperty(EPC_WATER_HEATER_STATUS);
			return this;
		}
		@Override
		public Informer reqInformWaterHeatingTemperatureSetting() {
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGdaytimeReheatingPermissionHSetting() {
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		@Override
		public Informer reqInformGtemperatureOfSuppliedWaterHSetting() {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathWaterTemperatureSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredAmountOfWaterRemainingInTank() {
			addProperty(EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK);
			return this;
		}
		@Override
		public Informer reqInformTankCapacity() {
			addProperty(EPC_TANK_CAPACITY);
			return this;
		}
		@Override
		public Informer reqInformGautomaticBathWaterHeatingHModeSetting() {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGadditionOfHotWaterHFunctionSetting() {
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting() {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting1() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting2() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting3() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3);
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfHPUnitInWintertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfHPUnitInSummertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME);
			return this;
		}
	}
}
