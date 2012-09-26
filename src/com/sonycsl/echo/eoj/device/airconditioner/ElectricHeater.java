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

	protected static final byte EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING = (byte)0xB1;
	protected static final byte EPC_TEMPERATURE_SETTING = (byte)0xB3;
	protected static final byte EPC_MEASURED_ROOM_TEMPERATURE = (byte)0xBB;
	protected static final byte EPC_REMOTELY_SET_TEMPERATURE = (byte)0xBC;
	protected static final byte EPC_AIR_FLOW_RATE_SETTING = (byte)0xA0;
	protected static final byte EPC_ON_TIMER_BASED_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_ON_TIMER_SETTING_TIME = (byte)0x91;
	protected static final byte EPC_ON_TIMER_SETTING_RELATIVE_TIME = (byte)0x92;
	protected static final byte EPC_OFF_TIMER_BASED_RESERVATION_SETTING = (byte)0x94;
	protected static final byte EPC_OFF_TIMER_SETTING_TIME = (byte)0x95;
	protected static final byte EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME = (byte)0x96;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42
	 */
	protected boolean setAutomaticTemperatureControlSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42
	 */
	protected byte[] getAutomaticTemperatureControlSetting() {return null;}
	/**
	 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)
	 */
	protected abstract boolean setTemperatureSetting(byte[] edt);
	/**
	 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)
	 */
	protected abstract byte[] getTemperatureSetting();
	/**
	 * This property indicates the measured room temperature.<br>0x81 to 0x7E (-128 to 127��C)
	 */
	protected byte[] getMeasuredRoomTemperature() {return null;}
	/**
	 * This property indicates the last temperature (��C) set by the user using a remote controller unit.<br>0x00 to 0x32 (0 to 50��C)
	 */
	protected byte[] getRemotelySetTemperature() {return null;}
	/**
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38
	 */
	protected boolean setAirFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38
	 */
	protected byte[] getAirFlowRateSetting() {return null;}
	/**
	 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42
	 */
	protected boolean setOnTimerBasedReservationSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42
	 */
	protected byte[] getOnTimerBasedReservationSetting() {return null;}
	/**
	 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOnTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOnTimerSettingTime() {return null;}
	/**
	 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOnTimerSettingRelativeTime(byte[] edt) {return false;}
	/**
	 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOnTimerSettingRelativeTime() {return null;}
	/**
	 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42
	 */
	protected boolean setOffTimerBasedReservationSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42
	 */
	protected byte[] getOffTimerBasedReservationSetting() {return null;}
	/**
	 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected boolean setOffTimerSettingTime(byte[] edt) {return false;}
	/**
	 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
	 */
	protected byte[] getOffTimerSettingTime() {return null;}
	/**
	 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected boolean setSetValueOfOffTimerRelativeTime(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
	 */
	protected byte[] getSetValueOfOffTimerRelativeTime() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			res.addProperty(epc, edt, setAutomaticTemperatureControlSetting(edt));
			break;
		case EPC_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setTemperatureSetting(edt));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, setAirFlowRateSetting(edt));
			break;
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOnTimerBasedReservationSetting(edt));
			break;
		case EPC_ON_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, setOnTimerSettingTime(edt));
			break;
		case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, setOnTimerSettingRelativeTime(edt));
			break;
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOffTimerBasedReservationSetting(edt));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			res.addProperty(epc, edt, setOffTimerSettingTime(edt));
			break;
		case EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME:
			res.addProperty(epc, edt, setSetValueOfOffTimerRelativeTime(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
			edt = getAutomaticTemperatureControlSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPERATURE_SETTING:
			edt = getTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_ROOM_TEMPERATURE:
			edt = getMeasuredRoomTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REMOTELY_SET_TEMPERATURE:
			edt = getRemotelySetTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AIR_FLOW_RATE_SETTING:
			edt = getAirFlowRateSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
			edt = getOnTimerBasedReservationSetting();
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
		case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
			edt = getOffTimerBasedReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING_TIME:
			edt = getOffTimerSettingTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME:
			edt = getSetValueOfOffTimerRelativeTime();
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
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				onSetAutomaticTemperatureControlSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPERATURE_SETTING:
				onSetTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				onSetAirFlowRateSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
				onSetOnTimerBasedReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				onSetOnTimerSettingTime(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				onSetOnTimerSettingRelativeTime(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
				onSetOffTimerBasedReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				onSetOffTimerSettingTime(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME:
				onSetSetValueOfOffTimerRelativeTime(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING:
				onGetAutomaticTemperatureControlSetting(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPERATURE_SETTING:
				onGetTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_ROOM_TEMPERATURE:
				onGetMeasuredRoomTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_REMOTELY_SET_TEMPERATURE:
				onGetRemotelySetTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_AIR_FLOW_RATE_SETTING:
				onGetAirFlowRateSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_BASED_RESERVATION_SETTING:
				onGetOnTimerBasedReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_TIME:
				onGetOnTimerSettingTime(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING_RELATIVE_TIME:
				onGetOnTimerSettingRelativeTime(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_BASED_RESERVATION_SETTING:
				onGetOffTimerBasedReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING_TIME:
				onGetOffTimerSettingTime(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME:
				onGetSetValueOfOffTimerRelativeTime(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42
		 */
		protected void onSetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42
		 */
		protected void onGetAutomaticTemperatureControlSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)
		 */
		protected void onSetTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)
		 */
		protected void onGetTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7E (-128 to 127��C)
		 */
		protected void onGetMeasuredRoomTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the last temperature (��C) set by the user using a remote controller unit.<br>0x00 to 0x32 (0 to 50��C)
		 */
		protected void onGetRemotelySetTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		protected void onSetAirFlowRateSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		protected void onGetAirFlowRateSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42
		 */
		protected void onSetOnTimerBasedReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42
		 */
		protected void onGetOnTimerBasedReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOnTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOnTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOnTimerSettingRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOnTimerSettingRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42
		 */
		protected void onSetOffTimerBasedReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42
		 */
		protected void onGetOffTimerBasedReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onSetOffTimerSettingTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		protected void onGetOffTimerSettingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onSetSetValueOfOffTimerRelativeTime(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		protected void onGetSetValueOfOffTimerRelativeTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42
		 */
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt);
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)
		 */
		public Setter reqSetTemperatureSetting(byte[] edt);
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		public Setter reqSetAirFlowRateSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42
		 */
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt);
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOnTimerSettingTime(byte[] edt);
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOnTimerSettingRelativeTime(byte[] edt);
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42
		 */
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt);
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Setter reqSetOffTimerSettingTime(byte[] edt);
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Setter reqSetSetValueOfOffTimerRelativeTime(byte[] edt);

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
		public Setter reqSetAutomaticTemperatureControlSetting(byte[] edt) {
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, setAutomaticTemperatureControlSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING, edt, setTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetAirFlowRateSetting(byte[] edt) {
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, setAirFlowRateSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt, setOnTimerBasedReservationSetting(edt));
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
		public Setter reqSetOffTimerBasedReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt, setOffTimerBasedReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSettingTime(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, setOffTimerSettingTime(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfOffTimerRelativeTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME, edt, setSetValueOfOffTimerRelativeTime(edt));
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
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42
		 */
		public Getter reqGetAutomaticTemperatureControlSetting();
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)
		 */
		public Getter reqGetTemperatureSetting();
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7E (-128 to 127��C)
		 */
		public Getter reqGetMeasuredRoomTemperature();
		/**
		 * This property indicates the last temperature (��C) set by the user using a remote controller unit.<br>0x00 to 0x32 (0 to 50��C)
		 */
		public Getter reqGetRemotelySetTemperature();
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		public Getter reqGetAirFlowRateSetting();
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42
		 */
		public Getter reqGetOnTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42
		 */
		public Getter reqGetOffTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Getter reqGetOffTimerSettingTime();
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Getter reqGetSetValueOfOffTimerRelativeTime();

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
		public Getter reqGetAutomaticTemperatureControlSetting() {
			byte[] edt = getAutomaticTemperatureControlSetting();
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting() {
			byte[] edt = getTemperatureSetting();
			addProperty(EPC_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredRoomTemperature() {
			byte[] edt = getMeasuredRoomTemperature();
			addProperty(EPC_MEASURED_ROOM_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRemotelySetTemperature() {
			byte[] edt = getRemotelySetTemperature();
			addProperty(EPC_REMOTELY_SET_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAirFlowRateSetting() {
			byte[] edt = getAirFlowRateSetting();
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerBasedReservationSetting() {
			byte[] edt = getOnTimerBasedReservationSetting();
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetOffTimerBasedReservationSetting() {
			byte[] edt = getOffTimerBasedReservationSetting();
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSettingTime() {
			byte[] edt = getOffTimerSettingTime();
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfOffTimerRelativeTime() {
			byte[] edt = getSetValueOfOffTimerRelativeTime();
			addProperty(EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
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
		 * Used to specify whether or not to use the automatic temperature control function.<br>Automatic = 0x41, non-automatic = 0x42
		 */
		public Informer reqInformAutomaticTemperatureControlSetting();
		/**
		 * Used to set the temperature.<br>0x00 to 0x32 (0 to 50��C)
		 */
		public Informer reqInformTemperatureSetting();
		/**
		 * This property indicates the measured room temperature.<br>0x81 to 0x7E (-128 to 127��C)
		 */
		public Informer reqInformMeasuredRoomTemperature();
		/**
		 * This property indicates the last temperature (��C) set by the user using a remote controller unit.<br>0x00 to 0x32 (0 to 50��C)
		 */
		public Informer reqInformRemotelySetTemperature();
		/**
		 * Used to specify the air flow rate or to specify using the function to automatically control the air flow rate. The air flow rate is selected from among the 8 predefined levels.<br>Automatic air flow rate control used = 0x41 Air flow rate = 0x31 to 0x38
		 */
		public Informer reqInformAirFlowRateSetting();
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function.<br>ON timer-based reservation function ON: 0x41 ON timer-based reservation function OFF: 0x42
		 */
		public Informer reqInformOnTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the ON timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOnTimerSettingTime();
		/**
		 * Used to specify the relative time for the ON timer-based reservation function in the HH:MM format<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOnTimerSettingRelativeTime();
		/**
		 * Used to specify whether or not to use the OFF timer-based reservation function.<br>OFF timer-based reservation function ON: 0x41 OFF timer-based reservation function OFF: 0x42
		 */
		public Informer reqInformOffTimerBasedReservationSetting();
		/**
		 * Used to specify the time for the OFF timer-based reservation function in the HH:MM format.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)
		 */
		public Informer reqInformOffTimerSettingTime();
		/**
		 * Timer value HH:MM<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)
		 */
		public Informer reqInformSetValueOfOffTimerRelativeTime();

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
		public Informer reqInformAutomaticTemperatureControlSetting() {
			byte[] edt = getAutomaticTemperatureControlSetting();
			addProperty(EPC_AUTOMATIC_TEMPERATURE_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting() {
			byte[] edt = getTemperatureSetting();
			addProperty(EPC_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRoomTemperature() {
			byte[] edt = getMeasuredRoomTemperature();
			addProperty(EPC_MEASURED_ROOM_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRemotelySetTemperature() {
			byte[] edt = getRemotelySetTemperature();
			addProperty(EPC_REMOTELY_SET_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAirFlowRateSetting() {
			byte[] edt = getAirFlowRateSetting();
			addProperty(EPC_AIR_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerBasedReservationSetting() {
			byte[] edt = getOnTimerBasedReservationSetting();
			addProperty(EPC_ON_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformOffTimerBasedReservationSetting() {
			byte[] edt = getOffTimerBasedReservationSetting();
			addProperty(EPC_OFF_TIMER_BASED_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSettingTime() {
			byte[] edt = getOffTimerSettingTime();
			addProperty(EPC_OFF_TIMER_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfOffTimerRelativeTime() {
			byte[] edt = getSetValueOfOffTimerRelativeTime();
			addProperty(EPC_SET_VALUE_OF_OFF_TIMER_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
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
