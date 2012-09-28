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
	@SuppressWarnings("unused")
	private static final String TAG = InstantaneousWaterHeater.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x72;

	protected static final byte EPC_HOT_WATER_HEATING_STATUS = (byte)0xD0;
	protected static final byte EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE = (byte)0xD1;
	protected static final byte EPC_HOT_WATER_WARMER_SETTING = (byte)0xD2;
	protected static final byte EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING = (byte)0xDA;
	protected static final byte EPC_REMAINING_AUTOMATIC_OPERATION_TIME = (byte)0xDB;
	protected static final byte EPC_SET_VALUE_OF_BATH_TEMPERATURE = (byte)0xE1;
	protected static final byte EPC_BATH_WATER_HEATER_STATUS = (byte)0xE2;
	protected static final byte EPC_BATH_AUTO_MODE_SETTING = (byte)0xE3;
	protected static final byte EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING = (byte)0xE4;
	protected static final byte EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING = (byte)0xE5;
	protected static final byte EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING = (byte)0xE6;
	protected static final byte EPC_BATH_HOT_WATER_VOLUME_SETTING1 = (byte)0xE7;
	protected static final byte EPC_BATH_HOT_WATER_VOLUME_SETTING2 = (byte)0xE8;
	protected static final byte EPC_BATH_HOT_WATER_VOLUME_SETTING3 = (byte)0xEE;
	protected static final byte EPC_BATHROOM_PRIORITY_SETTING = (byte)0xE9;
	protected static final byte EPC_SHOWER_HOT_WATER_SUPPLY_STATUS = (byte)0xEA;
	protected static final byte EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS = (byte)0xEB;
	protected static final byte EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING = (byte)0xEC;
	protected static final byte EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME = (byte)0xED;
	protected static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_SET_VALUE_OF_ON_TIMER_TIME = (byte)0x91;
	protected static final byte EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME = (byte)0x92;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates hot water heating status.<br>Hot water heating status found = 0x41 Hot water heating status not found = 0x42
	 */
	protected abstract byte[] getHotWaterHeatingStatus();
	/**
	 * This property indicates set value of hot water temperature in .C.<br>0x00.0x64 (0.100)
	 */
	protected boolean setSetValueOfHotWaterTemperature(byte[] edt) {return false;}
	/**
	 * This property indicates set value of hot water temperature in .C.<br>0x00.0x64 (0.100)
	 */
	protected byte[] getSetValueOfHotWaterTemperature() {return null;}
	/**
	 * Hot water warmer setting<br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42
	 */
	protected boolean setHotWaterWarmerSetting(byte[] edt) {return false;}
	/**
	 * Hot water warmer setting<br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42
	 */
	protected byte[] getHotWaterWarmerSetting() {return null;}
	/**
	 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF
	 */
	protected boolean setGdurationOfAutomaticOperationHSetting(byte[] edt) {return false;}
	/**
	 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF
	 */
	protected byte[] getGdurationOfAutomaticOperationHSetting() {return null;}
	/**
	 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Infinite: 0xFFFF
	 */
	protected byte[] getRemainingAutomaticOperationTime() {return null;}
	/**
	 * This property indicates set value of bath temperature in .C.<br>0x00.0x64 (0.100)
	 */
	protected boolean setSetValueOfBathTemperature(byte[] edt) {return false;}
	/**
	 * This property indicates set value of bath temperature in .C.<br>0x00.0x64 (0.100)
	 */
	protected byte[] getSetValueOfBathTemperature() {return null;}
	/**
	 * This property indicates whether or not the bath water heater is heating bath water.<br>Heating = 0x41 Not heating = 0x42
	 */
	protected abstract byte[] getBathWaterHeaterStatus();
	/**
	 * Bath auto mode ON/OFF<br>Auto ON = 0x41 Auto OFF = 0x42
	 */
	protected boolean setBathAutoModeSetting(byte[] edt) {return false;}
	/**
	 * Bath auto mode ON/OFF<br>Auto ON = 0x41 Auto OFF = 0x42
	 */
	protected byte[] getBathAutoModeSetting() {return null;}
	/**
	 * Additional boil-up ON/OFF<br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42
	 */
	protected boolean setBathAdditionalBoilUpOperationSetting(byte[] edt) {return false;}
	/**
	 * Additional boil-up ON/OFF<br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42
	 */
	protected byte[] getBathAdditionalBoilUpOperationSetting() {return null;}
	/**
	 * Hot water addition ON/OFF<br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42
	 */
	protected boolean setBathHotWaterAddingOperationSetting(byte[] edt) {return false;}
	/**
	 * Hot water addition ON/OFF<br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42
	 */
	protected byte[] getBathHotWaterAddingOperationSetting() {return null;}
	/**
	 * Hot water temperature lowering ON/OFF<br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42
	 */
	protected boolean setBathWaterTemperatureLoweringOperationSetting(byte[] edt) {return false;}
	/**
	 * Hot water temperature lowering ON/OFF<br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42
	 */
	protected byte[] getBathWaterTemperatureLoweringOperationSetting() {return null;}
	/**
	 * This property indicates bath hot water volume in liters.<br>0x00.0xFD (0 to 253 liters)
	 */
	protected boolean setBathHotWaterVolumeSetting1(byte[] edt) {return false;}
	/**
	 * This property indicates bath hot water volume in liters.<br>0x00.0xFD (0 to 253 liters)
	 */
	protected byte[] getBathHotWaterVolumeSetting1() {return null;}
	/**
	 * Specifies bath hot water volume (8-step).<br>0x31.0x38
	 */
	protected boolean setBathHotWaterVolumeSetting2(byte[] edt) {return false;}
	/**
	 * Specifies bath hot water volume (8-step).<br>0x31.0x38
	 */
	protected byte[] getBathHotWaterVolumeSetting2() {return null;}
	/**
	 * This property indicates bath hot water volume in liters.<br>0x0000.0xFFFD (0 to 65533 liters)
	 */
	protected boolean setBathHotWaterVolumeSetting3(byte[] edt) {return false;}
	/**
	 * This property indicates bath hot water volume in liters.<br>0x0000.0xFFFD (0 to 65533 liters)
	 */
	protected byte[] getBathHotWaterVolumeSetting3() {return null;}
	/**
	 * Bathroom priority ON/OFF<br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42
	 */
	protected boolean setBathroomPrioritySetting(byte[] edt) {return false;}
	/**
	 * Bathroom priority ON/OFF<br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42
	 */
	protected byte[] getBathroomPrioritySetting() {return null;}
	/**
	 * Shower hot water supply ON/OFF<br>Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42
	 */
	protected byte[] getShowerHotWaterSupplyStatus() {return null;}
	/**
	 * Kitchen hot water supply ON/OFF<br>Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42
	 */
	protected byte[] getKitchenHotWaterSupplyStatus() {return null;}
	/**
	 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42
	 */
	protected boolean setHotWaterWarmerOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42
	 */
	protected byte[] getHotWaterWarmerOnTimerReservationSetting() {return null;}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected boolean setSetValueOfHotWaterWarmerOnTimerTime(byte[] edt) {return false;}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected byte[] getSetValueOfHotWaterWarmerOnTimerTime() {return null;}
	/**
	 * Reservation ON/Reservation OFF<br>Reservation ON = 0x41 Reservation OFF = 0x42
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/Reservation OFF<br>Reservation ON = 0x41 Reservation OFF = 0x42
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected boolean setSetValueOfOnTimerTime(byte[] edt) {return false;}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected byte[] getSetValueOfOnTimerTime() {return null;}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected boolean setSetValueOfOnTimerRelativeTime(byte[] edt) {return false;}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected byte[] getSetValueOfOnTimerRelativeTime() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE:
			res.addProperty(epc, edt, setSetValueOfHotWaterTemperature(edt));
			break;
		case EPC_HOT_WATER_WARMER_SETTING:
			res.addProperty(epc, edt, setHotWaterWarmerSetting(edt));
			break;
		case EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING:
			res.addProperty(epc, edt, setGdurationOfAutomaticOperationHSetting(edt));
			break;
		case EPC_SET_VALUE_OF_BATH_TEMPERATURE:
			res.addProperty(epc, edt, setSetValueOfBathTemperature(edt));
			break;
		case EPC_BATH_AUTO_MODE_SETTING:
			res.addProperty(epc, edt, setBathAutoModeSetting(edt));
			break;
		case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING:
			res.addProperty(epc, edt, setBathAdditionalBoilUpOperationSetting(edt));
			break;
		case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING:
			res.addProperty(epc, edt, setBathHotWaterAddingOperationSetting(edt));
			break;
		case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING:
			res.addProperty(epc, edt, setBathWaterTemperatureLoweringOperationSetting(edt));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING1:
			res.addProperty(epc, edt, setBathHotWaterVolumeSetting1(edt));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING2:
			res.addProperty(epc, edt, setBathHotWaterVolumeSetting2(edt));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING3:
			res.addProperty(epc, edt, setBathHotWaterVolumeSetting3(edt));
			break;
		case EPC_BATHROOM_PRIORITY_SETTING:
			res.addProperty(epc, edt, setBathroomPrioritySetting(edt));
			break;
		case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setHotWaterWarmerOnTimerReservationSetting(edt));
			break;
		case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME:
			res.addProperty(epc, edt, setSetValueOfHotWaterWarmerOnTimerTime(edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOnTimerReservationSetting(edt));
			break;
		case EPC_SET_VALUE_OF_ON_TIMER_TIME:
			res.addProperty(epc, edt, setSetValueOfOnTimerTime(edt));
			break;
		case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME:
			res.addProperty(epc, edt, setSetValueOfOnTimerRelativeTime(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_HOT_WATER_HEATING_STATUS:
			edt = getHotWaterHeatingStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE:
			edt = getSetValueOfHotWaterTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HOT_WATER_WARMER_SETTING:
			edt = getHotWaterWarmerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING:
			edt = getGdurationOfAutomaticOperationHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_REMAINING_AUTOMATIC_OPERATION_TIME:
			edt = getRemainingAutomaticOperationTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SET_VALUE_OF_BATH_TEMPERATURE:
			edt = getSetValueOfBathTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_HEATER_STATUS:
			edt = getBathWaterHeaterStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_AUTO_MODE_SETTING:
			edt = getBathAutoModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING:
			edt = getBathAdditionalBoilUpOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING:
			edt = getBathHotWaterAddingOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING:
			edt = getBathWaterTemperatureLoweringOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING1:
			edt = getBathHotWaterVolumeSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING2:
			edt = getBathHotWaterVolumeSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_HOT_WATER_VOLUME_SETTING3:
			edt = getBathHotWaterVolumeSetting3();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_BATHROOM_PRIORITY_SETTING:
			edt = getBathroomPrioritySetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHOWER_HOT_WATER_SUPPLY_STATUS:
			edt = getShowerHotWaterSupplyStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS:
			edt = getKitchenHotWaterSupplyStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING:
			edt = getHotWaterWarmerOnTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME:
			edt = getSetValueOfHotWaterWarmerOnTimerTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = getOnTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_ON_TIMER_TIME:
			edt = getSetValueOfOnTimerTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME:
			edt = getSetValueOfOnTimerRelativeTime();
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
			case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE:
				onSetSetValueOfHotWaterTemperature(eoj, tid, (pdc != 0));
				break;
			case EPC_HOT_WATER_WARMER_SETTING:
				onSetHotWaterWarmerSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING:
				onSetGdurationOfAutomaticOperationHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_BATH_TEMPERATURE:
				onSetSetValueOfBathTemperature(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_AUTO_MODE_SETTING:
				onSetBathAutoModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING:
				onSetBathAdditionalBoilUpOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING:
				onSetBathHotWaterAddingOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING:
				onSetBathWaterTemperatureLoweringOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING1:
				onSetBathHotWaterVolumeSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING2:
				onSetBathHotWaterVolumeSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING3:
				onSetBathHotWaterVolumeSetting3(eoj, tid, (pdc != 0));
				break;
			case EPC_BATHROOM_PRIORITY_SETTING:
				onSetBathroomPrioritySetting(eoj, tid, (pdc != 0));
				break;
			case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING:
				onSetHotWaterWarmerOnTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME:
				onSetSetValueOfHotWaterWarmerOnTimerTime(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onSetOnTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_ON_TIMER_TIME:
				onSetSetValueOfOnTimerTime(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME:
				onSetSetValueOfOnTimerRelativeTime(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_HOT_WATER_HEATING_STATUS:
				onGetHotWaterHeatingStatus(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE:
				onGetSetValueOfHotWaterTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_HOT_WATER_WARMER_SETTING:
				onGetHotWaterWarmerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING:
				onGetGdurationOfAutomaticOperationHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_REMAINING_AUTOMATIC_OPERATION_TIME:
				onGetRemainingAutomaticOperationTime(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_BATH_TEMPERATURE:
				onGetSetValueOfBathTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_HEATER_STATUS:
				onGetBathWaterHeaterStatus(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_AUTO_MODE_SETTING:
				onGetBathAutoModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING:
				onGetBathAdditionalBoilUpOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING:
				onGetBathHotWaterAddingOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING:
				onGetBathWaterTemperatureLoweringOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING1:
				onGetBathHotWaterVolumeSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING2:
				onGetBathHotWaterVolumeSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_HOT_WATER_VOLUME_SETTING3:
				onGetBathHotWaterVolumeSetting3(eoj, tid, pdc, edt);
				break;
			case EPC_BATHROOM_PRIORITY_SETTING:
				onGetBathroomPrioritySetting(eoj, tid, pdc, edt);
				break;
			case EPC_SHOWER_HOT_WATER_SUPPLY_STATUS:
				onGetShowerHotWaterSupplyStatus(eoj, tid, pdc, edt);
				break;
			case EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS:
				onGetKitchenHotWaterSupplyStatus(eoj, tid, pdc, edt);
				break;
			case EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING:
				onGetHotWaterWarmerOnTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME:
				onGetSetValueOfHotWaterWarmerOnTimerTime(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onGetOnTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_ON_TIMER_TIME:
				onGetSetValueOfOnTimerTime(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME:
				onGetSetValueOfOnTimerRelativeTime(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates hot water heating status.<br>Hot water heating status found = 0x41 Hot water heating status not found = 0x42
		 */
		protected void onGetHotWaterHeatingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates set value of hot water temperature in .C.<br>0x00.0x64 (0.100)
		 */
		protected void onSetSetValueOfHotWaterTemperature(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates set value of hot water temperature in .C.<br>0x00.0x64 (0.100)
		 */
		protected void onGetSetValueOfHotWaterTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Hot water warmer setting<br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42
		 */
		protected void onSetHotWaterWarmerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Hot water warmer setting<br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42
		 */
		protected void onGetHotWaterWarmerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF
		 */
		protected void onSetGdurationOfAutomaticOperationHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF
		 */
		protected void onGetGdurationOfAutomaticOperationHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Infinite: 0xFFFF
		 */
		protected void onGetRemainingAutomaticOperationTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates set value of bath temperature in .C.<br>0x00.0x64 (0.100)
		 */
		protected void onSetSetValueOfBathTemperature(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates set value of bath temperature in .C.<br>0x00.0x64 (0.100)
		 */
		protected void onGetSetValueOfBathTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether or not the bath water heater is heating bath water.<br>Heating = 0x41 Not heating = 0x42
		 */
		protected void onGetBathWaterHeaterStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Bath auto mode ON/OFF<br>Auto ON = 0x41 Auto OFF = 0x42
		 */
		protected void onSetBathAutoModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Bath auto mode ON/OFF<br>Auto ON = 0x41 Auto OFF = 0x42
		 */
		protected void onGetBathAutoModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Additional boil-up ON/OFF<br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42
		 */
		protected void onSetBathAdditionalBoilUpOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Additional boil-up ON/OFF<br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42
		 */
		protected void onGetBathAdditionalBoilUpOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Hot water addition ON/OFF<br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42
		 */
		protected void onSetBathHotWaterAddingOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Hot water addition ON/OFF<br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42
		 */
		protected void onGetBathHotWaterAddingOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Hot water temperature lowering ON/OFF<br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42
		 */
		protected void onSetBathWaterTemperatureLoweringOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Hot water temperature lowering ON/OFF<br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42
		 */
		protected void onGetBathWaterTemperatureLoweringOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates bath hot water volume in liters.<br>0x00.0xFD (0 to 253 liters)
		 */
		protected void onSetBathHotWaterVolumeSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates bath hot water volume in liters.<br>0x00.0xFD (0 to 253 liters)
		 */
		protected void onGetBathHotWaterVolumeSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Specifies bath hot water volume (8-step).<br>0x31.0x38
		 */
		protected void onSetBathHotWaterVolumeSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Specifies bath hot water volume (8-step).<br>0x31.0x38
		 */
		protected void onGetBathHotWaterVolumeSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates bath hot water volume in liters.<br>0x0000.0xFFFD (0 to 65533 liters)
		 */
		protected void onSetBathHotWaterVolumeSetting3(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates bath hot water volume in liters.<br>0x0000.0xFFFD (0 to 65533 liters)
		 */
		protected void onGetBathHotWaterVolumeSetting3(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Bathroom priority ON/OFF<br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42
		 */
		protected void onSetBathroomPrioritySetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Bathroom priority ON/OFF<br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42
		 */
		protected void onGetBathroomPrioritySetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Shower hot water supply ON/OFF<br>Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42
		 */
		protected void onGetShowerHotWaterSupplyStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Kitchen hot water supply ON/OFF<br>Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42
		 */
		protected void onGetKitchenHotWaterSupplyStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42
		 */
		protected void onSetHotWaterWarmerOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42
		 */
		protected void onGetHotWaterWarmerOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onSetSetValueOfHotWaterWarmerOnTimerTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onGetSetValueOfHotWaterWarmerOnTimerTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/Reservation OFF<br>Reservation ON = 0x41 Reservation OFF = 0x42
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/Reservation OFF<br>Reservation ON = 0x41 Reservation OFF = 0x42
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onSetSetValueOfOnTimerTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onGetSetValueOfOnTimerTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onSetSetValueOfOnTimerRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onGetSetValueOfOnTimerRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

	}
	
	public interface Setter extends DeviceObject.Setter {
		public Setter reqSetPower(byte[] edt);
		public Setter reqSetInstallationLocation(byte[] edt);
		public Setter reqSetCurrentLimiting(byte[] edt);
		public Setter reqSetPowerSaving(byte[] edt);
		public Setter reqSetLocation(byte[] edt);
		public Setter reqSetCurrentTime(byte[] edt);
		public Setter reqSetCurrentDate(byte[] edt);
		public Setter reqSetPowerLimitation(byte[] edt);
		
		/**
		 * This property indicates set value of hot water temperature in .C.<br>0x00.0x64 (0.100)
		 */
		public Setter reqSetSetValueOfHotWaterTemperature(byte[] edt);
		/**
		 * Hot water warmer setting<br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42
		 */
		public Setter reqSetHotWaterWarmerSetting(byte[] edt);
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF
		 */
		public Setter reqSetGdurationOfAutomaticOperationHSetting(byte[] edt);
		/**
		 * This property indicates set value of bath temperature in .C.<br>0x00.0x64 (0.100)
		 */
		public Setter reqSetSetValueOfBathTemperature(byte[] edt);
		/**
		 * Bath auto mode ON/OFF<br>Auto ON = 0x41 Auto OFF = 0x42
		 */
		public Setter reqSetBathAutoModeSetting(byte[] edt);
		/**
		 * Additional boil-up ON/OFF<br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42
		 */
		public Setter reqSetBathAdditionalBoilUpOperationSetting(byte[] edt);
		/**
		 * Hot water addition ON/OFF<br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42
		 */
		public Setter reqSetBathHotWaterAddingOperationSetting(byte[] edt);
		/**
		 * Hot water temperature lowering ON/OFF<br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42
		 */
		public Setter reqSetBathWaterTemperatureLoweringOperationSetting(byte[] edt);
		/**
		 * This property indicates bath hot water volume in liters.<br>0x00.0xFD (0 to 253 liters)
		 */
		public Setter reqSetBathHotWaterVolumeSetting1(byte[] edt);
		/**
		 * Specifies bath hot water volume (8-step).<br>0x31.0x38
		 */
		public Setter reqSetBathHotWaterVolumeSetting2(byte[] edt);
		/**
		 * This property indicates bath hot water volume in liters.<br>0x0000.0xFFFD (0 to 65533 liters)
		 */
		public Setter reqSetBathHotWaterVolumeSetting3(byte[] edt);
		/**
		 * Bathroom priority ON/OFF<br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42
		 */
		public Setter reqSetBathroomPrioritySetting(byte[] edt);
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42
		 */
		public Setter reqSetHotWaterWarmerOnTimerReservationSetting(byte[] edt);
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Setter reqSetSetValueOfHotWaterWarmerOnTimerTime(byte[] edt);
		/**
		 * Reservation ON/Reservation OFF<br>Reservation ON = 0x41 Reservation OFF = 0x42
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Setter reqSetSetValueOfOnTimerTime(byte[] edt);
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Setter reqSetSetValueOfOnTimerRelativeTime(byte[] edt);

	}

	public class SetterImpl extends DeviceObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
		}
		
		@Override
		public Setter reqSetPower(byte[] edt) {
			return (Setter)super.reqSetPower(edt);
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimiting(edt);
		}

		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			return (Setter)super.reqSetPowerSaving(edt);
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			return (Setter)super.reqSetLocation(edt);
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			return (Setter)super.reqSetCurrentTime(edt);
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			return (Setter)super.reqSetCurrentDate(edt);
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			return (Setter)super.reqSetPowerLimitation(edt);
		}

		@Override
		public Setter reqSetSetValueOfHotWaterTemperature(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE, edt, setSetValueOfHotWaterTemperature(edt));
			return this;
		}
		@Override
		public Setter reqSetHotWaterWarmerSetting(byte[] edt) {
			addProperty(EPC_HOT_WATER_WARMER_SETTING, edt, setHotWaterWarmerSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGdurationOfAutomaticOperationHSetting(byte[] edt) {
			addProperty(EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING, edt, setGdurationOfAutomaticOperationHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfBathTemperature(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE, edt, setSetValueOfBathTemperature(edt));
			return this;
		}
		@Override
		public Setter reqSetBathAutoModeSetting(byte[] edt) {
			addProperty(EPC_BATH_AUTO_MODE_SETTING, edt, setBathAutoModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathAdditionalBoilUpOperationSetting(byte[] edt) {
			addProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING, edt, setBathAdditionalBoilUpOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathHotWaterAddingOperationSetting(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING, edt, setBathHotWaterAddingOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterTemperatureLoweringOperationSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING, edt, setBathWaterTemperatureLoweringOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathHotWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1, edt, setBathHotWaterVolumeSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetBathHotWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2, edt, setBathHotWaterVolumeSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetBathHotWaterVolumeSetting3(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3, edt, setBathHotWaterVolumeSetting3(edt));
			return this;
		}
		@Override
		public Setter reqSetBathroomPrioritySetting(byte[] edt) {
			addProperty(EPC_BATHROOM_PRIORITY_SETTING, edt, setBathroomPrioritySetting(edt));
			return this;
		}
		@Override
		public Setter reqSetHotWaterWarmerOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING, edt, setHotWaterWarmerOnTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfHotWaterWarmerOnTimerTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME, edt, setSetValueOfHotWaterWarmerOnTimerTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, setOnTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfOnTimerTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME, edt, setSetValueOfOnTimerTime(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfOnTimerRelativeTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME, edt, setSetValueOfOnTimerRelativeTime(edt));
			return this;
		}

	}
	
	public class SetterProxy extends DeviceObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
		}

		
		@Override
		public Setter reqSetPower(byte[] edt) {
			return (Setter)super.reqSetPower(edt);
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimiting(edt);
		}

		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			return (Setter)super.reqSetPowerSaving(edt);
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			return (Setter)super.reqSetLocation(edt);
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			return (Setter)super.reqSetCurrentTime(edt);
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			return (Setter)super.reqSetCurrentDate(edt);
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			return (Setter)super.reqSetPowerLimitation(edt);
		}

		@Override
		public Setter reqSetSetValueOfHotWaterTemperature(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHotWaterWarmerSetting(byte[] edt) {
			addProperty(EPC_HOT_WATER_WARMER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGdurationOfAutomaticOperationHSetting(byte[] edt) {
			addProperty(EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfBathTemperature(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathAutoModeSetting(byte[] edt) {
			addProperty(EPC_BATH_AUTO_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathAdditionalBoilUpOperationSetting(byte[] edt) {
			addProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathHotWaterAddingOperationSetting(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathWaterTemperatureLoweringOperationSetting(byte[] edt) {
			addProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathHotWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathHotWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathHotWaterVolumeSetting3(byte[] edt) {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetBathroomPrioritySetting(byte[] edt) {
			addProperty(EPC_BATHROOM_PRIORITY_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHotWaterWarmerOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfHotWaterWarmerOnTimerTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfOnTimerTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfOnTimerRelativeTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}

	}

	public interface Getter extends DeviceObject.Getter {
		public Getter reqGetPower();
		public Getter reqGetInstallationLocation();
		public Getter reqGetVersion();
		public Getter reqGetIdNumber();
		public Getter reqGetElectricityConsumption();
		public Getter reqGetPowerConsumption();
		public Getter reqGetMakerErrorCode();
		public Getter reqGetCurrentLimiting();
		public Getter reqGetError();
		public Getter reqGetErrorInfo();
		public Getter reqGetMakerCode();
		public Getter reqGetWorkplaceCode();
		public Getter reqGetProductCode();
		public Getter reqGetManufacturingNumber();
		public Getter reqGetDateOfManufacture();
		public Getter reqGetPowerSaving();
		public Getter reqGetLocation();
		public Getter reqGetCurrentTime();
		public Getter reqGetCurrentDate();
		public Getter reqGetPowerLimitation();
		public Getter reqGetWorkingTime();
		public Getter reqGetAnnoPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		/**
		 * This property indicates hot water heating status.<br>Hot water heating status found = 0x41 Hot water heating status not found = 0x42
		 */
		public Getter reqGetHotWaterHeatingStatus();
		/**
		 * This property indicates set value of hot water temperature in .C.<br>0x00.0x64 (0.100)
		 */
		public Getter reqGetSetValueOfHotWaterTemperature();
		/**
		 * Hot water warmer setting<br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42
		 */
		public Getter reqGetHotWaterWarmerSetting();
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF
		 */
		public Getter reqGetGdurationOfAutomaticOperationHSetting();
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Infinite: 0xFFFF
		 */
		public Getter reqGetRemainingAutomaticOperationTime();
		/**
		 * This property indicates set value of bath temperature in .C.<br>0x00.0x64 (0.100)
		 */
		public Getter reqGetSetValueOfBathTemperature();
		/**
		 * This property indicates whether or not the bath water heater is heating bath water.<br>Heating = 0x41 Not heating = 0x42
		 */
		public Getter reqGetBathWaterHeaterStatus();
		/**
		 * Bath auto mode ON/OFF<br>Auto ON = 0x41 Auto OFF = 0x42
		 */
		public Getter reqGetBathAutoModeSetting();
		/**
		 * Additional boil-up ON/OFF<br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42
		 */
		public Getter reqGetBathAdditionalBoilUpOperationSetting();
		/**
		 * Hot water addition ON/OFF<br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42
		 */
		public Getter reqGetBathHotWaterAddingOperationSetting();
		/**
		 * Hot water temperature lowering ON/OFF<br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42
		 */
		public Getter reqGetBathWaterTemperatureLoweringOperationSetting();
		/**
		 * This property indicates bath hot water volume in liters.<br>0x00.0xFD (0 to 253 liters)
		 */
		public Getter reqGetBathHotWaterVolumeSetting1();
		/**
		 * Specifies bath hot water volume (8-step).<br>0x31.0x38
		 */
		public Getter reqGetBathHotWaterVolumeSetting2();
		/**
		 * This property indicates bath hot water volume in liters.<br>0x0000.0xFFFD (0 to 65533 liters)
		 */
		public Getter reqGetBathHotWaterVolumeSetting3();
		/**
		 * Bathroom priority ON/OFF<br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42
		 */
		public Getter reqGetBathroomPrioritySetting();
		/**
		 * Shower hot water supply ON/OFF<br>Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42
		 */
		public Getter reqGetShowerHotWaterSupplyStatus();
		/**
		 * Kitchen hot water supply ON/OFF<br>Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42
		 */
		public Getter reqGetKitchenHotWaterSupplyStatus();
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42
		 */
		public Getter reqGetHotWaterWarmerOnTimerReservationSetting();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Getter reqGetSetValueOfHotWaterWarmerOnTimerTime();
		/**
		 * Reservation ON/Reservation OFF<br>Reservation ON = 0x41 Reservation OFF = 0x42
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Getter reqGetSetValueOfOnTimerTime();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Getter reqGetSetValueOfOnTimerRelativeTime();

	}
	
	public class GetterImpl extends DeviceObject.GetterImpl implements Getter {

		@Override
		public Getter reqGetPower() {
			return (Getter)super.reqGetPower();
		}

		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}

		@Override
		public Getter reqGetVersion() {
			return (Getter)super.reqGetVersion();
		}

		@Override
		public Getter reqGetIdNumber() {
			return (Getter)super.reqGetIdNumber();
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			return (Getter)super.reqGetElectricityConsumption();
		}

		@Override
		public Getter reqGetPowerConsumption() {
			return (Getter)super.reqGetPowerConsumption();
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			return (Getter)super.reqGetMakerErrorCode();
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			return (Getter)super.reqGetCurrentLimiting();
		}

		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
		}

		@Override
		public Getter reqGetErrorInfo() {
			return (Getter)super.reqGetErrorInfo();
		}

		@Override
		public Getter reqGetMakerCode() {
			return (Getter)super.reqGetMakerCode();
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			return (Getter)super.reqGetWorkplaceCode();
		}

		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			return (Getter)super.reqGetManufacturingNumber();
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
		}

		@Override
		public Getter reqGetPowerSaving() {
			return (Getter)super.reqGetPowerSaving();
		}

		@Override
		public Getter reqGetLocation() {
			return (Getter)super.reqGetLocation();
		}

		@Override
		public Getter reqGetCurrentTime() {
			return (Getter)super.reqGetCurrentTime();
		}

		@Override
		public Getter reqGetCurrentDate() {
			return (Getter)super.reqGetCurrentDate();
		}

		@Override
		public Getter reqGetPowerLimitation() {
			return (Getter)super.reqGetPowerLimitation();
		}

		@Override
		public Getter reqGetWorkingTime() {
			return (Getter)super.reqGetWorkingTime();
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			return (Getter)super.reqGetAnnoPropertyMap();
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
		public Getter reqGetHotWaterHeatingStatus() {
			byte[] edt = getHotWaterHeatingStatus();
			addProperty(EPC_HOT_WATER_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfHotWaterTemperature() {
			byte[] edt = getSetValueOfHotWaterTemperature();
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHotWaterWarmerSetting() {
			byte[] edt = getHotWaterWarmerSetting();
			addProperty(EPC_HOT_WATER_WARMER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGdurationOfAutomaticOperationHSetting() {
			byte[] edt = getGdurationOfAutomaticOperationHSetting();
			addProperty(EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRemainingAutomaticOperationTime() {
			byte[] edt = getRemainingAutomaticOperationTime();
			addProperty(EPC_REMAINING_AUTOMATIC_OPERATION_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfBathTemperature() {
			byte[] edt = getSetValueOfBathTemperature();
			addProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterHeaterStatus() {
			byte[] edt = getBathWaterHeaterStatus();
			addProperty(EPC_BATH_WATER_HEATER_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathAutoModeSetting() {
			byte[] edt = getBathAutoModeSetting();
			addProperty(EPC_BATH_AUTO_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathAdditionalBoilUpOperationSetting() {
			byte[] edt = getBathAdditionalBoilUpOperationSetting();
			addProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathHotWaterAddingOperationSetting() {
			byte[] edt = getBathHotWaterAddingOperationSetting();
			addProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterTemperatureLoweringOperationSetting() {
			byte[] edt = getBathWaterTemperatureLoweringOperationSetting();
			addProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathHotWaterVolumeSetting1() {
			byte[] edt = getBathHotWaterVolumeSetting1();
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathHotWaterVolumeSetting2() {
			byte[] edt = getBathHotWaterVolumeSetting2();
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathHotWaterVolumeSetting3() {
			byte[] edt = getBathHotWaterVolumeSetting3();
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetBathroomPrioritySetting() {
			byte[] edt = getBathroomPrioritySetting();
			addProperty(EPC_BATHROOM_PRIORITY_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetShowerHotWaterSupplyStatus() {
			byte[] edt = getShowerHotWaterSupplyStatus();
			addProperty(EPC_SHOWER_HOT_WATER_SUPPLY_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetKitchenHotWaterSupplyStatus() {
			byte[] edt = getKitchenHotWaterSupplyStatus();
			addProperty(EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHotWaterWarmerOnTimerReservationSetting() {
			byte[] edt = getHotWaterWarmerOnTimerReservationSetting();
			addProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfHotWaterWarmerOnTimerTime() {
			byte[] edt = getSetValueOfHotWaterWarmerOnTimerTime();
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfOnTimerTime() {
			byte[] edt = getSetValueOfOnTimerTime();
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfOnTimerRelativeTime() {
			byte[] edt = getSetValueOfOnTimerRelativeTime();
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}

	}

	public class GetterProxy extends DeviceObject.GetterProxy implements Getter {

		@Override
		public Getter reqGetPower() {
			return (Getter)super.reqGetPower();
		}

		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}

		@Override
		public Getter reqGetVersion() {
			return (Getter)super.reqGetVersion();
		}

		@Override
		public Getter reqGetIdNumber() {
			return (Getter)super.reqGetIdNumber();
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			return (Getter)super.reqGetElectricityConsumption();
		}

		@Override
		public Getter reqGetPowerConsumption() {
			return (Getter)super.reqGetPowerConsumption();
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			return (Getter)super.reqGetMakerErrorCode();
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			return (Getter)super.reqGetCurrentLimiting();
		}

		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
		}

		@Override
		public Getter reqGetErrorInfo() {
			return (Getter)super.reqGetErrorInfo();
		}

		@Override
		public Getter reqGetMakerCode() {
			return (Getter)super.reqGetMakerCode();
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			return (Getter)super.reqGetWorkplaceCode();
		}

		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			return (Getter)super.reqGetManufacturingNumber();
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
		}

		@Override
		public Getter reqGetPowerSaving() {
			return (Getter)super.reqGetPowerSaving();
		}

		@Override
		public Getter reqGetLocation() {
			return (Getter)super.reqGetLocation();
		}

		@Override
		public Getter reqGetCurrentTime() {
			return (Getter)super.reqGetCurrentTime();
		}

		@Override
		public Getter reqGetCurrentDate() {
			return (Getter)super.reqGetCurrentDate();
		}

		@Override
		public Getter reqGetPowerLimitation() {
			return (Getter)super.reqGetPowerLimitation();
		}

		@Override
		public Getter reqGetWorkingTime() {
			return (Getter)super.reqGetWorkingTime();
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			return (Getter)super.reqGetAnnoPropertyMap();
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
		public Getter reqGetHotWaterHeatingStatus() {
			addProperty(EPC_HOT_WATER_HEATING_STATUS);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfHotWaterTemperature() {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetHotWaterWarmerSetting() {
			addProperty(EPC_HOT_WATER_WARMER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGdurationOfAutomaticOperationHSetting() {
			addProperty(EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRemainingAutomaticOperationTime() {
			addProperty(EPC_REMAINING_AUTOMATIC_OPERATION_TIME);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfBathTemperature() {
			addProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetBathWaterHeaterStatus() {
			addProperty(EPC_BATH_WATER_HEATER_STATUS);
			return this;
		}
		@Override
		public Getter reqGetBathAutoModeSetting() {
			addProperty(EPC_BATH_AUTO_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathAdditionalBoilUpOperationSetting() {
			addProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathHotWaterAddingOperationSetting() {
			addProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathWaterTemperatureLoweringOperationSetting() {
			addProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathHotWaterVolumeSetting1() {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetBathHotWaterVolumeSetting2() {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetBathHotWaterVolumeSetting3() {
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3);
			return this;
		}
		@Override
		public Getter reqGetBathroomPrioritySetting() {
			addProperty(EPC_BATHROOM_PRIORITY_SETTING);
			return this;
		}
		@Override
		public Getter reqGetShowerHotWaterSupplyStatus() {
			addProperty(EPC_SHOWER_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		@Override
		public Getter reqGetKitchenHotWaterSupplyStatus() {
			addProperty(EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS);
			return this;
		}
		@Override
		public Getter reqGetHotWaterWarmerOnTimerReservationSetting() {
			addProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfHotWaterWarmerOnTimerTime() {
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME);
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfOnTimerTime() {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfOnTimerRelativeTime() {
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME);
			return this;
		}

	}
	
	public interface Informer extends DeviceObject.Informer {
		public Informer reqInformPower();
		public Informer reqInformInstallationLocation();
		public Informer reqInformVersion();
		public Informer reqInformIdNumber();
		public Informer reqInformElectricityConsumption();
		public Informer reqInformPowerConsumption();
		public Informer reqInformMakerErrorCode();
		public Informer reqInformCurrentLimiting();
		public Informer reqInformError();
		public Informer reqInformErrorInfo();
		public Informer reqInformMakerCode();
		public Informer reqInformWorkplaceCode();
		public Informer reqInformProductCode();
		public Informer reqInformManufacturingNumber();
		public Informer reqInformDateOfManufacture();
		public Informer reqInformPowerSaving();
		public Informer reqInformLocation();
		public Informer reqInformCurrentTime();
		public Informer reqInformCurrentDate();
		public Informer reqInformPowerLimitation();
		public Informer reqInformWorkingTime();
		public Informer reqInformAnnoPropertyMap();
		public Informer reqInformSetPropertyMap();
		public Informer reqInformGetPropertyMap();
		
		/**
		 * This property indicates hot water heating status.<br>Hot water heating status found = 0x41 Hot water heating status not found = 0x42
		 */
		public Informer reqInformHotWaterHeatingStatus();
		/**
		 * This property indicates set value of hot water temperature in .C.<br>0x00.0x64 (0.100)
		 */
		public Informer reqInformSetValueOfHotWaterTemperature();
		/**
		 * Hot water warmer setting<br>Hot water warmer operation = 0x41 Hot water warmer operation resetting = 0x42
		 */
		public Informer reqInformHotWaterWarmerSetting();
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Limitless: 0xFFFF
		 */
		public Informer reqInformGdurationOfAutomaticOperationHSetting();
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59) Infinite: 0xFFFF
		 */
		public Informer reqInformRemainingAutomaticOperationTime();
		/**
		 * This property indicates set value of bath temperature in .C.<br>0x00.0x64 (0.100)
		 */
		public Informer reqInformSetValueOfBathTemperature();
		/**
		 * This property indicates whether or not the bath water heater is heating bath water.<br>Heating = 0x41 Not heating = 0x42
		 */
		public Informer reqInformBathWaterHeaterStatus();
		/**
		 * Bath auto mode ON/OFF<br>Auto ON = 0x41 Auto OFF = 0x42
		 */
		public Informer reqInformBathAutoModeSetting();
		/**
		 * Additional boil-up ON/OFF<br>Additional boil-up ON = 0x41 Additional boil-up OFF = 0x42
		 */
		public Informer reqInformBathAdditionalBoilUpOperationSetting();
		/**
		 * Hot water addition ON/OFF<br>Hot water addition ON = 0x41 Hot water addition OFF = 0x42
		 */
		public Informer reqInformBathHotWaterAddingOperationSetting();
		/**
		 * Hot water temperature lowering ON/OFF<br>Hot water temperature lowering ON = 0x41 Hot water temperature lowering OFF = 0x42
		 */
		public Informer reqInformBathWaterTemperatureLoweringOperationSetting();
		/**
		 * This property indicates bath hot water volume in liters.<br>0x00.0xFD (0 to 253 liters)
		 */
		public Informer reqInformBathHotWaterVolumeSetting1();
		/**
		 * Specifies bath hot water volume (8-step).<br>0x31.0x38
		 */
		public Informer reqInformBathHotWaterVolumeSetting2();
		/**
		 * This property indicates bath hot water volume in liters.<br>0x0000.0xFFFD (0 to 65533 liters)
		 */
		public Informer reqInformBathHotWaterVolumeSetting3();
		/**
		 * Bathroom priority ON/OFF<br>Bathroom priority ON = 0x41, bathroom priority OFF = 0x42
		 */
		public Informer reqInformBathroomPrioritySetting();
		/**
		 * Shower hot water supply ON/OFF<br>Shower hot water supply ON = 0x41 Shower hot water supply OFF = 0x42
		 */
		public Informer reqInformShowerHotWaterSupplyStatus();
		/**
		 * Kitchen hot water supply ON/OFF<br>Kitchen hot water supply ON = 0x41 kitchen hot water supply OFF = 0x42
		 */
		public Informer reqInformKitchenHotWaterSupplyStatus();
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42
		 */
		public Informer reqInformHotWaterWarmerOnTimerReservationSetting();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Informer reqInformSetValueOfHotWaterWarmerOnTimerTime();
		/**
		 * Reservation ON/Reservation OFF<br>Reservation ON = 0x41 Reservation OFF = 0x42
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Informer reqInformSetValueOfOnTimerTime();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Informer reqInformSetValueOfOnTimerRelativeTime();

	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {

		@Override
		public Informer reqInformPower() {
			return (Informer)super.reqInformPower();
		}

		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}

		@Override
		public Informer reqInformVersion() {
			return (Informer)super.reqInformVersion();
		}

		@Override
		public Informer reqInformIdNumber() {
			return (Informer)super.reqInformIdNumber();
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			return (Informer)super.reqInformElectricityConsumption();
		}

		@Override
		public Informer reqInformPowerConsumption() {
			return (Informer)super.reqInformPowerConsumption();
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			return (Informer)super.reqInformMakerErrorCode();
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			return (Informer)super.reqInformCurrentLimiting();
		}

		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
		}

		@Override
		public Informer reqInformErrorInfo() {
			return (Informer)super.reqInformErrorInfo();
		}

		@Override
		public Informer reqInformMakerCode() {
			return (Informer)super.reqInformMakerCode();
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			return (Informer)super.reqInformWorkplaceCode();
		}

		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			return (Informer)super.reqInformManufacturingNumber();
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}

		@Override
		public Informer reqInformPowerSaving() {
			return (Informer)super.reqInformPowerSaving();
		}

		@Override
		public Informer reqInformLocation() {
			return (Informer)super.reqInformLocation();
		}

		@Override
		public Informer reqInformCurrentTime() {
			return (Informer)super.reqInformCurrentTime();
		}

		@Override
		public Informer reqInformCurrentDate() {
			return (Informer)super.reqInformCurrentDate();
		}

		@Override
		public Informer reqInformPowerLimitation() {
			return (Informer)super.reqInformPowerLimitation();
		}

		@Override
		public Informer reqInformWorkingTime() {
			return (Informer)super.reqInformWorkingTime();
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
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
			byte[] edt = getHotWaterHeatingStatus();
			addProperty(EPC_HOT_WATER_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfHotWaterTemperature() {
			byte[] edt = getSetValueOfHotWaterTemperature();
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHotWaterWarmerSetting() {
			byte[] edt = getHotWaterWarmerSetting();
			addProperty(EPC_HOT_WATER_WARMER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGdurationOfAutomaticOperationHSetting() {
			byte[] edt = getGdurationOfAutomaticOperationHSetting();
			addProperty(EPC_GDURATION_OF_AUTOMATIC_OPERATION_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRemainingAutomaticOperationTime() {
			byte[] edt = getRemainingAutomaticOperationTime();
			addProperty(EPC_REMAINING_AUTOMATIC_OPERATION_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfBathTemperature() {
			byte[] edt = getSetValueOfBathTemperature();
			addProperty(EPC_SET_VALUE_OF_BATH_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterHeaterStatus() {
			byte[] edt = getBathWaterHeaterStatus();
			addProperty(EPC_BATH_WATER_HEATER_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathAutoModeSetting() {
			byte[] edt = getBathAutoModeSetting();
			addProperty(EPC_BATH_AUTO_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathAdditionalBoilUpOperationSetting() {
			byte[] edt = getBathAdditionalBoilUpOperationSetting();
			addProperty(EPC_BATH_ADDITIONAL_BOIL_UP_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterAddingOperationSetting() {
			byte[] edt = getBathHotWaterAddingOperationSetting();
			addProperty(EPC_BATH_HOT_WATER_ADDING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterTemperatureLoweringOperationSetting() {
			byte[] edt = getBathWaterTemperatureLoweringOperationSetting();
			addProperty(EPC_BATH_WATER_TEMPERATURE_LOWERING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterVolumeSetting1() {
			byte[] edt = getBathHotWaterVolumeSetting1();
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterVolumeSetting2() {
			byte[] edt = getBathHotWaterVolumeSetting2();
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathHotWaterVolumeSetting3() {
			byte[] edt = getBathHotWaterVolumeSetting3();
			addProperty(EPC_BATH_HOT_WATER_VOLUME_SETTING3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformBathroomPrioritySetting() {
			byte[] edt = getBathroomPrioritySetting();
			addProperty(EPC_BATHROOM_PRIORITY_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShowerHotWaterSupplyStatus() {
			byte[] edt = getShowerHotWaterSupplyStatus();
			addProperty(EPC_SHOWER_HOT_WATER_SUPPLY_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformKitchenHotWaterSupplyStatus() {
			byte[] edt = getKitchenHotWaterSupplyStatus();
			addProperty(EPC_KITCHEN_HOT_WATER_SUPPLY_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHotWaterWarmerOnTimerReservationSetting() {
			byte[] edt = getHotWaterWarmerOnTimerReservationSetting();
			addProperty(EPC_HOT_WATER_WARMER_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfHotWaterWarmerOnTimerTime() {
			byte[] edt = getSetValueOfHotWaterWarmerOnTimerTime();
			addProperty(EPC_SET_VALUE_OF_HOT_WATER_WARMER_ON_TIMER_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfOnTimerTime() {
			byte[] edt = getSetValueOfOnTimerTime();
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfOnTimerRelativeTime() {
			byte[] edt = getSetValueOfOnTimerRelativeTime();
			addProperty(EPC_SET_VALUE_OF_ON_TIMER_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}

	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {

		@Override
		public Informer reqInformPower() {
			return (Informer)super.reqInformPower();
		}

		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}

		@Override
		public Informer reqInformVersion() {
			return (Informer)super.reqInformVersion();
		}

		@Override
		public Informer reqInformIdNumber() {
			return (Informer)super.reqInformIdNumber();
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			return (Informer)super.reqInformElectricityConsumption();
		}

		@Override
		public Informer reqInformPowerConsumption() {
			return (Informer)super.reqInformPowerConsumption();
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			return (Informer)super.reqInformMakerErrorCode();
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			return (Informer)super.reqInformCurrentLimiting();
		}

		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
		}

		@Override
		public Informer reqInformErrorInfo() {
			return (Informer)super.reqInformErrorInfo();
		}

		@Override
		public Informer reqInformMakerCode() {
			return (Informer)super.reqInformMakerCode();
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			return (Informer)super.reqInformWorkplaceCode();
		}

		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			return (Informer)super.reqInformManufacturingNumber();
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}

		@Override
		public Informer reqInformPowerSaving() {
			return (Informer)super.reqInformPowerSaving();
		}

		@Override
		public Informer reqInformLocation() {
			return (Informer)super.reqInformLocation();
		}

		@Override
		public Informer reqInformCurrentTime() {
			return (Informer)super.reqInformCurrentTime();
		}

		@Override
		public Informer reqInformCurrentDate() {
			return (Informer)super.reqInformCurrentDate();
		}

		@Override
		public Informer reqInformPowerLimitation() {
			return (Informer)super.reqInformPowerLimitation();
		}

		@Override
		public Informer reqInformWorkingTime() {
			return (Informer)super.reqInformWorkingTime();
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
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
