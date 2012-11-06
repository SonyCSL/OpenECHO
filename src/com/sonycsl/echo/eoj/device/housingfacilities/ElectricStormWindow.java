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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x63;
	
	public ElectricStormWindow() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_OPEN_CLOSE_SETTING1 = (byte)0xE0;
	public static final byte EPC_EXTENT_OF_OPENING1 = (byte)0xE1;
	public static final byte EPC_BLIND_ANGLE_SETTING = (byte)0xE2;
	public static final byte EPC_SHUTTER_SPEED = (byte)0xE3;
	public static final byte EPC_EXTENT_OF_OPENING2 = (byte)0xE4;
	public static final byte EPC_ELECTRIC_LOCK_SETTING = (byte)0xE5;
	public static final byte EPC_OPEN_CLOSE_SETTING2 = (byte)0xE7;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * Open(ed)/close(d)/stop(ped)<br><br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Name : Open/close setting 1<br>EPC : 0xE0<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract boolean setOpenCloseSetting1(byte[] edt);
	private final boolean _setOpenCloseSetting1(byte epc, byte[] edt) {
		boolean success = setOpenCloseSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Open(ed)/close(d)/stop(ped)<br><br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Name : Open/close setting 1<br>EPC : 0xE0<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract byte[] getOpenCloseSetting1();
	private final byte[] _getOpenCloseSetting1(byte epc) {
		byte[] edt = getOpenCloseSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Extent of opening 1<br>EPC : 0xE1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setExtentOfOpening1(byte[] edt) {return false;}
	private final boolean _setExtentOfOpening1(byte epc, byte[] edt) {
		boolean success = setExtentOfOpening1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Extent of opening 1<br>EPC : 0xE1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getExtentOfOpening1() {return null;}
	private final byte[] _getExtentOfOpening1(byte epc) {
		byte[] edt = getExtentOfOpening1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Blind angle<br><br>0x00 to 0xB4 (0 to 180  )<br><br>Name : Blind angle setting<br>EPC : 0xE2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBlindAngleSetting(byte[] edt) {return false;}
	private final boolean _setBlindAngleSetting(byte epc, byte[] edt) {
		boolean success = setBlindAngleSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Blind angle<br><br>0x00 to 0xB4 (0 to 180  )<br><br>Name : Blind angle setting<br>EPC : 0xE2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBlindAngleSetting() {return null;}
	private final byte[] _getBlindAngleSetting(byte epc) {
		byte[] edt = getBlindAngleSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Low/medium/high<br><br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Name : Shutter speed<br>EPC : 0xE3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setShutterSpeed(byte[] edt) {return false;}
	private final boolean _setShutterSpeed(byte epc, byte[] edt) {
		boolean success = setShutterSpeed(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Low/medium/high<br><br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Name : Shutter speed<br>EPC : 0xE3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getShutterSpeed() {return null;}
	private final byte[] _getShutterSpeed(byte epc) {
		byte[] edt = getShutterSpeed();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br><br>0x00 to 0xFF (0 to 255)<br><br>Name : Extent of opening 2<br>EPC : 0xE4<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setExtentOfOpening2(byte[] edt) {return false;}
	private final boolean _setExtentOfOpening2(byte epc, byte[] edt) {
		boolean success = setExtentOfOpening2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br><br>0x00 to 0xFF (0 to 255)<br><br>Name : Extent of opening 2<br>EPC : 0xE4<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getExtentOfOpening2() {return null;}
	private final byte[] _getExtentOfOpening2(byte epc) {
		byte[] edt = getExtentOfOpening2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br><br>Activated = 0x41, deactivated = 0x42<br><br>Name : Electric lock setting<br>EPC : 0xE5<br>Data Type : unsign ed char unsign ed char<br>Data Size(Byte) : 1 byte 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract boolean setElectricLockSetting(byte[] edt);
	private final boolean _setElectricLockSetting(byte epc, byte[] edt) {
		boolean success = setElectricLockSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br><br>Activated = 0x41, deactivated = 0x42<br><br>Name : Electric lock setting<br>EPC : 0xE5<br>Data Type : unsign ed char unsign ed char<br>Data Size(Byte) : 1 byte 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
	 */
	protected abstract byte[] getElectricLockSetting();
	private final byte[] _getElectricLockSetting(byte epc) {
		byte[] edt = getElectricLockSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting 2<br>EPC : 0xE7<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected boolean setOpenCloseSetting2(byte[] edt) {return false;}
	private final boolean _setOpenCloseSetting2(byte epc, byte[] edt) {
		boolean success = setOpenCloseSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting 2<br>EPC : 0xE7<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getOpenCloseSetting2() {return null;}
	private final byte[] _getOpenCloseSetting2(byte epc) {
		byte[] edt = getOpenCloseSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPEN_CLOSE_SETTING1:
			res.addProperty(epc, edt, _setOpenCloseSetting1(epc, edt));
			break;
		case EPC_EXTENT_OF_OPENING1:
			res.addProperty(epc, edt, _setExtentOfOpening1(epc, edt));
			break;
		case EPC_BLIND_ANGLE_SETTING:
			res.addProperty(epc, edt, _setBlindAngleSetting(epc, edt));
			break;
		case EPC_SHUTTER_SPEED:
			res.addProperty(epc, edt, _setShutterSpeed(epc, edt));
			break;
		case EPC_EXTENT_OF_OPENING2:
			res.addProperty(epc, edt, _setExtentOfOpening2(epc, edt));
			break;
		case EPC_ELECTRIC_LOCK_SETTING:
			res.addProperty(epc, edt, _setElectricLockSetting(epc, edt));
			break;
		case EPC_OPEN_CLOSE_SETTING2:
			res.addProperty(epc, edt, _setOpenCloseSetting2(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_OPEN_CLOSE_SETTING1:
			edt = _getOpenCloseSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EXTENT_OF_OPENING1:
			edt = _getExtentOfOpening1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BLIND_ANGLE_SETTING:
			edt = _getBlindAngleSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHUTTER_SPEED:
			edt = _getShutterSpeed(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EXTENT_OF_OPENING2:
			edt = _getExtentOfOpening2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ELECTRIC_LOCK_SETTING:
			edt = _getElectricLockSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_OPEN_CLOSE_SETTING2:
			edt = _getOpenCloseSetting2(epc);
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
			case EPC_OPEN_CLOSE_SETTING1:
				_onSetOpenCloseSetting1(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_EXTENT_OF_OPENING1:
				_onSetExtentOfOpening1(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_BLIND_ANGLE_SETTING:
				_onSetBlindAngleSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SHUTTER_SPEED:
				_onSetShutterSpeed(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_EXTENT_OF_OPENING2:
				_onSetExtentOfOpening2(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ELECTRIC_LOCK_SETTING:
				_onSetElectricLockSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_OPEN_CLOSE_SETTING2:
				_onSetOpenCloseSetting2(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_OPEN_CLOSE_SETTING1:
				_onGetOpenCloseSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_EXTENT_OF_OPENING1:
				_onGetExtentOfOpening1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BLIND_ANGLE_SETTING:
				_onGetBlindAngleSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SHUTTER_SPEED:
				_onGetShutterSpeed(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_EXTENT_OF_OPENING2:
				_onGetExtentOfOpening2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ELECTRIC_LOCK_SETTING:
				_onGetElectricLockSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OPEN_CLOSE_SETTING2:
				_onGetOpenCloseSetting2(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * Open(ed)/close(d)/stop(ped)<br><br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Name : Open/close setting 1<br>EPC : 0xE0<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onSetOpenCloseSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOpenCloseSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOpenCloseSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Open(ed)/close(d)/stop(ped)<br><br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Name : Open/close setting 1<br>EPC : 0xE0<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onGetOpenCloseSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOpenCloseSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOpenCloseSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Extent of opening 1<br>EPC : 0xE1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetExtentOfOpening1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetExtentOfOpening1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetExtentOfOpening1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Extent of opening 1<br>EPC : 0xE1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetExtentOfOpening1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetExtentOfOpening1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetExtentOfOpening1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Blind angle<br><br>0x00 to 0xB4 (0 to 180  )<br><br>Name : Blind angle setting<br>EPC : 0xE2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBlindAngleSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBlindAngleSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBlindAngleSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Blind angle<br><br>0x00 to 0xB4 (0 to 180  )<br><br>Name : Blind angle setting<br>EPC : 0xE2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBlindAngleSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBlindAngleSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBlindAngleSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Low/medium/high<br><br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Name : Shutter speed<br>EPC : 0xE3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetShutterSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetShutterSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetShutterSpeed(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Low/medium/high<br><br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Name : Shutter speed<br>EPC : 0xE3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetShutterSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetShutterSpeed(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetShutterSpeed(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br><br>0x00 to 0xFF (0 to 255)<br><br>Name : Extent of opening 2<br>EPC : 0xE4<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetExtentOfOpening2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetExtentOfOpening2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetExtentOfOpening2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br><br>0x00 to 0xFF (0 to 255)<br><br>Name : Extent of opening 2<br>EPC : 0xE4<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetExtentOfOpening2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetExtentOfOpening2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetExtentOfOpening2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br><br>Activated = 0x41, deactivated = 0x42<br><br>Name : Electric lock setting<br>EPC : 0xE5<br>Data Type : unsign ed char unsign ed char<br>Data Size(Byte) : 1 byte 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onSetElectricLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetElectricLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetElectricLockSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br><br>Activated = 0x41, deactivated = 0x42<br><br>Name : Electric lock setting<br>EPC : 0xE5<br>Data Type : unsign ed char unsign ed char<br>Data Size(Byte) : 1 byte 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		protected void onGetElectricLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetElectricLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetElectricLockSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting 2<br>EPC : 0xE7<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onSetOpenCloseSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOpenCloseSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOpenCloseSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting 2<br>EPC : 0xE7<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetOpenCloseSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOpenCloseSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOpenCloseSetting2(eoj, tid, esv, epc, pdc, edt);
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
		 * Open(ed)/close(d)/stop(ped)<br><br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Name : Open/close setting 1<br>EPC : 0xE0<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Setter reqSetOpenCloseSetting1(byte[] edt) {
			addProperty(EPC_OPEN_CLOSE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Extent of opening 1<br>EPC : 0xE1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetExtentOfOpening1(byte[] edt) {
			addProperty(EPC_EXTENT_OF_OPENING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Blind angle<br><br>0x00 to 0xB4 (0 to 180  )<br><br>Name : Blind angle setting<br>EPC : 0xE2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBlindAngleSetting(byte[] edt) {
			addProperty(EPC_BLIND_ANGLE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Low/medium/high<br><br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Name : Shutter speed<br>EPC : 0xE3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetShutterSpeed(byte[] edt) {
			addProperty(EPC_SHUTTER_SPEED, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br><br>0x00 to 0xFF (0 to 255)<br><br>Name : Extent of opening 2<br>EPC : 0xE4<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetExtentOfOpening2(byte[] edt) {
			addProperty(EPC_EXTENT_OF_OPENING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br><br>Activated = 0x41, deactivated = 0x42<br><br>Name : Electric lock setting<br>EPC : 0xE5<br>Data Type : unsign ed char unsign ed char<br>Data Size(Byte) : 1 byte 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Setter reqSetElectricLockSetting(byte[] edt) {
			addProperty(EPC_ELECTRIC_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting 2<br>EPC : 0xE7<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Setter reqSetOpenCloseSetting2(byte[] edt) {
			addProperty(EPC_OPEN_CLOSE_SETTING2, edt, (edt != null && (edt.length == 1)));
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
		 * Open(ed)/close(d)/stop(ped)<br><br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Name : Open/close setting 1<br>EPC : 0xE0<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Getter reqGetOpenCloseSetting1() {
			addProperty(EPC_OPEN_CLOSE_SETTING1);
			return this;
		}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Extent of opening 1<br>EPC : 0xE1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetExtentOfOpening1() {
			addProperty(EPC_EXTENT_OF_OPENING1);
			return this;
		}
		/**
		 * Blind angle<br><br>0x00 to 0xB4 (0 to 180  )<br><br>Name : Blind angle setting<br>EPC : 0xE2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBlindAngleSetting() {
			addProperty(EPC_BLIND_ANGLE_SETTING);
			return this;
		}
		/**
		 * Low/medium/high<br><br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Name : Shutter speed<br>EPC : 0xE3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetShutterSpeed() {
			addProperty(EPC_SHUTTER_SPEED);
			return this;
		}
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br><br>0x00 to 0xFF (0 to 255)<br><br>Name : Extent of opening 2<br>EPC : 0xE4<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetExtentOfOpening2() {
			addProperty(EPC_EXTENT_OF_OPENING2);
			return this;
		}
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br><br>Activated = 0x41, deactivated = 0x42<br><br>Name : Electric lock setting<br>EPC : 0xE5<br>Data Type : unsign ed char unsign ed char<br>Data Size(Byte) : 1 byte 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Getter reqGetElectricLockSetting() {
			addProperty(EPC_ELECTRIC_LOCK_SETTING);
			return this;
		}
		/**
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting 2<br>EPC : 0xE7<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetOpenCloseSetting2() {
			addProperty(EPC_OPEN_CLOSE_SETTING2);
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
		 * Open(ed)/close(d)/stop(ped)<br><br>Open(ed) = 0x41, close(d) = 0x42, stop(ped) = 0x43<br><br>Name : Open/close setting 1<br>EPC : 0xE0<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Informer reqInformOpenCloseSetting1();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 8 predefined levels, and to acquire the current setting.<br><br>0x31 to 0x38<br><br>Name : Extent of opening 1<br>EPC : 0xE1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformExtentOfOpening1();
		/**
		 * Blind angle<br><br>0x00 to 0xB4 (0 to 180  )<br><br>Name : Blind angle setting<br>EPC : 0xE2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBlindAngleSetting();
		/**
		 * Low/medium/high<br><br>Low = 0x41, medium = 0x42, high = 0x43<br><br>Name : Shutter speed<br>EPC : 0xE3<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformShutterSpeed();
		/**
		 * Used to specify the extent of opening by selecting a level from among the 256 predefined levels, and to acquire the current setting.<br><br>0x00 to 0xFF (0 to 255)<br><br>Name : Extent of opening 2<br>EPC : 0xE4<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformExtentOfOpening2();
		/**
		 * Used to specify whether or not to activate the electric lock, and to acquire the current setting.<br><br>Activated = 0x41, deactivated = 0x42<br><br>Name : Electric lock setting<br>EPC : 0xE5<br>Data Type : unsign ed char unsign ed char<br>Data Size(Byte) : 1 byte 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br><br>Announcement at status change<br>
		 */
		public Informer reqInformElectricLockSetting();
		/**
		 * Open/close<br><br>Open = 0x41, close = 0x42<br><br>Name : Open/close setting 2<br>EPC : 0xE7<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformOpenCloseSetting2();
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
		public Informer reqInformOpenCloseSetting1() {
			byte epc = EPC_OPEN_CLOSE_SETTING1;
			byte[] edt = _getOpenCloseSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformExtentOfOpening1() {
			byte epc = EPC_EXTENT_OF_OPENING1;
			byte[] edt = _getExtentOfOpening1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBlindAngleSetting() {
			byte epc = EPC_BLIND_ANGLE_SETTING;
			byte[] edt = _getBlindAngleSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShutterSpeed() {
			byte epc = EPC_SHUTTER_SPEED;
			byte[] edt = _getShutterSpeed(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformExtentOfOpening2() {
			byte epc = EPC_EXTENT_OF_OPENING2;
			byte[] edt = _getExtentOfOpening2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformElectricLockSetting() {
			byte epc = EPC_ELECTRIC_LOCK_SETTING;
			byte[] edt = _getElectricLockSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOpenCloseSetting2() {
			byte epc = EPC_OPEN_CLOSE_SETTING2;
			byte[] edt = _getOpenCloseSetting2(epc);
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
