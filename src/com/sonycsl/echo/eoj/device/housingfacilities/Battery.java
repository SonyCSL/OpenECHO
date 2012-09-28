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

public abstract class Battery extends DeviceObject {
	@SuppressWarnings("unused")
	private static final String TAG = Battery.class.getSimpleName();
	
	public static final byte CLASS_GROUP_CODE = (byte)0x02;
	public static final byte CLASS_CODE = (byte)0x7D;

	protected static final byte EPC_RATED_ELECTRIC_ENERGY = (byte)0xD0;
	protected static final byte EPC_RATED_CAPACITY = (byte)0xD1;
	protected static final byte EPC_RATED_VOLTAGE = (byte)0xD2;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY = (byte)0xD3;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT = (byte)0xD4;
	protected static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE = (byte)0xD5;
	protected static final byte EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY = (byte)0xD6;
	protected static final byte EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING = (byte)0xD7;
	protected static final byte EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY = (byte)0xD8;
	protected static final byte EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING = (byte)0xD9;
	protected static final byte EPC_OPERATION_MODE_SETTING_SEE_NOTE1 = (byte)0xDA;
	protected static final byte EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2 = (byte)0xE0;
	protected static final byte EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2 = (byte)0xE1;
	protected static final byte EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3 = (byte)0xE2;
	protected static final byte EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3 = (byte)0xE3;
	protected static final byte EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH = (byte)0xE4;
	protected static final byte EPC_BATTERY_TYPE = (byte)0xE6;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the rated electric energy of the battery in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j
	 */
	protected byte[] getRatedElectricEnergy() {return null;}
	/**
	 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j
	 */
	protected byte[] getRatedCapacity() {return null;}
	/**
	 * This property indicates the rated voltage of the battery in volts.<br>0x0000-0x7FFE�i0-32,766V�j
	 */
	protected byte[] getRatedVoltage() {return null;}
	/**
	 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999W�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999W)�Fduring discharging (negative value)
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargEElectricEnergy() {return null;}
	/**
	 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>0x0001-0x7FFE�i0.1-3,276.6A�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7A�j�Fduring discharging (negative value)
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargECurrent() {return null;}
	/**
	 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value), 0xFFFF-0x8001�i.1-.32,767V�j�F during discharging (negative value)
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargEVoltage() {return null;}
	/**
	 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j
	 */
	protected byte[] getMeasuredCumulativeDischargeElectricEnergy() {return null;}
	/**
	 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>Reset��0x00
	 */
	protected boolean setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt) {return false;}
	/**
	 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j
	 */
	protected byte[] getMeasuredCumulativeChargeElectricEnergy() {return null;}
	/**
	 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>Reset��0x00
	 */
	protected boolean setGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt) {return false;}
	/**
	 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45
	 */
	protected abstract boolean setOperationModeSettingSeeNote1(byte[] edt);
	/**
	 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45
	 */
	protected abstract byte[] getOperationModeSettingSeeNote1();
	/**
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)
	 */
	protected boolean setChargingDischaRgingAmountSetting1SeeNote2(byte[] edt) {return false;}
	/**
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)
	 */
	protected byte[] getChargingDischaRgingAmountSetting1SeeNote2() {return null;}
	/**
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)
	 */
	protected boolean setChargingDischaRgingAmountSetting2SeeNote2(byte[] edt) {return false;}
	/**
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)
	 */
	protected byte[] getChargingDischaRgingAmountSetting2SeeNote2() {return null;}
	/**
	 * This property indicates the remaining stored electric energy in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j
	 */
	protected abstract byte[] getRemainingStoredElectricity1SeeNote3();
	/**
	 * This property indicates the remaining capacity in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j
	 */
	protected abstract byte[] getRemainingStoredElectricity2SeeNote3();
	/**
	 * This  property indicates the charging rate of the battery in terms of percentage. (0-100%)<br>This  property indicates the battery state of health in terms of percentage. (0-100%)
	 */
	protected abstract byte[] getRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
	/**
	 * This property indicates the battery type.<br>Type=0x00-0xFF
	 */
	protected abstract byte[] getBatteryType();


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING:
			res.addProperty(epc, edt, setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(edt));
			break;
		case EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING:
			res.addProperty(epc, edt, setGmeasuredCumulativeChargeElectricEnergyHResetSetting(edt));
			break;
		case EPC_OPERATION_MODE_SETTING_SEE_NOTE1:
			res.addProperty(epc, edt, setOperationModeSettingSeeNote1(edt));
			break;
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2:
			res.addProperty(epc, edt, setChargingDischaRgingAmountSetting1SeeNote2(edt));
			break;
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2:
			res.addProperty(epc, edt, setChargingDischaRgingAmountSetting2SeeNote2(edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_RATED_ELECTRIC_ENERGY:
			edt = getRatedElectricEnergy();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_RATED_CAPACITY:
			edt = getRatedCapacity();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_VOLTAGE:
			edt = getRatedVoltage();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY:
			edt = getMeasuredInstantaneousChargeDischargEElectricEnergy();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT:
			edt = getMeasuredInstantaneousChargeDischargECurrent();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE:
			edt = getMeasuredInstantaneousChargeDischargEVoltage();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY:
			edt = getMeasuredCumulativeDischargeElectricEnergy();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY:
			edt = getMeasuredCumulativeChargeElectricEnergy();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_OPERATION_MODE_SETTING_SEE_NOTE1:
			edt = getOperationModeSettingSeeNote1();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2:
			edt = getChargingDischaRgingAmountSetting1SeeNote2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2:
			edt = getChargingDischaRgingAmountSetting2SeeNote2();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3:
			edt = getRemainingStoredElectricity1SeeNote3();
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3:
			edt = getRemainingStoredElectricity2SeeNote3();
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH:
			edt = getRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATTERY_TYPE:
			edt = getBatteryType();
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
			case EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING:
				onSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING:
				onSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(eoj, tid, (pdc != 0));
				break;
			case EPC_OPERATION_MODE_SETTING_SEE_NOTE1:
				onSetOperationModeSettingSeeNote1(eoj, tid, (pdc != 0));
				break;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2:
				onSetChargingDischaRgingAmountSetting1SeeNote2(eoj, tid, (pdc != 0));
				break;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2:
				onSetChargingDischaRgingAmountSetting2SeeNote2(eoj, tid, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte epc,
				byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, epc, pdc, edt);
			switch(epc) {
			case EPC_RATED_ELECTRIC_ENERGY:
				onGetRatedElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_CAPACITY:
				onGetRatedCapacity(eoj, tid, pdc, edt);
				break;
			case EPC_RATED_VOLTAGE:
				onGetRatedVoltage(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY:
				onGetMeasuredInstantaneousChargeDischargEElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT:
				onGetMeasuredInstantaneousChargeDischargECurrent(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE:
				onGetMeasuredInstantaneousChargeDischargEVoltage(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY:
				onGetMeasuredCumulativeDischargeElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY:
				onGetMeasuredCumulativeChargeElectricEnergy(eoj, tid, pdc, edt);
				break;
			case EPC_OPERATION_MODE_SETTING_SEE_NOTE1:
				onGetOperationModeSettingSeeNote1(eoj, tid, pdc, edt);
				break;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2:
				onGetChargingDischaRgingAmountSetting1SeeNote2(eoj, tid, pdc, edt);
				break;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2:
				onGetChargingDischaRgingAmountSetting2SeeNote2(eoj, tid, pdc, edt);
				break;
			case EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3:
				onGetRemainingStoredElectricity1SeeNote3(eoj, tid, pdc, edt);
				break;
			case EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3:
				onGetRemainingStoredElectricity2SeeNote3(eoj, tid, pdc, edt);
				break;
			case EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH:
				onGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth(eoj, tid, pdc, edt);
				break;
			case EPC_BATTERY_TYPE:
				onGetBatteryType(eoj, tid, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates the rated electric energy of the battery in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j
		 */
		protected void onGetRatedElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j
		 */
		protected void onGetRatedCapacity(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the rated voltage of the battery in volts.<br>0x0000-0x7FFE�i0-32,766V�j
		 */
		protected void onGetRatedVoltage(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999W�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999W)�Fduring discharging (negative value)
		 */
		protected void onGetMeasuredInstantaneousChargeDischargEElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>0x0001-0x7FFE�i0.1-3,276.6A�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7A�j�Fduring discharging (negative value)
		 */
		protected void onGetMeasuredInstantaneousChargeDischargECurrent(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value), 0xFFFF-0x8001�i.1-.32,767V�j�F during discharging (negative value)
		 */
		protected void onGetMeasuredInstantaneousChargeDischargEVoltage(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j
		 */
		protected void onGetMeasuredCumulativeDischargeElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>Reset��0x00
		 */
		protected void onSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j
		 */
		protected void onGetMeasuredCumulativeChargeElectricEnergy(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>Reset��0x00
		 */
		protected void onSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45
		 */
		protected void onSetOperationModeSettingSeeNote1(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45
		 */
		protected void onGetOperationModeSettingSeeNote1(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)
		 */
		protected void onSetChargingDischaRgingAmountSetting1SeeNote2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)
		 */
		protected void onGetChargingDischaRgingAmountSetting1SeeNote2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)
		 */
		protected void onSetChargingDischaRgingAmountSetting2SeeNote2(EchoObject eoj, short tid, boolean success) {}
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)
		 */
		protected void onGetChargingDischaRgingAmountSetting2SeeNote2(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the remaining stored electric energy in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j
		 */
		protected void onGetRemainingStoredElectricity1SeeNote3(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j
		 */
		protected void onGetRemainingStoredElectricity2SeeNote3(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This  property indicates the charging rate of the battery in terms of percentage. (0-100%)<br>This  property indicates the battery state of health in terms of percentage. (0-100%)
		 */
		protected void onGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth(EchoObject eoj, short tid, byte pdc, byte[] edt) {}
		/**
		 * This property indicates the battery type.<br>Type=0x00-0xFF
		 */
		protected void onGetBatteryType(EchoObject eoj, short tid, byte pdc, byte[] edt) {}

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
		 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>Reset��0x00
		 */
		public Setter reqSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt);
		/**
		 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>Reset��0x00
		 */
		public Setter reqSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt);
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45
		 */
		public Setter reqSetOperationModeSettingSeeNote1(byte[] edt);
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)
		 */
		public Setter reqSetChargingDischaRgingAmountSetting1SeeNote2(byte[] edt);
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)
		 */
		public Setter reqSetChargingDischaRgingAmountSetting2SeeNote2(byte[] edt);

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
		public Setter reqSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt) {
			addProperty(EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING, edt, setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt) {
			addProperty(EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING, edt, setGmeasuredCumulativeChargeElectricEnergyHResetSetting(edt));
			return this;
		}
		@Override
		public Setter reqSetOperationModeSettingSeeNote1(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1, edt, setOperationModeSettingSeeNote1(edt));
			return this;
		}
		@Override
		public Setter reqSetChargingDischaRgingAmountSetting1SeeNote2(byte[] edt) {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2, edt, setChargingDischaRgingAmountSetting1SeeNote2(edt));
			return this;
		}
		@Override
		public Setter reqSetChargingDischaRgingAmountSetting2SeeNote2(byte[] edt) {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2, edt, setChargingDischaRgingAmountSetting2SeeNote2(edt));
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
		public Setter reqSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt) {
			addProperty(EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt) {
			addProperty(EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetOperationModeSettingSeeNote1(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Setter reqSetChargingDischaRgingAmountSetting1SeeNote2(byte[] edt) {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Setter reqSetChargingDischaRgingAmountSetting2SeeNote2(byte[] edt) {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2, edt, (edt != null && (edt.length == 2)));
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
		 * This property indicates the rated electric energy of the battery in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j
		 */
		public Getter reqGetRatedElectricEnergy();
		/**
		 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j
		 */
		public Getter reqGetRatedCapacity();
		/**
		 * This property indicates the rated voltage of the battery in volts.<br>0x0000-0x7FFE�i0-32,766V�j
		 */
		public Getter reqGetRatedVoltage();
		/**
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999W�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999W)�Fduring discharging (negative value)
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargEElectricEnergy();
		/**
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>0x0001-0x7FFE�i0.1-3,276.6A�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7A�j�Fduring discharging (negative value)
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargECurrent();
		/**
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value), 0xFFFF-0x8001�i.1-.32,767V�j�F during discharging (negative value)
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargEVoltage();
		/**
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j
		 */
		public Getter reqGetMeasuredCumulativeDischargeElectricEnergy();
		/**
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j
		 */
		public Getter reqGetMeasuredCumulativeChargeElectricEnergy();
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45
		 */
		public Getter reqGetOperationModeSettingSeeNote1();
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)
		 */
		public Getter reqGetChargingDischaRgingAmountSetting1SeeNote2();
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)
		 */
		public Getter reqGetChargingDischaRgingAmountSetting2SeeNote2();
		/**
		 * This property indicates the remaining stored electric energy in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j
		 */
		public Getter reqGetRemainingStoredElectricity1SeeNote3();
		/**
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j
		 */
		public Getter reqGetRemainingStoredElectricity2SeeNote3();
		/**
		 * This  property indicates the charging rate of the battery in terms of percentage. (0-100%)<br>This  property indicates the battery state of health in terms of percentage. (0-100%)
		 */
		public Getter reqGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
		/**
		 * This property indicates the battery type.<br>Type=0x00-0xFF
		 */
		public Getter reqGetBatteryType();

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
		public Getter reqGetRatedElectricEnergy() {
			byte[] edt = getRatedElectricEnergy();
			addProperty(EPC_RATED_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetRatedCapacity() {
			byte[] edt = getRatedCapacity();
			addProperty(EPC_RATED_CAPACITY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRatedVoltage() {
			byte[] edt = getRatedVoltage();
			addProperty(EPC_RATED_VOLTAGE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousChargeDischargEElectricEnergy() {
			byte[] edt = getMeasuredInstantaneousChargeDischargEElectricEnergy();
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousChargeDischargECurrent() {
			byte[] edt = getMeasuredInstantaneousChargeDischargECurrent();
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousChargeDischargEVoltage() {
			byte[] edt = getMeasuredInstantaneousChargeDischargEVoltage();
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeDischargeElectricEnergy() {
			byte[] edt = getMeasuredCumulativeDischargeElectricEnergy();
			addProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeChargeElectricEnergy() {
			byte[] edt = getMeasuredCumulativeChargeElectricEnergy();
			addProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetOperationModeSettingSeeNote1() {
			byte[] edt = getOperationModeSettingSeeNote1();
			addProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetChargingDischaRgingAmountSetting1SeeNote2() {
			byte[] edt = getChargingDischaRgingAmountSetting1SeeNote2();
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetChargingDischaRgingAmountSetting2SeeNote2() {
			byte[] edt = getChargingDischaRgingAmountSetting2SeeNote2();
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRemainingStoredElectricity1SeeNote3() {
			byte[] edt = getRemainingStoredElectricity1SeeNote3();
			addProperty(EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetRemainingStoredElectricity2SeeNote3() {
			byte[] edt = getRemainingStoredElectricity2SeeNote3();
			addProperty(EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth() {
			byte[] edt = getRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
			addProperty(EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBatteryType() {
			byte[] edt = getBatteryType();
			addProperty(EPC_BATTERY_TYPE, edt, (edt != null && (edt.length == 1)));
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
		public Getter reqGetRatedElectricEnergy() {
			addProperty(EPC_RATED_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Getter reqGetRatedCapacity() {
			addProperty(EPC_RATED_CAPACITY);
			return this;
		}
		@Override
		public Getter reqGetRatedVoltage() {
			addProperty(EPC_RATED_VOLTAGE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousChargeDischargEElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousChargeDischargECurrent() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT);
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousChargeDischargEVoltage() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeDischargeElectricEnergy() {
			addProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeChargeElectricEnergy() {
			addProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Getter reqGetOperationModeSettingSeeNote1() {
			addProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1);
			return this;
		}
		@Override
		public Getter reqGetChargingDischaRgingAmountSetting1SeeNote2() {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2);
			return this;
		}
		@Override
		public Getter reqGetChargingDischaRgingAmountSetting2SeeNote2() {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2);
			return this;
		}
		@Override
		public Getter reqGetRemainingStoredElectricity1SeeNote3() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3);
			return this;
		}
		@Override
		public Getter reqGetRemainingStoredElectricity2SeeNote3() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3);
			return this;
		}
		@Override
		public Getter reqGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH);
			return this;
		}
		@Override
		public Getter reqGetBatteryType() {
			addProperty(EPC_BATTERY_TYPE);
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
		 * This property indicates the rated electric energy of the battery in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j
		 */
		public Informer reqInformRatedElectricEnergy();
		/**
		 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j
		 */
		public Informer reqInformRatedCapacity();
		/**
		 * This property indicates the rated voltage of the battery in volts.<br>0x0000-0x7FFE�i0-32,766V�j
		 */
		public Informer reqInformRatedVoltage();
		/**
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999W�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999W)�Fduring discharging (negative value)
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargEElectricEnergy();
		/**
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>0x0001-0x7FFE�i0.1-3,276.6A�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7A�j�Fduring discharging (negative value)
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargECurrent();
		/**
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value), 0xFFFF-0x8001�i.1-.32,767V�j�F during discharging (negative value)
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargEVoltage();
		/**
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j
		 */
		public Informer reqInformMeasuredCumulativeDischargeElectricEnergy();
		/**
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j
		 */
		public Informer reqInformMeasuredCumulativeChargeElectricEnergy();
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45
		 */
		public Informer reqInformOperationModeSettingSeeNote1();
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)
		 */
		public Informer reqInformChargingDischaRgingAmountSetting1SeeNote2();
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)
		 */
		public Informer reqInformChargingDischaRgingAmountSetting2SeeNote2();
		/**
		 * This property indicates the remaining stored electric energy in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j
		 */
		public Informer reqInformRemainingStoredElectricity1SeeNote3();
		/**
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j
		 */
		public Informer reqInformRemainingStoredElectricity2SeeNote3();
		/**
		 * This  property indicates the charging rate of the battery in terms of percentage. (0-100%)<br>This  property indicates the battery state of health in terms of percentage. (0-100%)
		 */
		public Informer reqInformRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
		/**
		 * This property indicates the battery type.<br>Type=0x00-0xFF
		 */
		public Informer reqInformBatteryType();

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
		public Informer reqInformRatedElectricEnergy() {
			byte[] edt = getRatedElectricEnergy();
			addProperty(EPC_RATED_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformRatedCapacity() {
			byte[] edt = getRatedCapacity();
			addProperty(EPC_RATED_CAPACITY, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedVoltage() {
			byte[] edt = getRatedVoltage();
			addProperty(EPC_RATED_VOLTAGE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousChargeDischargEElectricEnergy() {
			byte[] edt = getMeasuredInstantaneousChargeDischargEElectricEnergy();
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousChargeDischargECurrent() {
			byte[] edt = getMeasuredInstantaneousChargeDischargECurrent();
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousChargeDischargEVoltage() {
			byte[] edt = getMeasuredInstantaneousChargeDischargEVoltage();
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeDischargeElectricEnergy() {
			byte[] edt = getMeasuredCumulativeDischargeElectricEnergy();
			addProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeChargeElectricEnergy() {
			byte[] edt = getMeasuredCumulativeChargeElectricEnergy();
			addProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformOperationModeSettingSeeNote1() {
			byte[] edt = getOperationModeSettingSeeNote1();
			addProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformChargingDischaRgingAmountSetting1SeeNote2() {
			byte[] edt = getChargingDischaRgingAmountSetting1SeeNote2();
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformChargingDischaRgingAmountSetting2SeeNote2() {
			byte[] edt = getChargingDischaRgingAmountSetting2SeeNote2();
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRemainingStoredElectricity1SeeNote3() {
			byte[] edt = getRemainingStoredElectricity1SeeNote3();
			addProperty(EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformRemainingStoredElectricity2SeeNote3() {
			byte[] edt = getRemainingStoredElectricity2SeeNote3();
			addProperty(EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRemainingStoredElectricity3SeeNote3BateryStareOfHealth() {
			byte[] edt = getRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
			addProperty(EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBatteryType() {
			byte[] edt = getBatteryType();
			addProperty(EPC_BATTERY_TYPE, edt, (edt != null && (edt.length == 1)));
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
		public Informer reqInformRatedElectricEnergy() {
			addProperty(EPC_RATED_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Informer reqInformRatedCapacity() {
			addProperty(EPC_RATED_CAPACITY);
			return this;
		}
		@Override
		public Informer reqInformRatedVoltage() {
			addProperty(EPC_RATED_VOLTAGE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousChargeDischargEElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousChargeDischargECurrent() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT);
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousChargeDischargEVoltage() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeDischargeElectricEnergy() {
			addProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeChargeElectricEnergy() {
			addProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		@Override
		public Informer reqInformOperationModeSettingSeeNote1() {
			addProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1);
			return this;
		}
		@Override
		public Informer reqInformChargingDischaRgingAmountSetting1SeeNote2() {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2);
			return this;
		}
		@Override
		public Informer reqInformChargingDischaRgingAmountSetting2SeeNote2() {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2);
			return this;
		}
		@Override
		public Informer reqInformRemainingStoredElectricity1SeeNote3() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3);
			return this;
		}
		@Override
		public Informer reqInformRemainingStoredElectricity2SeeNote3() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3);
			return this;
		}
		@Override
		public Informer reqInformRemainingStoredElectricity3SeeNote3BateryStareOfHealth() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH);
			return this;
		}
		@Override
		public Informer reqInformBatteryType() {
			addProperty(EPC_BATTERY_TYPE);
			return this;
		}

	}
}
