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
	 * Door open/close status<br>Door open = 0x41, Door close = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getDoorOpenCloseStatus();
	/**
	 * Door open warning status<br>Door open warning found = 0x41 Door open warning not found = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getDoorOpenWarning() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRefrigeratorCompartmentDoorStatus() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getFreezerCompartmentDoorStatus() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getIceCompartmentDoorStatus() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getVegetableCompartmentDoorStatus() {return null;}
	/**
	 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMultiRefrigeraTingModeCompartmentDoor() {return null;}
	/**
	 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment<br><br>Data type : unsigned char x 8<br>Data size : 8 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMaximumAllowableTemperatureSettingLevel() {return null;}
	/**
	 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRefrigeratorCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRefrigeratorCompartmentTemperatureSetting() {return null;}
	/**
	 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setFreezerCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getFreezerCompartmentTemperatureSetting() {return null;}
	/**
	 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setIceTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getIceTemperatureSetting() {return null;}
	/**
	 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setVegetableCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVegetableCompartmentTemperatureSetting() {return null;}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getMultiRefrigeraTingModeCompartmentTemperatureSetting() {return null;}
	/**
	 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRefrigeratorCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setFreezerCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getFreezerCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setIceCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getIceCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setVegetableCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVegetableCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getMultiRefrigeraTingModeCompartmentTemperatureLevelSetting() {return null;}
	/**
	 * Used to acquire the measured refrigerator compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredRefrigeratorCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the measured freezer compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredFreezerCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the measured meat and fish compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredSubzeroFreshCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the measured vegetable compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredVegetableCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredMultiRefrigeratinGModeCompartmentTemperature() {return null;}
	/**
	 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getCompressorRotationSpeed() {return null;}
	/**
	 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredElectricCurrentConsumption() {return null;}
	/**
	 * Used to acquire the rated power consumption.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedPowerConsumption() {return null;}
	/**
	 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setQuickFreezeFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getQuickFreezeFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setQuickRefrigerationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getQuickRefrigerationFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setIcemakerSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getIcemakerSetting() {return null;}
	/**
	 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getIcemakerOperationStatus() {return null;}
	/**
	 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getIcemakerTankStatus() {return null;}
	/**
	 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRefrigeratorCompartmentHumidificationFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setVegetableCompartmentHumidificationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVegetableCompartmentHumidificationFunctionSetting() {return null;}
	/**
	 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDeodorizationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
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
		 * Door open/close status<br>Door open = 0x41, Door close = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Door open warning status<br>Door open warning found = 0x41 Door open warning not found = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetDoorOpenWarning(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRefrigeratorCompartmentDoorStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetFreezerCompartmentDoorStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetIceCompartmentDoorStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetVegetableCompartmentDoorStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMultiRefrigeraTingModeCompartmentDoor(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment<br><br>Data type : unsigned char x 8<br>Data size : 8 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMaximumAllowableTemperatureSettingLevel(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRefrigeratorCompartmentTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetFreezerCompartmentTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetIceTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetIceTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetVegetableCompartmentTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetMultiRefrigeraTingModeCompartmentTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRefrigeratorCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetFreezerCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetIceCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetVegetableCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured refrigerator compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredRefrigeratorCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured freezer compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredFreezerCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured meat and fish compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredSubzeroFreshCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured vegetable compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredVegetableCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredMultiRefrigeratinGModeCompartmentTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetCompressorRotationSpeed(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredElectricCurrentConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the rated power consumption.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedPowerConsumption(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetQuickFreezeFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetQuickFreezeFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetQuickRefrigerationFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetIcemakerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetIcemakerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetIcemakerOperationStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetIcemakerTankStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRefrigeratorCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetVegetableCompartmentHumidificationFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDeodorizationFunctionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDeodorizationFunctionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRefrigeratorCompartmentTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetFreezerCompartmentTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetIceTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetVegetableCompartmentTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRefrigeratorCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetFreezerCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetIceCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetVegetableCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetQuickFreezeFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetQuickRefrigerationFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetIcemakerSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRefrigeratorCompartmentHumidificationFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetVegetableCompartmentHumidificationFunctionSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDeodorizationFunctionSetting(byte[] edt);
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
		 * Door open/close status<br>Door open = 0x41, Door close = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetDoorOpenCloseStatus();
		/**
		 * Door open warning status<br>Door open warning found = 0x41 Door open warning not found = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetDoorOpenWarning();
		/**
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRefrigeratorCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetFreezerCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetIceCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetVegetableCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMultiRefrigeraTingModeCompartmentDoor();
		/**
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment<br><br>Data type : unsigned char x 8<br>Data size : 8 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMaximumAllowableTemperatureSettingLevel();
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRefrigeratorCompartmentTemperatureSetting();
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetFreezerCompartmentTemperatureSetting();
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetIceTemperatureSetting();
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetVegetableCompartmentTemperatureSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureSetting();
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRefrigeratorCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetFreezerCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetIceCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetVegetableCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
		/**
		 * Used to acquire the measured refrigerator compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredRefrigeratorCompartmentTemperature();
		/**
		 * Used to acquire the measured freezer compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredFreezerCompartmentTemperature();
		/**
		 * Used to acquire the measured meat and fish compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredSubzeroFreshCompartmentTemperature();
		/**
		 * Used to acquire the measured vegetable compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredVegetableCompartmentTemperature();
		/**
		 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredMultiRefrigeratinGModeCompartmentTemperature();
		/**
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetCompressorRotationSpeed();
		/**
		 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredElectricCurrentConsumption();
		/**
		 * Used to acquire the rated power consumption.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRatedPowerConsumption();
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetQuickFreezeFunctionSetting();
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetQuickRefrigerationFunctionSetting();
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetIcemakerSetting();
		/**
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetIcemakerOperationStatus();
		/**
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetIcemakerTankStatus();
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRefrigeratorCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetVegetableCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDeodorizationFunctionSetting();
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
		 * Door open/close status<br>Door open = 0x41, Door close = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformDoorOpenCloseStatus();
		/**
		 * Door open warning status<br>Door open warning found = 0x41 Door open warning not found = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformDoorOpenWarning();
		/**
		 * Used to acquire the status (i.e. open or closed) of the refrigerator compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRefrigeratorCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the freezer compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformFreezerCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the ice compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformIceCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the vegetable compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformVegetableCompartmentDoorStatus();
		/**
		 * Used to acquire the status (i.e. open or closed) of the multi-refrigerating mode compartment door.<br>Open = 0x41, closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMultiRefrigeraTingModeCompartmentDoor();
		/**
		 * Used to acquire the maximum allowable temperature setting levels for the individual compartments of the refrigerator.<br>First byte: Refrigerator compartment Second byte: Freezer compartment Third byte:subzero-fresh compartment Fourth byte: Vegetable compartment Fifth byte: Multi-refrigerating mode compartment Sixth to eighth bytes: Reserved for future use. 0x01 to 0xFF (Level 1 to 255) 0x00 = no compartment<br><br>Data type : unsigned char x 8<br>Data size : 8 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMaximumAllowableTemperatureSettingLevel();
		/**
		 * Used to specify the refrigerator compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRefrigeratorCompartmentTemperatureSetting();
		/**
		 * Used to specify the freezer compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformFreezerCompartmentTemperatureSetting();
		/**
		 * Used to specify the ice compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformIceTemperatureSetting();
		/**
		 * Used to specify the vegetable compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformVegetableCompartmentTemperatureSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature in ��C, and to acquire the current setting.<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureSetting();
		/**
		 * Used to specify the refrigerator compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRefrigeratorCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the freezer compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformFreezerCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify ice compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformIceCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the vegetable compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformVegetableCompartmentTemperatureLevelSetting();
		/**
		 * Used to specify the multi-refrigerating mode compartment temperature by selecting a level from among the predefined levels, and to acquire the current setting.<br>0x01 to maximum allowable temperature setting level (highest to lowest temperature)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformMultiRefrigeraTingModeCompartmentTemperatureLevelSetting();
		/**
		 * Used to acquire the measured refrigerator compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredRefrigeratorCompartmentTemperature();
		/**
		 * Used to acquire the measured freezer compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredFreezerCompartmentTemperature();
		/**
		 * Used to acquire the measured meat and fish compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredSubzeroFreshCompartmentTemperature();
		/**
		 * Used to acquire the measured vegetable compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredVegetableCompartmentTemperature();
		/**
		 * Used to acquire the measured multi-refrigerating mode compartment temperature (��C).<br>0x81 to 0x7E (-127 to 126��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredMultiRefrigeratinGModeCompartmentTemperature();
		/**
		 * Used to acquire the rotation speed of the compressor. The rotation speed is expressed in terms of a level.<br>First byte: Maximum rotation speed L (0x01 to 0xFF (1 to 255)) Second byte: Rotation speed of the actual compressor: 0x00 to L (zero speed to highest speed)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformCompressorRotationSpeed();
		/**
		 * Used to acquire the measured electric current consumption.<br>0x0000 to 0xFFFD (0 to 6553.3A)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredElectricCurrentConsumption();
		/**
		 * Used to acquire the rated power consumption.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : unsigned char<br>Data size : 2 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRatedPowerConsumption();
		/**
		 * Used to specify whether or not to use the �gQuick freeze�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick freeze�h mode: 0x42 �gStandby for fast freezing�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformQuickFreezeFunctionSetting();
		/**
		 * Used to specify whether or not to use the �gquick refrigeration�h function of the refrigerator, and to acquire the current setting.<br>�gNormal operation�h mode: 0x41 �gQuick refrigeration�h mode: 0x42 �gStandby for quick refrigeration�h mode: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformQuickRefrigerationFunctionSetting();
		/**
		 * Used to specify whether or not to enable the automatic icemaker of the refrigerator, and to acquire the current setting.<br>�gEnable icemaker�h option: 0x41 �gDisable icemaker�h option: 0x42 �gTemporarily disable icemaker�h option: 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformIcemakerSetting();
		/**
		 * Used to acquire the status of the automatic icemaker of the refrigerator.<br>�gIce-making in progress�h state: 0x41 �gIce-making stopped�h state: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformIcemakerOperationStatus();
		/**
		 * Used to acquire the status of the tank of the automatic icemaker of the refrigerator in terms of whether it contains water or not.<br>Icemaker tank contains water: 0x41 There is no water left in the icemaker tank or the icemaker tank has not been positioned correctly in the refrigerator: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformIcemakerTankStatus();
		/**
		 * Used to specify whether or not to use the refrigerator compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRefrigeratorCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the vegetable compartment humidification function, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformVegetableCompartmentHumidificationFunctionSetting();
		/**
		 * Used to specify whether or not to use the deodorization function of the refrigerator, and to acquire the current setting.<br>ON = 0x41 OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDeodorizationFunctionSetting();
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
