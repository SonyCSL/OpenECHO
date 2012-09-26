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

public abstract class FloorHeater extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = FloorHeater.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x7B;

	protected static final byte EPC_TEMPERATURE_SETTING1 = (byte)0xE0;
	protected static final byte EPC_TEMPERATURE_SETTING2 = (byte)0xE1;
	protected static final byte EPC_MEASURED_ROOM_TEEMPERATURE = (byte)0xE2;
	protected static final byte EPC_MEASURED_FLOOR_TEMPERATURE = (byte)0xE3;
	protected static final byte EPC_ZONE_CHANGE_SETTING = (byte)0xE4;
	protected static final byte EPC_SPECIAL_OPERATION_SETTING = (byte)0xE5;
	protected static final byte EPC_DAILY_TIMER_SETTING = (byte)0xE6;
	protected static final byte EPC_DAILY_TIMER_SETTING1 = (byte)0xE7;
	protected static final byte EPC_DAILY_TIMER_SETTING2 = (byte)0xE8;
	protected static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_TIME_SET_BY_ON_TIMER = (byte)0x91;
	protected static final byte EPC_RELATIVE_ON_TIMER_SETTING = (byte)0x92;
	protected static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	protected static final byte EPC_TIME_SET_BY_OFF_TIMER = (byte)0x95;
	protected static final byte EPC_RELATIVE_OFF_TIMER_SETTING = (byte)0x96;


	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71
	 */
	protected abstract boolean setTemperatureSetting1(byte[] edt);
	/**
	 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71
	 */
	protected abstract byte[] getTemperatureSetting1();
	/**
	 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41
	 */
	protected abstract boolean setTemperatureSetting2(byte[] edt);
	/**
	 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41
	 */
	protected abstract byte[] getTemperatureSetting2();
	/**
	 * Measured room temperature<br>0x81-0x7D�i-127-125���j
	 */
	protected byte[] getMeasuredRoomTeemperature() {return null;}
	/**
	 * Measured floor temperature<br>0x00-0x32�i0-50���j
	 */
	protected byte[] getMeasuredFloorTemperature() {return null;}
	/**
	 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control
	 */
	protected boolean setZoneChangeSetting(byte[] edt) {return false;}
	/**
	 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control
	 */
	protected byte[] getZoneChangeSetting() {return null;}
	/**
	 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43
	 */
	protected boolean setSpecialOperationSetting(byte[] edt) {return false;}
	/**
	 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43
	 */
	protected byte[] getSpecialOperationSetting() {return null;}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42
	 */
	protected boolean setDailyTimerSetting(byte[] edt) {return false;}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42
	 */
	protected byte[] getDailyTimerSetting() {return null;}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
	 */
	protected boolean setDailyTimerSetting1(byte[] edt) {return false;}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
	 */
	protected byte[] getDailyTimerSetting1() {return null;}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
	 */
	protected boolean setDailyTimerSetting2(byte[] edt) {return false;}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
	 */
	protected byte[] getDailyTimerSetting2() {return null;}
	/**
	 * Reservation ON/OFF<br>ON=0x41, OFF=0x42
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>ON=0x41, OFF=0x42
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
	 */
	protected boolean setTimeSetByOnTimer(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
	 */
	protected byte[] getTimeSetByOnTimer() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
	 */
	protected boolean setRelativeOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
	 */
	protected byte[] getRelativeOnTimerSetting() {return null;}
	/**
	 * Reservation ON/OFF<br>ON��0x41, OFF��0x42
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>ON��0x41, OFF��0x42
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
	 */
	protected boolean setTimeSetByOffTimer(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
	 */
	protected byte[] getTimeSetByOffTimer() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
	 */
	protected boolean setRelativeOffTimerSetting(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
	 */
	protected byte[] getRelativeOffTimerSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_TEMPERATURE_SETTING1:
			res.addProperty(epc, edt, setTemperatureSetting1(edt));
			break;
		case EPC_TEMPERATURE_SETTING2:
			res.addProperty(epc, edt, setTemperatureSetting2(edt));
			break;
		case EPC_ZONE_CHANGE_SETTING:
			res.addProperty(epc, edt, setZoneChangeSetting(edt));
			break;
		case EPC_SPECIAL_OPERATION_SETTING:
			res.addProperty(epc, edt, setSpecialOperationSetting(edt));
			break;
		case EPC_DAILY_TIMER_SETTING:
			res.addProperty(epc, edt, setDailyTimerSetting(edt));
			break;
		case EPC_DAILY_TIMER_SETTING1:
			res.addProperty(epc, edt, setDailyTimerSetting1(edt));
			break;
		case EPC_DAILY_TIMER_SETTING2:
			res.addProperty(epc, edt, setDailyTimerSetting2(edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOnTimerReservationSetting(edt));
			break;
		case EPC_TIME_SET_BY_ON_TIMER:
			res.addProperty(epc, edt, setTimeSetByOnTimer(edt));
			break;
		case EPC_RELATIVE_ON_TIMER_SETTING:
			res.addProperty(epc, edt, setRelativeOnTimerSetting(edt));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, setOffTimerReservationSetting(edt));
			break;
		case EPC_TIME_SET_BY_OFF_TIMER:
			res.addProperty(epc, edt, setTimeSetByOffTimer(edt));
			break;
		case EPC_RELATIVE_OFF_TIMER_SETTING:
			res.addProperty(epc, edt, setRelativeOffTimerSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_TEMPERATURE_SETTING1:
			edt = getTemperatureSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPERATURE_SETTING2:
			edt = getTemperatureSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_ROOM_TEEMPERATURE:
			edt = getMeasuredRoomTeemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_FLOOR_TEMPERATURE:
			edt = getMeasuredFloorTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ZONE_CHANGE_SETTING:
			edt = getZoneChangeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SPECIAL_OPERATION_SETTING:
			edt = getSpecialOperationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DAILY_TIMER_SETTING:
			edt = getDailyTimerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DAILY_TIMER_SETTING1:
			edt = getDailyTimerSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_DAILY_TIMER_SETTING2:
			edt = getDailyTimerSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = getOnTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TIME_SET_BY_ON_TIMER:
			edt = getTimeSetByOnTimer();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RELATIVE_ON_TIMER_SETTING:
			edt = getRelativeOnTimerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			edt = getOffTimerReservationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TIME_SET_BY_OFF_TIMER:
			edt = getTimeSetByOffTimer();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RELATIVE_OFF_TIMER_SETTING:
			edt = getRelativeOffTimerSetting();
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
			case EPC_TEMPERATURE_SETTING1:
				onSetTemperatureSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_TEMPERATURE_SETTING2:
				onSetTemperatureSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_ZONE_CHANGE_SETTING:
				onSetZoneChangeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SPECIAL_OPERATION_SETTING:
				onSetSpecialOperationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_DAILY_TIMER_SETTING:
				onSetDailyTimerSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_DAILY_TIMER_SETTING1:
				onSetDailyTimerSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_DAILY_TIMER_SETTING2:
				onSetDailyTimerSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onSetOnTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_TIME_SET_BY_ON_TIMER:
				onSetTimeSetByOnTimer(eoj, tid, (pdc != 0));
				break;
			case EPC_RELATIVE_ON_TIMER_SETTING:
				onSetRelativeOnTimerSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				onSetOffTimerReservationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_TIME_SET_BY_OFF_TIMER:
				onSetTimeSetByOffTimer(eoj, tid, (pdc != 0));
				break;
			case EPC_RELATIVE_OFF_TIMER_SETTING:
				onSetRelativeOffTimerSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_TEMPERATURE_SETTING1:
				onGetTemperatureSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_TEMPERATURE_SETTING2:
				onGetTemperatureSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_ROOM_TEEMPERATURE:
				onGetMeasuredRoomTeemperature(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_FLOOR_TEMPERATURE:
				onGetMeasuredFloorTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_ZONE_CHANGE_SETTING:
				onGetZoneChangeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SPECIAL_OPERATION_SETTING:
				onGetSpecialOperationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_DAILY_TIMER_SETTING:
				onGetDailyTimerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_DAILY_TIMER_SETTING1:
				onGetDailyTimerSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_DAILY_TIMER_SETTING2:
				onGetDailyTimerSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				onGetOnTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_TIME_SET_BY_ON_TIMER:
				onGetTimeSetByOnTimer(eoj, tid, pdc, edt);
				break;
			case EPC_RELATIVE_ON_TIMER_SETTING:
				onGetRelativeOnTimerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				onGetOffTimerReservationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_TIME_SET_BY_OFF_TIMER:
				onGetTimeSetByOffTimer(eoj, tid, pdc, edt);
				break;
			case EPC_RELATIVE_OFF_TIMER_SETTING:
				onGetRelativeOffTimerSetting(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71
		 */
		protected void onSetTemperatureSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71
		 */
		protected void onGetTemperatureSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41
		 */
		protected void onSetTemperatureSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41
		 */
		protected void onGetTemperatureSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Measured room temperature<br>0x81-0x7D�i-127-125���j
		 */
		protected void onGetMeasuredRoomTeemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Measured floor temperature<br>0x00-0x32�i0-50���j
		 */
		protected void onGetMeasuredFloorTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control
		 */
		protected void onSetZoneChangeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control
		 */
		protected void onGetZoneChangeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43
		 */
		protected void onSetSpecialOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43
		 */
		protected void onGetSpecialOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42
		 */
		protected void onSetDailyTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42
		 */
		protected void onGetDailyTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		protected void onSetDailyTimerSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		protected void onGetDailyTimerSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		protected void onSetDailyTimerSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		protected void onGetDailyTimerSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		protected void onSetTimeSetByOnTimer(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		protected void onGetTimeSetByOnTimer(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		protected void onSetRelativeOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		protected void onGetRelativeOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		protected void onSetTimeSetByOffTimer(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		protected void onGetTimeSetByOffTimer(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		protected void onSetRelativeOffTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		protected void onGetRelativeOffTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71
		 */
		public Setter reqSetTemperatureSetting1(byte[] edt);
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41
		 */
		public Setter reqSetTemperatureSetting2(byte[] edt);
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control
		 */
		public Setter reqSetZoneChangeSetting(byte[] edt);
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43
		 */
		public Setter reqSetSpecialOperationSetting(byte[] edt);
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42
		 */
		public Setter reqSetDailyTimerSetting(byte[] edt);
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		public Setter reqSetDailyTimerSetting1(byte[] edt);
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		public Setter reqSetDailyTimerSetting2(byte[] edt);
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		public Setter reqSetTimeSetByOnTimer(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		public Setter reqSetRelativeOnTimerSetting(byte[] edt);
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		public Setter reqSetTimeSetByOffTimer(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		public Setter reqSetRelativeOffTimerSetting(byte[] edt);

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
		public Setter reqSetTemperatureSetting1(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING1, edt, setTemperatureSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting2(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING2, edt, setTemperatureSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetZoneChangeSetting(byte[] edt) {
			addProperty(EPC_ZONE_CHANGE_SETTING, edt, setZoneChangeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSpecialOperationSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_SETTING, edt, setSpecialOperationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetDailyTimerSetting(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING, edt, setDailyTimerSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetDailyTimerSetting1(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING1, edt, setDailyTimerSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetDailyTimerSetting2(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING2, edt, setDailyTimerSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, setOnTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetTimeSetByOnTimer(byte[] edt) {
			addProperty(EPC_TIME_SET_BY_ON_TIMER, edt, setTimeSetByOnTimer(edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeOnTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING, edt, setRelativeOnTimerSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, setOffTimerReservationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetTimeSetByOffTimer(byte[] edt) {
			addProperty(EPC_TIME_SET_BY_OFF_TIMER, edt, setTimeSetByOffTimer(edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeOffTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING, edt, setRelativeOffTimerSetting(edt));
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
		public Setter reqSetTemperatureSetting1(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting2(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetZoneChangeSetting(byte[] edt) {
			addProperty(EPC_ZONE_CHANGE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetSpecialOperationSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetDailyTimerSetting(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetDailyTimerSetting1(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING1, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Setter reqSetDailyTimerSetting2(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING2, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetTimeSetByOnTimer(byte[] edt) {
			addProperty(EPC_TIME_SET_BY_ON_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetRelativeOnTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetTimeSetByOffTimer(byte[] edt) {
			addProperty(EPC_TIME_SET_BY_OFF_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetRelativeOffTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71
		 */
		public Getter reqGetTemperatureSetting1();
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41
		 */
		public Getter reqGetTemperatureSetting2();
		/**
		 * Measured room temperature<br>0x81-0x7D�i-127-125���j
		 */
		public Getter reqGetMeasuredRoomTeemperature();
		/**
		 * Measured floor temperature<br>0x00-0x32�i0-50���j
		 */
		public Getter reqGetMeasuredFloorTemperature();
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control
		 */
		public Getter reqGetZoneChangeSetting();
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43
		 */
		public Getter reqGetSpecialOperationSetting();
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42
		 */
		public Getter reqGetDailyTimerSetting();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		public Getter reqGetDailyTimerSetting1();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		public Getter reqGetDailyTimerSetting2();
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		public Getter reqGetTimeSetByOnTimer();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		public Getter reqGetRelativeOnTimerSetting();
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42
		 */
		public Getter reqGetOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		public Getter reqGetTimeSetByOffTimer();
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		public Getter reqGetRelativeOffTimerSetting();

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
		public Getter reqGetTemperatureSetting1() {
			byte[] edt = getTemperatureSetting1();
			addProperty(EPC_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting2() {
			byte[] edt = getTemperatureSetting2();
			addProperty(EPC_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredRoomTeemperature() {
			byte[] edt = getMeasuredRoomTeemperature();
			addProperty(EPC_MEASURED_ROOM_TEEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredFloorTemperature() {
			byte[] edt = getMeasuredFloorTemperature();
			addProperty(EPC_MEASURED_FLOOR_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetZoneChangeSetting() {
			byte[] edt = getZoneChangeSetting();
			addProperty(EPC_ZONE_CHANGE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSpecialOperationSetting() {
			byte[] edt = getSpecialOperationSetting();
			addProperty(EPC_SPECIAL_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDailyTimerSetting() {
			byte[] edt = getDailyTimerSetting();
			addProperty(EPC_DAILY_TIMER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDailyTimerSetting1() {
			byte[] edt = getDailyTimerSetting1();
			addProperty(EPC_DAILY_TIMER_SETTING1, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Getter reqGetDailyTimerSetting2() {
			byte[] edt = getDailyTimerSetting2();
			addProperty(EPC_DAILY_TIMER_SETTING2, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTimeSetByOnTimer() {
			byte[] edt = getTimeSetByOnTimer();
			addProperty(EPC_TIME_SET_BY_ON_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRelativeOnTimerSetting() {
			byte[] edt = getRelativeOnTimerSetting();
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerReservationSetting() {
			byte[] edt = getOffTimerReservationSetting();
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTimeSetByOffTimer() {
			byte[] edt = getTimeSetByOffTimer();
			addProperty(EPC_TIME_SET_BY_OFF_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRelativeOffTimerSetting() {
			byte[] edt = getRelativeOffTimerSetting();
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetTemperatureSetting1() {
			addProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting2() {
			addProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetMeasuredRoomTeemperature() {
			addProperty(EPC_MEASURED_ROOM_TEEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredFloorTemperature() {
			addProperty(EPC_MEASURED_FLOOR_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetZoneChangeSetting() {
			addProperty(EPC_ZONE_CHANGE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSpecialOperationSetting() {
			addProperty(EPC_SPECIAL_OPERATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetDailyTimerSetting() {
			addProperty(EPC_DAILY_TIMER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetDailyTimerSetting1() {
			addProperty(EPC_DAILY_TIMER_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetDailyTimerSetting2() {
			addProperty(EPC_DAILY_TIMER_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetTimeSetByOnTimer() {
			addProperty(EPC_TIME_SET_BY_ON_TIMER);
			return this;
		}
		@Override
		public Getter reqGetRelativeOnTimerSetting() {
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetTimeSetByOffTimer() {
			addProperty(EPC_TIME_SET_BY_OFF_TIMER);
			return this;
		}
		@Override
		public Getter reqGetRelativeOffTimerSetting() {
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING);
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
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71
		 */
		public Informer reqInformTemperatureSetting1();
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41
		 */
		public Informer reqInformTemperatureSetting2();
		/**
		 * Measured room temperature<br>0x81-0x7D�i-127-125���j
		 */
		public Informer reqInformMeasuredRoomTeemperature();
		/**
		 * Measured floor temperature<br>0x00-0x32�i0-50���j
		 */
		public Informer reqInformMeasuredFloorTemperature();
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control
		 */
		public Informer reqInformZoneChangeSetting();
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43
		 */
		public Informer reqInformSpecialOperationSetting();
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42
		 */
		public Informer reqInformDailyTimerSetting();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		public Informer reqInformDailyTimerSetting1();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped
		 */
		public Informer reqInformDailyTimerSetting2();
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		public Informer reqInformTimeSetByOnTimer();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)
		 */
		public Informer reqInformRelativeOnTimerSetting();
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42
		 */
		public Informer reqInformOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		public Informer reqInformTimeSetByOffTimer();
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)
		 */
		public Informer reqInformRelativeOffTimerSetting();

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
		public Informer reqInformTemperatureSetting1() {
			byte[] edt = getTemperatureSetting1();
			addProperty(EPC_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting2() {
			byte[] edt = getTemperatureSetting2();
			addProperty(EPC_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRoomTeemperature() {
			byte[] edt = getMeasuredRoomTeemperature();
			addProperty(EPC_MEASURED_ROOM_TEEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredFloorTemperature() {
			byte[] edt = getMeasuredFloorTemperature();
			addProperty(EPC_MEASURED_FLOOR_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformZoneChangeSetting() {
			byte[] edt = getZoneChangeSetting();
			addProperty(EPC_ZONE_CHANGE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSpecialOperationSetting() {
			byte[] edt = getSpecialOperationSetting();
			addProperty(EPC_SPECIAL_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDailyTimerSetting() {
			byte[] edt = getDailyTimerSetting();
			addProperty(EPC_DAILY_TIMER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDailyTimerSetting1() {
			byte[] edt = getDailyTimerSetting1();
			addProperty(EPC_DAILY_TIMER_SETTING1, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformDailyTimerSetting2() {
			byte[] edt = getDailyTimerSetting2();
			addProperty(EPC_DAILY_TIMER_SETTING2, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			byte[] edt = getOnTimerReservationSetting();
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTimeSetByOnTimer() {
			byte[] edt = getTimeSetByOnTimer();
			addProperty(EPC_TIME_SET_BY_ON_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRelativeOnTimerSetting() {
			byte[] edt = getRelativeOnTimerSetting();
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerReservationSetting() {
			byte[] edt = getOffTimerReservationSetting();
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTimeSetByOffTimer() {
			byte[] edt = getTimeSetByOffTimer();
			addProperty(EPC_TIME_SET_BY_OFF_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRelativeOffTimerSetting() {
			byte[] edt = getRelativeOffTimerSetting();
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		public Informer reqInformTemperatureSetting1() {
			addProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting2() {
			addProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformMeasuredRoomTeemperature() {
			addProperty(EPC_MEASURED_ROOM_TEEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredFloorTemperature() {
			addProperty(EPC_MEASURED_FLOOR_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformZoneChangeSetting() {
			addProperty(EPC_ZONE_CHANGE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSpecialOperationSetting() {
			addProperty(EPC_SPECIAL_OPERATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformDailyTimerSetting() {
			addProperty(EPC_DAILY_TIMER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformDailyTimerSetting1() {
			addProperty(EPC_DAILY_TIMER_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformDailyTimerSetting2() {
			addProperty(EPC_DAILY_TIMER_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformTimeSetByOnTimer() {
			addProperty(EPC_TIME_SET_BY_ON_TIMER);
			return this;
		}
		@Override
		public Informer reqInformRelativeOnTimerSetting() {
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformTimeSetByOffTimer() {
			addProperty(EPC_TIME_SET_BY_OFF_TIMER);
			return this;
		}
		@Override
		public Informer reqInformRelativeOffTimerSetting() {
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING);
			return this;
		}

	}
}
