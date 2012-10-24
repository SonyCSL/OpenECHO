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
package com.sonycsl.echo.eoj.device.cookinghousehold;

import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class CookingHeater extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xB9;

	public static final byte EPC_HEATING_STATUS = (byte)0xB1;
	public static final byte EPC_HEATING_SETTING = (byte)0xB2;
	public static final byte EPC_GALL_STOP_H_SETTING = (byte)0xB3;
	public static final byte EPC_HEATING_POWER_SETTING = (byte)0xE7;
	public static final byte EPC_HEATING_TEMPERATURE_SETTING = (byte)0xE3;
	public static final byte EPC_GHEATING_MODES_OF_STOVES_H_SETTING = (byte)0xE0;
	public static final byte EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS = (byte)0x96;
	public static final byte EPC_CHILD_LOCK_SETTING = (byte)0xA1;
	public static final byte EPC_RADIANT_HEATER_LOCK_SETTING = (byte)0xA2;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br><br>Standing by: 0x40 Operating: 0x41 Temporarily stopped: 0x42 Heating prohibited: 0x50 Unknown: 0xFF<br><br>Name : Heating status<br>EPC : 0xB1<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 1 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getHeatingStatus();
	private final byte[] _getHeatingStatus(byte epc) {
		byte[] edt = getHeatingStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br><br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHeatingSetting(byte[] edt) {return false;}
	private final boolean _setHeatingSetting(byte epc, byte[] edt) {
		boolean success = setHeatingSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br><br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHeatingSetting() {return null;}
	private final byte[] _getHeatingSetting(byte epc) {
		byte[] edt = getHeatingSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br><br>Stop the heating on all of the left stove, right stove, far-side stove and roaster: 0x40<br><br>Name :  gAll stop h setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : undefined<br>
	 */
	protected abstract boolean setGallStopHSetting(byte[] edt);
	private final boolean _setGallStopHSetting(byte epc, byte[] edt) {
		boolean success = setGallStopHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br><br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Name : Heating power setting<br>EPC : 0xE7<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 2 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHeatingPowerSetting(byte[] edt) {return false;}
	private final boolean _setHeatingPowerSetting(byte epc, byte[] edt) {
		boolean success = setHeatingPowerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br><br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Name : Heating power setting<br>EPC : 0xE7<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 2 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHeatingPowerSetting() {return null;}
	private final byte[] _getHeatingPowerSetting(byte epc) {
		byte[] edt = getHeatingPowerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br><br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Name : Heating temperature setting<br>EPC : 0xE3<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setHeatingTemperatureSetting(byte[] edt) {return false;}
	private final boolean _setHeatingTemperatureSetting(byte epc, byte[] edt) {
		boolean success = setHeatingTemperatureSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br><br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Name : Heating temperature setting<br>EPC : 0xE3<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getHeatingTemperatureSetting() {return null;}
	private final byte[] _getHeatingTemperatureSetting(byte epc) {
		byte[] edt = getHeatingTemperatureSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br><br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Name :  gHeating modes of stoves h setting<br>EPC : 0xE0<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGheatingModesOfStovesHSetting(byte[] edt) {return false;}
	private final boolean _setGheatingModesOfStovesHSetting(byte epc, byte[] edt) {
		boolean success = setGheatingModesOfStovesHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br><br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Name :  gHeating modes of stoves h setting<br>EPC : 0xE0<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGheatingModesOfStovesHSetting() {return null;}
	private final byte[] _getGheatingModesOfStovesHSetting(byte epc) {
		byte[] edt = getGheatingModesOfStovesHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br><br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Name : Relative time settings of OFF timers<br>EPC : 0x96<br>Data Type : unsigned char x 3 x 4<br>Data Size(Byte) : 1 byte x 3 x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRelativeTimeSettingsOfOffTimers(byte[] edt) {return false;}
	private final boolean _setRelativeTimeSettingsOfOffTimers(byte epc, byte[] edt) {
		boolean success = setRelativeTimeSettingsOfOffTimers(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br><br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Name : Relative time settings of OFF timers<br>EPC : 0x96<br>Data Type : unsigned char x 3 x 4<br>Data Size(Byte) : 1 byte x 3 x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRelativeTimeSettingsOfOffTimers() {return null;}
	private final byte[] _getRelativeTimeSettingsOfOffTimers(byte epc) {
		byte[] edt = getRelativeTimeSettingsOfOffTimers();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Child lock ON/OFF setting<br><br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Name : Child lock setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setChildLockSetting(byte[] edt) {return false;}
	private final boolean _setChildLockSetting(byte epc, byte[] edt) {
		boolean success = setChildLockSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Child lock ON/OFF setting<br><br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Name : Child lock setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getChildLockSetting() {return null;}
	private final byte[] _getChildLockSetting(byte epc) {
		byte[] edt = getChildLockSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Radiant heater lock ON/OFF<br><br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Name : Radiant heater lock setting<br>EPC : 0xA2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRadiantHeaterLockSetting(byte[] edt) {return false;}
	private final boolean _setRadiantHeaterLockSetting(byte epc, byte[] edt) {
		boolean success = setRadiantHeaterLockSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Radiant heater lock ON/OFF<br><br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Name : Radiant heater lock setting<br>EPC : 0xA2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRadiantHeaterLockSetting() {return null;}
	private final byte[] _getRadiantHeaterLockSetting(byte epc) {
		byte[] edt = getRadiantHeaterLockSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_HEATING_SETTING:
			res.addProperty(epc, edt, _setHeatingSetting(epc, edt));
			break;
		case EPC_GALL_STOP_H_SETTING:
			res.addProperty(epc, edt, _setGallStopHSetting(epc, edt));
			break;
		case EPC_HEATING_POWER_SETTING:
			res.addProperty(epc, edt, _setHeatingPowerSetting(epc, edt));
			break;
		case EPC_HEATING_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, _setHeatingTemperatureSetting(epc, edt));
			break;
		case EPC_GHEATING_MODES_OF_STOVES_H_SETTING:
			res.addProperty(epc, edt, _setGheatingModesOfStovesHSetting(epc, edt));
			break;
		case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS:
			res.addProperty(epc, edt, _setRelativeTimeSettingsOfOffTimers(epc, edt));
			break;
		case EPC_CHILD_LOCK_SETTING:
			res.addProperty(epc, edt, _setChildLockSetting(epc, edt));
			break;
		case EPC_RADIANT_HEATER_LOCK_SETTING:
			res.addProperty(epc, edt, _setRadiantHeaterLockSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_HEATING_STATUS:
			edt = _getHeatingStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_SETTING:
			edt = _getHeatingSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_POWER_SETTING:
			edt = _getHeatingPowerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_HEATING_TEMPERATURE_SETTING:
			edt = _getHeatingTemperatureSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GHEATING_MODES_OF_STOVES_H_SETTING:
			edt = _getGheatingModesOfStovesHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS:
			edt = _getRelativeTimeSettingsOfOffTimers(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CHILD_LOCK_SETTING:
			edt = _getChildLockSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RADIANT_HEATER_LOCK_SETTING:
			edt = _getRadiantHeaterLockSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;

		}
	}
	
	@Override
	public Setter set() {
		return new Setter(ESV_SETI);
	}

	@Override
	public Setter setC() {
		return new Setter(ESV_SETC);
	}

	@Override
	public Getter get() {
		return new Getter();
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
			case EPC_HEATING_SETTING:
				_onSetHeatingSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GALL_STOP_H_SETTING:
				_onSetGallStopHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_HEATING_POWER_SETTING:
				_onSetHeatingPowerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_HEATING_TEMPERATURE_SETTING:
				_onSetHeatingTemperatureSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GHEATING_MODES_OF_STOVES_H_SETTING:
				_onSetGheatingModesOfStovesHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS:
				_onSetRelativeTimeSettingsOfOffTimers(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_CHILD_LOCK_SETTING:
				_onSetChildLockSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_RADIANT_HEATER_LOCK_SETTING:
				_onSetRadiantHeaterLockSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_HEATING_STATUS:
				_onGetHeatingStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATING_SETTING:
				_onGetHeatingSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATING_POWER_SETTING:
				_onGetHeatingPowerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HEATING_TEMPERATURE_SETTING:
				_onGetHeatingTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GHEATING_MODES_OF_STOVES_H_SETTING:
				_onGetGheatingModesOfStovesHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS:
				_onGetRelativeTimeSettingsOfOffTimers(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CHILD_LOCK_SETTING:
				_onGetChildLockSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RADIANT_HEATER_LOCK_SETTING:
				_onGetRadiantHeaterLockSetting(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br><br>Standing by: 0x40 Operating: 0x41 Temporarily stopped: 0x42 Heating prohibited: 0x50 Unknown: 0xFF<br><br>Name : Heating status<br>EPC : 0xB1<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 1 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br><br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeatingSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br><br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br><br>Stop the heating on all of the left stove, right stove, far-side stove and roaster: 0x40<br><br>Name :  gAll stop h setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : undefined<br>
		 */
		protected void onSetGallStopHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGallStopHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGallStopHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br><br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Name : Heating power setting<br>EPC : 0xE7<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 2 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHeatingPowerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeatingPowerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeatingPowerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br><br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Name : Heating power setting<br>EPC : 0xE7<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 2 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHeatingPowerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingPowerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingPowerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br><br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Name : Heating temperature setting<br>EPC : 0xE3<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHeatingTemperatureSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br><br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Name : Heating temperature setting<br>EPC : 0xE3<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHeatingTemperatureSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHeatingTemperatureSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br><br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Name :  gHeating modes of stoves h setting<br>EPC : 0xE0<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGheatingModesOfStovesHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGheatingModesOfStovesHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGheatingModesOfStovesHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br><br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Name :  gHeating modes of stoves h setting<br>EPC : 0xE0<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGheatingModesOfStovesHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGheatingModesOfStovesHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGheatingModesOfStovesHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br><br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Name : Relative time settings of OFF timers<br>EPC : 0x96<br>Data Type : unsigned char x 3 x 4<br>Data Size(Byte) : 1 byte x 3 x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRelativeTimeSettingsOfOffTimers(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeTimeSettingsOfOffTimers(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeTimeSettingsOfOffTimers(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br><br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Name : Relative time settings of OFF timers<br>EPC : 0x96<br>Data Type : unsigned char x 3 x 4<br>Data Size(Byte) : 1 byte x 3 x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRelativeTimeSettingsOfOffTimers(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeTimeSettingsOfOffTimers(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeTimeSettingsOfOffTimers(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Child lock ON/OFF setting<br><br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Name : Child lock setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetChildLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetChildLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetChildLockSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Child lock ON/OFF setting<br><br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Name : Child lock setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetChildLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetChildLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetChildLockSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Radiant heater lock ON/OFF<br><br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Name : Radiant heater lock setting<br>EPC : 0xA2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRadiantHeaterLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRadiantHeaterLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRadiantHeaterLockSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Radiant heater lock ON/OFF<br><br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Name : Radiant heater lock setting<br>EPC : 0xA2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRadiantHeaterLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRadiantHeaterLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRadiantHeaterLockSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}

	}
	
	public class Setter extends DeviceObject.Setter {
		public Setter(byte esv) {
			super(esv);
		}

		@Override
		public Setter reqSet(byte epc, byte[] edt) {
			return (Setter)super.reqSet(epc, edt);
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

		/**
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br><br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHeatingSetting(byte[] edt) {
			addProperty(EPC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br><br>Stop the heating on all of the left stove, right stove, far-side stove and roaster: 0x40<br><br>Name :  gAll stop h setting<br>EPC : 0xB3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : undefined<br>
		 */
		public Setter reqSetGallStopHSetting(byte[] edt) {
			addProperty(EPC_GALL_STOP_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br><br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Name : Heating power setting<br>EPC : 0xE7<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 2 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHeatingPowerSetting(byte[] edt) {
			addProperty(EPC_HEATING_POWER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br><br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Name : Heating temperature setting<br>EPC : 0xE3<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetHeatingTemperatureSetting(byte[] edt) {
			addProperty(EPC_HEATING_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br><br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Name :  gHeating modes of stoves h setting<br>EPC : 0xE0<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGheatingModesOfStovesHSetting(byte[] edt) {
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br><br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Name : Relative time settings of OFF timers<br>EPC : 0x96<br>Data Type : unsigned char x 3 x 4<br>Data Size(Byte) : 1 byte x 3 x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRelativeTimeSettingsOfOffTimers(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Child lock ON/OFF setting<br><br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Name : Child lock setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetChildLockSetting(byte[] edt) {
			addProperty(EPC_CHILD_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Radiant heater lock ON/OFF<br><br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Name : Radiant heater lock setting<br>EPC : 0xA2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRadiantHeaterLockSetting(byte[] edt) {
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
	}

	public class Getter extends DeviceObject.Getter {

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
		
		/**
		 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br><br>Standing by: 0x40 Operating: 0x41 Temporarily stopped: 0x42 Heating prohibited: 0x50 Unknown: 0xFF<br><br>Name : Heating status<br>EPC : 0xB1<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 1 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		/**
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br><br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHeatingSetting() {
			addProperty(EPC_HEATING_SETTING);
			return this;
		}
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br><br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Name : Heating power setting<br>EPC : 0xE7<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 2 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHeatingPowerSetting() {
			addProperty(EPC_HEATING_POWER_SETTING);
			return this;
		}
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br><br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Name : Heating temperature setting<br>EPC : 0xE3<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetHeatingTemperatureSetting() {
			addProperty(EPC_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br><br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Name :  gHeating modes of stoves h setting<br>EPC : 0xE0<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGheatingModesOfStovesHSetting() {
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING);
			return this;
		}
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br><br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Name : Relative time settings of OFF timers<br>EPC : 0x96<br>Data Type : unsigned char x 3 x 4<br>Data Size(Byte) : 1 byte x 3 x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRelativeTimeSettingsOfOffTimers() {
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS);
			return this;
		}
		/**
		 * Child lock ON/OFF setting<br><br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Name : Child lock setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetChildLockSetting() {
			addProperty(EPC_CHILD_LOCK_SETTING);
			return this;
		}
		/**
		 * Radiant heater lock ON/OFF<br><br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Name : Radiant heater lock setting<br>EPC : 0xA2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRadiantHeaterLockSetting() {
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING);
			return this;
		}
	}
	
	public interface Informer extends DeviceObject.Informer {
		public Informer reqInform(byte epc);
		
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
		 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br><br>Standing by: 0x40 Operating: 0x41 Temporarily stopped: 0x42 Heating prohibited: 0x50 Unknown: 0xFF<br><br>Name : Heating status<br>EPC : 0xB1<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 1 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformHeatingStatus();
		/**
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br><br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Name : Heating setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHeatingSetting();
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br><br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Name : Heating power setting<br>EPC : 0xE7<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 2 byte x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHeatingPowerSetting();
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br><br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Name : Heating temperature setting<br>EPC : 0xE3<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformHeatingTemperatureSetting();
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br><br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Name :  gHeating modes of stoves h setting<br>EPC : 0xE0<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 1 byte x 3<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGheatingModesOfStovesHSetting();
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br><br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Name : Relative time settings of OFF timers<br>EPC : 0x96<br>Data Type : unsigned char x 3 x 4<br>Data Size(Byte) : 1 byte x 3 x 4<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRelativeTimeSettingsOfOffTimers();
		/**
		 * Child lock ON/OFF setting<br><br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Name : Child lock setting<br>EPC : 0xA1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformChildLockSetting();
		/**
		 * Radiant heater lock ON/OFF<br><br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Name : Radiant heater lock setting<br>EPC : 0xA2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRadiantHeaterLockSetting();
	}

	public class InformerImpl extends DeviceObject.InformerImpl implements Informer {
		@Override
		public Informer reqInform(byte epc) {
			return (Informer)super.reqInform(epc);
		}
		
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
		public Informer reqInformHeatingStatus() {
			byte epc = EPC_HEATING_STATUS;
			byte[] edt = _getHeatingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatingSetting() {
			byte epc = EPC_HEATING_SETTING;
			byte[] edt = _getHeatingSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatingPowerSetting() {
			byte epc = EPC_HEATING_POWER_SETTING;
			byte[] edt = _getHeatingPowerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformHeatingTemperatureSetting() {
			byte epc = EPC_HEATING_TEMPERATURE_SETTING;
			byte[] edt = _getHeatingTemperatureSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGheatingModesOfStovesHSetting() {
			byte epc = EPC_GHEATING_MODES_OF_STOVES_H_SETTING;
			byte[] edt = _getGheatingModesOfStovesHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRelativeTimeSettingsOfOffTimers() {
			byte epc = EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS;
			byte[] edt = _getRelativeTimeSettingsOfOffTimers(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformChildLockSetting() {
			byte epc = EPC_CHILD_LOCK_SETTING;
			byte[] edt = _getChildLockSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRadiantHeaterLockSetting() {
			byte epc = EPC_RADIANT_HEATER_LOCK_SETTING;
			byte[] edt = _getRadiantHeaterLockSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
	}
	
	public class InformerProxy extends DeviceObject.InformerProxy implements Informer {
		@Override
		public Informer reqInform(byte epc) {
			return (Informer)super.reqInform(epc);
		}
		
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
		public Informer reqInformHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		@Override
		public Informer reqInformHeatingSetting() {
			addProperty(EPC_HEATING_SETTING);
			return this;
		}
		@Override
		public Informer reqInformHeatingPowerSetting() {
			addProperty(EPC_HEATING_POWER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformHeatingTemperatureSetting() {
			addProperty(EPC_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGheatingModesOfStovesHSetting() {
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRelativeTimeSettingsOfOffTimers() {
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS);
			return this;
		}
		@Override
		public Informer reqInformChildLockSetting() {
			addProperty(EPC_CHILD_LOCK_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRadiantHeaterLockSetting() {
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING);
			return this;
		}
	}
}
