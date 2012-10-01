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
	@SuppressWarnings("unused")
	private static final String TAG = WashingMachine.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xC5;

	protected static final byte EPC_DOOR_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	protected static final byte EPC_WASHING_MACHINE_SETTING = (byte)0xB2;
	protected static final byte EPC_CURRENT_STAGE_OF_WASHING_CYCLE = (byte)0xE1;
	protected static final byte EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE = (byte)0xE6;
	protected static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
	protected static final byte EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING = (byte)0x92;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates whether the door/cover is open or closed.<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getDoorCoverOpenCloseStatus() {return null;}
	/**
	 * Washing machine setting<br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWashingMachineSetting(byte[] edt) {return false;}
	/**
	 * Washing machine setting<br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWashingMachineSetting() {return null;}
	/**
	 * This property indicates the current stage of the washing cycle.<br>Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getCurrentStageOfWashingCycle() {return null;}
	/**
	 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : unsigned char x 3<br>Data size : 3 bytes<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getTimeRemainingToCompleteWashingCycle() {return null;}
	/**
	 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeTimeBasedOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeTimeBasedOnTimerSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_WASHING_MACHINE_SETTING:
			res.addProperty(epc, edt, setWashingMachineSetting(edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOnTimerReservationSetting(edt));
			break;
		case EPC_ON_TIMER_SETTING:
			res.addProperty(epc, edt, setOnTimerSetting(edt));
			break;
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING:
			res.addProperty(epc, edt, setRelativeTimeBasedOnTimerSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS:
			edt = getDoorCoverOpenCloseStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHING_MACHINE_SETTING:
			edt = getWashingMachineSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CURRENT_STAGE_OF_WASHING_CYCLE:
			edt = getCurrentStageOfWashingCycle();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE:
			edt = getTimeRemainingToCompleteWashingCycle();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = getOnTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ON_TIMER_SETTING:
			edt = getOnTimerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING:
			edt = getRelativeTimeBasedOnTimerSetting();
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
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_WASHING_MACHINE_SETTING:
				onSetWashingMachineSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onSetOnTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_SETTING:
				onSetOnTimerSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING:
				onSetRelativeTimeBasedOnTimerSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_DOOR_COVER_OPEN_CLOSE_STATUS:
				onGetDoorCoverOpenCloseStatus(eoj, tid, pdc, edt);
				break;
			case EPC_WASHING_MACHINE_SETTING:
				onGetWashingMachineSetting(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_STAGE_OF_WASHING_CYCLE:
				onGetCurrentStageOfWashingCycle(eoj, tid, pdc, edt);
				break;
			case EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE:
				onGetTimeRemainingToCompleteWashingCycle(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onGetOnTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_SETTING:
				onGetOnTimerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING:
				onGetRelativeTimeBasedOnTimerSetting(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates whether the door/cover is open or closed.<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Washing machine setting<br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWashingMachineSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Washing machine setting<br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWashingMachineSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the current stage of the washing cycle.<br>Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetCurrentStageOfWashingCycle(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : unsigned char x 3<br>Data size : 3 bytes<br>Set : undefined<br>Get : optional
		 */
		protected void onGetTimeRemainingToCompleteWashingCycle(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Washing machine setting<br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWashingMachineSetting(byte[] edt);
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSetting(byte[] edt);
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
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
		public Setter reqSetWashingMachineSetting(byte[] edt) {
			addProperty(EPC_WASHING_MACHINE_SETTING, edt, setWashingMachineSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, setOnTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, setOnTimerSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeTimeBasedOnTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING, edt, setRelativeTimeBasedOnTimerSetting(edt));
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
		public Setter reqSetWashingMachineSetting(byte[] edt) {
			addProperty(EPC_WASHING_MACHINE_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * This property indicates whether the door/cover is open or closed.<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetDoorCoverOpenCloseStatus();
		/**
		 * Washing machine setting<br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWashingMachineSetting();
		/**
		 * This property indicates the current stage of the washing cycle.<br>Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetCurrentStageOfWashingCycle();
		/**
		 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : unsigned char x 3<br>Data size : 3 bytes<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetTimeRemainingToCompleteWashingCycle();
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSetting();
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
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
			byte[] edt = getDoorCoverOpenCloseStatus();
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWashingMachineSetting() {
			byte[] edt = getWashingMachineSetting();
			addProperty(EPC_WASHING_MACHINE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCurrentStageOfWashingCycle() {
			byte[] edt = getCurrentStageOfWashingCycle();
			addProperty(EPC_CURRENT_STAGE_OF_WASHING_CYCLE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTimeRemainingToCompleteWashingCycle() {
			byte[] edt = getTimeRemainingToCompleteWashingCycle();
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerSetting() {
			byte[] edt = getOnTimerSetting();
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRelativeTimeBasedOnTimerSetting() {
			byte[] edt = getRelativeTimeBasedOnTimerSetting();
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetWashingMachineSetting() {
			addProperty(EPC_WASHING_MACHINE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetCurrentStageOfWashingCycle() {
			addProperty(EPC_CURRENT_STAGE_OF_WASHING_CYCLE);
			return this;
		}
		@Override
		public Getter reqGetTimeRemainingToCompleteWashingCycle() {
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE);
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
		 * This property indicates whether the door/cover is open or closed.<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformDoorCoverOpenCloseStatus();
		/**
		 * Washing machine setting<br>Start/restart the washing cycle (started/restarted) = 0x41 Suspend the washing cycle (suspended) = 0x42 Stop the washing cycle (stopped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWashingMachineSetting();
		/**
		 * This property indicates the current stage of the washing cycle.<br>Washing = 0x41, rinsing = 0x42, spin drying = 0x43, suspended = 0x44, washing cycle stopped/completed = 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformCurrentStageOfWashingCycle();
		/**
		 * This property indicates the time remaining to complete the current washing cycle in the HH:MM:SS format.<br>0 to 0x17: 0 to 0x3B: 0 to 0x3B (= 0 to 23): (= 0 to 59): (= 0 to 59)<br><br>Data type : unsigned char x 3<br>Data size : 3 bytes<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformTimeRemainingToCompleteWashingCycle();
		/**
		 * Reservation ON/OFF<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * Timer value (HH:MM)<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char x 2<br>Data size : 2 bytes<br>Set : optional<br>Get : optional
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
			byte[] edt = getDoorCoverOpenCloseStatus();
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWashingMachineSetting() {
			byte[] edt = getWashingMachineSetting();
			addProperty(EPC_WASHING_MACHINE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCurrentStageOfWashingCycle() {
			byte[] edt = getCurrentStageOfWashingCycle();
			addProperty(EPC_CURRENT_STAGE_OF_WASHING_CYCLE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTimeRemainingToCompleteWashingCycle() {
			byte[] edt = getTimeRemainingToCompleteWashingCycle();
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHING_CYCLE, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerSetting() {
			byte[] edt = getOnTimerSetting();
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRelativeTimeBasedOnTimerSetting() {
			byte[] edt = getRelativeTimeBasedOnTimerSetting();
			addProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
