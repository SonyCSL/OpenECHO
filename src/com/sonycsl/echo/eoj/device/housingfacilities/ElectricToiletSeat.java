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

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class ElectricToiletSeat extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x6E;
	
	public ElectricToiletSeat() {
		setReceiver(new Receiver());
	}

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
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br><br>0x31 to 0x3A<br><br>Name : Temperature level of toilet seat<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTemperatureLevelOfToiletSeat(byte[] edt) {return false;}
	private final boolean _setTemperatureLevelOfToiletSeat(byte epc, byte[] edt) {
		boolean success = setTemperatureLevelOfToiletSeat(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br><br>0x31 to 0x3A<br><br>Name : Temperature level of toilet seat<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTemperatureLevelOfToiletSeat() {return null;}
	private final byte[] _getTemperatureLevelOfToiletSeat(byte epc) {
		byte[] edt = getTemperatureLevelOfToiletSeat();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Heater setting of toilet seat<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract boolean setHeaterSettingOfToiletSeat(byte[] edt);
	private final boolean _setHeaterSettingOfToiletSeat(byte epc, byte[] edt) {
		boolean success = setHeaterSettingOfToiletSeat(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Heater setting of toilet seat<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract byte[] getHeaterSettingOfToiletSeat();
	private final byte[] _getHeaterSettingOfToiletSeat(byte epc) {
		byte[] edt = getHeaterSettingOfToiletSeat();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Continuous setting / one time setting / no setting.<br><br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Name : Temporal halt setting of toilet seat<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTemporalHaltSettingOfToiletSeat(byte[] edt) {return false;}
	private final boolean _setTemporalHaltSettingOfToiletSeat(byte epc, byte[] edt) {
		boolean success = setTemporalHaltSettingOfToiletSeat(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Continuous setting / one time setting / no setting.<br><br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Name : Temporal halt setting of toilet seat<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTemporalHaltSettingOfToiletSeat() {return null;}
	private final byte[] _getTemporalHaltSettingOfToiletSeat(byte epc) {
		byte[] edt = getTemporalHaltSettingOfToiletSeat();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Temporal halt start time of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt start time of toilet seat<br>EPC : 0xE3<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTemporalHaltStartTimeOfToiletSeat(byte[] edt) {return false;}
	private final boolean _setTemporalHaltStartTimeOfToiletSeat(byte epc, byte[] edt) {
		boolean success = setTemporalHaltStartTimeOfToiletSeat(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Temporal halt start time of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt start time of toilet seat<br>EPC : 0xE3<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTemporalHaltStartTimeOfToiletSeat() {return null;}
	private final byte[] _getTemporalHaltStartTimeOfToiletSeat(byte epc) {
		byte[] edt = getTemporalHaltStartTimeOfToiletSeat();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Temporal stop time duration of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt time duration of toilet seat<br>EPC : 0xE4<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTemporalHaltTimeDurationOfToiletSeat(byte[] edt) {return false;}
	private final boolean _setTemporalHaltTimeDurationOfToiletSeat(byte epc, byte[] edt) {
		boolean success = setTemporalHaltTimeDurationOfToiletSeat(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Temporal stop time duration of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt time duration of toilet seat<br>EPC : 0xE4<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTemporalHaltTimeDurationOfToiletSeat() {return null;}
	private final byte[] _getTemporalHaltTimeDurationOfToiletSeat(byte epc) {
		byte[] edt = getTemporalHaltTimeDurationOfToiletSeat();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Low / midium / high temperature<br><br>0x31 / 0x32 / 0x33<br><br>Name : Temperature level setting of room heating<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTemperatureLevelSettingOfRoomHeating(byte[] edt) {return false;}
	private final boolean _setTemperatureLevelSettingOfRoomHeating(byte epc, byte[] edt) {
		boolean success = setTemperatureLevelSettingOfRoomHeating(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Low / midium / high temperature<br><br>0x31 / 0x32 / 0x33<br><br>Name : Temperature level setting of room heating<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTemperatureLevelSettingOfRoomHeating() {return null;}
	private final byte[] _getTemperatureLevelSettingOfRoomHeating(byte epc) {
		byte[] edt = getTemperatureLevelSettingOfRoomHeating();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Room heating ON / room heating OFF / timer mode setting<br><br>0x41 / 0x42 / 0x43<br><br>Name : Room heating setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRoomHeatingSetting(byte[] edt) {return false;}
	private final boolean _setRoomHeatingSetting(byte epc, byte[] edt) {
		boolean success = setRoomHeatingSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Room heating ON / room heating OFF / timer mode setting<br><br>0x41 / 0x42 / 0x43<br><br>Name : Room heating setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRoomHeatingSetting() {return null;}
	private final byte[] _getRoomHeatingSetting(byte epc) {
		byte[] edt = getRoomHeatingSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Room heating ON / room heating OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Room heating status<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRoomHeatingStatus() {return null;}
	private final byte[] _getRoomHeatingStatus(byte epc) {
		byte[] edt = getRoomHeatingStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Start time of room heating<br>EPC : 0xE8<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setStartTimeOfRoomHeating(byte[] edt) {return false;}
	private final boolean _setStartTimeOfRoomHeating(byte epc, byte[] edt) {
		boolean success = setStartTimeOfRoomHeating(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Start time of room heating<br>EPC : 0xE8<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getStartTimeOfRoomHeating() {return null;}
	private final byte[] _getStartTimeOfRoomHeating(byte epc) {
		byte[] edt = getStartTimeOfRoomHeating();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Duration time HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Duration time of room hreating<br>EPC : 0xE9<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDurationTimeOfRoomHreating(byte[] edt) {return false;}
	private final boolean _setDurationTimeOfRoomHreating(byte epc, byte[] edt) {
		boolean success = setDurationTimeOfRoomHreating(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Duration time HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Duration time of room hreating<br>EPC : 0xE9<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDurationTimeOfRoomHreating() {return null;}
	private final byte[] _getDurationTimeOfRoomHreating(byte epc) {
		byte[] edt = getDurationTimeOfRoomHreating();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to set a special operation mode and get the status<br><br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Name : Special operation mode setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSpecialOperationModeSetting(byte[] edt) {return false;}
	private final boolean _setSpecialOperationModeSetting(byte epc, byte[] edt) {
		boolean success = setSpecialOperationModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to set a special operation mode and get the status<br><br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Name : Special operation mode setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSpecialOperationModeSetting() {return null;}
	private final byte[] _getSpecialOperationModeSetting(byte epc) {
		byte[] edt = getSpecialOperationModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Indicate detection of human body<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Human detection status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHumanDetectionStatus(byte[] edt) {return false;}
	private final boolean _setHumanDetectionStatus(byte epc, byte[] edt) {
		boolean success = setHumanDetectionStatus(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Indicate detection of human body<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Human detection status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHumanDetectionStatus() {return null;}
	private final byte[] _getHumanDetectionStatus(byte epc) {
		byte[] edt = getHumanDetectionStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates detection of seating<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Seating detection status<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSeatingDetectionStatus(byte[] edt) {return false;}
	private final boolean _setSeatingDetectionStatus(byte epc, byte[] edt) {
		boolean success = setSeatingDetectionStatus(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates detection of seating<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Seating detection status<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSeatingDetectionStatus() {return null;}
	private final byte[] _getSeatingDetectionStatus(byte epc) {
		byte[] edt = getSeatingDetectionStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT:
			res.addProperty(epc, edt, _setTemperatureLevelOfToiletSeat(epc, edt));
			break;
		case EPC_HEATER_SETTING_OF_TOILET_SEAT:
			res.addProperty(epc, edt, _setHeaterSettingOfToiletSeat(epc, edt));
			break;
		case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT:
			res.addProperty(epc, edt, _setTemporalHaltSettingOfToiletSeat(epc, edt));
			break;
		case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT:
			res.addProperty(epc, edt, _setTemporalHaltStartTimeOfToiletSeat(epc, edt));
			break;
		case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT:
			res.addProperty(epc, edt, _setTemporalHaltTimeDurationOfToiletSeat(epc, edt));
			break;
		case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING:
			res.addProperty(epc, edt, _setTemperatureLevelSettingOfRoomHeating(epc, edt));
			break;
		case EPC_ROOM_HEATING_SETTING:
			res.addProperty(epc, edt, _setRoomHeatingSetting(epc, edt));
			break;
		case EPC_START_TIME_OF_ROOM_HEATING:
			res.addProperty(epc, edt, _setStartTimeOfRoomHeating(epc, edt));
			break;
		case EPC_DURATION_TIME_OF_ROOM_HREATING:
			res.addProperty(epc, edt, _setDurationTimeOfRoomHreating(epc, edt));
			break;
		case EPC_SPECIAL_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, _setSpecialOperationModeSetting(epc, edt));
			break;
		case EPC_HUMAN_DETECTION_STATUS:
			res.addProperty(epc, edt, _setHumanDetectionStatus(epc, edt));
			break;
		case EPC_SEATING_DETECTION_STATUS:
			res.addProperty(epc, edt, _setSeatingDetectionStatus(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT:
			edt = _getTemperatureLevelOfToiletSeat(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATER_SETTING_OF_TOILET_SEAT:
			edt = _getHeaterSettingOfToiletSeat(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT:
			edt = _getTemporalHaltSettingOfToiletSeat(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT:
			edt = _getTemporalHaltStartTimeOfToiletSeat(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT:
			edt = _getTemporalHaltTimeDurationOfToiletSeat(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING:
			edt = _getTemperatureLevelSettingOfRoomHeating(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ROOM_HEATING_SETTING:
			edt = _getRoomHeatingSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ROOM_HEATING_STATUS:
			edt = _getRoomHeatingStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_START_TIME_OF_ROOM_HEATING:
			edt = _getStartTimeOfRoomHeating(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_DURATION_TIME_OF_ROOM_HREATING:
			edt = _getDurationTimeOfRoomHreating(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SPECIAL_OPERATION_MODE_SETTING:
			edt = _getSpecialOperationModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HUMAN_DETECTION_STATUS:
			edt = _getHumanDetectionStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SEATING_DETECTION_STATUS:
			edt = _getSeatingDetectionStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
			case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT:
				_onSetTemperatureLevelOfToiletSeat(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_HEATER_SETTING_OF_TOILET_SEAT:
				_onSetHeaterSettingOfToiletSeat(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT:
				_onSetTemporalHaltSettingOfToiletSeat(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT:
				_onSetTemporalHaltStartTimeOfToiletSeat(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT:
				_onSetTemporalHaltTimeDurationOfToiletSeat(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING:
				_onSetTemperatureLevelSettingOfRoomHeating(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ROOM_HEATING_SETTING:
				_onSetRoomHeatingSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_START_TIME_OF_ROOM_HEATING:
				_onSetStartTimeOfRoomHeating(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_DURATION_TIME_OF_ROOM_HREATING:
				_onSetDurationTimeOfRoomHreating(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SPECIAL_OPERATION_MODE_SETTING:
				_onSetSpecialOperationModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_HUMAN_DETECTION_STATUS:
				_onSetHumanDetectionStatus(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SEATING_DETECTION_STATUS:
				_onSetSeatingDetectionStatus(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT:
				_onGetTemperatureLevelOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATER_SETTING_OF_TOILET_SEAT:
				_onGetHeaterSettingOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT:
				_onGetTemporalHaltSettingOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT:
				_onGetTemporalHaltStartTimeOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT:
				_onGetTemporalHaltTimeDurationOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING:
				_onGetTemperatureLevelSettingOfRoomHeating(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ROOM_HEATING_SETTING:
				_onGetRoomHeatingSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ROOM_HEATING_STATUS:
				_onGetRoomHeatingStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_START_TIME_OF_ROOM_HEATING:
				_onGetStartTimeOfRoomHeating(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DURATION_TIME_OF_ROOM_HREATING:
				_onGetDurationTimeOfRoomHreating(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPECIAL_OPERATION_MODE_SETTING:
				_onGetSpecialOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HUMAN_DETECTION_STATUS:
				_onGetHumanDetectionStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SEATING_DETECTION_STATUS:
				_onGetSeatingDetectionStatus(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br><br>0x31 to 0x3A<br><br>Name : Temperature level of toilet seat<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureLevelOfToiletSeat(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br><br>0x31 to 0x3A<br><br>Name : Temperature level of toilet seat<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureLevelOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Heater setting of toilet seat<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onSetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeaterSettingOfToiletSeat(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Heater setting of toilet seat<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onGetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeaterSettingOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Continuous setting / one time setting / no setting.<br><br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Name : Temporal halt setting of toilet seat<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemporalHaltSettingOfToiletSeat(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Continuous setting / one time setting / no setting.<br><br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Name : Temporal halt setting of toilet seat<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemporalHaltSettingOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt start time of toilet seat<br>EPC : 0xE3<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemporalHaltStartTimeOfToiletSeat(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt start time of toilet seat<br>EPC : 0xE3<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemporalHaltStartTimeOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt time duration of toilet seat<br>EPC : 0xE4<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemporalHaltTimeDurationOfToiletSeat(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt time duration of toilet seat<br>EPC : 0xE4<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemporalHaltTimeDurationOfToiletSeat(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Low / midium / high temperature<br><br>0x31 / 0x32 / 0x33<br><br>Name : Temperature level setting of room heating<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureLevelSettingOfRoomHeating(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Low / midium / high temperature<br><br>0x31 / 0x32 / 0x33<br><br>Name : Temperature level setting of room heating<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureLevelSettingOfRoomHeating(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br><br>0x41 / 0x42 / 0x43<br><br>Name : Room heating setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRoomHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRoomHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRoomHeatingSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br><br>0x41 / 0x42 / 0x43<br><br>Name : Room heating setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRoomHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRoomHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRoomHeatingSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Room heating ON / room heating OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Room heating status<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRoomHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRoomHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRoomHeatingStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Start time of room heating<br>EPC : 0xE8<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetStartTimeOfRoomHeating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetStartTimeOfRoomHeating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetStartTimeOfRoomHeating(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Start time of room heating<br>EPC : 0xE8<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetStartTimeOfRoomHeating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetStartTimeOfRoomHeating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetStartTimeOfRoomHeating(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Duration time HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Duration time of room hreating<br>EPC : 0xE9<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDurationTimeOfRoomHreating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDurationTimeOfRoomHreating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDurationTimeOfRoomHreating(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Duration time HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Duration time of room hreating<br>EPC : 0xE9<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDurationTimeOfRoomHreating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDurationTimeOfRoomHreating(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDurationTimeOfRoomHreating(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set a special operation mode and get the status<br><br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Name : Special operation mode setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSpecialOperationModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set a special operation mode and get the status<br><br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Name : Special operation mode setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSpecialOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Indicate detection of human body<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Human detection status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHumanDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHumanDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHumanDetectionStatus(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Indicate detection of human body<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Human detection status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHumanDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHumanDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHumanDetectionStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates detection of seating<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Seating detection status<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSeatingDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSeatingDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSeatingDetectionStatus(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates detection of seating<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Seating detection status<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSeatingDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSeatingDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSeatingDetectionStatus(eoj, tid, esv, epc, pdc, edt);
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
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br><br>0x31 to 0x3A<br><br>Name : Temperature level of toilet seat<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTemperatureLevelOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Heater setting of toilet seat<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Setter reqSetHeaterSettingOfToiletSeat(byte[] edt) {
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Continuous setting / one time setting / no setting.<br><br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Name : Temporal halt setting of toilet seat<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTemporalHaltSettingOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt start time of toilet seat<br>EPC : 0xE3<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTemporalHaltStartTimeOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt time duration of toilet seat<br>EPC : 0xE4<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTemporalHaltTimeDurationOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Low / midium / high temperature<br><br>0x31 / 0x32 / 0x33<br><br>Name : Temperature level setting of room heating<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTemperatureLevelSettingOfRoomHeating(byte[] edt) {
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br><br>0x41 / 0x42 / 0x43<br><br>Name : Room heating setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRoomHeatingSetting(byte[] edt) {
			addProperty(EPC_ROOM_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Start time of room heating<br>EPC : 0xE8<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetStartTimeOfRoomHeating(byte[] edt) {
			addProperty(EPC_START_TIME_OF_ROOM_HEATING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Duration time HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Duration time of room hreating<br>EPC : 0xE9<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDurationTimeOfRoomHreating(byte[] edt) {
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to set a special operation mode and get the status<br><br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Name : Special operation mode setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSpecialOperationModeSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Indicate detection of human body<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Human detection status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHumanDetectionStatus(byte[] edt) {
			addProperty(EPC_HUMAN_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates detection of seating<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Seating detection status<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSeatingDetectionStatus(byte[] edt) {
			addProperty(EPC_SEATING_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
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
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br><br>0x31 to 0x3A<br><br>Name : Temperature level of toilet seat<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTemperatureLevelOfToiletSeat() {
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Heater setting of toilet seat<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Getter reqGetHeaterSettingOfToiletSeat() {
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Continuous setting / one time setting / no setting.<br><br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Name : Temporal halt setting of toilet seat<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTemporalHaltSettingOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt start time of toilet seat<br>EPC : 0xE3<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTemporalHaltStartTimeOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt time duration of toilet seat<br>EPC : 0xE4<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTemporalHaltTimeDurationOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT);
			return this;
		}
		/**
		 * Low / midium / high temperature<br><br>0x31 / 0x32 / 0x33<br><br>Name : Temperature level setting of room heating<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTemperatureLevelSettingOfRoomHeating() {
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING);
			return this;
		}
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br><br>0x41 / 0x42 / 0x43<br><br>Name : Room heating setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRoomHeatingSetting() {
			addProperty(EPC_ROOM_HEATING_SETTING);
			return this;
		}
		/**
		 * Room heating ON / room heating OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Room heating status<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRoomHeatingStatus() {
			addProperty(EPC_ROOM_HEATING_STATUS);
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Start time of room heating<br>EPC : 0xE8<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetStartTimeOfRoomHeating() {
			addProperty(EPC_START_TIME_OF_ROOM_HEATING);
			return this;
		}
		/**
		 * Duration time HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Duration time of room hreating<br>EPC : 0xE9<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDurationTimeOfRoomHreating() {
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING);
			return this;
		}
		/**
		 * Used to set a special operation mode and get the status<br><br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Name : Special operation mode setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSpecialOperationModeSetting() {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Indicate detection of human body<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Human detection status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHumanDetectionStatus() {
			addProperty(EPC_HUMAN_DETECTION_STATUS);
			return this;
		}
		/**
		 * This property indicates detection of seating<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Seating detection status<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSeatingDetectionStatus() {
			addProperty(EPC_SEATING_DETECTION_STATUS);
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
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br><br>0x31 to 0x3A<br><br>Name : Temperature level of toilet seat<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTemperatureLevelOfToiletSeat();
		/**
		 * ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Heater setting of toilet seat<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Informer reqInformHeaterSettingOfToiletSeat();
		/**
		 * Continuous setting / one time setting / no setting.<br><br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Name : Temporal halt setting of toilet seat<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTemporalHaltSettingOfToiletSeat();
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt start time of toilet seat<br>EPC : 0xE3<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTemporalHaltStartTimeOfToiletSeat();
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Temporal halt time duration of toilet seat<br>EPC : 0xE4<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTemporalHaltTimeDurationOfToiletSeat();
		/**
		 * Low / midium / high temperature<br><br>0x31 / 0x32 / 0x33<br><br>Name : Temperature level setting of room heating<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTemperatureLevelSettingOfRoomHeating();
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br><br>0x41 / 0x42 / 0x43<br><br>Name : Room heating setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRoomHeatingSetting();
		/**
		 * Room heating ON / room heating OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : Room heating status<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRoomHeatingStatus();
		/**
		 * Timer value HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Start time of room heating<br>EPC : 0xE8<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformStartTimeOfRoomHeating();
		/**
		 * Duration time HH:MM<br><br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Name : Duration time of room hreating<br>EPC : 0xE9<br>Data Type : unsigned char *2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDurationTimeOfRoomHreating();
		/**
		 * Used to set a special operation mode and get the status<br><br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Name : Special operation mode setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSpecialOperationModeSetting();
		/**
		 * Indicate detection of human body<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Human detection status<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHumanDetectionStatus();
		/**
		 * This property indicates detection of seating<br><br>Detected = 0x41 Non detecteed = 0x42<br><br>Name : Seating detection status<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSeatingDetectionStatus();
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
		public Informer reqInformTemperatureLevelOfToiletSeat() {
			byte epc = EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT;
			byte[] edt = _getTemperatureLevelOfToiletSeat(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeaterSettingOfToiletSeat() {
			byte epc = EPC_HEATER_SETTING_OF_TOILET_SEAT;
			byte[] edt = _getHeaterSettingOfToiletSeat(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemporalHaltSettingOfToiletSeat() {
			byte epc = EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT;
			byte[] edt = _getTemporalHaltSettingOfToiletSeat(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemporalHaltStartTimeOfToiletSeat() {
			byte epc = EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT;
			byte[] edt = _getTemporalHaltStartTimeOfToiletSeat(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformTemporalHaltTimeDurationOfToiletSeat() {
			byte epc = EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT;
			byte[] edt = _getTemporalHaltTimeDurationOfToiletSeat(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformTemperatureLevelSettingOfRoomHeating() {
			byte epc = EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING;
			byte[] edt = _getTemperatureLevelSettingOfRoomHeating(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRoomHeatingSetting() {
			byte epc = EPC_ROOM_HEATING_SETTING;
			byte[] edt = _getRoomHeatingSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRoomHeatingStatus() {
			byte epc = EPC_ROOM_HEATING_STATUS;
			byte[] edt = _getRoomHeatingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformStartTimeOfRoomHeating() {
			byte epc = EPC_START_TIME_OF_ROOM_HEATING;
			byte[] edt = _getStartTimeOfRoomHeating(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformDurationTimeOfRoomHreating() {
			byte epc = EPC_DURATION_TIME_OF_ROOM_HREATING;
			byte[] edt = _getDurationTimeOfRoomHreating(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSpecialOperationModeSetting() {
			byte epc = EPC_SPECIAL_OPERATION_MODE_SETTING;
			byte[] edt = _getSpecialOperationModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHumanDetectionStatus() {
			byte epc = EPC_HUMAN_DETECTION_STATUS;
			byte[] edt = _getHumanDetectionStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSeatingDetectionStatus() {
			byte epc = EPC_SEATING_DETECTION_STATUS;
			byte[] edt = _getSeatingDetectionStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformTemperatureLevelOfToiletSeat() {
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Informer reqInformHeaterSettingOfToiletSeat() {
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Informer reqInformTemporalHaltSettingOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Informer reqInformTemporalHaltStartTimeOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Informer reqInformTemporalHaltTimeDurationOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Informer reqInformTemperatureLevelSettingOfRoomHeating() {
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING);
			return this;
		}
		@Override
		public Informer reqInformRoomHeatingSetting() {
			addProperty(EPC_ROOM_HEATING_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRoomHeatingStatus() {
			addProperty(EPC_ROOM_HEATING_STATUS);
			return this;
		}
		@Override
		public Informer reqInformStartTimeOfRoomHeating() {
			addProperty(EPC_START_TIME_OF_ROOM_HEATING);
			return this;
		}
		@Override
		public Informer reqInformDurationTimeOfRoomHreating() {
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING);
			return this;
		}
		@Override
		public Informer reqInformSpecialOperationModeSetting() {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformHumanDetectionStatus() {
			addProperty(EPC_HUMAN_DETECTION_STATUS);
			return this;
		}
		@Override
		public Informer reqInformSeatingDetectionStatus() {
			addProperty(EPC_SEATING_DETECTION_STATUS);
			return this;
		}
	}
}
