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

public abstract class Battery extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x027D;

	public static final byte EPC_MINIMUM_MAXIM_UM_CHARGE_ELECTRIC_ENERGY = (byte)0xC8;
	public static final byte EPC_MINIMUM_MAXIM_UM_DISCHARGE_ELECTRIC_ENERGY = (byte)0xC9;
	public static final byte EPC_MINIMUM_MAXIM_UM_CHARGE_CURRENT = (byte)0xCA;
	public static final byte EPC_MINIMUM_MAXIM_UM_DISCHARGE_CURRENT = (byte)0xCB;
	public static final byte EPC_RATED_ELECTRIC_ENERGY = (byte)0xD0;
	public static final byte EPC_RATED_CAPACITY = (byte)0xD1;
	public static final byte EPC_RATED_VOLTAGE = (byte)0xD2;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_ELECTRIC_ENERGY = (byte)0xD3;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_CURRENT = (byte)0xD4;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_VOLTAGE = (byte)0xD5;
	public static final byte EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY = (byte)0xD6;
	public static final byte EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING = (byte)0xD7;
	public static final byte EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY = (byte)0xD8;
	public static final byte EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING = (byte)0xD9;
	public static final byte EPC_OPERATION_MODE_SETTING = (byte)0xDA;
	public static final byte EPC_SYSTEM_INTERCONN_ECTED_TYPE = (byte)0xDB;
	public static final byte EPC_MINIMUM_MAXIMUM_CHARGING_POWER_INDEPENDENT = (byte)0xDC;
	public static final byte EPC_MINIMUM_MAXIM_UM_DISCHARGING_POWER_INDEPENDENT = (byte)0xDD;
	public static final byte EPC_MINIMUM_MAXIM_UM_CHARGING_CURRENT_INDEPENDENT = (byte)0xDE;
	public static final byte EPC_MINIMUM_MAXIM_UM_DISCHARGING_CURRENT_INDEPENDENT = (byte)0xDF;
	public static final byte EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING1 = (byte)0xE0;
	public static final byte EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING2 = (byte)0xE1;
	public static final byte EPC_REMAINING_STORED_ELECTRICITY1 = (byte)0xE2;
	public static final byte EPC_REMAINING_STORED_ELECTRICITY2 = (byte)0xE3;
	public static final byte EPC_REMAINING_STORED_ELECTRICITY3_BATTERY_STATE_OF_HEALTH = (byte)0xE4;
	public static final byte EPC_BATTERY_TYPE = (byte)0xE6;
	public static final byte EPC_CHARGING_AMOUNT_SETTING1 = (byte)0xE7;
	public static final byte EPC_DISCHARGING_AMOUNT_SETTING1 = (byte)0xE8;
	public static final byte EPC_CHARGING_AMOUNT_SETTING2 = (byte)0xE9;
	public static final byte EPC_DISCHARGING_AMOUNT_SETTING2 = (byte)0xEA;
	public static final byte EPC_CHARGE_ELECTRIC_ENERGY_SETTING = (byte)0xEB;
	public static final byte EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING = (byte)0xEC;
	public static final byte EPC_CHARGE_CURRENT_SETTING = (byte)0xED;
	public static final byte EPC_DISCHARGE_CURRENT_SETTING = (byte)0xEE;
	public static final byte EPC_RATED_VOLTAGE_INDEPENDENT = (byte)0xEF;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_MODE_SETTING);
		addSetProperty(EPC_OPERATION_MODE_SETTING);
		addGetProperty(EPC_OPERATION_MODE_SETTING);
		addGetProperty(EPC_REMAINING_STORED_ELECTRICITY1);
		addGetProperty(EPC_REMAINING_STORED_ELECTRICITY2);
		addGetProperty(EPC_REMAINING_STORED_ELECTRICITY3_BATTERY_STATE_OF_HEALTH);
		addGetProperty(EPC_BATTERY_TYPE);
	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewBattery(this);
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
	 * Unit : null<br>
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
	 * Unit : null<br>
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
	 * Property name : Minimum/maxim um charge electric energy<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum/maximum electric energy for charging in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * Minimum : maximum<br>
	 * <br>
	 * Data type : unsigned long
×2<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumMaximUmChargeElectricEnergy() {return null;}
	/**
	 * Property name : Minimum/maxim um charge electric energy<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum/maximum electric energy for charging in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * Minimum : maximum<br>
	 * <br>
	 * Data type : unsigned long
×2<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumMaximUmChargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Minimum/maxim um discharge electric energy<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum/maximum electric energy for discharging in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * Minimum : maximum<br>
	 * <br>
	 * Data type : unsigned long
×2<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumMaximUmDischargeElectricEnergy() {return null;}
	/**
	 * Property name : Minimum/maxim um discharge electric energy<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum/maximum electric energy for discharging in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * Minimum : maximum<br>
	 * <br>
	 * Data type : unsigned long
×2<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumMaximUmDischargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Minimum/maxim um charge current<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum/maximum current for charging in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE(0.3,276.6A)<br>
	 * Minimum : maximum<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumMaximUmChargeCurrent() {return null;}
	/**
	 * Property name : Minimum/maxim um charge current<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum/maximum current for charging in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE(0.3,276.6A)<br>
	 * Minimum : maximum<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumMaximUmChargeCurrent(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Minimum/maxim um discharge current<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum/maximum current for discharging in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE(0.3,276.6A)<br>
	 * Minimum : maximum<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumMaximUmDischargeCurrent() {return null;}
	/**
	 * Property name : Minimum/maxim um discharge current<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum/maximum current for discharging in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE(0.3,276.6A)<br>
	 * Minimum : maximum<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumMaximUmDischargeCurrent(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
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
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
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
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
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
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
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
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
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
	 * 0x0000.0x7FFE (0.32,766V)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
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
	 * 0x0000.0x7FFE (0.32,766V)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
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
	 * Property name : Measured instantaneous charge/discharge electric energy<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001.0x3B9AC9FF (1.<br>
	 * 999,999,999W) : during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1. -999,999,999W) :<br>
	 * during discharging (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargeElectricEnergy() {return null;}
	/**
	 * Property name : Measured instantaneous charge/discharge electric energy<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001.0x3B9AC9FF (1.<br>
	 * 999,999,999W) : during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1. -999,999,999W) :<br>
	 * during discharging (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousChargeDischargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous charge/discharge current<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFE (0.1.3,276.6A) :<br>
	 * during charging (positive value), 0xFFFF-0x8001 (-0.1. -3,276.7A) :<br>
	 * during discharging (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargeCurrent() {return null;}
	/**
	 * Property name : Measured instantaneous charge/discharge current<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFE (0.1.3,276.6A) :<br>
	 * during charging (positive value), 0xFFFF-0x8001 (-0.1. -3,276.7A) :<br>
	 * during discharging (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousChargeDischargeCurrent(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Measured instantaneous charge/discharge voltage<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFE (1.32,766V) : during<br>
	 * charging (positive value), 0xFFFF. 0x8001 (-1. -32,767V) : during<br>
	 * discharging (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargeVoltage() {return null;}
	/**
	 * Property name : Measured instantaneous charge/discharge voltage<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFE (1.32,766V) : during<br>
	 * charging (positive value), 0xFFFF. 0x8001 (-1. -32,767V) : during<br>
	 * discharging (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMeasuredInstantaneousChargeDischargeVoltage(byte[] edt) {
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
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999.999kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001k
Wh<br>
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
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999.999kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001k
Wh<br>
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
	 * Property name : “Measured cumulative discharge electric energy” reset setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets “Measured cumulative discharge electric energy” to zero.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
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
	 * Get - undefined<br>
	 */
	protected boolean setMeasuredCumulativeDischargeElectricEnergyResetSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Measured cumulative discharge electric energy” reset setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets “Measured cumulative discharge electric energy” to zero.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
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
	 * Get - undefined<br>
	 */
	protected boolean isValidMeasuredCumulativeDischargeElectricEnergyResetSetting(byte[] edt) {
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
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999.999kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001k
Wh<br>
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
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999.999kWh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.001k
Wh<br>
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
	 * Property name : “Measured cumulative charge electric energy” reset setting<br>
	 * <br>
	 * EPC : 0xD9<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets “Measured cumulative charge electric energy” to zero.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
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
	 * Get - undefined<br>
	 */
	protected boolean setMeasuredCumulativeChargeElectricEnergyResetSetting(byte[] edt) {return false;}
	/**
	 * Property name : “Measured cumulative charge electric energy” reset setting<br>
	 * <br>
	 * EPC : 0xD9<br>
	 * <br>
	 * Contents of property :<br>
	 * Resets “Measured cumulative charge electric energy” to zero.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset=0x00<br>
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
	 * Get - undefined<br>
	 */
	protected boolean isValidMeasuredCumulativeChargeElectricEnergyResetSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the battery to one of the following operation modes: “Rapid charging,” “Charging,” “Discharging,” “Standby,” “Test” or “Others.”<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rapid charging=0x41, Charging=0x42, Discharging=0x43, Standby=0x44, Test=0x45, Others=0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationModeSetting(byte[] edt);
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the battery to one of the following operation modes: “Rapid charging,” “Charging,” “Discharging,” “Standby,” “Test” or “Others.”<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rapid charging=0x41, Charging=0x42, Discharging=0x43, Standby=0x44, Test=0x45, Others=0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationModeSetting();
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents of property :<br>
	 * Sets the battery to one of the following operation modes: “Rapid charging,” “Charging,” “Discharging,” “Standby,” “Test” or “Others.”<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rapid charging=0x41, Charging=0x42, Discharging=0x43, Standby=0x44, Test=0x45, Others=0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
	 * <br>
	 * Unit : —<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - mandatory<br>
	 * Get - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : System-interconn ected type<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the status of connection with the current system (system interconnection status).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * System interconnection (reverse power flow acceptable) = 0x00, Independent type = 0x01, System-interconnected type (reverse power flow not acceptable) =0x02<br>
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
	protected byte[] getSystemInterconnEctedType() {return null;}
	/**
	 * Property name : System-interconn ected type<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the status of connection with the current system (system interconnection status).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * System interconnection (reverse power flow acceptable) = 0x00, Independent type = 0x01, System-interconnected type (reverse power flow not acceptable) =0x02<br>
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
	protected boolean isValidSystemInterconnEctedType(byte[] edt) {
		if(edt == null || !(edt.length == 1)) return false;
		return true;
	}
	/**
	 * Property name : Minimum/maximum charging power (Independent)<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum and maximum values of charging power battery in watts in the dependent status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
	 * Minimum charging power:Maximum charging power<br>
	 * <br>
	 * Data type : unsigned long
×2<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumMaximumChargingPowerIndependent() {return null;}
	/**
	 * Property name : Minimum/maximum charging power (Independent)<br>
	 * <br>
	 * EPC : 0xDC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum and maximum values of charging power battery in watts in the dependent status.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
	 * Minimum charging power:Maximum charging power<br>
	 * <br>
	 * Data type : unsigned long
×2<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumMaximumChargingPowerIndependent(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : ￼
Minimum/maxim um discharging power (Independent)<br>
	 * <br>
	 * EPC : 0xDD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum and maximum values of discharging power from the battery in the independent status in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
	 * Minimum discharging power: Maximum discharging power<br>
	 * <br>
	 * Data type : unsigned long
×2<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumMaximUmDischargingPowerIndependent() {return null;}
	/**
	 * Property name : ￼
Minimum/maxim um discharging power (Independent)<br>
	 * <br>
	 * EPC : 0xDD<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum and maximum values of discharging power from the battery in the independent status in watts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
	 * Minimum discharging power: Maximum discharging power<br>
	 * <br>
	 * Data type : unsigned long
×2<br>
	 * <br>
	 * Data size : 8 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumMaximUmDischargingPowerIndependent(byte[] edt) {
		if(edt == null || !(edt.length == 8)) return false;
		return true;
	}
	/**
	 * Property name : Minimum/maxim um charging current (Independent)<br>
	 * <br>
	 * EPC : 0xDE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum and maximum values of a charging current to the battery in the independent status in units of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0x7FFE(0–3,276.6A)<br>
	 * Minimum charging current:Maximum charging current<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumMaximUmChargingCurrentIndependent() {return null;}
	/**
	 * Property name : Minimum/maxim um charging current (Independent)<br>
	 * <br>
	 * EPC : 0xDE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum and maximum values of a charging current to the battery in the independent status in units of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0x7FFE(0–3,276.6A)<br>
	 * Minimum charging current:Maximum charging current<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumMaximUmChargingCurrentIndependent(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Minimum/maxim um discharging current (Independent)<br>
	 * <br>
	 * EPC : 0xDF<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum and maximum values of a discharging current in the independent status in units of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0x7FFE(0–3,276.6A)<br>
	 * Minimum discharging current: Maximum discharging current<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getMinimumMaximUmDischargingCurrentIndependent() {return null;}
	/**
	 * Property name : Minimum/maxim um discharging current (Independent)<br>
	 * <br>
	 * EPC : 0xDF<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the minimum and maximum values of a discharging current in the independent status in units of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0x7FFE(0–3,276.6A)<br>
	 * Minimum discharging current: Maximum discharging current<br>
	 * <br>
	 * Data type : unsigned short
×2<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidMinimumMaximUmDischargingCurrentIndependent(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Charging/dischar ging amount setting 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001.0x3B9AC9FF (1.<br>
	 * 999,999,999Wh):during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1.<br>
	 * -999,999,999Wh):during discharging (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setChargingDischarGingAmountSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Charging/dischar ging amount setting 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001.0x3B9AC9FF (1.<br>
	 * 999,999,999Wh):during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1.<br>
	 * -999,999,999Wh):during discharging (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getChargingDischarGingAmountSetting1() {return null;}
	/**
	 * Property name : Charging/dischar ging amount setting 1<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001.0x3B9AC9FF (1.<br>
	 * 999,999,999Wh):during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1.<br>
	 * -999,999,999Wh):during discharging (negative value)<br>
	 * <br>
	 * Data type : signed long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidChargingDischarGingAmountSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Charging/dischar ging amount setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFD (0.1.3,276.6Ah):<br>
	 * during charging (positive value), 0xFFFF.0x8001 (-0.1.<br>
	 * -3,276.7Ah) :during discharging (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setChargingDischarGingAmountSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Charging/dischar ging amount setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFD (0.1.3,276.6Ah):<br>
	 * during charging (positive value), 0xFFFF.0x8001 (-0.1.<br>
	 * -3,276.7Ah) :during discharging (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getChargingDischarGingAmountSetting2() {return null;}
	/**
	 * Property name : Charging/dischar ging amount setting 2<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents of property :<br>
	 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFD (0.1.3,276.6Ah):<br>
	 * during charging (positive value), 0xFFFF.0x8001 (-0.1.<br>
	 * -3,276.7Ah) :during discharging (negative value)<br>
	 * <br>
	 * Data type : signed short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidChargingDischarGingAmountSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Remaining stored electricity 1<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining stored electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getRemainingStoredElectricity1();
	/**
	 * Property name : Remaining stored electricity 1<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining stored electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidRemainingStoredElectricity1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Remaining stored electricity 2<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getRemainingStoredElectricity2();
	/**
	 * Property name : Remaining stored electricity 2<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidRemainingStoredElectricity2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Remaining stored electricity 3 Battery state of health<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the charging rate of the battery in %.<br>
	 * (0.100%)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * This property indicates the battery state of health in %.<br>
	 * (0.100%)<br>
	 * <br>
	 * Data type : unsigned char unsigned char<br>
	 * <br>
	 * Data size : 1 byte 1 byte<br>
	 * <br>
	 * Unit : % %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected abstract byte[] getRemainingStoredElectricity3BatteryStateOfHealth();
	/**
	 * Property name : Remaining stored electricity 3 Battery state of health<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the charging rate of the battery in %.<br>
	 * (0.100%)<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * This property indicates the battery state of health in %.<br>
	 * (0.100%)<br>
	 * <br>
	 * Data type : unsigned char unsigned char<br>
	 * <br>
	 * Data size : 1 byte 1 byte<br>
	 * <br>
	 * Unit : % %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - mandatory<br>
	 */
	protected boolean isValidRemainingStoredElectricity3BatteryStateOfHealth(byte[] edt) {
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
	 * Type=0x00.0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
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
	 * Type=0x00.0xFF<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * <br>
	 * Data size : 1 byte<br>
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
	/**
	 * Property name : Charging amount setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charge electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setChargingAmountSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Charging amount setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charge electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getChargingAmountSetting1() {return null;}
	/**
	 * Property name : Charging amount setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charge electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidChargingAmountSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Discharging amount setting 1<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharge electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDischargingAmountSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Discharging amount setting 1<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharge electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDischargingAmountSetting1() {return null;}
	/**
	 * Property name : Discharging amount setting 1<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharge electric energy in Wh.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDischargingAmountSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Charging amount setting 2<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charging capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x7FFE (0-3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setChargingAmountSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Charging amount setting 2<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charging capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x7FFE (0-3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getChargingAmountSetting2() {return null;}
	/**
	 * Property name : Charging amount setting 2<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charging capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000-0x7FFE (0-3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidChargingAmountSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Discharging amount setting 2<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharging capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDischargingAmountSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Discharging amount setting 2<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharging capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDischargingAmountSetting2() {return null;}
	/**
	 * Property name : Discharging amount setting 2<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharging capacity in increments of 0.1Ah.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDischargingAmountSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Charge electric energy setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charge electric energy in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setChargeElectricEnergySetting(byte[] edt) {return false;}
	/**
	 * Property name : Charge electric energy setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charge electric energy in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getChargeElectricEnergySetting() {return null;}
	/**
	 * Property name : Charge electric energy setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charge electric energy in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidChargeElectricEnergySetting(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Discharge electric energy setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharge electric energy in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDischargeElectricEnergySetting(byte[] edt) {return false;}
	/**
	 * Property name : Discharge electric energy setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharge electric energy in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDischargeElectricEnergySetting() {return null;}
	/**
	 * Property name : Discharge electric energy setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharge electric energy in W.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.<br>
	 * 999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * <br>
	 * Data size : 4 bytes<br>
	 * <br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDischargeElectricEnergySetting(byte[] edt) {
		if(edt == null || !(edt.length == 4)) return false;
		return true;
	}
	/**
	 * Property name : Charge current setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charge current in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setChargeCurrentSetting(byte[] edt) {return false;}
	/**
	 * Property name : Charge current setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charge current in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getChargeCurrentSetting() {return null;}
	/**
	 * Property name : Charge current setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the charge current in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidChargeCurrentSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Discharge current setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharge current in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean setDischargeCurrentSetting(byte[] edt) {return false;}
	/**
	 * Property name : Discharge current setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharge current in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected byte[] getDischargeCurrentSetting() {return null;}
	/**
	 * Property name : Discharge current setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents of property :<br>
	 * This property specifies the discharge current in increments of 0.1A.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - optional<br>
	 * Get - optional<br>
	 */
	protected boolean isValidDischargeCurrentSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}
	/**
	 * Property name : Rated voltage (Independent)<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated voltage of a battery in the independent status in volts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0x7FFE (0–32,766V)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected byte[] getRatedVoltageIndependent() {return null;}
	/**
	 * Property name : Rated voltage (Independent)<br>
	 * <br>
	 * EPC : 0xEF<br>
	 * <br>
	 * Contents of property :<br>
	 * This property indicates the rated voltage of a battery in the independent status in volts.<br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000–0x7FFE (0–32,766V)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * <br>
	 * Data size : 2 bytes<br>
	 * <br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - undefined<br>
	 * Set - undefined<br>
	 * Get - optional<br>
	 */
	protected boolean isValidRatedVoltageIndependent(byte[] edt) {
		if(edt == null || !(edt.length == 2)) return false;
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING : return setMeasuredCumulativeDischargeElectricEnergyResetSetting(property.edt);
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING : return setMeasuredCumulativeChargeElectricEnergyResetSetting(property.edt);
		case EPC_OPERATION_MODE_SETTING : return setOperationModeSetting(property.edt);
		case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING1 : return setChargingDischarGingAmountSetting1(property.edt);
		case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING2 : return setChargingDischarGingAmountSetting2(property.edt);
		case EPC_CHARGING_AMOUNT_SETTING1 : return setChargingAmountSetting1(property.edt);
		case EPC_DISCHARGING_AMOUNT_SETTING1 : return setDischargingAmountSetting1(property.edt);
		case EPC_CHARGING_AMOUNT_SETTING2 : return setChargingAmountSetting2(property.edt);
		case EPC_DISCHARGING_AMOUNT_SETTING2 : return setDischargingAmountSetting2(property.edt);
		case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : return setChargeElectricEnergySetting(property.edt);
		case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : return setDischargeElectricEnergySetting(property.edt);
		case EPC_CHARGE_CURRENT_SETTING : return setChargeCurrentSetting(property.edt);
		case EPC_DISCHARGE_CURRENT_SETTING : return setDischargeCurrentSetting(property.edt);
		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_MINIMUM_MAXIM_UM_CHARGE_ELECTRIC_ENERGY : return getMinimumMaximUmChargeElectricEnergy();
		case EPC_MINIMUM_MAXIM_UM_DISCHARGE_ELECTRIC_ENERGY : return getMinimumMaximUmDischargeElectricEnergy();
		case EPC_MINIMUM_MAXIM_UM_CHARGE_CURRENT : return getMinimumMaximUmChargeCurrent();
		case EPC_MINIMUM_MAXIM_UM_DISCHARGE_CURRENT : return getMinimumMaximUmDischargeCurrent();
		case EPC_RATED_ELECTRIC_ENERGY : return getRatedElectricEnergy();
		case EPC_RATED_CAPACITY : return getRatedCapacity();
		case EPC_RATED_VOLTAGE : return getRatedVoltage();
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_ELECTRIC_ENERGY : return getMeasuredInstantaneousChargeDischargeElectricEnergy();
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_CURRENT : return getMeasuredInstantaneousChargeDischargeCurrent();
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_VOLTAGE : return getMeasuredInstantaneousChargeDischargeVoltage();
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY : return getMeasuredCumulativeDischargeElectricEnergy();
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY : return getMeasuredCumulativeChargeElectricEnergy();
		case EPC_OPERATION_MODE_SETTING : return getOperationModeSetting();
		case EPC_SYSTEM_INTERCONN_ECTED_TYPE : return getSystemInterconnEctedType();
		case EPC_MINIMUM_MAXIMUM_CHARGING_POWER_INDEPENDENT : return getMinimumMaximumChargingPowerIndependent();
		case EPC_MINIMUM_MAXIM_UM_DISCHARGING_POWER_INDEPENDENT : return getMinimumMaximUmDischargingPowerIndependent();
		case EPC_MINIMUM_MAXIM_UM_CHARGING_CURRENT_INDEPENDENT : return getMinimumMaximUmChargingCurrentIndependent();
		case EPC_MINIMUM_MAXIM_UM_DISCHARGING_CURRENT_INDEPENDENT : return getMinimumMaximUmDischargingCurrentIndependent();
		case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING1 : return getChargingDischarGingAmountSetting1();
		case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING2 : return getChargingDischarGingAmountSetting2();
		case EPC_REMAINING_STORED_ELECTRICITY1 : return getRemainingStoredElectricity1();
		case EPC_REMAINING_STORED_ELECTRICITY2 : return getRemainingStoredElectricity2();
		case EPC_REMAINING_STORED_ELECTRICITY3_BATTERY_STATE_OF_HEALTH : return getRemainingStoredElectricity3BatteryStateOfHealth();
		case EPC_BATTERY_TYPE : return getBatteryType();
		case EPC_CHARGING_AMOUNT_SETTING1 : return getChargingAmountSetting1();
		case EPC_DISCHARGING_AMOUNT_SETTING1 : return getDischargingAmountSetting1();
		case EPC_CHARGING_AMOUNT_SETTING2 : return getChargingAmountSetting2();
		case EPC_DISCHARGING_AMOUNT_SETTING2 : return getDischargingAmountSetting2();
		case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : return getChargeElectricEnergySetting();
		case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : return getDischargeElectricEnergySetting();
		case EPC_CHARGE_CURRENT_SETTING : return getChargeCurrentSetting();
		case EPC_DISCHARGE_CURRENT_SETTING : return getDischargeCurrentSetting();
		case EPC_RATED_VOLTAGE_INDEPENDENT : return getRatedVoltageIndependent();
		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_MINIMUM_MAXIM_UM_CHARGE_ELECTRIC_ENERGY : return isValidMinimumMaximUmChargeElectricEnergy(property.edt);
		case EPC_MINIMUM_MAXIM_UM_DISCHARGE_ELECTRIC_ENERGY : return isValidMinimumMaximUmDischargeElectricEnergy(property.edt);
		case EPC_MINIMUM_MAXIM_UM_CHARGE_CURRENT : return isValidMinimumMaximUmChargeCurrent(property.edt);
		case EPC_MINIMUM_MAXIM_UM_DISCHARGE_CURRENT : return isValidMinimumMaximUmDischargeCurrent(property.edt);
		case EPC_RATED_ELECTRIC_ENERGY : return isValidRatedElectricEnergy(property.edt);
		case EPC_RATED_CAPACITY : return isValidRatedCapacity(property.edt);
		case EPC_RATED_VOLTAGE : return isValidRatedVoltage(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_ELECTRIC_ENERGY : return isValidMeasuredInstantaneousChargeDischargeElectricEnergy(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_CURRENT : return isValidMeasuredInstantaneousChargeDischargeCurrent(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_VOLTAGE : return isValidMeasuredInstantaneousChargeDischargeVoltage(property.edt);
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY : return isValidMeasuredCumulativeDischargeElectricEnergy(property.edt);
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING : return isValidMeasuredCumulativeDischargeElectricEnergyResetSetting(property.edt);
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY : return isValidMeasuredCumulativeChargeElectricEnergy(property.edt);
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING : return isValidMeasuredCumulativeChargeElectricEnergyResetSetting(property.edt);
		case EPC_OPERATION_MODE_SETTING : return isValidOperationModeSetting(property.edt);
		case EPC_SYSTEM_INTERCONN_ECTED_TYPE : return isValidSystemInterconnEctedType(property.edt);
		case EPC_MINIMUM_MAXIMUM_CHARGING_POWER_INDEPENDENT : return isValidMinimumMaximumChargingPowerIndependent(property.edt);
		case EPC_MINIMUM_MAXIM_UM_DISCHARGING_POWER_INDEPENDENT : return isValidMinimumMaximUmDischargingPowerIndependent(property.edt);
		case EPC_MINIMUM_MAXIM_UM_CHARGING_CURRENT_INDEPENDENT : return isValidMinimumMaximUmChargingCurrentIndependent(property.edt);
		case EPC_MINIMUM_MAXIM_UM_DISCHARGING_CURRENT_INDEPENDENT : return isValidMinimumMaximUmDischargingCurrentIndependent(property.edt);
		case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING1 : return isValidChargingDischarGingAmountSetting1(property.edt);
		case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING2 : return isValidChargingDischarGingAmountSetting2(property.edt);
		case EPC_REMAINING_STORED_ELECTRICITY1 : return isValidRemainingStoredElectricity1(property.edt);
		case EPC_REMAINING_STORED_ELECTRICITY2 : return isValidRemainingStoredElectricity2(property.edt);
		case EPC_REMAINING_STORED_ELECTRICITY3_BATTERY_STATE_OF_HEALTH : return isValidRemainingStoredElectricity3BatteryStateOfHealth(property.edt);
		case EPC_BATTERY_TYPE : return isValidBatteryType(property.edt);
		case EPC_CHARGING_AMOUNT_SETTING1 : return isValidChargingAmountSetting1(property.edt);
		case EPC_DISCHARGING_AMOUNT_SETTING1 : return isValidDischargingAmountSetting1(property.edt);
		case EPC_CHARGING_AMOUNT_SETTING2 : return isValidChargingAmountSetting2(property.edt);
		case EPC_DISCHARGING_AMOUNT_SETTING2 : return isValidDischargingAmountSetting2(property.edt);
		case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : return isValidChargeElectricEnergySetting(property.edt);
		case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : return isValidDischargeElectricEnergySetting(property.edt);
		case EPC_CHARGE_CURRENT_SETTING : return isValidChargeCurrentSetting(property.edt);
		case EPC_DISCHARGE_CURRENT_SETTING : return isValidDischargeCurrentSetting(property.edt);
		case EPC_RATED_VOLTAGE_INDEPENDENT : return isValidRatedVoltageIndependent(property.edt);
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
			case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING : 
				onSetMeasuredCumulativeDischargeElectricEnergyResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING : 
				onSetMeasuredCumulativeChargeElectricEnergyResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_MODE_SETTING : 
				onSetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING1 : 
				onSetChargingDischarGingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING2 : 
				onSetChargingDischarGingAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_AMOUNT_SETTING1 : 
				onSetChargingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGING_AMOUNT_SETTING1 : 
				onSetDischargingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_AMOUNT_SETTING2 : 
				onSetChargingAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGING_AMOUNT_SETTING2 : 
				onSetDischargingAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : 
				onSetChargeElectricEnergySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : 
				onSetDischargeElectricEnergySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGE_CURRENT_SETTING : 
				onSetChargeCurrentSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGE_CURRENT_SETTING : 
				onSetDischargeCurrentSetting(eoj, tid, esv, property, success);
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
			case EPC_MINIMUM_MAXIM_UM_CHARGE_ELECTRIC_ENERGY : 
				onGetMinimumMaximUmChargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIM_UM_DISCHARGE_ELECTRIC_ENERGY : 
				onGetMinimumMaximUmDischargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIM_UM_CHARGE_CURRENT : 
				onGetMinimumMaximUmChargeCurrent(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIM_UM_DISCHARGE_CURRENT : 
				onGetMinimumMaximUmDischargeCurrent(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_ELECTRIC_ENERGY : 
				onGetRatedElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_CAPACITY : 
				onGetRatedCapacity(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_VOLTAGE : 
				onGetRatedVoltage(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_ELECTRIC_ENERGY : 
				onGetMeasuredInstantaneousChargeDischargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_CURRENT : 
				onGetMeasuredInstantaneousChargeDischargeCurrent(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_VOLTAGE : 
				onGetMeasuredInstantaneousChargeDischargeVoltage(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY : 
				onGetMeasuredCumulativeDischargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY : 
				onGetMeasuredCumulativeChargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_MODE_SETTING : 
				onGetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SYSTEM_INTERCONN_ECTED_TYPE : 
				onGetSystemInterconnEctedType(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIMUM_CHARGING_POWER_INDEPENDENT : 
				onGetMinimumMaximumChargingPowerIndependent(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIM_UM_DISCHARGING_POWER_INDEPENDENT : 
				onGetMinimumMaximUmDischargingPowerIndependent(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIM_UM_CHARGING_CURRENT_INDEPENDENT : 
				onGetMinimumMaximUmChargingCurrentIndependent(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIM_UM_DISCHARGING_CURRENT_INDEPENDENT : 
				onGetMinimumMaximUmDischargingCurrentIndependent(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING1 : 
				onGetChargingDischarGingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING2 : 
				onGetChargingDischarGingAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_STORED_ELECTRICITY1 : 
				onGetRemainingStoredElectricity1(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_STORED_ELECTRICITY2 : 
				onGetRemainingStoredElectricity2(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_STORED_ELECTRICITY3_BATTERY_STATE_OF_HEALTH : 
				onGetRemainingStoredElectricity3BatteryStateOfHealth(eoj, tid, esv, property, success);
				return true;
			case EPC_BATTERY_TYPE : 
				onGetBatteryType(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_AMOUNT_SETTING1 : 
				onGetChargingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGING_AMOUNT_SETTING1 : 
				onGetDischargingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_AMOUNT_SETTING2 : 
				onGetChargingAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGING_AMOUNT_SETTING2 : 
				onGetDischargingAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : 
				onGetChargeElectricEnergySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : 
				onGetDischargeElectricEnergySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGE_CURRENT_SETTING : 
				onGetChargeCurrentSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGE_CURRENT_SETTING : 
				onGetDischargeCurrentSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_VOLTAGE_INDEPENDENT : 
				onGetRatedVoltageIndependent(eoj, tid, esv, property, success);
				return true;
			default :
				return false;
			}
		}
		
		/**
		 * Property name : Minimum/maxim um charge electric energy<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum electric energy for charging in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumMaximUmChargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maxim um discharge electric energy<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum electric energy for discharging in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumMaximUmDischargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maxim um charge current<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum current for charging in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE(0.3,276.6A)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumMaximUmChargeCurrent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maxim um discharge current<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum current for discharging in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE(0.3,276.6A)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumMaximUmDischargeCurrent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated electric energy<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated electric energy of the battery in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
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
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
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
		 * 0x0000.0x7FFE (0.32,766V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
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
		 * Property name : Measured instantaneous charge/discharge electric energy<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001.0x3B9AC9FF (1.<br>
		 * 999,999,999W) : during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1. -999,999,999W) :<br>
		 * during discharging (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousChargeDischargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous charge/discharge current<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (0.1.3,276.6A) :<br>
		 * during charging (positive value), 0xFFFF-0x8001 (-0.1. -3,276.7A) :<br>
		 * during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousChargeDischargeCurrent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous charge/discharge voltage<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (1.32,766V) : during<br>
		 * charging (positive value), 0xFFFF. 0x8001 (-1. -32,767V) : during<br>
		 * discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredInstantaneousChargeDischargeVoltage(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative discharge electric energy<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative discharge electric energy in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredCumulativeDischargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Measured cumulative discharge electric energy” reset setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets “Measured cumulative discharge electric energy” to zero.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
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
		 * Get - undefined<br>
		 */
		protected void onSetMeasuredCumulativeDischargeElectricEnergyResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative charge electric energy<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured cumulative charge electric energy in increments of 0.001kWh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMeasuredCumulativeChargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : “Measured cumulative charge electric energy” reset setting<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets “Measured cumulative charge electric energy” to zero.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
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
		 * Get - undefined<br>
		 */
		protected void onSetMeasuredCumulativeChargeElectricEnergyResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: “Rapid charging,” “Charging,” “Discharging,” “Standby,” “Test” or “Others.”<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging=0x41, Charging=0x42, Discharging=0x43, Standby=0x44, Test=0x45, Others=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: “Rapid charging,” “Charging,” “Discharging,” “Standby,” “Test” or “Others.”<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging=0x41, Charging=0x42, Discharging=0x43, Standby=0x44, Test=0x45, Others=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : System-interconn ected type<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the status of connection with the current system (system interconnection status).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System interconnection (reverse power flow acceptable) = 0x00, Independent type = 0x01, System-interconnected type (reverse power flow not acceptable) =0x02<br>
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
		protected void onGetSystemInterconnEctedType(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maximum charging power (Independent)<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of charging power battery in watts in the dependent status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
		 * Minimum charging power:Maximum charging power<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumMaximumChargingPowerIndependent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : ￼
Minimum/maxim um discharging power (Independent)<br>
		 * <br>
		 * EPC : 0xDD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of discharging power from the battery in the independent status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
		 * Minimum discharging power: Maximum discharging power<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumMaximUmDischargingPowerIndependent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maxim um charging current (Independent)<br>
		 * <br>
		 * EPC : 0xDE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of a charging current to the battery in the independent status in units of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0x7FFE(0–3,276.6A)<br>
		 * Minimum charging current:Maximum charging current<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumMaximUmChargingCurrentIndependent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maxim um discharging current (Independent)<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of a discharging current in the independent status in units of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0x7FFE(0–3,276.6A)<br>
		 * Minimum discharging current: Maximum discharging current<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetMinimumMaximUmDischargingCurrentIndependent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging/dischar ging amount setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001.0x3B9AC9FF (1.<br>
		 * 999,999,999Wh):during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1.<br>
		 * -999,999,999Wh):during discharging (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetChargingDischarGingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging/dischar ging amount setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001.0x3B9AC9FF (1.<br>
		 * 999,999,999Wh):during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1.<br>
		 * -999,999,999Wh):during discharging (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetChargingDischarGingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging/dischar ging amount setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFD (0.1.3,276.6Ah):<br>
		 * during charging (positive value), 0xFFFF.0x8001 (-0.1.<br>
		 * -3,276.7Ah) :during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetChargingDischarGingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging/dischar ging amount setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFD (0.1.3,276.6Ah):<br>
		 * during charging (positive value), 0xFFFF.0x8001 (-0.1.<br>
		 * -3,276.7Ah) :during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetChargingDischarGingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining stored electricity 1<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining stored electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetRemainingStoredElectricity1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining stored electricity 2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetRemainingStoredElectricity2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining stored electricity 3 Battery state of health<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the charging rate of the battery in %.<br>
		 * (0.100%)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * This property indicates the battery state of health in %.<br>
		 * (0.100%)<br>
		 * <br>
		 * Data type : unsigned char unsigned char<br>
		 * <br>
		 * Data size : 1 byte 1 byte<br>
		 * <br>
		 * Unit : % %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetRemainingStoredElectricity3BatteryStateOfHealth(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Battery type<br>
		 * <br>
		 * EPC : 0xE6<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the battery type.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type=0x00.0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		protected void onGetBatteryType(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetChargingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetChargingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDischargingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDischargingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE (0-3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetChargingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE (0-3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetChargingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDischargingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDischargingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetChargeElectricEnergySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetChargeElectricEnergySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDischargeElectricEnergySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDischargeElectricEnergySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetChargeCurrentSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetChargeCurrentSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onSetDischargeCurrentSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		protected void onGetDischargeCurrentSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated voltage (Independent)<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated voltage of a battery in the independent status in volts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0x7FFE (0–32,766V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		protected void onGetRatedVoltageIndependent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
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
		 * Property name : “Measured cumulative discharge electric energy” reset setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets “Measured cumulative discharge electric energy” to zero.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
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
		 * Get - undefined<br>
		 */
		public Setter reqSetMeasuredCumulativeDischargeElectricEnergyResetSetting(byte[] edt) {
			reqSetProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING, edt);
			return this;
		}
		/**
		 * Property name : “Measured cumulative charge electric energy” reset setting<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents of property :<br>
		 * Resets “Measured cumulative charge electric energy” to zero.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset=0x00<br>
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
		 * Get - undefined<br>
		 */
		public Setter reqSetMeasuredCumulativeChargeElectricEnergyResetSetting(byte[] edt) {
			reqSetProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: “Rapid charging,” “Charging,” “Discharging,” “Standby,” “Test” or “Others.”<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging=0x41, Charging=0x42, Discharging=0x43, Standby=0x44, Test=0x45, Others=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOperationModeSetting(byte[] edt) {
			reqSetProperty(EPC_OPERATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Charging/dischar ging amount setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001.0x3B9AC9FF (1.<br>
		 * 999,999,999Wh):during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1.<br>
		 * -999,999,999Wh):during discharging (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetChargingDischarGingAmountSetting1(byte[] edt) {
			reqSetProperty(EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Charging/dischar ging amount setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFD (0.1.3,276.6Ah):<br>
		 * during charging (positive value), 0xFFFF.0x8001 (-0.1.<br>
		 * -3,276.7Ah) :during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetChargingDischarGingAmountSetting2(byte[] edt) {
			reqSetProperty(EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetChargingAmountSetting1(byte[] edt) {
			reqSetProperty(EPC_CHARGING_AMOUNT_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDischargingAmountSetting1(byte[] edt) {
			reqSetProperty(EPC_DISCHARGING_AMOUNT_SETTING1, edt);
			return this;
		}
		/**
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE (0-3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetChargingAmountSetting2(byte[] edt) {
			reqSetProperty(EPC_CHARGING_AMOUNT_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDischargingAmountSetting2(byte[] edt) {
			reqSetProperty(EPC_DISCHARGING_AMOUNT_SETTING2, edt);
			return this;
		}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetChargeElectricEnergySetting(byte[] edt) {
			reqSetProperty(EPC_CHARGE_ELECTRIC_ENERGY_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDischargeElectricEnergySetting(byte[] edt) {
			reqSetProperty(EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetChargeCurrentSetting(byte[] edt) {
			reqSetProperty(EPC_CHARGE_CURRENT_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Setter reqSetDischargeCurrentSetting(byte[] edt) {
			reqSetProperty(EPC_DISCHARGE_CURRENT_SETTING, edt);
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
		 * Property name : Minimum/maxim um charge electric energy<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum electric energy for charging in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumMaximUmChargeElectricEnergy() {
			reqGetProperty(EPC_MINIMUM_MAXIM_UM_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um discharge electric energy<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum electric energy for discharging in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumMaximUmDischargeElectricEnergy() {
			reqGetProperty(EPC_MINIMUM_MAXIM_UM_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um charge current<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum current for charging in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE(0.3,276.6A)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumMaximUmChargeCurrent() {
			reqGetProperty(EPC_MINIMUM_MAXIM_UM_CHARGE_CURRENT);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um discharge current<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum current for discharging in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE(0.3,276.6A)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumMaximUmDischargeCurrent() {
			reqGetProperty(EPC_MINIMUM_MAXIM_UM_DISCHARGE_CURRENT);
			return this;
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
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedElectricEnergy() {
			reqGetProperty(EPC_RATED_ELECTRIC_ENERGY);
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
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedCapacity() {
			reqGetProperty(EPC_RATED_CAPACITY);
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
		 * 0x0000.0x7FFE (0.32,766V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedVoltage() {
			reqGetProperty(EPC_RATED_VOLTAGE);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharge electric energy<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001.0x3B9AC9FF (1.<br>
		 * 999,999,999W) : during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1. -999,999,999W) :<br>
		 * during discharging (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargeElectricEnergy() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharge current<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (0.1.3,276.6A) :<br>
		 * during charging (positive value), 0xFFFF-0x8001 (-0.1. -3,276.7A) :<br>
		 * during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargeCurrent() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_CURRENT);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharge voltage<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (1.32,766V) : during<br>
		 * charging (positive value), 0xFFFF. 0x8001 (-1. -32,767V) : during<br>
		 * discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredInstantaneousChargeDischargeVoltage() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_VOLTAGE);
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
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredCumulativeDischargeElectricEnergy() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY);
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
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMeasuredCumulativeChargeElectricEnergy() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: “Rapid charging,” “Charging,” “Discharging,” “Standby,” “Test” or “Others.”<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging=0x41, Charging=0x42, Discharging=0x43, Standby=0x44, Test=0x45, Others=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOperationModeSetting() {
			reqGetProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : System-interconn ected type<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the status of connection with the current system (system interconnection status).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System interconnection (reverse power flow acceptable) = 0x00, Independent type = 0x01, System-interconnected type (reverse power flow not acceptable) =0x02<br>
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
		public Getter reqGetSystemInterconnEctedType() {
			reqGetProperty(EPC_SYSTEM_INTERCONN_ECTED_TYPE);
			return this;
		}
		/**
		 * Property name : Minimum/maximum charging power (Independent)<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of charging power battery in watts in the dependent status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
		 * Minimum charging power:Maximum charging power<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumMaximumChargingPowerIndependent() {
			reqGetProperty(EPC_MINIMUM_MAXIMUM_CHARGING_POWER_INDEPENDENT);
			return this;
		}
		/**
		 * Property name : ￼
Minimum/maxim um discharging power (Independent)<br>
		 * <br>
		 * EPC : 0xDD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of discharging power from the battery in the independent status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
		 * Minimum discharging power: Maximum discharging power<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumMaximUmDischargingPowerIndependent() {
			reqGetProperty(EPC_MINIMUM_MAXIM_UM_DISCHARGING_POWER_INDEPENDENT);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um charging current (Independent)<br>
		 * <br>
		 * EPC : 0xDE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of a charging current to the battery in the independent status in units of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0x7FFE(0–3,276.6A)<br>
		 * Minimum charging current:Maximum charging current<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumMaximUmChargingCurrentIndependent() {
			reqGetProperty(EPC_MINIMUM_MAXIM_UM_CHARGING_CURRENT_INDEPENDENT);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um discharging current (Independent)<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of a discharging current in the independent status in units of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0x7FFE(0–3,276.6A)<br>
		 * Minimum discharging current: Maximum discharging current<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetMinimumMaximUmDischargingCurrentIndependent() {
			reqGetProperty(EPC_MINIMUM_MAXIM_UM_DISCHARGING_CURRENT_INDEPENDENT);
			return this;
		}
		/**
		 * Property name : Charging/dischar ging amount setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001.0x3B9AC9FF (1.<br>
		 * 999,999,999Wh):during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1.<br>
		 * -999,999,999Wh):during discharging (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetChargingDischarGingAmountSetting1() {
			reqGetProperty(EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING1);
			return this;
		}
		/**
		 * Property name : Charging/dischar ging amount setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFD (0.1.3,276.6Ah):<br>
		 * during charging (positive value), 0xFFFF.0x8001 (-0.1.<br>
		 * -3,276.7Ah) :during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetChargingDischarGingAmountSetting2() {
			reqGetProperty(EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING2);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 1<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining stored electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetRemainingStoredElectricity1() {
			reqGetProperty(EPC_REMAINING_STORED_ELECTRICITY1);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetRemainingStoredElectricity2() {
			reqGetProperty(EPC_REMAINING_STORED_ELECTRICITY2);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 3 Battery state of health<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the charging rate of the battery in %.<br>
		 * (0.100%)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * This property indicates the battery state of health in %.<br>
		 * (0.100%)<br>
		 * <br>
		 * Data type : unsigned char unsigned char<br>
		 * <br>
		 * Data size : 1 byte 1 byte<br>
		 * <br>
		 * Unit : % %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetRemainingStoredElectricity3BatteryStateOfHealth() {
			reqGetProperty(EPC_REMAINING_STORED_ELECTRICITY3_BATTERY_STATE_OF_HEALTH);
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
		 * Type=0x00.0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Getter reqGetBatteryType() {
			reqGetProperty(EPC_BATTERY_TYPE);
			return this;
		}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetChargingAmountSetting1() {
			reqGetProperty(EPC_CHARGING_AMOUNT_SETTING1);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDischargingAmountSetting1() {
			reqGetProperty(EPC_DISCHARGING_AMOUNT_SETTING1);
			return this;
		}
		/**
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE (0-3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetChargingAmountSetting2() {
			reqGetProperty(EPC_CHARGING_AMOUNT_SETTING2);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDischargingAmountSetting2() {
			reqGetProperty(EPC_DISCHARGING_AMOUNT_SETTING2);
			return this;
		}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetChargeElectricEnergySetting() {
			reqGetProperty(EPC_CHARGE_ELECTRIC_ENERGY_SETTING);
			return this;
		}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDischargeElectricEnergySetting() {
			reqGetProperty(EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING);
			return this;
		}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetChargeCurrentSetting() {
			reqGetProperty(EPC_CHARGE_CURRENT_SETTING);
			return this;
		}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Getter reqGetDischargeCurrentSetting() {
			reqGetProperty(EPC_DISCHARGE_CURRENT_SETTING);
			return this;
		}
		/**
		 * Property name : Rated voltage (Independent)<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated voltage of a battery in the independent status in volts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0x7FFE (0–32,766V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Getter reqGetRatedVoltageIndependent() {
			reqGetProperty(EPC_RATED_VOLTAGE_INDEPENDENT);
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
		 * Property name : Minimum/maxim um charge electric energy<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum electric energy for charging in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumMaximUmChargeElectricEnergy() {
			reqInformProperty(EPC_MINIMUM_MAXIM_UM_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um discharge electric energy<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum electric energy for discharging in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumMaximUmDischargeElectricEnergy() {
			reqInformProperty(EPC_MINIMUM_MAXIM_UM_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um charge current<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum current for charging in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE(0.3,276.6A)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumMaximUmChargeCurrent() {
			reqInformProperty(EPC_MINIMUM_MAXIM_UM_CHARGE_CURRENT);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um discharge current<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum/maximum current for discharging in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE(0.3,276.6A)<br>
		 * Minimum : maximum<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumMaximUmDischargeCurrent() {
			reqInformProperty(EPC_MINIMUM_MAXIM_UM_DISCHARGE_CURRENT);
			return this;
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
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedElectricEnergy() {
			reqInformProperty(EPC_RATED_ELECTRIC_ENERGY);
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
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedCapacity() {
			reqInformProperty(EPC_RATED_CAPACITY);
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
		 * 0x0000.0x7FFE (0.32,766V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedVoltage() {
			reqInformProperty(EPC_RATED_VOLTAGE);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharge electric energy<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge electric energy in watts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001.0x3B9AC9FF (1.<br>
		 * 999,999,999W) : during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1. -999,999,999W) :<br>
		 * during discharging (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargeElectricEnergy() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharge current<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge current in increments of 0.1A (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (0.1.3,276.6A) :<br>
		 * during charging (positive value), 0xFFFF-0x8001 (-0.1. -3,276.7A) :<br>
		 * during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargeCurrent() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_CURRENT);
			return this;
		}
		/**
		 * Property name : Measured instantaneous charge/discharge voltage<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the measured instantaneous charge/discharge voltage in volts (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (1.32,766V) : during<br>
		 * charging (positive value), 0xFFFF. 0x8001 (-1. -32,767V) : during<br>
		 * discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredInstantaneousChargeDischargeVoltage() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_VOLTAGE);
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
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredCumulativeDischargeElectricEnergy() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY);
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
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999.999kWh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.001k
Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMeasuredCumulativeChargeElectricEnergy() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents of property :<br>
		 * Sets the battery to one of the following operation modes: “Rapid charging,” “Charging,” “Discharging,” “Standby,” “Test” or “Others.”<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging=0x41, Charging=0x42, Discharging=0x43, Standby=0x44, Test=0x45, Others=0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : —<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - mandatory<br>
		 * Get - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOperationModeSetting() {
			reqInformProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : System-interconn ected type<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the status of connection with the current system (system interconnection status).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System interconnection (reverse power flow acceptable) = 0x00, Independent type = 0x01, System-interconnected type (reverse power flow not acceptable) =0x02<br>
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
		public Informer reqInformSystemInterconnEctedType() {
			reqInformProperty(EPC_SYSTEM_INTERCONN_ECTED_TYPE);
			return this;
		}
		/**
		 * Property name : Minimum/maximum charging power (Independent)<br>
		 * <br>
		 * EPC : 0xDC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of charging power battery in watts in the dependent status.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
		 * Minimum charging power:Maximum charging power<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumMaximumChargingPowerIndependent() {
			reqInformProperty(EPC_MINIMUM_MAXIMUM_CHARGING_POWER_INDEPENDENT);
			return this;
		}
		/**
		 * Property name : ￼
Minimum/maxim um discharging power (Independent)<br>
		 * <br>
		 * EPC : 0xDD<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of discharging power from the battery in the independent status in watts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000–0x3B9AC9FF (0–999,999,999W)<br>
		 * Minimum discharging power: Maximum discharging power<br>
		 * <br>
		 * Data type : unsigned long
×2<br>
		 * <br>
		 * Data size : 8 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumMaximUmDischargingPowerIndependent() {
			reqInformProperty(EPC_MINIMUM_MAXIM_UM_DISCHARGING_POWER_INDEPENDENT);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um charging current (Independent)<br>
		 * <br>
		 * EPC : 0xDE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of a charging current to the battery in the independent status in units of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0x7FFE(0–3,276.6A)<br>
		 * Minimum charging current:Maximum charging current<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumMaximUmChargingCurrentIndependent() {
			reqInformProperty(EPC_MINIMUM_MAXIM_UM_CHARGING_CURRENT_INDEPENDENT);
			return this;
		}
		/**
		 * Property name : Minimum/maxim um discharging current (Independent)<br>
		 * <br>
		 * EPC : 0xDF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the minimum and maximum values of a discharging current in the independent status in units of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0x7FFE(0–3,276.6A)<br>
		 * Minimum discharging current: Maximum discharging current<br>
		 * <br>
		 * Data type : unsigned short
×2<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformMinimumMaximUmDischargingCurrentIndependent() {
			reqInformProperty(EPC_MINIMUM_MAXIM_UM_DISCHARGING_CURRENT_INDEPENDENT);
			return this;
		}
		/**
		 * Property name : Charging/dischar ging amount setting 1<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charge/discharge electric energy in Wh (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001.0x3B9AC9FF (1.<br>
		 * 999,999,999Wh):during charging (positive value), 0xFFFFFFFF. 0xC4653601 (-1.<br>
		 * -999,999,999Wh):during discharging (negative value)<br>
		 * <br>
		 * Data type : signed long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformChargingDischarGingAmountSetting1() {
			reqInformProperty(EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING1);
			return this;
		}
		/**
		 * Property name : Charging/dischar ging amount setting 2<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents of property :<br>
		 * Specifies the charging/discharging capacity in increments of 0.1Ah (positive/negative).<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFD (0.1.3,276.6Ah):<br>
		 * during charging (positive value), 0xFFFF.0x8001 (-0.1.<br>
		 * -3,276.7Ah) :during discharging (negative value)<br>
		 * <br>
		 * Data type : signed short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformChargingDischarGingAmountSetting2() {
			reqInformProperty(EPC_CHARGING_DISCHAR_GING_AMOUNT_SETTING2);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 1<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining stored electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformRemainingStoredElectricity1() {
			reqInformProperty(EPC_REMAINING_STORED_ELECTRICITY1);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the remaining capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformRemainingStoredElectricity2() {
			reqInformProperty(EPC_REMAINING_STORED_ELECTRICITY2);
			return this;
		}
		/**
		 * Property name : Remaining stored electricity 3 Battery state of health<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the charging rate of the battery in %.<br>
		 * (0.100%)<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * This property indicates the battery state of health in %.<br>
		 * (0.100%)<br>
		 * <br>
		 * Data type : unsigned char unsigned char<br>
		 * <br>
		 * Data size : 1 byte 1 byte<br>
		 * <br>
		 * Unit : % %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformRemainingStoredElectricity3BatteryStateOfHealth() {
			reqInformProperty(EPC_REMAINING_STORED_ELECTRICITY3_BATTERY_STATE_OF_HEALTH);
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
		 * Type=0x00.0xFF<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * <br>
		 * Data size : 1 byte<br>
		 * <br>
		 * Unit : null<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - mandatory<br>
		 */
		public Informer reqInformBatteryType() {
			reqInformProperty(EPC_BATTERY_TYPE);
			return this;
		}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformChargingAmountSetting1() {
			reqInformProperty(EPC_CHARGING_AMOUNT_SETTING1);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in Wh.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDischargingAmountSetting1() {
			reqInformProperty(EPC_DISCHARGING_AMOUNT_SETTING1);
			return this;
		}
		/**
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000-0x7FFE (0-3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformChargingAmountSetting2() {
			reqInformProperty(EPC_CHARGING_AMOUNT_SETTING2);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDischargingAmountSetting2() {
			reqInformProperty(EPC_DISCHARGING_AMOUNT_SETTING2);
			return this;
		}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformChargeElectricEnergySetting() {
			reqInformProperty(EPC_CHARGE_ELECTRIC_ENERGY_SETTING);
			return this;
		}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge electric energy in W.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.<br>
		 * 999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * <br>
		 * Data size : 4 bytes<br>
		 * <br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDischargeElectricEnergySetting() {
			reqInformProperty(EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING);
			return this;
		}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the charge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformChargeCurrentSetting() {
			reqInformProperty(EPC_CHARGE_CURRENT_SETTING);
			return this;
		}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents of property :<br>
		 * This property specifies the discharge current in increments of 0.1A.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - optional<br>
		 * Get - optional<br>
		 */
		public Informer reqInformDischargeCurrentSetting() {
			reqInformProperty(EPC_DISCHARGE_CURRENT_SETTING);
			return this;
		}
		/**
		 * Property name : Rated voltage (Independent)<br>
		 * <br>
		 * EPC : 0xEF<br>
		 * <br>
		 * Contents of property :<br>
		 * This property indicates the rated voltage of a battery in the independent status in volts.<br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000–0x7FFE (0–32,766V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * <br>
		 * Data size : 2 bytes<br>
		 * <br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - undefined<br>
		 * Set - undefined<br>
		 * Get - optional<br>
		 */
		public Informer reqInformRatedVoltageIndependent() {
			reqInformProperty(EPC_RATED_VOLTAGE_INDEPENDENT);
			return this;
		}
	}

	public static class Proxy extends Battery {
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
		protected boolean setOperationModeSetting(byte[] edt) {return false;}
		@Override
		protected byte[] getOperationModeSetting() {return null;}
		@Override
		protected byte[] getRemainingStoredElectricity1() {return null;}
		@Override
		protected byte[] getRemainingStoredElectricity2() {return null;}
		@Override
		protected byte[] getRemainingStoredElectricity3BatteryStateOfHealth() {return null;}
		@Override
		protected byte[] getBatteryType() {return null;}
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
