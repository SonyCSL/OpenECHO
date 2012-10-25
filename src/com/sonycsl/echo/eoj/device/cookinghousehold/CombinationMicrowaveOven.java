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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xB8;
	
	public CombinationMicrowaveOven() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_DOOR_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_HEATING_STATUS = (byte)0xB1;
	public static final byte EPC_HEATING_SETTING = (byte)0xB2;
	public static final byte EPC_HEATING_MODE_SETTING = (byte)0xE0;
	public static final byte EPC_AUTOMATIC_HEATING_SETTING = (byte)0xE1;
	public static final byte EPC_AUTOMATIC_HEATING_LEVEL_SETTING = (byte)0xE2;
	public static final byte EPC_AUTOMATIC_HEATING_MENU_SETTING = (byte)0xD0;
	public static final byte EPC_OVEN_MODE_SETTING = (byte)0xD1;
	public static final byte EPC_OVEN_PREHEATING_SETTING = (byte)0xD5;
	public static final byte EPC_FERMENTING_MODE_SETTING = (byte)0xD6;
	public static final byte EPC_CHAMBER_TEMPERATURE_SETTING = (byte)0xE3;
	public static final byte EPC_FOOD_TEMPERATURE_SETTING = (byte)0xE4;
	public static final byte EPC_HEATING_TIME_SETTING = (byte)0xE5;
	public static final byte EPC_REMAINING_HEATING_TIME_SETTING = (byte)0xE6;
	public static final byte EPC_MICROWAVE_HEATING_POWER_SETTING = (byte)0xE7;
	public static final byte EPC_PROMPT_MESSAGE_SETTING = (byte)0xE8;
	public static final byte EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING = (byte)0xE9;
	public static final byte EPC_DISPLAY_CHARACTER_STRING_SETTING = (byte)0xEA;
	public static final byte EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION = (byte)0xEB;
	public static final byte EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER = (byte)0xEC;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br><br>Door open = 0x41, door closed = 0x42<br><br>Name : Door open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getDoorOpenCloseStatus() {return null;}
	private final byte[] _getDoorOpenCloseStatus(byte epc) {
		byte[] edt = getDoorOpenCloseStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the status of the combination microwave oven.<br><br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47<br><br>Name : Heating status<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getHeatingStatus() {return null;}
	private final byte[] _getHeatingStatus(byte epc) {
		byte[] edt = getHeatingStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br><br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHeatingSetting(byte[] edt) {return false;}
	private final boolean _setHeatingSetting(byte epc, byte[] edt) {
		boolean success = setHeatingSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br><br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHeatingSetting() {return null;}
	private final byte[] _getHeatingSetting(byte epc) {
		byte[] edt = getHeatingSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br><br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Name : Heating mode setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHeatingModeSetting(byte[] edt) {return false;}
	private final boolean _setHeatingModeSetting(byte epc, byte[] edt) {
		boolean success = setHeatingModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br><br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Name : Heating mode setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHeatingModeSetting() {return null;}
	private final byte[] _getHeatingModeSetting(byte epc) {
		byte[] edt = getHeatingModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br><br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Name : Automatic heating setting<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAutomaticHeatingSetting(byte[] edt) {return false;}
	private final boolean _setAutomaticHeatingSetting(byte epc, byte[] edt) {
		boolean success = setAutomaticHeatingSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br><br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Name : Automatic heating setting<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAutomaticHeatingSetting() {return null;}
	private final byte[] _getAutomaticHeatingSetting(byte epc) {
		byte[] edt = getAutomaticHeatingSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br><br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Name : Automatic heating level setting<br>EPC : 0xE2<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAutomaticHeatingLevelSetting(byte[] edt) {return false;}
	private final boolean _setAutomaticHeatingLevelSetting(byte epc, byte[] edt) {
		boolean success = setAutomaticHeatingLevelSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br><br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Name : Automatic heating level setting<br>EPC : 0xE2<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAutomaticHeatingLevelSetting() {return null;}
	private final byte[] _getAutomaticHeatingLevelSetting(byte epc) {
		byte[] edt = getAutomaticHeatingLevelSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br><br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Name : Automatic heating menu setting<br>EPC : 0xD0<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAutomaticHeatingMenuSetting(byte[] edt) {return false;}
	private final boolean _setAutomaticHeatingMenuSetting(byte epc, byte[] edt) {
		boolean success = setAutomaticHeatingMenuSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br><br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Name : Automatic heating menu setting<br>EPC : 0xD0<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAutomaticHeatingMenuSetting() {return null;}
	private final byte[] _getAutomaticHeatingMenuSetting(byte epc) {
		byte[] edt = getAutomaticHeatingMenuSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Name : Oven mode setting<br>EPC : 0xD1<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOvenModeSetting(byte[] edt) {return false;}
	private final boolean _setOvenModeSetting(byte epc, byte[] edt) {
		boolean success = setOvenModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Name : Oven mode setting<br>EPC : 0xD1<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOvenModeSetting() {return null;}
	private final byte[] _getOvenModeSetting(byte epc) {
		byte[] edt = getOvenModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br><br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Name : Oven preheating setting<br>EPC : 0xD5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOvenPreheatingSetting(byte[] edt) {return false;}
	private final boolean _setOvenPreheatingSetting(byte epc, byte[] edt) {
		boolean success = setOvenPreheatingSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br><br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Name : Oven preheating setting<br>EPC : 0xD5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOvenPreheatingSetting() {return null;}
	private final byte[] _getOvenPreheatingSetting(byte epc) {
		byte[] edt = getOvenPreheatingSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Name : Fermenting mode setting<br>EPC : 0xD6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setFermentingModeSetting(byte[] edt) {return false;}
	private final boolean _setFermentingModeSetting(byte epc, byte[] edt) {
		boolean success = setFermentingModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Name : Fermenting mode setting<br>EPC : 0xD6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getFermentingModeSetting() {return null;}
	private final byte[] _getFermentingModeSetting(byte epc) {
		byte[] edt = getFermentingModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Name : Chamber temperature setting<br>EPC : 0xE3<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setChamberTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setChamberTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setChamberTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Name : Chamber temperature setting<br>EPC : 0xE3<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getChamberTemperatureSetting() {return null;}
	private final byte[] _getChamberTemperatureSetting(byte epc) {
		byte[] edt = getChamberTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Name : Food temperature setting<br>EPC : 0xE4<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setFoodTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setFoodTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setFoodTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Name : Food temperature setting<br>EPC : 0xE4<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getFoodTemperatureSetting() {return null;}
	private final byte[] _getFoodTemperatureSetting(byte epc) {
		byte[] edt = getFoodTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Heating time setting<br>EPC : 0xE5<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHeatingTimeSetting(byte[] edt) {return false;}
	private final boolean _setHeatingTimeSetting(byte epc, byte[] edt) {
		boolean success = setHeatingTimeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Heating time setting<br>EPC : 0xE5<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHeatingTimeSetting() {return null;}
	private final byte[] _getHeatingTimeSetting(byte epc) {
		byte[] edt = getHeatingTimeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Remaining heating time setting<br>EPC : 0xE6<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRemainingHeatingTimeSetting(byte[] edt) {return false;}
	private final boolean _setRemainingHeatingTimeSetting(byte epc, byte[] edt) {
		boolean success = setRemainingHeatingTimeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Remaining heating time setting<br>EPC : 0xE6<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRemainingHeatingTimeSetting() {return null;}
	private final byte[] _getRemainingHeatingTimeSetting(byte epc) {
		byte[] edt = getRemainingHeatingTimeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Microwave heating power setting<br>EPC : 0xE7<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setMicrowaveHeatingPowerSetting(byte[] edt) {return false;}
	private final boolean _setMicrowaveHeatingPowerSetting(byte epc, byte[] edt) {
		boolean success = setMicrowaveHeatingPowerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Microwave heating power setting<br>EPC : 0xE7<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getMicrowaveHeatingPowerSetting() {return null;}
	private final byte[] _getMicrowaveHeatingPowerSetting(byte epc) {
		byte[] edt = getMicrowaveHeatingPowerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br><br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Name : Prompt message setting<br>EPC : 0xE8<br>Data Type : <br>Data Size(Byte) : 8<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setPromptMessageSetting(byte[] edt) {return false;}
	private final boolean _setPromptMessageSetting(byte epc, byte[] edt) {
		boolean success = setPromptMessageSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br><br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Name : Prompt message setting<br>EPC : 0xE8<br>Data Type : <br>Data Size(Byte) : 8<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getPromptMessageSetting() {return null;}
	private final byte[] _getPromptMessageSetting(byte epc) {
		byte[] edt = getPromptMessageSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br><br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Name : �gAccessories to combination microwave oven�h setting<br>EPC : 0xE9<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGaccessoriesToCombinationMicrowaveOvenHSetting(byte[] edt) {return false;}
	private final boolean _setGaccessoriesToCombinationMicrowaveOvenHSetting(byte epc, byte[] edt) {
		boolean success = setGaccessoriesToCombinationMicrowaveOvenHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br><br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Name : �gAccessories to combination microwave oven�h setting<br>EPC : 0xE9<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGaccessoriesToCombinationMicrowaveOvenHSetting() {return null;}
	private final byte[] _getGaccessoriesToCombinationMicrowaveOvenHSetting(byte epc) {
		byte[] edt = getGaccessoriesToCombinationMicrowaveOvenHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven.<br><br>Shift-JIS code characters x 20<br><br>Name : Display character string setting<br>EPC : 0xEA<br>Data Type : <br>Data Size(Byte) : 40<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
	 */
	protected boolean setDisplayCharacterStringSetting(byte[] edt) {return false;}
	private final boolean _setDisplayCharacterStringSetting(byte epc, byte[] edt) {
		boolean success = setDisplayCharacterStringSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br><br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Two-stage microwave heating setting (duration)<br>EPC : 0xEB<br>Data Type : <br>Data Size(Byte) : 6<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTwoStageMicrowaveHeatingSettingDuration(byte[] edt) {return false;}
	private final boolean _setTwoStageMicrowaveHeatingSettingDuration(byte epc, byte[] edt) {
		boolean success = setTwoStageMicrowaveHeatingSettingDuration(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br><br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Two-stage microwave heating setting (duration)<br>EPC : 0xEB<br>Data Type : <br>Data Size(Byte) : 6<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTwoStageMicrowaveHeatingSettingDuration() {return null;}
	private final byte[] _getTwoStageMicrowaveHeatingSettingDuration(byte epc) {
		byte[] edt = getTwoStageMicrowaveHeatingSettingDuration();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br><br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Two-stage microwave heating setting (heating power)<br>EPC : 0xEC<br>Data Type : <br>Data Size(Byte) : 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt) {return false;}
	private final boolean _setTwoStageMicrowaveHeatingSettingHeatingPower(byte epc, byte[] edt) {
		boolean success = setTwoStageMicrowaveHeatingSettingHeatingPower(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br><br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Two-stage microwave heating setting (heating power)<br>EPC : 0xEC<br>Data Type : <br>Data Size(Byte) : 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTwoStageMicrowaveHeatingSettingHeatingPower() {return null;}
	private final byte[] _getTwoStageMicrowaveHeatingSettingHeatingPower(byte epc) {
		byte[] edt = getTwoStageMicrowaveHeatingSettingHeatingPower();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_HEATING_SETTING:
			res.addProperty(epc, edt, _setHeatingSetting(epc, edt));
			break;
		case EPC_HEATING_MODE_SETTING:
			res.addProperty(epc, edt, _setHeatingModeSetting(epc, edt));
			break;
		case EPC_AUTOMATIC_HEATING_SETTING:
			res.addProperty(epc, edt, _setAutomaticHeatingSetting(epc, edt));
			break;
		case EPC_AUTOMATIC_HEATING_LEVEL_SETTING:
			res.addProperty(epc, edt, _setAutomaticHeatingLevelSetting(epc, edt));
			break;
		case EPC_AUTOMATIC_HEATING_MENU_SETTING:
			res.addProperty(epc, edt, _setAutomaticHeatingMenuSetting(epc, edt));
			break;
		case EPC_OVEN_MODE_SETTING:
			res.addProperty(epc, edt, _setOvenModeSetting(epc, edt));
			break;
		case EPC_OVEN_PREHEATING_SETTING:
			res.addProperty(epc, edt, _setOvenPreheatingSetting(epc, edt));
			break;
		case EPC_FERMENTING_MODE_SETTING:
			res.addProperty(epc, edt, _setFermentingModeSetting(epc, edt));
			break;
		case EPC_CHAMBER_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setChamberTemperatureSetting(epc, edt));
			break;
		case EPC_FOOD_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setFoodTemperatureSetting(epc, edt));
			break;
		case EPC_HEATING_TIME_SETTING:
			res.addProperty(epc, edt, _setHeatingTimeSetting(epc, edt));
			break;
		case EPC_REMAINING_HEATING_TIME_SETTING:
			res.addProperty(epc, edt, _setRemainingHeatingTimeSetting(epc, edt));
			break;
		case EPC_MICROWAVE_HEATING_POWER_SETTING:
			res.addProperty(epc, edt, _setMicrowaveHeatingPowerSetting(epc, edt));
			break;
		case EPC_PROMPT_MESSAGE_SETTING:
			res.addProperty(epc, edt, _setPromptMessageSetting(epc, edt));
			break;
		case EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING:
			res.addProperty(epc, edt, _setGaccessoriesToCombinationMicrowaveOvenHSetting(epc, edt));
			break;
		case EPC_DISPLAY_CHARACTER_STRING_SETTING:
			res.addProperty(epc, edt, _setDisplayCharacterStringSetting(epc, edt));
			break;
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION:
			res.addProperty(epc, edt, _setTwoStageMicrowaveHeatingSettingDuration(epc, edt));
			break;
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER:
			res.addProperty(epc, edt, _setTwoStageMicrowaveHeatingSettingHeatingPower(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_DOOR_OPEN_CLOSE_STATUS:
			edt = _getDoorOpenCloseStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_STATUS:
			edt = _getHeatingStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_SETTING:
			edt = _getHeatingSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_MODE_SETTING:
			edt = _getHeatingModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_HEATING_SETTING:
			edt = _getAutomaticHeatingSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_HEATING_LEVEL_SETTING:
			edt = _getAutomaticHeatingLevelSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_HEATING_MENU_SETTING:
			edt = _getAutomaticHeatingMenuSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OVEN_MODE_SETTING:
			edt = _getOvenModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OVEN_PREHEATING_SETTING:
			edt = _getOvenPreheatingSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FERMENTING_MODE_SETTING:
			edt = _getFermentingModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CHAMBER_TEMPERATURE_SETTING:
			edt = _getChamberTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_FOOD_TEMPERATURE_SETTING:
			edt = _getFoodTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_HEATING_TIME_SETTING:
			edt = _getHeatingTimeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_REMAINING_HEATING_TIME_SETTING:
			edt = _getRemainingHeatingTimeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_MICROWAVE_HEATING_POWER_SETTING:
			edt = _getMicrowaveHeatingPowerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_PROMPT_MESSAGE_SETTING:
			edt = _getPromptMessageSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 8)));
			break;
		case EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING:
			edt = _getGaccessoriesToCombinationMicrowaveOvenHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION:
			edt = _getTwoStageMicrowaveHeatingSettingDuration(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER:
			edt = _getTwoStageMicrowaveHeatingSettingHeatingPower(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
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
			case EPC_HEATING_SETTING:
				_onSetHeatingSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_HEATING_MODE_SETTING:
				_onSetHeatingModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AUTOMATIC_HEATING_SETTING:
				_onSetAutomaticHeatingSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AUTOMATIC_HEATING_LEVEL_SETTING:
				_onSetAutomaticHeatingLevelSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AUTOMATIC_HEATING_MENU_SETTING:
				_onSetAutomaticHeatingMenuSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OVEN_MODE_SETTING:
				_onSetOvenModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OVEN_PREHEATING_SETTING:
				_onSetOvenPreheatingSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_FERMENTING_MODE_SETTING:
				_onSetFermentingModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_CHAMBER_TEMPERATURE_SETTING:
				_onSetChamberTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_FOOD_TEMPERATURE_SETTING:
				_onSetFoodTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_HEATING_TIME_SETTING:
				_onSetHeatingTimeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_REMAINING_HEATING_TIME_SETTING:
				_onSetRemainingHeatingTimeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_MICROWAVE_HEATING_POWER_SETTING:
				_onSetMicrowaveHeatingPowerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_PROMPT_MESSAGE_SETTING:
				_onSetPromptMessageSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING:
				_onSetGaccessoriesToCombinationMicrowaveOvenHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DISPLAY_CHARACTER_STRING_SETTING:
				_onSetDisplayCharacterStringSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION:
				_onSetTwoStageMicrowaveHeatingSettingDuration(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER:
				_onSetTwoStageMicrowaveHeatingSettingHeatingPower(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_DOOR_OPEN_CLOSE_STATUS:
				_onGetDoorOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATING_STATUS:
				_onGetHeatingStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATING_SETTING:
				_onGetHeatingSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATING_MODE_SETTING:
				_onGetHeatingModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AUTOMATIC_HEATING_SETTING:
				_onGetAutomaticHeatingSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AUTOMATIC_HEATING_LEVEL_SETTING:
				_onGetAutomaticHeatingLevelSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AUTOMATIC_HEATING_MENU_SETTING:
				_onGetAutomaticHeatingMenuSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OVEN_MODE_SETTING:
				_onGetOvenModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OVEN_PREHEATING_SETTING:
				_onGetOvenPreheatingSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FERMENTING_MODE_SETTING:
				_onGetFermentingModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CHAMBER_TEMPERATURE_SETTING:
				_onGetChamberTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FOOD_TEMPERATURE_SETTING:
				_onGetFoodTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATING_TIME_SETTING:
				_onGetHeatingTimeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REMAINING_HEATING_TIME_SETTING:
				_onGetRemainingHeatingTimeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MICROWAVE_HEATING_POWER_SETTING:
				_onGetMicrowaveHeatingPowerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_PROMPT_MESSAGE_SETTING:
				_onGetPromptMessageSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING:
				_onGetGaccessoriesToCombinationMicrowaveOvenHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION:
				_onGetTwoStageMicrowaveHeatingSettingDuration(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER:
				_onGetTwoStageMicrowaveHeatingSettingHeatingPower(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br><br>Door open = 0x41, door closed = 0x42<br><br>Name : Door open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDoorOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the status of the combination microwave oven.<br><br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47<br><br>Name : Heating status<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br><br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeatingSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br><br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br><br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Name : Heating mode setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHeatingModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeatingModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeatingModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br><br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Name : Heating mode setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHeatingModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br><br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Name : Automatic heating setting<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAutomaticHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutomaticHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutomaticHeatingSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br><br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Name : Automatic heating setting<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAutomaticHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutomaticHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutomaticHeatingSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br><br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Name : Automatic heating level setting<br>EPC : 0xE2<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutomaticHeatingLevelSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br><br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Name : Automatic heating level setting<br>EPC : 0xE2<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutomaticHeatingLevelSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br><br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Name : Automatic heating menu setting<br>EPC : 0xD0<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutomaticHeatingMenuSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br><br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Name : Automatic heating menu setting<br>EPC : 0xD0<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutomaticHeatingMenuSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Name : Oven mode setting<br>EPC : 0xD1<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOvenModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOvenModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOvenModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Name : Oven mode setting<br>EPC : 0xD1<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOvenModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOvenModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOvenModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br><br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Name : Oven preheating setting<br>EPC : 0xD5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOvenPreheatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOvenPreheatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOvenPreheatingSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br><br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Name : Oven preheating setting<br>EPC : 0xD5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOvenPreheatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOvenPreheatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOvenPreheatingSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Name : Fermenting mode setting<br>EPC : 0xD6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetFermentingModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetFermentingModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetFermentingModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Name : Fermenting mode setting<br>EPC : 0xD6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetFermentingModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFermentingModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFermentingModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Name : Chamber temperature setting<br>EPC : 0xE3<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetChamberTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetChamberTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetChamberTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Name : Chamber temperature setting<br>EPC : 0xE3<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetChamberTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetChamberTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetChamberTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Name : Food temperature setting<br>EPC : 0xE4<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetFoodTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetFoodTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetFoodTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Name : Food temperature setting<br>EPC : 0xE4<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetFoodTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFoodTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFoodTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Heating time setting<br>EPC : 0xE5<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHeatingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeatingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeatingTimeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Heating time setting<br>EPC : 0xE5<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHeatingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingTimeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Remaining heating time setting<br>EPC : 0xE6<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRemainingHeatingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRemainingHeatingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRemainingHeatingTimeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Remaining heating time setting<br>EPC : 0xE6<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRemainingHeatingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRemainingHeatingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRemainingHeatingTimeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Microwave heating power setting<br>EPC : 0xE7<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetMicrowaveHeatingPowerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Microwave heating power setting<br>EPC : 0xE7<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMicrowaveHeatingPowerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br><br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Name : Prompt message setting<br>EPC : 0xE8<br>Data Type : <br>Data Size(Byte) : 8<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetPromptMessageSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetPromptMessageSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetPromptMessageSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br><br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Name : Prompt message setting<br>EPC : 0xE8<br>Data Type : <br>Data Size(Byte) : 8<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetPromptMessageSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPromptMessageSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPromptMessageSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br><br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Name : �gAccessories to combination microwave oven�h setting<br>EPC : 0xE9<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGaccessoriesToCombinationMicrowaveOvenHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGaccessoriesToCombinationMicrowaveOvenHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGaccessoriesToCombinationMicrowaveOvenHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br><br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Name : �gAccessories to combination microwave oven�h setting<br>EPC : 0xE9<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGaccessoriesToCombinationMicrowaveOvenHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGaccessoriesToCombinationMicrowaveOvenHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGaccessoriesToCombinationMicrowaveOvenHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven.<br><br>Shift-JIS code characters x 20<br><br>Name : Display character string setting<br>EPC : 0xEA<br>Data Type : <br>Data Size(Byte) : 40<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
		 */
		protected void onSetDisplayCharacterStringSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDisplayCharacterStringSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDisplayCharacterStringSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br><br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Two-stage microwave heating setting (duration)<br>EPC : 0xEB<br>Data Type : <br>Data Size(Byte) : 6<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTwoStageMicrowaveHeatingSettingDuration(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br><br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Two-stage microwave heating setting (duration)<br>EPC : 0xEB<br>Data Type : <br>Data Size(Byte) : 6<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTwoStageMicrowaveHeatingSettingDuration(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br><br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Two-stage microwave heating setting (heating power)<br>EPC : 0xEC<br>Data Type : <br>Data Size(Byte) : 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTwoStageMicrowaveHeatingSettingHeatingPower(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br><br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Two-stage microwave heating setting (heating power)<br>EPC : 0xEC<br>Data Type : <br>Data Size(Byte) : 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTwoStageMicrowaveHeatingSettingHeatingPower(eoj, tid, esv, epc, pdc, edt);
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
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br><br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHeatingSetting(byte[] edt) {
			addProperty(EPC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br><br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Name : Heating mode setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHeatingModeSetting(byte[] edt) {
			addProperty(EPC_HEATING_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br><br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Name : Automatic heating setting<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAutomaticHeatingSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br><br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Name : Automatic heating level setting<br>EPC : 0xE2<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAutomaticHeatingLevelSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br><br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Name : Automatic heating menu setting<br>EPC : 0xD0<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAutomaticHeatingMenuSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Name : Oven mode setting<br>EPC : 0xD1<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOvenModeSetting(byte[] edt) {
			addProperty(EPC_OVEN_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br><br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Name : Oven preheating setting<br>EPC : 0xD5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOvenPreheatingSetting(byte[] edt) {
			addProperty(EPC_OVEN_PREHEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Name : Fermenting mode setting<br>EPC : 0xD6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetFermentingModeSetting(byte[] edt) {
			addProperty(EPC_FERMENTING_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Name : Chamber temperature setting<br>EPC : 0xE3<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetChamberTemperatureSetting(byte[] edt) {
			addProperty(EPC_CHAMBER_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Name : Food temperature setting<br>EPC : 0xE4<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetFoodTemperatureSetting(byte[] edt) {
			addProperty(EPC_FOOD_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Heating time setting<br>EPC : 0xE5<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHeatingTimeSetting(byte[] edt) {
			addProperty(EPC_HEATING_TIME_SETTING, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Remaining heating time setting<br>EPC : 0xE6<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRemainingHeatingTimeSetting(byte[] edt) {
			addProperty(EPC_REMAINING_HEATING_TIME_SETTING, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Microwave heating power setting<br>EPC : 0xE7<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetMicrowaveHeatingPowerSetting(byte[] edt) {
			addProperty(EPC_MICROWAVE_HEATING_POWER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br><br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Name : Prompt message setting<br>EPC : 0xE8<br>Data Type : <br>Data Size(Byte) : 8<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetPromptMessageSetting(byte[] edt) {
			addProperty(EPC_PROMPT_MESSAGE_SETTING, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br><br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Name : �gAccessories to combination microwave oven�h setting<br>EPC : 0xE9<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGaccessoriesToCombinationMicrowaveOvenHSetting(byte[] edt) {
			addProperty(EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven.<br><br>Shift-JIS code characters x 20<br><br>Name : Display character string setting<br>EPC : 0xEA<br>Data Type : <br>Data Size(Byte) : 40<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : undefined<br>
		 */
		public Setter reqSetDisplayCharacterStringSetting(byte[] edt) {
			addProperty(EPC_DISPLAY_CHARACTER_STRING_SETTING, edt, (edt != null && (edt.length == 40)));
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br><br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Two-stage microwave heating setting (duration)<br>EPC : 0xEB<br>Data Type : <br>Data Size(Byte) : 6<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTwoStageMicrowaveHeatingSettingDuration(byte[] edt) {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br><br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Two-stage microwave heating setting (heating power)<br>EPC : 0xEC<br>Data Type : <br>Data Size(Byte) : 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt) {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER, edt, (edt != null && (edt.length == 4)));
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
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br><br>Door open = 0x41, door closed = 0x42<br><br>Name : Door open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetDoorOpenCloseStatus() {
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Used to acquire the status of the combination microwave oven.<br><br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47<br><br>Name : Heating status<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br><br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHeatingSetting() {
			addProperty(EPC_HEATING_SETTING);
			return this;
		}
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br><br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Name : Heating mode setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHeatingModeSetting() {
			addProperty(EPC_HEATING_MODE_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br><br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Name : Automatic heating setting<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAutomaticHeatingSetting() {
			addProperty(EPC_AUTOMATIC_HEATING_SETTING);
			return this;
		}
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br><br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Name : Automatic heating level setting<br>EPC : 0xE2<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAutomaticHeatingLevelSetting() {
			addProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING);
			return this;
		}
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br><br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Name : Automatic heating menu setting<br>EPC : 0xD0<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAutomaticHeatingMenuSetting() {
			addProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING);
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Name : Oven mode setting<br>EPC : 0xD1<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOvenModeSetting() {
			addProperty(EPC_OVEN_MODE_SETTING);
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br><br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Name : Oven preheating setting<br>EPC : 0xD5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOvenPreheatingSetting() {
			addProperty(EPC_OVEN_PREHEATING_SETTING);
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Name : Fermenting mode setting<br>EPC : 0xD6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetFermentingModeSetting() {
			addProperty(EPC_FERMENTING_MODE_SETTING);
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Name : Chamber temperature setting<br>EPC : 0xE3<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetChamberTemperatureSetting() {
			addProperty(EPC_CHAMBER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Name : Food temperature setting<br>EPC : 0xE4<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetFoodTemperatureSetting() {
			addProperty(EPC_FOOD_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Heating time setting<br>EPC : 0xE5<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHeatingTimeSetting() {
			addProperty(EPC_HEATING_TIME_SETTING);
			return this;
		}
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Remaining heating time setting<br>EPC : 0xE6<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRemainingHeatingTimeSetting() {
			addProperty(EPC_REMAINING_HEATING_TIME_SETTING);
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Microwave heating power setting<br>EPC : 0xE7<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetMicrowaveHeatingPowerSetting() {
			addProperty(EPC_MICROWAVE_HEATING_POWER_SETTING);
			return this;
		}
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br><br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Name : Prompt message setting<br>EPC : 0xE8<br>Data Type : <br>Data Size(Byte) : 8<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetPromptMessageSetting() {
			addProperty(EPC_PROMPT_MESSAGE_SETTING);
			return this;
		}
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br><br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Name : �gAccessories to combination microwave oven�h setting<br>EPC : 0xE9<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGaccessoriesToCombinationMicrowaveOvenHSetting() {
			addProperty(EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING);
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br><br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Two-stage microwave heating setting (duration)<br>EPC : 0xEB<br>Data Type : <br>Data Size(Byte) : 6<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTwoStageMicrowaveHeatingSettingDuration() {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION);
			return this;
		}
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br><br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Two-stage microwave heating setting (heating power)<br>EPC : 0xEC<br>Data Type : <br>Data Size(Byte) : 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTwoStageMicrowaveHeatingSettingHeatingPower() {
			addProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER);
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
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven.<br><br>Door open = 0x41, door closed = 0x42<br><br>Name : Door open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformDoorOpenCloseStatus();
		/**
		 * Used to acquire the status of the combination microwave oven.<br><br>Initial state = 0x40 Heating = 0x41 Heating suspended = 0x42 Reporting completion of heating cycle = 0x43 Setting = 0x44 Preheating = 0x45 Preheat temperature maintenance = 0x46 Heating temporarily stopped for manual cooking action = 0x47<br><br>Name : Heating status<br>EPC : 0xB1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformHeatingStatus();
		/**
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status).<br><br>Start/restart heating (heating started/restarted) = 0x41 Suspend heating (heating suspended) = 0x42 Stop heating (heating stopped) = 0x43<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHeatingSetting();
		/**
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode).<br><br>Microwave heating = 0x41 Defrosting = 0x42 Oven = 0x43 Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48 Two-stage microwave heating = 0x51 No mode specified = 0xFF<br><br>Name : Heating mode setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHeatingModeSetting();
		/**
		 * Used to specify whether or not to use the combination microwave oven�fs automatic heating mode, and to acquire the current setting.<br><br>Automatic = 0x41 Manual = 0x42 Not specified = 0xFF<br><br>Name : Automatic heating setting<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAutomaticHeatingSetting();
		/**
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the �gautomatic heating menu setting�h property, and to acquire the current setting.<br><br>0x31 to 0x35 (lowest to highest) Not specified = 0xFF<br><br>Name : Automatic heating level setting<br>EPC : 0xE2<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAutomaticHeatingLevelSetting();
		/**
		 * Used, when the value of the �gautomatic heating setting�h property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting.<br><br>0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled �gAutomatic heating menu setting.�h) No automatic heating cycle specified = 0xFF<br><br>Name : Automatic heating menu setting<br>EPC : 0xD0<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAutomaticHeatingMenuSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43 No sub-mode specified = 0xFF<br><br>Name : Oven mode setting<br>EPC : 0xD1<br>Data Type : unsigned cha<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOvenModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting.<br><br>With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br><br>Name : Oven preheating setting<br>EPC : 0xD5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOvenPreheatingSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting.<br><br>Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br><br>Name : Fermenting mode setting<br>EPC : 0xD6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformFermentingModeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��C) 0x8001: Automatic 0x8002: Not specified<br><br>Name : Chamber temperature setting<br>EPC : 0xE3<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformChamberTemperatureSetting();
		/**
		 * Used to specify the as-heated food temperature in 0.1��C increments, and to acquire the current setting.<br><br>0xF554 to 0x7FFE (-273.2 to 3276.6��) 0x8002: Not specified<br><br>Name : Food temperature setting<br>EPC : 0xE4<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformFoodTemperatureSetting();
		/**
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Heating time setting<br>EPC : 0xE5<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHeatingTimeSetting();
		/**
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23) (= 0 to 59) (= 0 to 59)<br><br>Name : Remaining heating time setting<br>EPC : 0xE6<br>Data Type : <br>Data Size(Byte) : 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRemainingHeatingTimeSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x46 (= fermenting) and the value of the �gfermenting mode setting�h property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the current setting.<br><br>0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Microwave heating power setting<br>EPC : 0xE7<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformMicrowaveHeatingPowerSetting();
		/**
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified.<br><br>First byte: Prompt message code (See the prompt message code table in the subsection entitled �gPrompt message setting.�h) Second byte: Timing value (0 to 0x64 (0 to 100%))<br><br>Name : Prompt message setting<br>EPC : 0xE8<br>Data Type : <br>Data Size(Byte) : 8<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformPromptMessageSetting();
		/**
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting.<br><br>The value contained in a bit in the bit map shall be �g1�h if the accessory represented by that bit is used and �g0�h if the accessory represented by that bit is not used (See the bitmap composition table in the subsection entitled �g�fAccessories to combination microwave oven�f setting�h).<br><br>Name : �gAccessories to combination microwave oven�h setting<br>EPC : 0xE9<br>Data Type : <br>Data Size(Byte) : 2<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGaccessoriesToCombinationMicrowaveOvenHSetting();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively.<br><br>Duration of first microwave heating cycle (first through third bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59) Duration of second microwave heating cycle (fourth through sixth bytes): 0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Two-stage microwave heating setting (duration)<br>EPC : 0xEB<br>Data Type : <br>Data Size(Byte) : 6<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTwoStageMicrowaveHeatingSettingDuration();
		/**
		 * Used, when the value of the �gheating mode setting�h property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the heating power for the first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively.<br><br>Heating power for first microwave heating cycle (first and second bytes): 0x0000 to 0xFFFD (0 to 65533W) Heating power for second microwave heating cycle (third and fourth bytes): 0x0000 to 0xFFFD (0 to 65533W)<br><br>Name : Two-stage microwave heating setting (heating power)<br>EPC : 0xEC<br>Data Type : <br>Data Size(Byte) : 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTwoStageMicrowaveHeatingSettingHeatingPower();
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
		public Informer reqInformDoorOpenCloseStatus() {
			byte epc = EPC_DOOR_OPEN_CLOSE_STATUS;
			byte[] edt = _getDoorOpenCloseStatus(epc);
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
		public Informer reqInformHeatingSetting() {
			byte epc = EPC_HEATING_SETTING;
			byte[] edt = _getHeatingSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatingModeSetting() {
			byte epc = EPC_HEATING_MODE_SETTING;
			byte[] edt = _getHeatingModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticHeatingSetting() {
			byte epc = EPC_AUTOMATIC_HEATING_SETTING;
			byte[] edt = _getAutomaticHeatingSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticHeatingLevelSetting() {
			byte epc = EPC_AUTOMATIC_HEATING_LEVEL_SETTING;
			byte[] edt = _getAutomaticHeatingLevelSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticHeatingMenuSetting() {
			byte epc = EPC_AUTOMATIC_HEATING_MENU_SETTING;
			byte[] edt = _getAutomaticHeatingMenuSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOvenModeSetting() {
			byte epc = EPC_OVEN_MODE_SETTING;
			byte[] edt = _getOvenModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOvenPreheatingSetting() {
			byte epc = EPC_OVEN_PREHEATING_SETTING;
			byte[] edt = _getOvenPreheatingSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFermentingModeSetting() {
			byte epc = EPC_FERMENTING_MODE_SETTING;
			byte[] edt = _getFermentingModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformChamberTemperatureSetting() {
			byte epc = EPC_CHAMBER_TEMPERATURE_SETTING;
			byte[] edt = _getChamberTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformFoodTemperatureSetting() {
			byte epc = EPC_FOOD_TEMPERATURE_SETTING;
			byte[] edt = _getFoodTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformHeatingTimeSetting() {
			byte epc = EPC_HEATING_TIME_SETTING;
			byte[] edt = _getHeatingTimeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformRemainingHeatingTimeSetting() {
			byte epc = EPC_REMAINING_HEATING_TIME_SETTING;
			byte[] edt = _getRemainingHeatingTimeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformMicrowaveHeatingPowerSetting() {
			byte epc = EPC_MICROWAVE_HEATING_POWER_SETTING;
			byte[] edt = _getMicrowaveHeatingPowerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformPromptMessageSetting() {
			byte epc = EPC_PROMPT_MESSAGE_SETTING;
			byte[] edt = _getPromptMessageSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 8)));
			return this;
		}
		@Override
		public Informer reqInformGaccessoriesToCombinationMicrowaveOvenHSetting() {
			byte epc = EPC_GACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_H_SETTING;
			byte[] edt = _getGaccessoriesToCombinationMicrowaveOvenHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformTwoStageMicrowaveHeatingSettingDuration() {
			byte epc = EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION;
			byte[] edt = _getTwoStageMicrowaveHeatingSettingDuration(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformTwoStageMicrowaveHeatingSettingHeatingPower() {
			byte epc = EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER;
			byte[] edt = _getTwoStageMicrowaveHeatingSettingHeatingPower(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
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
