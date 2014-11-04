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
package com.sonycsl.echo.eoj.device.housingfacilities;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class BathroomHeaterAndDryer extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0273;

	public static final byte EPC__ON_TIMER_BASED_RESERVATION_SETTING_2 = (byte)0xE1;
	public static final byte EPC_HUMAN_BODY_DETECTION_STATUS = (byte)0xE0;
	public static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	public static final byte EPC_MEASURED_BATHROOM_TEMPERATURE = (byte)0xBB;
	public static final byte EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY = (byte)0xBA;
	public static final byte EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING = (byte)0xCF;
	public static final byte EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING = (byte)0xB2;
	public static final byte EPC_BATHROOM_HEATER_OPERATION_SETTING = (byte)0xB3;
	public static final byte EPC_OPERATION_SETTING = (byte)0xB0;
	public static final byte EPC_VENTILATION_OPERATION_SETTING = (byte)0xB1;
	public static final byte EPC_BATHROOM_DRYER_OPERATION_SETTING = (byte)0xB4;
	public static final byte EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING = (byte)0xB5;
	public static final byte EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ = (byte)0x96;
	public static final byte EPC_OFF_TIMER_SETTING_TIME_ = (byte)0x95;
	public static final byte EPC__OFF_X000A_TIMER_BASED_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME_ = (byte)0x92;
	public static final byte EPC_ON_TIMER_SETTING_TIME_ = (byte)0x91;
	public static final byte EPC__ON_TIMER_BASED_RESERVATION_SETTING_1 = (byte)0x90;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING);
		addGetProperty(EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING);
		addSetProperty(EPC_OPERATION_SETTING);
		addGetProperty(EPC_OPERATION_SETTING);
		addSetProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);
		addGetProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);

	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewBathroomHeaterAndDryer(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : “ON timer-based reservation” setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON for the ventilation mode                     : 0x10_x000a_Reservation function ON for the bathroom pre-warmer mode : 0x20_x000a_Reservation function ON for the bathroom heater mode         : 0x30_x000a_Reservation function ON for the bathroom dryer mode            : 0x40_x000a_Reservation function ON for the cool air circulator mode       : 0x50_x000a_Reservation function OFF : 0x00<br>
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
	protected boolean setOnTimerBasedReservationSetting2(byte[] edt) {return false;}
	/**
	 * Property name : “ON timer-based reservation” setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON for the ventilation mode                     : 0x10_x000a_Reservation function ON for the bathroom pre-warmer mode : 0x20_x000a_Reservation function ON for the bathroom heater mode         : 0x30_x000a_Reservation function ON for the bathroom dryer mode            : 0x40_x000a_Reservation function ON for the cool air circulator mode       : 0x50_x000a_Reservation function OFF : 0x00<br>
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
	protected byte[] getOnTimerBasedReservationSetting2() {return null;}
	/**
	 * Property name : “ON timer-based reservation” setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON for the ventilation mode                     : 0x10_x000a_Reservation function ON for the bathroom pre-warmer mode : 0x20_x000a_Reservation function ON for the bathroom heater mode         : 0x30_x000a_Reservation function ON for the bathroom dryer mode            : 0x40_x000a_Reservation function ON for the cool air circulator mode       : 0x50_x000a_Reservation function OFF : 0x00<br>
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
	protected boolean isValidOnTimerBasedReservationSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Human body detection status<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the human body detection status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected: 0x41 Not detected: 0x42<br>
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
	protected byte[] getHumanBodyDetectionStatus() {return null;}
	/**
	 * Property name : Human body detection status<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the human body detection status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected: 0x41 Not detected: 0x42<br>
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
	protected boolean isValidHumanBodyDetectionStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Ventilation air flow rate setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic: 0x41_x000a_Air flow rate level: 0x31.0x38<br>
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
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic: 0x41_x000a_Air flow rate level: 0x31.0x38<br>
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
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic: 0x41_x000a_Air flow rate level: 0x31.0x38<br>
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
	 * Property name : Measured bathroom temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the measured temperature of the bathroom. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.+125°C)<br>
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
	protected byte[] getMeasuredBathroomTemperature() {return null;}
	/**
	 * Property name : Measured bathroom temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the measured temperature of the bathroom. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81.0x7D (-127.+125°C)<br>
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
	protected boolean isValidMeasuredBathroomTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured relative bathroom humidity<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the measured relative humidity of the bathroom. <br>
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
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredRelativeBathroomHumidity() {return null;}
	/**
	 * Property name : Measured relative bathroom humidity<br>
	 * <br>
	 * EPC : 0xBA<br>
	 * <br>
	 * Contents :<br>
	 * Used to acquire the measured relative humidity of the bathroom. <br>
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
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredRelativeBathroomHumidity(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Filter cleaning reminder sign setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the filter cleaning reminder_x000a_sign status (lit/not lit) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Lit: 0x41 Not lit: 0x42<br>
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
	protected boolean setFilterCleaningReminderSignSetting(byte[] edt) {return false;}
	/**
	 * Property name : Filter cleaning reminder sign setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the filter cleaning reminder_x000a_sign status (lit/not lit) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Lit: 0x41 Not lit: 0x42<br>
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
	protected byte[] getFilterCleaningReminderSignSetting() {return null;}
	/**
	 * Property name : Filter cleaning reminder sign setting<br>
	 * <br>
	 * EPC : 0xCF<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the filter cleaning reminder_x000a_sign status (lit/not lit) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Lit: 0x41 Not lit: 0x42<br>
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
	protected boolean isValidFilterCleaningReminderSignSetting(byte[] edt) {
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
	 * ON           : 0x30_x000a_OFF          : 0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
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
	 * This property indicates the ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON           : 0x30_x000a_OFF          : 0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
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
	 * This property indicates the ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON           : 0x30_x000a_OFF          : 0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
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
	 * Property name : Bathroom pre-warmer_x000a_operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom pre-warming level_x000a_: 0x31.0x38<br>
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
	protected abstract boolean setBathroomPreWarmerX000AOperationSetting(byte[] edt);
	/**
	 * Property name : Bathroom pre-warmer_x000a_operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom pre-warming level_x000a_: 0x31.0x38<br>
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
	protected abstract byte[] getBathroomPreWarmerX000AOperationSetting();
	/**
	 * Property name : Bathroom pre-warmer_x000a_operation setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom pre-warming level_x000a_: 0x31.0x38<br>
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
	protected boolean isValidBathroomPreWarmerX000AOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Bathroom heater operation setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom heating level_x000a_: 0x31.0x38<br>
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
	protected boolean setBathroomHeaterOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bathroom heater operation setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom heating level_x000a_: 0x31.0x38<br>
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
	protected byte[] getBathroomHeaterOperationSetting() {return null;}
	/**
	 * Property name : Bathroom heater operation setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom heating level_x000a_: 0x31.0x38<br>
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
	protected boolean isValidBathroomHeaterOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Operation setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the operation mode (ventilation mode, bathroom_x000a_pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or “stop”), and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation operation              : 0x10 Bathroom pre-warmer operation :_x000a_0x20_x000a_Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br>
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
	protected abstract boolean setOperationSetting(byte[] edt);
	/**
	 * Property name : Operation setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the operation mode (ventilation mode, bathroom_x000a_pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or “stop”), and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation operation              : 0x10 Bathroom pre-warmer operation :_x000a_0x20_x000a_Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br>
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
	protected abstract byte[] getOperationSetting();
	/**
	 * Property name : Operation setting<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the operation mode (ventilation mode, bathroom_x000a_pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or “stop”), and to_x000a_acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Ventilation operation              : 0x10 Bathroom pre-warmer operation :_x000a_0x20_x000a_Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br>
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
	protected boolean isValidOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Ventilation operation setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42_x000a_Air flow rate level    : 0x31.0x38<br>
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
	protected boolean setVentilationOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ventilation operation setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42_x000a_Air flow rate level    : 0x31.0x38<br>
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
	protected byte[] getVentilationOperationSetting() {return null;}
	/**
	 * Property name : Ventilation operation setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42_x000a_Air flow rate level    : 0x31.0x38<br>
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
	protected boolean isValidVentilationOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Bathroom dryer operation setting<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom drying level_x000a_: 0x31.0x38<br>
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
	protected abstract boolean setBathroomDryerOperationSetting(byte[] edt);
	/**
	 * Property name : Bathroom dryer operation setting<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom drying level_x000a_: 0x31.0x38<br>
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
	protected abstract byte[] getBathroomDryerOperationSetting();
	/**
	 * Property name : Bathroom dryer operation setting<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom drying level_x000a_: 0x31.0x38<br>
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
	protected boolean isValidBathroomDryerOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Cool air circulator operation setting<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Cool air circulation level_x000a_: 0x31.0x38<br>
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
	protected boolean setCoolAirCirculatorOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Cool air circulator operation setting<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Cool air circulation level_x000a_: 0x31.0x38<br>
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
	protected byte[] getCoolAirCirculatorOperationSetting() {return null;}
	/**
	 * Property name : Cool air circulator operation setting<br>
	 * <br>
	 * EPC : 0xB5<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic        : 0x41_x000a_Standard          : 0x42 Cool air circulation level_x000a_: 0x31.0x38<br>
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
	protected boolean isValidCoolAirCirculatorOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : OFF timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the_x000a_HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the_x000a_HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the_x000a_HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Property name : OFF timer setting (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the time setting for the_x000a_time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Used to set the time setting for the_x000a_time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Used to set the time setting for the_x000a_time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Property name : “OFF_x000a_timer-based reservation” setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41 Reservation function OFF: 0x42<br>
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
	protected boolean setOffX000ATimerBasedReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : “OFF_x000a_timer-based reservation” setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41 Reservation function OFF: 0x42<br>
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
	protected byte[] getOffX000ATimerBasedReservationSetting() {return null;}
	/**
	 * Property name : “OFF_x000a_timer-based reservation” setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41 Reservation function OFF: 0x42<br>
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
	protected boolean isValidOffX000ATimerBasedReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : ON timer setting (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the relative time setting for_x000a_the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Used to set the relative time setting for_x000a_the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Used to set the relative time setting for_x000a_the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Property name : ON timer setting (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the time setting for the_x000a_time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Used to set the time setting for the_x000a_time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Used to set the time setting for the_x000a_time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
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
	 * Property name : “ON timer-based reservation” setting 1<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ON/OFF status of the_x000a_ON timer-based reservation function and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41_x000a_Reservation function OFF: 0x42<br>
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
	protected boolean setOnTimerBasedReservationSetting1(byte[] edt) {return false;}
	/**
	 * Property name : “ON timer-based reservation” setting 1<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ON/OFF status of the_x000a_ON timer-based reservation function and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41_x000a_Reservation function OFF: 0x42<br>
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
	protected byte[] getOnTimerBasedReservationSetting1() {return null;}
	/**
	 * Property name : “ON timer-based reservation” setting 1<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents :<br>
	 * Used to set the ON/OFF status of the_x000a_ON timer-based reservation function and to acquire the current setting. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation function ON: 0x41_x000a_Reservation function OFF: 0x42<br>
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
	protected boolean isValidOnTimerBasedReservationSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC__ON_TIMER_BASED_RESERVATION_SETTING_2 : return setOnTimerBasedReservationSetting2(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return setVentilationAirFlowRateSetting(property.edt);
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : return setFilterCleaningReminderSignSetting(property.edt);
		case EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING : return setBathroomPreWarmerX000AOperationSetting(property.edt);
		case EPC_BATHROOM_HEATER_OPERATION_SETTING : return setBathroomHeaterOperationSetting(property.edt);
		case EPC_OPERATION_SETTING : return setOperationSetting(property.edt);
		case EPC_VENTILATION_OPERATION_SETTING : return setVentilationOperationSetting(property.edt);
		case EPC_BATHROOM_DRYER_OPERATION_SETTING : return setBathroomDryerOperationSetting(property.edt);
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : return setCoolAirCirculatorOperationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : return setOffTimerSettingRelativeTime(property.edt);
		case EPC_OFF_TIMER_SETTING_TIME_ : return setOffTimerSettingTime(property.edt);
		case EPC__OFF_X000A_TIMER_BASED_RESERVATION_SETTING : return setOffX000ATimerBasedReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : return setOnTimerSettingRelativeTime(property.edt);
		case EPC_ON_TIMER_SETTING_TIME_ : return setOnTimerSettingTime(property.edt);
		case EPC__ON_TIMER_BASED_RESERVATION_SETTING_1 : return setOnTimerBasedReservationSetting1(property.edt);

		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC__ON_TIMER_BASED_RESERVATION_SETTING_2 : return getOnTimerBasedReservationSetting2();
		case EPC_HUMAN_BODY_DETECTION_STATUS : return getHumanBodyDetectionStatus();
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return getVentilationAirFlowRateSetting();
		case EPC_MEASURED_BATHROOM_TEMPERATURE : return getMeasuredBathroomTemperature();
		case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY : return getMeasuredRelativeBathroomHumidity();
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : return getFilterCleaningReminderSignSetting();
		case EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING : return getBathroomPreWarmerX000AOperationSetting();
		case EPC_BATHROOM_HEATER_OPERATION_SETTING : return getBathroomHeaterOperationSetting();
		case EPC_OPERATION_SETTING : return getOperationSetting();
		case EPC_VENTILATION_OPERATION_SETTING : return getVentilationOperationSetting();
		case EPC_BATHROOM_DRYER_OPERATION_SETTING : return getBathroomDryerOperationSetting();
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : return getCoolAirCirculatorOperationSetting();
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : return getOffTimerSettingRelativeTime();
		case EPC_OFF_TIMER_SETTING_TIME_ : return getOffTimerSettingTime();
		case EPC__OFF_X000A_TIMER_BASED_RESERVATION_SETTING : return getOffX000ATimerBasedReservationSetting();
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : return getOnTimerSettingRelativeTime();
		case EPC_ON_TIMER_SETTING_TIME_ : return getOnTimerSettingTime();
		case EPC__ON_TIMER_BASED_RESERVATION_SETTING_1 : return getOnTimerBasedReservationSetting1();

		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC__ON_TIMER_BASED_RESERVATION_SETTING_2 : return isValidOnTimerBasedReservationSetting2(property.edt);
		case EPC_HUMAN_BODY_DETECTION_STATUS : return isValidHumanBodyDetectionStatus(property.edt);
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : return isValidVentilationAirFlowRateSetting(property.edt);
		case EPC_MEASURED_BATHROOM_TEMPERATURE : return isValidMeasuredBathroomTemperature(property.edt);
		case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY : return isValidMeasuredRelativeBathroomHumidity(property.edt);
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : return isValidFilterCleaningReminderSignSetting(property.edt);
		case EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING : return isValidBathroomPreWarmerX000AOperationSetting(property.edt);
		case EPC_BATHROOM_HEATER_OPERATION_SETTING : return isValidBathroomHeaterOperationSetting(property.edt);
		case EPC_OPERATION_SETTING : return isValidOperationSetting(property.edt);
		case EPC_VENTILATION_OPERATION_SETTING : return isValidVentilationOperationSetting(property.edt);
		case EPC_BATHROOM_DRYER_OPERATION_SETTING : return isValidBathroomDryerOperationSetting(property.edt);
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : return isValidCoolAirCirculatorOperationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : return isValidOffTimerSettingRelativeTime(property.edt);
		case EPC_OFF_TIMER_SETTING_TIME_ : return isValidOffTimerSettingTime(property.edt);
		case EPC__OFF_X000A_TIMER_BASED_RESERVATION_SETTING : return isValidOffX000ATimerBasedReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : return isValidOnTimerSettingRelativeTime(property.edt);
		case EPC_ON_TIMER_SETTING_TIME_ : return isValidOnTimerSettingTime(property.edt);
		case EPC__ON_TIMER_BASED_RESERVATION_SETTING_1 : return isValidOnTimerBasedReservationSetting1(property.edt);

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
			case EPC__ON_TIMER_BASED_RESERVATION_SETTING_2 : 
				onSetOnTimerBasedReservationSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onSetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : 
				onSetFilterCleaningReminderSignSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING : 
				onSetBathroomPreWarmerX000AOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_HEATER_OPERATION_SETTING : 
				onSetBathroomHeaterOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_SETTING : 
				onSetOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_OPERATION_SETTING : 
				onSetVentilationOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_DRYER_OPERATION_SETTING : 
				onSetBathroomDryerOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : 
				onSetCoolAirCirculatorOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : 
				onSetOffTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_TIME_ : 
				onSetOffTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC__OFF_X000A_TIMER_BASED_RESERVATION_SETTING : 
				onSetOffX000ATimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : 
				onSetOnTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_TIME_ : 
				onSetOnTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC__ON_TIMER_BASED_RESERVATION_SETTING_1 : 
				onSetOnTimerBasedReservationSetting1(eoj, tid, esv, property, success);
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
			case EPC__ON_TIMER_BASED_RESERVATION_SETTING_2 : 
				onGetOnTimerBasedReservationSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMAN_BODY_DETECTION_STATUS : 
				onGetHumanBodyDetectionStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING : 
				onGetVentilationAirFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_BATHROOM_TEMPERATURE : 
				onGetMeasuredBathroomTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY : 
				onGetMeasuredRelativeBathroomHumidity(eoj, tid, esv, property, success);
				return true;
			case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING : 
				onGetFilterCleaningReminderSignSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING : 
				onGetBathroomPreWarmerX000AOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_HEATER_OPERATION_SETTING : 
				onGetBathroomHeaterOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_SETTING : 
				onGetOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_VENTILATION_OPERATION_SETTING : 
				onGetVentilationOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHROOM_DRYER_OPERATION_SETTING : 
				onGetBathroomDryerOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING : 
				onGetCoolAirCirculatorOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME_ : 
				onGetOffTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_TIME_ : 
				onGetOffTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC__OFF_X000A_TIMER_BASED_RESERVATION_SETTING : 
				onGetOffX000ATimerBasedReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME_ : 
				onGetOnTimerSettingRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_TIME_ : 
				onGetOnTimerSettingTime(eoj, tid, esv, property, success);
				return true;
			case EPC__ON_TIMER_BASED_RESERVATION_SETTING_1 : 
				onGetOnTimerBasedReservationSetting1(eoj, tid, esv, property, success);
				return true;

			default :
				return false;
			}
		}
		
		/**
		 * Property name : “ON timer-based reservation” setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                     : 0x10_x000a_Reservation function ON for the bathroom pre-warmer mode : 0x20_x000a_Reservation function ON for the bathroom heater mode         : 0x30_x000a_Reservation function ON for the bathroom dryer mode            : 0x40_x000a_Reservation function ON for the cool air circulator mode       : 0x50_x000a_Reservation function OFF : 0x00<br>
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
		protected void onSetOnTimerBasedReservationSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “ON timer-based reservation” setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                     : 0x10_x000a_Reservation function ON for the bathroom pre-warmer mode : 0x20_x000a_Reservation function ON for the bathroom heater mode         : 0x30_x000a_Reservation function ON for the bathroom dryer mode            : 0x40_x000a_Reservation function ON for the cool air circulator mode       : 0x50_x000a_Reservation function OFF : 0x00<br>
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
		protected void onGetOnTimerBasedReservationSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Human body detection status<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the human body detection status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected: 0x41 Not detected: 0x42<br>
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
		protected void onGetHumanBodyDetectionStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41_x000a_Air flow rate level: 0x31.0x38<br>
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
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41_x000a_Air flow rate level: 0x31.0x38<br>
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
		 * Property name : Measured bathroom temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the measured temperature of the bathroom. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.+125°C)<br>
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
		protected void onGetMeasuredBathroomTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured relative bathroom humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the measured relative humidity of the bathroom. <br>
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
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredRelativeBathroomHumidity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the filter cleaning reminder_x000a_sign status (lit/not lit) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41 Not lit: 0x42<br>
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
		protected void onSetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the filter cleaning reminder_x000a_sign status (lit/not lit) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41 Not lit: 0x42<br>
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
		protected void onGetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status<br>
		 * <br>
		 * EPC : 0x80<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the ON/OFF status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON           : 0x30_x000a_OFF          : 0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
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
		 * This property indicates the ON/OFF status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON           : 0x30_x000a_OFF          : 0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
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
		 * Property name : Bathroom pre-warmer_x000a_operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom pre-warming level_x000a_: 0x31.0x38<br>
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
		protected void onSetBathroomPreWarmerX000AOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom pre-warmer_x000a_operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom pre-warming level_x000a_: 0x31.0x38<br>
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
		protected void onGetBathroomPreWarmerX000AOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom heating level_x000a_: 0x31.0x38<br>
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
		protected void onSetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom heating level_x000a_: 0x31.0x38<br>
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
		protected void onGetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the operation mode (ventilation mode, bathroom_x000a_pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or “stop”), and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation              : 0x10 Bathroom pre-warmer operation :_x000a_0x20_x000a_Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br>
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
		protected void onSetOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the operation mode (ventilation mode, bathroom_x000a_pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or “stop”), and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation              : 0x10 Bathroom pre-warmer operation :_x000a_0x20_x000a_Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br>
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
		protected void onGetOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42_x000a_Air flow rate level    : 0x31.0x38<br>
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
		protected void onSetVentilationOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42_x000a_Air flow rate level    : 0x31.0x38<br>
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
		protected void onGetVentilationOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom drying level_x000a_: 0x31.0x38<br>
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
		protected void onSetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom drying level_x000a_: 0x31.0x38<br>
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
		protected void onGetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Cool air circulation level_x000a_: 0x31.0x38<br>
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
		protected void onSetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Cool air circulation level_x000a_: 0x31.0x38<br>
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
		protected void onGetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the_x000a_HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the_x000a_HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the time setting for the_x000a_time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Used to set the time setting for the_x000a_time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : “OFF_x000a_timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41 Reservation function OFF: 0x42<br>
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
		protected void onSetOffX000ATimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “OFF_x000a_timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41 Reservation function OFF: 0x42<br>
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
		protected void onGetOffX000ATimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative time setting for_x000a_the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Used to set the relative time setting for_x000a_the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the time setting for the_x000a_time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Used to set the time setting for the_x000a_time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : “ON timer-based reservation” setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the_x000a_ON timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41_x000a_Reservation function OFF: 0x42<br>
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
		protected void onSetOnTimerBasedReservationSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “ON timer-based reservation” setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the_x000a_ON timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41_x000a_Reservation function OFF: 0x42<br>
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
		protected void onGetOnTimerBasedReservationSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

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
		 * Property name : “ON timer-based reservation” setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                     : 0x10_x000a_Reservation function ON for the bathroom pre-warmer mode : 0x20_x000a_Reservation function ON for the bathroom heater mode         : 0x30_x000a_Reservation function ON for the bathroom dryer mode            : 0x40_x000a_Reservation function ON for the cool air circulator mode       : 0x50_x000a_Reservation function OFF : 0x00<br>
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
		public Setter reqSetOnTimerBasedReservationSetting2(byte[] edt) {
			reqSetProperty(EPC__ON_TIMER_BASED_RESERVATION_SETTING_2, edt);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41_x000a_Air flow rate level: 0x31.0x38<br>
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
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the filter cleaning reminder_x000a_sign status (lit/not lit) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41 Not lit: 0x42<br>
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
		public Setter reqSetFilterCleaningReminderSignSetting(byte[] edt) {
			reqSetProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bathroom pre-warmer_x000a_operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom pre-warming level_x000a_: 0x31.0x38<br>
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
		public Setter reqSetBathroomPreWarmerX000AOperationSetting(byte[] edt) {
			reqSetProperty(EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom heating level_x000a_: 0x31.0x38<br>
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
		public Setter reqSetBathroomHeaterOperationSetting(byte[] edt) {
			reqSetProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the operation mode (ventilation mode, bathroom_x000a_pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or “stop”), and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation              : 0x10 Bathroom pre-warmer operation :_x000a_0x20_x000a_Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br>
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
		public Setter reqSetOperationSetting(byte[] edt) {
			reqSetProperty(EPC_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42_x000a_Air flow rate level    : 0x31.0x38<br>
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
		public Setter reqSetVentilationOperationSetting(byte[] edt) {
			reqSetProperty(EPC_VENTILATION_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom drying level_x000a_: 0x31.0x38<br>
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
		public Setter reqSetBathroomDryerOperationSetting(byte[] edt) {
			reqSetProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Cool air circulation level_x000a_: 0x31.0x38<br>
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
		public Setter reqSetCoolAirCirculatorOperationSetting(byte[] edt) {
			reqSetProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the_x000a_HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the time setting for the_x000a_time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : “OFF_x000a_timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41 Reservation function OFF: 0x42<br>
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
		public Setter reqSetOffX000ATimerBasedReservationSetting(byte[] edt) {
			reqSetProperty(EPC__OFF_X000A_TIMER_BASED_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative time setting for_x000a_the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the time setting for the_x000a_time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : “ON timer-based reservation” setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the_x000a_ON timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41_x000a_Reservation function OFF: 0x42<br>
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
		public Setter reqSetOnTimerBasedReservationSetting1(byte[] edt) {
			reqSetProperty(EPC__ON_TIMER_BASED_RESERVATION_SETTING_1, edt);
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
		 * Property name : “ON timer-based reservation” setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                     : 0x10_x000a_Reservation function ON for the bathroom pre-warmer mode : 0x20_x000a_Reservation function ON for the bathroom heater mode         : 0x30_x000a_Reservation function ON for the bathroom dryer mode            : 0x40_x000a_Reservation function ON for the cool air circulator mode       : 0x50_x000a_Reservation function OFF : 0x00<br>
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
		public Getter reqGetOnTimerBasedReservationSetting2() {
			reqGetProperty(EPC__ON_TIMER_BASED_RESERVATION_SETTING_2);
			return this;
		}
		/**
		 * Property name : Human body detection status<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the human body detection status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected: 0x41 Not detected: 0x42<br>
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
		public Getter reqGetHumanBodyDetectionStatus() {
			reqGetProperty(EPC_HUMAN_BODY_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41_x000a_Air flow rate level: 0x31.0x38<br>
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
		 * Property name : Measured bathroom temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the measured temperature of the bathroom. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.+125°C)<br>
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
		public Getter reqGetMeasuredBathroomTemperature() {
			reqGetProperty(EPC_MEASURED_BATHROOM_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured relative bathroom humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the measured relative humidity of the bathroom. <br>
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
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredRelativeBathroomHumidity() {
			reqGetProperty(EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the filter cleaning reminder_x000a_sign status (lit/not lit) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41 Not lit: 0x42<br>
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
		public Getter reqGetFilterCleaningReminderSignSetting() {
			reqGetProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom pre-warmer_x000a_operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom pre-warming level_x000a_: 0x31.0x38<br>
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
		public Getter reqGetBathroomPreWarmerX000AOperationSetting() {
			reqGetProperty(EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom heating level_x000a_: 0x31.0x38<br>
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
		public Getter reqGetBathroomHeaterOperationSetting() {
			reqGetProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the operation mode (ventilation mode, bathroom_x000a_pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or “stop”), and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation              : 0x10 Bathroom pre-warmer operation :_x000a_0x20_x000a_Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br>
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
		public Getter reqGetOperationSetting() {
			reqGetProperty(EPC_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42_x000a_Air flow rate level    : 0x31.0x38<br>
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
		public Getter reqGetVentilationOperationSetting() {
			reqGetProperty(EPC_VENTILATION_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom drying level_x000a_: 0x31.0x38<br>
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
		public Getter reqGetBathroomDryerOperationSetting() {
			reqGetProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Cool air circulation level_x000a_: 0x31.0x38<br>
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
		public Getter reqGetCoolAirCirculatorOperationSetting() {
			reqGetProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the_x000a_HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the time setting for the_x000a_time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : “OFF_x000a_timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41 Reservation function OFF: 0x42<br>
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
		public Getter reqGetOffX000ATimerBasedReservationSetting() {
			reqGetProperty(EPC__OFF_X000A_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative time setting for_x000a_the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the time setting for the_x000a_time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : “ON timer-based reservation” setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the_x000a_ON timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41_x000a_Reservation function OFF: 0x42<br>
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
		public Getter reqGetOnTimerBasedReservationSetting1() {
			reqGetProperty(EPC__ON_TIMER_BASED_RESERVATION_SETTING_1);
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
		 * Property name : “ON timer-based reservation” setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON for the ventilation mode                     : 0x10_x000a_Reservation function ON for the bathroom pre-warmer mode : 0x20_x000a_Reservation function ON for the bathroom heater mode         : 0x30_x000a_Reservation function ON for the bathroom dryer mode            : 0x40_x000a_Reservation function ON for the cool air circulator mode       : 0x50_x000a_Reservation function OFF : 0x00<br>
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
		public Informer reqInformOnTimerBasedReservationSetting2() {
			reqInformProperty(EPC__ON_TIMER_BASED_RESERVATION_SETTING_2);
			return this;
		}
		/**
		 * Property name : Human body detection status<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the human body detection status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected: 0x41 Not detected: 0x42<br>
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
		public Informer reqInformHumanBodyDetectionStatus() {
			reqInformProperty(EPC_HUMAN_BODY_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : Ventilation air flow rate setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic: 0x41_x000a_Air flow rate level: 0x31.0x38<br>
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
		 * Property name : Measured bathroom temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the measured temperature of the bathroom. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81.0x7D (-127.+125°C)<br>
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
		public Informer reqInformMeasuredBathroomTemperature() {
			reqInformProperty(EPC_MEASURED_BATHROOM_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured relative bathroom humidity<br>
		 * <br>
		 * EPC : 0xBA<br>
		 * <br>
		 * Contents :<br>
		 * Used to acquire the measured relative humidity of the bathroom. <br>
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
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredRelativeBathroomHumidity() {
			reqInformProperty(EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Filter cleaning reminder sign setting<br>
		 * <br>
		 * EPC : 0xCF<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the filter cleaning reminder_x000a_sign status (lit/not lit) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Lit: 0x41 Not lit: 0x42<br>
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
		public Informer reqInformFilterCleaningReminderSignSetting() {
			reqInformProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom pre-warmer_x000a_operation setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom pre-warming level_x000a_: 0x31.0x38<br>
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
		public Informer reqInformBathroomPreWarmerX000AOperationSetting() {
			reqInformProperty(EPC_BATHROOM_PRE_WARMER_X000A_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom heater operation setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom heating level_x000a_: 0x31.0x38<br>
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
		public Informer reqInformBathroomHeaterOperationSetting() {
			reqInformProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Operation setting<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the operation mode (ventilation mode, bathroom_x000a_pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or “stop”), and to_x000a_acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Ventilation operation              : 0x10 Bathroom pre-warmer operation :_x000a_0x20_x000a_Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br>
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
		public Informer reqInformOperationSetting() {
			reqInformProperty(EPC_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Ventilation operation setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42_x000a_Air flow rate level    : 0x31.0x38<br>
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
		public Informer reqInformVentilationOperationSetting() {
			reqInformProperty(EPC_VENTILATION_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Bathroom dryer operation setting<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Bathroom drying level_x000a_: 0x31.0x38<br>
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
		public Informer reqInformBathroomDryerOperationSetting() {
			reqInformProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Cool air circulator operation setting<br>
		 * <br>
		 * EPC : 0xB5<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic        : 0x41_x000a_Standard          : 0x42 Cool air circulation level_x000a_: 0x31.0x38<br>
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
		public Informer reqInformCoolAirCirculatorOperationSetting() {
			reqInformProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the_x000a_HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : OFF timer setting (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the time setting for the_x000a_time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : “OFF_x000a_timer-based reservation” setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41 Reservation function OFF: 0x42<br>
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
		public Informer reqInformOffX000ATimerBasedReservationSetting() {
			reqInformProperty(EPC__OFF_X000A_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the relative time setting for_x000a_the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : ON timer setting (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the time setting for the_x000a_time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
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
		 * Property name : “ON timer-based reservation” setting 1<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents :<br>
		 * Used to set the ON/OFF status of the_x000a_ON timer-based reservation function and to acquire the current setting. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation function ON: 0x41_x000a_Reservation function OFF: 0x42<br>
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
		public Informer reqInformOnTimerBasedReservationSetting1() {
			reqInformProperty(EPC__ON_TIMER_BASED_RESERVATION_SETTING_1);
			return this;
		}

	}

	public static class Proxy extends BathroomHeaterAndDryer {
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
		protected byte[] getManufacturerCode(){return null;}
		@Override
		protected boolean setBathroomPreWarmerX000AOperationSetting(byte[] edt){return false;}
		@Override
		protected byte[] getBathroomPreWarmerX000AOperationSetting(){return null;}
		@Override
		protected boolean setOperationSetting(byte[] edt){return false;}
		@Override
		protected byte[] getOperationSetting(){return null;}
		@Override
		protected boolean setBathroomDryerOperationSetting(byte[] edt){return false;}
		@Override
		protected byte[] getBathroomDryerOperationSetting(){return null;}

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
