/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Sony Computer Science Laboratories, Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sonycsl.echo.eoj.device.cookinghousehold;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class CombinationMicrowaveOven extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x03B8;

	public static final byte EPC_CHAMBER_TEMPERATURE_SETTING = (byte)0xE3;
	public static final byte EPC_AUTOMATIC_HEATING_LEVEL_SETTING = (byte)0xE2;
	public static final byte EPC_AUTOMATIC_HEATING_SETTING = (byte)0xE1;
	public static final byte EPC_HEATING_MODE_SETTING = (byte)0xE0;
	public static final byte EPC_MICROWAVE_HEATING_POWER_SETTING = (byte)0xE7;
	public static final byte EPC_REMAINING_HEATING_TIME_SETTING = (byte)0xE6;
	public static final byte EPC_HEATING_TIME_SETTING = (byte)0xE5;
	public static final byte EPC__ACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_SETTING = (byte)0xE9;
	public static final byte EPC_PROMPT_MESSAGE_SETTING = (byte)0xE8;
	public static final byte EPC_FOOD_TEMPERATURE_SETTING = (byte)0xE4;
	public static final byte EPC_AUTOMATIC_HEATING_MENU_SETTING = (byte)0xD0;
	public static final byte EPC_OVEN_MODE_SETTING = (byte)0xD1;
	public static final byte EPC_OVEN_PREHEATING_SETTING = (byte)0xD5;
	public static final byte EPC_FERMENTING_MODE_SETTING = (byte)0xD6;
	public static final byte EPC_HEATING_SETTING = (byte)0xB2;
	public static final byte EPC_DOOR_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_HEATING_STATUS = (byte)0xB1;
	public static final byte EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER_ = (byte)0xEC;
	public static final byte EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION_ = (byte)0xEB;
	public static final byte EPC_DISPLAY_CHARACTER_STRING_SETTING = (byte)0xEA;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);

	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewCombinationMicrowaveOven(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Chamber temperature setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1°C increments, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFE (-273.2. 3276.6°C)_x000a_0x8001: Automatic 0x8002: Not specified<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setChamberTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Chamber temperature setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1°C increments, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFE (-273.2. 3276.6°C)_x000a_0x8001: Automatic 0x8002: Not specified<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getChamberTemperatureSetting() {return null;}
	/**
	 * Property name : Chamber temperature setting<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1°C increments, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFE (-273.2. 3276.6°C)_x000a_0x8001: Automatic 0x8002: Not specified<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidChamberTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Automatic heating level setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the “automatic heating menu setting” property, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x35 (lowest to highest) Not specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned cha<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setAutomaticHeatingLevelSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic heating level setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the “automatic heating menu setting” property, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x35 (lowest to highest) Not specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned cha<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getAutomaticHeatingLevelSetting() {return null;}
	/**
	 * Property name : Automatic heating level setting<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the “automatic heating menu setting” property, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31.0x35 (lowest to highest) Not specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned cha<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidAutomaticHeatingLevelSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Automatic heating setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the combination microwave oven’s automatic heating mode, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41_x000a_Manual = 0x42_x000a_Not specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setAutomaticHeatingSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic heating setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the combination microwave oven’s automatic heating mode, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41_x000a_Manual = 0x42_x000a_Not specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getAutomaticHeatingSetting() {return null;}
	/**
	 * Property name : Automatic heating setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the combination microwave oven’s automatic heating mode, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41_x000a_Manual = 0x42_x000a_Not specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidAutomaticHeatingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Heating mode setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode). <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Microwave heating = 0x41 Defrosting = 0x42_x000a_Oven = 0x43_x000a_Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48_x000a_Two-stage microwave heating = 0x51_x000a_No mode specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setHeatingModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Heating mode setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode). <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Microwave heating = 0x41 Defrosting = 0x42_x000a_Oven = 0x43_x000a_Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48_x000a_Two-stage microwave heating = 0x51_x000a_No mode specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getHeatingModeSetting() {return null;}
	/**
	 * Property name : Heating mode setting<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode). <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Microwave heating = 0x41 Defrosting = 0x42_x000a_Oven = 0x43_x000a_Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48_x000a_Two-stage microwave heating = 0x51_x000a_No mode specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidHeatingModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Microwave heating power setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the “heating mode setting” property (EPC_x000a_= 0xE0) is 0x46 (= fermenting) and the value of the “fermenting mode setting”_x000a_property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the_x000a_current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 1_x000a_W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setMicrowaveHeatingPowerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Microwave heating power setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the “heating mode setting” property (EPC_x000a_= 0xE0) is 0x46 (= fermenting) and the value of the “fermenting mode setting”_x000a_property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the_x000a_current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 1_x000a_W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMicrowaveHeatingPowerSetting() {return null;}
	/**
	 * Property name : Microwave heating power setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the “heating mode setting” property (EPC_x000a_= 0xE0) is 0x46 (= fermenting) and the value of the “fermenting mode setting”_x000a_property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the_x000a_current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 1_x000a_W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMicrowaveHeatingPowerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Remaining heating time setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×3<br>
	 * Data size : 3<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setRemainingHeatingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Remaining heating time setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×3<br>
	 * Data size : 3<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getRemainingHeatingTimeSetting() {return null;}
	/**
	 * Property name : Remaining heating time setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×3<br>
	 * Data size : 3<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRemainingHeatingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 3)) {return false;};
		return true;
	}
	/**
	 * Property name : Heating time setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×3<br>
	 * Data size : 3<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setHeatingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Heating time setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×3<br>
	 * Data size : 3<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getHeatingTimeSetting() {return null;}
	/**
	 * Property name : Heating time setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×3<br>
	 * Data size : 3<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidHeatingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 3)) {return false;};
		return true;
	}
	/**
	 * Property name : “Accessories to combination microwave oven” setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The value contained in a bit in the bit map shall be “1” if the accessory represented by that bit is used and “0” if the accessory represented by that bit_x000a_is not used (See the bitmap composition table in the subsection entitled “’Accessories to combination_x000a_microwave oven’ setting”).<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setAccessoriesToCombinationMicrowaveOvenSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Accessories to combination microwave oven” setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The value contained in a bit in the bit map shall be “1” if the accessory represented by that bit is used and “0” if the accessory represented by that bit_x000a_is not used (See the bitmap composition table in the subsection entitled “’Accessories to combination_x000a_microwave oven’ setting”).<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getAccessoriesToCombinationMicrowaveOvenSetting() {return null;}
	/**
	 * Property name : “Accessories to combination microwave oven” setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The value contained in a bit in the bit map shall be “1” if the accessory represented by that bit is used and “0” if the accessory represented by that bit_x000a_is not used (See the bitmap composition table in the subsection entitled “’Accessories to combination_x000a_microwave oven’ setting”).<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidAccessoriesToCombinationMicrowaveOvenSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Prompt message setting<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents :<br>
	 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a  percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Prompt message code (See the prompt message code table in the subsection entitled “Prompt message setting.”)_x000a_Second byte: Timing value (0.0x64) (0.100%))<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2_x000a_×4<br>
	 * Data size : 8<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setPromptMessageSetting(byte[] edt) {return false;}
	/**
	 * Property name : Prompt message setting<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents :<br>
	 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a  percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Prompt message code (See the prompt message code table in the subsection entitled “Prompt message setting.”)_x000a_Second byte: Timing value (0.0x64) (0.100%))<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2_x000a_×4<br>
	 * Data size : 8<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getPromptMessageSetting() {return null;}
	/**
	 * Property name : Prompt message setting<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents :<br>
	 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a  percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: Prompt message code (See the prompt message code table in the subsection entitled “Prompt message setting.”)_x000a_Second byte: Timing value (0.0x64) (0.100%))<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2_x000a_×4<br>
	 * Data size : 8<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidPromptMessageSetting(byte[] edt) {
		if(edt == null || !(edt.length == 8)) {return false;};
		return true;
	}
	/**
	 * Property name : Food temperature setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the as-heated food temperature in 0.1°C increments, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFE (-273.2.3276.6°C)_x000a_0x8002: Not specified<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setFoodTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Food temperature setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the as-heated food temperature in 0.1°C increments, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFE (-273.2.3276.6°C)_x000a_0x8002: Not specified<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getFoodTemperatureSetting() {return null;}
	/**
	 * Property name : Food temperature setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the as-heated food temperature in 0.1°C increments, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xF554.0x7FFE (-273.2.3276.6°C)_x000a_0x8002: Not specified<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidFoodTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This  property  indicates  the  ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This  property  indicates  the  ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This  property  indicates  the  ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Automatic heating menu setting<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “automatic heating setting” property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled “Automatic heating menu setting.”)_x000a_No automatic heating cycle specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned cha<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setAutomaticHeatingMenuSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic heating menu setting<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “automatic heating setting” property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled “Automatic heating menu setting.”)_x000a_No automatic heating cycle specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned cha<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getAutomaticHeatingMenuSetting() {return null;}
	/**
	 * Property name : Automatic heating menu setting<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “automatic heating setting” property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled “Automatic heating menu setting.”)_x000a_No automatic heating cycle specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned cha<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidAutomaticHeatingMenuSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Oven mode setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven), to specify the_x000a_sub-mode to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43_x000a_No sub-mode specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned cha<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOvenModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Oven mode setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven), to specify the_x000a_sub-mode to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43_x000a_No sub-mode specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned cha<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getOvenModeSetting() {return null;}
	/**
	 * Property name : Oven mode setting<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven), to specify the_x000a_sub-mode to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43_x000a_No sub-mode specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned cha<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOvenModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Oven preheating setting<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOvenPreheatingSetting(byte[] edt) {return false;}
	/**
	 * Property name : Oven preheating setting<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getOvenPreheatingSetting() {return null;}
	/**
	 * Property name : Oven preheating setting<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOvenPreheatingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Fermenting mode setting<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setFermentingModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Fermenting mode setting<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getFermentingModeSetting() {return null;}
	/**
	 * Property name : Fermenting mode setting<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidFermentingModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Heating setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status). <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart heating (heating started/restarted) = 0x41_x000a_Suspend heating (heating suspended) = 0x42_x000a_Stop heating (heating stopped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setHeatingSetting(byte[] edt) {return false;}
	/**
	 * Property name : Heating setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status). <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart heating (heating started/restarted) = 0x41_x000a_Suspend heating (heating suspended) = 0x42_x000a_Stop heating (heating stopped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getHeatingSetting() {return null;}
	/**
	 * Property name : Heating setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status). <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart heating (heating started/restarted) = 0x41_x000a_Suspend heating (heating suspended) = 0x42_x000a_Stop heating (heating stopped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidHeatingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Door open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door open = 0x41, door closed = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getDoorOpenCloseStatus() {return null;}
	/**
	 * Property name : Door open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door open = 0x41, door closed = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDoorOpenCloseStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Heating status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the status of the combination microwave oven. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Initial state = 0x40 Heating = 0x41_x000a_Heating suspended = 0x42_x000a_Reporting completion of heating cycle_x000a_= 0x43_x000a_Setting = 0x44 Preheating = 0x45_x000a_Preheat temperature maintenance = 0x46_x000a_Heating temporarily stopped for manual cooking action = 0x47<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getHeatingStatus() {return null;}
	/**
	 * Property name : Heating status<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the status of the combination microwave oven. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Initial state = 0x40 Heating = 0x41_x000a_Heating suspended = 0x42_x000a_Reporting completion of heating cycle_x000a_= 0x43_x000a_Setting = 0x44 Preheating = 0x45_x000a_Preheat temperature maintenance = 0x46_x000a_Heating temporarily stopped for manual cooking action = 0x47<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidHeatingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Two-stage microwave heating setting (heating power)<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x51 (two-stage microwave heating), to specify the heating power for the  first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Heating power for first microwave heating cycle (first and second bytes):_x000a_0x0000.0xFFFD (0.65533W)_x000a_Heating power for second microwave heating cycle (third and fourth bytes):_x000a_0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 1_x000a_W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt) {return false;}
	/**
	 * Property name : Two-stage microwave heating setting (heating power)<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x51 (two-stage microwave heating), to specify the heating power for the  first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Heating power for first microwave heating cycle (first and second bytes):_x000a_0x0000.0xFFFD (0.65533W)_x000a_Heating power for second microwave heating cycle (third and fourth bytes):_x000a_0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 1_x000a_W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getTwoStageMicrowaveHeatingSettingHeatingPower() {return null;}
	/**
	 * Property name : Two-stage microwave heating setting (heating power)<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x51 (two-stage microwave heating), to specify the heating power for the  first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Heating power for first microwave heating cycle (first and second bytes):_x000a_0x0000.0xFFFD (0.65533W)_x000a_Heating power for second microwave heating cycle (third and fourth bytes):_x000a_0x0000.0xFFFD (0.65533W)<br>
	 * <br>
	 * Data type : unsigned short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 1_x000a_W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Two-stage microwave heating setting (duration)<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Duration of first microwave heating cycle (first through third bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)_x000a_Duration of second microwave heating cycle (fourth through sixth bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×3_x000a_×2<br>
	 * Data size : 6<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setTwoStageMicrowaveHeatingSettingDuration(byte[] edt) {return false;}
	/**
	 * Property name : Two-stage microwave heating setting (duration)<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Duration of first microwave heating cycle (first through third bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)_x000a_Duration of second microwave heating cycle (fourth through sixth bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×3_x000a_×2<br>
	 * Data size : 6<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getTwoStageMicrowaveHeatingSettingDuration() {return null;}
	/**
	 * Property name : Two-stage microwave heating setting (duration)<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents :<br>
	 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Duration of first microwave heating cycle (first through third bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)_x000a_Duration of second microwave heating cycle (fourth through sixth bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×3_x000a_×2<br>
	 * Data size : 6<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidTwoStageMicrowaveHeatingSettingDuration(byte[] edt) {
		if(edt == null || !(edt.length == 6)) {return false;};
		return true;
	}
	/**
	 * Property name : Display character string setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents :<br>
	 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Shift-JIS code characters × 20<br>
	 * <br>
	 * Data type : unsigned short_x000a_×20<br>
	 * Data size : 40<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - -<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setDisplayCharacterStringSetting(byte[] edt) {return false;}
	/**
	 * Property name : Display character string setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents :<br>
	 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Shift-JIS code characters × 20<br>
	 * <br>
	 * Data type : unsigned short_x000a_×20<br>
	 * Data size : 40<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - -<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDisplayCharacterStringSetting(byte[] edt) {
		if(edt == null || !(edt.length == 40)) {return false;};
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_CHAMBER_TEMPERATURE_SETTING : return setChamberTemperatureSetting(property.edt);
		case EPC_AUTOMATIC_HEATING_LEVEL_SETTING : return setAutomaticHeatingLevelSetting(property.edt);
		case EPC_AUTOMATIC_HEATING_SETTING : return setAutomaticHeatingSetting(property.edt);
		case EPC_HEATING_MODE_SETTING : return setHeatingModeSetting(property.edt);
		case EPC_MICROWAVE_HEATING_POWER_SETTING : return setMicrowaveHeatingPowerSetting(property.edt);
		case EPC_REMAINING_HEATING_TIME_SETTING : return setRemainingHeatingTimeSetting(property.edt);
		case EPC_HEATING_TIME_SETTING : return setHeatingTimeSetting(property.edt);
		case EPC__ACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_SETTING : return setAccessoriesToCombinationMicrowaveOvenSetting(property.edt);
		case EPC_PROMPT_MESSAGE_SETTING : return setPromptMessageSetting(property.edt);
		case EPC_FOOD_TEMPERATURE_SETTING : return setFoodTemperatureSetting(property.edt);
		case EPC_AUTOMATIC_HEATING_MENU_SETTING : return setAutomaticHeatingMenuSetting(property.edt);
		case EPC_OVEN_MODE_SETTING : return setOvenModeSetting(property.edt);
		case EPC_OVEN_PREHEATING_SETTING : return setOvenPreheatingSetting(property.edt);
		case EPC_FERMENTING_MODE_SETTING : return setFermentingModeSetting(property.edt);
		case EPC_HEATING_SETTING : return setHeatingSetting(property.edt);
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER_ : return setTwoStageMicrowaveHeatingSettingHeatingPower(property.edt);
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION_ : return setTwoStageMicrowaveHeatingSettingDuration(property.edt);
		case EPC_DISPLAY_CHARACTER_STRING_SETTING : return setDisplayCharacterStringSetting(property.edt);

		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_CHAMBER_TEMPERATURE_SETTING : return getChamberTemperatureSetting();
		case EPC_AUTOMATIC_HEATING_LEVEL_SETTING : return getAutomaticHeatingLevelSetting();
		case EPC_AUTOMATIC_HEATING_SETTING : return getAutomaticHeatingSetting();
		case EPC_HEATING_MODE_SETTING : return getHeatingModeSetting();
		case EPC_MICROWAVE_HEATING_POWER_SETTING : return getMicrowaveHeatingPowerSetting();
		case EPC_REMAINING_HEATING_TIME_SETTING : return getRemainingHeatingTimeSetting();
		case EPC_HEATING_TIME_SETTING : return getHeatingTimeSetting();
		case EPC__ACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_SETTING : return getAccessoriesToCombinationMicrowaveOvenSetting();
		case EPC_PROMPT_MESSAGE_SETTING : return getPromptMessageSetting();
		case EPC_FOOD_TEMPERATURE_SETTING : return getFoodTemperatureSetting();
		case EPC_AUTOMATIC_HEATING_MENU_SETTING : return getAutomaticHeatingMenuSetting();
		case EPC_OVEN_MODE_SETTING : return getOvenModeSetting();
		case EPC_OVEN_PREHEATING_SETTING : return getOvenPreheatingSetting();
		case EPC_FERMENTING_MODE_SETTING : return getFermentingModeSetting();
		case EPC_HEATING_SETTING : return getHeatingSetting();
		case EPC_DOOR_OPEN_CLOSE_STATUS : return getDoorOpenCloseStatus();
		case EPC_HEATING_STATUS : return getHeatingStatus();
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER_ : return getTwoStageMicrowaveHeatingSettingHeatingPower();
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION_ : return getTwoStageMicrowaveHeatingSettingDuration();

		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_CHAMBER_TEMPERATURE_SETTING : return isValidChamberTemperatureSetting(property.edt);
		case EPC_AUTOMATIC_HEATING_LEVEL_SETTING : return isValidAutomaticHeatingLevelSetting(property.edt);
		case EPC_AUTOMATIC_HEATING_SETTING : return isValidAutomaticHeatingSetting(property.edt);
		case EPC_HEATING_MODE_SETTING : return isValidHeatingModeSetting(property.edt);
		case EPC_MICROWAVE_HEATING_POWER_SETTING : return isValidMicrowaveHeatingPowerSetting(property.edt);
		case EPC_REMAINING_HEATING_TIME_SETTING : return isValidRemainingHeatingTimeSetting(property.edt);
		case EPC_HEATING_TIME_SETTING : return isValidHeatingTimeSetting(property.edt);
		case EPC__ACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_SETTING : return isValidAccessoriesToCombinationMicrowaveOvenSetting(property.edt);
		case EPC_PROMPT_MESSAGE_SETTING : return isValidPromptMessageSetting(property.edt);
		case EPC_FOOD_TEMPERATURE_SETTING : return isValidFoodTemperatureSetting(property.edt);
		case EPC_AUTOMATIC_HEATING_MENU_SETTING : return isValidAutomaticHeatingMenuSetting(property.edt);
		case EPC_OVEN_MODE_SETTING : return isValidOvenModeSetting(property.edt);
		case EPC_OVEN_PREHEATING_SETTING : return isValidOvenPreheatingSetting(property.edt);
		case EPC_FERMENTING_MODE_SETTING : return isValidFermentingModeSetting(property.edt);
		case EPC_HEATING_SETTING : return isValidHeatingSetting(property.edt);
		case EPC_DOOR_OPEN_CLOSE_STATUS : return isValidDoorOpenCloseStatus(property.edt);
		case EPC_HEATING_STATUS : return isValidHeatingStatus(property.edt);
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER_ : return isValidTwoStageMicrowaveHeatingSettingHeatingPower(property.edt);
		case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION_ : return isValidTwoStageMicrowaveHeatingSettingDuration(property.edt);
		case EPC_DISPLAY_CHARACTER_STRING_SETTING : return isValidDisplayCharacterStringSetting(property.edt);

		default : return false;
		}
	}

	@Override
	public Setter set() {
		return set(true);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr(), responseRequired);
	}

	@Override
	public Getter get() {
		return new Getter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr());
	}

	@Override
	public Informer inform() {
		return inform(isSelfObject());
	}

	@Override
	protected Informer inform(boolean multicast) {
		String address;
		if(multicast) {
			address = EchoSocket.MULTICAST_ADDRESS;
		} else {
			address = getNode().getAddressStr();
		}
		return new Informer(getEchoClassCode(), getInstanceCode()
				, address, isSelfObject());
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_CHAMBER_TEMPERATURE_SETTING : 
				onSetChamberTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_HEATING_LEVEL_SETTING : 
				onSetAutomaticHeatingLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_HEATING_SETTING : 
				onSetAutomaticHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_MODE_SETTING : 
				onSetHeatingModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MICROWAVE_HEATING_POWER_SETTING : 
				onSetMicrowaveHeatingPowerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_HEATING_TIME_SETTING : 
				onSetRemainingHeatingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_TIME_SETTING : 
				onSetHeatingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC__ACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_SETTING : 
				onSetAccessoriesToCombinationMicrowaveOvenSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_PROMPT_MESSAGE_SETTING : 
				onSetPromptMessageSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FOOD_TEMPERATURE_SETTING : 
				onSetFoodTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_HEATING_MENU_SETTING : 
				onSetAutomaticHeatingMenuSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OVEN_MODE_SETTING : 
				onSetOvenModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OVEN_PREHEATING_SETTING : 
				onSetOvenPreheatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FERMENTING_MODE_SETTING : 
				onSetFermentingModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_SETTING : 
				onSetHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER_ : 
				onSetTwoStageMicrowaveHeatingSettingHeatingPower(eoj, tid, esv, property, success);
				return true;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION_ : 
				onSetTwoStageMicrowaveHeatingSettingDuration(eoj, tid, esv, property, success);
				return true;
			case EPC_DISPLAY_CHARACTER_STRING_SETTING : 
				onSetDisplayCharacterStringSetting(eoj, tid, esv, property, success);
				return true;

			default :
				return false;
			}
		}

		@Override
		protected boolean onGetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onGetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_CHAMBER_TEMPERATURE_SETTING : 
				onGetChamberTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_HEATING_LEVEL_SETTING : 
				onGetAutomaticHeatingLevelSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_HEATING_SETTING : 
				onGetAutomaticHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_MODE_SETTING : 
				onGetHeatingModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MICROWAVE_HEATING_POWER_SETTING : 
				onGetMicrowaveHeatingPowerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_HEATING_TIME_SETTING : 
				onGetRemainingHeatingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_TIME_SETTING : 
				onGetHeatingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC__ACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_SETTING : 
				onGetAccessoriesToCombinationMicrowaveOvenSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_PROMPT_MESSAGE_SETTING : 
				onGetPromptMessageSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FOOD_TEMPERATURE_SETTING : 
				onGetFoodTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_HEATING_MENU_SETTING : 
				onGetAutomaticHeatingMenuSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OVEN_MODE_SETTING : 
				onGetOvenModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OVEN_PREHEATING_SETTING : 
				onGetOvenPreheatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FERMENTING_MODE_SETTING : 
				onGetFermentingModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_SETTING : 
				onGetHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DOOR_OPEN_CLOSE_STATUS : 
				onGetDoorOpenCloseStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATING_STATUS : 
				onGetHeatingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER_ : 
				onGetTwoStageMicrowaveHeatingSettingHeatingPower(eoj, tid, esv, property, success);
				return true;
			case EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION_ : 
				onGetTwoStageMicrowaveHeatingSettingDuration(eoj, tid, esv, property, success);
				return true;

			default :
				return false;
			}
		}
		
		/**
		 * Property name : Chamber temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2. 3276.6°C)_x000a_0x8001: Automatic 0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetChamberTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Chamber temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2. 3276.6°C)_x000a_0x8001: Automatic 0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetChamberTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic heating level setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the “automatic heating menu setting” property, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x35 (lowest to highest) Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic heating level setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the “automatic heating menu setting” property, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x35 (lowest to highest) Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetAutomaticHeatingLevelSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic heating setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the combination microwave oven’s automatic heating mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41_x000a_Manual = 0x42_x000a_Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetAutomaticHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic heating setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the combination microwave oven’s automatic heating mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41_x000a_Manual = 0x42_x000a_Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetAutomaticHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating mode setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Microwave heating = 0x41 Defrosting = 0x42_x000a_Oven = 0x43_x000a_Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48_x000a_Two-stage microwave heating = 0x51_x000a_No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetHeatingModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating mode setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Microwave heating = 0x41 Defrosting = 0x42_x000a_Oven = 0x43_x000a_Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48_x000a_Two-stage microwave heating = 0x51_x000a_No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetHeatingModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Microwave heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the “heating mode setting” property (EPC_x000a_= 0xE0) is 0x46 (= fermenting) and the value of the “fermenting mode setting”_x000a_property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Microwave heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the “heating mode setting” property (EPC_x000a_= 0xE0) is 0x46 (= fermenting) and the value of the “fermenting mode setting”_x000a_property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMicrowaveHeatingPowerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining heating time setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetRemainingHeatingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining heating time setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRemainingHeatingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetHeatingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetHeatingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Accessories to combination microwave oven” setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The value contained in a bit in the bit map shall be “1” if the accessory represented by that bit is used and “0” if the accessory represented by that bit_x000a_is not used (See the bitmap composition table in the subsection entitled “’Accessories to combination_x000a_microwave oven’ setting”).<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetAccessoriesToCombinationMicrowaveOvenSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Accessories to combination microwave oven” setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The value contained in a bit in the bit map shall be “1” if the accessory represented by that bit is used and “0” if the accessory represented by that bit_x000a_is not used (See the bitmap composition table in the subsection entitled “’Accessories to combination_x000a_microwave oven’ setting”).<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetAccessoriesToCombinationMicrowaveOvenSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Prompt message setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a  percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Prompt message code (See the prompt message code table in the subsection entitled “Prompt message setting.”)_x000a_Second byte: Timing value (0.0x64) (0.100%))<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2_x000a_×4<br>
		 * Data size : 8<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetPromptMessageSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Prompt message setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a  percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Prompt message code (See the prompt message code table in the subsection entitled “Prompt message setting.”)_x000a_Second byte: Timing value (0.0x64) (0.100%))<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2_x000a_×4<br>
		 * Data size : 8<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetPromptMessageSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Food temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the as-heated food temperature in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2.3276.6°C)_x000a_0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetFoodTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Food temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the as-heated food temperature in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2.3276.6°C)_x000a_0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetFoodTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status<br>
		 * <br>
		 * EPC : 0x80<br>
		 * <br>
		 * Contents :<br>
		 * This  property  indicates  the  ON/OFF status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x30, OFF=0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status<br>
		 * <br>
		 * EPC : 0x80<br>
		 * <br>
		 * Contents :<br>
		 * This  property  indicates  the  ON/OFF status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x30, OFF=0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic heating menu setting<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “automatic heating setting” property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled “Automatic heating menu setting.”)_x000a_No automatic heating cycle specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic heating menu setting<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “automatic heating setting” property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled “Automatic heating menu setting.”)_x000a_No automatic heating cycle specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetAutomaticHeatingMenuSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Oven mode setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven), to specify the_x000a_sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43_x000a_No sub-mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOvenModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Oven mode setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven), to specify the_x000a_sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43_x000a_No sub-mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOvenModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Oven preheating setting<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOvenPreheatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Oven preheating setting<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOvenPreheatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Fermenting mode setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetFermentingModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Fermenting mode setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetFermentingModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart heating (heating started/restarted) = 0x41_x000a_Suspend heating (heating suspended) = 0x42_x000a_Stop heating (heating stopped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart heating (heating started/restarted) = 0x41_x000a_Suspend heating (heating suspended) = 0x42_x000a_Stop heating (heating stopped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Door open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door open = 0x41, door closed = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heating status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the status of the combination microwave oven. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Initial state = 0x40 Heating = 0x41_x000a_Heating suspended = 0x42_x000a_Reporting completion of heating cycle_x000a_= 0x43_x000a_Setting = 0x44 Preheating = 0x45_x000a_Preheat temperature maintenance = 0x46_x000a_Heating temporarily stopped for manual cooking action = 0x47<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Two-stage microwave heating setting (heating power)<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x51 (two-stage microwave heating), to specify the heating power for the  first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power for first microwave heating cycle (first and second bytes):_x000a_0x0000.0xFFFD (0.65533W)_x000a_Heating power for second microwave heating cycle (third and fourth bytes):_x000a_0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Two-stage microwave heating setting (heating power)<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x51 (two-stage microwave heating), to specify the heating power for the  first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power for first microwave heating cycle (first and second bytes):_x000a_0x0000.0xFFFD (0.65533W)_x000a_Heating power for second microwave heating cycle (third and fourth bytes):_x000a_0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetTwoStageMicrowaveHeatingSettingHeatingPower(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Two-stage microwave heating setting (duration)<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Duration of first microwave heating cycle (first through third bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)_x000a_Duration of second microwave heating cycle (fourth through sixth bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3_x000a_×2<br>
		 * Data size : 6<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Two-stage microwave heating setting (duration)<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Duration of first microwave heating cycle (first through third bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)_x000a_Duration of second microwave heating cycle (fourth through sixth bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3_x000a_×2<br>
		 * Data size : 6<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetTwoStageMicrowaveHeatingSettingDuration(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Display character string setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shift-JIS code characters × 20<br>
		 * <br>
		 * Data type : unsigned short_x000a_×20<br>
		 * Data size : 40<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - -<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetDisplayCharacterStringSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress, responseRequired);
		}
		
		@Override
		public Setter reqSetProperty(byte epc, byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
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
		public Setter reqSetRemoteControlSetting(byte[] edt) {
			return (Setter)super.reqSetRemoteControlSetting(edt);
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
		 * Property name : Chamber temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2. 3276.6°C)_x000a_0x8001: Automatic 0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetChamberTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_CHAMBER_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Automatic heating level setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the “automatic heating menu setting” property, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x35 (lowest to highest) Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetAutomaticHeatingLevelSetting(byte[] edt) {
			reqSetProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Automatic heating setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the combination microwave oven’s automatic heating mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41_x000a_Manual = 0x42_x000a_Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetAutomaticHeatingSetting(byte[] edt) {
			reqSetProperty(EPC_AUTOMATIC_HEATING_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Heating mode setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Microwave heating = 0x41 Defrosting = 0x42_x000a_Oven = 0x43_x000a_Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48_x000a_Two-stage microwave heating = 0x51_x000a_No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetHeatingModeSetting(byte[] edt) {
			reqSetProperty(EPC_HEATING_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Microwave heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the “heating mode setting” property (EPC_x000a_= 0xE0) is 0x46 (= fermenting) and the value of the “fermenting mode setting”_x000a_property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetMicrowaveHeatingPowerSetting(byte[] edt) {
			reqSetProperty(EPC_MICROWAVE_HEATING_POWER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Remaining heating time setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetRemainingHeatingTimeSetting(byte[] edt) {
			reqSetProperty(EPC_REMAINING_HEATING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Heating time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetHeatingTimeSetting(byte[] edt) {
			reqSetProperty(EPC_HEATING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Accessories to combination microwave oven” setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The value contained in a bit in the bit map shall be “1” if the accessory represented by that bit is used and “0” if the accessory represented by that bit_x000a_is not used (See the bitmap composition table in the subsection entitled “’Accessories to combination_x000a_microwave oven’ setting”).<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetAccessoriesToCombinationMicrowaveOvenSetting(byte[] edt) {
			reqSetProperty(EPC__ACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Prompt message setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a  percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Prompt message code (See the prompt message code table in the subsection entitled “Prompt message setting.”)_x000a_Second byte: Timing value (0.0x64) (0.100%))<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2_x000a_×4<br>
		 * Data size : 8<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetPromptMessageSetting(byte[] edt) {
			reqSetProperty(EPC_PROMPT_MESSAGE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Food temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the as-heated food temperature in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2.3276.6°C)_x000a_0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetFoodTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_FOOD_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Automatic heating menu setting<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “automatic heating setting” property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled “Automatic heating menu setting.”)_x000a_No automatic heating cycle specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetAutomaticHeatingMenuSetting(byte[] edt) {
			reqSetProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Oven mode setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven), to specify the_x000a_sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43_x000a_No sub-mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOvenModeSetting(byte[] edt) {
			reqSetProperty(EPC_OVEN_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Oven preheating setting<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOvenPreheatingSetting(byte[] edt) {
			reqSetProperty(EPC_OVEN_PREHEATING_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Fermenting mode setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetFermentingModeSetting(byte[] edt) {
			reqSetProperty(EPC_FERMENTING_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart heating (heating started/restarted) = 0x41_x000a_Suspend heating (heating suspended) = 0x42_x000a_Stop heating (heating stopped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetHeatingSetting(byte[] edt) {
			reqSetProperty(EPC_HEATING_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Two-stage microwave heating setting (heating power)<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x51 (two-stage microwave heating), to specify the heating power for the  first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power for first microwave heating cycle (first and second bytes):_x000a_0x0000.0xFFFD (0.65533W)_x000a_Heating power for second microwave heating cycle (third and fourth bytes):_x000a_0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetTwoStageMicrowaveHeatingSettingHeatingPower(byte[] edt) {
			reqSetProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER_, edt);
			return this;
		}
		/**
		 * Property name : Two-stage microwave heating setting (duration)<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Duration of first microwave heating cycle (first through third bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)_x000a_Duration of second microwave heating cycle (fourth through sixth bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3_x000a_×2<br>
		 * Data size : 6<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetTwoStageMicrowaveHeatingSettingDuration(byte[] edt) {
			reqSetProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION_, edt);
			return this;
		}
		/**
		 * Property name : Display character string setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * Used to input character strings (up to 20 characters) to use on the display of the combination microwave oven. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shift-JIS code characters × 20<br>
		 * <br>
		 * Data type : unsigned short_x000a_×20<br>
		 * Data size : 40<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - -<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetDisplayCharacterStringSetting(byte[] edt) {
			reqSetProperty(EPC_DISPLAY_CHARACTER_STRING_SETTING, edt);
			return this;
		}

	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress);
		}
		
		@Override
		public Getter reqGetProperty(byte epc) {
			return (Getter)super.reqGetProperty(epc);
		}
		
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
		public Getter reqGetRemoteControlSetting() {
			return (Getter)super.reqGetRemoteControlSetting();
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
		 * Property name : Chamber temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2. 3276.6°C)_x000a_0x8001: Automatic 0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetChamberTemperatureSetting() {
			reqGetProperty(EPC_CHAMBER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic heating level setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the “automatic heating menu setting” property, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x35 (lowest to highest) Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetAutomaticHeatingLevelSetting() {
			reqGetProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic heating setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the combination microwave oven’s automatic heating mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41_x000a_Manual = 0x42_x000a_Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetAutomaticHeatingSetting() {
			reqGetProperty(EPC_AUTOMATIC_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Heating mode setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Microwave heating = 0x41 Defrosting = 0x42_x000a_Oven = 0x43_x000a_Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48_x000a_Two-stage microwave heating = 0x51_x000a_No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetHeatingModeSetting() {
			reqGetProperty(EPC_HEATING_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Microwave heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the “heating mode setting” property (EPC_x000a_= 0xE0) is 0x46 (= fermenting) and the value of the “fermenting mode setting”_x000a_property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMicrowaveHeatingPowerSetting() {
			reqGetProperty(EPC_MICROWAVE_HEATING_POWER_SETTING);
			return this;
		}
		/**
		 * Property name : Remaining heating time setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRemainingHeatingTimeSetting() {
			reqGetProperty(EPC_REMAINING_HEATING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Heating time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetHeatingTimeSetting() {
			reqGetProperty(EPC_HEATING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : “Accessories to combination microwave oven” setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The value contained in a bit in the bit map shall be “1” if the accessory represented by that bit is used and “0” if the accessory represented by that bit_x000a_is not used (See the bitmap composition table in the subsection entitled “’Accessories to combination_x000a_microwave oven’ setting”).<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetAccessoriesToCombinationMicrowaveOvenSetting() {
			reqGetProperty(EPC__ACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_SETTING);
			return this;
		}
		/**
		 * Property name : Prompt message setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a  percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Prompt message code (See the prompt message code table in the subsection entitled “Prompt message setting.”)_x000a_Second byte: Timing value (0.0x64) (0.100%))<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2_x000a_×4<br>
		 * Data size : 8<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetPromptMessageSetting() {
			reqGetProperty(EPC_PROMPT_MESSAGE_SETTING);
			return this;
		}
		/**
		 * Property name : Food temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the as-heated food temperature in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2.3276.6°C)_x000a_0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetFoodTemperatureSetting() {
			reqGetProperty(EPC_FOOD_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic heating menu setting<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “automatic heating setting” property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled “Automatic heating menu setting.”)_x000a_No automatic heating cycle specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetAutomaticHeatingMenuSetting() {
			reqGetProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING);
			return this;
		}
		/**
		 * Property name : Oven mode setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven), to specify the_x000a_sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43_x000a_No sub-mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOvenModeSetting() {
			reqGetProperty(EPC_OVEN_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Oven preheating setting<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOvenPreheatingSetting() {
			reqGetProperty(EPC_OVEN_PREHEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Fermenting mode setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetFermentingModeSetting() {
			reqGetProperty(EPC_FERMENTING_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart heating (heating started/restarted) = 0x41_x000a_Suspend heating (heating suspended) = 0x42_x000a_Stop heating (heating stopped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetHeatingSetting() {
			reqGetProperty(EPC_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Door open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door open = 0x41, door closed = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetDoorOpenCloseStatus() {
			reqGetProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Heating status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the status of the combination microwave oven. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Initial state = 0x40 Heating = 0x41_x000a_Heating suspended = 0x42_x000a_Reporting completion of heating cycle_x000a_= 0x43_x000a_Setting = 0x44 Preheating = 0x45_x000a_Preheat temperature maintenance = 0x46_x000a_Heating temporarily stopped for manual cooking action = 0x47<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetHeatingStatus() {
			reqGetProperty(EPC_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Two-stage microwave heating setting (heating power)<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x51 (two-stage microwave heating), to specify the heating power for the  first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power for first microwave heating cycle (first and second bytes):_x000a_0x0000.0xFFFD (0.65533W)_x000a_Heating power for second microwave heating cycle (third and fourth bytes):_x000a_0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetTwoStageMicrowaveHeatingSettingHeatingPower() {
			reqGetProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER_);
			return this;
		}
		/**
		 * Property name : Two-stage microwave heating setting (duration)<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Duration of first microwave heating cycle (first through third bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)_x000a_Duration of second microwave heating cycle (fourth through sixth bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3_x000a_×2<br>
		 * Data size : 6<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetTwoStageMicrowaveHeatingSettingDuration() {
			reqGetProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION_);
			return this;
		}

	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(short echoClassCode, byte echoInstanceCode
				, String dstEchoAddress, boolean isSelfObject) {
			super(echoClassCode, echoInstanceCode
					, dstEchoAddress, isSelfObject);
		}
		
		@Override
		public Informer reqInformProperty(byte epc) {
			return (Informer)super.reqInformProperty(epc);
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
		public Informer reqInformRemoteControlSetting() {
			return (Informer)super.reqInformRemoteControlSetting();
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
		
		/**
		 * Property name : Chamber temperature setting<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven) or 0x46 (= fermenting), to specify the temperature in the chamber in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2. 3276.6°C)_x000a_0x8001: Automatic 0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformChamberTemperatureSetting() {
			reqInformProperty(EPC_CHAMBER_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic heating level setting<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by selecting a level from among the five predefined levels, the level of automatic heating for the option specified by the “automatic heating menu setting” property, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31.0x35 (lowest to highest) Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformAutomaticHeatingLevelSetting() {
			reqInformProperty(EPC_AUTOMATIC_HEATING_LEVEL_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic heating setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the combination microwave oven’s automatic heating mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41_x000a_Manual = 0x42_x000a_Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformAutomaticHeatingSetting() {
			reqInformProperty(EPC_AUTOMATIC_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Heating mode setting<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the heating mode of the combination microwave oven, and to acquire the current setting (i.e. current mode). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Microwave heating = 0x41 Defrosting = 0x42_x000a_Oven = 0x43_x000a_Grill = 0x44 Toaster = 0x45 Fermenting = 0x46 Stewing = 0x47 Steaming = 0x48_x000a_Two-stage microwave heating = 0x51_x000a_No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformHeatingModeSetting() {
			reqInformProperty(EPC_HEATING_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Microwave heating power setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x41 (= microwave heating), 0x42 (= defrosting), 0x47 (= stewing) or 0x48 (= steaming) or when the value of the “heating mode setting” property (EPC_x000a_= 0xE0) is 0x46 (= fermenting) and the value of the “fermenting mode setting”_x000a_property (EPC = 0xD6) is 0x51 (= microwave fermentation mode), to specify the microwave heating power in 1W increments, and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMicrowaveHeatingPowerSetting() {
			reqInformProperty(EPC_MICROWAVE_HEATING_POWER_SETTING);
			return this;
		}
		/**
		 * Property name : Remaining heating time setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time remaining to complete the heating cycle in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRemainingHeatingTimeSetting() {
			reqInformProperty(EPC_REMAINING_HEATING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Heating time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the duration of heating in the HH:MM:SS format, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B: 0.0x3B (= 0.23) (= 0.59) (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3<br>
		 * Data size : 3<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformHeatingTimeSetting() {
			reqInformProperty(EPC_HEATING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : “Accessories to combination microwave oven” setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify, by means of a 2-byte bit map, what accessory or accessories to the combination microwave oven to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The value contained in a bit in the bit map shall be “1” if the accessory represented by that bit is used and “0” if the accessory represented by that bit_x000a_is not used (See the bitmap composition table in the subsection entitled “’Accessories to combination_x000a_microwave oven’ setting”).<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformAccessoriesToCombinationMicrowaveOvenSetting() {
			reqInformProperty(EPC__ACCESSORIES_TO_COMBINATION_MICROWAVE_OVEN_SETTING);
			return this;
		}
		/**
		 * Property name : Prompt message setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * Used, when it is necessary to instruct the combination microwave oven to temporarily stop heating at a point during a heating cycle to allow the user to perform manual reversing, mixing, etc. and display a message to instruct the user on the manual action to be performed, to specify the prompt message to be displayed and the timing of the message (in terms of a  percentage of the total duration of the heating cycle that is allowed to elapse (from the start of the heating cycle) before the message is displayed), and to acquire the current settings. Up to 4 messages may be specified. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: Prompt message code (See the prompt message code table in the subsection entitled “Prompt message setting.”)_x000a_Second byte: Timing value (0.0x64) (0.100%))<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2_x000a_×4<br>
		 * Data size : 8<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformPromptMessageSetting() {
			reqInformProperty(EPC_PROMPT_MESSAGE_SETTING);
			return this;
		}
		/**
		 * Property name : Food temperature setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the as-heated food temperature in 0.1°C increments, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xF554.0x7FFE (-273.2.3276.6°C)_x000a_0x8002: Not specified<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformFoodTemperatureSetting() {
			reqInformProperty(EPC_FOOD_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic heating menu setting<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “automatic heating setting” property is 0x41 (= automatic heating), to select an automatic heating cycle, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0xFE: Automatic heating cycle code (See the automatic heating cycle code table in the subsection entitled “Automatic heating menu setting.”)_x000a_No automatic heating cycle specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformAutomaticHeatingMenuSetting() {
			reqInformProperty(EPC_AUTOMATIC_HEATING_MENU_SETTING);
			return this;
		}
		/**
		 * Property name : Oven mode setting<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (= oven), to specify the_x000a_sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection oven mode = 0x41 Circulation oven mode = 0x42 Hybrid oven mode = 0x43_x000a_No sub-mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned cha<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOvenModeSetting() {
			reqInformProperty(EPC_OVEN_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Oven preheating setting<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x43 (oven), to specify whether or not to preheat the chamber for the selected oven sub-mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * With preheating = 0x41 Without preheating = 0x42 Not specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOvenPreheatingSetting() {
			reqInformProperty(EPC_OVEN_PREHEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Fermenting mode setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x46 (= fermenting), to specify the sub-mode to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic selection mode = 0x40 Convection fermentation mode = 0x41 Circulation fermentation mode = 0x42 Hybrid fermentation mode = 0x43 Microwave fermentation mode = 0x51 No mode specified = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformFermentingModeSetting() {
			reqInformProperty(EPC_FERMENTING_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Heating setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether to start, stop or suspend heating, and to acquire the current setting (i.e. current heating status). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart heating (heating started/restarted) = 0x41_x000a_Suspend heating (heating suspended) = 0x42_x000a_Stop heating (heating stopped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformHeatingSetting() {
			reqInformProperty(EPC_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Door open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the status (i.e. open or closed) of the door of the combination microwave oven. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door open = 0x41, door closed = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformDoorOpenCloseStatus() {
			reqInformProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Heating status<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the status of the combination microwave oven. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Initial state = 0x40 Heating = 0x41_x000a_Heating suspended = 0x42_x000a_Reporting completion of heating cycle_x000a_= 0x43_x000a_Setting = 0x44 Preheating = 0x45_x000a_Preheat temperature maintenance = 0x46_x000a_Heating temporarily stopped for manual cooking action = 0x47<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformHeatingStatus() {
			reqInformProperty(EPC_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Two-stage microwave heating setting (heating power)<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0)  is 0x51 (two-stage microwave heating), to specify the heating power for the  first and second microwave heating cycles in 1W increments, and to acquire the current setting. Two bytes shall be used for each heating cycle, with the first and second pairs of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Heating power for first microwave heating cycle (first and second bytes):_x000a_0x0000.0xFFFD (0.65533W)_x000a_Heating power for second microwave heating cycle (third and fourth bytes):_x000a_0x0000.0xFFFD (0.65533W)<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 1_x000a_W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformTwoStageMicrowaveHeatingSettingHeatingPower() {
			reqInformProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_HEATING_POWER_);
			return this;
		}
		/**
		 * Property name : Two-stage microwave heating setting (duration)<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * Used, when the value of the “heating mode setting” property (EPC = 0xE0) is 0x51 (two-stage microwave heating), to specify the duration of the first and second microwave heating cycles in the HH:MM:SS format, and to acquire the current setting. Three bytes shall be used for each heating cycle, with the first and second sets of bytes used for the first and second heating cycles, respectively. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Duration of first microwave heating cycle (first through third bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)_x000a_Duration of second microwave heating cycle (fourth through sixth bytes):_x000a_0.0x17: 0.0x3B: 0.0x3B_x000a_(= 0.23): (= 0.59): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×3_x000a_×2<br>
		 * Data size : 6<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformTwoStageMicrowaveHeatingSettingDuration() {
			reqInformProperty(EPC_TWO_STAGE_MICROWAVE_HEATING_SETTING_DURATION_);
			return this;
		}

	}

	public static class Proxy extends CombinationMicrowaveOven {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getGetPropertyMap(){return null;}
		@Override
		protected byte[] getSetPropertyMap(){return null;}
		@Override
		protected byte[] getStatusChangeAnnouncementPropertyMap(){return null;}
		@Override
		protected byte[] getManufacturerCode(){return null;}
		@Override
		protected byte[] getOperationStatus(){return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt){return false;}
		@Override
		protected byte[] getInstallationLocation(){return null;}
		@Override
		protected byte[] getStandardVersionInformation(){return null;}
		@Override
		protected byte[] getFaultStatus(){return null;}

	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return setG(instanceCode, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, responseRequired);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, false);
	}

}
