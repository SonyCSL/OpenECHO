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

	public static final byte EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE = (byte)0xB1;
	public static final byte EPC_HEATING_STATUS = (byte)0xB2;
	public static final byte EPC_HEATED_WATER_TEMPERATURE_SETTING = (byte)0xB3;
	public static final byte EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER = (byte)0xC1;
	public static final byte EPC_RATED_POWER_GENERATION_OUTPUT = (byte)0xC2;
	public static final byte EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK = (byte)0xC3;
	public static final byte EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT = (byte)0xC4;
	public static final byte EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT = (byte)0xC5;
	public static final byte EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING = (byte)0xC6;
	public static final byte EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION = (byte)0xC7;
	public static final byte EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION = (byte)0xC8;
	public static final byte EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING = (byte)0xC9;
	public static final byte EPC_POWER_GENERATION_SETTING = (byte)0xCA;
	public static final byte EPC_BATH_WATER_REHEATING = (byte)0xE4;
	public static final byte EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING = (byte)0xD1;
	public static final byte EPC_BATH_WATER_TEMPERATURE_SETTING = (byte)0xD3;
	public static final byte EPC_HEATED_BATH_WATER_AMOUNT_SETTING = (byte)0xE0;
	public static final byte EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT = (byte)0xE1;
	public static final byte EPC_TANK_CAPACITY = (byte)0xE2;
	public static final byte EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING = (byte)0xE3;
	public static final byte EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING = (byte)0xE5;
	public static final byte EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING = (byte)0xE6;
	public static final byte EPC_BATH_WATER_AMOUNT_SETTING2 = (byte)0xE8;
	public static final byte EPC_BATH_WATER_AMOUNT_SETTING3 = (byte)0xEE;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;

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
	private final boolean _setAutomaticSettingOfHeatedWaterTemperature(byte epc, byte[] edt) {
		boolean success = setAutomaticSettingOfHeatedWaterTemperature(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAutomaticSettingOfHeatedWaterTemperature() {return null;}
	private final byte[] _getAutomaticSettingOfHeatedWaterTemperature(byte epc) {
		byte[] edt = getAutomaticSettingOfHeatedWaterTemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHeatingStatus() {return null;}
	private final byte[] _getHeatingStatus(byte epc) {
		byte[] edt = getHeatingStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatedWaterTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setHeatedWaterTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setHeatedWaterTemperatureSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatedWaterTemperatureSetting() {return null;}
	private final byte[] _getHeatedWaterTemperatureSetting(byte epc) {
		byte[] edt = getHeatedWaterTemperatureSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredTemperatureOfWaterInWaterHeater() {return null;}
	private final byte[] _getMeasuredTemperatureOfWaterInWaterHeater(byte epc) {
		byte[] edt = getMeasuredTemperatureOfWaterInWaterHeater();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedPowerGenerationOutput() {return null;}
	private final byte[] _getRatedPowerGenerationOutput(byte epc) {
		byte[] edt = getRatedPowerGenerationOutput();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHeatingValueOfHotWaterStorageTank() {return null;}
	private final byte[] _getHeatingValueOfHotWaterStorageTank(byte epc) {
		byte[] edt = getHeatingValueOfHotWaterStorageTank();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getMeasuredInstantaneousPowerGenerationOutput();
	private final byte[] _getMeasuredInstantaneousPowerGenerationOutput(byte epc) {
		byte[] edt = getMeasuredInstantaneousPowerGenerationOutput();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getMeasuredCumulativePowerGenerationOutput();
	private final byte[] _getMeasuredCumulativePowerGenerationOutput(byte epc) {
		byte[] edt = getMeasuredCumulativePowerGenerationOutput();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Resets the cumulative power generation output by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
	 */
	protected boolean setCumulativePowerGenerationOutputResetSetting(byte[] edt) {return false;}
	private final boolean _setCumulativePowerGenerationOutputResetSetting(byte epc, byte[] edt) {
		boolean success = setCumulativePowerGenerationOutputResetSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredInstantaneousGasConsumption() {return null;}
	private final byte[] _getMeasuredInstantaneousGasConsumption(byte epc) {
		byte[] edt = getMeasuredInstantaneousGasConsumption();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredCumulativeGasConsumption() {return null;}
	private final byte[] _getMeasuredCumulativeGasConsumption(byte epc) {
		byte[] edt = getMeasuredCumulativeGasConsumption();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Resets the cumulative gas consumption by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
	 */
	protected boolean setCumulativeGasConsumptionResetSetting(byte[] edt) {return false;}
	private final boolean _setCumulativeGasConsumptionResetSetting(byte epc, byte[] edt) {
		boolean success = setCumulativeGasConsumptionResetSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setPowerGenerationSetting(byte[] edt) {return false;}
	private final boolean _setPowerGenerationSetting(byte epc, byte[] edt) {
		boolean success = setPowerGenerationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getPowerGenerationSetting() {return null;}
	private final byte[] _getPowerGenerationSetting(byte epc) {
		byte[] edt = getPowerGenerationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterReheating(byte[] edt) {return false;}
	private final boolean _setBathWaterReheating(byte epc, byte[] edt) {
		boolean success = setBathWaterReheating(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterReheating() {return null;}
	private final byte[] _getBathWaterReheating(byte epc) {
		byte[] edt = getBathWaterReheating();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGtemperatureOfSuppliedWaterHSetting(byte[] edt) {return false;}
	private final boolean _setGtemperatureOfSuppliedWaterHSetting(byte epc, byte[] edt) {
		boolean success = setGtemperatureOfSuppliedWaterHSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGtemperatureOfSuppliedWaterHSetting() {return null;}
	private final byte[] _getGtemperatureOfSuppliedWaterHSetting(byte epc) {
		byte[] edt = getGtemperatureOfSuppliedWaterHSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setBathWaterTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setBathWaterTemperatureSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterTemperatureSetting() {return null;}
	private final byte[] _getBathWaterTemperatureSetting(byte epc) {
		byte[] edt = getBathWaterTemperatureSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatedBathWaterAmountSetting(byte[] edt) {return false;}
	private final boolean _setHeatedBathWaterAmountSetting(byte epc, byte[] edt) {
		boolean success = setHeatedBathWaterAmountSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatedBathWaterAmountSetting() {return null;}
	private final byte[] _getHeatedBathWaterAmountSetting(byte epc) {
		byte[] edt = getHeatedBathWaterAmountSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredRemainingHotWaterAmount() {return null;}
	private final byte[] _getMeasuredRemainingHotWaterAmount(byte epc) {
		byte[] edt = getMeasuredRemainingHotWaterAmount();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getTankCapacity() {return null;}
	private final byte[] _getTankCapacity(byte epc) {
		byte[] edt = getTankCapacity();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGautomaticBathWaterHeatingModeHSetting(byte[] edt) {return false;}
	private final boolean _setGautomaticBathWaterHeatingModeHSetting(byte epc, byte[] edt) {
		boolean success = setGautomaticBathWaterHeatingModeHSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGautomaticBathWaterHeatingModeHSetting() {return null;}
	private final byte[] _getGautomaticBathWaterHeatingModeHSetting(byte epc) {
		byte[] edt = getGautomaticBathWaterHeatingModeHSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGbathWaterAdditionFunctionHSetting(byte[] edt) {return false;}
	private final boolean _setGbathWaterAdditionFunctionHSetting(byte epc, byte[] edt) {
		boolean success = setGbathWaterAdditionFunctionHSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGbathWaterAdditionFunctionHSetting() {return null;}
	private final byte[] _getGbathWaterAdditionFunctionHSetting(byte epc) {
		byte[] edt = getGbathWaterAdditionFunctionHSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {return false;}
	private final boolean _setGslightBathWaterTemperatureLoweringHFunctionSetting(byte epc, byte[] edt) {
		boolean success = setGslightBathWaterTemperatureLoweringHFunctionSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGslightBathWaterTemperatureLoweringHFunctionSetting() {return null;}
	private final byte[] _getGslightBathWaterTemperatureLoweringHFunctionSetting(byte epc) {
		byte[] edt = getGslightBathWaterTemperatureLoweringHFunctionSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterAmountSetting2(byte[] edt) {return false;}
	private final boolean _setBathWaterAmountSetting2(byte epc, byte[] edt) {
		boolean success = setBathWaterAmountSetting2(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterAmountSetting2() {return null;}
	private final byte[] _getBathWaterAmountSetting2(byte epc) {
		byte[] edt = getBathWaterAmountSetting2();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathWaterAmountSetting3(byte[] edt) {return false;}
	private final boolean _setBathWaterAmountSetting3(byte epc, byte[] edt) {
		boolean success = setBathWaterAmountSetting3(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathWaterAmountSetting3() {return null;}
	private final byte[] _getBathWaterAmountSetting3(byte epc) {
		byte[] edt = getBathWaterAmountSetting3();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSetting() {return null;}
	private final byte[] _getOnTimerSetting(byte epc) {
		byte[] edt = getOnTimerSetting();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE:
			res.addProperty(epc, edt, _setAutomaticSettingOfHeatedWaterTemperature(epc, edt));
			break;
		case EPC_HEATED_WATER_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setHeatedWaterTemperatureSetting(epc, edt));
			break;
		case EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING:
			res.addProperty(epc, edt, _setCumulativePowerGenerationOutputResetSetting(epc, edt));
			break;
		case EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING:
			res.addProperty(epc, edt, _setCumulativeGasConsumptionResetSetting(epc, edt));
			break;
		case EPC_POWER_GENERATION_SETTING:
			res.addProperty(epc, edt, _setPowerGenerationSetting(epc, edt));
			break;
		case EPC_BATH_WATER_REHEATING:
			res.addProperty(epc, edt, _setBathWaterReheating(epc, edt));
			break;
		case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
			res.addProperty(epc, edt, _setGtemperatureOfSuppliedWaterHSetting(epc, edt));
			break;
		case EPC_BATH_WATER_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setBathWaterTemperatureSetting(epc, edt));
			break;
		case EPC_HEATED_BATH_WATER_AMOUNT_SETTING:
			res.addProperty(epc, edt, _setHeatedBathWaterAmountSetting(epc, edt));
			break;
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING:
			res.addProperty(epc, edt, _setGautomaticBathWaterHeatingModeHSetting(epc, edt));
			break;
		case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING:
			res.addProperty(epc, edt, _setGbathWaterAdditionFunctionHSetting(epc, edt));
			break;
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
			res.addProperty(epc, edt, _setGslightBathWaterTemperatureLoweringHFunctionSetting(epc, edt));
			break;
		case EPC_BATH_WATER_AMOUNT_SETTING2:
			res.addProperty(epc, edt, _setBathWaterAmountSetting2(epc, edt));
			break;
		case EPC_BATH_WATER_AMOUNT_SETTING3:
			res.addProperty(epc, edt, _setBathWaterAmountSetting3(epc, edt));
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
		case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE:
			edt = _getAutomaticSettingOfHeatedWaterTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_STATUS:
			edt = _getHeatingStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATED_WATER_TEMPERATURE_SETTING:
			edt = _getHeatedWaterTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER:
			edt = _getMeasuredTemperatureOfWaterInWaterHeater(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RATED_POWER_GENERATION_OUTPUT:
			edt = _getRatedPowerGenerationOutput(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK:
			edt = _getHeatingValueOfHotWaterStorageTank(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT:
			edt = _getMeasuredInstantaneousPowerGenerationOutput(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT:
			edt = _getMeasuredCumulativePowerGenerationOutput(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION:
			edt = _getMeasuredInstantaneousGasConsumption(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION:
			edt = _getMeasuredCumulativeGasConsumption(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_POWER_GENERATION_SETTING:
			edt = _getPowerGenerationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_REHEATING:
			edt = _getBathWaterReheating(epc);
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
		case EPC_HEATED_BATH_WATER_AMOUNT_SETTING:
			edt = _getHeatedBathWaterAmountSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT:
			edt = _getMeasuredRemainingHotWaterAmount(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TANK_CAPACITY:
			edt = _getTankCapacity(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING:
			edt = _getGautomaticBathWaterHeatingModeHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING:
			edt = _getGbathWaterAdditionFunctionHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
			edt = _getGslightBathWaterTemperatureLoweringHFunctionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_AMOUNT_SETTING2:
			edt = _getBathWaterAmountSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATH_WATER_AMOUNT_SETTING3:
			edt = _getBathWaterAmountSetting3(epc);
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
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE:
				_onSetAutomaticSettingOfHeatedWaterTemperature(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_HEATED_WATER_TEMPERATURE_SETTING:
				_onSetHeatedWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING:
				_onSetCumulativePowerGenerationOutputResetSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING:
				_onSetCumulativeGasConsumptionResetSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_POWER_GENERATION_SETTING:
				_onSetPowerGenerationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_WATER_REHEATING:
				_onSetBathWaterReheating(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
				_onSetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_WATER_TEMPERATURE_SETTING:
				_onSetBathWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_HEATED_BATH_WATER_AMOUNT_SETTING:
				_onSetHeatedBathWaterAmountSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING:
				_onSetGautomaticBathWaterHeatingModeHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING:
				_onSetGbathWaterAdditionFunctionHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
				_onSetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_WATER_AMOUNT_SETTING2:
				_onSetBathWaterAmountSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATH_WATER_AMOUNT_SETTING3:
				_onSetBathWaterAmountSetting3(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING:
				_onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE:
				_onGetAutomaticSettingOfHeatedWaterTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATING_STATUS:
				_onGetHeatingStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATED_WATER_TEMPERATURE_SETTING:
				_onGetHeatedWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER:
				_onGetMeasuredTemperatureOfWaterInWaterHeater(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_POWER_GENERATION_OUTPUT:
				_onGetRatedPowerGenerationOutput(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK:
				_onGetHeatingValueOfHotWaterStorageTank(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT:
				_onGetMeasuredInstantaneousPowerGenerationOutput(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT:
				_onGetMeasuredCumulativePowerGenerationOutput(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION:
				_onGetMeasuredInstantaneousGasConsumption(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION:
				_onGetMeasuredCumulativeGasConsumption(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_POWER_GENERATION_SETTING:
				_onGetPowerGenerationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_REHEATING:
				_onGetBathWaterReheating(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING:
				_onGetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_TEMPERATURE_SETTING:
				_onGetBathWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATED_BATH_WATER_AMOUNT_SETTING:
				_onGetHeatedBathWaterAmountSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT:
				_onGetMeasuredRemainingHotWaterAmount(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TANK_CAPACITY:
				_onGetTankCapacity(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING:
				_onGetGautomaticBathWaterHeatingModeHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING:
				_onGetGbathWaterAdditionFunctionHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING:
				_onGetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_AMOUNT_SETTING2:
				_onGetBathWaterAmountSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATH_WATER_AMOUNT_SETTING3:
				_onGetBathWaterAmountSetting3(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING:
				_onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutomaticSettingOfHeatedWaterTemperature(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * AUTO/Non-AUTO<br>AUTO  0x41 CNon-AUTO  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutomaticSettingOfHeatedWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutomaticSettingOfHeatedWaterTemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether the water is being heated.<br>Being heated  0x41 C Not being heated  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeatedWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the heated water temperature setting in   .<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatedWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatedWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the current temperature of the water in the water heater in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredTemperatureOfWaterInWaterHeater(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredTemperatureOfWaterInWaterHeater(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the rated power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedPowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedPowerGenerationOutput(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the heating value of the hot water storage tank in MJ.<br>0x0000-0xFFFD  i0-65533MJ j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHeatingValueOfHotWaterStorageTank(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingValueOfHotWaterStorageTank(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingValueOfHotWaterStorageTank(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the instantaneous power generation output in watts.<br>0x0000-0xFFFD  i0-65533W j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetMeasuredInstantaneousPowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousPowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousPowerGenerationOutput(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the cumulative power generation output in increments of 0.001kWh.<br>0x0-0x3B9AC9FF  i0-999,999.999kWh j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetMeasuredCumulativePowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativePowerGenerationOutput(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativePowerGenerationOutput(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Resets the cumulative power generation output by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		protected void onSetCumulativePowerGenerationOutputResetSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetCumulativePowerGenerationOutputResetSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetCumulativePowerGenerationOutputResetSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the instantaneous gas consumption in increments of 0.001m3.<br>0x0-0xFFFD  i0-65.533m3 j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredInstantaneousGasConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousGasConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousGasConsumption(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the cumulative gas consumption in increments of 0.001m3.<br>0x0-0x3B9AC9FF  i0-999,999.999m3 j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeGasConsumption(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeGasConsumption(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Resets the cumulative gas consumption by writing 0x00.<br>Reset  0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		protected void onSetCumulativeGasConsumptionResetSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetCumulativeGasConsumptionResetSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetCumulativeGasConsumptionResetSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetPowerGenerationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetPowerGenerationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetPowerGenerationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the ON/OFF status of power generation.<br>Power generation ON=0x41 C Power generation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetPowerGenerationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPowerGenerationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPowerGenerationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterReheating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterReheating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterReheating(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reheating ON/OFF<br>Reheating ON =0x41 C Reheating OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterReheating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterReheating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterReheating(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the temperature setting for the supplied water in   C. 0x00-0x64 i0-100   j<br><br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGtemperatureOfSuppliedWaterHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGtemperatureOfSuppliedWaterHSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the temperature setting for the bath water in    .<br>0x00-0x64 i0-100   j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeatedBathWaterAmountSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the setting for the amount of the heated bath water in terms of percentage.<br>0x00-0x64 (0-100  )<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatedBathWaterAmountSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatedBathWaterAmountSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured amount of the remaining hot water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredRemainingHotWaterAmount(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredRemainingHotWaterAmount(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredRemainingHotWaterAmount(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the tank capacity in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetTankCapacity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTankCapacity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTankCapacity(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGautomaticBathWaterHeatingModeHSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the ON/OFF status of the automatic bath water heating mode.<br>Automatic mode ON  0x41 C Automatic mode OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGautomaticBathWaterHeatingModeHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGautomaticBathWaterHeatingModeHSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGbathWaterAdditionFunctionHSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Addition function ON/OFF<br>Addition function ON  0x41 C Addition function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGbathWaterAdditionFunctionHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGbathWaterAdditionFunctionHSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 *  gSlight bath water temperature lowering h function ON/OFF<br> gSlight bath water temperature lowering h function ON   0x41 C hSlight bath water temperature lowering h function OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGslightBathWaterTemperatureLoweringHFunctionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGslightBathWaterTemperatureLoweringHFunctionSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterAmountSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterAmountSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterAmountSetting2(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the amount of the bath water using an 8-level scale.<br>0x31-38<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterAmountSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterAmountSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterAmountSetting2(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathWaterAmountSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathWaterAmountSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathWaterAmountSetting3(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the amount of the bath water in liters.<br>0x0000-0xFFFD i0-65533 liters j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathWaterAmountSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathWaterAmountSetting3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathWaterAmountSetting3(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41, Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Time    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59 j<br><br>Data type : unsigned char  ~2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}

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
			byte epc = EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE;
			addProperty(epc, edt, _setAutomaticSettingOfHeatedWaterTemperature(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetHeatedWaterTemperatureSetting(byte[] edt) {
			byte epc = EPC_HEATED_WATER_TEMPERATURE_SETTING;
			addProperty(epc, edt, _setHeatedWaterTemperatureSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetCumulativePowerGenerationOutputResetSetting(byte[] edt) {
			byte epc = EPC_CUMULATIVE_POWER_GENERATION_OUTPUT_RESET_SETTING;
			addProperty(epc, edt, _setCumulativePowerGenerationOutputResetSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetCumulativeGasConsumptionResetSetting(byte[] edt) {
			byte epc = EPC_CUMULATIVE_GAS_CONSUMPTION_RESET_SETTING;
			addProperty(epc, edt, _setCumulativeGasConsumptionResetSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetPowerGenerationSetting(byte[] edt) {
			byte epc = EPC_POWER_GENERATION_SETTING;
			addProperty(epc, edt, _setPowerGenerationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterReheating(byte[] edt) {
			byte epc = EPC_BATH_WATER_REHEATING;
			addProperty(epc, edt, _setBathWaterReheating(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetGtemperatureOfSuppliedWaterHSetting(byte[] edt) {
			byte epc = EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING;
			addProperty(epc, edt, _setGtemperatureOfSuppliedWaterHSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterTemperatureSetting(byte[] edt) {
			byte epc = EPC_BATH_WATER_TEMPERATURE_SETTING;
			addProperty(epc, edt, _setBathWaterTemperatureSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetHeatedBathWaterAmountSetting(byte[] edt) {
			byte epc = EPC_HEATED_BATH_WATER_AMOUNT_SETTING;
			addProperty(epc, edt, _setHeatedBathWaterAmountSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetGautomaticBathWaterHeatingModeHSetting(byte[] edt) {
			byte epc = EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING;
			addProperty(epc, edt, _setGautomaticBathWaterHeatingModeHSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetGbathWaterAdditionFunctionHSetting(byte[] edt) {
			byte epc = EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING;
			addProperty(epc, edt, _setGbathWaterAdditionFunctionHSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetGslightBathWaterTemperatureLoweringHFunctionSetting(byte[] edt) {
			byte epc = EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING;
			addProperty(epc, edt, _setGslightBathWaterTemperatureLoweringHFunctionSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterAmountSetting2(byte[] edt) {
			byte epc = EPC_BATH_WATER_AMOUNT_SETTING2;
			addProperty(epc, edt, _setBathWaterAmountSetting2(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetBathWaterAmountSetting3(byte[] edt) {
			byte epc = EPC_BATH_WATER_AMOUNT_SETTING3;
			addProperty(epc, edt, _setBathWaterAmountSetting3(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSetting(byte[] edt) {
			byte epc = EPC_ON_TIMER_SETTING;
			addProperty(epc, edt, _setOnTimerSetting(epc, edt));
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
			byte epc = EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE;
			byte[] edt = _getAutomaticSettingOfHeatedWaterTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatingStatus() {
			byte epc = EPC_HEATING_STATUS;
			byte[] edt = _getHeatingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatedWaterTemperatureSetting() {
			byte epc = EPC_HEATED_WATER_TEMPERATURE_SETTING;
			byte[] edt = _getHeatedWaterTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfWaterInWaterHeater() {
			byte epc = EPC_MEASURED_TEMPERATURE_OF_WATER_IN_WATER_HEATER;
			byte[] edt = _getMeasuredTemperatureOfWaterInWaterHeater(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerGenerationOutput() {
			byte epc = EPC_RATED_POWER_GENERATION_OUTPUT;
			byte[] edt = _getRatedPowerGenerationOutput(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetHeatingValueOfHotWaterStorageTank() {
			byte epc = EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK;
			byte[] edt = _getHeatingValueOfHotWaterStorageTank(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousPowerGenerationOutput() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT;
			byte[] edt = _getMeasuredInstantaneousPowerGenerationOutput(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativePowerGenerationOutput() {
			byte epc = EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT;
			byte[] edt = _getMeasuredCumulativePowerGenerationOutput(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousGasConsumption() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION;
			byte[] edt = _getMeasuredInstantaneousGasConsumption(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeGasConsumption() {
			byte epc = EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION;
			byte[] edt = _getMeasuredCumulativeGasConsumption(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetPowerGenerationSetting() {
			byte epc = EPC_POWER_GENERATION_SETTING;
			byte[] edt = _getPowerGenerationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterReheating() {
			byte epc = EPC_BATH_WATER_REHEATING;
			byte[] edt = _getBathWaterReheating(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGtemperatureOfSuppliedWaterHSetting() {
			byte epc = EPC_GTEMPERATURE_OF_SUPPLIED_WATER_H_SETTING;
			byte[] edt = _getGtemperatureOfSuppliedWaterHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterTemperatureSetting() {
			byte epc = EPC_BATH_WATER_TEMPERATURE_SETTING;
			byte[] edt = _getBathWaterTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatedBathWaterAmountSetting() {
			byte epc = EPC_HEATED_BATH_WATER_AMOUNT_SETTING;
			byte[] edt = _getHeatedBathWaterAmountSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredRemainingHotWaterAmount() {
			byte epc = EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT;
			byte[] edt = _getMeasuredRemainingHotWaterAmount(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetTankCapacity() {
			byte epc = EPC_TANK_CAPACITY;
			byte[] edt = _getTankCapacity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGautomaticBathWaterHeatingModeHSetting() {
			byte epc = EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING;
			byte[] edt = _getGautomaticBathWaterHeatingModeHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGbathWaterAdditionFunctionHSetting() {
			byte epc = EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING;
			byte[] edt = _getGbathWaterAdditionFunctionHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGslightBathWaterTemperatureLoweringHFunctionSetting() {
			byte epc = EPC_GSLIGHT_BATH_WATER_TEMPERATURE_LOWERING_H_FUNCTION_SETTING;
			byte[] edt = _getGslightBathWaterTemperatureLoweringHFunctionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterAmountSetting2() {
			byte epc = EPC_BATH_WATER_AMOUNT_SETTING2;
			byte[] edt = _getBathWaterAmountSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathWaterAmountSetting3() {
			byte epc = EPC_BATH_WATER_AMOUNT_SETTING3;
			byte[] edt = _getBathWaterAmountSetting3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOnTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSetting() {
			byte epc = EPC_ON_TIMER_SETTING;
			byte[] edt = _getOnTimerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
			byte epc = EPC_AUTOMATIC_SETTING_OF_HEATED_WATER_TEMPERATURE;
			byte[] edt = _getAutomaticSettingOfHeatedWaterTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatingStatus() {
			byte epc = EPC_HEATING_STATUS;
			byte[] edt = _getHeatingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatedWaterTemperatureSetting() {
			byte epc = EPC_HEATED_WATER_TEMPERATURE_SETTING;
			byte[] edt = _getHeatedWaterTemperatureSetting(epc);
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
		public Informer reqInformRatedPowerGenerationOutput() {
			byte epc = EPC_RATED_POWER_GENERATION_OUTPUT;
			byte[] edt = _getRatedPowerGenerationOutput(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformHeatingValueOfHotWaterStorageTank() {
			byte epc = EPC_HEATING_VALUE_OF_HOT_WATER_STORAGE_TANK;
			byte[] edt = _getHeatingValueOfHotWaterStorageTank(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousPowerGenerationOutput() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_POWER_GENERATION_OUTPUT;
			byte[] edt = _getMeasuredInstantaneousPowerGenerationOutput(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativePowerGenerationOutput() {
			byte epc = EPC_MEASURED_CUMULATIVE_POWER_GENERATION_OUTPUT;
			byte[] edt = _getMeasuredCumulativePowerGenerationOutput(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousGasConsumption() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_GAS_CONSUMPTION;
			byte[] edt = _getMeasuredInstantaneousGasConsumption(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeGasConsumption() {
			byte epc = EPC_MEASURED_CUMULATIVE_GAS_CONSUMPTION;
			byte[] edt = _getMeasuredCumulativeGasConsumption(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformPowerGenerationSetting() {
			byte epc = EPC_POWER_GENERATION_SETTING;
			byte[] edt = _getPowerGenerationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterReheating() {
			byte epc = EPC_BATH_WATER_REHEATING;
			byte[] edt = _getBathWaterReheating(epc);
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
		public Informer reqInformHeatedBathWaterAmountSetting() {
			byte epc = EPC_HEATED_BATH_WATER_AMOUNT_SETTING;
			byte[] edt = _getHeatedBathWaterAmountSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRemainingHotWaterAmount() {
			byte epc = EPC_MEASURED_REMAINING_HOT_WATER_AMOUNT;
			byte[] edt = _getMeasuredRemainingHotWaterAmount(epc);
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
		public Informer reqInformGautomaticBathWaterHeatingModeHSetting() {
			byte epc = EPC_GAUTOMATIC_BATH_WATER_HEATING_MODE_H_SETTING;
			byte[] edt = _getGautomaticBathWaterHeatingModeHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGbathWaterAdditionFunctionHSetting() {
			byte epc = EPC_GBATH_WATER_ADDITION_FUNCTION_H_SETTING;
			byte[] edt = _getGbathWaterAdditionFunctionHSetting(epc);
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
		public Informer reqInformBathWaterAmountSetting2() {
			byte epc = EPC_BATH_WATER_AMOUNT_SETTING2;
			byte[] edt = _getBathWaterAmountSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathWaterAmountSetting3() {
			byte epc = EPC_BATH_WATER_AMOUNT_SETTING3;
			byte[] edt = _getBathWaterAmountSetting3(epc);
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
