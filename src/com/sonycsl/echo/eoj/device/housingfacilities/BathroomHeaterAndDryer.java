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
	 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00
	 */
	protected abstract boolean setOperationSetting(byte[] edt);
	/**
	 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00
	 */
	protected abstract byte[] getOperationSetting();
	/**
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38
	 */
	protected boolean setVentilationOperationSetting(byte[] edt) {return false;}
	/**
	 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38
	 */
	protected byte[] getVentilationOperationSetting() {return null;}
	/**
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38
	 */
	protected abstract boolean setBathroomPreWarmerOperationSetting(byte[] edt);
	/**
	 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38
	 */
	protected abstract byte[] getBathroomPreWarmerOperationSetting();
	/**
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38
	 */
	protected boolean setBathroomHeaterOperationSetting(byte[] edt) {return false;}
	/**
	 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38
	 */
	protected byte[] getBathroomHeaterOperationSetting() {return null;}
	/**
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38
	 */
	protected abstract boolean setBathroomDryerOperationSetting(byte[] edt);
	/**
	 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38
	 */
	protected abstract byte[] getBathroomDryerOperationSetting();
	/**
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38
	 */
	protected boolean setCoolAirCirculatorOperationSetting(byte[] edt) {return false;}
	/**
	 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38
	 */
	protected byte[] getCoolAirCirculatorOperationSetting() {return null;}
	/**
	 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)
	 */
	protected byte[] getMeasuredRelativeBathroomHumidity() {return null;}
	/**
	 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)
	 */
	protected byte[] getMeasuredBathroomTemperature() {return null;}
	/**
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38
	 */
	protected boolean setVentilationAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38
	 */
	protected byte[] getVentilationAirFlowRateSetting() {return null;}
	/**
	 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42
	 */
	protected boolean setFilterCleaningReminderSignSetting(byte[] edt) {return false;}
	/**
	 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42
	 */
	protected byte[] getFilterCleaningReminderSignSetting() {return null;}
	/**
	 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42
	 */
	protected byte[] getHumanBodyDetectionStatus() {return null;}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
	 */
	protected boolean setGonTimerBasedReservationHSetting1(byte[] edt) {return false;}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
	 */
	protected byte[] getGonTimerBasedReservationHSetting1() {return null;}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00
	 */
	protected boolean setGonTimerBasedReservationHSetting2(byte[] edt) {return false;}
	/**
	 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00
	 */
	protected byte[] getGonTimerBasedReservationHSetting2() {return null;}
	/**
	 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	/**
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
	 */
	protected boolean setGoffTimerBasedReservationHSetting(byte[] edt) {return false;}
	/**
	 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
	 */
	protected byte[] getGoffTimerBasedReservationHSetting() {return null;}
	/**
	 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOffTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
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
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00
		 */
		protected void onSetOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00
		 */
		protected void onGetOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38
		 */
		protected void onSetVentilationOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38
		 */
		protected void onGetVentilationOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38
		 */
		protected void onSetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38
		 */
		protected void onGetBathroomPreWarmerOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38
		 */
		protected void onSetBathroomHeaterOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38
		 */
		protected void onGetBathroomHeaterOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38
		 */
		protected void onSetBathroomDryerOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38
		 */
		protected void onGetBathroomDryerOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38
		 */
		protected void onSetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38
		 */
		protected void onGetCoolAirCirculatorOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)
		 */
		protected void onGetMeasuredRelativeBathroomHumidity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)
		 */
		protected void onGetMeasuredBathroomTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38
		 */
		protected void onSetVentilationAirFlowRateSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38
		 */
		protected void onGetVentilationAirFlowRateSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42
		 */
		protected void onSetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42
		 */
		protected void onGetFilterCleaningReminderSignSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42
		 */
		protected void onGetHumanBodyDetectionStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		protected void onSetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		protected void onGetGonTimerBasedReservationHSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00
		 */
		protected void onSetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00
		 */
		protected void onGetGonTimerBasedReservationHSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		protected void onSetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		protected void onGetGoffTimerBasedReservationHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOffTimerSettingRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOffTimerSettingRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00
		 */
		public Setter reqSetOperationSetting(byte[] edt);
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38
		 */
		public Setter reqSetVentilationOperationSetting(byte[] edt);
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38
		 */
		public Setter reqSetBathroomPreWarmerOperationSetting(byte[] edt);
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38
		 */
		public Setter reqSetBathroomHeaterOperationSetting(byte[] edt);
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38
		 */
		public Setter reqSetBathroomDryerOperationSetting(byte[] edt);
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38
		 */
		public Setter reqSetCoolAirCirculatorOperationSetting(byte[] edt);
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38
		 */
		public Setter reqSetVentilationAirFlowRateSetting(byte[] edt);
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42
		 */
		public Setter reqSetFilterCleaningReminderSignSetting(byte[] edt);
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		public Setter reqSetGonTimerBasedReservationHSetting1(byte[] edt);
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00
		 */
		public Setter reqSetGonTimerBasedReservationHSetting2(byte[] edt);
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt);
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt);
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		public Setter reqSetGoffTimerBasedReservationHSetting(byte[] edt);
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt);
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOffTimerSettingRelativeTime(byte[] edt);

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
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00
		 */
		public Getter reqGetOperationSetting();
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38
		 */
		public Getter reqGetVentilationOperationSetting();
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38
		 */
		public Getter reqGetBathroomPreWarmerOperationSetting();
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38
		 */
		public Getter reqGetBathroomHeaterOperationSetting();
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38
		 */
		public Getter reqGetBathroomDryerOperationSetting();
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38
		 */
		public Getter reqGetCoolAirCirculatorOperationSetting();
		/**
		 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)
		 */
		public Getter reqGetMeasuredRelativeBathroomHumidity();
		/**
		 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)
		 */
		public Getter reqGetMeasuredBathroomTemperature();
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38
		 */
		public Getter reqGetVentilationAirFlowRateSetting();
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42
		 */
		public Getter reqGetFilterCleaningReminderSignSetting();
		/**
		 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42
		 */
		public Getter reqGetHumanBodyDetectionStatus();
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		public Getter reqGetGonTimerBasedReservationHSetting1();
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00
		 */
		public Getter reqGetGonTimerBasedReservationHSetting2();
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOnTimerSettingTime();
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOnTimerSettingRelativeTime();
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		public Getter reqGetGoffTimerBasedReservationHSetting();
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOffTimerSettingTime();
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOffTimerSettingRelativeTime();

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
		 * Used to set the operation mode (ventilation mode, bathroom pre-warmer mode, bathroom heater mode, bathroom dryer mode, cool air circulator mode or �gstop�h), and to acquire the current setting.<br>Ventilation operation             : 0x10 Bathroom pre-warmer operation : 0x20 Bathroom heater operation   : 0x30 Bathroom dryer operation      : 0x40 Cool air circulator operation : 0x50 Stop                                           :0x00
		 */
		public Informer reqInformOperationSetting();
		/**
		 * Used to set the ventilation air flow rate level for the ventilation mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Air flow rate level    : 0x31 to 0x38
		 */
		public Informer reqInformVentilationOperationSetting();
		/**
		 * Used to set the bathroom pre-warming level for the bathroom pre-warmer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom pre-warming level : 0x31 to 0x38
		 */
		public Informer reqInformBathroomPreWarmerOperationSetting();
		/**
		 * Used to set the bathroom heating level for the bathroom heater mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom heating level : 0x31 to 0x38
		 */
		public Informer reqInformBathroomHeaterOperationSetting();
		/**
		 * Used to set the bathroom drying level for the bathroom dryer mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Bathroom drying level : 0x31 to 0x38
		 */
		public Informer reqInformBathroomDryerOperationSetting();
		/**
		 * Used to set the cool air circulation level for the cool air circulator mode and to acquire the current setting.<br>Automatic        : 0x41 Standard          : 0x42 Cool air circulation level : 0x31 to 0x38
		 */
		public Informer reqInformCoolAirCirculatorOperationSetting();
		/**
		 * Used to acquire the measured relative humidity of the bathroom.<br>0x00 to 0x64 (0 to 100%)
		 */
		public Informer reqInformMeasuredRelativeBathroomHumidity();
		/**
		 * Used to acquire the measured temperature of the bathroom.<br>0x81 to 0x7D (.127 to �{125��)
		 */
		public Informer reqInformMeasuredBathroomTemperature();
		/**
		 * Used to set the air flow rate level for the around-the-clock ventilation function and to acquire the current setting.<br>Automatic: 0x41 Air flow rate level: 0x31 to 0x38
		 */
		public Informer reqInformVentilationAirFlowRateSetting();
		/**
		 * Used to set the filter cleaning reminder sign status (lit/not lit) and to acquire the current setting.<br>Lit: 0x41 Not lit: 0x42
		 */
		public Informer reqInformFilterCleaningReminderSignSetting();
		/**
		 * Used to acquire the human body detection status.<br>Detected: 0x41 Not detected: 0x42
		 */
		public Informer reqInformHumanBodyDetectionStatus();
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		public Informer reqInformGonTimerBasedReservationHSetting1();
		/**
		 * Used to set the ON/OFF status of the ON timer-based reservation function with the mode in which the device starts operating specified, and to acquire the current setting.<br>Reservation function ON for the ventilation mode                      : 0x10 Reservation function ON for the bathroom pre-warmer mode : 0x20 Reservation function ON for the bathroom heater mode          : 0x30 Reservation function ON for the bathroom dryer mode            : 0x40 Reservation function ON for the cool air circulator mode       : 0x50 Reservation function OFF : 0x00
		 */
		public Informer reqInformGonTimerBasedReservationHSetting2();
		/**
		 * Used to set the time setting for the time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOnTimerSettingTime();
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the ON timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOnTimerSettingRelativeTime();
		/**
		 * Used to set the ON/OFF status of the OFF timer-based reservation function and to acquire the current setting.<br>Reservation function ON: 0x41 Reservation function OFF: 0x42
		 */
		public Informer reqInformGoffTimerBasedReservationHSetting();
		/**
		 * Used to set the time setting for the time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOffTimerSettingTime();
		/**
		 * Used to set the relative time setting for the relative time-based reservation function for the OFF timer (in the HH:MM format) and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOffTimerSettingRelativeTime();

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
