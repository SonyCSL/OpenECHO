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

public abstract class ElectricHeater extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = ElectricHeater.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x42;

	public static final byte EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING = (byte)0xB1;
	public static final byte EPC_TEMPERATURE_SETTING = (byte)0xB3;
	public static final byte EPC_MEASURED_ROOM_TEMPERATURE = (byte)0xBB;
	public static final byte EPC_REMOTELY_SET_TEMPERATURE = (byte)0xBC;
	public static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	public static final byte EPC_ON_TIMER_BASED_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING_TIME = (byte)0x91;
	public static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME = (byte)0x92;
	public static final byte EPC_OFF_TIMER_BASED_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_OFF_TIMER_SETTING_TIME = (byte)0x95;
	public static final byte EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME = (byte)0x96;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	private final boolean _setAutomaticTemperatureControlSetting(byte epc, byte[] edt) {
		boolean success = setAutomaticTemperatureControlSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	private final byte[] _getAutomaticTemperatureControlSetting(byte epc) {
		byte[] edt = getAutomaticTemperatureControlSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setTemperatureSetting(byte[] edt);
	private final boolean _setTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setTemperatureSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getTemperatureSetting();
	private final byte[] _getTemperatureSetting(byte epc) {
		byte[] edt = getTemperatureSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured room temperature.<br>0x81 to 0x7E (-128 to 127��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredRoomTemperature() {return null;}
	private final byte[] _getMeasuredRoomTemperature(byte epc) {
		byte[] edt = getMeasuredRoomTemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the last temperature (��C) set by the user using a remote controller unit.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRemotelySetTemperature() {return null;}
	private final byte[] _getRemotelySetTemperature(byte epc) {
		byte[] edt = getRemotelySetTemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	private final boolean _setAirFlowRateSetting(byte epc, byte[] edt) {
		boolean success = setAirFlowRateSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAirFlowRateSetting() {return null;}
	private final byte[] _getAirFlowRateSetting(byte epc) {
		byte[] edt = getAirFlowRateSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerBasedReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerBasedReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerBasedReservationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerBasedReservationSetting() {return null;}
	private final byte[] _getOnTimerBasedReservationSetting(byte epc) {
		byte[] edt = getOnTimerBasedReservationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	private final byte[] _getOnTimerSettingTime(byte epc) {
		byte[] edt = getOnTimerSettingTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	private final boolean _setOnTimerSettingRelativeTime(byte epc, byte[] edt) {
		boolean success = setOnTimerSettingRelativeTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	private final byte[] _getOnTimerSettingRelativeTime(byte epc) {
		byte[] edt = getOnTimerSettingRelativeTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerBasedReservationSetting(byte[] edt) {return false;}
	private final boolean _setOffTimerBasedReservationSetting(byte epc, byte[] edt) {
		boolean success = setOffTimerBasedReservationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerBasedReservationSetting() {return null;}
	private final byte[] _getOffTimerBasedReservationSetting(byte epc) {
		byte[] edt = getOffTimerBasedReservationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	private final boolean _setOffTimerSettingTime(byte epc, byte[] edt) {
		boolean success = setOffTimerSettingTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	private final byte[] _getOffTimerSettingTime(byte epc) {
		byte[] edt = getOffTimerSettingTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setSetValueOfOffTimerRelativeTime(byte[] edt) {return false;}
	private final boolean _setSetValueOfOffTimerRelativeTime(byte epc, byte[] edt) {
		boolean success = setSetValueOfOffTimerRelativeTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSetValueOfOffTimerRelativeTime() {return null;}
	private final byte[] _getSetValueOfOffTimerRelativeTime(byte epc) {
		byte[] edt = getSetValueOfOffTimerRelativeTime();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			res.addProperty(epc, edt, _setAutomaticTemperatureControlSetting(epc, edt));
			break;
		case EPC_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setTemperatureSetting(epc, edt));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, _setAirFlowRateSetting(epc, edt));
			break;
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOnTimerBasedReservationSetting(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingTime(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, _setOnTimerSettingRelativeTime(epc, edt));
			break;
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOffTimerBasedReservationSetting(epc, edt));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, _setOffTimerSettingTime(epc, edt));
			break;
		case EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME:
			res.addProperty(epc, edt, _setSetValueOfOffTimerRelativeTime(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			edt = _getAutomaticTemperatureControlSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPERATURE_SETTING:
			edt = _getTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_ROOM_TEMPERATURE:
			edt = _getMeasuredRoomTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REMOTELY_SET_TEMPERATURE:
			edt = _getRemotelySetTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			edt = _getAirFlowRateSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
			edt = _getOnTimerBasedReservationSetting(epc);
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
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
			edt = _getOffTimerBasedReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			edt = _getOffTimerSettingTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME:
			edt = _getSetValueOfOffTimerRelativeTime(epc);
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
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				_onSetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_TEMPERATURE_SETTING:
				_onSetTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				_onSetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
				_onSetOnTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				_onSetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				_onSetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
				_onSetOffTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				_onSetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME:
				_onSetSetValueOfOffTimerRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				_onGetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TEMPERATURE_SETTING:
				_onGetTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_ROOM_TEMPERATURE:
				_onGetMeasuredRoomTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REMOTELY_SET_TEMPERATURE:
				_onGetRemotelySetTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				_onGetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
				_onGetOnTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				_onGetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				_onGetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
				_onGetOffTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				_onGetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME:
				_onGetSetValueOfOffTimerRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutomaticTemperatureControlSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7E (-128 to 127��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredRoomTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredRoomTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredRoomTemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the last temperature (��C) set by the user using a remote controller unit.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRemotelySetTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRemotelySetTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRemotelySetTemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAirFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAirFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerBasedReservationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerSettingTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetSetValueOfOffTimerRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfOffTimerRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfOffTimerRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetSetValueOfOffTimerRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfOffTimerRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfOffTimerRelativeTime(eoj, tid, esv, epc, pdc, edt);
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
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt);
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetAirFlowRateSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt);
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt);
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt);
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt);
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt);
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSetValueOfOffTimerRelativeTime(byte[] edt);
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
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			byte epc = EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING;
			addProperty(epc, edt, _setAutomaticTemperatureControlSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting(byte[] edt) {
			byte epc = EPC_TEMPERATURE_SETTING;
			addProperty(epc, edt, _setTemperatureSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			byte epc = EPC_AIR_FLOW_RATE_SETTING;
			addProperty(epc, edt, _setAirFlowRateSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt) {
			byte epc = EPC_ON_TIMER_BASED_RESERVATION_SETTING;
			addProperty(epc, edt, _setOnTimerBasedReservationSetting(epc, edt));
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
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt) {
			byte epc = EPC_OFF_TIMER_BASED_RESERVATION_SETTING;
			addProperty(epc, edt, _setOffTimerBasedReservationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			byte epc = EPC_OFF_TIMER_SETTING_TIME;
			addProperty(epc, edt, _setOffTimerSettingTime(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfOffTimerRelativeTime(byte[] edt) {
			byte epc = EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME;
			addProperty(epc, edt, _setSetValueOfOffTimerRelativeTime(epc, edt));
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
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfOffTimerRelativeTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
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
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetAutomaticTemperatureControlSetting();
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetTemperatureSetting();
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7E (-128 to 127��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredRoomTemperature();
		/**
		 * This property indicates the last temperature (��C) set by the user using a remote controller unit.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRemotelySetTemperature();
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetAirFlowRateSetting();
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerSettingTime();
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSetValueOfOffTimerRelativeTime();
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
		public Getter reqGetAutomaticTemperatureControlSetting() {
			byte epc = EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING;
			byte[] edt = _getAutomaticTemperatureControlSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting() {
			byte epc = EPC_TEMPERATURE_SETTING;
			byte[] edt = _getTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredRoomTemperature() {
			byte epc = EPC_MEASURED_ROOM_TEMPERATURE;
			byte[] edt = _getMeasuredRoomTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRemotelySetTemperature() {
			byte epc = EPC_REMOTELY_SET_TEMPERATURE;
			byte[] edt = _getRemotelySetTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAirFlowRateSetting() {
			byte epc = EPC_AIR_FLOW_RATE_SETTING;
			byte[] edt = _getAirFlowRateSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerBasedReservationSetting() {
			byte epc = EPC_ON_TIMER_BASED_RESERVATION_SETTING;
			byte[] edt = _getOnTimerBasedReservationSetting(epc);
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
		public Getter reqGetOffTimerBasedReservationSetting() {
			byte epc = EPC_OFF_TIMER_BASED_RESERVATION_SETTING;
			byte[] edt = _getOffTimerBasedReservationSetting(epc);
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
		public Getter reqGetSetValueOfOffTimerRelativeTime() {
			byte epc = EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME;
			byte[] edt = _getSetValueOfOffTimerRelativeTime(epc);
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
		public Getter reqGetAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting() {
			addProperty(EPC_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMeasuredRoomTemperature() {
			addProperty(EPC_MEASURED_ROOM_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetRemotelySetTemperature() {
			addProperty(EPC_REMOTELY_SET_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerBasedReservationSetting() {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
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
		public Getter reqGetOffTimerBasedReservationSetting() {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfOffTimerRelativeTime() {
			addProperty(EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME);
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
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformAutomaticTemperatureControlSetting();
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformTemperatureSetting();
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7E (-128 to 127��C)<br><br>Data type : signed char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredRoomTemperature();
		/**
		 * This property indicates the last temperature (��C) set by the user using a remote controller unit.<br>0x00 to 0x32 (0 to 50��C)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRemotelySetTemperature();
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformAirFlowRateSetting();
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerSettingTime();
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSetValueOfOffTimerRelativeTime();
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
		public Informer reqInformAutomaticTemperatureControlSetting() {
			byte epc = EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING;
			byte[] edt = _getAutomaticTemperatureControlSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting() {
			byte epc = EPC_TEMPERATURE_SETTING;
			byte[] edt = _getTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRoomTemperature() {
			byte epc = EPC_MEASURED_ROOM_TEMPERATURE;
			byte[] edt = _getMeasuredRoomTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRemotelySetTemperature() {
			byte epc = EPC_REMOTELY_SET_TEMPERATURE;
			byte[] edt = _getRemotelySetTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			byte epc = EPC_AIR_FLOW_RATE_SETTING;
			byte[] edt = _getAirFlowRateSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerBasedReservationSetting() {
			byte epc = EPC_ON_TIMER_BASED_RESERVATION_SETTING;
			byte[] edt = _getOnTimerBasedReservationSetting(epc);
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
		public Informer reqInformOffTimerBasedReservationSetting() {
			byte epc = EPC_OFF_TIMER_BASED_RESERVATION_SETTING;
			byte[] edt = _getOffTimerBasedReservationSetting(epc);
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
		public Informer reqInformSetValueOfOffTimerRelativeTime() {
			byte epc = EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME;
			byte[] edt = _getSetValueOfOffTimerRelativeTime(epc);
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
		public Informer reqInformAutomaticTemperatureControlSetting() {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting() {
			addProperty(EPC_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMeasuredRoomTemperature() {
			addProperty(EPC_MEASURED_ROOM_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformRemotelySetTemperature() {
			addProperty(EPC_REMOTELY_SET_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			addProperty(EPC_AIR_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerBasedReservationSetting() {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING);
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
		public Informer reqInformOffTimerBasedReservationSetting() {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			addProperty(EPC_OFF_TIMER_SETTING_TIME);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfOffTimerRelativeTime() {
			addProperty(EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME);
			return this;
		}
	}
}
