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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x6F;
	
	public ElectricLock() {
		setReceiver(new Receiver());
	}

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
	 * Lock/unlock of main electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract boolean setLockSetting1(byte[] edt);
	private final boolean _setLockSetting1(byte epc, byte[] edt) {
		boolean success = setLockSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Lock/unlock of main electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract byte[] getLockSetting1();
	private final byte[] _getLockSetting1(byte epc) {
		byte[] edt = getLockSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Lock/unlock of sub electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setLockSetting2(byte[] edt) {return false;}
	private final boolean _setLockSetting2(byte epc, byte[] edt) {
		boolean success = setLockSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Lock/unlock of sub electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getLockSetting2() {return null;}
	private final byte[] _getLockSetting2(byte epc) {
		byte[] edt = getLockSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Lock status of door guard.<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock status of door guard<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getLockStatusOfDoorGuard() {return null;}
	private final byte[] _getLockStatusOfDoorGuard(byte epc) {
		byte[] edt = getLockStatusOfDoorGuard();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Open/close status of door<br><br>open=0x41, close=0x42<br><br>Name : Door open/close status<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getDoorOpenCloseStatus() {return null;}
	private final byte[] _getDoorOpenCloseStatus(byte epc) {
		byte[] edt = getDoorOpenCloseStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Occupant/ non-occupant status of persons<br><br>occupant=0x41, non-occupant=0x42<br><br>Name : Occupant/ non-occupant status<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getOccupantNonOccupantStatus() {return null;}
	private final byte[] _getOccupantNonOccupantStatus(byte epc) {
		byte[] edt = getOccupantNonOccupantStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Atarm status of electric lock<br><br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44<br><br>Name : Alarm status<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getAlarmStatus() {return null;}
	private final byte[] _getAlarmStatus(byte epc) {
		byte[] edt = getAlarmStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets ON/OFF of auto lock mode and get the status<br><br>ON=0x41, OFF=0x42<br><br>Name : Auto lock mode setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setAutoLockModeSetting(byte[] edt) {return false;}
	private final boolean _setAutoLockModeSetting(byte epc, byte[] edt) {
		boolean success = setAutoLockModeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets ON/OFF of auto lock mode and get the status<br><br>ON=0x41, OFF=0x42<br><br>Name : Auto lock mode setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getAutoLockModeSetting() {return null;}
	private final byte[] _getAutoLockModeSetting(byte epc) {
		byte[] edt = getAutoLockModeSetting();
		onInvokedGetMethod(epc, edt);
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
		 * Lock/unlock of main electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onSetLockSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetLockSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetLockSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Lock/unlock of main electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onGetLockSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLockSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLockSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Lock/unlock of sub electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetLockSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetLockSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetLockSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Lock/unlock of sub electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetLockSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLockSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLockSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Lock status of door guard.<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock status of door guard<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetLockStatusOfDoorGuard(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetLockStatusOfDoorGuard(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetLockStatusOfDoorGuard(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Open/close status of door<br><br>open=0x41, close=0x42<br><br>Name : Door open/close status<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDoorOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDoorOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Occupant/ non-occupant status of persons<br><br>occupant=0x41, non-occupant=0x42<br><br>Name : Occupant/ non-occupant status<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetOccupantNonOccupantStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOccupantNonOccupantStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOccupantNonOccupantStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Atarm status of electric lock<br><br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44<br><br>Name : Alarm status<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetAlarmStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAlarmStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAlarmStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br><br>ON=0x41, OFF=0x42<br><br>Name : Auto lock mode setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetAutoLockModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetAutoLockModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetAutoLockModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br><br>ON=0x41, OFF=0x42<br><br>Name : Auto lock mode setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetAutoLockModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetAutoLockModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetAutoLockModeSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Lock/unlock of main electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Setter reqSetLockSetting1(byte[] edt) {
			addProperty(EPC_LOCK_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Lock/unlock of sub electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetLockSetting2(byte[] edt) {
			addProperty(EPC_LOCK_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br><br>ON=0x41, OFF=0x42<br><br>Name : Auto lock mode setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetAutoLockModeSetting(byte[] edt) {
			addProperty(EPC_AUTO_LOCK_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Lock/unlock of main electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Getter reqGetLockSetting1() {
			addProperty(EPC_LOCK_SETTING1);
			return this;
		}
		/**
		 * Lock/unlock of sub electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetLockSetting2() {
			addProperty(EPC_LOCK_SETTING2);
			return this;
		}
		/**
		 * Lock status of door guard.<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock status of door guard<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetLockStatusOfDoorGuard() {
			addProperty(EPC_LOCK_STATUS_OF_DOOR_GUARD);
			return this;
		}
		/**
		 * Open/close status of door<br><br>open=0x41, close=0x42<br><br>Name : Door open/close status<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetDoorOpenCloseStatus() {
			addProperty(EPC_DOOR_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Occupant/ non-occupant status of persons<br><br>occupant=0x41, non-occupant=0x42<br><br>Name : Occupant/ non-occupant status<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetOccupantNonOccupantStatus() {
			addProperty(EPC_OCCUPANT_NON_OCCUPANT_STATUS);
			return this;
		}
		/**
		 * Atarm status of electric lock<br><br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44<br><br>Name : Alarm status<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetAlarmStatus() {
			addProperty(EPC_ALARM_STATUS);
			return this;
		}
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br><br>ON=0x41, OFF=0x42<br><br>Name : Auto lock mode setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetAutoLockModeSetting() {
			addProperty(EPC_AUTO_LOCK_MODE_SETTING);
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
		 * Lock/unlock of main electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Informer reqInformLockSetting1();
		/**
		 * Lock/unlock of sub electric lock<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformLockSetting2();
		/**
		 * Lock status of door guard.<br><br>lock=0x41, unlock=0x42<br><br>Name : Lock status of door guard<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformLockStatusOfDoorGuard();
		/**
		 * Open/close status of door<br><br>open=0x41, close=0x42<br><br>Name : Door open/close status<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformDoorOpenCloseStatus();
		/**
		 * Occupant/ non-occupant status of persons<br><br>occupant=0x41, non-occupant=0x42<br><br>Name : Occupant/ non-occupant status<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformOccupantNonOccupantStatus();
		/**
		 * Atarm status of electric lock<br><br>normal (no alarm)=0x40, break open=0x41, door open=0x42, manual unlocked=0x43, tampered=0x44<br><br>Name : Alarm status<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformAlarmStatus();
		/**
		 * Sets ON/OFF of auto lock mode and get the status<br><br>ON=0x41, OFF=0x42<br><br>Name : Auto lock mode setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformAutoLockModeSetting();
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
