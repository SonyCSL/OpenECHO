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
	@SuppressWarnings("unused")
	private static final String TAG = CookingHeater.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xB9;

	protected static final byte EPC_HEATING_STATUS = (byte)0xB1;
	protected static final byte EPC_HEATING_SETTING = (byte)0xB2;
	protected static final byte EPC_GALL_STOP_H_SETTING = (byte)0xB3;
	protected static final byte EPC_HEATING_POWER_SETTING = (byte)0xE7;
	protected static final byte EPC_HEATING_TEMPERATURE_SETTING = (byte)0xE3;
	protected static final byte EPC_GHEATING_MODES_OF_STOVES_H_SETTING = (byte)0xE0;
	protected static final byte EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS = (byte)0x96;
	protected static final byte EPC_CHILD_LOCK_SETTING = (byte)0xA1;
	protected static final byte EPC_RADIANT_HEATER_LOCK_SETTING = (byte)0xA2;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br>Standing by: 0x40 Operating: 0x41 Temporarily stopped: 0x42 Heating prohibited: 0x50 Unknown: 0xFF<br><br>Data type : unsigned char x 4<br>Data size : 1 byte x 4<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getHeatingStatus();
	/**
	 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatingSetting(byte[] edt) {return false;}
	/**
	 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatingSetting() {return null;}
	/**
	 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br>Stop the heating on all of the left stove, right stove, far-side stove and roaster: 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : undefined
	 */
	protected abstract boolean setGallStopHSetting(byte[] edt);
	/**
	 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Data type : unsigned char x 4<br>Data size : 2 byte x 4<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatingPowerSetting(byte[] edt) {return false;}
	/**
	 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Data type : unsigned char x 4<br>Data size : 2 byte x 4<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatingPowerSetting() {return null;}
	/**
	 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
	 */
	protected boolean setHeatingTemperatureSetting(byte[] edt) {return false;}
	/**
	 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
	 */
	protected byte[] getHeatingTemperatureSetting() {return null;}
	/**
	 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
	 */
	protected boolean setGheatingModesOfStovesHSetting(byte[] edt) {return false;}
	/**
	 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGheatingModesOfStovesHSetting() {return null;}
	/**
	 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Data type : unsigned char x 3 x 4<br>Data size : 1 byte x 3 x 4<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeTimeSettingsOfOffTimers(byte[] edt) {return false;}
	/**
	 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Data type : unsigned char x 3 x 4<br>Data size : 1 byte x 3 x 4<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeTimeSettingsOfOffTimers() {return null;}
	/**
	 * Child lock ON/OFF setting<br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setChildLockSetting(byte[] edt) {return false;}
	/**
	 * Child lock ON/OFF setting<br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getChildLockSetting() {return null;}
	/**
	 * Radiant heater lock ON/OFF<br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRadiantHeaterLockSetting(byte[] edt) {return false;}
	/**
	 * Radiant heater lock ON/OFF<br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRadiantHeaterLockSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_HEATING_SETTING:
			res.addProperty(epc, edt, setHeatingSetting(edt));
			break;
		case EPC_GALL_STOP_H_SETTING:
			res.addProperty(epc, edt, setGallStopHSetting(edt));
			break;
		case EPC_HEATING_POWER_SETTING:
			res.addProperty(epc, edt, setHeatingPowerSetting(edt));
			break;
		case EPC_HEATING_TEMPERATURE_SETTING:
			res.addProperty(epc, edt, setHeatingTemperatureSetting(edt));
			break;
		case EPC_GHEATING_MODES_OF_STOVES_H_SETTING:
			res.addProperty(epc, edt, setGheatingModesOfStovesHSetting(edt));
			break;
		case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS:
			res.addProperty(epc, edt, setRelativeTimeSettingsOfOffTimers(edt));
			break;
		case EPC_CHILD_LOCK_SETTING:
			res.addProperty(epc, edt, setChildLockSetting(edt));
			break;
		case EPC_RADIANT_HEATER_LOCK_SETTING:
			res.addProperty(epc, edt, setRadiantHeaterLockSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_HEATING_STATUS:
			edt = getHeatingStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_SETTING:
			edt = getHeatingSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HEATING_POWER_SETTING:
			edt = getHeatingPowerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_HEATING_TEMPERATURE_SETTING:
			edt = getHeatingTemperatureSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GHEATING_MODES_OF_STOVES_H_SETTING:
			edt = getGheatingModesOfStovesHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS:
			edt = getRelativeTimeSettingsOfOffTimers();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CHILD_LOCK_SETTING:
			edt = getChildLockSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RADIANT_HEATER_LOCK_SETTING:
			edt = getRadiantHeaterLockSetting();
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
			case EPC_HEATING_SETTING:
				onSetHeatingSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GALL_STOP_H_SETTING:
				onSetGallStopHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_HEATING_POWER_SETTING:
				onSetHeatingPowerSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_HEATING_TEMPERATURE_SETTING:
				onSetHeatingTemperatureSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GHEATING_MODES_OF_STOVES_H_SETTING:
				onSetGheatingModesOfStovesHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS:
				onSetRelativeTimeSettingsOfOffTimers(eoj, tid, (pdc != 0));
				break;
			case EPC_CHILD_LOCK_SETTING:
				onSetChildLockSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_RADIANT_HEATER_LOCK_SETTING:
				onSetRadiantHeaterLockSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_HEATING_STATUS:
				onGetHeatingStatus(eoj, tid, pdc, edt);
				break;
			case EPC_HEATING_SETTING:
				onGetHeatingSetting(eoj, tid, pdc, edt);
				break;
			case EPC_HEATING_POWER_SETTING:
				onGetHeatingPowerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_HEATING_TEMPERATURE_SETTING:
				onGetHeatingTemperatureSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GHEATING_MODES_OF_STOVES_H_SETTING:
				onGetGheatingModesOfStovesHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS:
				onGetRelativeTimeSettingsOfOffTimers(eoj, tid, pdc, edt);
				break;
			case EPC_CHILD_LOCK_SETTING:
				onGetChildLockSetting(eoj, tid, pdc, edt);
				break;
			case EPC_RADIANT_HEATER_LOCK_SETTING:
				onGetRadiantHeaterLockSetting(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br>Standing by: 0x40 Operating: 0x41 Temporarily stopped: 0x42 Heating prohibited: 0x50 Unknown: 0xFF<br><br>Data type : unsigned char x 4<br>Data size : 1 byte x 4<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetHeatingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatingSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatingSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br>Stop the heating on all of the left stove, right stove, far-side stove and roaster: 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : undefined
		 */
		protected void onSetGallStopHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Data type : unsigned char x 4<br>Data size : 2 byte x 4<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatingPowerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Data type : unsigned char x 4<br>Data size : 2 byte x 4<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatingPowerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		protected void onSetHeatingTemperatureSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		protected void onGetHeatingTemperatureSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		protected void onSetGheatingModesOfStovesHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		protected void onGetGheatingModesOfStovesHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Data type : unsigned char x 3 x 4<br>Data size : 1 byte x 3 x 4<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeTimeSettingsOfOffTimers(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Data type : unsigned char x 3 x 4<br>Data size : 1 byte x 3 x 4<br>Set : optional<br>Get : optional
		 */
		protected void onGetRelativeTimeSettingsOfOffTimers(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Child lock ON/OFF setting<br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetChildLockSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Child lock ON/OFF setting<br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetChildLockSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Radiant heater lock ON/OFF<br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRadiantHeaterLockSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Radiant heater lock ON/OFF<br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRadiantHeaterLockSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetHeatingSetting(byte[] edt);
		/**
		 * Used to stop the heating on all of the left stove, right stove, far-side stove and roaster.<br>Stop the heating on all of the left stove, right stove, far-side stove and roaster: 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : undefined
		 */
		public Setter reqSetGallStopHSetting(byte[] edt);
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Data type : unsigned char x 4<br>Data size : 2 byte x 4<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetHeatingPowerSetting(byte[] edt);
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetHeatingTemperatureSetting(byte[] edt);
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGheatingModesOfStovesHSetting(byte[] edt);
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Data type : unsigned char x 3 x 4<br>Data size : 1 byte x 3 x 4<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRelativeTimeSettingsOfOffTimers(byte[] edt);
		/**
		 * Child lock ON/OFF setting<br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetChildLockSetting(byte[] edt);
		/**
		 * Radiant heater lock ON/OFF<br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRadiantHeaterLockSetting(byte[] edt);
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
		public Setter reqSetHeatingSetting(byte[] edt) {
			addProperty(EPC_HEATING_SETTING, edt, setHeatingSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGallStopHSetting(byte[] edt) {
			addProperty(EPC_GALL_STOP_H_SETTING, edt, setGallStopHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetHeatingPowerSetting(byte[] edt) {
			addProperty(EPC_HEATING_POWER_SETTING, edt, setHeatingPowerSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetHeatingTemperatureSetting(byte[] edt) {
			addProperty(EPC_HEATING_TEMPERATURE_SETTING, edt, setHeatingTemperatureSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGheatingModesOfStovesHSetting(byte[] edt) {
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING, edt, setGheatingModesOfStovesHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeTimeSettingsOfOffTimers(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS, edt, setRelativeTimeSettingsOfOffTimers(edt));
			return this;
		}
		@Override
		public Setter reqSetChildLockSetting(byte[] edt) {
			addProperty(EPC_CHILD_LOCK_SETTING, edt, setChildLockSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetRadiantHeaterLockSetting(byte[] edt) {
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING, edt, setRadiantHeaterLockSetting(edt));
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
		public Setter reqSetHeatingSetting(byte[] edt) {
			addProperty(EPC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGallStopHSetting(byte[] edt) {
			addProperty(EPC_GALL_STOP_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHeatingPowerSetting(byte[] edt) {
			addProperty(EPC_HEATING_POWER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetHeatingTemperatureSetting(byte[] edt) {
			addProperty(EPC_HEATING_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGheatingModesOfStovesHSetting(byte[] edt) {
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRelativeTimeSettingsOfOffTimers(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetChildLockSetting(byte[] edt) {
			addProperty(EPC_CHILD_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRadiantHeaterLockSetting(byte[] edt) {
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br>Standing by: 0x40 Operating: 0x41 Temporarily stopped: 0x42 Heating prohibited: 0x50 Unknown: 0xFF<br><br>Data type : unsigned char x 4<br>Data size : 1 byte x 4<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetHeatingStatus();
		/**
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetHeatingSetting();
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Data type : unsigned char x 4<br>Data size : 2 byte x 4<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetHeatingPowerSetting();
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetHeatingTemperatureSetting();
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGheatingModesOfStovesHSetting();
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Data type : unsigned char x 3 x 4<br>Data size : 1 byte x 3 x 4<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRelativeTimeSettingsOfOffTimers();
		/**
		 * Child lock ON/OFF setting<br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetChildLockSetting();
		/**
		 * Radiant heater lock ON/OFF<br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRadiantHeaterLockSetting();
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
		public Getter reqGetHeatingStatus() {
			byte[] edt = getHeatingStatus();
			addProperty(EPC_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatingSetting() {
			byte[] edt = getHeatingSetting();
			addProperty(EPC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHeatingPowerSetting() {
			byte[] edt = getHeatingPowerSetting();
			addProperty(EPC_HEATING_POWER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetHeatingTemperatureSetting() {
			byte[] edt = getHeatingTemperatureSetting();
			addProperty(EPC_HEATING_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGheatingModesOfStovesHSetting() {
			byte[] edt = getGheatingModesOfStovesHSetting();
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRelativeTimeSettingsOfOffTimers() {
			byte[] edt = getRelativeTimeSettingsOfOffTimers();
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetChildLockSetting() {
			byte[] edt = getChildLockSetting();
			addProperty(EPC_CHILD_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRadiantHeaterLockSetting() {
			byte[] edt = getRadiantHeaterLockSetting();
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetHeatingStatus() {
			addProperty(EPC_HEATING_STATUS);
			return this;
		}
		@Override
		public Getter reqGetHeatingSetting() {
			addProperty(EPC_HEATING_SETTING);
			return this;
		}
		@Override
		public Getter reqGetHeatingPowerSetting() {
			addProperty(EPC_HEATING_POWER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetHeatingTemperatureSetting() {
			addProperty(EPC_HEATING_TEMPERATURE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGheatingModesOfStovesHSetting() {
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRelativeTimeSettingsOfOffTimers() {
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS);
			return this;
		}
		@Override
		public Getter reqGetChildLockSetting() {
			addProperty(EPC_CHILD_LOCK_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRadiantHeaterLockSetting() {
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING);
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
		 * Heating status of the left stove: heating status of the right stove: heating status of the far-side stove: heating status of the roaster.<br>Standing by: 0x40 Operating: 0x41 Temporarily stopped: 0x42 Heating prohibited: 0x50 Unknown: 0xFF<br><br>Data type : unsigned char x 4<br>Data size : 1 byte x 4<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformHeatingStatus();
		/**
		 * Left stove setting: right stove setting: far-side stove setting: roaster setting<br>Stop heating: 0x40 Start/resume heating: 0x41 Temporarily stop heating: 0x42 No setting: 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformHeatingSetting();
		/**
		 * Heating power of the left stove: heating power of the right stove: heating power of the far-side stove: heating power of the roaster<br> EWhen the heating powers are specified in terms of output wattage (0 to 10000W) : 0x0000 to 0x2710  EWhen the heating powers are specified in terms of level (17 levels)                : 0x3000 to 0x3010  EWhen the heating powers are specified in terms of the state of flame: Very low flame: 0x4002 Low flame: 0x4004 Medium flame: 0x4006 High flame: 0x4008 High power: 0x400a  ENo setting: 0xFFFF<br><br>Data type : unsigned char x 4<br>Data size : 2 byte x 4<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformHeatingPowerSetting();
		/**
		 * Left stove temperature setting: right stove temperature setting: far-side stove temperature setting<br>Temperature setting: 0x32 to 0xFA (50 to 250  ) No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformHeatingTemperatureSetting();
		/**
		 * Heating mode of the left stove: heating mode of the right stove: heating mode of the far-side stove<br>Heating power control mode: 0x41 Deep-frying mode (tempura, etc.): 0x42 Water heating mode: 0x43 Rice boiling mode: 0x44 Stir-frying mode: 0x45 No setting: 0xFF<br><br>Data type : unsigned char x 3<br>Data size : 1 byte x 3<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGheatingModesOfStovesHSetting();
		/**
		 * Relative time setting of the left stove OFF timer: relative time setting of the right stove OFF timer: relative time setting of the far-side stove OFF timer: relative time setting of the roaster OFF timer<br>Used to set the relative time settings of the OFF timers (in the HH:MM:SS format), activate the relevant timers and acquire the updated current relative time settings of the OFF timers. (0 to 0x17 : 0 to 0x3B: 0 to 0x3B)  ~ 4 (= 0 to 23) : (= 0 to 59): (= 0 to 59) No setting: 0xFFFFFF<br><br>Data type : unsigned char x 3 x 4<br>Data size : 1 byte x 3 x 4<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRelativeTimeSettingsOfOffTimers();
		/**
		 * Child lock ON/OFF setting<br>Child lock OFF: 0x40 Child lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformChildLockSetting();
		/**
		 * Radiant heater lock ON/OFF<br>Radiant heater lock OFF: 0x40 Radiant heater lock ON: 0x41<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRadiantHeaterLockSetting();
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
		public Informer reqInformHeatingStatus() {
			byte[] edt = getHeatingStatus();
			addProperty(EPC_HEATING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatingSetting() {
			byte[] edt = getHeatingSetting();
			addProperty(EPC_HEATING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHeatingPowerSetting() {
			byte[] edt = getHeatingPowerSetting();
			addProperty(EPC_HEATING_POWER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformHeatingTemperatureSetting() {
			byte[] edt = getHeatingTemperatureSetting();
			addProperty(EPC_HEATING_TEMPERATURE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGheatingModesOfStovesHSetting() {
			byte[] edt = getGheatingModesOfStovesHSetting();
			addProperty(EPC_GHEATING_MODES_OF_STOVES_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRelativeTimeSettingsOfOffTimers() {
			byte[] edt = getRelativeTimeSettingsOfOffTimers();
			addProperty(EPC_RELATIVE_TIME_SETTINGS_OF_OFF_TIMERS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformChildLockSetting() {
			byte[] edt = getChildLockSetting();
			addProperty(EPC_CHILD_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRadiantHeaterLockSetting() {
			byte[] edt = getRadiantHeaterLockSetting();
			addProperty(EPC_RADIANT_HEATER_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
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
