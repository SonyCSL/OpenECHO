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

	protected static final byte EPC_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	protected static final byte EPC_NO_WATER_WARNING = (byte)0xB1;
	protected static final byte EPC_BOIL_UP_SETTING = (byte)0xB2;
	protected static final byte EPC_BOIL_UP_WARMER_MODE_SETTING = (byte)0xE0;
	protected static final byte EPC_SET_VALUE_OF_WARMER_TEMPERATURE = (byte)0xE1;
	protected static final byte EPC_HOT_WATER_DISCHARGE_STATUS = (byte)0xE2;
	protected static final byte EPC_LOCK_STATUS = (byte)0xE3;

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
	/**
	 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getNoWaterWarning() {return null;}
	/**
	 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBoilUpSetting(byte[] edt) {return false;}
	/**
	 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBoilUpSetting() {return null;}
	/**
	 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBoilUpWarmerModeSetting(byte[] edt) {return false;}
	/**
	 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBoilUpWarmerModeSetting() {return null;}
	/**
	 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSetValueOfWarmerTemperature(byte[] edt) {return false;}
	/**
	 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSetValueOfWarmerTemperature() {return null;}
	/**
	 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getHotWaterDischargeStatus() {return null;}
	/**
	 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getLockStatus() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_BOIL_UP_SETTING:
			res.addProperty(epc, edt, setBoilUpSetting(edt));
			break;
		case EPC_BOIL_UP_WARMER_MODE_SETTING:
			res.addProperty(epc, edt, setBoilUpWarmerModeSetting(edt));
			break;
		case EPC_SET_VALUE_OF_WARMER_TEMPERATURE:
			res.addProperty(epc, edt, setSetValueOfWarmerTemperature(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_COVER_OPEN_CLOSE_STATUS:
			edt = getCoverOpenCloseStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_NO_WATER_WARNING:
			edt = getNoWaterWarning();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BOIL_UP_SETTING:
			edt = getBoilUpSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BOIL_UP_WARMER_MODE_SETTING:
			edt = getBoilUpWarmerModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_WARMER_TEMPERATURE:
			edt = getSetValueOfWarmerTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_HOT_WATER_DISCHARGE_STATUS:
			edt = getHotWaterDischargeStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_LOCK_STATUS:
			edt = getLockStatus();
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
			case EPC_BOIL_UP_SETTING:
				onSetBoilUpSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BOIL_UP_WARMER_MODE_SETTING:
				onSetBoilUpWarmerModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_WARMER_TEMPERATURE:
				onSetSetValueOfWarmerTemperature(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_COVER_OPEN_CLOSE_STATUS:
				onGetCoverOpenCloseStatus(eoj, tid, pdc, edt);
				break;
			case EPC_NO_WATER_WARNING:
				onGetNoWaterWarning(eoj, tid, pdc, edt);
				break;
			case EPC_BOIL_UP_SETTING:
				onGetBoilUpSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BOIL_UP_WARMER_MODE_SETTING:
				onGetBoilUpWarmerModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_WARMER_TEMPERATURE:
				onGetSetValueOfWarmerTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_HOT_WATER_DISCHARGE_STATUS:
				onGetHotWaterDischargeStatus(eoj, tid, pdc, edt);
				break;
			case EPC_LOCK_STATUS:
				onGetLockStatus(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Cover open/close status<br>Cover open = 0x41, cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetCoverOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetNoWaterWarning(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBoilUpSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBoilUpSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBoilUpWarmerModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBoilUpWarmerModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSetValueOfWarmerTemperature(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSetValueOfWarmerTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetHotWaterDischargeStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetLockStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
			addProperty(EPC_BOIL_UP_SETTING, edt, setBoilUpSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBoilUpWarmerModeSetting(byte[] edt) {
			addProperty(EPC_BOIL_UP_WARMER_MODE_SETTING, edt, setBoilUpWarmerModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfWarmerTemperature(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_WARMER_TEMPERATURE, edt, setSetValueOfWarmerTemperature(edt));
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
			byte[] edt = getCoverOpenCloseStatus();
			addProperty(EPC_COVER_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetNoWaterWarning() {
			byte[] edt = getNoWaterWarning();
			addProperty(EPC_NO_WATER_WARNING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBoilUpSetting() {
			byte[] edt = getBoilUpSetting();
			addProperty(EPC_BOIL_UP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBoilUpWarmerModeSetting() {
			byte[] edt = getBoilUpWarmerModeSetting();
			addProperty(EPC_BOIL_UP_WARMER_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfWarmerTemperature() {
			byte[] edt = getSetValueOfWarmerTemperature();
			addProperty(EPC_SET_VALUE_OF_WARMER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetHotWaterDischargeStatus() {
			byte[] edt = getHotWaterDischargeStatus();
			addProperty(EPC_HOT_WATER_DISCHARGE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetLockStatus() {
			byte[] edt = getLockStatus();
			addProperty(EPC_LOCK_STATUS, edt, (edt != null && (edt.length == 1)));
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
			byte[] edt = getCoverOpenCloseStatus();
			addProperty(EPC_COVER_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformNoWaterWarning() {
			byte[] edt = getNoWaterWarning();
			addProperty(EPC_NO_WATER_WARNING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBoilUpSetting() {
			byte[] edt = getBoilUpSetting();
			addProperty(EPC_BOIL_UP_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBoilUpWarmerModeSetting() {
			byte[] edt = getBoilUpWarmerModeSetting();
			addProperty(EPC_BOIL_UP_WARMER_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfWarmerTemperature() {
			byte[] edt = getSetValueOfWarmerTemperature();
			addProperty(EPC_SET_VALUE_OF_WARMER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformHotWaterDischargeStatus() {
			byte[] edt = getHotWaterDischargeStatus();
			addProperty(EPC_HOT_WATER_DISCHARGE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformLockStatus() {
			byte[] edt = getLockStatus();
			addProperty(EPC_LOCK_STATUS, edt, (edt != null && (edt.length == 1)));
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
