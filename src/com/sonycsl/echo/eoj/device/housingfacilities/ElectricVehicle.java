/*
 * The MIT License (MIT)
 * 
 * Copyright (c) 2014 Sony Computer Science Laboratories, Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sonycsl.echo.eoj.device.housingfacilities;

import com.sonycsl.echo.Echo;
import com.sonycsl.echo.EchoProperty;
import com.sonycsl.echo.EchoSocket;
import com.sonycsl.echo.eoj.EchoObject;
import com.sonycsl.echo.eoj.device.DeviceObject;

public abstract class ElectricVehicle extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x027E;

	public static final byte EPC_RATED_CHARGE_CAPACITY = (byte)0xC5;
	public static final byte EPC_V2H_REMAINING_AVAILABLE_CAPACITY_3 = (byte)0xC4;
	public static final byte EPC_CHARGEABLE_DISCHARGE_ABLE_STATUS = (byte)0xC7;
	public static final byte EPC_RATED_DISCHARGE_CAPACITY = (byte)0xC6;
	public static final byte EPC_V2H_STORED_ELECTRICITY_2 = (byte)0xC1;
	public static final byte EPC_V2H_STORED_ELECTRICITY_1 = (byte)0xC0;
	public static final byte EPC_V2H_REMAINING_AVAILABLE_CAPACITY_2 = (byte)0xC3;
	public static final byte EPC_V2H_REMAINING_AVAILABLE_CAPACITY_1 = (byte)0xC2;
	public static final byte EPC_CHARGING_AMOUNT_SETTING_2 = (byte)0xE9;
	public static final byte EPC_DISCHARGING_AMOUNT_SETTING_1 = (byte)0xE8;
	public static final byte EPC_MINIMUM_MAXIMUM_DISCHARGE_ELECTRIC_ENERGY = (byte)0xC9;
	public static final byte EPC_MINIMUM_MAXIMUM_CHARGE_ELECTRIC_ENERGY = (byte)0xC8;
	public static final byte EPC_REMAINING_BATTERY_CAPACITY1 = (byte)0xE2;
	public static final byte EPC_CHARGING_AMOUNT_SETTING_1 = (byte)0xE7;
	public static final byte EPC_DETERIORATION_STATUS = (byte)0xE5;
	public static final byte EPC_REMAINING_BATTERY_CAPACITY2 = (byte)0xE3;
	public static final byte EPC_REMAINING_BATTERY_CAPACITY3 = (byte)0xE4;
	public static final byte EPC_OPERATION_MODE_SETTING = (byte)0xDA;
	public static final byte EPC_SYSTEM_INTERCONNECTE_D_TYPE = (byte)0xDB;
	public static final byte EPC_USED_CAPACITY_1 = (byte)0xD0;
	public static final byte EPC_USED_CAPACITY_2 = (byte)0xD1;
	public static final byte EPC_RATED_VOLTAGE = (byte)0xD2;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_ELECTRIC_ENERGY = (byte)0xD3;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_CURRENT = (byte)0xD4;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_VOLTAGE = (byte)0xD5;
	public static final byte EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY = (byte)0xD6;
	public static final byte EPC_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING = (byte)0xD7;
	public static final byte EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY = (byte)0xD8;
	public static final byte EPC_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING = (byte)0xD9;
	public static final byte EPC_CHARGE_CURRENT_SETTING = (byte)0xED;
	public static final byte EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING = (byte)0xEC;
	public static final byte EPC_CHARGE_ELECTRIC_ENERGY_SETTING = (byte)0xEB;
	public static final byte EPC_DISCHARGING_AMOUNT_SETTING_2 = (byte)0xEA;
	public static final byte EPC_MINIMUM_MAXIMUM_CHARGE_CURRENT = (byte)0xCA;
	public static final byte EPC_DISCHARGE_CURRENT_SETTING = (byte)0xEE;
	public static final byte EPC_MINIMUM_MAXIMUM_DISCHARGE_CURRENT = (byte)0xCB;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addGetProperty(EPC_RATED_CHARGE_CAPACITY);
		addGetProperty(EPC_V2H_REMAINING_AVAILABLE_CAPACITY_3);
		addStatusChangeAnnouncementProperty(EPC_CHARGEABLE_DISCHARGE_ABLE_STATUS);
		addGetProperty(EPC_CHARGEABLE_DISCHARGE_ABLE_STATUS);
		addGetProperty(EPC_RATED_DISCHARGE_CAPACITY);
		addGetProperty(EPC_V2H_STORED_ELECTRICITY_2);
		addGetProperty(EPC_V2H_STORED_ELECTRICITY_1);
		addGetProperty(EPC_V2H_REMAINING_AVAILABLE_CAPACITY_2);
		addGetProperty(EPC_V2H_REMAINING_AVAILABLE_CAPACITY_1);
		addGetProperty(EPC_REMAINING_BATTERY_CAPACITY1);
		addGetProperty(EPC_REMAINING_BATTERY_CAPACITY2);
		addGetProperty(EPC_REMAINING_BATTERY_CAPACITY3);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_MODE_SETTING);
		addSetProperty(EPC_OPERATION_MODE_SETTING);
		addGetProperty(EPC_OPERATION_MODE_SETTING);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_USED_CAPACITY_1);
		addGetProperty(EPC_USED_CAPACITY_2);

	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewElectricVehicle(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Rated charge capacity<br>
	 * <br>
	 * EPC : 0xC5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the rated charge capacity in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getRatedChargeCapacity();
	/**
	 * Property name : Rated charge capacity<br>
	 * <br>
	 * EPC : 0xC5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the rated charge capacity in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRatedChargeCapacity(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : V2H remaining available capacity 3<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H remaining available capacity (%) of the vehicle battery. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getV2HRemainingAvailableCapacity3();
	/**
	 * Property name : V2H remaining available capacity 3<br>
	 * <br>
	 * EPC : 0xC4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H remaining available capacity (%) of the vehicle battery. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidV2HRemainingAvailableCapacity3(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Chargeable/discharge able status<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates whether the electric vehicle charge/discharge system is chargeable or not. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Not chargeable nor dischargeable   = 0x40 Chargeable but not dischargeable = 0x41 Not chargeable but dischargeable = 0x42 Chargeable and dischargeable = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getChargeableDischargeAbleStatus();
	/**
	 * Property name : Chargeable/discharge able status<br>
	 * <br>
	 * EPC : 0xC7<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates whether the electric vehicle charge/discharge system is chargeable or not. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Not chargeable nor dischargeable   = 0x40 Chargeable but not dischargeable = 0x41 Not chargeable but dischargeable = 0x42 Chargeable and dischargeable = 0x43<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidChargeableDischargeAbleStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Rated discharge capacity<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the rated discharge capacity in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getRatedDischargeCapacity();
	/**
	 * Property name : Rated discharge capacity<br>
	 * <br>
	 * EPC : 0xC6<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the rated discharge capacity in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRatedDischargeCapacity(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : V2H stored electricity 2<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H stored electricity of the vehicle battery in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getV2HStoredElectricity2();
	/**
	 * Property name : V2H stored electricity 2<br>
	 * <br>
	 * EPC : 0xC1<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H stored electricity of the vehicle battery in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidV2HStoredElectricity2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : V2H stored electricity 1<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H stored electricity of the vehicle battery in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getV2HStoredElectricity1();
	/**
	 * Property name : V2H stored electricity 1<br>
	 * <br>
	 * EPC : 0xC0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H stored electricity of the vehicle battery in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidV2HStoredElectricity1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : V2H remaining available capacity 2<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H remaining available capacity of the vehicle battery in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getV2HRemainingAvailableCapacity2();
	/**
	 * Property name : V2H remaining available capacity 2<br>
	 * <br>
	 * EPC : 0xC3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H remaining available capacity of the vehicle battery in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidV2HRemainingAvailableCapacity2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : V2H remaining available capacity 1<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H remaining available capacity of the vehicle battery in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getV2HRemainingAvailableCapacity1();
	/**
	 * Property name : V2H remaining available capacity 1<br>
	 * <br>
	 * EPC : 0xC2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the V2H remaining available capacity of the vehicle battery in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidV2HRemainingAvailableCapacity1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Charging amount setting 2<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charging capacity in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setChargingAmountSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Charging amount setting 2<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charging capacity in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getChargingAmountSetting2() {return null;}
	/**
	 * Property name : Charging amount setting 2<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charging capacity in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidChargingAmountSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Discharging amount setting 1<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharge electric energy in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setDischargingAmountSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Discharging amount setting 1<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharge electric energy in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getDischargingAmountSetting1() {return null;}
	/**
	 * Property name : Discharging amount setting 1<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharge electric energy in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDischargingAmountSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Minimum/maximum discharge electric energy<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the minimum/maximum discharge electric energy from the electric vehicle charge/discharge system in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum discharge electric energy: Maximum discharge electric energy<br>
	 * <br>
	 * Data type : unsigned long_x000a_×2<br>
	 * Data size : 8<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMinimumMaximumDischargeElectricEnergy() {return null;}
	/**
	 * Property name : Minimum/maximum discharge electric energy<br>
	 * <br>
	 * EPC : 0xC9<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the minimum/maximum discharge electric energy from the electric vehicle charge/discharge system in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum discharge electric energy: Maximum discharge electric energy<br>
	 * <br>
	 * Data type : unsigned long_x000a_×2<br>
	 * Data size : 8<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMinimumMaximumDischargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 8)) {return false;};
		return true;
	}
	/**
	 * Property name : Minimum/maximum charge electric energy<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the minimum/maximum charge electric energy to the charge-discharge system of the electric vehicle in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum charge electric energy: Maximum charge electric energy<br>
	 * <br>
	 * Data type : unsigned long_x000a_×2<br>
	 * Data size : 8<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMinimumMaximumChargeElectricEnergy() {return null;}
	/**
	 * Property name : Minimum/maximum charge electric energy<br>
	 * <br>
	 * EPC : 0xC8<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the minimum/maximum charge electric energy to the charge-discharge system of the electric vehicle in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum charge electric energy: Maximum charge electric energy<br>
	 * <br>
	 * Data type : unsigned long_x000a_×2<br>
	 * Data size : 8<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMinimumMaximumChargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 8)) {return false;};
		return true;
	}
	/**
	 * Property name : Remaining battery capacity1<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the remaining capacity of the vehicle battery in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getRemainingBatteryCapacity1();
	/**
	 * Property name : Remaining battery capacity1<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the remaining capacity of the vehicle battery in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRemainingBatteryCapacity1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Charging amount setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charge electric energy in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setChargingAmountSetting1(byte[] edt) {return false;}
	/**
	 * Property name : Charging amount setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charge electric energy in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getChargingAmountSetting1() {return null;}
	/**
	 * Property name : Charging amount setting 1<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charge electric energy in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidChargingAmountSetting1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Deterioration status<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the deterioration status (soundness) of the vehicle battery in %. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getDeteriorationStatus() {return null;}
	/**
	 * Property name : Deterioration status<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the deterioration status (soundness) of the vehicle battery in %. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDeteriorationStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Remaining battery capacity2<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the remaining capacity of the vehicle battery in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getRemainingBatteryCapacity2();
	/**
	 * Property name : Remaining battery capacity2<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the remaining capacity of the vehicle battery in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRemainingBatteryCapacity2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Remaining battery capacity3<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the remaining battery capacity of the vehicle battery in %. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getRemainingBatteryCapacity3();
	/**
	 * Property name : Remaining battery capacity3<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the remaining battery capacity of the vehicle battery in %. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x64 (0.100%)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : %<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRemainingBatteryCapacity3(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents :<br>
	 * This property sets the operation mode to Rapid charging, Charging, Discharging, Standby, Test, or Other. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rapid charging = 0x41, Charging = 0x42, Discharging = 0x43, Standby = 0x44, Test=0x45, Other = 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract boolean setOperationModeSetting(byte[] edt);
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents :<br>
	 * This property sets the operation mode to Rapid charging, Charging, Discharging, Standby, Test, or Other. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rapid charging = 0x41, Charging = 0x42, Discharging = 0x43, Standby = 0x44, Test=0x45, Other = 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationModeSetting();
	/**
	 * Property name : Operation mode setting<br>
	 * <br>
	 * EPC : 0xDA<br>
	 * <br>
	 * Contents :<br>
	 * This property sets the operation mode to Rapid charging, Charging, Discharging, Standby, Test, or Other. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Rapid charging = 0x41, Charging = 0x42, Discharging = 0x43, Standby = 0x44, Test=0x45, Other = 0x40<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - mandatory<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationModeSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : System-interconnecte d type<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the system interconnection status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * System interconnection(reverse power flow acceptable) = 0x00_x000a_Independent type = 0x01_x000a_System interconnection(reverse power flow not acceptable) = 0x02<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getSystemInterconnecteDType() {return null;}
	/**
	 * Property name : System-interconnecte d type<br>
	 * <br>
	 * EPC : 0xDB<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the system interconnection status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * System interconnection(reverse power flow acceptable) = 0x00_x000a_Independent type = 0x01_x000a_System interconnection(reverse power flow not acceptable) = 0x02<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidSystemInterconnecteDType(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x30, OFF = 0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOperationStatus(byte[] edt) {return false;}
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x30, OFF = 0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getOperationStatus();
	/**
	 * Property name : Operation status<br>
	 * <br>
	 * EPC : 0x80<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the ON/OFF status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * ON = 0x30, OFF = 0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOperationStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Used capacity 1<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the capacity of the vehicle battery in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getUsedCapacity1();
	/**
	 * Property name : Used capacity 1<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the capacity of the vehicle battery in Wh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : Wh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidUsedCapacity1(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Used capacity 2<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the capacity of the vehicle battery in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getUsedCapacity2();
	/**
	 * Property name : Used capacity 2<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the capacity of the vehicle battery in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidUsedCapacity2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Rated voltage<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the rated voltage of the vehicle battery in V. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.32,766V)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getRatedVoltage() {return null;}
	/**
	 * Property name : Rated voltage<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the rated voltage of the vehicle battery in V. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.32,766V)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidRatedVoltage(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured instantaneous charge/discharge electric energy<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the instantaneous charge/discharge electric energy in ±W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001. 0x3B9AC9FF (1._x000a_999,999,999W): charge (positive), 0xFFFFFFFF.0xC4653601 (-1._x000a_-999,999,999W): discharge (negative)<br>
	 * <br>
	 * Data type : signed long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargeElectricEnergy() {return null;}
	/**
	 * Property name : Measured instantaneous charge/discharge electric energy<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the instantaneous charge/discharge electric energy in ±W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000001. 0x3B9AC9FF (1._x000a_999,999,999W): charge (positive), 0xFFFFFFFF.0xC4653601 (-1._x000a_-999,999,999W): discharge (negative)<br>
	 * <br>
	 * Data type : signed long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredInstantaneousChargeDischargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured instantaneous charge/discharge current<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the instantaneous charge/discharge current in increments of_x000a_±0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFE (0.1.3,276.6A): charge_x000a_(positive), 0xFFFF .0x8001 (-0.1.-_x000a_-3,276.7A): discharge (negative)<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargeCurrent() {return null;}
	/**
	 * Property name : Measured instantaneous charge/discharge current<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the instantaneous charge/discharge current in increments of_x000a_±0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFE (0.1.3,276.6A): charge_x000a_(positive), 0xFFFF .0x8001 (-0.1.-_x000a_-3,276.7A): discharge (negative)<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredInstantaneousChargeDischargeCurrent(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured instantaneous charge/discharge voltage<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the instantaneous charge/discharge voltage in ±V. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFE (1.32,766V): charge (positive), 0xFFFF.0x8001 (-1.- -32,767V):_x000a_discharge (negative)<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredInstantaneousChargeDischargeVoltage() {return null;}
	/**
	 * Property name : Measured instantaneous charge/discharge voltage<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the instantaneous charge/discharge voltage in ±V. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0001.0x7FFE (1.32,766V): charge (positive), 0xFFFF.0x8001 (-1.- -32,767V):_x000a_discharge (negative)<br>
	 * <br>
	 * Data type : signed short<br>
	 * Data size : 2<br>
	 * Unit : V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredInstantaneousChargeDischargeVoltage(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured cumulative discharge electric energy<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the cumulative discharge electric energy in increments of 0.001kWh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999.999kWh<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : 0.001_x000a_kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredCumulativeDischargeElectricEnergy() {return null;}
	/**
	 * Property name : Measured cumulative discharge electric energy<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the cumulative discharge electric energy in increments of 0.001kWh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0._x000a_999,999.999kWh<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : 0.001_x000a_kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredCumulativeDischargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Cumulative discharge electric energy reset setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents :<br>
	 * This property resets the cumulative discharge electric energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setCumulativeDischargeElectricEnergyResetSetting(byte[] edt) {return false;}
	/**
	 * Property name : Cumulative discharge electric energy reset setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents :<br>
	 * This property resets the cumulative discharge electric energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getCumulativeDischargeElectricEnergyResetSetting() {return null;}
	/**
	 * Property name : Cumulative discharge electric energy reset setting<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents :<br>
	 * This property resets the cumulative discharge electric energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidCumulativeDischargeElectricEnergyResetSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured cumulative charge electric energy<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the cumulative charge electric energy in increments of 0.001kWh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000 . 0x3B9AC9FF (0._x000a_999,999.999kWh<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : 0.001_x000a_kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredCumulativeChargeElectricEnergy() {return null;}
	/**
	 * Property name : Measured cumulative charge electric energy<br>
	 * <br>
	 * EPC : 0xD8<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the cumulative charge electric energy in increments of 0.001kWh. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000 . 0x3B9AC9FF (0._x000a_999,999.999kWh<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : 0.001_x000a_kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredCumulativeChargeElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Cumulative charge electric energy reset setting<br>
	 * <br>
	 * EPC : 0xD9<br>
	 * <br>
	 * Contents :<br>
	 * This property resets the cumulative charge electricity energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setCumulativeChargeElectricEnergyResetSetting(byte[] edt) {return false;}
	/**
	 * Property name : Cumulative charge electric energy reset setting<br>
	 * <br>
	 * EPC : 0xD9<br>
	 * <br>
	 * Contents :<br>
	 * This property resets the cumulative charge electricity energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getCumulativeChargeElectricEnergyResetSetting() {return null;}
	/**
	 * Property name : Cumulative charge electric energy reset setting<br>
	 * <br>
	 * EPC : 0xD9<br>
	 * <br>
	 * Contents :<br>
	 * This property resets the cumulative charge electricity energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Reset = 0x00<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : -<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidCumulativeChargeElectricEnergyResetSetting(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Charge current setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charge current in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setChargeCurrentSetting(byte[] edt) {return false;}
	/**
	 * Property name : Charge current setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charge current in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getChargeCurrentSetting() {return null;}
	/**
	 * Property name : Charge current setting<br>
	 * <br>
	 * EPC : 0xED<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charge current in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidChargeCurrentSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Discharge electric energy setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharge electric energy in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setDischargeElectricEnergySetting(byte[] edt) {return false;}
	/**
	 * Property name : Discharge electric energy setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharge electric energy in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getDischargeElectricEnergySetting() {return null;}
	/**
	 * Property name : Discharge electric energy setting<br>
	 * <br>
	 * EPC : 0xEC<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharge electric energy in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDischargeElectricEnergySetting(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Charge electric energy setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charge electric energy in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setChargeElectricEnergySetting(byte[] edt) {return false;}
	/**
	 * Property name : Charge electric energy setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charge electric energy in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getChargeElectricEnergySetting() {return null;}
	/**
	 * Property name : Charge electric energy setting<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the charge electric energy in W. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : W<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidChargeElectricEnergySetting(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Discharging amount setting 2<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharging capacity in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setDischargingAmountSetting2(byte[] edt) {return false;}
	/**
	 * Property name : Discharging amount setting 2<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharging capacity in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getDischargingAmountSetting2() {return null;}
	/**
	 * Property name : Discharging amount setting 2<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharging capacity in increments of 0.1Ah. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1Ah<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDischargingAmountSetting2(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Minimum/maximum charge current<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the minimum/maximum charge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum charge current: Maximum charge current<br>
	 * <br>
	 * Data type : unsigned short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMinimumMaximumChargeCurrent() {return null;}
	/**
	 * Property name : Minimum/maximum charge current<br>
	 * <br>
	 * EPC : 0xCA<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the minimum/maximum charge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum charge current: Maximum charge current<br>
	 * <br>
	 * Data type : unsigned short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMinimumMaximumChargeCurrent(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Discharge current setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharge current in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD(0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setDischargeCurrentSetting(byte[] edt) {return false;}
	/**
	 * Property name : Discharge current setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharge current in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD(0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getDischargeCurrentSetting() {return null;}
	/**
	 * Property name : Discharge current setting<br>
	 * <br>
	 * EPC : 0xEE<br>
	 * <br>
	 * Contents :<br>
	 * This property specifies the discharge current in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD(0.6,553.3A)<br>
	 * <br>
	 * Data type : unsigned short<br>
	 * Data size : 2<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDischargeCurrentSetting(byte[] edt) {
		if(edt == null || !(edt.length == 2)) {return false;};
		return true;
	}
	/**
	 * Property name : Minimum/maximum discharge current<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the  minimum/maximum discharge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum discharge current: Maximum discharge current<br>
	 * <br>
	 * Data type : unsigned short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMinimumMaximumDischargeCurrent() {return null;}
	/**
	 * Property name : Minimum/maximum discharge current<br>
	 * <br>
	 * EPC : 0xCB<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the  minimum/maximum discharge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum discharge current: Maximum discharge current<br>
	 * <br>
	 * Data type : unsigned short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 0.1A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMinimumMaximumDischargeCurrent(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_CHARGING_AMOUNT_SETTING_2 : return setChargingAmountSetting2(property.edt);
		case EPC_DISCHARGING_AMOUNT_SETTING_1 : return setDischargingAmountSetting1(property.edt);
		case EPC_CHARGING_AMOUNT_SETTING_1 : return setChargingAmountSetting1(property.edt);
		case EPC_OPERATION_MODE_SETTING : return setOperationModeSetting(property.edt);
		case EPC_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING : return setCumulativeDischargeElectricEnergyResetSetting(property.edt);
		case EPC_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING : return setCumulativeChargeElectricEnergyResetSetting(property.edt);
		case EPC_CHARGE_CURRENT_SETTING : return setChargeCurrentSetting(property.edt);
		case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : return setDischargeElectricEnergySetting(property.edt);
		case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : return setChargeElectricEnergySetting(property.edt);
		case EPC_DISCHARGING_AMOUNT_SETTING_2 : return setDischargingAmountSetting2(property.edt);
		case EPC_DISCHARGE_CURRENT_SETTING : return setDischargeCurrentSetting(property.edt);

		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_RATED_CHARGE_CAPACITY : return getRatedChargeCapacity();
		case EPC_V2H_REMAINING_AVAILABLE_CAPACITY_3 : return getV2HRemainingAvailableCapacity3();
		case EPC_CHARGEABLE_DISCHARGE_ABLE_STATUS : return getChargeableDischargeAbleStatus();
		case EPC_RATED_DISCHARGE_CAPACITY : return getRatedDischargeCapacity();
		case EPC_V2H_STORED_ELECTRICITY_2 : return getV2HStoredElectricity2();
		case EPC_V2H_STORED_ELECTRICITY_1 : return getV2HStoredElectricity1();
		case EPC_V2H_REMAINING_AVAILABLE_CAPACITY_2 : return getV2HRemainingAvailableCapacity2();
		case EPC_V2H_REMAINING_AVAILABLE_CAPACITY_1 : return getV2HRemainingAvailableCapacity1();
		case EPC_CHARGING_AMOUNT_SETTING_2 : return getChargingAmountSetting2();
		case EPC_DISCHARGING_AMOUNT_SETTING_1 : return getDischargingAmountSetting1();
		case EPC_MINIMUM_MAXIMUM_DISCHARGE_ELECTRIC_ENERGY : return getMinimumMaximumDischargeElectricEnergy();
		case EPC_MINIMUM_MAXIMUM_CHARGE_ELECTRIC_ENERGY : return getMinimumMaximumChargeElectricEnergy();
		case EPC_REMAINING_BATTERY_CAPACITY1 : return getRemainingBatteryCapacity1();
		case EPC_CHARGING_AMOUNT_SETTING_1 : return getChargingAmountSetting1();
		case EPC_DETERIORATION_STATUS : return getDeteriorationStatus();
		case EPC_REMAINING_BATTERY_CAPACITY2 : return getRemainingBatteryCapacity2();
		case EPC_REMAINING_BATTERY_CAPACITY3 : return getRemainingBatteryCapacity3();
		case EPC_OPERATION_MODE_SETTING : return getOperationModeSetting();
		case EPC_SYSTEM_INTERCONNECTE_D_TYPE : return getSystemInterconnecteDType();
		case EPC_USED_CAPACITY_1 : return getUsedCapacity1();
		case EPC_USED_CAPACITY_2 : return getUsedCapacity2();
		case EPC_RATED_VOLTAGE : return getRatedVoltage();
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_ELECTRIC_ENERGY : return getMeasuredInstantaneousChargeDischargeElectricEnergy();
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_CURRENT : return getMeasuredInstantaneousChargeDischargeCurrent();
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_VOLTAGE : return getMeasuredInstantaneousChargeDischargeVoltage();
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY : return getMeasuredCumulativeDischargeElectricEnergy();
		case EPC_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING : return getCumulativeDischargeElectricEnergyResetSetting();
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY : return getMeasuredCumulativeChargeElectricEnergy();
		case EPC_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING : return getCumulativeChargeElectricEnergyResetSetting();
		case EPC_CHARGE_CURRENT_SETTING : return getChargeCurrentSetting();
		case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : return getDischargeElectricEnergySetting();
		case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : return getChargeElectricEnergySetting();
		case EPC_DISCHARGING_AMOUNT_SETTING_2 : return getDischargingAmountSetting2();
		case EPC_MINIMUM_MAXIMUM_CHARGE_CURRENT : return getMinimumMaximumChargeCurrent();
		case EPC_DISCHARGE_CURRENT_SETTING : return getDischargeCurrentSetting();
		case EPC_MINIMUM_MAXIMUM_DISCHARGE_CURRENT : return getMinimumMaximumDischargeCurrent();

		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_RATED_CHARGE_CAPACITY : return isValidRatedChargeCapacity(property.edt);
		case EPC_V2H_REMAINING_AVAILABLE_CAPACITY_3 : return isValidV2HRemainingAvailableCapacity3(property.edt);
		case EPC_CHARGEABLE_DISCHARGE_ABLE_STATUS : return isValidChargeableDischargeAbleStatus(property.edt);
		case EPC_RATED_DISCHARGE_CAPACITY : return isValidRatedDischargeCapacity(property.edt);
		case EPC_V2H_STORED_ELECTRICITY_2 : return isValidV2HStoredElectricity2(property.edt);
		case EPC_V2H_STORED_ELECTRICITY_1 : return isValidV2HStoredElectricity1(property.edt);
		case EPC_V2H_REMAINING_AVAILABLE_CAPACITY_2 : return isValidV2HRemainingAvailableCapacity2(property.edt);
		case EPC_V2H_REMAINING_AVAILABLE_CAPACITY_1 : return isValidV2HRemainingAvailableCapacity1(property.edt);
		case EPC_CHARGING_AMOUNT_SETTING_2 : return isValidChargingAmountSetting2(property.edt);
		case EPC_DISCHARGING_AMOUNT_SETTING_1 : return isValidDischargingAmountSetting1(property.edt);
		case EPC_MINIMUM_MAXIMUM_DISCHARGE_ELECTRIC_ENERGY : return isValidMinimumMaximumDischargeElectricEnergy(property.edt);
		case EPC_MINIMUM_MAXIMUM_CHARGE_ELECTRIC_ENERGY : return isValidMinimumMaximumChargeElectricEnergy(property.edt);
		case EPC_REMAINING_BATTERY_CAPACITY1 : return isValidRemainingBatteryCapacity1(property.edt);
		case EPC_CHARGING_AMOUNT_SETTING_1 : return isValidChargingAmountSetting1(property.edt);
		case EPC_DETERIORATION_STATUS : return isValidDeteriorationStatus(property.edt);
		case EPC_REMAINING_BATTERY_CAPACITY2 : return isValidRemainingBatteryCapacity2(property.edt);
		case EPC_REMAINING_BATTERY_CAPACITY3 : return isValidRemainingBatteryCapacity3(property.edt);
		case EPC_OPERATION_MODE_SETTING : return isValidOperationModeSetting(property.edt);
		case EPC_SYSTEM_INTERCONNECTE_D_TYPE : return isValidSystemInterconnecteDType(property.edt);
		case EPC_USED_CAPACITY_1 : return isValidUsedCapacity1(property.edt);
		case EPC_USED_CAPACITY_2 : return isValidUsedCapacity2(property.edt);
		case EPC_RATED_VOLTAGE : return isValidRatedVoltage(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_ELECTRIC_ENERGY : return isValidMeasuredInstantaneousChargeDischargeElectricEnergy(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_CURRENT : return isValidMeasuredInstantaneousChargeDischargeCurrent(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CHARGE_DISCHARGE_VOLTAGE : return isValidMeasuredInstantaneousChargeDischargeVoltage(property.edt);
		case EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY : return isValidMeasuredCumulativeDischargeElectricEnergy(property.edt);
		case EPC_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING : return isValidCumulativeDischargeElectricEnergyResetSetting(property.edt);
		case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY : return isValidMeasuredCumulativeChargeElectricEnergy(property.edt);
		case EPC_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING : return isValidCumulativeChargeElectricEnergyResetSetting(property.edt);
		case EPC_CHARGE_CURRENT_SETTING : return isValidChargeCurrentSetting(property.edt);
		case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : return isValidDischargeElectricEnergySetting(property.edt);
		case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : return isValidChargeElectricEnergySetting(property.edt);
		case EPC_DISCHARGING_AMOUNT_SETTING_2 : return isValidDischargingAmountSetting2(property.edt);
		case EPC_MINIMUM_MAXIMUM_CHARGE_CURRENT : return isValidMinimumMaximumChargeCurrent(property.edt);
		case EPC_DISCHARGE_CURRENT_SETTING : return isValidDischargeCurrentSetting(property.edt);
		case EPC_MINIMUM_MAXIMUM_DISCHARGE_CURRENT : return isValidMinimumMaximumDischargeCurrent(property.edt);

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
			case EPC_CHARGING_AMOUNT_SETTING_2 : 
				onSetChargingAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGING_AMOUNT_SETTING_1 : 
				onSetDischargingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_AMOUNT_SETTING_1 : 
				onSetChargingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_MODE_SETTING : 
				onSetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING : 
				onSetCumulativeDischargeElectricEnergyResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING : 
				onSetCumulativeChargeElectricEnergyResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGE_CURRENT_SETTING : 
				onSetChargeCurrentSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : 
				onSetDischargeElectricEnergySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : 
				onSetChargeElectricEnergySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGING_AMOUNT_SETTING_2 : 
				onSetDischargingAmountSetting2(eoj, tid, esv, property, success);
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
			case EPC_RATED_CHARGE_CAPACITY : 
				onGetRatedChargeCapacity(eoj, tid, esv, property, success);
				return true;
			case EPC_V2H_REMAINING_AVAILABLE_CAPACITY_3 : 
				onGetV2HRemainingAvailableCapacity3(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGEABLE_DISCHARGE_ABLE_STATUS : 
				onGetChargeableDischargeAbleStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_RATED_DISCHARGE_CAPACITY : 
				onGetRatedDischargeCapacity(eoj, tid, esv, property, success);
				return true;
			case EPC_V2H_STORED_ELECTRICITY_2 : 
				onGetV2HStoredElectricity2(eoj, tid, esv, property, success);
				return true;
			case EPC_V2H_STORED_ELECTRICITY_1 : 
				onGetV2HStoredElectricity1(eoj, tid, esv, property, success);
				return true;
			case EPC_V2H_REMAINING_AVAILABLE_CAPACITY_2 : 
				onGetV2HRemainingAvailableCapacity2(eoj, tid, esv, property, success);
				return true;
			case EPC_V2H_REMAINING_AVAILABLE_CAPACITY_1 : 
				onGetV2HRemainingAvailableCapacity1(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_AMOUNT_SETTING_2 : 
				onGetChargingAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGING_AMOUNT_SETTING_1 : 
				onGetDischargingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIMUM_DISCHARGE_ELECTRIC_ENERGY : 
				onGetMinimumMaximumDischargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIMUM_CHARGE_ELECTRIC_ENERGY : 
				onGetMinimumMaximumChargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_BATTERY_CAPACITY1 : 
				onGetRemainingBatteryCapacity1(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGING_AMOUNT_SETTING_1 : 
				onGetChargingAmountSetting1(eoj, tid, esv, property, success);
				return true;
			case EPC_DETERIORATION_STATUS : 
				onGetDeteriorationStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_BATTERY_CAPACITY2 : 
				onGetRemainingBatteryCapacity2(eoj, tid, esv, property, success);
				return true;
			case EPC_REMAINING_BATTERY_CAPACITY3 : 
				onGetRemainingBatteryCapacity3(eoj, tid, esv, property, success);
				return true;
			case EPC_OPERATION_MODE_SETTING : 
				onGetOperationModeSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_SYSTEM_INTERCONNECTE_D_TYPE : 
				onGetSystemInterconnecteDType(eoj, tid, esv, property, success);
				return true;
			case EPC_USED_CAPACITY_1 : 
				onGetUsedCapacity1(eoj, tid, esv, property, success);
				return true;
			case EPC_USED_CAPACITY_2 : 
				onGetUsedCapacity2(eoj, tid, esv, property, success);
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
			case EPC_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING : 
				onGetCumulativeDischargeElectricEnergyResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY : 
				onGetMeasuredCumulativeChargeElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING : 
				onGetCumulativeChargeElectricEnergyResetSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGE_CURRENT_SETTING : 
				onGetChargeCurrentSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING : 
				onGetDischargeElectricEnergySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_CHARGE_ELECTRIC_ENERGY_SETTING : 
				onGetChargeElectricEnergySetting(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGING_AMOUNT_SETTING_2 : 
				onGetDischargingAmountSetting2(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIMUM_CHARGE_CURRENT : 
				onGetMinimumMaximumChargeCurrent(eoj, tid, esv, property, success);
				return true;
			case EPC_DISCHARGE_CURRENT_SETTING : 
				onGetDischargeCurrentSetting(eoj, tid, esv, property, success);
				return true;
			case EPC_MINIMUM_MAXIMUM_DISCHARGE_CURRENT : 
				onGetMinimumMaximumDischargeCurrent(eoj, tid, esv, property, success);
				return true;

			default :
				return false;
			}
		}
		
		/**
		 * Property name : Rated charge capacity<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the rated charge capacity in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRatedChargeCapacity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : V2H remaining available capacity 3<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H remaining available capacity (%) of the vehicle battery. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetV2HRemainingAvailableCapacity3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Chargeable/discharge able status<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates whether the electric vehicle charge/discharge system is chargeable or not. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Not chargeable nor dischargeable   = 0x40 Chargeable but not dischargeable = 0x41 Not chargeable but dischargeable = 0x42 Chargeable and dischargeable = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetChargeableDischargeAbleStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated discharge capacity<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the rated discharge capacity in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRatedDischargeCapacity(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : V2H stored electricity 2<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H stored electricity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetV2HStoredElectricity2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : V2H stored electricity 1<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H stored electricity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetV2HStoredElectricity1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : V2H remaining available capacity 2<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H remaining available capacity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetV2HRemainingAvailableCapacity2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : V2H remaining available capacity 1<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H remaining available capacity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetV2HRemainingAvailableCapacity1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetChargingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetChargingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetDischargingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetDischargingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maximum discharge electric energy<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the minimum/maximum discharge electric energy from the electric vehicle charge/discharge system in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum discharge electric energy: Maximum discharge electric energy<br>
		 * <br>
		 * Data type : unsigned long_x000a_×2<br>
		 * Data size : 8<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMinimumMaximumDischargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maximum charge electric energy<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the minimum/maximum charge electric energy to the charge-discharge system of the electric vehicle in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum charge electric energy: Maximum charge electric energy<br>
		 * <br>
		 * Data type : unsigned long_x000a_×2<br>
		 * Data size : 8<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMinimumMaximumChargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining battery capacity1<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the remaining capacity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRemainingBatteryCapacity1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetChargingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetChargingAmountSetting1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Deterioration status<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the deterioration status (soundness) of the vehicle battery in %. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetDeteriorationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining battery capacity2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the remaining capacity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRemainingBatteryCapacity2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Remaining battery capacity3<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the remaining battery capacity of the vehicle battery in %. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRemainingBatteryCapacity3(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents :<br>
		 * This property sets the operation mode to Rapid charging, Charging, Discharging, Standby, Test, or Other. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging = 0x41, Charging = 0x42, Discharging = 0x43, Standby = 0x44, Test=0x45, Other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents :<br>
		 * This property sets the operation mode to Rapid charging, Charging, Discharging, Standby, Test, or Other. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging = 0x41, Charging = 0x42, Discharging = 0x43, Standby = 0x44, Test=0x45, Other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationModeSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : System-interconnecte d type<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the system interconnection status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System interconnection(reverse power flow acceptable) = 0x00_x000a_Independent type = 0x01_x000a_System interconnection(reverse power flow not acceptable) = 0x02<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetSystemInterconnecteDType(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status<br>
		 * <br>
		 * EPC : 0x80<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the ON/OFF status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x30, OFF = 0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status<br>
		 * <br>
		 * EPC : 0x80<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the ON/OFF status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON = 0x30, OFF = 0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOperationStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Used capacity 1<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the capacity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetUsedCapacity1(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Used capacity 2<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the capacity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetUsedCapacity2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Rated voltage<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the rated voltage of the vehicle battery in V. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.32,766V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetRatedVoltage(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous charge/discharge electric energy<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the instantaneous charge/discharge electric energy in ±W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001. 0x3B9AC9FF (1._x000a_999,999,999W): charge (positive), 0xFFFFFFFF.0xC4653601 (-1._x000a_-999,999,999W): discharge (negative)<br>
		 * <br>
		 * Data type : signed long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredInstantaneousChargeDischargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous charge/discharge current<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the instantaneous charge/discharge current in increments of_x000a_±0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (0.1.3,276.6A): charge_x000a_(positive), 0xFFFF .0x8001 (-0.1.-_x000a_-3,276.7A): discharge (negative)<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredInstantaneousChargeDischargeCurrent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous charge/discharge voltage<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the instantaneous charge/discharge voltage in ±V. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (1.32,766V): charge (positive), 0xFFFF.0x8001 (-1.- -32,767V):_x000a_discharge (negative)<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredInstantaneousChargeDischargeVoltage(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative discharge electric energy<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the cumulative discharge electric energy in increments of 0.001kWh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999.999kWh<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : 0.001_x000a_kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredCumulativeDischargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cumulative discharge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative discharge electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetCumulativeDischargeElectricEnergyResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cumulative discharge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative discharge electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetCumulativeDischargeElectricEnergyResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative charge electric energy<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the cumulative charge electric energy in increments of 0.001kWh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000 . 0x3B9AC9FF (0._x000a_999,999.999kWh<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : 0.001_x000a_kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredCumulativeChargeElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cumulative charge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative charge electricity energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetCumulativeChargeElectricEnergyResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cumulative charge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative charge electricity energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetCumulativeChargeElectricEnergyResetSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetChargeCurrentSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetChargeCurrentSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetDischargeElectricEnergySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetDischargeElectricEnergySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetChargeElectricEnergySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetChargeElectricEnergySetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetDischargingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetDischargingAmountSetting2(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maximum charge current<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the minimum/maximum charge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum charge current: Maximum charge current<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMinimumMaximumChargeCurrent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetDischargeCurrentSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetDischargeCurrentSetting(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Minimum/maximum discharge current<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the  minimum/maximum discharge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum discharge current: Maximum discharge current<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMinimumMaximumDischargeCurrent(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

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
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetChargingAmountSetting2(byte[] edt) {
			reqSetProperty(EPC_CHARGING_AMOUNT_SETTING_2, edt);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetDischargingAmountSetting1(byte[] edt) {
			reqSetProperty(EPC_DISCHARGING_AMOUNT_SETTING_1, edt);
			return this;
		}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetChargingAmountSetting1(byte[] edt) {
			reqSetProperty(EPC_CHARGING_AMOUNT_SETTING_1, edt);
			return this;
		}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents :<br>
		 * This property sets the operation mode to Rapid charging, Charging, Discharging, Standby, Test, or Other. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging = 0x41, Charging = 0x42, Discharging = 0x43, Standby = 0x44, Test=0x45, Other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOperationModeSetting(byte[] edt) {
			reqSetProperty(EPC_OPERATION_MODE_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Cumulative discharge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative discharge electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetCumulativeDischargeElectricEnergyResetSetting(byte[] edt) {
			reqSetProperty(EPC_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Cumulative charge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative charge electricity energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetCumulativeChargeElectricEnergyResetSetting(byte[] edt) {
			reqSetProperty(EPC_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetChargeCurrentSetting(byte[] edt) {
			reqSetProperty(EPC_CHARGE_CURRENT_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetDischargeElectricEnergySetting(byte[] edt) {
			reqSetProperty(EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetChargeElectricEnergySetting(byte[] edt) {
			reqSetProperty(EPC_CHARGE_ELECTRIC_ENERGY_SETTING, edt);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetDischargingAmountSetting2(byte[] edt) {
			reqSetProperty(EPC_DISCHARGING_AMOUNT_SETTING_2, edt);
			return this;
		}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
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
		 * Property name : Rated charge capacity<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the rated charge capacity in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRatedChargeCapacity() {
			reqGetProperty(EPC_RATED_CHARGE_CAPACITY);
			return this;
		}
		/**
		 * Property name : V2H remaining available capacity 3<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H remaining available capacity (%) of the vehicle battery. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetV2HRemainingAvailableCapacity3() {
			reqGetProperty(EPC_V2H_REMAINING_AVAILABLE_CAPACITY_3);
			return this;
		}
		/**
		 * Property name : Chargeable/discharge able status<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates whether the electric vehicle charge/discharge system is chargeable or not. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Not chargeable nor dischargeable   = 0x40 Chargeable but not dischargeable = 0x41 Not chargeable but dischargeable = 0x42 Chargeable and dischargeable = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetChargeableDischargeAbleStatus() {
			reqGetProperty(EPC_CHARGEABLE_DISCHARGE_ABLE_STATUS);
			return this;
		}
		/**
		 * Property name : Rated discharge capacity<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the rated discharge capacity in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRatedDischargeCapacity() {
			reqGetProperty(EPC_RATED_DISCHARGE_CAPACITY);
			return this;
		}
		/**
		 * Property name : V2H stored electricity 2<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H stored electricity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetV2HStoredElectricity2() {
			reqGetProperty(EPC_V2H_STORED_ELECTRICITY_2);
			return this;
		}
		/**
		 * Property name : V2H stored electricity 1<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H stored electricity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetV2HStoredElectricity1() {
			reqGetProperty(EPC_V2H_STORED_ELECTRICITY_1);
			return this;
		}
		/**
		 * Property name : V2H remaining available capacity 2<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H remaining available capacity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetV2HRemainingAvailableCapacity2() {
			reqGetProperty(EPC_V2H_REMAINING_AVAILABLE_CAPACITY_2);
			return this;
		}
		/**
		 * Property name : V2H remaining available capacity 1<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H remaining available capacity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetV2HRemainingAvailableCapacity1() {
			reqGetProperty(EPC_V2H_REMAINING_AVAILABLE_CAPACITY_1);
			return this;
		}
		/**
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetChargingAmountSetting2() {
			reqGetProperty(EPC_CHARGING_AMOUNT_SETTING_2);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetDischargingAmountSetting1() {
			reqGetProperty(EPC_DISCHARGING_AMOUNT_SETTING_1);
			return this;
		}
		/**
		 * Property name : Minimum/maximum discharge electric energy<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the minimum/maximum discharge electric energy from the electric vehicle charge/discharge system in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum discharge electric energy: Maximum discharge electric energy<br>
		 * <br>
		 * Data type : unsigned long_x000a_×2<br>
		 * Data size : 8<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMinimumMaximumDischargeElectricEnergy() {
			reqGetProperty(EPC_MINIMUM_MAXIMUM_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Minimum/maximum charge electric energy<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the minimum/maximum charge electric energy to the charge-discharge system of the electric vehicle in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum charge electric energy: Maximum charge electric energy<br>
		 * <br>
		 * Data type : unsigned long_x000a_×2<br>
		 * Data size : 8<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMinimumMaximumChargeElectricEnergy() {
			reqGetProperty(EPC_MINIMUM_MAXIMUM_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Remaining battery capacity1<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the remaining capacity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRemainingBatteryCapacity1() {
			reqGetProperty(EPC_REMAINING_BATTERY_CAPACITY1);
			return this;
		}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetChargingAmountSetting1() {
			reqGetProperty(EPC_CHARGING_AMOUNT_SETTING_1);
			return this;
		}
		/**
		 * Property name : Deterioration status<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the deterioration status (soundness) of the vehicle battery in %. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetDeteriorationStatus() {
			reqGetProperty(EPC_DETERIORATION_STATUS);
			return this;
		}
		/**
		 * Property name : Remaining battery capacity2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the remaining capacity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRemainingBatteryCapacity2() {
			reqGetProperty(EPC_REMAINING_BATTERY_CAPACITY2);
			return this;
		}
		/**
		 * Property name : Remaining battery capacity3<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the remaining battery capacity of the vehicle battery in %. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetRemainingBatteryCapacity3() {
			reqGetProperty(EPC_REMAINING_BATTERY_CAPACITY3);
			return this;
		}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents :<br>
		 * This property sets the operation mode to Rapid charging, Charging, Discharging, Standby, Test, or Other. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging = 0x41, Charging = 0x42, Discharging = 0x43, Standby = 0x44, Test=0x45, Other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOperationModeSetting() {
			reqGetProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : System-interconnecte d type<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the system interconnection status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System interconnection(reverse power flow acceptable) = 0x00_x000a_Independent type = 0x01_x000a_System interconnection(reverse power flow not acceptable) = 0x02<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetSystemInterconnecteDType() {
			reqGetProperty(EPC_SYSTEM_INTERCONNECTE_D_TYPE);
			return this;
		}
		/**
		 * Property name : Used capacity 1<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the capacity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetUsedCapacity1() {
			reqGetProperty(EPC_USED_CAPACITY_1);
			return this;
		}
		/**
		 * Property name : Used capacity 2<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the capacity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetUsedCapacity2() {
			reqGetProperty(EPC_USED_CAPACITY_2);
			return this;
		}
		/**
		 * Property name : Rated voltage<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the rated voltage of the vehicle battery in V. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.32,766V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
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
		 * Contents :<br>
		 * This property indicates the instantaneous charge/discharge electric energy in ±W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001. 0x3B9AC9FF (1._x000a_999,999,999W): charge (positive), 0xFFFFFFFF.0xC4653601 (-1._x000a_-999,999,999W): discharge (negative)<br>
		 * <br>
		 * Data type : signed long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
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
		 * Contents :<br>
		 * This property indicates the instantaneous charge/discharge current in increments of_x000a_±0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (0.1.3,276.6A): charge_x000a_(positive), 0xFFFF .0x8001 (-0.1.-_x000a_-3,276.7A): discharge (negative)<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
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
		 * Contents :<br>
		 * This property indicates the instantaneous charge/discharge voltage in ±V. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (1.32,766V): charge (positive), 0xFFFF.0x8001 (-1.- -32,767V):_x000a_discharge (negative)<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
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
		 * Contents :<br>
		 * This property indicates the cumulative discharge electric energy in increments of 0.001kWh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999.999kWh<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : 0.001_x000a_kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredCumulativeDischargeElectricEnergy() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Cumulative discharge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative discharge electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetCumulativeDischargeElectricEnergyResetSetting() {
			reqGetProperty(EPC_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING);
			return this;
		}
		/**
		 * Property name : Measured cumulative charge electric energy<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the cumulative charge electric energy in increments of 0.001kWh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000 . 0x3B9AC9FF (0._x000a_999,999.999kWh<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : 0.001_x000a_kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredCumulativeChargeElectricEnergy() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Cumulative charge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative charge electricity energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetCumulativeChargeElectricEnergyResetSetting() {
			reqGetProperty(EPC_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING);
			return this;
		}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetChargeCurrentSetting() {
			reqGetProperty(EPC_CHARGE_CURRENT_SETTING);
			return this;
		}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetDischargeElectricEnergySetting() {
			reqGetProperty(EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING);
			return this;
		}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetChargeElectricEnergySetting() {
			reqGetProperty(EPC_CHARGE_ELECTRIC_ENERGY_SETTING);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetDischargingAmountSetting2() {
			reqGetProperty(EPC_DISCHARGING_AMOUNT_SETTING_2);
			return this;
		}
		/**
		 * Property name : Minimum/maximum charge current<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the minimum/maximum charge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum charge current: Maximum charge current<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMinimumMaximumChargeCurrent() {
			reqGetProperty(EPC_MINIMUM_MAXIMUM_CHARGE_CURRENT);
			return this;
		}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetDischargeCurrentSetting() {
			reqGetProperty(EPC_DISCHARGE_CURRENT_SETTING);
			return this;
		}
		/**
		 * Property name : Minimum/maximum discharge current<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the  minimum/maximum discharge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum discharge current: Maximum discharge current<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMinimumMaximumDischargeCurrent() {
			reqGetProperty(EPC_MINIMUM_MAXIMUM_DISCHARGE_CURRENT);
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
		 * Property name : Rated charge capacity<br>
		 * <br>
		 * EPC : 0xC5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the rated charge capacity in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRatedChargeCapacity() {
			reqInformProperty(EPC_RATED_CHARGE_CAPACITY);
			return this;
		}
		/**
		 * Property name : V2H remaining available capacity 3<br>
		 * <br>
		 * EPC : 0xC4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H remaining available capacity (%) of the vehicle battery. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformV2HRemainingAvailableCapacity3() {
			reqInformProperty(EPC_V2H_REMAINING_AVAILABLE_CAPACITY_3);
			return this;
		}
		/**
		 * Property name : Chargeable/discharge able status<br>
		 * <br>
		 * EPC : 0xC7<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates whether the electric vehicle charge/discharge system is chargeable or not. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Not chargeable nor dischargeable   = 0x40 Chargeable but not dischargeable = 0x41 Not chargeable but dischargeable = 0x42 Chargeable and dischargeable = 0x43<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformChargeableDischargeAbleStatus() {
			reqInformProperty(EPC_CHARGEABLE_DISCHARGE_ABLE_STATUS);
			return this;
		}
		/**
		 * Property name : Rated discharge capacity<br>
		 * <br>
		 * EPC : 0xC6<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the rated discharge capacity in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRatedDischargeCapacity() {
			reqInformProperty(EPC_RATED_DISCHARGE_CAPACITY);
			return this;
		}
		/**
		 * Property name : V2H stored electricity 2<br>
		 * <br>
		 * EPC : 0xC1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H stored electricity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformV2HStoredElectricity2() {
			reqInformProperty(EPC_V2H_STORED_ELECTRICITY_2);
			return this;
		}
		/**
		 * Property name : V2H stored electricity 1<br>
		 * <br>
		 * EPC : 0xC0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H stored electricity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformV2HStoredElectricity1() {
			reqInformProperty(EPC_V2H_STORED_ELECTRICITY_1);
			return this;
		}
		/**
		 * Property name : V2H remaining available capacity 2<br>
		 * <br>
		 * EPC : 0xC3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H remaining available capacity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformV2HRemainingAvailableCapacity2() {
			reqInformProperty(EPC_V2H_REMAINING_AVAILABLE_CAPACITY_2);
			return this;
		}
		/**
		 * Property name : V2H remaining available capacity 1<br>
		 * <br>
		 * EPC : 0xC2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the V2H remaining available capacity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformV2HRemainingAvailableCapacity1() {
			reqInformProperty(EPC_V2H_REMAINING_AVAILABLE_CAPACITY_1);
			return this;
		}
		/**
		 * Property name : Charging amount setting 2<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformChargingAmountSetting2() {
			reqInformProperty(EPC_CHARGING_AMOUNT_SETTING_2);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 1<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformDischargingAmountSetting1() {
			reqInformProperty(EPC_DISCHARGING_AMOUNT_SETTING_1);
			return this;
		}
		/**
		 * Property name : Minimum/maximum discharge electric energy<br>
		 * <br>
		 * EPC : 0xC9<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the minimum/maximum discharge electric energy from the electric vehicle charge/discharge system in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum discharge electric energy: Maximum discharge electric energy<br>
		 * <br>
		 * Data type : unsigned long_x000a_×2<br>
		 * Data size : 8<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMinimumMaximumDischargeElectricEnergy() {
			reqInformProperty(EPC_MINIMUM_MAXIMUM_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Minimum/maximum charge electric energy<br>
		 * <br>
		 * EPC : 0xC8<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the minimum/maximum charge electric energy to the charge-discharge system of the electric vehicle in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)_x000a_Minimum charge electric energy: Maximum charge electric energy<br>
		 * <br>
		 * Data type : unsigned long_x000a_×2<br>
		 * Data size : 8<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMinimumMaximumChargeElectricEnergy() {
			reqInformProperty(EPC_MINIMUM_MAXIMUM_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Remaining battery capacity1<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the remaining capacity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRemainingBatteryCapacity1() {
			reqInformProperty(EPC_REMAINING_BATTERY_CAPACITY1);
			return this;
		}
		/**
		 * Property name : Charging amount setting 1<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformChargingAmountSetting1() {
			reqInformProperty(EPC_CHARGING_AMOUNT_SETTING_1);
			return this;
		}
		/**
		 * Property name : Deterioration status<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the deterioration status (soundness) of the vehicle battery in %. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformDeteriorationStatus() {
			reqInformProperty(EPC_DETERIORATION_STATUS);
			return this;
		}
		/**
		 * Property name : Remaining battery capacity2<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the remaining capacity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRemainingBatteryCapacity2() {
			reqInformProperty(EPC_REMAINING_BATTERY_CAPACITY2);
			return this;
		}
		/**
		 * Property name : Remaining battery capacity3<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the remaining battery capacity of the vehicle battery in %. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x64 (0.100%)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : %<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformRemainingBatteryCapacity3() {
			reqInformProperty(EPC_REMAINING_BATTERY_CAPACITY3);
			return this;
		}
		/**
		 * Property name : Operation mode setting<br>
		 * <br>
		 * EPC : 0xDA<br>
		 * <br>
		 * Contents :<br>
		 * This property sets the operation mode to Rapid charging, Charging, Discharging, Standby, Test, or Other. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Rapid charging = 0x41, Charging = 0x42, Discharging = 0x43, Standby = 0x44, Test=0x45, Other = 0x40<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - mandatory<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOperationModeSetting() {
			reqInformProperty(EPC_OPERATION_MODE_SETTING);
			return this;
		}
		/**
		 * Property name : System-interconnecte d type<br>
		 * <br>
		 * EPC : 0xDB<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the system interconnection status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * System interconnection(reverse power flow acceptable) = 0x00_x000a_Independent type = 0x01_x000a_System interconnection(reverse power flow not acceptable) = 0x02<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformSystemInterconnecteDType() {
			reqInformProperty(EPC_SYSTEM_INTERCONNECTE_D_TYPE);
			return this;
		}
		/**
		 * Property name : Used capacity 1<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the capacity of the vehicle battery in Wh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999,999Wh)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : Wh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformUsedCapacity1() {
			reqInformProperty(EPC_USED_CAPACITY_1);
			return this;
		}
		/**
		 * Property name : Used capacity 2<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the capacity of the vehicle battery in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformUsedCapacity2() {
			reqInformProperty(EPC_USED_CAPACITY_2);
			return this;
		}
		/**
		 * Property name : Rated voltage<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the rated voltage of the vehicle battery in V. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.32,766V)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
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
		 * Contents :<br>
		 * This property indicates the instantaneous charge/discharge electric energy in ±W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000001. 0x3B9AC9FF (1._x000a_999,999,999W): charge (positive), 0xFFFFFFFF.0xC4653601 (-1._x000a_-999,999,999W): discharge (negative)<br>
		 * <br>
		 * Data type : signed long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
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
		 * Contents :<br>
		 * This property indicates the instantaneous charge/discharge current in increments of_x000a_±0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (0.1.3,276.6A): charge_x000a_(positive), 0xFFFF .0x8001 (-0.1.-_x000a_-3,276.7A): discharge (negative)<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
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
		 * Contents :<br>
		 * This property indicates the instantaneous charge/discharge voltage in ±V. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0001.0x7FFE (1.32,766V): charge (positive), 0xFFFF.0x8001 (-1.- -32,767V):_x000a_discharge (negative)<br>
		 * <br>
		 * Data type : signed short<br>
		 * Data size : 2<br>
		 * Unit : V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
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
		 * Contents :<br>
		 * This property indicates the cumulative discharge electric energy in increments of 0.001kWh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0._x000a_999,999.999kWh<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : 0.001_x000a_kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredCumulativeDischargeElectricEnergy() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Cumulative discharge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative discharge electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformCumulativeDischargeElectricEnergyResetSetting() {
			reqInformProperty(EPC_CUMULATIVE_DISCHARGE_ELECTRIC_ENERGY_RESET_SETTING);
			return this;
		}
		/**
		 * Property name : Measured cumulative charge electric energy<br>
		 * <br>
		 * EPC : 0xD8<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the cumulative charge electric energy in increments of 0.001kWh. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000 . 0x3B9AC9FF (0._x000a_999,999.999kWh<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : 0.001_x000a_kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredCumulativeChargeElectricEnergy() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_CHARGE_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Cumulative charge electric energy reset setting<br>
		 * <br>
		 * EPC : 0xD9<br>
		 * <br>
		 * Contents :<br>
		 * This property resets the cumulative charge electricity energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Reset = 0x00<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : -<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformCumulativeChargeElectricEnergyResetSetting() {
			reqInformProperty(EPC_CUMULATIVE_CHARGE_ELECTRIC_ENERGY_RESET_SETTING);
			return this;
		}
		/**
		 * Property name : Charge current setting<br>
		 * <br>
		 * EPC : 0xED<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformChargeCurrentSetting() {
			reqInformProperty(EPC_CHARGE_CURRENT_SETTING);
			return this;
		}
		/**
		 * Property name : Discharge electric energy setting<br>
		 * <br>
		 * EPC : 0xEC<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformDischargeElectricEnergySetting() {
			reqInformProperty(EPC_DISCHARGE_ELECTRIC_ENERGY_SETTING);
			return this;
		}
		/**
		 * Property name : Charge electric energy setting<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the charge electric energy in W. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x3B9AC9FF (0.999,999,999W)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : W<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformChargeElectricEnergySetting() {
			reqInformProperty(EPC_CHARGE_ELECTRIC_ENERGY_SETTING);
			return this;
		}
		/**
		 * Property name : Discharging amount setting 2<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharging capacity in increments of 0.1Ah. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6Ah)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1Ah<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformDischargingAmountSetting2() {
			reqInformProperty(EPC_DISCHARGING_AMOUNT_SETTING_2);
			return this;
		}
		/**
		 * Property name : Minimum/maximum charge current<br>
		 * <br>
		 * EPC : 0xCA<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the minimum/maximum charge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum charge current: Maximum charge current<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMinimumMaximumChargeCurrent() {
			reqInformProperty(EPC_MINIMUM_MAXIMUM_CHARGE_CURRENT);
			return this;
		}
		/**
		 * Property name : Discharge current setting<br>
		 * <br>
		 * EPC : 0xEE<br>
		 * <br>
		 * Contents :<br>
		 * This property specifies the discharge current in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD(0.6,553.3A)<br>
		 * <br>
		 * Data type : unsigned short<br>
		 * Data size : 2<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformDischargeCurrentSetting() {
			reqInformProperty(EPC_DISCHARGE_CURRENT_SETTING);
			return this;
		}
		/**
		 * Property name : Minimum/maximum discharge current<br>
		 * <br>
		 * EPC : 0xCB<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the  minimum/maximum discharge current from the electric vehicle charge/discharge system in increments of 0.1A. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x7FFE (0.3,276.6A)_x000a_Minimum discharge current: Maximum discharge current<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMinimumMaximumDischargeCurrent() {
			reqInformProperty(EPC_MINIMUM_MAXIMUM_DISCHARGE_CURRENT);
			return this;
		}

	}

	public static class Proxy extends ElectricVehicle {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getRatedChargeCapacity(){return null;}
		@Override
		protected byte[] getV2HRemainingAvailableCapacity3(){return null;}
		@Override
		protected byte[] getChargeableDischargeAbleStatus(){return null;}
		@Override
		protected byte[] getRatedDischargeCapacity(){return null;}
		@Override
		protected byte[] getV2HStoredElectricity2(){return null;}
		@Override
		protected byte[] getV2HStoredElectricity1(){return null;}
		@Override
		protected byte[] getV2HRemainingAvailableCapacity2(){return null;}
		@Override
		protected byte[] getV2HRemainingAvailableCapacity1(){return null;}
		@Override
		protected byte[] getStatusChangeAnnouncementPropertyMap(){return null;}
		@Override
		protected byte[] getRemainingBatteryCapacity1(){return null;}
		@Override
		protected byte[] getSetPropertyMap(){return null;}
		@Override
		protected byte[] getManufacturerCode(){return null;}
		@Override
		protected byte[] getRemainingBatteryCapacity2(){return null;}
		@Override
		protected byte[] getRemainingBatteryCapacity3(){return null;}
		@Override
		protected boolean setOperationModeSetting(byte[] edt){return false;}
		@Override
		protected byte[] getOperationModeSetting(){return null;}
		@Override
		protected byte[] getOperationStatus(){return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt){return false;}
		@Override
		protected byte[] getInstallationLocation(){return null;}
		@Override
		protected byte[] getStandardVersionInformation(){return null;}
		@Override
		protected byte[] getGetPropertyMap(){return null;}
		@Override
		protected byte[] getFaultStatus(){return null;}
		@Override
		protected byte[] getUsedCapacity1(){return null;}
		@Override
		protected byte[] getUsedCapacity2(){return null;}

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
