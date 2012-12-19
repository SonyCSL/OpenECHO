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

public abstract class ElectricToiletSeat extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x026E;

	public static final byte EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT = (byte)0xE0;
	public static final byte EPC_HEATER_SETTING_OF_TOILET_SEAT = (byte)0xE1;
	public static final byte EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT = (byte)0xE2;
	public static final byte EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT = (byte)0xE3;
	public static final byte EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT = (byte)0xE4;
	public static final byte EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING = (byte)0xE5;
	public static final byte EPC_ROOM_HEATING_SETTING = (byte)0xE6;
	public static final byte EPC_ROOM_HEATING_STATUS = (byte)0xE7;
	public static final byte EPC_START_TIME_OF_ROOM_HEATING = (byte)0xE8;
	public static final byte EPC_DURATION_TIME_OF_ROOM_HREATING = (byte)0xE9;
	public static final byte EPC_SPECIAL_OPERATION_MODE_SETTING = (byte)0xEA;
	public static final byte EPC_HUMAN_DETECTION_STATUS = (byte)0xEB;
	public static final byte EPC_SEATING_DETECTION_STATUS = (byte)0xEC;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addSetProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT);
		addGetProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewElectricToiletSeat(this);
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
	 * Unit :  �<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
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
	 * Unit :  �<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Temperature level of toilet seat<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Low to high temperature (10 steps)<br>
	 * 0x31 for the lowest level, 0x3A for the highest level.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31 to 0x3A<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTemperatureLevelOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Property name : Temperature level of toilet seat<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Low to high temperature (10 steps)<br>
	 * 0x31 for the lowest level, 0x3A for the highest level.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31 to 0x3A<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTemperatureLevelOfToiletSeat() {return null;}
	/**
	 * Property name : Temperature level of toilet seat<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Low to high temperature (10 steps)<br>
	 * 0x31 for the lowest level, 0x3A for the highest level.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31 to 0x3A<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTemperatureLevelOfToiletSeat(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Heater setting of toilet seat<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract boolean setHeaterSettingOfToiletSeat(byte[] edt);
	/**
	 * Property name : Heater setting of toilet seat<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getHeaterSettingOfToiletSeat();
	/**
	 * Property name : Heater setting of toilet seat<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * ON/OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x41, OFF=0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidHeaterSettingOfToiletSeat(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Temporal halt setting of toilet seat<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Continuous setting / one time setting /<br>
	 * no setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Continuous setting=0x41, one time setting=0x42, no setting=0x43<br>
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
	protected boolean setTemporalHaltSettingOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Property name : Temporal halt setting of toilet seat<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Continuous setting / one time setting /<br>
	 * no setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Continuous setting=0x41, one time setting=0x42, no setting=0x43<br>
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
	protected byte[] getTemporalHaltSettingOfToiletSeat() {return null;}
	/**
	 * Property name : Temporal halt setting of toilet seat<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Continuous setting / one time setting /<br>
	 * no setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Continuous setting=0x41, one time setting=0x42, no setting=0x43<br>
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
	protected boolean isValidTemporalHaltSettingOfToiletSeat(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Temporal halt start time of toilet seat<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Temporal halt start time of toilet seat timer value: HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B<br>
	 * (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected boolean setTemporalHaltStartTimeOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Property name : Temporal halt start time of toilet seat<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Temporal halt start time of toilet seat timer value: HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B<br>
	 * (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected byte[] getTemporalHaltStartTimeOfToiletSeat() {return null;}
	/**
	 * Property name : Temporal halt start time of toilet seat<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Temporal halt start time of toilet seat timer value: HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B<br>
	 * (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected boolean isValidTemporalHaltStartTimeOfToiletSeat(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Temporal halt time duration of toilet seat<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Temporal stop time duration of toilet seat<br>
	 * timer value: HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected boolean setTemporalHaltTimeDurationOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Property name : Temporal halt time duration of toilet seat<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Temporal stop time duration of toilet seat<br>
	 * timer value: HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected byte[] getTemporalHaltTimeDurationOfToiletSeat() {return null;}
	/**
	 * Property name : Temporal halt time duration of toilet seat<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Temporal stop time duration of toilet seat<br>
	 * timer value: HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected boolean isValidTemporalHaltTimeDurationOfToiletSeat(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Temperature level setting of room heating<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Low / midium / high temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31 / 0x32 / 0x33<br>
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
	protected boolean setTemperatureLevelSettingOfRoomHeating(byte[] edt) {return false;}
	/**
	 * Property name : Temperature level setting of room heating<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Low / midium / high temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31 / 0x32 / 0x33<br>
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
	protected byte[] getTemperatureLevelSettingOfRoomHeating() {return null;}
	/**
	 * Property name : Temperature level setting of room heating<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Low / midium / high temperature<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x31 / 0x32 / 0x33<br>
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
	protected boolean isValidTemperatureLevelSettingOfRoomHeating(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Room heating setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Room heating ON / room heating OFF<br>
	 * / timer mode setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x41 / 0x42 / 0x43<br>
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
	protected boolean setRoomHeatingSetting(byte[] edt) {return false;}
	/**
	 * Property name : Room heating setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Room heating ON / room heating OFF<br>
	 * / timer mode setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x41 / 0x42 / 0x43<br>
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
	protected byte[] getRoomHeatingSetting() {return null;}
	/**
	 * Property name : Room heating setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Room heating ON / room heating OFF<br>
	 * / timer mode setting<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x41 / 0x42 / 0x43<br>
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
	protected boolean isValidRoomHeatingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Room heating status<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Room heating ON / room heating OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x41, OFF=0x42<br>
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
	protected byte[] getRoomHeatingStatus() {return null;}
	/**
	 * Property name : Room heating status<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Room heating ON / room heating OFF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x41, OFF=0x42<br>
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
	protected boolean isValidRoomHeatingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Start time of room heating<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected boolean setStartTimeOfRoomHeating(byte[] edt) {return false;}
	/**
	 * Property name : Start time of room heating<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected byte[] getStartTimeOfRoomHeating() {return null;}
	/**
	 * Property name : Start time of room heating<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Timer value HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected boolean isValidStartTimeOfRoomHeating(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Duration time of room hreating<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Duration time HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected boolean setDurationTimeOfRoomHreating(byte[] edt) {return false;}
	/**
	 * Property name : Duration time of room hreating<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Duration time HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected byte[] getDurationTimeOfRoomHreating() {return null;}
	/**
	 * Property name : Duration time of room hreating<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Duration time HH:MM<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
	 * <br>
	 * Data type : unsigned char
*2<br>
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
	protected boolean isValidDurationTimeOfRoomHreating(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Special operation mode setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set a special operation mode and get the status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No setting: 0x40,<br>
	 * Over-cool prevention: 0x41 for future reserved: 0x42-<br>
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
	protected boolean setSpecialOperationModeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Special operation mode setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set a special operation mode and get the status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No setting: 0x40,<br>
	 * Over-cool prevention: 0x41 for future reserved: 0x42-<br>
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
	protected byte[] getSpecialOperationModeSetting() {return null;}
	/**
	 * Property name : Special operation mode setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to set a special operation mode and get the status<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No setting: 0x40,<br>
	 * Over-cool prevention: 0x41 for future reserved: 0x42-<br>
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
	protected boolean isValidSpecialOperationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Human detection status<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Indicate detection of human body<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected = 0x41<br>
	 * Non detecteed = 0x42<br>
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
	protected boolean setHumanDetectionStatus(byte[] edt) {return false;}
	/**
	 * Property name : Human detection status<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Indicate detection of human body<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected = 0x41<br>
	 * Non detecteed = 0x42<br>
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
	protected byte[] getHumanDetectionStatus() {return null;}
	/**
	 * Property name : Human detection status<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Indicate detection of human body<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected = 0x41<br>
	 * Non detecteed = 0x42<br>
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
	protected boolean isValidHumanDetectionStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Seating detection status<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates detection of seating<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected = 0x41<br>
	 * Non detecteed = 0x42<br>
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
	protected boolean setSeatingDetectionStatus(byte[] edt) {return false;}
	/**
	 * Property name : Seating detection status<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates detection of seating<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected = 0x41<br>
	 * Non detecteed = 0x42<br>
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
	protected byte[] getSeatingDetectionStatus() {return null;}
	/**
	 * Property name : Seating detection status<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates detection of seating<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Detected = 0x41<br>
	 * Non detecteed = 0x42<br>
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
	protected boolean isValidSeatingDetectionStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	@Override
	protected boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT : return setTemperatureLevelOfToiletSeat(property.edt);
		case EPC_HEATER_SETTING_OF_TOILET_SEAT : return setHeaterSettingOfToiletSeat(property.edt);
		case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT : return setTemporalHaltSettingOfToiletSeat(property.edt);
		case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT : return setTemporalHaltStartTimeOfToiletSeat(property.edt);
		case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT : return setTemporalHaltTimeDurationOfToiletSeat(property.edt);
		case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING : return setTemperatureLevelSettingOfRoomHeating(property.edt);
		case EPC_ROOM_HEATING_SETTING : return setRoomHeatingSetting(property.edt);
		case EPC_START_TIME_OF_ROOM_HEATING : return setStartTimeOfRoomHeating(property.edt);
		case EPC_DURATION_TIME_OF_ROOM_HREATING : return setDurationTimeOfRoomHreating(property.edt);
		case EPC_SPECIAL_OPERATION_MODE_SETTING : return setSpecialOperationModeSetting(property.edt);
		case EPC_HUMAN_DETECTION_STATUS : return setHumanDetectionStatus(property.edt);
		case EPC_SEATING_DETECTION_STATUS : return setSeatingDetectionStatus(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT : return getTemperatureLevelOfToiletSeat();
		case EPC_HEATER_SETTING_OF_TOILET_SEAT : return getHeaterSettingOfToiletSeat();
		case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT : return getTemporalHaltSettingOfToiletSeat();
		case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT : return getTemporalHaltStartTimeOfToiletSeat();
		case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT : return getTemporalHaltTimeDurationOfToiletSeat();
		case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING : return getTemperatureLevelSettingOfRoomHeating();
		case EPC_ROOM_HEATING_SETTING : return getRoomHeatingSetting();
		case EPC_ROOM_HEATING_STATUS : return getRoomHeatingStatus();
		case EPC_START_TIME_OF_ROOM_HEATING : return getStartTimeOfRoomHeating();
		case EPC_DURATION_TIME_OF_ROOM_HREATING : return getDurationTimeOfRoomHreating();
		case EPC_SPECIAL_OPERATION_MODE_SETTING : return getSpecialOperationModeSetting();
		case EPC_HUMAN_DETECTION_STATUS : return getHumanDetectionStatus();
		case EPC_SEATING_DETECTION_STATUS : return getSeatingDetectionStatus();
		default : return null;
		}
	}

	@Override
	protected boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT : return isValidTemperatureLevelOfToiletSeat(property.edt);
		case EPC_HEATER_SETTING_OF_TOILET_SEAT : return isValidHeaterSettingOfToiletSeat(property.edt);
		case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT : return isValidTemporalHaltSettingOfToiletSeat(property.edt);
		case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT : return isValidTemporalHaltStartTimeOfToiletSeat(property.edt);
		case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT : return isValidTemporalHaltTimeDurationOfToiletSeat(property.edt);
		case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING : return isValidTemperatureLevelSettingOfRoomHeating(property.edt);
		case EPC_ROOM_HEATING_SETTING : return isValidRoomHeatingSetting(property.edt);
		case EPC_ROOM_HEATING_STATUS : return isValidRoomHeatingStatus(property.edt);
		case EPC_START_TIME_OF_ROOM_HEATING : return isValidStartTimeOfRoomHeating(property.edt);
		case EPC_DURATION_TIME_OF_ROOM_HREATING : return isValidDurationTimeOfRoomHreating(property.edt);
		case EPC_SPECIAL_OPERATION_MODE_SETTING : return isValidSpecialOperationModeSetting(property.edt);
		case EPC_HUMAN_DETECTION_STATUS : return isValidHumanDetectionStatus(property.edt);
		case EPC_SEATING_DETECTION_STATUS : return isValidSeatingDetectionStatus(property.edt);
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
			case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT : 
				onSetTemperatureLevelOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATER_SETTING_OF_TOILET_SEAT : 
				onSetHeaterSettingOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT : 
				onSetTemporalHaltSettingOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT : 
				onSetTemporalHaltStartTimeOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT : 
				onSetTemporalHaltTimeDurationOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING : 
				onSetTemperatureLevelSettingOfRoomHeating(eoj, tid, esv, property, success);
				return true;
			case EPC_ROOM_HEATING_SETTING : 
				onSetRoomHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_START_TIME_OF_ROOM_HEATING : 
				onSetStartTimeOfRoomHeating(eoj, tid, esv, property, success);
				return true;
			case EPC_DURATION_TIME_OF_ROOM_HREATING : 
				onSetDurationTimeOfRoomHreating(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_OPERATION_MODE_SETTING : 
				onSetSpecialOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMAN_DETECTION_STATUS : 
				onSetHumanDetectionStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_SEATING_DETECTION_STATUS : 
				onSetSeatingDetectionStatus(eoj, tid, esv, property, success);
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
			case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT : 
				onGetTemperatureLevelOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_HEATER_SETTING_OF_TOILET_SEAT : 
				onGetHeaterSettingOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT : 
				onGetTemporalHaltSettingOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT : 
				onGetTemporalHaltStartTimeOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT : 
				onGetTemporalHaltTimeDurationOfToiletSeat(eoj, tid, esv, property, success);
				return true;
			case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING : 
				onGetTemperatureLevelSettingOfRoomHeating(eoj, tid, esv, property, success);
				return true;
			case EPC_ROOM_HEATING_SETTING : 
				onGetRoomHeatingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ROOM_HEATING_STATUS : 
				onGetRoomHeatingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_START_TIME_OF_ROOM_HEATING : 
				onGetStartTimeOfRoomHeating(eoj, tid, esv, property, success);
				return true;
			case EPC_DURATION_TIME_OF_ROOM_HREATING : 
				onGetDurationTimeOfRoomHreating(eoj, tid, esv, property, success);
				return true;
			case EPC_SPECIAL_OPERATION_MODE_SETTING : 
				onGetSpecialOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_HUMAN_DETECTION_STATUS : 
				onGetHumanDetectionStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_SEATING_DETECTION_STATUS : 
				onGetSeatingDetectionStatus(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Temperature level of toilet seat<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Low to high temperature (10 steps)<br>
		 * 0x31 for the lowest level, 0x3A for the highest level.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 to 0x3A<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature level of toilet seat<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Low to high temperature (10 steps)<br>
		 * 0x31 for the lowest level, 0x3A for the highest level.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 to 0x3A<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heater setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onSetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Heater setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		protected void onGetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temporal halt setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Continuous setting / one time setting /<br>
		 * no setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Continuous setting=0x41, one time setting=0x42, no setting=0x43<br>
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
		protected void onSetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temporal halt setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Continuous setting / one time setting /<br>
		 * no setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Continuous setting=0x41, one time setting=0x42, no setting=0x43<br>
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
		protected void onGetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temporal halt start time of toilet seat<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B<br>
		 * (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		protected void onSetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temporal halt start time of toilet seat<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B<br>
		 * (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		protected void onGetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temporal halt time duration of toilet seat<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal stop time duration of toilet seat<br>
		 * timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		protected void onSetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temporal halt time duration of toilet seat<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal stop time duration of toilet seat<br>
		 * timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		protected void onGetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature level setting of room heating<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Low / midium / high temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 / 0x32 / 0x33<br>
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
		protected void onSetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Temperature level setting of room heating<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Low / midium / high temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 / 0x32 / 0x33<br>
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
		protected void onGetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Room heating setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Room heating ON / room heating OFF<br>
		 * / timer mode setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41 / 0x42 / 0x43<br>
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
		protected void onSetRoomHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Room heating setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Room heating ON / room heating OFF<br>
		 * / timer mode setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41 / 0x42 / 0x43<br>
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
		protected void onGetRoomHeatingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Room heating status<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Room heating ON / room heating OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
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
		protected void onGetRoomHeatingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Start time of room heating<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		protected void onSetStartTimeOfRoomHeating(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Start time of room heating<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		protected void onGetStartTimeOfRoomHeating(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Duration time of room hreating<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Duration time HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		protected void onSetDurationTimeOfRoomHreating(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Duration time of room hreating<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Duration time HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		protected void onGetDurationTimeOfRoomHreating(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set a special operation mode and get the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40,<br>
		 * Over-cool prevention: 0x41 for future reserved: 0x42-<br>
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
		protected void onSetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set a special operation mode and get the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40,<br>
		 * Over-cool prevention: 0x41 for future reserved: 0x42-<br>
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
		protected void onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Human detection status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicate detection of human body<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		protected void onSetHumanDetectionStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Human detection status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicate detection of human body<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		protected void onGetHumanDetectionStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Seating detection status<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates detection of seating<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		protected void onSetSeatingDetectionStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Seating detection status<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates detection of seating<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		protected void onGetSeatingDetectionStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Temperature level of toilet seat<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Low to high temperature (10 steps)<br>
		 * 0x31 for the lowest level, 0x3A for the highest level.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 to 0x3A<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTemperatureLevelOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT, edt);
			return this;
		}
		/**
		 * Property name : Heater setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Setter reqSetHeaterSettingOfToiletSeat(byte[] edt) {
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT, edt);
			return this;
		}
		/**
		 * Property name : Temporal halt setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Continuous setting / one time setting /<br>
		 * no setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Continuous setting=0x41, one time setting=0x42, no setting=0x43<br>
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
		public Setter reqSetTemporalHaltSettingOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT, edt);
			return this;
		}
		/**
		 * Property name : Temporal halt start time of toilet seat<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B<br>
		 * (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Setter reqSetTemporalHaltStartTimeOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT, edt);
			return this;
		}
		/**
		 * Property name : Temporal halt time duration of toilet seat<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal stop time duration of toilet seat<br>
		 * timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Setter reqSetTemporalHaltTimeDurationOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT, edt);
			return this;
		}
		/**
		 * Property name : Temperature level setting of room heating<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Low / midium / high temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 / 0x32 / 0x33<br>
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
		public Setter reqSetTemperatureLevelSettingOfRoomHeating(byte[] edt) {
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING, edt);
			return this;
		}
		/**
		 * Property name : Room heating setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Room heating ON / room heating OFF<br>
		 * / timer mode setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41 / 0x42 / 0x43<br>
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
		public Setter reqSetRoomHeatingSetting(byte[] edt) {
			addProperty(EPC_ROOM_HEATING_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Start time of room heating<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Setter reqSetStartTimeOfRoomHeating(byte[] edt) {
			addProperty(EPC_START_TIME_OF_ROOM_HEATING, edt);
			return this;
		}
		/**
		 * Property name : Duration time of room hreating<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Duration time HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Setter reqSetDurationTimeOfRoomHreating(byte[] edt) {
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING, edt);
			return this;
		}
		/**
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set a special operation mode and get the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40,<br>
		 * Over-cool prevention: 0x41 for future reserved: 0x42-<br>
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
		public Setter reqSetSpecialOperationModeSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Human detection status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicate detection of human body<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		public Setter reqSetHumanDetectionStatus(byte[] edt) {
			addProperty(EPC_HUMAN_DETECTION_STATUS, edt);
			return this;
		}
		/**
		 * Property name : Seating detection status<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates detection of seating<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		public Setter reqSetSeatingDetectionStatus(byte[] edt) {
			addProperty(EPC_SEATING_DETECTION_STATUS, edt);
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
		 * Property name : Temperature level of toilet seat<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Low to high temperature (10 steps)<br>
		 * 0x31 for the lowest level, 0x3A for the highest level.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 to 0x3A<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTemperatureLevelOfToiletSeat() {
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Heater setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetHeaterSettingOfToiletSeat() {
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Temporal halt setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Continuous setting / one time setting /<br>
		 * no setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Continuous setting=0x41, one time setting=0x42, no setting=0x43<br>
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
		public Getter reqGetTemporalHaltSettingOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Temporal halt start time of toilet seat<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B<br>
		 * (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Getter reqGetTemporalHaltStartTimeOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Temporal halt time duration of toilet seat<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal stop time duration of toilet seat<br>
		 * timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Getter reqGetTemporalHaltTimeDurationOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Temperature level setting of room heating<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Low / midium / high temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 / 0x32 / 0x33<br>
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
		public Getter reqGetTemperatureLevelSettingOfRoomHeating() {
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING);
			return this;
		}
		/**
		 * Property name : Room heating setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Room heating ON / room heating OFF<br>
		 * / timer mode setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41 / 0x42 / 0x43<br>
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
		public Getter reqGetRoomHeatingSetting() {
			addProperty(EPC_ROOM_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Room heating status<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Room heating ON / room heating OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
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
		public Getter reqGetRoomHeatingStatus() {
			addProperty(EPC_ROOM_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Start time of room heating<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Getter reqGetStartTimeOfRoomHeating() {
			addProperty(EPC_START_TIME_OF_ROOM_HEATING);
			return this;
		}
		/**
		 * Property name : Duration time of room hreating<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Duration time HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Getter reqGetDurationTimeOfRoomHreating() {
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING);
			return this;
		}
		/**
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set a special operation mode and get the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40,<br>
		 * Over-cool prevention: 0x41 for future reserved: 0x42-<br>
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
		public Getter reqGetSpecialOperationModeSetting() {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Human detection status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicate detection of human body<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		public Getter reqGetHumanDetectionStatus() {
			addProperty(EPC_HUMAN_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : Seating detection status<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates detection of seating<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		public Getter reqGetSeatingDetectionStatus() {
			addProperty(EPC_SEATING_DETECTION_STATUS);
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
		 * Property name : Temperature level of toilet seat<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Low to high temperature (10 steps)<br>
		 * 0x31 for the lowest level, 0x3A for the highest level.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 to 0x3A<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTemperatureLevelOfToiletSeat() {
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Heater setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * ON/OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformHeaterSettingOfToiletSeat() {
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Temporal halt setting of toilet seat<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Continuous setting / one time setting /<br>
		 * no setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Continuous setting=0x41, one time setting=0x42, no setting=0x43<br>
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
		public Informer reqInformTemporalHaltSettingOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Temporal halt start time of toilet seat<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B<br>
		 * (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Informer reqInformTemporalHaltStartTimeOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Temporal halt time duration of toilet seat<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Temporal stop time duration of toilet seat<br>
		 * timer value: HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Informer reqInformTemporalHaltTimeDurationOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Property name : Temperature level setting of room heating<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Low / midium / high temperature<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x31 / 0x32 / 0x33<br>
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
		public Informer reqInformTemperatureLevelSettingOfRoomHeating() {
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING);
			return this;
		}
		/**
		 * Property name : Room heating setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Room heating ON / room heating OFF<br>
		 * / timer mode setting<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x41 / 0x42 / 0x43<br>
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
		public Informer reqInformRoomHeatingSetting() {
			addProperty(EPC_ROOM_HEATING_SETTING);
			return this;
		}
		/**
		 * Property name : Room heating status<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Room heating ON / room heating OFF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x41, OFF=0x42<br>
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
		public Informer reqInformRoomHeatingStatus() {
			addProperty(EPC_ROOM_HEATING_STATUS);
			return this;
		}
		/**
		 * Property name : Start time of room heating<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Timer value HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Informer reqInformStartTimeOfRoomHeating() {
			addProperty(EPC_START_TIME_OF_ROOM_HEATING);
			return this;
		}
		/**
		 * Property name : Duration time of room hreating<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Duration time HH:MM<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br>
		 * <br>
		 * Data type : unsigned char
*2<br>
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
		public Informer reqInformDurationTimeOfRoomHreating() {
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING);
			return this;
		}
		/**
		 * Property name : Special operation mode setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to set a special operation mode and get the status<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No setting: 0x40,<br>
		 * Over-cool prevention: 0x41 for future reserved: 0x42-<br>
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
		public Informer reqInformSpecialOperationModeSetting() {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : Human detection status<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Indicate detection of human body<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		public Informer reqInformHumanDetectionStatus() {
			addProperty(EPC_HUMAN_DETECTION_STATUS);
			return this;
		}
		/**
		 * Property name : Seating detection status<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates detection of seating<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Detected = 0x41<br>
		 * Non detecteed = 0x42<br>
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
		public Informer reqInformSeatingDetectionStatus() {
			addProperty(EPC_SEATING_DETECTION_STATUS);
			return this;
		}
	}

	public static class Proxy extends ElectricToiletSeat {
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
		protected boolean setHeaterSettingOfToiletSeat(byte[] edt) {return false;}
		@Override
		protected byte[] getHeaterSettingOfToiletSeat() {return null;}
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
