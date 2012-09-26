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

public abstract class ElectricLock extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = ElectricLock.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x6F;

	protected static final byte EPC_LOCK_SETTING1 = (byte)0xE0;
	protected static final byte EPC_LOCK_SETTING2 = (byte)0xE1;
	protected static final byte EPC_LOCK_STATUS_OF_DOOR_GUARD = (byte)0xE2;
	protected static final byte EPC_DOOR_OPEN_CLOSE_STATUS = (byte)0xE3;
	protected static final byte EPC_OCCUPANT_NON_OCCUPANT_STATUS = (byte)0xE4;
	protected static final byte EPC_ALARM_STATUS = (byte)0xE5;
	protected static final byte EPC_AUTO_LOCK_MODE_SETTING = (byte)0xE6;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42
	 */
	protected abstract boolean setLockSetting1(byte[] edt);
	/**
	 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42
	 */
	protected abstract byte[] getLockSetting1();
	/**
	 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42
	 */
	protected boolean setLockSetting2(byte[] edt) {return false;}
	/**
	 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42
	 */
	protected byte[] getLockSetting2() {return null;}
	/**
	 * Lock status of door guard.<br>lock=0x41, unlock=0x42
	 */
	protected byte[] getLockStatusOfDoorGuard() {return null;}
	/**
	 * Open/close status of door<br>open=0x41, close=0x42
	 */
	protected byte[] getDoorOpenCloseStatus() {return null;}
	/**
	 * Occupant/ non-occupant status of persons<br>occupant=0x41, non-occupant=0x42
	 */
	protected byte[] getOccupantNonOccupantStatus() {return null;}
	/**
	 * Atarm status of electric lock<br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44
	 */
	protected byte[] getAlarmStatus() {return null;}
	/**
	 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42
	 */
	protected boolean setAutoLockModeSetting(byte[] edt) {return false;}
	/**
	 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42
	 */
	protected byte[] getAutoLockModeSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_LOCK_SETTING1:
			res.addProperty(epc, edt, setLockSetting1(edt));
			break;
		case EPC_LOCK_SETTING2:
			res.addProperty(epc, edt, setLockSetting2(edt));
			break;
		case EPC_AUTO_LOCK_MODE_SETTING:
			res.addProperty(epc, edt, setAutoLockModeSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_LOCK_SETTING1:
			edt = getLockSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_LOCK_SETTING2:
			edt = getLockSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_LOCK_STATUS_OF_DOOR_GUARD:
			edt = getLockStatusOfDoorGuard();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DOOR_OPEN_CLOSE_STATUS:
			edt = getDoorOpenCloseStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OCCUPANT_NON_OCCUPANT_STATUS:
			edt = getOccupantNonOccupantStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ALARM_STATUS:
			edt = getAlarmStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTO_LOCK_MODE_SETTING:
			edt = getAutoLockModeSetting();
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
			case EPC_LOCK_SETTING1:
				onSetLockSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_LOCK_SETTING2:
				onSetLockSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_AUTO_LOCK_MODE_SETTING:
				onSetAutoLockModeSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_LOCK_SETTING1:
				onGetLockSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_LOCK_SETTING2:
				onGetLockSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_LOCK_STATUS_OF_DOOR_GUARD:
				onGetLockStatusOfDoorGuard(eoj, tid, pdc, edt);
				break;
			case EPC_DOOR_OPEN_CLOSE_STATUS:
				onGetDoorOpenCloseStatus(eoj, tid, pdc, edt);
				break;
			case EPC_OCCUPANT_NON_OCCUPANT_STATUS:
				onGetOccupantNonOccupantStatus(eoj, tid, pdc, edt);
				break;
			case EPC_ALARM_STATUS:
				onGetAlarmStatus(eoj, tid, pdc, edt);
				break;
			case EPC_AUTO_LOCK_MODE_SETTING:
				onGetAutoLockModeSetting(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42
		 */
		protected void onSetLockSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42
		 */
		protected void onGetLockSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42
		 */
		protected void onSetLockSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42
		 */
		protected void onGetLockSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Lock status of door guard.<br>lock=0x41, unlock=0x42
		 */
		protected void onGetLockStatusOfDoorGuard(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Open/close status of door<br>open=0x41, close=0x42
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Occupant/ non-occupant status of persons<br>occupant=0x41, non-occupant=0x42
		 */
		protected void onGetOccupantNonOccupantStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Atarm status of electric lock<br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44
		 */
		protected void onGetAlarmStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42
		 */
		protected void onSetAutoLockModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42
		 */
		protected void onGetAutoLockModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42
		 */
		public Setter reqSetLockSetting1(byte[] edt);
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42
		 */
		public Setter reqSetLockSetting2(byte[] edt);
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42
		 */
		public Setter reqSetAutoLockModeSetting(byte[] edt);

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
		public Setter reqSetLockSetting1(byte[] edt) {
			addProperty(EPC_LOCK_SETTING1, edt, setLockSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetLockSetting2(byte[] edt) {
			addProperty(EPC_LOCK_SETTING2, edt, setLockSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetAutoLockModeSetting(byte[] edt) {
			addProperty(EPC_AUTO_LOCK_MODE_SETTING, edt, setAutoLockModeSetting(edt));
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
		public Setter reqSetLockSetting1(byte[] edt) {
			addProperty(EPC_LOCK_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetLockSetting2(byte[] edt) {
			addProperty(EPC_LOCK_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetAutoLockModeSetting(byte[] edt) {
			addProperty(EPC_AUTO_LOCK_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42
		 */
		public Getter reqGetLockSetting1();
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42
		 */
		public Getter reqGetLockSetting2();
		/**
		 * Lock status of door guard.<br>lock=0x41, unlock=0x42
		 */
		public Getter reqGetLockStatusOfDoorGuard();
		/**
		 * Open/close status of door<br>open=0x41, close=0x42
		 */
		public Getter reqGetDoorOpenCloseStatus();
		/**
		 * Occupant/ non-occupant status of persons<br>occupant=0x41, non-occupant=0x42
		 */
		public Getter reqGetOccupantNonOccupantStatus();
		/**
		 * Atarm status of electric lock<br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44
		 */
		public Getter reqGetAlarmStatus();
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42
		 */
		public Getter reqGetAutoLockModeSetting();

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
		public Getter reqGetLockSetting1() {
			byte[] edt = getLockSetting1();
			addProperty(EPC_LOCK_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetLockSetting2() {
			byte[] edt = getLockSetting2();
			addProperty(EPC_LOCK_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetLockStatusOfDoorGuard() {
			byte[] edt = getLockStatusOfDoorGuard();
			addProperty(EPC_LOCK_STATUS_OF_DOOR_GUARD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDoorOpenCloseStatus() {
			byte[] edt = getDoorOpenCloseStatus();
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOccupantNonOccupantStatus() {
			byte[] edt = getOccupantNonOccupantStatus();
			addProperty(EPC_OCCUPANT_NON_OCCUPANT_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAlarmStatus() {
			byte[] edt = getAlarmStatus();
			addProperty(EPC_ALARM_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutoLockModeSetting() {
			byte[] edt = getAutoLockModeSetting();
			addProperty(EPC_AUTO_LOCK_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetLockSetting1() {
			addProperty(EPC_LOCK_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetLockSetting2() {
			addProperty(EPC_LOCK_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetLockStatusOfDoorGuard() {
			addProperty(EPC_LOCK_STATUS_OF_DOOR_GUARD);
			return this;
		}
		@Override
		public Getter reqGetDoorOpenCloseStatus() {
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Getter reqGetOccupantNonOccupantStatus() {
			addProperty(EPC_OCCUPANT_NON_OCCUPANT_STATUS);
			return this;
		}
		@Override
		public Getter reqGetAlarmStatus() {
			addProperty(EPC_ALARM_STATUS);
			return this;
		}
		@Override
		public Getter reqGetAutoLockModeSetting() {
			addProperty(EPC_AUTO_LOCK_MODE_SETTING);
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
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42
		 */
		public Informer reqInformLockSetting1();
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42
		 */
		public Informer reqInformLockSetting2();
		/**
		 * Lock status of door guard.<br>lock=0x41, unlock=0x42
		 */
		public Informer reqInformLockStatusOfDoorGuard();
		/**
		 * Open/close status of door<br>open=0x41, close=0x42
		 */
		public Informer reqInformDoorOpenCloseStatus();
		/**
		 * Occupant/ non-occupant status of persons<br>occupant=0x41, non-occupant=0x42
		 */
		public Informer reqInformOccupantNonOccupantStatus();
		/**
		 * Atarm status of electric lock<br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44
		 */
		public Informer reqInformAlarmStatus();
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42
		 */
		public Informer reqInformAutoLockModeSetting();

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
		public Informer reqInformLockSetting1() {
			byte[] edt = getLockSetting1();
			addProperty(EPC_LOCK_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformLockSetting2() {
			byte[] edt = getLockSetting2();
			addProperty(EPC_LOCK_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformLockStatusOfDoorGuard() {
			byte[] edt = getLockStatusOfDoorGuard();
			addProperty(EPC_LOCK_STATUS_OF_DOOR_GUARD, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDoorOpenCloseStatus() {
			byte[] edt = getDoorOpenCloseStatus();
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOccupantNonOccupantStatus() {
			byte[] edt = getOccupantNonOccupantStatus();
			addProperty(EPC_OCCUPANT_NON_OCCUPANT_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAlarmStatus() {
			byte[] edt = getAlarmStatus();
			addProperty(EPC_ALARM_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutoLockModeSetting() {
			byte[] edt = getAutoLockModeSetting();
			addProperty(EPC_AUTO_LOCK_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformLockSetting1() {
			addProperty(EPC_LOCK_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformLockSetting2() {
			addProperty(EPC_LOCK_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformLockStatusOfDoorGuard() {
			addProperty(EPC_LOCK_STATUS_OF_DOOR_GUARD);
			return this;
		}
		@Override
		public Informer reqInformDoorOpenCloseStatus() {
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Informer reqInformOccupantNonOccupantStatus() {
			addProperty(EPC_OCCUPANT_NON_OCCUPANT_STATUS);
			return this;
		}
		@Override
		public Informer reqInformAlarmStatus() {
			addProperty(EPC_ALARM_STATUS);
			return this;
		}
		@Override
		public Informer reqInformAutoLockModeSetting() {
			addProperty(EPC_AUTO_LOCK_MODE_SETTING);
			return this;
		}

	}
}
