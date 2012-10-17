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

public abstract class ClothesDryer extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = ClothesDryer.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xC6;

	public static final byte EPC_DOOR_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_DRYING_SETTING = (byte)0xB2;
	public static final byte EPC_DRYING_STATUS = (byte)0xE1;
	public static final byte EPC_REMAINING_DRYING_TIME = (byte)0xE6;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	public static final byte EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING = (byte)0x92;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the status of the door or cover as to whether it is open or closed.<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getDoorCoverOpenCloseStatus() {return null;}
	private final byte[] _getDoorCoverOpenCloseStatus(byte epc) {
		byte[] edt = getDoorCoverOpenCloseStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Drying setting<br>Start/restart drying  0x41, Suspend drying  0x42, Stop drying  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDryingSetting(byte[] edt) {return false;}
	private final boolean _setDryingSetting(byte epc, byte[] edt) {
		boolean success = setDryingSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Drying setting<br>Start/restart drying  0x41, Suspend drying  0x42, Stop drying  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDryingSetting() {return null;}
	private final byte[] _getDryingSetting(byte epc) {
		byte[] edt = getDryingSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Drying status<br>Drying in progress  0x41 Drying suspended  0x42 Drying completed/stopped  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getDryingStatus() {return null;}
	private final byte[] _getDryingStatus(byte epc) {
		byte[] edt = getDryingStatus();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the remaining drying time in the  gHH:MM:SS h .format.<br>0-0x17: 0-0x3B : 0-0x3B (=0-23):(=0-59):(=0-59)<br><br>Data type : unsigned char  ~3<br>Data size : 3 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRemainingDryingTime() {return null;}
	private final byte[] _getRemainingDryingTime(byte epc) {
		byte[] edt = getRemainingDryingTime();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br>Reservation ON  0x41 Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br>Reservation ON  0x41 Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSetting() {return null;}
	private final byte[] _getOnTimerSetting(byte epc) {
		byte[] edt = getOnTimerSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeTimeBasedOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setRelativeTimeBasedOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setRelativeTimeBasedOnTimerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeTimeBasedOnTimerSetting() {return null;}
	private final byte[] _getRelativeTimeBasedOnTimerSetting(byte epc) {
		byte[] edt = getRelativeTimeBasedOnTimerSetting();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_DRYING_SETTING:
			res.addProperty(epc, edt, _setDryingSetting(epc, edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			break;
		case EPC_ON_TIMER_SETTING:
			res.addProperty(epc, edt, _setOnTimerSetting(epc, edt));
			break;
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING:
			res.addProperty(epc, edt, _setRelativeTimeBasedOnTimerSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS:
			edt = _getDoorCoverOpenCloseStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DRYING_SETTING:
			edt = _getDryingSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DRYING_STATUS:
			edt = _getDryingStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REMAINING_DRYING_TIME:
			edt = _getRemainingDryingTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = _getOnTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING:
			edt = _getOnTimerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING:
			edt = _getRelativeTimeBasedOnTimerSetting(epc);
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
			case EPC_DRYING_SETTING:
				_onSetDryingSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING:
				_onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING:
				_onSetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_DOOR_COVER_OPEN_CLOSE_STATUS:
				_onGetDoorCoverOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DRYING_SETTING:
				_onGetDryingSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DRYING_STATUS:
				_onGetDryingStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REMAINING_DRYING_TIME:
				_onGetRemainingDryingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING:
				_onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING:
				_onGetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates the status of the door or cover as to whether it is open or closed.<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDoorCoverOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Drying setting<br>Start/restart drying  0x41, Suspend drying  0x42, Stop drying  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDryingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDryingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDryingSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Drying setting<br>Start/restart drying  0x41, Suspend drying  0x42, Stop drying  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDryingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDryingSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDryingSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Drying status<br>Drying in progress  0x41 Drying suspended  0x42 Drying completed/stopped  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetDryingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDryingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDryingStatus(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the remaining drying time in the  gHH:MM:SS h .format.<br>0-0x17: 0-0x3B : 0-0x3B (=0-23):(=0-59):(=0-59)<br><br>Data type : unsigned char  ~3<br>Data size : 3 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRemainingDryingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRemainingDryingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRemainingDryingTime(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41 Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41 Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Drying setting<br>Start/restart drying  0x41, Suspend drying  0x42, Stop drying  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDryingSetting(byte[] edt);
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41 Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSetting(byte[] edt);
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRelativeTimeBasedOnTimerSetting(byte[] edt);
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
		public Setter reqSetDryingSetting(byte[] edt) {
			byte epc = EPC_DRYING_SETTING;
			addProperty(epc, edt, _setDryingSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSetting(byte[] edt) {
			byte epc = EPC_ON_TIMER_SETTING;
			addProperty(epc, edt, _setOnTimerSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeTimeBasedOnTimerSetting(byte[] edt) {
			byte epc = EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING;
			addProperty(epc, edt, _setRelativeTimeBasedOnTimerSetting(epc, edt));
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
		public Setter reqSetDryingSetting(byte[] edt) {
			addProperty(EPC_DRYING_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetRelativeTimeBasedOnTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates the status of the door or cover as to whether it is open or closed.<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetDoorCoverOpenCloseStatus();
		/**
		 * Drying setting<br>Start/restart drying  0x41, Suspend drying  0x42, Stop drying  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDryingSetting();
		/**
		 * Drying status<br>Drying in progress  0x41 Drying suspended  0x42 Drying completed/stopped  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetDryingStatus();
		/**
		 * This property indicates the remaining drying time in the  gHH:MM:SS h .format.<br>0-0x17: 0-0x3B : 0-0x3B (=0-23):(=0-59):(=0-59)<br><br>Data type : unsigned char  ~3<br>Data size : 3 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRemainingDryingTime();
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41 Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSetting();
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRelativeTimeBasedOnTimerSetting();
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
		public Getter reqGetDoorCoverOpenCloseStatus() {
			byte epc = EPC_DOOR_COVER_OPEN_CLOSE_STATUS;
			byte[] edt = _getDoorCoverOpenCloseStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDryingSetting() {
			byte epc = EPC_DRYING_SETTING;
			byte[] edt = _getDryingSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDryingStatus() {
			byte epc = EPC_DRYING_STATUS;
			byte[] edt = _getDryingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRemainingDryingTime() {
			byte epc = EPC_REMAINING_DRYING_TIME;
			byte[] edt = _getRemainingDryingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOnTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSetting() {
			byte epc = EPC_ON_TIMER_SETTING;
			byte[] edt = _getOnTimerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRelativeTimeBasedOnTimerSetting() {
			byte epc = EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING;
			byte[] edt = _getRelativeTimeBasedOnTimerSetting(epc);
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
		public Getter reqGetDoorCoverOpenCloseStatus() {
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Getter reqGetDryingSetting() {
			addProperty(EPC_DRYING_SETTING);
			return this;
		}
		@Override
		public Getter reqGetDryingStatus() {
			addProperty(EPC_DRYING_STATUS);
			return this;
		}
		@Override
		public Getter reqGetRemainingDryingTime() {
			addProperty(EPC_REMAINING_DRYING_TIME);
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRelativeTimeBasedOnTimerSetting() {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
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
		 * This property indicates the status of the door or cover as to whether it is open or closed.<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformDoorCoverOpenCloseStatus();
		/**
		 * Drying setting<br>Start/restart drying  0x41, Suspend drying  0x42, Stop drying  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDryingSetting();
		/**
		 * Drying status<br>Drying in progress  0x41 Drying suspended  0x42 Drying completed/stopped  0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformDryingStatus();
		/**
		 * This property indicates the remaining drying time in the  gHH:MM:SS h .format.<br>0-0x17: 0-0x3B : 0-0x3B (=0-23):(=0-59):(=0-59)<br><br>Data type : unsigned char  ~3<br>Data size : 3 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRemainingDryingTime();
		/**
		 * Reservation ON/OFF<br>Reservation ON  0x41 Reservation OFF  0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * Timer value    HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char  ~ Q<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRelativeTimeBasedOnTimerSetting();
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
		public Informer reqInformDoorCoverOpenCloseStatus() {
			byte epc = EPC_DOOR_COVER_OPEN_CLOSE_STATUS;
			byte[] edt = _getDoorCoverOpenCloseStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDryingSetting() {
			byte epc = EPC_DRYING_SETTING;
			byte[] edt = _getDryingSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDryingStatus() {
			byte epc = EPC_DRYING_STATUS;
			byte[] edt = _getDryingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRemainingDryingTime() {
			byte epc = EPC_REMAINING_DRYING_TIME;
			byte[] edt = _getRemainingDryingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOnTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSetting() {
			byte epc = EPC_ON_TIMER_SETTING;
			byte[] edt = _getOnTimerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRelativeTimeBasedOnTimerSetting() {
			byte epc = EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING;
			byte[] edt = _getRelativeTimeBasedOnTimerSetting(epc);
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
		public Informer reqInformDoorCoverOpenCloseStatus() {
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Informer reqInformDryingSetting() {
			addProperty(EPC_DRYING_SETTING);
			return this;
		}
		@Override
		public Informer reqInformDryingStatus() {
			addProperty(EPC_DRYING_STATUS);
			return this;
		}
		@Override
		public Informer reqInformRemainingDryingTime() {
			addProperty(EPC_REMAINING_DRYING_TIME);
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRelativeTimeBasedOnTimerSetting() {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
			return this;
		}
	}
}
