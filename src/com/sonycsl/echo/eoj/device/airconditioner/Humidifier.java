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
	@SuppressWarnings("unused")
	private static final String TAG = Humidifier.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x01;
	public static final byte CLASS_CODE = (byte)0x39;

	protected static final byte EPC_HUMIDIFYING_SETTING1 = (byte)0xC0;
	protected static final byte EPC_HUMIDIFYING_SETTING2 = (byte)0xC1;
	protected static final byte EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY = (byte)0xB4;
	protected static final byte EPC_RESERVATION_SET_OF_OFF_TIMER = (byte)0x94;
	protected static final byte EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER = (byte)0x96;
	protected static final byte EPC_ION_EMISSION_SETTING = (byte)0xC2;
	protected static final byte EPC_IMPLEMENTED_ION_EMISSION_METHOD = (byte)0xC3;
	protected static final byte EPC_SPECIAL_OPERATION_MODE_SETTING = (byte)0xC4;
	protected static final byte EPC_WATER_AMOUNT_LEVEL = (byte)0xC5;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setHumidifyingSetting1(byte[] edt);
	/**
	 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getHumidifyingSetting1();
	/**
	 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setHumidifyingSetting2(byte[] edt);
	/**
	 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getHumidifyingSetting2();
	/**
	 * This property indicates measured value of relative humidity<br>0x00.0x64, (0.100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredValueOfRelativeHumidity() {return null;}
	/**
	 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setReservationSetOfOffTimer(byte[] edt) {return false;}
	/**
	 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getReservationSetOfOffTimer() {return null;}
	/**
	 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char x2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeTimeValueSetOfOffTimer(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char x2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeTimeValueSetOfOffTimer() {return null;}
	/**
	 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setIonEmissionSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getIonEmissionSetting() {return null;}
	/**
	 * Sets ion emission method equipped in humidifier by bit map<br>Bit 0: negative ion method, Bit 1: cluster ion method,<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getImplementedIonEmissionMethod() {return null;}
	/**
	 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Data type : unsigned short<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSpecialOperationModeSetting(byte[] edt) {return false;}
	/**
	 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Data type : unsigned short<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSpecialOperationModeSetting() {return null;}
	/**
	 * This property indicates water amount level in water tank by 6 steps.<br>0x40: empty 0x41-0x45: minimum to maximum level<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getWaterAmountLevel() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_HUMIDIFYING_SETTING1:
			res.addProperty(epc, edt, setHumidifyingSetting1(edt));
			break;
		case EPC_HUMIDIFYING_SETTING2:
			res.addProperty(epc, edt, setHumidifyingSetting2(edt));
			break;
		case EPC_RESERVATION_SET_OF_OFF_TIMER:
			res.addProperty(epc, edt, setReservationSetOfOffTimer(edt));
			break;
		case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER:
			res.addProperty(epc, edt, setRelativeTimeValueSetOfOffTimer(edt));
			break;
		case EPC_ION_EMISSION_SETTING:
			res.addProperty(epc, edt, setIonEmissionSetting(edt));
			break;
		case EPC_SPECIAL_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, setSpecialOperationModeSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_HUMIDIFYING_SETTING1:
			edt = getHumidifyingSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HUMIDIFYING_SETTING2:
			edt = getHumidifyingSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY:
			edt = getMeasuredValueOfRelativeHumidity();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RESERVATION_SET_OF_OFF_TIMER:
			edt = getReservationSetOfOffTimer();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER:
			edt = getRelativeTimeValueSetOfOffTimer();
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
		case EPC_SPECIAL_OPERATION_MODE_SETTING:
			edt = getSpecialOperationModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_AMOUNT_LEVEL:
			edt = getWaterAmountLevel();
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
			case EPC_HUMIDIFYING_SETTING1:
				onSetHumidifyingSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_HUMIDIFYING_SETTING2:
				onSetHumidifyingSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_RESERVATION_SET_OF_OFF_TIMER:
				onSetReservationSetOfOffTimer(eoj, tid, (pdc != 0));
				break;
			case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER:
				onSetRelativeTimeValueSetOfOffTimer(eoj, tid, (pdc != 0));
				break;
			case EPC_ION_EMISSION_SETTING:
				onSetIonEmissionSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SPECIAL_OPERATION_MODE_SETTING:
				onSetSpecialOperationModeSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_HUMIDIFYING_SETTING1:
				onGetHumidifyingSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_HUMIDIFYING_SETTING2:
				onGetHumidifyingSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY:
				onGetMeasuredValueOfRelativeHumidity(eoj, tid, pdc, edt);
				break;
			case EPC_RESERVATION_SET_OF_OFF_TIMER:
				onGetReservationSetOfOffTimer(eoj, tid, pdc, edt);
				break;
			case EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER:
				onGetRelativeTimeValueSetOfOffTimer(eoj, tid, pdc, edt);
				break;
			case EPC_ION_EMISSION_SETTING:
				onGetIonEmissionSetting(eoj, tid, pdc, edt);
				break;
			case EPC_IMPLEMENTED_ION_EMISSION_METHOD:
				onGetImplementedIonEmissionMethod(eoj, tid, pdc, edt);
				break;
			case EPC_SPECIAL_OPERATION_MODE_SETTING:
				onGetSpecialOperationModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_WATER_AMOUNT_LEVEL:
				onGetWaterAmountLevel(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetHumidifyingSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetHumidifyingSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetHumidifyingSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetHumidifyingSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates measured value of relative humidity<br>0x00.0x64, (0.100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredValueOfRelativeHumidity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetReservationSetOfOffTimer(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetReservationSetOfOffTimer(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char x2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char x2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetIonEmissionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetIonEmissionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ion emission method equipped in humidifier by bit map<br>Bit 0: negative ion method, Bit 1: cluster ion method,<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Data type : unsigned short<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSpecialOperationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Data type : unsigned short<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates water amount level in water tank by 6 steps.<br>0x40: empty 0x41-0x45: minimum to maximum level<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetWaterAmountLevel(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetHumidifyingSetting1(byte[] edt);
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetHumidifyingSetting2(byte[] edt);
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetReservationSetOfOffTimer(byte[] edt);
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char x2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRelativeTimeValueSetOfOffTimer(byte[] edt);
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetIonEmissionSetting(byte[] edt);
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Data type : unsigned short<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSpecialOperationModeSetting(byte[] edt);
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
		public Setter reqSetHumidifyingSetting1(byte[] edt) {
			addProperty(EPC_HUMIDIFYING_SETTING1, edt, setHumidifyingSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetHumidifyingSetting2(byte[] edt) {
			addProperty(EPC_HUMIDIFYING_SETTING2, edt, setHumidifyingSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetReservationSetOfOffTimer(byte[] edt) {
			addProperty(EPC_RESERVATION_SET_OF_OFF_TIMER, edt, setReservationSetOfOffTimer(edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeTimeValueSetOfOffTimer(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER, edt, setRelativeTimeValueSetOfOffTimer(edt));
			return this;
		}
		@Override
		public Setter reqSetIonEmissionSetting(byte[] edt) {
			addProperty(EPC_ION_EMISSION_SETTING, edt, setIonEmissionSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSpecialOperationModeSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, setSpecialOperationModeSetting(edt));
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
		public Setter reqSetHumidifyingSetting1(byte[] edt) {
			addProperty(EPC_HUMIDIFYING_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetHumidifyingSetting2(byte[] edt) {
			addProperty(EPC_HUMIDIFYING_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetReservationSetOfOffTimer(byte[] edt) {
			addProperty(EPC_RESERVATION_SET_OF_OFF_TIMER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRelativeTimeValueSetOfOffTimer(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetIonEmissionSetting(byte[] edt) {
			addProperty(EPC_ION_EMISSION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSpecialOperationModeSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetHumidifyingSetting1();
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetHumidifyingSetting2();
		/**
		 * This property indicates measured value of relative humidity<br>0x00.0x64, (0.100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredValueOfRelativeHumidity();
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetReservationSetOfOffTimer();
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char x2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRelativeTimeValueSetOfOffTimer();
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetIonEmissionSetting();
		/**
		 * Sets ion emission method equipped in humidifier by bit map<br>Bit 0: negative ion method, Bit 1: cluster ion method,<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetImplementedIonEmissionMethod();
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Data type : unsigned short<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSpecialOperationModeSetting();
		/**
		 * This property indicates water amount level in water tank by 6 steps.<br>0x40: empty 0x41-0x45: minimum to maximum level<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetWaterAmountLevel();
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
		public Getter reqGetHumidifyingSetting1() {
			byte[] edt = getHumidifyingSetting1();
			addProperty(EPC_HUMIDIFYING_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHumidifyingSetting2() {
			byte[] edt = getHumidifyingSetting2();
			addProperty(EPC_HUMIDIFYING_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfRelativeHumidity() {
			byte[] edt = getMeasuredValueOfRelativeHumidity();
			addProperty(EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetReservationSetOfOffTimer() {
			byte[] edt = getReservationSetOfOffTimer();
			addProperty(EPC_RESERVATION_SET_OF_OFF_TIMER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRelativeTimeValueSetOfOffTimer() {
			byte[] edt = getRelativeTimeValueSetOfOffTimer();
			addProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetSpecialOperationModeSetting() {
			byte[] edt = getSpecialOperationModeSetting();
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWaterAmountLevel() {
			byte[] edt = getWaterAmountLevel();
			addProperty(EPC_WATER_AMOUNT_LEVEL, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetHumidifyingSetting1() {
			addProperty(EPC_HUMIDIFYING_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetHumidifyingSetting2() {
			addProperty(EPC_HUMIDIFYING_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetMeasuredValueOfRelativeHumidity() {
			addProperty(EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY);
			return this;
		}
		@Override
		public Getter reqGetReservationSetOfOffTimer() {
			addProperty(EPC_RESERVATION_SET_OF_OFF_TIMER);
			return this;
		}
		@Override
		public Getter reqGetRelativeTimeValueSetOfOffTimer() {
			addProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER);
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
		public Getter reqGetSpecialOperationModeSetting() {
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetWaterAmountLevel() {
			addProperty(EPC_WATER_AMOUNT_LEVEL);
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
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformHumidifyingSetting1();
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformHumidifyingSetting2();
		/**
		 * This property indicates measured value of relative humidity<br>0x00.0x64, (0.100%)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredValueOfRelativeHumidity();
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformReservationSetOfOffTimer();
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42<br><br>Data type : unsigned char x2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRelativeTimeValueSetOfOffTimer();
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformIonEmissionSetting();
		/**
		 * Sets ion emission method equipped in humidifier by bit map<br>Bit 0: negative ion method, Bit 1: cluster ion method,<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformImplementedIonEmissionMethod();
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved<br><br>Data type : unsigned short<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSpecialOperationModeSetting();
		/**
		 * This property indicates water amount level in water tank by 6 steps.<br>0x40: empty 0x41-0x45: minimum to maximum level<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformWaterAmountLevel();
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
		public Informer reqInformHumidifyingSetting1() {
			byte[] edt = getHumidifyingSetting1();
			addProperty(EPC_HUMIDIFYING_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHumidifyingSetting2() {
			byte[] edt = getHumidifyingSetting2();
			addProperty(EPC_HUMIDIFYING_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredValueOfRelativeHumidity() {
			byte[] edt = getMeasuredValueOfRelativeHumidity();
			addProperty(EPC_MEASURED_VALUE_OF_RELATIVE_HUMIDITY, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformReservationSetOfOffTimer() {
			byte[] edt = getReservationSetOfOffTimer();
			addProperty(EPC_RESERVATION_SET_OF_OFF_TIMER, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRelativeTimeValueSetOfOffTimer() {
			byte[] edt = getRelativeTimeValueSetOfOffTimer();
			addProperty(EPC_RELATIVE_TIME_VALUE_SET_OF_OFF_TIMER, edt, (edt != null && (edt.length == 2)));
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
		public Informer reqInformSpecialOperationModeSetting() {
			byte[] edt = getSpecialOperationModeSetting();
			addProperty(EPC_SPECIAL_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterAmountLevel() {
			byte[] edt = getWaterAmountLevel();
			addProperty(EPC_WATER_AMOUNT_LEVEL, edt, (edt != null && (edt.length == 1)));
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
