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

public abstract class ElectricallyOperatedShade extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x60;
	
	public ElectricallyOperatedShade() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_OPEN_CLOSE_SETTING = (byte)0xE0;
	public static final byte EPC_DEGREE_OF_OPENI_NG_LEVEL = (byte)0xE1;
	public static final byte EPC_SET_VALUE_OF_SHADE_ANGLE = (byte)0xE2;
	public static final byte EPC_SHADE_OPEN_CLOSE_SPEED = (byte)0xE3;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract boolean setOpenCloseSetting(byte[] edt);
	private final boolean _setOpenCloseSetting(byte epc, byte[] edt) {
		boolean success = setOpenCloseSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract byte[] getOpenCloseSetting();
	private final byte[] _getOpenCloseSetting(byte epc) {
		byte[] edt = getOpenCloseSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the Degree-of-opening level by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Degree-of-openi ng level<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDegreeOfOpeniNgLevel(byte[] edt) {return false;}
	private final boolean _setDegreeOfOpeniNgLevel(byte epc, byte[] edt) {
		boolean success = setDegreeOfOpeniNgLevel(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the Degree-of-opening level by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Degree-of-openi ng level<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDegreeOfOpeniNgLevel() {return null;}
	private final byte[] _getDegreeOfOpeniNgLevel(byte epc) {
		byte[] edt = getDegreeOfOpeniNgLevel();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Shade angle value<br><br>0x00.0xB4 (0.180. )<br><br>Name : Set value of shade angle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfShadeAngle(byte[] edt) {return false;}
	private final boolean _setSetValueOfShadeAngle(byte epc, byte[] edt) {
		boolean success = setSetValueOfShadeAngle(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Shade angle value<br><br>0x00.0xB4 (0.180. )<br><br>Name : Set value of shade angle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfShadeAngle() {return null;}
	private final byte[] _getSetValueOfShadeAngle(byte epc) {
		byte[] edt = getSetValueOfShadeAngle();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Low/Medium/High<br><br>Low = 0x41, Medium = 0x42, High = 0x43<br><br>Name : Shade open/close speed<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setShadeOpenCloseSpeed(byte[] edt) {return false;}
	private final boolean _setShadeOpenCloseSpeed(byte epc, byte[] edt) {
		boolean success = setShadeOpenCloseSpeed(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Low/Medium/High<br><br>Low = 0x41, Medium = 0x42, High = 0x43<br><br>Name : Shade open/close speed<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getShadeOpenCloseSpeed() {return null;}
	private final byte[] _getShadeOpenCloseSpeed(byte epc) {
		byte[] edt = getShadeOpenCloseSpeed();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPEN_CLOSE_SETTING:
			res.addProperty(epc, edt, _setOpenCloseSetting(epc, edt));
			break;
		case EPC_DEGREE_OF_OPENI_NG_LEVEL:
			res.addProperty(epc, edt, _setDegreeOfOpeniNgLevel(epc, edt));
			break;
		case EPC_SET_VALUE_OF_SHADE_ANGLE:
			res.addProperty(epc, edt, _setSetValueOfShadeAngle(epc, edt));
			break;
		case EPC_SHADE_OPEN_CLOSE_SPEED:
			res.addProperty(epc, edt, _setShadeOpenCloseSpeed(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPEN_CLOSE_SETTING:
			edt = _getOpenCloseSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DEGREE_OF_OPENI_NG_LEVEL:
			edt = _getDegreeOfOpeniNgLevel(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_SHADE_ANGLE:
			edt = _getSetValueOfShadeAngle(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHADE_OPEN_CLOSE_SPEED:
			edt = _getShadeOpenCloseSpeed(epc);
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
			case EPC_OPEN_CLOSE_SETTING:
				_onSetOpenCloseSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_DEGREE_OF_OPENI_NG_LEVEL:
				_onSetDegreeOfOpeniNgLevel(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SET_VALUE_OF_SHADE_ANGLE:
				_onSetSetValueOfShadeAngle(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SHADE_OPEN_CLOSE_SPEED:
				_onSetShadeOpenCloseSpeed(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_OPEN_CLOSE_SETTING:
				_onGetOpenCloseSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DEGREE_OF_OPENI_NG_LEVEL:
				_onGetDegreeOfOpeniNgLevel(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_SHADE_ANGLE:
				_onGetSetValueOfShadeAngle(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SHADE_OPEN_CLOSE_SPEED:
				_onGetShadeOpenCloseSpeed(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onSetOpenCloseSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOpenCloseSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOpenCloseSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onGetOpenCloseSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOpenCloseSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOpenCloseSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the Degree-of-opening level by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Degree-of-openi ng level<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDegreeOfOpeniNgLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDegreeOfOpeniNgLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDegreeOfOpeniNgLevel(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the Degree-of-opening level by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Degree-of-openi ng level<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDegreeOfOpeniNgLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDegreeOfOpeniNgLevel(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDegreeOfOpeniNgLevel(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Shade angle value<br><br>0x00.0xB4 (0.180. )<br><br>Name : Set value of shade angle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfShadeAngle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfShadeAngle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfShadeAngle(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Shade angle value<br><br>0x00.0xB4 (0.180. )<br><br>Name : Set value of shade angle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfShadeAngle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfShadeAngle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfShadeAngle(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Low/Medium/High<br><br>Low = 0x41, Medium = 0x42, High = 0x43<br><br>Name : Shade open/close speed<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetShadeOpenCloseSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetShadeOpenCloseSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetShadeOpenCloseSpeed(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Low/Medium/High<br><br>Low = 0x41, Medium = 0x42, High = 0x43<br><br>Name : Shade open/close speed<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetShadeOpenCloseSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetShadeOpenCloseSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetShadeOpenCloseSpeed(eoj, tid, esv, epc, pdc, edt);
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
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Setter reqSetOpenCloseSetting(byte[] edt) {
			addProperty(EPC_OPEN_CLOSE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the Degree-of-opening level by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Degree-of-openi ng level<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDegreeOfOpeniNgLevel(byte[] edt) {
			addProperty(EPC_DEGREE_OF_OPENI_NG_LEVEL, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Shade angle value<br><br>0x00.0xB4 (0.180. )<br><br>Name : Set value of shade angle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfShadeAngle(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_SHADE_ANGLE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Low/Medium/High<br><br>Low = 0x41, Medium = 0x42, High = 0x43<br><br>Name : Shade open/close speed<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetShadeOpenCloseSpeed(byte[] edt) {
			addProperty(EPC_SHADE_OPEN_CLOSE_SPEED, edt, (edt != null && (edt.length == 1)));
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
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Getter reqGetOpenCloseSetting() {
			addProperty(EPC_OPEN_CLOSE_SETTING);
			return this;
		}
		/**
		 * Used to specify the Degree-of-opening level by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Degree-of-openi ng level<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDegreeOfOpeniNgLevel() {
			addProperty(EPC_DEGREE_OF_OPENI_NG_LEVEL);
			return this;
		}
		/**
		 * Shade angle value<br><br>0x00.0xB4 (0.180. )<br><br>Name : Set value of shade angle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfShadeAngle() {
			addProperty(EPC_SET_VALUE_OF_SHADE_ANGLE);
			return this;
		}
		/**
		 * Low/Medium/High<br><br>Low = 0x41, Medium = 0x42, High = 0x43<br><br>Name : Shade open/close speed<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetShadeOpenCloseSpeed() {
			addProperty(EPC_SHADE_OPEN_CLOSE_SPEED);
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
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Informer reqInformOpenCloseSetting();
		/**
		 * Used to specify the Degree-of-opening level by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Degree-of-openi ng level<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDegreeOfOpeniNgLevel();
		/**
		 * Shade angle value<br><br>0x00.0xB4 (0.180. )<br><br>Name : Set value of shade angle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfShadeAngle();
		/**
		 * Low/Medium/High<br><br>Low = 0x41, Medium = 0x42, High = 0x43<br><br>Name : Shade open/close speed<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformShadeOpenCloseSpeed();
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
		public Informer reqInformOpenCloseSetting() {
			byte epc = EPC_OPEN_CLOSE_SETTING;
			byte[] edt = _getOpenCloseSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDegreeOfOpeniNgLevel() {
			byte epc = EPC_DEGREE_OF_OPENI_NG_LEVEL;
			byte[] edt = _getDegreeOfOpeniNgLevel(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfShadeAngle() {
			byte epc = EPC_SET_VALUE_OF_SHADE_ANGLE;
			byte[] edt = _getSetValueOfShadeAngle(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShadeOpenCloseSpeed() {
			byte epc = EPC_SHADE_OPEN_CLOSE_SPEED;
			byte[] edt = _getShadeOpenCloseSpeed(epc);
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
		public Informer reqInformOpenCloseSetting() {
			addProperty(EPC_OPEN_CLOSE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformDegreeOfOpeniNgLevel() {
			addProperty(EPC_DEGREE_OF_OPENI_NG_LEVEL);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfShadeAngle() {
			addProperty(EPC_SET_VALUE_OF_SHADE_ANGLE);
			return this;
		}
		@Override
		public Informer reqInformShadeOpenCloseSpeed() {
			addProperty(EPC_SHADE_OPEN_CLOSE_SPEED);
			return this;
		}
	}
}
