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

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class WasherAndDryer extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x03D3;

	public static final byte EPC_DOOR_COVER_OPEN_CLOSE_STATUS = (byte)0xB0;
	public static final byte EPC_WASHER_AND_DRYER_SETTING = (byte)0xB2;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 = (byte)0xD0;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 = (byte)0xD1;
	public static final byte EPC_DRYING_CYCLE_SETTING_NOTE1 = (byte)0xD2;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 = (byte)0xD3;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 = (byte)0xD4;
	public static final byte EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 = (byte)0xD5;
	public static final byte EPC_WATER_FLOW_RATE_SETTING = (byte)0xD6;
	public static final byte EPC_ROTATION_SPEED_FOR_SPIN_DRYING_SETTING = (byte)0xD7;
	public static final byte EPC_DEGREE_OF_DRYING_SETTING = (byte)0xD8;
	public static final byte EPC_REMAINING_WASHING_TIME = (byte)0xDB;
	public static final byte EPC_REMAINING_DRYING_TIME = (byte)0xDC;
	public static final byte EPC_ELAPSED_TIME_ON_THE_ON_TIMER = (byte)0xDF;
	public static final byte EPC_PRESOAKING_TIME_SETTING = (byte)0xE1;
	public static final byte EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE = (byte)0xE2;
	public static final byte EPC_WATER_VOLUME_SETTING1 = (byte)0xE3;
	public static final byte EPC_WATER_VOLUME_SETTING2 = (byte)0xE4;
	public static final byte EPC_WASHING_TIME_SETTING = (byte)0xE5;
	public static final byte EPC_NUMBER_OF_TIMES_OF_RINSING_SETTING = (byte)0xE6;
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
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewWasherAndDryer(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the ON/OFF status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Door/cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getDoorCoverOpenCloseStatus() {return null;}
	/**
	 * Property name : Door/cover open/close status<br>
	 * <br>
	 * EPC : 0xB0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDoorCoverOpenCloseStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42<br>
	 * Stop(ped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWasherAndDryerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Washer and dryer setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42<br>
	 * Stop(ped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerSetting() {return null;}
	/**
	 * Property name : Washer and dryer setting<br>
	 * <br>
	 * EPC : 0xB2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42<br>
	 * Stop(ped) = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying,” “washing” or “drying” mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
	 * Washing and drying course: 0x21.0x3F Washing and drying course maker<br>
	 * original code: 0x40.0x4F<br>
	 * Washing course: 0x61.0x7F Washing course maker original code:<br>
	 * 0x80.0x8F<br>
	 * Drying course: 0xA1.0xBF  Drying course maker original code:<br>
	 * 0xC0.0xDF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Washing and drying course>  Standard = 0x21, silent = 0x22, heavily<br>
	 * soiled clothes = 0x23, hard-to-remove<br>
	 * stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
	 * = 0x32<br>
	 * Washing course / maker original course<br>
	 * = 0x40.0x4F<br>
	 * <Washing course><br>
	 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection<br>
	 * = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
	 * Washing course / maker original course<br>
	 * = 0x80.0x8F<br>
	 * <Drying course><br>
	 * Standard = 0xA1, blankets = 0xA2, soft<br>
	 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank<br>
	 * drying = 0xBF<br>
	 * Drying course / maker original course = 0xC0.0xCF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWasherAndDryerCycleSetting1Note1(byte[] edt) {return false;}
	/**
	 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying,” “washing” or “drying” mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
	 * Washing and drying course: 0x21.0x3F Washing and drying course maker<br>
	 * original code: 0x40.0x4F<br>
	 * Washing course: 0x61.0x7F Washing course maker original code:<br>
	 * 0x80.0x8F<br>
	 * Drying course: 0xA1.0xBF  Drying course maker original code:<br>
	 * 0xC0.0xDF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Washing and drying course>  Standard = 0x21, silent = 0x22, heavily<br>
	 * soiled clothes = 0x23, hard-to-remove<br>
	 * stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
	 * = 0x32<br>
	 * Washing course / maker original course<br>
	 * = 0x40.0x4F<br>
	 * <Washing course><br>
	 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection<br>
	 * = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
	 * Washing course / maker original course<br>
	 * = 0x80.0x8F<br>
	 * <Drying course><br>
	 * Standard = 0xA1, blankets = 0xA2, soft<br>
	 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank<br>
	 * drying = 0xBF<br>
	 * Drying course / maker original course = 0xC0.0xCF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleSetting1Note1() {return null;}
	/**
	 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying,” “washing” or “drying” mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
	 * Washing and drying course: 0x21.0x3F Washing and drying course maker<br>
	 * original code: 0x40.0x4F<br>
	 * Washing course: 0x61.0x7F Washing course maker original code:<br>
	 * 0x80.0x8F<br>
	 * Drying course: 0xA1.0xBF  Drying course maker original code:<br>
	 * 0xC0.0xDF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Washing and drying course>  Standard = 0x21, silent = 0x22, heavily<br>
	 * soiled clothes = 0x23, hard-to-remove<br>
	 * stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
	 * = 0x32<br>
	 * Washing course / maker original course<br>
	 * = 0x40.0x4F<br>
	 * <Washing course><br>
	 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection<br>
	 * = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
	 * Washing course / maker original course<br>
	 * = 0x80.0x8F<br>
	 * <Drying course><br>
	 * Standard = 0xA1, blankets = 0xA2, soft<br>
	 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank<br>
	 * drying = 0xBF<br>
	 * Drying course / maker original course = 0xC0.0xCF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleSetting1Note1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying” mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the “drying cycle setting” property (EPC = 0xD2).<br>
	 * Maker original code = 0xE0.0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing<br>
	 * = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly<br>
	 * soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank<br>
	 * cleaning = 0x3F<br>
	 * Maker original course = 0xE0.0xEF<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWasherAndDryerCycleSetting2Note1(byte[] edt) {return false;}
	/**
	 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying” mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the “drying cycle setting” property (EPC = 0xD2).<br>
	 * Maker original code = 0xE0.0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing<br>
	 * = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly<br>
	 * soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank<br>
	 * cleaning = 0x3F<br>
	 * Maker original course = 0xE0.0xEF<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleSetting2Note1() {return null;}
	/**
	 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying” mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the “drying cycle setting” property (EPC = 0xD2).<br>
	 * Maker original code = 0xE0.0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing<br>
	 * = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly<br>
	 * soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank<br>
	 * cleaning = 0x3F<br>
	 * Maker original course = 0xE0.0xEF<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleSetting2Note1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Drying cycle setting (Note1)<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the “washing and drying” mode, the “washer and dryer cycle setting 2” property (EPC = 0xD1) shall be used.<br>
	 * Maker original code = 0xE0 to 0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts =  0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time<br>
	 * = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank<br>
	 * drying = 0xBF<br>
	 * Maker original course = 0xE0 0xEF<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDryingCycleSettingNote1(byte[] edt) {return false;}
	/**
	 * Property name : Drying cycle setting (Note1)<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the “washing and drying” mode, the “washer and dryer cycle setting 2” property (EPC = 0xD1) shall be used.<br>
	 * Maker original code = 0xE0 to 0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts =  0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time<br>
	 * = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank<br>
	 * drying = 0xBF<br>
	 * Maker original course = 0xE0 0xEF<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDryingCycleSettingNote1() {return null;}
	/**
	 * Property name : Drying cycle setting (Note1)<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the “washing and drying” mode, the “washer and dryer cycle setting 2” property (EPC = 0xD1) shall be used.<br>
	 * Maker original code = 0xE0 to 0xEF<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts =  0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time<br>
	 * = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank<br>
	 * drying = 0xBF<br>
	 * Maker original course = 0xE0 0xEF<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDryingCycleSettingNote1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle option list 1<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 1” property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
	 * <br>
	 * Data type : unsig ned
char
×12,<br>
	 * <br>
	 * Data size : 12
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleOptionList1() {return null;}
	/**
	 * Property name : Washer and dryer cycle option list 1<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 1” property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
	 * <br>
	 * Data type : unsig ned
char
×12,<br>
	 * <br>
	 * Data size : 12
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleOptionList1(byte[] edt) {
		if(edt == null || !(edt.length == 12)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle option list 2<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 2” property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
	 * <br>
	 * Data type : unsig ned
char
×4,<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleOptionList2() {return null;}
	/**
	 * Property name : Washer and dryer cycle option list 2<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 2” property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
	 * <br>
	 * Data type : unsig ned
char
×4,<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleOptionList2(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle option list 3<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the drying cycle options that can be specified with the “drying cycle setting” property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired drying cycle option is “1”, the option can be specified. When the value contained in the bit for the desired drying cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
	 * <br>
	 * Data type : unsig ned
char
×4,<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycleOptionList3() {return null;}
	/**
	 * Property name : Washer and dryer cycle option list 3<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire a bitmap list of the drying cycle options that can be specified with the “drying cycle setting” property.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * When the value contained in the bit for the desired drying cycle option is “1”, the option can be specified. When the value contained in the bit for the desired drying cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
	 * <br>
	 * Data type : unsig ned
char
×4,<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycleOptionList3(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Water flow rate setting<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting> 0x31.0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xA7: Levels 1.8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xC7: Levels 1.8<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWaterFlowRateSetting(byte[] edt) {return false;}
	/**
	 * Property name : Water flow rate setting<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting> 0x31.0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xA7: Levels 1.8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xC7: Levels 1.8<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWaterFlowRateSetting() {return null;}
	/**
	 * Property name : Water flow rate setting<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting> 0x31.0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xA7: Levels 1.8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xC7: Levels 1.8<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWaterFlowRateSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : “Rotation speed for spin drying” setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x0000. 0x0FFF (0.4095 r/min.)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFFFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA7FF (1.2048 r/min.)<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000.0xC7FF (1.2048r/min.)<br>
	 * <br>
	 * Data type : unsig ned short<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRotationSpeedForSpinDryingSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Rotation speed for spin drying” setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x0000. 0x0FFF (0.4095 r/min.)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFFFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA7FF (1.2048 r/min.)<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000.0xC7FF (1.2048r/min.)<br>
	 * <br>
	 * Data type : unsig ned short<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRotationSpeedForSpinDryingSetting() {return null;}
	/**
	 * Property name : “Rotation speed for spin drying” setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x0000. 0x0FFF (0.4095 r/min.)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFFFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA7FF (1.2048 r/min.)<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000.0xC7FF (1.2048r/min.)<br>
	 * <br>
	 * Data type : unsig ned short<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRotationSpeedForSpinDryingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : “Degree of drying” setting<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31.0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xA7: Levels 1.8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xC7: Levels 1.8<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDegreeOfDryingSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Degree of drying” setting<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31.0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xA7: Levels 1.8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xC7: Levels 1.8<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDegreeOfDryingSetting() {return null;}
	/**
	 * Property name : “Degree of drying” setting<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31.0x40 (16 levels)<br>
	 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xA7: Levels 1.8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xC7: Levels 1.8<br>
	 * <br>
	 * Data type : unsig ned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDegreeOfDryingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Remaining washing time<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * Acquires the remaining washing time<br>
	 * in the “HH:MM” format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFE : 0.0x3B<br>
	 * (=0-254) hours : (=0-59) minutes Remaining time unknown=0xFF :<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsign ed
char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRemainingWashingTime() {return null;}
	/**
	 * Property name : Remaining washing time<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * Acquires the remaining washing time<br>
	 * in the “HH:MM” format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFE : 0.0x3B<br>
	 * (=0-254) hours : (=0-59) minutes Remaining time unknown=0xFF :<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsign ed
char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRemainingWashingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Remaining drying time<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * Acquires the remaining drying<br>
	 * time in the “HH:MM” format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFE : 0.0x3B<br>
	 * (=0.254) hours : (=0.59) minutes Remaining time unknown=0xFF :<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsign ed
char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRemainingDryingTime() {return null;}
	/**
	 * Property name : Remaining drying time<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * Acquires the remaining drying<br>
	 * time in the “HH:MM” format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFE : 0.0x3B<br>
	 * (=0.254) hours : (=0.59) minutes Remaining time unknown=0xFF :<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsign ed
char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRemainingDryingTime(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Elapsed time on the ON timer<br>
	 * <br>
	 * EPC : 0xDF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsign ed
char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : Hour minu
tes<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getElapsedTimeOnTheOnTimer() {return null;}
	/**
	 * Property name : Elapsed time on the ON timer<br>
	 * <br>
	 * EPC : 0xDF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsign ed
char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : Hour minu
tes<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidElapsedTimeOnTheOnTimer(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Presoaking time setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x17: 0x00.0x3B<br>
	 * (= 0.23 hours): (= 0.59 minutes)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA03B: 1.60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000.0xC03B: 1.60 minutes<br>
	 * <br>
	 * Data type : unsign ed char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : h,mi n<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setPresoakingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Presoaking time setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x17: 0x00.0x3B<br>
	 * (= 0.23 hours): (= 0.59 minutes)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA03B: 1.60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000.0xC03B: 1.60 minutes<br>
	 * <br>
	 * Data type : unsign ed char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : h,mi n<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getPresoakingTimeSetting() {return null;}
	/**
	 * Property name : Presoaking time setting<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x17: 0x00.0x3B<br>
	 * (= 0.23 hours): (= 0.59 minutes)<br>
	 * <Relative setting relative to the automatic setting><br>
	 * - Automatic setting 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA03B: 1.60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000.0xC03B: 1.60 minutes<br>
	 * <br>
	 * Data type : unsign ed char
×2<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : h,mi n<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidPresoakingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Current stage of washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current stage of the washer and dryer cycle.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44<br>
	 * Washing completed = 0x45<br>
	 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
	 * Drying = 0x52<br>
	 * Wrinkling minimization = 0x53 Drying (with wrinkling<br>
	 * minimization) completed = 0x54<br>
	 * Standing by to start = 0x61 1st rinsing = 0x71<br>
	 * 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78<br>
	 * 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88<br>
	 * Preheat spin drying = 0x91<br>
	 * Unique code defined by the manufacture = 0xE0.0xEF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getCurrentStageOfWasherAndDryerCycle() {return null;}
	/**
	 * Property name : Current stage of washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current stage of the washer and dryer cycle.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44<br>
	 * Washing completed = 0x45<br>
	 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
	 * Drying = 0x52<br>
	 * Wrinkling minimization = 0x53 Drying (with wrinkling<br>
	 * minimization) completed = 0x54<br>
	 * Standing by to start = 0x61 1st rinsing = 0x71<br>
	 * 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78<br>
	 * 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88<br>
	 * Preheat spin drying = 0x91<br>
	 * Unique code defined by the manufacture = 0xE0.0xEF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidCurrentStageOfWasherAndDryerCycle(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Water volume setting 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume in liters and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x7F (0.127 liters)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xBF: 1.32 liters<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xDF (1.32 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWaterVolumeSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Water volume setting 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume in liters and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x7F (0.127 liters)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xBF: 1.32 liters<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xDF (1.32 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWaterVolumeSetting1() {return null;}
	/**
	 * Property name : Water volume setting 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume in liters and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x7F (0.127 liters)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xBF: 1.32 liters<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xDF (1.32 liters)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWaterVolumeSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Water volume setting 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31.0x40 (16 levels)<br>
	 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xA7: Levels 1.8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xC7: Levels 1. 8<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWaterVolumeSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Water volume setting 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31.0x40 (16 levels)<br>
	 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xA7: Levels 1.8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xC7: Levels 1. 8<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWaterVolumeSetting2() {return null;}
	/**
	 * Property name : Water volume setting 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x31.0x40 (16 levels)<br>
	 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xA7: Levels 1.8<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xC7: Levels 1. 8<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWaterVolumeSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washing time setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the washing process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x17: 0x00.0x3B<br>
	 * (= 0.23 hours): (= 0.59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA03B: 1.60 minutes<br>
	 * Relative setting in the negative direction<br>
	 * - 0xC000.0xC03B: 1.60 minutes<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWashingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Washing time setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the washing process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x17: 0x00.0x3B<br>
	 * (= 0.23 hours): (= 0.59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA03B: 1.60 minutes<br>
	 * Relative setting in the negative direction<br>
	 * - 0xC000.0xC03B: 1.60 minutes<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWashingTimeSetting() {return null;}
	/**
	 * Property name : Washing time setting<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the washing process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x17: 0x00.0x3B<br>
	 * (= 0.23 hours): (= 0.59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA03B: 1.60 minutes<br>
	 * Relative setting in the negative direction<br>
	 * - 0xC000.0xC03B: 1.60 minutes<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWashingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : “Number of times of rinsing” setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.8 times (0x00.0x08)<br>
	 * Automatic = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setNumberOfTimesOfRinsingSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Number of times of rinsing” setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.8 times (0x00.0x08)<br>
	 * Automatic = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getNumberOfTimesOfRinsingSetting() {return null;}
	/**
	 * Property name : “Number of times of rinsing” setting<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.8 times (0x00.0x08)<br>
	 * Automatic = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidNumberOfTimesOfRinsingSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Rinsing process setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
	 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0000: Automatic mode<br>
	 * 0001: Rinsing without additional feeding of water from the tap<br>
	 * 0010: Rinsing with additional feeding of water from the tap<br>
	 * 0011: Shower rinsing<br>
	 * <br>
	 * Data type : unsigned char
×4<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRinsingProcessSetting(byte[] edt) {return false;}
	/**
	 * Property name : Rinsing process setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
	 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0000: Automatic mode<br>
	 * 0001: Rinsing without additional feeding of water from the tap<br>
	 * 0010: Rinsing with additional feeding of water from the tap<br>
	 * 0011: Shower rinsing<br>
	 * <br>
	 * Data type : unsigned char
×4<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRinsingProcessSetting() {return null;}
	/**
	 * Property name : Rinsing process setting<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
	 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0000: Automatic mode<br>
	 * 0001: Rinsing without additional feeding of water from the tap<br>
	 * 0010: Rinsing with additional feeding of water from the tap<br>
	 * 0011: Shower rinsing<br>
	 * <br>
	 * Data type : unsigned char
×4<br>
	 * <br>
	 * Data size : 4
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRinsingProcessSetting(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Spin drying time setting<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x3B (0.59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xBF: 1.32 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xDF: 1.32 minute<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSpinDryingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Spin drying time setting<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x3B (0.59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xBF: 1.32 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xDF: 1.32 minute<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSpinDryingTimeSetting() {return null;}
	/**
	 * Property name : Spin drying time setting<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x3B (0.59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA0.0xBF: 1.32 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC0.0xDF: 1.32 minute<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSpinDryingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Drying time setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the drying process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x17: 0x00.0x3B<br>
	 * (= 0.23 hours): (= 0.59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA03B: 1.60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000.0xC03B: 1.60 minutes<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDryingTimeSetting(byte[] edt) {return false;}
	/**
	 * Property name : Drying time setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the drying process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x17: 0x00.0x3B<br>
	 * (= 0.23 hours): (= 0.59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA03B: 1.60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000.0xC03B: 1.60 minutes<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDryingTimeSetting() {return null;}
	/**
	 * Property name : Drying time setting<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the duration of the drying process and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * <Absolute setting><br>
	 * - 0x00.0x17: 0x00.0x3B<br>
	 * (= 0.23 hours): (= 0.59 minutes)<br>
	 * < Relative setting relative to the automatic setting ><br>
	 * - Automatic setting 0xFF: 0xFF<br>
	 * - Relative setting in the positive direction<br>
	 * 0xA000.0xA03B: 1.60 minutes<br>
	 * - Relative setting in the negative direction<br>
	 * 0xC000.0xC03B: 1.60 minutes<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : h,min<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDryingTimeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Warm water setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of laundry water in .C and to acquire the current  setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.100°C (0x00.0x64)<br>
	 * Not to use warm water = 0xFE Automatic water temperature setting<br>
	 * = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWarmWaterSetting(byte[] edt) {return false;}
	/**
	 * Property name : Warm water setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of laundry water in .C and to acquire the current  setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.100°C (0x00.0x64)<br>
	 * Not to use warm water = 0xFE Automatic water temperature setting<br>
	 * = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWarmWaterSetting() {return null;}
	/**
	 * Property name : Warm water setting<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the temperature of laundry water in .C and to acquire the current  setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.100°C (0x00.0x64)<br>
	 * Not to use warm water = 0xFE Automatic water temperature setting<br>
	 * = 0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : .C<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWarmWaterSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Bathtub water recycle setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bathtub water not used   : 0x40 Washing only                     : 0x41 Rinsing only (excluding the final<br>
	 * rinsing)                               : 0x42<br>
	 * All rinsing processes        : 0x43 Washing + rinsing (excluding the<br>
	 * final rinsing)                       : 0x44<br>
	 * Washing + all rinsing<br>
	 * processes                            : 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setBathtubWaterRecycleSetting(byte[] edt) {return false;}
	/**
	 * Property name : Bathtub water recycle setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bathtub water not used   : 0x40 Washing only                     : 0x41 Rinsing only (excluding the final<br>
	 * rinsing)                               : 0x42<br>
	 * All rinsing processes        : 0x43 Washing + rinsing (excluding the<br>
	 * final rinsing)                       : 0x44<br>
	 * Washing + all rinsing<br>
	 * processes                            : 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getBathtubWaterRecycleSetting() {return null;}
	/**
	 * Property name : Bathtub water recycle setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bathtub water not used   : 0x40 Washing only                     : 0x41 Rinsing only (excluding the final<br>
	 * rinsing)                               : 0x42<br>
	 * All rinsing processes        : 0x43 Washing + rinsing (excluding the<br>
	 * final rinsing)                       : 0x44<br>
	 * Washing + all rinsing<br>
	 * processes                            : 0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidBathtubWaterRecycleSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Wrinkling minimization setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Wrinkling minimization function ON                  : 0x41<br>
	 * Wrinkling minimization function OFF                : 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setWrinklingMinimizationSetting(byte[] edt) {return false;}
	/**
	 * Property name : Wrinkling minimization setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Wrinkling minimization function ON                  : 0x41<br>
	 * Wrinkling minimization function OFF                : 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getWrinklingMinimizationSetting() {return null;}
	/**
	 * Property name : Wrinkling minimization setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Wrinkling minimization function ON                  : 0x41<br>
	 * Wrinkling minimization function OFF                : 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWrinklingMinimizationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Time remaining to complete washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the time remaining to complete the current washer and dryer cycle in the “HH: MM” format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFE: 0.0x3B<br>
	 * (= 0.254 hours): (= 0.59 minutes) Remaining time unknown = 0xFF:<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getTimeRemainingToCompleteWasherAndDryerCycle() {return null;}
	/**
	 * Property name : Time remaining to complete washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the time remaining to complete the current washer and dryer cycle in the “HH: MM” format.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFE: 0.0x3B<br>
	 * (= 0.254 hours): (= 0.59 minutes) Remaining time unknown = 0xFF:<br>
	 * 0xFF<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTimeRemainingToCompleteWasherAndDryerCycle(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Door/cover lock    setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Locked: 0x41<br>
	 * Unlocked: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDoorCoverLockSetting(byte[] edt) {return false;}
	/**
	 * Property name : Door/cover lock    setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Locked: 0x41<br>
	 * Unlocked: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDoorCoverLockSetting() {return null;}
	/**
	 * Property name : Door/cover lock    setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Locked: 0x41<br>
	 * Unlocked: 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDoorCoverLockSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current washer and dryer cycle setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bytes 1 and 2: This property indicates the available<br>
	 * items in a bitmap format.<br>
	 * Byte 3: Presoaking With presoaking: 0x41<br>
	 * Without presoaking: 0x42<br>
	 * Bytes 4 and 5: Washing time The value of the “washing time<br>
	 * setting” property shall be referenced.<br>
	 * Byte 6: Number of times of rinsing The value of the “’number of times of<br>
	 * rinsing’ setting” property shall be referenced.<br>
	 * Bytes 7 through 10: Rinsing process The value of the “rinsing process setting” property shall be referenced.<br>
	 * Byte 11: Spin drying time<br>
	 * The value of the “spin drying time setting” property shall be referenced.<br>
	 * Bytes 12 and 13: Drying time<br>
	 * The value of the 'drying time setting” property shall be referenced.<br>
	 * Byte 14: Warm water setting The value of the “warm water<br>
	 * setting” property shall be referenced.<br>
	 * Byte 15: Water volume setting 1 The value of the “water volume setting 1” property shall be referenced.<br>
	 * Byte 16: Water volume setting 2 The value of the “water volume setting 2” property shall be referenced.<br>
	 * Byte 17: Bathtub water recycle setting<br>
	 * The value of the “bathtub water recycle setting” property shall be referenced.<br>
	 * Byte 18: Water flow rate setting The value of the “water flow rate<br>
	 * setting” property shall be referenced.<br>
	 * Bytes 19 and 20: “Rotation speed for spin drying” setting<br>
	 * The value of the “’rotation speed for spin drying’ setting” property shall be referenced.<br>
	 * Byte 21: “Degree of drying” setting The value of the “’degree of drying’ setting” property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
	 * The value of the “presoaking time setting” property shall be referenced. Byte 24: Wrinkling minimization setting<br>
	 * The value of the “wrinkling minimization setting” property shall<br>
	 * be referenced.<br>
	 * <br>
	 * Data type : unsigned Char
×24<br>
	 * <br>
	 * Data size : 24
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getWasherAndDryerCycle() {return null;}
	/**
	 * Property name : Washer and dryer cycle<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to acquire the current washer and dryer cycle setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Bytes 1 and 2: This property indicates the available<br>
	 * items in a bitmap format.<br>
	 * Byte 3: Presoaking With presoaking: 0x41<br>
	 * Without presoaking: 0x42<br>
	 * Bytes 4 and 5: Washing time The value of the “washing time<br>
	 * setting” property shall be referenced.<br>
	 * Byte 6: Number of times of rinsing The value of the “’number of times of<br>
	 * rinsing’ setting” property shall be referenced.<br>
	 * Bytes 7 through 10: Rinsing process The value of the “rinsing process setting” property shall be referenced.<br>
	 * Byte 11: Spin drying time<br>
	 * The value of the “spin drying time setting” property shall be referenced.<br>
	 * Bytes 12 and 13: Drying time<br>
	 * The value of the 'drying time setting” property shall be referenced.<br>
	 * Byte 14: Warm water setting The value of the “warm water<br>
	 * setting” property shall be referenced.<br>
	 * Byte 15: Water volume setting 1 The value of the “water volume setting 1” property shall be referenced.<br>
	 * Byte 16: Water volume setting 2 The value of the “water volume setting 2” property shall be referenced.<br>
	 * Byte 17: Bathtub water recycle setting<br>
	 * The value of the “bathtub water recycle setting” property shall be referenced.<br>
	 * Byte 18: Water flow rate setting The value of the “water flow rate<br>
	 * setting” property shall be referenced.<br>
	 * Bytes 19 and 20: “Rotation speed for spin drying” setting<br>
	 * The value of the “’rotation speed for spin drying’ setting” property shall be referenced.<br>
	 * Byte 21: “Degree of drying” setting The value of the “’degree of drying’ setting” property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
	 * The value of the “presoaking time setting” property shall be referenced. Byte 24: Wrinkling minimization setting<br>
	 * The value of the “wrinkling minimization setting” property shall<br>
	 * be referenced.<br>
	 * <br>
	 * Data type : unsigned Char
×24<br>
	 * <br>
	 * Data size : 24
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidWasherAndDryerCycle(byte[] edt) {
		if(edt == null || !(edt.length == 24)) return false;
		return true;
	}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerReservationSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerReservationSetting() {return null;}
	/**
	 * Property name : ON timer reservation setting<br>
	 * <br>
	 * EPC : 0x90<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reservation ON = 0x41, reservation OFF = 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerReservationSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getOnTimerSetting() {return null;}
	/**
	 * Property name : ON timer setting<br>
	 * <br>
	 * EPC : 0x91<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Relative time-based ON timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setRelativeTimeBasedOnTimerSetting(byte[] edt) {return false;}
	/**
	 * Property name : Relative time-based ON timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getRelativeTimeBasedOnTimerSetting() {return null;}
	/**
	 * Property name : Relative time-based ON timer setting<br>
	 * <br>
	 * EPC : 0x92<br>
	 * <br>
	 * Contents of property :<br>
	 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFF: 0.0x3B<br>
	 * (= 0.255): (= 0.59)<br>
	 * <br>
	 * Data type : unsigned char
×2<br>
	 * <br>
	 * Data size : 2
bytes<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRelativeTimeBasedOnTimerSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_WASHER_AND_DRYER_SETTING : return setWasherAndDryerSetting(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : return setWasherAndDryerCycleSetting1Note1(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : return setWasherAndDryerCycleSetting2Note1(property.edt);
		case EPC_DRYING_CYCLE_SETTING_NOTE1 : return setDryingCycleSettingNote1(property.edt);
		case EPC_WATER_FLOW_RATE_SETTING : return setWaterFlowRateSetting(property.edt);
		case EPC_ROTATION_SPEED_FOR_SPIN_DRYING_SETTING : return setRotationSpeedForSpinDryingSetting(property.edt);
		case EPC_DEGREE_OF_DRYING_SETTING : return setDegreeOfDryingSetting(property.edt);
		case EPC_PRESOAKING_TIME_SETTING : return setPresoakingTimeSetting(property.edt);
		case EPC_WATER_VOLUME_SETTING1 : return setWaterVolumeSetting1(property.edt);
		case EPC_WATER_VOLUME_SETTING2 : return setWaterVolumeSetting2(property.edt);
		case EPC_WASHING_TIME_SETTING : return setWashingTimeSetting(property.edt);
		case EPC_NUMBER_OF_TIMES_OF_RINSING_SETTING : return setNumberOfTimesOfRinsingSetting(property.edt);
		case EPC_RINSING_PROCESS_SETTING : return setRinsingProcessSetting(property.edt);
		case EPC_SPIN_DRYING_TIME_SETTING : return setSpinDryingTimeSetting(property.edt);
		case EPC_DRYING_TIME_SETTING : return setDryingTimeSetting(property.edt);
		case EPC_WARM_WATER_SETTING : return setWarmWaterSetting(property.edt);
		case EPC_BATHTUB_WATER_RECYCLE_SETTING : return setBathtubWaterRecycleSetting(property.edt);
		case EPC_WRINKLING_MINIMIZATION_SETTING : return setWrinklingMinimizationSetting(property.edt);
		case EPC_DOOR_COVER_LOCK_SETTING : return setDoorCoverLockSetting(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return setOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return setOnTimerSetting(property.edt);
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return setRelativeTimeBasedOnTimerSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : return getDoorCoverOpenCloseStatus();
		case EPC_WASHER_AND_DRYER_SETTING : return getWasherAndDryerSetting();
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : return getWasherAndDryerCycleSetting1Note1();
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : return getWasherAndDryerCycleSetting2Note1();
		case EPC_DRYING_CYCLE_SETTING_NOTE1 : return getDryingCycleSettingNote1();
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 : return getWasherAndDryerCycleOptionList1();
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 : return getWasherAndDryerCycleOptionList2();
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 : return getWasherAndDryerCycleOptionList3();
		case EPC_WATER_FLOW_RATE_SETTING : return getWaterFlowRateSetting();
		case EPC_ROTATION_SPEED_FOR_SPIN_DRYING_SETTING : return getRotationSpeedForSpinDryingSetting();
		case EPC_DEGREE_OF_DRYING_SETTING : return getDegreeOfDryingSetting();
		case EPC_REMAINING_WASHING_TIME : return getRemainingWashingTime();
		case EPC_REMAINING_DRYING_TIME : return getRemainingDryingTime();
		case EPC_ELAPSED_TIME_ON_THE_ON_TIMER : return getElapsedTimeOnTheOnTimer();
		case EPC_PRESOAKING_TIME_SETTING : return getPresoakingTimeSetting();
		case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE : return getCurrentStageOfWasherAndDryerCycle();
		case EPC_WATER_VOLUME_SETTING1 : return getWaterVolumeSetting1();
		case EPC_WATER_VOLUME_SETTING2 : return getWaterVolumeSetting2();
		case EPC_WASHING_TIME_SETTING : return getWashingTimeSetting();
		case EPC_NUMBER_OF_TIMES_OF_RINSING_SETTING : return getNumberOfTimesOfRinsingSetting();
		case EPC_RINSING_PROCESS_SETTING : return getRinsingProcessSetting();
		case EPC_SPIN_DRYING_TIME_SETTING : return getSpinDryingTimeSetting();
		case EPC_DRYING_TIME_SETTING : return getDryingTimeSetting();
		case EPC_WARM_WATER_SETTING : return getWarmWaterSetting();
		case EPC_BATHTUB_WATER_RECYCLE_SETTING : return getBathtubWaterRecycleSetting();
		case EPC_WRINKLING_MINIMIZATION_SETTING : return getWrinklingMinimizationSetting();
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE : return getTimeRemainingToCompleteWasherAndDryerCycle();
		case EPC_DOOR_COVER_LOCK_SETTING : return getDoorCoverLockSetting();
		case EPC_WASHER_AND_DRYER_CYCLE : return getWasherAndDryerCycle();
		case EPC_ON_TIMER_RESERVATION_SETTING : return getOnTimerReservationSetting();
		case EPC_ON_TIMER_SETTING : return getOnTimerSetting();
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return getRelativeTimeBasedOnTimerSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : return isValidDoorCoverOpenCloseStatus(property.edt);
		case EPC_WASHER_AND_DRYER_SETTING : return isValidWasherAndDryerSetting(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : return isValidWasherAndDryerCycleSetting1Note1(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : return isValidWasherAndDryerCycleSetting2Note1(property.edt);
		case EPC_DRYING_CYCLE_SETTING_NOTE1 : return isValidDryingCycleSettingNote1(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 : return isValidWasherAndDryerCycleOptionList1(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 : return isValidWasherAndDryerCycleOptionList2(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 : return isValidWasherAndDryerCycleOptionList3(property.edt);
		case EPC_WATER_FLOW_RATE_SETTING : return isValidWaterFlowRateSetting(property.edt);
		case EPC_ROTATION_SPEED_FOR_SPIN_DRYING_SETTING : return isValidRotationSpeedForSpinDryingSetting(property.edt);
		case EPC_DEGREE_OF_DRYING_SETTING : return isValidDegreeOfDryingSetting(property.edt);
		case EPC_REMAINING_WASHING_TIME : return isValidRemainingWashingTime(property.edt);
		case EPC_REMAINING_DRYING_TIME : return isValidRemainingDryingTime(property.edt);
		case EPC_ELAPSED_TIME_ON_THE_ON_TIMER : return isValidElapsedTimeOnTheOnTimer(property.edt);
		case EPC_PRESOAKING_TIME_SETTING : return isValidPresoakingTimeSetting(property.edt);
		case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE : return isValidCurrentStageOfWasherAndDryerCycle(property.edt);
		case EPC_WATER_VOLUME_SETTING1 : return isValidWaterVolumeSetting1(property.edt);
		case EPC_WATER_VOLUME_SETTING2 : return isValidWaterVolumeSetting2(property.edt);
		case EPC_WASHING_TIME_SETTING : return isValidWashingTimeSetting(property.edt);
		case EPC_NUMBER_OF_TIMES_OF_RINSING_SETTING : return isValidNumberOfTimesOfRinsingSetting(property.edt);
		case EPC_RINSING_PROCESS_SETTING : return isValidRinsingProcessSetting(property.edt);
		case EPC_SPIN_DRYING_TIME_SETTING : return isValidSpinDryingTimeSetting(property.edt);
		case EPC_DRYING_TIME_SETTING : return isValidDryingTimeSetting(property.edt);
		case EPC_WARM_WATER_SETTING : return isValidWarmWaterSetting(property.edt);
		case EPC_BATHTUB_WATER_RECYCLE_SETTING : return isValidBathtubWaterRecycleSetting(property.edt);
		case EPC_WRINKLING_MINIMIZATION_SETTING : return isValidWrinklingMinimizationSetting(property.edt);
		case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE : return isValidTimeRemainingToCompleteWasherAndDryerCycle(property.edt);
		case EPC_DOOR_COVER_LOCK_SETTING : return isValidDoorCoverLockSetting(property.edt);
		case EPC_WASHER_AND_DRYER_CYCLE : return isValidWasherAndDryerCycle(property.edt);
		case EPC_ON_TIMER_RESERVATION_SETTING : return isValidOnTimerReservationSetting(property.edt);
		case EPC_ON_TIMER_SETTING : return isValidOnTimerSetting(property.edt);
		case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : return isValidRelativeTimeBasedOnTimerSetting(property.edt);
		default : return false;
		}
	}

	@Override
	public Setter set() {
		return set(true);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr(), responseRequired);
	}

	@Override
	public Getter get() {
		return new Getter(getEchoClassCode(), getInstanceCode()
				, getNode().getAddressStr());
	}

	@Override
	public Informer inform() {
		return inform(isSelfObject());
	}

	@Override
	protected Informer inform(boolean multicast) {
		String address;
		if(multicast) {
			address = EchoSocket.MULTICAST_ADDRESS;
		} else {
			address = getNode().getAddressStr();
		}
		return new Informer(getEchoClassCode(), getInstanceCode()
				, address, isSelfObject());
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_WASHER_AND_DRYER_SETTING : 
				onSetWasherAndDryerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : 
				onSetWasherAndDryerCycleSetting1Note1(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : 
				onSetWasherAndDryerCycleSetting2Note1(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_CYCLE_SETTING_NOTE1 : 
				onSetDryingCycleSettingNote1(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_FLOW_RATE_SETTING : 
				onSetWaterFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ROTATION_SPEED_FOR_SPIN_DRYING_SETTING : 
				onSetRotationSpeedForSpinDryingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DEGREE_OF_DRYING_SETTING : 
				onSetDegreeOfDryingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_PRESOAKING_TIME_SETTING : 
				onSetPresoakingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_VOLUME_SETTING1 : 
				onSetWaterVolumeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_VOLUME_SETTING2 : 
				onSetWaterVolumeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHING_TIME_SETTING : 
				onSetWashingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_NUMBER_OF_TIMES_OF_RINSING_SETTING : 
				onSetNumberOfTimesOfRinsingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RINSING_PROCESS_SETTING : 
				onSetRinsingProcessSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPIN_DRYING_TIME_SETTING : 
				onSetSpinDryingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_TIME_SETTING : 
				onSetDryingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WARM_WATER_SETTING : 
				onSetWarmWaterSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHTUB_WATER_RECYCLE_SETTING : 
				onSetBathtubWaterRecycleSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WRINKLING_MINIMIZATION_SETTING : 
				onSetWrinklingMinimizationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DOOR_COVER_LOCK_SETTING : 
				onSetDoorCoverLockSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onSetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onSetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : 
				onSetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}

		@Override
		protected boolean onGetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onGetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_DOOR_COVER_OPEN_CLOSE_STATUS : 
				onGetDoorCoverOpenCloseStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_SETTING : 
				onGetWasherAndDryerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1 : 
				onGetWasherAndDryerCycleSetting1Note1(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1 : 
				onGetWasherAndDryerCycleSetting2Note1(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_CYCLE_SETTING_NOTE1 : 
				onGetDryingCycleSettingNote1(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1 : 
				onGetWasherAndDryerCycleOptionList1(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2 : 
				onGetWasherAndDryerCycleOptionList2(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3 : 
				onGetWasherAndDryerCycleOptionList3(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_FLOW_RATE_SETTING : 
				onGetWaterFlowRateSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ROTATION_SPEED_FOR_SPIN_DRYING_SETTING : 
				onGetRotationSpeedForSpinDryingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DEGREE_OF_DRYING_SETTING : 
				onGetDegreeOfDryingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_WASHING_TIME : 
				onGetRemainingWashingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_DRYING_TIME : 
				onGetRemainingDryingTime(eoj, tid, esv, property, success);
				return true;
			case EPC_ELAPSED_TIME_ON_THE_ON_TIMER : 
				onGetElapsedTimeOnTheOnTimer(eoj, tid, esv, property, success);
				return true;
			case EPC_PRESOAKING_TIME_SETTING : 
				onGetPresoakingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE : 
				onGetCurrentStageOfWasherAndDryerCycle(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_VOLUME_SETTING1 : 
				onGetWaterVolumeSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_WATER_VOLUME_SETTING2 : 
				onGetWaterVolumeSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHING_TIME_SETTING : 
				onGetWashingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_NUMBER_OF_TIMES_OF_RINSING_SETTING : 
				onGetNumberOfTimesOfRinsingSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RINSING_PROCESS_SETTING : 
				onGetRinsingProcessSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SPIN_DRYING_TIME_SETTING : 
				onGetSpinDryingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DRYING_TIME_SETTING : 
				onGetDryingTimeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WARM_WATER_SETTING : 
				onGetWarmWaterSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_BATHTUB_WATER_RECYCLE_SETTING : 
				onGetBathtubWaterRecycleSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WRINKLING_MINIMIZATION_SETTING : 
				onGetWrinklingMinimizationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE : 
				onGetTimeRemainingToCompleteWasherAndDryerCycle(eoj, tid, esv, property, success);
				return true;
			case EPC_DOOR_COVER_LOCK_SETTING : 
				onGetDoorCoverLockSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_WASHER_AND_DRYER_CYCLE : 
				onGetWasherAndDryerCycle(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_RESERVATION_SETTING : 
				onGetOnTimerReservationSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_ON_TIMER_SETTING : 
				onGetOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING : 
				onGetRelativeTimeBasedOnTimerSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetDoorCoverOpenCloseStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWasherAndDryerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying,” “washing” or “drying” mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying course: 0x21.0x3F Washing and drying course maker<br>
		 * original code: 0x40.0x4F<br>
		 * Washing course: 0x61.0x7F Washing course maker original code:<br>
		 * 0x80.0x8F<br>
		 * Drying course: 0xA1.0xBF  Drying course maker original code:<br>
		 * 0xC0.0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying course>  Standard = 0x21, silent = 0x22, heavily<br>
		 * soiled clothes = 0x23, hard-to-remove<br>
		 * stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing course / maker original course<br>
		 * = 0x40.0x4F<br>
		 * <Washing course><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing course / maker original course<br>
		 * = 0x80.0x8F<br>
		 * <Drying course><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank<br>
		 * drying = 0xBF<br>
		 * Drying course / maker original course = 0xC0.0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying,” “washing” or “drying” mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying course: 0x21.0x3F Washing and drying course maker<br>
		 * original code: 0x40.0x4F<br>
		 * Washing course: 0x61.0x7F Washing course maker original code:<br>
		 * 0x80.0x8F<br>
		 * Drying course: 0xA1.0xBF  Drying course maker original code:<br>
		 * 0xC0.0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying course>  Standard = 0x21, silent = 0x22, heavily<br>
		 * soiled clothes = 0x23, hard-to-remove<br>
		 * stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing course / maker original course<br>
		 * = 0x40.0x4F<br>
		 * <Washing course><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing course / maker original course<br>
		 * = 0x80.0x8F<br>
		 * <Drying course><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank<br>
		 * drying = 0xBF<br>
		 * Drying course / maker original course = 0xC0.0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleSetting1Note1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying” mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the “drying cycle setting” property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0.0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing<br>
		 * = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly<br>
		 * soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank<br>
		 * cleaning = 0x3F<br>
		 * Maker original course = 0xE0.0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying” mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the “drying cycle setting” property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0.0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing<br>
		 * = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly<br>
		 * soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank<br>
		 * cleaning = 0x3F<br>
		 * Maker original course = 0xE0.0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleSetting2Note1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the “washing and drying” mode, the “washer and dryer cycle setting 2” property (EPC = 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts =  0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time<br>
		 * = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank<br>
		 * drying = 0xBF<br>
		 * Maker original course = 0xE0 0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDryingCycleSettingNote1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the “washing and drying” mode, the “washer and dryer cycle setting 2” property (EPC = 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts =  0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time<br>
		 * = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank<br>
		 * drying = 0xBF<br>
		 * Maker original course = 0xE0 0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDryingCycleSettingNote1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle option list 1<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 1” property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsig ned
char
×12,<br>
		 * <br>
		 * Data size : 12
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleOptionList1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle option list 2<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 2” property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsig ned
char
×4,<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleOptionList2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle option list 3<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the “drying cycle setting” property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired drying cycle option is “1”, the option can be specified. When the value contained in the bit for the desired drying cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsig ned
char
×4,<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycleOptionList3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting> 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWaterFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting> 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWaterFlowRateSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Rotation speed for spin drying” setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000. 0x0FFF (0.4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA7FF (1.2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC7FF (1.2048r/min.)<br>
		 * <br>
		 * Data type : unsig ned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRotationSpeedForSpinDryingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Rotation speed for spin drying” setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000. 0x0FFF (0.4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA7FF (1.2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC7FF (1.2048r/min.)<br>
		 * <br>
		 * Data type : unsig ned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRotationSpeedForSpinDryingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Degree of drying” setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDegreeOfDryingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Degree of drying” setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDegreeOfDryingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining washing time<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining washing time<br>
		 * in the “HH:MM” format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFE : 0.0x3B<br>
		 * (=0-254) hours : (=0-59) minutes Remaining time unknown=0xFF :<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsign ed
char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRemainingWashingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining drying time<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining drying<br>
		 * time in the “HH:MM” format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFE : 0.0x3B<br>
		 * (=0.254) hours : (=0.59) minutes Remaining time unknown=0xFF :<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsign ed
char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRemainingDryingTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Elapsed time on the ON timer<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsign ed
char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : Hour minu
tes<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetElapsedTimeOnTheOnTimer(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsign ed char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : h,mi n<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetPresoakingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsign ed char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : h,mi n<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetPresoakingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Current stage of washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current stage of the washer and dryer cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44<br>
		 * Washing completed = 0x45<br>
		 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
		 * Drying = 0x52<br>
		 * Wrinkling minimization = 0x53 Drying (with wrinkling<br>
		 * minimization) completed = 0x54<br>
		 * Standing by to start = 0x61 1st rinsing = 0x71<br>
		 * 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78<br>
		 * 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88<br>
		 * Preheat spin drying = 0x91<br>
		 * Unique code defined by the manufacture = 0xE0.0xEF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetCurrentStageOfWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x7F (0.127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF (1.32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x7F (0.127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF (1.32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWaterVolumeSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1. 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1. 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWaterVolumeSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWashingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWashingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Number of times of rinsing” setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.8 times (0x00.0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetNumberOfTimesOfRinsingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Number of times of rinsing” setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.8 times (0x00.0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetNumberOfTimesOfRinsingSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
×4<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRinsingProcessSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
×4<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRinsingProcessSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x3B (0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF: 1.32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSpinDryingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x3B (0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF: 1.32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSpinDryingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDryingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDryingTimeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in .C and to acquire the current  setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.100°C (0x00.0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWarmWaterSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in .C and to acquire the current  setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.100°C (0x00.0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWarmWaterSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40 Washing only                     : 0x41 Rinsing only (excluding the final<br>
		 * rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43 Washing + rinsing (excluding the<br>
		 * final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetBathtubWaterRecycleSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40 Washing only                     : 0x41 Rinsing only (excluding the final<br>
		 * rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43 Washing + rinsing (excluding the<br>
		 * final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetBathtubWaterRecycleSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function ON                  : 0x41<br>
		 * Wrinkling minimization function OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetWrinklingMinimizationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function ON                  : 0x41<br>
		 * Wrinkling minimization function OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetWrinklingMinimizationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Time remaining to complete washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time remaining to complete the current washer and dryer cycle in the “HH: MM” format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFE: 0.0x3B<br>
		 * (= 0.254 hours): (= 0.59 minutes) Remaining time unknown = 0xFF:<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetTimeRemainingToCompleteWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDoorCoverLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDoorCoverLockSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current washer and dryer cycle setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bytes 1 and 2: This property indicates the available<br>
		 * items in a bitmap format.<br>
		 * Byte 3: Presoaking With presoaking: 0x41<br>
		 * Without presoaking: 0x42<br>
		 * Bytes 4 and 5: Washing time The value of the “washing time<br>
		 * setting” property shall be referenced.<br>
		 * Byte 6: Number of times of rinsing The value of the “’number of times of<br>
		 * rinsing’ setting” property shall be referenced.<br>
		 * Bytes 7 through 10: Rinsing process The value of the “rinsing process setting” property shall be referenced.<br>
		 * Byte 11: Spin drying time<br>
		 * The value of the “spin drying time setting” property shall be referenced.<br>
		 * Bytes 12 and 13: Drying time<br>
		 * The value of the 'drying time setting” property shall be referenced.<br>
		 * Byte 14: Warm water setting The value of the “warm water<br>
		 * setting” property shall be referenced.<br>
		 * Byte 15: Water volume setting 1 The value of the “water volume setting 1” property shall be referenced.<br>
		 * Byte 16: Water volume setting 2 The value of the “water volume setting 2” property shall be referenced.<br>
		 * Byte 17: Bathtub water recycle setting<br>
		 * The value of the “bathtub water recycle setting” property shall be referenced.<br>
		 * Byte 18: Water flow rate setting The value of the “water flow rate<br>
		 * setting” property shall be referenced.<br>
		 * Bytes 19 and 20: “Rotation speed for spin drying” setting<br>
		 * The value of the “’rotation speed for spin drying’ setting” property shall be referenced.<br>
		 * Byte 21: “Degree of drying” setting The value of the “’degree of drying’ setting” property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
		 * The value of the “presoaking time setting” property shall be referenced. Byte 24: Wrinkling minimization setting<br>
		 * The value of the “wrinkling minimization setting” property shall<br>
		 * be referenced.<br>
		 * <br>
		 * Data type : unsigned Char
×24<br>
		 * <br>
		 * Data size : 24
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetWasherAndDryerCycle(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerReservationSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetRelativeTimeBasedOnTimerSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress, boolean responseRequired) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress, responseRequired);
		}
		
		@Override
		public Setter reqSetProperty(byte epc, byte[] edt) {
			return (Setter)super.reqSetProperty(epc, edt);
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
		public Setter reqSetRemoteControlSetting(byte[] edt) {
			return (Setter)super.reqSetRemoteControlSetting(edt);
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
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWasherAndDryerSetting(byte[] edt) {
			reqSetProperty(EPC_WASHER_AND_DRYER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying,” “washing” or “drying” mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying course: 0x21.0x3F Washing and drying course maker<br>
		 * original code: 0x40.0x4F<br>
		 * Washing course: 0x61.0x7F Washing course maker original code:<br>
		 * 0x80.0x8F<br>
		 * Drying course: 0xA1.0xBF  Drying course maker original code:<br>
		 * 0xC0.0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying course>  Standard = 0x21, silent = 0x22, heavily<br>
		 * soiled clothes = 0x23, hard-to-remove<br>
		 * stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing course / maker original course<br>
		 * = 0x40.0x4F<br>
		 * <Washing course><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing course / maker original course<br>
		 * = 0x80.0x8F<br>
		 * <Drying course><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank<br>
		 * drying = 0xBF<br>
		 * Drying course / maker original course = 0xC0.0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWasherAndDryerCycleSetting1Note1(byte[] edt) {
			reqSetProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1, edt);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying” mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the “drying cycle setting” property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0.0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing<br>
		 * = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly<br>
		 * soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank<br>
		 * cleaning = 0x3F<br>
		 * Maker original course = 0xE0.0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWasherAndDryerCycleSetting2Note1(byte[] edt) {
			reqSetProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1, edt);
			return this;
		}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the “washing and drying” mode, the “washer and dryer cycle setting 2” property (EPC = 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts =  0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time<br>
		 * = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank<br>
		 * drying = 0xBF<br>
		 * Maker original course = 0xE0 0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDryingCycleSettingNote1(byte[] edt) {
			reqSetProperty(EPC_DRYING_CYCLE_SETTING_NOTE1, edt);
			return this;
		}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting> 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWaterFlowRateSetting(byte[] edt) {
			reqSetProperty(EPC_WATER_FLOW_RATE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Rotation speed for spin drying” setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000. 0x0FFF (0.4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA7FF (1.2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC7FF (1.2048r/min.)<br>
		 * <br>
		 * Data type : unsig ned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRotationSpeedForSpinDryingSetting(byte[] edt) {
			reqSetProperty(EPC_ROTATION_SPEED_FOR_SPIN_DRYING_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Degree of drying” setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDegreeOfDryingSetting(byte[] edt) {
			reqSetProperty(EPC_DEGREE_OF_DRYING_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsign ed char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : h,mi n<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetPresoakingTimeSetting(byte[] edt) {
			reqSetProperty(EPC_PRESOAKING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x7F (0.127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF (1.32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWaterVolumeSetting1(byte[] edt) {
			reqSetProperty(EPC_WATER_VOLUME_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1. 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWaterVolumeSetting2(byte[] edt) {
			reqSetProperty(EPC_WATER_VOLUME_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWashingTimeSetting(byte[] edt) {
			reqSetProperty(EPC_WASHING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Number of times of rinsing” setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.8 times (0x00.0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetNumberOfTimesOfRinsingSetting(byte[] edt) {
			reqSetProperty(EPC_NUMBER_OF_TIMES_OF_RINSING_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
×4<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRinsingProcessSetting(byte[] edt) {
			reqSetProperty(EPC_RINSING_PROCESS_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x3B (0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF: 1.32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSpinDryingTimeSetting(byte[] edt) {
			reqSetProperty(EPC_SPIN_DRYING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDryingTimeSetting(byte[] edt) {
			reqSetProperty(EPC_DRYING_TIME_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in .C and to acquire the current  setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.100°C (0x00.0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWarmWaterSetting(byte[] edt) {
			reqSetProperty(EPC_WARM_WATER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40 Washing only                     : 0x41 Rinsing only (excluding the final<br>
		 * rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43 Washing + rinsing (excluding the<br>
		 * final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetBathtubWaterRecycleSetting(byte[] edt) {
			reqSetProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function ON                  : 0x41<br>
		 * Wrinkling minimization function OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetWrinklingMinimizationSetting(byte[] edt) {
			reqSetProperty(EPC_WRINKLING_MINIMIZATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDoorCoverLockSetting(byte[] edt) {
			reqSetProperty(EPC_DOOR_COVER_LOCK_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerReservationSetting(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_RESERVATION_SETTING, edt);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetOnTimerSetting(byte[] edt) {
			reqSetProperty(EPC_ON_TIMER_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetRelativeTimeBasedOnTimerSetting(byte[] edt) {
			reqSetProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(short dstEchoClassCode, byte dstEchoInstanceCode
				, String dstEchoAddress) {
			super(dstEchoClassCode, dstEchoInstanceCode
					, dstEchoAddress);
		}
		
		@Override
		public Getter reqGetProperty(byte epc) {
			return (Getter)super.reqGetProperty(epc);
		}
		
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
		public Getter reqGetRemoteControlSetting() {
			return (Getter)super.reqGetRemoteControlSetting();
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
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDoorCoverOpenCloseStatus() {
			reqGetProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerSetting() {
			reqGetProperty(EPC_WASHER_AND_DRYER_SETTING);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying,” “washing” or “drying” mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying course: 0x21.0x3F Washing and drying course maker<br>
		 * original code: 0x40.0x4F<br>
		 * Washing course: 0x61.0x7F Washing course maker original code:<br>
		 * 0x80.0x8F<br>
		 * Drying course: 0xA1.0xBF  Drying course maker original code:<br>
		 * 0xC0.0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying course>  Standard = 0x21, silent = 0x22, heavily<br>
		 * soiled clothes = 0x23, hard-to-remove<br>
		 * stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing course / maker original course<br>
		 * = 0x40.0x4F<br>
		 * <Washing course><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing course / maker original course<br>
		 * = 0x80.0x8F<br>
		 * <Drying course><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank<br>
		 * drying = 0xBF<br>
		 * Drying course / maker original course = 0xC0.0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleSetting1Note1() {
			reqGetProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying” mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the “drying cycle setting” property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0.0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing<br>
		 * = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly<br>
		 * soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank<br>
		 * cleaning = 0x3F<br>
		 * Maker original course = 0xE0.0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleSetting2Note1() {
			reqGetProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1);
			return this;
		}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the “washing and drying” mode, the “washer and dryer cycle setting 2” property (EPC = 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts =  0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time<br>
		 * = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank<br>
		 * drying = 0xBF<br>
		 * Maker original course = 0xE0 0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDryingCycleSettingNote1() {
			reqGetProperty(EPC_DRYING_CYCLE_SETTING_NOTE1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 1<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 1” property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsig ned
char
×12,<br>
		 * <br>
		 * Data size : 12
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleOptionList1() {
			reqGetProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 2<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 2” property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsig ned
char
×4,<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleOptionList2() {
			reqGetProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 3<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the “drying cycle setting” property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired drying cycle option is “1”, the option can be specified. When the value contained in the bit for the desired drying cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsig ned
char
×4,<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycleOptionList3() {
			reqGetProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3);
			return this;
		}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting> 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWaterFlowRateSetting() {
			reqGetProperty(EPC_WATER_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : “Rotation speed for spin drying” setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000. 0x0FFF (0.4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA7FF (1.2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC7FF (1.2048r/min.)<br>
		 * <br>
		 * Data type : unsig ned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRotationSpeedForSpinDryingSetting() {
			reqGetProperty(EPC_ROTATION_SPEED_FOR_SPIN_DRYING_SETTING);
			return this;
		}
		/**
		 * Property name : “Degree of drying” setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDegreeOfDryingSetting() {
			reqGetProperty(EPC_DEGREE_OF_DRYING_SETTING);
			return this;
		}
		/**
		 * Property name : Remaining washing time<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining washing time<br>
		 * in the “HH:MM” format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFE : 0.0x3B<br>
		 * (=0-254) hours : (=0-59) minutes Remaining time unknown=0xFF :<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsign ed
char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRemainingWashingTime() {
			reqGetProperty(EPC_REMAINING_WASHING_TIME);
			return this;
		}
		/**
		 * Property name : Remaining drying time<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining drying<br>
		 * time in the “HH:MM” format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFE : 0.0x3B<br>
		 * (=0.254) hours : (=0.59) minutes Remaining time unknown=0xFF :<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsign ed
char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRemainingDryingTime() {
			reqGetProperty(EPC_REMAINING_DRYING_TIME);
			return this;
		}
		/**
		 * Property name : Elapsed time on the ON timer<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsign ed
char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : Hour minu
tes<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetElapsedTimeOnTheOnTimer() {
			reqGetProperty(EPC_ELAPSED_TIME_ON_THE_ON_TIMER);
			return this;
		}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsign ed char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : h,mi n<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetPresoakingTimeSetting() {
			reqGetProperty(EPC_PRESOAKING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Current stage of washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current stage of the washer and dryer cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44<br>
		 * Washing completed = 0x45<br>
		 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
		 * Drying = 0x52<br>
		 * Wrinkling minimization = 0x53 Drying (with wrinkling<br>
		 * minimization) completed = 0x54<br>
		 * Standing by to start = 0x61 1st rinsing = 0x71<br>
		 * 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78<br>
		 * 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88<br>
		 * Preheat spin drying = 0x91<br>
		 * Unique code defined by the manufacture = 0xE0.0xEF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetCurrentStageOfWasherAndDryerCycle() {
			reqGetProperty(EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x7F (0.127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF (1.32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWaterVolumeSetting1() {
			reqGetProperty(EPC_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1. 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWaterVolumeSetting2() {
			reqGetProperty(EPC_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWashingTimeSetting() {
			reqGetProperty(EPC_WASHING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : “Number of times of rinsing” setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.8 times (0x00.0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetNumberOfTimesOfRinsingSetting() {
			reqGetProperty(EPC_NUMBER_OF_TIMES_OF_RINSING_SETTING);
			return this;
		}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
×4<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRinsingProcessSetting() {
			reqGetProperty(EPC_RINSING_PROCESS_SETTING);
			return this;
		}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x3B (0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF: 1.32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSpinDryingTimeSetting() {
			reqGetProperty(EPC_SPIN_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDryingTimeSetting() {
			reqGetProperty(EPC_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in .C and to acquire the current  setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.100°C (0x00.0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWarmWaterSetting() {
			reqGetProperty(EPC_WARM_WATER_SETTING);
			return this;
		}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40 Washing only                     : 0x41 Rinsing only (excluding the final<br>
		 * rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43 Washing + rinsing (excluding the<br>
		 * final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetBathtubWaterRecycleSetting() {
			reqGetProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING);
			return this;
		}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function ON                  : 0x41<br>
		 * Wrinkling minimization function OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWrinklingMinimizationSetting() {
			reqGetProperty(EPC_WRINKLING_MINIMIZATION_SETTING);
			return this;
		}
		/**
		 * Property name : Time remaining to complete washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time remaining to complete the current washer and dryer cycle in the “HH: MM” format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFE: 0.0x3B<br>
		 * (= 0.254 hours): (= 0.59 minutes) Remaining time unknown = 0xFF:<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTimeRemainingToCompleteWasherAndDryerCycle() {
			reqGetProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDoorCoverLockSetting() {
			reqGetProperty(EPC_DOOR_COVER_LOCK_SETTING);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current washer and dryer cycle setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bytes 1 and 2: This property indicates the available<br>
		 * items in a bitmap format.<br>
		 * Byte 3: Presoaking With presoaking: 0x41<br>
		 * Without presoaking: 0x42<br>
		 * Bytes 4 and 5: Washing time The value of the “washing time<br>
		 * setting” property shall be referenced.<br>
		 * Byte 6: Number of times of rinsing The value of the “’number of times of<br>
		 * rinsing’ setting” property shall be referenced.<br>
		 * Bytes 7 through 10: Rinsing process The value of the “rinsing process setting” property shall be referenced.<br>
		 * Byte 11: Spin drying time<br>
		 * The value of the “spin drying time setting” property shall be referenced.<br>
		 * Bytes 12 and 13: Drying time<br>
		 * The value of the 'drying time setting” property shall be referenced.<br>
		 * Byte 14: Warm water setting The value of the “warm water<br>
		 * setting” property shall be referenced.<br>
		 * Byte 15: Water volume setting 1 The value of the “water volume setting 1” property shall be referenced.<br>
		 * Byte 16: Water volume setting 2 The value of the “water volume setting 2” property shall be referenced.<br>
		 * Byte 17: Bathtub water recycle setting<br>
		 * The value of the “bathtub water recycle setting” property shall be referenced.<br>
		 * Byte 18: Water flow rate setting The value of the “water flow rate<br>
		 * setting” property shall be referenced.<br>
		 * Bytes 19 and 20: “Rotation speed for spin drying” setting<br>
		 * The value of the “’rotation speed for spin drying’ setting” property shall be referenced.<br>
		 * Byte 21: “Degree of drying” setting The value of the “’degree of drying’ setting” property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
		 * The value of the “presoaking time setting” property shall be referenced. Byte 24: Wrinkling minimization setting<br>
		 * The value of the “wrinkling minimization setting” property shall<br>
		 * be referenced.<br>
		 * <br>
		 * Data type : unsigned Char
×24<br>
		 * <br>
		 * Data size : 24
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetWasherAndDryerCycle() {
			reqGetProperty(EPC_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerReservationSetting() {
			reqGetProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetOnTimerSetting() {
			reqGetProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRelativeTimeBasedOnTimerSetting() {
			reqGetProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(short echoClassCode, byte echoInstanceCode
				, String dstEchoAddress, boolean isSelfObject) {
			super(echoClassCode, echoInstanceCode
					, dstEchoAddress, isSelfObject);
		}
		
		@Override
		public Informer reqInformProperty(byte epc) {
			return (Informer)super.reqInformProperty(epc);
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
		public Informer reqInformRemoteControlSetting() {
			return (Informer)super.reqInformRemoteControlSetting();
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
		
		/**
		 * Property name : Door/cover open/close status<br>
		 * <br>
		 * EPC : 0xB0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the status of the door/cover (i.e. open or closed).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Door/cover open = 0x41 Door/cover closed = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDoorCoverOpenCloseStatus() {
			reqInformProperty(EPC_DOOR_COVER_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Washer and dryer setting<br>
		 * <br>
		 * EPC : 0xB2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether to start or stop the washing, drying or washing and drying cycle, and to acquire the current status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Start/restart(ed) or in progress = 0x41 Suspend(ed) = 0x42<br>
		 * Stop(ped) = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerSetting() {
			reqInformProperty(EPC_WASHER_AND_DRYER_SETTING);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 1
(Note 1)<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying,” “washing” or “drying” mode and to acquire the current setting(s). The value ranges shall be as follows:<br>
		 * Washing and drying course: 0x21.0x3F Washing and drying course maker<br>
		 * original code: 0x40.0x4F<br>
		 * Washing course: 0x61.0x7F Washing course maker original code:<br>
		 * 0x80.0x8F<br>
		 * Drying course: 0xA1.0xBF  Drying course maker original code:<br>
		 * 0xC0.0xDF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Washing and drying course>  Standard = 0x21, silent = 0x22, heavily<br>
		 * soiled clothes = 0x23, hard-to-remove<br>
		 * stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing = 0x29, ironing/business shirts = 0x2A, hang drying = 0x2B, thick clothes = 0x2C, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly soiled clothes = 0x31, quick wash of small amount of laundry<br>
		 * = 0x32<br>
		 * Washing course / maker original course<br>
		 * = 0x40.0x4F<br>
		 * <Washing course><br>
		 * Standard = 0x61, silent = 0x62, heavily soiled clothes = 0x63, hard-to-remove stains = 0x64, presoaking = 0x65, blankets = 0x66, soft = 0x67, dry = 0x68, clean rinsing = 0x69, disinfection<br>
		 * = 0x6A, oil stains = 0x6B, memory = 0x6C, detergent saving = 0x6D, lightly soiled clothes = 0x6E, quick wash of small amount of laundry = 0x6F, tank cleaning = 0x7F<br>
		 * Washing course / maker original course<br>
		 * = 0x80.0x8F<br>
		 * <Drying course><br>
		 * Standard = 0xA1, blankets = 0xA2, soft<br>
		 * = 0xA3, dry = 0xA4, ironing/business shirts = 0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time = 0xAC, garment warming = 0xAD, tank<br>
		 * drying = 0xBF<br>
		 * Drying course / maker original course = 0xC0.0xCF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleSetting1Note1() {
			reqInformProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING1_NOTE1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle setting 2 (Note
1)<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the washer and dryer cycle option(s) to use in the “washing and drying” mode, and to acquire the current setting(s). The drying option(s) to use shall be specified with the “drying cycle setting” property (EPC = 0xD2).<br>
		 * Maker original code = 0xE0.0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No washing = 0x20, standard = 0x21, silent = 0x22, heavily soiled clothes = 0x23, hard-to-remove stains = 0x24, presoaking = 0x25, blankets = 0x26, soft = 0x27, dry = 0x28, clean rinsing<br>
		 * = 0x29, disinfection = 0x2D, oil stains = 0x2E, memory = 0x2F, detergent saving = 0x30, lightly<br>
		 * soiled clothes = 0x31, quick wash of small amount of laundry = 0x32, tank<br>
		 * cleaning = 0x3F<br>
		 * Maker original course = 0xE0.0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleSetting2Note1() {
			reqInformProperty(EPC_WASHER_AND_DRYER_CYCLE_SETTING2_NOTE1);
			return this;
		}
		/**
		 * Property name : Drying cycle setting (Note1)<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the drying cycle option(s) to use, and to acquire the current setting. For the “washing and drying” mode, the “washer and dryer cycle setting 2” property (EPC = 0xD1) shall be used.<br>
		 * Maker original code = 0xE0 to 0xEF<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * No drying = 0xA0, standard = 0xA1, blankets = 0xA2, soft = 0xA3, dry = 0xA4, ironing/business shirts =  0xA5, hang drying = 0xA6, thick clothes = 0xA7, disinfection = 0xA8, shrinkage minimization = 0xA9, finishing = 0xAA, stationary drying = 0xAB, user definition of drying time<br>
		 * = 0xAC, garment warming = 0xAD, heater current limit = 0xAE, tank<br>
		 * drying = 0xBF<br>
		 * Maker original course = 0xE0 0xEF<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDryingCycleSettingNote1() {
			reqInformProperty(EPC_DRYING_CYCLE_SETTING_NOTE1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 1<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 1” property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsig ned
char
×12,<br>
		 * <br>
		 * Data size : 12
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleOptionList1() {
			reqInformProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST1);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 2<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the washer and dryer cycle options that can be specified with the “washer and dryer cycle setting 2” property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired washer and dryer cycle option is “1”, the option can be specified. When the value contained in the bit for the desired washer and dryer cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsig ned
char
×4,<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleOptionList2() {
			reqInformProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST2);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle option list 3<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire a bitmap list of the drying cycle options that can be specified with the “drying cycle setting” property.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * When the value contained in the bit for the desired drying cycle option is “1”, the option can be specified. When the value contained in the bit for the desired drying cycle option is “0”, the option cannot be specified. For the requirement as to which bit must be used for which option, refer to the detailed explanation.<br>
		 * <br>
		 * Data type : unsig ned
char
×4,<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycleOptionList3() {
			reqInformProperty(EPC_WASHER_AND_DRYER_CYCLE_OPTION_LIST3);
			return this;
		}
		/**
		 * Property name : Water flow rate setting<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water flow rate by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting> 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest flow rates, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWaterFlowRateSetting() {
			reqInformProperty(EPC_WATER_FLOW_RATE_SETTING);
			return this;
		}
		/**
		 * Property name : “Rotation speed for spin drying” setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rotation speed for spin drying in r/min. and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x0000. 0x0FFF (0.4095 r/min.)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFFFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA7FF (1.2048 r/min.)<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC7FF (1.2048r/min.)<br>
		 * <br>
		 * Data type : unsig ned short<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRotationSpeedForSpinDryingSetting() {
			reqInformProperty(EPC_ROTATION_SPEED_FOR_SPIN_DRYING_SETTING);
			return this;
		}
		/**
		 * Property name : “Degree of drying” setting<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the degree of drying to achieve by selecting a level from among the 16 predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * * 0x31 and 0x40 shall be used for the lowest and highest levels, respectively.<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1.8<br>
		 * <br>
		 * Data type : unsig ned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDegreeOfDryingSetting() {
			reqInformProperty(EPC_DEGREE_OF_DRYING_SETTING);
			return this;
		}
		/**
		 * Property name : Remaining washing time<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining washing time<br>
		 * in the “HH:MM” format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFE : 0.0x3B<br>
		 * (=0-254) hours : (=0-59) minutes Remaining time unknown=0xFF :<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsign ed
char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRemainingWashingTime() {
			reqInformProperty(EPC_REMAINING_WASHING_TIME);
			return this;
		}
		/**
		 * Property name : Remaining drying time<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * Acquires the remaining drying<br>
		 * time in the “HH:MM” format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFE : 0.0x3B<br>
		 * (=0.254) hours : (=0.59) minutes Remaining time unknown=0xFF :<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsign ed
char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRemainingDryingTime() {
			reqInformProperty(EPC_REMAINING_DRYING_TIME);
			return this;
		}
		/**
		 * Property name : Elapsed time on the ON timer<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time elapsed on the ON timer after the ON timer was activated.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsign ed
char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : Hour minu
tes<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformElapsedTimeOnTheOnTimer() {
			reqInformProperty(EPC_ELAPSED_TIME_ON_THE_ON_TIMER);
			return this;
		}
		/**
		 * Property name : Presoaking time setting<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the presoaking process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * <Relative setting relative to the automatic setting><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsign ed char
×2<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : h,mi n<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformPresoakingTimeSetting() {
			reqInformProperty(EPC_PRESOAKING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Current stage of washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current stage of the washer and dryer cycle.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Washing = 0x41 Rinsing = 0x42 Spin drying = 0x43 Suspended = 0x44<br>
		 * Washing completed = 0x45<br>
		 * Washing/drying (without wrinkling minimization) completed = 0x51<br>
		 * Drying = 0x52<br>
		 * Wrinkling minimization = 0x53 Drying (with wrinkling<br>
		 * minimization) completed = 0x54<br>
		 * Standing by to start = 0x61 1st rinsing = 0x71<br>
		 * 2nd rinsing = 0x72 3rd rinsing = 0x73 4th rinsing = 0x74 5th rinsing = 0x75 6th rinsing = 0x76 7th rinsing = 0x77 8th rinsing = 0x78<br>
		 * 1st spin drying = 0x81 2nd spin drying = 0x82 3rd spin drying = 0x83 4th spin drying = 0x84 5th spin drying = 0x85 6th spin drying = 0x86 7th spin drying = 0x87 8th spin drying = 0x88<br>
		 * Preheat spin drying = 0x91<br>
		 * Unique code defined by the manufacture = 0xE0.0xEF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformCurrentStageOfWasherAndDryerCycle() {
			reqInformProperty(EPC_CURRENT_STAGE_OF_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : Water volume setting 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume in liters and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x7F (0.127 liters)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 liters<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF (1.32 liters)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWaterVolumeSetting1() {
			reqInformProperty(EPC_WATER_VOLUME_SETTING1);
			return this;
		}
		/**
		 * Property name : Water volume setting 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the water volume by selecting a level from among the predefined levels and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x31.0x40 (16 levels)<br>
		 * - 0x31 and 0x40 shall be used for the lowest and highest water levels, respectively.<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xA7: Levels 1.8<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xC7: Levels 1. 8<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWaterVolumeSetting2() {
			reqInformProperty(EPC_WATER_VOLUME_SETTING2);
			return this;
		}
		/**
		 * Property name : Washing time setting<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the washing process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * Relative setting in the negative direction<br>
		 * - 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWashingTimeSetting() {
			reqInformProperty(EPC_WASHING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : “Number of times of rinsing” setting<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the number of times of rinsing and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.8 times (0x00.0x08)<br>
		 * Automatic = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformNumberOfTimesOfRinsingSetting() {
			reqInformProperty(EPC_NUMBER_OF_TIMES_OF_RINSING_SETTING);
			return this;
		}
		/**
		 * Property name : Rinsing process setting<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the rinsing process(es) to use by means of a bitmap, and to acquire the current setting. Four bits are used to represent each rinsing process as follows:<br>
		 * Bits 0 through bit 3: 1st rinsing Bits 4 through bit 7: 2nd rinsing Bits 8 through bit 11: 3rd rinsing Bits 12 through bit 15: 4th rinsing Bits 16 through bit 19: 5th rinsing Bits 20 through bit 23: 6th rinsing Bits 24 through bit 27: 7th rinsing Bits 28 through bit 31: 8th rinsing<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0000: Automatic mode<br>
		 * 0001: Rinsing without additional feeding of water from the tap<br>
		 * 0010: Rinsing with additional feeding of water from the tap<br>
		 * 0011: Shower rinsing<br>
		 * <br>
		 * Data type : unsigned char
×4<br>
		 * <br>
		 * Data size : 4
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRinsingProcessSetting() {
			reqInformProperty(EPC_RINSING_PROCESS_SETTING);
			return this;
		}
		/**
		 * Property name : Spin drying time setting<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the spin drying process in minutes and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x3B (0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA0.0xBF: 1.32 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC0.0xDF: 1.32 minute<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSpinDryingTimeSetting() {
			reqInformProperty(EPC_SPIN_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Drying time setting<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the duration of the drying process and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * <Absolute setting><br>
		 * - 0x00.0x17: 0x00.0x3B<br>
		 * (= 0.23 hours): (= 0.59 minutes)<br>
		 * < Relative setting relative to the automatic setting ><br>
		 * - Automatic setting 0xFF: 0xFF<br>
		 * - Relative setting in the positive direction<br>
		 * 0xA000.0xA03B: 1.60 minutes<br>
		 * - Relative setting in the negative direction<br>
		 * 0xC000.0xC03B: 1.60 minutes<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : h,min<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDryingTimeSetting() {
			reqInformProperty(EPC_DRYING_TIME_SETTING);
			return this;
		}
		/**
		 * Property name : Warm water setting<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the temperature of laundry water in .C and to acquire the current  setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.100°C (0x00.0x64)<br>
		 * Not to use warm water = 0xFE Automatic water temperature setting<br>
		 * = 0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : .C<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWarmWaterSetting() {
			reqInformProperty(EPC_WARM_WATER_SETTING);
			return this;
		}
		/**
		 * Property name : Bathtub water recycle setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not, and when, to recycle used bathtub water, and acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bathtub water not used   : 0x40 Washing only                     : 0x41 Rinsing only (excluding the final<br>
		 * rinsing)                               : 0x42<br>
		 * All rinsing processes        : 0x43 Washing + rinsing (excluding the<br>
		 * final rinsing)                       : 0x44<br>
		 * Washing + all rinsing<br>
		 * processes                            : 0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformBathtubWaterRecycleSetting() {
			reqInformProperty(EPC_BATHTUB_WATER_RECYCLE_SETTING);
			return this;
		}
		/**
		 * Property name : Wrinkling minimization setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the wrinkling minimization function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Wrinkling minimization function ON                  : 0x41<br>
		 * Wrinkling minimization function OFF                : 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWrinklingMinimizationSetting() {
			reqInformProperty(EPC_WRINKLING_MINIMIZATION_SETTING);
			return this;
		}
		/**
		 * Property name : Time remaining to complete washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the time remaining to complete the current washer and dryer cycle in the “HH: MM” format.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFE: 0.0x3B<br>
		 * (= 0.254 hours): (= 0.59 minutes) Remaining time unknown = 0xFF:<br>
		 * 0xFF<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTimeRemainingToCompleteWasherAndDryerCycle() {
			reqInformProperty(EPC_TIME_REMAINING_TO_COMPLETE_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : Door/cover lock    setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the state of the door/cover lock during operation and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Locked: 0x41<br>
		 * Unlocked: 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDoorCoverLockSetting() {
			reqInformProperty(EPC_DOOR_COVER_LOCK_SETTING);
			return this;
		}
		/**
		 * Property name : Washer and dryer cycle<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to acquire the current washer and dryer cycle setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Bytes 1 and 2: This property indicates the available<br>
		 * items in a bitmap format.<br>
		 * Byte 3: Presoaking With presoaking: 0x41<br>
		 * Without presoaking: 0x42<br>
		 * Bytes 4 and 5: Washing time The value of the “washing time<br>
		 * setting” property shall be referenced.<br>
		 * Byte 6: Number of times of rinsing The value of the “’number of times of<br>
		 * rinsing’ setting” property shall be referenced.<br>
		 * Bytes 7 through 10: Rinsing process The value of the “rinsing process setting” property shall be referenced.<br>
		 * Byte 11: Spin drying time<br>
		 * The value of the “spin drying time setting” property shall be referenced.<br>
		 * Bytes 12 and 13: Drying time<br>
		 * The value of the 'drying time setting” property shall be referenced.<br>
		 * Byte 14: Warm water setting The value of the “warm water<br>
		 * setting” property shall be referenced.<br>
		 * Byte 15: Water volume setting 1 The value of the “water volume setting 1” property shall be referenced.<br>
		 * Byte 16: Water volume setting 2 The value of the “water volume setting 2” property shall be referenced.<br>
		 * Byte 17: Bathtub water recycle setting<br>
		 * The value of the “bathtub water recycle setting” property shall be referenced.<br>
		 * Byte 18: Water flow rate setting The value of the “water flow rate<br>
		 * setting” property shall be referenced.<br>
		 * Bytes 19 and 20: “Rotation speed for spin drying” setting<br>
		 * The value of the “’rotation speed for spin drying’ setting” property shall be referenced.<br>
		 * Byte 21: “Degree of drying” setting The value of the “’degree of drying’ setting” property shall be referenced. Bytes 22 and 23: Presoaking time setting<br>
		 * The value of the “presoaking time setting” property shall be referenced. Byte 24: Wrinkling minimization setting<br>
		 * The value of the “wrinkling minimization setting” property shall<br>
		 * be referenced.<br>
		 * <br>
		 * Data type : unsigned Char
×24<br>
		 * <br>
		 * Data size : 24
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformWasherAndDryerCycle() {
			reqInformProperty(EPC_WASHER_AND_DRYER_CYCLE);
			return this;
		}
		/**
		 * Property name : ON timer reservation setting<br>
		 * <br>
		 * EPC : 0x90<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify whether or not to use the ON timer-based reservation function, and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reservation ON = 0x41, reservation OFF = 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerReservationSetting() {
			reqInformProperty(EPC_ON_TIMER_RESERVATION_SETTING);
			return this;
		}
		/**
		 * Property name : ON timer setting<br>
		 * <br>
		 * EPC : 0x91<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the time for the time-based reservation function of the ON timer and to acquire the current setting.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x17: 0.0x3B (= 0.23): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformOnTimerSetting() {
			reqInformProperty(EPC_ON_TIMER_SETTING);
			return this;
		}
		/**
		 * Property name : Relative time-based ON timer setting<br>
		 * <br>
		 * EPC : 0x92<br>
		 * <br>
		 * Contents of property :<br>
		 * Used to specify the relative time for the relative time-based reservation function of the ON timer and to acquire the time remaining for the current reservation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFF: 0.0x3B<br>
		 * (= 0.255): (= 0.59)<br>
		 * <br>
		 * Data type : unsigned char
×2<br>
		 * <br>
		 * Data size : 2
bytes<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRelativeTimeBasedOnTimerSetting() {
			reqInformProperty(EPC_RELATIVE_TIME_BASED_ON_TIMER_SETTING);
			return this;
		}
	}

	public static class Proxy extends WasherAndDryer {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getOperationStatus() {return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt) {return false;}
		@Override
		protected byte[] getInstallationLocation() {return null;}
		@Override
		protected byte[] getStandardVersionInformation() {return null;}
		@Override
		protected byte[] getFaultStatus() {return null;}
		@Override
		protected byte[] getManufacturerCode() {return null;}
	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return setG(instanceCode, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, responseRequired);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(ECHO_CLASS_CODE, instanceCode
				, EchoSocket.MULTICAST_ADDRESS, false);
	}

}
