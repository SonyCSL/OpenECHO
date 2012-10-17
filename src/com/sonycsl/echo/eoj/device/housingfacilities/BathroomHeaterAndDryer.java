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

	public static final byte EPC_OPERATION_SETTING = (byte)0xB0;
	public static final byte EPC_VENTILATION_OPERATION_SETTING = (byte)0xB1;
	public static final byte EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING = (byte)0xB2;
	public static final byte EPC_BATHROOM_HEATER_OPERATION_SETTING = (byte)0xB3;
	public static final byte EPC_BATHROOM_DRYER_OPERATION_SETTING = (byte)0xB4;
	public static final byte EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING = (byte)0xB5;
	public static final byte EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY = (byte)0xBA;
	public static final byte EPC_MEASURED_BATHROOM_TEMPERATURE = (byte)0xBB;
	public static final byte EPC_VENTILATION_AIR_FLOW_RATE_SETTING = (byte)0xC2;
	public static final byte EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING = (byte)0xCF;
	public static final byte EPC_HUMAN_BODY_DETECTION_STATUS = (byte)0xE0;
	public static final byte EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1 = (byte)0x90;
	public static final byte EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2 = (byte)0xE1;
	public static final byte EPC_ON_TIMER_SETTING_TIME = (byte)0x91;
	public static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME = (byte)0x92;
	public static final byte EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING = (byte)0x94;
	public static final byte EPC_OFF_TIMER_SETTING_TIME = (byte)0x95;
	public static final byte EPC_OFF_TIMER_SETTING_RELATIVE_TIME = (byte)0x96;

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
	private final boolean _setOperationSetting(byte epc, byte[] edt) {
		boolean success = setOperationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getOperationSetting();
	private final byte[] _getOperationSetting(byte epc) {
		byte[] edt = getOperationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setVentilationOperationSetting(byte[] edt) {return false;}
	private final boolean _setVentilationOperationSetting(byte epc, byte[] edt) {
		boolean success = setVentilationOperationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVentilationOperationSetting() {return null;}
	private final byte[] _getVentilationOperationSetting(byte epc) {
		byte[] edt = getVentilationOperationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setBathroomPreWarmerOperationSetting(byte[] edt);
	private final boolean _setBathroomPreWarmerOperationSetting(byte epc, byte[] edt) {
		boolean success = setBathroomPreWarmerOperationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getBathroomPreWarmerOperationSetting();
	private final byte[] _getBathroomPreWarmerOperationSetting(byte epc) {
		byte[] edt = getBathroomPreWarmerOperationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathroomHeaterOperationSetting(byte[] edt) {return false;}
	private final boolean _setBathroomHeaterOperationSetting(byte epc, byte[] edt) {
		boolean success = setBathroomHeaterOperationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathroomHeaterOperationSetting() {return null;}
	private final byte[] _getBathroomHeaterOperationSetting(byte epc) {
		byte[] edt = getBathroomHeaterOperationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setBathroomDryerOperationSetting(byte[] edt);
	private final boolean _setBathroomDryerOperationSetting(byte epc, byte[] edt) {
		boolean success = setBathroomDryerOperationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getBathroomDryerOperationSetting();
	private final byte[] _getBathroomDryerOperationSetting(byte epc) {
		byte[] edt = getBathroomDryerOperationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setCoolAirCirculatorOperationSetting(byte[] edt) {return false;}
	private final boolean _setCoolAirCirculatorOperationSetting(byte epc, byte[] edt) {
		boolean success = setCoolAirCirculatorOperationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getCoolAirCirculatorOperationSetting() {return null;}
	private final byte[] _getCoolAirCirculatorOperationSetting(byte epc) {
		byte[] edt = getCoolAirCirculatorOperationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredRelativeBathroomHumidity() {return null;}
	private final byte[] _getMeasuredRelativeBathroomHumidity(byte epc) {
		byte[] edt = getMeasuredRelativeBathroomHumidity();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredBathroomTemperature() {return null;}
	private final byte[] _getMeasuredBathroomTemperature(byte epc) {
		byte[] edt = getMeasuredBathroomTemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	private final boolean _setVentilationAirFlowRateSetting(byte epc, byte[] edt) {
		boolean success = setVentilationAirFlowRateSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	private final byte[] _getVentilationAirFlowRateSetting(byte epc) {
		byte[] edt = getVentilationAirFlowRateSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setFilterCleaningReminderSignSetting(byte[] edt) {return false;}
	private final boolean _setFilterCleaningReminderSignSetting(byte epc, byte[] edt) {
		boolean success = setFilterCleaningReminderSignSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getFilterCleaningReminderSignSetting() {return null;}
	private final byte[] _getFilterCleaningReminderSignSetting(byte epc) {
		byte[] edt = getFilterCleaningReminderSignSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getHumanBodyDetectionStatus() {return null;}
	private final byte[] _getHumanBodyDetectionStatus(byte epc) {
		byte[] edt = getHumanBodyDetectionStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setGonTimerBasedReservationHSetting1(byte[] edt) {return false;}
	private final boolean _setGonTimerBasedReservationHSetting1(byte epc, byte[] edt) {
		boolean success = setGonTimerBasedReservationHSetting1(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGonTimerBasedReservationHSetting1() {return null;}
	private final byte[] _getGonTimerBasedReservationHSetting1(byte epc) {
		byte[] edt = getGonTimerBasedReservationHSetting1();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setGonTimerBasedReservationHSetting2(byte[] edt) {return false;}
	private final boolean _setGonTimerBasedReservationHSetting2(byte epc, byte[] edt) {
		boolean success = setGonTimerBasedReservationHSetting2(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGonTimerBasedReservationHSetting2() {return null;}
	private final byte[] _getGonTimerBasedReservationHSetting2(byte epc) {
		byte[] edt = getGonTimerBasedReservationHSetting2();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	private final byte[] _getOnTimerSettingTime(byte epc) {
		byte[] edt = getOnTimerSettingTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingRelativeTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingRelativeTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	private final byte[] _getOnTimerSettingRelativeTime(byte epc) {
		byte[] edt = getOnTimerSettingRelativeTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setGoffTimerBasedReservationHSetting(byte[] edt) {return false;}
	private final boolean _setGoffTimerBasedReservationHSetting(byte epc, byte[] edt) {
		boolean success = setGoffTimerBasedReservationHSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGoffTimerBasedReservationHSetting() {return null;}
	private final byte[] _getGoffTimerBasedReservationHSetting(byte epc) {
		byte[] edt = getGoffTimerBasedReservationHSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	private final boolean _setOffTimerSettingTime(byte epc, byte[] edt) {
		boolean success = setOffTimerSettingTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	private final byte[] _getOffTimerSettingTime(byte epc) {
		byte[] edt = getOffTimerSettingTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	private final boolean _setOffTimerSettingRelativeTime(byte epc, byte[] edt) {
		boolean success = setOffTimerSettingRelativeTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerSettingRelativeTime() {return null;}
	private final byte[] _getOffTimerSettingRelativeTime(byte epc) {
		byte[] edt = getOffTimerSettingRelativeTime();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_SETTING:
			res.addProperty(epc, edt, _setOperationSetting(epc, edt));
			break;
		case EPC_VENTILATION_OPERATION_SETTING:
			res.addProperty(epc, edt, _setVentilationOperationSetting(epc, edt));
			break;
		case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING:
			res.addProperty(epc, edt, _setBathroomPreWarmerOperationSetting(epc, edt));
			break;
		case EPC_BATHROOM_HEATER_OPERATION_SETTING:
			res.addProperty(epc, edt, _setBathroomHeaterOperationSetting(epc, edt));
			break;
		case EPC_BATHROOM_DRYER_OPERATION_SETTING:
			res.addProperty(epc, edt, _setBathroomDryerOperationSetting(epc, edt));
			break;
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING:
			res.addProperty(epc, edt, _setCoolAirCirculatorOperationSetting(epc, edt));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, _setVentilationAirFlowRateSetting(epc, edt));
			break;
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING:
			res.addProperty(epc, edt, _setFilterCleaningReminderSignSetting(epc, edt));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1:
			res.addProperty(epc, edt, _setGonTimerBasedReservationHSetting1(epc, edt));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2:
			res.addProperty(epc, edt, _setGonTimerBasedReservationHSetting2(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingTime(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingRelativeTime(epc, edt));
			break;
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
			res.addProperty(epc, edt, _setGoffTimerBasedReservationHSetting(epc, edt));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, _setOffTimerSettingTime(epc, edt));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, _setOffTimerSettingRelativeTime(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPERATION_SETTING:
			edt = _getOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_OPERATION_SETTING:
			edt = _getVentilationOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING:
			edt = _getBathroomPreWarmerOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATHROOM_HEATER_OPERATION_SETTING:
			edt = _getBathroomHeaterOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATHROOM_DRYER_OPERATION_SETTING:
			edt = _getBathroomDryerOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING:
			edt = _getCoolAirCirculatorOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY:
			edt = _getMeasuredRelativeBathroomHumidity(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_BATHROOM_TEMPERATURE:
			edt = _getMeasuredBathroomTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
			edt = _getVentilationAirFlowRateSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING:
			edt = _getFilterCleaningReminderSignSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HUMAN_BODY_DETECTION_STATUS:
			edt = _getHumanBodyDetectionStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1:
			edt = _getGonTimerBasedReservationHSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2:
			edt = _getGonTimerBasedReservationHSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			edt = _getOnTimerSettingTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			edt = _getOnTimerSettingRelativeTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
			edt = _getGoffTimerBasedReservationHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			edt = _getOffTimerSettingTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
			edt = _getOffTimerSettingRelativeTime(epc);
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
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_SETTING:
				_onSetOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_VENTILATION_OPERATION_SETTING:
				_onSetVentilationOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING:
				_onSetBathroomPreWarmerOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATHROOM_HEATER_OPERATION_SETTING:
				_onSetBathroomHeaterOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATHROOM_DRYER_OPERATION_SETTING:
				_onSetBathroomDryerOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING:
				_onSetCoolAirCirculatorOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				_onSetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING:
				_onSetFilterCleaningReminderSignSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1:
				_onSetGonTimerBasedReservationHSetting1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2:
				_onSetGonTimerBasedReservationHSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				_onSetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				_onSetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
				_onSetGoffTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				_onSetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				_onSetOffTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_OPERATION_SETTING:
				_onGetOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VENTILATION_OPERATION_SETTING:
				_onGetVentilationOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING:
				_onGetBathroomPreWarmerOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATHROOM_HEATER_OPERATION_SETTING:
				_onGetBathroomHeaterOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATHROOM_DRYER_OPERATION_SETTING:
				_onGetBathroomDryerOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING:
				_onGetCoolAirCirculatorOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY:
				_onGetMeasuredRelativeBathroomHumidity(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_BATHROOM_TEMPERATURE:
				_onGetMeasuredBathroomTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_VENTILATION_AIR_FLOW_RATE_SETTING:
				_onGetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING:
				_onGetFilterCleaningReminderSignSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HUMAN_BODY_DETECTION_STATUS:
				_onGetHumanBodyDetectionStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1:
				_onGetGonTimerBasedReservationHSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2:
				_onGetGonTimerBasedReservationHSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				_onGetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				_onGetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING:
				_onGetGoffTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				_onGetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_RELATIVE_TIME:
				_onGetOffTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetVentilationOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVentilationOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVentilationOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetVentilationOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVentilationOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVentilationOperationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathroomPreWarmerOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathroomPreWarmerOperationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathroomHeaterOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathroomHeaterOperationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathroomDryerOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathroomDryerOperationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetCoolAirCirculatorOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCoolAirCirculatorOperationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredRelativeBathroomHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredRelativeBathroomHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredRelativeBathroomHumidity(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)<br><br>Data type : signed char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredBathroomTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredBathroomTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredBathroomTemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetVentilationAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetFilterCleaningReminderSignSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetFilterCleaningReminderSignSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetHumanBodyDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHumanBodyDetectionStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHumanBodyDetectionStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGonTimerBasedReservationHSetting1(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGonTimerBasedReservationHSetting1(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGonTimerBasedReservationHSetting2(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGonTimerBasedReservationHSetting2(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGoffTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGoffTimerBasedReservationHSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}

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
			byte epc = EPC_OPERATION_SETTING;
			addProperty(epc, edt, _setOperationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetVentilationOperationSetting(byte[] edt) {
			byte epc = EPC_VENTILATION_OPERATION_SETTING;
			addProperty(epc, edt, _setVentilationOperationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetBathroomPreWarmerOperationSetting(byte[] edt) {
			byte epc = EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING;
			addProperty(epc, edt, _setBathroomPreWarmerOperationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetBathroomHeaterOperationSetting(byte[] edt) {
			byte epc = EPC_BATHROOM_HEATER_OPERATION_SETTING;
			addProperty(epc, edt, _setBathroomHeaterOperationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetBathroomDryerOperationSetting(byte[] edt) {
			byte epc = EPC_BATHROOM_DRYER_OPERATION_SETTING;
			addProperty(epc, edt, _setBathroomDryerOperationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetCoolAirCirculatorOperationSetting(byte[] edt) {
			byte epc = EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING;
			addProperty(epc, edt, _setCoolAirCirculatorOperationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt) {
			byte epc = EPC_VENTILATION_AIR_FLOW_RATE_SETTING;
			addProperty(epc, edt, _setVentilationAirFlowRateSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetFilterCleaningReminderSignSetting(byte[] edt) {
			byte epc = EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING;
			addProperty(epc, edt, _setFilterCleaningReminderSignSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetGonTimerBasedReservationHSetting1(byte[] edt) {
			byte epc = EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1;
			addProperty(epc, edt, _setGonTimerBasedReservationHSetting1(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetGonTimerBasedReservationHSetting2(byte[] edt) {
			byte epc = EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2;
			addProperty(epc, edt, _setGonTimerBasedReservationHSetting2(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingTime(byte[] edt) {
			byte epc = EPC_ON_TIMER_SETTING_TIME;
			addProperty(epc, edt, _setOnTimerSettingTime(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt) {
			byte epc = EPC_ON_TIMER_SETTING_RELATIVE_TIME;
			addProperty(epc, edt, _setOnTimerSettingRelativeTime(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt) {
			byte epc = EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING;
			addProperty(epc, edt, _setGoffTimerBasedReservationHSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			byte epc = EPC_OFF_TIMER_SETTING_TIME;
			addProperty(epc, edt, _setOffTimerSettingTime(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt) {
			byte epc = EPC_OFF_TIMER_SETTING_RELATIVE_TIME;
			addProperty(epc, edt, _setOffTimerSettingRelativeTime(epc, edt));
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
			byte epc = EPC_OPERATION_SETTING;
			byte[] edt = _getOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVentilationOperationSetting() {
			byte epc = EPC_VENTILATION_OPERATION_SETTING;
			byte[] edt = _getVentilationOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathroomPreWarmerOperationSetting() {
			byte epc = EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING;
			byte[] edt = _getBathroomPreWarmerOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathroomHeaterOperationSetting() {
			byte epc = EPC_BATHROOM_HEATER_OPERATION_SETTING;
			byte[] edt = _getBathroomHeaterOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathroomDryerOperationSetting() {
			byte epc = EPC_BATHROOM_DRYER_OPERATION_SETTING;
			byte[] edt = _getBathroomDryerOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCoolAirCirculatorOperationSetting() {
			byte epc = EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING;
			byte[] edt = _getCoolAirCirculatorOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredRelativeBathroomHumidity() {
			byte epc = EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY;
			byte[] edt = _getMeasuredRelativeBathroomHumidity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredBathroomTemperature() {
			byte epc = EPC_MEASURED_BATHROOM_TEMPERATURE;
			byte[] edt = _getMeasuredBathroomTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetVentilationAirFlowRateSetting() {
			byte epc = EPC_VENTILATION_AIR_FLOW_RATE_SETTING;
			byte[] edt = _getVentilationAirFlowRateSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetFilterCleaningReminderSignSetting() {
			byte epc = EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING;
			byte[] edt = _getFilterCleaningReminderSignSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHumanBodyDetectionStatus() {
			byte epc = EPC_HUMAN_BODY_DETECTION_STATUS;
			byte[] edt = _getHumanBodyDetectionStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGonTimerBasedReservationHSetting1() {
			byte epc = EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1;
			byte[] edt = _getGonTimerBasedReservationHSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGonTimerBasedReservationHSetting2() {
			byte epc = EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2;
			byte[] edt = _getGonTimerBasedReservationHSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingTime() {
			byte epc = EPC_ON_TIMER_SETTING_TIME;
			byte[] edt = _getOnTimerSettingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingRelativeTime() {
			byte epc = EPC_ON_TIMER_SETTING_RELATIVE_TIME;
			byte[] edt = _getOnTimerSettingRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGoffTimerBasedReservationHSetting() {
			byte epc = EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING;
			byte[] edt = _getGoffTimerBasedReservationHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingTime() {
			byte epc = EPC_OFF_TIMER_SETTING_TIME;
			byte[] edt = _getOffTimerSettingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingRelativeTime() {
			byte epc = EPC_OFF_TIMER_SETTING_RELATIVE_TIME;
			byte[] edt = _getOffTimerSettingRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
			byte epc = EPC_OPERATION_SETTING;
			byte[] edt = _getOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationOperationSetting() {
			byte epc = EPC_VENTILATION_OPERATION_SETTING;
			byte[] edt = _getVentilationOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathroomPreWarmerOperationSetting() {
			byte epc = EPC_BATHROOM_PRE_WARMER_OPERATION_SETTING;
			byte[] edt = _getBathroomPreWarmerOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathroomHeaterOperationSetting() {
			byte epc = EPC_BATHROOM_HEATER_OPERATION_SETTING;
			byte[] edt = _getBathroomHeaterOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathroomDryerOperationSetting() {
			byte epc = EPC_BATHROOM_DRYER_OPERATION_SETTING;
			byte[] edt = _getBathroomDryerOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCoolAirCirculatorOperationSetting() {
			byte epc = EPC_COOL_AIR_CIRCULATOR_OPERATION_SETTING;
			byte[] edt = _getCoolAirCirculatorOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRelativeBathroomHumidity() {
			byte epc = EPC_MEASURED_RELATIVE_BATHROOM_HUMIDITY;
			byte[] edt = _getMeasuredRelativeBathroomHumidity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredBathroomTemperature() {
			byte epc = EPC_MEASURED_BATHROOM_TEMPERATURE;
			byte[] edt = _getMeasuredBathroomTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformVentilationAirFlowRateSetting() {
			byte epc = EPC_VENTILATION_AIR_FLOW_RATE_SETTING;
			byte[] edt = _getVentilationAirFlowRateSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformFilterCleaningReminderSignSetting() {
			byte epc = EPC_FILTER_CLEANING_REMINDER_SIGN_SETTING;
			byte[] edt = _getFilterCleaningReminderSignSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHumanBodyDetectionStatus() {
			byte epc = EPC_HUMAN_BODY_DETECTION_STATUS;
			byte[] edt = _getHumanBodyDetectionStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGonTimerBasedReservationHSetting1() {
			byte epc = EPC_GON_TIMER_BASED_RESERVATION_H_SETTING1;
			byte[] edt = _getGonTimerBasedReservationHSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGonTimerBasedReservationHSetting2() {
			byte epc = EPC_GON_TIMER_BASED_RESERVATION_H_SETTING2;
			byte[] edt = _getGonTimerBasedReservationHSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingTime() {
			byte epc = EPC_ON_TIMER_SETTING_TIME;
			byte[] edt = _getOnTimerSettingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingRelativeTime() {
			byte epc = EPC_ON_TIMER_SETTING_RELATIVE_TIME;
			byte[] edt = _getOnTimerSettingRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGoffTimerBasedReservationHSetting() {
			byte epc = EPC_GOFF_TIMER_BASED_RESERVATION_H_SETTING;
			byte[] edt = _getGoffTimerBasedReservationHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			byte epc = EPC_OFF_TIMER_SETTING_TIME;
			byte[] edt = _getOffTimerSettingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingRelativeTime() {
			byte epc = EPC_OFF_TIMER_SETTING_RELATIVE_TIME;
			byte[] edt = _getOffTimerSettingRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
