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

public abstract class ElectricHotWaterPot extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = ElectricHotWaterPot.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xB2;

	public static final byte EPC_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_NO_WATER_WARNING = (byte)0xB1;
	public static final byte EPC_BOIL_UP_SETTING = (byte)0xB2;
	public static final byte EPC_BOIL_UP_WARMER_MODE_SETTING = (byte)0xE0;
	public static final byte EPC_SET_VALUE_OF_WARMER_TEMPERATURE = (byte)0xE1;
	public static final byte EPC_HOT_WATER_DISCHARGE_STATUS = (byte)0xE2;
	public static final byte EPC_LOCK_STATUS = (byte)0xE3;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Cover open/close status<br>Cover open = 0x41, cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getCoverOpenCloseStatus() {return null;}
	private final byte[] _getCoverOpenCloseStatus(byte epc) {
		byte[] edt = getCoverOpenCloseStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getNoWaterWarning() {return null;}
	private final byte[] _getNoWaterWarning(byte epc) {
		byte[] edt = getNoWaterWarning();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBoilUpSetting(byte[] edt) {return false;}
	private final boolean _setBoilUpSetting(byte epc, byte[] edt) {
		boolean success = setBoilUpSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBoilUpSetting() {return null;}
	private final byte[] _getBoilUpSetting(byte epc) {
		byte[] edt = getBoilUpSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBoilUpWarmerModeSetting(byte[] edt) {return false;}
	private final boolean _setBoilUpWarmerModeSetting(byte epc, byte[] edt) {
		boolean success = setBoilUpWarmerModeSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBoilUpWarmerModeSetting() {return null;}
	private final byte[] _getBoilUpWarmerModeSetting(byte epc) {
		byte[] edt = getBoilUpWarmerModeSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSetValueOfWarmerTemperature(byte[] edt) {return false;}
	private final boolean _setSetValueOfWarmerTemperature(byte epc, byte[] edt) {
		boolean success = setSetValueOfWarmerTemperature(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSetValueOfWarmerTemperature() {return null;}
	private final byte[] _getSetValueOfWarmerTemperature(byte epc) {
		byte[] edt = getSetValueOfWarmerTemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getHotWaterDischargeStatus() {return null;}
	private final byte[] _getHotWaterDischargeStatus(byte epc) {
		byte[] edt = getHotWaterDischargeStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getLockStatus() {return null;}
	private final byte[] _getLockStatus(byte epc) {
		byte[] edt = getLockStatus();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_BOIL_UP_SETTING:
			res.addProperty(epc, edt, _setBoilUpSetting(epc, edt));
			break;
		case EPC_BOIL_UP_WARMER_MODE_SETTING:
			res.addProperty(epc, edt, _setBoilUpWarmerModeSetting(epc, edt));
			break;
		case EPC_SET_VALUE_OF_WARMER_TEMPERATURE:
			res.addProperty(epc, edt, _setSetValueOfWarmerTemperature(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_COVER_OPEN_CLOSE_STATUS:
			edt = _getCoverOpenCloseStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_NO_WATER_WARNING:
			edt = _getNoWaterWarning(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BOIL_UP_SETTING:
			edt = _getBoilUpSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BOIL_UP_WARMER_MODE_SETTING:
			edt = _getBoilUpWarmerModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_WARMER_TEMPERATURE:
			edt = _getSetValueOfWarmerTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HOT_WATER_DISCHARGE_STATUS:
			edt = _getHotWaterDischargeStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_LOCK_STATUS:
			edt = _getLockStatus(epc);
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
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_BOIL_UP_SETTING:
				_onSetBoilUpSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BOIL_UP_WARMER_MODE_SETTING:
				_onSetBoilUpWarmerModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_WARMER_TEMPERATURE:
				_onSetSetValueOfWarmerTemperature(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_COVER_OPEN_CLOSE_STATUS:
				_onGetCoverOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_NO_WATER_WARNING:
				_onGetNoWaterWarning(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BOIL_UP_SETTING:
				_onGetBoilUpSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BOIL_UP_WARMER_MODE_SETTING:
				_onGetBoilUpWarmerModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_WARMER_TEMPERATURE:
				_onGetSetValueOfWarmerTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_HOT_WATER_DISCHARGE_STATUS:
				_onGetHotWaterDischargeStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_LOCK_STATUS:
				_onGetLockStatus(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Cover open/close status<br>Cover open = 0x41, cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCoverOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetNoWaterWarning(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetNoWaterWarning(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetNoWaterWarning(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBoilUpSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBoilUpSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBoilUpSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBoilUpSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBoilUpSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBoilUpSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBoilUpWarmerModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBoilUpWarmerModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBoilUpWarmerModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBoilUpWarmerModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBoilUpWarmerModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBoilUpWarmerModeSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSetValueOfWarmerTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfWarmerTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfWarmerTemperature(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSetValueOfWarmerTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfWarmerTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfWarmerTemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetHotWaterDischargeStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetHotWaterDischargeStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetHotWaterDischargeStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetLockStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLockStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLockStatus(eoj, tid, esv, epc, pdc, edt);
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
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBoilUpSetting(byte[] edt);
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBoilUpWarmerModeSetting(byte[] edt);
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSetValueOfWarmerTemperature(byte[] edt);
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
		public Setter reqSetBoilUpSetting(byte[] edt) {
			byte epc = EPC_BOIL_UP_SETTING;
			addProperty(epc, edt, _setBoilUpSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetBoilUpWarmerModeSetting(byte[] edt) {
			byte epc = EPC_BOIL_UP_WARMER_MODE_SETTING;
			addProperty(epc, edt, _setBoilUpWarmerModeSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfWarmerTemperature(byte[] edt) {
			byte epc = EPC_SET_VALUE_OF_WARMER_TEMPERATURE;
			addProperty(epc, edt, _setSetValueOfWarmerTemperature(epc, edt));
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
		public Setter reqSetBoilUpSetting(byte[] edt) {
			addProperty(EPC_BOIL_UP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBoilUpWarmerModeSetting(byte[] edt) {
			addProperty(EPC_BOIL_UP_WARMER_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfWarmerTemperature(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_WARMER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
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
		 * Cover open/close status<br>Cover open = 0x41, cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetCoverOpenCloseStatus();
		/**
		 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetNoWaterWarning();
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBoilUpSetting();
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBoilUpWarmerModeSetting();
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSetValueOfWarmerTemperature();
		/**
		 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetHotWaterDischargeStatus();
		/**
		 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetLockStatus();
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
		public Getter reqGetCoverOpenCloseStatus() {
			byte epc = EPC_COVER_OPEN_CLOSE_STATUS;
			byte[] edt = _getCoverOpenCloseStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetNoWaterWarning() {
			byte epc = EPC_NO_WATER_WARNING;
			byte[] edt = _getNoWaterWarning(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBoilUpSetting() {
			byte epc = EPC_BOIL_UP_SETTING;
			byte[] edt = _getBoilUpSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBoilUpWarmerModeSetting() {
			byte epc = EPC_BOIL_UP_WARMER_MODE_SETTING;
			byte[] edt = _getBoilUpWarmerModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfWarmerTemperature() {
			byte epc = EPC_SET_VALUE_OF_WARMER_TEMPERATURE;
			byte[] edt = _getSetValueOfWarmerTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHotWaterDischargeStatus() {
			byte epc = EPC_HOT_WATER_DISCHARGE_STATUS;
			byte[] edt = _getHotWaterDischargeStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetLockStatus() {
			byte epc = EPC_LOCK_STATUS;
			byte[] edt = _getLockStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetCoverOpenCloseStatus() {
			addProperty(EPC_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Getter reqGetNoWaterWarning() {
			addProperty(EPC_NO_WATER_WARNING);
			return this;
		}
		@Override
		public Getter reqGetBoilUpSetting() {
			addProperty(EPC_BOIL_UP_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBoilUpWarmerModeSetting() {
			addProperty(EPC_BOIL_UP_WARMER_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfWarmerTemperature() {
			addProperty(EPC_SET_VALUE_OF_WARMER_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetHotWaterDischargeStatus() {
			addProperty(EPC_HOT_WATER_DISCHARGE_STATUS);
			return this;
		}
		@Override
		public Getter reqGetLockStatus() {
			addProperty(EPC_LOCK_STATUS);
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
		 * Cover open/close status<br>Cover open = 0x41, cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformCoverOpenCloseStatus();
		/**
		 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformNoWaterWarning();
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBoilUpSetting();
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBoilUpWarmerModeSetting();
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSetValueOfWarmerTemperature();
		/**
		 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformHotWaterDischargeStatus();
		/**
		 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformLockStatus();
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
		public Informer reqInformCoverOpenCloseStatus() {
			byte epc = EPC_COVER_OPEN_CLOSE_STATUS;
			byte[] edt = _getCoverOpenCloseStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformNoWaterWarning() {
			byte epc = EPC_NO_WATER_WARNING;
			byte[] edt = _getNoWaterWarning(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBoilUpSetting() {
			byte epc = EPC_BOIL_UP_SETTING;
			byte[] edt = _getBoilUpSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBoilUpWarmerModeSetting() {
			byte epc = EPC_BOIL_UP_WARMER_MODE_SETTING;
			byte[] edt = _getBoilUpWarmerModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfWarmerTemperature() {
			byte epc = EPC_SET_VALUE_OF_WARMER_TEMPERATURE;
			byte[] edt = _getSetValueOfWarmerTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHotWaterDischargeStatus() {
			byte epc = EPC_HOT_WATER_DISCHARGE_STATUS;
			byte[] edt = _getHotWaterDischargeStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformLockStatus() {
			byte epc = EPC_LOCK_STATUS;
			byte[] edt = _getLockStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformCoverOpenCloseStatus() {
			addProperty(EPC_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Informer reqInformNoWaterWarning() {
			addProperty(EPC_NO_WATER_WARNING);
			return this;
		}
		@Override
		public Informer reqInformBoilUpSetting() {
			addProperty(EPC_BOIL_UP_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBoilUpWarmerModeSetting() {
			addProperty(EPC_BOIL_UP_WARMER_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfWarmerTemperature() {
			addProperty(EPC_SET_VALUE_OF_WARMER_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformHotWaterDischargeStatus() {
			addProperty(EPC_HOT_WATER_DISCHARGE_STATUS);
			return this;
		}
		@Override
		public Informer reqInformLockStatus() {
			addProperty(EPC_LOCK_STATUS);
			return this;
		}
	}
}
