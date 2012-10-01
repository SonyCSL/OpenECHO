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
	@SuppressWarnings("unused")
	private static final String TAG = ElectricToiletSeat.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x6E;

	protected static final byte EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT = (byte)0xE0;
	protected static final byte EPC_HEATER_SETTING_OF_TOILET_SEAT = (byte)0xE1;
	protected static final byte EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT = (byte)0xE2;
	protected static final byte EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT = (byte)0xE3;
	protected static final byte EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT = (byte)0xE4;
	protected static final byte EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING = (byte)0xE5;
	protected static final byte EPC_ROOM_HEATING_SETTING = (byte)0xE6;
	protected static final byte EPC_ROOM_HEATING_STATUS = (byte)0xE7;
	protected static final byte EPC_START_TIME_OF_ROOM_HEATING = (byte)0xE8;
	protected static final byte EPC_DURATION_TIME_OF_ROOM_HREATING = (byte)0xE9;
	protected static final byte EPC_SPECIAL_OPERATION_MODE_SETTING = (byte)0xEA;
	protected static final byte EPC_HUMAN_DETECTION_STATUS = (byte)0xEB;
	protected static final byte EPC_SEATING_DETECTION_STATUS = (byte)0xEC;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setTemperatureLevelOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTemperatureLevelOfToiletSeat() {return null;}
	/**
	 * ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setHeaterSettingOfToiletSeat(byte[] edt);
	/**
	 * ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getHeaterSettingOfToiletSeat();
	/**
	 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setTemporalHaltSettingOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTemporalHaltSettingOfToiletSeat() {return null;}
	/**
	 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setTemporalHaltStartTimeOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTemporalHaltStartTimeOfToiletSeat() {return null;}
	/**
	 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setTemporalHaltTimeDurationOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTemporalHaltTimeDurationOfToiletSeat() {return null;}
	/**
	 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setTemperatureLevelSettingOfRoomHeating(byte[] edt) {return false;}
	/**
	 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTemperatureLevelSettingOfRoomHeating() {return null;}
	/**
	 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRoomHeatingSetting(byte[] edt) {return false;}
	/**
	 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRoomHeatingSetting() {return null;}
	/**
	 * Room heating ON / room heating OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRoomHeatingStatus() {return null;}
	/**
	 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setStartTimeOfRoomHeating(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getStartTimeOfRoomHeating() {return null;}
	/**
	 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setDurationTimeOfRoomHreating(byte[] edt) {return false;}
	/**
	 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDurationTimeOfRoomHreating() {return null;}
	/**
	 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSpecialOperationModeSetting(byte[] edt) {return false;}
	/**
	 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSpecialOperationModeSetting() {return null;}
	/**
	 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setHumanDetectionStatus(byte[] edt) {return false;}
	/**
	 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHumanDetectionStatus() {return null;}
	/**
	 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSeatingDetectionStatus(byte[] edt) {return false;}
	/**
	 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSeatingDetectionStatus() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT:
			res.addProperty(epc, edt, setTemperatureLevelOfToiletSeat(edt));
			break;
		case EPC_HEATER_SETTING_OF_TOILET_SEAT:
			res.addProperty(epc, edt, setHeaterSettingOfToiletSeat(edt));
			break;
		case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT:
			res.addProperty(epc, edt, setTemporalHaltSettingOfToiletSeat(edt));
			break;
		case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT:
			res.addProperty(epc, edt, setTemporalHaltStartTimeOfToiletSeat(edt));
			break;
		case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT:
			res.addProperty(epc, edt, setTemporalHaltTimeDurationOfToiletSeat(edt));
			break;
		case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING:
			res.addProperty(epc, edt, setTemperatureLevelSettingOfRoomHeating(edt));
			break;
		case EPC_ROOM_HEATING_SETTING:
			res.addProperty(epc, edt, setRoomHeatingSetting(edt));
			break;
		case EPC_START_TIME_OF_ROOM_HEATING:
			res.addProperty(epc, edt, setStartTimeOfRoomHeating(edt));
			break;
		case EPC_DURATION_TIME_OF_ROOM_HREATING:
			res.addProperty(epc, edt, setDurationTimeOfRoomHreating(edt));
			break;
		case EPC_SPECIAL_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, setSpecialOperationModeSetting(edt));
			break;
		case EPC_HUMAN_DETECTION_STATUS:
			res.addProperty(epc, edt, setHumanDetectionStatus(edt));
			break;
		case EPC_SEATING_DETECTION_STATUS:
			res.addProperty(epc, edt, setSeatingDetectionStatus(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT:
			edt = getTemperatureLevelOfToiletSeat();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATER_SETTING_OF_TOILET_SEAT:
			edt = getHeaterSettingOfToiletSeat();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT:
			edt = getTemporalHaltSettingOfToiletSeat();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT:
			edt = getTemporalHaltStartTimeOfToiletSeat();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT:
			edt = getTemporalHaltTimeDurationOfToiletSeat();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING:
			edt = getTemperatureLevelSettingOfRoomHeating();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ROOM_HEATING_SETTING:
			edt = getRoomHeatingSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ROOM_HEATING_STATUS:
			edt = getRoomHeatingStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_START_TIME_OF_ROOM_HEATING:
			edt = getStartTimeOfRoomHeating();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_DURATION_TIME_OF_ROOM_HREATING:
			edt = getDurationTimeOfRoomHreating();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SPECIAL_OPERATION_MODE_SETTING:
			edt = getSpecialOperationModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HUMAN_DETECTION_STATUS:
			edt = getHumanDetectionStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SEATING_DETECTION_STATUS:
			edt = getSeatingDetectionStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;

		}
	}
	
	@Override
	public Setter set() {
		return new SetterImpl(ESV_SET_NO_RES);
	}

	@Override
	public Setter setC() {
		return new SetterImpl(ESV_SET_RES);
	}

	@Override
	public Getter get() {
		return new GetterImpl();
	}

	@Override
	public Informer inform() {
		return new InformerImpl();
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT:
				onSetTemperatureLevelOfToiletSeat(eoj, tid, (pdc != 0));
				break;
			case EPC_HEATER_SETTING_OF_TOILET_SEAT:
				onSetHeaterSettingOfToiletSeat(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT:
				onSetTemporalHaltSettingOfToiletSeat(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT:
				onSetTemporalHaltStartTimeOfToiletSeat(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT:
				onSetTemporalHaltTimeDurationOfToiletSeat(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING:
				onSetTemperatureLevelSettingOfRoomHeating(eoj, tid, (pdc != 0));
				break;
			case EPC_ROOM_HEATING_SETTING:
				onSetRoomHeatingSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_START_TIME_OF_ROOM_HEATING:
				onSetStartTimeOfRoomHeating(eoj, tid, (pdc != 0));
				break;
			case EPC_DURATION_TIME_OF_ROOM_HREATING:
				onSetDurationTimeOfRoomHreating(eoj, tid, (pdc != 0));
				break;
			case EPC_SPECIAL_OPERATION_MODE_SETTING:
				onSetSpecialOperationModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_HUMAN_DETECTION_STATUS:
				onSetHumanDetectionStatus(eoj, tid, (pdc != 0));
				break;
			case EPC_SEATING_DETECTION_STATUS:
				onSetSeatingDetectionStatus(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT:
				onGetTemperatureLevelOfToiletSeat(eoj, tid, pdc, edt);
				break;
			case EPC_HEATER_SETTING_OF_TOILET_SEAT:
				onGetHeaterSettingOfToiletSeat(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT:
				onGetTemporalHaltSettingOfToiletSeat(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT:
				onGetTemporalHaltStartTimeOfToiletSeat(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT:
				onGetTemporalHaltTimeDurationOfToiletSeat(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING:
				onGetTemperatureLevelSettingOfRoomHeating(eoj, tid, pdc, edt);
				break;
			case EPC_ROOM_HEATING_SETTING:
				onGetRoomHeatingSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ROOM_HEATING_STATUS:
				onGetRoomHeatingStatus(eoj, tid, pdc, edt);
				break;
			case EPC_START_TIME_OF_ROOM_HEATING:
				onGetStartTimeOfRoomHeating(eoj, tid, pdc, edt);
				break;
			case EPC_DURATION_TIME_OF_ROOM_HREATING:
				onGetDurationTimeOfRoomHreating(eoj, tid, pdc, edt);
				break;
			case EPC_SPECIAL_OPERATION_MODE_SETTING:
				onGetSpecialOperationModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_HUMAN_DETECTION_STATUS:
				onGetHumanDetectionStatus(eoj, tid, pdc, edt);
				break;
			case EPC_SEATING_DETECTION_STATUS:
				onGetSeatingDetectionStatus(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRoomHeatingSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRoomHeatingSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Room heating ON / room heating OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRoomHeatingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetStartTimeOfRoomHeating(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetStartTimeOfRoomHeating(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetDurationTimeOfRoomHreating(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetDurationTimeOfRoomHreating(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSpecialOperationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetHumanDetectionStatus(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetHumanDetectionStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSeatingDetectionStatus(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSeatingDetectionStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

	}
	
	public interface Setter extends DeviceObject.Setter {
		public Setter reqSetOperationStatus(byte[] edt);
		public Setter reqSetInstallationLocation(byte[] edt);
		public Setter reqSetCurrentLimitSetting(byte[] edt);
		public Setter reqSetPowerSavingOperationSetting(byte[] edt);
		public Setter reqSetPositionInformation(byte[] edt);
		public Setter reqSetCurrentTimeSetting(byte[] edt);
		public Setter reqSetCurrentDateSetting(byte[] edt);
		public Setter reqSetPowerLimitSetting(byte[] edt);
		
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTemperatureLevelOfToiletSeat(byte[] edt);
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetHeaterSettingOfToiletSeat(byte[] edt);
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTemporalHaltSettingOfToiletSeat(byte[] edt);
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTemporalHaltStartTimeOfToiletSeat(byte[] edt);
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTemporalHaltTimeDurationOfToiletSeat(byte[] edt);
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTemperatureLevelSettingOfRoomHeating(byte[] edt);
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRoomHeatingSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetStartTimeOfRoomHeating(byte[] edt);
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDurationTimeOfRoomHreating(byte[] edt);
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSpecialOperationModeSetting(byte[] edt);
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetHumanDetectionStatus(byte[] edt);
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSeatingDetectionStatus(byte[] edt);
	}

	public class SetterImpl extends DeviceObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
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

		@Override
		public Setter reqSetTemperatureLevelOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT, edt, setTemperatureLevelOfToiletSeat(edt));
			return this;
		}
		@Override
		public Setter reqSetHeaterSettingOfToiletSeat(byte[] edt) {
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT, edt, setHeaterSettingOfToiletSeat(edt));
			return this;
		}
		@Override
		public Setter reqSetTemporalHaltSettingOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT, edt, setTemporalHaltSettingOfToiletSeat(edt));
			return this;
		}
		@Override
		public Setter reqSetTemporalHaltStartTimeOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT, edt, setTemporalHaltStartTimeOfToiletSeat(edt));
			return this;
		}
		@Override
		public Setter reqSetTemporalHaltTimeDurationOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT, edt, setTemporalHaltTimeDurationOfToiletSeat(edt));
			return this;
		}
		@Override
		public Setter reqSetTemperatureLevelSettingOfRoomHeating(byte[] edt) {
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING, edt, setTemperatureLevelSettingOfRoomHeating(edt));
			return this;
		}
		@Override
		public Setter reqSetRoomHeatingSetting(byte[] edt) {
			addProperty(EPC_ROOM_HEATING_SETTING, edt, setRoomHeatingSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetStartTimeOfRoomHeating(byte[] edt) {
			addProperty(EPC_START_TIME_OF_ROOM_HEATING, edt, setStartTimeOfRoomHeating(edt));
			return this;
		}
		@Override
		public Setter reqSetDurationTimeOfRoomHreating(byte[] edt) {
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING, edt, setDurationTimeOfRoomHreating(edt));
			return this;
		}
		@Override
		public Setter reqSetSpecialOperationModeSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, setSpecialOperationModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetHumanDetectionStatus(byte[] edt) {
			addProperty(EPC_HUMAN_DETECTION_STATUS, edt, setHumanDetectionStatus(edt));
			return this;
		}
		@Override
		public Setter reqSetSeatingDetectionStatus(byte[] edt) {
			addProperty(EPC_SEATING_DETECTION_STATUS, edt, setSeatingDetectionStatus(edt));
			return this;
		}
	}
	
	public class SetterProxy extends DeviceObject.SetterProxy implements Setter {

		public SetterProxy(byte esv) {
			super(esv);
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

		@Override
		public Setter reqSetTemperatureLevelOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHeaterSettingOfToiletSeat(byte[] edt) {
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetTemporalHaltSettingOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetTemporalHaltStartTimeOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetTemporalHaltTimeDurationOfToiletSeat(byte[] edt) {
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetTemperatureLevelSettingOfRoomHeating(byte[] edt) {
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRoomHeatingSetting(byte[] edt) {
			addProperty(EPC_ROOM_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetStartTimeOfRoomHeating(byte[] edt) {
			addProperty(EPC_START_TIME_OF_ROOM_HEATING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetDurationTimeOfRoomHreating(byte[] edt) {
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetSpecialOperationModeSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHumanDetectionStatus(byte[] edt) {
			addProperty(EPC_HUMAN_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSeatingDetectionStatus(byte[] edt) {
			addProperty(EPC_SEATING_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
	}

	public interface Getter extends DeviceObject.Getter {
		public Getter reqGetOperationStatus();
		public Getter reqGetInstallationLocation();
		public Getter reqGetStandardVersionInformation();
		public Getter reqGetIdentificationNumber();
		public Getter reqGetMeasuredInstantaneousPowerConsumption();
		public Getter reqGetMeasuredCumulativePowerConsumption();
		public Getter reqGetManufacturersFaultCode();
		public Getter reqGetCurrentLimitSetting();
		public Getter reqGetFaultStatus();
		public Getter reqGetFaultDescription();
		public Getter reqGetManufacturerCode();
		public Getter reqGetBusinessFacilityCode();
		public Getter reqGetProductCode();
		public Getter reqGetProductionNumber();
		public Getter reqGetProductionDate();
		public Getter reqGetPowerSavingOperationSetting();
		public Getter reqGetPositionInformation();
		public Getter reqGetCurrentTimeSetting();
		public Getter reqGetCurrentDateSetting();
		public Getter reqGetPowerLimitSetting();
		public Getter reqGetCumulativeOperatingTime();
		public Getter reqGetStatusChangeAnnouncementPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTemperatureLevelOfToiletSeat();
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetHeaterSettingOfToiletSeat();
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTemporalHaltSettingOfToiletSeat();
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTemporalHaltStartTimeOfToiletSeat();
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTemporalHaltTimeDurationOfToiletSeat();
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTemperatureLevelSettingOfRoomHeating();
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRoomHeatingSetting();
		/**
		 * Room heating ON / room heating OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRoomHeatingStatus();
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetStartTimeOfRoomHeating();
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDurationTimeOfRoomHreating();
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSpecialOperationModeSetting();
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetHumanDetectionStatus();
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSeatingDetectionStatus();
	}
	
	public class GetterImpl extends DeviceObject.GetterImpl implements Getter {

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

		@Override
		public Getter reqGetTemperatureLevelOfToiletSeat() {
			byte[] edt = getTemperatureLevelOfToiletSeat();
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeaterSettingOfToiletSeat() {
			byte[] edt = getHeaterSettingOfToiletSeat();
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTemporalHaltSettingOfToiletSeat() {
			byte[] edt = getTemporalHaltSettingOfToiletSeat();
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTemporalHaltStartTimeOfToiletSeat() {
			byte[] edt = getTemporalHaltStartTimeOfToiletSeat();
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetTemporalHaltTimeDurationOfToiletSeat() {
			byte[] edt = getTemporalHaltTimeDurationOfToiletSeat();
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetTemperatureLevelSettingOfRoomHeating() {
			byte[] edt = getTemperatureLevelSettingOfRoomHeating();
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRoomHeatingSetting() {
			byte[] edt = getRoomHeatingSetting();
			addProperty(EPC_ROOM_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRoomHeatingStatus() {
			byte[] edt = getRoomHeatingStatus();
			addProperty(EPC_ROOM_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetStartTimeOfRoomHeating() {
			byte[] edt = getStartTimeOfRoomHeating();
			addProperty(EPC_START_TIME_OF_ROOM_HEATING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetDurationTimeOfRoomHreating() {
			byte[] edt = getDurationTimeOfRoomHreating();
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSpecialOperationModeSetting() {
			byte[] edt = getSpecialOperationModeSetting();
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHumanDetectionStatus() {
			byte[] edt = getHumanDetectionStatus();
			addProperty(EPC_HUMAN_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSeatingDetectionStatus() {
			byte[] edt = getSeatingDetectionStatus();
			addProperty(EPC_SEATING_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
	}

	public class GetterProxy extends DeviceObject.GetterProxy implements Getter {

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

		@Override
		public Getter reqGetTemperatureLevelOfToiletSeat() {
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Getter reqGetHeaterSettingOfToiletSeat() {
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Getter reqGetTemporalHaltSettingOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Getter reqGetTemporalHaltStartTimeOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Getter reqGetTemporalHaltTimeDurationOfToiletSeat() {
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT);
			return this;
		}
		@Override
		public Getter reqGetTemperatureLevelSettingOfRoomHeating() {
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING);
			return this;
		}
		@Override
		public Getter reqGetRoomHeatingSetting() {
			addProperty(EPC_ROOM_HEATING_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRoomHeatingStatus() {
			addProperty(EPC_ROOM_HEATING_STATUS);
			return this;
		}
		@Override
		public Getter reqGetStartTimeOfRoomHeating() {
			addProperty(EPC_START_TIME_OF_ROOM_HEATING);
			return this;
		}
		@Override
		public Getter reqGetDurationTimeOfRoomHreating() {
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING);
			return this;
		}
		@Override
		public Getter reqGetSpecialOperationModeSetting() {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetHumanDetectionStatus() {
			addProperty(EPC_HUMAN_DETECTION_STATUS);
			return this;
		}
		@Override
		public Getter reqGetSeatingDetectionStatus() {
			addProperty(EPC_SEATING_DETECTION_STATUS);
			return this;
		}
	}
	
	public interface Informer extends DeviceObject.Informer {
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
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTemperatureLevelOfToiletSeat();
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformHeaterSettingOfToiletSeat();
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTemporalHaltSettingOfToiletSeat();
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTemporalHaltStartTimeOfToiletSeat();
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTemporalHaltTimeDurationOfToiletSeat();
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTemperatureLevelSettingOfRoomHeating();
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRoomHeatingSetting();
		/**
		 * Room heating ON / room heating OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRoomHeatingStatus();
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformStartTimeOfRoomHeating();
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)<br><br>Data type : unsigned char *2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDurationTimeOfRoomHreating();
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSpecialOperationModeSetting();
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformHumanDetectionStatus();
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSeatingDetectionStatus();
	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {

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
			byte[] edt = getTemperatureLevelOfToiletSeat();
			addProperty(EPC_TEMPERATURE_LEVEL_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeaterSettingOfToiletSeat() {
			byte[] edt = getHeaterSettingOfToiletSeat();
			addProperty(EPC_HEATER_SETTING_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemporalHaltSettingOfToiletSeat() {
			byte[] edt = getTemporalHaltSettingOfToiletSeat();
			addProperty(EPC_TEMPORAL_HALT_SETTING_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemporalHaltStartTimeOfToiletSeat() {
			byte[] edt = getTemporalHaltStartTimeOfToiletSeat();
			addProperty(EPC_TEMPORAL_HALT_START_TIME_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformTemporalHaltTimeDurationOfToiletSeat() {
			byte[] edt = getTemporalHaltTimeDurationOfToiletSeat();
			addProperty(EPC_TEMPORAL_HALT_TIME_DURATION_OF_TOILET_SEAT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformTemperatureLevelSettingOfRoomHeating() {
			byte[] edt = getTemperatureLevelSettingOfRoomHeating();
			addProperty(EPC_TEMPERATURE_LEVEL_SETTING_OF_ROOM_HEATING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRoomHeatingSetting() {
			byte[] edt = getRoomHeatingSetting();
			addProperty(EPC_ROOM_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRoomHeatingStatus() {
			byte[] edt = getRoomHeatingStatus();
			addProperty(EPC_ROOM_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformStartTimeOfRoomHeating() {
			byte[] edt = getStartTimeOfRoomHeating();
			addProperty(EPC_START_TIME_OF_ROOM_HEATING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformDurationTimeOfRoomHreating() {
			byte[] edt = getDurationTimeOfRoomHreating();
			addProperty(EPC_DURATION_TIME_OF_ROOM_HREATING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSpecialOperationModeSetting() {
			byte[] edt = getSpecialOperationModeSetting();
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHumanDetectionStatus() {
			byte[] edt = getHumanDetectionStatus();
			addProperty(EPC_HUMAN_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSeatingDetectionStatus() {
			byte[] edt = getSeatingDetectionStatus();
			addProperty(EPC_SEATING_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {

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
