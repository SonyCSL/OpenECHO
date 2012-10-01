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
	@SuppressWarnings("unused")
	private static final String TAG = WasherAndDryer.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x03;
	public static final byte CLASS_CODE = (byte)0xD3;

	protected static final byte EPC_DOOR_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	protected static final byte EPC_WASHER_AND_DRYER_SETTING = (byte)0xB2;
	protected static final byte EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 = (byte)0xD0;
	protected static final byte EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 = (byte)0xD1;
	protected static final byte EPC_DRYING_CYCLE_SETTING_NOTE1 = (byte)0xD2;
	protected static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 = (byte)0xD3;
	protected static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 = (byte)0xD4;
	protected static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 = (byte)0xD5;
	protected static final byte EPC_WATER_FLOW_RATE_SETTING = (byte)0xD6;
	protected static final byte EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING = (byte)0xD7;
	protected static final byte EPC_GDEGREE_OF_DRYING_H_SETTING = (byte)0xD8;
	protected static final byte EPC_REMAINING_WASHING_TIME = (byte)0xDB;
	protected static final byte EPC_REMAINING_DRYING_TIME = (byte)0xDC;
	protected static final byte EPC_ELAPSED_TIME_ON_THE_ON_TIMER = (byte)0xDF;
	protected static final byte EPC_PRESOAKING_TIME_SETTING = (byte)0xE1;
	protected static final byte EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE = (byte)0xE2;
	protected static final byte EPC_WATER_VOLUME_SETTING1 = (byte)0xE3;
	protected static final byte EPC_WATER_VOLUME_SETTING2 = (byte)0xE4;
	protected static final byte EPC_WASHING_TIME_SETTING = (byte)0xE5;
	protected static final byte EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING = (byte)0xE6;
	protected static final byte EPC_RINSING_PROCESS_SETTING = (byte)0xE7;
	protected static final byte EPC_SPIN_DRYING_TIME_SETTING = (byte)0xE8;
	protected static final byte EPC_DRYING_TIME_SETTING = (byte)0xE9;
	protected static final byte EPC_WARM_WATER_SETTING = (byte)0xEA;
	protected static final byte EPC_BATHTUB_WATER_RECYCLE_SETTING = (byte)0xEB;
	protected static final byte EPC_WRINKLING_MINIMIZATION_SETTING = (byte)0xEC;
	protected static final byte EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE = (byte)0xED;
	protected static final byte EPC_DOOR_COVER_LOCK_SETTING = (byte)0xEE;
	protected static final byte EPC_WASHER_AND_DRYER_CYCLE = (byte)0xEF;
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
	 * Used to acquire the status of the door/cover (i.e. open or closed).<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getDoorCoverOpenCloseStatus() {return null;}
	/**
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWasherAndDryerSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWasherAndDryerSetting() {return null;}
	/**
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWasherAndDryerCycleSetting1Note1(byte[] edt) {return false;}
	/**
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWasherAndDryerCycleSetting1Note1() {return null;}
	/**
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWasherAndDryerCycleSetting2Note1(byte[] edt) {return false;}
	/**
	 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWasherAndDryerCycleSetting2Note1() {return null;}
	/**
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDryingCycleSettingNote1(byte[] edt) {return false;}
	/**
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDryingCycleSettingNote1() {return null;}
	/**
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~12,<br>Data size : 12 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getWasherAndDryerCycleOptionList1() {return null;}
	/**
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~4,<br>Data size : 4 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getWasherAndDryerCycleOptionList2() {return null;}
	/**
	 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br>When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~4,<br>Data size : 4 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getWasherAndDryerCycleOptionList3() {return null;}
	/**
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWaterFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWaterFlowRateSetting() {return null;}
	/**
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Data type : unsign ed short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGrotationSpeedForSpinDryingHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Data type : unsign ed short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGrotationSpeedForSpinDryingHSetting() {return null;}
	/**
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGdegreeOfDryingHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGdegreeOfDryingHSetting() {return null;}
	/**
	 * Acquires the remaining washing time in .the . gHH:MM h .format.<br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F 0xFF<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRemainingWashingTime() {return null;}
	/**
	 * Acquires the remaining drying time .in .the . gHH:MM h .format.<br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F0xFF<br><br>Data type : unsign ed<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRemainingDryingTime() {return null;}
	/**
	 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getElapsedTimeOnTheOnTimer() {return null;}
	/**
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setPresoakingTimeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getPresoakingTimeSetting() {return null;}
	/**
	 * Used to acquire the current stage of the washer and dryer cycle.<br>Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44 Washing completed = 0x45 Washing/drying (without wrinkling minimization) completed = 0x51 Drying = 0x52 Wrinkling minimization = 0x53 Drying (with wrinkling minimization) completed = 0x54 Standing by to start = 0x61 1st rinsing = 0x71 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88 Preheat spin drying = 0x91 Unique code defined by the manufature = 0xE0 to 0xEF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getCurrentStageOfWasherAndDryerCycle() {return null;}
	/**
	 * Used to specify the water volume in liters and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWaterVolumeSetting1(byte[] edt) {return false;}
	/**
	 * Used to specify the water volume in liters and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWaterVolumeSetting1() {return null;}
	/**
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWaterVolumeSetting2(byte[] edt) {return false;}
	/**
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWaterVolumeSetting2() {return null;}
	/**
	 * Used to specify the duration of the washing process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWashingTimeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the duration of the washing process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWashingTimeSetting() {return null;}
	/**
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setGnumberOfTimesOfRinsingHSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getGnumberOfTimesOfRinsingHSetting() {return null;}
	/**
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Data type : unsigned char  ~4<br>Data size : 4 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRinsingProcessSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Data type : unsigned char  ~4<br>Data size : 4 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRinsingProcessSetting() {return null;}
	/**
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setSpinDryingTimeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getSpinDryingTimeSetting() {return null;}
	/**
	 * Used to specify the duration of the drying process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDryingTimeSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the duration of the drying process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDryingTimeSetting() {return null;}
	/**
	 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWarmWaterSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWarmWaterSetting() {return null;}
	/**
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setBathtubWaterRecycleSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getBathtubWaterRecycleSetting() {return null;}
	/**
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setWrinklingMinimizationSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getWrinklingMinimizationSetting() {return null;}
	/**
	 * Used to acquire the time remaining to complete the current washer and dryer .cycle .in .the . gHH: .MM h .format.<br>0 to 0xFE: 0 to 0x3B (= 0 to 254 hours): (= 0 to 59 minutes) Remaining time unknown = 0xFF: 0xFF<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getTimeRemainingToCompleteWasherAndDryerCycle() {return null;}
	/**
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>Locked: 0x41 Unlocked: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setDoorCoverLockSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>Locked: 0x41 Unlocked: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getDoorCoverLockSetting() {return null;}
	/**
	 * Used to acquire the current washer and dryer cycle setting.<br>Bytes 1 and 2: This property indicates the available items in a bitmap format. Byte 3: Presoaking With presoaking: 0x41 Without presoaking: 0x42 Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced. Byte 6: Number of times of rinsing The value of the  g fnumber of times of rinsing f setting h property shall be referenced. Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced. Byte 11: Spin drying time The value of the  gspin drying time setting h property shall be referenced. Bytes 12 and 13: Drying time The value of the  hdrying time setting h property shall be referenced. Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced. Byte 15: Water volume setting 1 The value of the  gwater volume setting 1 h property shall be referenced. Byte 16: Water volume setting 2 The value of the  gwater volume setting 2 h property shall be referenced. Byte 17: Bathtub water recycle setting The value of the  gbathtub water recycle setting h property shall be referenced. Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced. Bytes 19 and 20:  gRotation speed for spin drying h setting The value of the  g frotation speed for spin drying f setting h property shall be referenced. Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting The value of the  gpresoaking time setting h property shall be referenced. Byte 24: Wrinkling minimization setting The value of the  gwrinkling minimization setting h property shall be referenced.<br><br>Data type : unsigned Char  ~24<br>Data size : 24 byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getWasherAndDryerCycle() {return null;}
	/**
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setRelativeTimeBasedOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getRelativeTimeBasedOnTimerSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_WASHER_AND_DRYER_SETTING:
			res.addProperty(epc, edt, setWasherAndDryerSetting(edt));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1:
			res.addProperty(epc, edt, setWasherAndDryerCycleSetting1Note1(edt));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1:
			res.addProperty(epc, edt, setWasherAndDryerCycleSetting2Note1(edt));
			break;
		case EPC_DRYING_CYCLE_SETTING_NOTE1:
			res.addProperty(epc, edt, setDryingCycleSettingNote1(edt));
			break;
		case EPC_WATER_FLOW_RATE_SETTING:
			res.addProperty(epc, edt, setWaterFlowRateSetting(edt));
			break;
		case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING:
			res.addProperty(epc, edt, setGrotationSpeedForSpinDryingHSetting(edt));
			break;
		case EPC_GDEGREE_OF_DRYING_H_SETTING:
			res.addProperty(epc, edt, setGdegreeOfDryingHSetting(edt));
			break;
		case EPC_PRESOAKING_TIME_SETTING:
			res.addProperty(epc, edt, setPresoakingTimeSetting(edt));
			break;
		case EPC_WATER_VOLUME_SETTING1:
			res.addProperty(epc, edt, setWaterVolumeSetting1(edt));
			break;
		case EPC_WATER_VOLUME_SETTING2:
			res.addProperty(epc, edt, setWaterVolumeSetting2(edt));
			break;
		case EPC_WASHING_TIME_SETTING:
			res.addProperty(epc, edt, setWashingTimeSetting(edt));
			break;
		case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING:
			res.addProperty(epc, edt, setGnumberOfTimesOfRinsingHSetting(edt));
			break;
		case EPC_RINSING_PROCESS_SETTING:
			res.addProperty(epc, edt, setRinsingProcessSetting(edt));
			break;
		case EPC_SPIN_DRYING_TIME_SETTING:
			res.addProperty(epc, edt, setSpinDryingTimeSetting(edt));
			break;
		case EPC_DRYING_TIME_SETTING:
			res.addProperty(epc, edt, setDryingTimeSetting(edt));
			break;
		case EPC_WARM_WATER_SETTING:
			res.addProperty(epc, edt, setWarmWaterSetting(edt));
			break;
		case EPC_BATHTUB_WATER_RECYCLE_SETTING:
			res.addProperty(epc, edt, setBathtubWaterRecycleSetting(edt));
			break;
		case EPC_WRINKLING_MINIMIZATION_SETTING:
			res.addProperty(epc, edt, setWrinklingMinimizationSetting(edt));
			break;
		case EPC_DOOR_COVER_LOCK_SETTING:
			res.addProperty(epc, edt, setDoorCoverLockSetting(edt));
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
		case EPC_WASHER_AND_DRYER_SETTING:
			edt = getWasherAndDryerSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1:
			edt = getWasherAndDryerCycleSetting1Note1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1:
			edt = getWasherAndDryerCycleSetting2Note1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DRYING_CYCLE_SETTING_NOTE1:
			edt = getDryingCycleSettingNote1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1:
			edt = getWasherAndDryerCycleOptionList1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 12)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2:
			edt = getWasherAndDryerCycleOptionList2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3:
			edt = getWasherAndDryerCycleOptionList3();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_WATER_FLOW_RATE_SETTING:
			edt = getWaterFlowRateSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING:
			edt = getGrotationSpeedForSpinDryingHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GDEGREE_OF_DRYING_H_SETTING:
			edt = getGdegreeOfDryingHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_REMAINING_WASHING_TIME:
			edt = getRemainingWashingTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_REMAINING_DRYING_TIME:
			edt = getRemainingDryingTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_ELAPSED_TIME_ON_THE_ON_TIMER:
			edt = getElapsedTimeOnTheOnTimer();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_PRESOAKING_TIME_SETTING:
			edt = getPresoakingTimeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE:
			edt = getCurrentStageOfWasherAndDryerCycle();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_VOLUME_SETTING1:
			edt = getWaterVolumeSetting1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WATER_VOLUME_SETTING2:
			edt = getWaterVolumeSetting2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHING_TIME_SETTING:
			edt = getWashingTimeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING:
			edt = getGnumberOfTimesOfRinsingHSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RINSING_PROCESS_SETTING:
			edt = getRinsingProcessSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_SPIN_DRYING_TIME_SETTING:
			edt = getSpinDryingTimeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_DRYING_TIME_SETTING:
			edt = getDryingTimeSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_WARM_WATER_SETTING:
			edt = getWarmWaterSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATHTUB_WATER_RECYCLE_SETTING:
			edt = getBathtubWaterRecycleSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WRINKLING_MINIMIZATION_SETTING:
			edt = getWrinklingMinimizationSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE:
			edt = getTimeRemainingToCompleteWasherAndDryerCycle();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_DOOR_COVER_LOCK_SETTING:
			edt = getDoorCoverLockSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_WASHER_AND_DRYER_CYCLE:
			edt = getWasherAndDryerCycle();
			res.addProperty(epc, edt, (edt != null && (edt.length == 24)));
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
			case EPC_WASHER_AND_DRYER_SETTING:
				onSetWasherAndDryerSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1:
				onSetWasherAndDryerCycleSetting1Note1(eoj, tid, (pdc != 0));
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1:
				onSetWasherAndDryerCycleSetting2Note1(eoj, tid, (pdc != 0));
				break;
			case EPC_DRYING_CYCLE_SETTING_NOTE1:
				onSetDryingCycleSettingNote1(eoj, tid, (pdc != 0));
				break;
			case EPC_WATER_FLOW_RATE_SETTING:
				onSetWaterFlowRateSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING:
				onSetGrotationSpeedForSpinDryingHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GDEGREE_OF_DRYING_H_SETTING:
				onSetGdegreeOfDryingHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_PRESOAKING_TIME_SETTING:
				onSetPresoakingTimeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_WATER_VOLUME_SETTING1:
				onSetWaterVolumeSetting1(eoj, tid, (pdc != 0));
				break;
			case EPC_WATER_VOLUME_SETTING2:
				onSetWaterVolumeSetting2(eoj, tid, (pdc != 0));
				break;
			case EPC_WASHING_TIME_SETTING:
				onSetWashingTimeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING:
				onSetGnumberOfTimesOfRinsingHSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_RINSING_PROCESS_SETTING:
				onSetRinsingProcessSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_SPIN_DRYING_TIME_SETTING:
				onSetSpinDryingTimeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_DRYING_TIME_SETTING:
				onSetDryingTimeSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_WARM_WATER_SETTING:
				onSetWarmWaterSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_BATHTUB_WATER_RECYCLE_SETTING:
				onSetBathtubWaterRecycleSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_WRINKLING_MINIMIZATION_SETTING:
				onSetWrinklingMinimizationSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_DOOR_COVER_LOCK_SETTING:
				onSetDoorCoverLockSetting(eoj, tid, (pdc != 0));
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
			case EPC_WASHER_AND_DRYER_SETTING:
				onGetWasherAndDryerSetting(eoj, tid, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1:
				onGetWasherAndDryerCycleSetting1Note1(eoj, tid, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1:
				onGetWasherAndDryerCycleSetting2Note1(eoj, tid, pdc, edt);
				break;
			case EPC_DRYING_CYCLE_SETTING_NOTE1:
				onGetDryingCycleSettingNote1(eoj, tid, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1:
				onGetWasherAndDryerCycleOptionList1(eoj, tid, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2:
				onGetWasherAndDryerCycleOptionList2(eoj, tid, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3:
				onGetWasherAndDryerCycleOptionList3(eoj, tid, pdc, edt);
				break;
			case EPC_WATER_FLOW_RATE_SETTING:
				onGetWaterFlowRateSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING:
				onGetGrotationSpeedForSpinDryingHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GDEGREE_OF_DRYING_H_SETTING:
				onGetGdegreeOfDryingHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_REMAINING_WASHING_TIME:
				onGetRemainingWashingTime(eoj, tid, pdc, edt);
				break;
			case EPC_REMAINING_DRYING_TIME:
				onGetRemainingDryingTime(eoj, tid, pdc, edt);
				break;
			case EPC_ELAPSED_TIME_ON_THE_ON_TIMER:
				onGetElapsedTimeOnTheOnTimer(eoj, tid, pdc, edt);
				break;
			case EPC_PRESOAKING_TIME_SETTING:
				onGetPresoakingTimeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE:
				onGetCurrentStageOfWasherAndDryerCycle(eoj, tid, pdc, edt);
				break;
			case EPC_WATER_VOLUME_SETTING1:
				onGetWaterVolumeSetting1(eoj, tid, pdc, edt);
				break;
			case EPC_WATER_VOLUME_SETTING2:
				onGetWaterVolumeSetting2(eoj, tid, pdc, edt);
				break;
			case EPC_WASHING_TIME_SETTING:
				onGetWashingTimeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING:
				onGetGnumberOfTimesOfRinsingHSetting(eoj, tid, pdc, edt);
				break;
			case EPC_RINSING_PROCESS_SETTING:
				onGetRinsingProcessSetting(eoj, tid, pdc, edt);
				break;
			case EPC_SPIN_DRYING_TIME_SETTING:
				onGetSpinDryingTimeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_DRYING_TIME_SETTING:
				onGetDryingTimeSetting(eoj, tid, pdc, edt);
				break;
			case EPC_WARM_WATER_SETTING:
				onGetWarmWaterSetting(eoj, tid, pdc, edt);
				break;
			case EPC_BATHTUB_WATER_RECYCLE_SETTING:
				onGetBathtubWaterRecycleSetting(eoj, tid, pdc, edt);
				break;
			case EPC_WRINKLING_MINIMIZATION_SETTING:
				onGetWrinklingMinimizationSetting(eoj, tid, pdc, edt);
				break;
			case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE:
				onGetTimeRemainingToCompleteWasherAndDryerCycle(eoj, tid, pdc, edt);
				break;
			case EPC_DOOR_COVER_LOCK_SETTING:
				onGetDoorCoverLockSetting(eoj, tid, pdc, edt);
				break;
			case EPC_WASHER_AND_DRYER_CYCLE:
				onGetWasherAndDryerCycle(eoj, tid, pdc, edt);
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
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWasherAndDryerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWasherAndDryerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDryingCycleSettingNote1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDryingCycleSettingNote1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~12,<br>Data size : 12 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetWasherAndDryerCycleOptionList1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~4,<br>Data size : 4 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetWasherAndDryerCycleOptionList2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br>When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~4,<br>Data size : 4 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetWasherAndDryerCycleOptionList3(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWaterFlowRateSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWaterFlowRateSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Data type : unsign ed short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGrotationSpeedForSpinDryingHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Data type : unsign ed short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGrotationSpeedForSpinDryingHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGdegreeOfDryingHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGdegreeOfDryingHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Acquires the remaining washing time in .the . gHH:MM h .format.<br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F 0xFF<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRemainingWashingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Acquires the remaining drying time .in .the . gHH:MM h .format.<br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F0xFF<br><br>Data type : unsign ed<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRemainingDryingTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetElapsedTimeOnTheOnTimer(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetPresoakingTimeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetPresoakingTimeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the current stage of the washer and dryer cycle.<br>Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44 Washing completed = 0x45 Washing/drying (without wrinkling minimization) completed = 0x51 Drying = 0x52 Wrinkling minimization = 0x53 Drying (with wrinkling minimization) completed = 0x54 Standing by to start = 0x61 1st rinsing = 0x71 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88 Preheat spin drying = 0x91 Unique code defined by the manufature = 0xE0 to 0xEF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetCurrentStageOfWasherAndDryerCycle(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWaterVolumeSetting1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWaterVolumeSetting1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWaterVolumeSetting2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWaterVolumeSetting2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWashingTimeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWashingTimeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetGnumberOfTimesOfRinsingHSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetGnumberOfTimesOfRinsingHSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Data type : unsigned char  ~4<br>Data size : 4 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRinsingProcessSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Data type : unsigned char  ~4<br>Data size : 4 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetRinsingProcessSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetSpinDryingTimeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetSpinDryingTimeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDryingTimeSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDryingTimeSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWarmWaterSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWarmWaterSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetBathtubWaterRecycleSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetBathtubWaterRecycleSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetWrinklingMinimizationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetWrinklingMinimizationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the time remaining to complete the current washer and dryer .cycle .in .the . gHH: .MM h .format.<br>0 to 0xFE: 0 to 0x3B (= 0 to 254 hours): (= 0 to 59 minutes) Remaining time unknown = 0xFF: 0xFF<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetTimeRemainingToCompleteWasherAndDryerCycle(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>Locked: 0x41 Unlocked: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetDoorCoverLockSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>Locked: 0x41 Unlocked: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetDoorCoverLockSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to acquire the current washer and dryer cycle setting.<br>Bytes 1 and 2: This property indicates the available items in a bitmap format. Byte 3: Presoaking With presoaking: 0x41 Without presoaking: 0x42 Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced. Byte 6: Number of times of rinsing The value of the  g fnumber of times of rinsing f setting h property shall be referenced. Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced. Byte 11: Spin drying time The value of the  gspin drying time setting h property shall be referenced. Bytes 12 and 13: Drying time The value of the  hdrying time setting h property shall be referenced. Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced. Byte 15: Water volume setting 1 The value of the  gwater volume setting 1 h property shall be referenced. Byte 16: Water volume setting 2 The value of the  gwater volume setting 2 h property shall be referenced. Byte 17: Bathtub water recycle setting The value of the  gbathtub water recycle setting h property shall be referenced. Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced. Bytes 19 and 20:  gRotation speed for spin drying h setting The value of the  g frotation speed for spin drying f setting h property shall be referenced. Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting The value of the  gpresoaking time setting h property shall be referenced. Byte 24: Wrinkling minimization setting The value of the  gwrinkling minimization setting h property shall be referenced.<br><br>Data type : unsigned Char  ~24<br>Data size : 24 byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetWasherAndDryerCycle(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
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
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWasherAndDryerSetting(byte[] edt);
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWasherAndDryerCycleSetting1Note1(byte[] edt);
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWasherAndDryerCycleSetting2Note1(byte[] edt);
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDryingCycleSettingNote1(byte[] edt);
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWaterFlowRateSetting(byte[] edt);
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Data type : unsign ed short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGrotationSpeedForSpinDryingHSetting(byte[] edt);
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGdegreeOfDryingHSetting(byte[] edt);
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetPresoakingTimeSetting(byte[] edt);
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWaterVolumeSetting1(byte[] edt);
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWaterVolumeSetting2(byte[] edt);
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWashingTimeSetting(byte[] edt);
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetGnumberOfTimesOfRinsingHSetting(byte[] edt);
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Data type : unsigned char  ~4<br>Data size : 4 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetRinsingProcessSetting(byte[] edt);
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetSpinDryingTimeSetting(byte[] edt);
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDryingTimeSetting(byte[] edt);
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWarmWaterSetting(byte[] edt);
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetBathtubWaterRecycleSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetWrinklingMinimizationSetting(byte[] edt);
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>Locked: 0x41 Unlocked: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetDoorCoverLockSetting(byte[] edt);
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt);
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetOnTimerSetting(byte[] edt);
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
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
		public Setter reqSetWasherAndDryerSetting(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_SETTING, edt, setWasherAndDryerSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetWasherAndDryerCycleSetting1Note1(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1, edt, setWasherAndDryerCycleSetting1Note1(edt));
			return this;
		}
		@Override
		public Setter reqSetWasherAndDryerCycleSetting2Note1(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1, edt, setWasherAndDryerCycleSetting2Note1(edt));
			return this;
		}
		@Override
		public Setter reqSetDryingCycleSettingNote1(byte[] edt) {
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1, edt, setDryingCycleSettingNote1(edt));
			return this;
		}
		@Override
		public Setter reqSetWaterFlowRateSetting(byte[] edt) {
			addProperty(EPC_WATER_FLOW_RATE_SETTING, edt, setWaterFlowRateSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGrotationSpeedForSpinDryingHSetting(byte[] edt) {
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING, edt, setGrotationSpeedForSpinDryingHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGdegreeOfDryingHSetting(byte[] edt) {
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING, edt, setGdegreeOfDryingHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetPresoakingTimeSetting(byte[] edt) {
			addProperty(EPC_PRESOAKING_TIME_SETTING, edt, setPresoakingTimeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_WATER_VOLUME_SETTING1, edt, setWaterVolumeSetting1(edt));
			return this;
		}
		@Override
		public Setter reqSetWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_WATER_VOLUME_SETTING2, edt, setWaterVolumeSetting2(edt));
			return this;
		}
		@Override
		public Setter reqSetWashingTimeSetting(byte[] edt) {
			addProperty(EPC_WASHING_TIME_SETTING, edt, setWashingTimeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGnumberOfTimesOfRinsingHSetting(byte[] edt) {
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING, edt, setGnumberOfTimesOfRinsingHSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetRinsingProcessSetting(byte[] edt) {
			addProperty(EPC_RINSING_PROCESS_SETTING, edt, setRinsingProcessSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetSpinDryingTimeSetting(byte[] edt) {
			addProperty(EPC_SPIN_DRYING_TIME_SETTING, edt, setSpinDryingTimeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetDryingTimeSetting(byte[] edt) {
			addProperty(EPC_DRYING_TIME_SETTING, edt, setDryingTimeSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetWarmWaterSetting(byte[] edt) {
			addProperty(EPC_WARM_WATER_SETTING, edt, setWarmWaterSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetBathtubWaterRecycleSetting(byte[] edt) {
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING, edt, setBathtubWaterRecycleSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetWrinklingMinimizationSetting(byte[] edt) {
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING, edt, setWrinklingMinimizationSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetDoorCoverLockSetting(byte[] edt) {
			addProperty(EPC_DOOR_COVER_LOCK_SETTING, edt, setDoorCoverLockSetting(edt));
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
		public Setter reqSetWasherAndDryerSetting(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWasherAndDryerCycleSetting1Note1(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWasherAndDryerCycleSetting2Note1(byte[] edt) {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetDryingCycleSettingNote1(byte[] edt) {
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWaterFlowRateSetting(byte[] edt) {
			addProperty(EPC_WATER_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGrotationSpeedForSpinDryingHSetting(byte[] edt) {
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetGdegreeOfDryingHSetting(byte[] edt) {
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetPresoakingTimeSetting(byte[] edt) {
			addProperty(EPC_PRESOAKING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetWaterVolumeSetting1(byte[] edt) {
			addProperty(EPC_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWaterVolumeSetting2(byte[] edt) {
			addProperty(EPC_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWashingTimeSetting(byte[] edt) {
			addProperty(EPC_WASHING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetGnumberOfTimesOfRinsingHSetting(byte[] edt) {
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetRinsingProcessSetting(byte[] edt) {
			addProperty(EPC_RINSING_PROCESS_SETTING, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Setter reqSetSpinDryingTimeSetting(byte[] edt) {
			addProperty(EPC_SPIN_DRYING_TIME_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetDryingTimeSetting(byte[] edt) {
			addProperty(EPC_DRYING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Setter reqSetWarmWaterSetting(byte[] edt) {
			addProperty(EPC_WARM_WATER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetBathtubWaterRecycleSetting(byte[] edt) {
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetWrinklingMinimizationSetting(byte[] edt) {
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetDoorCoverLockSetting(byte[] edt) {
			addProperty(EPC_DOOR_COVER_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetDoorCoverOpenCloseStatus();
		/**
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWasherAndDryerSetting();
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWasherAndDryerCycleSetting1Note1();
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWasherAndDryerCycleSetting2Note1();
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDryingCycleSettingNote1();
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~12,<br>Data size : 12 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetWasherAndDryerCycleOptionList1();
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~4,<br>Data size : 4 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetWasherAndDryerCycleOptionList2();
		/**
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br>When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~4,<br>Data size : 4 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetWasherAndDryerCycleOptionList3();
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWaterFlowRateSetting();
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Data type : unsign ed short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGrotationSpeedForSpinDryingHSetting();
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGdegreeOfDryingHSetting();
		/**
		 * Acquires the remaining washing time in .the . gHH:MM h .format.<br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F 0xFF<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRemainingWashingTime();
		/**
		 * Acquires the remaining drying time .in .the . gHH:MM h .format.<br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F0xFF<br><br>Data type : unsign ed<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRemainingDryingTime();
		/**
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetElapsedTimeOnTheOnTimer();
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetPresoakingTimeSetting();
		/**
		 * Used to acquire the current stage of the washer and dryer cycle.<br>Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44 Washing completed = 0x45 Washing/drying (without wrinkling minimization) completed = 0x51 Drying = 0x52 Wrinkling minimization = 0x53 Drying (with wrinkling minimization) completed = 0x54 Standing by to start = 0x61 1st rinsing = 0x71 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88 Preheat spin drying = 0x91 Unique code defined by the manufature = 0xE0 to 0xEF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetCurrentStageOfWasherAndDryerCycle();
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWaterVolumeSetting1();
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWaterVolumeSetting2();
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWashingTimeSetting();
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetGnumberOfTimesOfRinsingHSetting();
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Data type : unsigned char  ~4<br>Data size : 4 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetRinsingProcessSetting();
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetSpinDryingTimeSetting();
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDryingTimeSetting();
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWarmWaterSetting();
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetBathtubWaterRecycleSetting();
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetWrinklingMinimizationSetting();
		/**
		 * Used to acquire the time remaining to complete the current washer and dryer .cycle .in .the . gHH: .MM h .format.<br>0 to 0xFE: 0 to 0x3B (= 0 to 254 hours): (= 0 to 59 minutes) Remaining time unknown = 0xFF: 0xFF<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetTimeRemainingToCompleteWasherAndDryerCycle();
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>Locked: 0x41 Unlocked: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetDoorCoverLockSetting();
		/**
		 * Used to acquire the current washer and dryer cycle setting.<br>Bytes 1 and 2: This property indicates the available items in a bitmap format. Byte 3: Presoaking With presoaking: 0x41 Without presoaking: 0x42 Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced. Byte 6: Number of times of rinsing The value of the  g fnumber of times of rinsing f setting h property shall be referenced. Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced. Byte 11: Spin drying time The value of the  gspin drying time setting h property shall be referenced. Bytes 12 and 13: Drying time The value of the  hdrying time setting h property shall be referenced. Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced. Byte 15: Water volume setting 1 The value of the  gwater volume setting 1 h property shall be referenced. Byte 16: Water volume setting 2 The value of the  gwater volume setting 2 h property shall be referenced. Byte 17: Bathtub water recycle setting The value of the  gbathtub water recycle setting h property shall be referenced. Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced. Bytes 19 and 20:  gRotation speed for spin drying h setting The value of the  g frotation speed for spin drying f setting h property shall be referenced. Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting The value of the  gpresoaking time setting h property shall be referenced. Byte 24: Wrinkling minimization setting The value of the  gwrinkling minimization setting h property shall be referenced.<br><br>Data type : unsigned Char  ~24<br>Data size : 24 byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetWasherAndDryerCycle();
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerReservationSetting();
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetOnTimerSetting();
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
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
		public Getter reqGetWasherAndDryerSetting() {
			byte[] edt = getWasherAndDryerSetting();
			addProperty(EPC_WASHER_AND_DRYER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleSetting1Note1() {
			byte[] edt = getWasherAndDryerCycleSetting1Note1();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleSetting2Note1() {
			byte[] edt = getWasherAndDryerCycleSetting2Note1();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDryingCycleSettingNote1() {
			byte[] edt = getDryingCycleSettingNote1();
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleOptionList1() {
			byte[] edt = getWasherAndDryerCycleOptionList1();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1, edt, (edt != null && (edt.length == 12)));
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleOptionList2() {
			byte[] edt = getWasherAndDryerCycleOptionList2();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleOptionList3() {
			byte[] edt = getWasherAndDryerCycleOptionList3();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetWaterFlowRateSetting() {
			byte[] edt = getWaterFlowRateSetting();
			addProperty(EPC_WATER_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetGrotationSpeedForSpinDryingHSetting() {
			byte[] edt = getGrotationSpeedForSpinDryingHSetting();
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGdegreeOfDryingHSetting() {
			byte[] edt = getGdegreeOfDryingHSetting();
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRemainingWashingTime() {
			byte[] edt = getRemainingWashingTime();
			addProperty(EPC_REMAINING_WASHING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRemainingDryingTime() {
			byte[] edt = getRemainingDryingTime();
			addProperty(EPC_REMAINING_DRYING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetElapsedTimeOnTheOnTimer() {
			byte[] edt = getElapsedTimeOnTheOnTimer();
			addProperty(EPC_ELAPSED_TIME_ON_THE_ON_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetPresoakingTimeSetting() {
			byte[] edt = getPresoakingTimeSetting();
			addProperty(EPC_PRESOAKING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetCurrentStageOfWasherAndDryerCycle() {
			byte[] edt = getCurrentStageOfWasherAndDryerCycle();
			addProperty(EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWaterVolumeSetting1() {
			byte[] edt = getWaterVolumeSetting1();
			addProperty(EPC_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWaterVolumeSetting2() {
			byte[] edt = getWaterVolumeSetting2();
			addProperty(EPC_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWashingTimeSetting() {
			byte[] edt = getWashingTimeSetting();
			addProperty(EPC_WASHING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetGnumberOfTimesOfRinsingHSetting() {
			byte[] edt = getGnumberOfTimesOfRinsingHSetting();
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetRinsingProcessSetting() {
			byte[] edt = getRinsingProcessSetting();
			addProperty(EPC_RINSING_PROCESS_SETTING, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetSpinDryingTimeSetting() {
			byte[] edt = getSpinDryingTimeSetting();
			addProperty(EPC_SPIN_DRYING_TIME_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetDryingTimeSetting() {
			byte[] edt = getDryingTimeSetting();
			addProperty(EPC_DRYING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetWarmWaterSetting() {
			byte[] edt = getWarmWaterSetting();
			addProperty(EPC_WARM_WATER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBathtubWaterRecycleSetting() {
			byte[] edt = getBathtubWaterRecycleSetting();
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWrinklingMinimizationSetting() {
			byte[] edt = getWrinklingMinimizationSetting();
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetTimeRemainingToCompleteWasherAndDryerCycle() {
			byte[] edt = getTimeRemainingToCompleteWasherAndDryerCycle();
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetDoorCoverLockSetting() {
			byte[] edt = getDoorCoverLockSetting();
			addProperty(EPC_DOOR_COVER_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycle() {
			byte[] edt = getWasherAndDryerCycle();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE, edt, (edt != null && (edt.length == 24)));
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
		public Getter reqGetWasherAndDryerSetting() {
			addProperty(EPC_WASHER_AND_DRYER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleSetting1Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1);
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleSetting2Note1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1);
			return this;
		}
		@Override
		public Getter reqGetDryingCycleSettingNote1() {
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1);
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleOptionList1() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1);
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleOptionList2() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2);
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycleOptionList3() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3);
			return this;
		}
		@Override
		public Getter reqGetWaterFlowRateSetting() {
			addProperty(EPC_WATER_FLOW_RATE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGrotationSpeedForSpinDryingHSetting() {
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGdegreeOfDryingHSetting() {
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRemainingWashingTime() {
			addProperty(EPC_REMAINING_WASHING_TIME);
			return this;
		}
		@Override
		public Getter reqGetRemainingDryingTime() {
			addProperty(EPC_REMAINING_DRYING_TIME);
			return this;
		}
		@Override
		public Getter reqGetElapsedTimeOnTheOnTimer() {
			addProperty(EPC_ELAPSED_TIME_ON_THE_ON_TIMER);
			return this;
		}
		@Override
		public Getter reqGetPresoakingTimeSetting() {
			addProperty(EPC_PRESOAKING_TIME_SETTING);
			return this;
		}
		@Override
		public Getter reqGetCurrentStageOfWasherAndDryerCycle() {
			addProperty(EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		@Override
		public Getter reqGetWaterVolumeSetting1() {
			addProperty(EPC_WATER_VOLUME_SETTING1);
			return this;
		}
		@Override
		public Getter reqGetWaterVolumeSetting2() {
			addProperty(EPC_WATER_VOLUME_SETTING2);
			return this;
		}
		@Override
		public Getter reqGetWashingTimeSetting() {
			addProperty(EPC_WASHING_TIME_SETTING);
			return this;
		}
		@Override
		public Getter reqGetGnumberOfTimesOfRinsingHSetting() {
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING);
			return this;
		}
		@Override
		public Getter reqGetRinsingProcessSetting() {
			addProperty(EPC_RINSING_PROCESS_SETTING);
			return this;
		}
		@Override
		public Getter reqGetSpinDryingTimeSetting() {
			addProperty(EPC_SPIN_DRYING_TIME_SETTING);
			return this;
		}
		@Override
		public Getter reqGetDryingTimeSetting() {
			addProperty(EPC_DRYING_TIME_SETTING);
			return this;
		}
		@Override
		public Getter reqGetWarmWaterSetting() {
			addProperty(EPC_WARM_WATER_SETTING);
			return this;
		}
		@Override
		public Getter reqGetBathtubWaterRecycleSetting() {
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING);
			return this;
		}
		@Override
		public Getter reqGetWrinklingMinimizationSetting() {
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING);
			return this;
		}
		@Override
		public Getter reqGetTimeRemainingToCompleteWasherAndDryerCycle() {
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		@Override
		public Getter reqGetDoorCoverLockSetting() {
			addProperty(EPC_DOOR_COVER_LOCK_SETTING);
			return this;
		}
		@Override
		public Getter reqGetWasherAndDryerCycle() {
			addProperty(EPC_WASHER_AND_DRYER_CYCLE);
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
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br>Door/cover open = 0x41 Door/cover closed = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformDoorCoverOpenCloseStatus();
		/**
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42 Stop(ped) = 0x43<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWasherAndDryerSetting();
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying, h  gwashing h or  gdrying h mode and to acquire the current setting(s). The value ranges shall be as follows: Washing and drying couse: 0x21 to 0x3F Washing and drying cource maker original code: 0x40 to 0x4F Washing cource: 0x61 to 0x7F Washing cource maker original code: 0x80 to 0x8F Drying cource: 0xA1 to 0xBF Drying cource maker original code: 0xC0 to 0xDF<br><Washing and drying cource> Standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32 Washing cource / maker original cource = 0x40 to 0x4F <Washing cource> Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F Washing cource / maker original cource = 0x80 to 0x8F <Drying cource> Standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank drying = 0xBF Drying cource / maker original cource = 0xC0 to 0xCF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWasherAndDryerCycleSetting1Note1();
		/**
		 * Used to specify the washer and dryer cycle option(s) to use in the  gwashing and drying h mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the  gdrying cycle setting h property (EPC = 0xD2). Maker original code = 0xE0 to 0xEF<br>No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank cleaning = 0x3F Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWasherAndDryerCycleSetting2Note1();
		/**
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the  gwashing and drying h mode, the  gwasher and dryer cycle setting 2 h property (EPC = 0xD1) shall be used. Maker original code = 0xE0 to 0xEF<br>No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank drying = 0xBF Maker original cource = 0xE0 to 0xEF<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDryingCycleSettingNote1();
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 1 h property.<br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~12,<br>Data size : 12 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformWasherAndDryerCycleOptionList1();
		/**
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the  gwasher and dryer cycle setting 2 h property.<br>When the value contained in the bit for the desired washer and dryer cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~4,<br>Data size : 4 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformWasherAndDryerCycleOptionList2();
		/**
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the  gdrying cycle setting h property.<br>When the value contained in the bit for the desired drying cycle option is  g1 h, the option can be specified. When the value contained in the bit for the desired drying cycle option is  g0 h, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br><br>Data type : unsign ed char  ~4,<br>Data size : 4 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformWasherAndDryerCycleOptionList3();
		/**
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWaterFlowRateSetting();
		/**
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br><Absolute setting> - 0x0000 to 0x0FFF (0 to 4095 r/min.) <Relative setting relative to the automatic setting> - Automatic setting 0xFFFF - Relative setting in the positive direction 0xA000 to 0xA7FF (1 to 2048 r/min.) - Relative setting in the negative direction 0xC000 to 0xC7FF (1 to 2048r/min.)<br><br>Data type : unsign ed short<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGrotationSpeedForSpinDryingHSetting();
		/**
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively. <Relative setting relative to the automatic setting> - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsign ed char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGdegreeOfDryingHSetting();
		/**
		 * Acquires the remaining washing time in .the . gHH:MM h .format.<br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F 0xFF<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRemainingWashingTime();
		/**
		 * Acquires the remaining drying time .in .the . gHH:MM h .format.<br>0-0xFE F0-0x3B (=0-254) hours F(=0-59) minutes Remaining time unknown=0xFF F0xFF<br><br>Data type : unsign ed<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRemainingDryingTime();
		/**
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformElapsedTimeOnTheOnTimer();
		/**
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) <Relative setting relative to the automatic setting> - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigne d char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformPresoakingTimeSetting();
		/**
		 * Used to acquire the current stage of the washer and dryer cycle.<br>Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44 Washing completed = 0x45 Washing/drying (without wrinkling minimization) completed = 0x51 Drying = 0x52 Wrinkling minimization = 0x53 Drying (with wrinkling minimization) completed = 0x54 Standing by to start = 0x61 1st rinsing = 0x71 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88 Preheat spin drying = 0x91 Unique code defined by the manufature = 0xE0 to 0xEF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformCurrentStageOfWasherAndDryerCycle();
		/**
		 * Used to specify the water volume in liters and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x7F (0 to 127 liters) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 liters - Relative setting in the negative direction 0xC0 to 0xDF (1 to 32 liters)<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWaterVolumeSetting1();
		/**
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br><Absolute setting> - 0x31 to 0x40 (16 levels) - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively. < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xA7: Levels 1 to 8 - Relative setting in the negative direction 0xC0 to 0xC7: Levels 1 to 8<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWaterVolumeSetting2();
		/**
		 * Used to specify the duration of the washing process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes Relative setting in the negative direction - 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWashingTimeSetting();
		/**
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>0 to 8 times (0x00 to 0x08) Automatic = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformGnumberOfTimesOfRinsingHSetting();
		/**
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows: Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>0000: Automatic mode 0001: Rinsing without additional feeding of water from the tap 0010: Rinsing with additional feeding of water from the tap 0011: Shower rinsing<br><br>Data type : unsigned char  ~4<br>Data size : 4 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformRinsingProcessSetting();
		/**
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x3B (0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF - Relative setting in the positive direction 0xA0 to 0xBF: 1 to 32 minutes - Relative setting in the negative direction 0xC0 to 0xDF: 1 to 32 minute<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformSpinDryingTimeSetting();
		/**
		 * Used to specify the duration of the drying process and to acquire the current setting.<br><Absolute setting> - 0x00 to 0x17: 0x00 to 0x3B (= 0 to 23 hours): (= 0 to 59 minutes) < Relative setting relative to the automatic setting > - Automatic setting 0xFF: 0xFF - Relative setting in the positive direction 0xA000 to 0xA03B: 1 to 60 minutes - Relative setting in the negative direction 0xC000 to 0xC03B: 1 to 60 minutes<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDryingTimeSetting();
		/**
		 * Used to specify the temperature of laundry water in   and to acquire the current setting.<br>0 to 100  C (0x00 to 0x64) Not to use warm water = 0xFE Automatic water temperature setting = 0xFF<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWarmWaterSetting();
		/**
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>Bathtub water not used   : 0x40 Washing only                      : 0x41 Rinsing only (excluding the final rinsing)                               : 0x42 All rinsing processes        : 0x43 Washing + rinsing (excluding the final rinsing)                       : 0x44 Washing + all rinsing processes                            : 0x45<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformBathtubWaterRecycleSetting();
		/**
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>Wrinkling minimization function ON                  : 0x41 Wrinkling minimization function OFF                : 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformWrinklingMinimizationSetting();
		/**
		 * Used to acquire the time remaining to complete the current washer and dryer .cycle .in .the . gHH: .MM h .format.<br>0 to 0xFE: 0 to 0x3B (= 0 to 254 hours): (= 0 to 59 minutes) Remaining time unknown = 0xFF: 0xFF<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformTimeRemainingToCompleteWasherAndDryerCycle();
		/**
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>Locked: 0x41 Unlocked: 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformDoorCoverLockSetting();
		/**
		 * Used to acquire the current washer and dryer cycle setting.<br>Bytes 1 and 2: This property indicates the available items in a bitmap format. Byte 3: Presoaking With presoaking: 0x41 Without presoaking: 0x42 Bytes 4 and 5: Washing time The value of the  gwashing time setting h property shall be referenced. Byte 6: Number of times of rinsing The value of the  g fnumber of times of rinsing f setting h property shall be referenced. Bytes 7 through 10: Rinsing process The value of the  grinsing process setting h property shall be referenced. Byte 11: Spin drying time The value of the  gspin drying time setting h property shall be referenced. Bytes 12 and 13: Drying time The value of the  hdrying time setting h property shall be referenced. Byte 14: Warm water setting The value of the  gwarm water setting h property shall be referenced. Byte 15: Water volume setting 1 The value of the  gwater volume setting 1 h property shall be referenced. Byte 16: Water volume setting 2 The value of the  gwater volume setting 2 h property shall be referenced. Byte 17: Bathtub water recycle setting The value of the  gbathtub water recycle setting h property shall be referenced. Byte 18: Water flow rate setting The value of the  gwater flow rate setting h property shall be referenced. Bytes 19 and 20:  gRotation speed for spin drying h setting The value of the  g frotation speed for spin drying f setting h property shall be referenced. Byte 21:  gDegree of drying h setting The value of the  g fdegree of drying f setting h property shall be referenced. Bytes 22 and 23: Presoaking time setting The value of the  gpresoaking time setting h property shall be referenced. Byte 24: Wrinkling minimization setting The value of the  gwrinkling minimization setting h property shall be referenced.<br><br>Data type : unsigned Char  ~24<br>Data size : 24 byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformWasherAndDryerCycle();
		/**
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>Reservation ON = 0x41, reservation OFF = 0x42<br><br>Data type : unsigned char<br>Data size : 1 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerReservationSetting();
		/**
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>0 to 0x17: 0 to 0x3B (= 0 to 23): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformOnTimerSetting();
		/**
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>0 to 0xFF: 0 to 0x3B (= 0 to 255): (= 0 to 59)<br><br>Data type : unsigned char  ~2<br>Data size : 2 byte<br>Set : optional<br>Get : optional
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
		public Informer reqInformWasherAndDryerSetting() {
			byte[] edt = getWasherAndDryerSetting();
			addProperty(EPC_WASHER_AND_DRYER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleSetting1Note1() {
			byte[] edt = getWasherAndDryerCycleSetting1Note1();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleSetting2Note1() {
			byte[] edt = getWasherAndDryerCycleSetting2Note1();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDryingCycleSettingNote1() {
			byte[] edt = getDryingCycleSettingNote1();
			addProperty(EPC_DRYING_CYCLE_SETTING_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleOptionList1() {
			byte[] edt = getWasherAndDryerCycleOptionList1();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1, edt, (edt != null && (edt.length == 12)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleOptionList2() {
			byte[] edt = getWasherAndDryerCycleOptionList2();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycleOptionList3() {
			byte[] edt = getWasherAndDryerCycleOptionList3();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformWaterFlowRateSetting() {
			byte[] edt = getWaterFlowRateSetting();
			addProperty(EPC_WATER_FLOW_RATE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformGrotationSpeedForSpinDryingHSetting() {
			byte[] edt = getGrotationSpeedForSpinDryingHSetting();
			addProperty(EPC_GROTATION_SPEED_FOR_SPIN_DRYING_H_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGdegreeOfDryingHSetting() {
			byte[] edt = getGdegreeOfDryingHSetting();
			addProperty(EPC_GDEGREE_OF_DRYING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRemainingWashingTime() {
			byte[] edt = getRemainingWashingTime();
			addProperty(EPC_REMAINING_WASHING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRemainingDryingTime() {
			byte[] edt = getRemainingDryingTime();
			addProperty(EPC_REMAINING_DRYING_TIME, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformElapsedTimeOnTheOnTimer() {
			byte[] edt = getElapsedTimeOnTheOnTimer();
			addProperty(EPC_ELAPSED_TIME_ON_THE_ON_TIMER, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformPresoakingTimeSetting() {
			byte[] edt = getPresoakingTimeSetting();
			addProperty(EPC_PRESOAKING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformCurrentStageOfWasherAndDryerCycle() {
			byte[] edt = getCurrentStageOfWasherAndDryerCycle();
			addProperty(EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterVolumeSetting1() {
			byte[] edt = getWaterVolumeSetting1();
			addProperty(EPC_WATER_VOLUME_SETTING1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWaterVolumeSetting2() {
			byte[] edt = getWaterVolumeSetting2();
			addProperty(EPC_WATER_VOLUME_SETTING2, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWashingTimeSetting() {
			byte[] edt = getWashingTimeSetting();
			addProperty(EPC_WASHING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformGnumberOfTimesOfRinsingHSetting() {
			byte[] edt = getGnumberOfTimesOfRinsingHSetting();
			addProperty(EPC_GNUMBER_OF_TIMES_OF_RINSING_H_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformRinsingProcessSetting() {
			byte[] edt = getRinsingProcessSetting();
			addProperty(EPC_RINSING_PROCESS_SETTING, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformSpinDryingTimeSetting() {
			byte[] edt = getSpinDryingTimeSetting();
			addProperty(EPC_SPIN_DRYING_TIME_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformDryingTimeSetting() {
			byte[] edt = getDryingTimeSetting();
			addProperty(EPC_DRYING_TIME_SETTING, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformWarmWaterSetting() {
			byte[] edt = getWarmWaterSetting();
			addProperty(EPC_WARM_WATER_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBathtubWaterRecycleSetting() {
			byte[] edt = getBathtubWaterRecycleSetting();
			addProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWrinklingMinimizationSetting() {
			byte[] edt = getWrinklingMinimizationSetting();
			addProperty(EPC_WRINKLING_MINIMIZATION_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformTimeRemainingToCompleteWasherAndDryerCycle() {
			byte[] edt = getTimeRemainingToCompleteWasherAndDryerCycle();
			addProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformDoorCoverLockSetting() {
			byte[] edt = getDoorCoverLockSetting();
			addProperty(EPC_DOOR_COVER_LOCK_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformWasherAndDryerCycle() {
			byte[] edt = getWasherAndDryerCycle();
			addProperty(EPC_WASHER_AND_DRYER_CYCLE, edt, (edt != null && (edt.length == 24)));
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
