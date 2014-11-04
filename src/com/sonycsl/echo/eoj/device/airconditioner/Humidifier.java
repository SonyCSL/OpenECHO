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

public abstract class Humidifier extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0139;

	public static final byte EPC_WATER_AMOUNT_LEVEL = (byte)0xC5;
	public static final byte EPC_SPECIAL_OPERATION_MODE_SETTING = (byte)0xC4;
	public static final byte EPC_HUMIDIFYING_SETTING_2 = (byte)0xC1;
	public static final byte EPC_HUMIDIFYING_SETTING_1 = (byte)0xC0;
	public static final byte EPC_IMPLEMENTED_ION_EMISSION_METHOD = (byte)0xC3;
	public static final byte EPC_ION_EMISSION_SETTING = (byte)0xC2;
	public static final byte EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY = (byte)0xB4;
	public static final byte EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER = (byte)0x96;
	public static final byte EPC_RESERVATION_SET_OF_OFF_TIMER = (byte)0x94;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addSetProperty(EPC_HUMIDIFYING_SETTING_2);
		addGetProperty(EPC_HUMIDIFYING_SETTING_2);
		addSetProperty(EPC_HUMIDIFYING_SETTING_1);
		addGetProperty(EPC_HUMIDIFYING_SETTING_1);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);

	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewHumidifier(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Water amount level<br>
	 * <br>
	 * EPC : 0xC5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates water amount level in water tank by 6 steps. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x40: empty_x000a_0x41.0x45: minimum to maximum level<br>
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
	protected byte[] getWaterAmountLevel() {return null;}
	/**
	 * Property name : Water amount level<br>
	 * <br>
	 * EPC : 0xC5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates water amount level in water tank by 6 steps. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x40: empty_x000a_0x41.0x45: minimum to maximum level<br>
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
	protected boolean isValidWaterAmountLevel(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Special operation mode setting<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents :<br>
	 * Sets special operation mode and gets setting status._x000a_Specifies by bit map <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation_x000a_Bit 2.7: for future reserved<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setSpecialOperationModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Special operation mode setting<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents :<br>
	 * Sets special operation mode and gets setting status._x000a_Specifies by bit map <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation_x000a_Bit 2.7: for future reserved<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getSpecialOperationModeSetting() {return null;}
	/**
	 * Property name : Special operation mode setting<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents :<br>
	 * Sets special operation mode and gets setting status._x000a_Specifies by bit map <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation_x000a_Bit 2.7: for future reserved<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidSpecialOperationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Humidifying setting 2<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents :<br>
	 * Sets humidifying level by 3 steps <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setHumidifyingSetting2(byte[] edt);
	/**
	 * Property name : Humidifying setting 2<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents :<br>
	 * Sets humidifying level by 3 steps <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getHumidifyingSetting2();
	/**
	 * Property name : Humidifying setting 2<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents :<br>
	 * Sets humidifying level by 3 steps <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidHumidifyingSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Humidifying setting 1<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents :<br>
	 * Sets value of relative humidity and get setting status <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64, (0.100%)_x000a_Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setHumidifyingSetting1(byte[] edt);
	/**
	 * Property name : Humidifying setting 1<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents :<br>
	 * Sets value of relative humidity and get setting status <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64, (0.100%)_x000a_Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getHumidifyingSetting1();
	/**
	 * Property name : Humidifying setting 1<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents :<br>
	 * Sets value of relative humidity and get setting status <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64, (0.100%)_x000a_Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidHumidifyingSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Implemented ion emission method<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents :<br>
	 * Sets ion emission method equipped in humidifier by bit map <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: negative ion method, Bit 1: cluster ion method,<br>
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
	protected byte[] getImplementedIonEmissionMethod() {return null;}
	/**
	 * Property name : Implemented ion emission method<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents :<br>
	 * Sets ion emission method equipped in humidifier by bit map <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bit 0: negative ion method, Bit 1: cluster ion method,<br>
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
	protected boolean isValidImplementedIonEmissionMethod(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Ion emission setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents :<br>
	 * Sets ON/OFF of ion emission and gets setting status <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emission ON= 0x41, OFF=0x42<br>
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
	protected boolean setIonEmissionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ion emission setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents :<br>
	 * Sets ON/OFF of ion emission and gets setting status <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emission ON= 0x41, OFF=0x42<br>
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
	protected byte[] getIonEmissionSetting() {return null;}
	/**
	 * Property name : Ion emission setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents :<br>
	 * Sets ON/OFF of ion emission and gets setting status <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emission ON= 0x41, OFF=0x42<br>
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
	protected boolean isValidIonEmissionSetting(byte[] edt) {
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
	 * Property name : Measured value of relative humidity<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates measured value of relative humidity <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64, (0.100%)<br>
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
	protected byte[] getMeasuredValueOfRelativeHumidity() {return null;}
	/**
	 * Property name : Measured value of relative humidity<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates measured value of relative humidity <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64, (0.100%)<br>
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
	protected boolean isValidMeasuredValueOfRelativeHumidity(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Relative time value set of OFF timer<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents :<br>
	 * Sets timer value HH:MM and   get updated time <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON =0x41, OFF =0x42<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
	 * Data size : 2<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setRelativeTimeValueSetOfOffTimer(byte[] edt) {return false;}
	/**
	 * Property name : Relative time value set of OFF timer<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents :<br>
	 * Sets timer value HH:MM and   get updated time <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON =0x41, OFF =0x42<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
	 * Data size : 2<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getRelativeTimeValueSetOfOffTimer() {return null;}
	/**
	 * Property name : Relative time value set of OFF timer<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents :<br>
	 * Sets timer value HH:MM and   get updated time <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON =0x41, OFF =0x42<br>
	 * <br>
	 * Data type : unsigned char_x000a_×2<br>
	 * Data size : 2<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRelativeTimeValueSetOfOffTimer(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Reservation set of OFF timer<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents :<br>
	 * Sets reservation ON/OFF and set setting status <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON =0x41, OFF =0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setReservationSetOfOffTimer(byte[] edt) {return false;}
	/**
	 * Property name : Reservation set of OFF timer<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents :<br>
	 * Sets reservation ON/OFF and set setting status <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON =0x41, OFF =0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getReservationSetOfOffTimer() {return null;}
	/**
	 * Property name : Reservation set of OFF timer<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents :<br>
	 * Sets reservation ON/OFF and set setting status <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON =0x41, OFF =0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidReservationSetOfOffTimer(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_SPECIAL_OPERATION_MODE_SETTING : return setSpecialOperationModeSetting(property.edt);
		case EPC_HUMIDIFYING_SETTING_2 : return setHumidifyingSetting2(property.edt);
		case EPC_HUMIDIFYING_SETTING_1 : return setHumidifyingSetting1(property.edt);
		case EPC_ION_EMISSION_SETTING : return setIonEmissionSetting(property.edt);
		case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER : return setRelativeTimeValueSetOfOffTimer(property.edt);
		case EPC_RESERVATION_SET_OF_OFF_TIMER : return setReservationSetOfOffTimer(property.edt);

		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_WATER_AMOUNT_LEVEL : return getWaterAmountLevel();
		case EPC_SPECIAL_OPERATION_MODE_SETTING : return getSpecialOperationModeSetting();
		case EPC_HUMIDIFYING_SETTING_2 : return getHumidifyingSetting2();
		case EPC_HUMIDIFYING_SETTING_1 : return getHumidifyingSetting1();
		case EPC_IMPLEMENTED_ION_EMISSION_METHOD : return getImplementedIonEmissionMethod();
		case EPC_ION_EMISSION_SETTING : return getIonEmissionSetting();
		case EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY : return getMeasuredValueOfRelativeHumidity();
		case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER : return getRelativeTimeValueSetOfOffTimer();
		case EPC_RESERVATION_SET_OF_OFF_TIMER : return getReservationSetOfOffTimer();

		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_WATER_AMOUNT_LEVEL : return isValidWaterAmountLevel(property.edt);
		case EPC_SPECIAL_OPERATION_MODE_SETTING : return isValidSpecialOperationModeSetting(property.edt);
		case EPC_HUMIDIFYING_SETTING_2 : return isValidHumidifyingSetting2(property.edt);
		case EPC_HUMIDIFYING_SETTING_1 : return isValidHumidifyingSetting1(property.edt);
		case EPC_IMPLEMENTED_ION_EMISSION_METHOD : return isValidImplementedIonEmissionMethod(property.edt);
		case EPC_ION_EMISSION_SETTING : return isValidIonEmissionSetting(property.edt);
		case EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY : return isValidMeasuredValueOfRelativeHumidity(property.edt);
		case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER : return isValidRelativeTimeValueSetOfOffTimer(property.edt);
		case EPC_RESERVATION_SET_OF_OFF_TIMER : return isValidReservationSetOfOffTimer(property.edt);

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
			case EPC_SPECIAL_OPERATION_MODE_SETTING : 
				onSetSpecialOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMIDIFYING_SETTING_2 : 
				onSetHumidifyingSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMIDIFYING_SETTING_1 : 
				onSetHumidifyingSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_ION_EMISSION_SETTING : 
				onSetIonEmissionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER : 
				onSetRelativeTimeValueSetOfOffTimer(eoj, tid, esv, property, success);
				return true;
			case EPC_RESERVATION_SET_OF_OFF_TIMER : 
				onSetReservationSetOfOffTimer(eoj, tid, esv, property, success);
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
			case EPC_WATER_AMOUNT_LEVEL : 
				onGetWaterAmountLevel(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_OPERATION_MODE_SETTING : 
				onGetSpecialOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMIDIFYING_SETTING_2 : 
				onGetHumidifyingSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMIDIFYING_SETTING_1 : 
				onGetHumidifyingSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_IMPLEMENTED_ION_EMISSION_METHOD : 
				onGetImplementedIonEmissionMethod(eoj, tid, esv, property, success);
				return true;
			case EPC_ION_EMISSION_SETTING : 
				onGetIonEmissionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY : 
				onGetMeasuredValueOfRelativeHumidity(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER : 
				onGetRelativeTimeValueSetOfOffTimer(eoj, tid, esv, property, success);
				return true;
			case EPC_RESERVATION_SET_OF_OFF_TIMER : 
				onGetReservationSetOfOffTimer(eoj, tid, esv, property, success);
				return true;

			default :
				return false;
			}
		}
		
		/**
		 * Property name : Water amount level<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates water amount level in water tank by 6 steps. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40: empty_x000a_0x41.0x45: minimum to maximum level<br>
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
		protected void onGetWaterAmountLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Sets special operation mode and gets setting status._x000a_Specifies by bit map <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation_x000a_Bit 2.7: for future reserved<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Sets special operation mode and gets setting status._x000a_Specifies by bit map <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation_x000a_Bit 2.7: for future reserved<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Humidifying setting 2<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Sets humidifying level by 3 steps <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetHumidifyingSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Humidifying setting 2<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Sets humidifying level by 3 steps <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetHumidifyingSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Humidifying setting 1<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Sets value of relative humidity and get setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64, (0.100%)_x000a_Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetHumidifyingSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Humidifying setting 1<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Sets value of relative humidity and get setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64, (0.100%)_x000a_Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetHumidifyingSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Implemented ion emission method<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents :<br>
		 * Sets ion emission method equipped in humidifier by bit map <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: negative ion method, Bit 1: cluster ion method,<br>
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
		protected void onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Sets ON/OFF of ion emission and gets setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON= 0x41, OFF=0x42<br>
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
		protected void onSetIonEmissionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Sets ON/OFF of ion emission and gets setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON= 0x41, OFF=0x42<br>
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
		protected void onGetIonEmissionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Measured value of relative humidity<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates measured value of relative humidity <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64, (0.100%)<br>
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
		protected void onGetMeasuredValueOfRelativeHumidity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative time value set of OFF timer<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Sets timer value HH:MM and   get updated time <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
		 * Data size : 2<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative time value set of OFF timer<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Sets timer value HH:MM and   get updated time <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
		 * Data size : 2<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Reservation set of OFF timer<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Sets reservation ON/OFF and set setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetReservationSetOfOffTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Reservation set of OFF timer<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Sets reservation ON/OFF and set setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetReservationSetOfOffTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

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
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Sets special operation mode and gets setting status._x000a_Specifies by bit map <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation_x000a_Bit 2.7: for future reserved<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetSpecialOperationModeSetting(byte[] edt) {
			reqSetProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Humidifying setting 2<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Sets humidifying level by 3 steps <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetHumidifyingSetting2(byte[] edt) {
			reqSetProperty(EPC_HUMIDIFYING_SETTING_2, edt);
			return this;
		}
		/**
		 * Property name : Humidifying setting 1<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Sets value of relative humidity and get setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64, (0.100%)_x000a_Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetHumidifyingSetting1(byte[] edt) {
			reqSetProperty(EPC_HUMIDIFYING_SETTING_1, edt);
			return this;
		}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Sets ON/OFF of ion emission and gets setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON= 0x41, OFF=0x42<br>
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
		public Setter reqSetIonEmissionSetting(byte[] edt) {
			reqSetProperty(EPC_ION_EMISSION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Relative time value set of OFF timer<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Sets timer value HH:MM and   get updated time <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
		 * Data size : 2<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetRelativeTimeValueSetOfOffTimer(byte[] edt) {
			reqSetProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER, edt);
			return this;
		}
		/**
		 * Property name : Reservation set of OFF timer<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Sets reservation ON/OFF and set setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetReservationSetOfOffTimer(byte[] edt) {
			reqSetProperty(EPC_RESERVATION_SET_OF_OFF_TIMER, edt);
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
		 * Property name : Water amount level<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates water amount level in water tank by 6 steps. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40: empty_x000a_0x41.0x45: minimum to maximum level<br>
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
		public Getter reqGetWaterAmountLevel() {
			reqGetProperty(EPC_WATER_AMOUNT_LEVEL);
			return this;
		}
		/**
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Sets special operation mode and gets setting status._x000a_Specifies by bit map <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation_x000a_Bit 2.7: for future reserved<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetSpecialOperationModeSetting() {
			reqGetProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Humidifying setting 2<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Sets humidifying level by 3 steps <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetHumidifyingSetting2() {
			reqGetProperty(EPC_HUMIDIFYING_SETTING_2);
			return this;
		}
		/**
		 * Property name : Humidifying setting 1<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Sets value of relative humidity and get setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64, (0.100%)_x000a_Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetHumidifyingSetting1() {
			reqGetProperty(EPC_HUMIDIFYING_SETTING_1);
			return this;
		}
		/**
		 * Property name : Implemented ion emission method<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents :<br>
		 * Sets ion emission method equipped in humidifier by bit map <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: negative ion method, Bit 1: cluster ion method,<br>
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
		public Getter reqGetImplementedIonEmissionMethod() {
			reqGetProperty(EPC_IMPLEMENTED_ION_EMISSION_METHOD);
			return this;
		}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Sets ON/OFF of ion emission and gets setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON= 0x41, OFF=0x42<br>
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
		public Getter reqGetIonEmissionSetting() {
			reqGetProperty(EPC_ION_EMISSION_SETTING);
			return this;
		}
		/**
		 * Property name : Measured value of relative humidity<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates measured value of relative humidity <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64, (0.100%)<br>
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
		public Getter reqGetMeasuredValueOfRelativeHumidity() {
			reqGetProperty(EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Relative time value set of OFF timer<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Sets timer value HH:MM and   get updated time <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
		 * Data size : 2<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRelativeTimeValueSetOfOffTimer() {
			reqGetProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER);
			return this;
		}
		/**
		 * Property name : Reservation set of OFF timer<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Sets reservation ON/OFF and set setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetReservationSetOfOffTimer() {
			reqGetProperty(EPC_RESERVATION_SET_OF_OFF_TIMER);
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
		 * Property name : Water amount level<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates water amount level in water tank by 6 steps. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40: empty_x000a_0x41.0x45: minimum to maximum level<br>
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
		public Informer reqInformWaterAmountLevel() {
			reqInformProperty(EPC_WATER_AMOUNT_LEVEL);
			return this;
		}
		/**
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * Sets special operation mode and gets setting status._x000a_Specifies by bit map <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation_x000a_Bit 2.7: for future reserved<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformSpecialOperationModeSetting() {
			reqInformProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Humidifying setting 2<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * Sets humidifying level by 3 steps <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformHumidifyingSetting2() {
			reqInformProperty(EPC_HUMIDIFYING_SETTING_2);
			return this;
		}
		/**
		 * Property name : Humidifying setting 1<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * Sets value of relative humidity and get setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64, (0.100%)_x000a_Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformHumidifyingSetting1() {
			reqInformProperty(EPC_HUMIDIFYING_SETTING_1);
			return this;
		}
		/**
		 * Property name : Implemented ion emission method<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents :<br>
		 * Sets ion emission method equipped in humidifier by bit map <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bit 0: negative ion method, Bit 1: cluster ion method,<br>
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
		public Informer reqInformImplementedIonEmissionMethod() {
			reqInformProperty(EPC_IMPLEMENTED_ION_EMISSION_METHOD);
			return this;
		}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * Sets ON/OFF of ion emission and gets setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON= 0x41, OFF=0x42<br>
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
		public Informer reqInformIonEmissionSetting() {
			reqInformProperty(EPC_ION_EMISSION_SETTING);
			return this;
		}
		/**
		 * Property name : Measured value of relative humidity<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates measured value of relative humidity <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64, (0.100%)<br>
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
		public Informer reqInformMeasuredValueOfRelativeHumidity() {
			reqInformProperty(EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Property name : Relative time value set of OFF timer<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents :<br>
		 * Sets timer value HH:MM and   get updated time <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char_x000a_×2<br>
		 * Data size : 2<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRelativeTimeValueSetOfOffTimer() {
			reqInformProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER);
			return this;
		}
		/**
		 * Property name : Reservation set of OFF timer<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents :<br>
		 * Sets reservation ON/OFF and set setting status <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON =0x41, OFF =0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformReservationSetOfOffTimer() {
			reqInformProperty(EPC_RESERVATION_SET_OF_OFF_TIMER);
			return this;
		}

	}

	public static class Proxy extends Humidifier {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getSetPropertyMap(){return null;}
		@Override
		protected byte[] getStatusChangeAnnouncementPropertyMap(){return null;}
		@Override
		protected boolean setHumidifyingSetting2(byte[] edt){return false;}
		@Override
		protected byte[] getHumidifyingSetting2(){return null;}
		@Override
		protected boolean setHumidifyingSetting1(byte[] edt){return false;}
		@Override
		protected byte[] getHumidifyingSetting1(){return null;}
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
		protected byte[] getGetPropertyMap(){return null;}
		@Override
		protected byte[] getFaultStatus(){return null;}
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
