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

public abstract class Humidifier extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x39;
	
	public Humidifier() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_HUMIDIFYING_SETTING1 = (byte)0xC0;
	public static final byte EPC_HUMIDIFYING_SETTING2 = (byte)0xC1;
	public static final byte EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY = (byte)0xB4;
	public static final byte EPC_RESERVATION_SET_OF_OFF_TIMER = (byte)0x94;
	public static final byte EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER = (byte)0x96;
	public static final byte EPC_ION_EMISSION_SETTING = (byte)0xC2;
	public static final byte EPC_IMPLEMENTED_ION_EMISSION_METHOD = (byte)0xC3;
	public static final byte EPC_SPECIAL_OPERATION_MODE_SETTING = (byte)0xC4;
	public static final byte EPC_WATER_AMOUNT_LEVEL = (byte)0xC5;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Sets value of relative humidity and get setting status<br><br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 1<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract boolean setHumidifyingSetting1(byte[] edt);
	private final boolean _setHumidifyingSetting1(byte epc, byte[] edt) {
		boolean success = setHumidifyingSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets value of relative humidity and get setting status<br><br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 1<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract byte[] getHumidifyingSetting1();
	private final byte[] _getHumidifyingSetting1(byte epc) {
		byte[] edt = getHumidifyingSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets humidifying level by 3 steps<br><br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 2<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract boolean setHumidifyingSetting2(byte[] edt);
	private final boolean _setHumidifyingSetting2(byte epc, byte[] edt) {
		boolean success = setHumidifyingSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets humidifying level by 3 steps<br><br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 2<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract byte[] getHumidifyingSetting2();
	private final byte[] _getHumidifyingSetting2(byte epc) {
		byte[] edt = getHumidifyingSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates measured value of relative humidity<br><br>0x00.0x64, (0.100%)<br><br>Name : Measured value of relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredValueOfRelativeHumidity() {return null;}
	private final byte[] _getMeasuredValueOfRelativeHumidity(byte epc) {
		byte[] edt = getMeasuredValueOfRelativeHumidity();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets reservation ON/OFF and set setting status<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Reservation set of OFF timer<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setReservationSetOfOffTimer(byte[] edt) {return false;}
	private final boolean _setReservationSetOfOffTimer(byte epc, byte[] edt) {
		boolean success = setReservationSetOfOffTimer(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets reservation ON/OFF and set setting status<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Reservation set of OFF timer<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getReservationSetOfOffTimer() {return null;}
	private final byte[] _getReservationSetOfOffTimer(byte epc) {
		byte[] edt = getReservationSetOfOffTimer();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets timer value HH:MM and   get updated time<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Relative time value set of OFF timer<br>EPC : 0x96<br>Data Type : unsigned char x2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRelativeTimeValueSetOfOffTimer(byte[] edt) {return false;}
	private final boolean _setRelativeTimeValueSetOfOffTimer(byte epc, byte[] edt) {
		boolean success = setRelativeTimeValueSetOfOffTimer(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets timer value HH:MM and   get updated time<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Relative time value set of OFF timer<br>EPC : 0x96<br>Data Type : unsigned char x2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRelativeTimeValueSetOfOffTimer() {return null;}
	private final byte[] _getRelativeTimeValueSetOfOffTimer(byte epc) {
		byte[] edt = getRelativeTimeValueSetOfOffTimer();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets ON/OFF of ion emission and gets setting status<br><br>Emission ON= 0x41, OFF=0x42<br><br>Name : Ion emission setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setIonEmissionSetting(byte[] edt) {return false;}
	private final boolean _setIonEmissionSetting(byte epc, byte[] edt) {
		boolean success = setIonEmissionSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets ON/OFF of ion emission and gets setting status<br><br>Emission ON= 0x41, OFF=0x42<br><br>Name : Ion emission setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getIonEmissionSetting() {return null;}
	private final byte[] _getIonEmissionSetting(byte epc) {
		byte[] edt = getIonEmissionSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets ion emission method equipped in humidifier by bit map<br><br>Bit 0: negative ion method, Bit 1: cluster ion method,<br><br>Name : Implemented ion emission method<br>EPC : 0xC3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getImplementedIonEmissionMethod() {return null;}
	private final byte[] _getImplementedIonEmissionMethod(byte epc) {
		byte[] edt = getImplementedIonEmissionMethod();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets special operation mode and gets setting status. Specifies by bit map<br><br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Name : Special operation mode setting<br>EPC : 0xC4<br>Data Type : unsigned short<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSpecialOperationModeSetting(byte[] edt) {return false;}
	private final boolean _setSpecialOperationModeSetting(byte epc, byte[] edt) {
		boolean success = setSpecialOperationModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets special operation mode and gets setting status. Specifies by bit map<br><br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Name : Special operation mode setting<br>EPC : 0xC4<br>Data Type : unsigned short<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSpecialOperationModeSetting() {return null;}
	private final byte[] _getSpecialOperationModeSetting(byte epc) {
		byte[] edt = getSpecialOperationModeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates water amount level in water tank by 6 steps.<br><br>0x40: empty 0x41-0x45: minimum to maximum level<br><br>Name : Water amount level<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getWaterAmountLevel() {return null;}
	private final byte[] _getWaterAmountLevel(byte epc) {
		byte[] edt = getWaterAmountLevel();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_HUMIDIFYING_SETTING1:
			res.addProperty(epc, edt, _setHumidifyingSetting1(epc, edt));
			break;
		case EPC_HUMIDIFYING_SETTING2:
			res.addProperty(epc, edt, _setHumidifyingSetting2(epc, edt));
			break;
		case EPC_RESERVATION_SET_OF_OFF_TIMER:
			res.addProperty(epc, edt, _setReservationSetOfOffTimer(epc, edt));
			break;
		case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER:
			res.addProperty(epc, edt, _setRelativeTimeValueSetOfOffTimer(epc, edt));
			break;
		case EPC_ION_EMISSION_SETTING:
			res.addProperty(epc, edt, _setIonEmissionSetting(epc, edt));
			break;
		case EPC_SPECIAL_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, _setSpecialOperationModeSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_HUMIDIFYING_SETTING1:
			edt = _getHumidifyingSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HUMIDIFYING_SETTING2:
			edt = _getHumidifyingSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY:
			edt = _getMeasuredValueOfRelativeHumidity(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RESERVATION_SET_OF_OFF_TIMER:
			edt = _getReservationSetOfOffTimer(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER:
			edt = _getRelativeTimeValueSetOfOffTimer(epc);
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
		case EPC_SPECIAL_OPERATION_MODE_SETTING:
			edt = _getSpecialOperationModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_AMOUNT_LEVEL:
			edt = _getWaterAmountLevel(epc);
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
			case EPC_HUMIDIFYING_SETTING1:
				_onSetHumidifyingSetting1(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_HUMIDIFYING_SETTING2:
				_onSetHumidifyingSetting2(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_RESERVATION_SET_OF_OFF_TIMER:
				_onSetReservationSetOfOffTimer(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER:
				_onSetRelativeTimeValueSetOfOffTimer(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ION_EMISSION_SETTING:
				_onSetIonEmissionSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SPECIAL_OPERATION_MODE_SETTING:
				_onSetSpecialOperationModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_HUMIDIFYING_SETTING1:
				_onGetHumidifyingSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HUMIDIFYING_SETTING2:
				_onGetHumidifyingSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY:
				_onGetMeasuredValueOfRelativeHumidity(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RESERVATION_SET_OF_OFF_TIMER:
				_onGetReservationSetOfOffTimer(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER:
				_onGetRelativeTimeValueSetOfOffTimer(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ION_EMISSION_SETTING:
				_onGetIonEmissionSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_IMPLEMENTED_ION_EMISSION_METHOD:
				_onGetImplementedIonEmissionMethod(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPECIAL_OPERATION_MODE_SETTING:
				_onGetSpecialOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WATER_AMOUNT_LEVEL:
				_onGetWaterAmountLevel(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Sets value of relative humidity and get setting status<br><br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 1<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onSetHumidifyingSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHumidifyingSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHumidifyingSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets value of relative humidity and get setting status<br><br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 1<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onGetHumidifyingSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHumidifyingSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHumidifyingSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets humidifying level by 3 steps<br><br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 2<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onSetHumidifyingSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetHumidifyingSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetHumidifyingSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets humidifying level by 3 steps<br><br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 2<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onGetHumidifyingSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHumidifyingSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHumidifyingSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates measured value of relative humidity<br><br>0x00.0x64, (0.100%)<br><br>Name : Measured value of relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredValueOfRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredValueOfRelativeHumidity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredValueOfRelativeHumidity(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets reservation ON/OFF and set setting status<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Reservation set of OFF timer<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetReservationSetOfOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetReservationSetOfOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetReservationSetOfOffTimer(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets reservation ON/OFF and set setting status<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Reservation set of OFF timer<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetReservationSetOfOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetReservationSetOfOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetReservationSetOfOffTimer(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets timer value HH:MM and   get updated time<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Relative time value set of OFF timer<br>EPC : 0x96<br>Data Type : unsigned char x2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeTimeValueSetOfOffTimer(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets timer value HH:MM and   get updated time<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Relative time value set of OFF timer<br>EPC : 0x96<br>Data Type : unsigned char x2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeTimeValueSetOfOffTimer(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br><br>Emission ON= 0x41, OFF=0x42<br><br>Name : Ion emission setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetIonEmissionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetIonEmissionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetIonEmissionSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br><br>Emission ON= 0x41, OFF=0x42<br><br>Name : Ion emission setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetIonEmissionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIonEmissionSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIonEmissionSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets ion emission method equipped in humidifier by bit map<br><br>Bit 0: negative ion method, Bit 1: cluster ion method,<br><br>Name : Implemented ion emission method<br>EPC : 0xC3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetImplementedIonEmissionMethod(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br><br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Name : Special operation mode setting<br>EPC : 0xC4<br>Data Type : unsigned short<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSpecialOperationModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br><br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Name : Special operation mode setting<br>EPC : 0xC4<br>Data Type : unsigned short<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSpecialOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates water amount level in water tank by 6 steps.<br><br>0x40: empty 0x41-0x45: minimum to maximum level<br><br>Name : Water amount level<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetWaterAmountLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWaterAmountLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWaterAmountLevel(eoj, tid, esv, epc, pdc, edt);
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
		 * Sets value of relative humidity and get setting status<br><br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 1<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Setter reqSetHumidifyingSetting1(byte[] edt) {
			addProperty(EPC_HUMIDIFYING_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Sets humidifying level by 3 steps<br><br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 2<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Setter reqSetHumidifyingSetting2(byte[] edt) {
			addProperty(EPC_HUMIDIFYING_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Sets reservation ON/OFF and set setting status<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Reservation set of OFF timer<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetReservationSetOfOffTimer(byte[] edt) {
			addProperty(EPC_RESERVATION_SET_OF_OFF_TIMER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Sets timer value HH:MM and   get updated time<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Relative time value set of OFF timer<br>EPC : 0x96<br>Data Type : unsigned char x2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRelativeTimeValueSetOfOffTimer(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br><br>Emission ON= 0x41, OFF=0x42<br><br>Name : Ion emission setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetIonEmissionSetting(byte[] edt) {
			addProperty(EPC_ION_EMISSION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br><br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Name : Special operation mode setting<br>EPC : 0xC4<br>Data Type : unsigned short<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSpecialOperationModeSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Sets value of relative humidity and get setting status<br><br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 1<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Getter reqGetHumidifyingSetting1() {
			addProperty(EPC_HUMIDIFYING_SETTING1);
			return this;
		}
		/**
		 * Sets humidifying level by 3 steps<br><br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 2<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Getter reqGetHumidifyingSetting2() {
			addProperty(EPC_HUMIDIFYING_SETTING2);
			return this;
		}
		/**
		 * This property indicates measured value of relative humidity<br><br>0x00.0x64, (0.100%)<br><br>Name : Measured value of relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredValueOfRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY);
			return this;
		}
		/**
		 * Sets reservation ON/OFF and set setting status<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Reservation set of OFF timer<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetReservationSetOfOffTimer() {
			addProperty(EPC_RESERVATION_SET_OF_OFF_TIMER);
			return this;
		}
		/**
		 * Sets timer value HH:MM and   get updated time<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Relative time value set of OFF timer<br>EPC : 0x96<br>Data Type : unsigned char x2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRelativeTimeValueSetOfOffTimer() {
			addProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER);
			return this;
		}
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br><br>Emission ON= 0x41, OFF=0x42<br><br>Name : Ion emission setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetIonEmissionSetting() {
			addProperty(EPC_ION_EMISSION_SETTING);
			return this;
		}
		/**
		 * Sets ion emission method equipped in humidifier by bit map<br><br>Bit 0: negative ion method, Bit 1: cluster ion method,<br><br>Name : Implemented ion emission method<br>EPC : 0xC3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetImplementedIonEmissionMethod() {
			addProperty(EPC_IMPLEMENTED_ION_EMISSION_METHOD);
			return this;
		}
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br><br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Name : Special operation mode setting<br>EPC : 0xC4<br>Data Type : unsigned short<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSpecialOperationModeSetting() {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * This property indicates water amount level in water tank by 6 steps.<br><br>0x40: empty 0x41-0x45: minimum to maximum level<br><br>Name : Water amount level<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetWaterAmountLevel() {
			addProperty(EPC_WATER_AMOUNT_LEVEL);
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
		 * Sets value of relative humidity and get setting status<br><br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 1<br>EPC : 0xC0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Informer reqInformHumidifyingSetting1();
		/**
		 * Sets humidifying level by 3 steps<br><br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Name : Humidifying setting 2<br>EPC : 0xC1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Informer reqInformHumidifyingSetting2();
		/**
		 * This property indicates measured value of relative humidity<br><br>0x00.0x64, (0.100%)<br><br>Name : Measured value of relative humidity<br>EPC : 0xB4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredValueOfRelativeHumidity();
		/**
		 * Sets reservation ON/OFF and set setting status<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Reservation set of OFF timer<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformReservationSetOfOffTimer();
		/**
		 * Sets timer value HH:MM and   get updated time<br><br>Reservation ON =0x41, OFF =0x42<br><br>Name : Relative time value set of OFF timer<br>EPC : 0x96<br>Data Type : unsigned char x2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRelativeTimeValueSetOfOffTimer();
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br><br>Emission ON= 0x41, OFF=0x42<br><br>Name : Ion emission setting<br>EPC : 0xC2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformIonEmissionSetting();
		/**
		 * Sets ion emission method equipped in humidifier by bit map<br><br>Bit 0: negative ion method, Bit 1: cluster ion method,<br><br>Name : Implemented ion emission method<br>EPC : 0xC3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformImplementedIonEmissionMethod();
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br><br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Name : Special operation mode setting<br>EPC : 0xC4<br>Data Type : unsigned short<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSpecialOperationModeSetting();
		/**
		 * This property indicates water amount level in water tank by 6 steps.<br><br>0x40: empty 0x41-0x45: minimum to maximum level<br><br>Name : Water amount level<br>EPC : 0xC5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformWaterAmountLevel();
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
		public Informer reqInformHumidifyingSetting1() {
			byte epc = EPC_HUMIDIFYING_SETTING1;
			byte[] edt = _getHumidifyingSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHumidifyingSetting2() {
			byte epc = EPC_HUMIDIFYING_SETTING2;
			byte[] edt = _getHumidifyingSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRelativeHumidity() {
			byte epc = EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY;
			byte[] edt = _getMeasuredValueOfRelativeHumidity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformReservationSetOfOffTimer() {
			byte epc = EPC_RESERVATION_SET_OF_OFF_TIMER;
			byte[] edt = _getReservationSetOfOffTimer(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRelativeTimeValueSetOfOffTimer() {
			byte epc = EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER;
			byte[] edt = _getRelativeTimeValueSetOfOffTimer(epc);
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
		public Informer reqInformSpecialOperationModeSetting() {
			byte epc = EPC_SPECIAL_OPERATION_MODE_SETTING;
			byte[] edt = _getSpecialOperationModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterAmountLevel() {
			byte epc = EPC_WATER_AMOUNT_LEVEL;
			byte[] edt = _getWaterAmountLevel(epc);
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
		public Informer reqInformHumidifyingSetting1() {
			addProperty(EPC_HUMIDIFYING_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformHumidifyingSetting2() {
			addProperty(EPC_HUMIDIFYING_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY);
			return this;
		}
		@Override
		public Informer reqInformReservationSetOfOffTimer() {
			addProperty(EPC_RESERVATION_SET_OF_OFF_TIMER);
			return this;
		}
		@Override
		public Informer reqInformRelativeTimeValueSetOfOffTimer() {
			addProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER);
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
		public Informer reqInformSpecialOperationModeSetting() {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformWaterAmountLevel() {
			addProperty(EPC_WATER_AMOUNT_LEVEL);
			return this;
		}
	}
}
