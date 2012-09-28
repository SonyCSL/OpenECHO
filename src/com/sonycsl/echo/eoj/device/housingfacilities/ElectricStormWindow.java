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
	 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43
	 */
	protected abstract boolean setOpenCloseSetting1(byte[] edt);
	/**
	 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43
	 */
	protected abstract byte[] getOpenCloseSetting1();
	/**
	 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38
	 */
	protected boolean setExtentOfOpening1(byte[] edt) {return false;}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38
	 */
	protected byte[] getExtentOfOpening1() {return null;}
	/**
	 * Blind angle<br>0x00 to 0xB4 (0 to 180  )
	 */
	protected boolean setBlindAngleSetting(byte[] edt) {return false;}
	/**
	 * Blind angle<br>0x00 to 0xB4 (0 to 180  )
	 */
	protected byte[] getBlindAngleSetting() {return null;}
	/**
	 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43
	 */
	protected boolean setShutterSpeed(byte[] edt) {return false;}
	/**
	 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43
	 */
	protected byte[] getShutterSpeed() {return null;}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)
	 */
	protected boolean setExtentOfOpening2(byte[] edt) {return false;}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)
	 */
	protected byte[] getExtentOfOpening2() {return null;}
	/**
	 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42
	 */
	protected abstract boolean setElectricLockSetting(byte[] edt);
	/**
	 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42
	 */
	protected abstract byte[] getElectricLockSetting();
	/**
	 * Open/close<br>Open = 0x41, close = 0x42
	 */
	protected boolean setOpenCloseSetting2(byte[] edt) {return false;}
	/**
	 * Open/close<br>Open = 0x41, close = 0x42
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
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43
		 */
		protected void onSetOpenCloseSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43
		 */
		protected void onGetOpenCloseSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38
		 */
		protected void onSetExtentOfOpening1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38
		 */
		protected void onGetExtentOfOpening1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )
		 */
		protected void onSetBlindAngleSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )
		 */
		protected void onGetBlindAngleSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43
		 */
		protected void onSetShutterSpeed(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43
		 */
		protected void onGetShutterSpeed(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)
		 */
		protected void onSetExtentOfOpening2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)
		 */
		protected void onGetExtentOfOpening2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42
		 */
		protected void onSetElectricLockSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42
		 */
		protected void onGetElectricLockSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Open/close<br>Open = 0x41, close = 0x42
		 */
		protected void onSetOpenCloseSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Open/close<br>Open = 0x41, close = 0x42
		 */
		protected void onGetOpenCloseSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43
		 */
		public Setter reqSetOpenCloseSetting1(byte[] edt);
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38
		 */
		public Setter reqSetExtentOfOpening1(byte[] edt);
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )
		 */
		public Setter reqSetBlindAngleSetting(byte[] edt);
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43
		 */
		public Setter reqSetShutterSpeed(byte[] edt);
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)
		 */
		public Setter reqSetExtentOfOpening2(byte[] edt);
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42
		 */
		public Setter reqSetElectricLockSetting(byte[] edt);
		/**
		 * Open/close<br>Open = 0x41, close = 0x42
		 */
		public Setter reqSetOpenCloseSetting2(byte[] edt);

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
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43
		 */
		public Getter reqGetOpenCloseSetting1();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38
		 */
		public Getter reqGetExtentOfOpening1();
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )
		 */
		public Getter reqGetBlindAngleSetting();
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43
		 */
		public Getter reqGetShutterSpeed();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)
		 */
		public Getter reqGetExtentOfOpening2();
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42
		 */
		public Getter reqGetElectricLockSetting();
		/**
		 * Open/close<br>Open = 0x41, close = 0x42
		 */
		public Getter reqGetOpenCloseSetting2();

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
		 * Open(ed)/close(d)/stop(ped)<br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43
		 */
		public Informer reqInformOpenCloseSetting1();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br>0x31 to 0x38
		 */
		public Informer reqInformExtentOfOpening1();
		/**
		 * Blind angle<br>0x00 to 0xB4 (0 to 180  )
		 */
		public Informer reqInformBlindAngleSetting();
		/**
		 * Low/medium/high<br>Low = 0x41, medium = 0x42, high = 0x43
		 */
		public Informer reqInformShutterSpeed();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br>0x00 to 0xFF (0 to 255)
		 */
		public Informer reqInformExtentOfOpening2();
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br>Activated = 0x41, deactivated = 0x42
		 */
		public Informer reqInformElectricLockSetting();
		/**
		 * Open/close<br>Open = 0x41, close = 0x42
		 */
		public Informer reqInformOpenCloseSetting2();

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
