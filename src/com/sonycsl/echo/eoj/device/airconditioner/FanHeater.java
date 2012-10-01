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
	 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setTemperatureSettingValue(byte[] edt);
	/**
	 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getTemperatureSettingValue();
	/**
	 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredTemperature() {return null;}
	/**
	 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	/**
	 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	/**
	 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingValueTime(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingValueTime() {return null;}
	/**
	 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingValueRelativeTime(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingValueRelativeTime() {return null;}
	/**
	 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	/**
	 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerSettingValueTime(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerSettingValueTime() {return null;}
	/**
	 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerValueRelativeTime(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerValueRelativeTime() {return null;}
	/**
	 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setExtentionalOperationSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getExtentionalOperationSetting() {return null;}
	/**
	 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setExtentionalOperationTimerTimeSettingValue(byte[] edt) {return false;}
	/**
	 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getExtentionalOperationTimerTimeSettingValue() {return null;}
	/**
	 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setIonEmissionSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getIonEmissionSetting() {return null;}
	/**
	 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getImplementedIonEmissionMethod() {return null;}
	/**
	 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
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
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetTemperatureSettingValue(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetTemperatureSettingValue(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingValueTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingValueTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerSettingValueTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerSettingValueTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerValueRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerValueRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetExtentionalOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetExtentionalOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetIonEmissionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetIonEmissionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetOilAmountLevel(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetTemperatureSettingValue(byte[] edt);
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt);
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSettingValueTime(byte[] edt);
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSettingValueRelativeTime(byte[] edt);
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt);
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerSettingValueTime(byte[] edt);
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerValueRelativeTime(byte[] edt);
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetExtentionalOperationSetting(byte[] edt);
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetExtentionalOperationTimerTimeSettingValue(byte[] edt);
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetIonEmissionSetting(byte[] edt);
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
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetTemperatureSettingValue();
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredTemperature();
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetAutomaticTemperatureControlSetting();
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSettingValueTime();
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSettingValueRelativeTime();
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerReservationSetting();
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerSettingValueTime();
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerValueRelativeTime();
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetExtentionalOperationSetting();
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetExtentionalOperationTimerTimeSettingValue();
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetIonEmissionSetting();
		/**
		 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetImplementedIonEmissionMethod();
		/**
		 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetOilAmountLevel();
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
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformTemperatureSettingValue();
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredTemperature();
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformAutomaticTemperatureControlSetting();
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSettingValueTime();
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSettingValueRelativeTime();
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerReservationSetting();
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerSettingValueTime();
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerValueRelativeTime();
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformExtentionalOperationSetting();
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformExtentionalOperationTimerTimeSettingValue();
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformIonEmissionSetting();
		/**
		 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformImplementedIonEmissionMethod();
		/**
		 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformOilAmountLevel();
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
