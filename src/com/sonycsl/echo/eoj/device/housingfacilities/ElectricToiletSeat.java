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
	protected static final byte EPC_POWER_SAVING_OPERATION_SETTING = (byte)0x8F;
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
	 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A
	 */
	protected boolean setTemperatureLevelOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A
	 */
	protected byte[] getTemperatureLevelOfToiletSeat() {return null;}
	/**
	 * ON/OFF<br>ON=0x41, OFF=0x42
	 */
	protected abstract boolean setHeaterSettingOfToiletSeat(byte[] edt);
	/**
	 * ON/OFF<br>ON=0x41, OFF=0x42
	 */
	protected abstract byte[] getHeaterSettingOfToiletSeat();
	/**
	 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43
	 */
	protected boolean setTemporalHaltSettingOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43
	 */
	protected byte[] getTemporalHaltSettingOfToiletSeat() {return null;}
	/**
	 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
	 */
	protected boolean setTemporalHaltStartTimeOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
	 */
	protected byte[] getTemporalHaltStartTimeOfToiletSeat() {return null;}
	/**
	 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
	 */
	protected boolean setTemporalHaltTimeDurationOfToiletSeat(byte[] edt) {return false;}
	/**
	 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
	 */
	protected byte[] getTemporalHaltTimeDurationOfToiletSeat() {return null;}
	/**
	 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33
	 */
	protected boolean setTemperatureLevelSettingOfRoomHeating(byte[] edt) {return false;}
	/**
	 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33
	 */
	protected byte[] getTemperatureLevelSettingOfRoomHeating() {return null;}
	/**
	 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43
	 */
	protected boolean setRoomHeatingSetting(byte[] edt) {return false;}
	/**
	 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43
	 */
	protected byte[] getRoomHeatingSetting() {return null;}
	/**
	 * Room heating ON / room heating OFF<br>ON=0x41, OFF=0x42
	 */
	protected byte[] getRoomHeatingStatus() {return null;}
	/**
	 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
	 */
	protected boolean setStartTimeOfRoomHeating(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
	 */
	protected byte[] getStartTimeOfRoomHeating() {return null;}
	/**
	 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
	 */
	protected boolean setDurationTimeOfRoomHreating(byte[] edt) {return false;}
	/**
	 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
	 */
	protected byte[] getDurationTimeOfRoomHreating() {return null;}
	/**
	 * Power saving mode ON/OFF<br>ON=0x41, OFF=0x42
	 */
	protected boolean setPowerSavingOperationSetting(byte[] edt) {return false;}
	/**
	 * Power saving mode ON/OFF<br>ON=0x41, OFF=0x42
	 */
	protected byte[] getPowerSavingOperationSetting() {return null;}
	/**
	 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-
	 */
	protected boolean setSpecialOperationModeSetting(byte[] edt) {return false;}
	/**
	 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-
	 */
	protected byte[] getSpecialOperationModeSetting() {return null;}
	/**
	 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42
	 */
	protected boolean setHumanDetectionStatus(byte[] edt) {return false;}
	/**
	 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42
	 */
	protected byte[] getHumanDetectionStatus() {return null;}
	/**
	 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42
	 */
	protected boolean setSeatingDetectionStatus(byte[] edt) {return false;}
	/**
	 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42
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
		case EPC_POWER_SAVING_OPERATION_SETTING:
			res.addProperty(epc, edt, setPowerSavingOperationSetting(edt));
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
		case EPC_POWER_SAVING_OPERATION_SETTING:
			edt = getPowerSavingOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
			case EPC_POWER_SAVING_OPERATION_SETTING:
				onSetPowerSavingOperationSetting(eoj, tid, (pdc != 0));
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
			case EPC_POWER_SAVING_OPERATION_SETTING:
				onGetPowerSavingOperationSetting(eoj, tid, pdc, edt);
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
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A
		 */
		protected void onSetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A
		 */
		protected void onGetTemperatureLevelOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42
		 */
		protected void onSetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42
		 */
		protected void onGetHeaterSettingOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43
		 */
		protected void onSetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43
		 */
		protected void onGetTemporalHaltSettingOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		protected void onSetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		protected void onGetTemporalHaltStartTimeOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		protected void onSetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		protected void onGetTemporalHaltTimeDurationOfToiletSeat(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33
		 */
		protected void onSetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33
		 */
		protected void onGetTemperatureLevelSettingOfRoomHeating(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43
		 */
		protected void onSetRoomHeatingSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43
		 */
		protected void onGetRoomHeatingSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Room heating ON / room heating OFF<br>ON=0x41, OFF=0x42
		 */
		protected void onGetRoomHeatingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		protected void onSetStartTimeOfRoomHeating(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		protected void onGetStartTimeOfRoomHeating(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		protected void onSetDurationTimeOfRoomHreating(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		protected void onGetDurationTimeOfRoomHreating(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Power saving mode ON/OFF<br>ON=0x41, OFF=0x42
		 */
		protected void onSetPowerSavingOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Power saving mode ON/OFF<br>ON=0x41, OFF=0x42
		 */
		protected void onGetPowerSavingOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-
		 */
		protected void onSetSpecialOperationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-
		 */
		protected void onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42
		 */
		protected void onSetHumanDetectionStatus(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42
		 */
		protected void onGetHumanDetectionStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42
		 */
		protected void onSetSeatingDetectionStatus(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42
		 */
		protected void onGetSeatingDetectionStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

	}
	
	public interface Setter extends DeviceObject.Setter {
		public Setter reqSetPower(byte[] edt);
		public Setter reqSetInstallationLocation(byte[] edt);
		public Setter reqSetCurrentLimiting(byte[] edt);
		public Setter reqSetPowerSaving(byte[] edt);
		public Setter reqSetLocation(byte[] edt);
		public Setter reqSetCurrentTime(byte[] edt);
		public Setter reqSetCurrentDate(byte[] edt);
		public Setter reqSetPowerLimitation(byte[] edt);
		
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A
		 */
		public Setter reqSetTemperatureLevelOfToiletSeat(byte[] edt);
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42
		 */
		public Setter reqSetHeaterSettingOfToiletSeat(byte[] edt);
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43
		 */
		public Setter reqSetTemporalHaltSettingOfToiletSeat(byte[] edt);
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Setter reqSetTemporalHaltStartTimeOfToiletSeat(byte[] edt);
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Setter reqSetTemporalHaltTimeDurationOfToiletSeat(byte[] edt);
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33
		 */
		public Setter reqSetTemperatureLevelSettingOfRoomHeating(byte[] edt);
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43
		 */
		public Setter reqSetRoomHeatingSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Setter reqSetStartTimeOfRoomHeating(byte[] edt);
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Setter reqSetDurationTimeOfRoomHreating(byte[] edt);
		/**
		 * Power saving mode ON/OFF<br>ON=0x41, OFF=0x42
		 */
		public Setter reqSetPowerSavingOperationSetting(byte[] edt);
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-
		 */
		public Setter reqSetSpecialOperationModeSetting(byte[] edt);
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42
		 */
		public Setter reqSetHumanDetectionStatus(byte[] edt);
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42
		 */
		public Setter reqSetSeatingDetectionStatus(byte[] edt);

	}

	public class SetterImpl extends DeviceObject.SetterImpl implements Setter {

		public SetterImpl(byte esv) {
			super(esv);
		}
		
		@Override
		public Setter reqSetPower(byte[] edt) {
			return (Setter)super.reqSetPower(edt);
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimiting(edt);
		}

		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			return (Setter)super.reqSetPowerSaving(edt);
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			return (Setter)super.reqSetLocation(edt);
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			return (Setter)super.reqSetCurrentTime(edt);
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			return (Setter)super.reqSetCurrentDate(edt);
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			return (Setter)super.reqSetPowerLimitation(edt);
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
		public Setter reqSetPowerSavingOperationSetting(byte[] edt) {
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt, setPowerSavingOperationSetting(edt));
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
		public Setter reqSetPower(byte[] edt) {
			return (Setter)super.reqSetPower(edt);
		}

		@Override
		public Setter reqSetInstallationLocation(byte[] edt) {
			return (Setter)super.reqSetInstallationLocation(edt);
		}

		@Override
		public Setter reqSetCurrentLimiting(byte[] edt) {
			return (Setter)super.reqSetCurrentLimiting(edt);
		}

		@Override
		public Setter reqSetPowerSaving(byte[] edt) {
			return (Setter)super.reqSetPowerSaving(edt);
		}

		@Override
		public Setter reqSetLocation(byte[] edt) {
			return (Setter)super.reqSetLocation(edt);
		}

		@Override
		public Setter reqSetCurrentTime(byte[] edt) {
			return (Setter)super.reqSetCurrentTime(edt);
		}

		@Override
		public Setter reqSetCurrentDate(byte[] edt) {
			return (Setter)super.reqSetCurrentDate(edt);
		}

		@Override
		public Setter reqSetPowerLimitation(byte[] edt) {
			return (Setter)super.reqSetPowerLimitation(edt);
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
		public Setter reqSetPowerSavingOperationSetting(byte[] edt) {
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetPower();
		public Getter reqGetInstallationLocation();
		public Getter reqGetVersion();
		public Getter reqGetIdNumber();
		public Getter reqGetElectricityConsumption();
		public Getter reqGetPowerConsumption();
		public Getter reqGetMakerErrorCode();
		public Getter reqGetCurrentLimiting();
		public Getter reqGetError();
		public Getter reqGetErrorInfo();
		public Getter reqGetMakerCode();
		public Getter reqGetWorkplaceCode();
		public Getter reqGetProductCode();
		public Getter reqGetManufacturingNumber();
		public Getter reqGetDateOfManufacture();
		public Getter reqGetPowerSaving();
		public Getter reqGetLocation();
		public Getter reqGetCurrentTime();
		public Getter reqGetCurrentDate();
		public Getter reqGetPowerLimitation();
		public Getter reqGetWorkingTime();
		public Getter reqGetAnnoPropertyMap();
		public Getter reqGetSetPropertyMap();
		public Getter reqGetGetPropertyMap();
		
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A
		 */
		public Getter reqGetTemperatureLevelOfToiletSeat();
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42
		 */
		public Getter reqGetHeaterSettingOfToiletSeat();
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43
		 */
		public Getter reqGetTemporalHaltSettingOfToiletSeat();
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Getter reqGetTemporalHaltStartTimeOfToiletSeat();
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Getter reqGetTemporalHaltTimeDurationOfToiletSeat();
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33
		 */
		public Getter reqGetTemperatureLevelSettingOfRoomHeating();
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43
		 */
		public Getter reqGetRoomHeatingSetting();
		/**
		 * Room heating ON / room heating OFF<br>ON=0x41, OFF=0x42
		 */
		public Getter reqGetRoomHeatingStatus();
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Getter reqGetStartTimeOfRoomHeating();
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Getter reqGetDurationTimeOfRoomHreating();
		/**
		 * Power saving mode ON/OFF<br>ON=0x41, OFF=0x42
		 */
		public Getter reqGetPowerSavingOperationSetting();
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-
		 */
		public Getter reqGetSpecialOperationModeSetting();
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42
		 */
		public Getter reqGetHumanDetectionStatus();
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42
		 */
		public Getter reqGetSeatingDetectionStatus();

	}
	
	public class GetterImpl extends DeviceObject.GetterImpl implements Getter {

		@Override
		public Getter reqGetPower() {
			return (Getter)super.reqGetPower();
		}

		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}

		@Override
		public Getter reqGetVersion() {
			return (Getter)super.reqGetVersion();
		}

		@Override
		public Getter reqGetIdNumber() {
			return (Getter)super.reqGetIdNumber();
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			return (Getter)super.reqGetElectricityConsumption();
		}

		@Override
		public Getter reqGetPowerConsumption() {
			return (Getter)super.reqGetPowerConsumption();
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			return (Getter)super.reqGetMakerErrorCode();
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			return (Getter)super.reqGetCurrentLimiting();
		}

		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
		}

		@Override
		public Getter reqGetErrorInfo() {
			return (Getter)super.reqGetErrorInfo();
		}

		@Override
		public Getter reqGetMakerCode() {
			return (Getter)super.reqGetMakerCode();
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			return (Getter)super.reqGetWorkplaceCode();
		}

		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			return (Getter)super.reqGetManufacturingNumber();
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
		}

		@Override
		public Getter reqGetPowerSaving() {
			return (Getter)super.reqGetPowerSaving();
		}

		@Override
		public Getter reqGetLocation() {
			return (Getter)super.reqGetLocation();
		}

		@Override
		public Getter reqGetCurrentTime() {
			return (Getter)super.reqGetCurrentTime();
		}

		@Override
		public Getter reqGetCurrentDate() {
			return (Getter)super.reqGetCurrentDate();
		}

		@Override
		public Getter reqGetPowerLimitation() {
			return (Getter)super.reqGetPowerLimitation();
		}

		@Override
		public Getter reqGetWorkingTime() {
			return (Getter)super.reqGetWorkingTime();
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			return (Getter)super.reqGetAnnoPropertyMap();
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
		public Getter reqGetPowerSavingOperationSetting() {
			byte[] edt = getPowerSavingOperationSetting();
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetPower() {
			return (Getter)super.reqGetPower();
		}

		@Override
		public Getter reqGetInstallationLocation() {
			return (Getter)super.reqGetInstallationLocation();
		}

		@Override
		public Getter reqGetVersion() {
			return (Getter)super.reqGetVersion();
		}

		@Override
		public Getter reqGetIdNumber() {
			return (Getter)super.reqGetIdNumber();
		}

		@Override
		public Getter reqGetElectricityConsumption() {
			return (Getter)super.reqGetElectricityConsumption();
		}

		@Override
		public Getter reqGetPowerConsumption() {
			return (Getter)super.reqGetPowerConsumption();
		}

		@Override
		public Getter reqGetMakerErrorCode() {
			return (Getter)super.reqGetMakerErrorCode();
		}

		@Override
		public Getter reqGetCurrentLimiting() {
			return (Getter)super.reqGetCurrentLimiting();
		}

		@Override
		public Getter reqGetError() {
			return (Getter)super.reqGetError();
		}

		@Override
		public Getter reqGetErrorInfo() {
			return (Getter)super.reqGetErrorInfo();
		}

		@Override
		public Getter reqGetMakerCode() {
			return (Getter)super.reqGetMakerCode();
		}

		@Override
		public Getter reqGetWorkplaceCode() {
			return (Getter)super.reqGetWorkplaceCode();
		}

		@Override
		public Getter reqGetProductCode() {
			return (Getter)super.reqGetProductCode();
		}

		@Override
		public Getter reqGetManufacturingNumber() {
			return (Getter)super.reqGetManufacturingNumber();
		}

		@Override
		public Getter reqGetDateOfManufacture() {
			return (Getter)super.reqGetDateOfManufacture();
		}

		@Override
		public Getter reqGetPowerSaving() {
			return (Getter)super.reqGetPowerSaving();
		}

		@Override
		public Getter reqGetLocation() {
			return (Getter)super.reqGetLocation();
		}

		@Override
		public Getter reqGetCurrentTime() {
			return (Getter)super.reqGetCurrentTime();
		}

		@Override
		public Getter reqGetCurrentDate() {
			return (Getter)super.reqGetCurrentDate();
		}

		@Override
		public Getter reqGetPowerLimitation() {
			return (Getter)super.reqGetPowerLimitation();
		}

		@Override
		public Getter reqGetWorkingTime() {
			return (Getter)super.reqGetWorkingTime();
		}

		@Override
		public Getter reqGetAnnoPropertyMap() {
			return (Getter)super.reqGetAnnoPropertyMap();
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
		public Getter reqGetPowerSavingOperationSetting() {
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING);
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
		public Informer reqInformPower();
		public Informer reqInformInstallationLocation();
		public Informer reqInformVersion();
		public Informer reqInformIdNumber();
		public Informer reqInformElectricityConsumption();
		public Informer reqInformPowerConsumption();
		public Informer reqInformMakerErrorCode();
		public Informer reqInformCurrentLimiting();
		public Informer reqInformError();
		public Informer reqInformErrorInfo();
		public Informer reqInformMakerCode();
		public Informer reqInformWorkplaceCode();
		public Informer reqInformProductCode();
		public Informer reqInformManufacturingNumber();
		public Informer reqInformDateOfManufacture();
		public Informer reqInformPowerSaving();
		public Informer reqInformLocation();
		public Informer reqInformCurrentTime();
		public Informer reqInformCurrentDate();
		public Informer reqInformPowerLimitation();
		public Informer reqInformWorkingTime();
		public Informer reqInformAnnoPropertyMap();
		public Informer reqInformSetPropertyMap();
		public Informer reqInformGetPropertyMap();
		
		/**
		 * Low to high temperature (10 steps) 0x31 for the lowest level, 0x3A for the highest level.<br>0x31 to 0x3A
		 */
		public Informer reqInformTemperatureLevelOfToiletSeat();
		/**
		 * ON/OFF<br>ON=0x41, OFF=0x42
		 */
		public Informer reqInformHeaterSettingOfToiletSeat();
		/**
		 * Continuous setting / one time setting / no setting.<br>Continuous setting=0x41, one time setting=0x42, no setting=0x43
		 */
		public Informer reqInformTemporalHaltSettingOfToiletSeat();
		/**
		 * Temporal halt start time of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Informer reqInformTemporalHaltStartTimeOfToiletSeat();
		/**
		 * Temporal stop time duration of toilet seat timer value: HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Informer reqInformTemporalHaltTimeDurationOfToiletSeat();
		/**
		 * Low / midium / high temperature<br>0x31 / 0x32 / 0x33
		 */
		public Informer reqInformTemperatureLevelSettingOfRoomHeating();
		/**
		 * Room heating ON / room heating OFF / timer mode setting<br>0x41 / 0x42 / 0x43
		 */
		public Informer reqInformRoomHeatingSetting();
		/**
		 * Room heating ON / room heating OFF<br>ON=0x41, OFF=0x42
		 */
		public Informer reqInformRoomHeatingStatus();
		/**
		 * Timer value HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Informer reqInformStartTimeOfRoomHeating();
		/**
		 * Duration time HH:MM<br>0 to 0x17 : 0 to 0x3B (=0 to 23) : (=0 to 59)
		 */
		public Informer reqInformDurationTimeOfRoomHreating();
		/**
		 * Power saving mode ON/OFF<br>ON=0x41, OFF=0x42
		 */
		public Informer reqInformPowerSavingOperationSetting();
		/**
		 * Used to set a special operation mode and get the status<br>No setting: 0x40, Over-cool prevention: 0x41 for future reserved: 0x42-
		 */
		public Informer reqInformSpecialOperationModeSetting();
		/**
		 * Indicate detection of human body<br>Detected = 0x41 Non detecteed = 0x42
		 */
		public Informer reqInformHumanDetectionStatus();
		/**
		 * This property indicates detection of seating<br>Detected = 0x41 Non detecteed = 0x42
		 */
		public Informer reqInformSeatingDetectionStatus();

	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {

		@Override
		public Informer reqInformPower() {
			return (Informer)super.reqInformPower();
		}

		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}

		@Override
		public Informer reqInformVersion() {
			return (Informer)super.reqInformVersion();
		}

		@Override
		public Informer reqInformIdNumber() {
			return (Informer)super.reqInformIdNumber();
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			return (Informer)super.reqInformElectricityConsumption();
		}

		@Override
		public Informer reqInformPowerConsumption() {
			return (Informer)super.reqInformPowerConsumption();
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			return (Informer)super.reqInformMakerErrorCode();
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			return (Informer)super.reqInformCurrentLimiting();
		}

		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
		}

		@Override
		public Informer reqInformErrorInfo() {
			return (Informer)super.reqInformErrorInfo();
		}

		@Override
		public Informer reqInformMakerCode() {
			return (Informer)super.reqInformMakerCode();
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			return (Informer)super.reqInformWorkplaceCode();
		}

		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			return (Informer)super.reqInformManufacturingNumber();
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}

		@Override
		public Informer reqInformPowerSaving() {
			return (Informer)super.reqInformPowerSaving();
		}

		@Override
		public Informer reqInformLocation() {
			return (Informer)super.reqInformLocation();
		}

		@Override
		public Informer reqInformCurrentTime() {
			return (Informer)super.reqInformCurrentTime();
		}

		@Override
		public Informer reqInformCurrentDate() {
			return (Informer)super.reqInformCurrentDate();
		}

		@Override
		public Informer reqInformPowerLimitation() {
			return (Informer)super.reqInformPowerLimitation();
		}

		@Override
		public Informer reqInformWorkingTime() {
			return (Informer)super.reqInformWorkingTime();
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
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
		public Informer reqInformPowerSavingOperationSetting() {
			byte[] edt = getPowerSavingOperationSetting();
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformPower() {
			return (Informer)super.reqInformPower();
		}

		@Override
		public Informer reqInformInstallationLocation() {
			return (Informer)super.reqInformInstallationLocation();
		}

		@Override
		public Informer reqInformVersion() {
			return (Informer)super.reqInformVersion();
		}

		@Override
		public Informer reqInformIdNumber() {
			return (Informer)super.reqInformIdNumber();
		}

		@Override
		public Informer reqInformElectricityConsumption() {
			return (Informer)super.reqInformElectricityConsumption();
		}

		@Override
		public Informer reqInformPowerConsumption() {
			return (Informer)super.reqInformPowerConsumption();
		}

		@Override
		public Informer reqInformMakerErrorCode() {
			return (Informer)super.reqInformMakerErrorCode();
		}

		@Override
		public Informer reqInformCurrentLimiting() {
			return (Informer)super.reqInformCurrentLimiting();
		}

		@Override
		public Informer reqInformError() {
			return (Informer)super.reqInformError();
		}

		@Override
		public Informer reqInformErrorInfo() {
			return (Informer)super.reqInformErrorInfo();
		}

		@Override
		public Informer reqInformMakerCode() {
			return (Informer)super.reqInformMakerCode();
		}

		@Override
		public Informer reqInformWorkplaceCode() {
			return (Informer)super.reqInformWorkplaceCode();
		}

		@Override
		public Informer reqInformProductCode() {
			return (Informer)super.reqInformProductCode();
		}

		@Override
		public Informer reqInformManufacturingNumber() {
			return (Informer)super.reqInformManufacturingNumber();
		}

		@Override
		public Informer reqInformDateOfManufacture() {
			return (Informer)super.reqInformDateOfManufacture();
		}

		@Override
		public Informer reqInformPowerSaving() {
			return (Informer)super.reqInformPowerSaving();
		}

		@Override
		public Informer reqInformLocation() {
			return (Informer)super.reqInformLocation();
		}

		@Override
		public Informer reqInformCurrentTime() {
			return (Informer)super.reqInformCurrentTime();
		}

		@Override
		public Informer reqInformCurrentDate() {
			return (Informer)super.reqInformCurrentDate();
		}

		@Override
		public Informer reqInformPowerLimitation() {
			return (Informer)super.reqInformPowerLimitation();
		}

		@Override
		public Informer reqInformWorkingTime() {
			return (Informer)super.reqInformWorkingTime();
		}

		@Override
		public Informer reqInformAnnoPropertyMap() {
			return (Informer)super.reqInformAnnoPropertyMap();
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
		public Informer reqInformPowerSavingOperationSetting() {
			addProperty(EPC_POWER_SAVING_OPERATION_SETTING);
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
