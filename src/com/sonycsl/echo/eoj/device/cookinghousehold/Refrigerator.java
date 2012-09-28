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
	@SuppressWarnings("unused")
	private static final String TAG = Refrigerator.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xB7;

	protected static final byte EPC_DOOR_OPEN_CLOSE_STATUS = (byte)0xB0;
	protected static final byte EPC_DOOR_OPEN_WARNING = (byte)0xB1;
	protected static final byte EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS = (byte)0xB2;
	protected static final byte EPC_FREEZER_COMPARTMENT_DOOR_STATUS = (byte)0xB3;
	protected static final byte EPC_ICE_COMPARTMENT_DOOR_STATUS = (byte)0xB4;
	protected static final byte EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS = (byte)0xB5;
	protected static final byte EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR = (byte)0xB6;
	protected static final byte EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL = (byte)0xE0;
	protected static final byte EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING = (byte)0xE2;
	protected static final byte EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING = (byte)0xE3;
	protected static final byte EPC_ICE_TEMPERATURE_SETTING = (byte)0xE4;
	protected static final byte EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING = (byte)0xE5;
	protected static final byte EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING = (byte)0xE6;
	protected static final byte EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xE9;
	protected static final byte EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xEA;
	protected static final byte EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xEB;
	protected static final byte EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xEC;
	protected static final byte EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING = (byte)0xED;
	protected static final byte EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE = (byte)0xD1;
	protected static final byte EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE = (byte)0xD2;
	protected static final byte EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE = (byte)0xD3;
	protected static final byte EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE = (byte)0xD4;
	protected static final byte EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE = (byte)0xD5;
	protected static final byte EPC_COMPRESSOR_ROTATION_SPEED = (byte)0xD8;
	protected static final byte EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION = (byte)0xDA;
	protected static final byte EPC_RATED_POWER_CONSUMPTION = (byte)0xDC;
	protected static final byte EPC_QUICK_FREEZE_FUNCTION_SETTING = (byte)0xA0;
	protected static final byte EPC_QUICK_REFRIGERATION_FUNCTION_SETTING = (byte)0xA1;
	protected static final byte EPC_ICEMAKER_SETTING = (byte)0xA4;
	protected static final byte EPC_ICEMAKER_OPERATION_STATUS = (byte)0xA5;
	protected static final byte EPC_ICEMAKER_TANK_STATUS = (byte)0xA6;
	protected static final byte EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING = (byte)0xA8;
	protected static final byte EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING = (byte)0xA9;
	protected static final byte EPC_DEODORIZATION_FUNCTION_SETTING = (byte)0xAD;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Door open/close status<br>Door open = 0x41, Door close = 0x42
	 */
	protected abstract byte[] getDoorOpenCloseStatus();
	/**
	 * Door open warning status<br>Door open warning found = 0x41 Door open warning not found = 0x42
	 */
	protected byte[] getDoorOpenWarning() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>Open = 0x41, closed = 0x42
	 */
	protected byte[] getRefrigeratorCompartmentDoorStatus() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>Open = 0x41, closed = 0x42
	 */
	protected byte[] getFreezerCompartmentDoorStatus() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>Open = 0x41, closed = 0x42
	 */
	protected byte[] getIceCompartmentDoorStatus() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>Open = 0x41, closed = 0x42
	 */
	protected byte[] getVegetableCompartmentDoorStatus() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>Open = 0x41, closed = 0x42
	 */
	protected byte[] getMultiRefrigeraTingModeCompartmentDoor() {return null;}
	/**
	 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment
	 */
	protected byte[] getMaximumAllowableTemperatureSettingLevel() {return null;}
	/**
	 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected boolean setRefrigeratorCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getRefrigeratorCompartmentTemperatureSetting() {return null;}
	/**
	 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected boolean setFreezerCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getFreezerCompartmentTemperatureSetting() {return null;}
	/**
	 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected boolean setIceTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getIceTemperatureSetting() {return null;}
	/**
	 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected boolean setVegetableCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getVegetableCompartmentTemperatureSetting() {return null;}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected boolean setMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getMultiRefrigeraTingModeCompartmentTemperatureSetting() {return null;}
	/**
	 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected boolean setRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected byte[] getRefrigeratorCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected boolean setFreezerCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected byte[] getFreezerCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected boolean setIceCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected byte[] getIceCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected boolean setVegetableCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected byte[] getVegetableCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected boolean setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
	 */
	protected byte[] getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to acquire the measured refrigerator compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getMeasuredRefrigeratorCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the measured freezer compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getMeasuredFreezerCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the measured meat and fish compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getMeasuredSubzeroFreshCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the measured vegetable compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getMeasuredVegetableCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
	 */
	protected byte[] getMeasuredMultiRefrigeratinGModeCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)
	 */
	protected byte[] getCompressorRotationSpeed() {return null;}
	/**
	 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)
	 */
	protected byte[] getMeasuredElectricCurrentConsumption() {return null;}
	/**
	 * Used to acquire the rated power consumption.<br>0x0000 to 0xFFFD (0 to 65533W)
	 */
	protected byte[] getRatedPowerConsumption() {return null;}
	/**
	 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43
	 */
	protected boolean setQuickFreezeFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43
	 */
	protected byte[] getQuickFreezeFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43
	 */
	protected boolean setQuickRefrigerationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43
	 */
	protected byte[] getQuickRefrigerationFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43
	 */
	protected boolean setIcemakerSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43
	 */
	protected byte[] getIcemakerSetting() {return null;}
	/**
	 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42
	 */
	protected byte[] getIcemakerOperationStatus() {return null;}
	/**
	 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42
	 */
	protected byte[] getIcemakerTankStatus() {return null;}
	/**
	 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
	 */
	protected boolean setRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
	 */
	protected byte[] getRefrigeratorCompartmentHumidificationFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
	 */
	protected boolean setVegetableCompartmentHumidificationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
	 */
	protected byte[] getVegetableCompartmentHumidificationFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
	 */
	protected boolean setDeodorizationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
	 */
	protected byte[] getDeodorizationFunctionSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setRefrigeratorCompartmentTemperatureSetting(edt));
			break;
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setFreezerCompartmentTemperatureSetting(edt));
			break;
		case EPC_ICE_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setIceTemperatureSetting(edt));
			break;
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setVegetableCompartmentTemperatureSetting(edt));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setMultiRefrigeraTingModeCompartmentTemperatureSetting(edt));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, setRefrigeratorCompartmentTemperatureLevelSetting(edt));
			break;
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, setFreezerCompartmentTemperatureLevelSetting(edt));
			break;
		case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, setIceCompartmentTemperatureLevelSetting(edt));
			break;
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, setVegetableCompartmentTemperatureLevelSetting(edt));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			res.addProperty(epc, edt, setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(edt));
			break;
		case EPC_QUICK_FREEZE_FUNCTION_SETTING:
			res.addProperty(epc, edt, setQuickFreezeFunctionSetting(edt));
			break;
		case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, setQuickRefrigerationFunctionSetting(edt));
			break;
		case EPC_ICEMAKER_SETTING:
			res.addProperty(epc, edt, setIcemakerSetting(edt));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, setRefrigeratorCompartmentHumidificationFunctionSetting(edt));
			break;
		case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, setVegetableCompartmentHumidificationFunctionSetting(edt));
			break;
		case EPC_DEODORIZATION_FUNCTION_SETTING:
			res.addProperty(epc, edt, setDeodorizationFunctionSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_DOOR_OPEN_CLOSE_STATUS:
			edt = getDoorOpenCloseStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DOOR_OPEN_WARNING:
			edt = getDoorOpenWarning();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS:
			edt = getRefrigeratorCompartmentDoorStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FREEZER_COMPARTMENT_DOOR_STATUS:
			edt = getFreezerCompartmentDoorStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICE_COMPARTMENT_DOOR_STATUS:
			edt = getIceCompartmentDoorStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS:
			edt = getVegetableCompartmentDoorStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR:
			edt = getMultiRefrigeraTingModeCompartmentDoor();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL:
			edt = getMaximumAllowableTemperatureSettingLevel();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING:
			edt = getRefrigeratorCompartmentTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING:
			edt = getFreezerCompartmentTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICE_TEMPERATURE_SETTING:
			edt = getIceTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING:
			edt = getVegetableCompartmentTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING:
			edt = getMultiRefrigeraTingModeCompartmentTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = getRefrigeratorCompartmentTemperatureLevelSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = getFreezerCompartmentTemperatureLevelSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = getIceCompartmentTemperatureLevelSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = getVegetableCompartmentTemperatureLevelSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
			edt = getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE:
			edt = getMeasuredRefrigeratorCompartmentTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE:
			edt = getMeasuredFreezerCompartmentTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE:
			edt = getMeasuredSubzeroFreshCompartmentTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE:
			edt = getMeasuredVegetableCompartmentTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE:
			edt = getMeasuredMultiRefrigeratinGModeCompartmentTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_COMPRESSOR_ROTATION_SPEED:
			edt = getCompressorRotationSpeed();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION:
			edt = getMeasuredElectricCurrentConsumption();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_POWER_CONSUMPTION:
			edt = getRatedPowerConsumption();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_QUICK_FREEZE_FUNCTION_SETTING:
			edt = getQuickFreezeFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING:
			edt = getQuickRefrigerationFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICEMAKER_SETTING:
			edt = getIcemakerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICEMAKER_OPERATION_STATUS:
			edt = getIcemakerOperationStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ICEMAKER_TANK_STATUS:
			edt = getIcemakerTankStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
			edt = getRefrigeratorCompartmentHumidificationFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
			edt = getVegetableCompartmentHumidificationFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DEODORIZATION_FUNCTION_SETTING:
			edt = getDeodorizationFunctionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING:
				onSetRefrigeratorCompartmentTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING:
				onSetFreezerCompartmentTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ICE_TEMPERATURE_SETTING:
				onSetIceTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING:
				onSetVegetableCompartmentTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING:
				onSetMultiRefrigeraTingModeCompartmentTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onSetRefrigeratorCompartmentTemperatureLevelSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onSetFreezerCompartmentTemperatureLevelSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onSetIceCompartmentTemperatureLevelSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onSetVegetableCompartmentTemperatureLevelSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_QUICK_FREEZE_FUNCTION_SETTING:
				onSetQuickFreezeFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING:
				onSetQuickRefrigerationFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ICEMAKER_SETTING:
				onSetIcemakerSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
				onSetRefrigeratorCompartmentHumidificationFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
				onSetVegetableCompartmentHumidificationFunctionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_DEODORIZATION_FUNCTION_SETTING:
				onSetDeodorizationFunctionSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_DOOR_OPEN_CLOSE_STATUS:
				onGetDoorOpenCloseStatus(eoj, tid, pdc, edt);
				break;
			case EPC_DOOR_OPEN_WARNING:
				onGetDoorOpenWarning(eoj, tid, pdc, edt);
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS:
				onGetRefrigeratorCompartmentDoorStatus(eoj, tid, pdc, edt);
				break;
			case EPC_FREEZER_COMPARTMENT_DOOR_STATUS:
				onGetFreezerCompartmentDoorStatus(eoj, tid, pdc, edt);
				break;
			case EPC_ICE_COMPARTMENT_DOOR_STATUS:
				onGetIceCompartmentDoorStatus(eoj, tid, pdc, edt);
				break;
			case EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS:
				onGetVegetableCompartmentDoorStatus(eoj, tid, pdc, edt);
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR:
				onGetMultiRefrigeraTingModeCompartmentDoor(eoj, tid, pdc, edt);
				break;
			case EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL:
				onGetMaximumAllowableTemperatureSettingLevel(eoj, tid, pdc, edt);
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING:
				onGetRefrigeratorCompartmentTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING:
				onGetFreezerCompartmentTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ICE_TEMPERATURE_SETTING:
				onGetIceTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING:
				onGetVegetableCompartmentTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING:
				onGetMultiRefrigeraTingModeCompartmentTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onGetRefrigeratorCompartmentTemperatureLevelSetting(eoj, tid, pdc, edt);
				break;
			case EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onGetFreezerCompartmentTemperatureLevelSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onGetIceCompartmentTemperatureLevelSetting(eoj, tid, pdc, edt);
				break;
			case EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onGetVegetableCompartmentTemperatureLevelSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING:
				onGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE:
				onGetMeasuredRefrigeratorCompartmentTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE:
				onGetMeasuredFreezerCompartmentTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE:
				onGetMeasuredSubzeroFreshCompartmentTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE:
				onGetMeasuredVegetableCompartmentTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE:
				onGetMeasuredMultiRefrigeratinGModeCompartmentTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_COMPRESSOR_ROTATION_SPEED:
				onGetCompressorRotationSpeed(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION:
				onGetMeasuredElectricCurrentConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_POWER_CONSUMPTION:
				onGetRatedPowerConsumption(eoj, tid, pdc, edt);
				break;
			case EPC_QUICK_FREEZE_FUNCTION_SETTING:
				onGetQuickFreezeFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_QUICK_REFRIGERATION_FUNCTION_SETTING:
				onGetQuickRefrigerationFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ICEMAKER_SETTING:
				onGetIcemakerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ICEMAKER_OPERATION_STATUS:
				onGetIcemakerOperationStatus(eoj, tid, pdc, edt);
				break;
			case EPC_ICEMAKER_TANK_STATUS:
				onGetIcemakerTankStatus(eoj, tid, pdc, edt);
				break;
			case EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
				onGetRefrigeratorCompartmentHumidificationFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING:
				onGetVegetableCompartmentHumidificationFunctionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_DEODORIZATION_FUNCTION_SETTING:
				onGetDeodorizationFunctionSetting(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Door open/close status<br>Door open = 0x41, Door close = 0x42
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Door open warning status<br>Door open warning found = 0x41 Door open warning not found = 0x42
		 */
		protected void onGetDoorOpenWarning(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>Open = 0x41, closed = 0x42
		 */
		protected void onGetRefrigeratorCompartmentDoorStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>Open = 0x41, closed = 0x42
		 */
		protected void onGetFreezerCompartmentDoorStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>Open = 0x41, closed = 0x42
		 */
		protected void onGetIceCompartmentDoorStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>Open = 0x41, closed = 0x42
		 */
		protected void onGetVegetableCompartmentDoorStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>Open = 0x41, closed = 0x42
		 */
		protected void onGetMultiRefrigeraTingModeCompartmentDoor(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment
		 */
		protected void onGetMaximumAllowableTemperatureSettingLevel(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onSetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onSetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onSetIceTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetIceTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onSetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onSetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onSetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onGetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onSetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onGetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onSetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onGetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onSetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onGetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		protected void onGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured refrigerator compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetMeasuredRefrigeratorCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured freezer compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetMeasuredFreezerCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured meat and fish compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetMeasuredSubzeroFreshCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured vegetable compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetMeasuredVegetableCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		protected void onGetMeasuredMultiRefrigeratinGModeCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)
		 */
		protected void onGetCompressorRotationSpeed(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)
		 */
		protected void onGetMeasuredElectricCurrentConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the rated power consumption.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		protected void onGetRatedPowerConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43
		 */
		protected void onSetQuickFreezeFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43
		 */
		protected void onGetQuickFreezeFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43
		 */
		protected void onSetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43
		 */
		protected void onGetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43
		 */
		protected void onSetIcemakerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43
		 */
		protected void onGetIcemakerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42
		 */
		protected void onGetIcemakerOperationStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42
		 */
		protected void onGetIcemakerTankStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		protected void onSetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		protected void onGetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		protected void onSetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		protected void onGetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		protected void onSetDeodorizationFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		protected void onGetDeodorizationFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Setter reqSetRefrigeratorCompartmentTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Setter reqSetFreezerCompartmentTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Setter reqSetIceTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Setter reqSetVegetableCompartmentTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Setter reqSetRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Setter reqSetFreezerCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Setter reqSetIceCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Setter reqSetVegetableCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43
		 */
		public Setter reqSetQuickFreezeFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43
		 */
		public Setter reqSetQuickRefrigerationFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43
		 */
		public Setter reqSetIcemakerSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		public Setter reqSetRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		public Setter reqSetVegetableCompartmentHumidificationFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		public Setter reqSetDeodorizationFunctionSetting(byte[] edt);

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
		public Setter reqSetRefrigeratorCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING, edt, setRefrigeratorCompartmentTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetFreezerCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING, edt, setFreezerCompartmentTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetIceTemperatureSetting(byte[] edt) {
			addProperty(EPC_ICE_TEMPERATURE_SETTING, edt, setIceTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetVegetableCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING, edt, setVegetableCompartmentTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING, edt, setMultiRefrigeraTingModeCompartmentTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, setRefrigeratorCompartmentTemperatureLevelSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetFreezerCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, setFreezerCompartmentTemperatureLevelSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetIceCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, setIceCompartmentTemperatureLevelSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetVegetableCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, setVegetableCompartmentTemperatureLevelSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetQuickFreezeFunctionSetting(byte[] edt) {
			addProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING, edt, setQuickFreezeFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetQuickRefrigerationFunctionSetting(byte[] edt) {
			addProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING, edt, setQuickRefrigerationFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetIcemakerSetting(byte[] edt) {
			addProperty(EPC_ICEMAKER_SETTING, edt, setIcemakerSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt) {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, setRefrigeratorCompartmentHumidificationFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetVegetableCompartmentHumidificationFunctionSetting(byte[] edt) {
			addProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, setVegetableCompartmentHumidificationFunctionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetDeodorizationFunctionSetting(byte[] edt) {
			addProperty(EPC_DEODORIZATION_FUNCTION_SETTING, edt, setDeodorizationFunctionSetting(edt));
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
		public Setter reqSetRefrigeratorCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetFreezerCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetIceTemperatureSetting(byte[] edt) {
			addProperty(EPC_ICE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVegetableCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt) {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetFreezerCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetIceCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVegetableCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt) {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetQuickFreezeFunctionSetting(byte[] edt) {
			addProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetQuickRefrigerationFunctionSetting(byte[] edt) {
			addProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetIcemakerSetting(byte[] edt) {
			addProperty(EPC_ICEMAKER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt) {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVegetableCompartmentHumidificationFunctionSetting(byte[] edt) {
			addProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetDeodorizationFunctionSetting(byte[] edt) {
			addProperty(EPC_DEODORIZATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Door open/close status<br>Door open = 0x41, Door close = 0x42
		 */
		public Getter reqGetDoorOpenCloseStatus();
		/**
		 * Door open warning status<br>Door open warning found = 0x41 Door open warning not found = 0x42
		 */
		public Getter reqGetDoorOpenWarning();
		/**
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Getter reqGetRefrigeratorCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Getter reqGetFreezerCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Getter reqGetIceCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Getter reqGetVegetableCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Getter reqGetMultiRefrigeraTingModeCompartmentDoor();
		/**
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment
		 */
		public Getter reqGetMaximumAllowableTemperatureSettingLevel();
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetRefrigeratorCompartmentTemperatureSetting();
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetFreezerCompartmentTemperatureSetting();
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetIceTemperatureSetting();
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetVegetableCompartmentTemperatureSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureSetting();
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Getter reqGetRefrigeratorCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Getter reqGetFreezerCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Getter reqGetIceCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Getter reqGetVegetableCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
		/**
		 * Used to acquire the measured refrigerator compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetMeasuredRefrigeratorCompartmentTemperature();
		/**
		 * Used to acquire the measured freezer compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetMeasuredFreezerCompartmentTemperature();
		/**
		 * Used to acquire the measured meat and fish compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetMeasuredSubzeroFreshCompartmentTemperature();
		/**
		 * Used to acquire the measured vegetable compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetMeasuredVegetableCompartmentTemperature();
		/**
		 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Getter reqGetMeasuredMultiRefrigeratinGModeCompartmentTemperature();
		/**
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)
		 */
		public Getter reqGetCompressorRotationSpeed();
		/**
		 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)
		 */
		public Getter reqGetMeasuredElectricCurrentConsumption();
		/**
		 * Used to acquire the rated power consumption.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Getter reqGetRatedPowerConsumption();
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43
		 */
		public Getter reqGetQuickFreezeFunctionSetting();
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43
		 */
		public Getter reqGetQuickRefrigerationFunctionSetting();
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43
		 */
		public Getter reqGetIcemakerSetting();
		/**
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42
		 */
		public Getter reqGetIcemakerOperationStatus();
		/**
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42
		 */
		public Getter reqGetIcemakerTankStatus();
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		public Getter reqGetRefrigeratorCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		public Getter reqGetVegetableCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		public Getter reqGetDeodorizationFunctionSetting();

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
		public Getter reqGetDoorOpenCloseStatus() {
			byte[] edt = getDoorOpenCloseStatus();
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDoorOpenWarning() {
			byte[] edt = getDoorOpenWarning();
			addProperty(EPC_DOOR_OPEN_WARNING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRefrigeratorCompartmentDoorStatus() {
			byte[] edt = getRefrigeratorCompartmentDoorStatus();
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetFreezerCompartmentDoorStatus() {
			byte[] edt = getFreezerCompartmentDoorStatus();
			addProperty(EPC_FREEZER_COMPARTMENT_DOOR_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetIceCompartmentDoorStatus() {
			byte[] edt = getIceCompartmentDoorStatus();
			addProperty(EPC_ICE_COMPARTMENT_DOOR_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVegetableCompartmentDoorStatus() {
			byte[] edt = getVegetableCompartmentDoorStatus();
			addProperty(EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMultiRefrigeraTingModeCompartmentDoor() {
			byte[] edt = getMultiRefrigeraTingModeCompartmentDoor();
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMaximumAllowableTemperatureSettingLevel() {
			byte[] edt = getMaximumAllowableTemperatureSettingLevel();
			addProperty(EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetRefrigeratorCompartmentTemperatureSetting() {
			byte[] edt = getRefrigeratorCompartmentTemperatureSetting();
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetFreezerCompartmentTemperatureSetting() {
			byte[] edt = getFreezerCompartmentTemperatureSetting();
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetIceTemperatureSetting() {
			byte[] edt = getIceTemperatureSetting();
			addProperty(EPC_ICE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVegetableCompartmentTemperatureSetting() {
			byte[] edt = getVegetableCompartmentTemperatureSetting();
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureSetting() {
			byte[] edt = getMultiRefrigeraTingModeCompartmentTemperatureSetting();
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRefrigeratorCompartmentTemperatureLevelSetting() {
			byte[] edt = getRefrigeratorCompartmentTemperatureLevelSetting();
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetFreezerCompartmentTemperatureLevelSetting() {
			byte[] edt = getFreezerCompartmentTemperatureLevelSetting();
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetIceCompartmentTemperatureLevelSetting() {
			byte[] edt = getIceCompartmentTemperatureLevelSetting();
			addProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVegetableCompartmentTemperatureLevelSetting() {
			byte[] edt = getVegetableCompartmentTemperatureLevelSetting();
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {
			byte[] edt = getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredRefrigeratorCompartmentTemperature() {
			byte[] edt = getMeasuredRefrigeratorCompartmentTemperature();
			addProperty(EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredFreezerCompartmentTemperature() {
			byte[] edt = getMeasuredFreezerCompartmentTemperature();
			addProperty(EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredSubzeroFreshCompartmentTemperature() {
			byte[] edt = getMeasuredSubzeroFreshCompartmentTemperature();
			addProperty(EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredVegetableCompartmentTemperature() {
			byte[] edt = getMeasuredVegetableCompartmentTemperature();
			addProperty(EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredMultiRefrigeratinGModeCompartmentTemperature() {
			byte[] edt = getMeasuredMultiRefrigeratinGModeCompartmentTemperature();
			addProperty(EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCompressorRotationSpeed() {
			byte[] edt = getCompressorRotationSpeed();
			addProperty(EPC_COMPRESSOR_ROTATION_SPEED, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredElectricCurrentConsumption() {
			byte[] edt = getMeasuredElectricCurrentConsumption();
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumption() {
			byte[] edt = getRatedPowerConsumption();
			addProperty(EPC_RATED_POWER_CONSUMPTION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetQuickFreezeFunctionSetting() {
			byte[] edt = getQuickFreezeFunctionSetting();
			addProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetQuickRefrigerationFunctionSetting() {
			byte[] edt = getQuickRefrigerationFunctionSetting();
			addProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetIcemakerSetting() {
			byte[] edt = getIcemakerSetting();
			addProperty(EPC_ICEMAKER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetIcemakerOperationStatus() {
			byte[] edt = getIcemakerOperationStatus();
			addProperty(EPC_ICEMAKER_OPERATION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetIcemakerTankStatus() {
			byte[] edt = getIcemakerTankStatus();
			addProperty(EPC_ICEMAKER_TANK_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRefrigeratorCompartmentHumidificationFunctionSetting() {
			byte[] edt = getRefrigeratorCompartmentHumidificationFunctionSetting();
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVegetableCompartmentHumidificationFunctionSetting() {
			byte[] edt = getVegetableCompartmentHumidificationFunctionSetting();
			addProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDeodorizationFunctionSetting() {
			byte[] edt = getDeodorizationFunctionSetting();
			addProperty(EPC_DEODORIZATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetDoorOpenCloseStatus() {
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Getter reqGetDoorOpenWarning() {
			addProperty(EPC_DOOR_OPEN_WARNING);
			return this;
		}
		@Override
		public Getter reqGetRefrigeratorCompartmentDoorStatus() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		@Override
		public Getter reqGetFreezerCompartmentDoorStatus() {
			addProperty(EPC_FREEZER_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		@Override
		public Getter reqGetIceCompartmentDoorStatus() {
			addProperty(EPC_ICE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		@Override
		public Getter reqGetVegetableCompartmentDoorStatus() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS);
			return this;
		}
		@Override
		public Getter reqGetMultiRefrigeraTingModeCompartmentDoor() {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR);
			return this;
		}
		@Override
		public Getter reqGetMaximumAllowableTemperatureSettingLevel() {
			addProperty(EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL);
			return this;
		}
		@Override
		public Getter reqGetRefrigeratorCompartmentTemperatureSetting() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetFreezerCompartmentTemperatureSetting() {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetIceTemperatureSetting() {
			addProperty(EPC_ICE_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetVegetableCompartmentTemperatureSetting() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureSetting() {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRefrigeratorCompartmentTemperatureLevelSetting() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetFreezerCompartmentTemperatureLevelSetting() {
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetIceCompartmentTemperatureLevelSetting() {
			addProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetVegetableCompartmentTemperatureLevelSetting() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredRefrigeratorCompartmentTemperature() {
			addProperty(EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredFreezerCompartmentTemperature() {
			addProperty(EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredSubzeroFreshCompartmentTemperature() {
			addProperty(EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredVegetableCompartmentTemperature() {
			addProperty(EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredMultiRefrigeratinGModeCompartmentTemperature() {
			addProperty(EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetCompressorRotationSpeed() {
			addProperty(EPC_COMPRESSOR_ROTATION_SPEED);
			return this;
		}
		@Override
		public Getter reqGetMeasuredElectricCurrentConsumption() {
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION);
			return this;
		}
		@Override
		public Getter reqGetRatedPowerConsumption() {
			addProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		@Override
		public Getter reqGetQuickFreezeFunctionSetting() {
			addProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetQuickRefrigerationFunctionSetting() {
			addProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetIcemakerSetting() {
			addProperty(EPC_ICEMAKER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetIcemakerOperationStatus() {
			addProperty(EPC_ICEMAKER_OPERATION_STATUS);
			return this;
		}
		@Override
		public Getter reqGetIcemakerTankStatus() {
			addProperty(EPC_ICEMAKER_TANK_STATUS);
			return this;
		}
		@Override
		public Getter reqGetRefrigeratorCompartmentHumidificationFunctionSetting() {
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetVegetableCompartmentHumidificationFunctionSetting() {
			addProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetDeodorizationFunctionSetting() {
			addProperty(EPC_DEODORIZATION_FUNCTION_SETTING);
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
		 * Door open/close status<br>Door open = 0x41, Door close = 0x42
		 */
		public Informer reqInformDoorOpenCloseStatus();
		/**
		 * Door open warning status<br>Door open warning found = 0x41 Door open warning not found = 0x42
		 */
		public Informer reqInformDoorOpenWarning();
		/**
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Informer reqInformRefrigeratorCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Informer reqInformFreezerCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Informer reqInformIceCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Informer reqInformVegetableCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>Open = 0x41, closed = 0x42
		 */
		public Informer reqInformMultiRefrigeraTingModeCompartmentDoor();
		/**
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment
		 */
		public Informer reqInformMaximumAllowableTemperatureSettingLevel();
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformRefrigeratorCompartmentTemperatureSetting();
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformFreezerCompartmentTemperatureSetting();
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformIceTemperatureSetting();
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformVegetableCompartmentTemperatureSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureSetting();
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Informer reqInformRefrigeratorCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Informer reqInformFreezerCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Informer reqInformIceCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Informer reqInformVegetableCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)
		 */
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
		/**
		 * Used to acquire the measured refrigerator compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformMeasuredRefrigeratorCompartmentTemperature();
		/**
		 * Used to acquire the measured freezer compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformMeasuredFreezerCompartmentTemperature();
		/**
		 * Used to acquire the measured meat and fish compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformMeasuredSubzeroFreshCompartmentTemperature();
		/**
		 * Used to acquire the measured vegetable compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformMeasuredVegetableCompartmentTemperature();
		/**
		 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)
		 */
		public Informer reqInformMeasuredMultiRefrigeratinGModeCompartmentTemperature();
		/**
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)
		 */
		public Informer reqInformCompressorRotationSpeed();
		/**
		 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)
		 */
		public Informer reqInformMeasuredElectricCurrentConsumption();
		/**
		 * Used to acquire the rated power consumption.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Informer reqInformRatedPowerConsumption();
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43
		 */
		public Informer reqInformQuickFreezeFunctionSetting();
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43
		 */
		public Informer reqInformQuickRefrigerationFunctionSetting();
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43
		 */
		public Informer reqInformIcemakerSetting();
		/**
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42
		 */
		public Informer reqInformIcemakerOperationStatus();
		/**
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42
		 */
		public Informer reqInformIcemakerTankStatus();
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		public Informer reqInformRefrigeratorCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		public Informer reqInformVegetableCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42
		 */
		public Informer reqInformDeodorizationFunctionSetting();

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
		public Informer reqInformDoorOpenCloseStatus() {
			byte[] edt = getDoorOpenCloseStatus();
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDoorOpenWarning() {
			byte[] edt = getDoorOpenWarning();
			addProperty(EPC_DOOR_OPEN_WARNING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentDoorStatus() {
			byte[] edt = getRefrigeratorCompartmentDoorStatus();
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_DOOR_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFreezerCompartmentDoorStatus() {
			byte[] edt = getFreezerCompartmentDoorStatus();
			addProperty(EPC_FREEZER_COMPARTMENT_DOOR_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIceCompartmentDoorStatus() {
			byte[] edt = getIceCompartmentDoorStatus();
			addProperty(EPC_ICE_COMPARTMENT_DOOR_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentDoorStatus() {
			byte[] edt = getVegetableCompartmentDoorStatus();
			addProperty(EPC_VEGETABLE_COMPARTMENT_DOOR_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMultiRefrigeraTingModeCompartmentDoor() {
			byte[] edt = getMultiRefrigeraTingModeCompartmentDoor();
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_DOOR, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMaximumAllowableTemperatureSettingLevel() {
			byte[] edt = getMaximumAllowableTemperatureSettingLevel();
			addProperty(EPC_MAXIMUM_ALLOWABLE_TEMPERATURE_SETTING_LEVEL, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentTemperatureSetting() {
			byte[] edt = getRefrigeratorCompartmentTemperatureSetting();
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFreezerCompartmentTemperatureSetting() {
			byte[] edt = getFreezerCompartmentTemperatureSetting();
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIceTemperatureSetting() {
			byte[] edt = getIceTemperatureSetting();
			addProperty(EPC_ICE_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentTemperatureSetting() {
			byte[] edt = getVegetableCompartmentTemperatureSetting();
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureSetting() {
			byte[] edt = getMultiRefrigeraTingModeCompartmentTemperatureSetting();
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentTemperatureLevelSetting() {
			byte[] edt = getRefrigeratorCompartmentTemperatureLevelSetting();
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFreezerCompartmentTemperatureLevelSetting() {
			byte[] edt = getFreezerCompartmentTemperatureLevelSetting();
			addProperty(EPC_FREEZER_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIceCompartmentTemperatureLevelSetting() {
			byte[] edt = getIceCompartmentTemperatureLevelSetting();
			addProperty(EPC_ICE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentTemperatureLevelSetting() {
			byte[] edt = getVegetableCompartmentTemperatureLevelSetting();
			addProperty(EPC_VEGETABLE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {
			byte[] edt = getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
			addProperty(EPC_MULTI_REFRIGERA_TING_MODE_COMPARTMENT_TEMPERATURE_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRefrigeratorCompartmentTemperature() {
			byte[] edt = getMeasuredRefrigeratorCompartmentTemperature();
			addProperty(EPC_MEASURED_REFRIGERATOR_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredFreezerCompartmentTemperature() {
			byte[] edt = getMeasuredFreezerCompartmentTemperature();
			addProperty(EPC_MEASURED_FREEZER_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredSubzeroFreshCompartmentTemperature() {
			byte[] edt = getMeasuredSubzeroFreshCompartmentTemperature();
			addProperty(EPC_MEASURED_SUBZERO_FRESH_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredVegetableCompartmentTemperature() {
			byte[] edt = getMeasuredVegetableCompartmentTemperature();
			addProperty(EPC_MEASURED_VEGETABLE_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredMultiRefrigeratinGModeCompartmentTemperature() {
			byte[] edt = getMeasuredMultiRefrigeratinGModeCompartmentTemperature();
			addProperty(EPC_MEASURED_MULTI_REFRIGERATIN_G_MODE_COMPARTMENT_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCompressorRotationSpeed() {
			byte[] edt = getCompressorRotationSpeed();
			addProperty(EPC_COMPRESSOR_ROTATION_SPEED, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredElectricCurrentConsumption() {
			byte[] edt = getMeasuredElectricCurrentConsumption();
			addProperty(EPC_MEASURED_ELECTRIC_CURRENT_CONSUMPTION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedPowerConsumption() {
			byte[] edt = getRatedPowerConsumption();
			addProperty(EPC_RATED_POWER_CONSUMPTION, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformQuickFreezeFunctionSetting() {
			byte[] edt = getQuickFreezeFunctionSetting();
			addProperty(EPC_QUICK_FREEZE_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformQuickRefrigerationFunctionSetting() {
			byte[] edt = getQuickRefrigerationFunctionSetting();
			addProperty(EPC_QUICK_REFRIGERATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIcemakerSetting() {
			byte[] edt = getIcemakerSetting();
			addProperty(EPC_ICEMAKER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIcemakerOperationStatus() {
			byte[] edt = getIcemakerOperationStatus();
			addProperty(EPC_ICEMAKER_OPERATION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIcemakerTankStatus() {
			byte[] edt = getIcemakerTankStatus();
			addProperty(EPC_ICEMAKER_TANK_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRefrigeratorCompartmentHumidificationFunctionSetting() {
			byte[] edt = getRefrigeratorCompartmentHumidificationFunctionSetting();
			addProperty(EPC_REFRIGERATOR_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVegetableCompartmentHumidificationFunctionSetting() {
			byte[] edt = getVegetableCompartmentHumidificationFunctionSetting();
			addProperty(EPC_VEGETABLE_COMPARTMENT_HUMIDIFICATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDeodorizationFunctionSetting() {
			byte[] edt = getDeodorizationFunctionSetting();
			addProperty(EPC_DEODORIZATION_FUNCTION_SETTING, edt, (edt != null && (edt.length == 1)));
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
