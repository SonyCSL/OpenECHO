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
	 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42
	 */
	protected boolean setAutomaticSettingOfHeatedWaterTemperature(byte[] edt) {return false;}
	/**
	 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42
	 */
	protected byte[] getAutomaticSettingOfHeatedWaterTemperature() {return null;}
	/**
	 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42
	 */
	protected byte[] getHeatingStatus() {return null;}
	/**
	 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )
	 */
	protected boolean setHeatedWaterTemperatureSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )
	 */
	protected byte[] getHeatedWaterTemperatureSetting() {return null;}
	/**
	 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j
	 */
	protected byte[] getMeasuredTemperatureOfWaterInWaterHeater() {return null;}
	/**
	 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j
	 */
	protected byte[] getRatedPowerGenerationOutput() {return null;}
	/**
	 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j
	 */
	protected byte[] getHeatingValueOfHotWaterStorageTank() {return null;}
	/**
	 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j
	 */
	protected abstract byte[] getMeasuredInstantaneousPowerGenerationOutput();
	/**
	 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j
	 */
	protected abstract byte[] getMeasuredCumulativePowerGenerationOutput();
	/**
	 * Resets the cumulative power generation output by writing 0x00.<br>Reset  0x00
	 */
	protected boolean setCumulativePowerGenerationOutputResetSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j
	 */
	protected byte[] getMeasuredInstantaneousGasConsumption() {return null;}
	/**
	 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j
	 */
	protected byte[] getMeasuredCumulativeGasConsumption() {return null;}
	/**
	 * Resets the cumulative gas consumption by writing 0x00.<br>Reset  0x00
	 */
	protected boolean setCumulativeGasConsumptionResetSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42
	 */
	protected boolean setPowerGenerationSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42
	 */
	protected byte[] getPowerGenerationSetting() {return null;}
	/**
	 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42
	 */
	protected boolean setBathWaterReheating(byte[] edt) {return false;}
	/**
	 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42
	 */
	protected byte[] getBathWaterReheating() {return null;}
	/**
	 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br>
	 */
	protected boolean setGtemperatureOfSuppliedWaterHSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br>
	 */
	protected byte[] getGtemperatureOfSuppliedWaterHSetting() {return null;}
	/**
	 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j
	 */
	protected boolean setBathWaterTemperatureSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j
	 */
	protected byte[] getBathWaterTemperatureSetting() {return null;}
	/**
	 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )
	 */
	protected boolean setHeatedBathWaterAmountSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )
	 */
	protected byte[] getHeatedBathWaterAmountSetting() {return null;}
	/**
	 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j
	 */
	protected byte[] getMeasuredRemainingHotWaterAmount() {return null;}
	/**
	 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j
	 */
	protected byte[] getTankCapacity() {return null;}
	/**
	 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42
	 */
	protected boolean setGautomaticBathWaterHeatingModeHSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42
	 */
	protected byte[] getGautomaticBathWaterHeatingModeHSetting() {return null;}
	/**
	 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42
	 */
	protected boolean setGbathWaterAdditionFunctionHSetting(byte[] edt) {return false;}
	/**
	 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42
	 */
	protected byte[] getGbathWaterAdditionFunctionHSetting() {return null;}
	/**
	 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42
	 */
	protected boolean setGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {return false;}
	/**
	 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42
	 */
	protected byte[] getGslightBathWaterTemperatureLoweringHFunctionSetting() {return null;}
	/**
	 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38
	 */
	protected boolean setBathWaterAmountSetting2(byte[] edt) {return false;}
	/**
	 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38
	 */
	protected byte[] getBathWaterAmountSetting2() {return null;}
	/**
	 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j
	 */
	protected boolean setBathWaterAmountSetting3(byte[] edt) {return false;}
	/**
	 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j
	 */
	protected byte[] getBathWaterAmountSetting3() {return null;}
	/**
	 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j
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
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42
		 */
		protected void onSetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, boolean success) {}
		/**
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42
		 */
		protected void onGetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )
		 */
		protected void onSetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )
		 */
		protected void onGetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j
		 */
		protected void onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j
		 */
		protected void onGetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j
		 */
		protected void onGetHeatingValueOfHotWaterStorageTank(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j
		 */
		protected void onGetMeasuredInstantaneousPowerGenerationOutput(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j
		 */
		protected void onGetMeasuredCumulativePowerGenerationOutput(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Resets the cumulative power generation output by writing 0x00.<br>Reset  0x00
		 */
		protected void onSetCumulativePowerGenerationOutputResetSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j
		 */
		protected void onGetMeasuredInstantaneousGasConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j
		 */
		protected void onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Resets the cumulative gas consumption by writing 0x00.<br>Reset  0x00
		 */
		protected void onSetCumulativeGasConsumptionResetSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42
		 */
		protected void onSetPowerGenerationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42
		 */
		protected void onGetPowerGenerationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42
		 */
		protected void onSetBathWaterReheating(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42
		 */
		protected void onGetBathWaterReheating(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br>
		 */
		protected void onSetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br>
		 */
		protected void onGetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j
		 */
		protected void onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j
		 */
		protected void onGetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )
		 */
		protected void onSetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )
		 */
		protected void onGetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		protected void onGetMeasuredRemainingHotWaterAmount(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		protected void onGetTankCapacity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42
		 */
		protected void onSetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42
		 */
		protected void onGetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42
		 */
		protected void onSetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42
		 */
		protected void onGetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42
		 */
		protected void onSetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42
		 */
		protected void onGetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38
		 */
		protected void onSetBathWaterAmountSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38
		 */
		protected void onGetBathWaterAmountSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		protected void onSetBathWaterAmountSetting3(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		protected void onGetBathWaterAmountSetting3(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42
		 */
		public Setter reqSetAutomaticSettingOfHeatedWaterTemperature(byte[] edt);
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )
		 */
		public Setter reqSetHeatedWaterTemperatureSetting(byte[] edt);
		/**
		 * Resets the cumulative power generation output by writing 0x00.<br>Reset  0x00
		 */
		public Setter reqSetCumulativePowerGenerationOutputResetSetting(byte[] edt);
		/**
		 * Resets the cumulative gas consumption by writing 0x00.<br>Reset  0x00
		 */
		public Setter reqSetCumulativeGasConsumptionResetSetting(byte[] edt);
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42
		 */
		public Setter reqSetPowerGenerationSetting(byte[] edt);
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42
		 */
		public Setter reqSetBathWaterReheating(byte[] edt);
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br>
		 */
		public Setter reqSetGtemperatureOfSuppliedWaterHSetting(byte[] edt);
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j
		 */
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt);
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )
		 */
		public Setter reqSetHeatedBathWaterAmountSetting(byte[] edt);
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42
		 */
		public Setter reqSetGautomaticBathWaterHeatingModeHSetting(byte[] edt);
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42
		 */
		public Setter reqSetGbathWaterAdditionFunctionHSetting(byte[] edt);
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42
		 */
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt);
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38
		 */
		public Setter reqSetBathWaterAmountSetting2(byte[] edt);
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		public Setter reqSetBathWaterAmountSetting3(byte[] edt);
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j
		 */
		public Setter reqSetOnTimerSetting(byte[] edt);

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
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42
		 */
		public Getter reqGetAutomaticSettingOfHeatedWaterTemperature();
		/**
		 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42
		 */
		public Getter reqGetHeatingStatus();
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )
		 */
		public Getter reqGetHeatedWaterTemperatureSetting();
		/**
		 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j
		 */
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater();
		/**
		 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j
		 */
		public Getter reqGetRatedPowerGenerationOutput();
		/**
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j
		 */
		public Getter reqGetHeatingValueOfHotWaterStorageTank();
		/**
		 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j
		 */
		public Getter reqGetMeasuredInstantaneousPowerGenerationOutput();
		/**
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j
		 */
		public Getter reqGetMeasuredCumulativePowerGenerationOutput();
		/**
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j
		 */
		public Getter reqGetMeasuredInstantaneousGasConsumption();
		/**
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j
		 */
		public Getter reqGetMeasuredCumulativeGasConsumption();
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42
		 */
		public Getter reqGetPowerGenerationSetting();
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42
		 */
		public Getter reqGetBathWaterReheating();
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br>
		 */
		public Getter reqGetGtemperatureOfSuppliedWaterHSetting();
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j
		 */
		public Getter reqGetBathWaterTemperatureSetting();
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )
		 */
		public Getter reqGetHeatedBathWaterAmountSetting();
		/**
		 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		public Getter reqGetMeasuredRemainingHotWaterAmount();
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		public Getter reqGetTankCapacity();
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42
		 */
		public Getter reqGetGautomaticBathWaterHeatingModeHSetting();
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42
		 */
		public Getter reqGetGbathWaterAdditionFunctionHSetting();
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42
		 */
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting();
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38
		 */
		public Getter reqGetBathWaterAmountSetting2();
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		public Getter reqGetBathWaterAmountSetting3();
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j
		 */
		public Getter reqGetOnTimerSetting();

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
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42
		 */
		public Informer reqInformAutomaticSettingOfHeatedWaterTemperature();
		/**
		 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42
		 */
		public Informer reqInformHeatingStatus();
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )
		 */
		public Informer reqInformHeatedWaterTemperatureSetting();
		/**
		 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j
		 */
		public Informer reqInformMeasuredTemperatureOfWaterInWaterHeater();
		/**
		 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j
		 */
		public Informer reqInformRatedPowerGenerationOutput();
		/**
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j
		 */
		public Informer reqInformHeatingValueOfHotWaterStorageTank();
		/**
		 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j
		 */
		public Informer reqInformMeasuredInstantaneousPowerGenerationOutput();
		/**
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j
		 */
		public Informer reqInformMeasuredCumulativePowerGenerationOutput();
		/**
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j
		 */
		public Informer reqInformMeasuredInstantaneousGasConsumption();
		/**
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j
		 */
		public Informer reqInformMeasuredCumulativeGasConsumption();
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42
		 */
		public Informer reqInformPowerGenerationSetting();
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42
		 */
		public Informer reqInformBathWaterReheating();
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br>
		 */
		public Informer reqInformGtemperatureOfSuppliedWaterHSetting();
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j
		 */
		public Informer reqInformBathWaterTemperatureSetting();
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )
		 */
		public Informer reqInformHeatedBathWaterAmountSetting();
		/**
		 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		public Informer reqInformMeasuredRemainingHotWaterAmount();
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		public Informer reqInformTankCapacity();
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42
		 */
		public Informer reqInformGautomaticBathWaterHeatingModeHSetting();
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42
		 */
		public Informer reqInformGbathWaterAdditionFunctionHSetting();
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42
		 */
		public Informer reqInformGslightBathWaterTemperatureLoweringHFunctionSetting();
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38
		 */
		public Informer reqInformBathWaterAmountSetting2();
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j
		 */
		public Informer reqInformBathWaterAmountSetting3();
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j
		 */
		public Informer reqInformOnTimerSetting();

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
