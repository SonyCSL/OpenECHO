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

public abstract class ElectricStormWindow extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = ElectricStormWindow.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x63;

	protected static final byte EPC_OPEN_CLOSE_SETTING1 = (byte)0xE0;
	protected static final byte EPC_EXTENT_OF_OPENING1 = (byte)0xE1;
	protected static final byte EPC_BLIND_ANGLE_SETTING = (byte)0xE2;
	protected static final byte EPC_SHUTTER_SPEED = (byte)0xE3;
	protected static final byte EPC_EXTENT_OF_OPENING2 = (byte)0xE4;
	protected static final byte EPC_ELECTRIC_LOCK_SETTING = (byte)0xE5;
	protected static final byte EPC_OPEN_CLOSE_SETTING2 = (byte)0xE7;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract boolean setOpenCloseSetting1(byte[] edt);
	/**
	 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract byte[] getOpenCloseSetting1();
	/**
	 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setExtentOfOpening1(byte[] edt) {return false;}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getExtentOfOpening1() {return null;}
	/**
	 * Blind angle<br>0x00 to 0xB4 (0 to 180  )<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBlindAngleSetting(byte[] edt) {return false;}
	/**
	 * Blind angle<br>0x00 to 0xB4 (0 to 180  )<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBlindAngleSetting() {return null;}
	/**
	 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setShutterSpeed(byte[] edt) {return false;}
	/**
	 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getShutterSpeed() {return null;}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setExtentOfOpening2(byte[] edt) {return false;}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getExtentOfOpening2() {return null;}
	/**
	 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42<br><br>Data type : unsign ed char unsign ed char<br>Data size : 1 byte 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract boolean setElectricLockSetting(byte[] edt);
	/**
	 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42<br><br>Data type : unsign ed char unsign ed char<br>Data size : 1 byte 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract byte[] getElectricLockSetting();
	/**
	 * Open/close<br>Open = 0x41, close = 0x42<br><br>Data type : unsign ed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional<br>Announcement at status change
	 */
	protected boolean setOpenCloseSetting2(byte[] edt) {return false;}
	/**
	 * Open/close<br>Open = 0x41, close = 0x42<br><br>Data type : unsign ed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional<br>Announcement at status change
	 */
	protected byte[] getOpenCloseSetting2() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPEN_CLOSE_SETTING1:
			res.addProperty(epc, edt, setOpenCloseSetting1(edt));
			break;
		case EPC_EXTENT_OF_OPENING1:
			res.addProperty(epc, edt, setExtentOfOpening1(edt));
			break;
		case EPC_BLIND_ANGLE_SETTING:
			res.addProperty(epc, edt, setBlindAngleSetting(edt));
			break;
		case EPC_SHUTTER_SPEED:
			res.addProperty(epc, edt, setShutterSpeed(edt));
			break;
		case EPC_EXTENT_OF_OPENING2:
			res.addProperty(epc, edt, setExtentOfOpening2(edt));
			break;
		case EPC_ELECTRIC_LOCK_SETTING:
			res.addProperty(epc, edt, setElectricLockSetting(edt));
			break;
		case EPC_OPEN_CLOSE_SETTING2:
			res.addProperty(epc, edt, setOpenCloseSetting2(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPEN_CLOSE_SETTING1:
			edt = getOpenCloseSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EXTENT_OF_OPENING1:
			edt = getExtentOfOpening1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BLIND_ANGLE_SETTING:
			edt = getBlindAngleSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHUTTER_SPEED:
			edt = getShutterSpeed();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EXTENT_OF_OPENING2:
			edt = getExtentOfOpening2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ELECTRIC_LOCK_SETTING:
			edt = getElectricLockSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OPEN_CLOSE_SETTING2:
			edt = getOpenCloseSetting2();
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
			case EPC_OPEN_CLOSE_SETTING1:
				onSetOpenCloseSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_EXTENT_OF_OPENING1:
				onSetExtentOfOpening1(eoj, tid, (pdc != 0));
				break;
			case EPC_BLIND_ANGLE_SETTING:
				onSetBlindAngleSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SHUTTER_SPEED:
				onSetShutterSpeed(eoj, tid, (pdc != 0));
				break;
			case EPC_EXTENT_OF_OPENING2:
				onSetExtentOfOpening2(eoj, tid, (pdc != 0));
				break;
			case EPC_ELECTRIC_LOCK_SETTING:
				onSetElectricLockSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OPEN_CLOSE_SETTING2:
				onSetOpenCloseSetting2(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_OPEN_CLOSE_SETTING1:
				onGetOpenCloseSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_EXTENT_OF_OPENING1:
				onGetExtentOfOpening1(eoj, tid, pdc, edt);
				break;
			case EPC_BLIND_ANGLE_SETTING:
				onGetBlindAngleSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SHUTTER_SPEED:
				onGetShutterSpeed(eoj, tid, pdc, edt);
				break;
			case EPC_EXTENT_OF_OPENING2:
				onGetExtentOfOpening2(eoj, tid, pdc, edt);
				break;
			case EPC_ELECTRIC_LOCK_SETTING:
				onGetElectricLockSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OPEN_CLOSE_SETTING2:
				onGetOpenCloseSetting2(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onSetOpenCloseSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onGetOpenCloseSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetExtentOfOpening1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetExtentOfOpening1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBlindAngleSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBlindAngleSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetShutterSpeed(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetShutterSpeed(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetExtentOfOpening2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetExtentOfOpening2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42<br><br>Data type : unsign ed char unsign ed char<br>Data size : 1 byte 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onSetElectricLockSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42<br><br>Data type : unsign ed char unsign ed char<br>Data size : 1 byte 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onGetElectricLockSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Open/close<br>Open = 0x41, close = 0x42<br><br>Data type : unsign ed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		protected void onSetOpenCloseSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Open/close<br>Open = 0x41, close = 0x42<br><br>Data type : unsign ed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		protected void onGetOpenCloseSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Setter reqSetOpenCloseSetting1(byte[] edt);
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetExtentOfOpening1(byte[] edt);
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBlindAngleSetting(byte[] edt);
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetShutterSpeed(byte[] edt);
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetExtentOfOpening2(byte[] edt);
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42<br><br>Data type : unsign ed char unsign ed char<br>Data size : 1 byte 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Setter reqSetElectricLockSetting(byte[] edt);
		/**
		 * Open/close<br>Open = 0x41, close = 0x42<br><br>Data type : unsign ed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Setter reqSetOpenCloseSetting2(byte[] edt);
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
		public Setter reqSetOpenCloseSetting1(byte[] edt) {
			addProperty(EPC_OPEN_CLOSE_SETTING1, edt, setOpenCloseSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetExtentOfOpening1(byte[] edt) {
			addProperty(EPC_EXTENT_OF_OPENING1, edt, setExtentOfOpening1(edt));
			return this;
		}
		@Override
		public Setter reqSetBlindAngleSetting(byte[] edt) {
			addProperty(EPC_BLIND_ANGLE_SETTING, edt, setBlindAngleSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetShutterSpeed(byte[] edt) {
			addProperty(EPC_SHUTTER_SPEED, edt, setShutterSpeed(edt));
			return this;
		}
		@Override
		public Setter reqSetExtentOfOpening2(byte[] edt) {
			addProperty(EPC_EXTENT_OF_OPENING2, edt, setExtentOfOpening2(edt));
			return this;
		}
		@Override
		public Setter reqSetElectricLockSetting(byte[] edt) {
			addProperty(EPC_ELECTRIC_LOCK_SETTING, edt, setElectricLockSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOpenCloseSetting2(byte[] edt) {
			addProperty(EPC_OPEN_CLOSE_SETTING2, edt, setOpenCloseSetting2(edt));
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
		public Setter reqSetOpenCloseSetting1(byte[] edt) {
			addProperty(EPC_OPEN_CLOSE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetExtentOfOpening1(byte[] edt) {
			addProperty(EPC_EXTENT_OF_OPENING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBlindAngleSetting(byte[] edt) {
			addProperty(EPC_BLIND_ANGLE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetShutterSpeed(byte[] edt) {
			addProperty(EPC_SHUTTER_SPEED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetExtentOfOpening2(byte[] edt) {
			addProperty(EPC_EXTENT_OF_OPENING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetElectricLockSetting(byte[] edt) {
			addProperty(EPC_ELECTRIC_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOpenCloseSetting2(byte[] edt) {
			addProperty(EPC_OPEN_CLOSE_SETTING2, edt, (edt != null && (edt.length == 1)));
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
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Getter reqGetOpenCloseSetting1();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetExtentOfOpening1();
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBlindAngleSetting();
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetShutterSpeed();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetExtentOfOpening2();
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42<br><br>Data type : unsign ed char unsign ed char<br>Data size : 1 byte 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Getter reqGetElectricLockSetting();
		/**
		 * Open/close<br>Open = 0x41, close = 0x42<br><br>Data type : unsign ed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Getter reqGetOpenCloseSetting2();
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
		public Getter reqGetOpenCloseSetting1() {
			byte[] edt = getOpenCloseSetting1();
			addProperty(EPC_OPEN_CLOSE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetExtentOfOpening1() {
			byte[] edt = getExtentOfOpening1();
			addProperty(EPC_EXTENT_OF_OPENING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBlindAngleSetting() {
			byte[] edt = getBlindAngleSetting();
			addProperty(EPC_BLIND_ANGLE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetShutterSpeed() {
			byte[] edt = getShutterSpeed();
			addProperty(EPC_SHUTTER_SPEED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetExtentOfOpening2() {
			byte[] edt = getExtentOfOpening2();
			addProperty(EPC_EXTENT_OF_OPENING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetElectricLockSetting() {
			byte[] edt = getElectricLockSetting();
			addProperty(EPC_ELECTRIC_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOpenCloseSetting2() {
			byte[] edt = getOpenCloseSetting2();
			addProperty(EPC_OPEN_CLOSE_SETTING2, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetOpenCloseSetting1() {
			addProperty(EPC_OPEN_CLOSE_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetExtentOfOpening1() {
			addProperty(EPC_EXTENT_OF_OPENING1);
			return this;
		}
		@Override
		public Getter reqGetBlindAngleSetting() {
			addProperty(EPC_BLIND_ANGLE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetShutterSpeed() {
			addProperty(EPC_SHUTTER_SPEED);
			return this;
		}
		@Override
		public Getter reqGetExtentOfOpening2() {
			addProperty(EPC_EXTENT_OF_OPENING2);
			return this;
		}
		@Override
		public Getter reqGetElectricLockSetting() {
			addProperty(EPC_ELECTRIC_LOCK_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOpenCloseSetting2() {
			addProperty(EPC_OPEN_CLOSE_SETTING2);
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
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Informer reqInformOpenCloseSetting1();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformExtentOfOpening1();
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBlindAngleSetting();
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformShutterSpeed();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformExtentOfOpening2();
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42<br><br>Data type : unsign ed char unsign ed char<br>Data size : 1 byte 1 byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Informer reqInformElectricLockSetting();
		/**
		 * Open/close<br>Open = 0x41, close = 0x42<br><br>Data type : unsign ed char<br>Data size : 1 bytes<br>Set : optional<br>Get : optional<br>Announcement at status change
		 */
		public Informer reqInformOpenCloseSetting2();
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
		public Informer reqInformOpenCloseSetting1() {
			byte[] edt = getOpenCloseSetting1();
			addProperty(EPC_OPEN_CLOSE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformExtentOfOpening1() {
			byte[] edt = getExtentOfOpening1();
			addProperty(EPC_EXTENT_OF_OPENING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBlindAngleSetting() {
			byte[] edt = getBlindAngleSetting();
			addProperty(EPC_BLIND_ANGLE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShutterSpeed() {
			byte[] edt = getShutterSpeed();
			addProperty(EPC_SHUTTER_SPEED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformExtentOfOpening2() {
			byte[] edt = getExtentOfOpening2();
			addProperty(EPC_EXTENT_OF_OPENING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformElectricLockSetting() {
			byte[] edt = getElectricLockSetting();
			addProperty(EPC_ELECTRIC_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOpenCloseSetting2() {
			byte[] edt = getOpenCloseSetting2();
			addProperty(EPC_OPEN_CLOSE_SETTING2, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformOpenCloseSetting1() {
			addProperty(EPC_OPEN_CLOSE_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformExtentOfOpening1() {
			addProperty(EPC_EXTENT_OF_OPENING1);
			return this;
		}
		@Override
		public Informer reqInformBlindAngleSetting() {
			addProperty(EPC_BLIND_ANGLE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformShutterSpeed() {
			addProperty(EPC_SHUTTER_SPEED);
			return this;
		}
		@Override
		public Informer reqInformExtentOfOpening2() {
			addProperty(EPC_EXTENT_OF_OPENING2);
			return this;
		}
		@Override
		public Informer reqInformElectricLockSetting() {
			addProperty(EPC_ELECTRIC_LOCK_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOpenCloseSetting2() {
			addProperty(EPC_OPEN_CLOSE_SETTING2);
			return this;
		}
	}
}
