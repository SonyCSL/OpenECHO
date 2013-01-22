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

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class FloorHeater extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x027B;

	public static final byte EPC_TEMPERATURE_SETTING1 = (byte)0xE0;
	public static final byte EPC_TEMPERATURE_SETTING2 = (byte)0xE1;
	public static final byte EPC_MEASURED_ROOM_TEEMPERATURE = (byte)0xE2;
	public static final byte EPC_MEASURED_FLOOR_TEMPERATURE = (byte)0xE3;
	public static final byte EPC_ZONE_CHANGE_SETTING = (byte)0xE4;
	public static final byte EPC_SPECIAL_OPERATION_SETTING = (byte)0xE5;
	public static final byte EPC_DAILY_TIMER_SETTING = (byte)0xE6;
	public static final byte EPC_DAILY_TIMER_SETTING1 = (byte)0xE7;
	public static final byte EPC_DAILY_TIMER_SETTING2 = (byte)0xE8;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_TIME_SET_BY_ON_TIMER = (byte)0x91;
	public static final byte EPC_RELATIVE_ON_TIMER_SETTING = (byte)0x92;
	public static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_TIME_SET_BY_OFF_TIMER = (byte)0x95;
	public static final byte EPC_RELATIVE_OFF_TIMER_SETTING = (byte)0x96;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_TEMPERATURE_SETTING1);
		addGetProperty(EPC_TEMPERATURE_SETTING1);
		addSetProperty(EPC_TEMPERATURE_SETTING2);
		addGetProperty(EPC_TEMPERATURE_SETTING2);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewFloorHeater(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : �\<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationStatus(byte[] edt);
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 bytes<br>
	 * <br>
	 * Unit : �\<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Temperature setting 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x32�i0-50���j<br>
	 * AUTO��0x71<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : ��<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setTemperatureSetting1(byte[] edt);
	/**
	 * Property name : Temperature setting 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x32�i0-50���j<br>
	 * AUTO��0x71<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : ��<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getTemperatureSetting1();
	/**
	 * Property name : Temperature setting 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x32�i0-50���j<br>
	 * AUTO��0x71<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : ��<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidTemperatureSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Temperature setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set temperature level by 15 steps<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31-0x3F<br>
	 * 0x31 indicates the minimum level,<br>
	 * 0x3F indicates the maximumlevel<br>
	 * AUTO=0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setTemperatureSetting2(byte[] edt);
	/**
	 * Property name : Temperature setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set temperature level by 15 steps<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31-0x3F<br>
	 * 0x31 indicates the minimum level,<br>
	 * 0x3F indicates the maximumlevel<br>
	 * AUTO=0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getTemperatureSetting2();
	/**
	 * Property name : Temperature setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates set temperature level by 15 steps<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31-0x3F<br>
	 * 0x31 indicates the minimum level,<br>
	 * 0x3F indicates the maximumlevel<br>
	 * AUTO=0x41<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidTemperatureSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured room teemperature<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured room temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81-0x7D�i-127-125���j<br>
	 * <br>
	 * Data type : signed
char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : ��<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredRoomTeemperature() {return null;}
	/**
	 * Property name : Measured room teemperature<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured room temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81-0x7D�i-127-125���j<br>
	 * <br>
	 * Data type : signed
char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : ��<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredRoomTeemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured floor temperature<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured floor temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x32�i0-50���j<br>
	 * <br>
	 * Data type : unsigned
char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : ��<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredFloorTemperature() {return null;}
	/**
	 * Property name : Measured floor temperature<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Measured floor temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00-0x32�i0-50���j<br>
	 * <br>
	 * Data type : unsigned
char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : ��<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredFloorTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Zone change setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the target zone for control and gets the number of controllable zones<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * b0-b7 is allocated to 0 to 7<br>
	 * Each bit 1: with control, 0: without control<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setZoneChangeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Zone change setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the target zone for control and gets the number of controllable zones<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * b0-b7 is allocated to 0 to 7<br>
	 * Each bit 1: with control, 0: without control<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getZoneChangeSetting() {return null;}
	/**
	 * Property name : Zone change setting<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the target zone for control and gets the number of controllable zones<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * b0-b7 is allocated to 0 to 7<br>
	 * Each bit 1: with control, 0: without control<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidZoneChangeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Special operation setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Nornal Operation=0x41, modest<br>
	 * operation=0x42�high power<br>
	 * operation=0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSpecialOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Special operation setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Nornal Operation=0x41, modest<br>
	 * operation=0x42�high power<br>
	 * operation=0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSpecialOperationSetting() {return null;}
	/**
	 * Property name : Special operation setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Nornal Operation=0x41, modest<br>
	 * operation=0x42�high power<br>
	 * operation=0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSpecialOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Daily timer setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Daily timer ON/OFF<br>
	 * Up tp 2 kinds of timers can be used<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDailyTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Daily timer setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Daily timer ON/OFF<br>
	 * Up tp 2 kinds of timers can be used<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDailyTimerSetting() {return null;}
	/**
	 * Property name : Daily timer setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Daily timer ON/OFF<br>
	 * Up tp 2 kinds of timers can be used<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDailyTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Daily timer setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Time set by daily timer<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
	 * Each bit 1: worked 0: stopped<br>
	 * <br>
	 * Data type : unsigned char
x 6<br>
	 * <br>
	 * Data size : 6
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDailyTimerSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Daily timer setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Time set by daily timer<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
	 * Each bit 1: worked 0: stopped<br>
	 * <br>
	 * Data type : unsigned char
x 6<br>
	 * <br>
	 * Data size : 6
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDailyTimerSetting1() {return null;}
	/**
	 * Property name : Daily timer setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Time set by daily timer<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
	 * Each bit 1: worked 0: stopped<br>
	 * <br>
	 * Data type : unsigned char
x 6<br>
	 * <br>
	 * Data size : 6
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDailyTimerSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 6)) return false;
		return true;
	}
	/**
	 * Property name : Daily timer setting 2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Time set by daily timer<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
	 * Each bit 1: worked 0: stopped<br>
	 * <br>
	 * Data type : unsigned char
x 6<br>
	 * <br>
	 * Data size : 6
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDailyTimerSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Daily timer setting 2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Time set by daily timer<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
	 * Each bit 1: worked 0: stopped<br>
	 * <br>
	 * Data type : unsigned char
x 6<br>
	 * <br>
	 * Data size : 6
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDailyTimerSetting2() {return null;}
	/**
	 * Property name : Daily timer setting 2<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Time set by daily timer<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
	 * Each bit 1: worked 0: stopped<br>
	 * <br>
	 * Data type : unsigned char
x 6<br>
	 * <br>
	 * Data size : 6
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDailyTimerSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 6)) return false;
		return true;
	}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Time set by ON
timer<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
x 2<br>
	 * <br>
	 * Data size : 2
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTimeSetByOnTimer(byte[] edt) {return false;}
	/**
	 * Property name : Time set by ON
timer<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
x 2<br>
	 * <br>
	 * Data size : 2
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTimeSetByOnTimer() {return null;}
	/**
	 * Property name : Time set by ON
timer<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
x 2<br>
	 * <br>
	 * Data size : 2
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTimeSetByOnTimer(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Relative ON
timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
x 2<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRelativeOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Relative ON
timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
x 2<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRelativeOnTimerSetting() {return null;}
	/**
	 * Property name : Relative ON
timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
x 2<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRelativeOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON��0x41, OFF��0x42<br>
	 * <br>
	 * Data type : unsigned
char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON��0x41, OFF��0x42<br>
	 * <br>
	 * Data type : unsigned
char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	/**
	 * Property name : OFF timer reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON��0x41, OFF��0x42<br>
	 * <br>
	 * Data type : unsigned
char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Time set by OFF
timer<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17:  0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
�~2<br>
	 * <br>
	 * Data size : 2
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTimeSetByOffTimer(byte[] edt) {return false;}
	/**
	 * Property name : Time set by OFF
timer<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17:  0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
�~2<br>
	 * <br>
	 * Data size : 2
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTimeSetByOffTimer() {return null;}
	/**
	 * Property name : Time set by OFF
timer<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17:  0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
�~2<br>
	 * <br>
	 * Data size : 2
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTimeSetByOffTimer(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Relative OFF
timer setting<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17:  0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
�~2<br>
	 * <br>
	 * Data size : 2
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRelativeOffTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Relative OFF
timer setting<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17:  0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
�~2<br>
	 * <br>
	 * Data size : 2
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRelativeOffTimerSetting() {return null;}
	/**
	 * Property name : Relative OFF
timer setting<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17:  0-0x3B<br>
	 * (=0-23):(=0-59)<br>
	 * <br>
	 * Data type : unsigned char
�~2<br>
	 * <br>
	 * Data size : 2
Bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRelativeOffTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_TEMPERATURE_SETTING1 : return setTemperatureSetting1(property.edt);
		case EPC_TEMPERATURE_SETTING2 : return setTemperatureSetting2(property.edt);
		case EPC_ZONE_CHANGE_SETTING : return setZoneChangeSetting(property.edt);
		case EPC_SPECIAL_OPERATION_SETTING : return setSpecialOperationSetting(property.edt);
		case EPC_DAILY_TIMER_SETTING : return setDailyTimerSetting(property.edt);
		case EPC_DAILY_TIMER_SETTING1 : return setDailyTimerSetting1(property.edt);
		case EPC_DAILY_TIMER_SETTING2 : return setDailyTimerSetting2(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_TIME_SET_BY_ON_TIMER : return setTimeSetByOnTimer(property.edt);
		case EPC_RELATIVE_ON_TIMER_SETTING : return setRelativeOnTimerSetting(property.edt);
		case EPC_OFF_TIMER_RESERVATION_SETTING : return setOffTimerReservationSetting(property.edt);
		case EPC_TIME_SET_BY_OFF_TIMER : return setTimeSetByOffTimer(property.edt);
		case EPC_RELATIVE_OFF_TIMER_SETTING : return setRelativeOffTimerSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_TEMPERATURE_SETTING1 : return getTemperatureSetting1();
		case EPC_TEMPERATURE_SETTING2 : return getTemperatureSetting2();
		case EPC_MEASURED_ROOM_TEEMPERATURE : return getMeasuredRoomTeemperature();
		case EPC_MEASURED_FLOOR_TEMPERATURE : return getMeasuredFloorTemperature();
		case EPC_ZONE_CHANGE_SETTING : return getZoneChangeSetting();
		case EPC_SPECIAL_OPERATION_SETTING : return getSpecialOperationSetting();
		case EPC_DAILY_TIMER_SETTING : return getDailyTimerSetting();
		case EPC_DAILY_TIMER_SETTING1 : return getDailyTimerSetting1();
		case EPC_DAILY_TIMER_SETTING2 : return getDailyTimerSetting2();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_TIME_SET_BY_ON_TIMER : return getTimeSetByOnTimer();
		case EPC_RELATIVE_ON_TIMER_SETTING : return getRelativeOnTimerSetting();
		case EPC_OFF_TIMER_RESERVATION_SETTING : return getOffTimerReservationSetting();
		case EPC_TIME_SET_BY_OFF_TIMER : return getTimeSetByOffTimer();
		case EPC_RELATIVE_OFF_TIMER_SETTING : return getRelativeOffTimerSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_TEMPERATURE_SETTING1 : return isValidTemperatureSetting1(property.edt);
		case EPC_TEMPERATURE_SETTING2 : return isValidTemperatureSetting2(property.edt);
		case EPC_MEASURED_ROOM_TEEMPERATURE : return isValidMeasuredRoomTeemperature(property.edt);
		case EPC_MEASURED_FLOOR_TEMPERATURE : return isValidMeasuredFloorTemperature(property.edt);
		case EPC_ZONE_CHANGE_SETTING : return isValidZoneChangeSetting(property.edt);
		case EPC_SPECIAL_OPERATION_SETTING : return isValidSpecialOperationSetting(property.edt);
		case EPC_DAILY_TIMER_SETTING : return isValidDailyTimerSetting(property.edt);
		case EPC_DAILY_TIMER_SETTING1 : return isValidDailyTimerSetting1(property.edt);
		case EPC_DAILY_TIMER_SETTING2 : return isValidDailyTimerSetting2(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_TIME_SET_BY_ON_TIMER : return isValidTimeSetByOnTimer(property.edt);
		case EPC_RELATIVE_ON_TIMER_SETTING : return isValidRelativeOnTimerSetting(property.edt);
		case EPC_OFF_TIMER_RESERVATION_SETTING : return isValidOffTimerReservationSetting(property.edt);
		case EPC_TIME_SET_BY_OFF_TIMER : return isValidTimeSetByOffTimer(property.edt);
		case EPC_RELATIVE_OFF_TIMER_SETTING : return isValidRelativeOffTimerSetting(property.edt);
		default : return false;
		}
	}

	@Override
	public Setter set() {
		return new Setter(this, true, false);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(this, responseRequired, false);
	}

	@Override
	public Getter get() {
		return new Getter(this, false);
	}

	@Override
	public Informer inform() {
		return new Informer(this, !isProxy());
	}
	
	@Override
	protected Informer inform(boolean multicast) {
		return new Informer(this, multicast);
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_TEMPERATURE_SETTING1 : 
				onSetTemperatureSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING2 : 
				onSetTemperatureSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_ZONE_CHANGE_SETTING : 
				onSetZoneChangeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_OPERATION_SETTING : 
				onSetSpecialOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DAILY_TIMER_SETTING : 
				onSetDailyTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DAILY_TIMER_SETTING1 : 
				onSetDailyTimerSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_DAILY_TIMER_SETTING2 : 
				onSetDailyTimerSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TIME_SET_BY_ON_TIMER : 
				onSetTimeSetByOnTimer(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_ON_TIMER_SETTING : 
				onSetRelativeOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_RESERVATION_SETTING : 
				onSetOffTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TIME_SET_BY_OFF_TIMER : 
				onSetTimeSetByOffTimer(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_OFF_TIMER_SETTING : 
				onSetRelativeOffTimerSetting(eoj, tid, esv, property, success);
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
			case EPC_TEMPERATURE_SETTING1 : 
				onGetTemperatureSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_SETTING2 : 
				onGetTemperatureSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_ROOM_TEEMPERATURE : 
				onGetMeasuredRoomTeemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_FLOOR_TEMPERATURE : 
				onGetMeasuredFloorTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_ZONE_CHANGE_SETTING : 
				onGetZoneChangeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_OPERATION_SETTING : 
				onGetSpecialOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DAILY_TIMER_SETTING : 
				onGetDailyTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DAILY_TIMER_SETTING1 : 
				onGetDailyTimerSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_DAILY_TIMER_SETTING2 : 
				onGetDailyTimerSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TIME_SET_BY_ON_TIMER : 
				onGetTimeSetByOnTimer(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_ON_TIMER_SETTING : 
				onGetRelativeOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_RESERVATION_SETTING : 
				onGetOffTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TIME_SET_BY_OFF_TIMER : 
				onGetTimeSetByOffTimer(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_OFF_TIMER_SETTING : 
				onGetRelativeOffTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x32�i0-50���j<br>
		 * AUTO��0x71<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetTemperatureSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x32�i0-50���j<br>
		 * AUTO��0x71<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetTemperatureSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature level by 15 steps<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-0x3F<br>
		 * 0x31 indicates the minimum level,<br>
		 * 0x3F indicates the maximumlevel<br>
		 * AUTO=0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetTemperatureSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature level by 15 steps<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-0x3F<br>
		 * 0x31 indicates the minimum level,<br>
		 * 0x3F indicates the maximumlevel<br>
		 * AUTO=0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetTemperatureSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured room teemperature<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured room temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81-0x7D�i-127-125���j<br>
		 * <br>
		 * Data type : signed
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredRoomTeemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured floor temperature<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured floor temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x32�i0-50���j<br>
		 * <br>
		 * Data type : unsigned
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredFloorTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Zone change setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the target zone for control and gets the number of controllable zones<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * b0-b7 is allocated to 0 to 7<br>
		 * Each bit 1: with control, 0: without control<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetZoneChangeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Zone change setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the target zone for control and gets the number of controllable zones<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * b0-b7 is allocated to 0 to 7<br>
		 * Each bit 1: with control, 0: without control<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetZoneChangeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Nornal Operation=0x41, modest<br>
		 * operation=0x42�high power<br>
		 * operation=0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Nornal Operation=0x41, modest<br>
		 * operation=0x42�high power<br>
		 * operation=0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Daily timer setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Daily timer ON/OFF<br>
		 * Up tp 2 kinds of timers can be used<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDailyTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Daily timer setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Daily timer ON/OFF<br>
		 * Up tp 2 kinds of timers can be used<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDailyTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Daily timer setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Daily timer setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Daily timer setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Daily timer setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Time set by ON
timer<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Time set by ON
timer<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON��0x41, OFF��0x42<br>
		 * <br>
		 * Data type : unsigned
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON��0x41, OFF��0x42<br>
		 * <br>
		 * Data type : unsigned
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Time set by OFF
timer<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Time set by OFF
timer<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative OFF
timer setting<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative OFF
timer setting<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(EchoObject eoj, boolean responseRequired, boolean multicast) {
			super(eoj, responseRequired, multicast);
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
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x32�i0-50���j<br>
		 * AUTO��0x71<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetTemperatureSetting1(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature level by 15 steps<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-0x3F<br>
		 * 0x31 indicates the minimum level,<br>
		 * 0x3F indicates the maximumlevel<br>
		 * AUTO=0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetTemperatureSetting2(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Zone change setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the target zone for control and gets the number of controllable zones<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * b0-b7 is allocated to 0 to 7<br>
		 * Each bit 1: with control, 0: without control<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetZoneChangeSetting(byte[] edt) {
			addProperty(EPC_ZONE_CHANGE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Special operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Nornal Operation=0x41, modest<br>
		 * operation=0x42�high power<br>
		 * operation=0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSpecialOperationSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Daily timer setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Daily timer ON/OFF<br>
		 * Up tp 2 kinds of timers can be used<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDailyTimerSetting(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Daily timer setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDailyTimerSetting1(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Daily timer setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDailyTimerSetting2(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Time set by ON
timer<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTimeSetByOnTimer(byte[] edt) {
			addProperty(EPC_TIME_SET_BY_ON_TIMER, edt);
			return this;
		}
		/**
		 * Property name : Relative ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRelativeOnTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON��0x41, OFF��0x42<br>
		 * <br>
		 * Data type : unsigned
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Time set by OFF
timer<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTimeSetByOffTimer(byte[] edt) {
			addProperty(EPC_TIME_SET_BY_OFF_TIMER, edt);
			return this;
		}
		/**
		 * Property name : Relative OFF
timer setting<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRelativeOffTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
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
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x32�i0-50���j<br>
		 * AUTO��0x71<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetTemperatureSetting1() {
			addProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature level by 15 steps<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-0x3F<br>
		 * 0x31 indicates the minimum level,<br>
		 * 0x3F indicates the maximumlevel<br>
		 * AUTO=0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetTemperatureSetting2() {
			addProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		/**
		 * Property name : Measured room teemperature<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured room temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81-0x7D�i-127-125���j<br>
		 * <br>
		 * Data type : signed
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredRoomTeemperature() {
			addProperty(EPC_MEASURED_ROOM_TEEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured floor temperature<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured floor temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x32�i0-50���j<br>
		 * <br>
		 * Data type : unsigned
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredFloorTemperature() {
			addProperty(EPC_MEASURED_FLOOR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Zone change setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the target zone for control and gets the number of controllable zones<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * b0-b7 is allocated to 0 to 7<br>
		 * Each bit 1: with control, 0: without control<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetZoneChangeSetting() {
			addProperty(EPC_ZONE_CHANGE_SETTING);
			return this;
		}
		/**
		 * Property name : Special operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Nornal Operation=0x41, modest<br>
		 * operation=0x42�high power<br>
		 * operation=0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSpecialOperationSetting() {
			addProperty(EPC_SPECIAL_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Daily timer setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Daily timer ON/OFF<br>
		 * Up tp 2 kinds of timers can be used<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDailyTimerSetting() {
			addProperty(EPC_DAILY_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Daily timer setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDailyTimerSetting1() {
			addProperty(EPC_DAILY_TIMER_SETTING1);
			return this;
		}
		/**
		 * Property name : Daily timer setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDailyTimerSetting2() {
			addProperty(EPC_DAILY_TIMER_SETTING2);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Time set by ON
timer<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTimeSetByOnTimer() {
			addProperty(EPC_TIME_SET_BY_ON_TIMER);
			return this;
		}
		/**
		 * Property name : Relative ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRelativeOnTimerSetting() {
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON��0x41, OFF��0x42<br>
		 * <br>
		 * Data type : unsigned
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Time set by OFF
timer<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTimeSetByOffTimer() {
			addProperty(EPC_TIME_SET_BY_OFF_TIMER);
			return this;
		}
		/**
		 * Property name : Relative OFF
timer setting<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRelativeOffTimerSetting() {
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
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
		
		/**
		 * Property name : Temperature setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x32�i0-50���j<br>
		 * AUTO��0x71<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformTemperatureSetting1() {
			addProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		/**
		 * Property name : Temperature setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates set temperature level by 15 steps<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31-0x3F<br>
		 * 0x31 indicates the minimum level,<br>
		 * 0x3F indicates the maximumlevel<br>
		 * AUTO=0x41<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformTemperatureSetting2() {
			addProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		/**
		 * Property name : Measured room teemperature<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured room temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81-0x7D�i-127-125���j<br>
		 * <br>
		 * Data type : signed
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredRoomTeemperature() {
			addProperty(EPC_MEASURED_ROOM_TEEMPERATURE);
			return this;
		}
		/**
		 * Property name : Measured floor temperature<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Measured floor temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00-0x32�i0-50���j<br>
		 * <br>
		 * Data type : unsigned
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : ��<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredFloorTemperature() {
			addProperty(EPC_MEASURED_FLOOR_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Zone change setting<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the target zone for control and gets the number of controllable zones<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * b0-b7 is allocated to 0 to 7<br>
		 * Each bit 1: with control, 0: without control<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformZoneChangeSetting() {
			addProperty(EPC_ZONE_CHANGE_SETTING);
			return this;
		}
		/**
		 * Property name : Special operation setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Nornal Operation=0x41, modest<br>
		 * operation=0x42�high power<br>
		 * operation=0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSpecialOperationSetting() {
			addProperty(EPC_SPECIAL_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Daily timer setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Daily timer ON/OFF<br>
		 * Up tp 2 kinds of timers can be used<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDailyTimerSetting() {
			addProperty(EPC_DAILY_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Daily timer setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDailyTimerSetting1() {
			addProperty(EPC_DAILY_TIMER_SETTING1);
			return this;
		}
		/**
		 * Property name : Daily timer setting 2<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Time set by daily timer<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes.<br>
		 * Each bit 1: worked 0: stopped<br>
		 * <br>
		 * Data type : unsigned char
x 6<br>
		 * <br>
		 * Data size : 6
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDailyTimerSetting2() {
			addProperty(EPC_DAILY_TIMER_SETTING2);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Time set by ON
timer<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTimeSetByOnTimer() {
			addProperty(EPC_TIME_SET_BY_ON_TIMER);
			return this;
		}
		/**
		 * Property name : Relative ON
timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
x 2<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRelativeOnTimerSetting() {
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON��0x41, OFF��0x42<br>
		 * <br>
		 * Data type : unsigned
char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : Time set by OFF
timer<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTimeSetByOffTimer() {
			addProperty(EPC_TIME_SET_BY_OFF_TIMER);
			return this;
		}
		/**
		 * Property name : Relative OFF
timer setting<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17:  0-0x3B<br>
		 * (=0-23):(=0-59)<br>
		 * <br>
		 * Data type : unsigned char
�~2<br>
		 * <br>
		 * Data size : 2
Bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRelativeOffTimerSetting() {
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING);
			return this;
		}
	}

	public static class Proxy extends FloorHeater {
		private byte mInstanceCode;
		public Proxy(byte instanceCode) {
			super();
			mInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mInstanceCode;
		}
		@Override
		protected byte[] getOperationStatus() {return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt) {return false;}
		@Override
		protected byte[] getInstallationLocation() {return null;}
		@Override
		protected byte[] getStandardVersionInformation() {return null;}
		@Override
		protected byte[] getFaultStatus() {return null;}
		@Override
		protected byte[] getManufacturerCode() {return null;}
		@Override
		protected boolean setOperationStatus(byte[] edt) {return false;}
		@Override
		protected boolean setTemperatureSetting1(byte[] edt) {return false;}
		@Override
		protected byte[] getTemperatureSetting1() {return null;}
		@Override
		protected boolean setTemperatureSetting2(byte[] edt) {return false;}
		@Override
		protected byte[] getTemperatureSetting2() {return null;}
	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return new Setter(new Proxy(instanceCode), true, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(new Proxy(instanceCode), responseRequired, true);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(new Proxy(instanceCode), true);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(new Proxy(instanceCode), true);
	}

}
