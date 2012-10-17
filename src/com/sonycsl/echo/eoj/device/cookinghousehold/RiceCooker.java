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

public abstract class RiceCooker extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = RiceCooker.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xBB;

	public static final byte EPC_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_RICE_COOKING_STATUS = (byte)0xB1;
	public static final byte EPC_RICE_COOKING_CONTROL_SETTING = (byte)0xB2;
	public static final byte EPC_WARMER_SETTING = (byte)0xE1;
	public static final byte EPC_INNER_POT_REMOVAL_STATUS = (byte)0xE5;
	public static final byte EPC_COVER_REMOVAL_STATUS = (byte)0xE6;
	public static final byte EPC_RICE_COOKING_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME = (byte)0x91;
	public static final byte EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME = (byte)0x92;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates whether the cover is open or closed.<br>Cover open = 0x41, Cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getCoverOpenCloseStatus() {return null;}
	private final byte[] _getCoverOpenCloseStatus(byte epc) {
		byte[] edt = getCoverOpenCloseStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates rice cooking status.<br>Stop = 0x41, Preheating = 0x42, Rice cooking = 0x43, Steaming = 0x44, Rice cooking completion = 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getRiceCookingStatus();
	private final byte[] _getRiceCookingStatus(byte epc) {
		byte[] edt = getRiceCookingStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates rice cooking control setting.<br>Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setRiceCookingControlSetting(byte[] edt);
	private final boolean _setRiceCookingControlSetting(byte epc, byte[] edt) {
		boolean success = setRiceCookingControlSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates rice cooking control setting.<br>Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getRiceCookingControlSetting();
	private final byte[] _getRiceCookingControlSetting(byte epc) {
		byte[] edt = getRiceCookingControlSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether or not warmer function is enabled.<br>Warmer enabled = 0x41, Warmer disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWarmerSetting(byte[] edt) {return false;}
	private final boolean _setWarmerSetting(byte epc, byte[] edt) {
		boolean success = setWarmerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates whether or not warmer function is enabled.<br>Warmer enabled = 0x41, Warmer disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWarmerSetting() {return null;}
	private final byte[] _getWarmerSetting(byte epc) {
		byte[] edt = getWarmerSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether inner pot is removed or not.<br>Removed = 0x41, Not removed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getInnerPotRemovalStatus() {return null;}
	private final byte[] _getInnerPotRemovalStatus(byte epc) {
		byte[] edt = getInnerPotRemovalStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether or not cover is removed.<br>Removed = 0x41, Not removed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getCoverRemovalStatus() {return null;}
	private final byte[] _getCoverRemovalStatus(byte epc) {
		byte[] edt = getCoverRemovalStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates whether rice cooking reservation is ON or OFF.<br>Reservation ON = 0x41, Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRiceCookingReservationSetting(byte[] edt) {return false;}
	private final boolean _setRiceCookingReservationSetting(byte epc, byte[] edt) {
		boolean success = setRiceCookingReservationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates whether rice cooking reservation is ON or OFF.<br>Reservation ON = 0x41, Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRiceCookingReservationSetting() {return null;}
	private final byte[] _getRiceCookingReservationSetting(byte epc) {
		byte[] edt = getRiceCookingReservationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setSetValueOfRiceCookingReservationSettingTime(byte[] edt) {return false;}
	private final boolean _setSetValueOfRiceCookingReservationSettingTime(byte epc, byte[] edt) {
		boolean success = setSetValueOfRiceCookingReservationSettingTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSetValueOfRiceCookingReservationSettingTime() {return null;}
	private final byte[] _getSetValueOfRiceCookingReservationSettingTime(byte epc) {
		byte[] edt = getSetValueOfRiceCookingReservationSettingTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setSetValueOfRiceCookingReservationSettingRelativeTime(byte[] edt) {return false;}
	private final boolean _setSetValueOfRiceCookingReservationSettingRelativeTime(byte epc, byte[] edt) {
		boolean success = setSetValueOfRiceCookingReservationSettingRelativeTime(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSetValueOfRiceCookingReservationSettingRelativeTime() {return null;}
	private final byte[] _getSetValueOfRiceCookingReservationSettingRelativeTime(byte epc) {
		byte[] edt = getSetValueOfRiceCookingReservationSettingRelativeTime();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_RICE_COOKING_CONTROL_SETTING:
			res.addProperty(epc, edt, _setRiceCookingControlSetting(epc, edt));
			break;
		case EPC_WARMER_SETTING:
			res.addProperty(epc, edt, _setWarmerSetting(epc, edt));
			break;
		case EPC_RICE_COOKING_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setRiceCookingReservationSetting(epc, edt));
			break;
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME:
			res.addProperty(epc, edt, _setSetValueOfRiceCookingReservationSettingTime(epc, edt));
			break;
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME:
			res.addProperty(epc, edt, _setSetValueOfRiceCookingReservationSettingRelativeTime(epc, edt));
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
		case EPC_RICE_COOKING_STATUS:
			edt = _getRiceCookingStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RICE_COOKING_CONTROL_SETTING:
			edt = _getRiceCookingControlSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WARMER_SETTING:
			edt = _getWarmerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_INNER_POT_REMOVAL_STATUS:
			edt = _getInnerPotRemovalStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_COVER_REMOVAL_STATUS:
			edt = _getCoverRemovalStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RICE_COOKING_RESERVATION_SETTING:
			edt = _getRiceCookingReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME:
			edt = _getSetValueOfRiceCookingReservationSettingTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME:
			edt = _getSetValueOfRiceCookingReservationSettingRelativeTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
			case EPC_RICE_COOKING_CONTROL_SETTING:
				_onSetRiceCookingControlSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WARMER_SETTING:
				_onSetWarmerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_RICE_COOKING_RESERVATION_SETTING:
				_onSetRiceCookingReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME:
				_onSetSetValueOfRiceCookingReservationSettingTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME:
				_onSetSetValueOfRiceCookingReservationSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
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
			case EPC_RICE_COOKING_STATUS:
				_onGetRiceCookingStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RICE_COOKING_CONTROL_SETTING:
				_onGetRiceCookingControlSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WARMER_SETTING:
				_onGetWarmerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_INNER_POT_REMOVAL_STATUS:
				_onGetInnerPotRemovalStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_COVER_REMOVAL_STATUS:
				_onGetCoverRemovalStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RICE_COOKING_RESERVATION_SETTING:
				_onGetRiceCookingReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME:
				_onGetSetValueOfRiceCookingReservationSettingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME:
				_onGetSetValueOfRiceCookingReservationSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates whether the cover is open or closed.<br>Cover open = 0x41, Cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCoverOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates rice cooking status.<br>Stop = 0x41, Preheating = 0x42, Rice cooking = 0x43, Steaming = 0x44, Rice cooking completion = 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetRiceCookingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRiceCookingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRiceCookingStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates rice cooking control setting.<br>Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetRiceCookingControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRiceCookingControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRiceCookingControlSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates rice cooking control setting.<br>Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetRiceCookingControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRiceCookingControlSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRiceCookingControlSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether or not warmer function is enabled.<br>Warmer enabled = 0x41, Warmer disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWarmerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWarmerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWarmerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates whether or not warmer function is enabled.<br>Warmer enabled = 0x41, Warmer disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWarmerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWarmerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWarmerSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether inner pot is removed or not.<br>Removed = 0x41, Not removed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetInnerPotRemovalStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetInnerPotRemovalStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetInnerPotRemovalStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether or not cover is removed.<br>Removed = 0x41, Not removed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetCoverRemovalStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCoverRemovalStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCoverRemovalStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>Reservation ON = 0x41, Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRiceCookingReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRiceCookingReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRiceCookingReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>Reservation ON = 0x41, Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRiceCookingReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRiceCookingReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRiceCookingReservationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetSetValueOfRiceCookingReservationSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfRiceCookingReservationSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfRiceCookingReservationSettingTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetSetValueOfRiceCookingReservationSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfRiceCookingReservationSettingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfRiceCookingReservationSettingTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetSetValueOfRiceCookingReservationSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfRiceCookingReservationSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfRiceCookingReservationSettingRelativeTime(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetSetValueOfRiceCookingReservationSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfRiceCookingReservationSettingRelativeTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfRiceCookingReservationSettingRelativeTime(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates rice cooking control setting.<br>Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetRiceCookingControlSetting(byte[] edt);
		/**
		 * This property indicates whether or not warmer function is enabled.<br>Warmer enabled = 0x41, Warmer disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWarmerSetting(byte[] edt);
		/**
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>Reservation ON = 0x41, Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRiceCookingReservationSetting(byte[] edt);
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSetValueOfRiceCookingReservationSettingTime(byte[] edt);
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSetValueOfRiceCookingReservationSettingRelativeTime(byte[] edt);
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
		public Setter reqSetRiceCookingControlSetting(byte[] edt) {
			byte epc = EPC_RICE_COOKING_CONTROL_SETTING;
			addProperty(epc, edt, _setRiceCookingControlSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetWarmerSetting(byte[] edt) {
			byte epc = EPC_WARMER_SETTING;
			addProperty(epc, edt, _setWarmerSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetRiceCookingReservationSetting(byte[] edt) {
			byte epc = EPC_RICE_COOKING_RESERVATION_SETTING;
			addProperty(epc, edt, _setRiceCookingReservationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfRiceCookingReservationSettingTime(byte[] edt) {
			byte epc = EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME;
			addProperty(epc, edt, _setSetValueOfRiceCookingReservationSettingTime(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfRiceCookingReservationSettingRelativeTime(byte[] edt) {
			byte epc = EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME;
			addProperty(epc, edt, _setSetValueOfRiceCookingReservationSettingRelativeTime(epc, edt));
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
		public Setter reqSetRiceCookingControlSetting(byte[] edt) {
			addProperty(EPC_RICE_COOKING_CONTROL_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWarmerSetting(byte[] edt) {
			addProperty(EPC_WARMER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRiceCookingReservationSetting(byte[] edt) {
			addProperty(EPC_RICE_COOKING_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfRiceCookingReservationSettingTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfRiceCookingReservationSettingRelativeTime(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates whether the cover is open or closed.<br>Cover open = 0x41, Cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetCoverOpenCloseStatus();
		/**
		 * This property indicates rice cooking status.<br>Stop = 0x41, Preheating = 0x42, Rice cooking = 0x43, Steaming = 0x44, Rice cooking completion = 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetRiceCookingStatus();
		/**
		 * This property indicates rice cooking control setting.<br>Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetRiceCookingControlSetting();
		/**
		 * This property indicates whether or not warmer function is enabled.<br>Warmer enabled = 0x41, Warmer disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWarmerSetting();
		/**
		 * This property indicates whether inner pot is removed or not.<br>Removed = 0x41, Not removed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetInnerPotRemovalStatus();
		/**
		 * This property indicates whether or not cover is removed.<br>Removed = 0x41, Not removed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetCoverRemovalStatus();
		/**
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>Reservation ON = 0x41, Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRiceCookingReservationSetting();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSetValueOfRiceCookingReservationSettingTime();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSetValueOfRiceCookingReservationSettingRelativeTime();
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
		public Getter reqGetRiceCookingStatus() {
			byte epc = EPC_RICE_COOKING_STATUS;
			byte[] edt = _getRiceCookingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRiceCookingControlSetting() {
			byte epc = EPC_RICE_COOKING_CONTROL_SETTING;
			byte[] edt = _getRiceCookingControlSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWarmerSetting() {
			byte epc = EPC_WARMER_SETTING;
			byte[] edt = _getWarmerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetInnerPotRemovalStatus() {
			byte epc = EPC_INNER_POT_REMOVAL_STATUS;
			byte[] edt = _getInnerPotRemovalStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCoverRemovalStatus() {
			byte epc = EPC_COVER_REMOVAL_STATUS;
			byte[] edt = _getCoverRemovalStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRiceCookingReservationSetting() {
			byte epc = EPC_RICE_COOKING_RESERVATION_SETTING;
			byte[] edt = _getRiceCookingReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfRiceCookingReservationSettingTime() {
			byte epc = EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME;
			byte[] edt = _getSetValueOfRiceCookingReservationSettingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfRiceCookingReservationSettingRelativeTime() {
			byte epc = EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME;
			byte[] edt = _getSetValueOfRiceCookingReservationSettingRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetRiceCookingStatus() {
			addProperty(EPC_RICE_COOKING_STATUS);
			return this;
		}
		@Override
		public Getter reqGetRiceCookingControlSetting() {
			addProperty(EPC_RICE_COOKING_CONTROL_SETTING);
			return this;
		}
		@Override
		public Getter reqGetWarmerSetting() {
			addProperty(EPC_WARMER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetInnerPotRemovalStatus() {
			addProperty(EPC_INNER_POT_REMOVAL_STATUS);
			return this;
		}
		@Override
		public Getter reqGetCoverRemovalStatus() {
			addProperty(EPC_COVER_REMOVAL_STATUS);
			return this;
		}
		@Override
		public Getter reqGetRiceCookingReservationSetting() {
			addProperty(EPC_RICE_COOKING_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfRiceCookingReservationSettingTime() {
			addProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfRiceCookingReservationSettingRelativeTime() {
			addProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME);
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
		 * This property indicates whether the cover is open or closed.<br>Cover open = 0x41, Cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformCoverOpenCloseStatus();
		/**
		 * This property indicates rice cooking status.<br>Stop = 0x41, Preheating = 0x42, Rice cooking = 0x43, Steaming = 0x44, Rice cooking completion = 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformRiceCookingStatus();
		/**
		 * This property indicates rice cooking control setting.<br>Rice cooking start/restart = 0x41, Rice cooking suspension = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformRiceCookingControlSetting();
		/**
		 * This property indicates whether or not warmer function is enabled.<br>Warmer enabled = 0x41, Warmer disabled = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWarmerSetting();
		/**
		 * This property indicates whether inner pot is removed or not.<br>Removed = 0x41, Not removed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformInnerPotRemovalStatus();
		/**
		 * This property indicates whether or not cover is removed.<br>Removed = 0x41, Not removed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformCoverRemovalStatus();
		/**
		 * This property indicates whether rice cooking reservation is ON or OFF.<br>Reservation ON = 0x41, Reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRiceCookingReservationSetting();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSetValueOfRiceCookingReservationSettingTime();
		/**
		 * Timer value (HH:MM)<br>0.0x17: 0.0x3B (= 0.23):(= 0.59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSetValueOfRiceCookingReservationSettingRelativeTime();
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
		public Informer reqInformRiceCookingStatus() {
			byte epc = EPC_RICE_COOKING_STATUS;
			byte[] edt = _getRiceCookingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRiceCookingControlSetting() {
			byte epc = EPC_RICE_COOKING_CONTROL_SETTING;
			byte[] edt = _getRiceCookingControlSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWarmerSetting() {
			byte epc = EPC_WARMER_SETTING;
			byte[] edt = _getWarmerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformInnerPotRemovalStatus() {
			byte epc = EPC_INNER_POT_REMOVAL_STATUS;
			byte[] edt = _getInnerPotRemovalStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCoverRemovalStatus() {
			byte epc = EPC_COVER_REMOVAL_STATUS;
			byte[] edt = _getCoverRemovalStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRiceCookingReservationSetting() {
			byte epc = EPC_RICE_COOKING_RESERVATION_SETTING;
			byte[] edt = _getRiceCookingReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfRiceCookingReservationSettingTime() {
			byte epc = EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME;
			byte[] edt = _getSetValueOfRiceCookingReservationSettingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfRiceCookingReservationSettingRelativeTime() {
			byte epc = EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME;
			byte[] edt = _getSetValueOfRiceCookingReservationSettingRelativeTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
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
		public Informer reqInformRiceCookingStatus() {
			addProperty(EPC_RICE_COOKING_STATUS);
			return this;
		}
		@Override
		public Informer reqInformRiceCookingControlSetting() {
			addProperty(EPC_RICE_COOKING_CONTROL_SETTING);
			return this;
		}
		@Override
		public Informer reqInformWarmerSetting() {
			addProperty(EPC_WARMER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformInnerPotRemovalStatus() {
			addProperty(EPC_INNER_POT_REMOVAL_STATUS);
			return this;
		}
		@Override
		public Informer reqInformCoverRemovalStatus() {
			addProperty(EPC_COVER_REMOVAL_STATUS);
			return this;
		}
		@Override
		public Informer reqInformRiceCookingReservationSetting() {
			addProperty(EPC_RICE_COOKING_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfRiceCookingReservationSettingTime() {
			addProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_TIME);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfRiceCookingReservationSettingRelativeTime() {
			addProperty(EPC_SET_VALUE_OF_RICE_COOKING_RESERVATION_SETTING_RELATIVE_TIME);
			return this;
		}
	}
}
