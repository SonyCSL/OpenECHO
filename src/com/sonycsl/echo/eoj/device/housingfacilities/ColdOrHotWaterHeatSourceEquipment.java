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

	public static final byte EPC_OPERATION_MODE_SETTING = (byte)0xE0;
	public static final byte EPC_WATER_TEMPERATURE_SETTING1 = (byte)0xE1;
	public static final byte EPC_WATER_TEMPERATURE_SETTING2 = (byte)0xE2;
	public static final byte EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE = (byte)0xE3;
	public static final byte EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE = (byte)0xE4;
	public static final byte EPC_SPECIAL_OPERATION_SETTING = (byte)0xE5;
	public static final byte EPC_DAILY_TIMER_SETTING = (byte)0xE6;
	public static final byte EPC_DAILY_TIMER_SETTING1 = (byte)0xE7;
	public static final byte EPC_DAILY_TIMER_SETTING2 = (byte)0xE8;
	public static final byte EPC_ON_TIMER_RESERVATION_SETTING = (byte)0x90;
	public static final byte EPC_ON_TIMER_SETTING = (byte)0x91;
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
	 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOperationModeSetting(byte[] edt) {return false;}
	private final boolean _setOperationModeSetting(byte epc, byte[] edt) {
		boolean success = setOperationModeSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOperationModeSetting() {return null;}
	private final byte[] _getOperationModeSetting(byte epc) {
		byte[] edt = getOperationModeSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setWaterTemperatureSetting1(byte[] edt);
	private final boolean _setWaterTemperatureSetting1(byte epc, byte[] edt) {
		boolean success = setWaterTemperatureSetting1(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getWaterTemperatureSetting1();
	private final byte[] _getWaterTemperatureSetting1(byte epc) {
		byte[] edt = getWaterTemperatureSetting1();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract boolean setWaterTemperatureSetting2(byte[] edt);
	private final boolean _setWaterTemperatureSetting2(byte epc, byte[] edt) {
		boolean success = setWaterTemperatureSetting2(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
	 */
	protected abstract byte[] getWaterTemperatureSetting2();
	private final byte[] _getWaterTemperatureSetting2(byte epc) {
		byte[] edt = getWaterTemperatureSetting2();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Measured temperature of outward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredTemperatureOfOutwardWaterExitWaterTemperature() {return null;}
	private final byte[] _getMeasuredTemperatureOfOutwardWaterExitWaterTemperature(byte epc) {
		byte[] edt = getMeasuredTemperatureOfOutwardWaterExitWaterTemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Measured temperature of inward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature() {return null;}
	private final byte[] _getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(byte epc) {
		byte[] edt = getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSpecialOperationSetting(byte[] edt) {return false;}
	private final boolean _setSpecialOperationSetting(byte epc, byte[] edt) {
		boolean success = setSpecialOperationSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSpecialOperationSetting() {return null;}
	private final byte[] _getSpecialOperationSetting(byte epc) {
		byte[] edt = getSpecialOperationSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDailyTimerSetting(byte[] edt) {return false;}
	private final boolean _setDailyTimerSetting(byte epc, byte[] edt) {
		boolean success = setDailyTimerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDailyTimerSetting() {return null;}
	private final byte[] _getDailyTimerSetting(byte epc) {
		byte[] edt = getDailyTimerSetting();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setDailyTimerSetting1(byte[] edt) {return false;}
	private final boolean _setDailyTimerSetting1(byte epc, byte[] edt) {
		boolean success = setDailyTimerSetting1(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDailyTimerSetting1() {return null;}
	private final byte[] _getDailyTimerSetting1(byte epc) {
		byte[] edt = getDailyTimerSetting1();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setDailyTimerSetting2(byte[] edt) {return false;}
	private final boolean _setDailyTimerSetting2(byte epc, byte[] edt) {
		boolean success = setDailyTimerSetting2(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
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
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSetting() {return null;}
	private final byte[] _getOnTimerSetting(byte epc) {
		byte[] edt = getOnTimerSetting();
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
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setTimeSetByOffTimer(byte[] edt) {return false;}
	private final boolean _setTimeSetByOffTimer(byte epc, byte[] edt) {
		boolean success = setTimeSetByOffTimer(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected byte[] getTimeSetByOffTimer() {return null;}
	private final byte[] _getTimeSetByOffTimer(byte epc) {
		byte[] edt = getTimeSetByOffTimer();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeOffTimerSetting(byte[] edt) {return false;}
	private final boolean _setRelativeOffTimerSetting(byte epc, byte[] edt) {
		boolean success = setRelativeOffTimerSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
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
		case EPC_OPERATION_MODE_SETTING:
			res.addProperty(epc, edt, _setOperationModeSetting(epc, edt));
			break;
		case EPC_WATER_TEMPERATURE_SETTING1:
			res.addProperty(epc, edt, _setWaterTemperatureSetting1(epc, edt));
			break;
		case EPC_WATER_TEMPERATURE_SETTING2:
			res.addProperty(epc, edt, _setWaterTemperatureSetting2(epc, edt));
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
		case EPC_ON_TIMER_SETTING:
			res.addProperty(epc, edt, _setOnTimerSetting(epc, edt));
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
		case EPC_OPERATION_MODE_SETTING:
			edt = _getOperationModeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_TEMPERATURE_SETTING1:
			edt = _getWaterTemperatureSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_TEMPERATURE_SETTING2:
			edt = _getWaterTemperatureSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE:
			edt = _getMeasuredTemperatureOfOutwardWaterExitWaterTemperature(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE:
			edt = _getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(epc);
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
		case EPC_ON_TIMER_SETTING:
			edt = _getOnTimerSetting(epc);
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
			case EPC_OPERATION_MODE_SETTING:
				_onSetOperationModeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WATER_TEMPERATURE_SETTING1:
				_onSetWaterTemperatureSetting1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WATER_TEMPERATURE_SETTING2:
				_onSetWaterTemperatureSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
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
			case EPC_ON_TIMER_SETTING:
				_onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
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
			case EPC_OPERATION_MODE_SETTING:
				_onGetOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WATER_TEMPERATURE_SETTING1:
				_onGetWaterTemperatureSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WATER_TEMPERATURE_SETTING2:
				_onGetWaterTemperatureSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE:
				_onGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE:
				_onGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(eoj, tid, esv, epc, pdc, edt);
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
			case EPC_ON_TIMER_SETTING:
				_onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOperationModeSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Set the operation mode of heating (hot water)/cooling (cold water) and gets the status<br>Heating��0x41,Cooling��0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationModeSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetWaterTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWaterTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWaterTemperatureSetting1(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates water temperature setting�B<br>0x00-0x64�i0-100���j AUTO��0x71<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetWaterTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWaterTemperatureSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWaterTemperatureSetting1(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onSetWaterTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWaterTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWaterTemperatureSetting2(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates water temperature setting level by 15 steps<br>Cooling (cold water):0x21-0x2F Heating (hot water):0x31-0x3F indicated the minimum to maximumlevel respectively AUTO=0x41<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory
		 */
		protected void onGetWaterTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWaterTemperatureSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWaterTemperatureSetting2(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured temperature of outward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Measured temperature of inward water<br>0x00-0x64�i0-100���j<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSpecialOperationSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets Nornal Operation/ modest o peration/high power operation and gets the status<br>Nornal Operation=0x41, modest operation=0x42�high power operation=0x43<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSpecialOperationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSpecialOperationSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDailyTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Daily timer ON/OFF Up tp 2 kinds of timers can be used<br>Timer OFF=0x40, timer 1=0x41 timer 2=0x42<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDailyTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDailyTimerSetting(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDailyTimerSetting1(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDailyTimerSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDailyTimerSetting1(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDailyTimerSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDailyTimerSetting2(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Time set by daily timer<br>Set the time in the unit of 30 minutes, dividing 24 hours by 30 minutes and allocated 6 bytes. Each bit 1: worked 0: stopped<br><br>Data type : unsigned char x 6<br>Data size : 6 Bytes<br>Set : optional<br>Get : optional
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
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char x 2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTimeSetByOffTimer(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onGetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTimeSetByOffTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTimeSetByOffTimer(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeOffTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeOffTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Timer value HH:MM<br>0-0x17: 0-0x3B (=0-23):(=0-59)<br><br>Data type : unsigned char �~2<br>Data size : 2 Bytes<br>Set : optional<br>Get : optional
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
			byte epc = EPC_OPERATION_MODE_SETTING;
			addProperty(epc, edt, _setOperationModeSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetWaterTemperatureSetting1(byte[] edt) {
			byte epc = EPC_WATER_TEMPERATURE_SETTING1;
			addProperty(epc, edt, _setWaterTemperatureSetting1(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetWaterTemperatureSetting2(byte[] edt) {
			byte epc = EPC_WATER_TEMPERATURE_SETTING2;
			addProperty(epc, edt, _setWaterTemperatureSetting2(epc, edt));
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
		public Setter reqSetOnTimerSetting(byte[] edt) {
			byte epc = EPC_ON_TIMER_SETTING;
			addProperty(epc, edt, _setOnTimerSetting(epc, edt));
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
			byte epc = EPC_OPERATION_MODE_SETTING;
			byte[] edt = _getOperationModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWaterTemperatureSetting1() {
			byte epc = EPC_WATER_TEMPERATURE_SETTING1;
			byte[] edt = _getWaterTemperatureSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWaterTemperatureSetting2() {
			byte epc = EPC_WATER_TEMPERATURE_SETTING2;
			byte[] edt = _getWaterTemperatureSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfOutwardWaterExitWaterTemperature() {
			byte epc = EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE;
			byte[] edt = _getMeasuredTemperatureOfOutwardWaterExitWaterTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredTemperatureOfInwardWaterEntranceWaterTemperature() {
			byte epc = EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE;
			byte[] edt = _getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(epc);
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
		public Getter reqGetOnTimerSetting() {
			byte epc = EPC_ON_TIMER_SETTING;
			byte[] edt = _getOnTimerSetting(epc);
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
			byte epc = EPC_OPERATION_MODE_SETTING;
			byte[] edt = _getOperationModeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterTemperatureSetting1() {
			byte epc = EPC_WATER_TEMPERATURE_SETTING1;
			byte[] edt = _getWaterTemperatureSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterTemperatureSetting2() {
			byte epc = EPC_WATER_TEMPERATURE_SETTING2;
			byte[] edt = _getWaterTemperatureSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfOutwardWaterExitWaterTemperature() {
			byte epc = EPC_MEASURED_TEMPERATURE_OF_OUTWARD_WATER_EXIT_WATER_TEMPERATURE;
			byte[] edt = _getMeasuredTemperatureOfOutwardWaterExitWaterTemperature(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredTemperatureOfInwardWaterEntranceWaterTemperature() {
			byte epc = EPC_MEASURED_TEMPERATURE_OF_INWARD_WATER_ENTRANCE_WATER_TEMPERATURE;
			byte[] edt = _getMeasuredTemperatureOfInwardWaterEntranceWaterTemperature(epc);
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
		public Informer reqInformOnTimerSetting() {
			byte epc = EPC_ON_TIMER_SETTING;
			byte[] edt = _getOnTimerSetting(epc);
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
