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
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x7B;
	
	public FloorHeater() {
		setReceiver(new Receiver());
	}

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
	 * This property indicates set temperature<br><br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Name : Temperature setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract boolean setTemperatureSetting1(byte[] edt);
	private final boolean _setTemperatureSetting1(byte epc, byte[] edt) {
		boolean success = setTemperatureSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates set temperature<br><br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Name : Temperature setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract byte[] getTemperatureSetting1();
	private final byte[] _getTemperatureSetting1(byte epc) {
		byte[] edt = getTemperatureSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates set temperature level by 15 steps<br><br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Name : Temperature setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract boolean setTemperatureSetting2(byte[] edt);
	private final boolean _setTemperatureSetting2(byte epc, byte[] edt) {
		boolean success = setTemperatureSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates set temperature level by 15 steps<br><br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Name : Temperature setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
	 */
	protected abstract byte[] getTemperatureSetting2();
	private final byte[] _getTemperatureSetting2(byte epc) {
		byte[] edt = getTemperatureSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Measured room temperature<br><br>0x81-0x7D�i-127-125���j<br><br>Name : Measured room teemperature<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredRoomTeemperature() {return null;}
	private final byte[] _getMeasuredRoomTeemperature(byte epc) {
		byte[] edt = getMeasuredRoomTeemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Measured floor temperature<br><br>0x00-0x32�i0-50���j<br><br>Name : Measured floor temperature<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMeasuredFloorTemperature() {return null;}
	private final byte[] _getMeasuredFloorTemperature(byte epc) {
		byte[] edt = getMeasuredFloorTemperature();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets the target zone for control and gets the number of controllable zones<br><br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Name : Zone change setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setZoneChangeSetting(byte[] edt) {return false;}
	private final boolean _setZoneChangeSetting(byte epc, byte[] edt) {
		boolean success = setZoneChangeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets the target zone for control and gets the number of controllable zones<br><br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Name : Zone change setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getZoneChangeSetting() {return null;}
	private final byte[] _getZoneChangeSetting(byte epc) {
		byte[] edt = getZoneChangeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets Nornal Operation/modest operation/high power operation and gets the status<br><br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Name : Special operation setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSpecialOperationSetting(byte[] edt) {return false;}
	private final boolean _setSpecialOperationSetting(byte epc, byte[] edt) {
		boolean success = setSpecialOperationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets Nornal Operation/modest operation/high power operation and gets the status<br><br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Name : Special operation setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSpecialOperationSetting() {return null;}
	private final byte[] _getSpecialOperationSetting(byte epc) {
		byte[] edt = getSpecialOperationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br><br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Name : Daily timer setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDailyTimerSetting(byte[] edt) {return false;}
	private final boolean _setDailyTimerSetting(byte epc, byte[] edt) {
		boolean success = setDailyTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br><br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Name : Daily timer setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDailyTimerSetting() {return null;}
	private final byte[] _getDailyTimerSetting(byte epc) {
		byte[] edt = getDailyTimerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 1<br>EPC : 0xE7<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDailyTimerSetting1(byte[] edt) {return false;}
	private final boolean _setDailyTimerSetting1(byte epc, byte[] edt) {
		boolean success = setDailyTimerSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 1<br>EPC : 0xE7<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDailyTimerSetting1() {return null;}
	private final byte[] _getDailyTimerSetting1(byte epc) {
		byte[] edt = getDailyTimerSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 2<br>EPC : 0xE8<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDailyTimerSetting2(byte[] edt) {return false;}
	private final boolean _setDailyTimerSetting2(byte epc, byte[] edt) {
		boolean success = setDailyTimerSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 2<br>EPC : 0xE8<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDailyTimerSetting2() {return null;}
	private final byte[] _getDailyTimerSetting2(byte epc) {
		byte[] edt = getDailyTimerSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by ON timer<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTimeSetByOnTimer(byte[] edt) {return false;}
	private final boolean _setTimeSetByOnTimer(byte epc, byte[] edt) {
		boolean success = setTimeSetByOnTimer(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by ON timer<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTimeSetByOnTimer() {return null;}
	private final byte[] _getTimeSetByOnTimer(byte epc) {
		byte[] edt = getTimeSetByOnTimer();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Relative ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRelativeOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setRelativeOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setRelativeOnTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Relative ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRelativeOnTimerSetting() {return null;}
	private final byte[] _getRelativeOnTimerSetting(byte epc) {
		byte[] edt = getRelativeOnTimerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Reservation ON/OFF<br><br>ON��0x41, OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOffTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOffTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOffTimerReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Reservation ON/OFF<br><br>ON��0x41, OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOffTimerReservationSetting() {return null;}
	private final byte[] _getOffTimerReservationSetting(byte epc) {
		byte[] edt = getOffTimerReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by OFF timer<br>EPC : 0x95<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTimeSetByOffTimer(byte[] edt) {return false;}
	private final boolean _setTimeSetByOffTimer(byte epc, byte[] edt) {
		boolean success = setTimeSetByOffTimer(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by OFF timer<br>EPC : 0x95<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTimeSetByOffTimer() {return null;}
	private final byte[] _getTimeSetByOffTimer(byte epc) {
		byte[] edt = getTimeSetByOffTimer();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Relative OFF timer setting<br>EPC : 0x96<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRelativeOffTimerSetting(byte[] edt) {return false;}
	private final boolean _setRelativeOffTimerSetting(byte epc, byte[] edt) {
		boolean success = setRelativeOffTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Relative OFF timer setting<br>EPC : 0x96<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRelativeOffTimerSetting() {return null;}
	private final byte[] _getRelativeOffTimerSetting(byte epc) {
		byte[] edt = getRelativeOffTimerSetting();
		onInvokedGetMethod(epc, edt);
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
			case EPC_TEMPERATURE_SETTING1:
				_onSetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_TEMPERATURE_SETTING2:
				_onSetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ZONE_CHANGE_SETTING:
				_onSetZoneChangeSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SPECIAL_OPERATION_SETTING:
				_onSetSpecialOperationSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_DAILY_TIMER_SETTING:
				_onSetDailyTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_DAILY_TIMER_SETTING1:
				_onSetDailyTimerSetting1(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_DAILY_TIMER_SETTING2:
				_onSetDailyTimerSetting2(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_ON_TIMER_RESERVATION_SETTING:
				_onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_TIME_SET_BY_ON_TIMER:
				_onSetTimeSetByOnTimer(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_RELATIVE_ON_TIMER_SETTING:
				_onSetRelativeOnTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_OFF_TIMER_RESERVATION_SETTING:
				_onSetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_TIME_SET_BY_OFF_TIMER:
				_onSetTimeSetByOffTimer(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_RELATIVE_OFF_TIMER_SETTING:
				_onSetRelativeOffTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
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
		 * This property indicates set temperature<br><br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Name : Temperature setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onSetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates set temperature<br><br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Name : Temperature setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onGetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates set temperature level by 15 steps<br><br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Name : Temperature setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onSetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates set temperature level by 15 steps<br><br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Name : Temperature setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		protected void onGetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTemperatureSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured room temperature<br><br>0x81-0x7D�i-127-125���j<br><br>Name : Measured room teemperature<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredRoomTeemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredRoomTeemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredRoomTeemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured floor temperature<br><br>0x00-0x32�i0-50���j<br><br>Name : Measured floor temperature<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMeasuredFloorTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredFloorTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredFloorTemperature(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br><br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Name : Zone change setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetZoneChangeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetZoneChangeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetZoneChangeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br><br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Name : Zone change setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetZoneChangeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetZoneChangeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetZoneChangeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br><br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Name : Special operation setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSpecialOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br><br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Name : Special operation setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSpecialOperationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br><br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Name : Daily timer setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDailyTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br><br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Name : Daily timer setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDailyTimerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 1<br>EPC : 0xE7<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDailyTimerSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 1<br>EPC : 0xE7<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDailyTimerSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 2<br>EPC : 0xE8<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDailyTimerSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 2<br>EPC : 0xE8<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDailyTimerSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by ON timer<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTimeSetByOnTimer(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by ON timer<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTimeSetByOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTimeSetByOnTimer(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Relative ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Relative ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Reservation ON/OFF<br><br>ON��0x41, OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Reservation ON/OFF<br><br>ON��0x41, OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOffTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOffTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by OFF timer<br>EPC : 0x95<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTimeSetByOffTimer(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by OFF timer<br>EPC : 0x95<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTimeSetByOffTimer(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Relative OFF timer setting<br>EPC : 0x96<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeOffTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Relative OFF timer setting<br>EPC : 0x96<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRelativeOffTimerSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * This property indicates set temperature<br><br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Name : Temperature setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Setter reqSetTemperatureSetting1(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * This property indicates set temperature level by 15 steps<br><br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Name : Temperature setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Setter reqSetTemperatureSetting2(byte[] edt) {
			addProperty(EPC_TEMPERATURE_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br><br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Name : Zone change setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetZoneChangeSetting(byte[] edt) {
			addProperty(EPC_ZONE_CHANGE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br><br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Name : Special operation setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSpecialOperationSetting(byte[] edt) {
			addProperty(EPC_SPECIAL_OPERATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br><br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Name : Daily timer setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDailyTimerSetting(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 1<br>EPC : 0xE7<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDailyTimerSetting1(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING1, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 2<br>EPC : 0xE8<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDailyTimerSetting2(byte[] edt) {
			addProperty(EPC_DAILY_TIMER_SETTING2, edt, (edt != null && (edt.length == 6)));
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by ON timer<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTimeSetByOnTimer(byte[] edt) {
			addProperty(EPC_TIME_SET_BY_ON_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Relative ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRelativeOnTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>ON��0x41, OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOffTimerReservationSetting(byte[] edt) {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by OFF timer<br>EPC : 0x95<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTimeSetByOffTimer(byte[] edt) {
			addProperty(EPC_TIME_SET_BY_OFF_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Relative OFF timer setting<br>EPC : 0x96<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRelativeOffTimerSetting(byte[] edt) {
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates set temperature<br><br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Name : Temperature setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Getter reqGetTemperatureSetting1() {
			addProperty(EPC_TEMPERATURE_SETTING1);
			return this;
		}
		/**
		 * This property indicates set temperature level by 15 steps<br><br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Name : Temperature setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Getter reqGetTemperatureSetting2() {
			addProperty(EPC_TEMPERATURE_SETTING2);
			return this;
		}
		/**
		 * Measured room temperature<br><br>0x81-0x7D�i-127-125���j<br><br>Name : Measured room teemperature<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredRoomTeemperature() {
			addProperty(EPC_MEASURED_ROOM_TEEMPERATURE);
			return this;
		}
		/**
		 * Measured floor temperature<br><br>0x00-0x32�i0-50���j<br><br>Name : Measured floor temperature<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMeasuredFloorTemperature() {
			addProperty(EPC_MEASURED_FLOOR_TEMPERATURE);
			return this;
		}
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br><br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Name : Zone change setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetZoneChangeSetting() {
			addProperty(EPC_ZONE_CHANGE_SETTING);
			return this;
		}
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br><br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Name : Special operation setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSpecialOperationSetting() {
			addProperty(EPC_SPECIAL_OPERATION_SETTING);
			return this;
		}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br><br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Name : Daily timer setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDailyTimerSetting() {
			addProperty(EPC_DAILY_TIMER_SETTING);
			return this;
		}
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 1<br>EPC : 0xE7<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDailyTimerSetting1() {
			addProperty(EPC_DAILY_TIMER_SETTING1);
			return this;
		}
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 2<br>EPC : 0xE8<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDailyTimerSetting2() {
			addProperty(EPC_DAILY_TIMER_SETTING2);
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by ON timer<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTimeSetByOnTimer() {
			addProperty(EPC_TIME_SET_BY_ON_TIMER);
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Relative ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRelativeOnTimerSetting() {
			addProperty(EPC_RELATIVE_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Reservation ON/OFF<br><br>ON��0x41, OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOffTimerReservationSetting() {
			addProperty(EPC_OFF_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by OFF timer<br>EPC : 0x95<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTimeSetByOffTimer() {
			addProperty(EPC_TIME_SET_BY_OFF_TIMER);
			return this;
		}
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Relative OFF timer setting<br>EPC : 0x96<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRelativeOffTimerSetting() {
			addProperty(EPC_RELATIVE_OFF_TIMER_SETTING);
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
		 * This property indicates set temperature<br><br>0x00-0x32�i0-50���j AUTO��0x71<br><br>Name : Temperature setting 1<br>EPC : 0xE0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Informer reqInformTemperatureSetting1();
		/**
		 * This property indicates set temperature level by 15 steps<br><br>0x31-0x3F 0x31 indicates the minimum level, 0x3F indicates the maximumlevel AUTO=0x41<br><br>Name : Temperature setting 2<br>EPC : 0xE1<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : mandatory<br>Get : mandatory<br>
		 */
		public Informer reqInformTemperatureSetting2();
		/**
		 * Measured room temperature<br><br>0x81-0x7D�i-127-125���j<br><br>Name : Measured room teemperature<br>EPC : 0xE2<br>Data Type : signed char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredRoomTeemperature();
		/**
		 * Measured floor temperature<br><br>0x00-0x32�i0-50���j<br><br>Name : Measured floor temperature<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMeasuredFloorTemperature();
		/**
		 * Sets the target zone for control and gets the number of controllable zones<br><br>b0-b7 is allocated to 0 to 7 Each bit 1: with control, 0: without control<br><br>Name : Zone change setting<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformZoneChangeSetting();
		/**
		 * Sets Nornal Operation/modest operation/high power operation and gets the status<br><br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Name : Special operation setting<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSpecialOperationSetting();
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br><br>Timer OFF=0x40, timer 1=0x41, timer 2=0x42<br><br>Name : Daily timer setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDailyTimerSetting();
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 1<br>EPC : 0xE7<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDailyTimerSetting1();
		/**
		 * Time set by daily timer<br><br>Set the time in the unit of 30 minutes, deviding 24 hours by 30 minutes and allocated to 6 bytes. Each bit 1: worked 0: stopped<br><br>Name : Daily timer setting 2<br>EPC : 0xE8<br>Data Type : unsigned char x 6<br>Data Size(Byte) : 6 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDailyTimerSetting2();
		/**
		 * Reservation ON/OFF<br><br>ON=0x41, OFF=0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by ON timer<br>EPC : 0x91<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTimeSetByOnTimer();
		/**
		 * Timer value HH:MM<br><br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Name : Relative ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char x 2<br>Data Size(Byte) : 2 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRelativeOnTimerSetting();
		/**
		 * Reservation ON/OFF<br><br>ON��0x41, OFF��0x42<br><br>Name : OFF timer reservation setting<br>EPC : 0x94<br>Data Type : unsigned char<br>Data Size(Byte) : 1 Byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOffTimerReservationSetting();
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Time set by OFF timer<br>EPC : 0x95<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTimeSetByOffTimer();
		/**
		 * Timer value HH:MM<br><br>0-0x17:  0-0x3B (=0-23):(=0-59)<br><br>Name : Relative OFF timer setting<br>EPC : 0x96<br>Data Type : unsigned char �~2<br>Data Size(Byte) : 2 Bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRelativeOffTimerSetting();
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
