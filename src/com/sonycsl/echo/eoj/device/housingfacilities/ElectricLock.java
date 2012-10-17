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

	public static final byte EPC_LOCK_SETTING1 = (byte)0xE0;
	public static final byte EPC_LOCK_SETTING2 = (byte)0xE1;
	public static final byte EPC_LOCK_STATUS_OF_DOOR_GUARD = (byte)0xE2;
	public static final byte EPC_DOOR_OPEN_CLOSE_STATUS = (byte)0xE3;
	public static final byte EPC_OCCUPANT_NON_OCCUPANT_STATUS = (byte)0xE4;
	public static final byte EPC_ALARM_STATUS = (byte)0xE5;
	public static final byte EPC_AUTO_LOCK_MODE_SETTING = (byte)0xE6;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract boolean setLockSetting1(byte[] edt);
	private final boolean _setLockSetting1(byte epc, byte[] edt) {
		boolean success = setLockSetting1(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract byte[] getLockSetting1();
	private final byte[] _getLockSetting1(byte epc) {
		byte[] edt = getLockSetting1();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setLockSetting2(byte[] edt) {return false;}
	private final boolean _setLockSetting2(byte epc, byte[] edt) {
		boolean success = setLockSetting2(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getLockSetting2() {return null;}
	private final byte[] _getLockSetting2(byte epc) {
		byte[] edt = getLockSetting2();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Lock status of door guard.<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getLockStatusOfDoorGuard() {return null;}
	private final byte[] _getLockStatusOfDoorGuard(byte epc) {
		byte[] edt = getLockStatusOfDoorGuard();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Open/close status of door<br>open=0x41, close=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getDoorOpenCloseStatus() {return null;}
	private final byte[] _getDoorOpenCloseStatus(byte epc) {
		byte[] edt = getDoorOpenCloseStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Occupant/ non-occupant status of persons<br>occupant=0x41, non-occupant=0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getOccupantNonOccupantStatus() {return null;}
	private final byte[] _getOccupantNonOccupantStatus(byte epc) {
		byte[] edt = getOccupantNonOccupantStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Atarm status of electric lock<br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getAlarmStatus() {return null;}
	private final byte[] _getAlarmStatus(byte epc) {
		byte[] edt = getAlarmStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setAutoLockModeSetting(byte[] edt) {return false;}
	private final boolean _setAutoLockModeSetting(byte epc, byte[] edt) {
		boolean success = setAutoLockModeSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getAutoLockModeSetting() {return null;}
	private final byte[] _getAutoLockModeSetting(byte epc) {
		byte[] edt = getAutoLockModeSetting();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_LOCK_SETTING1:
			res.addProperty(epc, edt, _setLockSetting1(epc, edt));
			break;
		case EPC_LOCK_SETTING2:
			res.addProperty(epc, edt, _setLockSetting2(epc, edt));
			break;
		case EPC_AUTO_LOCK_MODE_SETTING:
			res.addProperty(epc, edt, _setAutoLockModeSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_LOCK_SETTING1:
			edt = _getLockSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_LOCK_SETTING2:
			edt = _getLockSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_LOCK_STATUS_OF_DOOR_GUARD:
			edt = _getLockStatusOfDoorGuard(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DOOR_OPEN_CLOSE_STATUS:
			edt = _getDoorOpenCloseStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OCCUPANT_NON_OCCUPANT_STATUS:
			edt = _getOccupantNonOccupantStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ALARM_STATUS:
			edt = _getAlarmStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_AUTO_LOCK_MODE_SETTING:
			edt = _getAutoLockModeSetting(epc);
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
			case EPC_LOCK_SETTING1:
				_onSetLockSetting1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_LOCK_SETTING2:
				_onSetLockSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_AUTO_LOCK_MODE_SETTING:
				_onSetAutoLockModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_LOCK_SETTING1:
				_onGetLockSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_LOCK_SETTING2:
				_onGetLockSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_LOCK_STATUS_OF_DOOR_GUARD:
				_onGetLockStatusOfDoorGuard(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DOOR_OPEN_CLOSE_STATUS:
				_onGetDoorOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OCCUPANT_NON_OCCUPANT_STATUS:
				_onGetOccupantNonOccupantStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ALARM_STATUS:
				_onGetAlarmStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_AUTO_LOCK_MODE_SETTING:
				_onGetAutoLockModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onSetLockSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetLockSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetLockSetting1(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onGetLockSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLockSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLockSetting1(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetLockSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetLockSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetLockSetting2(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetLockSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLockSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLockSetting2(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Lock status of door guard.<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetLockStatusOfDoorGuard(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLockStatusOfDoorGuard(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLockStatusOfDoorGuard(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Open/close status of door<br>open=0x41, close=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDoorOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Occupant/ non-occupant status of persons<br>occupant=0x41, non-occupant=0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetOccupantNonOccupantStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOccupantNonOccupantStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOccupantNonOccupantStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Atarm status of electric lock<br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetAlarmStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAlarmStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAlarmStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetAutoLockModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutoLockModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutoLockModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetAutoLockModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutoLockModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutoLockModeSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Setter reqSetLockSetting1(byte[] edt);
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetLockSetting2(byte[] edt);
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetAutoLockModeSetting(byte[] edt);
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
		public Setter reqSetLockSetting1(byte[] edt) {
			byte epc = EPC_LOCK_SETTING1;
			addProperty(epc, edt, _setLockSetting1(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetLockSetting2(byte[] edt) {
			byte epc = EPC_LOCK_SETTING2;
			addProperty(epc, edt, _setLockSetting2(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetAutoLockModeSetting(byte[] edt) {
			byte epc = EPC_AUTO_LOCK_MODE_SETTING;
			addProperty(epc, edt, _setAutoLockModeSetting(epc, edt));
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
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Getter reqGetLockSetting1();
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetLockSetting2();
		/**
		 * Lock status of door guard.<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetLockStatusOfDoorGuard();
		/**
		 * Open/close status of door<br>open=0x41, close=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetDoorOpenCloseStatus();
		/**
		 * Occupant/ non-occupant status of persons<br>occupant=0x41, non-occupant=0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetOccupantNonOccupantStatus();
		/**
		 * Atarm status of electric lock<br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetAlarmStatus();
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetAutoLockModeSetting();
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
		public Getter reqGetLockSetting1() {
			byte epc = EPC_LOCK_SETTING1;
			byte[] edt = _getLockSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetLockSetting2() {
			byte epc = EPC_LOCK_SETTING2;
			byte[] edt = _getLockSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetLockStatusOfDoorGuard() {
			byte epc = EPC_LOCK_STATUS_OF_DOOR_GUARD;
			byte[] edt = _getLockStatusOfDoorGuard(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDoorOpenCloseStatus() {
			byte epc = EPC_DOOR_OPEN_CLOSE_STATUS;
			byte[] edt = _getDoorOpenCloseStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOccupantNonOccupantStatus() {
			byte epc = EPC_OCCUPANT_NON_OCCUPANT_STATUS;
			byte[] edt = _getOccupantNonOccupantStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAlarmStatus() {
			byte epc = EPC_ALARM_STATUS;
			byte[] edt = _getAlarmStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetAutoLockModeSetting() {
			byte epc = EPC_AUTO_LOCK_MODE_SETTING;
			byte[] edt = _getAutoLockModeSetting(epc);
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
		 * Lock/unlock of main electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Informer reqInformLockSetting1();
		/**
		 * Lock/unlock of sub electric lock<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformLockSetting2();
		/**
		 * Lock status of door guard.<br>lock=0x41, unlock=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformLockStatusOfDoorGuard();
		/**
		 * Open/close status of door<br>open=0x41, close=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformDoorOpenCloseStatus();
		/**
		 * Occupant/ non-occupant status of persons<br>occupant=0x41, non-occupant=0x42<br><br>Data type : unsigned char<br>Data size : 1 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformOccupantNonOccupantStatus();
		/**
		 * Atarm status of electric lock<br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformAlarmStatus();
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformAutoLockModeSetting();
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
		public Informer reqInformLockSetting1() {
			byte epc = EPC_LOCK_SETTING1;
			byte[] edt = _getLockSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformLockSetting2() {
			byte epc = EPC_LOCK_SETTING2;
			byte[] edt = _getLockSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformLockStatusOfDoorGuard() {
			byte epc = EPC_LOCK_STATUS_OF_DOOR_GUARD;
			byte[] edt = _getLockStatusOfDoorGuard(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDoorOpenCloseStatus() {
			byte epc = EPC_DOOR_OPEN_CLOSE_STATUS;
			byte[] edt = _getDoorOpenCloseStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOccupantNonOccupantStatus() {
			byte epc = EPC_OCCUPANT_NON_OCCUPANT_STATUS;
			byte[] edt = _getOccupantNonOccupantStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAlarmStatus() {
			byte epc = EPC_ALARM_STATUS;
			byte[] edt = _getAlarmStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformAutoLockModeSetting() {
			byte epc = EPC_AUTO_LOCK_MODE_SETTING;
			byte[] edt = _getAutoLockModeSetting(epc);
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
