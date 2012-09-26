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

public abstract class CombinationMicrowaveOven extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = CombinationMicrowaveOven.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xB8;

	protected static final byte EPC_DOOR_OPEN_CLOSE_STATUS = (byte)0xB0;
	protected static final byte EPC_HEATING_STATUS = (byte)0xB1;
	protected static final byte EPC_HEATING_SETTING = (byte)0xB2;
	protected static final byte EPC_HEATING_MODE_SETTING = (byte)0xE0;
	protected static final byte EPC_AUTOMATIC_HEATING_SETTING = (byte)0xE1;
	protected static final byte EPC_AUTOMATIC_HEATING_LEVEL_SETTING = (byte)0xE2;
	protected static final byte EPC_AUTOMATIC_HEATING_MENU_SETTING = (byte)0xD0;
	protected static final byte EPC_OVEN_MODE_SETTING = (byte)0xD1;
	protected static final byte EPC_OVEN_PREHEATING_SETTING = (byte)0xD5;
	protected static final byte EPC_FERMENTING_MODE_SETTING = (byte)0xD6;
	protected static final byte EPC_CHAMBER_TEMPERATURE_SETTING = (byte)0xE3;
	protected static final byte EPC_FOOD_TEMPERATURE_SETTING = (byte)0xE4;
	protected static final byte EPC_HEATING_TIME_SETTING = (byte)0xE5;
	protected static final byte EPC_REMAINING_HEATING_TIME_SETTING = (byte)0xE6;
	protected static final byte EPC_MICROWAVE_HEATING_POWER_SETTING = (byte)0xE7;
	protected static final byte EPC_PROMPT_MESSAGE_SETTING = (byte)0xE8;
	protected static final byte EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING = (byte)0xE9;
	protected static final byte EPC_DISPLAY_CHARACTER_STRING_SETTING = (byte)0xEA;
	protected static final byte EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION = (byte)0xEB;
	protected static final byte EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER = (byte)0xEC;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br>Door open = 0x41, door closed = 0x42
	 */
	protected byte[] getDoorOpenCloseStatus() {return null;}
	/**
	 * Used to acquire the status of the combination microwave oven.<br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47
	 */
	protected byte[] getHeatingStatus() {return null;}
	/**
	 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43
	 */
	protected boolean setHeatingSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43
	 */
	protected byte[] getHeatingSetting() {return null;}
	/**
	 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF
	 */
	protected boolean setHeatingModeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF
	 */
	protected byte[] getHeatingModeSetting() {return null;}
	/**
	 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF
	 */
	protected boolean setAutomaticHeatingSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF
	 */
	protected byte[] getAutomaticHeatingSetting() {return null;}
	/**
	 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF
	 */
	protected boolean setAutomaticHeatingLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF
	 */
	protected byte[] getAutomaticHeatingLevelSetting() {return null;}
	/**
	 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF
	 */
	protected boolean setAutomaticHeatingMenuSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF
	 */
	protected byte[] getAutomaticHeatingMenuSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF
	 */
	protected boolean setOvenModeSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF
	 */
	protected byte[] getOvenModeSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF
	 */
	protected boolean setOvenPreheatingSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF
	 */
	protected byte[] getOvenPreheatingSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF
	 */
	protected boolean setFermentingModeSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF
	 */
	protected byte[] getFermentingModeSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified
	 */
	protected boolean setChamberTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified
	 */
	protected byte[] getChamberTemperatureSetting() {return null;}
	/**
	 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified
	 */
	protected boolean setFoodTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified
	 */
	protected byte[] getFoodTemperatureSetting() {return null;}
	/**
	 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
	 */
	protected boolean setHeatingTimeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
	 */
	protected byte[] getHeatingTimeSetting() {return null;}
	/**
	 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
	 */
	protected boolean setRemainingHeatingTimeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
	 */
	protected byte[] getRemainingHeatingTimeSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)
	 */
	protected boolean setMicrowaveHeatingPowerSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)
	 */
	protected byte[] getMicrowaveHeatingPowerSetting() {return null;}
	/**
	 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))
	 */
	protected boolean setPromptMessageSetting(byte[] edt) {return false;}
	/**
	 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))
	 */
	protected byte[] getPromptMessageSetting() {return null;}
	/**
	 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).
	 */
	protected boolean setGaccessoriesToCombinationMicrowaveOvenHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).
	 */
	protected byte[] getGaccessoriesToCombinationMicrowaveOvenHSetting() {return null;}
	/**
	 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven.<br>Shift-JIS code characters x 20
	 */
	protected boolean setDisplayCharacterStringSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)
	 */
	protected boolean setTwoStageMicrowaveHeatingSettingDuration(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)
	 */
	protected byte[] getTwoStageMicrowaveHeatingSettingDuration() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)
	 */
	protected boolean setTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)
	 */
	protected byte[] getTwoStageMicrowaveHeatingSettingHeatingPower() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_HEATING_SETTING:
			res.addProperty(epc, edt, setHeatingSetting(edt));
			break;
		case EPC_HEATING_MODE_SETTING:
			res.addProperty(epc, edt, setHeatingModeSetting(edt));
			break;
		case EPC_AUTOMATIC_HEATING_SETTING:
			res.addProperty(epc, edt, setAutomaticHeatingSetting(edt));
			break;
		case EPC_AUTOMATIC_HEATING_LEVEL_SETTING:
			res.addProperty(epc, edt, setAutomaticHeatingLevelSetting(edt));
			break;
		case EPC_AUTOMATIC_HEATING_MENU_SETTING:
			res.addProperty(epc, edt, setAutomaticHeatingMenuSetting(edt));
			break;
		case EPC_OVEN_MODE_SETTING:
			res.addProperty(epc, edt, setOvenModeSetting(edt));
			break;
		case EPC_OVEN_PREHEATING_SETTING:
			res.addProperty(epc, edt, setOvenPreheatingSetting(edt));
			break;
		case EPC_FERMENTING_MODE_SETTING:
			res.addProperty(epc, edt, setFermentingModeSetting(edt));
			break;
		case EPC_CHAMBER_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setChamberTemperatureSetting(edt));
			break;
		case EPC_FOOD_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setFoodTemperatureSetting(edt));
			break;
		case EPC_HEATING_TIME_SETTING:
			res.addProperty(epc, edt, setHeatingTimeSetting(edt));
			break;
		case EPC_REMAINING_HEATING_TIME_SETTING:
			res.addProperty(epc, edt, setRemainingHeatingTimeSetting(edt));
			break;
		case EPC_MICROWAVE_HEATING_POWER_SETTING:
			res.addProperty(epc, edt, setMicrowaveHeatingPowerSetting(edt));
			break;
		case EPC_PROMPT_MESSAGE_SETTING:
			res.addProperty(epc, edt, setPromptMessageSetting(edt));
			break;
		case EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING:
			res.addProperty(epc, edt, setGaccessoriesToCombinationMicrowaveOvenHSetting(edt));
			break;
		case EPC_DISPLAY_CHARACTER_STRING_SETTING:
			res.addProperty(epc, edt, setDisplayCharacterStringSetting(edt));
			break;
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION:
			res.addProperty(epc, edt, setTwoStageMicrowaveHeatingSettingDuration(edt));
			break;
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER:
			res.addProperty(epc, edt, setTwoStageMicrowaveHeatingSettingHeatingPower(edt));
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
		case EPC_HEATING_STATUS:
			edt = getHeatingStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_SETTING:
			edt = getHeatingSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_MODE_SETTING:
			edt = getHeatingModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_HEATING_SETTING:
			edt = getAutomaticHeatingSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_HEATING_LEVEL_SETTING:
			edt = getAutomaticHeatingLevelSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_HEATING_MENU_SETTING:
			edt = getAutomaticHeatingMenuSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OVEN_MODE_SETTING:
			edt = getOvenModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OVEN_PREHEATING_SETTING:
			edt = getOvenPreheatingSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FERMENTING_MODE_SETTING:
			edt = getFermentingModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CHAMBER_TEMPERATURE_SETTING:
			edt = getChamberTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_FOOD_TEMPERATURE_SETTING:
			edt = getFoodTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_HEATING_TIME_SETTING:
			edt = getHeatingTimeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_REMAINING_HEATING_TIME_SETTING:
			edt = getRemainingHeatingTimeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_MICROWAVE_HEATING_POWER_SETTING:
			edt = getMicrowaveHeatingPowerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_PROMPT_MESSAGE_SETTING:
			edt = getPromptMessageSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING:
			edt = getGaccessoriesToCombinationMicrowaveOvenHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION:
			edt = getTwoStageMicrowaveHeatingSettingDuration();
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER:
			edt = getTwoStageMicrowaveHeatingSettingHeatingPower();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
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
			case EPC_HEATING_SETTING:
				onSetHeatingSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_HEATING_MODE_SETTING:
				onSetHeatingModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTOMATIC_HEATING_SETTING:
				onSetAutomaticHeatingSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTOMATIC_HEATING_LEVEL_SETTING:
				onSetAutomaticHeatingLevelSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTOMATIC_HEATING_MENU_SETTING:
				onSetAutomaticHeatingMenuSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OVEN_MODE_SETTING:
				onSetOvenModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OVEN_PREHEATING_SETTING:
				onSetOvenPreheatingSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_FERMENTING_MODE_SETTING:
				onSetFermentingModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_CHAMBER_TEMPERATURE_SETTING:
				onSetChamberTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_FOOD_TEMPERATURE_SETTING:
				onSetFoodTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_HEATING_TIME_SETTING:
				onSetHeatingTimeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_REMAINING_HEATING_TIME_SETTING:
				onSetRemainingHeatingTimeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_MICROWAVE_HEATING_POWER_SETTING:
				onSetMicrowaveHeatingPowerSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_PROMPT_MESSAGE_SETTING:
				onSetPromptMessageSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING:
				onSetGaccessoriesToCombinationMicrowaveOvenHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_DISPLAY_CHARACTER_STRING_SETTING:
				onSetDisplayCharacterStringSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION:
				onSetTwoStageMicrowaveHeatingSettingDuration(eoj, tid, (pdc != 0));
				break;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER:
				onSetTwoStageMicrowaveHeatingSettingHeatingPower(eoj, tid, (pdc != 0));
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
			case EPC_HEATING_STATUS:
				onGetHeatingStatus(eoj, tid, pdc, edt);
				break;
			case EPC_HEATING_SETTING:
				onGetHeatingSetting(eoj, tid, pdc, edt);
				break;
			case EPC_HEATING_MODE_SETTING:
				onGetHeatingModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AUTOMATIC_HEATING_SETTING:
				onGetAutomaticHeatingSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AUTOMATIC_HEATING_LEVEL_SETTING:
				onGetAutomaticHeatingLevelSetting(eoj, tid, pdc, edt);
				break;
			case EPC_AUTOMATIC_HEATING_MENU_SETTING:
				onGetAutomaticHeatingMenuSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OVEN_MODE_SETTING:
				onGetOvenModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OVEN_PREHEATING_SETTING:
				onGetOvenPreheatingSetting(eoj, tid, pdc, edt);
				break;
			case EPC_FERMENTING_MODE_SETTING:
				onGetFermentingModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_CHAMBER_TEMPERATURE_SETTING:
				onGetChamberTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_FOOD_TEMPERATURE_SETTING:
				onGetFoodTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_HEATING_TIME_SETTING:
				onGetHeatingTimeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_REMAINING_HEATING_TIME_SETTING:
				onGetRemainingHeatingTimeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MICROWAVE_HEATING_POWER_SETTING:
				onGetMicrowaveHeatingPowerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_PROMPT_MESSAGE_SETTING:
				onGetPromptMessageSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING:
				onGetGaccessoriesToCombinationMicrowaveOvenHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION:
				onGetTwoStageMicrowaveHeatingSettingDuration(eoj, tid, pdc, edt);
				break;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER:
				onGetTwoStageMicrowaveHeatingSettingHeatingPower(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br>Door open = 0x41, door closed = 0x42
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status of the combination microwave oven.<br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43
		 */
		protected void onSetHeatingSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43
		 */
		protected void onGetHeatingSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF
		 */
		protected void onSetHeatingModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF
		 */
		protected void onGetHeatingModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF
		 */
		protected void onSetAutomaticHeatingSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF
		 */
		protected void onGetAutomaticHeatingSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF
		 */
		protected void onSetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF
		 */
		protected void onGetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF
		 */
		protected void onSetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF
		 */
		protected void onGetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF
		 */
		protected void onSetOvenModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF
		 */
		protected void onGetOvenModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF
		 */
		protected void onSetOvenPreheatingSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF
		 */
		protected void onGetOvenPreheatingSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF
		 */
		protected void onSetFermentingModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF
		 */
		protected void onGetFermentingModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified
		 */
		protected void onSetChamberTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified
		 */
		protected void onGetChamberTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified
		 */
		protected void onSetFoodTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified
		 */
		protected void onGetFoodTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		protected void onSetHeatingTimeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		protected void onGetHeatingTimeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		protected void onSetRemainingHeatingTimeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		protected void onGetRemainingHeatingTimeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		protected void onSetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		protected void onGetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))
		 */
		protected void onSetPromptMessageSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))
		 */
		protected void onGetPromptMessageSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).
		 */
		protected void onSetGaccessoriesToCombinationMicrowaveOvenHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).
		 */
		protected void onGetGaccessoriesToCombinationMicrowaveOvenHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven.<br>Shift-JIS code characters x 20
		 */
		protected void onSetDisplayCharacterStringSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)
		 */
		protected void onSetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)
		 */
		protected void onGetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)
		 */
		protected void onSetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)
		 */
		protected void onGetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43
		 */
		public Setter reqSetHeatingSetting(byte[] edt);
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF
		 */
		public Setter reqSetHeatingModeSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF
		 */
		public Setter reqSetAutomaticHeatingSetting(byte[] edt);
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF
		 */
		public Setter reqSetAutomaticHeatingLevelSetting(byte[] edt);
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF
		 */
		public Setter reqSetAutomaticHeatingMenuSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF
		 */
		public Setter reqSetOvenModeSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF
		 */
		public Setter reqSetOvenPreheatingSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF
		 */
		public Setter reqSetFermentingModeSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified
		 */
		public Setter reqSetChamberTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified
		 */
		public Setter reqSetFoodTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		public Setter reqSetHeatingTimeSetting(byte[] edt);
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		public Setter reqSetRemainingHeatingTimeSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Setter reqSetMicrowaveHeatingPowerSetting(byte[] edt);
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))
		 */
		public Setter reqSetPromptMessageSetting(byte[] edt);
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).
		 */
		public Setter reqSetGaccessoriesToCombinationMicrowaveOvenHSetting(byte[] edt);
		/**
		 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven.<br>Shift-JIS code characters x 20
		 */
		public Setter reqSetDisplayCharacterStringSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)
		 */
		public Setter reqSetTwoStageMicrowaveHeatingSettingDuration(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Setter reqSetTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt);

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
		public Setter reqSetHeatingSetting(byte[] edt) {
			addProperty(EPC_HEATING_SETTING, edt, setHeatingSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetHeatingModeSetting(byte[] edt) {
			addProperty(EPC_HEATING_MODE_SETTING, edt, setHeatingModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAutomaticHeatingSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_HEATING_SETTING, edt, setAutomaticHeatingSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAutomaticHeatingLevelSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING, edt, setAutomaticHeatingLevelSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAutomaticHeatingMenuSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING, edt, setAutomaticHeatingMenuSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOvenModeSetting(byte[] edt) {
			addProperty(EPC_OVEN_MODE_SETTING, edt, setOvenModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOvenPreheatingSetting(byte[] edt) {
			addProperty(EPC_OVEN_PREHEATING_SETTING, edt, setOvenPreheatingSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetFermentingModeSetting(byte[] edt) {
			addProperty(EPC_FERMENTING_MODE_SETTING, edt, setFermentingModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetChamberTemperatureSetting(byte[] edt) {
			addProperty(EPC_CHAMBER_TEMPERATURE_SETTING, edt, setChamberTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetFoodTemperatureSetting(byte[] edt) {
			addProperty(EPC_FOOD_TEMPERATURE_SETTING, edt, setFoodTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetHeatingTimeSetting(byte[] edt) {
			addProperty(EPC_HEATING_TIME_SETTING, edt, setHeatingTimeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetRemainingHeatingTimeSetting(byte[] edt) {
			addProperty(EPC_REMAINING_HEATING_TIME_SETTING, edt, setRemainingHeatingTimeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetMicrowaveHeatingPowerSetting(byte[] edt) {
			addProperty(EPC_MICROWAVE_HEATING_POWER_SETTING, edt, setMicrowaveHeatingPowerSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetPromptMessageSetting(byte[] edt) {
			addProperty(EPC_PROMPT_MESSAGE_SETTING, edt, setPromptMessageSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGaccessoriesToCombinationMicrowaveOvenHSetting(byte[] edt) {
			addProperty(EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING, edt, setGaccessoriesToCombinationMicrowaveOvenHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetDisplayCharacterStringSetting(byte[] edt) {
			addProperty(EPC_DISPLAY_CHARACTER_STRING_SETTING, edt, setDisplayCharacterStringSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetTwoStageMicrowaveHeatingSettingDuration(byte[] edt) {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION, edt, setTwoStageMicrowaveHeatingSettingDuration(edt));
			return this;
		}
		@Override
		public Setter reqSetTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt) {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER, edt, setTwoStageMicrowaveHeatingSettingHeatingPower(edt));
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
		public Setter reqSetHeatingSetting(byte[] edt) {
			addProperty(EPC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHeatingModeSetting(byte[] edt) {
			addProperty(EPC_HEATING_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAutomaticHeatingSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAutomaticHeatingLevelSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAutomaticHeatingMenuSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOvenModeSetting(byte[] edt) {
			addProperty(EPC_OVEN_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOvenPreheatingSetting(byte[] edt) {
			addProperty(EPC_OVEN_PREHEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetFermentingModeSetting(byte[] edt) {
			addProperty(EPC_FERMENTING_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetChamberTemperatureSetting(byte[] edt) {
			addProperty(EPC_CHAMBER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetFoodTemperatureSetting(byte[] edt) {
			addProperty(EPC_FOOD_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetHeatingTimeSetting(byte[] edt) {
			addProperty(EPC_HEATING_TIME_SETTING, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Setter reqSetRemainingHeatingTimeSetting(byte[] edt) {
			addProperty(EPC_REMAINING_HEATING_TIME_SETTING, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Setter reqSetMicrowaveHeatingPowerSetting(byte[] edt) {
			addProperty(EPC_MICROWAVE_HEATING_POWER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetPromptMessageSetting(byte[] edt) {
			addProperty(EPC_PROMPT_MESSAGE_SETTING, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Setter reqSetGaccessoriesToCombinationMicrowaveOvenHSetting(byte[] edt) {
			addProperty(EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetDisplayCharacterStringSetting(byte[] edt) {
			addProperty(EPC_DISPLAY_CHARACTER_STRING_SETTING, edt, (edt != null && (edt.length == 40)));
			return this;
		}
		@Override
		public Setter reqSetTwoStageMicrowaveHeatingSettingDuration(byte[] edt) {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Setter reqSetTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt) {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER, edt, (edt != null && (edt.length == 4)));
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
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br>Door open = 0x41, door closed = 0x42
		 */
		public Getter reqGetDoorOpenCloseStatus();
		/**
		 * Used to acquire the status of the combination microwave oven.<br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47
		 */
		public Getter reqGetHeatingStatus();
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43
		 */
		public Getter reqGetHeatingSetting();
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF
		 */
		public Getter reqGetHeatingModeSetting();
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF
		 */
		public Getter reqGetAutomaticHeatingSetting();
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF
		 */
		public Getter reqGetAutomaticHeatingLevelSetting();
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF
		 */
		public Getter reqGetAutomaticHeatingMenuSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF
		 */
		public Getter reqGetOvenModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF
		 */
		public Getter reqGetOvenPreheatingSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF
		 */
		public Getter reqGetFermentingModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified
		 */
		public Getter reqGetChamberTemperatureSetting();
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified
		 */
		public Getter reqGetFoodTemperatureSetting();
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		public Getter reqGetHeatingTimeSetting();
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		public Getter reqGetRemainingHeatingTimeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Getter reqGetMicrowaveHeatingPowerSetting();
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))
		 */
		public Getter reqGetPromptMessageSetting();
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).
		 */
		public Getter reqGetGaccessoriesToCombinationMicrowaveOvenHSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)
		 */
		public Getter reqGetTwoStageMicrowaveHeatingSettingDuration();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Getter reqGetTwoStageMicrowaveHeatingSettingHeatingPower();

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
		public Getter reqGetHeatingStatus() {
			byte[] edt = getHeatingStatus();
			addProperty(EPC_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatingSetting() {
			byte[] edt = getHeatingSetting();
			addProperty(EPC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatingModeSetting() {
			byte[] edt = getHeatingModeSetting();
			addProperty(EPC_HEATING_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutomaticHeatingSetting() {
			byte[] edt = getAutomaticHeatingSetting();
			addProperty(EPC_AUTOMATIC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutomaticHeatingLevelSetting() {
			byte[] edt = getAutomaticHeatingLevelSetting();
			addProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutomaticHeatingMenuSetting() {
			byte[] edt = getAutomaticHeatingMenuSetting();
			addProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOvenModeSetting() {
			byte[] edt = getOvenModeSetting();
			addProperty(EPC_OVEN_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOvenPreheatingSetting() {
			byte[] edt = getOvenPreheatingSetting();
			addProperty(EPC_OVEN_PREHEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetFermentingModeSetting() {
			byte[] edt = getFermentingModeSetting();
			addProperty(EPC_FERMENTING_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetChamberTemperatureSetting() {
			byte[] edt = getChamberTemperatureSetting();
			addProperty(EPC_CHAMBER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetFoodTemperatureSetting() {
			byte[] edt = getFoodTemperatureSetting();
			addProperty(EPC_FOOD_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetHeatingTimeSetting() {
			byte[] edt = getHeatingTimeSetting();
			addProperty(EPC_HEATING_TIME_SETTING, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetRemainingHeatingTimeSetting() {
			byte[] edt = getRemainingHeatingTimeSetting();
			addProperty(EPC_REMAINING_HEATING_TIME_SETTING, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetMicrowaveHeatingPowerSetting() {
			byte[] edt = getMicrowaveHeatingPowerSetting();
			addProperty(EPC_MICROWAVE_HEATING_POWER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetPromptMessageSetting() {
			byte[] edt = getPromptMessageSetting();
			addProperty(EPC_PROMPT_MESSAGE_SETTING, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Getter reqGetGaccessoriesToCombinationMicrowaveOvenHSetting() {
			byte[] edt = getGaccessoriesToCombinationMicrowaveOvenHSetting();
			addProperty(EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetTwoStageMicrowaveHeatingSettingDuration() {
			byte[] edt = getTwoStageMicrowaveHeatingSettingDuration();
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Getter reqGetTwoStageMicrowaveHeatingSettingHeatingPower() {
			byte[] edt = getTwoStageMicrowaveHeatingSettingHeatingPower();
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER, edt, (edt != null && (edt.length == 4)));
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
		public Getter reqGetHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		@Override
		public Getter reqGetHeatingSetting() {
			addProperty(EPC_HEATING_SETTING);
			return this;
		}
		@Override
		public Getter reqGetHeatingModeSetting() {
			addProperty(EPC_HEATING_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAutomaticHeatingSetting() {
			addProperty(EPC_AUTOMATIC_HEATING_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAutomaticHeatingLevelSetting() {
			addProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetAutomaticHeatingMenuSetting() {
			addProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOvenModeSetting() {
			addProperty(EPC_OVEN_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOvenPreheatingSetting() {
			addProperty(EPC_OVEN_PREHEATING_SETTING);
			return this;
		}
		@Override
		public Getter reqGetFermentingModeSetting() {
			addProperty(EPC_FERMENTING_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetChamberTemperatureSetting() {
			addProperty(EPC_CHAMBER_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetFoodTemperatureSetting() {
			addProperty(EPC_FOOD_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetHeatingTimeSetting() {
			addProperty(EPC_HEATING_TIME_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRemainingHeatingTimeSetting() {
			addProperty(EPC_REMAINING_HEATING_TIME_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMicrowaveHeatingPowerSetting() {
			addProperty(EPC_MICROWAVE_HEATING_POWER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetPromptMessageSetting() {
			addProperty(EPC_PROMPT_MESSAGE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGaccessoriesToCombinationMicrowaveOvenHSetting() {
			addProperty(EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetTwoStageMicrowaveHeatingSettingDuration() {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION);
			return this;
		}
		@Override
		public Getter reqGetTwoStageMicrowaveHeatingSettingHeatingPower() {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER);
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
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br>Door open = 0x41, door closed = 0x42
		 */
		public Informer reqInformDoorOpenCloseStatus();
		/**
		 * Used to acquire the status of the combination microwave oven.<br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47
		 */
		public Informer reqInformHeatingStatus();
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43
		 */
		public Informer reqInformHeatingSetting();
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF
		 */
		public Informer reqInformHeatingModeSetting();
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF
		 */
		public Informer reqInformAutomaticHeatingSetting();
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF
		 */
		public Informer reqInformAutomaticHeatingLevelSetting();
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF
		 */
		public Informer reqInformAutomaticHeatingMenuSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF
		 */
		public Informer reqInformOvenModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF
		 */
		public Informer reqInformOvenPreheatingSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF
		 */
		public Informer reqInformFermentingModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified
		 */
		public Informer reqInformChamberTemperatureSetting();
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified
		 */
		public Informer reqInformFoodTemperatureSetting();
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		public Informer reqInformHeatingTimeSetting();
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)
		 */
		public Informer reqInformRemainingHeatingTimeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Informer reqInformMicrowaveHeatingPowerSetting();
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))
		 */
		public Informer reqInformPromptMessageSetting();
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).
		 */
		public Informer reqInformGaccessoriesToCombinationMicrowaveOvenHSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)
		 */
		public Informer reqInformTwoStageMicrowaveHeatingSettingDuration();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)
		 */
		public Informer reqInformTwoStageMicrowaveHeatingSettingHeatingPower();

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
		public Informer reqInformHeatingStatus() {
			byte[] edt = getHeatingStatus();
			addProperty(EPC_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatingSetting() {
			byte[] edt = getHeatingSetting();
			addProperty(EPC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatingModeSetting() {
			byte[] edt = getHeatingModeSetting();
			addProperty(EPC_HEATING_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticHeatingSetting() {
			byte[] edt = getAutomaticHeatingSetting();
			addProperty(EPC_AUTOMATIC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticHeatingLevelSetting() {
			byte[] edt = getAutomaticHeatingLevelSetting();
			addProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticHeatingMenuSetting() {
			byte[] edt = getAutomaticHeatingMenuSetting();
			addProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOvenModeSetting() {
			byte[] edt = getOvenModeSetting();
			addProperty(EPC_OVEN_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOvenPreheatingSetting() {
			byte[] edt = getOvenPreheatingSetting();
			addProperty(EPC_OVEN_PREHEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFermentingModeSetting() {
			byte[] edt = getFermentingModeSetting();
			addProperty(EPC_FERMENTING_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformChamberTemperatureSetting() {
			byte[] edt = getChamberTemperatureSetting();
			addProperty(EPC_CHAMBER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformFoodTemperatureSetting() {
			byte[] edt = getFoodTemperatureSetting();
			addProperty(EPC_FOOD_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformHeatingTimeSetting() {
			byte[] edt = getHeatingTimeSetting();
			addProperty(EPC_HEATING_TIME_SETTING, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformRemainingHeatingTimeSetting() {
			byte[] edt = getRemainingHeatingTimeSetting();
			addProperty(EPC_REMAINING_HEATING_TIME_SETTING, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformMicrowaveHeatingPowerSetting() {
			byte[] edt = getMicrowaveHeatingPowerSetting();
			addProperty(EPC_MICROWAVE_HEATING_POWER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformPromptMessageSetting() {
			byte[] edt = getPromptMessageSetting();
			addProperty(EPC_PROMPT_MESSAGE_SETTING, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformGaccessoriesToCombinationMicrowaveOvenHSetting() {
			byte[] edt = getGaccessoriesToCombinationMicrowaveOvenHSetting();
			addProperty(EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformTwoStageMicrowaveHeatingSettingDuration() {
			byte[] edt = getTwoStageMicrowaveHeatingSettingDuration();
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformTwoStageMicrowaveHeatingSettingHeatingPower() {
			byte[] edt = getTwoStageMicrowaveHeatingSettingHeatingPower();
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER, edt, (edt != null && (edt.length == 4)));
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
		public Informer reqInformHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		@Override
		public Informer reqInformHeatingSetting() {
			addProperty(EPC_HEATING_SETTING);
			return this;
		}
		@Override
		public Informer reqInformHeatingModeSetting() {
			addProperty(EPC_HEATING_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAutomaticHeatingSetting() {
			addProperty(EPC_AUTOMATIC_HEATING_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAutomaticHeatingLevelSetting() {
			addProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformAutomaticHeatingMenuSetting() {
			addProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOvenModeSetting() {
			addProperty(EPC_OVEN_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOvenPreheatingSetting() {
			addProperty(EPC_OVEN_PREHEATING_SETTING);
			return this;
		}
		@Override
		public Informer reqInformFermentingModeSetting() {
			addProperty(EPC_FERMENTING_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformChamberTemperatureSetting() {
			addProperty(EPC_CHAMBER_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformFoodTemperatureSetting() {
			addProperty(EPC_FOOD_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformHeatingTimeSetting() {
			addProperty(EPC_HEATING_TIME_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRemainingHeatingTimeSetting() {
			addProperty(EPC_REMAINING_HEATING_TIME_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMicrowaveHeatingPowerSetting() {
			addProperty(EPC_MICROWAVE_HEATING_POWER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformPromptMessageSetting() {
			addProperty(EPC_PROMPT_MESSAGE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGaccessoriesToCombinationMicrowaveOvenHSetting() {
			addProperty(EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformTwoStageMicrowaveHeatingSettingDuration() {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION);
			return this;
		}
		@Override
		public Informer reqInformTwoStageMicrowaveHeatingSettingHeatingPower() {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER);
			return this;
		}

	}
}
