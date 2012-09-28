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
	 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
	 */
	protected abstract boolean setHumidifyingSetting1(byte[] edt);
	/**
	 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
	 */
	protected abstract byte[] getHumidifyingSetting1();
	/**
	 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
	 */
	protected abstract boolean setHumidifyingSetting2(byte[] edt);
	/**
	 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
	 */
	protected abstract byte[] getHumidifyingSetting2();
	/**
	 * This property indicates measured value of relative humidity<br>0x00.0x64, (0.100%)
	 */
	protected byte[] getMeasuredValueOfRelativeHumidity() {return null;}
	/**
	 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42
	 */
	protected boolean setReservationSetOfOffTimer(byte[] edt) {return false;}
	/**
	 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42
	 */
	protected byte[] getReservationSetOfOffTimer() {return null;}
	/**
	 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42
	 */
	protected boolean setRelativeTimeValueSetOfOffTimer(byte[] edt) {return false;}
	/**
	 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42
	 */
	protected byte[] getRelativeTimeValueSetOfOffTimer() {return null;}
	/**
	 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42
	 */
	protected boolean setIonEmissionSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42
	 */
	protected byte[] getIonEmissionSetting() {return null;}
	/**
	 * Sets ion emission method equipped in humidifier by bit map<br>Bit 0: negative ion method, Bit 1: cluster ion method,
	 */
	protected byte[] getImplementedIonEmissionMethod() {return null;}
	/**
	 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved
	 */
	protected boolean setSpecialOperationModeSetting(byte[] edt) {return false;}
	/**
	 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved
	 */
	protected byte[] getSpecialOperationModeSetting() {return null;}
	/**
	 * This property indicates water amount level in water tank by 6 steps.<br>0x40: empty 0x41-0x45: minimum to maximum level
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
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		protected void onSetHumidifyingSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		protected void onGetHumidifyingSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		protected void onSetHumidifyingSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		protected void onGetHumidifyingSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates measured value of relative humidity<br>0x00.0x64, (0.100%)
		 */
		protected void onGetMeasuredValueOfRelativeHumidity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42
		 */
		protected void onSetReservationSetOfOffTimer(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42
		 */
		protected void onGetReservationSetOfOffTimer(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42
		 */
		protected void onSetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42
		 */
		protected void onGetRelativeTimeValueSetOfOffTimer(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42
		 */
		protected void onSetIonEmissionSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42
		 */
		protected void onGetIonEmissionSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ion emission method equipped in humidifier by bit map<br>Bit 0: negative ion method, Bit 1: cluster ion method,
		 */
		protected void onGetImplementedIonEmissionMethod(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved
		 */
		protected void onSetSpecialOperationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved
		 */
		protected void onGetSpecialOperationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates water amount level in water tank by 6 steps.<br>0x40: empty 0x41-0x45: minimum to maximum level
		 */
		protected void onGetWaterAmountLevel(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		public Setter reqSetHumidifyingSetting1(byte[] edt);
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		public Setter reqSetHumidifyingSetting2(byte[] edt);
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42
		 */
		public Setter reqSetReservationSetOfOffTimer(byte[] edt);
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42
		 */
		public Setter reqSetRelativeTimeValueSetOfOffTimer(byte[] edt);
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42
		 */
		public Setter reqSetIonEmissionSetting(byte[] edt);
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved
		 */
		public Setter reqSetSpecialOperationModeSetting(byte[] edt);

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
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		public Getter reqGetHumidifyingSetting1();
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		public Getter reqGetHumidifyingSetting2();
		/**
		 * This property indicates measured value of relative humidity<br>0x00.0x64, (0.100%)
		 */
		public Getter reqGetMeasuredValueOfRelativeHumidity();
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42
		 */
		public Getter reqGetReservationSetOfOffTimer();
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42
		 */
		public Getter reqGetRelativeTimeValueSetOfOffTimer();
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42
		 */
		public Getter reqGetIonEmissionSetting();
		/**
		 * Sets ion emission method equipped in humidifier by bit map<br>Bit 0: negative ion method, Bit 1: cluster ion method,
		 */
		public Getter reqGetImplementedIonEmissionMethod();
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved
		 */
		public Getter reqGetSpecialOperationModeSetting();
		/**
		 * This property indicates water amount level in water tank by 6 steps.<br>0x40: empty 0x41-0x45: minimum to maximum level
		 */
		public Getter reqGetWaterAmountLevel();

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
		 * Sets value of relative humidity and get setting status<br>0x00.0x64, (0.100%) Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		public Informer reqInformHumidifyingSetting1();
		/**
		 * Sets humidifying level by 3 steps<br>Humidifying levels =0x31.0x33 Automatic setting =0x70, Continuous operation =0x71, intermittent operation =0x72
		 */
		public Informer reqInformHumidifyingSetting2();
		/**
		 * This property indicates measured value of relative humidity<br>0x00.0x64, (0.100%)
		 */
		public Informer reqInformMeasuredValueOfRelativeHumidity();
		/**
		 * Sets reservation ON/OFF and set setting status<br>Reservation ON =0x41, OFF =0x42
		 */
		public Informer reqInformReservationSetOfOffTimer();
		/**
		 * Sets timer value HH:MM and   get updated time<br>Reservation ON =0x41, OFF =0x42
		 */
		public Informer reqInformRelativeTimeValueSetOfOffTimer();
		/**
		 * Sets ON/OFF of ion emission and gets setting status<br>Emission ON= 0x41, OFF=0x42
		 */
		public Informer reqInformIonEmissionSetting();
		/**
		 * Sets ion emission method equipped in humidifier by bit map<br>Bit 0: negative ion method, Bit 1: cluster ion method,
		 */
		public Informer reqInformImplementedIonEmissionMethod();
		/**
		 * Sets special operation mode and gets setting status. Specifies by bit map<br>Specifies 1 for effective setting Bit 0: Throat dry prevention Bit 1: Quiet operation Bit 2-7: for future reserved
		 */
		public Informer reqInformSpecialOperationModeSetting();
		/**
		 * This property indicates water amount level in water tank by 6 steps.<br>0x40: empty 0x41-0x45: minimum to maximum level
		 */
		public Informer reqInformWaterAmountLevel();

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
