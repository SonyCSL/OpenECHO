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
	 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br>Door open = 0x41, door closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getDoorOpenCloseStatus() {return null;}
	/**
	 * Used to acquire the status of the combination microwave oven.<br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHeatingStatus() {return null;}
	/**
	 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatingSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatingSetting() {return null;}
	/**
	 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatingModeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatingModeSetting() {return null;}
	/**
	 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setAutomaticHeatingSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAutomaticHeatingSetting() {return null;}
	/**
	 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setAutomaticHeatingLevelSetting(byte[] edt) {return false;}
	/**
	 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAutomaticHeatingLevelSetting() {return null;}
	/**
	 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setAutomaticHeatingMenuSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAutomaticHeatingMenuSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOvenModeSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOvenModeSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOvenPreheatingSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOvenPreheatingSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setFermentingModeSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getFermentingModeSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
	 */
	protected boolean setChamberTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
	 */
	protected byte[] getChamberTemperatureSetting() {return null;}
	/**
	 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
	 */
	protected boolean setFoodTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
	 */
	protected byte[] getFoodTemperatureSetting() {return null;}
	/**
	 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatingTimeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatingTimeSetting() {return null;}
	/**
	 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
	 */
	protected boolean setRemainingHeatingTimeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRemainingHeatingTimeSetting() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
	 */
	protected boolean setMicrowaveHeatingPowerSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
	 */
	protected byte[] getMicrowaveHeatingPowerSetting() {return null;}
	/**
	 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Data type : <br>Data size : 8<br>Set : optional<br>Get : optional
	 */
	protected boolean setPromptMessageSetting(byte[] edt) {return false;}
	/**
	 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Data type : <br>Data size : 8<br>Set : optional<br>Get : optional
	 */
	protected byte[] getPromptMessageSetting() {return null;}
	/**
	 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
	 */
	protected boolean setGaccessoriesToCombinationMicrowaveOvenHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGaccessoriesToCombinationMicrowaveOvenHSetting() {return null;}
	/**
	 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven.<br>Shift-JIS code characters x 20<br><br>Data type : <br>Data size : 40<br>Set : optional<br>Get : undefined
	 */
	protected boolean setDisplayCharacterStringSetting(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : <br>Data size : 6<br>Set : optional<br>Get : optional
	 */
	protected boolean setTwoStageMicrowaveHeatingSettingDuration(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : <br>Data size : 6<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTwoStageMicrowaveHeatingSettingDuration() {return null;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 4<br>Set : optional<br>Get : optional
	 */
	protected boolean setTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt) {return false;}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 4<br>Set : optional<br>Get : optional
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
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br>Door open = 0x41, door closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the status of the combination microwave oven.<br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatingSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatingSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatingModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatingModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetAutomaticHeatingSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetAutomaticHeatingSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOvenModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOvenModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOvenPreheatingSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOvenPreheatingSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetFermentingModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetFermentingModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		protected void onSetChamberTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		protected void onGetChamberTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		protected void onSetFoodTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		protected void onGetFoodTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatingTimeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatingTimeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		protected void onSetRemainingHeatingTimeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		protected void onGetRemainingHeatingTimeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		protected void onSetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		protected void onGetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Data type : <br>Data size : 8<br>Set : optional<br>Get : optional
		 */
		protected void onSetPromptMessageSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Data type : <br>Data size : 8<br>Set : optional<br>Get : optional
		 */
		protected void onGetPromptMessageSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		protected void onSetGaccessoriesToCombinationMicrowaveOvenHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		protected void onGetGaccessoriesToCombinationMicrowaveOvenHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven.<br>Shift-JIS code characters x 20<br><br>Data type : <br>Data size : 40<br>Set : optional<br>Get : undefined
		 */
		protected void onSetDisplayCharacterStringSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : <br>Data size : 6<br>Set : optional<br>Get : optional
		 */
		protected void onSetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : <br>Data size : 6<br>Set : optional<br>Get : optional
		 */
		protected void onGetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 4<br>Set : optional<br>Get : optional
		 */
		protected void onSetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 4<br>Set : optional<br>Get : optional
		 */
		protected void onGetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetHeatingSetting(byte[] edt);
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetHeatingModeSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetAutomaticHeatingSetting(byte[] edt);
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetAutomaticHeatingLevelSetting(byte[] edt);
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetAutomaticHeatingMenuSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOvenModeSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOvenPreheatingSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetFermentingModeSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetChamberTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetFoodTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetHeatingTimeSetting(byte[] edt);
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRemainingHeatingTimeSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetMicrowaveHeatingPowerSetting(byte[] edt);
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Data type : <br>Data size : 8<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetPromptMessageSetting(byte[] edt);
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGaccessoriesToCombinationMicrowaveOvenHSetting(byte[] edt);
		/**
		 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven.<br>Shift-JIS code characters x 20<br><br>Data type : <br>Data size : 40<br>Set : optional<br>Get : undefined
		 */
		public Setter reqSetDisplayCharacterStringSetting(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : <br>Data size : 6<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTwoStageMicrowaveHeatingSettingDuration(byte[] edt);
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 4<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt);
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
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br>Door open = 0x41, door closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetDoorOpenCloseStatus();
		/**
		 * Used to acquire the status of the combination microwave oven.<br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetHeatingStatus();
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetHeatingSetting();
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetHeatingModeSetting();
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetAutomaticHeatingSetting();
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetAutomaticHeatingLevelSetting();
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetAutomaticHeatingMenuSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOvenModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOvenPreheatingSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetFermentingModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetChamberTemperatureSetting();
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetFoodTemperatureSetting();
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetHeatingTimeSetting();
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRemainingHeatingTimeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetMicrowaveHeatingPowerSetting();
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Data type : <br>Data size : 8<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetPromptMessageSetting();
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGaccessoriesToCombinationMicrowaveOvenHSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : <br>Data size : 6<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTwoStageMicrowaveHeatingSettingDuration();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 4<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTwoStageMicrowaveHeatingSettingHeatingPower();
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
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br>Door open = 0x41, door closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformDoorOpenCloseStatus();
		/**
		 * Used to acquire the status of the combination microwave oven.<br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformHeatingStatus();
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformHeatingSetting();
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformHeatingModeSetting();
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformAutomaticHeatingSetting();
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformAutomaticHeatingLevelSetting();
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformAutomaticHeatingMenuSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Data type : unsigned cha<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOvenModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOvenPreheatingSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformFermentingModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformChamberTemperatureSetting();
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformFoodTemperatureSetting();
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformHeatingTimeSetting();
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Data type : <br>Data size : 3<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRemainingHeatingTimeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformMicrowaveHeatingPowerSetting();
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Data type : <br>Data size : 8<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformPromptMessageSetting();
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Data type : <br>Data size : 2<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGaccessoriesToCombinationMicrowaveOvenHSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : <br>Data size : 6<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTwoStageMicrowaveHeatingSettingDuration();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Data type : <br>Data size : 4<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTwoStageMicrowaveHeatingSettingHeatingPower();
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
