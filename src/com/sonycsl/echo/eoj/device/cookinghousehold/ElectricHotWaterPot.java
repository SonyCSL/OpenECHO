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
	 * Cover open/close status<br>Cover open = 0x41, cover closed = 0x42
	 */
	protected byte[] getCoverOpenCloseStatus() {return null;}
	/**
	 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40
	 */
	protected byte[] getNoWaterWarning() {return null;}
	/**
	 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42
	 */
	protected boolean setBoilUpSetting(byte[] edt) {return false;}
	/**
	 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42
	 */
	protected byte[] getBoilUpSetting() {return null;}
	/**
	 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43
	 */
	protected boolean setBoilUpWarmerModeSetting(byte[] edt) {return false;}
	/**
	 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43
	 */
	protected byte[] getBoilUpWarmerModeSetting() {return null;}
	/**
	 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)
	 */
	protected boolean setSetValueOfWarmerTemperature(byte[] edt) {return false;}
	/**
	 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)
	 */
	protected byte[] getSetValueOfWarmerTemperature() {return null;}
	/**
	 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42
	 */
	protected byte[] getHotWaterDischargeStatus() {return null;}
	/**
	 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42
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
		 * Cover open/close status<br>Cover open = 0x41, cover closed = 0x42
		 */
		protected void onGetCoverOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40
		 */
		protected void onGetNoWaterWarning(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42
		 */
		protected void onSetBoilUpSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42
		 */
		protected void onGetBoilUpSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43
		 */
		protected void onSetBoilUpWarmerModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43
		 */
		protected void onGetBoilUpWarmerModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)
		 */
		protected void onSetSetValueOfWarmerTemperature(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)
		 */
		protected void onGetSetValueOfWarmerTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42
		 */
		protected void onGetHotWaterDischargeStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42
		 */
		protected void onGetLockStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42
		 */
		public Setter reqSetBoilUpSetting(byte[] edt);
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43
		 */
		public Setter reqSetBoilUpWarmerModeSetting(byte[] edt);
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)
		 */
		public Setter reqSetSetValueOfWarmerTemperature(byte[] edt);

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
		 * Cover open/close status<br>Cover open = 0x41, cover closed = 0x42
		 */
		public Getter reqGetCoverOpenCloseStatus();
		/**
		 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40
		 */
		public Getter reqGetNoWaterWarning();
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42
		 */
		public Getter reqGetBoilUpSetting();
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43
		 */
		public Getter reqGetBoilUpWarmerModeSetting();
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)
		 */
		public Getter reqGetSetValueOfWarmerTemperature();
		/**
		 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42
		 */
		public Getter reqGetHotWaterDischargeStatus();
		/**
		 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42
		 */
		public Getter reqGetLockStatus();

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
		 * Cover open/close status<br>Cover open = 0x41, cover closed = 0x42
		 */
		public Informer reqInformCoverOpenCloseStatus();
		/**
		 * Notifies that electric hot water pot is emptied of water.<br>No-water condition found = 0x41 No-water condition not found = 0x40
		 */
		public Informer reqInformNoWaterWarning();
		/**
		 * Boil-up setting<br>Boil-up start - 0x41 Boil-up stop/warmer = 0x42
		 */
		public Informer reqInformBoilUpSetting();
		/**
		 * This property indicates citric acid cleaning, normal warmer, or power-saving warmer mode.<br>Citric acid cleaning = 0x41, normal warmer = 0x42, power-saving warmer = 0x43
		 */
		public Informer reqInformBoilUpWarmerModeSetting();
		/**
		 * This property indicates set value of warmer temperature in .C.<br>0x00.0x64 (0.100)
		 */
		public Informer reqInformSetValueOfWarmerTemperature();
		/**
		 * Hot water discharge status<br>Hot water discharged = 0x41, hot water not discharged = 0x42
		 */
		public Informer reqInformHotWaterDischargeStatus();
		/**
		 * Hot water discharge lock status<br>Locked = 0x41, unlocked = 0x42
		 */
		public Informer reqInformLockStatus();

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
