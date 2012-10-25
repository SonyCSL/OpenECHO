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

public abstract class WashingMachine extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xC5;
	
	public WashingMachine() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_DOOR_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_WASHING_MACHINE_SETTING = (byte)0xB2;
	public static final byte EPC_CURRENT_STAGE_OF_WASHING_CYCLE = (byte)0xE1;
	public static final byte EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE = (byte)0xE6;
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
	 * This property indicates whether the door/cover is open or closed.<br><br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Name : Door/cover open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getDoorCoverOpenCloseStatus() {return null;}
	private final byte[] _getDoorCoverOpenCloseStatus(byte epc) {
		byte[] edt = getDoorCoverOpenCloseStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Washing machine setting<br><br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Name : Washing machine setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWashingMachineSetting(byte[] edt) {return false;}
	private final boolean _setWashingMachineSetting(byte epc, byte[] edt) {
		boolean success = setWashingMachineSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Washing machine setting<br><br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Name : Washing machine setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWashingMachineSetting() {return null;}
	private final byte[] _getWashingMachineSetting(byte epc) {
		byte[] edt = getWashingMachineSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the current stage of the washing cycle.<br><br>Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br><br>Name : Current stage of washing cycle<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getCurrentStageOfWashingCycle() {return null;}
	private final byte[] _getCurrentStageOfWashingCycle(byte epc) {
		byte[] edt = getCurrentStageOfWashingCycle();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Time remaining to complete washing cycle<br>EPC : 0xE6<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getTimeRemainingToCompleteWashingCycle() {return null;}
	private final byte[] _getTimeRemainingToCompleteWashingCycle(byte epc) {
		byte[] edt = getTimeRemainingToCompleteWashingCycle();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerSetting() {return null;}
	private final byte[] _getOnTimerSetting(byte epc) {
		byte[] edt = getOnTimerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRelativeTimeBasedOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setRelativeTimeBasedOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setRelativeTimeBasedOnTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRelativeTimeBasedOnTimerSetting() {return null;}
	private final byte[] _getRelativeTimeBasedOnTimerSetting(byte epc) {
		byte[] edt = getRelativeTimeBasedOnTimerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_WASHING_MACHINE_SETTING:
			res.addProperty(epc, edt, _setWashingMachineSetting(epc, edt));
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
		case EPC_WASHING_MACHINE_SETTING:
			edt = _getWashingMachineSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CURRENT_STAGE_OF_WASHING_CYCLE:
			edt = _getCurrentStageOfWashingCycle(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE:
			edt = _getTimeRemainingToCompleteWashingCycle(epc);
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
			case EPC_WASHING_MACHINE_SETTING:
				_onSetWashingMachineSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
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
			case EPC_WASHING_MACHINE_SETTING:
				_onGetWashingMachineSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CURRENT_STAGE_OF_WASHING_CYCLE:
				_onGetCurrentStageOfWashingCycle(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE:
				_onGetTimeRemainingToCompleteWashingCycle(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates whether the door/cover is open or closed.<br><br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Name : Door/cover open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDoorCoverOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Washing machine setting<br><br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Name : Washing machine setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWashingMachineSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWashingMachineSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWashingMachineSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Washing machine setting<br><br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Name : Washing machine setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWashingMachineSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWashingMachineSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWashingMachineSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the current stage of the washing cycle.<br><br>Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br><br>Name : Current stage of washing cycle<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetCurrentStageOfWashingCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCurrentStageOfWashingCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCurrentStageOfWashingCycle(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Time remaining to complete washing cycle<br>EPC : 0xE6<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetTimeRemainingToCompleteWashingCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTimeRemainingToCompleteWashingCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTimeRemainingToCompleteWashingCycle(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Washing machine setting<br><br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Name : Washing machine setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWashingMachineSetting(byte[] edt) {
			addProperty(EPC_WASHING_MACHINE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRelativeTimeBasedOnTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates whether the door/cover is open or closed.<br><br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Name : Door/cover open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetDoorCoverOpenCloseStatus() {
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Washing machine setting<br><br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Name : Washing machine setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWashingMachineSetting() {
			addProperty(EPC_WASHING_MACHINE_SETTING);
			return this;
		}
		/**
		 * This property indicates the current stage of the washing cycle.<br><br>Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br><br>Name : Current stage of washing cycle<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetCurrentStageOfWashingCycle() {
			addProperty(EPC_CURRENT_STAGE_OF_WASHING_CYCLE);
			return this;
		}
		/**
		 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Time remaining to complete washing cycle<br>EPC : 0xE6<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetTimeRemainingToCompleteWashingCycle() {
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE);
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRelativeTimeBasedOnTimerSetting() {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
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
		 * This property indicates whether the door/cover is open or closed.<br><br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Name : Door/cover open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformDoorCoverOpenCloseStatus();
		/**
		 * Washing machine setting<br><br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Name : Washing machine setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWashingMachineSetting();
		/**
		 * This property indicates the current stage of the washing cycle.<br><br>Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br><br>Name : Current stage of washing cycle<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformCurrentStageOfWashingCycle();
		/**
		 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br><br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Name : Time remaining to complete washing cycle<br>EPC : 0xE6<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformTimeRemainingToCompleteWashingCycle();
		/**
		 * Reservation ON/OFF<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * Timer value (HH:MM)<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRelativeTimeBasedOnTimerSetting();
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
		public Informer reqInformDoorCoverOpenCloseStatus() {
			byte epc = EPC_DOOR_COVER_OPEN_CLOSE_STATUS;
			byte[] edt = _getDoorCoverOpenCloseStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWashingMachineSetting() {
			byte epc = EPC_WASHING_MACHINE_SETTING;
			byte[] edt = _getWashingMachineSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCurrentStageOfWashingCycle() {
			byte epc = EPC_CURRENT_STAGE_OF_WASHING_CYCLE;
			byte[] edt = _getCurrentStageOfWashingCycle(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTimeRemainingToCompleteWashingCycle() {
			byte epc = EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE;
			byte[] edt = _getTimeRemainingToCompleteWashingCycle(epc);
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
		public Informer reqInformDoorCoverOpenCloseStatus() {
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Informer reqInformWashingMachineSetting() {
			addProperty(EPC_WASHING_MACHINE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformCurrentStageOfWashingCycle() {
			addProperty(EPC_CURRENT_STAGE_OF_WASHING_CYCLE);
			return this;
		}
		@Override
		public Informer reqInformTimeRemainingToCompleteWashingCycle() {
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE);
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
