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

	public static final byte EPC_TEMPERATURE_SETTING1 = (byte)0xE0;
	public static final byte EPC_TEMPERATURE_SETTING2 = (byte)0xE1;
	public static final byte EPC_MEASURED_ROOM_TEEMPERATURE = (byte)0xE2;
	public static final byte EPC_MEASURED_FLOOR_TEMPERATURE = (byte)0xE3;
	public static final byte EPC_ZONE_CHANGE_SETTING = (byte)0xE4;
	public static final byte EPC_SPECIAL_OPERATION_SETTING = (byte)0xE5;
	public static final byte EPC_DAILY_TIMER_SETTING = (byte)0xE6;
	public static final byte EPC_DAILY_TIMER_SETTING1 = (byte)0xE7;
	public static final byte EPC_DAILY_TIMER_SETTING2 = (byte)0xE8;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_TIME_SET_BY_ON_TIMER = (byte)0x91;
	public static final byte EPC_RELATIVE_ON_TIMER_SETTING = (byte)0x92;
	public static final byte EPC_OFF_TIMER_RESERVATION_SETTING = (byte)0x94;
	public static final byte EPC_TIME_SET_BY_OFF_TIMER = (byte)0x95;
	public static final byte EPC_RELATIVE_OFF_TIMER_SETTING = (byte)0x96;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setTemperatureSetting1(byte[] edt);
	private final boolean _setTemperatureSetting1(byte epc, byte[] edt) {
		boolean success = setTemperatureSetting1(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getTemperatureSetting1();
	private final byte[] _getTemperatureSetting1(byte epc) {
		byte[] edt = getTemperatureSetting1();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setTemperatureSetting2(byte[] edt);
	private final boolean _setTemperatureSetting2(byte epc, byte[] edt) {
		boolean success = setTemperatureSetting2(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getTemperatureSetting2();
	private final byte[] _getTemperatureSetting2(byte epc) {
		byte[] edt = getTemperatureSetting2();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Measured room temperature<br>0x81-0x7D�i-127-125���j<br><br>Data type : signed char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredRoomTeemperature() {return null;}
	private final byte[] _getMeasuredRoomTeemperature(byte epc) {
		byte[] edt = getMeasuredRoomTeemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Measured floor temperature<br>0x00-0x32�i0-50���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredFloorTemperature() {return null;}
	private final byte[] _getMeasuredFloorTemperature(byte epc) {
		byte[] edt = getMeasuredFloorTemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setZoneChangeSetting(byte[] edt) {return false;}
	private final boolean _setZoneChangeSetting(byte epc, byte[] edt) {
		boolean success = setZoneChangeSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getZoneChangeSetting() {return null;}
	private final byte[] _getZoneChangeSetting(byte epc) {
		byte[] edt = getZoneChangeSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSpecialOperationSetting(byte[] edt) {return false;}
	private final boolean _setSpecialOperationSetting(byte epc, byte[] edt) {
		boolean success = setSpecialOperationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSpecialOperationSetting() {return null;}
	private final byte[] _getSpecialOperationSetting(byte epc) {
		byte[] edt = getSpecialOperationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDailyTimerSetting(byte[] edt) {return false;}
	private final boolean _setDailyTimerSetting(byte epc, byte[] edt) {
		boolean success = setDailyTimerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDailyTimerSetting() {return null;}
	private final byte[] _getDailyTimerSetting(byte epc) {
		byte[] edt = getDailyTimerSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setDailyTimerSetting1(byte[] edt) {return false;}
	private final boolean _setDailyTimerSetting1(byte epc, byte[] edt) {
		boolean success = setDailyTimerSetting1(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDailyTimerSetting1() {return null;}
	private final byte[] _getDailyTimerSetting1(byte epc) {
		byte[] edt = getDailyTimerSetting1();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setDailyTimerSetting2(byte[] edt) {return false;}
	private final boolean _setDailyTimerSetting2(byte epc, byte[] edt) {
		boolean success = setDailyTimerSetting2(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDailyTimerSetting2() {return null;}
	private final byte[] _getDailyTimerSetting2(byte epc) {
		byte[] edt = getDailyTimerSetting2();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setTimeSetByOnTimer(byte[] edt) {return false;}
	private final boolean _setTimeSetByOnTimer(byte epc, byte[] edt) {
		boolean success = setTimeSetByOnTimer(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTimeSetByOnTimer() {return null;}
	private final byte[] _getTimeSetByOnTimer(byte epc) {
		byte[] edt = getTimeSetByOnTimer();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setRelativeOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setRelativeOnTimerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeOnTimerSetting() {return null;}
	private final byte[] _getRelativeOnTimerSetting(byte epc) {
		byte[] edt = getRelativeOnTimerSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOffTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOffTimerReservationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	private final byte[] _getOffTimerReservationSetting(byte epc) {
		byte[] edt = getOffTimerReservationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setTimeSetByOffTimer(byte[] edt) {return false;}
	private final boolean _setTimeSetByOffTimer(byte epc, byte[] edt) {
		boolean success = setTimeSetByOffTimer(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTimeSetByOffTimer() {return null;}
	private final byte[] _getTimeSetByOffTimer(byte epc) {
		byte[] edt = getTimeSetByOffTimer();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeOffTimerSetting(byte[] edt) {return false;}
	private final boolean _setRelativeOffTimerSetting(byte epc, byte[] edt) {
		boolean success = setRelativeOffTimerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeOffTimerSetting() {return null;}
	private final byte[] _getRelativeOffTimerSetting(byte epc) {
		byte[] edt = getRelativeOffTimerSetting();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_TEMPERATURE_SETTING1:
			res.addProperty(epc, edt, _setTemperatureSetting1(epc, edt));
			break;
		case EPC_TEMPERATURE_SETTING2:
			res.addProperty(epc, edt, _setTemperatureSetting2(epc, edt));
			break;
		case EPC_ZONE_CHANGE_SETTING:
			res.addProperty(epc, edt, _setZoneChangeSetting(epc, edt));
			break;
		case EPC_SPECIAL_OPERATION_SETTING:
			res.addProperty(epc, edt, _setSpecialOperationSetting(epc, edt));
			break;
		case EPC_DAILY_TIMER_SETTING:
			res.addProperty(epc, edt, _setDailyTimerSetting(epc, edt));
			break;
		case EPC_DAILY_TIMER_SETTING1:
			res.addProperty(epc, edt, _setDailyTimerSetting1(epc, edt));
			break;
		case EPC_DAILY_TIMER_SETTING2:
			res.addProperty(epc, edt, _setDailyTimerSetting2(epc, edt));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			break;
		case EPC_TIME_SET_BY_ON_TIMER:
			res.addProperty(epc, edt, _setTimeSetByOnTimer(epc, edt));
			break;
		case EPC_RELATIVE_ON_TIMER_SETTING:
			res.addProperty(epc, edt, _setRelativeOnTimerSetting(epc, edt));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			res.addProperty(epc, edt, _setOffTimerReservationSetting(epc, edt));
			break;
		case EPC_TIME_SET_BY_OFF_TIMER:
			res.addProperty(epc, edt, _setTimeSetByOffTimer(epc, edt));
			break;
		case EPC_RELATIVE_OFF_TIMER_SETTING:
			res.addProperty(epc, edt, _setRelativeOffTimerSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_TEMPERATURE_SETTING1:
			edt = _getTemperatureSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TEMPERATURE_SETTING2:
			edt = _getTemperatureSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_ROOM_TEEMPERATURE:
			edt = _getMeasuredRoomTeemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_FLOOR_TEMPERATURE:
			edt = _getMeasuredFloorTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_ZONE_CHANGE_SETTING:
			edt = _getZoneChangeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SPECIAL_OPERATION_SETTING:
			edt = _getSpecialOperationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DAILY_TIMER_SETTING:
			edt = _getDailyTimerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DAILY_TIMER_SETTING1:
			edt = _getDailyTimerSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_DAILY_TIMER_SETTING2:
			edt = _getDailyTimerSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 6)));
			break;
		case EPC_ON_TIMER_RESERVATION_SETTING:
			edt = _getOnTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TIME_SET_BY_ON_TIMER:
			edt = _getTimeSetByOnTimer(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RELATIVE_ON_TIMER_SETTING:
			edt = _getRelativeOnTimerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_OFF_TIMER_RESERVATION_SETTING:
			edt = _getOffTimerReservationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TIME_SET_BY_OFF_TIMER:
			edt = _getTimeSetByOffTimer(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RELATIVE_OFF_TIMER_SETTING:
			edt = _getRelativeOffTimerSetting(epc);
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
			case EPC_TEMPERATURE_SETTING1:
				_onSetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_TEMPERATURE_SETTING2:
				_onSetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ZONE_CHANGE_SETTING:
				_onSetZoneChangeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SPECIAL_OPERATION_SETTING:
				_onSetSpecialOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DAILY_TIMER_SETTING:
				_onSetDailyTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DAILY_TIMER_SETTING1:
				_onSetDailyTimerSetting1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DAILY_TIMER_SETTING2:
				_onSetDailyTimerSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_TIME_SET_BY_ON_TIMER:
				_onSetTimeSetByOnTimer(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_RELATIVE_ON_TIMER_SETTING:
				_onSetRelativeOnTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				_onSetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_TIME_SET_BY_OFF_TIMER:
				_onSetTimeSetByOffTimer(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_RELATIVE_OFF_TIMER_SETTING:
				_onSetRelativeOffTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_TEMPERATURE_SETTING1:
				_onGetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TEMPERATURE_SETTING2:
				_onGetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_ROOM_TEEMPERATURE:
				_onGetMeasuredRoomTeemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_FLOOR_TEMPERATURE:
				_onGetMeasuredFloorTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ZONE_CHANGE_SETTING:
				_onGetZoneChangeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPECIAL_OPERATION_SETTING:
				_onGetSpecialOperationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DAILY_TIMER_SETTING:
				_onGetDailyTimerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DAILY_TIMER_SETTING1:
				_onGetDailyTimerSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DAILY_TIMER_SETTING2:
				_onGetDailyTimerSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TIME_SET_BY_ON_TIMER:
				_onGetTimeSetByOnTimer(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RELATIVE_ON_TIMER_SETTING:
				_onGetRelativeOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				_onGetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TIME_SET_BY_OFF_TIMER:
				_onGetTimeSetByOffTimer(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RELATIVE_OFF_TIMER_SETTING:
				_onGetRelativeOffTimerSetting(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured room temperature<br>0x81-0x7D�i-127-125���j<br><br>Data type : signed char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredRoomTeemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredRoomTeemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredRoomTeemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured floor temperature<br>0x00-0x32�i0-50���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredFloorTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredFloorTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredFloorTemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetZoneChangeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetZoneChangeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetZoneChangeSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetZoneChangeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetZoneChangeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetZoneChangeSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSpecialOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSpecialOperationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDailyTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDailyTimerSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDailyTimerSetting1(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDailyTimerSetting1(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDailyTimerSetting2(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDailyTimerSetting2(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTimeSetByOnTimer(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTimeSetByOnTimer(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTimeSetByOffTimer(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTimeSetByOffTimer(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeOffTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeOffTimerSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetTemperatureSetting1(byte[] edt);
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Setter reqSetTemperatureSetting2(byte[] edt);
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetZoneChangeSetting(byte[] edt);
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSpecialOperationSetting(byte[] edt);
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDailyTimerSetting(byte[] edt);
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDailyTimerSetting1(byte[] edt);
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDailyTimerSetting2(byte[] edt);
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTimeSetByOnTimer(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRelativeOnTimerSetting(byte[] edt);
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetTimeSetByOffTimer(byte[] edt);
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
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
		public Setter reqSetTemperatureSetting1(byte[] edt) {
			byte epc = EPC_TEMPERATURE_SETTING1;
			addProperty(epc, edt, _setTemperatureSetting1(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetTemperatureSetting2(byte[] edt) {
			byte epc = EPC_TEMPERATURE_SETTING2;
			addProperty(epc, edt, _setTemperatureSetting2(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetZoneChangeSetting(byte[] edt) {
			byte epc = EPC_ZONE_CHANGE_SETTING;
			addProperty(epc, edt, _setZoneChangeSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetSpecialOperationSetting(byte[] edt) {
			byte epc = EPC_SPECIAL_OPERATION_SETTING;
			addProperty(epc, edt, _setSpecialOperationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetDailyTimerSetting(byte[] edt) {
			byte epc = EPC_DAILY_TIMER_SETTING;
			addProperty(epc, edt, _setDailyTimerSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetDailyTimerSetting1(byte[] edt) {
			byte epc = EPC_DAILY_TIMER_SETTING1;
			addProperty(epc, edt, _setDailyTimerSetting1(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetDailyTimerSetting2(byte[] edt) {
			byte epc = EPC_DAILY_TIMER_SETTING2;
			addProperty(epc, edt, _setDailyTimerSetting2(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			byte epc = EPC_ON_TIMER_RESERVATION_SETTING;
			addProperty(epc, edt, _setOnTimerReservationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetTimeSetByOnTimer(byte[] edt) {
			byte epc = EPC_TIME_SET_BY_ON_TIMER;
			addProperty(epc, edt, _setTimeSetByOnTimer(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeOnTimerSetting(byte[] edt) {
			byte epc = EPC_RELATIVE_ON_TIMER_SETTING;
			addProperty(epc, edt, _setRelativeOnTimerSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			byte epc = EPC_OFF_TIMER_RESERVATION_SETTING;
			addProperty(epc, edt, _setOffTimerReservationSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetTimeSetByOffTimer(byte[] edt) {
			byte epc = EPC_TIME_SET_BY_OFF_TIMER;
			addProperty(epc, edt, _setTimeSetByOffTimer(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetRelativeOffTimerSetting(byte[] edt) {
			byte epc = EPC_RELATIVE_OFF_TIMER_SETTING;
			addProperty(epc, edt, _setRelativeOffTimerSetting(epc, edt));
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
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetTemperatureSetting1();
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Getter reqGetTemperatureSetting2();
		/**
		 * Measured room temperature<br>0x81-0x7D�i-127-125���j<br><br>Data type : signed char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredRoomTeemperature();
		/**
		 * Measured floor temperature<br>0x00-0x32�i0-50���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredFloorTemperature();
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetZoneChangeSetting();
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSpecialOperationSetting();
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDailyTimerSetting();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDailyTimerSetting1();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDailyTimerSetting2();
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTimeSetByOnTimer();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRelativeOnTimerSetting();
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetTimeSetByOffTimer();
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
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
		public Getter reqGetTemperatureSetting1() {
			byte epc = EPC_TEMPERATURE_SETTING1;
			byte[] edt = _getTemperatureSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTemperatureSetting2() {
			byte epc = EPC_TEMPERATURE_SETTING2;
			byte[] edt = _getTemperatureSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredRoomTeemperature() {
			byte epc = EPC_MEASURED_ROOM_TEEMPERATURE;
			byte[] edt = _getMeasuredRoomTeemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredFloorTemperature() {
			byte epc = EPC_MEASURED_FLOOR_TEMPERATURE;
			byte[] edt = _getMeasuredFloorTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetZoneChangeSetting() {
			byte epc = EPC_ZONE_CHANGE_SETTING;
			byte[] edt = _getZoneChangeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSpecialOperationSetting() {
			byte epc = EPC_SPECIAL_OPERATION_SETTING;
			byte[] edt = _getSpecialOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDailyTimerSetting() {
			byte epc = EPC_DAILY_TIMER_SETTING;
			byte[] edt = _getDailyTimerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDailyTimerSetting1() {
			byte epc = EPC_DAILY_TIMER_SETTING1;
			byte[] edt = _getDailyTimerSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Getter reqGetDailyTimerSetting2() {
			byte epc = EPC_DAILY_TIMER_SETTING2;
			byte[] edt = _getDailyTimerSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
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
		public Getter reqGetTimeSetByOnTimer() {
			byte epc = EPC_TIME_SET_BY_ON_TIMER;
			byte[] edt = _getTimeSetByOnTimer(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRelativeOnTimerSetting() {
			byte epc = EPC_RELATIVE_ON_TIMER_SETTING;
			byte[] edt = _getRelativeOnTimerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetOffTimerReservationSetting() {
			byte epc = EPC_OFF_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOffTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTimeSetByOffTimer() {
			byte epc = EPC_TIME_SET_BY_OFF_TIMER;
			byte[] edt = _getTimeSetByOffTimer(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRelativeOffTimerSetting() {
			byte epc = EPC_RELATIVE_OFF_TIMER_SETTING;
			byte[] edt = _getRelativeOffTimerSetting(epc);
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
		 * This property indicates set temperature<br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformTemperatureSetting1();
		/**
		 * This property indicates set temperature level by 15 steps<br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		public Informer reqInformTemperatureSetting2();
		/**
		 * Measured room temperature<br>0x81-0x7D�i-127-125���j<br><br>Data type : signed char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredRoomTeemperature();
		/**
		 * Measured floor temperature<br>0x00-0x32�i0-50���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredFloorTemperature();
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformZoneChangeSetting();
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSpecialOperationSetting();
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDailyTimerSetting();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDailyTimerSetting1();
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDailyTimerSetting2();
		/**
		 * Reservation ON/OFF<br>ON=0x41, OFF=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTimeSetByOnTimer();
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRelativeOnTimerSetting();
		/**
		 * Reservation ON/OFF<br>ON��0x41, OFF��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformTimeSetByOffTimer();
		/**
		 * Timer value HH:MM<br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
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
		public Informer reqInformTemperatureSetting1() {
			byte epc = EPC_TEMPERATURE_SETTING1;
			byte[] edt = _getTemperatureSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTemperatureSetting2() {
			byte epc = EPC_TEMPERATURE_SETTING2;
			byte[] edt = _getTemperatureSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredRoomTeemperature() {
			byte epc = EPC_MEASURED_ROOM_TEEMPERATURE;
			byte[] edt = _getMeasuredRoomTeemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredFloorTemperature() {
			byte epc = EPC_MEASURED_FLOOR_TEMPERATURE;
			byte[] edt = _getMeasuredFloorTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformZoneChangeSetting() {
			byte epc = EPC_ZONE_CHANGE_SETTING;
			byte[] edt = _getZoneChangeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSpecialOperationSetting() {
			byte epc = EPC_SPECIAL_OPERATION_SETTING;
			byte[] edt = _getSpecialOperationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDailyTimerSetting() {
			byte epc = EPC_DAILY_TIMER_SETTING;
			byte[] edt = _getDailyTimerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDailyTimerSetting1() {
			byte epc = EPC_DAILY_TIMER_SETTING1;
			byte[] edt = _getDailyTimerSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		@Override
		public Informer reqInformDailyTimerSetting2() {
			byte epc = EPC_DAILY_TIMER_SETTING2;
			byte[] edt = _getDailyTimerSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 6)));
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
		public Informer reqInformTimeSetByOnTimer() {
			byte epc = EPC_TIME_SET_BY_ON_TIMER;
			byte[] edt = _getTimeSetByOnTimer(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRelativeOnTimerSetting() {
			byte epc = EPC_RELATIVE_ON_TIMER_SETTING;
			byte[] edt = _getRelativeOnTimerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformOffTimerReservationSetting() {
			byte epc = EPC_OFF_TIMER_RESERVATION_SETTING;
			byte[] edt = _getOffTimerReservationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTimeSetByOffTimer() {
			byte epc = EPC_TIME_SET_BY_OFF_TIMER;
			byte[] edt = _getTimeSetByOffTimer(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRelativeOffTimerSetting() {
			byte epc = EPC_RELATIVE_OFF_TIMER_SETTING;
			byte[] edt = _getRelativeOffTimerSetting(epc);
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
