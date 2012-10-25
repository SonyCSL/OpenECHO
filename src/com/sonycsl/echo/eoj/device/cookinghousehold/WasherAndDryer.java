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

public abstract class WasherAndDryer extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xD3;
	
	public WasherAndDryer() {
		setReceiver(new Receiver());
	}

	public static final byte EPC_DOOR_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_WASHER_AND_DRYER_SETTING = (byte)0xB2;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 = (byte)0xD0;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 = (byte)0xD1;
	public static final byte EPC_DRYING_CYCLE_SETTING_NOTE1 = (byte)0xD2;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 = (byte)0xD3;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 = (byte)0xD4;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 = (byte)0xD5;
	public static final byte EPC_WATER_FLOW_RATE_SETTING = (byte)0xD6;
	public static final byte EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING = (byte)0xD7;
	public static final byte EPC_GDEGREE_OF_DRYING_H_SETTING = (byte)0xD8;
	public static final byte EPC_REMAINING_WASHING_TIME = (byte)0xDB;
	public static final byte EPC_REMAINING_DRYING_TIME = (byte)0xDC;
	public static final byte EPC_ELAPSED_TIME_ON_THE_ON_TIMER = (byte)0xDF;
	public static final byte EPC_PRESOAKING_TIME_SETTING = (byte)0xE1;
	public static final byte EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE = (byte)0xE2;
	public static final byte EPC_WATER_VOLUME_SETTING1 = (byte)0xE3;
	public static final byte EPC_WATER_VOLUME_SETTING2 = (byte)0xE4;
	public static final byte EPC_WASHING_TIME_SETTING = (byte)0xE5;
	public static final byte EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING = (byte)0xE6;
	public static final byte EPC_RINSING_PROCESS_SETTING = (byte)0xE7;
	public static final byte EPC_SPIN_DRYING_TIME_SETTING = (byte)0xE8;
	public static final byte EPC_DRYING_TIME_SETTING = (byte)0xE9;
	public static final byte EPC_WARM_WATER_SETTING = (byte)0xEA;
	public static final byte EPC_BATHTUB_WATER_RECYCLE_SETTING = (byte)0xEB;
	public static final byte EPC_WRINKLING_MINIMIZATION_SETTING = (byte)0xEC;
	public static final byte EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE = (byte)0xED;
	public static final byte EPC_DOOR_COVER_LOCK_SETTING = (byte)0xEE;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE = (byte)0xEF;
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
	 * Used to acquire the status of the door/cover (i.e. open or closed).<br><br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Name : Door/cover open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getDoorCoverOpenCloseStatus() {return null;}
	private final byte[] _getDoorCoverOpenCloseStatus(byte epc) {
		byte[] edt = getDoorCoverOpenCloseStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br><br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Name : Washer and dryer setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWasherAndDryerSetting(byte[] edt) {return false;}
	private final boolean _setWasherAndDryerSetting(byte epc, byte[] edt) {
		boolean success = setWasherAndDryerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br><br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Name : Washer and dryer setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWasherAndDryerSetting() {return null;}
	private final byte[] _getWasherAndDryerSetting(byte epc) {
		byte[] edt = getWasherAndDryerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Name : Washer and dryer cycle setting 1 (Note 1)<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWasherAndDryerCycleSetting1Note1(byte[] edt) {return false;}
	private final boolean _setWasherAndDryerCycleSetting1Note1(byte epc, byte[] edt) {
		boolean success = setWasherAndDryerCycleSetting1Note1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Name : Washer and dryer cycle setting 1 (Note 1)<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWasherAndDryerCycleSetting1Note1() {return null;}
	private final byte[] _getWasherAndDryerCycleSetting1Note1(byte epc) {
		byte[] edt = getWasherAndDryerCycleSetting1Note1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br><br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Name : Washer and dryer cycle setting 2 (Note 1)<br>EPC : 0xD1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWasherAndDryerCycleSetting2Note1(byte[] edt) {return false;}
	private final boolean _setWasherAndDryerCycleSetting2Note1(byte epc, byte[] edt) {
		boolean success = setWasherAndDryerCycleSetting2Note1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br><br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Name : Washer and dryer cycle setting 2 (Note 1)<br>EPC : 0xD1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWasherAndDryerCycleSetting2Note1() {return null;}
	private final byte[] _getWasherAndDryerCycleSetting2Note1(byte epc) {
		byte[] edt = getWasherAndDryerCycleSetting2Note1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br><br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Name : Drying cycle setting (Note1)<br>EPC : 0xD2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDryingCycleSettingNote1(byte[] edt) {return false;}
	private final boolean _setDryingCycleSettingNote1(byte epc, byte[] edt) {
		boolean success = setDryingCycleSettingNote1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br><br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Name : Drying cycle setting (Note1)<br>EPC : 0xD2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDryingCycleSettingNote1() {return null;}
	private final byte[] _getDryingCycleSettingNote1(byte epc) {
		byte[] edt = getDryingCycleSettingNote1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br><br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 1<br>EPC : 0xD3<br>Data Type : unsign ed char  ~12,<br>Data Size(Byte) : 12 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getWasherAndDryerCycleOptionList1() {return null;}
	private final byte[] _getWasherAndDryerCycleOptionList1(byte epc) {
		byte[] edt = getWasherAndDryerCycleOptionList1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br><br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 2<br>EPC : 0xD4<br>Data Type : unsign ed char  ~4,<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getWasherAndDryerCycleOptionList2() {return null;}
	private final byte[] _getWasherAndDryerCycleOptionList2(byte epc) {
		byte[] edt = getWasherAndDryerCycleOptionList2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br><br>When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 3<br>EPC : 0xD5<br>Data Type : unsign ed char  ~4,<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getWasherAndDryerCycleOptionList3() {return null;}
	private final byte[] _getWasherAndDryerCycleOptionList3(byte epc) {
		byte[] edt = getWasherAndDryerCycleOptionList3();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water flow rate setting<br>EPC : 0xD6<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWaterFlowRateSetting(byte[] edt) {return false;}
	private final boolean _setWaterFlowRateSetting(byte epc, byte[] edt) {
		boolean success = setWaterFlowRateSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water flow rate setting<br>EPC : 0xD6<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWaterFlowRateSetting() {return null;}
	private final byte[] _getWaterFlowRateSetting(byte epc) {
		byte[] edt = getWaterFlowRateSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Name :  gRotation speed for spin drying h setting<br>EPC : 0xD7<br>Data Type : unsign ed short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGrotationSpeedForSpinDryingHSetting(byte[] edt) {return false;}
	private final boolean _setGrotationSpeedForSpinDryingHSetting(byte epc, byte[] edt) {
		boolean success = setGrotationSpeedForSpinDryingHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Name :  gRotation speed for spin drying h setting<br>EPC : 0xD7<br>Data Type : unsign ed short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGrotationSpeedForSpinDryingHSetting() {return null;}
	private final byte[] _getGrotationSpeedForSpinDryingHSetting(byte epc) {
		byte[] edt = getGrotationSpeedForSpinDryingHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name :  gDegree of drying h setting<br>EPC : 0xD8<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGdegreeOfDryingHSetting(byte[] edt) {return false;}
	private final boolean _setGdegreeOfDryingHSetting(byte epc, byte[] edt) {
		boolean success = setGdegreeOfDryingHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name :  gDegree of drying h setting<br>EPC : 0xD8<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGdegreeOfDryingHSetting() {return null;}
	private final byte[] _getGdegreeOfDryingHSetting(byte epc) {
		byte[] edt = getGdegreeOfDryingHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Acquires the remaining washing time in .the . gHH:MM h .format.<br><br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F 0xFF<br><br>Name : Remaining washing time<br>EPC : 0xDB<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRemainingWashingTime() {return null;}
	private final byte[] _getRemainingWashingTime(byte epc) {
		byte[] edt = getRemainingWashingTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Acquires the remaining drying time .in .the . gHH:MM h .format.<br><br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F0xFF<br><br>Name : Remaining drying time<br>EPC : 0xDC<br>Data Type : unsign ed<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getRemainingDryingTime() {return null;}
	private final byte[] _getRemainingDryingTime(byte epc) {
		byte[] edt = getRemainingDryingTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Elapsed time on the ON timer<br>EPC : 0xDF<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getElapsedTimeOnTheOnTimer() {return null;}
	private final byte[] _getElapsedTimeOnTheOnTimer(byte epc) {
		byte[] edt = getElapsedTimeOnTheOnTimer();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Presoaking time setting<br>EPC : 0xE1<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setPresoakingTimeSetting(byte[] edt) {return false;}
	private final boolean _setPresoakingTimeSetting(byte epc, byte[] edt) {
		boolean success = setPresoakingTimeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Presoaking time setting<br>EPC : 0xE1<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getPresoakingTimeSetting() {return null;}
	private final byte[] _getPresoakingTimeSetting(byte epc) {
		byte[] edt = getPresoakingTimeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the current stage of the washer and dryer cycle.<br><br>Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44 Washing completed = 0x45 Washing/drying (without wrinkling minimization) completed = 0x51 Drying = 0x52 Wrinkling minimization = 0x53 Drying (with wrinkling minimization) completed = 0x54 Standing by to start = 0x61 1st rinsing = 0x71 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88 Preheat spin drying = 0x91 Unique code defined by the manufature = 0xE0 to 0xEF<br><br>Name : Current stage of washer and dryer cycle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getCurrentStageOfWasherAndDryerCycle() {return null;}
	private final byte[] _getCurrentStageOfWasherAndDryerCycle(byte epc) {
		byte[] edt = getCurrentStageOfWasherAndDryerCycle();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the water volume in liters and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Name : Water volume setting 1<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWaterVolumeSetting1(byte[] edt) {return false;}
	private final boolean _setWaterVolumeSetting1(byte epc, byte[] edt) {
		boolean success = setWaterVolumeSetting1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the water volume in liters and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Name : Water volume setting 1<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWaterVolumeSetting1() {return null;}
	private final byte[] _getWaterVolumeSetting1(byte epc) {
		byte[] edt = getWaterVolumeSetting1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water volume setting 2<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWaterVolumeSetting2(byte[] edt) {return false;}
	private final boolean _setWaterVolumeSetting2(byte epc, byte[] edt) {
		boolean success = setWaterVolumeSetting2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water volume setting 2<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWaterVolumeSetting2() {return null;}
	private final byte[] _getWaterVolumeSetting2(byte epc) {
		byte[] edt = getWaterVolumeSetting2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the duration of the washing process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Washing time setting<br>EPC : 0xE5<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWashingTimeSetting(byte[] edt) {return false;}
	private final boolean _setWashingTimeSetting(byte epc, byte[] edt) {
		boolean success = setWashingTimeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the duration of the washing process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Washing time setting<br>EPC : 0xE5<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWashingTimeSetting() {return null;}
	private final byte[] _getWashingTimeSetting(byte epc) {
		byte[] edt = getWashingTimeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br><br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Name :  gNumber of times of rinsing h setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setGnumberOfTimesOfRinsingHSetting(byte[] edt) {return false;}
	private final boolean _setGnumberOfTimesOfRinsingHSetting(byte epc, byte[] edt) {
		boolean success = setGnumberOfTimesOfRinsingHSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br><br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Name :  gNumber of times of rinsing h setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getGnumberOfTimesOfRinsingHSetting() {return null;}
	private final byte[] _getGnumberOfTimesOfRinsingHSetting(byte epc) {
		byte[] edt = getGnumberOfTimesOfRinsingHSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br><br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Name : Rinsing process setting<br>EPC : 0xE7<br>Data Type : unsigned char  ~4<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRinsingProcessSetting(byte[] edt) {return false;}
	private final boolean _setRinsingProcessSetting(byte epc, byte[] edt) {
		boolean success = setRinsingProcessSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br><br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Name : Rinsing process setting<br>EPC : 0xE7<br>Data Type : unsigned char  ~4<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getRinsingProcessSetting() {return null;}
	private final byte[] _getRinsingProcessSetting(byte epc) {
		byte[] edt = getRinsingProcessSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Name : Spin drying time setting<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSpinDryingTimeSetting(byte[] edt) {return false;}
	private final boolean _setSpinDryingTimeSetting(byte epc, byte[] edt) {
		boolean success = setSpinDryingTimeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Name : Spin drying time setting<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSpinDryingTimeSetting() {return null;}
	private final byte[] _getSpinDryingTimeSetting(byte epc) {
		byte[] edt = getSpinDryingTimeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the duration of the drying process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Drying time setting<br>EPC : 0xE9<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDryingTimeSetting(byte[] edt) {return false;}
	private final boolean _setDryingTimeSetting(byte epc, byte[] edt) {
		boolean success = setDryingTimeSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the duration of the drying process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Drying time setting<br>EPC : 0xE9<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDryingTimeSetting() {return null;}
	private final byte[] _getDryingTimeSetting(byte epc) {
		byte[] edt = getDryingTimeSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br><br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Name : Warm water setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWarmWaterSetting(byte[] edt) {return false;}
	private final boolean _setWarmWaterSetting(byte epc, byte[] edt) {
		boolean success = setWarmWaterSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br><br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Name : Warm water setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWarmWaterSetting() {return null;}
	private final byte[] _getWarmWaterSetting(byte epc) {
		byte[] edt = getWarmWaterSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br><br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Name : Bathtub water recycle setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setBathtubWaterRecycleSetting(byte[] edt) {return false;}
	private final boolean _setBathtubWaterRecycleSetting(byte epc, byte[] edt) {
		boolean success = setBathtubWaterRecycleSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br><br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Name : Bathtub water recycle setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getBathtubWaterRecycleSetting() {return null;}
	private final byte[] _getBathtubWaterRecycleSetting(byte epc) {
		byte[] edt = getBathtubWaterRecycleSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br><br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Name : Wrinkling minimization setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setWrinklingMinimizationSetting(byte[] edt) {return false;}
	private final boolean _setWrinklingMinimizationSetting(byte epc, byte[] edt) {
		boolean success = setWrinklingMinimizationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br><br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Name : Wrinkling minimization setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getWrinklingMinimizationSetting() {return null;}
	private final byte[] _getWrinklingMinimizationSetting(byte epc) {
		byte[] edt = getWrinklingMinimizationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the time remaining to complete the current washer and dryer .cycle .in .the . gHH: .MM h .format.<br><br>0 to 0xFE: 0 to 0x3B (= 0 to 254 hours): (= 0 to 59 minutes) Remaining time unknown = 0xFF: 0xFF<br><br>Name : Time remaining to complete washer and dryer cycle<br>EPC : 0xED<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getTimeRemainingToCompleteWasherAndDryerCycle() {return null;}
	private final byte[] _getTimeRemainingToCompleteWasherAndDryerCycle(byte epc) {
		byte[] edt = getTimeRemainingToCompleteWasherAndDryerCycle();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br><br>Locked: 0x41 Unlocked: 0x42<br><br>Name : Door/cover lock    setting<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setDoorCoverLockSetting(byte[] edt) {return false;}
	private final boolean _setDoorCoverLockSetting(byte epc, byte[] edt) {
		boolean success = setDoorCoverLockSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br><br>Locked: 0x41 Unlocked: 0x42<br><br>Name : Door/cover lock    setting<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getDoorCoverLockSetting() {return null;}
	private final byte[] _getDoorCoverLockSetting(byte epc) {
		byte[] edt = getDoorCoverLockSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to acquire the current washer and dryer cycle setting.<br><br>Bytes 1 and 2: This property indicates the available items in a bitmap format. Byte 3: Presoaking With presoaking: 0x41 Without presoaking: 0x42 Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced. Byte 6: Number of times of rinsing The value of the  g fnumber of times of rinsing f setting h property shall be referenced. Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced. Byte 11: Spin drying time The value of the  gspin drying time setting h property shall be referenced. Bytes 12 and 13: Drying time The value of the  hdrying time setting h property shall be referenced. Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced. Byte 15: Water volume setting 1 The value of the  gwater volume setting 1 h property shall be referenced. Byte 16: Water volume setting 2 The value of the  gwater volume setting 2 h property shall be referenced. Byte 17: Bathtub water recycle setting The value of the  gbathtub water recycle setting h property shall be referenced. Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced. Bytes 19 and 20:  gRotation speed for spin drying h setting The value of the  g frotation speed for spin drying f setting h property shall be referenced. Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting The value of the  gpresoaking time setting h property shall be referenced. Byte 24: Wrinkling minimization setting The value of the  gwrinkling minimization setting h property shall be referenced.<br><br>Name : Washer and dryer cycle<br>EPC : 0xEF<br>Data Type : unsigned Char  ~24<br>Data Size(Byte) : 24 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getWasherAndDryerCycle() {return null;}
	private final byte[] _getWasherAndDryerCycle(byte epc) {
		byte[] edt = getWasherAndDryerCycle();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerReservationSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerReservationSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	private final byte[] _getOnTimerReservationSetting(byte epc) {
		byte[] edt = getOnTimerReservationSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setOnTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getOnTimerSetting() {return null;}
	private final byte[] _getOnTimerSetting(byte epc) {
		byte[] edt = getOnTimerSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setRelativeTimeBasedOnTimerSetting(byte[] edt) {return false;}
	private final boolean _setRelativeTimeBasedOnTimerSetting(byte epc, byte[] edt) {
		boolean success = setRelativeTimeBasedOnTimerSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		case EPC_WASHER_AND_DRYER_SETTING:
			res.addProperty(epc, edt, _setWasherAndDryerSetting(epc, edt));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1:
			res.addProperty(epc, edt, _setWasherAndDryerCycleSetting1Note1(epc, edt));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1:
			res.addProperty(epc, edt, _setWasherAndDryerCycleSetting2Note1(epc, edt));
			break;
		case EPC_DRYING_CYCLE_SETTING_NOTE1:
			res.addProperty(epc, edt, _setDryingCycleSettingNote1(epc, edt));
			break;
		case EPC_WATER_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, _setWaterFlowRateSetting(epc, edt));
			break;
		case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING:
			res.addProperty(epc, edt, _setGrotationSpeedForSpinDryingHSetting(epc, edt));
			break;
		case EPC_GDEGREE_OF_DRYING_H_SETTING:
			res.addProperty(epc, edt, _setGdegreeOfDryingHSetting(epc, edt));
			break;
		case EPC_PRESOAKING_TIME_SETTING:
			res.addProperty(epc, edt, _setPresoakingTimeSetting(epc, edt));
			break;
		case EPC_WATER_VOLUME_SETTING1:
			res.addProperty(epc, edt, _setWaterVolumeSetting1(epc, edt));
			break;
		case EPC_WATER_VOLUME_SETTING2:
			res.addProperty(epc, edt, _setWaterVolumeSetting2(epc, edt));
			break;
		case EPC_WASHING_TIME_SETTING:
			res.addProperty(epc, edt, _setWashingTimeSetting(epc, edt));
			break;
		case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING:
			res.addProperty(epc, edt, _setGnumberOfTimesOfRinsingHSetting(epc, edt));
			break;
		case EPC_RINSING_PROCESS_SETTING:
			res.addProperty(epc, edt, _setRinsingProcessSetting(epc, edt));
			break;
		case EPC_SPIN_DRYING_TIME_SETTING:
			res.addProperty(epc, edt, _setSpinDryingTimeSetting(epc, edt));
			break;
		case EPC_DRYING_TIME_SETTING:
			res.addProperty(epc, edt, _setDryingTimeSetting(epc, edt));
			break;
		case EPC_WARM_WATER_SETTING:
			res.addProperty(epc, edt, _setWarmWaterSetting(epc, edt));
			break;
		case EPC_BATHTUB_WATER_RECYCLE_SETTING:
			res.addProperty(epc, edt, _setBathtubWaterRecycleSetting(epc, edt));
			break;
		case EPC_WRINKLING_MINIMIZATION_SETTING:
			res.addProperty(epc, edt, _setWrinklingMinimizationSetting(epc, edt));
			break;
		case EPC_DOOR_COVER_LOCK_SETTING:
			res.addProperty(epc, edt, _setDoorCoverLockSetting(epc, edt));
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
		case EPC_WASHER_AND_DRYER_SETTING:
			edt = _getWasherAndDryerSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1:
			edt = _getWasherAndDryerCycleSetting1Note1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1:
			edt = _getWasherAndDryerCycleSetting2Note1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DRYING_CYCLE_SETTING_NOTE1:
			edt = _getDryingCycleSettingNote1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1:
			edt = _getWasherAndDryerCycleOptionList1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 12)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2:
			edt = _getWasherAndDryerCycleOptionList2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3:
			edt = _getWasherAndDryerCycleOptionList3(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_WATER_FLOW_RATE_SETTING:
			edt = _getWaterFlowRateSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING:
			edt = _getGrotationSpeedForSpinDryingHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GDEGREE_OF_DRYING_H_SETTING:
			edt = _getGdegreeOfDryingHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REMAINING_WASHING_TIME:
			edt = _getRemainingWashingTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_REMAINING_DRYING_TIME:
			edt = _getRemainingDryingTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ELAPSED_TIME_ON_THE_ON_TIMER:
			edt = _getElapsedTimeOnTheOnTimer(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_PRESOAKING_TIME_SETTING:
			edt = _getPresoakingTimeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE:
			edt = _getCurrentStageOfWasherAndDryerCycle(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_VOLUME_SETTING1:
			edt = _getWaterVolumeSetting1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_VOLUME_SETTING2:
			edt = _getWaterVolumeSetting2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHING_TIME_SETTING:
			edt = _getWashingTimeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING:
			edt = _getGnumberOfTimesOfRinsingHSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RINSING_PROCESS_SETTING:
			edt = _getRinsingProcessSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_SPIN_DRYING_TIME_SETTING:
			edt = _getSpinDryingTimeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DRYING_TIME_SETTING:
			edt = _getDryingTimeSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_WARM_WATER_SETTING:
			edt = _getWarmWaterSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATHTUB_WATER_RECYCLE_SETTING:
			edt = _getBathtubWaterRecycleSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WRINKLING_MINIMIZATION_SETTING:
			edt = _getWrinklingMinimizationSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE:
			edt = _getTimeRemainingToCompleteWasherAndDryerCycle(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_DOOR_COVER_LOCK_SETTING:
			edt = _getDoorCoverLockSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE:
			edt = _getWasherAndDryerCycle(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 24)));
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
			case EPC_WASHER_AND_DRYER_SETTING:
				_onSetWasherAndDryerSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1:
				_onSetWasherAndDryerCycleSetting1Note1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1:
				_onSetWasherAndDryerCycleSetting2Note1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DRYING_CYCLE_SETTING_NOTE1:
				_onSetDryingCycleSettingNote1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WATER_FLOW_RATE_SETTING:
				_onSetWaterFlowRateSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING:
				_onSetGrotationSpeedForSpinDryingHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GDEGREE_OF_DRYING_H_SETTING:
				_onSetGdegreeOfDryingHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_PRESOAKING_TIME_SETTING:
				_onSetPresoakingTimeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WATER_VOLUME_SETTING1:
				_onSetWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WATER_VOLUME_SETTING2:
				_onSetWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WASHING_TIME_SETTING:
				_onSetWashingTimeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING:
				_onSetGnumberOfTimesOfRinsingHSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_RINSING_PROCESS_SETTING:
				_onSetRinsingProcessSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_SPIN_DRYING_TIME_SETTING:
				_onSetSpinDryingTimeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DRYING_TIME_SETTING:
				_onSetDryingTimeSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WARM_WATER_SETTING:
				_onSetWarmWaterSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_BATHTUB_WATER_RECYCLE_SETTING:
				_onSetBathtubWaterRecycleSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_WRINKLING_MINIMIZATION_SETTING:
				_onSetWrinklingMinimizationSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_DOOR_COVER_LOCK_SETTING:
				_onSetDoorCoverLockSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
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
			case EPC_WASHER_AND_DRYER_SETTING:
				_onGetWasherAndDryerSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1:
				_onGetWasherAndDryerCycleSetting1Note1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1:
				_onGetWasherAndDryerCycleSetting2Note1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DRYING_CYCLE_SETTING_NOTE1:
				_onGetDryingCycleSettingNote1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1:
				_onGetWasherAndDryerCycleOptionList1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2:
				_onGetWasherAndDryerCycleOptionList2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3:
				_onGetWasherAndDryerCycleOptionList3(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WATER_FLOW_RATE_SETTING:
				_onGetWaterFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING:
				_onGetGrotationSpeedForSpinDryingHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GDEGREE_OF_DRYING_H_SETTING:
				_onGetGdegreeOfDryingHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REMAINING_WASHING_TIME:
				_onGetRemainingWashingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REMAINING_DRYING_TIME:
				_onGetRemainingDryingTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ELAPSED_TIME_ON_THE_ON_TIMER:
				_onGetElapsedTimeOnTheOnTimer(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_PRESOAKING_TIME_SETTING:
				_onGetPresoakingTimeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE:
				_onGetCurrentStageOfWasherAndDryerCycle(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WATER_VOLUME_SETTING1:
				_onGetWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WATER_VOLUME_SETTING2:
				_onGetWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WASHING_TIME_SETTING:
				_onGetWashingTimeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING:
				_onGetGnumberOfTimesOfRinsingHSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RINSING_PROCESS_SETTING:
				_onGetRinsingProcessSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SPIN_DRYING_TIME_SETTING:
				_onGetSpinDryingTimeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DRYING_TIME_SETTING:
				_onGetDryingTimeSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WARM_WATER_SETTING:
				_onGetWarmWaterSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATHTUB_WATER_RECYCLE_SETTING:
				_onGetBathtubWaterRecycleSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WRINKLING_MINIMIZATION_SETTING:
				_onGetWrinklingMinimizationSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE:
				_onGetTimeRemainingToCompleteWasherAndDryerCycle(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_DOOR_COVER_LOCK_SETTING:
				_onGetDoorCoverLockSetting(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE:
				_onGetWasherAndDryerCycle(eoj, tid, esv, epc, pdc, edt);
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
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br><br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Name : Door/cover open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDoorCoverOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br><br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Name : Washer and dryer setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWasherAndDryerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWasherAndDryerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWasherAndDryerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br><br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Name : Washer and dryer setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWasherAndDryerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWasherAndDryerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWasherAndDryerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Name : Washer and dryer cycle setting 1 (Note 1)<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWasherAndDryerCycleSetting1Note1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Name : Washer and dryer cycle setting 1 (Note 1)<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWasherAndDryerCycleSetting1Note1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br><br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Name : Washer and dryer cycle setting 2 (Note 1)<br>EPC : 0xD1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWasherAndDryerCycleSetting2Note1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br><br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Name : Washer and dryer cycle setting 2 (Note 1)<br>EPC : 0xD1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWasherAndDryerCycleSetting2Note1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br><br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Name : Drying cycle setting (Note1)<br>EPC : 0xD2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDryingCycleSettingNote1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDryingCycleSettingNote1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDryingCycleSettingNote1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br><br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Name : Drying cycle setting (Note1)<br>EPC : 0xD2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDryingCycleSettingNote1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDryingCycleSettingNote1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDryingCycleSettingNote1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br><br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 1<br>EPC : 0xD3<br>Data Type : unsign ed char  ~12,<br>Data Size(Byte) : 12 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetWasherAndDryerCycleOptionList1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWasherAndDryerCycleOptionList1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWasherAndDryerCycleOptionList1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br><br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 2<br>EPC : 0xD4<br>Data Type : unsign ed char  ~4,<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetWasherAndDryerCycleOptionList2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWasherAndDryerCycleOptionList2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWasherAndDryerCycleOptionList2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br><br>When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 3<br>EPC : 0xD5<br>Data Type : unsign ed char  ~4,<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetWasherAndDryerCycleOptionList3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWasherAndDryerCycleOptionList3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWasherAndDryerCycleOptionList3(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water flow rate setting<br>EPC : 0xD6<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWaterFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWaterFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWaterFlowRateSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water flow rate setting<br>EPC : 0xD6<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWaterFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWaterFlowRateSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWaterFlowRateSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Name :  gRotation speed for spin drying h setting<br>EPC : 0xD7<br>Data Type : unsign ed short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGrotationSpeedForSpinDryingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGrotationSpeedForSpinDryingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGrotationSpeedForSpinDryingHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Name :  gRotation speed for spin drying h setting<br>EPC : 0xD7<br>Data Type : unsign ed short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGrotationSpeedForSpinDryingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGrotationSpeedForSpinDryingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGrotationSpeedForSpinDryingHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name :  gDegree of drying h setting<br>EPC : 0xD8<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGdegreeOfDryingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGdegreeOfDryingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGdegreeOfDryingHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name :  gDegree of drying h setting<br>EPC : 0xD8<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGdegreeOfDryingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGdegreeOfDryingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGdegreeOfDryingHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Acquires the remaining washing time in .the . gHH:MM h .format.<br><br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F 0xFF<br><br>Name : Remaining washing time<br>EPC : 0xDB<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRemainingWashingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRemainingWashingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRemainingWashingTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Acquires the remaining drying time .in .the . gHH:MM h .format.<br><br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F0xFF<br><br>Name : Remaining drying time<br>EPC : 0xDC<br>Data Type : unsign ed<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetRemainingDryingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRemainingDryingTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRemainingDryingTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Elapsed time on the ON timer<br>EPC : 0xDF<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetElapsedTimeOnTheOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetElapsedTimeOnTheOnTimer(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetElapsedTimeOnTheOnTimer(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Presoaking time setting<br>EPC : 0xE1<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetPresoakingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetPresoakingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetPresoakingTimeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Presoaking time setting<br>EPC : 0xE1<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetPresoakingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetPresoakingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetPresoakingTimeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the current stage of the washer and dryer cycle.<br><br>Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44 Washing completed = 0x45 Washing/drying (without wrinkling minimization) completed = 0x51 Drying = 0x52 Wrinkling minimization = 0x53 Drying (with wrinkling minimization) completed = 0x54 Standing by to start = 0x61 1st rinsing = 0x71 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88 Preheat spin drying = 0x91 Unique code defined by the manufature = 0xE0 to 0xEF<br><br>Name : Current stage of washer and dryer cycle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetCurrentStageOfWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCurrentStageOfWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCurrentStageOfWasherAndDryerCycle(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Name : Water volume setting 1<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Name : Water volume setting 1<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWaterVolumeSetting1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water volume setting 2<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water volume setting 2<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWaterVolumeSetting2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Washing time setting<br>EPC : 0xE5<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWashingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWashingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWashingTimeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Washing time setting<br>EPC : 0xE5<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWashingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWashingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWashingTimeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br><br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Name :  gNumber of times of rinsing h setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetGnumberOfTimesOfRinsingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGnumberOfTimesOfRinsingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGnumberOfTimesOfRinsingHSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br><br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Name :  gNumber of times of rinsing h setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetGnumberOfTimesOfRinsingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetGnumberOfTimesOfRinsingHSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetGnumberOfTimesOfRinsingHSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br><br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Name : Rinsing process setting<br>EPC : 0xE7<br>Data Type : unsigned char  ~4<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRinsingProcessSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRinsingProcessSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRinsingProcessSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br><br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Name : Rinsing process setting<br>EPC : 0xE7<br>Data Type : unsigned char  ~4<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetRinsingProcessSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRinsingProcessSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRinsingProcessSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Name : Spin drying time setting<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSpinDryingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSpinDryingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSpinDryingTimeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Name : Spin drying time setting<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSpinDryingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSpinDryingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSpinDryingTimeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Drying time setting<br>EPC : 0xE9<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDryingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDryingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDryingTimeSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Drying time setting<br>EPC : 0xE9<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDryingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDryingTimeSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDryingTimeSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br><br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Name : Warm water setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWarmWaterSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWarmWaterSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWarmWaterSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br><br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Name : Warm water setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWarmWaterSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWarmWaterSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWarmWaterSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br><br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Name : Bathtub water recycle setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetBathtubWaterRecycleSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetBathtubWaterRecycleSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetBathtubWaterRecycleSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br><br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Name : Bathtub water recycle setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetBathtubWaterRecycleSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBathtubWaterRecycleSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBathtubWaterRecycleSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br><br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Name : Wrinkling minimization setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetWrinklingMinimizationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetWrinklingMinimizationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetWrinklingMinimizationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br><br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Name : Wrinkling minimization setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetWrinklingMinimizationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWrinklingMinimizationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWrinklingMinimizationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the time remaining to complete the current washer and dryer .cycle .in .the . gHH: .MM h .format.<br><br>0 to 0xFE: 0 to 0x3B (= 0 to 254 hours): (= 0 to 59 minutes) Remaining time unknown = 0xFF: 0xFF<br><br>Name : Time remaining to complete washer and dryer cycle<br>EPC : 0xED<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetTimeRemainingToCompleteWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTimeRemainingToCompleteWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTimeRemainingToCompleteWasherAndDryerCycle(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br><br>Locked: 0x41 Unlocked: 0x42<br><br>Name : Door/cover lock    setting<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetDoorCoverLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetDoorCoverLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetDoorCoverLockSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br><br>Locked: 0x41 Unlocked: 0x42<br><br>Name : Door/cover lock    setting<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetDoorCoverLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetDoorCoverLockSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetDoorCoverLockSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to acquire the current washer and dryer cycle setting.<br><br>Bytes 1 and 2: This property indicates the available items in a bitmap format. Byte 3: Presoaking With presoaking: 0x41 Without presoaking: 0x42 Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced. Byte 6: Number of times of rinsing The value of the  g fnumber of times of rinsing f setting h property shall be referenced. Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced. Byte 11: Spin drying time The value of the  gspin drying time setting h property shall be referenced. Bytes 12 and 13: Drying time The value of the  hdrying time setting h property shall be referenced. Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced. Byte 15: Water volume setting 1 The value of the  gwater volume setting 1 h property shall be referenced. Byte 16: Water volume setting 2 The value of the  gwater volume setting 2 h property shall be referenced. Byte 17: Bathtub water recycle setting The value of the  gbathtub water recycle setting h property shall be referenced. Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced. Bytes 19 and 20:  gRotation speed for spin drying h setting The value of the  g frotation speed for spin drying f setting h property shall be referenced. Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting The value of the  gpresoaking time setting h property shall be referenced. Byte 24: Wrinkling minimization setting The value of the  gwrinkling minimization setting h property shall be referenced.<br><br>Name : Washer and dryer cycle<br>EPC : 0xEF<br>Data Type : unsigned Char  ~24<br>Data Size(Byte) : 24 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetWasherAndDryerCycle(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerReservationSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOnTimerSetting(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br><br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Name : Washer and dryer setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWasherAndDryerSetting(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Name : Washer and dryer cycle setting 1 (Note 1)<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWasherAndDryerCycleSetting1Note1(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br><br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Name : Washer and dryer cycle setting 2 (Note 1)<br>EPC : 0xD1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWasherAndDryerCycleSetting2Note1(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br><br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Name : Drying cycle setting (Note1)<br>EPC : 0xD2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDryingCycleSettingNote1(byte[] edt) {
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water flow rate setting<br>EPC : 0xD6<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWaterFlowRateSetting(byte[] edt) {
			addProperty(EPC_WATER_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Name :  gRotation speed for spin drying h setting<br>EPC : 0xD7<br>Data Type : unsign ed short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGrotationSpeedForSpinDryingHSetting(byte[] edt) {
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name :  gDegree of drying h setting<br>EPC : 0xD8<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGdegreeOfDryingHSetting(byte[] edt) {
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Presoaking time setting<br>EPC : 0xE1<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetPresoakingTimeSetting(byte[] edt) {
			addProperty(EPC_PRESOAKING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Name : Water volume setting 1<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water volume setting 2<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Washing time setting<br>EPC : 0xE5<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWashingTimeSetting(byte[] edt) {
			addProperty(EPC_WASHING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br><br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Name :  gNumber of times of rinsing h setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetGnumberOfTimesOfRinsingHSetting(byte[] edt) {
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br><br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Name : Rinsing process setting<br>EPC : 0xE7<br>Data Type : unsigned char  ~4<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetRinsingProcessSetting(byte[] edt) {
			addProperty(EPC_RINSING_PROCESS_SETTING, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Name : Spin drying time setting<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSpinDryingTimeSetting(byte[] edt) {
			addProperty(EPC_SPIN_DRYING_TIME_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Drying time setting<br>EPC : 0xE9<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDryingTimeSetting(byte[] edt) {
			addProperty(EPC_DRYING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br><br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Name : Warm water setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWarmWaterSetting(byte[] edt) {
			addProperty(EPC_WARM_WATER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br><br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Name : Bathtub water recycle setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetBathtubWaterRecycleSetting(byte[] edt) {
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br><br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Name : Wrinkling minimization setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetWrinklingMinimizationSetting(byte[] edt) {
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br><br>Locked: 0x41 Unlocked: 0x42<br><br>Name : Door/cover lock    setting<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetDoorCoverLockSetting(byte[] edt) {
			addProperty(EPC_DOOR_COVER_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetOnTimerSetting(byte[] edt) {
			addProperty(EPC_ON_TIMER_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br><br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Name : Door/cover open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetDoorCoverOpenCloseStatus() {
			addProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br><br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Name : Washer and dryer setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWasherAndDryerSetting() {
			addProperty(EPC_WASHER_AND_DRYER_SETTING);
			return this;
		}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Name : Washer and dryer cycle setting 1 (Note 1)<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleSetting1Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1);
			return this;
		}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br><br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Name : Washer and dryer cycle setting 2 (Note 1)<br>EPC : 0xD1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleSetting2Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1);
			return this;
		}
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br><br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Name : Drying cycle setting (Note1)<br>EPC : 0xD2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDryingCycleSettingNote1() {
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1);
			return this;
		}
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br><br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 1<br>EPC : 0xD3<br>Data Type : unsign ed char  ~12,<br>Data Size(Byte) : 12 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleOptionList1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1);
			return this;
		}
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br><br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 2<br>EPC : 0xD4<br>Data Type : unsign ed char  ~4,<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleOptionList2() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2);
			return this;
		}
		/**
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br><br>When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 3<br>EPC : 0xD5<br>Data Type : unsign ed char  ~4,<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleOptionList3() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3);
			return this;
		}
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water flow rate setting<br>EPC : 0xD6<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWaterFlowRateSetting() {
			addProperty(EPC_WATER_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Name :  gRotation speed for spin drying h setting<br>EPC : 0xD7<br>Data Type : unsign ed short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGrotationSpeedForSpinDryingHSetting() {
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING);
			return this;
		}
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name :  gDegree of drying h setting<br>EPC : 0xD8<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGdegreeOfDryingHSetting() {
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING);
			return this;
		}
		/**
		 * Acquires the remaining washing time in .the . gHH:MM h .format.<br><br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F 0xFF<br><br>Name : Remaining washing time<br>EPC : 0xDB<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRemainingWashingTime() {
			addProperty(EPC_REMAINING_WASHING_TIME);
			return this;
		}
		/**
		 * Acquires the remaining drying time .in .the . gHH:MM h .format.<br><br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F0xFF<br><br>Name : Remaining drying time<br>EPC : 0xDC<br>Data Type : unsign ed<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetRemainingDryingTime() {
			addProperty(EPC_REMAINING_DRYING_TIME);
			return this;
		}
		/**
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Elapsed time on the ON timer<br>EPC : 0xDF<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetElapsedTimeOnTheOnTimer() {
			addProperty(EPC_ELAPSED_TIME_ON_THE_ON_TIMER);
			return this;
		}
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Presoaking time setting<br>EPC : 0xE1<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetPresoakingTimeSetting() {
			addProperty(EPC_PRESOAKING_TIME_SETTING);
			return this;
		}
		/**
		 * Used to acquire the current stage of the washer and dryer cycle.<br><br>Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44 Washing completed = 0x45 Washing/drying (without wrinkling minimization) completed = 0x51 Drying = 0x52 Wrinkling minimization = 0x53 Drying (with wrinkling minimization) completed = 0x54 Standing by to start = 0x61 1st rinsing = 0x71 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88 Preheat spin drying = 0x91 Unique code defined by the manufature = 0xE0 to 0xEF<br><br>Name : Current stage of washer and dryer cycle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetCurrentStageOfWasherAndDryerCycle() {
			addProperty(EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Name : Water volume setting 1<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWaterVolumeSetting1() {
			addProperty(EPC_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water volume setting 2<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWaterVolumeSetting2() {
			addProperty(EPC_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Washing time setting<br>EPC : 0xE5<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWashingTimeSetting() {
			addProperty(EPC_WASHING_TIME_SETTING);
			return this;
		}
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br><br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Name :  gNumber of times of rinsing h setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetGnumberOfTimesOfRinsingHSetting() {
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING);
			return this;
		}
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br><br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Name : Rinsing process setting<br>EPC : 0xE7<br>Data Type : unsigned char  ~4<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetRinsingProcessSetting() {
			addProperty(EPC_RINSING_PROCESS_SETTING);
			return this;
		}
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Name : Spin drying time setting<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSpinDryingTimeSetting() {
			addProperty(EPC_SPIN_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Drying time setting<br>EPC : 0xE9<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDryingTimeSetting() {
			addProperty(EPC_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br><br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Name : Warm water setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWarmWaterSetting() {
			addProperty(EPC_WARM_WATER_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br><br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Name : Bathtub water recycle setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetBathtubWaterRecycleSetting() {
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING);
			return this;
		}
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br><br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Name : Wrinkling minimization setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetWrinklingMinimizationSetting() {
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING);
			return this;
		}
		/**
		 * Used to acquire the time remaining to complete the current washer and dryer .cycle .in .the . gHH: .MM h .format.<br><br>0 to 0xFE: 0 to 0x3B (= 0 to 254 hours): (= 0 to 59 minutes) Remaining time unknown = 0xFF: 0xFF<br><br>Name : Time remaining to complete washer and dryer cycle<br>EPC : 0xED<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetTimeRemainingToCompleteWasherAndDryerCycle() {
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br><br>Locked: 0x41 Unlocked: 0x42<br><br>Name : Door/cover lock    setting<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetDoorCoverLockSetting() {
			addProperty(EPC_DOOR_COVER_LOCK_SETTING);
			return this;
		}
		/**
		 * Used to acquire the current washer and dryer cycle setting.<br><br>Bytes 1 and 2: This property indicates the available items in a bitmap format. Byte 3: Presoaking With presoaking: 0x41 Without presoaking: 0x42 Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced. Byte 6: Number of times of rinsing The value of the  g fnumber of times of rinsing f setting h property shall be referenced. Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced. Byte 11: Spin drying time The value of the  gspin drying time setting h property shall be referenced. Bytes 12 and 13: Drying time The value of the  hdrying time setting h property shall be referenced. Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced. Byte 15: Water volume setting 1 The value of the  gwater volume setting 1 h property shall be referenced. Byte 16: Water volume setting 2 The value of the  gwater volume setting 2 h property shall be referenced. Byte 17: Bathtub water recycle setting The value of the  gbathtub water recycle setting h property shall be referenced. Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced. Bytes 19 and 20:  gRotation speed for spin drying h setting The value of the  g frotation speed for spin drying f setting h property shall be referenced. Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting The value of the  gpresoaking time setting h property shall be referenced. Byte 24: Wrinkling minimization setting The value of the  gwrinkling minimization setting h property shall be referenced.<br><br>Name : Washer and dryer cycle<br>EPC : 0xEF<br>Data Type : unsigned Char  ~24<br>Data Size(Byte) : 24 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetWasherAndDryerCycle() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			addProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetOnTimerSetting() {
			addProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br><br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Name : Door/cover open/close status<br>EPC : 0xB0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformDoorCoverOpenCloseStatus();
		/**
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br><br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Name : Washer and dryer setting<br>EPC : 0xB2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWasherAndDryerSetting();
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Name : Washer and dryer cycle setting 1 (Note 1)<br>EPC : 0xD0<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleSetting1Note1();
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br><br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Name : Washer and dryer cycle setting 2 (Note 1)<br>EPC : 0xD1<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleSetting2Note1();
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br><br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Name : Drying cycle setting (Note1)<br>EPC : 0xD2<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDryingCycleSettingNote1();
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br><br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 1<br>EPC : 0xD3<br>Data Type : unsign ed char  ~12,<br>Data Size(Byte) : 12 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleOptionList1();
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br><br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 2<br>EPC : 0xD4<br>Data Type : unsign ed char  ~4,<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleOptionList2();
		/**
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br><br>When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Name : Washer and dryer cycle option list 3<br>EPC : 0xD5<br>Data Type : unsign ed char  ~4,<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleOptionList3();
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water flow rate setting<br>EPC : 0xD6<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWaterFlowRateSetting();
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Name :  gRotation speed for spin drying h setting<br>EPC : 0xD7<br>Data Type : unsign ed short<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGrotationSpeedForSpinDryingHSetting();
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name :  gDegree of drying h setting<br>EPC : 0xD8<br>Data Type : unsign ed char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGdegreeOfDryingHSetting();
		/**
		 * Acquires the remaining washing time in .the . gHH:MM h .format.<br><br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F 0xFF<br><br>Name : Remaining washing time<br>EPC : 0xDB<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRemainingWashingTime();
		/**
		 * Acquires the remaining drying time .in .the . gHH:MM h .format.<br><br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F0xFF<br><br>Name : Remaining drying time<br>EPC : 0xDC<br>Data Type : unsign ed<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformRemainingDryingTime();
		/**
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Elapsed time on the ON timer<br>EPC : 0xDF<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformElapsedTimeOnTheOnTimer();
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Presoaking time setting<br>EPC : 0xE1<br>Data Type : unsigne d char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformPresoakingTimeSetting();
		/**
		 * Used to acquire the current stage of the washer and dryer cycle.<br><br>Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44 Washing completed = 0x45 Washing/drying (without wrinkling minimization) completed = 0x51 Drying = 0x52 Wrinkling minimization = 0x53 Drying (with wrinkling minimization) completed = 0x54 Standing by to start = 0x61 1st rinsing = 0x71 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88 Preheat spin drying = 0x91 Unique code defined by the manufature = 0xE0 to 0xEF<br><br>Name : Current stage of washer and dryer cycle<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformCurrentStageOfWasherAndDryerCycle();
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Name : Water volume setting 1<br>EPC : 0xE3<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWaterVolumeSetting1();
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Name : Water volume setting 2<br>EPC : 0xE4<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWaterVolumeSetting2();
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Washing time setting<br>EPC : 0xE5<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWashingTimeSetting();
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br><br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Name :  gNumber of times of rinsing h setting<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformGnumberOfTimesOfRinsingHSetting();
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br><br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Name : Rinsing process setting<br>EPC : 0xE7<br>Data Type : unsigned char  ~4<br>Data Size(Byte) : 4 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformRinsingProcessSetting();
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Name : Spin drying time setting<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSpinDryingTimeSetting();
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Name : Drying time setting<br>EPC : 0xE9<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDryingTimeSetting();
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br><br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Name : Warm water setting<br>EPC : 0xEA<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWarmWaterSetting();
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br><br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Name : Bathtub water recycle setting<br>EPC : 0xEB<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformBathtubWaterRecycleSetting();
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br><br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Name : Wrinkling minimization setting<br>EPC : 0xEC<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformWrinklingMinimizationSetting();
		/**
		 * Used to acquire the time remaining to complete the current washer and dryer .cycle .in .the . gHH: .MM h .format.<br><br>0 to 0xFE: 0 to 0x3B (= 0 to 254 hours): (= 0 to 59 minutes) Remaining time unknown = 0xFF: 0xFF<br><br>Name : Time remaining to complete washer and dryer cycle<br>EPC : 0xED<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformTimeRemainingToCompleteWasherAndDryerCycle();
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br><br>Locked: 0x41 Unlocked: 0x42<br><br>Name : Door/cover lock    setting<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformDoorCoverLockSetting();
		/**
		 * Used to acquire the current washer and dryer cycle setting.<br><br>Bytes 1 and 2: This property indicates the available items in a bitmap format. Byte 3: Presoaking With presoaking: 0x41 Without presoaking: 0x42 Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced. Byte 6: Number of times of rinsing The value of the  g fnumber of times of rinsing f setting h property shall be referenced. Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced. Byte 11: Spin drying time The value of the  gspin drying time setting h property shall be referenced. Bytes 12 and 13: Drying time The value of the  hdrying time setting h property shall be referenced. Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced. Byte 15: Water volume setting 1 The value of the  gwater volume setting 1 h property shall be referenced. Byte 16: Water volume setting 2 The value of the  gwater volume setting 2 h property shall be referenced. Byte 17: Bathtub water recycle setting The value of the  gbathtub water recycle setting h property shall be referenced. Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced. Bytes 19 and 20:  gRotation speed for spin drying h setting The value of the  g frotation speed for spin drying f setting h property shall be referenced. Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting The value of the  gpresoaking time setting h property shall be referenced. Byte 24: Wrinkling minimization setting The value of the  gwrinkling minimization setting h property shall be referenced.<br><br>Name : Washer and dryer cycle<br>EPC : 0xEF<br>Data Type : unsigned Char  ~24<br>Data Size(Byte) : 24 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformWasherAndDryerCycle();
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br><br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Name : ON timer reservation setting<br>EPC : 0x90<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br><br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Name : ON timer setting<br>EPC : 0x91<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br><br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Name : Relative time-based ON timer setting<br>EPC : 0x92<br>Data Type : unsigned char  ~2<br>Data Size(Byte) : 2 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
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
		public Informer reqInformWasherAndDryerSetting() {
			byte epc = EPC_WASHER_AND_DRYER_SETTING;
			byte[] edt = _getWasherAndDryerSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleSetting1Note1() {
			byte epc = EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1;
			byte[] edt = _getWasherAndDryerCycleSetting1Note1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleSetting2Note1() {
			byte epc = EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1;
			byte[] edt = _getWasherAndDryerCycleSetting2Note1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDryingCycleSettingNote1() {
			byte epc = EPC_DRYING_CYCLE_SETTING_NOTE1;
			byte[] edt = _getDryingCycleSettingNote1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleOptionList1() {
			byte epc = EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1;
			byte[] edt = _getWasherAndDryerCycleOptionList1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 12)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleOptionList2() {
			byte epc = EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2;
			byte[] edt = _getWasherAndDryerCycleOptionList2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleOptionList3() {
			byte epc = EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3;
			byte[] edt = _getWasherAndDryerCycleOptionList3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformWaterFlowRateSetting() {
			byte epc = EPC_WATER_FLOW_RATE_SETTING;
			byte[] edt = _getWaterFlowRateSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGrotationSpeedForSpinDryingHSetting() {
			byte epc = EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING;
			byte[] edt = _getGrotationSpeedForSpinDryingHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGdegreeOfDryingHSetting() {
			byte epc = EPC_GDEGREE_OF_DRYING_H_SETTING;
			byte[] edt = _getGdegreeOfDryingHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRemainingWashingTime() {
			byte epc = EPC_REMAINING_WASHING_TIME;
			byte[] edt = _getRemainingWashingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRemainingDryingTime() {
			byte epc = EPC_REMAINING_DRYING_TIME;
			byte[] edt = _getRemainingDryingTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformElapsedTimeOnTheOnTimer() {
			byte epc = EPC_ELAPSED_TIME_ON_THE_ON_TIMER;
			byte[] edt = _getElapsedTimeOnTheOnTimer(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformPresoakingTimeSetting() {
			byte epc = EPC_PRESOAKING_TIME_SETTING;
			byte[] edt = _getPresoakingTimeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformCurrentStageOfWasherAndDryerCycle() {
			byte epc = EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE;
			byte[] edt = _getCurrentStageOfWasherAndDryerCycle(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterVolumeSetting1() {
			byte epc = EPC_WATER_VOLUME_SETTING1;
			byte[] edt = _getWaterVolumeSetting1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterVolumeSetting2() {
			byte epc = EPC_WATER_VOLUME_SETTING2;
			byte[] edt = _getWaterVolumeSetting2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWashingTimeSetting() {
			byte epc = EPC_WASHING_TIME_SETTING;
			byte[] edt = _getWashingTimeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGnumberOfTimesOfRinsingHSetting() {
			byte epc = EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING;
			byte[] edt = _getGnumberOfTimesOfRinsingHSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRinsingProcessSetting() {
			byte epc = EPC_RINSING_PROCESS_SETTING;
			byte[] edt = _getRinsingProcessSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformSpinDryingTimeSetting() {
			byte epc = EPC_SPIN_DRYING_TIME_SETTING;
			byte[] edt = _getSpinDryingTimeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDryingTimeSetting() {
			byte epc = EPC_DRYING_TIME_SETTING;
			byte[] edt = _getDryingTimeSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformWarmWaterSetting() {
			byte epc = EPC_WARM_WATER_SETTING;
			byte[] edt = _getWarmWaterSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathtubWaterRecycleSetting() {
			byte epc = EPC_BATHTUB_WATER_RECYCLE_SETTING;
			byte[] edt = _getBathtubWaterRecycleSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWrinklingMinimizationSetting() {
			byte epc = EPC_WRINKLING_MINIMIZATION_SETTING;
			byte[] edt = _getWrinklingMinimizationSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTimeRemainingToCompleteWasherAndDryerCycle() {
			byte epc = EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE;
			byte[] edt = _getTimeRemainingToCompleteWasherAndDryerCycle(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformDoorCoverLockSetting() {
			byte epc = EPC_DOOR_COVER_LOCK_SETTING;
			byte[] edt = _getDoorCoverLockSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycle() {
			byte epc = EPC_WASHER_AND_DRYER_CYCLE;
			byte[] edt = _getWasherAndDryerCycle(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 24)));
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
		public Informer reqInformWasherAndDryerSetting() {
			addProperty(EPC_WASHER_AND_DRYER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleSetting1Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1);
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleSetting2Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1);
			return this;
		}
		@Override
		public Informer reqInformDryingCycleSettingNote1() {
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1);
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleOptionList1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1);
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleOptionList2() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2);
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleOptionList3() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3);
			return this;
		}
		@Override
		public Informer reqInformWaterFlowRateSetting() {
			addProperty(EPC_WATER_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGrotationSpeedForSpinDryingHSetting() {
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGdegreeOfDryingHSetting() {
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRemainingWashingTime() {
			addProperty(EPC_REMAINING_WASHING_TIME);
			return this;
		}
		@Override
		public Informer reqInformRemainingDryingTime() {
			addProperty(EPC_REMAINING_DRYING_TIME);
			return this;
		}
		@Override
		public Informer reqInformElapsedTimeOnTheOnTimer() {
			addProperty(EPC_ELAPSED_TIME_ON_THE_ON_TIMER);
			return this;
		}
		@Override
		public Informer reqInformPresoakingTimeSetting() {
			addProperty(EPC_PRESOAKING_TIME_SETTING);
			return this;
		}
		@Override
		public Informer reqInformCurrentStageOfWasherAndDryerCycle() {
			addProperty(EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		@Override
		public Informer reqInformWaterVolumeSetting1() {
			addProperty(EPC_WATER_VOLUME_SETTING1);
			return this;
		}
		@Override
		public Informer reqInformWaterVolumeSetting2() {
			addProperty(EPC_WATER_VOLUME_SETTING2);
			return this;
		}
		@Override
		public Informer reqInformWashingTimeSetting() {
			addProperty(EPC_WASHING_TIME_SETTING);
			return this;
		}
		@Override
		public Informer reqInformGnumberOfTimesOfRinsingHSetting() {
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING);
			return this;
		}
		@Override
		public Informer reqInformRinsingProcessSetting() {
			addProperty(EPC_RINSING_PROCESS_SETTING);
			return this;
		}
		@Override
		public Informer reqInformSpinDryingTimeSetting() {
			addProperty(EPC_SPIN_DRYING_TIME_SETTING);
			return this;
		}
		@Override
		public Informer reqInformDryingTimeSetting() {
			addProperty(EPC_DRYING_TIME_SETTING);
			return this;
		}
		@Override
		public Informer reqInformWarmWaterSetting() {
			addProperty(EPC_WARM_WATER_SETTING);
			return this;
		}
		@Override
		public Informer reqInformBathtubWaterRecycleSetting() {
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING);
			return this;
		}
		@Override
		public Informer reqInformWrinklingMinimizationSetting() {
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING);
			return this;
		}
		@Override
		public Informer reqInformTimeRemainingToCompleteWasherAndDryerCycle() {
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		@Override
		public Informer reqInformDoorCoverLockSetting() {
			addProperty(EPC_DOOR_COVER_LOCK_SETTING);
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycle() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE);
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
