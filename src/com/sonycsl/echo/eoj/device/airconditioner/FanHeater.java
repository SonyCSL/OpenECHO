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

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class FanHeater extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = FanHeater.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x43;

	protected static final byte EPC_TEMPERATURE_SETTING_VALUE = (byte)0xB3;
	protected static final byte EPC_MEASURED_TEMPERATURE = (byte)0xBB;
	protected static final byte EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING = (byte)0xB1;
	protected static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_ON_TIMER_SETTING_VALUE_TIME = (byte)0x91;
	protected static final byte EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME = (byte)0x92;
	protected static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	protected static final byte EPC_OFF_TIMER_SETTING_VALUE_TIME = (byte)0x95;
	protected static final byte EPC_OFF_TIMER_VALUE_RELATIVE_TIME = (byte)0x96;
	protected static final byte EPC_EXTENTIONAL_OPERATION_SETTING = (byte)0xC0;
	protected static final byte EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE = (byte)0xC1;
	protected static final byte EPC_ION_EMISSION_SETTING = (byte)0xC2;
	protected static final byte EPC_IMPLEMENTED_ION_EMISSION_METHOD = (byte)0xC3;
	protected static final byte EPC_OIL_AMOUNT_LEVEL = (byte)0xC4;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)
	 */
	protected abstract boolean setTemperatureSettingValue(byte[] edt);
	/**
	 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)
	 */
	protected abstract byte[] getTemperatureSettingValue();
	/**
	 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)
	 */
	protected byte[] getMeasuredTemperature() {return null;}
	/**
	 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42
	 */
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	/**
	 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42
	 */
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	/**
	 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOnTimerSettingValueTime(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOnTimerSettingValueTime() {return null;}
	/**
	 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOnTimerSettingValueRelativeTime(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOnTimerSettingValueRelativeTime() {return null;}
	/**
	 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	/**
	 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOffTimerSettingValueTime(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOffTimerSettingValueTime() {return null;}
	/**
	 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected boolean setOffTimerValueRelativeTime(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected byte[] getOffTimerValueRelativeTime() {return null;}
	/**
	 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42
	 */
	protected boolean setExtentionalOperationSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42
	 */
	protected byte[] getExtentionalOperationSetting() {return null;}
	/**
	 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected boolean setExtentionalOperationTimerTimeSettingValue(byte[] edt) {return false;}
	/**
	 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected byte[] getExtentionalOperationTimerTimeSettingValue() {return null;}
	/**
	 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42
	 */
	protected boolean setIonEmissionSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42
	 */
	protected byte[] getIonEmissionSetting() {return null;}
	/**
	 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42
	 */
	protected byte[] getImplementedIonEmissionMethod() {return null;}
	/**
	 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels
	 */
	protected byte[] getOilAmountLevel() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_TEMPERATURE_SETTING_VALUE:
			res.addProperty(epc, edt, setTemperatureSettingValue(edt));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			res.addProperty(epc, edt, setAutomaticTemperatureControlSetting(edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOnTimerReservationSetting(edt));
			break;
		case EPC_ON_TIMER_SETTING_VALUE_TIME:
			res.addProperty(epc, edt, setOnTimerSettingValueTime(edt));
			break;
		case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME:
			res.addProperty(epc, edt, setOnTimerSettingValueRelativeTime(edt));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOffTimerReservationSetting(edt));
			break;
		case EPC_OFF_TIMER_SETTING_VALUE_TIME:
			res.addProperty(epc, edt, setOffTimerSettingValueTime(edt));
			break;
		case EPC_OFF_TIMER_VALUE_RELATIVE_TIME:
			res.addProperty(epc, edt, setOffTimerValueRelativeTime(edt));
			break;
		case EPC_EXTENTIONAL_OPERATION_SETTING:
			res.addProperty(epc, edt, setExtentionalOperationSetting(edt));
			break;
		case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE:
			res.addProperty(epc, edt, setExtentionalOperationTimerTimeSettingValue(edt));
			break;
		case EPC_ION_EMISSION_SETTING:
			res.addProperty(epc, edt, setIonEmissionSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_TEMPERATURE_SETTING_VALUE:
			edt = getTemperatureSettingValue();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE:
			edt = getMeasuredTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			edt = getAutomaticTemperatureControlSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = getOnTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING_VALUE_TIME:
			edt = getOnTimerSettingValueTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME:
			edt = getOnTimerSettingValueRelativeTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			edt = getOffTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING_VALUE_TIME:
			edt = getOffTimerSettingValueTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_VALUE_RELATIVE_TIME:
			edt = getOffTimerValueRelativeTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_EXTENTIONAL_OPERATION_SETTING:
			edt = getExtentionalOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE:
			edt = getExtentionalOperationTimerTimeSettingValue();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ION_EMISSION_SETTING:
			edt = getIonEmissionSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_IMPLEMENTED_ION_EMISSION_METHOD:
			edt = getImplementedIonEmissionMethod();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OIL_AMOUNT_LEVEL:
			edt = getOilAmountLevel();
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
			case EPC_TEMPERATURE_SETTING_VALUE:
				onSetTemperatureSettingValue(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				onSetAutomaticTemperatureControlSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onSetOnTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_VALUE_TIME:
				onSetOnTimerSettingValueTime(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME:
				onSetOnTimerSettingValueRelativeTime(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				onSetOffTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_VALUE_TIME:
				onSetOffTimerSettingValueTime(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_VALUE_RELATIVE_TIME:
				onSetOffTimerValueRelativeTime(eoj, tid, (pdc != 0));
				break;
			case EPC_EXTENTIONAL_OPERATION_SETTING:
				onSetExtentionalOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE:
				onSetExtentionalOperationTimerTimeSettingValue(eoj, tid, (pdc != 0));
				break;
			case EPC_ION_EMISSION_SETTING:
				onSetIonEmissionSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_TEMPERATURE_SETTING_VALUE:
				onGetTemperatureSettingValue(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE:
				onGetMeasuredTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				onGetAutomaticTemperatureControlSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onGetOnTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_VALUE_TIME:
				onGetOnTimerSettingValueTime(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME:
				onGetOnTimerSettingValueRelativeTime(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				onGetOffTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_VALUE_TIME:
				onGetOffTimerSettingValueTime(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_VALUE_RELATIVE_TIME:
				onGetOffTimerValueRelativeTime(eoj, tid, pdc, edt);
				break;
			case EPC_EXTENTIONAL_OPERATION_SETTING:
				onGetExtentionalOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE:
				onGetExtentionalOperationTimerTimeSettingValue(eoj, tid, pdc, edt);
				break;
			case EPC_ION_EMISSION_SETTING:
				onGetIonEmissionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_IMPLEMENTED_ION_EMISSION_METHOD:
				onGetImplementedIonEmissionMethod(eoj, tid, pdc, edt);
				break;
			case EPC_OIL_AMOUNT_LEVEL:
				onGetOilAmountLevel(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)
		 */
		protected void onSetTemperatureSettingValue(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)
		 */
		protected void onGetTemperatureSettingValue(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)
		 */
		protected void onGetMeasuredTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42
		 */
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42
		 */
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOnTimerSettingValueTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOnTimerSettingValueTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOffTimerSettingValueTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOffTimerSettingValueTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onSetOffTimerValueRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onGetOffTimerValueRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42
		 */
		protected void onSetExtentionalOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42
		 */
		protected void onGetExtentionalOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onSetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onGetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42
		 */
		protected void onSetIonEmissionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42
		 */
		protected void onGetIonEmissionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42
		 */
		protected void onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels
		 */
		protected void onGetOilAmountLevel(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)
		 */
		public Setter reqSetTemperatureSettingValue(byte[] edt);
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42
		 */
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt);
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOnTimerSettingValueTime(byte[] edt);
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOnTimerSettingValueRelativeTime(byte[] edt);
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt);
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOffTimerSettingValueTime(byte[] edt);
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Setter reqSetOffTimerValueRelativeTime(byte[] edt);
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42
		 */
		public Setter reqSetExtentionalOperationSetting(byte[] edt);
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Setter reqSetExtentionalOperationTimerTimeSettingValue(byte[] edt);
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42
		 */
		public Setter reqSetIonEmissionSetting(byte[] edt);

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
		public Setter reqSetTemperatureSettingValue(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING_VALUE, edt, setTemperatureSettingValue(edt));
			return this;
		}
		@Override
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, setAutomaticTemperatureControlSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, setOnTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingValueTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_TIME, edt, setOnTimerSettingValueTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingValueRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME, edt, setOnTimerSettingValueRelativeTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, setOffTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingValueTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_VALUE_TIME, edt, setOffTimerSettingValueTime(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerValueRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_VALUE_RELATIVE_TIME, edt, setOffTimerValueRelativeTime(edt));
			return this;
		}
		@Override
		public Setter reqSetExtentionalOperationSetting(byte[] edt) {
			addProperty(EPC_EXTENTIONAL_OPERATION_SETTING, edt, setExtentionalOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetExtentionalOperationTimerTimeSettingValue(byte[] edt) {
			addProperty(EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE, edt, setExtentionalOperationTimerTimeSettingValue(edt));
			return this;
		}
		@Override
		public Setter reqSetIonEmissionSetting(byte[] edt) {
			addProperty(EPC_ION_EMISSION_SETTING, edt, setIonEmissionSetting(edt));
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
		public Setter reqSetTemperatureSettingValue(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING_VALUE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingValueTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingValueRelativeTime(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingValueTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_VALUE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerValueRelativeTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_VALUE_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetExtentionalOperationSetting(byte[] edt) {
			addProperty(EPC_EXTENTIONAL_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetExtentionalOperationTimerTimeSettingValue(byte[] edt) {
			addProperty(EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetIonEmissionSetting(byte[] edt) {
			addProperty(EPC_ION_EMISSION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)
		 */
		public Getter reqGetTemperatureSettingValue();
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)
		 */
		public Getter reqGetMeasuredTemperature();
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42
		 */
		public Getter reqGetAutomaticTemperatureControlSetting();
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOnTimerSettingValueTime();
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOnTimerSettingValueRelativeTime();
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		public Getter reqGetOffTimerReservationSetting();
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOffTimerSettingValueTime();
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Getter reqGetOffTimerValueRelativeTime();
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42
		 */
		public Getter reqGetExtentionalOperationSetting();
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Getter reqGetExtentionalOperationTimerTimeSettingValue();
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42
		 */
		public Getter reqGetIonEmissionSetting();
		/**
		 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42
		 */
		public Getter reqGetImplementedIonEmissionMethod();
		/**
		 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels
		 */
		public Getter reqGetOilAmountLevel();

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
		public Getter reqGetTemperatureSettingValue() {
			byte[] edt = getTemperatureSettingValue();
			addProperty(EPC_TEMPERATURE_SETTING_VALUE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperature() {
			byte[] edt = getMeasuredTemperature();
			addProperty(EPC_MEASURED_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutomaticTemperatureControlSetting() {
			byte[] edt = getAutomaticTemperatureControlSetting();
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingValueTime() {
			byte[] edt = getOnTimerSettingValueTime();
			addProperty(EPC_ON_TIMER_SETTING_VALUE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingValueRelativeTime() {
			byte[] edt = getOnTimerSettingValueRelativeTime();
			addProperty(EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerReservationSetting() {
			byte[] edt = getOffTimerReservationSetting();
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingValueTime() {
			byte[] edt = getOffTimerSettingValueTime();
			addProperty(EPC_OFF_TIMER_SETTING_VALUE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerValueRelativeTime() {
			byte[] edt = getOffTimerValueRelativeTime();
			addProperty(EPC_OFF_TIMER_VALUE_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetExtentionalOperationSetting() {
			byte[] edt = getExtentionalOperationSetting();
			addProperty(EPC_EXTENTIONAL_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetExtentionalOperationTimerTimeSettingValue() {
			byte[] edt = getExtentionalOperationTimerTimeSettingValue();
			addProperty(EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetIonEmissionSetting() {
			byte[] edt = getIonEmissionSetting();
			addProperty(EPC_ION_EMISSION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetImplementedIonEmissionMethod() {
			byte[] edt = getImplementedIonEmissionMethod();
			addProperty(EPC_IMPLEMENTED_ION_EMISSION_METHOD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOilAmountLevel() {
			byte[] edt = getOilAmountLevel();
			addProperty(EPC_OIL_AMOUNT_LEVEL, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetTemperatureSettingValue() {
			addProperty(EPC_TEMPERATURE_SETTING_VALUE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperature() {
			addProperty(EPC_MEASURED_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingValueTime() {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_TIME);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingValueRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME);
			return this;
		}
		@Override
		public Getter reqGetOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingValueTime() {
			addProperty(EPC_OFF_TIMER_SETTING_VALUE_TIME);
			return this;
		}
		@Override
		public Getter reqGetOffTimerValueRelativeTime() {
			addProperty(EPC_OFF_TIMER_VALUE_RELATIVE_TIME);
			return this;
		}
		@Override
		public Getter reqGetExtentionalOperationSetting() {
			addProperty(EPC_EXTENTIONAL_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetExtentionalOperationTimerTimeSettingValue() {
			addProperty(EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE);
			return this;
		}
		@Override
		public Getter reqGetIonEmissionSetting() {
			addProperty(EPC_ION_EMISSION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetImplementedIonEmissionMethod() {
			addProperty(EPC_IMPLEMENTED_ION_EMISSION_METHOD);
			return this;
		}
		@Override
		public Getter reqGetOilAmountLevel() {
			addProperty(EPC_OIL_AMOUNT_LEVEL);
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
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)
		 */
		public Informer reqInformTemperatureSettingValue();
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)
		 */
		public Informer reqInformMeasuredTemperature();
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42
		 */
		public Informer reqInformAutomaticTemperatureControlSetting();
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOnTimerSettingValueTime();
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOnTimerSettingValueRelativeTime();
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44
		 */
		public Informer reqInformOffTimerReservationSetting();
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOffTimerSettingValueTime();
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Informer reqInformOffTimerValueRelativeTime();
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42
		 */
		public Informer reqInformExtentionalOperationSetting();
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Informer reqInformExtentionalOperationTimerTimeSettingValue();
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42
		 */
		public Informer reqInformIonEmissionSetting();
		/**
		 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42
		 */
		public Informer reqInformImplementedIonEmissionMethod();
		/**
		 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels
		 */
		public Informer reqInformOilAmountLevel();

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
		public Informer reqInformTemperatureSettingValue() {
			byte[] edt = getTemperatureSettingValue();
			addProperty(EPC_TEMPERATURE_SETTING_VALUE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperature() {
			byte[] edt = getMeasuredTemperature();
			addProperty(EPC_MEASURED_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticTemperatureControlSetting() {
			byte[] edt = getAutomaticTemperatureControlSetting();
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingValueTime() {
			byte[] edt = getOnTimerSettingValueTime();
			addProperty(EPC_ON_TIMER_SETTING_VALUE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingValueRelativeTime() {
			byte[] edt = getOnTimerSettingValueRelativeTime();
			addProperty(EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerReservationSetting() {
			byte[] edt = getOffTimerReservationSetting();
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingValueTime() {
			byte[] edt = getOffTimerSettingValueTime();
			addProperty(EPC_OFF_TIMER_SETTING_VALUE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerValueRelativeTime() {
			byte[] edt = getOffTimerValueRelativeTime();
			addProperty(EPC_OFF_TIMER_VALUE_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformExtentionalOperationSetting() {
			byte[] edt = getExtentionalOperationSetting();
			addProperty(EPC_EXTENTIONAL_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformExtentionalOperationTimerTimeSettingValue() {
			byte[] edt = getExtentionalOperationTimerTimeSettingValue();
			addProperty(EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformIonEmissionSetting() {
			byte[] edt = getIonEmissionSetting();
			addProperty(EPC_ION_EMISSION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformImplementedIonEmissionMethod() {
			byte[] edt = getImplementedIonEmissionMethod();
			addProperty(EPC_IMPLEMENTED_ION_EMISSION_METHOD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOilAmountLevel() {
			byte[] edt = getOilAmountLevel();
			addProperty(EPC_OIL_AMOUNT_LEVEL, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformTemperatureSettingValue() {
			addProperty(EPC_TEMPERATURE_SETTING_VALUE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperature() {
			addProperty(EPC_MEASURED_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingValueTime() {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_TIME);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingValueRelativeTime() {
			addProperty(EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME);
			return this;
		}
		@Override
		public Informer reqInformOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingValueTime() {
			addProperty(EPC_OFF_TIMER_SETTING_VALUE_TIME);
			return this;
		}
		@Override
		public Informer reqInformOffTimerValueRelativeTime() {
			addProperty(EPC_OFF_TIMER_VALUE_RELATIVE_TIME);
			return this;
		}
		@Override
		public Informer reqInformExtentionalOperationSetting() {
			addProperty(EPC_EXTENTIONAL_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformExtentionalOperationTimerTimeSettingValue() {
			addProperty(EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE);
			return this;
		}
		@Override
		public Informer reqInformIonEmissionSetting() {
			addProperty(EPC_ION_EMISSION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformImplementedIonEmissionMethod() {
			addProperty(EPC_IMPLEMENTED_ION_EMISSION_METHOD);
			return this;
		}
		@Override
		public Informer reqInformOilAmountLevel() {
			addProperty(EPC_OIL_AMOUNT_LEVEL);
			return this;
		}

	}
}
