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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x90;

	public static final byte EPC_ILLUMINANCE_LEVEL = (byte)0xB0;
	public static final byte EPC_ILLUMINANCE_LEVEL_STEP_SETTING = (byte)0xB2;
	public static final byte EPC_LIGHT_COLOR_STEP_SETTING = (byte)0xB3;
	public static final byte EPC_MAXIMUM_SPECIFIABLE_VALUES = (byte)0xB4;
	public static final byte EPC_LIGHT_COLOR_SETTING = (byte)0xB1;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	public static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_OFF_TIMER_SETTING = (byte)0x95;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates illuminance level in %.<br><br>0x00.0x64 (0.100%)<br><br>Name : Illuminance level<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setIlluminanceLevel(byte[] edt) {return false;}
	private final boolean _setIlluminanceLevel(byte epc, byte[] edt) {
		boolean success = setIlluminanceLevel(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates illuminance level in %.<br><br>0x00.0x64 (0.100%)<br><br>Name : Illuminance level<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getIlluminanceLevel() {return null;}
	private final byte[] _getIlluminanceLevel(byte epc) {
		byte[] edt = getIlluminanceLevel();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br><br>Name : Illuminance level step setting<br>EPC : 0xB2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setIlluminanceLevelStepSetting(byte[] edt) {return false;}
	private final boolean _setIlluminanceLevelStepSetting(byte epc, byte[] edt) {
		boolean success = setIlluminanceLevelStepSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br><br>Name : Illuminance level step setting<br>EPC : 0xB2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getIlluminanceLevelStepSetting() {return null;}
	private final byte[] _getIlluminanceLevelStepSetting(byte epc) {
		byte[] edt = getIlluminanceLevelStepSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the light color in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br><br>Name : Light color step setting<br>EPC : 0xB3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setLightColorStepSetting(byte[] edt) {return false;}
	private final boolean _setLightColorStepSetting(byte epc, byte[] edt) {
		boolean success = setLightColorStepSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the light color in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br><br>Name : Light color step setting<br>EPC : 0xB3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getLightColorStepSetting() {return null;}
	private final byte[] _getLightColorStepSetting(byte epc) {
		byte[] edt = getLightColorStepSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br><br>First byte: illuminance Second byte: light color 0x01-0xFF(Step 1 -Step 255) 0x00(when the function is not implemented)<br><br>Name : Maximum specifiable values<br>EPC : 0xB4<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMaximumSpecifiableValues() {return null;}
	private final byte[] _getMaximumSpecifiableValues(byte epc) {
		byte[] edt = getMaximumSpecifiableValues();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the light color.<br><br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br><br>Name : Light color setting<br>EPC : 0xB1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setLightColorSetting(byte[] edt) {return false;}
	private final boolean _setLightColorSetting(byte epc, byte[] edt) {
		boolean success = setLightColorSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the light color.<br><br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br><br>Name : Light color setting<br>EPC : 0xB1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getLightColorSetting() {return null;}
	private final byte[] _getLightColorSetting(byte epc) {
		byte[] edt = getLightColorSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerSetting() {return null;}
	private final byte[] _getOnTimerSetting(byte epc) {
		byte[] edt = getOnTimerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOffTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOffTimerReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	private final byte[] _getOffTimerReservationSetting(byte epc) {
		byte[] edt = getOffTimerReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : OFF timer setting<br>EPC : 0x95<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOffTimerSetting(byte[] edt) {return false;}
	private final boolean _setOffTimerSetting(byte epc, byte[] edt) {
		boolean success = setOffTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : OFF timer setting<br>EPC : 0x95<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOffTimerSetting() {return null;}
	private final byte[] _getOffTimerSetting(byte epc) {
		byte[] edt = getOffTimerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_ILLUMINANCE_LEVEL:
			res.addProperty(epc, edt, _setIlluminanceLevel(epc, edt));
			break;
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING:
			res.addProperty(epc, edt, _setIlluminanceLevelStepSetting(epc, edt));
			break;
		case EPC_LIGHT_COLOR_STEP_SETTING:
			res.addProperty(epc, edt, _setLightColorStepSetting(epc, edt));
			break;
		case EPC_LIGHT_COLOR_SETTING:
			res.addProperty(epc, edt, _setLightColorSetting(epc, edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING:
			res.addProperty(epc, edt, _setOnTimerSetting(epc, edt));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOffTimerReservationSetting(epc, edt));
			break;
		case EPC_OFF_TIMER_SETTING:
			res.addProperty(epc, edt, _setOffTimerSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_ILLUMINANCE_LEVEL:
			edt = _getIlluminanceLevel(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ILLUMINANCE_LEVEL_STEP_SETTING:
			edt = _getIlluminanceLevelStepSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_LIGHT_COLOR_STEP_SETTING:
			edt = _getLightColorStepSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MAXIMUM_SPECIFIABLE_VALUES:
			edt = _getMaximumSpecifiableValues(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_LIGHT_COLOR_SETTING:
			edt = _getLightColorSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = _getOnTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING:
			edt = _getOnTimerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			edt = _getOffTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OFF_TIMER_SETTING:
			edt = _getOffTimerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
			case EPC_ILLUMINANCE_LEVEL:
				_onSetIlluminanceLevel(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING:
				_onSetIlluminanceLevelStepSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_LIGHT_COLOR_STEP_SETTING:
				_onSetLightColorStepSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_LIGHT_COLOR_SETTING:
				_onSetLightColorSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING:
				_onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				_onSetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_SETTING:
				_onSetOffTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_ILLUMINANCE_LEVEL:
				_onGetIlluminanceLevel(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ILLUMINANCE_LEVEL_STEP_SETTING:
				_onGetIlluminanceLevelStepSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_LIGHT_COLOR_STEP_SETTING:
				_onGetLightColorStepSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MAXIMUM_SPECIFIABLE_VALUES:
				_onGetMaximumSpecifiableValues(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_LIGHT_COLOR_SETTING:
				_onGetLightColorSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING:
				_onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				_onGetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_SETTING:
				_onGetOffTimerSetting(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates illuminance level in %.<br><br>0x00.0x64 (0.100%)<br><br>Name : Illuminance level<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetIlluminanceLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetIlluminanceLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetIlluminanceLevel(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates illuminance level in %.<br><br>0x00.0x64 (0.100%)<br><br>Name : Illuminance level<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetIlluminanceLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIlluminanceLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIlluminanceLevel(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br><br>Name : Illuminance level step setting<br>EPC : 0xB2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetIlluminanceLevelStepSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetIlluminanceLevelStepSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetIlluminanceLevelStepSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br><br>Name : Illuminance level step setting<br>EPC : 0xB2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetIlluminanceLevelStepSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIlluminanceLevelStepSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIlluminanceLevelStepSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br><br>Name : Light color step setting<br>EPC : 0xB3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetLightColorStepSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetLightColorStepSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetLightColorStepSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br><br>Name : Light color step setting<br>EPC : 0xB3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetLightColorStepSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLightColorStepSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLightColorStepSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br><br>First byte: illuminance Second byte: light color 0x01-0xFF(Step 1 -Step 255) 0x00(when the function is not implemented)<br><br>Name : Maximum specifiable values<br>EPC : 0xB4<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMaximumSpecifiableValues(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMaximumSpecifiableValues(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMaximumSpecifiableValues(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the light color.<br><br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br><br>Name : Light color setting<br>EPC : 0xB1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetLightColorSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetLightColorSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetLightColorSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the light color.<br><br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br><br>Name : Light color setting<br>EPC : 0xB1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetLightColorSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLightColorSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLightColorSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : OFF timer setting<br>EPC : 0x95<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : OFF timer setting<br>EPC : 0x95<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates illuminance level in %.<br><br>0x00.0x64 (0.100%)<br><br>Name : Illuminance level<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetIlluminanceLevel(byte[] edt) {
			addProperty(EPC_ILLUMINANCE_LEVEL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br><br>Name : Illuminance level step setting<br>EPC : 0xB2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetIlluminanceLevelStepSetting(byte[] edt) {
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br><br>Name : Light color step setting<br>EPC : 0xB3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetLightColorStepSetting(byte[] edt) {
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the light color.<br><br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br><br>Name : Light color setting<br>EPC : 0xB1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetLightColorSetting(byte[] edt) {
			addProperty(EPC_LIGHT_COLOR_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : OFF timer setting<br>EPC : 0x95<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOffTimerSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates illuminance level in %.<br><br>0x00.0x64 (0.100%)<br><br>Name : Illuminance level<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetIlluminanceLevel() {
			addProperty(EPC_ILLUMINANCE_LEVEL);
			return this;
		}
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br><br>Name : Illuminance level step setting<br>EPC : 0xB2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetIlluminanceLevelStepSetting() {
			addProperty(EPC_ILLUMINANCE_LEVEL_STEP_SETTING);
			return this;
		}
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br><br>Name : Light color step setting<br>EPC : 0xB3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetLightColorStepSetting() {
			addProperty(EPC_LIGHT_COLOR_STEP_SETTING);
			return this;
		}
		/**
		 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br><br>First byte: illuminance Second byte: light color 0x01-0xFF(Step 1 -Step 255) 0x00(when the function is not implemented)<br><br>Name : Maximum specifiable values<br>EPC : 0xB4<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMaximumSpecifiableValues() {
			addProperty(EPC_MAXIMUM_SPECIFIABLE_VALUES);
			return this;
		}
		/**
		 * Used to specify the light color.<br><br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br><br>Name : Light color setting<br>EPC : 0xB1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetLightColorSetting() {
			addProperty(EPC_LIGHT_COLOR_SETTING);
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : OFF timer setting<br>EPC : 0x95<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOffTimerSetting() {
			addProperty(EPC_OFF_TIMER_SETTING);
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
		 * This property indicates illuminance level in %.<br><br>0x00.0x64 (0.100%)<br><br>Name : Illuminance level<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformIlluminanceLevel();
		/**
		 * Used to specify the illuminance level in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable illuminance level value (from dark to bright)<br><br>Name : Illuminance level step setting<br>EPC : 0xB2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformIlluminanceLevelStepSetting();
		/**
		 * Used to specify the light color in terms of steps and acquire the current setting.<br><br>From 0x01 to the maximum specifiable light color value (from incandescent lamp color to white)<br><br>Name : Light color step setting<br>EPC : 0xB3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformLightColorStepSetting();
		/**
		 * Used to acquire the maximum specifiable illuminance level value and the maximum specifiable light color value.<br><br>First byte: illuminance Second byte: light color 0x01-0xFF(Step 1 -Step 255) 0x00(when the function is not implemented)<br><br>Name : Maximum specifiable values<br>EPC : 0xB4<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMaximumSpecifiableValues();
		/**
		 * Used to specify the light color.<br><br>incandescent lamp color��0x41, white��0x42, daylight white��0x43, daylight color��0x44<br><br>Name : Light color setting<br>EPC : 0xB1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformLightColorSetting();
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * Reservation ON/OFF<br><br>Reservation ON��0x41, Reservation OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0 -0x3B (=0-23):(=0 -59)<br><br>Name : OFF timer setting<br>EPC : 0x95<br>Data Type : unsign ed char �~2<br>Data Size(Byte) : 2 Byt e<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOffTimerSetting();
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
		public Informer reqInformIlluminanceLevel() {
			byte epc = EPC_ILLUMINANCE_LEVEL;
			byte[] edt = _getIlluminanceLevel(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformIlluminanceLevelStepSetting() {
			byte epc = EPC_ILLUMINANCE_LEVEL_STEP_SETTING;
			byte[] edt = _getIlluminanceLevelStepSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformLightColorStepSetting() {
			byte epc = EPC_LIGHT_COLOR_STEP_SETTING;
			byte[] edt = _getLightColorStepSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMaximumSpecifiableValues() {
			byte epc = EPC_MAXIMUM_SPECIFIABLE_VALUES;
			byte[] edt = _getMaximumSpecifiableValues(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformLightColorSetting() {
			byte epc = EPC_LIGHT_COLOR_SETTING;
			byte[] edt = _getLightColorSetting(epc);
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
		public Informer reqInformOnTimerSetting() {
			byte epc = EPC_ON_TIMER_SETTING;
			byte[] edt = _getOnTimerSetting(epc);
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
		public Informer reqInformOffTimerSetting() {
			byte epc = EPC_OFF_TIMER_SETTING;
			byte[] edt = _getOffTimerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
