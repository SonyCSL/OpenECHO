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
package com.sonycsl.echo.eoj.device.airconditioner;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class HomeAirConditioner extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0130;

	public static final byte EPC_DEGREE_OF_HUMIDIFICATION_SETTING = (byte)0xC4;
	public static final byte EPC_AIR_PURIFIER_FUNCTION_SETTING = (byte)0xC7;
	public static final byte EPC_MOUNTED_AIR_CLEANING_METHOD = (byte)0xC6;
	public static final byte EPC_HUMIDIFIER_FUNCTION_SETTING = (byte)0xC1;
	public static final byte EPC_VENTILATION_FUNCTION_SETTING = (byte)0xC0;
	public static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	public static final byte EPC_AIR_REFRESHER_FUNCTION_SETTING = (byte)0xC9;
	public static final byte EPC_MOUNTED_AIR_REFRESH_METHOD = (byte)0xC8;
	public static final byte EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING = (byte)0xA5;
	public static final byte EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING = (byte)0xA4;
	public static final byte EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING = (byte)0xA3;
	public static final byte EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING = (byte)0xA1;
	public static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	public static final byte EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ = (byte)0x96;
	public static final byte EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE = (byte)0xBB;
	public static final byte EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL = (byte)0xBC;
	public static final byte EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY = (byte)0xBA;
	public static final byte EPC_RELATIVE_TEMPERATURE_SETTING = (byte)0xBF;
	public static final byte EPC_MEASURED_COOLED_AIR_TEMPERATURE = (byte)0xBD;
	public static final byte EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE = (byte)0xBE;
	public static final byte EPC_OFF_TIMER_BASED_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_ON_TIMER_SETTING_TIME_ = (byte)0x91;
	public static final byte EPC_ON_TIMER_BASED_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_RATED_POWER_CONSUMPTION = (byte)0xB8;
	public static final byte EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION = (byte)0xB9;
	public static final byte EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING = (byte)0xB2;
	public static final byte EPC_SET_TEMPERATURE_VALUE = (byte)0xB3;
	public static final byte EPC_OPERATION_MODE_SETTING = (byte)0xB0;
	public static final byte EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING = (byte)0xB1;
	public static final byte EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE = (byte)0xB6;
	public static final byte EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE = (byte)0xB7;
	public static final byte EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE = (byte)0xB4;
	public static final byte EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE = (byte)0xB5;
	public static final byte EPC_NON_PRIORITY_STATE = (byte)0xAB;
	public static final byte EPC_SPECIAL_STATE = (byte)0xAA;
	public static final byte EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION = (byte)0xCE;
	public static final byte EPC_OPERATION_STATUS_OF_COMPONENTS = (byte)0xCD;
	public static final byte EPC_OFF_TIMER_SETTING_TIME_ = (byte)0x95;
	public static final byte EPC_AIR_PURIFICATION_MODE_SETTING = (byte)0xCF;
	public static final byte EPC_MOUNTED_SELF_CLEANING_METHOD = (byte)0xCA;
	public static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME_ = (byte)0x92;
	public static final byte EPC_SPECIAL_FUNCTION_SETTING = (byte)0xCC;
	public static final byte EPC_SELF_CLEANING_FUNCTION_SETTING = (byte)0xCB;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_SET_TEMPERATURE_VALUE);
		addGetProperty(EPC_SET_TEMPERATURE_VALUE);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_MODE_SETTING);
		addSetProperty(EPC_OPERATION_MODE_SETTING);
		addGetProperty(EPC_OPERATION_MODE_SETTING);

	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewHomeAirConditioner(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Degree of humidification setting<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of the degree of humidification = 0x41_x000a_Degree of humidification = 0x31.0x38<br>
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
	protected boolean setDegreeOfHumidificationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Degree of humidification setting<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of the degree of humidification = 0x41_x000a_Degree of humidification = 0x31.0x38<br>
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
	protected byte[] getDegreeOfHumidificationSetting() {return null;}
	/**
	 * Property name : Degree of humidification setting<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of the degree of humidification = 0x41_x000a_Degree of humidification = 0x31.0x38<br>
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
	protected boolean isValidDegreeOfHumidificationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Air purifier function setting<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents :<br>
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air purifier function._x000a_Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char ×8<br>
	 * Data size : 8<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setAirPurifierFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air purifier function setting<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents :<br>
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air purifier function._x000a_Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char ×8<br>
	 * Data size : 8<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getAirPurifierFunctionSetting() {return null;}
	/**
	 * Property name : Air purifier function setting<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents :<br>
	 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air purifier function._x000a_Elements 2 to 7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char ×8<br>
	 * Data size : 8<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidAirPurifierFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 8)) {return false;};
		return true;
	}
	/**
	 * Property name : Mounted air cleaning method<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents :<br>
	 * A bitmap indicates mounted method of exercising air cleaning function. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about electrical dust collection method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
	protected byte[] getMountedAirCleaningMethod() {return null;}
	/**
	 * Property name : Mounted air cleaning method<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents :<br>
	 * A bitmap indicates mounted method of exercising air cleaning function. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about electrical dust collection method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
	protected boolean isValidMountedAirCleaningMethod(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Humidifier function setting<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
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
	protected boolean setHumidifierFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Humidifier function setting<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
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
	protected byte[] getHumidifierFunctionSetting() {return null;}
	/**
	 * Property name : Humidifier function setting<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the humidifier function, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
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
	protected boolean isValidHumidifierFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Ventilation function setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
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
	protected boolean setVentilationFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ventilation function setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
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
	protected byte[] getVentilationFunctionSetting() {return null;}
	/**
	 * Property name : Ventilation function setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
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
	protected boolean isValidVentilationFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31.0x38<br>
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
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31.0x38<br>
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
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31.0x38<br>
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
	protected boolean isValidVentilationAirFlowRateSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Air refresher function setting<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents :<br>
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the minus ion-based air refresher function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air refresher function._x000a_Elements 2.7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char × 8<br>
	 * Data size : 8<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setAirRefresherFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air refresher function setting<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents :<br>
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the minus ion-based air refresher function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air refresher function._x000a_Elements 2.7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char × 8<br>
	 * Data size : 8<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getAirRefresherFunctionSetting() {return null;}
	/**
	 * Property name : Air refresher function setting<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents :<br>
	 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the minus ion-based air refresher function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air refresher function._x000a_Elements 2.7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char × 8<br>
	 * Data size : 8<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidAirRefresherFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 8)) {return false;};
		return true;
	}
	/**
	 * Property name : Mounted air refresh method<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents :<br>
	 * A bitmap indicates mounted method for exercising refresh function. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about minus ion method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
	protected byte[] getMountedAirRefreshMethod() {return null;}
	/**
	 * Property name : Mounted air refresh method<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents :<br>
	 * A bitmap indicates mounted method for exercising refresh function. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about minus ion method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
	protected boolean isValidMountedAirRefreshMethod(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Air flow direction (horizontal) setting<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward_x000a_= 0x44 (for a full list of the predefined_x000a_patterns, see the table in the subsection defining the detailed requirements for this property.<br>
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
	protected boolean setAirFlowDirectionHorizontalSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air flow direction (horizontal) setting<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward_x000a_= 0x44 (for a full list of the predefined_x000a_patterns, see the table in the subsection defining the detailed requirements for this property.<br>
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
	protected byte[] getAirFlowDirectionHorizontalSetting() {return null;}
	/**
	 * Property name : Air flow direction (horizontal) setting<br>
	 * <br>
	 * EPC : 0xA5<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward_x000a_= 0x44 (for a full list of the predefined_x000a_patterns, see the table in the subsection defining the detailed requirements for this property.<br>
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
	protected boolean isValidAirFlowDirectionHorizontalSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Air flow direction (vertical) setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
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
	protected boolean setAirFlowDirectionVerticalSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air flow direction (vertical) setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
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
	protected byte[] getAirFlowDirectionVerticalSetting() {return null;}
	/**
	 * Property name : Air flow direction (vertical) setting<br>
	 * <br>
	 * EPC : 0xA4<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
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
	protected boolean isValidAirFlowDirectionVerticalSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Automatic swing of air flow setting<br>
	 * <br>
	 * EPC : 0xA3<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br>
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
	protected boolean setAutomaticSwingOfAirFlowSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic swing of air flow setting<br>
	 * <br>
	 * EPC : 0xA3<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br>
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
	protected byte[] getAutomaticSwingOfAirFlowSetting() {return null;}
	/**
	 * Property name : Automatic swing of air flow setting<br>
	 * <br>
	 * EPC : 0xA3<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br>
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
	protected boolean isValidAutomaticSwingOfAirFlowSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Automatic control of air flow direction setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br>
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
	protected boolean setAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic control of air flow direction setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br>
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
	protected byte[] getAutomaticControlOfAirFlowDirectionSetting() {return null;}
	/**
	 * Property name : Automatic control of air flow direction setting<br>
	 * <br>
	 * EPC : 0xA1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br>
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
	protected boolean isValidAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Air flow rate setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow rate control function used = 0x41_x000a_Air flow rate = 0x31.0x38<br>
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
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air flow rate setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow rate control function used = 0x41_x000a_Air flow rate = 0x31.0x38<br>
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
	protected byte[] getAirFlowRateSetting() {return null;}
	/**
	 * Property name : Air flow rate setting<br>
	 * <br>
	 * EPC : 0xA0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic air flow rate control function used = 0x41_x000a_Air flow rate = 0x31.0x38<br>
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
	protected boolean isValidAirFlowRateSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getOffTimerSettingRelativeTime() {return null;}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOffTimerSettingRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured value of room temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents :<br>
	 * Measured value of room temperature <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredValueOfRoomTemperature() {return null;}
	/**
	 * Property name : Measured value of room temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents :<br>
	 * Measured value of room temperature <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredValueOfRoomTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Set temperature value of user remote control<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents :<br>
	 * Set temperature value of user remote control <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getSetTemperatureValueOfUserRemoteControl() {return null;}
	/**
	 * Property name : Set temperature value of user remote control<br>
	 * <br>
	 * EPC : 0xBC<br>
	 * <br>
	 * Contents :<br>
	 * Set temperature value of user remote control <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidSetTemperatureValueOfUserRemoteControl(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured value of room relative humidity<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents :<br>
	 * Measured value of room relative humidity <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredValueOfRoomRelativeHumidity() {return null;}
	/**
	 * Property name : Measured value of room relative humidity<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents :<br>
	 * Measured value of room relative humidity <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredValueOfRoomRelativeHumidity(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Relative temperature setting<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-12.7°C.12.5°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setRelativeTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Property name : Relative temperature setting<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-12.7°C.12.5°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getRelativeTemperatureSetting() {return null;}
	/**
	 * Property name : Relative temperature setting<br>
	 * <br>
	 * EPC : 0xBF<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-12.7°C.12.5°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : 0.1°C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRelativeTemperatureSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured cooled air temperature<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured cooled air temperature at the outlet. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredCooledAirTemperature() {return null;}
	/**
	 * Property name : Measured cooled air temperature<br>
	 * <br>
	 * EPC : 0xBD<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured cooled air temperature at the outlet. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredCooledAirTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured outdoor air temperature<br>
	 * <br>
	 * EPC : 0xBE<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured outdoor air temperature. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredOutdoorAirTemperature() {return null;}
	/**
	 * Property name : Measured outdoor air temperature<br>
	 * <br>
	 * EPC : 0xBE<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured outdoor air temperature. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.125°C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredOutdoorAirTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : OFF timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
	protected boolean setOffTimerBasedReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
	protected byte[] getOffTimerBasedReservationSetting() {return null;}
	/**
	 * Property name : OFF timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
	protected boolean isValidOffTimerBasedReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the ON/OFF status. <br>
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
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationStatus(byte[] edt);
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the ON/OFF status. <br>
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
	 * Set      - mandatory<br>
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
	 * This property indicates the ON/OFF status. <br>
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
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : ON timer setting (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the time for the_x000a_time-based reservation function in the HH:MM format and to acquire the_x000a_current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the time for the_x000a_time-based reservation function in the HH:MM format and to acquire the_x000a_current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	/**
	 * Property name : ON timer setting (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the time for the_x000a_time-based reservation function in the HH:MM format and to acquire the_x000a_current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOnTimerSettingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : ON timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
	protected boolean setOnTimerBasedReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
	protected byte[] getOnTimerBasedReservationSetting() {return null;}
	/**
	 * Property name : ON timer-based reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
	protected boolean isValidOnTimerBasedReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Rated power consumption<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents :<br>
	 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)_x000a_Cooling: heating: dehumidifying: blast<br>
	 * <br>
	 * Data type : unsigned short × 4<br>
	 * Data size : 8<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getRatedPowerConsumption() {return null;}
	/**
	 * Property name : Rated power consumption<br>
	 * <br>
	 * EPC : 0xB8<br>
	 * <br>
	 * Contents :<br>
	 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.65533W)_x000a_Cooling: heating: dehumidifying: blast<br>
	 * <br>
	 * Data type : unsigned short × 4<br>
	 * Data size : 8<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRatedPowerConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 8)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured value of current consumption<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents :<br>
	 * Measured value of current consumption <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredValueOfCurrentConsumption() {return null;}
	/**
	 * Property name : Measured value of current consumption<br>
	 * <br>
	 * EPC : 0xB9<br>
	 * <br>
	 * Contents :<br>
	 * Measured value of current consumption <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredValueOfCurrentConsumption(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Normal/high- speed/silent operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the type of operation_x000a_(“normal,” “high-speed” or “silent”),_x000a_and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal operation: 0x41 High-speed operation: 0x42_x000a_Silent operation: 0x43<br>
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
	protected boolean setNormalHighSpeedSilentOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Normal/high- speed/silent operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the type of operation_x000a_(“normal,” “high-speed” or “silent”),_x000a_and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal operation: 0x41 High-speed operation: 0x42_x000a_Silent operation: 0x43<br>
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
	protected byte[] getNormalHighSpeedSilentOperationSetting() {return null;}
	/**
	 * Property name : Normal/high- speed/silent operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the type of operation_x000a_(“normal,” “high-speed” or “silent”),_x000a_and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal operation: 0x41 High-speed operation: 0x42_x000a_Silent operation: 0x43<br>
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
	protected boolean isValidNormalHighSpeedSilentOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Set temperature value<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setSetTemperatureValue(byte[] edt);
	/**
	 * Property name : Set temperature value<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getSetTemperatureValue();
	/**
	 * Property name : Set temperature value<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidSetTemperatureValue(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification,” “air circulator” or “other”), and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41_x000a_Cooling: 0x42 Heating: 0x43_x000a_Dehumidification: 0x44 Air circulator: 0x45_x000a_Other: 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationModeSetting(byte[] edt);
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification,” “air circulator” or “other”), and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41_x000a_Cooling: 0x42 Heating: 0x43_x000a_Dehumidification: 0x44 Air circulator: 0x45_x000a_Other: 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationModeSetting();
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification,” “air circulator” or “other”), and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * The following values shall be used: Automatic: 0x41_x000a_Cooling: 0x42 Heating: 0x43_x000a_Dehumidification: 0x44 Air circulator: 0x45_x000a_Other: 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Automatic temperature control setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41 Non-automatic = 0x42<br>
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
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic temperature control setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41 Non-automatic = 0x42<br>
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
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	/**
	 * Property name : Automatic temperature control setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41 Non-automatic = 0x42<br>
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
	protected boolean isValidAutomaticTemperatureControlSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Set temperature value in heating mode<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature for the “heating” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setSetTemperatureValueInHeatingMode(byte[] edt) {return false;}
	/**
	 * Property name : Set temperature value in heating mode<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature for the “heating” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getSetTemperatureValueInHeatingMode() {return null;}
	/**
	 * Property name : Set temperature value in heating mode<br>
	 * <br>
	 * EPC : 0xB6<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature for the “heating” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidSetTemperatureValueInHeatingMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Set temperature value in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setSetTemperatureValueInDehumidifyingMode(byte[] edt) {return false;}
	/**
	 * Property name : Set temperature value in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getSetTemperatureValueInDehumidifyingMode() {return null;}
	/**
	 * Property name : Set temperature value in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB7<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidSetTemperatureValueInDehumidifyingMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Set value of relative humidity in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {return false;}
	/**
	 * Property name : Set value of relative humidity in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getSetValueOfRelativeHumidityInDehumidifyingMode() {return null;}
	/**
	 * Property name : Set value of relative humidity in dehumidifying mode<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Set temperature value in cooling mode<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature for the “cooling” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setSetTemperatureValueInCoolingMode(byte[] edt) {return false;}
	/**
	 * Property name : Set temperature value in cooling mode<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature for the “cooling” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getSetTemperatureValueInCoolingMode() {return null;}
	/**
	 * Property name : Set temperature value in cooling mode<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the temperature for the “cooling” mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x32 (0.50°C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : °C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidSetTemperatureValueInCoolingMode(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Non-priority state<br>
	 * <br>
	 * EPC : 0xAB<br>
	 * <br>
	 * Contents :<br>
	 * Used to indicate when the air conditioner is in a “non-priority” state. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” state = 0x40,_x000a_“Non-priority” state = 0x41<br>
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
	protected byte[] getNonPriorityState() {return null;}
	/**
	 * Property name : Non-priority state<br>
	 * <br>
	 * EPC : 0xAB<br>
	 * <br>
	 * Contents :<br>
	 * Used to indicate when the air conditioner is in a “non-priority” state. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” state = 0x40,_x000a_“Non-priority” state = 0x41<br>
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
	protected boolean isValidNonPriorityState(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Special state<br>
	 * <br>
	 * EPC : 0xAA<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates if the air conditioner is in a “special” state (i.e. the “defrosting,” “preheating,” or “heat removal” state). <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” state = 0x40, “Defrosting” state = 0x41, “Preheating” state = 0x42,_x000a_“Heat removal” state = 0x43<br>
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
	protected byte[] getSpecialState() {return null;}
	/**
	 * Property name : Special state<br>
	 * <br>
	 * EPC : 0xAA<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates if the air conditioner is in a “special” state (i.e. the “defrosting,” “preheating,” or “heat removal” state). <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * “Normal operation” state = 0x40, “Defrosting” state = 0x41, “Preheating” state = 0x42,_x000a_“Heat removal” state = 0x43<br>
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
	protected boolean isValidSpecialState(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Thermostat setting override function<br>
	 * <br>
	 * EPC : 0xCE<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - -<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setThermostatSettingOverrideFunction(byte[] edt) {return false;}
	/**
	 * Property name : Thermostat setting override function<br>
	 * <br>
	 * EPC : 0xCE<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - -<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidThermostatSettingOverrideFunction(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Operation status of components<br>
	 * <br>
	 * EPC : 0xCD<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the operation status of components of the air conditioner in a bitmap format. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Operation status of the compressor:_x000a_0: Not operating_x000a_1: In operation_x000a_Bit 1: Operation status of the thermostat:_x000a_0: Thermostat OFF_x000a_1: Thermostat ON Bits 2.7: Reserved for future use.<br>
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
	protected byte[] getOperationStatusOfComponents() {return null;}
	/**
	 * Property name : Operation status of components<br>
	 * <br>
	 * EPC : 0xCD<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the operation status of components of the air conditioner in a bitmap format. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Operation status of the compressor:_x000a_0: Not operating_x000a_1: In operation_x000a_Bit 1: Operation status of the thermostat:_x000a_0: Thermostat OFF_x000a_1: Thermostat ON Bits 2.7: Reserved for future use.<br>
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
	protected boolean isValidOperationStatusOfComponents(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the time for the_x000a_time-based reservation function in the_x000a_HH:MM format and to acquire the_x000a_current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the time for the_x000a_time-based reservation function in the_x000a_HH:MM format and to acquire the_x000a_current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	/**
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the time for the_x000a_time-based reservation function in the_x000a_HH:MM format and to acquire the_x000a_current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOffTimerSettingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Air purification mode setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the air purification mode setting ON/OFF and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Air purification ON=0x41,OFF=0x42<br>
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
	protected boolean setAirPurificationModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Air purification mode setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the air purification mode setting ON/OFF and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Air purification ON=0x41,OFF=0x42<br>
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
	protected byte[] getAirPurificationModeSetting() {return null;}
	/**
	 * Property name : Air purification mode setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the air purification mode setting ON/OFF and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Air purification ON=0x41,OFF=0x42<br>
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
	protected boolean isValidAirPurificationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Mounted self-cleaning method<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents :<br>
	 * A bitmap indicates mounted method for exercising self-cleaning function. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about ozone cleaning method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about drying method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
	protected byte[] getMountedSelfCleaningMethod() {return null;}
	/**
	 * Property name : Mounted self-cleaning method<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents :<br>
	 * A bitmap indicates mounted method for exercising self-cleaning function. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: Information about ozone cleaning method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about drying method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
	protected boolean isValidMountedSelfCleaningMethod(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : ON timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	/**
	 * Property name : ON timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char × 2<br>
	 * Data size : 2<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOnTimerSettingRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Special function setting<br>
	 * <br>
	 * EPC : 0xCC<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the “special function” to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44_x000a_0x45. : Reserved for future use.<br>
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
	protected boolean setSpecialFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Special function setting<br>
	 * <br>
	 * EPC : 0xCC<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the “special function” to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44_x000a_0x45. : Reserved for future use.<br>
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
	protected byte[] getSpecialFunctionSetting() {return null;}
	/**
	 * Property name : Special function setting<br>
	 * <br>
	 * EPC : 0xCC<br>
	 * <br>
	 * Contents :<br>
	 * Used to specify the “special function” to use, and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44_x000a_0x45. : Reserved for future use.<br>
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
	protected boolean isValidSpecialFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Self-cleaning function setting<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents :<br>
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of_x000a_self-cleaning to achieve with the_x000a_self-cleaning function, and to acquire_x000a_the current settings. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function._x000a_Element 1: Indicates whether or not to use the drying-based self-cleaning function._x000a_Elements 2.7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char × 8<br>
	 * Data size : 8<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setSelfCleaningFunctionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Self-cleaning function setting<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents :<br>
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of_x000a_self-cleaning to achieve with the_x000a_self-cleaning function, and to acquire_x000a_the current settings. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function._x000a_Element 1: Indicates whether or not to use the drying-based self-cleaning function._x000a_Elements 2.7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char × 8<br>
	 * Data size : 8<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getSelfCleaningFunctionSetting() {return null;}
	/**
	 * Property name : Self-cleaning function setting<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents :<br>
	 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of_x000a_self-cleaning to achieve with the_x000a_self-cleaning function, and to acquire_x000a_the current settings. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function._x000a_Element 1: Indicates whether or not to use the drying-based self-cleaning function._x000a_Elements 2.7: Reserved for future use.<br>
	 * <br>
	 * Data type : unsigned char × 8<br>
	 * Data size : 8<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidSelfCleaningFunctionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 8)) {return false;};
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : return setDegreeOfHumidificationSetting(property.edt);
		case EPC_AIR_PURIFIER_FUNCTION_SETTING : return setAirPurifierFunctionSetting(property.edt);
		case EPC_HUMIDIFIER_FUNCTION_SETTING : return setHumidifierFunctionSetting(property.edt);
		case EPC_VENTILATION_FUNCTION_SETTING : return setVentilationFunctionSetting(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return setVentilationAirFlowRateSetting(property.edt);
		case EPC_AIR_REFRESHER_FUNCTION_SETTING : return setAirRefresherFunctionSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : return setAirFlowDirectionHorizontalSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : return setAirFlowDirectionVerticalSetting(property.edt);
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : return setAutomaticSwingOfAirFlowSetting(property.edt);
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : return setAutomaticControlOfAirFlowDirectionSetting(property.edt);
		case EPC_AIR_FLOW_RATE_SETTING : return setAirFlowRateSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : return setOffTimerSettingRelativeTime(property.edt);
		case EPC_RELATIVE_TEMPERATURE_SETTING : return setRelativeTemperatureSetting(property.edt);
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : return setOffTimerBasedReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING_TIME_ : return setOnTimerSettingTime(property.edt);
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING : return setOnTimerBasedReservationSetting(property.edt);
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : return setNormalHighSpeedSilentOperationSetting(property.edt);
		case EPC_SET_TEMPERATURE_VALUE : return setSetTemperatureValue(property.edt);
		case EPC_OPERATION_MODE_SETTING : return setOperationModeSetting(property.edt);
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : return setAutomaticTemperatureControlSetting(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : return setSetTemperatureValueInHeatingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : return setSetTemperatureValueInDehumidifyingMode(property.edt);
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : return setSetValueOfRelativeHumidityInDehumidifyingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : return setSetTemperatureValueInCoolingMode(property.edt);
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : return setThermostatSettingOverrideFunction(property.edt);
		case EPC_OFF_TIMER_SETTING_TIME_ : return setOffTimerSettingTime(property.edt);
		case EPC_AIR_PURIFICATION_MODE_SETTING : return setAirPurificationModeSetting(property.edt);
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : return setOnTimerSettingRelativeTime(property.edt);
		case EPC_SPECIAL_FUNCTION_SETTING : return setSpecialFunctionSetting(property.edt);
		case EPC_SELF_CLEANING_FUNCTION_SETTING : return setSelfCleaningFunctionSetting(property.edt);

		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : return getDegreeOfHumidificationSetting();
		case EPC_AIR_PURIFIER_FUNCTION_SETTING : return getAirPurifierFunctionSetting();
		case EPC_MOUNTED_AIR_CLEANING_METHOD : return getMountedAirCleaningMethod();
		case EPC_HUMIDIFIER_FUNCTION_SETTING : return getHumidifierFunctionSetting();
		case EPC_VENTILATION_FUNCTION_SETTING : return getVentilationFunctionSetting();
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return getVentilationAirFlowRateSetting();
		case EPC_AIR_REFRESHER_FUNCTION_SETTING : return getAirRefresherFunctionSetting();
		case EPC_MOUNTED_AIR_REFRESH_METHOD : return getMountedAirRefreshMethod();
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : return getAirFlowDirectionHorizontalSetting();
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : return getAirFlowDirectionVerticalSetting();
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : return getAutomaticSwingOfAirFlowSetting();
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : return getAutomaticControlOfAirFlowDirectionSetting();
		case EPC_AIR_FLOW_RATE_SETTING : return getAirFlowRateSetting();
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : return getOffTimerSettingRelativeTime();
		case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE : return getMeasuredValueOfRoomTemperature();
		case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL : return getSetTemperatureValueOfUserRemoteControl();
		case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY : return getMeasuredValueOfRoomRelativeHumidity();
		case EPC_RELATIVE_TEMPERATURE_SETTING : return getRelativeTemperatureSetting();
		case EPC_MEASURED_COOLED_AIR_TEMPERATURE : return getMeasuredCooledAirTemperature();
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE : return getMeasuredOutdoorAirTemperature();
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : return getOffTimerBasedReservationSetting();
		case EPC_ON_TIMER_SETTING_TIME_ : return getOnTimerSettingTime();
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING : return getOnTimerBasedReservationSetting();
		case EPC_RATED_POWER_CONSUMPTION : return getRatedPowerConsumption();
		case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION : return getMeasuredValueOfCurrentConsumption();
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : return getNormalHighSpeedSilentOperationSetting();
		case EPC_SET_TEMPERATURE_VALUE : return getSetTemperatureValue();
		case EPC_OPERATION_MODE_SETTING : return getOperationModeSetting();
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : return getAutomaticTemperatureControlSetting();
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : return getSetTemperatureValueInHeatingMode();
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : return getSetTemperatureValueInDehumidifyingMode();
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : return getSetValueOfRelativeHumidityInDehumidifyingMode();
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : return getSetTemperatureValueInCoolingMode();
		case EPC_NON_PRIORITY_STATE : return getNonPriorityState();
		case EPC_SPECIAL_STATE : return getSpecialState();
		case EPC_OPERATION_STATUS_OF_COMPONENTS : return getOperationStatusOfComponents();
		case EPC_OFF_TIMER_SETTING_TIME_ : return getOffTimerSettingTime();
		case EPC_AIR_PURIFICATION_MODE_SETTING : return getAirPurificationModeSetting();
		case EPC_MOUNTED_SELF_CLEANING_METHOD : return getMountedSelfCleaningMethod();
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : return getOnTimerSettingRelativeTime();
		case EPC_SPECIAL_FUNCTION_SETTING : return getSpecialFunctionSetting();
		case EPC_SELF_CLEANING_FUNCTION_SETTING : return getSelfCleaningFunctionSetting();

		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : return isValidDegreeOfHumidificationSetting(property.edt);
		case EPC_AIR_PURIFIER_FUNCTION_SETTING : return isValidAirPurifierFunctionSetting(property.edt);
		case EPC_MOUNTED_AIR_CLEANING_METHOD : return isValidMountedAirCleaningMethod(property.edt);
		case EPC_HUMIDIFIER_FUNCTION_SETTING : return isValidHumidifierFunctionSetting(property.edt);
		case EPC_VENTILATION_FUNCTION_SETTING : return isValidVentilationFunctionSetting(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return isValidVentilationAirFlowRateSetting(property.edt);
		case EPC_AIR_REFRESHER_FUNCTION_SETTING : return isValidAirRefresherFunctionSetting(property.edt);
		case EPC_MOUNTED_AIR_REFRESH_METHOD : return isValidMountedAirRefreshMethod(property.edt);
		case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : return isValidAirFlowDirectionHorizontalSetting(property.edt);
		case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : return isValidAirFlowDirectionVerticalSetting(property.edt);
		case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : return isValidAutomaticSwingOfAirFlowSetting(property.edt);
		case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : return isValidAutomaticControlOfAirFlowDirectionSetting(property.edt);
		case EPC_AIR_FLOW_RATE_SETTING : return isValidAirFlowRateSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : return isValidOffTimerSettingRelativeTime(property.edt);
		case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE : return isValidMeasuredValueOfRoomTemperature(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL : return isValidSetTemperatureValueOfUserRemoteControl(property.edt);
		case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY : return isValidMeasuredValueOfRoomRelativeHumidity(property.edt);
		case EPC_RELATIVE_TEMPERATURE_SETTING : return isValidRelativeTemperatureSetting(property.edt);
		case EPC_MEASURED_COOLED_AIR_TEMPERATURE : return isValidMeasuredCooledAirTemperature(property.edt);
		case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE : return isValidMeasuredOutdoorAirTemperature(property.edt);
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : return isValidOffTimerBasedReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING_TIME_ : return isValidOnTimerSettingTime(property.edt);
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING : return isValidOnTimerBasedReservationSetting(property.edt);
		case EPC_RATED_POWER_CONSUMPTION : return isValidRatedPowerConsumption(property.edt);
		case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION : return isValidMeasuredValueOfCurrentConsumption(property.edt);
		case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : return isValidNormalHighSpeedSilentOperationSetting(property.edt);
		case EPC_SET_TEMPERATURE_VALUE : return isValidSetTemperatureValue(property.edt);
		case EPC_OPERATION_MODE_SETTING : return isValidOperationModeSetting(property.edt);
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : return isValidAutomaticTemperatureControlSetting(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : return isValidSetTemperatureValueInHeatingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : return isValidSetTemperatureValueInDehumidifyingMode(property.edt);
		case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : return isValidSetValueOfRelativeHumidityInDehumidifyingMode(property.edt);
		case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : return isValidSetTemperatureValueInCoolingMode(property.edt);
		case EPC_NON_PRIORITY_STATE : return isValidNonPriorityState(property.edt);
		case EPC_SPECIAL_STATE : return isValidSpecialState(property.edt);
		case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : return isValidThermostatSettingOverrideFunction(property.edt);
		case EPC_OPERATION_STATUS_OF_COMPONENTS : return isValidOperationStatusOfComponents(property.edt);
		case EPC_OFF_TIMER_SETTING_TIME_ : return isValidOffTimerSettingTime(property.edt);
		case EPC_AIR_PURIFICATION_MODE_SETTING : return isValidAirPurificationModeSetting(property.edt);
		case EPC_MOUNTED_SELF_CLEANING_METHOD : return isValidMountedSelfCleaningMethod(property.edt);
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : return isValidOnTimerSettingRelativeTime(property.edt);
		case EPC_SPECIAL_FUNCTION_SETTING : return isValidSpecialFunctionSetting(property.edt);
		case EPC_SELF_CLEANING_FUNCTION_SETTING : return isValidSelfCleaningFunctionSetting(property.edt);

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
			case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : 
				onSetDegreeOfHumidificationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_PURIFIER_FUNCTION_SETTING : 
				onSetAirPurifierFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMIDIFIER_FUNCTION_SETTING : 
				onSetHumidifierFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_FUNCTION_SETTING : 
				onSetVentilationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onSetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_REFRESHER_FUNCTION_SETTING : 
				onSetAirRefresherFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : 
				onSetAirFlowDirectionHorizontalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : 
				onSetAirFlowDirectionVerticalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : 
				onSetAutomaticSwingOfAirFlowSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : 
				onSetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_RATE_SETTING : 
				onSetAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : 
				onSetOffTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TEMPERATURE_SETTING : 
				onSetRelativeTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : 
				onSetOffTimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_TIME_ : 
				onSetOnTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING : 
				onSetOnTimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : 
				onSetNormalHighSpeedSilentOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE : 
				onSetSetTemperatureValue(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_MODE_SETTING : 
				onSetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : 
				onSetAutomaticTemperatureControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : 
				onSetSetTemperatureValueInHeatingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : 
				onSetSetTemperatureValueInDehumidifyingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : 
				onSetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : 
				onSetSetTemperatureValueInCoolingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION : 
				onSetThermostatSettingOverrideFunction(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_TIME_ : 
				onSetOffTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_PURIFICATION_MODE_SETTING : 
				onSetAirPurificationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : 
				onSetOnTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_FUNCTION_SETTING : 
				onSetSpecialFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SELF_CLEANING_FUNCTION_SETTING : 
				onSetSelfCleaningFunctionSetting(eoj, tid, esv, property, success);
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
			case EPC_DEGREE_OF_HUMIDIFICATION_SETTING : 
				onGetDegreeOfHumidificationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_PURIFIER_FUNCTION_SETTING : 
				onGetAirPurifierFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MOUNTED_AIR_CLEANING_METHOD : 
				onGetMountedAirCleaningMethod(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMIDIFIER_FUNCTION_SETTING : 
				onGetHumidifierFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_FUNCTION_SETTING : 
				onGetVentilationFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onGetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_REFRESHER_FUNCTION_SETTING : 
				onGetAirRefresherFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MOUNTED_AIR_REFRESH_METHOD : 
				onGetMountedAirRefreshMethod(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING : 
				onGetAirFlowDirectionHorizontalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING : 
				onGetAirFlowDirectionVerticalSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING : 
				onGetAutomaticSwingOfAirFlowSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING : 
				onGetAutomaticControlOfAirFlowDirectionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_FLOW_RATE_SETTING : 
				onGetAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : 
				onGetOffTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE : 
				onGetMeasuredValueOfRoomTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL : 
				onGetSetTemperatureValueOfUserRemoteControl(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY : 
				onGetMeasuredValueOfRoomRelativeHumidity(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TEMPERATURE_SETTING : 
				onGetRelativeTemperatureSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_COOLED_AIR_TEMPERATURE : 
				onGetMeasuredCooledAirTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE : 
				onGetMeasuredOutdoorAirTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING : 
				onGetOffTimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_TIME_ : 
				onGetOnTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING : 
				onGetOnTimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_POWER_CONSUMPTION : 
				onGetRatedPowerConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION : 
				onGetMeasuredValueOfCurrentConsumption(eoj, tid, esv, property, success);
				return true;
			case EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING : 
				onGetNormalHighSpeedSilentOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE : 
				onGetSetTemperatureValue(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_MODE_SETTING : 
				onGetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : 
				onGetAutomaticTemperatureControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE : 
				onGetSetTemperatureValueInHeatingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE : 
				onGetSetTemperatureValueInDehumidifyingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE : 
				onGetSetValueOfRelativeHumidityInDehumidifyingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE : 
				onGetSetTemperatureValueInCoolingMode(eoj, tid, esv, property, success);
				return true;
			case EPC_NON_PRIORITY_STATE : 
				onGetNonPriorityState(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_STATE : 
				onGetSpecialState(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_STATUS_OF_COMPONENTS : 
				onGetOperationStatusOfComponents(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_TIME_ : 
				onGetOffTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_AIR_PURIFICATION_MODE_SETTING : 
				onGetAirPurificationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MOUNTED_SELF_CLEANING_METHOD : 
				onGetMountedSelfCleaningMethod(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : 
				onGetOnTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_FUNCTION_SETTING : 
				onGetSpecialFunctionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SELF_CLEANING_FUNCTION_SETTING : 
				onGetSelfCleaningFunctionSetting(eoj, tid, esv, property, success);
				return true;

			default :
				return false;
			}
		}
		
		/**
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41_x000a_Degree of humidification = 0x31.0x38<br>
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
		protected void onSetDegreeOfHumidificationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41_x000a_Degree of humidification = 0x31.0x38<br>
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
		protected void onGetDegreeOfHumidificationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air purifier function._x000a_Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char ×8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetAirPurifierFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air purifier function._x000a_Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char ×8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetAirPurifierFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Mounted air cleaning method<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents :<br>
		 * A bitmap indicates mounted method of exercising air cleaning function. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about electrical dust collection method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
		protected void onGetMountedAirCleaningMethod(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
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
		protected void onSetHumidifierFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
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
		protected void onGetHumidifierFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
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
		protected void onSetVentilationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
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
		protected void onGetVentilationFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31.0x38<br>
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
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31.0x38<br>
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
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air refresher function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetAirRefresherFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air refresher function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetAirRefresherFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Mounted air refresh method<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents :<br>
		 * A bitmap indicates mounted method for exercising refresh function. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about minus ion method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
		protected void onGetMountedAirRefreshMethod(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward_x000a_= 0x44 (for a full list of the predefined_x000a_patterns, see the table in the subsection defining the detailed requirements for this property.<br>
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
		protected void onSetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward_x000a_= 0x44 (for a full list of the predefined_x000a_patterns, see the table in the subsection defining the detailed requirements for this property.<br>
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
		protected void onGetAirFlowDirectionHorizontalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
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
		protected void onSetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
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
		protected void onGetAirFlowDirectionVerticalSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic swing of air flow setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br>
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
		protected void onSetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic swing of air flow setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br>
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
		protected void onGetAutomaticSwingOfAirFlowSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br>
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
		protected void onSetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br>
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
		protected void onGetAutomaticControlOfAirFlowDirectionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41_x000a_Air flow rate = 0x31.0x38<br>
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
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41_x000a_Air flow rate = 0x31.0x38<br>
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
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured value of room temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents :<br>
		 * Measured value of room temperature <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredValueOfRoomTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value of user remote control<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents :<br>
		 * Set temperature value of user remote control <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetSetTemperatureValueOfUserRemoteControl(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured value of room relative humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents :<br>
		 * Measured value of room relative humidity <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredValueOfRoomRelativeHumidity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRelativeTemperatureSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cooled air temperature<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured cooled air temperature at the outlet. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredCooledAirTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured outdoor air temperature<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured outdoor air temperature. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredOutdoorAirTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		protected void onSetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		protected void onGetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status<br>
		 * <br>
		 * EPC : 0x80<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the ON/OFF status. <br>
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
		 * Set      - mandatory<br>
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
		 * This property indicates the ON/OFF status. <br>
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
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		protected void onSetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		protected void onGetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated power consumption<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents :<br>
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)_x000a_Cooling: heating: dehumidifying: blast<br>
		 * <br>
		 * Data type : unsigned short × 4<br>
		 * Data size : 8<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRatedPowerConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured value of current consumption<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents :<br>
		 * Measured value of current consumption <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredValueOfCurrentConsumption(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the type of operation_x000a_(“normal,” “high-speed” or “silent”),_x000a_and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41 High-speed operation: 0x42_x000a_Silent operation: 0x43<br>
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
		protected void onSetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the type of operation_x000a_(“normal,” “high-speed” or “silent”),_x000a_and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41 High-speed operation: 0x42_x000a_Silent operation: 0x43<br>
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
		protected void onGetNormalHighSpeedSilentOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetSetTemperatureValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetSetTemperatureValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification,” “air circulator” or “other”), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41_x000a_Cooling: 0x42 Heating: 0x43_x000a_Dehumidification: 0x44 Air circulator: 0x45_x000a_Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification,” “air circulator” or “other”), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41_x000a_Cooling: 0x42 Heating: 0x43_x000a_Dehumidification: 0x44 Air circulator: 0x45_x000a_Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41 Non-automatic = 0x42<br>
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
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41 Non-automatic = 0x42<br>
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
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetSetTemperatureValueInHeatingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetSetTemperatureValueInDehumidifyingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetSetValueOfRelativeHumidityInDehumidifyingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetSetTemperatureValueInCoolingMode(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Non-priority state<br>
		 * <br>
		 * EPC : 0xAB<br>
		 * <br>
		 * Contents :<br>
		 * Used to indicate when the air conditioner is in a “non-priority” state. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40,_x000a_“Non-priority” state = 0x41<br>
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
		protected void onGetNonPriorityState(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates if the air conditioner is in a “special” state (i.e. the “defrosting,” “preheating,” or “heat removal” state). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40, “Defrosting” state = 0x41, “Preheating” state = 0x42,_x000a_“Heat removal” state = 0x43<br>
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
		protected void onGetSpecialState(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Thermostat setting override function<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - -<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetThermostatSettingOverrideFunction(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status of components<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the operation status of components of the air conditioner in a bitmap format. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Operation status of the compressor:_x000a_0: Not operating_x000a_1: In operation_x000a_Bit 1: Operation status of the thermostat:_x000a_0: Thermostat OFF_x000a_1: Thermostat ON Bits 2.7: Reserved for future use.<br>
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
		protected void onGetOperationStatusOfComponents(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the_x000a_HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the_x000a_HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the air purification mode setting ON/OFF and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON=0x41,OFF=0x42<br>
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
		protected void onSetAirPurificationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the air purification mode setting ON/OFF and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON=0x41,OFF=0x42<br>
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
		protected void onGetAirPurificationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Mounted self-cleaning method<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents :<br>
		 * A bitmap indicates mounted method for exercising self-cleaning function. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about ozone cleaning method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about drying method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
		protected void onGetMountedSelfCleaningMethod(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the “special function” to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44_x000a_0x45. : Reserved for future use.<br>
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
		protected void onSetSpecialFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the “special function” to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44_x000a_0x45. : Reserved for future use.<br>
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
		protected void onGetSpecialFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of_x000a_self-cleaning to achieve with the_x000a_self-cleaning function, and to acquire_x000a_the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function._x000a_Element 1: Indicates whether or not to use the drying-based self-cleaning function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetSelfCleaningFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of_x000a_self-cleaning to achieve with the_x000a_self-cleaning function, and to acquire_x000a_the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function._x000a_Element 1: Indicates whether or not to use the drying-based self-cleaning function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetSelfCleaningFunctionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

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
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41_x000a_Degree of humidification = 0x31.0x38<br>
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
		public Setter reqSetDegreeOfHumidificationSetting(byte[] edt) {
			reqSetProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air purifier function._x000a_Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char ×8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetAirPurifierFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
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
		public Setter reqSetHumidifierFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_HUMIDIFIER_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
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
		public Setter reqSetVentilationFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_VENTILATION_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31.0x38<br>
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
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			reqSetProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air refresher function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetAirRefresherFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward_x000a_= 0x44 (for a full list of the predefined_x000a_patterns, see the table in the subsection defining the detailed requirements for this property.<br>
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
		public Setter reqSetAirFlowDirectionHorizontalSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
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
		public Setter reqSetAirFlowDirectionVerticalSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Automatic swing of air flow setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br>
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
		public Setter reqSetAutomaticSwingOfAirFlowSetting(byte[] edt) {
			reqSetProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br>
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
		public Setter reqSetAutomaticControlOfAirFlowDirectionSetting(byte[] edt) {
			reqSetProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41_x000a_Air flow rate = 0x31.0x38<br>
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
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			reqSetProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME_, edt);
			return this;
		}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetRelativeTemperatureSetting(byte[] edt) {
			reqSetProperty(EPC_RELATIVE_TEMPERATURE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt) {
			reqSetProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_SETTING_TIME_, edt);
			return this;
		}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the type of operation_x000a_(“normal,” “high-speed” or “silent”),_x000a_and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41 High-speed operation: 0x42_x000a_Silent operation: 0x43<br>
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
		public Setter reqSetNormalHighSpeedSilentOperationSetting(byte[] edt) {
			reqSetProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetSetTemperatureValue(byte[] edt) {
			reqSetProperty(EPC_SET_TEMPERATURE_VALUE, edt);
			return this;
		}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification,” “air circulator” or “other”), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41_x000a_Cooling: 0x42 Heating: 0x43_x000a_Dehumidification: 0x44 Air circulator: 0x45_x000a_Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOperationModeSetting(byte[] edt) {
			reqSetProperty(EPC_OPERATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41 Non-automatic = 0x42<br>
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
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			reqSetProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetSetTemperatureValueInHeatingMode(byte[] edt) {
			reqSetProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE, edt);
			return this;
		}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetSetTemperatureValueInDehumidifyingMode(byte[] edt) {
			reqSetProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE, edt);
			return this;
		}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetSetValueOfRelativeHumidityInDehumidifyingMode(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE, edt);
			return this;
		}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetSetTemperatureValueInCoolingMode(byte[] edt) {
			reqSetProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE, edt);
			return this;
		}
		/**
		 * Property name : Thermostat setting override function<br>
		 * <br>
		 * EPC : 0xCE<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to allow the air conditioner to operate ignoring its thermostat setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal setting = 0x40, thermostat setting override function ON = 0x41, thermostat setting override function OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - -<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetThermostatSettingOverrideFunction(byte[] edt) {
			reqSetProperty(EPC_THERMOSTAT_SETTING_OVERRIDE_FUNCTION, edt);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the_x000a_HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			reqSetProperty(EPC_OFF_TIMER_SETTING_TIME_, edt);
			return this;
		}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the air purification mode setting ON/OFF and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON=0x41,OFF=0x42<br>
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
		public Setter reqSetAirPurificationModeSetting(byte[] edt) {
			reqSetProperty(EPC_AIR_PURIFICATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME_, edt);
			return this;
		}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the “special function” to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44_x000a_0x45. : Reserved for future use.<br>
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
		public Setter reqSetSpecialFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_SPECIAL_FUNCTION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of_x000a_self-cleaning to achieve with the_x000a_self-cleaning function, and to acquire_x000a_the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function._x000a_Element 1: Indicates whether or not to use the drying-based self-cleaning function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetSelfCleaningFunctionSetting(byte[] edt) {
			reqSetProperty(EPC_SELF_CLEANING_FUNCTION_SETTING, edt);
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
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41_x000a_Degree of humidification = 0x31.0x38<br>
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
		public Getter reqGetDegreeOfHumidificationSetting() {
			reqGetProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING);
			return this;
		}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air purifier function._x000a_Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char ×8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetAirPurifierFunctionSetting() {
			reqGetProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted air cleaning method<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents :<br>
		 * A bitmap indicates mounted method of exercising air cleaning function. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about electrical dust collection method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
		public Getter reqGetMountedAirCleaningMethod() {
			reqGetProperty(EPC_MOUNTED_AIR_CLEANING_METHOD);
			return this;
		}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
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
		public Getter reqGetHumidifierFunctionSetting() {
			reqGetProperty(EPC_HUMIDIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
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
		public Getter reqGetVentilationFunctionSetting() {
			reqGetProperty(EPC_VENTILATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31.0x38<br>
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
		public Getter reqGetVentilationAirFlowRateSetting() {
			reqGetProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air refresher function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetAirRefresherFunctionSetting() {
			reqGetProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted air refresh method<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents :<br>
		 * A bitmap indicates mounted method for exercising refresh function. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about minus ion method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
		public Getter reqGetMountedAirRefreshMethod() {
			reqGetProperty(EPC_MOUNTED_AIR_REFRESH_METHOD);
			return this;
		}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward_x000a_= 0x44 (for a full list of the predefined_x000a_patterns, see the table in the subsection defining the detailed requirements for this property.<br>
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
		public Getter reqGetAirFlowDirectionHorizontalSetting() {
			reqGetProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
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
		public Getter reqGetAirFlowDirectionVerticalSetting() {
			reqGetProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic swing of air flow setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br>
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
		public Getter reqGetAutomaticSwingOfAirFlowSetting() {
			reqGetProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br>
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
		public Getter reqGetAutomaticControlOfAirFlowDirectionSetting() {
			reqGetProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41_x000a_Air flow rate = 0x31.0x38<br>
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
		public Getter reqGetAirFlowRateSetting() {
			reqGetProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOffTimerSettingRelativeTime() {
			reqGetProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME_);
			return this;
		}
		/**
		 * Property name : Measured value of room temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents :<br>
		 * Measured value of room temperature <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredValueOfRoomTemperature() {
			reqGetProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Set temperature value of user remote control<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents :<br>
		 * Set temperature value of user remote control <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetSetTemperatureValueOfUserRemoteControl() {
			reqGetProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL);
			return this;
		}
		/**
		 * Property name : Measured value of room relative humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents :<br>
		 * Measured value of room relative humidity <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredValueOfRoomRelativeHumidity() {
			reqGetProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRelativeTemperatureSetting() {
			reqGetProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Measured cooled air temperature<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured cooled air temperature at the outlet. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredCooledAirTemperature() {
			reqGetProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured outdoor air temperature<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured outdoor air temperature. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredOutdoorAirTemperature() {
			reqGetProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		public Getter reqGetOffTimerBasedReservationSetting() {
			reqGetProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOnTimerSettingTime() {
			reqGetProperty(EPC_ON_TIMER_SETTING_TIME_);
			return this;
		}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		public Getter reqGetOnTimerBasedReservationSetting() {
			reqGetProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Rated power consumption<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents :<br>
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)_x000a_Cooling: heating: dehumidifying: blast<br>
		 * <br>
		 * Data type : unsigned short × 4<br>
		 * Data size : 8<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRatedPowerConsumption() {
			reqGetProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured value of current consumption<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents :<br>
		 * Measured value of current consumption <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredValueOfCurrentConsumption() {
			reqGetProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the type of operation_x000a_(“normal,” “high-speed” or “silent”),_x000a_and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41 High-speed operation: 0x42_x000a_Silent operation: 0x43<br>
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
		public Getter reqGetNormalHighSpeedSilentOperationSetting() {
			reqGetProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetSetTemperatureValue() {
			reqGetProperty(EPC_SET_TEMPERATURE_VALUE);
			return this;
		}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification,” “air circulator” or “other”), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41_x000a_Cooling: 0x42 Heating: 0x43_x000a_Dehumidification: 0x44 Air circulator: 0x45_x000a_Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOperationModeSetting() {
			reqGetProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41 Non-automatic = 0x42<br>
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
		public Getter reqGetAutomaticTemperatureControlSetting() {
			reqGetProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetSetTemperatureValueInHeatingMode() {
			reqGetProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetSetTemperatureValueInDehumidifyingMode() {
			reqGetProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetSetValueOfRelativeHumidityInDehumidifyingMode() {
			reqGetProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetSetTemperatureValueInCoolingMode() {
			reqGetProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE);
			return this;
		}
		/**
		 * Property name : Non-priority state<br>
		 * <br>
		 * EPC : 0xAB<br>
		 * <br>
		 * Contents :<br>
		 * Used to indicate when the air conditioner is in a “non-priority” state. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40,_x000a_“Non-priority” state = 0x41<br>
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
		public Getter reqGetNonPriorityState() {
			reqGetProperty(EPC_NON_PRIORITY_STATE);
			return this;
		}
		/**
		 * Property name : Special state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates if the air conditioner is in a “special” state (i.e. the “defrosting,” “preheating,” or “heat removal” state). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40, “Defrosting” state = 0x41, “Preheating” state = 0x42,_x000a_“Heat removal” state = 0x43<br>
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
		public Getter reqGetSpecialState() {
			reqGetProperty(EPC_SPECIAL_STATE);
			return this;
		}
		/**
		 * Property name : Operation status of components<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the operation status of components of the air conditioner in a bitmap format. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Operation status of the compressor:_x000a_0: Not operating_x000a_1: In operation_x000a_Bit 1: Operation status of the thermostat:_x000a_0: Thermostat OFF_x000a_1: Thermostat ON Bits 2.7: Reserved for future use.<br>
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
		public Getter reqGetOperationStatusOfComponents() {
			reqGetProperty(EPC_OPERATION_STATUS_OF_COMPONENTS);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the_x000a_HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOffTimerSettingTime() {
			reqGetProperty(EPC_OFF_TIMER_SETTING_TIME_);
			return this;
		}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the air purification mode setting ON/OFF and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON=0x41,OFF=0x42<br>
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
		public Getter reqGetAirPurificationModeSetting() {
			reqGetProperty(EPC_AIR_PURIFICATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted self-cleaning method<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents :<br>
		 * A bitmap indicates mounted method for exercising self-cleaning function. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about ozone cleaning method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about drying method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
		public Getter reqGetMountedSelfCleaningMethod() {
			reqGetProperty(EPC_MOUNTED_SELF_CLEANING_METHOD);
			return this;
		}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOnTimerSettingRelativeTime() {
			reqGetProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME_);
			return this;
		}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the “special function” to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44_x000a_0x45. : Reserved for future use.<br>
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
		public Getter reqGetSpecialFunctionSetting() {
			reqGetProperty(EPC_SPECIAL_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of_x000a_self-cleaning to achieve with the_x000a_self-cleaning function, and to acquire_x000a_the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function._x000a_Element 1: Indicates whether or not to use the drying-based self-cleaning function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetSelfCleaningFunctionSetting() {
			reqGetProperty(EPC_SELF_CLEANING_FUNCTION_SETTING);
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
		 * Property name : Degree of humidification setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the degree of humidification to achieve by selecting a level from among the predefined levels, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of the degree of humidification = 0x41_x000a_Degree of humidification = 0x31.0x38<br>
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
		public Informer reqInformDegreeOfHumidificationSetting() {
			reqInformProperty(EPC_DEGREE_OF_HUMIDIFICATION_SETTING);
			return this;
		}
		/**
		 * Property name : Air purifier function setting<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air purifier function, whether or not to use the air purifier function and the degree of air purification to achieve with the air purifier function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the electrical dust collection-based air purifier function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air purifier function._x000a_Elements 2 to 7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char ×8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformAirPurifierFunctionSetting() {
			reqInformProperty(EPC_AIR_PURIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted air cleaning method<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents :<br>
		 * A bitmap indicates mounted method of exercising air cleaning function. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about electrical dust collection method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
		public Informer reqInformMountedAirCleaningMethod() {
			reqInformProperty(EPC_MOUNTED_AIR_CLEANING_METHOD);
			return this;
		}
		/**
		 * Property name : Humidifier function setting<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the humidifier function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifier function ON = 0x41, Humidifier function OFF = 0x42<br>
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
		public Informer reqInformHumidifierFunctionSetting() {
			reqInformProperty(EPC_HUMIDIFIER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation function setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ventilation function, to specify the ventilation direction, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation function ON (outlet direction) = 0x41, ventilation function OFF = 0x42, ventilation function ON (intake direction) = 0x43<br>
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
		public Informer reqInformVentilationFunctionSetting() {
			reqInformProperty(EPC_VENTILATION_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the ventilation air flow rate by selecting a level from among the predefined levels, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic control of ventilation air flow rate = 0x41, ventilation air flow rate = 0x31.0x38<br>
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
		public Informer reqInformVentilationAirFlowRateSetting() {
			reqInformProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : Air refresher function setting<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of air refresher function, whether or not to use the air refresher function and the degree of air refreshing to achieve with the air refresher function, and to acquire the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the minus ion-based air refresher function._x000a_Element 1: Indicates whether or not to use the cluster ion-based air refresher function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformAirRefresherFunctionSetting() {
			reqInformProperty(EPC_AIR_REFRESHER_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted air refresh method<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents :<br>
		 * A bitmap indicates mounted method for exercising refresh function. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about minus ion method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about cluster ion method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
		public Informer reqInformMountedAirRefreshMethod() {
			reqInformProperty(EPC_MOUNTED_AIR_REFRESH_METHOD);
			return this;
		}
		/**
		 * Property name : Air flow direction (horizontal) setting<br>
		 * <br>
		 * EPC : 0xA5<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction(s) in the horizontal plane by selecting a pattern from among the 31 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rightward = 0x41, leftward = 0x42, central = 0x43, rightward and leftward_x000a_= 0x44 (for a full list of the predefined_x000a_patterns, see the table in the subsection defining the detailed requirements for this property.<br>
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
		public Informer reqInformAirFlowDirectionHorizontalSetting() {
			reqInformProperty(EPC_AIR_FLOW_DIRECTION_HORIZONTAL_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow direction (vertical) setting<br>
		 * <br>
		 * EPC : 0xA4<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow direction in the vertical plane by selecting a pattern from among the 5 predefined patterns, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Uppermost = 0x41, lowermost = 0x42, central = 0x43, midpoint between uppermost and central = 0x44, midpoint between lowermost and central = 0x45<br>
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
		public Informer reqInformAirFlowDirectionVerticalSetting() {
			reqInformProperty(EPC_AIR_FLOW_DIRECTION_VERTICAL_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic swing of air flow setting<br>
		 * <br>
		 * EPC : 0xA3<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow swing function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow swing function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow swing function not used = 0x31, used (vertical) = 0x41, used (horizontal) = 0x42, used (vertical and horizontal) = 0x43<br>
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
		public Informer reqInformAutomaticSwingOfAirFlowSetting() {
			reqInformProperty(EPC_AUTOMATIC_SWING_OF_AIR_FLOW_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic control of air flow direction setting<br>
		 * <br>
		 * EPC : 0xA1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic air flow direction control function, to specify the plane(s) (vertical and/or horizontal) in which the automatic air flow direction control function is to be used, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic = 0x42, automatic (vertical) = 0x43, automatic (horizontal) = 0x44<br>
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
		public Informer reqInformAutomaticControlOfAirFlowDirectionSetting() {
			reqInformProperty(EPC_AUTOMATIC_CONTROL_OF_AIR_FLOW_DIRECTION_SETTING);
			return this;
		}
		/**
		 * Property name : Air flow rate setting<br>
		 * <br>
		 * EPC : 0xA0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the air flow rate or use the function to automatically control the air flow rate, and to acquire the current setting. The air flow rate shall be selected from among the 8 predefined levels. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic air flow rate control function used = 0x41_x000a_Air flow rate = 0x31.0x38<br>
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
		public Informer reqInformAirFlowRateSetting() {
			reqInformProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOffTimerSettingRelativeTime() {
			reqInformProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME_);
			return this;
		}
		/**
		 * Property name : Measured value of room temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents :<br>
		 * Measured value of room temperature <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredValueOfRoomTemperature() {
			reqInformProperty(EPC_MEASURED_VALUE_OF_ROOM_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Set temperature value of user remote control<br>
		 * <br>
		 * EPC : 0xBC<br>
		 * <br>
		 * Contents :<br>
		 * Set temperature value of user remote control <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformSetTemperatureValueOfUserRemoteControl() {
			reqInformProperty(EPC_SET_TEMPERATURE_VALUE_OF_USER_REMOTE_CONTROL);
			return this;
		}
		/**
		 * Property name : Measured value of room relative humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents :<br>
		 * Measured value of room relative humidity <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredValueOfRoomRelativeHumidity() {
			reqInformProperty(EPC_MEASURED_VALUE_OF_ROOM_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Relative temperature setting<br>
		 * <br>
		 * EPC : 0xBF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative temperature relative to the target temperature for an air conditioner operation mode, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-12.7°C.12.5°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : 0.1°C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRelativeTemperatureSetting() {
			reqInformProperty(EPC_RELATIVE_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Property name : Measured cooled air temperature<br>
		 * <br>
		 * EPC : 0xBD<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured cooled air temperature at the outlet. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredCooledAirTemperature() {
			reqInformProperty(EPC_MEASURED_COOLED_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured outdoor air temperature<br>
		 * <br>
		 * EPC : 0xBE<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured outdoor air temperature. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.125°C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredOutdoorAirTemperature() {
			reqInformProperty(EPC_MEASURED_OUTDOOR_AIR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : OFF timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the OFF timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		public Informer reqInformOffTimerBasedReservationSetting() {
			reqInformProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOnTimerSettingTime() {
			reqInformProperty(EPC_ON_TIMER_SETTING_TIME_);
			return this;
		}
		/**
		 * Property name : ON timer-based reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the ON timer (time-based reservation function, relative time-based reservation function or both), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Both the time- and relative time-based reservation functions are ON = 0x41, both reservation functions are OFF = 0x42, time-based reservation function is ON = 0x43, relative time-based reservation function is ON = 0x44<br>
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
		public Informer reqInformOnTimerBasedReservationSetting() {
			reqInformProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Rated power consumption<br>
		 * <br>
		 * EPC : 0xB8<br>
		 * <br>
		 * Contents :<br>
		 * Rated power consumption in each operation mode of cooling/heating/dehumidifying/blast <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.65533W)_x000a_Cooling: heating: dehumidifying: blast<br>
		 * <br>
		 * Data type : unsigned short × 4<br>
		 * Data size : 8<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRatedPowerConsumption() {
			reqInformProperty(EPC_RATED_POWER_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Measured value of current consumption<br>
		 * <br>
		 * EPC : 0xB9<br>
		 * <br>
		 * Contents :<br>
		 * Measured value of current consumption <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredValueOfCurrentConsumption() {
			reqInformProperty(EPC_MEASURED_VALUE_OF_CURRENT_CONSUMPTION);
			return this;
		}
		/**
		 * Property name : Normal/high- speed/silent operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the type of operation_x000a_(“normal,” “high-speed” or “silent”),_x000a_and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Normal operation: 0x41 High-speed operation: 0x42_x000a_Silent operation: 0x43<br>
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
		public Informer reqInformNormalHighSpeedSilentOperationSetting() {
			reqInformProperty(EPC_NORMAL_HIGH_SPEED_SILENT_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Set temperature value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformSetTemperatureValue() {
			reqInformProperty(EPC_SET_TEMPERATURE_VALUE);
			return this;
		}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the operation mode (“automatic,” “cooling,” “heating,” “dehumidification,” “air circulator” or “other”), and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * The following values shall be used: Automatic: 0x41_x000a_Cooling: 0x42 Heating: 0x43_x000a_Dehumidification: 0x44 Air circulator: 0x45_x000a_Other: 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOperationModeSetting() {
			reqInformProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify whether or not to use the automatic temperature control function, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41 Non-automatic = 0x42<br>
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
		public Informer reqInformAutomaticTemperatureControlSetting() {
			reqInformProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : Set temperature value in heating mode<br>
		 * <br>
		 * EPC : 0xB6<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “heating” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformSetTemperatureValueInHeatingMode() {
			reqInformProperty(EPC_SET_TEMPERATURE_VALUE_IN_HEATING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB7<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformSetTemperatureValueInDehumidifyingMode() {
			reqInformProperty(EPC_SET_TEMPERATURE_VALUE_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Property name : Set value of relative humidity in dehumidifying mode<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative humidity for the “dehumidification” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformSetValueOfRelativeHumidityInDehumidifyingMode() {
			reqInformProperty(EPC_SET_VALUE_OF_RELATIVE_HUMIDITY_IN_DEHUMIDIFYING_MODE);
			return this;
		}
		/**
		 * Property name : Set temperature value in cooling mode<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the temperature for the “cooling” mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x32 (0.50°C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : °C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformSetTemperatureValueInCoolingMode() {
			reqInformProperty(EPC_SET_TEMPERATURE_VALUE_IN_COOLING_MODE);
			return this;
		}
		/**
		 * Property name : Non-priority state<br>
		 * <br>
		 * EPC : 0xAB<br>
		 * <br>
		 * Contents :<br>
		 * Used to indicate when the air conditioner is in a “non-priority” state. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40,_x000a_“Non-priority” state = 0x41<br>
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
		public Informer reqInformNonPriorityState() {
			reqInformProperty(EPC_NON_PRIORITY_STATE);
			return this;
		}
		/**
		 * Property name : Special state<br>
		 * <br>
		 * EPC : 0xAA<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates if the air conditioner is in a “special” state (i.e. the “defrosting,” “preheating,” or “heat removal” state). <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * “Normal operation” state = 0x40, “Defrosting” state = 0x41, “Preheating” state = 0x42,_x000a_“Heat removal” state = 0x43<br>
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
		public Informer reqInformSpecialState() {
			reqInformProperty(EPC_SPECIAL_STATE);
			return this;
		}
		/**
		 * Property name : Operation status of components<br>
		 * <br>
		 * EPC : 0xCD<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the operation status of components of the air conditioner in a bitmap format. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Operation status of the compressor:_x000a_0: Not operating_x000a_1: In operation_x000a_Bit 1: Operation status of the thermostat:_x000a_0: Thermostat OFF_x000a_1: Thermostat ON Bits 2.7: Reserved for future use.<br>
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
		public Informer reqInformOperationStatusOfComponents() {
			reqInformProperty(EPC_OPERATION_STATUS_OF_COMPONENTS);
			return this;
		}
		/**
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the time for the_x000a_time-based reservation function in the_x000a_HH:MM format and to acquire the_x000a_current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOffTimerSettingTime() {
			reqInformProperty(EPC_OFF_TIMER_SETTING_TIME_);
			return this;
		}
		/**
		 * Property name : Air purification mode setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the air purification mode setting ON/OFF and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Air purification ON=0x41,OFF=0x42<br>
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
		public Informer reqInformAirPurificationModeSetting() {
			reqInformProperty(EPC_AIR_PURIFICATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Mounted self-cleaning method<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents :<br>
		 * A bitmap indicates mounted method for exercising self-cleaning function. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: Information about ozone cleaning method mounting_x000a_0 - Not mounted 1 - Mounted_x000a_Bit 1: Information about drying method mounting_x000a_0 - Not mounted 1 - Mounted<br>
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
		public Informer reqInformMountedSelfCleaningMethod() {
			reqInformProperty(EPC_MOUNTED_SELF_CLEANING_METHOD);
			return this;
		}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the relative time for the relative time-based reservation function in the HH:MM format and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B_x000a_(= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char × 2<br>
		 * Data size : 2<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOnTimerSettingRelativeTime() {
			reqInformProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME_);
			return this;
		}
		/**
		 * Property name : Special function setting<br>
		 * <br>
		 * EPC : 0xCC<br>
		 * <br>
		 * Contents :<br>
		 * Used to specify the “special function” to use, and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40, clothes dryer function: 0x41, condensation suppressor function: 0x42, mite and mold control function: 0x43, active defrosting function: 0x44_x000a_0x45. : Reserved for future use.<br>
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
		public Informer reqInformSpecialFunctionSetting() {
			reqInformProperty(EPC_SPECIAL_FUNCTION_SETTING);
			return this;
		}
		/**
		 * Property name : Self-cleaning function setting<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents :<br>
		 * An 8-byte array used to specify, for each type of self-cleaning function, whether or not to use the self-cleaning function and the degree of_x000a_self-cleaning to achieve with the_x000a_self-cleaning function, and to acquire_x000a_the current settings. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Element 0: Indicates whether or not to use the ozone-based self-cleaning function._x000a_Element 1: Indicates whether or not to use the drying-based self-cleaning function._x000a_Elements 2.7: Reserved for future use.<br>
		 * <br>
		 * Data type : unsigned char × 8<br>
		 * Data size : 8<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformSelfCleaningFunctionSetting() {
			reqInformProperty(EPC_SELF_CLEANING_FUNCTION_SETTING);
			return this;
		}

	}

	public static class Proxy extends HomeAirConditioner {
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
		protected byte[] getStatusChangeAnnouncementPropertyMap(){return null;}
		@Override
		protected boolean setOperationStatus(byte[] edt){return false;}
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
		@Override
		protected byte[] getSetPropertyMap(){return null;}
		@Override
		protected boolean setSetTemperatureValue(byte[] edt){return false;}
		@Override
		protected byte[] getSetTemperatureValue(){return null;}
		@Override
		protected boolean setOperationModeSetting(byte[] edt){return false;}
		@Override
		protected byte[] getOperationModeSetting(){return null;}
		@Override
		protected byte[] getManufacturerCode(){return null;}

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
