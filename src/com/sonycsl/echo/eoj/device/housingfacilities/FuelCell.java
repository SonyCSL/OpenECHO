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

public abstract class FuelCell extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = FuelCell.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x7C;

	protected static final byte EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE = (byte)0xB1;
	protected static final byte EPC_HEATING_STATUS = (byte)0xB2;
	protected static final byte EPC_HEATED_WATER_TEMPERATURE_SETTING = (byte)0xB3;
	protected static final byte EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER = (byte)0xC1;
	protected static final byte EPC_RATED_POWER_GENERATION_OUTPUT = (byte)0xC2;
	protected static final byte EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK = (byte)0xC3;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT = (byte)0xC4;
	protected static final byte EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT = (byte)0xC5;
	protected static final byte EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING = (byte)0xC6;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION = (byte)0xC7;
	protected static final byte EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION = (byte)0xC8;
	protected static final byte EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING = (byte)0xC9;
	protected static final byte EPC_POWER_GENERATION_SETTING = (byte)0xCA;
	protected static final byte EPC_BATH_WATER_REHEATING = (byte)0xE4;
	protected static final byte EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING = (byte)0xD1;
	protected static final byte EPC_BATH_WATER_TEMPERATURE_SETTING = (byte)0xD3;
	protected static final byte EPC_HEATED_BATH_WATER_AMOUNT_SETTING = (byte)0xE0;
	protected static final byte EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT = (byte)0xE1;
	protected static final byte EPC_TANK_CAPACITY = (byte)0xE2;
	protected static final byte EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING = (byte)0xE3;
	protected static final byte EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING = (byte)0xE5;
	protected static final byte EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING = (byte)0xE6;
	protected static final byte EPC_BATH_WATER_AMOUNT_SETTING2 = (byte)0xE8;
	protected static final byte EPC_BATH_WATER_AMOUNT_SETTING3 = (byte)0xEE;
	protected static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_ON_TIMER_SETTING = (byte)0x91;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setAutomaticSettingOfHeatedWaterTemperature(byte[] edt) {return false;}
	/**
	 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAutomaticSettingOfHeatedWaterTemperature() {return null;}
	/**
	 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHeatingStatus() {return null;}
	/**
	 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatedWaterTemperatureSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatedWaterTemperatureSetting() {return null;}
	/**
	 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredTemperatureOfWaterInWaterHeater() {return null;}
	/**
	 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedPowerGenerationOutput() {return null;}
	/**
	 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHeatingValueOfHotWaterStorageTank() {return null;}
	/**
	 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getMeasuredInstantaneousPowerGenerationOutput();
	/**
	 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getMeasuredCumulativePowerGenerationOutput();
	/**
	 * Resets the cumulative power generation output by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
	 */
	protected boolean setCumulativePowerGenerationOutputResetSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredInstantaneousGasConsumption() {return null;}
	/**
	 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredCumulativeGasConsumption() {return null;}
	/**
	 * Resets the cumulative gas consumption by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
	 */
	protected boolean setCumulativeGasConsumptionResetSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setPowerGenerationSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getPowerGenerationSetting() {return null;}
	/**
	 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterReheating(byte[] edt) {return false;}
	/**
	 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterReheating() {return null;}
	/**
	 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGtemperatureOfSuppliedWaterHSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGtemperatureOfSuppliedWaterHSetting() {return null;}
	/**
	 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterTemperatureSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterTemperatureSetting() {return null;}
	/**
	 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatedBathWaterAmountSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatedBathWaterAmountSetting() {return null;}
	/**
	 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredRemainingHotWaterAmount() {return null;}
	/**
	 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getTankCapacity() {return null;}
	/**
	 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGautomaticBathWaterHeatingModeHSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGautomaticBathWaterHeatingModeHSetting() {return null;}
	/**
	 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGbathWaterAdditionFunctionHSetting(byte[] edt) {return false;}
	/**
	 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGbathWaterAdditionFunctionHSetting() {return null;}
	/**
	 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {return false;}
	/**
	 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGslightBathWaterTemperatureLoweringHFunctionSetting() {return null;}
	/**
	 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterAmountSetting2(byte[] edt) {return false;}
	/**
	 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterAmountSetting2() {return null;}
	/**
	 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterAmountSetting3(byte[] edt) {return false;}
	/**
	 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterAmountSetting3() {return null;}
	/**
	 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE:
			res.addProperty(epc, edt, setAutomaticSettingOfHeatedWaterTemperature(edt));
			break;
		case EPC_HEATED_WATER_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setHeatedWaterTemperatureSetting(edt));
			break;
		case EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING:
			res.addProperty(epc, edt, setCumulativePowerGenerationOutputResetSetting(edt));
			break;
		case EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING:
			res.addProperty(epc, edt, setCumulativeGasConsumptionResetSetting(edt));
			break;
		case EPC_POWER_GENERATION_SETTING:
			res.addProperty(epc, edt, setPowerGenerationSetting(edt));
			break;
		case EPC_BATH_WATER_REHEATING:
			res.addProperty(epc, edt, setBathWaterReheating(edt));
			break;
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
			res.addProperty(epc, edt, setGtemperatureOfSuppliedWaterHSetting(edt));
			break;
		case EPC_BATH_WATER_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setBathWaterTemperatureSetting(edt));
			break;
		case EPC_HEATED_BATH_WATER_AMOUNT_SETTING:
			res.addProperty(epc, edt, setHeatedBathWaterAmountSetting(edt));
			break;
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING:
			res.addProperty(epc, edt, setGautomaticBathWaterHeatingModeHSetting(edt));
			break;
		case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING:
			res.addProperty(epc, edt, setGbathWaterAdditionFunctionHSetting(edt));
			break;
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
			res.addProperty(epc, edt, setGslightBathWaterTemperatureLoweringHFunctionSetting(edt));
			break;
		case EPC_BATH_WATER_AMOUNT_SETTING2:
			res.addProperty(epc, edt, setBathWaterAmountSetting2(edt));
			break;
		case EPC_BATH_WATER_AMOUNT_SETTING3:
			res.addProperty(epc, edt, setBathWaterAmountSetting3(edt));
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
		case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE:
			edt = getAutomaticSettingOfHeatedWaterTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_STATUS:
			edt = getHeatingStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATED_WATER_TEMPERATURE_SETTING:
			edt = getHeatedWaterTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER:
			edt = getMeasuredTemperatureOfWaterInWaterHeater();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RATED_POWER_GENERATION_OUTPUT:
			edt = getRatedPowerGenerationOutput();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK:
			edt = getHeatingValueOfHotWaterStorageTank();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT:
			edt = getMeasuredInstantaneousPowerGenerationOutput();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT:
			edt = getMeasuredCumulativePowerGenerationOutput();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION:
			edt = getMeasuredInstantaneousGasConsumption();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION:
			edt = getMeasuredCumulativeGasConsumption();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_POWER_GENERATION_SETTING:
			edt = getPowerGenerationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_REHEATING:
			edt = getBathWaterReheating();
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
		case EPC_HEATED_BATH_WATER_AMOUNT_SETTING:
			edt = getHeatedBathWaterAmountSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT:
			edt = getMeasuredRemainingHotWaterAmount();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TANK_CAPACITY:
			edt = getTankCapacity();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING:
			edt = getGautomaticBathWaterHeatingModeHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING:
			edt = getGbathWaterAdditionFunctionHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
			edt = getGslightBathWaterTemperatureLoweringHFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_AMOUNT_SETTING2:
			edt = getBathWaterAmountSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_AMOUNT_SETTING3:
			edt = getBathWaterAmountSetting3();
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
			case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE:
				onSetAutomaticSettingOfHeatedWaterTemperature(eoj, tid, (pdc != 0));
				break;
			case EPC_HEATED_WATER_TEMPERATURE_SETTING:
				onSetHeatedWaterTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING:
				onSetCumulativePowerGenerationOutputResetSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING:
				onSetCumulativeGasConsumptionResetSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_POWER_GENERATION_SETTING:
				onSetPowerGenerationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_REHEATING:
				onSetBathWaterReheating(eoj, tid, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
				onSetGtemperatureOfSuppliedWaterHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_TEMPERATURE_SETTING:
				onSetBathWaterTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_HEATED_BATH_WATER_AMOUNT_SETTING:
				onSetHeatedBathWaterAmountSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING:
				onSetGautomaticBathWaterHeatingModeHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING:
				onSetGbathWaterAdditionFunctionHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
				onSetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_AMOUNT_SETTING2:
				onSetBathWaterAmountSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_BATH_WATER_AMOUNT_SETTING3:
				onSetBathWaterAmountSetting3(eoj, tid, (pdc != 0));
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
			case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE:
				onGetAutomaticSettingOfHeatedWaterTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_HEATING_STATUS:
				onGetHeatingStatus(eoj, tid, pdc, edt);
				break;
			case EPC_HEATED_WATER_TEMPERATURE_SETTING:
				onGetHeatedWaterTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER:
				onGetMeasuredTemperatureOfWaterInWaterHeater(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_POWER_GENERATION_OUTPUT:
				onGetRatedPowerGenerationOutput(eoj, tid, pdc, edt);
				break;
			case EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK:
				onGetHeatingValueOfHotWaterStorageTank(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT:
				onGetMeasuredInstantaneousPowerGenerationOutput(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT:
				onGetMeasuredCumulativePowerGenerationOutput(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION:
				onGetMeasuredInstantaneousGasConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION:
				onGetMeasuredCumulativeGasConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_POWER_GENERATION_SETTING:
				onGetPowerGenerationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_REHEATING:
				onGetBathWaterReheating(eoj, tid, pdc, edt);
				break;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
				onGetGtemperatureOfSuppliedWaterHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_TEMPERATURE_SETTING:
				onGetBathWaterTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_HEATED_BATH_WATER_AMOUNT_SETTING:
				onGetHeatedBathWaterAmountSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT:
				onGetMeasuredRemainingHotWaterAmount(eoj, tid, pdc, edt);
				break;
			case EPC_TANK_CAPACITY:
				onGetTankCapacity(eoj, tid, pdc, edt);
				break;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING:
				onGetGautomaticBathWaterHeatingModeHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING:
				onGetGbathWaterAdditionFunctionHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
				onGetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_AMOUNT_SETTING2:
				onGetBathWaterAmountSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_BATH_WATER_AMOUNT_SETTING3:
				onGetBathWaterAmountSetting3(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onGetOnTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING:
				onGetOnTimerSetting(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, boolean success) {}
		/**
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHeatingValueOfHotWaterStorageTank(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetMeasuredInstantaneousPowerGenerationOutput(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetMeasuredCumulativePowerGenerationOutput(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Resets the cumulative power generation output by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		protected void onSetCumulativePowerGenerationOutputResetSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredInstantaneousGasConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Resets the cumulative gas consumption by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		protected void onSetCumulativeGasConsumptionResetSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetPowerGenerationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetPowerGenerationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterReheating(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterReheating(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredRemainingHotWaterAmount(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetTankCapacity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterAmountSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterAmountSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterAmountSetting3(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterAmountSetting3(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetAutomaticSettingOfHeatedWaterTemperature(byte[] edt);
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetHeatedWaterTemperatureSetting(byte[] edt);
		/**
		 * Resets the cumulative power generation output by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		public Setter reqSetCumulativePowerGenerationOutputResetSetting(byte[] edt);
		/**
		 * Resets the cumulative gas consumption by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		public Setter reqSetCumulativeGasConsumptionResetSetting(byte[] edt);
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetPowerGenerationSetting(byte[] edt);
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathWaterReheating(byte[] edt);
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGtemperatureOfSuppliedWaterHSetting(byte[] edt);
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt);
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetHeatedBathWaterAmountSetting(byte[] edt);
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGautomaticBathWaterHeatingModeHSetting(byte[] edt);
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGbathWaterAdditionFunctionHSetting(byte[] edt);
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt);
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathWaterAmountSetting2(byte[] edt);
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathWaterAmountSetting3(byte[] edt);
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
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
		public Setter reqSetAutomaticSettingOfHeatedWaterTemperature(byte[] edt) {
			addProperty(EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE, edt, setAutomaticSettingOfHeatedWaterTemperature(edt));
			return this;
		}
		@Override
		public Setter reqSetHeatedWaterTemperatureSetting(byte[] edt) {
			addProperty(EPC_HEATED_WATER_TEMPERATURE_SETTING, edt, setHeatedWaterTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetCumulativePowerGenerationOutputResetSetting(byte[] edt) {
			addProperty(EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING, edt, setCumulativePowerGenerationOutputResetSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetCumulativeGasConsumptionResetSetting(byte[] edt) {
			addProperty(EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING, edt, setCumulativeGasConsumptionResetSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetPowerGenerationSetting(byte[] edt) {
			addProperty(EPC_POWER_GENERATION_SETTING, edt, setPowerGenerationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterReheating(byte[] edt) {
			addProperty(EPC_BATH_WATER_REHEATING, edt, setBathWaterReheating(edt));
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
		public Setter reqSetHeatedBathWaterAmountSetting(byte[] edt) {
			addProperty(EPC_HEATED_BATH_WATER_AMOUNT_SETTING, edt, setHeatedBathWaterAmountSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGautomaticBathWaterHeatingModeHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING, edt, setGautomaticBathWaterHeatingModeHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGbathWaterAdditionFunctionHSetting(byte[] edt) {
			addProperty(EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING, edt, setGbathWaterAdditionFunctionHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt, setGslightBathWaterTemperatureLoweringHFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterAmountSetting2(byte[] edt) {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING2, edt, setBathWaterAmountSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterAmountSetting3(byte[] edt) {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING3, edt, setBathWaterAmountSetting3(edt));
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
		public Setter reqSetAutomaticSettingOfHeatedWaterTemperature(byte[] edt) {
			addProperty(EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHeatedWaterTemperatureSetting(byte[] edt) {
			addProperty(EPC_HEATED_WATER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetCumulativePowerGenerationOutputResetSetting(byte[] edt) {
			addProperty(EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetCumulativeGasConsumptionResetSetting(byte[] edt) {
			addProperty(EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetPowerGenerationSetting(byte[] edt) {
			addProperty(EPC_POWER_GENERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathWaterReheating(byte[] edt) {
			addProperty(EPC_BATH_WATER_REHEATING, edt, (edt != null && (edt.length == 1)));
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
		public Setter reqSetHeatedBathWaterAmountSetting(byte[] edt) {
			addProperty(EPC_HEATED_BATH_WATER_AMOUNT_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGautomaticBathWaterHeatingModeHSetting(byte[] edt) {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGbathWaterAdditionFunctionHSetting(byte[] edt) {
			addProperty(EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathWaterAmountSetting2(byte[] edt) {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathWaterAmountSetting3(byte[] edt) {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING3, edt, (edt != null && (edt.length == 2)));
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
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetAutomaticSettingOfHeatedWaterTemperature();
		/**
		 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetHeatingStatus();
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetHeatedWaterTemperatureSetting();
		/**
		 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater();
		/**
		 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRatedPowerGenerationOutput();
		/**
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetHeatingValueOfHotWaterStorageTank();
		/**
		 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetMeasuredInstantaneousPowerGenerationOutput();
		/**
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetMeasuredCumulativePowerGenerationOutput();
		/**
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredInstantaneousGasConsumption();
		/**
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredCumulativeGasConsumption();
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetPowerGenerationSetting();
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathWaterReheating();
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGtemperatureOfSuppliedWaterHSetting();
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathWaterTemperatureSetting();
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetHeatedBathWaterAmountSetting();
		/**
		 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredRemainingHotWaterAmount();
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetTankCapacity();
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGautomaticBathWaterHeatingModeHSetting();
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGbathWaterAdditionFunctionHSetting();
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting();
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathWaterAmountSetting2();
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathWaterAmountSetting3();
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSetting();
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
		public Getter reqGetAutomaticSettingOfHeatedWaterTemperature() {
			byte[] edt = getAutomaticSettingOfHeatedWaterTemperature();
			addProperty(EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatingStatus() {
			byte[] edt = getHeatingStatus();
			addProperty(EPC_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatedWaterTemperatureSetting() {
			byte[] edt = getHeatedWaterTemperatureSetting();
			addProperty(EPC_HEATED_WATER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			byte[] edt = getMeasuredTemperatureOfWaterInWaterHeater();
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerGenerationOutput() {
			byte[] edt = getRatedPowerGenerationOutput();
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetHeatingValueOfHotWaterStorageTank() {
			byte[] edt = getHeatingValueOfHotWaterStorageTank();
			addProperty(EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousPowerGenerationOutput() {
			byte[] edt = getMeasuredInstantaneousPowerGenerationOutput();
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativePowerGenerationOutput() {
			byte[] edt = getMeasuredCumulativePowerGenerationOutput();
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousGasConsumption() {
			byte[] edt = getMeasuredInstantaneousGasConsumption();
			addProperty(EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeGasConsumption() {
			byte[] edt = getMeasuredCumulativeGasConsumption();
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetPowerGenerationSetting() {
			byte[] edt = getPowerGenerationSetting();
			addProperty(EPC_POWER_GENERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterReheating() {
			byte[] edt = getBathWaterReheating();
			addProperty(EPC_BATH_WATER_REHEATING, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetHeatedBathWaterAmountSetting() {
			byte[] edt = getHeatedBathWaterAmountSetting();
			addProperty(EPC_HEATED_BATH_WATER_AMOUNT_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredRemainingHotWaterAmount() {
			byte[] edt = getMeasuredRemainingHotWaterAmount();
			addProperty(EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetTankCapacity() {
			byte[] edt = getTankCapacity();
			addProperty(EPC_TANK_CAPACITY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGautomaticBathWaterHeatingModeHSetting() {
			byte[] edt = getGautomaticBathWaterHeatingModeHSetting();
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGbathWaterAdditionFunctionHSetting() {
			byte[] edt = getGbathWaterAdditionFunctionHSetting();
			addProperty(EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting() {
			byte[] edt = getGslightBathWaterTemperatureLoweringHFunctionSetting();
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterAmountSetting2() {
			byte[] edt = getBathWaterAmountSetting2();
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterAmountSetting3() {
			byte[] edt = getBathWaterAmountSetting3();
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING3, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetAutomaticSettingOfHeatedWaterTemperature() {
			addProperty(EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		@Override
		public Getter reqGetHeatedWaterTemperatureSetting() {
			addProperty(EPC_HEATED_WATER_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		@Override
		public Getter reqGetRatedPowerGenerationOutput() {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT);
			return this;
		}
		@Override
		public Getter reqGetHeatingValueOfHotWaterStorageTank() {
			addProperty(EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK);
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousPowerGenerationOutput() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativePowerGenerationOutput() {
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT);
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousGasConsumption() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeGasConsumption() {
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		@Override
		public Getter reqGetPowerGenerationSetting() {
			addProperty(EPC_POWER_GENERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathWaterReheating() {
			addProperty(EPC_BATH_WATER_REHEATING);
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
		public Getter reqGetHeatedBathWaterAmountSetting() {
			addProperty(EPC_HEATED_BATH_WATER_AMOUNT_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredRemainingHotWaterAmount() {
			addProperty(EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT);
			return this;
		}
		@Override
		public Getter reqGetTankCapacity() {
			addProperty(EPC_TANK_CAPACITY);
			return this;
		}
		@Override
		public Getter reqGetGautomaticBathWaterHeatingModeHSetting() {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGbathWaterAdditionFunctionHSetting() {
			addProperty(EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting() {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathWaterAmountSetting2() {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetBathWaterAmountSetting3() {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING3);
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
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformAutomaticSettingOfHeatedWaterTemperature();
		/**
		 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformHeatingStatus();
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformHeatedWaterTemperatureSetting();
		/**
		 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater();
		/**
		 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRatedPowerGenerationOutput();
		/**
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformHeatingValueOfHotWaterStorageTank();
		/**
		 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformMeasuredInstantaneousPowerGenerationOutput();
		/**
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformMeasuredCumulativePowerGenerationOutput();
		/**
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredInstantaneousGasConsumption();
		/**
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredCumulativeGasConsumption();
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformPowerGenerationSetting();
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathWaterReheating();
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGtemperatureOfSuppliedWaterHSetting();
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathWaterTemperatureSetting();
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformHeatedBathWaterAmountSetting();
		/**
		 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredRemainingHotWaterAmount();
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformTankCapacity();
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGautomaticBathWaterHeatingModeHSetting();
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGbathWaterAdditionFunctionHSetting();
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting();
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathWaterAmountSetting2();
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathWaterAmountSetting3();
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSetting();
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
		public Informer reqInformAutomaticSettingOfHeatedWaterTemperature() {
			byte[] edt = getAutomaticSettingOfHeatedWaterTemperature();
			addProperty(EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatingStatus() {
			byte[] edt = getHeatingStatus();
			addProperty(EPC_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatedWaterTemperatureSetting() {
			byte[] edt = getHeatedWaterTemperatureSetting();
			addProperty(EPC_HEATED_WATER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater() {
			byte[] edt = getMeasuredTemperatureOfWaterInWaterHeater();
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerGenerationOutput() {
			byte[] edt = getRatedPowerGenerationOutput();
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformHeatingValueOfHotWaterStorageTank() {
			byte[] edt = getHeatingValueOfHotWaterStorageTank();
			addProperty(EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousPowerGenerationOutput() {
			byte[] edt = getMeasuredInstantaneousPowerGenerationOutput();
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativePowerGenerationOutput() {
			byte[] edt = getMeasuredCumulativePowerGenerationOutput();
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousGasConsumption() {
			byte[] edt = getMeasuredInstantaneousGasConsumption();
			addProperty(EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeGasConsumption() {
			byte[] edt = getMeasuredCumulativeGasConsumption();
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformPowerGenerationSetting() {
			byte[] edt = getPowerGenerationSetting();
			addProperty(EPC_POWER_GENERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterReheating() {
			byte[] edt = getBathWaterReheating();
			addProperty(EPC_BATH_WATER_REHEATING, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformHeatedBathWaterAmountSetting() {
			byte[] edt = getHeatedBathWaterAmountSetting();
			addProperty(EPC_HEATED_BATH_WATER_AMOUNT_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRemainingHotWaterAmount() {
			byte[] edt = getMeasuredRemainingHotWaterAmount();
			addProperty(EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformTankCapacity() {
			byte[] edt = getTankCapacity();
			addProperty(EPC_TANK_CAPACITY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGautomaticBathWaterHeatingModeHSetting() {
			byte[] edt = getGautomaticBathWaterHeatingModeHSetting();
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGbathWaterAdditionFunctionHSetting() {
			byte[] edt = getGbathWaterAdditionFunctionHSetting();
			addProperty(EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting() {
			byte[] edt = getGslightBathWaterTemperatureLoweringHFunctionSetting();
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterAmountSetting2() {
			byte[] edt = getBathWaterAmountSetting2();
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterAmountSetting3() {
			byte[] edt = getBathWaterAmountSetting3();
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING3, edt, (edt != null && (edt.length == 2)));
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
		public Informer reqInformAutomaticSettingOfHeatedWaterTemperature() {
			addProperty(EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		@Override
		public Informer reqInformHeatedWaterTemperatureSetting() {
			addProperty(EPC_HEATED_WATER_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER);
			return this;
		}
		@Override
		public Informer reqInformRatedPowerGenerationOutput() {
			addProperty(EPC_RATED_POWER_GENERATION_OUTPUT);
			return this;
		}
		@Override
		public Informer reqInformHeatingValueOfHotWaterStorageTank() {
			addProperty(EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK);
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousPowerGenerationOutput() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativePowerGenerationOutput() {
			addProperty(EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT);
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousGasConsumption() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeGasConsumption() {
			addProperty(EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION);
			return this;
		}
		@Override
		public Informer reqInformPowerGenerationSetting() {
			addProperty(EPC_POWER_GENERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathWaterReheating() {
			addProperty(EPC_BATH_WATER_REHEATING);
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
		public Informer reqInformHeatedBathWaterAmountSetting() {
			addProperty(EPC_HEATED_BATH_WATER_AMOUNT_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredRemainingHotWaterAmount() {
			addProperty(EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT);
			return this;
		}
		@Override
		public Informer reqInformTankCapacity() {
			addProperty(EPC_TANK_CAPACITY);
			return this;
		}
		@Override
		public Informer reqInformGautomaticBathWaterHeatingModeHSetting() {
			addProperty(EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGbathWaterAdditionFunctionHSetting() {
			addProperty(EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting() {
			addProperty(EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathWaterAmountSetting2() {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformBathWaterAmountSetting3() {
			addProperty(EPC_BATH_WATER_AMOUNT_SETTING3);
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
	}
}
