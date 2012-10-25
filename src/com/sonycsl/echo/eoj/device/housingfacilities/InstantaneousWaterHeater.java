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

public abstract class InstantaneousWaterHeater extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x72;
	
	public InstantaneousWaterHeater() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_HOT_WATER_HEATING_STATUS = (byte)0xD0;
	public static final byte EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE = (byte)0xD1;
	public static final byte EPC_HOT_WATER_WARMER_SETTING = (byte)0xD2;
	public static final byte EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING = (byte)0xDA;
	public static final byte EPC_REMAINING_AUTOMATIC_OPERATION_TIME = (byte)0xDB;
	public static final byte EPC_SET_VALUE_OF_BATH_TEMPERATURE = (byte)0xE1;
	public static final byte EPC_BATH_WATER_HEATER_STATUS = (byte)0xE2;
	public static final byte EPC_BATH_AUTO_MODE_SETTING = (byte)0xE3;
	public static final byte EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING = (byte)0xE4;
	public static final byte EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING = (byte)0xE5;
	public static final byte EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING = (byte)0xE6;
	public static final byte EPC_BATH_HOT_WATER_VOLUME_SETTING1 = (byte)0xE7;
	public static final byte EPC_BATH_HOT_WATER_VOLUME_SETTING2 = (byte)0xE8;
	public static final byte EPC_BATH_HOT_WATER_VOLUME_SETTING3 = (byte)0xEE;
	public static final byte EPC_BATHROOM_PRIORITY_SETTING = (byte)0xE9;
	public static final byte EPC_SHOWER_HOT_WATER_SUPPLY_STATUS = (byte)0xEA;
	public static final byte EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS = (byte)0xEB;
	public static final byte EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING = (byte)0xEC;
	public static final byte EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME = (byte)0xED;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_SET_VALUE_OF_ON_TIMER_TIME = (byte)0x91;
	public static final byte EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME = (byte)0x92;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates hot water heating status.<br><br>Hot water heating status found = 0x41 Hot water heating status not found = 0x42<br><br>Name : Hot water heating status<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getHotWaterHeatingStatus();
	private final byte[] _getHotWaterHeatingStatus(byte epc) {
		byte[] edt = getHotWaterHeatingStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates set value of hot water temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of hot water temperature<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfHotWaterTemperature(byte[] edt) {return false;}
	private final boolean _setSetValueOfHotWaterTemperature(byte epc, byte[] edt) {
		boolean success = setSetValueOfHotWaterTemperature(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates set value of hot water temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of hot water temperature<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfHotWaterTemperature() {return null;}
	private final byte[] _getSetValueOfHotWaterTemperature(byte epc) {
		byte[] edt = getSetValueOfHotWaterTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Hot water warmer setting<br><br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42<br><br>Name : Hot water Warmer setting<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHotWaterWarmerSetting(byte[] edt) {return false;}
	private final boolean _setHotWaterWarmerSetting(byte epc, byte[] edt) {
		boolean success = setHotWaterWarmerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Hot water warmer setting<br><br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42<br><br>Name : Hot water Warmer setting<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHotWaterWarmerSetting() {return null;}
	private final byte[] _getHotWaterWarmerSetting(byte epc) {
		byte[] edt = getHotWaterWarmerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF<br><br>Name :  gDuration of automatic operation h setting<br>EPC : 0xDA<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGdurationOfAutomaticOperationHSetting(byte[] edt) {return false;}
	private final boolean _setGdurationOfAutomaticOperationHSetting(byte epc, byte[] edt) {
		boolean success = setGdurationOfAutomaticOperationHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF<br><br>Name :  gDuration of automatic operation h setting<br>EPC : 0xDA<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGdurationOfAutomaticOperationHSetting() {return null;}
	private final byte[] _getGdurationOfAutomaticOperationHSetting(byte epc) {
		byte[] edt = getGdurationOfAutomaticOperationHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Infinite: 0xFFFF<br><br>Name : Remaining automatic operation time<br>EPC : 0xDB<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRemainingAutomaticOperationTime() {return null;}
	private final byte[] _getRemainingAutomaticOperationTime(byte epc) {
		byte[] edt = getRemainingAutomaticOperationTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates set value of bath temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of bath temperature<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfBathTemperature(byte[] edt) {return false;}
	private final boolean _setSetValueOfBathTemperature(byte epc, byte[] edt) {
		boolean success = setSetValueOfBathTemperature(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates set value of bath temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of bath temperature<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfBathTemperature() {return null;}
	private final byte[] _getSetValueOfBathTemperature(byte epc) {
		byte[] edt = getSetValueOfBathTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether or not the bath water heater is heating bath water.<br><br>Heating = 0x41 Not heating = 0x42<br><br>Name : Bath water heater status<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getBathWaterHeaterStatus();
	private final byte[] _getBathWaterHeaterStatus(byte epc) {
		byte[] edt = getBathWaterHeaterStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Bath auto mode ON/OFF<br><br>Auto ON = 0x41 Auto OFF = 0x42<br><br>Name : Bath auto mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathAutoModeSetting(byte[] edt) {return false;}
	private final boolean _setBathAutoModeSetting(byte epc, byte[] edt) {
		boolean success = setBathAutoModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Bath auto mode ON/OFF<br><br>Auto ON = 0x41 Auto OFF = 0x42<br><br>Name : Bath auto mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathAutoModeSetting() {return null;}
	private final byte[] _getBathAutoModeSetting(byte epc) {
		byte[] edt = getBathAutoModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Additional boil-up ON/OFF<br><br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br><br>Name : Bath additional boil-up operation setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathAdditionalBoilUpOperationSetting(byte[] edt) {return false;}
	private final boolean _setBathAdditionalBoilUpOperationSetting(byte epc, byte[] edt) {
		boolean success = setBathAdditionalBoilUpOperationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Additional boil-up ON/OFF<br><br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br><br>Name : Bath additional boil-up operation setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathAdditionalBoilUpOperationSetting() {return null;}
	private final byte[] _getBathAdditionalBoilUpOperationSetting(byte epc) {
		byte[] edt = getBathAdditionalBoilUpOperationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Hot water addition ON/OFF<br><br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br><br>Name : Bath hot water adding operation setting<br>EPC : 0xE5<br>Data Type : unsigned<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathHotWaterAddingOperationSetting(byte[] edt) {return false;}
	private final boolean _setBathHotWaterAddingOperationSetting(byte epc, byte[] edt) {
		boolean success = setBathHotWaterAddingOperationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Hot water addition ON/OFF<br><br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br><br>Name : Bath hot water adding operation setting<br>EPC : 0xE5<br>Data Type : unsigned<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathHotWaterAddingOperationSetting() {return null;}
	private final byte[] _getBathHotWaterAddingOperationSetting(byte epc) {
		byte[] edt = getBathHotWaterAddingOperationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Hot water temperature lowering ON/OFF<br><br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42<br><br>Name : Bath water temperature lowering operation setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathWaterTemperatureLoweringOperationSetting(byte[] edt) {return false;}
	private final boolean _setBathWaterTemperatureLoweringOperationSetting(byte epc, byte[] edt) {
		boolean success = setBathWaterTemperatureLoweringOperationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Hot water temperature lowering ON/OFF<br><br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42<br><br>Name : Bath water temperature lowering operation setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathWaterTemperatureLoweringOperationSetting() {return null;}
	private final byte[] _getBathWaterTemperatureLoweringOperationSetting(byte epc) {
		byte[] edt = getBathWaterTemperatureLoweringOperationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates bath hot water volume in liters.<br><br>0x00.0xFD (0 to 253 liters)<br><br>Name : Bath hot water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathHotWaterVolumeSetting1(byte[] edt) {return false;}
	private final boolean _setBathHotWaterVolumeSetting1(byte epc, byte[] edt) {
		boolean success = setBathHotWaterVolumeSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates bath hot water volume in liters.<br><br>0x00.0xFD (0 to 253 liters)<br><br>Name : Bath hot water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathHotWaterVolumeSetting1() {return null;}
	private final byte[] _getBathHotWaterVolumeSetting1(byte epc) {
		byte[] edt = getBathHotWaterVolumeSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Specifies bath hot water volume (8-step).<br><br>0x31.0x38<br><br>Name : Bath hot water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathHotWaterVolumeSetting2(byte[] edt) {return false;}
	private final boolean _setBathHotWaterVolumeSetting2(byte epc, byte[] edt) {
		boolean success = setBathHotWaterVolumeSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Specifies bath hot water volume (8-step).<br><br>0x31.0x38<br><br>Name : Bath hot water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathHotWaterVolumeSetting2() {return null;}
	private final byte[] _getBathHotWaterVolumeSetting2(byte epc) {
		byte[] edt = getBathHotWaterVolumeSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates bath hot water volume in liters.<br><br>0x0000.0xFFFD (0 to 65533 liters)<br><br>Name : Bath hot water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathHotWaterVolumeSetting3(byte[] edt) {return false;}
	private final boolean _setBathHotWaterVolumeSetting3(byte epc, byte[] edt) {
		boolean success = setBathHotWaterVolumeSetting3(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates bath hot water volume in liters.<br><br>0x0000.0xFFFD (0 to 65533 liters)<br><br>Name : Bath hot water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathHotWaterVolumeSetting3() {return null;}
	private final byte[] _getBathHotWaterVolumeSetting3(byte epc) {
		byte[] edt = getBathHotWaterVolumeSetting3();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Bathroom priority ON/OFF<br><br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br><br>Name : Bathroom priority setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathroomPrioritySetting(byte[] edt) {return false;}
	private final boolean _setBathroomPrioritySetting(byte epc, byte[] edt) {
		boolean success = setBathroomPrioritySetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Bathroom priority ON/OFF<br><br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br><br>Name : Bathroom priority setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathroomPrioritySetting() {return null;}
	private final byte[] _getBathroomPrioritySetting(byte epc) {
		byte[] edt = getBathroomPrioritySetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Shower hot water supply ON/OFF<br><br>Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42<br><br>Name : Shower hot water supply status<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getShowerHotWaterSupplyStatus() {return null;}
	private final byte[] _getShowerHotWaterSupplyStatus(byte epc) {
		byte[] edt = getShowerHotWaterSupplyStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Kitchen hot water supply ON/OFF<br><br>Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42<br><br>Name : Kitchen hot water supply status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getKitchenHotWaterSupplyStatus() {return null;}
	private final byte[] _getKitchenHotWaterSupplyStatus(byte epc) {
		byte[] edt = getKitchenHotWaterSupplyStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : Hot water warmer ON timer reservation setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHotWaterWarmerOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setHotWaterWarmerOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setHotWaterWarmerOnTimerReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : Hot water warmer ON timer reservation setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHotWaterWarmerOnTimerReservationSetting() {return null;}
	private final byte[] _getHotWaterWarmerOnTimerReservationSetting(byte epc) {
		byte[] edt = getHotWaterWarmerOnTimerReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of hot water warmer ON timer time<br>EPC : 0xED<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfHotWaterWarmerOnTimerTime(byte[] edt) {return false;}
	private final boolean _setSetValueOfHotWaterWarmerOnTimerTime(byte epc, byte[] edt) {
		boolean success = setSetValueOfHotWaterWarmerOnTimerTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of hot water warmer ON timer time<br>EPC : 0xED<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfHotWaterWarmerOnTimerTime() {return null;}
	private final byte[] _getSetValueOfHotWaterWarmerOnTimerTime(byte epc) {
		byte[] edt = getSetValueOfHotWaterWarmerOnTimerTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/Reservation OFF<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/Reservation OFF<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer time<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfOnTimerTime(byte[] edt) {return false;}
	private final boolean _setSetValueOfOnTimerTime(byte epc, byte[] edt) {
		boolean success = setSetValueOfOnTimerTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer time<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfOnTimerTime() {return null;}
	private final byte[] _getSetValueOfOnTimerTime(byte epc) {
		byte[] edt = getSetValueOfOnTimerTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer relative time<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfOnTimerRelativeTime(byte[] edt) {return false;}
	private final boolean _setSetValueOfOnTimerRelativeTime(byte epc, byte[] edt) {
		boolean success = setSetValueOfOnTimerRelativeTime(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer relative time<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfOnTimerRelativeTime() {return null;}
	private final byte[] _getSetValueOfOnTimerRelativeTime(byte epc) {
		byte[] edt = getSetValueOfOnTimerRelativeTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE:
			res.addProperty(epc, edt, _setSetValueOfHotWaterTemperature(epc, edt));
			break;
		case EPC_HOT_WATER_WARMER_SETTING:
			res.addProperty(epc, edt, _setHotWaterWarmerSetting(epc, edt));
			break;
		case EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING:
			res.addProperty(epc, edt, _setGdurationOfAutomaticOperationHSetting(epc, edt));
			break;
		case EPC_SET_VALUE_OF_BATH_TEMPERATURE:
			res.addProperty(epc, edt, _setSetValueOfBathTemperature(epc, edt));
			break;
		case EPC_BATH_AUTO_MODE_SETTING:
			res.addProperty(epc, edt, _setBathAutoModeSetting(epc, edt));
			break;
		case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING:
			res.addProperty(epc, edt, _setBathAdditionalBoilUpOperationSetting(epc, edt));
			break;
		case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING:
			res.addProperty(epc, edt, _setBathHotWaterAddingOperationSetting(epc, edt));
			break;
		case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING:
			res.addProperty(epc, edt, _setBathWaterTemperatureLoweringOperationSetting(epc, edt));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING1:
			res.addProperty(epc, edt, _setBathHotWaterVolumeSetting1(epc, edt));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING2:
			res.addProperty(epc, edt, _setBathHotWaterVolumeSetting2(epc, edt));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING3:
			res.addProperty(epc, edt, _setBathHotWaterVolumeSetting3(epc, edt));
			break;
		case EPC_BATHROOM_PRIORITY_SETTING:
			res.addProperty(epc, edt, _setBathroomPrioritySetting(epc, edt));
			break;
		case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setHotWaterWarmerOnTimerReservationSetting(epc, edt));
			break;
		case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME:
			res.addProperty(epc, edt, _setSetValueOfHotWaterWarmerOnTimerTime(epc, edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			break;
		case EPC_SET_VALUE_OF_ON_TIMER_TIME:
			res.addProperty(epc, edt, _setSetValueOfOnTimerTime(epc, edt));
			break;
		case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME:
			res.addProperty(epc, edt, _setSetValueOfOnTimerRelativeTime(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_HOT_WATER_HEATING_STATUS:
			edt = _getHotWaterHeatingStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE:
			edt = _getSetValueOfHotWaterTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HOT_WATER_WARMER_SETTING:
			edt = _getHotWaterWarmerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING:
			edt = _getGdurationOfAutomaticOperationHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_REMAINING_AUTOMATIC_OPERATION_TIME:
			edt = _getRemainingAutomaticOperationTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SET_VALUE_OF_BATH_TEMPERATURE:
			edt = _getSetValueOfBathTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_HEATER_STATUS:
			edt = _getBathWaterHeaterStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_AUTO_MODE_SETTING:
			edt = _getBathAutoModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING:
			edt = _getBathAdditionalBoilUpOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING:
			edt = _getBathHotWaterAddingOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING:
			edt = _getBathWaterTemperatureLoweringOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING1:
			edt = _getBathHotWaterVolumeSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING2:
			edt = _getBathHotWaterVolumeSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING3:
			edt = _getBathHotWaterVolumeSetting3(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_BATHROOM_PRIORITY_SETTING:
			edt = _getBathroomPrioritySetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHOWER_HOT_WATER_SUPPLY_STATUS:
			edt = _getShowerHotWaterSupplyStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS:
			edt = _getKitchenHotWaterSupplyStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING:
			edt = _getHotWaterWarmerOnTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME:
			edt = _getSetValueOfHotWaterWarmerOnTimerTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = _getOnTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_ON_TIMER_TIME:
			edt = _getSetValueOfOnTimerTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME:
			edt = _getSetValueOfOnTimerRelativeTime(epc);
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
			case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE:
				_onSetSetValueOfHotWaterTemperature(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_HOT_WATER_WARMER_SETTING:
				_onSetHotWaterWarmerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING:
				_onSetGdurationOfAutomaticOperationHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_BATH_TEMPERATURE:
				_onSetSetValueOfBathTemperature(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_AUTO_MODE_SETTING:
				_onSetBathAutoModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING:
				_onSetBathAdditionalBoilUpOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING:
				_onSetBathHotWaterAddingOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING:
				_onSetBathWaterTemperatureLoweringOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING1:
				_onSetBathHotWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING2:
				_onSetBathHotWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING3:
				_onSetBathHotWaterVolumeSetting3(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATHROOM_PRIORITY_SETTING:
				_onSetBathroomPrioritySetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING:
				_onSetHotWaterWarmerOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME:
				_onSetSetValueOfHotWaterWarmerOnTimerTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_ON_TIMER_TIME:
				_onSetSetValueOfOnTimerTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME:
				_onSetSetValueOfOnTimerRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_HOT_WATER_HEATING_STATUS:
				_onGetHotWaterHeatingStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE:
				_onGetSetValueOfHotWaterTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HOT_WATER_WARMER_SETTING:
				_onGetHotWaterWarmerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING:
				_onGetGdurationOfAutomaticOperationHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REMAINING_AUTOMATIC_OPERATION_TIME:
				_onGetRemainingAutomaticOperationTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_BATH_TEMPERATURE:
				_onGetSetValueOfBathTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_HEATER_STATUS:
				_onGetBathWaterHeaterStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_AUTO_MODE_SETTING:
				_onGetBathAutoModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING:
				_onGetBathAdditionalBoilUpOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING:
				_onGetBathHotWaterAddingOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING:
				_onGetBathWaterTemperatureLoweringOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING1:
				_onGetBathHotWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING2:
				_onGetBathHotWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING3:
				_onGetBathHotWaterVolumeSetting3(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATHROOM_PRIORITY_SETTING:
				_onGetBathroomPrioritySetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SHOWER_HOT_WATER_SUPPLY_STATUS:
				_onGetShowerHotWaterSupplyStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS:
				_onGetKitchenHotWaterSupplyStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING:
				_onGetHotWaterWarmerOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME:
				_onGetSetValueOfHotWaterWarmerOnTimerTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_ON_TIMER_TIME:
				_onGetSetValueOfOnTimerTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME:
				_onGetSetValueOfOnTimerRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates hot water heating status.<br><br>Hot water heating status found = 0x41 Hot water heating status not found = 0x42<br><br>Name : Hot water heating status<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetHotWaterHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHotWaterHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHotWaterHeatingStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates set value of hot water temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of hot water temperature<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfHotWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfHotWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfHotWaterTemperature(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates set value of hot water temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of hot water temperature<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfHotWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfHotWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfHotWaterTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Hot water warmer setting<br><br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42<br><br>Name : Hot water Warmer setting<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHotWaterWarmerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHotWaterWarmerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHotWaterWarmerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Hot water warmer setting<br><br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42<br><br>Name : Hot water Warmer setting<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHotWaterWarmerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHotWaterWarmerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHotWaterWarmerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF<br><br>Name :  gDuration of automatic operation h setting<br>EPC : 0xDA<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGdurationOfAutomaticOperationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGdurationOfAutomaticOperationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGdurationOfAutomaticOperationHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF<br><br>Name :  gDuration of automatic operation h setting<br>EPC : 0xDA<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGdurationOfAutomaticOperationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGdurationOfAutomaticOperationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGdurationOfAutomaticOperationHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Infinite: 0xFFFF<br><br>Name : Remaining automatic operation time<br>EPC : 0xDB<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRemainingAutomaticOperationTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRemainingAutomaticOperationTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRemainingAutomaticOperationTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates set value of bath temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of bath temperature<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfBathTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfBathTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfBathTemperature(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates set value of bath temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of bath temperature<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfBathTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfBathTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfBathTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether or not the bath water heater is heating bath water.<br><br>Heating = 0x41 Not heating = 0x42<br><br>Name : Bath water heater status<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetBathWaterHeaterStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterHeaterStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterHeaterStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Bath auto mode ON/OFF<br><br>Auto ON = 0x41 Auto OFF = 0x42<br><br>Name : Bath auto mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathAutoModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathAutoModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathAutoModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Bath auto mode ON/OFF<br><br>Auto ON = 0x41 Auto OFF = 0x42<br><br>Name : Bath auto mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathAutoModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathAutoModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathAutoModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Additional boil-up ON/OFF<br><br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br><br>Name : Bath additional boil-up operation setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathAdditionalBoilUpOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathAdditionalBoilUpOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathAdditionalBoilUpOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Additional boil-up ON/OFF<br><br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br><br>Name : Bath additional boil-up operation setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathAdditionalBoilUpOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathAdditionalBoilUpOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathAdditionalBoilUpOperationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Hot water addition ON/OFF<br><br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br><br>Name : Bath hot water adding operation setting<br>EPC : 0xE5<br>Data Type : unsigned<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathHotWaterAddingOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathHotWaterAddingOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathHotWaterAddingOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Hot water addition ON/OFF<br><br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br><br>Name : Bath hot water adding operation setting<br>EPC : 0xE5<br>Data Type : unsigned<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathHotWaterAddingOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathHotWaterAddingOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathHotWaterAddingOperationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Hot water temperature lowering ON/OFF<br><br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42<br><br>Name : Bath water temperature lowering operation setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathWaterTemperatureLoweringOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterTemperatureLoweringOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterTemperatureLoweringOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Hot water temperature lowering ON/OFF<br><br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42<br><br>Name : Bath water temperature lowering operation setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathWaterTemperatureLoweringOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterTemperatureLoweringOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterTemperatureLoweringOperationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x00.0xFD (0 to 253 liters)<br><br>Name : Bath hot water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathHotWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathHotWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathHotWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x00.0xFD (0 to 253 liters)<br><br>Name : Bath hot water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathHotWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathHotWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathHotWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Specifies bath hot water volume (8-step).<br><br>0x31.0x38<br><br>Name : Bath hot water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathHotWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathHotWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathHotWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Specifies bath hot water volume (8-step).<br><br>0x31.0x38<br><br>Name : Bath hot water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathHotWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathHotWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathHotWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x0000.0xFFFD (0 to 65533 liters)<br><br>Name : Bath hot water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathHotWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathHotWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathHotWaterVolumeSetting3(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x0000.0xFFFD (0 to 65533 liters)<br><br>Name : Bath hot water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathHotWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathHotWaterVolumeSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathHotWaterVolumeSetting3(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Bathroom priority ON/OFF<br><br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br><br>Name : Bathroom priority setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathroomPrioritySetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathroomPrioritySetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathroomPrioritySetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Bathroom priority ON/OFF<br><br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br><br>Name : Bathroom priority setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathroomPrioritySetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathroomPrioritySetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathroomPrioritySetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Shower hot water supply ON/OFF<br><br>Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42<br><br>Name : Shower hot water supply status<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetShowerHotWaterSupplyStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetShowerHotWaterSupplyStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetShowerHotWaterSupplyStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Kitchen hot water supply ON/OFF<br><br>Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42<br><br>Name : Kitchen hot water supply status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetKitchenHotWaterSupplyStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetKitchenHotWaterSupplyStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetKitchenHotWaterSupplyStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : Hot water warmer ON timer reservation setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHotWaterWarmerOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHotWaterWarmerOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHotWaterWarmerOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : Hot water warmer ON timer reservation setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHotWaterWarmerOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHotWaterWarmerOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHotWaterWarmerOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of hot water warmer ON timer time<br>EPC : 0xED<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfHotWaterWarmerOnTimerTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfHotWaterWarmerOnTimerTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfHotWaterWarmerOnTimerTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of hot water warmer ON timer time<br>EPC : 0xED<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfHotWaterWarmerOnTimerTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfHotWaterWarmerOnTimerTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfHotWaterWarmerOnTimerTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/Reservation OFF<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/Reservation OFF<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer time<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfOnTimerTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfOnTimerTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfOnTimerTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer time<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfOnTimerTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfOnTimerTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfOnTimerTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer relative time<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfOnTimerRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfOnTimerRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfOnTimerRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer relative time<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfOnTimerRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfOnTimerRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfOnTimerRelativeTime(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates set value of hot water temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of hot water temperature<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfHotWaterTemperature(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Hot water warmer setting<br><br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42<br><br>Name : Hot water Warmer setting<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHotWaterWarmerSetting(byte[] edt) {
			addProperty(EPC_HOT_WATER_WARMER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF<br><br>Name :  gDuration of automatic operation h setting<br>EPC : 0xDA<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGdurationOfAutomaticOperationHSetting(byte[] edt) {
			addProperty(EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * This property indicates set value of bath temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of bath temperature<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfBathTemperature(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Bath auto mode ON/OFF<br><br>Auto ON = 0x41 Auto OFF = 0x42<br><br>Name : Bath auto mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathAutoModeSetting(byte[] edt) {
			addProperty(EPC_BATH_AUTO_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Additional boil-up ON/OFF<br><br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br><br>Name : Bath additional boil-up operation setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathAdditionalBoilUpOperationSetting(byte[] edt) {
			addProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Hot water addition ON/OFF<br><br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br><br>Name : Bath hot water adding operation setting<br>EPC : 0xE5<br>Data Type : unsigned<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathHotWaterAddingOperationSetting(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Hot water temperature lowering ON/OFF<br><br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42<br><br>Name : Bath water temperature lowering operation setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathWaterTemperatureLoweringOperationSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x00.0xFD (0 to 253 liters)<br><br>Name : Bath hot water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathHotWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Specifies bath hot water volume (8-step).<br><br>0x31.0x38<br><br>Name : Bath hot water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathHotWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x0000.0xFFFD (0 to 65533 liters)<br><br>Name : Bath hot water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathHotWaterVolumeSetting3(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Bathroom priority ON/OFF<br><br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br><br>Name : Bathroom priority setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathroomPrioritySetting(byte[] edt) {
			addProperty(EPC_BATHROOM_PRIORITY_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : Hot water warmer ON timer reservation setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHotWaterWarmerOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of hot water warmer ON timer time<br>EPC : 0xED<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfHotWaterWarmerOnTimerTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Reservation ON/Reservation OFF<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer time<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfOnTimerTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer relative time<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfOnTimerRelativeTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates hot water heating status.<br><br>Hot water heating status found = 0x41 Hot water heating status not found = 0x42<br><br>Name : Hot water heating status<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetHotWaterHeatingStatus() {
			addProperty(EPC_HOT_WATER_HEATING_STATUS);
			return this;
		}
		/**
		 * This property indicates set value of hot water temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of hot water temperature<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfHotWaterTemperature() {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE);
			return this;
		}
		/**
		 * Hot water warmer setting<br><br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42<br><br>Name : Hot water Warmer setting<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHotWaterWarmerSetting() {
			addProperty(EPC_HOT_WATER_WARMER_SETTING);
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF<br><br>Name :  gDuration of automatic operation h setting<br>EPC : 0xDA<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGdurationOfAutomaticOperationHSetting() {
			addProperty(EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING);
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Infinite: 0xFFFF<br><br>Name : Remaining automatic operation time<br>EPC : 0xDB<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRemainingAutomaticOperationTime() {
			addProperty(EPC_REMAINING_AUTOMATIC_OPERATION_TIME);
			return this;
		}
		/**
		 * This property indicates set value of bath temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of bath temperature<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfBathTemperature() {
			addProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE);
			return this;
		}
		/**
		 * This property indicates whether or not the bath water heater is heating bath water.<br><br>Heating = 0x41 Not heating = 0x42<br><br>Name : Bath water heater status<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetBathWaterHeaterStatus() {
			addProperty(EPC_BATH_WATER_HEATER_STATUS);
			return this;
		}
		/**
		 * Bath auto mode ON/OFF<br><br>Auto ON = 0x41 Auto OFF = 0x42<br><br>Name : Bath auto mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathAutoModeSetting() {
			addProperty(EPC_BATH_AUTO_MODE_SETTING);
			return this;
		}
		/**
		 * Additional boil-up ON/OFF<br><br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br><br>Name : Bath additional boil-up operation setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathAdditionalBoilUpOperationSetting() {
			addProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING);
			return this;
		}
		/**
		 * Hot water addition ON/OFF<br><br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br><br>Name : Bath hot water adding operation setting<br>EPC : 0xE5<br>Data Type : unsigned<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathHotWaterAddingOperationSetting() {
			addProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING);
			return this;
		}
		/**
		 * Hot water temperature lowering ON/OFF<br><br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42<br><br>Name : Bath water temperature lowering operation setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathWaterTemperatureLoweringOperationSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING);
			return this;
		}
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x00.0xFD (0 to 253 liters)<br><br>Name : Bath hot water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathHotWaterVolumeSetting1() {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Specifies bath hot water volume (8-step).<br><br>0x31.0x38<br><br>Name : Bath hot water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathHotWaterVolumeSetting2() {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x0000.0xFFFD (0 to 65533 liters)<br><br>Name : Bath hot water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathHotWaterVolumeSetting3() {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3);
			return this;
		}
		/**
		 * Bathroom priority ON/OFF<br><br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br><br>Name : Bathroom priority setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathroomPrioritySetting() {
			addProperty(EPC_BATHROOM_PRIORITY_SETTING);
			return this;
		}
		/**
		 * Shower hot water supply ON/OFF<br><br>Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42<br><br>Name : Shower hot water supply status<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetShowerHotWaterSupplyStatus() {
			addProperty(EPC_SHOWER_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		/**
		 * Kitchen hot water supply ON/OFF<br><br>Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42<br><br>Name : Kitchen hot water supply status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetKitchenHotWaterSupplyStatus() {
			addProperty(EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : Hot water warmer ON timer reservation setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHotWaterWarmerOnTimerReservationSetting() {
			addProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of hot water warmer ON timer time<br>EPC : 0xED<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfHotWaterWarmerOnTimerTime() {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME);
			return this;
		}
		/**
		 * Reservation ON/Reservation OFF<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer time<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfOnTimerTime() {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME);
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer relative time<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfOnTimerRelativeTime() {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME);
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
		 * This property indicates hot water heating status.<br><br>Hot water heating status found = 0x41 Hot water heating status not found = 0x42<br><br>Name : Hot water heating status<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformHotWaterHeatingStatus();
		/**
		 * This property indicates set value of hot water temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of hot water temperature<br>EPC : 0xD1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfHotWaterTemperature();
		/**
		 * Hot water warmer setting<br><br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42<br><br>Name : Hot water Warmer setting<br>EPC : 0xD2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHotWaterWarmerSetting();
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF<br><br>Name :  gDuration of automatic operation h setting<br>EPC : 0xDA<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGdurationOfAutomaticOperationHSetting();
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Infinite: 0xFFFF<br><br>Name : Remaining automatic operation time<br>EPC : 0xDB<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRemainingAutomaticOperationTime();
		/**
		 * This property indicates set value of bath temperature in .C.<br><br>0x00.0x64 (0.100)<br><br>Name : Set value of bath temperature<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfBathTemperature();
		/**
		 * This property indicates whether or not the bath water heater is heating bath water.<br><br>Heating = 0x41 Not heating = 0x42<br><br>Name : Bath water heater status<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformBathWaterHeaterStatus();
		/**
		 * Bath auto mode ON/OFF<br><br>Auto ON = 0x41 Auto OFF = 0x42<br><br>Name : Bath auto mode setting<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathAutoModeSetting();
		/**
		 * Additional boil-up ON/OFF<br><br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42<br><br>Name : Bath additional boil-up operation setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathAdditionalBoilUpOperationSetting();
		/**
		 * Hot water addition ON/OFF<br><br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42<br><br>Name : Bath hot water adding operation setting<br>EPC : 0xE5<br>Data Type : unsigned<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathHotWaterAddingOperationSetting();
		/**
		 * Hot water temperature lowering ON/OFF<br><br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42<br><br>Name : Bath water temperature lowering operation setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathWaterTemperatureLoweringOperationSetting();
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x00.0xFD (0 to 253 liters)<br><br>Name : Bath hot water volume setting 1<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathHotWaterVolumeSetting1();
		/**
		 * Specifies bath hot water volume (8-step).<br><br>0x31.0x38<br><br>Name : Bath hot water volume setting 2<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathHotWaterVolumeSetting2();
		/**
		 * This property indicates bath hot water volume in liters.<br><br>0x0000.0xFFFD (0 to 65533 liters)<br><br>Name : Bath hot water volume setting 3<br>EPC : 0xEE<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathHotWaterVolumeSetting3();
		/**
		 * Bathroom priority ON/OFF<br><br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42<br><br>Name : Bathroom priority setting<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathroomPrioritySetting();
		/**
		 * Shower hot water supply ON/OFF<br><br>Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42<br><br>Name : Shower hot water supply status<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformShowerHotWaterSupplyStatus();
		/**
		 * Kitchen hot water supply ON/OFF<br><br>Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42<br><br>Name : Kitchen hot water supply status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformKitchenHotWaterSupplyStatus();
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : Hot water warmer ON timer reservation setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHotWaterWarmerOnTimerReservationSetting();
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of hot water warmer ON timer time<br>EPC : 0xED<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfHotWaterWarmerOnTimerTime();
		/**
		 * Reservation ON/Reservation OFF<br><br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer time<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfOnTimerTime();
		/**
		 * Timer value (HH:MM)<br><br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Name : Set value of ON timer relative time<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfOnTimerRelativeTime();
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
		public Informer reqInformHotWaterHeatingStatus() {
			byte epc = EPC_HOT_WATER_HEATING_STATUS;
			byte[] edt = _getHotWaterHeatingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfHotWaterTemperature() {
			byte epc = EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE;
			byte[] edt = _getSetValueOfHotWaterTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHotWaterWarmerSetting() {
			byte epc = EPC_HOT_WATER_WARMER_SETTING;
			byte[] edt = _getHotWaterWarmerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGdurationOfAutomaticOperationHSetting() {
			byte epc = EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING;
			byte[] edt = _getGdurationOfAutomaticOperationHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRemainingAutomaticOperationTime() {
			byte epc = EPC_REMAINING_AUTOMATIC_OPERATION_TIME;
			byte[] edt = _getRemainingAutomaticOperationTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfBathTemperature() {
			byte epc = EPC_SET_VALUE_OF_BATH_TEMPERATURE;
			byte[] edt = _getSetValueOfBathTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterHeaterStatus() {
			byte epc = EPC_BATH_WATER_HEATER_STATUS;
			byte[] edt = _getBathWaterHeaterStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathAutoModeSetting() {
			byte epc = EPC_BATH_AUTO_MODE_SETTING;
			byte[] edt = _getBathAutoModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathAdditionalBoilUpOperationSetting() {
			byte epc = EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING;
			byte[] edt = _getBathAdditionalBoilUpOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterAddingOperationSetting() {
			byte epc = EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING;
			byte[] edt = _getBathHotWaterAddingOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterTemperatureLoweringOperationSetting() {
			byte epc = EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING;
			byte[] edt = _getBathWaterTemperatureLoweringOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterVolumeSetting1() {
			byte epc = EPC_BATH_HOT_WATER_VOLUME_SETTING1;
			byte[] edt = _getBathHotWaterVolumeSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterVolumeSetting2() {
			byte epc = EPC_BATH_HOT_WATER_VOLUME_SETTING2;
			byte[] edt = _getBathHotWaterVolumeSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterVolumeSetting3() {
			byte epc = EPC_BATH_HOT_WATER_VOLUME_SETTING3;
			byte[] edt = _getBathHotWaterVolumeSetting3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformBathroomPrioritySetting() {
			byte epc = EPC_BATHROOM_PRIORITY_SETTING;
			byte[] edt = _getBathroomPrioritySetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShowerHotWaterSupplyStatus() {
			byte epc = EPC_SHOWER_HOT_WATER_SUPPLY_STATUS;
			byte[] edt = _getShowerHotWaterSupplyStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformKitchenHotWaterSupplyStatus() {
			byte epc = EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS;
			byte[] edt = _getKitchenHotWaterSupplyStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHotWaterWarmerOnTimerReservationSetting() {
			byte epc = EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING;
			byte[] edt = _getHotWaterWarmerOnTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfHotWaterWarmerOnTimerTime() {
			byte epc = EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME;
			byte[] edt = _getSetValueOfHotWaterWarmerOnTimerTime(epc);
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
		public Informer reqInformSetValueOfOnTimerTime() {
			byte epc = EPC_SET_VALUE_OF_ON_TIMER_TIME;
			byte[] edt = _getSetValueOfOnTimerTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfOnTimerRelativeTime() {
			byte epc = EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME;
			byte[] edt = _getSetValueOfOnTimerRelativeTime(epc);
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
		public Informer reqInformHotWaterHeatingStatus() {
			addProperty(EPC_HOT_WATER_HEATING_STATUS);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfHotWaterTemperature() {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformHotWaterWarmerSetting() {
			addProperty(EPC_HOT_WATER_WARMER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGdurationOfAutomaticOperationHSetting() {
			addProperty(EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRemainingAutomaticOperationTime() {
			addProperty(EPC_REMAINING_AUTOMATIC_OPERATION_TIME);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfBathTemperature() {
			addProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformBathWaterHeaterStatus() {
			addProperty(EPC_BATH_WATER_HEATER_STATUS);
			return this;
		}
		@Override
		public Informer reqInformBathAutoModeSetting() {
			addProperty(EPC_BATH_AUTO_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathAdditionalBoilUpOperationSetting() {
			addProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterAddingOperationSetting() {
			addProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathWaterTemperatureLoweringOperationSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterVolumeSetting1() {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterVolumeSetting2() {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterVolumeSetting3() {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3);
			return this;
		}
		@Override
		public Informer reqInformBathroomPrioritySetting() {
			addProperty(EPC_BATHROOM_PRIORITY_SETTING);
			return this;
		}
		@Override
		public Informer reqInformShowerHotWaterSupplyStatus() {
			addProperty(EPC_SHOWER_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		@Override
		public Informer reqInformKitchenHotWaterSupplyStatus() {
			addProperty(EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		@Override
		public Informer reqInformHotWaterWarmerOnTimerReservationSetting() {
			addProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfHotWaterWarmerOnTimerTime() {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME);
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfOnTimerTime() {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfOnTimerRelativeTime() {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME);
			return this;
		}
	}
}
