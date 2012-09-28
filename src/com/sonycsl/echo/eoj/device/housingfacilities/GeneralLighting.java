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

public abstract class GeneralLighting extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = GeneralLighting.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x90;

	protected static final byte EPC_ILLUMINANCE_LEVEL = (byte)0xB0;
	protected static final byte EPC_ILLUMINANCE_LEVEL_STEP_SETTING = (byte)0xB2;
	protected static final byte EPC_LIGHT_COLOR_STEP_SETTING = (byte)0xB3;
	protected static final byte EPC_MAXIMUM_SPECIFIABLE_VALUES = (byte)0xB4;
	protected static final byte EPC_LIGHT_COLOR_SETTING = (byte)0xB1;
	protected static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	protected static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	protected static final byte EPC_OFF_TIMER_SETTING = (byte)0x95;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates illuminance level in %.<br>0x00.0x64 (0.100%)
	 */
	protected boolean setIlluminanceLevel(byte[] edt) {return false;}
	/**
	 * This property indicates illuminance level in %.<br>0x00.0x64 (0.100%)
	 */
	protected byte[] getIlluminanceLevel() {return null;}
	/**
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)
	 */
	protected boolean setIlluminanceLevelStepSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)
	 */
	protected byte[] getIlluminanceLevelStepSetting() {return null;}
	/**
	 * Used to specify the light color in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)
	 */
	protected boolean setLightColorStepSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the light color in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)
	 */
	protected byte[] getLightColorStepSetting() {return null;}
	/**
	 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br>First byte: illuminance Second byte: light color 0x01-0xFF(Step 1 -Step 255) 0x00(when the function is not implemented)
	 */
	protected byte[] getMaximumSpecifiableValues() {return null;}
	/**
	 * Used to specify the light color.<br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44
	 */
	protected boolean setLightColorSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the light color.<br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44
	 */
	protected byte[] getLightColorSetting() {return null;}
	/**
	 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
	 */
	protected boolean setOffTimerSetting(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
	 */
	protected byte[] getOffTimerSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_ILLUMINANCE_LEVEL:
			res.addProperty(epc, edt, setIlluminanceLevel(edt));
			break;
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING:
			res.addProperty(epc, edt, setIlluminanceLevelStepSetting(edt));
			break;
		case EPC_LIGHT_COLOR_STEP_SETTING:
			res.addProperty(epc, edt, setLightColorStepSetting(edt));
			break;
		case EPC_LIGHT_COLOR_SETTING:
			res.addProperty(epc, edt, setLightColorSetting(edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOnTimerReservationSetting(edt));
			break;
		case EPC_ON_TIMER_SETTING:
			res.addProperty(epc, edt, setOnTimerSetting(edt));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOffTimerReservationSetting(edt));
			break;
		case EPC_OFF_TIMER_SETTING:
			res.addProperty(epc, edt, setOffTimerSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_ILLUMINANCE_LEVEL:
			edt = getIlluminanceLevel();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING:
			edt = getIlluminanceLevelStepSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_LIGHT_COLOR_STEP_SETTING:
			edt = getLightColorStepSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MAXIMUM_SPECIFIABLE_VALUES:
			edt = getMaximumSpecifiableValues();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_LIGHT_COLOR_SETTING:
			edt = getLightColorSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = getOnTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING:
			edt = getOnTimerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			edt = getOffTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING:
			edt = getOffTimerSetting();
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
			case EPC_ILLUMINANCE_LEVEL:
				onSetIlluminanceLevel(eoj, tid, (pdc != 0));
				break;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING:
				onSetIlluminanceLevelStepSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_LIGHT_COLOR_STEP_SETTING:
				onSetLightColorStepSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_LIGHT_COLOR_SETTING:
				onSetLightColorSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onSetOnTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING:
				onSetOnTimerSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				onSetOffTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING:
				onSetOffTimerSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_ILLUMINANCE_LEVEL:
				onGetIlluminanceLevel(eoj, tid, pdc, edt);
				break;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING:
				onGetIlluminanceLevelStepSetting(eoj, tid, pdc, edt);
				break;
			case EPC_LIGHT_COLOR_STEP_SETTING:
				onGetLightColorStepSetting(eoj, tid, pdc, edt);
				break;
			case EPC_MAXIMUM_SPECIFIABLE_VALUES:
				onGetMaximumSpecifiableValues(eoj, tid, pdc, edt);
				break;
			case EPC_LIGHT_COLOR_SETTING:
				onGetLightColorSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onGetOnTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING:
				onGetOnTimerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				onGetOffTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING:
				onGetOffTimerSetting(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates illuminance level in %.<br>0x00.0x64 (0.100%)
		 */
		protected void onSetIlluminanceLevel(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates illuminance level in %.<br>0x00.0x64 (0.100%)
		 */
		protected void onGetIlluminanceLevel(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)
		 */
		protected void onSetIlluminanceLevelStepSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)
		 */
		protected void onGetIlluminanceLevelStepSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)
		 */
		protected void onSetLightColorStepSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)
		 */
		protected void onGetLightColorStepSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br>First byte: illuminance Second byte: light color 0x01-0xFF(Step 1 -Step 255) 0x00(when the function is not implemented)
		 */
		protected void onGetMaximumSpecifiableValues(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the light color.<br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44
		 */
		protected void onSetLightColorSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the light color.<br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44
		 */
		protected void onGetLightColorSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		protected void onSetOffTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		protected void onGetOffTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * This property indicates illuminance level in %.<br>0x00.0x64 (0.100%)
		 */
		public Setter reqSetIlluminanceLevel(byte[] edt);
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)
		 */
		public Setter reqSetIlluminanceLevelStepSetting(byte[] edt);
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)
		 */
		public Setter reqSetLightColorStepSetting(byte[] edt);
		/**
		 * Used to specify the light color.<br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44
		 */
		public Setter reqSetLightColorSetting(byte[] edt);
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		public Setter reqSetOnTimerSetting(byte[] edt);
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		public Setter reqSetOffTimerSetting(byte[] edt);

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
		public Setter reqSetIlluminanceLevel(byte[] edt) {
			addProperty(EPC_ILLUMINANCE_LEVEL, edt, setIlluminanceLevel(edt));
			return this;
		}
		@Override
		public Setter reqSetIlluminanceLevelStepSetting(byte[] edt) {
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING, edt, setIlluminanceLevelStepSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetLightColorStepSetting(byte[] edt) {
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING, edt, setLightColorStepSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetLightColorSetting(byte[] edt) {
			addProperty(EPC_LIGHT_COLOR_SETTING, edt, setLightColorSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, setOnTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, setOnTimerSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, setOffTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING, edt, setOffTimerSetting(edt));
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
		public Setter reqSetIlluminanceLevel(byte[] edt) {
			addProperty(EPC_ILLUMINANCE_LEVEL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetIlluminanceLevelStepSetting(byte[] edt) {
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetLightColorStepSetting(byte[] edt) {
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetLightColorSetting(byte[] edt) {
			addProperty(EPC_LIGHT_COLOR_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates illuminance level in %.<br>0x00.0x64 (0.100%)
		 */
		public Getter reqGetIlluminanceLevel();
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)
		 */
		public Getter reqGetIlluminanceLevelStepSetting();
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)
		 */
		public Getter reqGetLightColorStepSetting();
		/**
		 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br>First byte: illuminance Second byte: light color 0x01-0xFF(Step 1 -Step 255) 0x00(when the function is not implemented)
		 */
		public Getter reqGetMaximumSpecifiableValues();
		/**
		 * Used to specify the light color.<br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44
		 */
		public Getter reqGetLightColorSetting();
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		public Getter reqGetOnTimerSetting();
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		public Getter reqGetOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		public Getter reqGetOffTimerSetting();

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
		public Getter reqGetIlluminanceLevel() {
			byte[] edt = getIlluminanceLevel();
			addProperty(EPC_ILLUMINANCE_LEVEL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetIlluminanceLevelStepSetting() {
			byte[] edt = getIlluminanceLevelStepSetting();
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetLightColorStepSetting() {
			byte[] edt = getLightColorStepSetting();
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMaximumSpecifiableValues() {
			byte[] edt = getMaximumSpecifiableValues();
			addProperty(EPC_MAXIMUM_SPECIFIABLE_VALUES, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetLightColorSetting() {
			byte[] edt = getLightColorSetting();
			addProperty(EPC_LIGHT_COLOR_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSetting() {
			byte[] edt = getOnTimerSetting();
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerReservationSetting() {
			byte[] edt = getOffTimerReservationSetting();
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerSetting() {
			byte[] edt = getOffTimerSetting();
			addProperty(EPC_OFF_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetIlluminanceLevel() {
			addProperty(EPC_ILLUMINANCE_LEVEL);
			return this;
		}
		@Override
		public Getter reqGetIlluminanceLevelStepSetting() {
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING);
			return this;
		}
		@Override
		public Getter reqGetLightColorStepSetting() {
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING);
			return this;
		}
		@Override
		public Getter reqGetMaximumSpecifiableValues() {
			addProperty(EPC_MAXIMUM_SPECIFIABLE_VALUES);
			return this;
		}
		@Override
		public Getter reqGetLightColorSetting() {
			addProperty(EPC_LIGHT_COLOR_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOffTimerSetting() {
			addProperty(EPC_OFF_TIMER_SETTING);
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
		 * This property indicates illuminance level in %.<br>0x00.0x64 (0.100%)
		 */
		public Informer reqInformIlluminanceLevel();
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)
		 */
		public Informer reqInformIlluminanceLevelStepSetting();
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)
		 */
		public Informer reqInformLightColorStepSetting();
		/**
		 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br>First byte: illuminance Second byte: light color 0x01-0xFF(Step 1 -Step 255) 0x00(when the function is not implemented)
		 */
		public Informer reqInformMaximumSpecifiableValues();
		/**
		 * Used to specify the light color.<br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44
		 */
		public Informer reqInformLightColorSetting();
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * Reservation ON/OFF<br>Reservation ON��0x41, Reservation OFF��0x42
		 */
		public Informer reqInformOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0 -0x3B (=0-23):(=0 -59)
		 */
		public Informer reqInformOffTimerSetting();

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
		public Informer reqInformIlluminanceLevel() {
			byte[] edt = getIlluminanceLevel();
			addProperty(EPC_ILLUMINANCE_LEVEL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIlluminanceLevelStepSetting() {
			byte[] edt = getIlluminanceLevelStepSetting();
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformLightColorStepSetting() {
			byte[] edt = getLightColorStepSetting();
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMaximumSpecifiableValues() {
			byte[] edt = getMaximumSpecifiableValues();
			addProperty(EPC_MAXIMUM_SPECIFIABLE_VALUES, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformLightColorSetting() {
			byte[] edt = getLightColorSetting();
			addProperty(EPC_LIGHT_COLOR_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSetting() {
			byte[] edt = getOnTimerSetting();
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerReservationSetting() {
			byte[] edt = getOffTimerReservationSetting();
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerSetting() {
			byte[] edt = getOffTimerSetting();
			addProperty(EPC_OFF_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		public Informer reqInformIlluminanceLevel() {
			addProperty(EPC_ILLUMINANCE_LEVEL);
			return this;
		}
		@Override
		public Informer reqInformIlluminanceLevelStepSetting() {
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING);
			return this;
		}
		@Override
		public Informer reqInformLightColorStepSetting() {
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING);
			return this;
		}
		@Override
		public Informer reqInformMaximumSpecifiableValues() {
			addProperty(EPC_MAXIMUM_SPECIFIABLE_VALUES);
			return this;
		}
		@Override
		public Informer reqInformLightColorSetting() {
			addProperty(EPC_LIGHT_COLOR_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOffTimerSetting() {
			addProperty(EPC_OFF_TIMER_SETTING);
			return this;
		}

	}
}
