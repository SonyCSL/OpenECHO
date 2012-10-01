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

public abstract class ColdOrHotWaterHeatSourceEquipment extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = ColdOrHotWaterHeatSourceEquipment.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x7A;

	protected static final byte EPC_OPERATION_MODE_SETTING = (byte)0xE0;
	protected static final byte EPC_WATER_TEMPERATURE_SETTING1 = (byte)0xE1;
	protected static final byte EPC_WATER_TEMPERATURE_SETTING2 = (byte)0xE2;
	protected static final byte EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE = (byte)0xE3;
	protected static final byte EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE = (byte)0xE4;
	protected static final byte EPC_SPECIAL_OPERATION_SETTING = (byte)0xE5;
	protected static final byte EPC_DAILY_TIMER_SETTING = (byte)0xE6;
	protected static final byte EPC_DAILY_TIMER_SETTING1 = (byte)0xE7;
	protected static final byte EPC_DAILY_TIMER_SETTING2 = (byte)0xE8;
	protected static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	protected static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
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
	 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOperationModeSetting(byte[] edt) {return false;}
	/**
	 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOperationModeSetting() {return null;}
	/**
	 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setWaterTemperatureSetting1(byte[] edt);
	/**
	 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getWaterTemperatureSetting1();
	/**
	 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setWaterTemperatureSetting2(byte[] edt);
	/**
	 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getWaterTemperatureSetting2();
	/**
	 * Measured temperature of outward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredTemperatureOfOutwardWaterExitWaterTemperature() {return null;}
	/**
	 * Measured temperature of inward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature() {return null;}
	/**
	 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSpecialOperationSetting(byte[] edt) {return false;}
	/**
	 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSpecialOperationSetting() {return null;}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDailyTimerSetting(byte[] edt) {return false;}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDailyTimerSetting() {return null;}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setDailyTimerSetting1(byte[] edt) {return false;}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDailyTimerSetting1() {return null;}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setDailyTimerSetting2(byte[] edt) {return false;}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDailyTimerSetting2() {return null;}
	/**
	 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeOnTimerSetting() {return null;}
	/**
	 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setTimeSetByOffTimer(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTimeSetByOffTimer() {return null;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeOffTimerSetting(byte[] edt) {return false;}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeOffTimerSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, setOperationModeSetting(edt));
			break;
		case EPC_WATER_TEMPERATURE_SETTING1:
			res.addProperty(epc, edt, setWaterTemperatureSetting1(edt));
			break;
		case EPC_WATER_TEMPERATURE_SETTING2:
			res.addProperty(epc, edt, setWaterTemperatureSetting2(edt));
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
		case EPC_ON_TIMER_SETTING:
			res.addProperty(epc, edt, setOnTimerSetting(edt));
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
		case EPC_OPERATION_MODE_SETTING:
			edt = getOperationModeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_TEMPERATURE_SETTING1:
			edt = getWaterTemperatureSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_TEMPERATURE_SETTING2:
			edt = getWaterTemperatureSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE:
			edt = getMeasuredTemperatureOfOutwardWaterExitWaterTemperature();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE:
			edt = getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature();
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
		case EPC_ON_TIMER_SETTING:
			edt = getOnTimerSetting();
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
			case EPC_OPERATION_MODE_SETTING:
				onSetOperationModeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_WATER_TEMPERATURE_SETTING1:
				onSetWaterTemperatureSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_WATER_TEMPERATURE_SETTING2:
				onSetWaterTemperatureSetting2(eoj, tid, (pdc != 0));
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
			case EPC_ON_TIMER_SETTING:
				onSetOnTimerSetting(eoj, tid, (pdc != 0));
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
			case EPC_OPERATION_MODE_SETTING:
				onGetOperationModeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_WATER_TEMPERATURE_SETTING1:
				onGetWaterTemperatureSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_WATER_TEMPERATURE_SETTING2:
				onGetWaterTemperatureSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE:
				onGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE:
				onGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(eoj, tid, pdc, edt);
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
			case EPC_ON_TIMER_SETTING:
				onGetOnTimerSetting(eoj, tid, pdc, edt);
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
		 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetWaterTemperatureSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetWaterTemperatureSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetWaterTemperatureSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetWaterTemperatureSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Measured temperature of outward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Measured temperature of inward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSpecialOperationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSpecialOperationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDailyTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDailyTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetDailyTimerSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetDailyTimerSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetDailyTimerSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetDailyTimerSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRelativeOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetTimeSetByOffTimer(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetTimeSetByOffTimer(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeOffTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetRelativeOffTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOperationModeSetting(byte[] edt);
		/**
		 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetWaterTemperatureSetting1(byte[] edt);
		/**
		 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetWaterTemperatureSetting2(byte[] edt);
		/**
		 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSpecialOperationSetting(byte[] edt);
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDailyTimerSetting(byte[] edt);
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDailyTimerSetting1(byte[] edt);
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDailyTimerSetting2(byte[] edt);
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRelativeOnTimerSetting(byte[] edt);
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTimeSetByOffTimer(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRelativeOffTimerSetting(byte[] edt);
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
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, setOperationModeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetWaterTemperatureSetting1(byte[] edt) {
			addProperty(EPC_WATER_TEMPERATURE_SETTING1, edt, setWaterTemperatureSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetWaterTemperatureSetting2(byte[] edt) {
			addProperty(EPC_WATER_TEMPERATURE_SETTING2, edt, setWaterTemperatureSetting2(edt));
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
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, setOnTimerSetting(edt));
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
		public Setter reqSetOperationModeSetting(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWaterTemperatureSetting1(byte[] edt) {
			addProperty(EPC_WATER_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWaterTemperatureSetting2(byte[] edt) {
			addProperty(EPC_WATER_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 1)));
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
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOperationModeSetting();
		/**
		 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetWaterTemperatureSetting1();
		/**
		 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetWaterTemperatureSetting2();
		/**
		 * Measured temperature of outward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature();
		/**
		 * Measured temperature of inward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature();
		/**
		 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSpecialOperationSetting();
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDailyTimerSetting();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDailyTimerSetting1();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDailyTimerSetting2();
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRelativeOnTimerSetting();
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTimeSetByOffTimer();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRelativeOffTimerSetting();
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
		public Getter reqGetOperationModeSetting() {
			byte[] edt = getOperationModeSetting();
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWaterTemperatureSetting1() {
			byte[] edt = getWaterTemperatureSetting1();
			addProperty(EPC_WATER_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWaterTemperatureSetting2() {
			byte[] edt = getWaterTemperatureSetting2();
			addProperty(EPC_WATER_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature() {
			byte[] edt = getMeasuredTemperatureOfOutwardWaterExitWaterTemperature();
			addProperty(EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature() {
			byte[] edt = getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature();
			addProperty(EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetOnTimerSetting() {
			byte[] edt = getOnTimerSetting();
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		public Getter reqGetOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetWaterTemperatureSetting1() {
			addProperty(EPC_WATER_TEMPERATURE_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetWaterTemperatureSetting2() {
			addProperty(EPC_WATER_TEMPERATURE_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE);
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
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
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
		 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOperationModeSetting();
		/**
		 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformWaterTemperatureSetting1();
		/**
		 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformWaterTemperatureSetting2();
		/**
		 * Measured temperature of outward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredTemperatureOfOutwardWaterExitWaterTemperature();
		/**
		 * Measured temperature of inward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredTemperatureOfInwardWaterEntranceWaterTemperature();
		/**
		 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSpecialOperationSetting();
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDailyTimerSetting();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDailyTimerSetting1();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDailyTimerSetting2();
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRelativeOnTimerSetting();
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTimeSetByOffTimer();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRelativeOffTimerSetting();
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
		public Informer reqInformOperationModeSetting() {
			byte[] edt = getOperationModeSetting();
			addProperty(EPC_OPERATION_MODE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterTemperatureSetting1() {
			byte[] edt = getWaterTemperatureSetting1();
			addProperty(EPC_WATER_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterTemperatureSetting2() {
			byte[] edt = getWaterTemperatureSetting2();
			addProperty(EPC_WATER_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfOutwardWaterExitWaterTemperature() {
			byte[] edt = getMeasuredTemperatureOfOutwardWaterExitWaterTemperature();
			addProperty(EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfInwardWaterEntranceWaterTemperature() {
			byte[] edt = getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature();
			addProperty(EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformOnTimerSetting() {
			byte[] edt = getOnTimerSetting();
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		public Informer reqInformOperationModeSetting() {
			addProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformWaterTemperatureSetting1() {
			addProperty(EPC_WATER_TEMPERATURE_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformWaterTemperatureSetting2() {
			addProperty(EPC_WATER_TEMPERATURE_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfOutwardWaterExitWaterTemperature() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfInwardWaterEntranceWaterTemperature() {
			addProperty(EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE);
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
		public Informer reqInformOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
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
