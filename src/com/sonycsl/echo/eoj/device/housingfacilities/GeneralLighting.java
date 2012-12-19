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

public abstract class GeneralLighting extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0290;

	public static final byte EPC_ILLUMINANCE_LEVEL = (byte)0xB0;
	public static final byte EPC_ILLUMINANCE_LEVEL_STEP_SETTING = (byte)0xB2;
	public static final byte EPC_LIGHT_COLOR_STEP_SETTING = (byte)0xB3;
	public static final byte EPC_MAXIMUM_SPECIFIABLE_VALUES = (byte)0xB4;
	public static final byte EPC_LIGHT_COLOR_SETTING = (byte)0xB1;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	public static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_OFF_TIMER_SETTING = (byte)0x95;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewGeneralLighting(this);
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
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
bytes<br>
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
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
bytes<br>
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
	 * Property name : Illuminance level<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates illuminance level in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIlluminanceLevel(byte[] edt) {return false;}
	/**
	 * Property name : Illuminance level<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates illuminance level in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIlluminanceLevel() {return null;}
	/**
	 * Property name : Illuminance level<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates illuminance level in %.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIlluminanceLevel(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Illuminance level step
setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable<br>
	 * illuminance level value (from dark to bright)<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setIlluminanceLevelStepSetting(byte[] edt) {return false;}
	/**
	 * Property name : Illuminance level step
setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable<br>
	 * illuminance level value (from dark to bright)<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getIlluminanceLevelStepSetting() {return null;}
	/**
	 * Property name : Illuminance level step
setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable<br>
	 * illuminance level value (from dark to bright)<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidIlluminanceLevelStepSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Light color step setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the light color in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLightColorStepSetting(byte[] edt) {return false;}
	/**
	 * Property name : Light color step setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the light color in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLightColorStepSetting() {return null;}
	/**
	 * Property name : Light color step setting<br>
	 * <br>
	 * EPC : 0xB3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the light color in terms of steps and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLightColorStepSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Maximum
specifiable values<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the maximum specifiable<br>
	 * illuminance level value and the maximum specifiable light color value.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: illuminance<br>
	 * Second byte: light color<br>
	 * 0x01-0xFF(Step 1 -Step 255)<br>
	 * 0x00(when the function is not implemented)<br>
	 * <br>
	 * Data type : unsign ed
char
�~2<br>
	 * <br>
	 * Data size : 2
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMaximumSpecifiableValues() {return null;}
	/**
	 * Property name : Maximum
specifiable values<br>
	 * <br>
	 * EPC : 0xB4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the maximum specifiable<br>
	 * illuminance level value and the maximum specifiable light color value.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * First byte: illuminance<br>
	 * Second byte: light color<br>
	 * 0x01-0xFF(Step 1 -Step 255)<br>
	 * 0x00(when the function is not implemented)<br>
	 * <br>
	 * Data type : unsign ed
char
�~2<br>
	 * <br>
	 * Data size : 2
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMaximumSpecifiableValues(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Light color setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the light color.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setLightColorSetting(byte[] edt) {return false;}
	/**
	 * Property name : Light color setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the light color.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getLightColorSetting() {return null;}
	/**
	 * Property name : Light color setting<br>
	 * <br>
	 * EPC : 0xB1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the light color.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidLightColorSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer
reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON��0x41,<br>
	 * Reservation OFF��0x42<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
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
	 * Property name : ON timer
reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON��0x41,<br>
	 * Reservation OFF��0x42<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
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
	 * Property name : ON timer
reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON��0x41,<br>
	 * Reservation OFF��0x42<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
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
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
	 * <br>
	 * Data type : unsign ed
char
�~2<br>
	 * <br>
	 * Data size : 2
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
	 * <br>
	 * Data type : unsign ed
char
�~2<br>
	 * <br>
	 * Data size : 2
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
	 * <br>
	 * Data type : unsign ed
char
�~2<br>
	 * <br>
	 * Data size : 2
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : OFF timer
reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON��0x41,<br>
	 * Reservation OFF��0x42<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
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
	 * Property name : OFF timer
reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON��0x41,<br>
	 * Reservation OFF��0x42<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
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
	 * Property name : OFF timer
reservation setting<br>
	 * <br>
	 * EPC : 0x94<br>
	 * <br>
	 * Contents of property :<br>
	 * Reservation ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON��0x41,<br>
	 * Reservation OFF��0x42<br>
	 * <br>
	 * Data type : unsign ed
char<br>
	 * <br>
	 * Data size : 1
Byt e<br>
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
	 * Property name : OFF timer setting<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
	 * <br>
	 * Data type : unsign ed
char
�~2<br>
	 * <br>
	 * Data size : 2
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOffTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : OFF timer setting<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
	 * <br>
	 * Data type : unsign ed
char
�~2<br>
	 * <br>
	 * Data size : 2
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOffTimerSetting() {return null;}
	/**
	 * Property name : OFF timer setting<br>
	 * <br>
	 * EPC : 0x95<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
	 * <br>
	 * Data type : unsign ed
char
�~2<br>
	 * <br>
	 * Data size : 2
Byt e<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOffTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_ILLUMINANCE_LEVEL : return setIlluminanceLevel(property.edt);
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : return setIlluminanceLevelStepSetting(property.edt);
		case EPC_LIGHT_COLOR_STEP_SETTING : return setLightColorStepSetting(property.edt);
		case EPC_LIGHT_COLOR_SETTING : return setLightColorSetting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return setOnTimerSetting(property.edt);
		case EPC_OFF_TIMER_RESERVATION_SETTING : return setOffTimerReservationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING : return setOffTimerSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_ILLUMINANCE_LEVEL : return getIlluminanceLevel();
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : return getIlluminanceLevelStepSetting();
		case EPC_LIGHT_COLOR_STEP_SETTING : return getLightColorStepSetting();
		case EPC_MAXIMUM_SPECIFIABLE_VALUES : return getMaximumSpecifiableValues();
		case EPC_LIGHT_COLOR_SETTING : return getLightColorSetting();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_ON_TIMER_SETTING : return getOnTimerSetting();
		case EPC_OFF_TIMER_RESERVATION_SETTING : return getOffTimerReservationSetting();
		case EPC_OFF_TIMER_SETTING : return getOffTimerSetting();
		default : return null;
		}
	}

	@Override
	protected boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_ILLUMINANCE_LEVEL : return isValidIlluminanceLevel(property.edt);
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : return isValidIlluminanceLevelStepSetting(property.edt);
		case EPC_LIGHT_COLOR_STEP_SETTING : return isValidLightColorStepSetting(property.edt);
		case EPC_MAXIMUM_SPECIFIABLE_VALUES : return isValidMaximumSpecifiableValues(property.edt);
		case EPC_LIGHT_COLOR_SETTING : return isValidLightColorSetting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return isValidOnTimerSetting(property.edt);
		case EPC_OFF_TIMER_RESERVATION_SETTING : return isValidOffTimerReservationSetting(property.edt);
		case EPC_OFF_TIMER_SETTING : return isValidOffTimerSetting(property.edt);
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
			case EPC_ILLUMINANCE_LEVEL : 
				onSetIlluminanceLevel(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : 
				onSetIlluminanceLevelStepSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_STEP_SETTING : 
				onSetLightColorStepSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_SETTING : 
				onSetLightColorSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onSetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_RESERVATION_SETTING : 
				onSetOffTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING : 
				onSetOffTimerSetting(eoj, tid, esv, property, success);
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
			case EPC_ILLUMINANCE_LEVEL : 
				onGetIlluminanceLevel(eoj, tid, esv, property, success);
				return true;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING : 
				onGetIlluminanceLevelStepSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_STEP_SETTING : 
				onGetLightColorStepSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MAXIMUM_SPECIFIABLE_VALUES : 
				onGetMaximumSpecifiableValues(eoj, tid, esv, property, success);
				return true;
			case EPC_LIGHT_COLOR_SETTING : 
				onGetLightColorSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onGetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_RESERVATION_SETTING : 
				onGetOffTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OFF_TIMER_SETTING : 
				onGetOffTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIlluminanceLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIlluminanceLevel(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level step
setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable<br>
		 * illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetIlluminanceLevelStepSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Illuminance level step
setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable<br>
		 * illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetIlluminanceLevelStepSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLightColorStepSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLightColorStepSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Maximum
specifiable values<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum specifiable<br>
		 * illuminance level value and the maximum specifiable light color value.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: illuminance<br>
		 * Second byte: light color<br>
		 * 0x01-0xFF(Step 1 -Step 255)<br>
		 * 0x00(when the function is not implemented)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMaximumSpecifiableValues(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetLightColorSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetLightColorSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer
reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : ON timer
reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer
reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : OFF timer
reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOffTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOffTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIlluminanceLevel(byte[] edt) {
			addProperty(EPC_ILLUMINANCE_LEVEL, edt);
			return this;
		}
		/**
		 * Property name : Illuminance level step
setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable<br>
		 * illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetIlluminanceLevelStepSetting(byte[] edt) {
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLightColorStepSetting(byte[] edt) {
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetLightColorSetting(byte[] edt) {
			addProperty(EPC_LIGHT_COLOR_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer
reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : OFF timer
reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOffTimerSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING, edt);
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
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIlluminanceLevel() {
			addProperty(EPC_ILLUMINANCE_LEVEL);
			return this;
		}
		/**
		 * Property name : Illuminance level step
setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable<br>
		 * illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetIlluminanceLevelStepSetting() {
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING);
			return this;
		}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLightColorStepSetting() {
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING);
			return this;
		}
		/**
		 * Property name : Maximum
specifiable values<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum specifiable<br>
		 * illuminance level value and the maximum specifiable light color value.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: illuminance<br>
		 * Second byte: light color<br>
		 * 0x01-0xFF(Step 1 -Step 255)<br>
		 * 0x00(when the function is not implemented)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMaximumSpecifiableValues() {
			addProperty(EPC_MAXIMUM_SPECIFIABLE_VALUES);
			return this;
		}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetLightColorSetting() {
			addProperty(EPC_LIGHT_COLOR_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer
reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer
reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOffTimerSetting() {
			addProperty(EPC_OFF_TIMER_SETTING);
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
		 * Property name : Illuminance level<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates illuminance level in %.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIlluminanceLevel() {
			addProperty(EPC_ILLUMINANCE_LEVEL);
			return this;
		}
		/**
		 * Property name : Illuminance level step
setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable<br>
		 * illuminance level value (from dark to bright)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformIlluminanceLevelStepSetting() {
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING);
			return this;
		}
		/**
		 * Property name : Light color step setting<br>
		 * <br>
		 * EPC : 0xB3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLightColorStepSetting() {
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING);
			return this;
		}
		/**
		 * Property name : Maximum
specifiable values<br>
		 * <br>
		 * EPC : 0xB4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the maximum specifiable<br>
		 * illuminance level value and the maximum specifiable light color value.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * First byte: illuminance<br>
		 * Second byte: light color<br>
		 * 0x01-0xFF(Step 1 -Step 255)<br>
		 * 0x00(when the function is not implemented)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMaximumSpecifiableValues() {
			addProperty(EPC_MAXIMUM_SPECIFIABLE_VALUES);
			return this;
		}
		/**
		 * Property name : Light color setting<br>
		 * <br>
		 * EPC : 0xB1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the light color.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformLightColorSetting() {
			addProperty(EPC_LIGHT_COLOR_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer
reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : OFF timer
reservation setting<br>
		 * <br>
		 * EPC : 0x94<br>
		 * <br>
		 * Contents of property :<br>
		 * Reservation ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON��0x41,<br>
		 * Reservation OFF��0x42<br>
		 * <br>
		 * Data type : unsign ed
char<br>
		 * <br>
		 * Data size : 1
Byt e<br>
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
		 * Property name : OFF timer setting<br>
		 * <br>
		 * EPC : 0x95<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0-0x17: 0 -0x3B (=0-23):(=0 -59)<br>
		 * <br>
		 * Data type : unsign ed
char
�~2<br>
		 * <br>
		 * Data size : 2
Byt e<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOffTimerSetting() {
			addProperty(EPC_OFF_TIMER_SETTING);
			return this;
		}
	}

	public static class Proxy extends GeneralLighting {
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
