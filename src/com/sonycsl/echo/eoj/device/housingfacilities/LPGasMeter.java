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

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoFrame;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class LPGasMeter extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0283;

	public static final byte EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1 = (byte)0xE0;
	public static final byte EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2 = (byte)0xE1;
	public static final byte EPC_ERROR_DETECTION_STATUSOF_METERING_DATA = (byte)0xE2;
	public static final byte EPC_SECURITY_DATA1 = (byte)0xE3;
	public static final byte EPC_SECURITY_DATA2 = (byte)0xE4;
	public static final byte EPC_CENTER_VALVE_SHUT_OFF_STATUS = (byte)0xE5;
	public static final byte EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS = (byte)0xE6;
	public static final byte EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS = (byte)0xE7;
	public static final byte EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS = (byte)0xE8;
	public static final byte EPC_RESIDUAL_VOLUME_CONTROL_WARNING = (byte)0xE9;
	public static final byte EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1 = (byte)0xEA;
	public static final byte EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2 = (byte)0xEB;
	public static final byte EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3 = (byte)0xEC;
	public static final byte EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION = (byte)0xED;
	public static final byte EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE = (byte)0xEE;
	public static final byte EPC_SHUT_OFF_REASON_LOG = (byte)0xEF;
	public static final byte EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA = (byte)0xD0;
	public static final byte EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA = (byte)0xD1;
	public static final byte EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA = (byte)0xD2;
	public static final byte EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA = (byte)0xD3;
	public static final byte EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA = (byte)0xD4;
	public static final byte EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA = (byte)0xD5;
	public static final byte EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME = (byte)0xD6;
	public static final byte EPC_TEST_CALL_SETTING = (byte)0xD7;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1);
		addGetProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2);
		addStatusChangeAnnouncementProperty(EPC_ERROR_DETECTION_STATUSOF_METERING_DATA);
		addStatusChangeAnnouncementProperty(EPC_CENTER_VALVE_SHUT_OFF_STATUS);
		addStatusChangeAnnouncementProperty(EPC_RESIDUAL_VOLUME_CONTROL_WARNING);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewLPGasMeter(this);
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
	 * Property name : Integral gas consumption of metering data 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral gas consumption in units of 0.0001 m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x005F5E0FF (0.9999,9999 m3)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.0001
m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getIntegralGasConsumptionOfMeteringData1();
	/**
	 * Property name : Integral gas consumption of metering data 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral gas consumption in units of 0.0001 m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x005F5E0FF (0.9999,9999 m3)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.0001
m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidIntegralGasConsumptionOfMeteringData1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Integral gas consumption of metering data 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral gas consumption in units of 0.001 m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x005F5E0FF (0.99999,999 m3)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001
m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getIntegralGasConsumptionOfMeteringData2();
	/**
	 * Property name : Integral gas consumption of metering data 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates integral gas consumption in units of 0.001 m3.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0x005F5E0FF (0.99999,999 m3)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001
m3<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidIntegralGasConsumptionOfMeteringData2(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Error detection statusof metering data<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status where meter detected metering data error.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Error detection status found = 0x41 Error detection status not found<br>
	 * = 0x42<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getErrorDetectionStatusofMeteringData() {return null;}
	/**
	 * Property name : Error detection statusof metering data<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status where meter detected metering data error.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Error detection status found = 0x41 Error detection status not found<br>
	 * = 0x42<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidErrorDetectionStatusofMeteringData(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Security data 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates security data to define security information on meter operation by bit allocation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFFFF<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSecurityData1() {return null;}
	/**
	 * Property name : Security data 1<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates security data to define security information on meter operation by bit allocation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFFFF<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSecurityData1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Security data 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates security data to define security information on meter operation by bit allocation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFFFF<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSecurityData2() {return null;}
	/**
	 * Property name : Security data 2<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates security data to define security information on meter operation by bit allocation.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFFFF<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSecurityData2(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Center valve shut-off status<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Center valve shut-off status found<br>
	 * = 0x41<br>
	 * Center valve shut-off status not found<br>
	 * = 0x42<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getCenterValveShutOffStatus() {return null;}
	/**
	 * Property name : Center valve shut-off status<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Center valve shut-off status found<br>
	 * = 0x41<br>
	 * Center valve shut-off status not found<br>
	 * = 0x42<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidCenterValveShutOffStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Center valve shut-off recovery permission setting status<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Center valve shut-off reset enable = 0x41<br>
	 * Center valve shut-off reset not enable<br>
	 * = 0x42<br>
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
	protected byte[] getCenterValveShutOffRecoveryPermissionSettingStatus() {return null;}
	/**
	 * Property name : Center valve shut-off recovery permission setting status<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Center valve shut-off reset enable = 0x41<br>
	 * Center valve shut-off reset not enable<br>
	 * = 0x42<br>
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
	protected boolean isValidCenterValveShutOffRecoveryPermissionSettingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Emergency valve shut-off status<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status where gas shut-off valve of meter has been shut off.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emergency valve shut-off status found<br>
	 * = 0x41<br>
	 * Emergency valve shut-off status not found = 0x42<br>
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
	protected byte[] getEmergencyValveShutOffStatus() {return null;}
	/**
	 * Property name : Emergency valve shut-off status<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status where gas shut-off valve of meter has been shut off.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Emergency valve shut-off status found<br>
	 * = 0x41<br>
	 * Emergency valve shut-off status not found = 0x42<br>
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
	protected boolean isValidEmergencyValveShutOffStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Shut-off valve open/close status<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates open/close status of shut-off valve.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Shut-off valve open status = 0x41 Shut-off valve close status = 0x42<br>
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
	protected byte[] getShutOffValveOpenCloseStatus() {return null;}
	/**
	 * Property name : Shut-off valve open/close status<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates open/close status of shut-off valve.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Shut-off valve open status = 0x41 Shut-off valve close status = 0x42<br>
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
	protected boolean isValidShutOffValveOpenCloseStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Residual volume control warning<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status as warning where residual volume is very small.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Residual volume control warning level 1 0x31<br>
	 * Residual volume control warning level 2 0x32<br>
	 * Residual volume control warning level 3 0x33<br>
	 * No residual volume control warning 0x42<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getResidualVolumeControlWarning() {return null;}
	/**
	 * Property name : Residual volume control warning<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates status as warning where residual volume is very small.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Residual volume control warning level 1 0x31<br>
	 * Residual volume control warning level 2 0x32<br>
	 * Residual volume control warning level 3 0x33<br>
	 * No residual volume control warning 0x42<br>
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
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidResidualVolumeControlWarning(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Set value of residual volume control warning level 1<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets “Small residual volume detection level 1”.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFF (0.16,777,215)<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfResidualVolumeControlWarningLevel1(byte[] edt) {return false;}
	/**
	 * Property name : Set value of residual volume control warning level 1<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets “Small residual volume detection level 1”.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFF (0.16,777,215)<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfResidualVolumeControlWarningLevel1() {return null;}
	/**
	 * Property name : Set value of residual volume control warning level 1<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets “Small residual volume detection level 1”.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFF (0.16,777,215)<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfResidualVolumeControlWarningLevel1(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	/**
	 * Property name : Set value of residual volume control warning level 2<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets “Small residual volume detection level 2”.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFF (0.16,777,215)<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfResidualVolumeControlWarningLevel2(byte[] edt) {return false;}
	/**
	 * Property name : Set value of residual volume control warning level 2<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets “Small residual volume detection level 2”.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFF (0.16,777,215)<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfResidualVolumeControlWarningLevel2() {return null;}
	/**
	 * Property name : Set value of residual volume control warning level 2<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets “Small residual volume detection level 2”.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFF (0.16,777,215)<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfResidualVolumeControlWarningLevel2(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	/**
	 * Property name : Set value of residual volume control warning level 3<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets “Small residual volume detection level 3”.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFF (0.16,777,215)<br>
	 * <br>
	 * Data type : unsigned char ×3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setSetValueOfResidualVolumeControlWarningLevel3(byte[] edt) {return false;}
	/**
	 * Property name : Set value of residual volume control warning level 3<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets “Small residual volume detection level 3”.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFF (0.16,777,215)<br>
	 * <br>
	 * Data type : unsigned char ×3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getSetValueOfResidualVolumeControlWarningLevel3() {return null;}
	/**
	 * Property name : Set value of residual volume control warning level 3<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets “Small residual volume detection level 3”.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFFFFFF (0.16,777,215)<br>
	 * <br>
	 * Data type : unsigned char ×3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : liter<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSetValueOfResidualVolumeControlWarningLevel3(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	/**
	 * Property name : Slight leak timer value (gas flow rate continuation)<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates number of days on which gas flow rate is continued.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFD (0.253)<br>
	 * (0 to 253 days)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : Day<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSlightLeakTimerValueGasFlowRateContinuation() {return null;}
	/**
	 * Property name : Slight leak timer value (gas flow rate continuation)<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates number of days on which gas flow rate is continued.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFD (0.253)<br>
	 * (0 to 253 days)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : Day<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSlightLeakTimerValueGasFlowRateContinuation(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Slight leak timer value (without pressure increase)<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFD (0.253)<br>
	 * (0 to 253 days)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : Day<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getSlightLeakTimerValueWithoutPressureIncrease() {return null;}
	/**
	 * Property name : Slight leak timer value (without pressure increase)<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0.0xFD (0.253)<br>
	 * (0 to 253 days)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : Day<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidSlightLeakTimerValueWithoutPressureIncrease(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Shut-off reason log<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs.<br>
	 * Log 3: log 2: log 1<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFF: 0xFF: 0xFF<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getShutOffReasonLog() {return null;}
	/**
	 * Property name : Shut-off reason log<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs.<br>
	 * Log 3: log 2: log 1<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0xFF: 0xFF: 0xFF<br>
	 * <br>
	 * Data type : unsigned char × 3<br>
	 * <br>
	 * Data size : 3 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidShutOffReasonLog(byte[] edt) {
		if(edt == null || !(edt.length == 3)) return false;
		return true;
	}
	/**
	 * Property name : Maximum value of supply pressure data<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMaximumValueOfSupplyPressureData() {return null;}
	/**
	 * Property name : Maximum value of supply pressure data<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMaximumValueOfSupplyPressureData(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Minimum value of supply pressure data<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumValueOfSupplyPressureData() {return null;}
	/**
	 * Property name : Minimum value of supply pressure data<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumValueOfSupplyPressureData(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Current value of supply pressure data<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getCurrentValueOfSupplyPressureData() {return null;}
	/**
	 * Property name : Current value of supply pressure data<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidCurrentValueOfSupplyPressureData(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Maximum value of block pressure data<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMaximumValueOfBlockPressureData() {return null;}
	/**
	 * Property name : Maximum value of block pressure data<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMaximumValueOfBlockPressureData(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Minimum value of block pressure data<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumValueOfBlockPressureData() {return null;}
	/**
	 * Property name : Minimum value of block pressure data<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumValueOfBlockPressureData(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Current value of block pressure data<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates current value of block pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getCurrentValueOfBlockPressureData() {return null;}
	/**
	 * Property name : Current value of block pressure data<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates current value of block pressure data in units of 0.01 kPa.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.655.33)<br>
	 * (0.655.33 kPa)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.01
kPa<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidCurrentValueOfBlockPressureData(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Number of block pressure/supply pressure error days:time<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte  each.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times<br>
	 * <br>
	 * Data type : unsigned char × 4<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getNumberOfBlockPressureSupplyPressureErrorDaysTime() {return null;}
	/**
	 * Property name : Number of block pressure/supply pressure error days:time<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte  each.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times<br>
	 * <br>
	 * Data type : unsigned char × 4<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidNumberOfBlockPressureSupplyPressureErrorDaysTime(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Test call setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Performs test call operation setup.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Test call operation ON 0x41 Test call operation OFF 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setTestCallSetting(byte[] edt) {return false;}
	/**
	 * Property name : Test call setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Performs test call operation setup.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Test call operation ON 0x41 Test call operation OFF 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getTestCallSetting() {return null;}
	/**
	 * Property name : Test call setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Performs test call operation setup.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Test call operation ON 0x41 Test call operation OFF 0x42<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidTestCallSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1 : return setSetValueOfResidualVolumeControlWarningLevel1(property.edt);
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2 : return setSetValueOfResidualVolumeControlWarningLevel2(property.edt);
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3 : return setSetValueOfResidualVolumeControlWarningLevel3(property.edt);
		case EPC_TEST_CALL_SETTING : return setTestCallSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1 : return getIntegralGasConsumptionOfMeteringData1();
		case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2 : return getIntegralGasConsumptionOfMeteringData2();
		case EPC_ERROR_DETECTION_STATUSOF_METERING_DATA : return getErrorDetectionStatusofMeteringData();
		case EPC_SECURITY_DATA1 : return getSecurityData1();
		case EPC_SECURITY_DATA2 : return getSecurityData2();
		case EPC_CENTER_VALVE_SHUT_OFF_STATUS : return getCenterValveShutOffStatus();
		case EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS : return getCenterValveShutOffRecoveryPermissionSettingStatus();
		case EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS : return getEmergencyValveShutOffStatus();
		case EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS : return getShutOffValveOpenCloseStatus();
		case EPC_RESIDUAL_VOLUME_CONTROL_WARNING : return getResidualVolumeControlWarning();
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1 : return getSetValueOfResidualVolumeControlWarningLevel1();
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2 : return getSetValueOfResidualVolumeControlWarningLevel2();
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3 : return getSetValueOfResidualVolumeControlWarningLevel3();
		case EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION : return getSlightLeakTimerValueGasFlowRateContinuation();
		case EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE : return getSlightLeakTimerValueWithoutPressureIncrease();
		case EPC_SHUT_OFF_REASON_LOG : return getShutOffReasonLog();
		case EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA : return getMaximumValueOfSupplyPressureData();
		case EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA : return getMinimumValueOfSupplyPressureData();
		case EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA : return getCurrentValueOfSupplyPressureData();
		case EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA : return getMaximumValueOfBlockPressureData();
		case EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA : return getMinimumValueOfBlockPressureData();
		case EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA : return getCurrentValueOfBlockPressureData();
		case EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME : return getNumberOfBlockPressureSupplyPressureErrorDaysTime();
		case EPC_TEST_CALL_SETTING : return getTestCallSetting();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1 : return isValidIntegralGasConsumptionOfMeteringData1(property.edt);
		case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2 : return isValidIntegralGasConsumptionOfMeteringData2(property.edt);
		case EPC_ERROR_DETECTION_STATUSOF_METERING_DATA : return isValidErrorDetectionStatusofMeteringData(property.edt);
		case EPC_SECURITY_DATA1 : return isValidSecurityData1(property.edt);
		case EPC_SECURITY_DATA2 : return isValidSecurityData2(property.edt);
		case EPC_CENTER_VALVE_SHUT_OFF_STATUS : return isValidCenterValveShutOffStatus(property.edt);
		case EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS : return isValidCenterValveShutOffRecoveryPermissionSettingStatus(property.edt);
		case EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS : return isValidEmergencyValveShutOffStatus(property.edt);
		case EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS : return isValidShutOffValveOpenCloseStatus(property.edt);
		case EPC_RESIDUAL_VOLUME_CONTROL_WARNING : return isValidResidualVolumeControlWarning(property.edt);
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1 : return isValidSetValueOfResidualVolumeControlWarningLevel1(property.edt);
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2 : return isValidSetValueOfResidualVolumeControlWarningLevel2(property.edt);
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3 : return isValidSetValueOfResidualVolumeControlWarningLevel3(property.edt);
		case EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION : return isValidSlightLeakTimerValueGasFlowRateContinuation(property.edt);
		case EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE : return isValidSlightLeakTimerValueWithoutPressureIncrease(property.edt);
		case EPC_SHUT_OFF_REASON_LOG : return isValidShutOffReasonLog(property.edt);
		case EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA : return isValidMaximumValueOfSupplyPressureData(property.edt);
		case EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA : return isValidMinimumValueOfSupplyPressureData(property.edt);
		case EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA : return isValidCurrentValueOfSupplyPressureData(property.edt);
		case EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA : return isValidMaximumValueOfBlockPressureData(property.edt);
		case EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA : return isValidMinimumValueOfBlockPressureData(property.edt);
		case EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA : return isValidCurrentValueOfBlockPressureData(property.edt);
		case EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME : return isValidNumberOfBlockPressureSupplyPressureErrorDaysTime(property.edt);
		case EPC_TEST_CALL_SETTING : return isValidTestCallSetting(property.edt);
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
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1 : 
				onSetSetValueOfResidualVolumeControlWarningLevel1(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2 : 
				onSetSetValueOfResidualVolumeControlWarningLevel2(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3 : 
				onSetSetValueOfResidualVolumeControlWarningLevel3(eoj, tid, esv, property, success);
				return true;
			case EPC_TEST_CALL_SETTING : 
				onSetTestCallSetting(eoj, tid, esv, property, success);
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
			case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1 : 
				onGetIntegralGasConsumptionOfMeteringData1(eoj, tid, esv, property, success);
				return true;
			case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2 : 
				onGetIntegralGasConsumptionOfMeteringData2(eoj, tid, esv, property, success);
				return true;
			case EPC_ERROR_DETECTION_STATUSOF_METERING_DATA : 
				onGetErrorDetectionStatusofMeteringData(eoj, tid, esv, property, success);
				return true;
			case EPC_SECURITY_DATA1 : 
				onGetSecurityData1(eoj, tid, esv, property, success);
				return true;
			case EPC_SECURITY_DATA2 : 
				onGetSecurityData2(eoj, tid, esv, property, success);
				return true;
			case EPC_CENTER_VALVE_SHUT_OFF_STATUS : 
				onGetCenterValveShutOffStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS : 
				onGetCenterValveShutOffRecoveryPermissionSettingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS : 
				onGetEmergencyValveShutOffStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS : 
				onGetShutOffValveOpenCloseStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_RESIDUAL_VOLUME_CONTROL_WARNING : 
				onGetResidualVolumeControlWarning(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1 : 
				onGetSetValueOfResidualVolumeControlWarningLevel1(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2 : 
				onGetSetValueOfResidualVolumeControlWarningLevel2(eoj, tid, esv, property, success);
				return true;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3 : 
				onGetSetValueOfResidualVolumeControlWarningLevel3(eoj, tid, esv, property, success);
				return true;
			case EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION : 
				onGetSlightLeakTimerValueGasFlowRateContinuation(eoj, tid, esv, property, success);
				return true;
			case EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE : 
				onGetSlightLeakTimerValueWithoutPressureIncrease(eoj, tid, esv, property, success);
				return true;
			case EPC_SHUT_OFF_REASON_LOG : 
				onGetShutOffReasonLog(eoj, tid, esv, property, success);
				return true;
			case EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA : 
				onGetMaximumValueOfSupplyPressureData(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA : 
				onGetMinimumValueOfSupplyPressureData(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA : 
				onGetCurrentValueOfSupplyPressureData(eoj, tid, esv, property, success);
				return true;
			case EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA : 
				onGetMaximumValueOfBlockPressureData(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA : 
				onGetMinimumValueOfBlockPressureData(eoj, tid, esv, property, success);
				return true;
			case EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA : 
				onGetCurrentValueOfBlockPressureData(eoj, tid, esv, property, success);
				return true;
			case EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME : 
				onGetNumberOfBlockPressureSupplyPressureErrorDaysTime(eoj, tid, esv, property, success);
				return true;
			case EPC_TEST_CALL_SETTING : 
				onGetTestCallSetting(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Integral gas consumption of metering data 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral gas consumption in units of 0.0001 m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x005F5E0FF (0.9999,9999 m3)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.0001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetIntegralGasConsumptionOfMeteringData1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Integral gas consumption of metering data 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral gas consumption in units of 0.001 m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x005F5E0FF (0.99999,999 m3)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetIntegralGasConsumptionOfMeteringData2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Error detection statusof metering data<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where meter detected metering data error.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Error detection status found = 0x41 Error detection status not found<br>
		 * = 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetErrorDetectionStatusofMeteringData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Security data 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFFFF<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSecurityData1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Security data 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFFFF<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSecurityData2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Center valve shut-off status<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Center valve shut-off status found<br>
		 * = 0x41<br>
		 * Center valve shut-off status not found<br>
		 * = 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetCenterValveShutOffStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Center valve shut-off recovery permission setting status<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Center valve shut-off reset enable = 0x41<br>
		 * Center valve shut-off reset not enable<br>
		 * = 0x42<br>
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
		protected void onGetCenterValveShutOffRecoveryPermissionSettingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Emergency valve shut-off status<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where gas shut-off valve of meter has been shut off.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emergency valve shut-off status found<br>
		 * = 0x41<br>
		 * Emergency valve shut-off status not found = 0x42<br>
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
		protected void onGetEmergencyValveShutOffStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Shut-off valve open/close status<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates open/close status of shut-off valve.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shut-off valve open status = 0x41 Shut-off valve close status = 0x42<br>
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
		protected void onGetShutOffValveOpenCloseStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Residual volume control warning<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status as warning where residual volume is very small.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Residual volume control warning level 1 0x31<br>
		 * Residual volume control warning level 2 0x32<br>
		 * Residual volume control warning level 3 0x33<br>
		 * No residual volume control warning 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetResidualVolumeControlWarning(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of residual volume control warning level 1<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 1”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfResidualVolumeControlWarningLevel1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of residual volume control warning level 1<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 1”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfResidualVolumeControlWarningLevel1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of residual volume control warning level 2<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 2”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfResidualVolumeControlWarningLevel2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of residual volume control warning level 2<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 2”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfResidualVolumeControlWarningLevel2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of residual volume control warning level 3<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 3”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char ×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetSetValueOfResidualVolumeControlWarningLevel3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Set value of residual volume control warning level 3<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 3”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char ×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetSetValueOfResidualVolumeControlWarningLevel3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Slight leak timer value (gas flow rate continuation)<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of days on which gas flow rate is continued.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFD (0.253)<br>
		 * (0 to 253 days)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : Day<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSlightLeakTimerValueGasFlowRateContinuation(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Slight leak timer value (without pressure increase)<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFD (0.253)<br>
		 * (0 to 253 days)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : Day<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetSlightLeakTimerValueWithoutPressureIncrease(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Shut-off reason log<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs.<br>
		 * Log 3: log 2: log 1<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFF: 0xFF: 0xFF<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetShutOffReasonLog(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Maximum value of supply pressure data<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMaximumValueOfSupplyPressureData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum value of supply pressure data<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumValueOfSupplyPressureData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Current value of supply pressure data<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetCurrentValueOfSupplyPressureData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Maximum value of block pressure data<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMaximumValueOfBlockPressureData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum value of block pressure data<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumValueOfBlockPressureData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Current value of block pressure data<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates current value of block pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetCurrentValueOfBlockPressureData(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Number of block pressure/supply pressure error days:time<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte  each.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times<br>
		 * <br>
		 * Data type : unsigned char × 4<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetNumberOfBlockPressureSupplyPressureErrorDaysTime(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Test call setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Performs test call operation setup.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Test call operation ON 0x41 Test call operation OFF 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetTestCallSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Test call setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Performs test call operation setup.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Test call operation ON 0x41 Test call operation OFF 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetTestCallSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : Set value of residual volume control warning level 1<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 1”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel1(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1, edt);
			return this;
		}
		/**
		 * Property name : Set value of residual volume control warning level 2<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 2”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel2(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2, edt);
			return this;
		}
		/**
		 * Property name : Set value of residual volume control warning level 3<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 3”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char ×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel3(byte[] edt) {
			reqSetProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3, edt);
			return this;
		}
		/**
		 * Property name : Test call setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Performs test call operation setup.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Test call operation ON 0x41 Test call operation OFF 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetTestCallSetting(byte[] edt) {
			reqSetProperty(EPC_TEST_CALL_SETTING, edt);
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
		 * Property name : Integral gas consumption of metering data 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral gas consumption in units of 0.0001 m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x005F5E0FF (0.9999,9999 m3)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.0001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetIntegralGasConsumptionOfMeteringData1() {
			reqGetProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1);
			return this;
		}
		/**
		 * Property name : Integral gas consumption of metering data 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral gas consumption in units of 0.001 m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x005F5E0FF (0.99999,999 m3)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetIntegralGasConsumptionOfMeteringData2() {
			reqGetProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2);
			return this;
		}
		/**
		 * Property name : Error detection statusof metering data<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where meter detected metering data error.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Error detection status found = 0x41 Error detection status not found<br>
		 * = 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetErrorDetectionStatusofMeteringData() {
			reqGetProperty(EPC_ERROR_DETECTION_STATUSOF_METERING_DATA);
			return this;
		}
		/**
		 * Property name : Security data 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFFFF<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSecurityData1() {
			reqGetProperty(EPC_SECURITY_DATA1);
			return this;
		}
		/**
		 * Property name : Security data 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFFFF<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSecurityData2() {
			reqGetProperty(EPC_SECURITY_DATA2);
			return this;
		}
		/**
		 * Property name : Center valve shut-off status<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Center valve shut-off status found<br>
		 * = 0x41<br>
		 * Center valve shut-off status not found<br>
		 * = 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetCenterValveShutOffStatus() {
			reqGetProperty(EPC_CENTER_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		/**
		 * Property name : Center valve shut-off recovery permission setting status<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Center valve shut-off reset enable = 0x41<br>
		 * Center valve shut-off reset not enable<br>
		 * = 0x42<br>
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
		public Getter reqGetCenterValveShutOffRecoveryPermissionSettingStatus() {
			reqGetProperty(EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS);
			return this;
		}
		/**
		 * Property name : Emergency valve shut-off status<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where gas shut-off valve of meter has been shut off.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emergency valve shut-off status found<br>
		 * = 0x41<br>
		 * Emergency valve shut-off status not found = 0x42<br>
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
		public Getter reqGetEmergencyValveShutOffStatus() {
			reqGetProperty(EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		/**
		 * Property name : Shut-off valve open/close status<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates open/close status of shut-off valve.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shut-off valve open status = 0x41 Shut-off valve close status = 0x42<br>
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
		public Getter reqGetShutOffValveOpenCloseStatus() {
			reqGetProperty(EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Residual volume control warning<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status as warning where residual volume is very small.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Residual volume control warning level 1 0x31<br>
		 * Residual volume control warning level 2 0x32<br>
		 * Residual volume control warning level 3 0x33<br>
		 * No residual volume control warning 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetResidualVolumeControlWarning() {
			reqGetProperty(EPC_RESIDUAL_VOLUME_CONTROL_WARNING);
			return this;
		}
		/**
		 * Property name : Set value of residual volume control warning level 1<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 1”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel1() {
			reqGetProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1);
			return this;
		}
		/**
		 * Property name : Set value of residual volume control warning level 2<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 2”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel2() {
			reqGetProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2);
			return this;
		}
		/**
		 * Property name : Set value of residual volume control warning level 3<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 3”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char ×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel3() {
			reqGetProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3);
			return this;
		}
		/**
		 * Property name : Slight leak timer value (gas flow rate continuation)<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of days on which gas flow rate is continued.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFD (0.253)<br>
		 * (0 to 253 days)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : Day<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSlightLeakTimerValueGasFlowRateContinuation() {
			reqGetProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION);
			return this;
		}
		/**
		 * Property name : Slight leak timer value (without pressure increase)<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFD (0.253)<br>
		 * (0 to 253 days)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : Day<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetSlightLeakTimerValueWithoutPressureIncrease() {
			reqGetProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE);
			return this;
		}
		/**
		 * Property name : Shut-off reason log<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs.<br>
		 * Log 3: log 2: log 1<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFF: 0xFF: 0xFF<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetShutOffReasonLog() {
			reqGetProperty(EPC_SHUT_OFF_REASON_LOG);
			return this;
		}
		/**
		 * Property name : Maximum value of supply pressure data<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMaximumValueOfSupplyPressureData() {
			reqGetProperty(EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Minimum value of supply pressure data<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumValueOfSupplyPressureData() {
			reqGetProperty(EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Current value of supply pressure data<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetCurrentValueOfSupplyPressureData() {
			reqGetProperty(EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Maximum value of block pressure data<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMaximumValueOfBlockPressureData() {
			reqGetProperty(EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Minimum value of block pressure data<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumValueOfBlockPressureData() {
			reqGetProperty(EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Current value of block pressure data<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates current value of block pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetCurrentValueOfBlockPressureData() {
			reqGetProperty(EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Number of block pressure/supply pressure error days:time<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte  each.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times<br>
		 * <br>
		 * Data type : unsigned char × 4<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetNumberOfBlockPressureSupplyPressureErrorDaysTime() {
			reqGetProperty(EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME);
			return this;
		}
		/**
		 * Property name : Test call setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Performs test call operation setup.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Test call operation ON 0x41 Test call operation OFF 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetTestCallSetting() {
			reqGetProperty(EPC_TEST_CALL_SETTING);
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
		 * Property name : Integral gas consumption of metering data 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral gas consumption in units of 0.0001 m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x005F5E0FF (0.9999,9999 m3)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.0001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformIntegralGasConsumptionOfMeteringData1() {
			reqInformProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1);
			return this;
		}
		/**
		 * Property name : Integral gas consumption of metering data 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates integral gas consumption in units of 0.001 m3.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0x005F5E0FF (0.99999,999 m3)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001
m3<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformIntegralGasConsumptionOfMeteringData2() {
			reqInformProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2);
			return this;
		}
		/**
		 * Property name : Error detection statusof metering data<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where meter detected metering data error.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Error detection status found = 0x41 Error detection status not found<br>
		 * = 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformErrorDetectionStatusofMeteringData() {
			reqInformProperty(EPC_ERROR_DETECTION_STATUSOF_METERING_DATA);
			return this;
		}
		/**
		 * Property name : Security data 1<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFFFF<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSecurityData1() {
			reqInformProperty(EPC_SECURITY_DATA1);
			return this;
		}
		/**
		 * Property name : Security data 2<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFFFF<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSecurityData2() {
			reqInformProperty(EPC_SECURITY_DATA2);
			return this;
		}
		/**
		 * Property name : Center valve shut-off status<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Center valve shut-off status found<br>
		 * = 0x41<br>
		 * Center valve shut-off status not found<br>
		 * = 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformCenterValveShutOffStatus() {
			reqInformProperty(EPC_CENTER_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		/**
		 * Property name : Center valve shut-off recovery permission setting status<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Center valve shut-off reset enable = 0x41<br>
		 * Center valve shut-off reset not enable<br>
		 * = 0x42<br>
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
		public Informer reqInformCenterValveShutOffRecoveryPermissionSettingStatus() {
			reqInformProperty(EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS);
			return this;
		}
		/**
		 * Property name : Emergency valve shut-off status<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status where gas shut-off valve of meter has been shut off.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Emergency valve shut-off status found<br>
		 * = 0x41<br>
		 * Emergency valve shut-off status not found = 0x42<br>
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
		public Informer reqInformEmergencyValveShutOffStatus() {
			reqInformProperty(EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		/**
		 * Property name : Shut-off valve open/close status<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates open/close status of shut-off valve.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Shut-off valve open status = 0x41 Shut-off valve close status = 0x42<br>
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
		public Informer reqInformShutOffValveOpenCloseStatus() {
			reqInformProperty(EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * Property name : Residual volume control warning<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates status as warning where residual volume is very small.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Residual volume control warning level 1 0x31<br>
		 * Residual volume control warning level 2 0x32<br>
		 * Residual volume control warning level 3 0x33<br>
		 * No residual volume control warning 0x42<br>
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
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformResidualVolumeControlWarning() {
			reqInformProperty(EPC_RESIDUAL_VOLUME_CONTROL_WARNING);
			return this;
		}
		/**
		 * Property name : Set value of residual volume control warning level 1<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 1”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel1() {
			reqInformProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1);
			return this;
		}
		/**
		 * Property name : Set value of residual volume control warning level 2<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 2”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel2() {
			reqInformProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2);
			return this;
		}
		/**
		 * Property name : Set value of residual volume control warning level 3<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets “Small residual volume detection level 3”.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFFFFFF (0.16,777,215)<br>
		 * <br>
		 * Data type : unsigned char ×3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : liter<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel3() {
			reqInformProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3);
			return this;
		}
		/**
		 * Property name : Slight leak timer value (gas flow rate continuation)<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of days on which gas flow rate is continued.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFD (0.253)<br>
		 * (0 to 253 days)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : Day<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSlightLeakTimerValueGasFlowRateContinuation() {
			reqInformProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION);
			return this;
		}
		/**
		 * Property name : Slight leak timer value (without pressure increase)<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0.0xFD (0.253)<br>
		 * (0 to 253 days)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : Day<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformSlightLeakTimerValueWithoutPressureIncrease() {
			reqInformProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE);
			return this;
		}
		/**
		 * Property name : Shut-off reason log<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs.<br>
		 * Log 3: log 2: log 1<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0xFF: 0xFF: 0xFF<br>
		 * <br>
		 * Data type : unsigned char × 3<br>
		 * <br>
		 * Data size : 3 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformShutOffReasonLog() {
			reqInformProperty(EPC_SHUT_OFF_REASON_LOG);
			return this;
		}
		/**
		 * Property name : Maximum value of supply pressure data<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMaximumValueOfSupplyPressureData() {
			reqInformProperty(EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Minimum value of supply pressure data<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumValueOfSupplyPressureData() {
			reqInformProperty(EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Current value of supply pressure data<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformCurrentValueOfSupplyPressureData() {
			reqInformProperty(EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Maximum value of block pressure data<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMaximumValueOfBlockPressureData() {
			reqInformProperty(EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Minimum value of block pressure data<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumValueOfBlockPressureData() {
			reqInformProperty(EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Current value of block pressure data<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates current value of block pressure data in units of 0.01 kPa.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.655.33)<br>
		 * (0.655.33 kPa)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.01
kPa<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformCurrentValueOfBlockPressureData() {
			reqInformProperty(EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		/**
		 * Property name : Number of block pressure/supply pressure error days:time<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte  each.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times<br>
		 * <br>
		 * Data type : unsigned char × 4<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformNumberOfBlockPressureSupplyPressureErrorDaysTime() {
			reqInformProperty(EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME);
			return this;
		}
		/**
		 * Property name : Test call setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Performs test call operation setup.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Test call operation ON 0x41 Test call operation OFF 0x42<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformTestCallSetting() {
			reqInformProperty(EPC_TEST_CALL_SETTING);
			return this;
		}
	}

	public static class Proxy extends LPGasMeter {
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
		@Override
		protected byte[] getIntegralGasConsumptionOfMeteringData1() {return null;}
		@Override
		protected byte[] getIntegralGasConsumptionOfMeteringData2() {return null;}
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
