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

public abstract class LPGasMeter extends DeviceObject {
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x83;
	
	public LPGasMeter() {
		setReceiver(new Receiver());
	}

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
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates integral gas consumption in units of 0.0001 m3.<br><br>0.0x005F5E0FF (0.9999,9999 m3)<br><br>Name : Integral gas consumption of metering data 1<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getIntegralGasConsumptionOfMeteringData1();
	private final byte[] _getIntegralGasConsumptionOfMeteringData1(byte epc) {
		byte[] edt = getIntegralGasConsumptionOfMeteringData1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates integral gas consumption in units of 0.001 m3.<br><br>0.0x005F5E0FF (0.99999,999 m3)<br><br>Name : Integral gas consumption of metering data 2<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
	 */
	protected abstract byte[] getIntegralGasConsumptionOfMeteringData2();
	private final byte[] _getIntegralGasConsumptionOfMeteringData2(byte epc) {
		byte[] edt = getIntegralGasConsumptionOfMeteringData2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates status where meter detected metering data error.<br><br>Error detection status found = 0x41 Error detection status not found = 0x42<br><br>Name : Error detection statusof metering data<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getErrorDetectionStatusofMeteringData() {return null;}
	private final byte[] _getErrorDetectionStatusofMeteringData(byte epc) {
		byte[] edt = getErrorDetectionStatusofMeteringData();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates security data to define security information on meter operation by bit allocation.<br><br>0.0xFFFFFFFF<br><br>Name : Security data 1<br>EPC : 0xE3<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSecurityData1() {return null;}
	private final byte[] _getSecurityData1(byte epc) {
		byte[] edt = getSecurityData1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates security data to define security information on meter operation by bit allocation.<br><br>0.0xFFFFFFFF<br><br>Name : Security data 2<br>EPC : 0xE4<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSecurityData2() {return null;}
	private final byte[] _getSecurityData2(byte epc) {
		byte[] edt = getSecurityData2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br><br>Center valve shut-off status found = 0x41 Center valve shut-off status not found = 0x42<br><br>Name : Center valve shut-off status<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getCenterValveShutOffStatus() {return null;}
	private final byte[] _getCenterValveShutOffStatus(byte epc) {
		byte[] edt = getCenterValveShutOffStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br><br>Center valve shut-off reset enable = 0x41 Center valve shut-off reset not enable = 0x42<br><br>Name : Center valve shut-off recovery permission setting status<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getCenterValveShutOffRecoveryPermissionSettingStatus() {return null;}
	private final byte[] _getCenterValveShutOffRecoveryPermissionSettingStatus(byte epc) {
		byte[] edt = getCenterValveShutOffRecoveryPermissionSettingStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates status where gas shut-off valve of meter has been shut off.<br><br>Emergency valve shut-off status found = 0x41 Emergency valve shut-off status not found = 0x42<br><br>Name : Emergency valve shut-off status<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getEmergencyValveShutOffStatus() {return null;}
	private final byte[] _getEmergencyValveShutOffStatus(byte epc) {
		byte[] edt = getEmergencyValveShutOffStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates open/close status of shut-off valve.<br><br>Shut-off valve open status = 0x41 Shut-off valve close status = 0x42<br><br>Name : Shut-off valve open/close status<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getShutOffValveOpenCloseStatus() {return null;}
	private final byte[] _getShutOffValveOpenCloseStatus(byte epc) {
		byte[] edt = getShutOffValveOpenCloseStatus();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates status as warning where residual volume is very small.<br><br>Residual volume control warning level 1 0x31 Residual volume control warning level 2 0x32 Residual volume control warning level 3 0x33 No residual volume control warning 0x42<br><br>Name : Residual volume control warning<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
	 */
	protected byte[] getResidualVolumeControlWarning() {return null;}
	private final byte[] _getResidualVolumeControlWarning(byte epc) {
		byte[] edt = getResidualVolumeControlWarning();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets �gSmall residual volume detection level 1�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 1<br>EPC : 0xEA<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfResidualVolumeControlWarningLevel1(byte[] edt) {return false;}
	private final boolean _setSetValueOfResidualVolumeControlWarningLevel1(byte epc, byte[] edt) {
		boolean success = setSetValueOfResidualVolumeControlWarningLevel1(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets �gSmall residual volume detection level 1�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 1<br>EPC : 0xEA<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfResidualVolumeControlWarningLevel1() {return null;}
	private final byte[] _getSetValueOfResidualVolumeControlWarningLevel1(byte epc) {
		byte[] edt = getSetValueOfResidualVolumeControlWarningLevel1();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets �gSmall residual volume detection level 2�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 2<br>EPC : 0xEB<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfResidualVolumeControlWarningLevel2(byte[] edt) {return false;}
	private final boolean _setSetValueOfResidualVolumeControlWarningLevel2(byte epc, byte[] edt) {
		boolean success = setSetValueOfResidualVolumeControlWarningLevel2(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets �gSmall residual volume detection level 2�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 2<br>EPC : 0xEB<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfResidualVolumeControlWarningLevel2() {return null;}
	private final byte[] _getSetValueOfResidualVolumeControlWarningLevel2(byte epc) {
		byte[] edt = getSetValueOfResidualVolumeControlWarningLevel2();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Sets �gSmall residual volume detection level 3�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 3<br>EPC : 0xEC<br>Data Type : unsigned char x3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setSetValueOfResidualVolumeControlWarningLevel3(byte[] edt) {return false;}
	private final boolean _setSetValueOfResidualVolumeControlWarningLevel3(byte epc, byte[] edt) {
		boolean success = setSetValueOfResidualVolumeControlWarningLevel3(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Sets �gSmall residual volume detection level 3�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 3<br>EPC : 0xEC<br>Data Type : unsigned char x3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getSetValueOfResidualVolumeControlWarningLevel3() {return null;}
	private final byte[] _getSetValueOfResidualVolumeControlWarningLevel3(byte epc) {
		byte[] edt = getSetValueOfResidualVolumeControlWarningLevel3();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates number of days on which gas flow rate is continued.<br><br>0.0xFD (0.253) (0 to 253 days)<br><br>Name : Slight leak timer value (gas flow rate continuation)<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSlightLeakTimerValueGasFlowRateContinuation() {return null;}
	private final byte[] _getSlightLeakTimerValueGasFlowRateContinuation(byte epc) {
		byte[] edt = getSlightLeakTimerValueGasFlowRateContinuation();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br><br>0.0xFD (0.253) (0 to 253 days)<br><br>Name : Slight leak timer value (without pressure increase)<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getSlightLeakTimerValueWithoutPressureIncrease() {return null;}
	private final byte[] _getSlightLeakTimerValueWithoutPressureIncrease(byte epc) {
		byte[] edt = getSlightLeakTimerValueWithoutPressureIncrease();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs. Log 3: log 2: log 1<br><br>0xFF: 0xFF: 0xFF<br><br>Name : Shut-off reason log<br>EPC : 0xEF<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getShutOffReasonLog() {return null;}
	private final byte[] _getShutOffReasonLog(byte epc) {
		byte[] edt = getShutOffReasonLog();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Maximum value of supply pressure data<br>EPC : 0xD0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMaximumValueOfSupplyPressureData() {return null;}
	private final byte[] _getMaximumValueOfSupplyPressureData(byte epc) {
		byte[] edt = getMaximumValueOfSupplyPressureData();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Minimum value of supply pressure data<br>EPC : 0xD1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMinimumValueOfSupplyPressureData() {return null;}
	private final byte[] _getMinimumValueOfSupplyPressureData(byte epc) {
		byte[] edt = getMinimumValueOfSupplyPressureData();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Current value of supply pressure data<br>EPC : 0xD2<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getCurrentValueOfSupplyPressureData() {return null;}
	private final byte[] _getCurrentValueOfSupplyPressureData(byte epc) {
		byte[] edt = getCurrentValueOfSupplyPressureData();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Maximum value of block pressure data<br>EPC : 0xD3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMaximumValueOfBlockPressureData() {return null;}
	private final byte[] _getMaximumValueOfBlockPressureData(byte epc) {
		byte[] edt = getMaximumValueOfBlockPressureData();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Minimum value of block pressure data<br>EPC : 0xD4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getMinimumValueOfBlockPressureData() {return null;}
	private final byte[] _getMinimumValueOfBlockPressureData(byte epc) {
		byte[] edt = getMinimumValueOfBlockPressureData();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates current value of block pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Current value of block pressure data<br>EPC : 0xD5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getCurrentValueOfBlockPressureData() {return null;}
	private final byte[] _getCurrentValueOfBlockPressureData(byte epc) {
		byte[] edt = getCurrentValueOfBlockPressureData();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte each.<br><br>Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times<br><br>Name : Number of block pressure/supply pressure error days:time<br>EPC : 0xD6<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
	 */
	protected byte[] getNumberOfBlockPressureSupplyPressureErrorDaysTime() {return null;}
	private final byte[] _getNumberOfBlockPressureSupplyPressureErrorDaysTime(byte epc) {
		byte[] edt = getNumberOfBlockPressureSupplyPressureErrorDaysTime();
		onInvokedGetMethod(epc, edt);
		return edt;
	}
	/**
	 * Performs test call operation setup.<br><br>Test call operation ON 0x41 Test call operation OFF 0x42<br><br>Name : Test call setting<br>EPC : 0xD7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected boolean setTestCallSetting(byte[] edt) {return false;}
	private final boolean _setTestCallSetting(byte epc, byte[] edt) {
		boolean success = setTestCallSetting(edt);
		onInvokedSetMethod(epc, edt, success);
		return success;
	}
	/**
	 * Performs test call operation setup.<br><br>Test call operation ON 0x41 Test call operation OFF 0x42<br><br>Name : Test call setting<br>EPC : 0xD7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
	 */
	protected byte[] getTestCallSetting() {return null;}
	private final byte[] _getTestCallSetting(byte epc) {
		byte[] edt = getTestCallSetting();
		onInvokedGetMethod(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1:
			res.addProperty(epc, edt, _setSetValueOfResidualVolumeControlWarningLevel1(epc, edt));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2:
			res.addProperty(epc, edt, _setSetValueOfResidualVolumeControlWarningLevel2(epc, edt));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3:
			res.addProperty(epc, edt, _setSetValueOfResidualVolumeControlWarningLevel3(epc, edt));
			break;
		case EPC_TEST_CALL_SETTING:
			res.addProperty(epc, edt, _setTestCallSetting(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1:
			edt = _getIntegralGasConsumptionOfMeteringData1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2:
			edt = _getIntegralGasConsumptionOfMeteringData2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_ERROR_DETECTION_STATUSOF_METERING_DATA:
			edt = _getErrorDetectionStatusofMeteringData(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SECURITY_DATA1:
			edt = _getSecurityData1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_SECURITY_DATA2:
			edt = _getSecurityData2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_CENTER_VALVE_SHUT_OFF_STATUS:
			edt = _getCenterValveShutOffStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS:
			edt = _getCenterValveShutOffRecoveryPermissionSettingStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS:
			edt = _getEmergencyValveShutOffStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS:
			edt = _getShutOffValveOpenCloseStatus(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RESIDUAL_VOLUME_CONTROL_WARNING:
			edt = _getResidualVolumeControlWarning(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1:
			edt = _getSetValueOfResidualVolumeControlWarningLevel1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2:
			edt = _getSetValueOfResidualVolumeControlWarningLevel2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3:
			edt = _getSetValueOfResidualVolumeControlWarningLevel3(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION:
			edt = _getSlightLeakTimerValueGasFlowRateContinuation(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE:
			edt = _getSlightLeakTimerValueWithoutPressureIncrease(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHUT_OFF_REASON_LOG:
			edt = _getShutOffReasonLog(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA:
			edt = _getMaximumValueOfSupplyPressureData(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA:
			edt = _getMinimumValueOfSupplyPressureData(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA:
			edt = _getCurrentValueOfSupplyPressureData(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA:
			edt = _getMaximumValueOfBlockPressureData(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA:
			edt = _getMinimumValueOfBlockPressureData(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA:
			edt = _getCurrentValueOfBlockPressureData(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME:
			edt = _getNumberOfBlockPressureSupplyPressureErrorDaysTime(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_TEST_CALL_SETTING:
			edt = _getTestCallSetting(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1:
				_onSetSetValueOfResidualVolumeControlWarningLevel1(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2:
				_onSetSetValueOfResidualVolumeControlWarningLevel2(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3:
				_onSetSetValueOfResidualVolumeControlWarningLevel3(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;
			case EPC_TEST_CALL_SETTING:
				_onSetTestCallSetting(eoj, tid, esv, epc, pdc, edt, (pdc == 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1:
				_onGetIntegralGasConsumptionOfMeteringData1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2:
				_onGetIntegralGasConsumptionOfMeteringData2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_ERROR_DETECTION_STATUSOF_METERING_DATA:
				_onGetErrorDetectionStatusofMeteringData(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SECURITY_DATA1:
				_onGetSecurityData1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SECURITY_DATA2:
				_onGetSecurityData2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CENTER_VALVE_SHUT_OFF_STATUS:
				_onGetCenterValveShutOffStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS:
				_onGetCenterValveShutOffRecoveryPermissionSettingStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS:
				_onGetEmergencyValveShutOffStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS:
				_onGetShutOffValveOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RESIDUAL_VOLUME_CONTROL_WARNING:
				_onGetResidualVolumeControlWarning(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1:
				_onGetSetValueOfResidualVolumeControlWarningLevel1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2:
				_onGetSetValueOfResidualVolumeControlWarningLevel2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3:
				_onGetSetValueOfResidualVolumeControlWarningLevel3(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION:
				_onGetSlightLeakTimerValueGasFlowRateContinuation(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE:
				_onGetSlightLeakTimerValueWithoutPressureIncrease(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_SHUT_OFF_REASON_LOG:
				_onGetShutOffReasonLog(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA:
				_onGetMaximumValueOfSupplyPressureData(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA:
				_onGetMinimumValueOfSupplyPressureData(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA:
				_onGetCurrentValueOfSupplyPressureData(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA:
				_onGetMaximumValueOfBlockPressureData(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA:
				_onGetMinimumValueOfBlockPressureData(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA:
				_onGetCurrentValueOfBlockPressureData(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME:
				_onGetNumberOfBlockPressureSupplyPressureErrorDaysTime(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_TEST_CALL_SETTING:
				_onGetTestCallSetting(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates integral gas consumption in units of 0.0001 m3.<br><br>0.0x005F5E0FF (0.9999,9999 m3)<br><br>Name : Integral gas consumption of metering data 1<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetIntegralGasConsumptionOfMeteringData1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIntegralGasConsumptionOfMeteringData1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIntegralGasConsumptionOfMeteringData1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates integral gas consumption in units of 0.001 m3.<br><br>0.0x005F5E0FF (0.99999,999 m3)<br><br>Name : Integral gas consumption of metering data 2<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		protected void onGetIntegralGasConsumptionOfMeteringData2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetIntegralGasConsumptionOfMeteringData2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetIntegralGasConsumptionOfMeteringData2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates status where meter detected metering data error.<br><br>Error detection status found = 0x41 Error detection status not found = 0x42<br><br>Name : Error detection statusof metering data<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetErrorDetectionStatusofMeteringData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetErrorDetectionStatusofMeteringData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetErrorDetectionStatusofMeteringData(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br><br>0.0xFFFFFFFF<br><br>Name : Security data 1<br>EPC : 0xE3<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSecurityData1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSecurityData1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSecurityData1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br><br>0.0xFFFFFFFF<br><br>Name : Security data 2<br>EPC : 0xE4<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSecurityData2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSecurityData2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSecurityData2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br><br>Center valve shut-off status found = 0x41 Center valve shut-off status not found = 0x42<br><br>Name : Center valve shut-off status<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetCenterValveShutOffStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCenterValveShutOffStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCenterValveShutOffStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br><br>Center valve shut-off reset enable = 0x41 Center valve shut-off reset not enable = 0x42<br><br>Name : Center valve shut-off recovery permission setting status<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetCenterValveShutOffRecoveryPermissionSettingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCenterValveShutOffRecoveryPermissionSettingStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCenterValveShutOffRecoveryPermissionSettingStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off.<br><br>Emergency valve shut-off status found = 0x41 Emergency valve shut-off status not found = 0x42<br><br>Name : Emergency valve shut-off status<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetEmergencyValveShutOffStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetEmergencyValveShutOffStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetEmergencyValveShutOffStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates open/close status of shut-off valve.<br><br>Shut-off valve open status = 0x41 Shut-off valve close status = 0x42<br><br>Name : Shut-off valve open/close status<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetShutOffValveOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetShutOffValveOpenCloseStatus(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetShutOffValveOpenCloseStatus(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates status as warning where residual volume is very small.<br><br>Residual volume control warning level 1 0x31 Residual volume control warning level 2 0x32 Residual volume control warning level 3 0x33 No residual volume control warning 0x42<br><br>Name : Residual volume control warning<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		protected void onGetResidualVolumeControlWarning(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetResidualVolumeControlWarning(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetResidualVolumeControlWarning(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets �gSmall residual volume detection level 1�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 1<br>EPC : 0xEA<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfResidualVolumeControlWarningLevel1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfResidualVolumeControlWarningLevel1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfResidualVolumeControlWarningLevel1(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets �gSmall residual volume detection level 1�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 1<br>EPC : 0xEA<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfResidualVolumeControlWarningLevel1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfResidualVolumeControlWarningLevel1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfResidualVolumeControlWarningLevel1(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 2<br>EPC : 0xEB<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfResidualVolumeControlWarningLevel2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfResidualVolumeControlWarningLevel2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfResidualVolumeControlWarningLevel2(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 2<br>EPC : 0xEB<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfResidualVolumeControlWarningLevel2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfResidualVolumeControlWarningLevel2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfResidualVolumeControlWarningLevel2(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 3<br>EPC : 0xEC<br>Data Type : unsigned char x3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetSetValueOfResidualVolumeControlWarningLevel3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetSetValueOfResidualVolumeControlWarningLevel3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetSetValueOfResidualVolumeControlWarningLevel3(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 3<br>EPC : 0xEC<br>Data Type : unsigned char x3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetSetValueOfResidualVolumeControlWarningLevel3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSetValueOfResidualVolumeControlWarningLevel3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSetValueOfResidualVolumeControlWarningLevel3(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates number of days on which gas flow rate is continued.<br><br>0.0xFD (0.253) (0 to 253 days)<br><br>Name : Slight leak timer value (gas flow rate continuation)<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSlightLeakTimerValueGasFlowRateContinuation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSlightLeakTimerValueGasFlowRateContinuation(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSlightLeakTimerValueGasFlowRateContinuation(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br><br>0.0xFD (0.253) (0 to 253 days)<br><br>Name : Slight leak timer value (without pressure increase)<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetSlightLeakTimerValueWithoutPressureIncrease(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetSlightLeakTimerValueWithoutPressureIncrease(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetSlightLeakTimerValueWithoutPressureIncrease(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs. Log 3: log 2: log 1<br><br>0xFF: 0xFF: 0xFF<br><br>Name : Shut-off reason log<br>EPC : 0xEF<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetShutOffReasonLog(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetShutOffReasonLog(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetShutOffReasonLog(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Maximum value of supply pressure data<br>EPC : 0xD0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMaximumValueOfSupplyPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMaximumValueOfSupplyPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMaximumValueOfSupplyPressureData(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Minimum value of supply pressure data<br>EPC : 0xD1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMinimumValueOfSupplyPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMinimumValueOfSupplyPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMinimumValueOfSupplyPressureData(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Current value of supply pressure data<br>EPC : 0xD2<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetCurrentValueOfSupplyPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCurrentValueOfSupplyPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCurrentValueOfSupplyPressureData(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Maximum value of block pressure data<br>EPC : 0xD3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMaximumValueOfBlockPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMaximumValueOfBlockPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMaximumValueOfBlockPressureData(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Minimum value of block pressure data<br>EPC : 0xD4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetMinimumValueOfBlockPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMinimumValueOfBlockPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMinimumValueOfBlockPressureData(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates current value of block pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Current value of block pressure data<br>EPC : 0xD5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetCurrentValueOfBlockPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetCurrentValueOfBlockPressureData(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetCurrentValueOfBlockPressureData(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte each.<br><br>Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times<br><br>Name : Number of block pressure/supply pressure error days:time<br>EPC : 0xD6<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		protected void onGetNumberOfBlockPressureSupplyPressureErrorDaysTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetNumberOfBlockPressureSupplyPressureErrorDaysTime(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetNumberOfBlockPressureSupplyPressureErrorDaysTime(eoj, tid, esv, epc, pdc, edt);
			onInvokedOnGetMethod(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Performs test call operation setup.<br><br>Test call operation ON 0x41 Test call operation OFF 0x42<br><br>Name : Test call setting<br>EPC : 0xD7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onSetTestCallSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetTestCallSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetTestCallSetting(eoj, tid, esv, epc, pdc, edt, success);
			onInvokedOnSetMethod(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Performs test call operation setup.<br><br>Test call operation ON 0x41 Test call operation OFF 0x42<br><br>Name : Test call setting<br>EPC : 0xD7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		protected void onGetTestCallSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetTestCallSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetTestCallSetting(eoj, tid, esv, epc, pdc, edt);
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
		 * Sets �gSmall residual volume detection level 1�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 1<br>EPC : 0xEA<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel1(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 2<br>EPC : 0xEB<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel2(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 3<br>EPC : 0xEC<br>Data Type : unsigned char x3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel3(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		/**
		 * Performs test call operation setup.<br><br>Test call operation ON 0x41 Test call operation OFF 0x42<br><br>Name : Test call setting<br>EPC : 0xD7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Setter reqSetTestCallSetting(byte[] edt) {
			addProperty(EPC_TEST_CALL_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * This property indicates integral gas consumption in units of 0.0001 m3.<br><br>0.0x005F5E0FF (0.9999,9999 m3)<br><br>Name : Integral gas consumption of metering data 1<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetIntegralGasConsumptionOfMeteringData1() {
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1);
			return this;
		}
		/**
		 * This property indicates integral gas consumption in units of 0.001 m3.<br><br>0.0x005F5E0FF (0.99999,999 m3)<br><br>Name : Integral gas consumption of metering data 2<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Getter reqGetIntegralGasConsumptionOfMeteringData2() {
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2);
			return this;
		}
		/**
		 * This property indicates status where meter detected metering data error.<br><br>Error detection status found = 0x41 Error detection status not found = 0x42<br><br>Name : Error detection statusof metering data<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetErrorDetectionStatusofMeteringData() {
			addProperty(EPC_ERROR_DETECTION_STATUSOF_METERING_DATA);
			return this;
		}
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br><br>0.0xFFFFFFFF<br><br>Name : Security data 1<br>EPC : 0xE3<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSecurityData1() {
			addProperty(EPC_SECURITY_DATA1);
			return this;
		}
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br><br>0.0xFFFFFFFF<br><br>Name : Security data 2<br>EPC : 0xE4<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSecurityData2() {
			addProperty(EPC_SECURITY_DATA2);
			return this;
		}
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br><br>Center valve shut-off status found = 0x41 Center valve shut-off status not found = 0x42<br><br>Name : Center valve shut-off status<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetCenterValveShutOffStatus() {
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br><br>Center valve shut-off reset enable = 0x41 Center valve shut-off reset not enable = 0x42<br><br>Name : Center valve shut-off recovery permission setting status<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetCenterValveShutOffRecoveryPermissionSettingStatus() {
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS);
			return this;
		}
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off.<br><br>Emergency valve shut-off status found = 0x41 Emergency valve shut-off status not found = 0x42<br><br>Name : Emergency valve shut-off status<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetEmergencyValveShutOffStatus() {
			addProperty(EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		/**
		 * This property indicates open/close status of shut-off valve.<br><br>Shut-off valve open status = 0x41 Shut-off valve close status = 0x42<br><br>Name : Shut-off valve open/close status<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetShutOffValveOpenCloseStatus() {
			addProperty(EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS);
			return this;
		}
		/**
		 * This property indicates status as warning where residual volume is very small.<br><br>Residual volume control warning level 1 0x31 Residual volume control warning level 2 0x32 Residual volume control warning level 3 0x33 No residual volume control warning 0x42<br><br>Name : Residual volume control warning<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Getter reqGetResidualVolumeControlWarning() {
			addProperty(EPC_RESIDUAL_VOLUME_CONTROL_WARNING);
			return this;
		}
		/**
		 * Sets �gSmall residual volume detection level 1�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 1<br>EPC : 0xEA<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel1() {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1);
			return this;
		}
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 2<br>EPC : 0xEB<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel2() {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2);
			return this;
		}
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 3<br>EPC : 0xEC<br>Data Type : unsigned char x3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel3() {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3);
			return this;
		}
		/**
		 * This property indicates number of days on which gas flow rate is continued.<br><br>0.0xFD (0.253) (0 to 253 days)<br><br>Name : Slight leak timer value (gas flow rate continuation)<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSlightLeakTimerValueGasFlowRateContinuation() {
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION);
			return this;
		}
		/**
		 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br><br>0.0xFD (0.253) (0 to 253 days)<br><br>Name : Slight leak timer value (without pressure increase)<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetSlightLeakTimerValueWithoutPressureIncrease() {
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE);
			return this;
		}
		/**
		 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs. Log 3: log 2: log 1<br><br>0xFF: 0xFF: 0xFF<br><br>Name : Shut-off reason log<br>EPC : 0xEF<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetShutOffReasonLog() {
			addProperty(EPC_SHUT_OFF_REASON_LOG);
			return this;
		}
		/**
		 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Maximum value of supply pressure data<br>EPC : 0xD0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMaximumValueOfSupplyPressureData() {
			addProperty(EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Minimum value of supply pressure data<br>EPC : 0xD1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMinimumValueOfSupplyPressureData() {
			addProperty(EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		/**
		 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Current value of supply pressure data<br>EPC : 0xD2<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetCurrentValueOfSupplyPressureData() {
			addProperty(EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Maximum value of block pressure data<br>EPC : 0xD3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMaximumValueOfBlockPressureData() {
			addProperty(EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Minimum value of block pressure data<br>EPC : 0xD4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetMinimumValueOfBlockPressureData() {
			addProperty(EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		/**
		 * This property indicates current value of block pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Current value of block pressure data<br>EPC : 0xD5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetCurrentValueOfBlockPressureData() {
			addProperty(EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		/**
		 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte each.<br><br>Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times<br><br>Name : Number of block pressure/supply pressure error days:time<br>EPC : 0xD6<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Getter reqGetNumberOfBlockPressureSupplyPressureErrorDaysTime() {
			addProperty(EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME);
			return this;
		}
		/**
		 * Performs test call operation setup.<br><br>Test call operation ON 0x41 Test call operation OFF 0x42<br><br>Name : Test call setting<br>EPC : 0xD7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Getter reqGetTestCallSetting() {
			addProperty(EPC_TEST_CALL_SETTING);
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
		 * This property indicates integral gas consumption in units of 0.0001 m3.<br><br>0.0x005F5E0FF (0.9999,9999 m3)<br><br>Name : Integral gas consumption of metering data 1<br>EPC : 0xE0<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformIntegralGasConsumptionOfMeteringData1();
		/**
		 * This property indicates integral gas consumption in units of 0.001 m3.<br><br>0.0x005F5E0FF (0.99999,999 m3)<br><br>Name : Integral gas consumption of metering data 2<br>EPC : 0xE1<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : mandatory<br>
		 */
		public Informer reqInformIntegralGasConsumptionOfMeteringData2();
		/**
		 * This property indicates status where meter detected metering data error.<br><br>Error detection status found = 0x41 Error detection status not found = 0x42<br><br>Name : Error detection statusof metering data<br>EPC : 0xE2<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformErrorDetectionStatusofMeteringData();
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br><br>0.0xFFFFFFFF<br><br>Name : Security data 1<br>EPC : 0xE3<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSecurityData1();
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br><br>0.0xFFFFFFFF<br><br>Name : Security data 2<br>EPC : 0xE4<br>Data Type : unsigned long<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSecurityData2();
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br><br>Center valve shut-off status found = 0x41 Center valve shut-off status not found = 0x42<br><br>Name : Center valve shut-off status<br>EPC : 0xE5<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformCenterValveShutOffStatus();
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br><br>Center valve shut-off reset enable = 0x41 Center valve shut-off reset not enable = 0x42<br><br>Name : Center valve shut-off recovery permission setting status<br>EPC : 0xE6<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformCenterValveShutOffRecoveryPermissionSettingStatus();
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off.<br><br>Emergency valve shut-off status found = 0x41 Emergency valve shut-off status not found = 0x42<br><br>Name : Emergency valve shut-off status<br>EPC : 0xE7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformEmergencyValveShutOffStatus();
		/**
		 * This property indicates open/close status of shut-off valve.<br><br>Shut-off valve open status = 0x41 Shut-off valve close status = 0x42<br><br>Name : Shut-off valve open/close status<br>EPC : 0xE8<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformShutOffValveOpenCloseStatus();
		/**
		 * This property indicates status as warning where residual volume is very small.<br><br>Residual volume control warning level 1 0x31 Residual volume control warning level 2 0x32 Residual volume control warning level 3 0x33 No residual volume control warning 0x42<br><br>Name : Residual volume control warning<br>EPC : 0xE9<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br><br>Announcement at status change<br>
		 */
		public Informer reqInformResidualVolumeControlWarning();
		/**
		 * Sets �gSmall residual volume detection level 1�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 1<br>EPC : 0xEA<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel1();
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 2<br>EPC : 0xEB<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel2();
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br><br>0.0xFFFFFF (0.16,777,215)<br><br>Name : Set value of residual volume control warning level 3<br>EPC : 0xEC<br>Data Type : unsigned char x3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel3();
		/**
		 * This property indicates number of days on which gas flow rate is continued.<br><br>0.0xFD (0.253) (0 to 253 days)<br><br>Name : Slight leak timer value (gas flow rate continuation)<br>EPC : 0xED<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSlightLeakTimerValueGasFlowRateContinuation();
		/**
		 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br><br>0.0xFD (0.253) (0 to 253 days)<br><br>Name : Slight leak timer value (without pressure increase)<br>EPC : 0xEE<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformSlightLeakTimerValueWithoutPressureIncrease();
		/**
		 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs. Log 3: log 2: log 1<br><br>0xFF: 0xFF: 0xFF<br><br>Name : Shut-off reason log<br>EPC : 0xEF<br>Data Type : unsigned char x 3<br>Data Size(Byte) : 3 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformShutOffReasonLog();
		/**
		 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Maximum value of supply pressure data<br>EPC : 0xD0<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMaximumValueOfSupplyPressureData();
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Minimum value of supply pressure data<br>EPC : 0xD1<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMinimumValueOfSupplyPressureData();
		/**
		 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Current value of supply pressure data<br>EPC : 0xD2<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformCurrentValueOfSupplyPressureData();
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Maximum value of block pressure data<br>EPC : 0xD3<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMaximumValueOfBlockPressureData();
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Minimum value of block pressure data<br>EPC : 0xD4<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformMinimumValueOfBlockPressureData();
		/**
		 * This property indicates current value of block pressure data in units of 0.01 kPa.<br><br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)<br><br>Name : Current value of block pressure data<br>EPC : 0xD5<br>Data Type : unsigned short<br>Data Size(Byte) : 2 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformCurrentValueOfBlockPressureData();
		/**
		 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte each.<br><br>Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times<br><br>Name : Number of block pressure/supply pressure error days:time<br>EPC : 0xD6<br>Data Type : unsigned char x 4<br>Data Size(Byte) : 4 bytes<br><br>AccessRule<br>Announce : undefined<br>Set : undefined<br>Get : optional<br>
		 */
		public Informer reqInformNumberOfBlockPressureSupplyPressureErrorDaysTime();
		/**
		 * Performs test call operation setup.<br><br>Test call operation ON 0x41 Test call operation OFF 0x42<br><br>Name : Test call setting<br>EPC : 0xD7<br>Data Type : unsigned char<br>Data Size(Byte) : 1 byte<br><br>AccessRule<br>Announce : undefined<br>Set : optional<br>Get : optional<br>
		 */
		public Informer reqInformTestCallSetting();
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
		public Informer reqInformIntegralGasConsumptionOfMeteringData1() {
			byte epc = EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1;
			byte[] edt = _getIntegralGasConsumptionOfMeteringData1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformIntegralGasConsumptionOfMeteringData2() {
			byte epc = EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2;
			byte[] edt = _getIntegralGasConsumptionOfMeteringData2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformErrorDetectionStatusofMeteringData() {
			byte epc = EPC_ERROR_DETECTION_STATUSOF_METERING_DATA;
			byte[] edt = _getErrorDetectionStatusofMeteringData(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSecurityData1() {
			byte epc = EPC_SECURITY_DATA1;
			byte[] edt = _getSecurityData1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformSecurityData2() {
			byte epc = EPC_SECURITY_DATA2;
			byte[] edt = _getSecurityData2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformCenterValveShutOffStatus() {
			byte epc = EPC_CENTER_VALVE_SHUT_OFF_STATUS;
			byte[] edt = _getCenterValveShutOffStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCenterValveShutOffRecoveryPermissionSettingStatus() {
			byte epc = EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS;
			byte[] edt = _getCenterValveShutOffRecoveryPermissionSettingStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformEmergencyValveShutOffStatus() {
			byte epc = EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS;
			byte[] edt = _getEmergencyValveShutOffStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShutOffValveOpenCloseStatus() {
			byte epc = EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS;
			byte[] edt = _getShutOffValveOpenCloseStatus(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformResidualVolumeControlWarning() {
			byte epc = EPC_RESIDUAL_VOLUME_CONTROL_WARNING;
			byte[] edt = _getResidualVolumeControlWarning(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel1() {
			byte epc = EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1;
			byte[] edt = _getSetValueOfResidualVolumeControlWarningLevel1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel2() {
			byte epc = EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2;
			byte[] edt = _getSetValueOfResidualVolumeControlWarningLevel2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel3() {
			byte epc = EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3;
			byte[] edt = _getSetValueOfResidualVolumeControlWarningLevel3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformSlightLeakTimerValueGasFlowRateContinuation() {
			byte epc = EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION;
			byte[] edt = _getSlightLeakTimerValueGasFlowRateContinuation(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSlightLeakTimerValueWithoutPressureIncrease() {
			byte epc = EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE;
			byte[] edt = _getSlightLeakTimerValueWithoutPressureIncrease(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShutOffReasonLog() {
			byte epc = EPC_SHUT_OFF_REASON_LOG;
			byte[] edt = _getShutOffReasonLog(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformMaximumValueOfSupplyPressureData() {
			byte epc = EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA;
			byte[] edt = _getMaximumValueOfSupplyPressureData(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMinimumValueOfSupplyPressureData() {
			byte epc = EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA;
			byte[] edt = _getMinimumValueOfSupplyPressureData(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformCurrentValueOfSupplyPressureData() {
			byte epc = EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA;
			byte[] edt = _getCurrentValueOfSupplyPressureData(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMaximumValueOfBlockPressureData() {
			byte epc = EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA;
			byte[] edt = _getMaximumValueOfBlockPressureData(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMinimumValueOfBlockPressureData() {
			byte epc = EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA;
			byte[] edt = _getMinimumValueOfBlockPressureData(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformCurrentValueOfBlockPressureData() {
			byte epc = EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA;
			byte[] edt = _getCurrentValueOfBlockPressureData(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformNumberOfBlockPressureSupplyPressureErrorDaysTime() {
			byte epc = EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME;
			byte[] edt = _getNumberOfBlockPressureSupplyPressureErrorDaysTime(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformTestCallSetting() {
			byte epc = EPC_TEST_CALL_SETTING;
			byte[] edt = _getTestCallSetting(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformIntegralGasConsumptionOfMeteringData1() {
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1);
			return this;
		}
		@Override
		public Informer reqInformIntegralGasConsumptionOfMeteringData2() {
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2);
			return this;
		}
		@Override
		public Informer reqInformErrorDetectionStatusofMeteringData() {
			addProperty(EPC_ERROR_DETECTION_STATUSOF_METERING_DATA);
			return this;
		}
		@Override
		public Informer reqInformSecurityData1() {
			addProperty(EPC_SECURITY_DATA1);
			return this;
		}
		@Override
		public Informer reqInformSecurityData2() {
			addProperty(EPC_SECURITY_DATA2);
			return this;
		}
		@Override
		public Informer reqInformCenterValveShutOffStatus() {
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		@Override
		public Informer reqInformCenterValveShutOffRecoveryPermissionSettingStatus() {
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS);
			return this;
		}
		@Override
		public Informer reqInformEmergencyValveShutOffStatus() {
			addProperty(EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		@Override
		public Informer reqInformShutOffValveOpenCloseStatus() {
			addProperty(EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Informer reqInformResidualVolumeControlWarning() {
			addProperty(EPC_RESIDUAL_VOLUME_CONTROL_WARNING);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel1() {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel2() {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2);
			return this;
		}
		@Override
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel3() {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3);
			return this;
		}
		@Override
		public Informer reqInformSlightLeakTimerValueGasFlowRateContinuation() {
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION);
			return this;
		}
		@Override
		public Informer reqInformSlightLeakTimerValueWithoutPressureIncrease() {
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE);
			return this;
		}
		@Override
		public Informer reqInformShutOffReasonLog() {
			addProperty(EPC_SHUT_OFF_REASON_LOG);
			return this;
		}
		@Override
		public Informer reqInformMaximumValueOfSupplyPressureData() {
			addProperty(EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		@Override
		public Informer reqInformMinimumValueOfSupplyPressureData() {
			addProperty(EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		@Override
		public Informer reqInformCurrentValueOfSupplyPressureData() {
			addProperty(EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		@Override
		public Informer reqInformMaximumValueOfBlockPressureData() {
			addProperty(EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		@Override
		public Informer reqInformMinimumValueOfBlockPressureData() {
			addProperty(EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		@Override
		public Informer reqInformCurrentValueOfBlockPressureData() {
			addProperty(EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		@Override
		public Informer reqInformNumberOfBlockPressureSupplyPressureErrorDaysTime() {
			addProperty(EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME);
			return this;
		}
		@Override
		public Informer reqInformTestCallSetting() {
			addProperty(EPC_TEST_CALL_SETTING);
			return this;
		}
	}
}
