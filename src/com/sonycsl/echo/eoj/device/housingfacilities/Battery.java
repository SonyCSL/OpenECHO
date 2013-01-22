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
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;
import com.sonycsl.echo.node.EchoNode;

public abstract class Battery extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x027D;

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
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1);
		addSetProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1);
		addGetProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1);
		addGetProperty(EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3);
		addGetProperty(EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3);
		addGetProperty(EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH);
		addGetProperty(EPC_BATTERY_TYPE);
	}
	
	@Override
	public void initialize(EchoNode node) {
		super.initialize(node);
		Echo.EventListener listener = Echo.getEventListener();
		if(listener != null) listener.onNewBattery(this);
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
	 * This property indicates the ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30�COFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
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
	 * This property indicates the ON/OFF<br>
	 * status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON=0x30�COFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
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
	 * Property name : Rated electric energy<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated electric energy of the battery in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF<br>
	 * �i0-999,999,999Wh�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedElectricEnergy() {return null;}
	/**
	 * Property name : Rated electric energy<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated electric energy of the battery in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF<br>
	 * �i0-999,999,999Wh�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Rated capacity<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : 0.1
Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedCapacity() {return null;}
	/**
	 * Property name : Rated capacity<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : 0.1
Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedCapacity(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Rated voltage<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated voltage of the battery in volts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x7FFE�i0-32,766V�j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedVoltage() {return null;}
	/**
	 * Property name : Rated voltage<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated voltage of the battery in volts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x7FFE�i0-32,766V�j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedVoltage(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous charge/discharg
e electric energy<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001-0x3B9AC9FF<br>
	 * �i1-999,999,999W�j�Fduring charging<br>
	 * (positive value),<br>
	 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
	 * 999,999,999W)�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargEElectricEnergy() {return null;}
	/**
	 * Property name : Measured instantaneous charge/discharg
e electric energy<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001-0x3B9AC9FF<br>
	 * �i1-999,999,999W�j�Fduring charging<br>
	 * (positive value),<br>
	 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
	 * 999,999,999W)�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousChargeDischargEElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous charge/discharg e current<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001-0x7FFE�i0.1-3,276.6A�j�F<br>
	 * during charging (positive value),<br>
	 * 0xFFFF-0x8001�i.0.1-.<br>
	 * 3,276.7A�j�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargECurrent() {return null;}
	/**
	 * Property name : Measured instantaneous charge/discharg e current<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001-0x7FFE�i0.1-3,276.6A�j�F<br>
	 * during charging (positive value),<br>
	 * 0xFFFF-0x8001�i.0.1-.<br>
	 * 3,276.7A�j�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousChargeDischargECurrent(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous charge/discharg e voltage<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value),<br>
	 * 0xFFFF-0x8001�i.1-.32,767V�j�F<br>
	 * during discharging (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargEVoltage() {return null;}
	/**
	 * Property name : Measured instantaneous charge/discharg e voltage<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value),<br>
	 * 0xFFFF-0x8001�i.1-.32,767V�j�F<br>
	 * during discharging (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousChargeDischargEVoltage(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative discharge electric energy<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF<br>
	 * �i0-999,999.999kWh�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.001 kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredCumulativeDischargeElectricEnergy() {return null;}
	/**
	 * Property name : Measured cumulative discharge electric energy<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF<br>
	 * �i0-999,999.999kWh�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.001 kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredCumulativeDischargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : �gMeasured cumulative discharge electric energy�h reset setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset��0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gMeasured cumulative discharge electric energy�h reset setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset��0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Measured cumulative charge electric energy<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF<br>
	 * �i0-999,999.999kWh�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.001 kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredCumulativeChargeElectricEnergy() {return null;}
	/**
	 * Property name : Measured cumulative charge electric energy<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF<br>
	 * �i0-999,999.999kWh�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : 0.001 kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredCumulativeChargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : �gMeasured cumulative charge electric energy�h reset setting<br>
	 * <br>
	 * EPC : 0xD9<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset��0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean setGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt) {return false;}
	/**
	 * Property name : �gMeasured cumulative charge electric energy�h reset setting<br>
	 * <br>
	 * EPC : 0xD9<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset��0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - undefined<br>
	 */
	protected boolean isValidGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Operation mode setting (See
Note 1.)<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rapid charging��0x41, Charging��<br>
	 * 0x42, Discharging��0x43, Standby��<br>
	 * 0x44, Test=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationModeSettingSeeNote1(byte[] edt);
	/**
	 * Property name : Operation mode setting (See
Note 1.)<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rapid charging��0x41, Charging��<br>
	 * 0x42, Discharging��0x43, Standby��<br>
	 * 0x44, Test=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationModeSettingSeeNote1();
	/**
	 * Property name : Operation mode setting (See
Note 1.)<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rapid charging��0x41, Charging��<br>
	 * 0x42, Discharging��0x43, Standby��<br>
	 * 0x44, Test=0x45<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationModeSettingSeeNote1(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Charging/discha rging amount setting 1 (See Note 2.)<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001-0x3B9AC9FF<br>
	 * �i1-999,999,999Wh�j�Fduring charging (positive value),<br>
	 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
	 * 999,999,999Wh�j�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setChargingDischaRgingAmountSetting1SeeNote2(byte[] edt) {return false;}
	/**
	 * Property name : Charging/discha rging amount setting 1 (See Note 2.)<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001-0x3B9AC9FF<br>
	 * �i1-999,999,999Wh�j�Fduring charging (positive value),<br>
	 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
	 * 999,999,999Wh�j�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getChargingDischaRgingAmountSetting1SeeNote2() {return null;}
	/**
	 * Property name : Charging/discha rging amount setting 1 (See Note 2.)<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001-0x3B9AC9FF<br>
	 * �i1-999,999,999Wh�j�Fduring charging (positive value),<br>
	 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
	 * 999,999,999Wh�j�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidChargingDischaRgingAmountSetting1SeeNote2(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Charging/discha rging amount setting 2 (See Note 2.)<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001-0x7FFD�i0.1-3,276.6Ah�j�F<br>
	 * during charging (positive value),<br>
	 * 0xFFFF-0x8001�i.0.1-.<br>
	 * 3,276.7Ah�j�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : 0.1A
h<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setChargingDischaRgingAmountSetting2SeeNote2(byte[] edt) {return false;}
	/**
	 * Property name : Charging/discha rging amount setting 2 (See Note 2.)<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001-0x7FFD�i0.1-3,276.6Ah�j�F<br>
	 * during charging (positive value),<br>
	 * 0xFFFF-0x8001�i.0.1-.<br>
	 * 3,276.7Ah�j�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : 0.1A
h<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getChargingDischaRgingAmountSetting2SeeNote2() {return null;}
	/**
	 * Property name : Charging/discha rging amount setting 2 (See Note 2.)<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001-0x7FFD�i0.1-3,276.6Ah�j�F<br>
	 * during charging (positive value),<br>
	 * 0xFFFF-0x8001�i.0.1-.<br>
	 * 3,276.7Ah�j�Fduring discharging<br>
	 * (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : 0.1A
h<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidChargingDischaRgingAmountSetting2SeeNote2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Remaining stored electricity 1 (See Note 3.)<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining stored electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF<br>
	 * �i0-999,999,999Wh�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getRemainingStoredElectricity1SeeNote3();
	/**
	 * Property name : Remaining stored electricity 1 (See Note 3.)<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining stored electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000-0x3B9AC9FF<br>
	 * �i0-999,999,999Wh�j<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4
Byte<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidRemainingStoredElectricity1SeeNote3(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Remaining stored electricity 2 (See Note 3.)<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : 0.1A
h<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getRemainingStoredElectricity2SeeNote3();
	/**
	 * Property name : Remaining stored electricity 2 (See Note 3.)<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2
Byte<br>
	 * <br>
	 * Unit : 0.1A
h<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidRemainingStoredElectricity2SeeNote3(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Remaining stored electricity 3 (See Note 3.) Batery stare of health<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This  property indicates the charging rate of the battery in terms of percentage.<br>
	 * (0-100%)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * This  property indicates the battery state of health in terms of percentage.<br>
	 * (0-100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
	/**
	 * Property name : Remaining stored electricity 3 (See Note 3.) Batery stare of health<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This  property indicates the charging rate of the battery in terms of percentage.<br>
	 * (0-100%)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * This  property indicates the battery state of health in terms of percentage.<br>
	 * (0-100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidRemainingStoredElectricity3SeeNote3BateryStareOfHealth(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Battery type<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the battery type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Type=0x00-0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getBatteryType();
	/**
	 * Property name : Battery type<br>
	 * <br>
	 * EPC : 0xE6<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the battery type.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Type=0x00-0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1
Byte<br>
	 * <br>
	 * Unit : null<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidBatteryType(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING : return setGmeasuredCumulativeDischargeElectricEnergyHResetSetting(property.edt);
		case EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING : return setGmeasuredCumulativeChargeElectricEnergyHResetSetting(property.edt);
		case EPC_OPERATION_MODE_SETTING_SEE_NOTE1 : return setOperationModeSettingSeeNote1(property.edt);
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2 : return setChargingDischaRgingAmountSetting1SeeNote2(property.edt);
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2 : return setChargingDischaRgingAmountSetting2SeeNote2(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_RATED_ELECTRIC_ENERGY : return getRatedElectricEnergy();
		case EPC_RATED_CAPACITY : return getRatedCapacity();
		case EPC_RATED_VOLTAGE : return getRatedVoltage();
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY : return getMeasuredInstantaneousChargeDischargEElectricEnergy();
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT : return getMeasuredInstantaneousChargeDischargECurrent();
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE : return getMeasuredInstantaneousChargeDischargEVoltage();
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY : return getMeasuredCumulativeDischargeElectricEnergy();
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY : return getMeasuredCumulativeChargeElectricEnergy();
		case EPC_OPERATION_MODE_SETTING_SEE_NOTE1 : return getOperationModeSettingSeeNote1();
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2 : return getChargingDischaRgingAmountSetting1SeeNote2();
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2 : return getChargingDischaRgingAmountSetting2SeeNote2();
		case EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3 : return getRemainingStoredElectricity1SeeNote3();
		case EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3 : return getRemainingStoredElectricity2SeeNote3();
		case EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH : return getRemainingStoredElectricity3SeeNote3BateryStareOfHealth();
		case EPC_BATTERY_TYPE : return getBatteryType();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_RATED_ELECTRIC_ENERGY : return isValidRatedElectricEnergy(property.edt);
		case EPC_RATED_CAPACITY : return isValidRatedCapacity(property.edt);
		case EPC_RATED_VOLTAGE : return isValidRatedVoltage(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY : return isValidMeasuredInstantaneousChargeDischargEElectricEnergy(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT : return isValidMeasuredInstantaneousChargeDischargECurrent(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE : return isValidMeasuredInstantaneousChargeDischargEVoltage(property.edt);
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY : return isValidMeasuredCumulativeDischargeElectricEnergy(property.edt);
		case EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING : return isValidGmeasuredCumulativeDischargeElectricEnergyHResetSetting(property.edt);
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY : return isValidMeasuredCumulativeChargeElectricEnergy(property.edt);
		case EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING : return isValidGmeasuredCumulativeChargeElectricEnergyHResetSetting(property.edt);
		case EPC_OPERATION_MODE_SETTING_SEE_NOTE1 : return isValidOperationModeSettingSeeNote1(property.edt);
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2 : return isValidChargingDischaRgingAmountSetting1SeeNote2(property.edt);
		case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2 : return isValidChargingDischaRgingAmountSetting2SeeNote2(property.edt);
		case EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3 : return isValidRemainingStoredElectricity1SeeNote3(property.edt);
		case EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3 : return isValidRemainingStoredElectricity2SeeNote3(property.edt);
		case EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH : return isValidRemainingStoredElectricity3SeeNote3BateryStareOfHealth(property.edt);
		case EPC_BATTERY_TYPE : return isValidBatteryType(property.edt);
		default : return false;
		}
	}

	@Override
	public Setter set() {
		return new Setter(this, true, false);
	}

	@Override
	public Setter set(boolean responseRequired) {
		return new Setter(this, responseRequired, false);
	}

	@Override
	public Getter get() {
		return new Getter(this, false);
	}

	@Override
	public Informer inform() {
		return new Informer(this, !isProxy());
	}
	
	@Override
	protected Informer inform(boolean multicast) {
		return new Informer(this, multicast);
	}
	
	public static class Receiver extends DeviceObject.Receiver {

		@Override
		protected boolean onSetProperty(EchoObject eoj, short tid, byte esv,
				EchoProperty property, boolean success) {
			boolean ret = super.onSetProperty(eoj, tid, esv, property, success);
			if(ret) return true;
			
			switch(property.epc) {
			case EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING : 
				onSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING : 
				onSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_MODE_SETTING_SEE_NOTE1 : 
				onSetOperationModeSettingSeeNote1(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2 : 
				onSetChargingDischaRgingAmountSetting1SeeNote2(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2 : 
				onSetChargingDischaRgingAmountSetting2SeeNote2(eoj, tid, esv, property, success);
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
			case EPC_RATED_ELECTRIC_ENERGY : 
				onGetRatedElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_CAPACITY : 
				onGetRatedCapacity(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_VOLTAGE : 
				onGetRatedVoltage(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY : 
				onGetMeasuredInstantaneousChargeDischargEElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT : 
				onGetMeasuredInstantaneousChargeDischargECurrent(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE : 
				onGetMeasuredInstantaneousChargeDischargEVoltage(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY : 
				onGetMeasuredCumulativeDischargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY : 
				onGetMeasuredCumulativeChargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_MODE_SETTING_SEE_NOTE1 : 
				onGetOperationModeSettingSeeNote1(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2 : 
				onGetChargingDischaRgingAmountSetting1SeeNote2(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2 : 
				onGetChargingDischaRgingAmountSetting2SeeNote2(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3 : 
				onGetRemainingStoredElectricity1SeeNote3(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3 : 
				onGetRemainingStoredElectricity2SeeNote3(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH : 
				onGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth(eoj, tid, esv, property, success);
				return true;
			case EPC_BATTERY_TYPE : 
				onGetBatteryType(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Rated electric energy<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated electric energy of the battery in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999,999Wh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated capacity<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1
Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedCapacity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated voltage<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated voltage of the battery in volts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE�i0-32,766V�j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedVoltage(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous charge/discharg
e electric energy<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001-0x3B9AC9FF<br>
		 * �i1-999,999,999W�j�Fduring charging<br>
		 * (positive value),<br>
		 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
		 * 999,999,999W)�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousChargeDischargEElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous charge/discharg e current<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFE�i0.1-3,276.6A�j�F<br>
		 * during charging (positive value),<br>
		 * 0xFFFF-0x8001�i.0.1-.<br>
		 * 3,276.7A�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousChargeDischargECurrent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous charge/discharg e voltage<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value),<br>
		 * 0xFFFF-0x8001�i.1-.32,767V�j�F<br>
		 * during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousChargeDischargEVoltage(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative discharge electric energy<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999.999kWh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredCumulativeDischargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gMeasured cumulative discharge electric energy�h reset setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset��0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		protected void onSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative charge electric energy<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999.999kWh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredCumulativeChargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : �gMeasured cumulative charge electric energy�h reset setting<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset��0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		protected void onSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting (See
Note 1.)<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging��0x41, Charging��<br>
		 * 0x42, Discharging��0x43, Standby��<br>
		 * 0x44, Test=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOperationModeSettingSeeNote1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting (See
Note 1.)<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging��0x41, Charging��<br>
		 * 0x42, Discharging��0x43, Standby��<br>
		 * 0x44, Test=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationModeSettingSeeNote1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging/discha rging amount setting 1 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001-0x3B9AC9FF<br>
		 * �i1-999,999,999Wh�j�Fduring charging (positive value),<br>
		 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
		 * 999,999,999Wh�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetChargingDischaRgingAmountSetting1SeeNote2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging/discha rging amount setting 1 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001-0x3B9AC9FF<br>
		 * �i1-999,999,999Wh�j�Fduring charging (positive value),<br>
		 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
		 * 999,999,999Wh�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetChargingDischaRgingAmountSetting1SeeNote2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging/discha rging amount setting 2 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFD�i0.1-3,276.6Ah�j�F<br>
		 * during charging (positive value),<br>
		 * 0xFFFF-0x8001�i.0.1-.<br>
		 * 3,276.7Ah�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A
h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetChargingDischaRgingAmountSetting2SeeNote2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging/discha rging amount setting 2 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFD�i0.1-3,276.6Ah�j�F<br>
		 * during charging (positive value),<br>
		 * 0xFFFF-0x8001�i.0.1-.<br>
		 * 3,276.7Ah�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A
h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetChargingDischaRgingAmountSetting2SeeNote2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining stored electricity 1 (See Note 3.)<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining stored electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999,999Wh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetRemainingStoredElectricity1SeeNote3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining stored electricity 2 (See Note 3.)<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A
h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetRemainingStoredElectricity2SeeNote3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining stored electricity 3 (See Note 3.) Batery stare of health<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This  property indicates the charging rate of the battery in terms of percentage.<br>
		 * (0-100%)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * This  property indicates the battery state of health in terms of percentage.<br>
		 * (0-100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Battery type<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the battery type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type=0x00-0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetBatteryType(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
	}

	public static class Setter extends DeviceObject.Setter {
		public Setter(EchoObject eoj, boolean responseRequired, boolean multicast) {
			super(eoj, responseRequired, multicast);
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
		 * Property name : �gMeasured cumulative discharge electric energy�h reset setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets �gMeasured cumulative discharge electric energy�h to zero.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset��0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetGmeasuredCumulativeDischargeElectricEnergyHResetSetting(byte[] edt) {
			addProperty(EPC_GMEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_H_RESET_SETTING, edt);
			return this;
		}
		/**
		 * Property name : �gMeasured cumulative charge electric energy�h reset setting<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets �gMeasured cumulative charge electric energy�h to zero.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset��0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - undefined<br>
		 */
		public Setter reqSetGmeasuredCumulativeChargeElectricEnergyHResetSetting(byte[] edt) {
			addProperty(EPC_GMEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_H_RESET_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Operation mode setting (See
Note 1.)<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging��0x41, Charging��<br>
		 * 0x42, Discharging��0x43, Standby��<br>
		 * 0x44, Test=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOperationModeSettingSeeNote1(byte[] edt) {
			addProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1, edt);
			return this;
		}
		/**
		 * Property name : Charging/discha rging amount setting 1 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001-0x3B9AC9FF<br>
		 * �i1-999,999,999Wh�j�Fduring charging (positive value),<br>
		 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
		 * 999,999,999Wh�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetChargingDischaRgingAmountSetting1SeeNote2(byte[] edt) {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2, edt);
			return this;
		}
		/**
		 * Property name : Charging/discha rging amount setting 2 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFD�i0.1-3,276.6Ah�j�F<br>
		 * during charging (positive value),<br>
		 * 0xFFFF-0x8001�i.0.1-.<br>
		 * 3,276.7Ah�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A
h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetChargingDischaRgingAmountSetting2SeeNote2(byte[] edt) {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2, edt);
			return this;
		}
	}
	
	public static class Getter extends DeviceObject.Getter {
		public Getter(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
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
		 * Property name : Rated electric energy<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated electric energy of the battery in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999,999Wh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedElectricEnergy() {
			addProperty(EPC_RATED_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Rated capacity<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1
Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedCapacity() {
			addProperty(EPC_RATED_CAPACITY);
			return this;
		}
		/**
		 * Property name : Rated voltage<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated voltage of the battery in volts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE�i0-32,766V�j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedVoltage() {
			addProperty(EPC_RATED_VOLTAGE);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharg
e electric energy<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001-0x3B9AC9FF<br>
		 * �i1-999,999,999W�j�Fduring charging<br>
		 * (positive value),<br>
		 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
		 * 999,999,999W)�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargEElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharg e current<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFE�i0.1-3,276.6A�j�F<br>
		 * during charging (positive value),<br>
		 * 0xFFFF-0x8001�i.0.1-.<br>
		 * 3,276.7A�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargECurrent() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharg e voltage<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value),<br>
		 * 0xFFFF-0x8001�i.1-.32,767V�j�F<br>
		 * during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargEVoltage() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE);
			return this;
		}
		/**
		 * Property name : Measured cumulative discharge electric energy<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999.999kWh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredCumulativeDischargeElectricEnergy() {
			addProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured cumulative charge electric energy<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999.999kWh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredCumulativeChargeElectricEnergy() {
			addProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Operation mode setting (See
Note 1.)<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging��0x41, Charging��<br>
		 * 0x42, Discharging��0x43, Standby��<br>
		 * 0x44, Test=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOperationModeSettingSeeNote1() {
			addProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1);
			return this;
		}
		/**
		 * Property name : Charging/discha rging amount setting 1 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001-0x3B9AC9FF<br>
		 * �i1-999,999,999Wh�j�Fduring charging (positive value),<br>
		 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
		 * 999,999,999Wh�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetChargingDischaRgingAmountSetting1SeeNote2() {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2);
			return this;
		}
		/**
		 * Property name : Charging/discha rging amount setting 2 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFD�i0.1-3,276.6Ah�j�F<br>
		 * during charging (positive value),<br>
		 * 0xFFFF-0x8001�i.0.1-.<br>
		 * 3,276.7Ah�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A
h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetChargingDischaRgingAmountSetting2SeeNote2() {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 1 (See Note 3.)<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining stored electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999,999Wh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetRemainingStoredElectricity1SeeNote3() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 2 (See Note 3.)<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A
h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetRemainingStoredElectricity2SeeNote3() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 3 (See Note 3.) Batery stare of health<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This  property indicates the charging rate of the battery in terms of percentage.<br>
		 * (0-100%)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * This  property indicates the battery state of health in terms of percentage.<br>
		 * (0-100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetRemainingStoredElectricity3SeeNote3BateryStareOfHealth() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH);
			return this;
		}
		/**
		 * Property name : Battery type<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the battery type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type=0x00-0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetBatteryType() {
			addProperty(EPC_BATTERY_TYPE);
			return this;
		}
	}
	
	public static class Informer extends DeviceObject.Informer {
		public Informer(EchoObject eoj, boolean multicast) {
			super(eoj, multicast);
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
		
		/**
		 * Property name : Rated electric energy<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated electric energy of the battery in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999,999Wh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedElectricEnergy() {
			addProperty(EPC_RATED_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Rated capacity<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated charging capacity of the battery in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1
Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedCapacity() {
			addProperty(EPC_RATED_CAPACITY);
			return this;
		}
		/**
		 * Property name : Rated voltage<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated voltage of the battery in volts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE�i0-32,766V�j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedVoltage() {
			addProperty(EPC_RATED_VOLTAGE);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharg
e electric energy<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001-0x3B9AC9FF<br>
		 * �i1-999,999,999W�j�Fduring charging<br>
		 * (positive value),<br>
		 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
		 * 999,999,999W)�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargEElectricEnergy() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharg e current<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFE�i0.1-3,276.6A�j�F<br>
		 * during charging (positive value),<br>
		 * 0xFFFF-0x8001�i.0.1-.<br>
		 * 3,276.7A�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargECurrent() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_CURRENT);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharg e voltage<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFE�i1-32,766V�j�Fduring charging (positive value),<br>
		 * 0xFFFF-0x8001�i.1-.32,767V�j�F<br>
		 * during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargEVoltage() {
			addProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARG_E_VOLTAGE);
			return this;
		}
		/**
		 * Property name : Measured cumulative discharge electric energy<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999.999kWh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredCumulativeDischargeElectricEnergy() {
			addProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured cumulative charge electric energy<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999.999kWh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : 0.001 kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredCumulativeChargeElectricEnergy() {
			addProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Operation mode setting (See
Note 1.)<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: �gRapid charging,�h �gCharging,�h �gDischarging,�h �gStandby�h or �gTest.�h<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging��0x41, Charging��<br>
		 * 0x42, Discharging��0x43, Standby��<br>
		 * 0x44, Test=0x45<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOperationModeSettingSeeNote1() {
			addProperty(EPC_OPERATION_MODE_SETTING_SEE_NOTE1);
			return this;
		}
		/**
		 * Property name : Charging/discha rging amount setting 1 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001-0x3B9AC9FF<br>
		 * �i1-999,999,999Wh�j�Fduring charging (positive value),<br>
		 * 0xFFFFFFFF-0xC4653601 (.1-.<br>
		 * 999,999,999Wh�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformChargingDischaRgingAmountSetting1SeeNote2() {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING1_SEE_NOTE2);
			return this;
		}
		/**
		 * Property name : Charging/discha rging amount setting 2 (See Note 2.)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001-0x7FFD�i0.1-3,276.6Ah�j�F<br>
		 * during charging (positive value),<br>
		 * 0xFFFF-0x8001�i.0.1-.<br>
		 * 3,276.7Ah�j�Fduring discharging<br>
		 * (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A
h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformChargingDischaRgingAmountSetting2SeeNote2() {
			addProperty(EPC_CHARGING_DISCHA_RGING_AMOUNT_SETTING2_SEE_NOTE2);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 1 (See Note 3.)<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining stored electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000-0x3B9AC9FF<br>
		 * �i0-999,999,999Wh�j<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4
Byte<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformRemainingStoredElectricity1SeeNote3() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY1_SEE_NOTE3);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 2 (See Note 3.)<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE�i0-3,276.6Ah�j<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2
Byte<br>
		 * <br>
		 * Unit : 0.1A
h<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformRemainingStoredElectricity2SeeNote3() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY2_SEE_NOTE3);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 3 (See Note 3.) Batery stare of health<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This  property indicates the charging rate of the battery in terms of percentage.<br>
		 * (0-100%)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * This  property indicates the battery state of health in terms of percentage.<br>
		 * (0-100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformRemainingStoredElectricity3SeeNote3BateryStareOfHealth() {
			addProperty(EPC_REMAINING_STORED_ELECTRICITY3_SEE_NOTE3_BATERY_STARE_OF_HEALTH);
			return this;
		}
		/**
		 * Property name : Battery type<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the battery type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type=0x00-0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1
Byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformBatteryType() {
			addProperty(EPC_BATTERY_TYPE);
			return this;
		}
	}

	public static class Proxy extends Battery {
		private byte mInstanceCode;
		public Proxy(byte instanceCode) {
			super();
			mInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mInstanceCode;
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
		protected boolean setOperationModeSettingSeeNote1(byte[] edt) {return false;}
		@Override
		protected byte[] getOperationModeSettingSeeNote1() {return null;}
		@Override
		protected byte[] getRemainingStoredElectricity1SeeNote3() {return null;}
		@Override
		protected byte[] getRemainingStoredElectricity2SeeNote3() {return null;}
		@Override
		protected byte[] getRemainingStoredElectricity3SeeNote3BateryStareOfHealth() {return null;}
		@Override
		protected byte[] getBatteryType() {return null;}
	}
	
	public static Setter setG() {
		return setG((byte)0);
	}

	public static Setter setG(byte instanceCode) {
		return new Setter(new Proxy(instanceCode), true, true);
	}

	public static Setter setG(boolean responseRequired) {
		return setG((byte)0, responseRequired);
	}

	public static Setter setG(byte instanceCode, boolean responseRequired) {
		return new Setter(new Proxy(instanceCode), responseRequired, true);
	}

	public static Getter getG() {
		return getG((byte)0);
	}
	
	public static Getter getG(byte instanceCode) {
		return new Getter(new Proxy(instanceCode), true);
	}

	public static Informer informG() {
		return informG((byte)0);
	}

	public static Informer informG(byte instanceCode) {
		return new Informer(new Proxy(instanceCode), true);
	}

}
