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

public abstract class SmartElectricEnergyMeter extends DeviceObject {
	
	public static final short ECHO_CLASS_CODE = (short)0x0288;

	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION = (byte)0xE3;
	public static final byte EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS = (byte)0xE1;
	public static final byte EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION = (byte)0xE0;
	public static final byte EPC_MEASURED_INSTANTANEOUS_ELECTRIC_ENERGY = (byte)0xE7;
	public static final byte EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED = (byte)0xE5;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_REVERSE_DIRECTION = (byte)0xE4;
	public static final byte EPC_MEASURED_INSTANTANEOUS_VOLTAGES = (byte)0xE9;
	public static final byte EPC_MEASURED_INSTANTANEOUS_CURRENTS = (byte)0xE8;
	public static final byte EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_NORMAL_DIRECTION = (byte)0xE2;
	public static final byte EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION = (byte)0xD0;
	public static final byte EPC_OWNER_CLASSIFICATION = (byte)0xD1;
	public static final byte EPC_PHASES_AND_WIRES_SETTING_STATUS = (byte)0xD2;
	public static final byte EPC_COMPOSITE_TRANSFORMATION_RATIO = (byte)0xD3;
	public static final byte EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO = (byte)0xD4;
	public static final byte EPC_METER_TYPE_CERTIFICATION_NUMBER = (byte)0xD5;
	public static final byte EPC_YEAR_AND_MONTH_OF_INSPECTION_EXPIRY = (byte)0xD6;
	public static final byte EPC_NUMBER_OF_EFFECTIVE_DIGITS_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY = (byte)0xD7;
	public static final byte EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_REVERSE_DIRECTION = (byte)0xEB;
	public static final byte EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_NORMAL_DIRECTION = (byte)0xEA;

	@Override
	protected void setupPropertyMaps() {
		super.setupPropertyMaps();
		
		addGetProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS);
		addGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
		addStatusChangeAnnouncementProperty(EPC_OPERATION_STATUS);
		removeSetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_OPERATION_STATUS);
		addGetProperty(EPC_NUMBER_OF_EFFECTIVE_DIGITS_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY);
		addGetProperty(EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_NORMAL_DIRECTION);

	}

	@Override
	public void onNew() {
		super.onNew();
		Echo.getEventListener().onNewSmartElectricEnergyMeter(this);
	}
	
	@Override
	public short getEchoClassCode() {
		return ECHO_CLASS_CODE;
	}

	/**
	 * Property name : Measured cumulative amounts of electric energy (reverse direction)<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured cumulative amounts of electric energy using an 8-digit decimal notation number. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {return null;}
	/**
	 * Property name : Measured cumulative amounts of electric energy (reverse direction)<br>
	 * <br>
	 * EPC : 0xE3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured cumulative amounts of electric energy using an 8-digit decimal notation number. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1kWh 0x01: 0.1kWh_x000a_0x02: 0.01kWh_x000a_0x03: 0.001kWh_x000a_0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh_x000a_0x0C: 1000kWh_x000a_0x0D: 10000kWh<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
	/**
	 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
	 * <br>
	 * EPC : 0xE1<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00: 1kWh 0x01: 0.1kWh_x000a_0x02: 0.01kWh_x000a_0x03: 0.001kWh_x000a_0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh_x000a_0x0C: 1000kWh_x000a_0x0D: 10000kWh<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
	/**
	 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
	 * <br>
	 * EPC : 0xE0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredCumulativeAmountOfElectricEnergyNormalDirection(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured instantaneous electric energy<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured effective instantaneous electric energy in watts. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80000001.0x7FFFFFFD (-2,147,483,647._x000a_2,147,483,645)<br>
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
	protected byte[] getMeasuredInstantaneousElectricEnergy() {return null;}
	/**
	 * Property name : Measured instantaneous electric energy<br>
	 * <br>
	 * EPC : 0xE7<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured effective instantaneous electric energy in watts. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x80000001.0x7FFFFFFD (-2,147,483,647._x000a_2,147,483,645)<br>
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
	protected boolean isValidMeasuredInstantaneousElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x63 (0.99)_x000a_0: current day_x000a_1. 99: previous day. day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {return false;}
	/**
	 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x63 (0.99)_x000a_0: current day_x000a_1. 99: previous day. day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {return null;}
	/**
	 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
	 * <br>
	 * EPC : 0xE5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00.0x63 (0.99)_x000a_0: current day_x000a_1. 99: previous day. day that precedes the current day by 99 days<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(reverse direction)<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned short_x000a_+unsigned_x000a_long_x000a_×48<br>
	 * Data size : 194<br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000AReverseDirection() {return null;}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(reverse direction)<br>
	 * <br>
	 * EPC : 0xE4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned short_x000a_+unsigned_x000a_long_x000a_×48<br>
	 * Data size : 194<br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000AReverseDirection(byte[] edt) {
		if(edt == null || !(edt.length == 194)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured instantaneous voltages<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a_x000a_single-phase, two-wire system,_x000a_0xFFFE shall be used for the S(N)-T voltage. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (between R and S(N)):_x000a_0x0000.0xFFFD (between S(N) and T)_x000a_(0.6,553.3) : (0.6,553.3)<br>
	 * <br>
	 * Data type : unsigned short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 0.1_x000a_V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredInstantaneousVoltages() {return null;}
	/**
	 * Property name : Measured instantaneous voltages<br>
	 * <br>
	 * EPC : 0xE9<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a_x000a_single-phase, two-wire system,_x000a_0xFFFE shall be used for the S(N)-T voltage. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0xFFFD (between R and S(N)):_x000a_0x0000.0xFFFD (between S(N) and T)_x000a_(0.6,553.3) : (0.6,553.3)<br>
	 * <br>
	 * Data type : unsigned short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 0.1_x000a_V<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredInstantaneousVoltages(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Measured instantaneous currents<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes._x000a_In the case of a single-phase,_x000a_two-wire system, 0x7FFE shall be used for the T phase. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001.0x7FFD (R phase)_x000a_: 0x8001.0x7FFD (T phase) (-3,276.7.3,276.5):_x000a_(-3,276.7.3,276.5)<br>
	 * <br>
	 * Data type : signed short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 0.1_x000a_A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeasuredInstantaneousCurrents() {return null;}
	/**
	 * Property name : Measured instantaneous currents<br>
	 * <br>
	 * EPC : 0xE8<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the measured effective instantaneous R and T phase currents in amperes._x000a_In the case of a single-phase,_x000a_two-wire system, 0x7FFE shall be used for the T phase. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x8001.0x7FFD (R phase)_x000a_: 0x8001.0x7FFD (T phase) (-3,276.7.3,276.5):_x000a_(-3,276.7.3,276.5)<br>
	 * <br>
	 * Data type : signed short_x000a_×2<br>
	 * Data size : 4<br>
	 * Unit : 0.1_x000a_A<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeasuredInstantaneousCurrents(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(normal direction)<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned short_x000a_+_x000a_unsigned long_x000a_×48<br>
	 * Data size : 194<br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000ANormalDirection() {return null;}
	/**
	 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(normal direction)<br>
	 * <br>
	 * EPC : 0xE2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned short_x000a_+_x000a_unsigned long_x000a_×48<br>
	 * Data size : 194<br>
	 * Unit : kWh<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000ANormalDirection(byte[] edt) {
		if(edt == null || !(edt.length == 194)) {return false;};
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
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
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
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
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
	 * ON=0x30, OFF=0x31<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
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
	 * Property name : Electric energy meter classification<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the electric energy meter type. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: Electric utility company 0x31: Solar power_x000a_0x32: Fuel cell 0x33: Battery 0x34: EV_x000a_0x35: Others<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setElectricEnergyMeterClassification(byte[] edt) {return false;}
	/**
	 * Property name : Electric energy meter classification<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the electric energy meter type. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: Electric utility company 0x31: Solar power_x000a_0x32: Fuel cell 0x33: Battery 0x34: EV_x000a_0x35: Others<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getElectricEnergyMeterClassification() {return null;}
	/**
	 * Property name : Electric energy meter classification<br>
	 * <br>
	 * EPC : 0xD0<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the electric energy meter type. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: Electric utility company 0x31: Solar power_x000a_0x32: Fuel cell 0x33: Battery 0x34: EV_x000a_0x35: Others<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidElectricEnergyMeterClassification(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Owner classification<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the type of owner of the meter. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: Not specified_x000a_0x31: Electric utility company 0x32: Other than_x000a_electric utility companies 0x33: Individual<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setOwnerClassification(byte[] edt) {return false;}
	/**
	 * Property name : Owner classification<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the type of owner of the meter. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: Not specified_x000a_0x31: Electric utility company 0x32: Other than_x000a_electric utility companies 0x33: Individual<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getOwnerClassification() {return null;}
	/**
	 * Property name : Owner classification<br>
	 * <br>
	 * EPC : 0xD1<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the type of owner of the meter. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x30: Not specified_x000a_0x31: Electric utility company 0x32: Other than_x000a_electric utility companies 0x33: Individual<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : .<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidOwnerClassification(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Phases and wires setting status<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the phases and wires setting status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Single-phase, two-wire system: 0x30_x000a_Single-phase, three-wire system: 0x31_x000a_Three-phase, three-wire system: 0x32_x000a_Three-phase, four-wire system: 0x33<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getPhasesAndWiresSettingStatus() {return null;}
	/**
	 * Property name : Phases and wires setting status<br>
	 * <br>
	 * EPC : 0xD2<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the phases and wires setting status. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Single-phase, two-wire system: 0x30_x000a_Single-phase, three-wire system: 0x31_x000a_Three-phase, three-wire system: 0x32_x000a_Three-phase, four-wire system: 0x33<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidPhasesAndWiresSettingStatus(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Composite transformation ratio<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the composite transformation ratio using a 6-digit decimal notation number. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x000F423F (000000.999999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getCompositeTransformationRatio() {return null;}
	/**
	 * Property name : Composite transformation ratio<br>
	 * <br>
	 * EPC : 0xD3<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the composite transformation ratio using a 6-digit decimal notation number. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00000000.0x000F423F (000000.999999)<br>
	 * <br>
	 * Data type : unsigned long<br>
	 * Data size : 4<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidCompositeTransformationRatio(byte[] edt) {
		if(edt == null || !(edt.length == 4)) {return false;};
		return true;
	}
	/**
	 * Property name : Multiplying factor for composite transformation ratio<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the multiplying factor for the composite transformation ratio. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 : ×1_x000a_0x01 : ×0.1_x000a_0x02 : ×0.01_x000a_0x03 : ×0.001<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMultiplyingFactorForCompositeTransformationRatio() {return null;}
	/**
	 * Property name : Multiplying factor for composite transformation ratio<br>
	 * <br>
	 * EPC : 0xD4<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the multiplying factor for the composite transformation ratio. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x00 : ×1_x000a_0x01 : ×0.1_x000a_0x02 : ×0.01_x000a_0x03 : ×0.001<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMultiplyingFactorForCompositeTransformationRatio(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Meter type certification number<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the_x000a_type-certified meter number using a string of 10 alphanumeric characters <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Type-certified meter (type number):<br>
	 * <br>
	 * Data type : unsigned char × 10<br>
	 * Data size : 10<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getMeterTypeCertificationNumber() {return null;}
	/**
	 * Property name : Meter type certification number<br>
	 * <br>
	 * EPC : 0xD5<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the_x000a_type-certified meter number using a string of 10 alphanumeric characters <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * Type-certified meter (type number):<br>
	 * <br>
	 * Data type : unsigned char × 10<br>
	 * Data size : 10<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidMeterTypeCertificationNumber(byte[] edt) {
		if(edt == null || !(edt.length == 10)) {return false;};
		return true;
	}
	/**
	 * Property name : Year and month of inspection expiry<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the year and month of inspection expiry of the meter by a six-byte ASCII code. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM_x000a_YYYY (Year), MM (Month)<br>
	 * <br>
	 * Data type : unsigned char × 6<br>
	 * Data size : 6<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean setYearAndMonthOfInspectionExpiry(byte[] edt) {return false;}
	/**
	 * Property name : Year and month of inspection expiry<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the year and month of inspection expiry of the meter by a six-byte ASCII code. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM_x000a_YYYY (Year), MM (Month)<br>
	 * <br>
	 * Data type : unsigned char × 6<br>
	 * Data size : 6<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getYearAndMonthOfInspectionExpiry() {return null;}
	/**
	 * Property name : Year and month of inspection expiry<br>
	 * <br>
	 * EPC : 0xD6<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the year and month of inspection expiry of the meter by a six-byte ASCII code. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * YYYYMM_x000a_YYYY (Year), MM (Month)<br>
	 * <br>
	 * Data type : unsigned char × 6<br>
	 * Data size : 6<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - optional<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidYearAndMonthOfInspectionExpiry(byte[] edt) {
		if(edt == null || !(edt.length == 6)) {return false;};
		return true;
	}
	/**
	 * Property name : Number of effective digits for cumulative amounts of electric energy<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the number of effective digits for measured cumulative amounts of electric energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01.0x08 (1.8)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : digit<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getNumberOfEffectiveDigitsForCumulativeAmountsOfElectricEnergy();
	/**
	 * Property name : Number of effective digits for cumulative amounts of electric energy<br>
	 * <br>
	 * EPC : 0xD7<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the number of effective digits for measured cumulative amounts of electric energy. <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 0x01.0x08 (1.8)<br>
	 * <br>
	 * Data type : unsigned char<br>
	 * Data size : 1<br>
	 * Unit : digit<br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidNumberOfEffectiveDigitsForCumulativeAmountsOfElectricEnergy(byte[] edt) {
		if(edt == null || !(edt.length == 1)) {return false;};
		return true;
	}
	/**
	 * Property name : Cumulative amounts of electric energy measured at fixed time (reverse direction)<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the most recent cumulative amount of electric energy (reverse direction) measured at 30-minute intervals held by the meter in the format of 4 bytes for date of measurement, 3_x000a_bytes for time of measurement, and 4 bytes for cumulative electric energy (reverse direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char ×3_x000a_+_x000a_unsigned long<br>
	 * Data size : 11<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected byte[] getCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeReverseDirection() {return null;}
	/**
	 * Property name : Cumulative amounts of electric energy measured at fixed time (reverse direction)<br>
	 * <br>
	 * EPC : 0xEB<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the most recent cumulative amount of electric energy (reverse direction) measured at 30-minute intervals held by the meter in the format of 4 bytes for date of measurement, 3_x000a_bytes for time of measurement, and 4 bytes for cumulative electric energy (reverse direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char ×3_x000a_+_x000a_unsigned long<br>
	 * Data size : 11<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - optional<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeReverseDirection(byte[] edt) {
		if(edt == null || !(edt.length == 11)) {return false;};
		return true;
	}
	/**
	 * Property name : Cumulative amounts of electric energy measured at fixed time (normal direction)<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the most recent cumulative amount of electric energy (normal direction)_x000a_measured at 30-minute intervals_x000a_held by the meter in the format of_x000a_4 bytes for date of measurement, 3 bytes for time of measurement, and 4 bytes for cumulative electric energy (normal direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char×3_x000a_+_x000a_unsigned long_x000a_<br>
	 * Data size : 11<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected abstract byte[] getCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeNormalDirection();
	/**
	 * Property name : Cumulative amounts of electric energy measured at fixed time (normal direction)<br>
	 * <br>
	 * EPC : 0xEA<br>
	 * <br>
	 * Contents :<br>
	 * This property indicates the most recent cumulative amount of electric energy (normal direction)_x000a_measured at 30-minute intervals_x000a_held by the meter in the format of_x000a_4 bytes for date of measurement, 3 bytes for time of measurement, and 4 bytes for cumulative electric energy (normal direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
	 * <br>
	 * Value range (decimal notation) :<br>
	 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
	 * <br>
	 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char×3_x000a_+_x000a_unsigned long_x000a_<br>
	 * Data size : 11<br>
	 * Unit : <br>
	 * <br>
	 * Access rule :<br>
	 * Announce - -<br>
	 * Set      - -<br>
	 * Get      - mandatory<br>
	 * <br>
	 * <b>Announcement at status change</b><br>
	 */
	protected boolean isValidCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeNormalDirection(byte[] edt) {
		if(edt == null || !(edt.length == 11)) {return false;};
		return true;
	}

	@Override
	protected synchronized boolean setProperty(EchoProperty property) {
		boolean success = super.setProperty(property);
		if(success) return success;

		switch(property.epc) {
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : return setDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(property.edt);
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : return setElectricEnergyMeterClassification(property.edt);
		case EPC_OWNER_CLASSIFICATION : return setOwnerClassification(property.edt);
		case EPC_YEAR_AND_MONTH_OF_INSPECTION_EXPIRY : return setYearAndMonthOfInspectionExpiry(property.edt);

		default : return false;
		}
	}
	
	@Override
	protected synchronized byte[] getProperty(byte epc) {
		byte[] edt = super.getProperty(epc);
		if(edt != null) return edt;
		
		switch(epc) {
		case EPC_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return getMeasuredCumulativeAmountsOfElectricEnergyReverseDirection();
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS : return getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections();
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return getMeasuredCumulativeAmountOfElectricEnergyNormalDirection();
		case EPC_MEASURED_INSTANTANEOUS_ELECTRIC_ENERGY : return getMeasuredInstantaneousElectricEnergy();
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : return getDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved();
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_REVERSE_DIRECTION : return getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000AReverseDirection();
		case EPC_MEASURED_INSTANTANEOUS_VOLTAGES : return getMeasuredInstantaneousVoltages();
		case EPC_MEASURED_INSTANTANEOUS_CURRENTS : return getMeasuredInstantaneousCurrents();
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_NORMAL_DIRECTION : return getHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000ANormalDirection();
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : return getElectricEnergyMeterClassification();
		case EPC_OWNER_CLASSIFICATION : return getOwnerClassification();
		case EPC_PHASES_AND_WIRES_SETTING_STATUS : return getPhasesAndWiresSettingStatus();
		case EPC_COMPOSITE_TRANSFORMATION_RATIO : return getCompositeTransformationRatio();
		case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO : return getMultiplyingFactorForCompositeTransformationRatio();
		case EPC_METER_TYPE_CERTIFICATION_NUMBER : return getMeterTypeCertificationNumber();
		case EPC_YEAR_AND_MONTH_OF_INSPECTION_EXPIRY : return getYearAndMonthOfInspectionExpiry();
		case EPC_NUMBER_OF_EFFECTIVE_DIGITS_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY : return getNumberOfEffectiveDigitsForCumulativeAmountsOfElectricEnergy();
		case EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_REVERSE_DIRECTION : return getCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeReverseDirection();
		case EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_NORMAL_DIRECTION : return getCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeNormalDirection();

		default : return null;
		}
	}

	@Override
	protected synchronized boolean isValidProperty(EchoProperty property) {
		boolean valid = super.isValidProperty(property);
		if(valid) return valid;
		
		switch(property.epc) {
		case EPC_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : return isValidMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(property.edt);
		case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS : return isValidUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(property.edt);
		case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : return isValidMeasuredCumulativeAmountOfElectricEnergyNormalDirection(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_ELECTRIC_ENERGY : return isValidMeasuredInstantaneousElectricEnergy(property.edt);
		case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : return isValidDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(property.edt);
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_REVERSE_DIRECTION : return isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000AReverseDirection(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_VOLTAGES : return isValidMeasuredInstantaneousVoltages(property.edt);
		case EPC_MEASURED_INSTANTANEOUS_CURRENTS : return isValidMeasuredInstantaneousCurrents(property.edt);
		case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_NORMAL_DIRECTION : return isValidHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000ANormalDirection(property.edt);
		case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : return isValidElectricEnergyMeterClassification(property.edt);
		case EPC_OWNER_CLASSIFICATION : return isValidOwnerClassification(property.edt);
		case EPC_PHASES_AND_WIRES_SETTING_STATUS : return isValidPhasesAndWiresSettingStatus(property.edt);
		case EPC_COMPOSITE_TRANSFORMATION_RATIO : return isValidCompositeTransformationRatio(property.edt);
		case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO : return isValidMultiplyingFactorForCompositeTransformationRatio(property.edt);
		case EPC_METER_TYPE_CERTIFICATION_NUMBER : return isValidMeterTypeCertificationNumber(property.edt);
		case EPC_YEAR_AND_MONTH_OF_INSPECTION_EXPIRY : return isValidYearAndMonthOfInspectionExpiry(property.edt);
		case EPC_NUMBER_OF_EFFECTIVE_DIGITS_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY : return isValidNumberOfEffectiveDigitsForCumulativeAmountsOfElectricEnergy(property.edt);
		case EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_REVERSE_DIRECTION : return isValidCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeReverseDirection(property.edt);
		case EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_NORMAL_DIRECTION : return isValidCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeNormalDirection(property.edt);

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
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : 
				onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, property, success);
				return true;
			case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : 
				onSetElectricEnergyMeterClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION : 
				onSetOwnerClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_YEAR_AND_MONTH_OF_INSPECTION_EXPIRY : 
				onSetYearAndMonthOfInspectionExpiry(eoj, tid, esv, property, success);
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
			case EPC_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION : 
				onGetMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS : 
				onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION : 
				onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_ELECTRIC_ENERGY : 
				onGetMeasuredInstantaneousElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED : 
				onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_REVERSE_DIRECTION : 
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000AReverseDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_VOLTAGES : 
				onGetMeasuredInstantaneousVoltages(eoj, tid, esv, property, success);
				return true;
			case EPC_MEASURED_INSTANTANEOUS_CURRENTS : 
				onGetMeasuredInstantaneousCurrents(eoj, tid, esv, property, success);
				return true;
			case EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_NORMAL_DIRECTION : 
				onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000ANormalDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION : 
				onGetElectricEnergyMeterClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_OWNER_CLASSIFICATION : 
				onGetOwnerClassification(eoj, tid, esv, property, success);
				return true;
			case EPC_PHASES_AND_WIRES_SETTING_STATUS : 
				onGetPhasesAndWiresSettingStatus(eoj, tid, esv, property, success);
				return true;
			case EPC_COMPOSITE_TRANSFORMATION_RATIO : 
				onGetCompositeTransformationRatio(eoj, tid, esv, property, success);
				return true;
			case EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO : 
				onGetMultiplyingFactorForCompositeTransformationRatio(eoj, tid, esv, property, success);
				return true;
			case EPC_METER_TYPE_CERTIFICATION_NUMBER : 
				onGetMeterTypeCertificationNumber(eoj, tid, esv, property, success);
				return true;
			case EPC_YEAR_AND_MONTH_OF_INSPECTION_EXPIRY : 
				onGetYearAndMonthOfInspectionExpiry(eoj, tid, esv, property, success);
				return true;
			case EPC_NUMBER_OF_EFFECTIVE_DIGITS_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY : 
				onGetNumberOfEffectiveDigitsForCumulativeAmountsOfElectricEnergy(eoj, tid, esv, property, success);
				return true;
			case EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_REVERSE_DIRECTION : 
				onGetCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeReverseDirection(eoj, tid, esv, property, success);
				return true;
			case EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_NORMAL_DIRECTION : 
				onGetCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeNormalDirection(eoj, tid, esv, property, success);
				return true;

			default :
				return false;
			}
		}
		
		/**
		 * Property name : Measured cumulative amounts of electric energy (reverse direction)<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured cumulative amounts of electric energy using an 8-digit decimal notation number. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredCumulativeAmountsOfElectricEnergyReverseDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1kWh 0x01: 0.1kWh_x000a_0x02: 0.01kWh_x000a_0x03: 0.001kWh_x000a_0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh_x000a_0x0C: 1000kWh_x000a_0x0D: 10000kWh<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured effective instantaneous electric energy in watts. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80000001.0x7FFFFFFD (-2,147,483,647._x000a_2,147,483,645)<br>
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
		protected void onGetMeasuredInstantaneousElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)_x000a_0: current day_x000a_1. 99: previous day. day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)_x000a_0: current day_x000a_1. 99: previous day. day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(reverse direction)<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short_x000a_+unsigned_x000a_long_x000a_×48<br>
		 * Data size : 194<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000AReverseDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous voltages<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a_x000a_single-phase, two-wire system,_x000a_0xFFFE shall be used for the S(N)-T voltage. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (between R and S(N)):_x000a_0x0000.0xFFFD (between S(N) and T)_x000a_(0.6,553.3) : (0.6,553.3)<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1_x000a_V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredInstantaneousVoltages(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Measured instantaneous currents<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes._x000a_In the case of a single-phase,_x000a_two-wire system, 0x7FFE shall be used for the T phase. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFD (R phase)_x000a_: 0x8001.0x7FFD (T phase) (-3,276.7.3,276.5):_x000a_(-3,276.7.3,276.5)<br>
		 * <br>
		 * Data type : signed short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1_x000a_A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeasuredInstantaneousCurrents(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(normal direction)<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short_x000a_+_x000a_unsigned long_x000a_×48<br>
		 * Data size : 194<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000ANormalDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Operation status<br>
		 * <br>
		 * EPC : 0x80<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the ON/OFF status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * ON=0x30, OFF=0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
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
		 * ON=0x30, OFF=0x31<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
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
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the electric energy meter type. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Electric utility company 0x31: Solar power_x000a_0x32: Fuel cell 0x33: Battery 0x34: EV_x000a_0x35: Others<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetElectricEnergyMeterClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the electric energy meter type. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Electric utility company 0x31: Solar power_x000a_0x32: Fuel cell 0x33: Battery 0x34: EV_x000a_0x35: Others<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetElectricEnergyMeterClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the type of owner of the meter. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Not specified_x000a_0x31: Electric utility company 0x32: Other than_x000a_electric utility companies 0x33: Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetOwnerClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the type of owner of the meter. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Not specified_x000a_0x31: Electric utility company 0x32: Other than_x000a_electric utility companies 0x33: Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetOwnerClassification(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Phases and wires setting status<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the phases and wires setting status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Single-phase, two-wire system: 0x30_x000a_Single-phase, three-wire system: 0x31_x000a_Three-phase, three-wire system: 0x32_x000a_Three-phase, four-wire system: 0x33<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetPhasesAndWiresSettingStatus(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x000F423F (000000.999999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetCompositeTransformationRatio(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Multiplying factor for composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the multiplying factor for the composite transformation ratio. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 : ×1_x000a_0x01 : ×0.1_x000a_0x02 : ×0.01_x000a_0x03 : ×0.001<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMultiplyingFactorForCompositeTransformationRatio(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Meter type certification number<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the_x000a_type-certified meter number using a string of 10 alphanumeric characters <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type-certified meter (type number):<br>
		 * <br>
		 * Data type : unsigned char × 10<br>
		 * Data size : 10<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetMeterTypeCertificationNumber(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Year and month of inspection expiry<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the year and month of inspection expiry of the meter by a six-byte ASCII code. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM_x000a_YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char × 6<br>
		 * Data size : 6<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onSetYearAndMonthOfInspectionExpiry(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Year and month of inspection expiry<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the year and month of inspection expiry of the meter by a six-byte ASCII code. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM_x000a_YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char × 6<br>
		 * Data size : 6<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetYearAndMonthOfInspectionExpiry(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Number of effective digits for cumulative amounts of electric energy<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the number of effective digits for measured cumulative amounts of electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01.0x08 (1.8)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : digit<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetNumberOfEffectiveDigitsForCumulativeAmountsOfElectricEnergy(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cumulative amounts of electric energy measured at fixed time (reverse direction)<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the most recent cumulative amount of electric energy (reverse direction) measured at 30-minute intervals held by the meter in the format of 4 bytes for date of measurement, 3_x000a_bytes for time of measurement, and 4 bytes for cumulative electric energy (reverse direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char ×3_x000a_+_x000a_unsigned long<br>
		 * Data size : 11<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeReverseDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}
		/**
		 * Property name : Cumulative amounts of electric energy measured at fixed time (normal direction)<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the most recent cumulative amount of electric energy (normal direction)_x000a_measured at 30-minute intervals_x000a_held by the meter in the format of_x000a_4 bytes for date of measurement, 3 bytes for time of measurement, and 4 bytes for cumulative electric energy (normal direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char×3_x000a_+_x000a_unsigned long_x000a_<br>
		 * Data size : 11<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		protected void onGetCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeNormalDirection(EchoObject eoj, short tid, byte esv, EchoProperty property, boolean success) {}

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
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)_x000a_0: current day_x000a_1. 99: previous day. day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved(byte[] edt) {
			reqSetProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED, edt);
			return this;
		}
		/**
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the electric energy meter type. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Electric utility company 0x31: Solar power_x000a_0x32: Fuel cell 0x33: Battery 0x34: EV_x000a_0x35: Others<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetElectricEnergyMeterClassification(byte[] edt) {
			reqSetProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION, edt);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the type of owner of the meter. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Not specified_x000a_0x31: Electric utility company 0x32: Other than_x000a_electric utility companies 0x33: Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetOwnerClassification(byte[] edt) {
			reqSetProperty(EPC_OWNER_CLASSIFICATION, edt);
			return this;
		}
		/**
		 * Property name : Year and month of inspection expiry<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the year and month of inspection expiry of the meter by a six-byte ASCII code. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM_x000a_YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char × 6<br>
		 * Data size : 6<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Setter reqSetYearAndMonthOfInspectionExpiry(byte[] edt) {
			reqSetProperty(EPC_YEAR_AND_MONTH_OF_INSPECTION_EXPIRY, edt);
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
		 * Property name : Measured cumulative amounts of electric energy (reverse direction)<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured cumulative amounts of electric energy using an 8-digit decimal notation number. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1kWh 0x01: 0.1kWh_x000a_0x02: 0.01kWh_x000a_0x03: 0.001kWh_x000a_0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh_x000a_0x0C: 1000kWh_x000a_0x0D: 10000kWh<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			reqGetProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			reqGetProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Measured instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured effective instantaneous electric energy in watts. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80000001.0x7FFFFFFD (-2,147,483,647._x000a_2,147,483,645)<br>
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
		public Getter reqGetMeasuredInstantaneousElectricEnergy() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)_x000a_0: current day_x000a_1. 99: previous day. day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			reqGetProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(reverse direction)<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short_x000a_+unsigned_x000a_long_x000a_×48<br>
		 * Data size : 194<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000AReverseDirection() {
			reqGetProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Measured instantaneous voltages<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a_x000a_single-phase, two-wire system,_x000a_0xFFFE shall be used for the S(N)-T voltage. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (between R and S(N)):_x000a_0x0000.0xFFFD (between S(N) and T)_x000a_(0.6,553.3) : (0.6,553.3)<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1_x000a_V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredInstantaneousVoltages() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES);
			return this;
		}
		/**
		 * Property name : Measured instantaneous currents<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes._x000a_In the case of a single-phase,_x000a_two-wire system, 0x7FFE shall be used for the T phase. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFD (R phase)_x000a_: 0x8001.0x7FFD (T phase) (-3,276.7.3,276.5):_x000a_(-3,276.7.3,276.5)<br>
		 * <br>
		 * Data type : signed short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1_x000a_A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeasuredInstantaneousCurrents() {
			reqGetProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(normal direction)<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short_x000a_+_x000a_unsigned long_x000a_×48<br>
		 * Data size : 194<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000ANormalDirection() {
			reqGetProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the electric energy meter type. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Electric utility company 0x31: Solar power_x000a_0x32: Fuel cell 0x33: Battery 0x34: EV_x000a_0x35: Others<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetElectricEnergyMeterClassification() {
			reqGetProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the type of owner of the meter. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Not specified_x000a_0x31: Electric utility company 0x32: Other than_x000a_electric utility companies 0x33: Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetOwnerClassification() {
			reqGetProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Phases and wires setting status<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the phases and wires setting status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Single-phase, two-wire system: 0x30_x000a_Single-phase, three-wire system: 0x31_x000a_Three-phase, three-wire system: 0x32_x000a_Three-phase, four-wire system: 0x33<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetPhasesAndWiresSettingStatus() {
			reqGetProperty(EPC_PHASES_AND_WIRES_SETTING_STATUS);
			return this;
		}
		/**
		 * Property name : Composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x000F423F (000000.999999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetCompositeTransformationRatio() {
			reqGetProperty(EPC_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		/**
		 * Property name : Multiplying factor for composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the multiplying factor for the composite transformation ratio. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 : ×1_x000a_0x01 : ×0.1_x000a_0x02 : ×0.01_x000a_0x03 : ×0.001<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMultiplyingFactorForCompositeTransformationRatio() {
			reqGetProperty(EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		/**
		 * Property name : Meter type certification number<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the_x000a_type-certified meter number using a string of 10 alphanumeric characters <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type-certified meter (type number):<br>
		 * <br>
		 * Data type : unsigned char × 10<br>
		 * Data size : 10<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetMeterTypeCertificationNumber() {
			reqGetProperty(EPC_METER_TYPE_CERTIFICATION_NUMBER);
			return this;
		}
		/**
		 * Property name : Year and month of inspection expiry<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the year and month of inspection expiry of the meter by a six-byte ASCII code. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM_x000a_YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char × 6<br>
		 * Data size : 6<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetYearAndMonthOfInspectionExpiry() {
			reqGetProperty(EPC_YEAR_AND_MONTH_OF_INSPECTION_EXPIRY);
			return this;
		}
		/**
		 * Property name : Number of effective digits for cumulative amounts of electric energy<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the number of effective digits for measured cumulative amounts of electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01.0x08 (1.8)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : digit<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetNumberOfEffectiveDigitsForCumulativeAmountsOfElectricEnergy() {
			reqGetProperty(EPC_NUMBER_OF_EFFECTIVE_DIGITS_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Cumulative amounts of electric energy measured at fixed time (reverse direction)<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the most recent cumulative amount of electric energy (reverse direction) measured at 30-minute intervals held by the meter in the format of 4 bytes for date of measurement, 3_x000a_bytes for time of measurement, and 4 bytes for cumulative electric energy (reverse direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char ×3_x000a_+_x000a_unsigned long<br>
		 * Data size : 11<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeReverseDirection() {
			reqGetProperty(EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Cumulative amounts of electric energy measured at fixed time (normal direction)<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the most recent cumulative amount of electric energy (normal direction)_x000a_measured at 30-minute intervals_x000a_held by the meter in the format of_x000a_4 bytes for date of measurement, 3 bytes for time of measurement, and 4 bytes for cumulative electric energy (normal direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char×3_x000a_+_x000a_unsigned long_x000a_<br>
		 * Data size : 11<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Getter reqGetCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeNormalDirection() {
			reqGetProperty(EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_NORMAL_DIRECTION);
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
		 * Property name : Measured cumulative amounts of electric energy (reverse direction)<br>
		 * <br>
		 * EPC : 0xE3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured cumulative amounts of electric energy using an 8-digit decimal notation number. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredCumulativeAmountsOfElectricEnergyReverseDirection() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Unit for cumulative amounts of electric energy (normal and reverse directions)<br>
		 * <br>
		 * EPC : 0xE1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the unit (multiplying factor) used for the measured cumulative amount of electric energy and the historical data of measured cumulative amounts of electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00: 1kWh 0x01: 0.1kWh_x000a_0x02: 0.01kWh_x000a_0x03: 0.001kWh_x000a_0x04: 0.0001kWh 0x0A: 10kWh 0x0B: 100kWh_x000a_0x0C: 1000kWh_x000a_0x0D: 10000kWh<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections() {
			reqInformProperty(EPC_UNIT_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_NORMAL_AND_REVERSE_DIRECTIONS);
			return this;
		}
		/**
		 * Property name : Measured cumulative amount of electric energy (normal direction)<br>
		 * <br>
		 * EPC : 0xE0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured cumulative amount of electric energy using an 8-digit decimal notation number. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredCumulativeAmountOfElectricEnergyNormalDirection() {
			reqInformProperty(EPC_MEASURED_CUMULATIVE_AMOUNT_OF_ELECTRIC_ENERGY_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Measured instantaneous electric energy<br>
		 * <br>
		 * EPC : 0xE7<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured effective instantaneous electric energy in watts. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x80000001.0x7FFFFFFD (-2,147,483,647._x000a_2,147,483,645)<br>
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
		public Informer reqInformMeasuredInstantaneousElectricEnergy() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Day for which the historical data of measured cumulative amounts of electric energy is to be retrieved<br>
		 * <br>
		 * EPC : 0xE5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy (which consists of 48 pieces of half-hourly data for the preceding 24 hours) is to be retrieved. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00.0x63 (0.99)_x000a_0: current day_x000a_1. 99: previous day. day that precedes the current day by 99 days<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformDayForWhichTheHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyIsToBeRetrieved() {
			reqInformProperty(EPC_DAY_FOR_WHICH_THE_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_IS_TO_BE_RETRIEVED);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(reverse direction)<br>
		 * <br>
		 * EPC : 0xE4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short_x000a_+unsigned_x000a_long_x000a_×48<br>
		 * Data size : 194<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000AReverseDirection() {
			reqInformProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Measured instantaneous voltages<br>
		 * <br>
		 * EPC : 0xE9<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured effective instantaneous R-S(N) and S(N)-T voltages in volts. In the case of a_x000a_single-phase, two-wire system,_x000a_0xFFFE shall be used for the S(N)-T voltage. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0xFFFD (between R and S(N)):_x000a_0x0000.0xFFFD (between S(N) and T)_x000a_(0.6,553.3) : (0.6,553.3)<br>
		 * <br>
		 * Data type : unsigned short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1_x000a_V<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredInstantaneousVoltages() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_VOLTAGES);
			return this;
		}
		/**
		 * Property name : Measured instantaneous currents<br>
		 * <br>
		 * EPC : 0xE8<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the measured effective instantaneous R and T phase currents in amperes._x000a_In the case of a single-phase,_x000a_two-wire system, 0x7FFE shall be used for the T phase. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x8001.0x7FFD (R phase)_x000a_: 0x8001.0x7FFD (T phase) (-3,276.7.3,276.5):_x000a_(-3,276.7.3,276.5)<br>
		 * <br>
		 * Data type : signed short_x000a_×2<br>
		 * Data size : 4<br>
		 * Unit : 0.1_x000a_A<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeasuredInstantaneousCurrents() {
			reqInformProperty(EPC_MEASURED_INSTANTANEOUS_CURRENTS);
			return this;
		}
		/**
		 * Property name : Historical data of measured cumulative amounts of electric energy_x000a_(normal direction)<br>
		 * <br>
		 * EPC : 0xE2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the day for which the historical data of measured cumulative amounts of electric energy is to be retrieved and the historical data of measured cumulative amounts of electric energy (up to 8 digits), which consists of 48 pieces of half-hourly data for the preceding 24 hours. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x0000.0x0063:_x000a_0x00000000.0x05F5E0FF (0.99) : (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned short_x000a_+_x000a_unsigned long_x000a_×48<br>
		 * Data size : 194<br>
		 * Unit : kWh<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformHistoricalDataOfMeasuredCumulativeAmountsOfElectricEnergyX000ANormalDirection() {
			reqInformProperty(EPC_HISTORICAL_DATA_OF_MEASURED_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_X000A_NORMAL_DIRECTION);
			return this;
		}
		/**
		 * Property name : Electric energy meter classification<br>
		 * <br>
		 * EPC : 0xD0<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the electric energy meter type. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Electric utility company 0x31: Solar power_x000a_0x32: Fuel cell 0x33: Battery 0x34: EV_x000a_0x35: Others<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformElectricEnergyMeterClassification() {
			reqInformProperty(EPC_ELECTRIC_ENERGY_METER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Owner classification<br>
		 * <br>
		 * EPC : 0xD1<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the type of owner of the meter. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x30: Not specified_x000a_0x31: Electric utility company 0x32: Other than_x000a_electric utility companies 0x33: Individual<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : .<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformOwnerClassification() {
			reqInformProperty(EPC_OWNER_CLASSIFICATION);
			return this;
		}
		/**
		 * Property name : Phases and wires setting status<br>
		 * <br>
		 * EPC : 0xD2<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the phases and wires setting status. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Single-phase, two-wire system: 0x30_x000a_Single-phase, three-wire system: 0x31_x000a_Three-phase, three-wire system: 0x32_x000a_Three-phase, four-wire system: 0x33<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformPhasesAndWiresSettingStatus() {
			reqInformProperty(EPC_PHASES_AND_WIRES_SETTING_STATUS);
			return this;
		}
		/**
		 * Property name : Composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD3<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the composite transformation ratio using a 6-digit decimal notation number. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00000000.0x000F423F (000000.999999)<br>
		 * <br>
		 * Data type : unsigned long<br>
		 * Data size : 4<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformCompositeTransformationRatio() {
			reqInformProperty(EPC_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		/**
		 * Property name : Multiplying factor for composite transformation ratio<br>
		 * <br>
		 * EPC : 0xD4<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the multiplying factor for the composite transformation ratio. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x00 : ×1_x000a_0x01 : ×0.1_x000a_0x02 : ×0.01_x000a_0x03 : ×0.001<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMultiplyingFactorForCompositeTransformationRatio() {
			reqInformProperty(EPC_MULTIPLYING_FACTOR_FOR_COMPOSITE_TRANSFORMATION_RATIO);
			return this;
		}
		/**
		 * Property name : Meter type certification number<br>
		 * <br>
		 * EPC : 0xD5<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the_x000a_type-certified meter number using a string of 10 alphanumeric characters <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * Type-certified meter (type number):<br>
		 * <br>
		 * Data type : unsigned char × 10<br>
		 * Data size : 10<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformMeterTypeCertificationNumber() {
			reqInformProperty(EPC_METER_TYPE_CERTIFICATION_NUMBER);
			return this;
		}
		/**
		 * Property name : Year and month of inspection expiry<br>
		 * <br>
		 * EPC : 0xD6<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the year and month of inspection expiry of the meter by a six-byte ASCII code. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * YYYYMM_x000a_YYYY (Year), MM (Month)<br>
		 * <br>
		 * Data type : unsigned char × 6<br>
		 * Data size : 6<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - optional<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformYearAndMonthOfInspectionExpiry() {
			reqInformProperty(EPC_YEAR_AND_MONTH_OF_INSPECTION_EXPIRY);
			return this;
		}
		/**
		 * Property name : Number of effective digits for cumulative amounts of electric energy<br>
		 * <br>
		 * EPC : 0xD7<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the number of effective digits for measured cumulative amounts of electric energy. <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 0x01.0x08 (1.8)<br>
		 * <br>
		 * Data type : unsigned char<br>
		 * Data size : 1<br>
		 * Unit : digit<br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformNumberOfEffectiveDigitsForCumulativeAmountsOfElectricEnergy() {
			reqInformProperty(EPC_NUMBER_OF_EFFECTIVE_DIGITS_FOR_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY);
			return this;
		}
		/**
		 * Property name : Cumulative amounts of electric energy measured at fixed time (reverse direction)<br>
		 * <br>
		 * EPC : 0xEB<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the most recent cumulative amount of electric energy (reverse direction) measured at 30-minute intervals held by the meter in the format of 4 bytes for date of measurement, 3_x000a_bytes for time of measurement, and 4 bytes for cumulative electric energy (reverse direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char ×3_x000a_+_x000a_unsigned long<br>
		 * Data size : 11<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - optional<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeReverseDirection() {
			reqInformProperty(EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_REVERSE_DIRECTION);
			return this;
		}
		/**
		 * Property name : Cumulative amounts of electric energy measured at fixed time (normal direction)<br>
		 * <br>
		 * EPC : 0xEA<br>
		 * <br>
		 * Contents :<br>
		 * This property indicates the most recent cumulative amount of electric energy (normal direction)_x000a_measured at 30-minute intervals_x000a_held by the meter in the format of_x000a_4 bytes for date of measurement, 3 bytes for time of measurement, and 4 bytes for cumulative electric energy (normal direction)._x000a_date of measurement_x000a_YYYY:MM:DD_x000a_time of measurement hh:mm:ss_x000a_cumulative electric energy: an_x000a_8-digit decimal notation number <br>
		 * <br>
		 * Value range (decimal notation) :<br>
		 * 1.4 bytes: date of measurement YYYY:0x0001.0x270F (1.9999) MM:0x01.0x0C(1.12) DD:0x01.0x1F(1.31)_x000a_5.7 bytes: time of measurement hh:0x00.0x17(0.23) mm:0x00.0x3B(0.59) ss:0x00.0x3B(0.59)_x000a_8.11 bytes: 0x00000000.0x05F5E0FF (0.99,999,999)<br>
		 * <br>
		 * Data type : unsigned char ×4_x000a_+_x000a_unsigned char×3_x000a_+_x000a_unsigned long_x000a_<br>
		 * Data size : 11<br>
		 * Unit : <br>
		 * <br>
		 * Access rule :<br>
		 * Announce - -<br>
		 * Set      - -<br>
		 * Get      - mandatory<br>
		 * <br>
		 * <b>Announcement at status change</b><br>
		 */
		public Informer reqInformCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeNormalDirection() {
			reqInformProperty(EPC_CUMULATIVE_AMOUNTS_OF_ELECTRIC_ENERGY_MEASURED_AT_FIXED_TIME_NORMAL_DIRECTION);
			return this;
		}

	}

	public static class Proxy extends SmartElectricEnergyMeter {
		public Proxy(byte instanceCode) {
			super();
			mEchoInstanceCode = instanceCode;
		}
		@Override
		public byte getInstanceCode() {
			return mEchoInstanceCode;
		}
		@Override
		protected byte[] getGetPropertyMap(){return null;}
		@Override
		protected byte[] getUnitForCumulativeAmountsOfElectricEnergyNormalAndReverseDirections(){return null;}
		@Override
		protected byte[] getMeasuredCumulativeAmountOfElectricEnergyNormalDirection(){return null;}
		@Override
		protected byte[] getSetPropertyMap(){return null;}
		@Override
		protected byte[] getStatusChangeAnnouncementPropertyMap(){return null;}
		@Override
		protected byte[] getManufacturerCode(){return null;}
		@Override
		protected byte[] getOperationStatus(){return null;}
		@Override
		protected boolean setInstallationLocation(byte[] edt){return false;}
		@Override
		protected byte[] getInstallationLocation(){return null;}
		@Override
		protected byte[] getStandardVersionInformation(){return null;}
		@Override
		protected byte[] getFaultStatus(){return null;}
		@Override
		protected byte[] getNumberOfEffectiveDigitsForCumulativeAmountsOfElectricEnergy(){return null;}
		@Override
		protected byte[] getCumulativeAmountsOfElectricEnergyMeasuredAtFixedTimeNormalDirection(){return null;}

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
