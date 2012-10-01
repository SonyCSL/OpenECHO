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
	@SuppressWarnings("unused")
	private static final String TAG = ElectricWaterHeater.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x6B;

	protected static final byte EPC_GAUTOMATIC_WATER_HEATING_H_SETTING = (byte)0xB0;
	protected static final byte EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING = (byte)0xB1;
	protected static final byte EPC_WATER_HEATER_STATUS = (byte)0xB2;
	protected static final byte EPC_WATER_HEATING_TEMPERATURE_SETTING = (byte)0xB3;
	protected static final byte EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING = (byte)0xC0;
	protected static final byte EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER = (byte)0xC1;
	protected static final byte EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING = (byte)0xD1;
	protected static final byte EPC_BATH_WATER_TEMPERATURE_SETTING = (byte)0xD3;
	protected static final byte EPC_BATH_WATER_VOLUME_SETTING = (byte)0xE0;
	protected static final byte EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK = (byte)0xE1;
	protected static final byte EPC_TANK_CAPACITY = (byte)0xE2;
	protected static final byte EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING = (byte)0xE3;
	protected static final byte EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING = (byte)0xE5;
	protected static final byte EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING = (byte)0xE6;
	protected static final byte EPC_BATH_WATER_VOLUME_SETTING1 = (byte)0xE7;
	protected static final byte EPC_BATH_WATER_VOLUME_SETTING2 = (byte)0xE8;
	protected static final byte EPC_BATH_WATER_VOLUME_SETTING3 = (byte)0xEE;
	protected static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	protected static final byte EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME = (byte)0xDB;
	protected static final byte EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS = (byte)0xDC;
	protected static final byte EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME = (byte)0xDD;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGautomaticWaterHeatingHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGautomaticWaterHeatingHSetting() {return null;}
	/**
	 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGautomaticWaterTemperatureControlHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGautomaticWaterTemperatureControlHSetting() {return null;}
	/**
	 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>Heating = 0x41 Not heating = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getWaterHeaterStatus() {return null;}
	/**
	 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setWaterHeatingTemperatureSetting(byte[] edt);
	/**
	 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getWaterHeatingTemperatureSetting();
	/**
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGdaytimeReheatingPermissionHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGdaytimeReheatingPermissionHSetting() {return null;}
	/**
	 * This property indicates the current temperature of the water in the water heater.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredTemperatureOfWaterInWaterHeater() {return null;}
	/**
	 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGtemperatureOfSuppliedWaterHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGtemperatureOfSuppliedWaterHSetting() {return null;}
	/**
	 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterTemperatureSetting() {return null;}
	/**
	 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterVolumeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterVolumeSetting() {return null;}
	/**
	 * This property indicates the measured amount of water left in the tank in liters.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredAmountOfWaterRemainingInTank() {return null;}
	/**
	 * This property indicates the tank capacity in liters.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getTankCapacity() {return null;}
	/**
	 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGautomaticBathWaterHeatingHModeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGautomaticBathWaterHeatingHModeSetting() {return null;}
	/**
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGadditionOfHotWaterHFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGadditionOfHotWaterHFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGslightBathWaterTemperatureLoweringHFunctionSetting() {return null;}
	/**
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x00 to 0xFD (0 to 253 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterVolumeSetting1(byte[] edt) {return false;}
	/**
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x00 to 0xFD (0 to 253 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterVolumeSetting1() {return null;}
	/**
	 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterVolumeSetting2(byte[] edt) {return false;}
	/**
	 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterVolumeSetting2() {return null;}
	/**
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterVolumeSetting3(byte[] edt) {return false;}
	/**
	 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterVolumeSetting3() {return null;}
	/**
	 * 0x31 to 0x38<br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * 0x31 to 0x38<br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * ON timer setting (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * ON timer setting (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedPowerConsumptionOfHPUnitInWintertime() {return null;}
	/**
	 * This property indicates the rated power consumption of the heat pump in in-between seasons (April, May, October, November)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {return null;}
	/**
	 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedPowerConsumptionOfHPUnitInSummertime() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING:
			res.addProperty(epc, edt, setGautomaticWaterHeatingHSetting(edt));
			break;
		case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING:
			res.addProperty(epc, edt, setGautomaticWaterTemperatureControlHSetting(edt));
			break;
		case EPC_WATER_HEATING_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setWaterHeatingTemperatureSetting(edt));
			break;
		case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING:
			res.addProperty(epc, edt, setGdaytimeReheatingPermissionHSetting(edt));
			break;
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
			res.addProperty(epc, edt, setGtemperatureOfSuppliedWaterHSetting(edt));
			break;
		case EPC_BATH_WATER_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setBathWaterTemperatureSetting(edt));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING:
			res.addProperty(epc, edt, setBathWaterVolumeSetting(edt));
			break;
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING:
			res.addProperty(epc, edt, setGautomaticBathWaterHeatingHModeSetting(edt));
			break;
		case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING:
			res.addProperty(epc, edt, setGadditionOfHotWaterHFunctionSetting(edt));
			break;
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
			res.addProperty(epc, edt, setGslightBathWaterTemperatureLoweringHFunctionSetting(edt));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING1:
			res.addProperty(epc, edt, setBathWaterVolumeSetting1(edt));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING2:
			res.addProperty(epc, edt, setBathWaterVolumeSetting2(edt));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING3:
			res.addProperty(epc, edt, setBathWaterVolumeSetting3(edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOnTimerReservationSetting(edt));
			break;
		case EPC_ON_TIMER_SETTING:
			res.addProperty(epc, edt, setOnTimerSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING:
			edt = getGautomaticWaterHeatingHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING:
			edt = getGautomaticWaterTemperatureControlHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_HEATER_STATUS:
			edt = getWaterHeaterStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_HEATING_TEMPERATURE_SETTING:
			edt = getWaterHeatingTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING:
			edt = getGdaytimeReheatingPermissionHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER:
			edt = getMeasuredTemperatureOfWaterInWaterHeater();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
			edt = getGtemperatureOfSuppliedWaterHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_TEMPERATURE_SETTING:
			edt = getBathWaterTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING:
			edt = getBathWaterVolumeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK:
			edt = getMeasuredAmountOfWaterRemainingInTank();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TANK_CAPACITY:
			edt = getTankCapacity();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING:
			edt = getGautomaticBathWaterHeatingHModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING:
			edt = getGadditionOfHotWaterHFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
			edt = getGslightBathWaterTemperatureLoweringHFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING1:
			edt = getBathWaterVolumeSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING2:
			edt = getBathWaterVolumeSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_VOLUME_SETTING3:
			edt = getBathWaterVolumeSetting3();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = getOnTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING:
			edt = getOnTimerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME:
			edt = getRatedPowerConsumptionOfHPUnitInWintertime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS:
			edt = getRatedPowerConsumptionOfHPUnitInInBetweenSeasons();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME:
			edt = getRatedPowerConsumptionOfHPUnitInSummertime();
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
			case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING:
				onSetGautomaticWaterHeatingHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING:
				onSetGautomaticWaterTemperatureControlHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_WATER_HEATING_TEMPERATURE_SETTING:
				onSetWaterHeatingTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING:
				onSetGdaytimeReheatingPermissionHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
				onSetGtemperatureOfSuppliedWaterHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_TEMPERATURE_SETTING:
				onSetBathWaterTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_VOLUME_SETTING:
				onSetBathWaterVolumeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING:
				onSetGautomaticBathWaterHeatingHModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING:
				onSetGadditionOfHotWaterHFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
				onSetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_VOLUME_SETTING1:
				onSetBathWaterVolumeSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_VOLUME_SETTING2:
				onSetBathWaterVolumeSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_VOLUME_SETTING3:
				onSetBathWaterVolumeSetting3(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onSetOnTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING:
				onSetOnTimerSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_GAUTOMATIC_WATER_HEATING_H_SETTING:
				onGetGautomaticWaterHeatingHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING:
				onGetGautomaticWaterTemperatureControlHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_WATER_HEATER_STATUS:
				onGetWaterHeaterStatus(eoj, tid, pdc, edt);
				break;
			case EPC_WATER_HEATING_TEMPERATURE_SETTING:
				onGetWaterHeatingTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING:
				onGetGdaytimeReheatingPermissionHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER:
				onGetMeasuredTemperatureOfWaterInWaterHeater(eoj, tid, pdc, edt);
				break;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
				onGetGtemperatureOfSuppliedWaterHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_TEMPERATURE_SETTING:
				onGetBathWaterTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_VOLUME_SETTING:
				onGetBathWaterVolumeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK:
				onGetMeasuredAmountOfWaterRemainingInTank(eoj, tid, pdc, edt);
				break;
			case EPC_TANK_CAPACITY:
				onGetTankCapacity(eoj, tid, pdc, edt);
				break;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING:
				onGetGautomaticBathWaterHeatingHModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING:
				onGetGadditionOfHotWaterHFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
				onGetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_VOLUME_SETTING1:
				onGetBathWaterVolumeSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_VOLUME_SETTING2:
				onGetBathWaterVolumeSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_VOLUME_SETTING3:
				onGetBathWaterVolumeSetting3(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onGetOnTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING:
				onGetOnTimerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME:
				onGetRatedPowerConsumptionOfHPUnitInWintertime(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS:
				onGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME:
				onGetRatedPowerConsumptionOfHPUnitInSummertime(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGautomaticWaterHeatingHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGautomaticWaterHeatingHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGautomaticWaterTemperatureControlHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGautomaticWaterTemperatureControlHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>Heating = 0x41 Not heating = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetWaterHeaterStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetWaterHeatingTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGdaytimeReheatingPermissionHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGdaytimeReheatingPermissionHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the current temperature of the water in the water heater.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterVolumeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterVolumeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured amount of water left in the tank in liters.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredAmountOfWaterRemainingInTank(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetTankCapacity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGautomaticBathWaterHeatingHModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGautomaticBathWaterHeatingHModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGadditionOfHotWaterHFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGadditionOfHotWaterHFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x00 to 0xFD (0 to 253 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterVolumeSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x00 to 0xFD (0 to 253 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterVolumeSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterVolumeSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterVolumeSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterVolumeSetting3(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterVolumeSetting3(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * 0x31 to 0x38<br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * 0x31 to 0x38<br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * ON timer setting (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * ON timer setting (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedPowerConsumptionOfHPUnitInWintertime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the rated power consumption of the heat pump in in-between seasons (April, May, October, November)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedPowerConsumptionOfHPUnitInSummertime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGautomaticWaterHeatingHSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGautomaticWaterTemperatureControlHSetting(byte[] edt);
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetWaterHeatingTemperatureSetting(byte[] edt);
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGdaytimeReheatingPermissionHSetting(byte[] edt);
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGtemperatureOfSuppliedWaterHSetting(byte[] edt);
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt);
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathWaterVolumeSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGautomaticBathWaterHeatingHModeSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGadditionOfHotWaterHFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt);
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x00 to 0xFD (0 to 253 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathWaterVolumeSetting1(byte[] edt);
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathWaterVolumeSetting2(byte[] edt);
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathWaterVolumeSetting3(byte[] edt);
		/**
		 * 0x31 to 0x38<br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * ON timer setting (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSetting(byte[] edt);
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
		public Setter reqSetGautomaticWaterHeatingHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING, edt, setGautomaticWaterHeatingHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGautomaticWaterTemperatureControlHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING, edt, setGautomaticWaterTemperatureControlHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetWaterHeatingTemperatureSetting(byte[] edt) {
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING, edt, setWaterHeatingTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGdaytimeReheatingPermissionHSetting(byte[] edt) {
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING, edt, setGdaytimeReheatingPermissionHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureOfSuppliedWaterHSetting(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING, edt, setGtemperatureOfSuppliedWaterHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING, edt, setBathWaterTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterVolumeSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING, edt, setBathWaterVolumeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGautomaticBathWaterHeatingHModeSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING, edt, setGautomaticBathWaterHeatingHModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGadditionOfHotWaterHFunctionSetting(byte[] edt) {
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING, edt, setGadditionOfHotWaterHFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt, setGslightBathWaterTemperatureLoweringHFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1, edt, setBathWaterVolumeSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2, edt, setBathWaterVolumeSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterVolumeSetting3(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3, edt, setBathWaterVolumeSetting3(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, setOnTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, setOnTimerSetting(edt));
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
		public Setter reqSetGautomaticWaterHeatingHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGautomaticWaterTemperatureControlHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWaterHeatingTemperatureSetting(byte[] edt) {
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGdaytimeReheatingPermissionHSetting(byte[] edt) {
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureOfSuppliedWaterHSetting(byte[] edt) {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathWaterVolumeSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGautomaticBathWaterHeatingHModeSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGadditionOfHotWaterHFunctionSetting(byte[] edt) {
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathWaterVolumeSetting3(byte[] edt) {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGautomaticWaterHeatingHSetting();
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGautomaticWaterTemperatureControlHSetting();
		/**
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>Heating = 0x41 Not heating = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetWaterHeaterStatus();
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetWaterHeatingTemperatureSetting();
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGdaytimeReheatingPermissionHSetting();
		/**
		 * This property indicates the current temperature of the water in the water heater.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater();
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGtemperatureOfSuppliedWaterHSetting();
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathWaterTemperatureSetting();
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathWaterVolumeSetting();
		/**
		 * This property indicates the measured amount of water left in the tank in liters.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredAmountOfWaterRemainingInTank();
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetTankCapacity();
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGautomaticBathWaterHeatingHModeSetting();
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGadditionOfHotWaterHFunctionSetting();
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting();
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x00 to 0xFD (0 to 253 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathWaterVolumeSetting1();
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathWaterVolumeSetting2();
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathWaterVolumeSetting3();
		/**
		 * 0x31 to 0x38<br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * ON timer setting (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSetting();
		/**
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInWintertime();
		/**
		 * This property indicates the rated power consumption of the heat pump in in-between seasons (April, May, October, November)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons();
		/**
		 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRatedPowerConsumptionOfHPUnitInSummertime();
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
		public Getter reqGetGautomaticWaterHeatingHSetting() {
			byte[] edt = getGautomaticWaterHeatingHSetting();
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGautomaticWaterTemperatureControlHSetting() {
			byte[] edt = getGautomaticWaterTemperatureControlHSetting();
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWaterHeaterStatus() {
			byte[] edt = getWaterHeaterStatus();
			addProperty(EPC_WATER_HEATER_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWaterHeatingTemperatureSetting() {
			byte[] edt = getWaterHeatingTemperatureSetting();
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGdaytimeReheatingPermissionHSetting() {
			byte[] edt = getGdaytimeReheatingPermissionHSetting();
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			byte[] edt = getMeasuredTemperatureOfWaterInWaterHeater();
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGtemperatureOfSuppliedWaterHSetting() {
			byte[] edt = getGtemperatureOfSuppliedWaterHSetting();
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterTemperatureSetting() {
			byte[] edt = getBathWaterTemperatureSetting();
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterVolumeSetting() {
			byte[] edt = getBathWaterVolumeSetting();
			addProperty(EPC_BATH_WATER_VOLUME_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredAmountOfWaterRemainingInTank() {
			byte[] edt = getMeasuredAmountOfWaterRemainingInTank();
			addProperty(EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetTankCapacity() {
			byte[] edt = getTankCapacity();
			addProperty(EPC_TANK_CAPACITY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGautomaticBathWaterHeatingHModeSetting() {
			byte[] edt = getGautomaticBathWaterHeatingHModeSetting();
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGadditionOfHotWaterHFunctionSetting() {
			byte[] edt = getGadditionOfHotWaterHFunctionSetting();
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting() {
			byte[] edt = getGslightBathWaterTemperatureLoweringHFunctionSetting();
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterVolumeSetting1() {
			byte[] edt = getBathWaterVolumeSetting1();
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterVolumeSetting2() {
			byte[] edt = getBathWaterVolumeSetting2();
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterVolumeSetting3() {
			byte[] edt = getBathWaterVolumeSetting3();
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSetting() {
			byte[] edt = getOnTimerSetting();
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfHPUnitInWintertime() {
			byte[] edt = getRatedPowerConsumptionOfHPUnitInWintertime();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			byte[] edt = getRatedPowerConsumptionOfHPUnitInInBetweenSeasons();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfHPUnitInSummertime() {
			byte[] edt = getRatedPowerConsumptionOfHPUnitInSummertime();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetGautomaticWaterHeatingHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGautomaticWaterTemperatureControlHSetting() {
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetWaterHeaterStatus() {
			addProperty(EPC_WATER_HEATER_STATUS);
			return this;
		}
		@Override
		public Getter reqGetWaterHeatingTemperatureSetting() {
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGdaytimeReheatingPermissionHSetting() {
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		@Override
		public Getter reqGetGtemperatureOfSuppliedWaterHSetting() {
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathWaterTemperatureSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathWaterVolumeSetting() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredAmountOfWaterRemainingInTank() {
			addProperty(EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK);
			return this;
		}
		@Override
		public Getter reqGetTankCapacity() {
			addProperty(EPC_TANK_CAPACITY);
			return this;
		}
		@Override
		public Getter reqGetGautomaticBathWaterHeatingHModeSetting() {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGadditionOfHotWaterHFunctionSetting() {
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting() {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathWaterVolumeSetting1() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetBathWaterVolumeSetting2() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetBathWaterVolumeSetting3() {
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3);
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfHPUnitInWintertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME);
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS);
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumptionOfHPUnitInSummertime() {
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME);
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
		 * Used to specify whether or not to use the automatic water heating function, and to acquire the current setting.<br>Automatic water heating function used: 0x41 Non-automatic water heating function stopped: 0x43 Non-automatic water heating function used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGautomaticWaterHeatingHSetting();
		/**
		 * Used to specify whether or not to use the automatic water temperature control function, and to acquire the current setting.<br>Automatic water temperature control function used: 0x41 Automatic water temperature control function not used: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGautomaticWaterTemperatureControlHSetting();
		/**
		 * This property indicates the current status of the water heater in terms of whether it is heating water or not.<br>Heating = 0x41 Not heating = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformWaterHeaterStatus();
		/**
		 * Used to specify (in ��C) the temperature of heated water to achieve, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformWaterHeatingTemperatureSetting();
		/**
		 * Used to specify whether or not to permit daytime reheating, and to acquire the current setting.<br>Daytime reheating permitted: 0x41 Daytime reheating not permitted: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGdaytimeReheatingPermissionHSetting();
		/**
		 * This property indicates the current temperature of the water in the water heater.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater();
		/**
		 * Used to specify the temperature of water supplied from the water heater in ��C, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGtemperatureOfSuppliedWaterHSetting();
		/**
		 * Used to specify (in ��C) the temperature up to which the water heater will heat bath water, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathWaterTemperatureSetting();
		/**
		 * Used to specify (in %) the volume of bath water the bathtub will contain upon completion of heating, and to acquire the current setting.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathWaterVolumeSetting();
		/**
		 * This property indicates the measured amount of water left in the tank in liters.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredAmountOfWaterRemainingInTank();
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformTankCapacity();
		/**
		 * Used to specify whether or not to use the �gautomatic bath water heating�h mode, and to acquire the current setting.<br>�gAutomatic bath water heating�h mode ON = 0x41 �gAutomatic bath water heating�h mode OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGautomaticBathWaterHeatingHModeSetting();
		/**
		 * Used to specify whether or not to use the function to add hot water to the bath water in the bathtub, and to acquire the current setting.<br>�gAddition of hot water�h function ON = 0x41 �gAddition of hot water�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGadditionOfHotWaterHFunctionSetting();
		/**
		 * Used to specify whether or not to use the �gslight bath water temperature lowering�h function, and to acquire the current setting.<br>�gSlight bath water temperature lowering�h function ON = 0x41 �gSlight bath water temperature lowering�h function OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting();
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x00 to 0xFD (0 to 253 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathWaterVolumeSetting1();
		/**
		 * Used to specify the bath water volume by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathWaterVolumeSetting2();
		/**
		 * Used to specify the bath water volume in liters, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533 liters)<br><br>Data type : unsigned short<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathWaterVolumeSetting3();
		/**
		 * 0x31 to 0x38<br>Reservation ON = 0x41 Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * ON timer setting (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * This property indicates the rated power consumption of the heat pump in wintertime (December to Mar.ch)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInWintertime();
		/**
		 * This property indicates the rated power consumption of the heat pump in in-between seasons (April, May, October, November)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInInBetweenSeasons();
		/**
		 * This property indicates the rated power consumption of the heat pump in summertime (June to September)<br>0x0000-0xFFFD(0-65,533)<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRatedPowerConsumptionOfHPUnitInSummertime();
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
		public Informer reqInformGautomaticWaterHeatingHSetting() {
			byte[] edt = getGautomaticWaterHeatingHSetting();
			addProperty(EPC_GAUTOMATIC_WATER_HEATING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGautomaticWaterTemperatureControlHSetting() {
			byte[] edt = getGautomaticWaterTemperatureControlHSetting();
			addProperty(EPC_GAUTOMATIC_WATER_TEMPERATURE_CONTROL_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterHeaterStatus() {
			byte[] edt = getWaterHeaterStatus();
			addProperty(EPC_WATER_HEATER_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterHeatingTemperatureSetting() {
			byte[] edt = getWaterHeatingTemperatureSetting();
			addProperty(EPC_WATER_HEATING_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGdaytimeReheatingPermissionHSetting() {
			byte[] edt = getGdaytimeReheatingPermissionHSetting();
			addProperty(EPC_GDAYTIME_REHEATING_PERMISSION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater() {
			byte[] edt = getMeasuredTemperatureOfWaterInWaterHeater();
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGtemperatureOfSuppliedWaterHSetting() {
			byte[] edt = getGtemperatureOfSuppliedWaterHSetting();
			addProperty(EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterTemperatureSetting() {
			byte[] edt = getBathWaterTemperatureSetting();
			addProperty(EPC_BATH_WATER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting() {
			byte[] edt = getBathWaterVolumeSetting();
			addProperty(EPC_BATH_WATER_VOLUME_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredAmountOfWaterRemainingInTank() {
			byte[] edt = getMeasuredAmountOfWaterRemainingInTank();
			addProperty(EPC_MEASURED_AMOUNT_OF_WATER_REMAINING_IN_TANK, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformTankCapacity() {
			byte[] edt = getTankCapacity();
			addProperty(EPC_TANK_CAPACITY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGautomaticBathWaterHeatingHModeSetting() {
			byte[] edt = getGautomaticBathWaterHeatingHModeSetting();
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_H_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGadditionOfHotWaterHFunctionSetting() {
			byte[] edt = getGadditionOfHotWaterHFunctionSetting();
			addProperty(EPC_GADDITION_OF_HOT_WATER_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting() {
			byte[] edt = getGslightBathWaterTemperatureLoweringHFunctionSetting();
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting1() {
			byte[] edt = getBathWaterVolumeSetting1();
			addProperty(EPC_BATH_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting2() {
			byte[] edt = getBathWaterVolumeSetting2();
			addProperty(EPC_BATH_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterVolumeSetting3() {
			byte[] edt = getBathWaterVolumeSetting3();
			addProperty(EPC_BATH_WATER_VOLUME_SETTING3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSetting() {
			byte[] edt = getOnTimerSetting();
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfHPUnitInWintertime() {
			byte[] edt = getRatedPowerConsumptionOfHPUnitInWintertime();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_WINTERTIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfHPUnitInInBetweenSeasons() {
			byte[] edt = getRatedPowerConsumptionOfHPUnitInInBetweenSeasons();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_IN_BETWEEN_SEASONS, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumptionOfHPUnitInSummertime() {
			byte[] edt = getRatedPowerConsumptionOfHPUnitInSummertime();
			addProperty(EPC_RATED_POWER_CONSUMPTION_OF_H_P_UNIT_IN_SUMMERTIME, edt, (edt != null && (edt.length == 2)));
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
