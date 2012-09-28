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
	@SuppressWarnings("unused")
	private static final String TAG = LPGasMeter.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x83;

	protected static final byte EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1 = (byte)0xE0;
	protected static final byte EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2 = (byte)0xE1;
	protected static final byte EPC_ERROR_DETECTION_STATUSOF_METERING_DATA = (byte)0xE2;
	protected static final byte EPC_SECURITY_DATA1 = (byte)0xE3;
	protected static final byte EPC_SECURITY_DATA2 = (byte)0xE4;
	protected static final byte EPC_CENTER_VALVE_SHUT_OFF_STATUS = (byte)0xE5;
	protected static final byte EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS = (byte)0xE6;
	protected static final byte EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS = (byte)0xE7;
	protected static final byte EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS = (byte)0xE8;
	protected static final byte EPC_RESIDUAL_VOLUME_CONTROL_WARNING = (byte)0xE9;
	protected static final byte EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1 = (byte)0xEA;
	protected static final byte EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2 = (byte)0xEB;
	protected static final byte EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3 = (byte)0xEC;
	protected static final byte EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION = (byte)0xED;
	protected static final byte EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE = (byte)0xEE;
	protected static final byte EPC_SHUT_OFF_REASON_LOG = (byte)0xEF;
	protected static final byte EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA = (byte)0xD0;
	protected static final byte EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA = (byte)0xD1;
	protected static final byte EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA = (byte)0xD2;
	protected static final byte EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA = (byte)0xD3;
	protected static final byte EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA = (byte)0xD4;
	protected static final byte EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA = (byte)0xD5;
	protected static final byte EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME = (byte)0xD6;
	protected static final byte EPC_TEST_CALL_SETTING = (byte)0xD7;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates integral gas consumption in units of 0.0001 m3.<br>0.0x005F5E0FF (0.9999,9999 m3)
	 */
	protected abstract byte[] getIntegralGasConsumptionOfMeteringData1();
	/**
	 * This property indicates integral gas consumption in units of 0.001 m3.<br>0.0x005F5E0FF (0.99999,999 m3)
	 */
	protected abstract byte[] getIntegralGasConsumptionOfMeteringData2();
	/**
	 * This property indicates status where meter detected metering data error.<br>Error detection status found = 0x41 Error detection status not found = 0x42
	 */
	protected byte[] getErrorDetectionStatusofMeteringData() {return null;}
	/**
	 * This property indicates security data to define security information on meter operation by bit allocation.<br>0.0xFFFFFFFF
	 */
	protected byte[] getSecurityData1() {return null;}
	/**
	 * This property indicates security data to define security information on meter operation by bit allocation.<br>0.0xFFFFFFFF
	 */
	protected byte[] getSecurityData2() {return null;}
	/**
	 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>Center valve shut-off status found = 0x41 Center valve shut-off status not found = 0x42
	 */
	protected byte[] getCenterValveShutOffStatus() {return null;}
	/**
	 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>Center valve shut-off reset enable = 0x41 Center valve shut-off reset not enable = 0x42
	 */
	protected byte[] getCenterValveShutOffRecoveryPermissionSettingStatus() {return null;}
	/**
	 * This property indicates status where gas shut-off valve of meter has been shut off.<br>Emergency valve shut-off status found = 0x41 Emergency valve shut-off status not found = 0x42
	 */
	protected byte[] getEmergencyValveShutOffStatus() {return null;}
	/**
	 * This property indicates open/close status of shut-off valve.<br>Shut-off valve open status = 0x41 Shut-off valve close status = 0x42
	 */
	protected byte[] getShutOffValveOpenCloseStatus() {return null;}
	/**
	 * This property indicates status as warning where residual volume is very small.<br>Residual volume control warning level 1 0x31 Residual volume control warning level 2 0x32 Residual volume control warning level 3 0x33 No residual volume control warning 0x42
	 */
	protected byte[] getResidualVolumeControlWarning() {return null;}
	/**
	 * Sets �gSmall residual volume detection level 1�h.<br>0.0xFFFFFF (0.16,777,215)
	 */
	protected boolean setSetValueOfResidualVolumeControlWarningLevel1(byte[] edt) {return false;}
	/**
	 * Sets �gSmall residual volume detection level 1�h.<br>0.0xFFFFFF (0.16,777,215)
	 */
	protected byte[] getSetValueOfResidualVolumeControlWarningLevel1() {return null;}
	/**
	 * Sets �gSmall residual volume detection level 2�h.<br>0.0xFFFFFF (0.16,777,215)
	 */
	protected boolean setSetValueOfResidualVolumeControlWarningLevel2(byte[] edt) {return false;}
	/**
	 * Sets �gSmall residual volume detection level 2�h.<br>0.0xFFFFFF (0.16,777,215)
	 */
	protected byte[] getSetValueOfResidualVolumeControlWarningLevel2() {return null;}
	/**
	 * Sets �gSmall residual volume detection level 3�h.<br>0.0xFFFFFF (0.16,777,215)
	 */
	protected boolean setSetValueOfResidualVolumeControlWarningLevel3(byte[] edt) {return false;}
	/**
	 * Sets �gSmall residual volume detection level 3�h.<br>0.0xFFFFFF (0.16,777,215)
	 */
	protected byte[] getSetValueOfResidualVolumeControlWarningLevel3() {return null;}
	/**
	 * This property indicates number of days on which gas flow rate is continued.<br>0.0xFD (0.253) (0 to 253 days)
	 */
	protected byte[] getSlightLeakTimerValueGasFlowRateContinuation() {return null;}
	/**
	 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br>0.0xFD (0.253) (0 to 253 days)
	 */
	protected byte[] getSlightLeakTimerValueWithoutPressureIncrease() {return null;}
	/**
	 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs. Log 3: log 2: log 1<br>0xFF: 0xFF: 0xFF
	 */
	protected byte[] getShutOffReasonLog() {return null;}
	/**
	 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
	 */
	protected byte[] getMaximumValueOfSupplyPressureData() {return null;}
	/**
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
	 */
	protected byte[] getMinimumValueOfSupplyPressureData() {return null;}
	/**
	 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
	 */
	protected byte[] getCurrentValueOfSupplyPressureData() {return null;}
	/**
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
	 */
	protected byte[] getMaximumValueOfBlockPressureData() {return null;}
	/**
	 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
	 */
	protected byte[] getMinimumValueOfBlockPressureData() {return null;}
	/**
	 * This property indicates current value of block pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
	 */
	protected byte[] getCurrentValueOfBlockPressureData() {return null;}
	/**
	 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte each.<br>Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times
	 */
	protected byte[] getNumberOfBlockPressureSupplyPressureErrorDaysTime() {return null;}
	/**
	 * Performs test call operation setup.<br>Test call operation ON 0x41 Test call operation OFF 0x42
	 */
	protected boolean setTestCallSetting(byte[] edt) {return false;}
	/**
	 * Performs test call operation setup.<br>Test call operation ON 0x41 Test call operation OFF 0x42
	 */
	protected byte[] getTestCallSetting() {return null;}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1:
			res.addProperty(epc, edt, setSetValueOfResidualVolumeControlWarningLevel1(edt));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2:
			res.addProperty(epc, edt, setSetValueOfResidualVolumeControlWarningLevel2(edt));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3:
			res.addProperty(epc, edt, setSetValueOfResidualVolumeControlWarningLevel3(edt));
			break;
		case EPC_TEST_CALL_SETTING:
			res.addProperty(epc, edt, setTestCallSetting(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1:
			edt = getIntegralGasConsumptionOfMeteringData1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2:
			edt = getIntegralGasConsumptionOfMeteringData2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_ERROR_DETECTION_STATUSOF_METERING_DATA:
			edt = getErrorDetectionStatusofMeteringData();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SECURITY_DATA1:
			edt = getSecurityData1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_SECURITY_DATA2:
			edt = getSecurityData2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_CENTER_VALVE_SHUT_OFF_STATUS:
			edt = getCenterValveShutOffStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS:
			edt = getCenterValveShutOffRecoveryPermissionSettingStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS:
			edt = getEmergencyValveShutOffStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS:
			edt = getShutOffValveOpenCloseStatus();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_RESIDUAL_VOLUME_CONTROL_WARNING:
			edt = getResidualVolumeControlWarning();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1:
			edt = getSetValueOfResidualVolumeControlWarningLevel1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2:
			edt = getSetValueOfResidualVolumeControlWarningLevel2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3:
			edt = getSetValueOfResidualVolumeControlWarningLevel3();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION:
			edt = getSlightLeakTimerValueGasFlowRateContinuation();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE:
			edt = getSlightLeakTimerValueWithoutPressureIncrease();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_SHUT_OFF_REASON_LOG:
			edt = getShutOffReasonLog();
			res.addProperty(epc, edt, (edt != null && (edt.length == 3)));
			break;
		case EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA:
			edt = getMaximumValueOfSupplyPressureData();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA:
			edt = getMinimumValueOfSupplyPressureData();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA:
			edt = getCurrentValueOfSupplyPressureData();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA:
			edt = getMaximumValueOfBlockPressureData();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA:
			edt = getMinimumValueOfBlockPressureData();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA:
			edt = getCurrentValueOfBlockPressureData();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME:
			edt = getNumberOfBlockPressureSupplyPressureErrorDaysTime();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_TEST_CALL_SETTING:
			edt = getTestCallSetting();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1:
				onSetSetValueOfResidualVolumeControlWarningLevel1(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2:
				onSetSetValueOfResidualVolumeControlWarningLevel2(eoj, tid, (pdc != 0));
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3:
				onSetSetValueOfResidualVolumeControlWarningLevel3(eoj, tid, (pdc != 0));
				break;
			case EPC_TEST_CALL_SETTING:
				onSetTestCallSetting(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1:
				onGetIntegralGasConsumptionOfMeteringData1(eoj, tid, pdc, edt);
				break;
			case EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2:
				onGetIntegralGasConsumptionOfMeteringData2(eoj, tid, pdc, edt);
				break;
			case EPC_ERROR_DETECTION_STATUSOF_METERING_DATA:
				onGetErrorDetectionStatusofMeteringData(eoj, tid, pdc, edt);
				break;
			case EPC_SECURITY_DATA1:
				onGetSecurityData1(eoj, tid, pdc, edt);
				break;
			case EPC_SECURITY_DATA2:
				onGetSecurityData2(eoj, tid, pdc, edt);
				break;
			case EPC_CENTER_VALVE_SHUT_OFF_STATUS:
				onGetCenterValveShutOffStatus(eoj, tid, pdc, edt);
				break;
			case EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS:
				onGetCenterValveShutOffRecoveryPermissionSettingStatus(eoj, tid, pdc, edt);
				break;
			case EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS:
				onGetEmergencyValveShutOffStatus(eoj, tid, pdc, edt);
				break;
			case EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS:
				onGetShutOffValveOpenCloseStatus(eoj, tid, pdc, edt);
				break;
			case EPC_RESIDUAL_VOLUME_CONTROL_WARNING:
				onGetResidualVolumeControlWarning(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1:
				onGetSetValueOfResidualVolumeControlWarningLevel1(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2:
				onGetSetValueOfResidualVolumeControlWarningLevel2(eoj, tid, pdc, edt);
				break;
			case EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3:
				onGetSetValueOfResidualVolumeControlWarningLevel3(eoj, tid, pdc, edt);
				break;
			case EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION:
				onGetSlightLeakTimerValueGasFlowRateContinuation(eoj, tid, pdc, edt);
				break;
			case EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE:
				onGetSlightLeakTimerValueWithoutPressureIncrease(eoj, tid, pdc, edt);
				break;
			case EPC_SHUT_OFF_REASON_LOG:
				onGetShutOffReasonLog(eoj, tid, pdc, edt);
				break;
			case EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA:
				onGetMaximumValueOfSupplyPressureData(eoj, tid, pdc, edt);
				break;
			case EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA:
				onGetMinimumValueOfSupplyPressureData(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA:
				onGetCurrentValueOfSupplyPressureData(eoj, tid, pdc, edt);
				break;
			case EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA:
				onGetMaximumValueOfBlockPressureData(eoj, tid, pdc, edt);
				break;
			case EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA:
				onGetMinimumValueOfBlockPressureData(eoj, tid, pdc, edt);
				break;
			case EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA:
				onGetCurrentValueOfBlockPressureData(eoj, tid, pdc, edt);
				break;
			case EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME:
				onGetNumberOfBlockPressureSupplyPressureErrorDaysTime(eoj, tid, pdc, edt);
				break;
			case EPC_TEST_CALL_SETTING:
				onGetTestCallSetting(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates integral gas consumption in units of 0.0001 m3.<br>0.0x005F5E0FF (0.9999,9999 m3)
		 */
		protected void onGetIntegralGasConsumptionOfMeteringData1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates integral gas consumption in units of 0.001 m3.<br>0.0x005F5E0FF (0.99999,999 m3)
		 */
		protected void onGetIntegralGasConsumptionOfMeteringData2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates status where meter detected metering data error.<br>Error detection status found = 0x41 Error detection status not found = 0x42
		 */
		protected void onGetErrorDetectionStatusofMeteringData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>0.0xFFFFFFFF
		 */
		protected void onGetSecurityData1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>0.0xFFFFFFFF
		 */
		protected void onGetSecurityData2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>Center valve shut-off status found = 0x41 Center valve shut-off status not found = 0x42
		 */
		protected void onGetCenterValveShutOffStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>Center valve shut-off reset enable = 0x41 Center valve shut-off reset not enable = 0x42
		 */
		protected void onGetCenterValveShutOffRecoveryPermissionSettingStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off.<br>Emergency valve shut-off status found = 0x41 Emergency valve shut-off status not found = 0x42
		 */
		protected void onGetEmergencyValveShutOffStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates open/close status of shut-off valve.<br>Shut-off valve open status = 0x41 Shut-off valve close status = 0x42
		 */
		protected void onGetShutOffValveOpenCloseStatus(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates status as warning where residual volume is very small.<br>Residual volume control warning level 1 0x31 Residual volume control warning level 2 0x32 Residual volume control warning level 3 0x33 No residual volume control warning 0x42
		 */
		protected void onGetResidualVolumeControlWarning(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets �gSmall residual volume detection level 1�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		protected void onSetSetValueOfResidualVolumeControlWarningLevel1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets �gSmall residual volume detection level 1�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		protected void onGetSetValueOfResidualVolumeControlWarningLevel1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		protected void onSetSetValueOfResidualVolumeControlWarningLevel2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		protected void onGetSetValueOfResidualVolumeControlWarningLevel2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		protected void onSetSetValueOfResidualVolumeControlWarningLevel3(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		protected void onGetSetValueOfResidualVolumeControlWarningLevel3(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates number of days on which gas flow rate is continued.<br>0.0xFD (0.253) (0 to 253 days)
		 */
		protected void onGetSlightLeakTimerValueGasFlowRateContinuation(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br>0.0xFD (0.253) (0 to 253 days)
		 */
		protected void onGetSlightLeakTimerValueWithoutPressureIncrease(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs. Log 3: log 2: log 1<br>0xFF: 0xFF: 0xFF
		 */
		protected void onGetShutOffReasonLog(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		protected void onGetMaximumValueOfSupplyPressureData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		protected void onGetMinimumValueOfSupplyPressureData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		protected void onGetCurrentValueOfSupplyPressureData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		protected void onGetMaximumValueOfBlockPressureData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		protected void onGetMinimumValueOfBlockPressureData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates current value of block pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		protected void onGetCurrentValueOfBlockPressureData(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte each.<br>Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times
		 */
		protected void onGetNumberOfBlockPressureSupplyPressureErrorDaysTime(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Performs test call operation setup.<br>Test call operation ON 0x41 Test call operation OFF 0x42
		 */
		protected void onSetTestCallSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Performs test call operation setup.<br>Test call operation ON 0x41 Test call operation OFF 0x42
		 */
		protected void onGetTestCallSetting(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Sets �gSmall residual volume detection level 1�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel1(byte[] edt);
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel2(byte[] edt);
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel3(byte[] edt);
		/**
		 * Performs test call operation setup.<br>Test call operation ON 0x41 Test call operation OFF 0x42
		 */
		public Setter reqSetTestCallSetting(byte[] edt);

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
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel1(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1, edt, setSetValueOfResidualVolumeControlWarningLevel1(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel2(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2, edt, setSetValueOfResidualVolumeControlWarningLevel2(edt));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel3(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3, edt, setSetValueOfResidualVolumeControlWarningLevel3(edt));
			return this;
		}
		@Override
		public Setter reqSetTestCallSetting(byte[] edt) {
			addProperty(EPC_TEST_CALL_SETTING, edt, setTestCallSetting(edt));
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
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel1(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel2(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Setter reqSetSetValueOfResidualVolumeControlWarningLevel3(byte[] edt) {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Setter reqSetTestCallSetting(byte[] edt) {
			addProperty(EPC_TEST_CALL_SETTING, edt, (edt != null && (edt.length == 1)));
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
		 * This property indicates integral gas consumption in units of 0.0001 m3.<br>0.0x005F5E0FF (0.9999,9999 m3)
		 */
		public Getter reqGetIntegralGasConsumptionOfMeteringData1();
		/**
		 * This property indicates integral gas consumption in units of 0.001 m3.<br>0.0x005F5E0FF (0.99999,999 m3)
		 */
		public Getter reqGetIntegralGasConsumptionOfMeteringData2();
		/**
		 * This property indicates status where meter detected metering data error.<br>Error detection status found = 0x41 Error detection status not found = 0x42
		 */
		public Getter reqGetErrorDetectionStatusofMeteringData();
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>0.0xFFFFFFFF
		 */
		public Getter reqGetSecurityData1();
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>0.0xFFFFFFFF
		 */
		public Getter reqGetSecurityData2();
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>Center valve shut-off status found = 0x41 Center valve shut-off status not found = 0x42
		 */
		public Getter reqGetCenterValveShutOffStatus();
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>Center valve shut-off reset enable = 0x41 Center valve shut-off reset not enable = 0x42
		 */
		public Getter reqGetCenterValveShutOffRecoveryPermissionSettingStatus();
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off.<br>Emergency valve shut-off status found = 0x41 Emergency valve shut-off status not found = 0x42
		 */
		public Getter reqGetEmergencyValveShutOffStatus();
		/**
		 * This property indicates open/close status of shut-off valve.<br>Shut-off valve open status = 0x41 Shut-off valve close status = 0x42
		 */
		public Getter reqGetShutOffValveOpenCloseStatus();
		/**
		 * This property indicates status as warning where residual volume is very small.<br>Residual volume control warning level 1 0x31 Residual volume control warning level 2 0x32 Residual volume control warning level 3 0x33 No residual volume control warning 0x42
		 */
		public Getter reqGetResidualVolumeControlWarning();
		/**
		 * Sets �gSmall residual volume detection level 1�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel1();
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel2();
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel3();
		/**
		 * This property indicates number of days on which gas flow rate is continued.<br>0.0xFD (0.253) (0 to 253 days)
		 */
		public Getter reqGetSlightLeakTimerValueGasFlowRateContinuation();
		/**
		 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br>0.0xFD (0.253) (0 to 253 days)
		 */
		public Getter reqGetSlightLeakTimerValueWithoutPressureIncrease();
		/**
		 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs. Log 3: log 2: log 1<br>0xFF: 0xFF: 0xFF
		 */
		public Getter reqGetShutOffReasonLog();
		/**
		 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Getter reqGetMaximumValueOfSupplyPressureData();
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Getter reqGetMinimumValueOfSupplyPressureData();
		/**
		 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Getter reqGetCurrentValueOfSupplyPressureData();
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Getter reqGetMaximumValueOfBlockPressureData();
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Getter reqGetMinimumValueOfBlockPressureData();
		/**
		 * This property indicates current value of block pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Getter reqGetCurrentValueOfBlockPressureData();
		/**
		 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte each.<br>Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times
		 */
		public Getter reqGetNumberOfBlockPressureSupplyPressureErrorDaysTime();
		/**
		 * Performs test call operation setup.<br>Test call operation ON 0x41 Test call operation OFF 0x42
		 */
		public Getter reqGetTestCallSetting();

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
		public Getter reqGetIntegralGasConsumptionOfMeteringData1() {
			byte[] edt = getIntegralGasConsumptionOfMeteringData1();
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetIntegralGasConsumptionOfMeteringData2() {
			byte[] edt = getIntegralGasConsumptionOfMeteringData2();
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetErrorDetectionStatusofMeteringData() {
			byte[] edt = getErrorDetectionStatusofMeteringData();
			addProperty(EPC_ERROR_DETECTION_STATUSOF_METERING_DATA, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSecurityData1() {
			byte[] edt = getSecurityData1();
			addProperty(EPC_SECURITY_DATA1, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetSecurityData2() {
			byte[] edt = getSecurityData2();
			addProperty(EPC_SECURITY_DATA2, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetCenterValveShutOffStatus() {
			byte[] edt = getCenterValveShutOffStatus();
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetCenterValveShutOffRecoveryPermissionSettingStatus() {
			byte[] edt = getCenterValveShutOffRecoveryPermissionSettingStatus();
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetEmergencyValveShutOffStatus() {
			byte[] edt = getEmergencyValveShutOffStatus();
			addProperty(EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetShutOffValveOpenCloseStatus() {
			byte[] edt = getShutOffValveOpenCloseStatus();
			addProperty(EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetResidualVolumeControlWarning() {
			byte[] edt = getResidualVolumeControlWarning();
			addProperty(EPC_RESIDUAL_VOLUME_CONTROL_WARNING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel1() {
			byte[] edt = getSetValueOfResidualVolumeControlWarningLevel1();
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel2() {
			byte[] edt = getSetValueOfResidualVolumeControlWarningLevel2();
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel3() {
			byte[] edt = getSetValueOfResidualVolumeControlWarningLevel3();
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetSlightLeakTimerValueGasFlowRateContinuation() {
			byte[] edt = getSlightLeakTimerValueGasFlowRateContinuation();
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetSlightLeakTimerValueWithoutPressureIncrease() {
			byte[] edt = getSlightLeakTimerValueWithoutPressureIncrease();
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetShutOffReasonLog() {
			byte[] edt = getShutOffReasonLog();
			addProperty(EPC_SHUT_OFF_REASON_LOG, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Getter reqGetMaximumValueOfSupplyPressureData() {
			byte[] edt = getMaximumValueOfSupplyPressureData();
			addProperty(EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMinimumValueOfSupplyPressureData() {
			byte[] edt = getMinimumValueOfSupplyPressureData();
			addProperty(EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetCurrentValueOfSupplyPressureData() {
			byte[] edt = getCurrentValueOfSupplyPressureData();
			addProperty(EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMaximumValueOfBlockPressureData() {
			byte[] edt = getMaximumValueOfBlockPressureData();
			addProperty(EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMinimumValueOfBlockPressureData() {
			byte[] edt = getMinimumValueOfBlockPressureData();
			addProperty(EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetCurrentValueOfBlockPressureData() {
			byte[] edt = getCurrentValueOfBlockPressureData();
			addProperty(EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetNumberOfBlockPressureSupplyPressureErrorDaysTime() {
			byte[] edt = getNumberOfBlockPressureSupplyPressureErrorDaysTime();
			addProperty(EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetTestCallSetting() {
			byte[] edt = getTestCallSetting();
			addProperty(EPC_TEST_CALL_SETTING, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetIntegralGasConsumptionOfMeteringData1() {
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1);
			return this;
		}
		@Override
		public Getter reqGetIntegralGasConsumptionOfMeteringData2() {
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2);
			return this;
		}
		@Override
		public Getter reqGetErrorDetectionStatusofMeteringData() {
			addProperty(EPC_ERROR_DETECTION_STATUSOF_METERING_DATA);
			return this;
		}
		@Override
		public Getter reqGetSecurityData1() {
			addProperty(EPC_SECURITY_DATA1);
			return this;
		}
		@Override
		public Getter reqGetSecurityData2() {
			addProperty(EPC_SECURITY_DATA2);
			return this;
		}
		@Override
		public Getter reqGetCenterValveShutOffStatus() {
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		@Override
		public Getter reqGetCenterValveShutOffRecoveryPermissionSettingStatus() {
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS);
			return this;
		}
		@Override
		public Getter reqGetEmergencyValveShutOffStatus() {
			addProperty(EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS);
			return this;
		}
		@Override
		public Getter reqGetShutOffValveOpenCloseStatus() {
			addProperty(EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS);
			return this;
		}
		@Override
		public Getter reqGetResidualVolumeControlWarning() {
			addProperty(EPC_RESIDUAL_VOLUME_CONTROL_WARNING);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel1() {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel2() {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2);
			return this;
		}
		@Override
		public Getter reqGetSetValueOfResidualVolumeControlWarningLevel3() {
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3);
			return this;
		}
		@Override
		public Getter reqGetSlightLeakTimerValueGasFlowRateContinuation() {
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION);
			return this;
		}
		@Override
		public Getter reqGetSlightLeakTimerValueWithoutPressureIncrease() {
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE);
			return this;
		}
		@Override
		public Getter reqGetShutOffReasonLog() {
			addProperty(EPC_SHUT_OFF_REASON_LOG);
			return this;
		}
		@Override
		public Getter reqGetMaximumValueOfSupplyPressureData() {
			addProperty(EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		@Override
		public Getter reqGetMinimumValueOfSupplyPressureData() {
			addProperty(EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		@Override
		public Getter reqGetCurrentValueOfSupplyPressureData() {
			addProperty(EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA);
			return this;
		}
		@Override
		public Getter reqGetMaximumValueOfBlockPressureData() {
			addProperty(EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		@Override
		public Getter reqGetMinimumValueOfBlockPressureData() {
			addProperty(EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		@Override
		public Getter reqGetCurrentValueOfBlockPressureData() {
			addProperty(EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA);
			return this;
		}
		@Override
		public Getter reqGetNumberOfBlockPressureSupplyPressureErrorDaysTime() {
			addProperty(EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME);
			return this;
		}
		@Override
		public Getter reqGetTestCallSetting() {
			addProperty(EPC_TEST_CALL_SETTING);
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
		 * This property indicates integral gas consumption in units of 0.0001 m3.<br>0.0x005F5E0FF (0.9999,9999 m3)
		 */
		public Informer reqInformIntegralGasConsumptionOfMeteringData1();
		/**
		 * This property indicates integral gas consumption in units of 0.001 m3.<br>0.0x005F5E0FF (0.99999,999 m3)
		 */
		public Informer reqInformIntegralGasConsumptionOfMeteringData2();
		/**
		 * This property indicates status where meter detected metering data error.<br>Error detection status found = 0x41 Error detection status not found = 0x42
		 */
		public Informer reqInformErrorDetectionStatusofMeteringData();
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>0.0xFFFFFFFF
		 */
		public Informer reqInformSecurityData1();
		/**
		 * This property indicates security data to define security information on meter operation by bit allocation.<br>0.0xFFFFFFFF
		 */
		public Informer reqInformSecurityData2();
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>Center valve shut-off status found = 0x41 Center valve shut-off status not found = 0x42
		 */
		public Informer reqInformCenterValveShutOffStatus();
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off by center.<br>Center valve shut-off reset enable = 0x41 Center valve shut-off reset not enable = 0x42
		 */
		public Informer reqInformCenterValveShutOffRecoveryPermissionSettingStatus();
		/**
		 * This property indicates status where gas shut-off valve of meter has been shut off.<br>Emergency valve shut-off status found = 0x41 Emergency valve shut-off status not found = 0x42
		 */
		public Informer reqInformEmergencyValveShutOffStatus();
		/**
		 * This property indicates open/close status of shut-off valve.<br>Shut-off valve open status = 0x41 Shut-off valve close status = 0x42
		 */
		public Informer reqInformShutOffValveOpenCloseStatus();
		/**
		 * This property indicates status as warning where residual volume is very small.<br>Residual volume control warning level 1 0x31 Residual volume control warning level 2 0x32 Residual volume control warning level 3 0x33 No residual volume control warning 0x42
		 */
		public Informer reqInformResidualVolumeControlWarning();
		/**
		 * Sets �gSmall residual volume detection level 1�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel1();
		/**
		 * Sets �gSmall residual volume detection level 2�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel2();
		/**
		 * Sets �gSmall residual volume detection level 3�h.<br>0.0xFFFFFF (0.16,777,215)
		 */
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel3();
		/**
		 * This property indicates number of days on which gas flow rate is continued.<br>0.0xFD (0.253) (0 to 253 days)
		 */
		public Informer reqInformSlightLeakTimerValueGasFlowRateContinuation();
		/**
		 * This property indicates number of days on which gas leak monitoring is performed without gas pressure increase.<br>0.0xFD (0.253) (0 to 253 days)
		 */
		public Informer reqInformSlightLeakTimerValueWithoutPressureIncrease();
		/**
		 * Defines log of reasons for gas shut-off by shut-off valve in 1 byte each with bits assigned. Shows the last three logs. Log 3: log 2: log 1<br>0xFF: 0xFF: 0xFF
		 */
		public Informer reqInformShutOffReasonLog();
		/**
		 * This property indicates maximum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Informer reqInformMaximumValueOfSupplyPressureData();
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Informer reqInformMinimumValueOfSupplyPressureData();
		/**
		 * This property indicates current value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Informer reqInformCurrentValueOfSupplyPressureData();
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Informer reqInformMaximumValueOfBlockPressureData();
		/**
		 * This property indicates minimum value of supply pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Informer reqInformMinimumValueOfBlockPressureData();
		/**
		 * This property indicates current value of block pressure data in units of 0.01 kPa.<br>0x0000.0xFFFD (0.655.33) (0.655.33 kPa)
		 */
		public Informer reqInformCurrentValueOfBlockPressureData();
		/**
		 * This property indicates number of days on which block pressure/supply pressure errors occurred in 1 byte each.<br>Number of block pressure error days: Number of supply pressure error days: Number of block pressure error times: Number of supply pressure error times
		 */
		public Informer reqInformNumberOfBlockPressureSupplyPressureErrorDaysTime();
		/**
		 * Performs test call operation setup.<br>Test call operation ON 0x41 Test call operation OFF 0x42
		 */
		public Informer reqInformTestCallSetting();

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
		public Informer reqInformIntegralGasConsumptionOfMeteringData1() {
			byte[] edt = getIntegralGasConsumptionOfMeteringData1();
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA1, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformIntegralGasConsumptionOfMeteringData2() {
			byte[] edt = getIntegralGasConsumptionOfMeteringData2();
			addProperty(EPC_INTEGRAL_GAS_CONSUMPTION_OF_METERING_DATA2, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformErrorDetectionStatusofMeteringData() {
			byte[] edt = getErrorDetectionStatusofMeteringData();
			addProperty(EPC_ERROR_DETECTION_STATUSOF_METERING_DATA, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSecurityData1() {
			byte[] edt = getSecurityData1();
			addProperty(EPC_SECURITY_DATA1, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformSecurityData2() {
			byte[] edt = getSecurityData2();
			addProperty(EPC_SECURITY_DATA2, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformCenterValveShutOffStatus() {
			byte[] edt = getCenterValveShutOffStatus();
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformCenterValveShutOffRecoveryPermissionSettingStatus() {
			byte[] edt = getCenterValveShutOffRecoveryPermissionSettingStatus();
			addProperty(EPC_CENTER_VALVE_SHUT_OFF_RECOVERY_PERMISSION_SETTING_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformEmergencyValveShutOffStatus() {
			byte[] edt = getEmergencyValveShutOffStatus();
			addProperty(EPC_EMERGENCY_VALVE_SHUT_OFF_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShutOffValveOpenCloseStatus() {
			byte[] edt = getShutOffValveOpenCloseStatus();
			addProperty(EPC_SHUT_OFF_VALVE_OPEN_CLOSE_STATUS, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformResidualVolumeControlWarning() {
			byte[] edt = getResidualVolumeControlWarning();
			addProperty(EPC_RESIDUAL_VOLUME_CONTROL_WARNING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel1() {
			byte[] edt = getSetValueOfResidualVolumeControlWarningLevel1();
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL1, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel2() {
			byte[] edt = getSetValueOfResidualVolumeControlWarningLevel2();
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL2, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformSetValueOfResidualVolumeControlWarningLevel3() {
			byte[] edt = getSetValueOfResidualVolumeControlWarningLevel3();
			addProperty(EPC_SET_VALUE_OF_RESIDUAL_VOLUME_CONTROL_WARNING_LEVEL3, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformSlightLeakTimerValueGasFlowRateContinuation() {
			byte[] edt = getSlightLeakTimerValueGasFlowRateContinuation();
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_GAS_FLOW_RATE_CONTINUATION, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformSlightLeakTimerValueWithoutPressureIncrease() {
			byte[] edt = getSlightLeakTimerValueWithoutPressureIncrease();
			addProperty(EPC_SLIGHT_LEAK_TIMER_VALUE_WITHOUT_PRESSURE_INCREASE, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformShutOffReasonLog() {
			byte[] edt = getShutOffReasonLog();
			addProperty(EPC_SHUT_OFF_REASON_LOG, edt, (edt != null && (edt.length == 3)));
			return this;
		}
		@Override
		public Informer reqInformMaximumValueOfSupplyPressureData() {
			byte[] edt = getMaximumValueOfSupplyPressureData();
			addProperty(EPC_MAXIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMinimumValueOfSupplyPressureData() {
			byte[] edt = getMinimumValueOfSupplyPressureData();
			addProperty(EPC_MINIMUM_VALUE_OF_SUPPLY_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformCurrentValueOfSupplyPressureData() {
			byte[] edt = getCurrentValueOfSupplyPressureData();
			addProperty(EPC_CURRENT_VALUE_OF_SUPPLY_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMaximumValueOfBlockPressureData() {
			byte[] edt = getMaximumValueOfBlockPressureData();
			addProperty(EPC_MAXIMUM_VALUE_OF_BLOCK_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMinimumValueOfBlockPressureData() {
			byte[] edt = getMinimumValueOfBlockPressureData();
			addProperty(EPC_MINIMUM_VALUE_OF_BLOCK_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformCurrentValueOfBlockPressureData() {
			byte[] edt = getCurrentValueOfBlockPressureData();
			addProperty(EPC_CURRENT_VALUE_OF_BLOCK_PRESSURE_DATA, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformNumberOfBlockPressureSupplyPressureErrorDaysTime() {
			byte[] edt = getNumberOfBlockPressureSupplyPressureErrorDaysTime();
			addProperty(EPC_NUMBER_OF_BLOCK_PRESSURE_SUPPLY_PRESSURE_ERROR_DAYS_TIME, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformTestCallSetting() {
			byte[] edt = getTestCallSetting();
			addProperty(EPC_TEST_CALL_SETTING, edt, (edt != null && (edt.length == 1)));
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
