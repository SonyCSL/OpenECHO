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

	public static final byte EPC_RATED_ELECTRIC_ENERGY = (byte)0xD0;
	public static final byte EPC_RATED_CAPACITY = (byte)0xD1;
	public static final byte EPC_RATED_VOLTAGE = (byte)0xD2;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY = (byte)0xD3;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT = (byte)0xD4;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE = (byte)0xD5;
	public static final byte EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY = (byte)0xD6;
	public static final byte EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING = (byte)0xD7;
	public static final byte EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY = (byte)0xD8;
	public static final byte EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING = (byte)0xD9;
	public static final byte EPC_OPERATION_MODE_SETTING_SEE_NOTE1 = (byte)0xDA;
	public static final byte EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2 = (byte)0xE0;
	public static final byte EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2 = (byte)0xE1;
	public static final byte EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3 = (byte)0xE2;
	public static final byte EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3 = (byte)0xE3;
	public static final byte EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH = (byte)0xE4;
	public static final byte EPC_BATTERY_TYPE = (byte)0xE6;

	@Override
	public byte getClassGroupCode() {
		return CLASS_GROUP_CODE;
	}

	@Override
	public byte getClassCode() {
		return CLASS_CODE;
	}

	/**
	 * This property indicates the rated electric energy of the battery in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedElectricEnergy() {return null;}
	private final byte[] _getRatedElectricEnergy(byte epc) {
		byte[] edt = getRatedElectricEnergy();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedCapacity() {return null;}
	private final byte[] _getRatedCapacity(byte epc) {
		byte[] edt = getRatedCapacity();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the rated voltage of the battery in volts.<br>0x0000-0x7FFE�i0-32,766V�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getRatedVoltage() {return null;}
	private final byte[] _getRatedVoltage(byte epc) {
		byte[] edt = getRatedVoltage();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999W�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999W)�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargEElectricEnergy() {return null;}
	private final byte[] _getMeasuredInstantaneousChargeDischargEElectricEnergy(byte epc) {
		byte[] edt = getMeasuredInstantaneousChargeDischargEElectricEnergy();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>0x0001-0x7FFE�i0.1-3,276.6A�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7A�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargECurrent() {return null;}
	private final byte[] _getMeasuredInstantaneousChargeDischargECurrent(byte epc) {
		byte[] edt = getMeasuredInstantaneousChargeDischargECurrent();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value), 0xFFFF-0x8001�i.1-.32,767V�j�F during discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargEVoltage() {return null;}
	private final byte[] _getMeasuredInstantaneousChargeDischargEVoltage(byte epc) {
		byte[] edt = getMeasuredInstantaneousChargeDischargEVoltage();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredCumulativeDischargeElectricEnergy() {return null;}
	private final byte[] _getMeasuredCumulativeDischargeElectricEnergy(byte epc) {
		byte[] edt = getMeasuredCumulativeDischargeElectricEnergy();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>Reset��0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
	 */
	protected boolean setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt) {return false;}
	private final boolean _setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte epc, byte[] edt) {
		boolean success = setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
	 */
	protected byte[] getMeasuredCumulativeChargeElectricEnergy() {return null;}
	private final byte[] _getMeasuredCumulativeChargeElectricEnergy(byte epc) {
		byte[] edt = getMeasuredCumulativeChargeElectricEnergy();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>Reset��0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
	 */
	protected boolean setGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt) {return false;}
	private final boolean _setGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte epc, byte[] edt) {
		boolean success = setGmeasuredCumulativeChargeElectricEnergyHResetSetting(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract boolean setOperationModeSettingSeeNote1(byte[] edt);
	private final boolean _setOperationModeSettingSeeNote1(byte epc, byte[] edt) {
		boolean success = setOperationModeSettingSeeNote1(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
	 */
	protected abstract byte[] getOperationModeSettingSeeNote1();
	private final byte[] _getOperationModeSettingSeeNote1(byte epc) {
		byte[] edt = getOperationModeSettingSeeNote1();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setChargingDischaRgingAmountSetting1SeeNote2(byte[] edt) {return false;}
	private final boolean _setChargingDischaRgingAmountSetting1SeeNote2(byte epc, byte[] edt) {
		boolean success = setChargingDischaRgingAmountSetting1SeeNote2(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getChargingDischaRgingAmountSetting1SeeNote2() {return null;}
	private final byte[] _getChargingDischaRgingAmountSetting1SeeNote2(byte epc) {
		byte[] edt = getChargingDischaRgingAmountSetting1SeeNote2();
		notify(epc, edt);
		return edt;
	}
	/**
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected boolean setChargingDischaRgingAmountSetting2SeeNote2(byte[] edt) {return false;}
	private final boolean _setChargingDischaRgingAmountSetting2SeeNote2(byte epc, byte[] edt) {
		boolean success = setChargingDischaRgingAmountSetting2SeeNote2(edt);
		notify(epc, edt, success);
		return success;
	}
	/**
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
	 */
	protected byte[] getChargingDischaRgingAmountSetting2SeeNote2() {return null;}
	private final byte[] _getChargingDischaRgingAmountSetting2SeeNote2(byte epc) {
		byte[] edt = getChargingDischaRgingAmountSetting2SeeNote2();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the remaining stored electric energy in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getRemainingStoredElectricity1SeeNote3();
	private final byte[] _getRemainingStoredElectricity1SeeNote3(byte epc) {
		byte[] edt = getRemainingStoredElectricity1SeeNote3();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the remaining capacity in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getRemainingStoredElectricity2SeeNote3();
	private final byte[] _getRemainingStoredElectricity2SeeNote3(byte epc) {
		byte[] edt = getRemainingStoredElectricity2SeeNote3();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This  property indicates the charging rate of the battery in terms of percentage. (0-100%)<br>This  property indicates the battery state of health in terms of percentage. (0-100%)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
	private final byte[] _getRemainingStoredElectricity3SeeNote3BateryStareOfHealth(byte epc) {
		byte[] edt = getRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
		notify(epc, edt);
		return edt;
	}
	/**
	 * This property indicates the battery type.<br>Type=0x00-0xFF<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
	 */
	protected abstract byte[] getBatteryType();
	private final byte[] _getBatteryType(byte epc) {
		byte[] edt = getBatteryType();
		notify(epc, edt);
		return edt;
	}


	@Override
	protected void onReceiveSet(EchoFrame res, byte epc, byte pdc, byte[] edt) {
		super.onReceiveSet(res, epc, pdc, edt);
		switch(epc) {
		case EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING:
			res.addProperty(epc, edt, _setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(epc, edt));
			break;
		case EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING:
			res.addProperty(epc, edt, _setGmeasuredCumulativeChargeElectricEnergyHResetSetting(epc, edt));
			break;
		case EPC_OPERATION_MODE_SETTING_SEE_NOTE1:
			res.addProperty(epc, edt, _setOperationModeSettingSeeNote1(epc, edt));
			break;
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2:
			res.addProperty(epc, edt, _setChargingDischaRgingAmountSetting1SeeNote2(epc, edt));
			break;
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2:
			res.addProperty(epc, edt, _setChargingDischaRgingAmountSetting2SeeNote2(epc, edt));
			break;

		}
	}

	@Override
	protected void onReceiveGet(EchoFrame res, byte epc) {
		super.onReceiveGet(res, epc);
		byte[] edt;
		switch(epc) {
		case EPC_RATED_ELECTRIC_ENERGY:
			edt = _getRatedElectricEnergy(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_RATED_CAPACITY:
			edt = _getRatedCapacity(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_RATED_VOLTAGE:
			edt = _getRatedVoltage(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY:
			edt = _getMeasuredInstantaneousChargeDischargEElectricEnergy(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT:
			edt = _getMeasuredInstantaneousChargeDischargECurrent(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE:
			edt = _getMeasuredInstantaneousChargeDischargEVoltage(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY:
			edt = _getMeasuredCumulativeDischargeElectricEnergy(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY:
			edt = _getMeasuredCumulativeChargeElectricEnergy(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_OPERATION_MODE_SETTING_SEE_NOTE1:
			edt = _getOperationModeSettingSeeNote1(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2:
			edt = _getChargingDischaRgingAmountSetting1SeeNote2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2:
			edt = _getChargingDischaRgingAmountSetting2SeeNote2(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3:
			edt = _getRemainingStoredElectricity1SeeNote3(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 4)));
			break;
		case EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3:
			edt = _getRemainingStoredElectricity2SeeNote3(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 2)));
			break;
		case EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH:
			edt = _getRemainingStoredElectricity3SeeNote3BateryStareOfHealth(epc);
			res.addProperty(epc, edt, (edt != null && (edt.length == 1)));
			break;
		case EPC_BATTERY_TYPE:
			edt = _getBatteryType(epc);
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
		protected void onReceiveSetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveSetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING:
				_onSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING:
				_onSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_OPERATION_MODE_SETTING_SEE_NOTE1:
				_onSetOperationModeSettingSeeNote1(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2:
				_onSetChargingDischaRgingAmountSetting1SeeNote2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2:
				_onSetChargingDischaRgingAmountSetting2SeeNote2(eoj, tid, esv, epc, pdc, edt, (pdc != 0));
				break;

			}
		}

		@Override
		protected void onReceiveGetRes(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			super.onReceiveGetRes(eoj, tid, esv, epc, pdc, edt);
			switch(epc) {
			case EPC_RATED_ELECTRIC_ENERGY:
				_onGetRatedElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_CAPACITY:
				_onGetRatedCapacity(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_RATED_VOLTAGE:
				_onGetRatedVoltage(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY:
				_onGetMeasuredInstantaneousChargeDischargEElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT:
				_onGetMeasuredInstantaneousChargeDischargECurrent(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE:
				_onGetMeasuredInstantaneousChargeDischargEVoltage(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY:
				_onGetMeasuredCumulativeDischargeElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY:
				_onGetMeasuredCumulativeChargeElectricEnergy(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_OPERATION_MODE_SETTING_SEE_NOTE1:
				_onGetOperationModeSettingSeeNote1(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2:
				_onGetChargingDischaRgingAmountSetting1SeeNote2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2:
				_onGetChargingDischaRgingAmountSetting2SeeNote2(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3:
				_onGetRemainingStoredElectricity1SeeNote3(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3:
				_onGetRemainingStoredElectricity2SeeNote3(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH:
				_onGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth(eoj, tid, esv, epc, pdc, edt);
				break;
			case EPC_BATTERY_TYPE:
				_onGetBatteryType(eoj, tid, esv, epc, pdc, edt);
				break;

			}
		}
		
		/**
		 * This property indicates the rated electric energy of the battery in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedCapacity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedCapacity(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedCapacity(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the rated voltage of the battery in volts.<br>0x0000-0x7FFE�i0-32,766V�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetRatedVoltage(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRatedVoltage(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRatedVoltage(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999W�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999W)�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredInstantaneousChargeDischargEElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousChargeDischargEElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousChargeDischargEElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>0x0001-0x7FFE�i0.1-3,276.6A�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7A�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredInstantaneousChargeDischargECurrent(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousChargeDischargECurrent(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousChargeDischargECurrent(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value), 0xFFFF-0x8001�i.1-.32,767V�j�F during discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredInstantaneousChargeDischargEVoltage(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredInstantaneousChargeDischargEVoltage(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredInstantaneousChargeDischargEVoltage(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredCumulativeDischargeElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeDischargeElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeDischargeElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>Reset��0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		protected void onSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		protected void onGetMeasuredCumulativeChargeElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetMeasuredCumulativeChargeElectricEnergy(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetMeasuredCumulativeChargeElectricEnergy(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>Reset��0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		protected void onSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onSetOperationModeSettingSeeNote1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetOperationModeSettingSeeNote1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetOperationModeSettingSeeNote1(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		protected void onGetOperationModeSettingSeeNote1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetOperationModeSettingSeeNote1(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetOperationModeSettingSeeNote1(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetChargingDischaRgingAmountSetting1SeeNote2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetChargingDischaRgingAmountSetting1SeeNote2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetChargingDischaRgingAmountSetting1SeeNote2(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetChargingDischaRgingAmountSetting1SeeNote2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetChargingDischaRgingAmountSetting1SeeNote2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetChargingDischaRgingAmountSetting1SeeNote2(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onSetChargingDischaRgingAmountSetting2SeeNote2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {}
		private final void _onSetChargingDischaRgingAmountSetting2SeeNote2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt, boolean success) {
			onSetChargingDischaRgingAmountSetting2SeeNote2(eoj, tid, esv, epc, pdc, edt, success);
			notify(eoj, tid, esv, epc, pdc, edt, success);
		}
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		protected void onGetChargingDischaRgingAmountSetting2SeeNote2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetChargingDischaRgingAmountSetting2SeeNote2(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetChargingDischaRgingAmountSetting2SeeNote2(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the remaining stored electric energy in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetRemainingStoredElectricity1SeeNote3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRemainingStoredElectricity1SeeNote3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRemainingStoredElectricity1SeeNote3(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetRemainingStoredElectricity2SeeNote3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRemainingStoredElectricity2SeeNote3(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRemainingStoredElectricity2SeeNote3(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This  property indicates the charging rate of the battery in terms of percentage. (0-100%)<br>This  property indicates the battery state of health in terms of percentage. (0-100%)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth(eoj, tid, esv, epc, pdc, edt);
			notify(eoj, tid, esv, epc, pdc, edt);
		}
		/**
		 * This property indicates the battery type.<br>Type=0x00-0xFF<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		protected void onGetBatteryType(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {}
		private final void _onGetBatteryType(EchoObject eoj, short tid, byte esv, byte epc, byte pdc, byte[] edt) {
			onGetBatteryType(eoj, tid, esv, epc, pdc, edt);
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
		 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>Reset��0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		public Setter reqSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt);
		/**
		 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>Reset��0x00<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : optional<br>Get : undefined
		 */
		public Setter reqSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt);
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Setter reqSetOperationModeSettingSeeNote1(byte[] edt);
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetChargingDischaRgingAmountSetting1SeeNote2(byte[] edt);
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Setter reqSetChargingDischaRgingAmountSetting2SeeNote2(byte[] edt);
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
		public Setter reqSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt) {
			byte epc = EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING;
			addProperty(epc, edt, _setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt) {
			byte epc = EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING;
			addProperty(epc, edt, _setGmeasuredCumulativeChargeElectricEnergyHResetSetting(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetOperationModeSettingSeeNote1(byte[] edt) {
			byte epc = EPC_OPERATION_MODE_SETTING_SEE_NOTE1;
			addProperty(epc, edt, _setOperationModeSettingSeeNote1(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetChargingDischaRgingAmountSetting1SeeNote2(byte[] edt) {
			byte epc = EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2;
			addProperty(epc, edt, _setChargingDischaRgingAmountSetting1SeeNote2(epc, edt));
			return this;
		}
		@Override
		public Setter reqSetChargingDischaRgingAmountSetting2SeeNote2(byte[] edt) {
			byte epc = EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2;
			addProperty(epc, edt, _setChargingDischaRgingAmountSetting2SeeNote2(epc, edt));
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
		 * This property indicates the rated electric energy of the battery in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRatedElectricEnergy();
		/**
		 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRatedCapacity();
		/**
		 * This property indicates the rated voltage of the battery in volts.<br>0x0000-0x7FFE�i0-32,766V�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetRatedVoltage();
		/**
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999W�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999W)�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargEElectricEnergy();
		/**
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>0x0001-0x7FFE�i0.1-3,276.6A�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7A�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargECurrent();
		/**
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value), 0xFFFF-0x8001�i.1-.32,767V�j�F during discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargEVoltage();
		/**
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredCumulativeDischargeElectricEnergy();
		/**
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Getter reqGetMeasuredCumulativeChargeElectricEnergy();
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Getter reqGetOperationModeSettingSeeNote1();
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetChargingDischaRgingAmountSetting1SeeNote2();
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Getter reqGetChargingDischaRgingAmountSetting2SeeNote2();
		/**
		 * This property indicates the remaining stored electric energy in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetRemainingStoredElectricity1SeeNote3();
		/**
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetRemainingStoredElectricity2SeeNote3();
		/**
		 * This  property indicates the charging rate of the battery in terms of percentage. (0-100%)<br>This  property indicates the battery state of health in terms of percentage. (0-100%)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
		/**
		 * This property indicates the battery type.<br>Type=0x00-0xFF<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Getter reqGetBatteryType();
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
		public Getter reqGetRatedElectricEnergy() {
			byte epc = EPC_RATED_ELECTRIC_ENERGY;
			byte[] edt = _getRatedElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetRatedCapacity() {
			byte epc = EPC_RATED_CAPACITY;
			byte[] edt = _getRatedCapacity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRatedVoltage() {
			byte epc = EPC_RATED_VOLTAGE;
			byte[] edt = _getRatedVoltage(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousChargeDischargEElectricEnergy() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY;
			byte[] edt = _getMeasuredInstantaneousChargeDischargEElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousChargeDischargECurrent() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT;
			byte[] edt = _getMeasuredInstantaneousChargeDischargECurrent(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredInstantaneousChargeDischargEVoltage() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE;
			byte[] edt = _getMeasuredInstantaneousChargeDischargEVoltage(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeDischargeElectricEnergy() {
			byte epc = EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY;
			byte[] edt = _getMeasuredCumulativeDischargeElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetMeasuredCumulativeChargeElectricEnergy() {
			byte epc = EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY;
			byte[] edt = _getMeasuredCumulativeChargeElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetOperationModeSettingSeeNote1() {
			byte epc = EPC_OPERATION_MODE_SETTING_SEE_NOTE1;
			byte[] edt = _getOperationModeSettingSeeNote1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetChargingDischaRgingAmountSetting1SeeNote2() {
			byte epc = EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2;
			byte[] edt = _getChargingDischaRgingAmountSetting1SeeNote2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetChargingDischaRgingAmountSetting2SeeNote2() {
			byte epc = EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2;
			byte[] edt = _getChargingDischaRgingAmountSetting2SeeNote2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRemainingStoredElectricity1SeeNote3() {
			byte epc = EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3;
			byte[] edt = _getRemainingStoredElectricity1SeeNote3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Getter reqGetRemainingStoredElectricity2SeeNote3() {
			byte epc = EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3;
			byte[] edt = _getRemainingStoredElectricity2SeeNote3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Getter reqGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth() {
			byte epc = EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH;
			byte[] edt = _getRemainingStoredElectricity3SeeNote3BateryStareOfHealth(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Getter reqGetBatteryType() {
			byte epc = EPC_BATTERY_TYPE;
			byte[] edt = _getBatteryType(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
		 * This property indicates the rated electric energy of the battery in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRatedElectricEnergy();
		/**
		 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRatedCapacity();
		/**
		 * This property indicates the rated voltage of the battery in volts.<br>0x0000-0x7FFE�i0-32,766V�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformRatedVoltage();
		/**
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999W�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999W)�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargEElectricEnergy();
		/**
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>0x0001-0x7FFE�i0.1-3,276.6A�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7A�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargECurrent();
		/**
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value), 0xFFFF-0x8001�i.1-.32,767V�j�F during discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargEVoltage();
		/**
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredCumulativeDischargeElectricEnergy();
		/**
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>0x00000000-0x3B9AC9FF �i0-999,999.999kWh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : optional
		 */
		public Informer reqInformMeasuredCumulativeChargeElectricEnergy();
		/**
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>Rapid charging��0x41, Charging�� 0x42, Discharging��0x43, Standby�� 0x44, Test=0x45<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : mandatory<br>Get : mandatory<br>Announcement at status change
		 */
		public Informer reqInformOperationModeSettingSeeNote1();
		/**
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>0x00000001-0x3B9AC9FF �i1-999,999,999Wh�j�Fduring charging (positive value), 0xFFFFFFFF-0xC4653601 (.1-. 999,999,999Wh�j�Fduring discharging (negative value)<br><br>Data type : signed long<br>Data size : 4 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformChargingDischaRgingAmountSetting1SeeNote2();
		/**
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>0x0001-0x7FFD�i0.1-3,276.6Ah�j�F during charging (positive value), 0xFFFF-0x8001�i.0.1-. 3,276.7Ah�j�Fduring discharging (negative value)<br><br>Data type : signed short<br>Data size : 2 Byte<br>Set : optional<br>Get : optional
		 */
		public Informer reqInformChargingDischaRgingAmountSetting2SeeNote2();
		/**
		 * This property indicates the remaining stored electric energy in Wh.<br>0x00000000-0x3B9AC9FF �i0-999,999,999Wh�j<br><br>Data type : unsigned long<br>Data size : 4 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformRemainingStoredElectricity1SeeNote3();
		/**
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>0x0000-0x7FFE�i0-3,276.6Ah�j<br><br>Data type : unsigned short<br>Data size : 2 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformRemainingStoredElectricity2SeeNote3();
		/**
		 * This  property indicates the charging rate of the battery in terms of percentage. (0-100%)<br>This  property indicates the battery state of health in terms of percentage. (0-100%)<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
		/**
		 * This property indicates the battery type.<br>Type=0x00-0xFF<br><br>Data type : unsigned char<br>Data size : 1 Byte<br>Set : undefined<br>Get : mandatory
		 */
		public Informer reqInformBatteryType();
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
		public Informer reqInformRatedElectricEnergy() {
			byte epc = EPC_RATED_ELECTRIC_ENERGY;
			byte[] edt = _getRatedElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformRatedCapacity() {
			byte epc = EPC_RATED_CAPACITY;
			byte[] edt = _getRatedCapacity(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRatedVoltage() {
			byte epc = EPC_RATED_VOLTAGE;
			byte[] edt = _getRatedVoltage(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousChargeDischargEElectricEnergy() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY;
			byte[] edt = _getMeasuredInstantaneousChargeDischargEElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousChargeDischargECurrent() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT;
			byte[] edt = _getMeasuredInstantaneousChargeDischargECurrent(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredInstantaneousChargeDischargEVoltage() {
			byte epc = EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE;
			byte[] edt = _getMeasuredInstantaneousChargeDischargEVoltage(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeDischargeElectricEnergy() {
			byte epc = EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY;
			byte[] edt = _getMeasuredCumulativeDischargeElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformMeasuredCumulativeChargeElectricEnergy() {
			byte epc = EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY;
			byte[] edt = _getMeasuredCumulativeChargeElectricEnergy(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformOperationModeSettingSeeNote1() {
			byte epc = EPC_OPERATION_MODE_SETTING_SEE_NOTE1;
			byte[] edt = _getOperationModeSettingSeeNote1(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformChargingDischaRgingAmountSetting1SeeNote2() {
			byte epc = EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2;
			byte[] edt = _getChargingDischaRgingAmountSetting1SeeNote2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformChargingDischaRgingAmountSetting2SeeNote2() {
			byte epc = EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2;
			byte[] edt = _getChargingDischaRgingAmountSetting2SeeNote2(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRemainingStoredElectricity1SeeNote3() {
			byte epc = EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3;
			byte[] edt = _getRemainingStoredElectricity1SeeNote3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 4)));
			return this;
		}
		@Override
		public Informer reqInformRemainingStoredElectricity2SeeNote3() {
			byte epc = EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3;
			byte[] edt = _getRemainingStoredElectricity2SeeNote3(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 2)));
			return this;
		}
		@Override
		public Informer reqInformRemainingStoredElectricity3SeeNote3BateryStareOfHealth() {
			byte epc = EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH;
			byte[] edt = _getRemainingStoredElectricity3SeeNote3BateryStareOfHealth(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
			return this;
		}
		@Override
		public Informer reqInformBatteryType() {
			byte epc = EPC_BATTERY_TYPE;
			byte[] edt = _getBatteryType(epc);
			addProperty(epc, edt, (edt != null && (edt.length == 1)));
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
