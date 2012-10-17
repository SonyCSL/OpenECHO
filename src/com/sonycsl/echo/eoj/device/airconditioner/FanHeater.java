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

	public static final byte EPC_TEMPERATURE_SETTING_VALUE = (byte)0xB3;
	public static final byte EPC_MEASURED_TEMPERATURE = (byte)0xBB;
	public static final byte EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING = (byte)0xB1;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING_VALUE_TIME = (byte)0x91;
	public static final byte EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME = (byte)0x92;
	public static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_OFF_TIMER_SETTING_VALUE_TIME = (byte)0x95;
	public static final byte EPC_OFF_TIMER_VALUE_RELATIVE_TIME = (byte)0x96;
	public static final byte EPC_EXTENTIONAL_OPERATION_SETTING = (byte)0xC0;
	public static final byte EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE = (byte)0xC1;
	public static final byte EPC_ION_EMISSION_SETTING = (byte)0xC2;
	public static final byte EPC_IMPLEMENTED_ION_EMISSION_METHOD = (byte)0xC3;
	public static final byte EPC_OIL_AMOUNT_LEVEL = (byte)0xC4;

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
	private final boolean _setTemperatureSettingValue(byte epc, byte[] edt) {
		boolean success = setTemperatureSettingValue(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getTemperatureSettingValue();
	private final byte[] _getTemperatureSettingValue(byte epc) {
		byte[] edt = getTemperatureSettingValue();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredTemperature() {return null;}
	private final byte[] _getMeasuredTemperature(byte epc) {
		byte[] edt = getMeasuredTemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	private final boolean _setAutomaticTemperatureControlSetting(byte epc, byte[] edt) {
		boolean success = setAutomaticTemperatureControlSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	private final byte[] _getAutomaticTemperatureControlSetting(byte epc) {
		byte[] edt = getAutomaticTemperatureControlSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingValueTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingValueTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingValueTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingValueTime() {return null;}
	private final byte[] _getOnTimerSettingValueTime(byte epc) {
		byte[] edt = getOnTimerSettingValueTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingValueRelativeTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingValueRelativeTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingValueRelativeTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingValueRelativeTime() {return null;}
	private final byte[] _getOnTimerSettingValueRelativeTime(byte epc) {
		byte[] edt = getOnTimerSettingValueRelativeTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOffTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOffTimerReservationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	private final byte[] _getOffTimerReservationSetting(byte epc) {
		byte[] edt = getOffTimerReservationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerSettingValueTime(byte[] edt) {return false;}
	private final boolean _setOffTimerSettingValueTime(byte epc, byte[] edt) {
		boolean success = setOffTimerSettingValueTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerSettingValueTime() {return null;}
	private final byte[] _getOffTimerSettingValueTime(byte epc) {
		byte[] edt = getOffTimerSettingValueTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerValueRelativeTime(byte[] edt) {return false;}
	private final boolean _setOffTimerValueRelativeTime(byte epc, byte[] edt) {
		boolean success = setOffTimerValueRelativeTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerValueRelativeTime() {return null;}
	private final byte[] _getOffTimerValueRelativeTime(byte epc) {
		byte[] edt = getOffTimerValueRelativeTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setExtentionalOperationSetting(byte[] edt) {return false;}
	private final boolean _setExtentionalOperationSetting(byte epc, byte[] edt) {
		boolean success = setExtentionalOperationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getExtentionalOperationSetting() {return null;}
	private final byte[] _getExtentionalOperationSetting(byte epc) {
		byte[] edt = getExtentionalOperationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setExtentionalOperationTimerTimeSettingValue(byte[] edt) {return false;}
	private final boolean _setExtentionalOperationTimerTimeSettingValue(byte epc, byte[] edt) {
		boolean success = setExtentionalOperationTimerTimeSettingValue(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getExtentionalOperationTimerTimeSettingValue() {return null;}
	private final byte[] _getExtentionalOperationTimerTimeSettingValue(byte epc) {
		byte[] edt = getExtentionalOperationTimerTimeSettingValue();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setIonEmissionSetting(byte[] edt) {return false;}
	private final boolean _setIonEmissionSetting(byte epc, byte[] edt) {
		boolean success = setIonEmissionSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getIonEmissionSetting() {return null;}
	private final byte[] _getIonEmissionSetting(byte epc) {
		byte[] edt = getIonEmissionSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getImplementedIonEmissionMethod() {return null;}
	private final byte[] _getImplementedIonEmissionMethod(byte epc) {
		byte[] edt = getImplementedIonEmissionMethod();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getOilAmountLevel() {return null;}
	private final byte[] _getOilAmountLevel(byte epc) {
		byte[] edt = getOilAmountLevel();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_TEMPERATURE_SETTING_VALUE:
			res.addProperty(epc, edt, _setTemperatureSettingValue(epc, edt));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			res.addProperty(epc, edt, _setAutomaticTemperatureControlSetting(epc, edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_VALUE_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingValueTime(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingValueRelativeTime(epc, edt));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOffTimerReservationSetting(epc, edt));
			break;
		case EPC_OFF_TIMER_SETTING_VALUE_TIME:
			res.addProperty(epc, edt, _setOffTimerSettingValueTime(epc, edt));
			break;
		case EPC_OFF_TIMER_VALUE_RELATIVE_TIME:
			res.addProperty(epc, edt, _setOffTimerValueRelativeTime(epc, edt));
			break;
		case EPC_EXTENTIONAL_OPERATION_SETTING:
			res.addProperty(epc, edt, _setExtentionalOperationSetting(epc, edt));
			break;
		case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE:
			res.addProperty(epc, edt, _setExtentionalOperationTimerTimeSettingValue(epc, edt));
			break;
		case EPC_ION_EMISSION_SETTING:
			res.addProperty(epc, edt, _setIonEmissionSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_TEMPERATURE_SETTING_VALUE:
			edt = _getTemperatureSettingValue(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE:
			edt = _getMeasuredTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			edt = _getAutomaticTemperatureControlSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = _getOnTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING_VALUE_TIME:
			edt = _getOnTimerSettingValueTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME:
			edt = _getOnTimerSettingValueRelativeTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			edt = _getOffTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING_VALUE_TIME:
			edt = _getOffTimerSettingValueTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_VALUE_RELATIVE_TIME:
			edt = _getOffTimerValueRelativeTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_EXTENTIONAL_OPERATION_SETTING:
			edt = _getExtentionalOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE:
			edt = _getExtentionalOperationTimerTimeSettingValue(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ION_EMISSION_SETTING:
			edt = _getIonEmissionSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_IMPLEMENTED_ION_EMISSION_METHOD:
			edt = _getImplementedIonEmissionMethod(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OIL_AMOUNT_LEVEL:
			edt = _getOilAmountLevel(epc);
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
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_TEMPERATURE_SETTING_VALUE:
				_onSetTemperatureSettingValue(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				_onSetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_VALUE_TIME:
				_onSetOnTimerSettingValueTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME:
				_onSetOnTimerSettingValueRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				_onSetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_VALUE_TIME:
				_onSetOffTimerSettingValueTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_VALUE_RELATIVE_TIME:
				_onSetOffTimerValueRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_EXTENTIONAL_OPERATION_SETTING:
				_onSetExtentionalOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE:
				_onSetExtentionalOperationTimerTimeSettingValue(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ION_EMISSION_SETTING:
				_onSetIonEmissionSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_TEMPERATURE_SETTING_VALUE:
				_onGetTemperatureSettingValue(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE:
				_onGetMeasuredTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				_onGetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_VALUE_TIME:
				_onGetOnTimerSettingValueTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME:
				_onGetOnTimerSettingValueRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				_onGetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_VALUE_TIME:
				_onGetOffTimerSettingValueTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_VALUE_RELATIVE_TIME:
				_onGetOffTimerValueRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_EXTENTIONAL_OPERATION_SETTING:
				_onGetExtentionalOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE:
				_onGetExtentionalOperationTimerTimeSettingValue(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ION_EMISSION_SETTING:
				_onGetIonEmissionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_IMPLEMENTED_ION_EMISSION_METHOD:
				_onGetImplementedIonEmissionMethod(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OIL_AMOUNT_LEVEL:
				_onGetOilAmountLevel(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetTemperatureSettingValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureSettingValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureSettingValue(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets the temperature and gets the setting status.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetTemperatureSettingValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureSettingValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureSettingValue(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7D (-128 to 125��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredTemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets automatic / non-automatic and gets the setting status<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets ON/OFF of reservation and gets the setting status.<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingValueTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingValueTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingValueTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets timer value HH:MM and gets setting status<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingValueTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingValueTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingValueTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingValueRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets timer value HH:MM and gets the updated time<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingValueRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingValueRelativeTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets ON/OFF of reservation and gets setting status<br>Reservation ON: 0x41, OFF:0x42 for both time and relative time Timer-based reservation ON:0x43, Relative time reservation ON:0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerSettingValueTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerSettingValueTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerSettingValueTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets timer value HH:MM and gets the setting status.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerSettingValueTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerSettingValueTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerSettingValueTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerValueRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerValueRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerValueRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets timer value HH:MM and gets updated time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerValueRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerValueRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerValueRelativeTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetExtentionalOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetExtentionalOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetExtentionalOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets ON/OFF of extensional operation and gets setting status.<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetExtentionalOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetExtentionalOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetExtentionalOperationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetExtentionalOperationTimerTimeSettingValue(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Setsextension time HH:MM and gets the extended time<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetExtentionalOperationTimerTimeSettingValue(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetExtentionalOperationTimerTimeSettingValue(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetIonEmissionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetIonEmissionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetIonEmissionSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets ON/OFF of ion emission and gets setting status.<br>Emission ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetIonEmissionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIonEmissionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIonEmissionSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Specifies ion emission method imlemented in humidifier by bit map<br>Extension ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetImplementedIonEmissionMethod(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Specifies oil amount in the tank by 6 levels.<br>0x40: empty 0x41-0x45: minimum to maximum levels<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetOilAmountLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOilAmountLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOilAmountLevel(eoj, tid, esv, epc, pdc, edt);
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
			byte epc = EPC_TEMPERATURE_SETTING_VALUE;
			addProperty(epc, edt, _setTemperatureSettingValue(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			byte epc = EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING;
			addProperty(epc, edt, _setAutomaticTemperatureControlSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingValueTime(byte[] edt) {
			byte epc = EPC_ON_TIMER_SETTING_VALUE_TIME;
			addProperty(epc, edt, _setOnTimerSettingValueTime(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSettingValueRelativeTime(byte[] edt) {
			byte epc = EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME;
			addProperty(epc, edt, _setOnTimerSettingValueRelativeTime(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			byte epc = EPC_OFF_TIMER_RESERVATION_SETTING;
			addProperty(epc, edt, _setOffTimerReservationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingValueTime(byte[] edt) {
			byte epc = EPC_OFF_TIMER_SETTING_VALUE_TIME;
			addProperty(epc, edt, _setOffTimerSettingValueTime(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerValueRelativeTime(byte[] edt) {
			byte epc = EPC_OFF_TIMER_VALUE_RELATIVE_TIME;
			addProperty(epc, edt, _setOffTimerValueRelativeTime(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetExtentionalOperationSetting(byte[] edt) {
			byte epc = EPC_EXTENTIONAL_OPERATION_SETTING;
			addProperty(epc, edt, _setExtentionalOperationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetExtentionalOperationTimerTimeSettingValue(byte[] edt) {
			byte epc = EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE;
			addProperty(epc, edt, _setExtentionalOperationTimerTimeSettingValue(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetIonEmissionSetting(byte[] edt) {
			byte epc = EPC_ION_EMISSION_SETTING;
			addProperty(epc, edt, _setIonEmissionSetting(epc, edt));
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
			byte epc = EPC_TEMPERATURE_SETTING_VALUE;
			byte[] edt = _getTemperatureSettingValue(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperature() {
			byte epc = EPC_MEASURED_TEMPERATURE;
			byte[] edt = _getMeasuredTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutomaticTemperatureControlSetting() {
			byte epc = EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING;
			byte[] edt = _getAutomaticTemperatureControlSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOnTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingValueTime() {
			byte epc = EPC_ON_TIMER_SETTING_VALUE_TIME;
			byte[] edt = _getOnTimerSettingValueTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSettingValueRelativeTime() {
			byte epc = EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME;
			byte[] edt = _getOnTimerSettingValueRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerReservationSetting() {
			byte epc = EPC_OFF_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOffTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingValueTime() {
			byte epc = EPC_OFF_TIMER_SETTING_VALUE_TIME;
			byte[] edt = _getOffTimerSettingValueTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerValueRelativeTime() {
			byte epc = EPC_OFF_TIMER_VALUE_RELATIVE_TIME;
			byte[] edt = _getOffTimerValueRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetExtentionalOperationSetting() {
			byte epc = EPC_EXTENTIONAL_OPERATION_SETTING;
			byte[] edt = _getExtentionalOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetExtentionalOperationTimerTimeSettingValue() {
			byte epc = EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE;
			byte[] edt = _getExtentionalOperationTimerTimeSettingValue(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetIonEmissionSetting() {
			byte epc = EPC_ION_EMISSION_SETTING;
			byte[] edt = _getIonEmissionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetImplementedIonEmissionMethod() {
			byte epc = EPC_IMPLEMENTED_ION_EMISSION_METHOD;
			byte[] edt = _getImplementedIonEmissionMethod(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOilAmountLevel() {
			byte epc = EPC_OIL_AMOUNT_LEVEL;
			byte[] edt = _getOilAmountLevel(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
			byte epc = EPC_TEMPERATURE_SETTING_VALUE;
			byte[] edt = _getTemperatureSettingValue(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperature() {
			byte epc = EPC_MEASURED_TEMPERATURE;
			byte[] edt = _getMeasuredTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutomaticTemperatureControlSetting() {
			byte epc = EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING;
			byte[] edt = _getAutomaticTemperatureControlSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOnTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingValueTime() {
			byte epc = EPC_ON_TIMER_SETTING_VALUE_TIME;
			byte[] edt = _getOnTimerSettingValueTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSettingValueRelativeTime() {
			byte epc = EPC_ON_TIMER_SETTING_VALUE_RELATIVE_TIME;
			byte[] edt = _getOnTimerSettingValueRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerReservationSetting() {
			byte epc = EPC_OFF_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOffTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingValueTime() {
			byte epc = EPC_OFF_TIMER_SETTING_VALUE_TIME;
			byte[] edt = _getOffTimerSettingValueTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerValueRelativeTime() {
			byte epc = EPC_OFF_TIMER_VALUE_RELATIVE_TIME;
			byte[] edt = _getOffTimerValueRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformExtentionalOperationSetting() {
			byte epc = EPC_EXTENTIONAL_OPERATION_SETTING;
			byte[] edt = _getExtentionalOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformExtentionalOperationTimerTimeSettingValue() {
			byte epc = EPC_EXTENTIONAL_OPERATION_TIMER_TIME_SETTING_VALUE;
			byte[] edt = _getExtentionalOperationTimerTimeSettingValue(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformIonEmissionSetting() {
			byte epc = EPC_ION_EMISSION_SETTING;
			byte[] edt = _getIonEmissionSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformImplementedIonEmissionMethod() {
			byte epc = EPC_IMPLEMENTED_ION_EMISSION_METHOD;
			byte[] edt = _getImplementedIonEmissionMethod(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOilAmountLevel() {
			byte epc = EPC_OIL_AMOUNT_LEVEL;
			byte[] edt = _getOilAmountLevel(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
