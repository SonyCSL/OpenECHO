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
package com.sonycsl.echo.eoj.device.airconditioner;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class FanHeater extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0143;

	public static final byte EPC_TEMPERATURE_SETTING_VALUE = (byte)0xB3;
	public static final byte EPC_MEASURED_TEMPERATURE = (byte)0xBB;
	public static final byte EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING = (byte)0xB1;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING_VALUE_TIME = (byte)0x91;
	public static final byte EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME = (byte)0x92;
	public static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_OFF_TIMER_SETTING_VALUE_TIME = (byte)0x95;
	public static final byte EPC_OFF_TIMER_VALUE_RELATIVE_TIME = (byte)0x96;
	public static final byte EPC_EXTENTIONAL_OPERATION_SETTING = (byte)0xC0;
	public static final byte EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE = (byte)0xC1;
	public static final byte EPC_ION_EMISSION_SETTING = (byte)0xC2;
	public static final byte EPC_IMPLEMENTED_ION_EMISSION_METHOD = (byte)0xC3;
	public static final byte EPC_OIL_AMOUNT_LEVEL = (byte)0xC4;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_TEMPERATURE_SETTING_VALUE);
		addGetProperty(EPC_TEMPERATURE_SETTING_VALUE);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewFanHeater(this);
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
	 * This  property  indicates  the  ON/OFF<br>
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
	 * This  property  indicates  the  ON/OFF<br>
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
	 * Property name : Temperature setting value<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the temperature and gets the setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50��C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setTemperatureSettingValue(byte[] edt);
	/**
	 * Property name : Temperature setting value<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the temperature and gets the setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50��C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getTemperatureSettingValue();
	/**
	 * Property name : Temperature setting value<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the temperature and gets the setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 to 0x32 (0 to 50��C)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidTemperatureSettingValue(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured room temperature.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (-128 to 125��C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredTemperature() {return null;}
	/**
	 * Property name : Measured temperature<br>
	 * <br>
	 * EPC : 0xBB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured room temperature.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x81 to 0x7D (-128 to 125��C)<br>
	 * <br>
	 * Data type : signed char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : . C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredTemperature(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Automatic temperature control setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets automatic / non-automatic and gets the setting status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41, non-automatic =<br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	/**
	 * Property name : Automatic temperature control setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets automatic / non-automatic and gets the setting status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41, non-automatic =<br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	/**
	 * Property name : Automatic temperature control setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets automatic / non-automatic and gets the setting status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Automatic = 0x41, non-automatic =<br>
	 * 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidAutomaticTemperatureControlSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets ON/OFF of reservation and gets the setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
	 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
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
	 * Sets ON/OFF of reservation and gets the setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
	 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
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
	 * Sets ON/OFF of reservation and gets the setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
	 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
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
	 * Property name : ON timer setting value (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets setting status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSettingValueTime(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting value (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets setting status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSettingValueTime() {return null;}
	/**
	 * Property name : ON timer setting value (time)<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets setting status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSettingValueTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : ON timer setting value (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets the updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSettingValueRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting value (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets the updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSettingValueRelativeTime() {return null;}
	/**
	 * Property name : ON timer setting value (relative time)<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets the updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSettingValueRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets ON/OFF of reservation and gets setting status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
	 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
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
	 * Sets ON/OFF of reservation and gets setting status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
	 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
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
	 * Sets ON/OFF of reservation and gets setting status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
	 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
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
	 * Property name : OFF timer setting value (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets the setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerSettingValueTime(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer setting value (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets the setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerSettingValueTime() {return null;}
	/**
	 * Property name : OFF timer setting value (time)<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets the setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17: 0 to 0x3B<br>
	 * (= 0 to 23): (= 0 to 59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerSettingValueTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer value
( relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerValueRelativeTime(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer value
( relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerValueRelativeTime() {return null;}
	/**
	 * Property name : OFF timer value
( relative time)<br>
	 * <br>
	 * EPC : 0x96<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets timer value HH:MM and gets updated time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerValueRelativeTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Extentional operation setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets ON/OFF of extensional operation and gets setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Extension ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setExtentionalOperationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Extentional operation setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets ON/OFF of extensional operation and gets setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Extension ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getExtentionalOperationSetting() {return null;}
	/**
	 * Property name : Extentional operation setting<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets ON/OFF of extensional operation and gets setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Extension ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidExtentionalOperationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Extentional operation timer time setting value<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * Setsextension time HH:MM and gets the extended time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B<br>
	 * (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setExtentionalOperationTimerTimeSettingValue(byte[] edt) {return false;}
	/**
	 * Property name : Extentional operation timer time setting value<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * Setsextension time HH:MM and gets the extended time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B<br>
	 * (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getExtentionalOperationTimerTimeSettingValue() {return null;}
	/**
	 * Property name : Extentional operation timer time setting value<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents of property :<br>
	 * Setsextension time HH:MM and gets the extended time<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B<br>
	 * (= 0.23):(= 0.59)<br>
	 * <br>
	 * Data type : unsigned char x 2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidExtentionalOperationTimerTimeSettingValue(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Ion emission setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets ON/OFF of ion emission and gets setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emission ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIonEmissionSetting(byte[] edt) {return false;}
	/**
	 * Property name : Ion emission setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets ON/OFF of ion emission and gets setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emission ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIonEmissionSetting() {return null;}
	/**
	 * Property name : Ion emission setting<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets ON/OFF of ion emission and gets setting status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emission ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIonEmissionSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Implemented ion emission method<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies ion emission method imlemented in humidifier by bit map<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Extension ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getImplementedIonEmissionMethod() {return null;}
	/**
	 * Property name : Implemented ion emission method<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies ion emission method imlemented in humidifier by bit map<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Extension ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidImplementedIonEmissionMethod(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Oil amount level<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies oil amount in the tank by 6 levels.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x40: empty<br>
	 * 0x41-0x45: minimum to maximum levels<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getOilAmountLevel() {return null;}
	/**
	 * Property name : Oil amount level<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies oil amount in the tank by 6 levels.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x40: empty<br>
	 * 0x41-0x45: minimum to maximum levels<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOilAmountLevel(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	@Override
	protected boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_TEMPERATURE_SETTING_VALUE : return setTemperatureSettingValue(property.edt);
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : return setAutomaticTemperatureControlSetting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING_VALUE_TIME : return setOnTimerSettingValueTime(property.edt);
		case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME : return setOnTimerSettingValueRelativeTime(property.edt);
		case EPC_OFF_TIMER_RESERVATION_SETTING : return setOffTimerReservationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_VALUE_TIME : return setOffTimerSettingValueTime(property.edt);
		case EPC_OFF_TIMER_VALUE_RELATIVE_TIME : return setOffTimerValueRelativeTime(property.edt);
		case EPC_EXTENTIONAL_OPERATION_SETTING : return setExtentionalOperationSetting(property.edt);
		case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE : return setExtentionalOperationTimerTimeSettingValue(property.edt);
		case EPC_ION_EMISSION_SETTING : return setIonEmissionSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_TEMPERATURE_SETTING_VALUE : return getTemperatureSettingValue();
		case EPC_MEASURED_TEMPERATURE : return getMeasuredTemperature();
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : return getAutomaticTemperatureControlSetting();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_ON_TIMER_SETTING_VALUE_TIME : return getOnTimerSettingValueTime();
		case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME : return getOnTimerSettingValueRelativeTime();
		case EPC_OFF_TIMER_RESERVATION_SETTING : return getOffTimerReservationSetting();
		case EPC_OFF_TIMER_SETTING_VALUE_TIME : return getOffTimerSettingValueTime();
		case EPC_OFF_TIMER_VALUE_RELATIVE_TIME : return getOffTimerValueRelativeTime();
		case EPC_EXTENTIONAL_OPERATION_SETTING : return getExtentionalOperationSetting();
		case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE : return getExtentionalOperationTimerTimeSettingValue();
		case EPC_ION_EMISSION_SETTING : return getIonEmissionSetting();
		case EPC_IMPLEMENTED_ION_EMISSION_METHOD : return getImplementedIonEmissionMethod();
		case EPC_OIL_AMOUNT_LEVEL : return getOilAmountLevel();
		default : return null;
		}
	}

	@Override
	protected boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_TEMPERATURE_SETTING_VALUE : return isValidTemperatureSettingValue(property.edt);
		case EPC_MEASURED_TEMPERATURE : return isValidMeasuredTemperature(property.edt);
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : return isValidAutomaticTemperatureControlSetting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING_VALUE_TIME : return isValidOnTimerSettingValueTime(property.edt);
		case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME : return isValidOnTimerSettingValueRelativeTime(property.edt);
		case EPC_OFF_TIMER_RESERVATION_SETTING : return isValidOffTimerReservationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING_VALUE_TIME : return isValidOffTimerSettingValueTime(property.edt);
		case EPC_OFF_TIMER_VALUE_RELATIVE_TIME : return isValidOffTimerValueRelativeTime(property.edt);
		case EPC_EXTENTIONAL_OPERATION_SETTING : return isValidExtentionalOperationSetting(property.edt);
		case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE : return isValidExtentionalOperationTimerTimeSettingValue(property.edt);
		case EPC_ION_EMISSION_SETTING : return isValidIonEmissionSetting(property.edt);
		case EPC_IMPLEMENTED_ION_EMISSION_METHOD : return isValidImplementedIonEmissionMethod(property.edt);
		case EPC_OIL_AMOUNT_LEVEL : return isValidOilAmountLevel(property.edt);
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
			case EPC_TEMPERATURE_SETTING_VALUE : 
				onSetTemperatureSettingValue(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : 
				onSetAutomaticTemperatureControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_VALUE_TIME : 
				onSetOnTimerSettingValueTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME : 
				onSetOnTimerSettingValueRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_RESERVATION_SETTING : 
				onSetOffTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_VALUE_TIME : 
				onSetOffTimerSettingValueTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_VALUE_RELATIVE_TIME : 
				onSetOffTimerValueRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_EXTENTIONAL_OPERATION_SETTING : 
				onSetExtentionalOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE : 
				onSetExtentionalOperationTimerTimeSettingValue(eoj, tid, esv, property, success);
				return true;
			case EPC_ION_EMISSION_SETTING : 
				onSetIonEmissionSetting(eoj, tid, esv, property, success);
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
			case EPC_TEMPERATURE_SETTING_VALUE : 
				onGetTemperatureSettingValue(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_TEMPERATURE : 
				onGetMeasuredTemperature(eoj, tid, esv, property, success);
				return true;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING : 
				onGetAutomaticTemperatureControlSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_VALUE_TIME : 
				onGetOnTimerSettingValueTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME : 
				onGetOnTimerSettingValueRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_RESERVATION_SETTING : 
				onGetOffTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING_VALUE_TIME : 
				onGetOffTimerSettingValueTime(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_VALUE_RELATIVE_TIME : 
				onGetOffTimerValueRelativeTime(eoj, tid, esv, property, success);
				return true;
			case EPC_EXTENTIONAL_OPERATION_SETTING : 
				onGetExtentionalOperationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE : 
				onGetExtentionalOperationTimerTimeSettingValue(eoj, tid, esv, property, success);
				return true;
			case EPC_ION_EMISSION_SETTING : 
				onGetIonEmissionSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_IMPLEMENTED_ION_EMISSION_METHOD : 
				onGetImplementedIonEmissionMethod(eoj, tid, esv, property, success);
				return true;
			case EPC_OIL_AMOUNT_LEVEL : 
				onGetOilAmountLevel(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Temperature setting value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the temperature and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50��C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetTemperatureSettingValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature setting value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the temperature and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50��C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetTemperatureSettingValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured room temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-128 to 125��C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredTemperature(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets automatic / non-automatic and gets the setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets automatic / non-automatic and gets the setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of reservation and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Sets ON/OFF of reservation and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Property name : ON timer setting value (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSettingValueTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting value (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSettingValueTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting value (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting value (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of reservation and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Sets ON/OFF of reservation and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Property name : OFF timer setting value (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerSettingValueTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting value (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerSettingValueTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer value
( relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerValueRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer value
( relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerValueRelativeTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Extentional operation setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of extensional operation and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Extension ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetExtentionalOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Extentional operation setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of extensional operation and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Extension ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetExtentionalOperationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Extentional operation timer time setting value<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Setsextension time HH:MM and gets the extended time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B<br>
		 * (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Extentional operation timer time setting value<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Setsextension time HH:MM and gets the extended time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B<br>
		 * (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of ion emission and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIonEmissionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of ion emission and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIonEmissionSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Implemented ion emission method<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies ion emission method imlemented in humidifier by bit map<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Extension ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Oil amount level<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies oil amount in the tank by 6 levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40: empty<br>
		 * 0x41-0x45: minimum to maximum levels<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetOilAmountLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Temperature setting value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the temperature and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50��C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetTemperatureSettingValue(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING_VALUE, edt);
			return this;
		}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets automatic / non-automatic and gets the setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of reservation and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Property name : ON timer setting value (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSettingValueTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_TIME, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting value (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSettingValueRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME, edt);
			return this;
		}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of reservation and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Property name : OFF timer setting value (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerSettingValueTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_VALUE_TIME, edt);
			return this;
		}
		/**
		 * Property name : OFF timer value
( relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerValueRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_VALUE_RELATIVE_TIME, edt);
			return this;
		}
		/**
		 * Property name : Extentional operation setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of extensional operation and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Extension ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetExtentionalOperationSetting(byte[] edt) {
			addProperty(EPC_EXTENTIONAL_OPERATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Extentional operation timer time setting value<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Setsextension time HH:MM and gets the extended time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B<br>
		 * (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetExtentionalOperationTimerTimeSettingValue(byte[] edt) {
			addProperty(EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE, edt);
			return this;
		}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of ion emission and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIonEmissionSetting(byte[] edt) {
			addProperty(EPC_ION_EMISSION_SETTING, edt);
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
		 * Property name : Temperature setting value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the temperature and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50��C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetTemperatureSettingValue() {
			addProperty(EPC_TEMPERATURE_SETTING_VALUE);
			return this;
		}
		/**
		 * Property name : Measured temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured room temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-128 to 125��C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredTemperature() {
			addProperty(EPC_MEASURED_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets automatic / non-automatic and gets the setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of reservation and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Property name : ON timer setting value (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSettingValueTime() {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_TIME);
			return this;
		}
		/**
		 * Property name : ON timer setting value (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSettingValueRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of reservation and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Property name : OFF timer setting value (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerSettingValueTime() {
			addProperty(EPC_OFF_TIMER_SETTING_VALUE_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer value
( relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerValueRelativeTime() {
			addProperty(EPC_OFF_TIMER_VALUE_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : Extentional operation setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of extensional operation and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Extension ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetExtentionalOperationSetting() {
			addProperty(EPC_EXTENTIONAL_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Extentional operation timer time setting value<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Setsextension time HH:MM and gets the extended time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B<br>
		 * (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetExtentionalOperationTimerTimeSettingValue() {
			addProperty(EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE);
			return this;
		}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of ion emission and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIonEmissionSetting() {
			addProperty(EPC_ION_EMISSION_SETTING);
			return this;
		}
		/**
		 * Property name : Implemented ion emission method<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies ion emission method imlemented in humidifier by bit map<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Extension ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetImplementedIonEmissionMethod() {
			addProperty(EPC_IMPLEMENTED_ION_EMISSION_METHOD);
			return this;
		}
		/**
		 * Property name : Oil amount level<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies oil amount in the tank by 6 levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40: empty<br>
		 * 0x41-0x45: minimum to maximum levels<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOilAmountLevel() {
			addProperty(EPC_OIL_AMOUNT_LEVEL);
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
		 * Property name : Temperature setting value<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the temperature and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 to 0x32 (0 to 50��C)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformTemperatureSettingValue() {
			addProperty(EPC_TEMPERATURE_SETTING_VALUE);
			return this;
		}
		/**
		 * Property name : Measured temperature<br>
		 * <br>
		 * EPC : 0xBB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured room temperature.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x81 to 0x7D (-128 to 125��C)<br>
		 * <br>
		 * Data type : signed char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : . C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredTemperature() {
			addProperty(EPC_MEASURED_TEMPERATURE);
			return this;
		}
		/**
		 * Property name : Automatic temperature control setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets automatic / non-automatic and gets the setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Automatic = 0x41, non-automatic =<br>
		 * 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of reservation and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Property name : ON timer setting value (time)<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSettingValueTime() {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_TIME);
			return this;
		}
		/**
		 * Property name : ON timer setting value (relative time)<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSettingValueRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of reservation and gets setting status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON: 0x41, OFF:0x42 for both time and relative time<br>
		 * Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
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
		 * Property name : OFF timer setting value (time)<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets the setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17: 0 to 0x3B<br>
		 * (= 0 to 23): (= 0 to 59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerSettingValueTime() {
			addProperty(EPC_OFF_TIMER_SETTING_VALUE_TIME);
			return this;
		}
		/**
		 * Property name : OFF timer value
( relative time)<br>
		 * <br>
		 * EPC : 0x96<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets timer value HH:MM and gets updated time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerValueRelativeTime() {
			addProperty(EPC_OFF_TIMER_VALUE_RELATIVE_TIME);
			return this;
		}
		/**
		 * Property name : Extentional operation setting<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of extensional operation and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Extension ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformExtentionalOperationSetting() {
			addProperty(EPC_EXTENTIONAL_OPERATION_SETTING);
			return this;
		}
		/**
		 * Property name : Extentional operation timer time setting value<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents of property :<br>
		 * Setsextension time HH:MM and gets the extended time<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B<br>
		 * (= 0.23):(= 0.59)<br>
		 * <br>
		 * Data type : unsigned char x 2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformExtentionalOperationTimerTimeSettingValue() {
			addProperty(EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE);
			return this;
		}
		/**
		 * Property name : Ion emission setting<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets ON/OFF of ion emission and gets setting status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emission ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIonEmissionSetting() {
			addProperty(EPC_ION_EMISSION_SETTING);
			return this;
		}
		/**
		 * Property name : Implemented ion emission method<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies ion emission method imlemented in humidifier by bit map<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Extension ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformImplementedIonEmissionMethod() {
			addProperty(EPC_IMPLEMENTED_ION_EMISSION_METHOD);
			return this;
		}
		/**
		 * Property name : Oil amount level<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies oil amount in the tank by 6 levels.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x40: empty<br>
		 * 0x41-0x45: minimum to maximum levels<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOilAmountLevel() {
			addProperty(EPC_OIL_AMOUNT_LEVEL);
			return this;
		}
	}

	public static class Proxy extends FanHeater {
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
		protected boolean setTemperatureSettingValue(byte[] edt) {return false;}
		@Override
		protected byte[] getTemperatureSettingValue() {return null;}
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
