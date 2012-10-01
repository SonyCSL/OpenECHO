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

public abstract class BathroomHeaterAndDryer extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = BathroomHeaterAndDryer.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x73;

	protected static final byte EPC_OPERATION_SETTING = (byte)0xB0;
	protected static final byte EPC_VENTILATION_OPERATION_SETTING = (byte)0xB1;
	protected static final byte EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING = (byte)0xB2;
	protected static final byte EPC_BATHROOM_HEATER_OPERATION_SETTING = (byte)0xB3;
	protected static final byte EPC_BATHROOM_DRYER_OPERATION_SETTING = (byte)0xB4;
	protected static final byte EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING = (byte)0xB5;
	protected static final byte EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY = (byte)0xBA;
	protected static final byte EPC_MEASURED_BATHROOM_TEMPERATURE = (byte)0xBB;
	protected static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	protected static final byte EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING = (byte)0xCF;
	protected static final byte EPC_HUMAN_BODY_DETECTION_STATUS = (byte)0xE0;
	protected static final byte EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1 = (byte)0x90;
	protected static final byte EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2 = (byte)0xE1;
	protected static final byte EPC_ON_TIMER_SETTING_TIME = (byte)0x91;
	protected static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME = (byte)0x92;
	protected static final byte EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING = (byte)0x94;
	protected static final byte EPC_OFF_TIMER_SETTING_TIME = (byte)0x95;
	protected static final byte EPC_OFF_TIMER_SETTING_RELATIVE_TIME = (byte)0x96;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setOperationSetting(byte[] edt);
	/**
	 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getOperationSetting();
	/**
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setVentilationOperationSetting(byte[] edt) {return false;}
	/**
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVentilationOperationSetting() {return null;}
	/**
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setBathroomPreWarmerOperationSetting(byte[] edt);
	/**
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getBathroomPreWarmerOperationSetting();
	/**
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathroomHeaterOperationSetting(byte[] edt) {return false;}
	/**
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathroomHeaterOperationSetting() {return null;}
	/**
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setBathroomDryerOperationSetting(byte[] edt);
	/**
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getBathroomDryerOperationSetting();
	/**
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setCoolAirCirculatorOperationSetting(byte[] edt) {return false;}
	/**
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getCoolAirCirculatorOperationSetting() {return null;}
	/**
	 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredRelativeBathroomHumidity() {return null;}
	/**
	 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredBathroomTemperature() {return null;}
	/**
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	/**
	 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setFilterCleaningReminderSignSetting(byte[] edt) {return false;}
	/**
	 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getFilterCleaningReminderSignSetting() {return null;}
	/**
	 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHumanBodyDetectionStatus() {return null;}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setGonTimerBasedReservationHSetting1(byte[] edt) {return false;}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGonTimerBasedReservationHSetting1() {return null;}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setGonTimerBasedReservationHSetting2(byte[] edt) {return false;}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGonTimerBasedReservationHSetting2() {return null;}
	/**
	 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	/**
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setGoffTimerBasedReservationHSetting(byte[] edt) {return false;}
	/**
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGoffTimerBasedReservationHSetting() {return null;}
	/**
	 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerSettingRelativeTime() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_SETTING:
			res.addProperty(epc, edt, setOperationSetting(edt));
			break;
		case EPC_VENTILATION_OPERATION_SETTING:
			res.addProperty(epc, edt, setVentilationOperationSetting(edt));
			break;
		case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING:
			res.addProperty(epc, edt, setBathroomPreWarmerOperationSetting(edt));
			break;
		case EPC_BATHROOM_HEATER_OPERATION_SETTING:
			res.addProperty(epc, edt, setBathroomHeaterOperationSetting(edt));
			break;
		case EPC_BATHROOM_DRYER_OPERATION_SETTING:
			res.addProperty(epc, edt, setBathroomDryerOperationSetting(edt));
			break;
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING:
			res.addProperty(epc, edt, setCoolAirCirculatorOperationSetting(edt));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, setVentilationAirFlowRateSetting(edt));
			break;
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING:
			res.addProperty(epc, edt, setFilterCleaningReminderSignSetting(edt));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1:
			res.addProperty(epc, edt, setGonTimerBasedReservationHSetting1(edt));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2:
			res.addProperty(epc, edt, setGonTimerBasedReservationHSetting2(edt));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, setOnTimerSettingTime(edt));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, setOnTimerSettingRelativeTime(edt));
			break;
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
			res.addProperty(epc, edt, setGoffTimerBasedReservationHSetting(edt));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, setOffTimerSettingTime(edt));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, setOffTimerSettingRelativeTime(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATION_SETTING:
			edt = getOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_OPERATION_SETTING:
			edt = getVentilationOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING:
			edt = getBathroomPreWarmerOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATHROOM_HEATER_OPERATION_SETTING:
			edt = getBathroomHeaterOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATHROOM_DRYER_OPERATION_SETTING:
			edt = getBathroomDryerOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING:
			edt = getCoolAirCirculatorOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY:
			edt = getMeasuredRelativeBathroomHumidity();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_BATHROOM_TEMPERATURE:
			edt = getMeasuredBathroomTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			edt = getVentilationAirFlowRateSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING:
			edt = getFilterCleaningReminderSignSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HUMAN_BODY_DETECTION_STATUS:
			edt = getHumanBodyDetectionStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1:
			edt = getGonTimerBasedReservationHSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2:
			edt = getGonTimerBasedReservationHSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			edt = getOnTimerSettingTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			edt = getOnTimerSettingRelativeTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
			edt = getGoffTimerBasedReservationHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			edt = getOffTimerSettingTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			edt = getOffTimerSettingRelativeTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
			case EPC_OPERATION_SETTING:
				onSetOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_VENTILATION_OPERATION_SETTING:
				onSetVentilationOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING:
				onSetBathroomPreWarmerOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATHROOM_HEATER_OPERATION_SETTING:
				onSetBathroomHeaterOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATHROOM_DRYER_OPERATION_SETTING:
				onSetBathroomDryerOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING:
				onSetCoolAirCirculatorOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				onSetVentilationAirFlowRateSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING:
				onSetFilterCleaningReminderSignSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1:
				onSetGonTimerBasedReservationHSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2:
				onSetGonTimerBasedReservationHSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				onSetOnTimerSettingTime(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				onSetOnTimerSettingRelativeTime(eoj, tid, (pdc != 0));
				break;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
				onSetGoffTimerBasedReservationHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				onSetOffTimerSettingTime(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				onSetOffTimerSettingRelativeTime(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_SETTING:
				onGetOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_VENTILATION_OPERATION_SETTING:
				onGetVentilationOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING:
				onGetBathroomPreWarmerOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATHROOM_HEATER_OPERATION_SETTING:
				onGetBathroomHeaterOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATHROOM_DRYER_OPERATION_SETTING:
				onGetBathroomDryerOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING:
				onGetCoolAirCirculatorOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY:
				onGetMeasuredRelativeBathroomHumidity(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_BATHROOM_TEMPERATURE:
				onGetMeasuredBathroomTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				onGetVentilationAirFlowRateSetting(eoj, tid, pdc, edt);
				break;
			case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING:
				onGetFilterCleaningReminderSignSetting(eoj, tid, pdc, edt);
				break;
			case EPC_HUMAN_BODY_DETECTION_STATUS:
				onGetHumanBodyDetectionStatus(eoj, tid, pdc, edt);
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1:
				onGetGonTimerBasedReservationHSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2:
				onGetGonTimerBasedReservationHSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				onGetOnTimerSettingTime(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				onGetOnTimerSettingRelativeTime(eoj, tid, pdc, edt);
				break;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
				onGetGoffTimerBasedReservationHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				onGetOffTimerSettingTime(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				onGetOffTimerSettingRelativeTime(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetVentilationOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetVentilationOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathroomHeaterOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetBathroomDryerOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredRelativeBathroomHumidity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredBathroomTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHumanBodyDetectionStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetOperationSetting(byte[] edt);
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetVentilationOperationSetting(byte[] edt);
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetBathroomPreWarmerOperationSetting(byte[] edt);
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathroomHeaterOperationSetting(byte[] edt);
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetBathroomDryerOperationSetting(byte[] edt);
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetCoolAirCirculatorOperationSetting(byte[] edt);
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt);
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetFilterCleaningReminderSignSetting(byte[] edt);
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGonTimerBasedReservationHSetting1(byte[] edt);
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGonTimerBasedReservationHSetting2(byte[] edt);
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt);
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt);
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt);
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt);
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt);
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
		public Setter reqSetOperationSetting(byte[] edt) {
			addProperty(EPC_OPERATION_SETTING, edt, setOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetVentilationOperationSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_OPERATION_SETTING, edt, setVentilationOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathroomPreWarmerOperationSetting(byte[] edt) {
			addProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING, edt, setBathroomPreWarmerOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathroomHeaterOperationSetting(byte[] edt) {
			addProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING, edt, setBathroomHeaterOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathroomDryerOperationSetting(byte[] edt) {
			addProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING, edt, setBathroomDryerOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetCoolAirCirculatorOperationSetting(byte[] edt) {
			addProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING, edt, setCoolAirCirculatorOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, setVentilationAirFlowRateSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetFilterCleaningReminderSignSetting(byte[] edt) {
			addProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING, edt, setFilterCleaningReminderSignSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGonTimerBasedReservationHSetting1(byte[] edt) {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1, edt, setGonTimerBasedReservationHSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetGonTimerBasedReservationHSetting2(byte[] edt) {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2, edt, setGonTimerBasedReservationHSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, setOnTimerSettingTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, setOnTimerSettingRelativeTime(edt));
			return this;
		}
		@Override
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt) {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt, setGoffTimerBasedReservationHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, setOffTimerSettingTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, setOffTimerSettingRelativeTime(edt));
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
		public Setter reqSetOperationSetting(byte[] edt) {
			addProperty(EPC_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVentilationOperationSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathroomPreWarmerOperationSetting(byte[] edt) {
			addProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathroomHeaterOperationSetting(byte[] edt) {
			addProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathroomDryerOperationSetting(byte[] edt) {
			addProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetCoolAirCirculatorOperationSetting(byte[] edt) {
			addProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetFilterCleaningReminderSignSetting(byte[] edt) {
			addProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGonTimerBasedReservationHSetting1(byte[] edt) {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGonTimerBasedReservationHSetting2(byte[] edt) {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt) {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
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
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetOperationSetting();
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetVentilationOperationSetting();
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetBathroomPreWarmerOperationSetting();
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathroomHeaterOperationSetting();
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetBathroomDryerOperationSetting();
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetCoolAirCirculatorOperationSetting();
		/**
		 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredRelativeBathroomHumidity();
		/**
		 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredBathroomTemperature();
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetVentilationAirFlowRateSetting();
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetFilterCleaningReminderSignSetting();
		/**
		 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetHumanBodyDetectionStatus();
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGonTimerBasedReservationHSetting1();
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGonTimerBasedReservationHSetting2();
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSettingTime();
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSettingRelativeTime();
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGoffTimerBasedReservationHSetting();
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerSettingTime();
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerSettingRelativeTime();
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
		public Getter reqGetOperationSetting() {
			byte[] edt = getOperationSetting();
			addProperty(EPC_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVentilationOperationSetting() {
			byte[] edt = getVentilationOperationSetting();
			addProperty(EPC_VENTILATION_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathroomPreWarmerOperationSetting() {
			byte[] edt = getBathroomPreWarmerOperationSetting();
			addProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathroomHeaterOperationSetting() {
			byte[] edt = getBathroomHeaterOperationSetting();
			addProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathroomDryerOperationSetting() {
			byte[] edt = getBathroomDryerOperationSetting();
			addProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCoolAirCirculatorOperationSetting() {
			byte[] edt = getCoolAirCirculatorOperationSetting();
			addProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredRelativeBathroomHumidity() {
			byte[] edt = getMeasuredRelativeBathroomHumidity();
			addProperty(EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredBathroomTemperature() {
			byte[] edt = getMeasuredBathroomTemperature();
			addProperty(EPC_MEASURED_BATHROOM_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVentilationAirFlowRateSetting() {
			byte[] edt = getVentilationAirFlowRateSetting();
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetFilterCleaningReminderSignSetting() {
			byte[] edt = getFilterCleaningReminderSignSetting();
			addProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHumanBodyDetectionStatus() {
			byte[] edt = getHumanBodyDetectionStatus();
			addProperty(EPC_HUMAN_BODY_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGonTimerBasedReservationHSetting1() {
			byte[] edt = getGonTimerBasedReservationHSetting1();
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGonTimerBasedReservationHSetting2() {
			byte[] edt = getGonTimerBasedReservationHSetting2();
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingTime() {
			byte[] edt = getOnTimerSettingTime();
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingRelativeTime() {
			byte[] edt = getOnTimerSettingRelativeTime();
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGoffTimerBasedReservationHSetting() {
			byte[] edt = getGoffTimerBasedReservationHSetting();
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingTime() {
			byte[] edt = getOffTimerSettingTime();
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingRelativeTime() {
			byte[] edt = getOffTimerSettingRelativeTime();
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetOperationSetting() {
			addProperty(EPC_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetVentilationOperationSetting() {
			addProperty(EPC_VENTILATION_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathroomPreWarmerOperationSetting() {
			addProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathroomHeaterOperationSetting() {
			addProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathroomDryerOperationSetting() {
			addProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetCoolAirCirculatorOperationSetting() {
			addProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredRelativeBathroomHumidity() {
			addProperty(EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY);
			return this;
		}
		@Override
		public Getter reqGetMeasuredBathroomTemperature() {
			addProperty(EPC_MEASURED_BATHROOM_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetFilterCleaningReminderSignSetting() {
			addProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING);
			return this;
		}
		@Override
		public Getter reqGetHumanBodyDetectionStatus() {
			addProperty(EPC_HUMAN_BODY_DETECTION_STATUS);
			return this;
		}
		@Override
		public Getter reqGetGonTimerBasedReservationHSetting1() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetGonTimerBasedReservationHSetting2() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		@Override
		public Getter reqGetGoffTimerBasedReservationHSetting() {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
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
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformOperationSetting();
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformVentilationOperationSetting();
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformBathroomPreWarmerOperationSetting();
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathroomHeaterOperationSetting();
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformBathroomDryerOperationSetting();
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformCoolAirCirculatorOperationSetting();
		/**
		 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredRelativeBathroomHumidity();
		/**
		 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredBathroomTemperature();
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformVentilationAirFlowRateSetting();
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformFilterCleaningReminderSignSetting();
		/**
		 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformHumanBodyDetectionStatus();
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGonTimerBasedReservationHSetting1();
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGonTimerBasedReservationHSetting2();
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSettingTime();
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSettingRelativeTime();
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGoffTimerBasedReservationHSetting();
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerSettingTime();
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerSettingRelativeTime();
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
		public Informer reqInformOperationSetting() {
			byte[] edt = getOperationSetting();
			addProperty(EPC_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationOperationSetting() {
			byte[] edt = getVentilationOperationSetting();
			addProperty(EPC_VENTILATION_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathroomPreWarmerOperationSetting() {
			byte[] edt = getBathroomPreWarmerOperationSetting();
			addProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathroomHeaterOperationSetting() {
			byte[] edt = getBathroomHeaterOperationSetting();
			addProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathroomDryerOperationSetting() {
			byte[] edt = getBathroomDryerOperationSetting();
			addProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCoolAirCirculatorOperationSetting() {
			byte[] edt = getCoolAirCirculatorOperationSetting();
			addProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRelativeBathroomHumidity() {
			byte[] edt = getMeasuredRelativeBathroomHumidity();
			addProperty(EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredBathroomTemperature() {
			byte[] edt = getMeasuredBathroomTemperature();
			addProperty(EPC_MEASURED_BATHROOM_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationAirFlowRateSetting() {
			byte[] edt = getVentilationAirFlowRateSetting();
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFilterCleaningReminderSignSetting() {
			byte[] edt = getFilterCleaningReminderSignSetting();
			addProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHumanBodyDetectionStatus() {
			byte[] edt = getHumanBodyDetectionStatus();
			addProperty(EPC_HUMAN_BODY_DETECTION_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGonTimerBasedReservationHSetting1() {
			byte[] edt = getGonTimerBasedReservationHSetting1();
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGonTimerBasedReservationHSetting2() {
			byte[] edt = getGonTimerBasedReservationHSetting2();
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingTime() {
			byte[] edt = getOnTimerSettingTime();
			addProperty(EPC_ON_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingRelativeTime() {
			byte[] edt = getOnTimerSettingRelativeTime();
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGoffTimerBasedReservationHSetting() {
			byte[] edt = getGoffTimerBasedReservationHSetting();
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			byte[] edt = getOffTimerSettingTime();
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingRelativeTime() {
			byte[] edt = getOffTimerSettingRelativeTime();
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
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
		public Informer reqInformOperationSetting() {
			addProperty(EPC_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformVentilationOperationSetting() {
			addProperty(EPC_VENTILATION_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathroomPreWarmerOperationSetting() {
			addProperty(EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathroomHeaterOperationSetting() {
			addProperty(EPC_BATHROOM_HEATER_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathroomDryerOperationSetting() {
			addProperty(EPC_BATHROOM_DRYER_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformCoolAirCirculatorOperationSetting() {
			addProperty(EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredRelativeBathroomHumidity() {
			addProperty(EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY);
			return this;
		}
		@Override
		public Informer reqInformMeasuredBathroomTemperature() {
			addProperty(EPC_MEASURED_BATHROOM_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformVentilationAirFlowRateSetting() {
			addProperty(EPC_VENTILATION_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformFilterCleaningReminderSignSetting() {
			addProperty(EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING);
			return this;
		}
		@Override
		public Informer reqInformHumanBodyDetectionStatus() {
			addProperty(EPC_HUMAN_BODY_DETECTION_STATUS);
			return this;
		}
		@Override
		public Informer reqInformGonTimerBasedReservationHSetting1() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformGonTimerBasedReservationHSetting2() {
			addProperty(EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingTime() {
			addProperty(EPC_ON_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
		@Override
		public Informer reqInformGoffTimerBasedReservationHSetting() {
			addProperty(EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingRelativeTime() {
			addProperty(EPC_OFF_TIMER_SETTING_RELATIVE_TIME);
			return this;
		}
	}
}
